/*
 * Copyright © 2026 IKE Network (support@ike.network)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package network.ike.foundation.ike.writer;

import dev.ikm.tinkar.common.id.IntIdList;
import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.ConceptRecord;
import dev.ikm.tinkar.entity.ConceptRecordBuilder;
import dev.ikm.tinkar.entity.ConceptVersionRecord;
import dev.ikm.tinkar.entity.ConceptVersionRecordBuilder;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.PublicIdentifierRecord;
import dev.ikm.tinkar.entity.RecordListBuilder;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.SemanticRecord;
import dev.ikm.tinkar.entity.SemanticRecordBuilder;
import dev.ikm.tinkar.entity.SemanticVersionRecord;
import dev.ikm.tinkar.entity.SemanticVersionRecordBuilder;
import dev.ikm.tinkar.entity.StampRecord;
import dev.ikm.tinkar.entity.StampVersionRecord;
import dev.ikm.tinkar.entity.builder.InactiveStamp;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.entity.graph.adaptor.axiom.LogicalExpressionBuilder;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Writes knowledge into the running store from code, the way the ledger does at replay: one
 * stamp for everything written, concepts with their stated parents, semantics that are
 * version-aware, descriptions with their dialects, and retirement. Every identity is the
 * caller's, derived and never random, so writing the same thing twice finds the same
 * component (IKE-Network/ike-issues#1112, #1114).
 *
 * <p>Writing is version-aware: before a semantic is written its latest version on the view is
 * read; identical content writes nothing, different content appends a version under the
 * writer's stamp, and retirement appends an inactive version, never deleting. The store keeps
 * one version per stamp, so each import that should leave its own mark carries its own stamp.
 */
public final class StoreWriter {

    /** What the writer did, counted since it was created. */
    public static final class Counts {
        private int written;
        private int unchanged;
        private int versioned;
        private int retired;

        /**
         * Components created for the first time.
         *
         * @return the count
         */
        public int written() {
            return written;
        }

        /**
         * Semantics found with identical content, left untouched.
         *
         * @return the count
         */
        public int unchanged() {
            return unchanged;
        }

        /**
         * Semantics found with different content, given a new version.
         *
         * @return the count
         */
        public int versioned() {
            return versioned;
        }

        /**
         * Semantics retired with an inactive version.
         *
         * @return the count
         */
        public int retired() {
            return retired;
        }
    }

    private final StampCalculator calculator;
    private final int stampNid;
    private final int inactiveStampNid;
    private final Counts counts = new Counts();

    /**
     * Creates a writer that records under one stamp.
     *
     * @param calculator the view that decides which existing versions count
     * @param stamp      the stamp every new version is written under
     */
    public StoreWriter(StampCalculator calculator, Stamp stamp) {
        this.calculator = calculator;
        this.stampNid = writeStamp(stamp);
        this.inactiveStampNid = writeStamp(new InactiveStamp(stamp.time(), stamp.author(), stamp.module(), stamp.path()));
    }

    /**
     * What the writer has done so far.
     *
     * @return the counts
     */
    public Counts counts() {
        return counts;
    }

    /**
     * The view this writer reads existing versions under.
     *
     * @return the calculator
     */
    public StampCalculator calculator() {
        return calculator;
    }

    /**
     * Writes a concept if the store has none under that identity; a concept has no content
     * of its own, so an existing one is left alone.
     *
     * @param conceptId the concept's public id
     * @return the concept's nid
     */
    public int concept(PublicId conceptId) {
        int nid = PrimitiveData.nid(conceptId);
        if (EntityService.get().getEntity(nid).isEmpty()) {
            RecordListBuilder<ConceptVersionRecord> versions = RecordListBuilder.make();
            ConceptRecord bootstrap = ConceptRecord.makeNew(conceptId, versions);
            versions.add(ConceptVersionRecordBuilder.builder().chronology(bootstrap).stampNid(stampNid).build());
            EntityService.get().putEntity(ConceptRecordBuilder.builder(bootstrap).versions(versions.toImmutable()).build());
            counts.written++;
        }
        return nid;
    }

