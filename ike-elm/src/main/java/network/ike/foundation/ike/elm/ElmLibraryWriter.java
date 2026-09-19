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
package network.ike.foundation.ike.elm;

import dev.ikm.tinkar.common.id.IntIdList;
import dev.ikm.tinkar.common.id.IntIds;
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
import dev.ikm.tinkar.terms.ConceptFacade;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Records a library as knowledge (IKE-Network/ike-issues#1110, #1112): one concept for the
 * library, one tree semantic per definition about that concept, each definition carrying its
 * name as a description in the CQL dialect, ordered list semantics where order carries meaning,
 * and one reference semantic per thing a definition names. Every identity comes from
 * {@link ElmIdentity}, so writing the same library twice finds the same components.
 *
 * <p>Writing is version-aware: before a semantic is written its latest version on the view is
 * read; identical content writes nothing, different content appends a version under the
 * writer's stamp, and a definition that has gone from the text is retired with an inactive
 * version, never deleted.
 *
 * <p>The writer records through the entity store directly. The ledger grammar's store-free
 * tree value cannot yet carry a vertex's properties, which an ELM tree needs; when it can, this
 * writer becomes a thin layer over it.
 */
public final class ElmLibraryWriter {

    /** What the writer did, counted since it was created. */
    public static final class Counts {
        private int written;
        private int unchanged;
        private int versioned;
        private int retired;

        /**
         * Semantics created for the first time.
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

    private final ElmTreeBuilder builder;
    private final StampCalculator calculator;
    private final int stampNid;
    private final int inactiveStampNid;
    private final Counts counts = new Counts();

    /**
     * Creates a writer that records under one stamp.
     *
     * @param builder    the tree builder, driven by the catalog
     * @param calculator the view that decides which existing versions count
     * @param stamp      the stamp every new version is written under
     */
    public ElmLibraryWriter(ElmTreeBuilder builder, StampCalculator calculator, Stamp stamp) {
        this.builder = builder;
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
     * The builder this writer records with.
     *
     * @return the builder
     */
    public ElmTreeBuilder builder() {
        return builder;
    }

    /**
     * Records a library: its concept, named by its id, and its identity record, a tree whose
     * root is the ELM Library node holding the versioned identifier as written and the ELM
     * schema identifier every library names.
     *
     * @param libraryId the library's id as CQL writes it
     * @param version   the CQL version string, data on the identity record, empty when none
     * @param system    the identifier's system, empty when none
     * @return the library concept's public id
     */
    public PublicId library(String libraryId, String version, String system) {
        PublicId libraryPublicId = ElmIdentity.library(libraryId);
        int libraryNid = PrimitiveData.nid(libraryPublicId);
        if (EntityService.get().getEntity(libraryNid).isEmpty()) {
            RecordListBuilder<ConceptVersionRecord> versions = RecordListBuilder.make();
            ConceptRecord bootstrap = ConceptRecord.makeNew(libraryPublicId, versions);
            versions.add(ConceptVersionRecordBuilder.builder().chronology(bootstrap).stampNid(stampNid).build());
            EntityService.get().putEntity(ConceptRecordBuilder.builder(bootstrap).versions(versions.toImmutable()).build());
            counts.written++;
        }
        describe(libraryNid, UuidT5Generator.get(libraryPublicId.asUuidArray()[0], "fqn"),
                libraryId + " (CQL library)", TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);
        describe(libraryNid, UuidT5Generator.get(libraryPublicId.asUuidArray()[0], "name"),
                libraryId, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE);

        ElmNode identifier = builder.node("VersionedIdentifier").property("id", libraryId);
        if (!version.isEmpty()) {
            identifier.property("version", version);
        }
        if (!system.isEmpty()) {
            identifier.property("system", system);
        }
        // Every ELM library names the ELM schema it is written to, as the translator does.
        ElmNode schema = builder.node("VersionedIdentifier").property("id", "urn:hl7-org:elm").property("version", "r1");
        ElmNode record = builder.node("Library").edge("identifier", identifier).edge("schemaIdentifier", schema);
        PublicId recordId = ElmIdentity.libraryRecord(libraryId);
        writeTree(recordId, libraryNid, builder.build(record, recordId));
        return libraryPublicId;
    }

    /**
     * Records one definition of a library: a tree semantic about the library concept, carrying
     * the definition's name as a description in the CQL dialect.
     *
     * @param libraryId    the library's id
     * @param root         the definition's root node, an ELM definition kind such as ExpressionDef
     * @param name         the definition's name as written
     * @param operandTypes the operand type names of a function definition, in order, empty otherwise
     * @return the definition semantic's public id
     */
    public PublicId definition(String libraryId, ElmNode root, String name, List<String> operandTypes) {
        PublicId definitionId = ElmIdentity.definition(libraryId, root.kind().name(), name, operandTypes);
        int libraryNid = PrimitiveData.nid(ElmIdentity.library(libraryId));
        int definitionNid = writeTree(definitionId, libraryNid, builder.build(root, definitionId));
        int descriptionNid = describe(definitionNid, UuidT5Generator.get(definitionId.asUuidArray()[0], "name"),
                name, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE);
        writeSemantic(PublicIds.of(UuidT5Generator.get(definitionId.asUuidArray()[0], "cql-dialect")),
                IkeTerms.CQL_DIALECT_PATTERN, descriptionNid, Lists.immutable.of(TinkarTerm.PREFERRED));
        return definitionId;
    }

    /**
     * Records an unnamed list item: a tree semantic about the library, identified by what it
     * contains.
     *
     * @param libraryId the library's id
     * @param root      the item's root node
     * @param content   the item's canonical text, the seed of its identity
     * @return the item semantic's public id
     */
    public PublicId item(String libraryId, ElmNode root, String content) {
        PublicId itemId = ElmIdentity.item(libraryId, content);
        int libraryNid = PrimitiveData.nid(ElmIdentity.library(libraryId));
        writeTree(itemId, libraryNid, builder.build(root, itemId));
        return itemId;
    }

    /**
     * Records an ordered list: the items a list position holds, in order, about the definition
     * whose tree points at it.
     *
     * @param definition   the definition semantic's public id
     * @param positionPath the path of positions from the definition's root to the list
     * @param items        the item semantics' public ids, in order
     * @return the list semantic's public id
     */
    public PublicId orderedList(PublicId definition, String positionPath, List<PublicId> items) {
        PublicId listId = ElmIdentity.list(definition, positionPath);
        int[] nids = new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            nids[i] = PrimitiveData.nid(items.get(i));
        }
        IntIdList itemNids = IntIds.list.of(nids);
        writeSemantic(listId, IkeTerms.ELM_ORDERED_LIST_PATTERN, PrimitiveData.nid(definition),
                Lists.immutable.of(itemNids));
        return listId;
    }

    /**
     * Records one thing a definition names, linked to the definition it means.
     *
     * @param definition  the definition semantic doing the naming
     * @param kindName    the ELM node kind of the reference, for example {@code ValueSetRef}
     * @param target      the definition semantic the name means
     * @param name        the name as written
     * @param libraryName the library name as written, empty for the same library
     * @return the reference semantic's public id
     */
    public PublicId reference(PublicId definition, String kindName, PublicId target, String name, String libraryName) {
        PublicId referenceId = ElmIdentity.reference(definition, kindName, libraryName, name);
        EntityProxy.Concept kind = builder.catalog().kind(kindName).concept();
        writeSemantic(referenceId, IkeTerms.ELM_REFERENCE_PATTERN, PrimitiveData.nid(definition),
                Lists.immutable.of(kind, EntityProxy.Semantic.make(PrimitiveData.nid(target)), name, libraryName));
        return referenceId;
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

    private int writeTree(PublicId semanticId, int aboutNid, DiTreeEntity tree) {
        return writeSemantic(semanticId, IkeTerms.ELM_TREE_PATTERN, aboutNid, Lists.immutable.of(tree));
    }

    private int describe(int aboutNid, UUID descriptionUuid, String text, EntityProxy.Concept type) {
        int descriptionNid = writeSemantic(PublicIds.of(descriptionUuid), TinkarTerm.DESCRIPTION_PATTERN, aboutNid,
                Lists.immutable.of(TinkarTerm.ENGLISH_LANGUAGE, text, TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, type));
        writeSemantic(PublicIds.of(UuidT5Generator.get(descriptionUuid, "us-dialect")), TinkarTerm.US_DIALECT_PATTERN,
                descriptionNid, Lists.immutable.of(TinkarTerm.PREFERRED));
        return descriptionNid;
    }

    private int writeSemantic(PublicId semanticId, EntityProxy.Pattern pattern, int referencedComponentNid,
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
     * Whether two field lists say the same thing: trees by structure, meaning, and properties;
     * components by nid; lists of nids in order; everything else by equality.
     */
    static boolean sameFields(ImmutableList<Object> a, ImmutableList<Object> b) {
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
        // Children carry no order, so each child of one tree must have a match among the other's.
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

    /**
     * The concept a plain value names, for a bound enumeration constant or a concept facade.
     *
     * @param value the value
     * @return the concept, or empty when the value is not a concept
     */
    static Optional<ConceptFacade> conceptOf(Object value) {
        return value instanceof ConceptFacade concept ? Optional.of(concept) : Optional.empty();
    }
}