    /**
     * States a concept's parent: its stated-axiom semantic says it is necessarily a kind of
     * the parent, and nothing more. Written version-aware like any semantic.
     *
     * @param conceptId the concept
     * @param parentId  the parent concept
     * @return the axiom semantic's nid
     */
    public int statedParent(PublicId conceptId, PublicId parentId) {
        UUID conceptUuid = conceptId.asUuidArray()[0];
        PublicId axiomId = PublicIds.of(UuidT5Generator.get(conceptUuid, "stated axioms"));
        int[] ordinal = {0};
        LogicalExpressionBuilder builder = new LogicalExpressionBuilder(
                UuidT5Generator.get(conceptUuid, "definition root"),
                () -> UuidT5Generator.get(conceptUuid, "axiom vertex " + ordinal[0]++));
        builder.NecessarySet(builder.And(builder.ConceptAxiom(EntityProxy.Concept.make(PrimitiveData.nid(parentId)))));
        DiTreeEntity tree = (DiTreeEntity) builder.build().sourceGraph();
        return semantic(axiomId, TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN, PrimitiveData.nid(conceptId),
                Lists.immutable.of(tree));
    }

    /**
     * Writes a semantic, version-aware: nothing when the latest version says the same,
     * a new version when it differs, a new semantic when none exists.
     *
     * @param semanticId             the semantic's public id
     * @param pattern                its pattern
     * @param referencedComponentNid the component it is about
     * @param fieldValues            its field values, in the pattern's order
     * @return the semantic's nid
     */
    public int semantic(PublicId semanticId, EntityProxy.Pattern pattern, int referencedComponentNid,
                        ImmutableList<Object> fieldValues) {
        PublicIdentifierRecord identifier = PublicIdentifierRecord.make(semanticId);
        int nid = ScopedValue.where(PrimitiveData.SCOPED_PATTERN_PUBLICID_FOR_NID, pattern.publicId())
                .call(() -> PrimitiveData.nid(semanticId));
        Optional<SemanticRecord> existing = EntityService.get().getEntity(nid);
        if (existing.isPresent()) {
            Latest<SemanticEntityVersion> latest = calculator.latest(nid);
            if (latest.isPresent() && latest.get().stampNid() != inactiveStampNid
                    && sameFields(latest.get().fieldValues(), fieldValues)) {
                counts.unchanged++;
                return nid;
            }
            SemanticRecord record = existing.get();
            SemanticVersionRecord version = SemanticVersionRecordBuilder.builder()
                    .chronology(record)
                    .stampNid(stampNid)
                    .fieldValues(fieldValues)
                    .build();
            EntityService.get().putEntity(SemanticRecordBuilder.builder(record)
                    .versions(record.versions().newWith(version)).build());
            counts.versioned++;
            return nid;
        }
        RecordListBuilder<SemanticVersionRecord> versions = RecordListBuilder.make();
        SemanticRecord bootstrap = SemanticRecordBuilder.builder()
                .mostSignificantBits(identifier.mostSignificantBits())
                .leastSignificantBits(identifier.leastSignificantBits())
                .additionalUuidLongs(identifier.additionalUuidLongs())
                .nid(nid)
                .patternNid(pattern.nid())
                .referencedComponentNid(referencedComponentNid)
                .versions(versions)
                .build();
        versions.add(SemanticVersionRecordBuilder.builder()
                .chronology(bootstrap)
                .stampNid(stampNid)
                .fieldValues(fieldValues)
                .build());
        EntityService.get().putEntity(SemanticRecordBuilder.builder(bootstrap).versions(versions.toImmutable()).build());
        counts.written++;
        return nid;
    }

    /**
     * Writes a description of a component in English, not case sensitive, with its US dialect
     * acceptability set to preferred.
     *
     * @param aboutNid        the component described
     * @param descriptionUuid the description's identity
     * @param text            the text
     * @param type            the description type, a fully qualified name or a regular name
     * @return the description semantic's nid
     */
    public int describe(int aboutNid, UUID descriptionUuid, String text, EntityProxy.Concept type) {
        return describe(aboutNid, descriptionUuid, text, type, TinkarTerm.PREFERRED);
    }

    /**
     * Writes a description of a component in English, not case sensitive, with its US dialect
     * acceptability as given.
     *
     * @param aboutNid        the component described
     * @param descriptionUuid the description's identity
     * @param text            the text
     * @param type            the description type, a fully qualified name, a regular name, or a definition
     * @param usAcceptability preferred or acceptable in the US dialect
     * @return the description semantic's nid
     */
    public int describe(int aboutNid, UUID descriptionUuid, String text, EntityProxy.Concept type,
                        EntityProxy.Concept usAcceptability) {
        int descriptionNid = semantic(PublicIds.of(descriptionUuid), TinkarTerm.DESCRIPTION_PATTERN, aboutNid,
                Lists.immutable.of(TinkarTerm.ENGLISH_LANGUAGE, text, TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, type));
        dialect(descriptionNid, UuidT5Generator.get(descriptionUuid, "us-dialect"), TinkarTerm.US_DIALECT_PATTERN,
                usAcceptability);
        return descriptionNid;
    }

    /**
     * Records a description's acceptability in a dialect.
     *
     * @param descriptionNid the description
     * @param dialectUuid    the dialect semantic's identity
     * @param dialectPattern the dialect's pattern, one field: acceptability
     * @param acceptability  preferred or acceptable
     * @return the dialect semantic's nid
     */
    public int dialect(int descriptionNid, UUID dialectUuid, EntityProxy.Pattern dialectPattern,
                       EntityProxy.Concept acceptability) {
        return semantic(PublicIds.of(dialectUuid), dialectPattern, descriptionNid, Lists.immutable.of(acceptability));
    }

    /**
     * Retires a semantic: appends an inactive version carrying its latest content. A semantic
     * already inactive on the view, or absent, is left alone.
     *
     * @param semanticId the semantic's public id
     * @return true when a version was appended
     */
    public boolean retire(PublicId semanticId) {
        if (!PrimitiveData.get().hasPublicId(semanticId)) {
            return false;
        }
        int nid = PrimitiveData.nid(semanticId);
        Optional<SemanticRecord> existing = EntityService.get().getEntity(nid);
        Latest<SemanticEntityVersion> latest = calculator.latest(nid);
        if (existing.isEmpty() || latest.isAbsent()) {
            return false;
        }
        SemanticRecord record = existing.get();
        SemanticVersionRecord version = SemanticVersionRecordBuilder.builder()
                .chronology(record)
                .stampNid(inactiveStampNid)
                .fieldValues(latest.get().fieldValues())
                .build();
        EntityService.get().putEntity(SemanticRecordBuilder.builder(record)
                .versions(record.versions().newWith(version)).build());
        counts.retired++;
        return true;
    }

    /**
     * Whether two field lists say the same thing: trees by structure, meaning, and properties
     * with no regard to child order; components by nid; lists of nids in order; everything
     * else by equality.
     *
     * @param a one list
     * @param b the other
     * @return true when they agree
     */
    public static boolean sameFields(ImmutableList<Object> a, ImmutableList<Object> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!sameValue(a.get(i), b.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean sameValue(Object a, Object b) {
        if (a instanceof DiTreeEntity treeA && b instanceof DiTreeEntity treeB) {
            return sameTree(treeA, treeA.root(), treeB, treeB.root());
        }
        if (a instanceof EntityFacade facadeA && b instanceof EntityFacade facadeB) {
            return facadeA.nid() == facadeB.nid();
        }
        if (a instanceof IntIdList listA && b instanceof IntIdList listB) {
            return listA.equals(listB);
        }
        return Objects.equals(a, b);
    }

    private static boolean sameTree(DiTreeEntity treeA, EntityVertex a, DiTreeEntity treeB, EntityVertex b) {
        if (a.getMeaningNid() != b.getMeaningNid() || a.properties().size() != b.properties().size()) {
            return false;
        }
        for (int key : a.properties().keySet().toArray()) {
            if (!b.properties().containsKey(key) || !sameValue(a.properties().get(key), b.properties().get(key))) {
                return false;
            }
        }
        ImmutableIntList childrenA = treeA.successors(a.vertexIndex());
        ImmutableIntList childrenB = treeB.successors(b.vertexIndex());
        if (childrenA.size() != childrenB.size()) {
            return false;
        }
        boolean[] matched = new boolean[childrenB.size()];
        for (int i = 0; i < childrenA.size(); i++) {
            boolean found = false;
            for (int j = 0; j < childrenB.size() && !found; j++) {
                if (!matched[j] && sameTree(treeA, treeA.vertex(childrenA.get(i)), treeB, treeB.vertex(childrenB.get(j)))) {
                    matched[j] = true;
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    private static int writeStamp(Stamp stamp) {
        PublicId stampId = stamp.publicId();
        int stampNid = EntityService.get().nidForStamp(stampId);
        if (EntityService.get().getEntity(stampNid).isPresent()) {
            return stampNid;
        }
        UUID primordial = stampId.asUuidArray()[0];
        RecordListBuilder<StampVersionRecord> versionRecords = RecordListBuilder.make();
        StampRecord stampEntity = new StampRecord(primordial.getMostSignificantBits(),
                primordial.getLeastSignificantBits(), stampId.additionalUuidLongs(), stampNid, versionRecords);
        versionRecords.add(new StampVersionRecord(stampEntity, stamp.state().nid(), stamp.time(),
                stamp.author().nid(), stamp.module().nid(), stamp.path().nid()));
        versionRecords.build();
        EntityService.get().putEntity(stampEntity);
        return stampNid;
    }
}
