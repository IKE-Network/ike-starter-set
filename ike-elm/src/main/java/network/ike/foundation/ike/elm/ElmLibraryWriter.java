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

import dev.ikm.tinkar.common.id.IntIds;
import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.id.IntIdList;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.entity.ConceptRecord;
import dev.ikm.tinkar.entity.ConceptRecordBuilder;
import dev.ikm.tinkar.entity.ConceptVersionRecordBuilder;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.PublicIdentifierRecord;
import dev.ikm.tinkar.entity.RecordListBuilder;
import dev.ikm.tinkar.entity.SemanticRecord;
import dev.ikm.tinkar.entity.SemanticRecordBuilder;
import dev.ikm.tinkar.entity.SemanticVersionRecord;
import dev.ikm.tinkar.entity.SemanticVersionRecordBuilder;
import dev.ikm.tinkar.entity.StampRecord;
import dev.ikm.tinkar.entity.StampVersionRecord;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;
import org.eclipse.collections.api.factory.Lists;

import java.util.List;
import java.util.UUID;

/**
 * Records a library as knowledge (IKE-Network/ike-issues#1110): one concept for the library,
 * one tree semantic per definition about that concept, each definition carrying its name as a
 * description in the CQL dialect, ordered list semantics where order carries meaning, and one
 * reference semantic per thing a definition names. Every identity comes from
 * {@link ElmIdentity}, so writing the same library twice finds the same components.
 *
 * <p>The writer records through the entity store directly. The ledger grammar's store-free tree
 * value cannot yet carry a vertex's properties, which an ELM tree needs; when it can, this
 * writer becomes a thin layer over it.
 */
public final class ElmLibraryWriter {

    private final ElmTreeBuilder builder;
    private final int stampNid;

    /**
     * Creates a writer that records under one stamp.
     *
     * @param builder the tree builder, driven by the catalog
     * @param stamp   the stamp every version is written under
     */
    public ElmLibraryWriter(ElmTreeBuilder builder, Stamp stamp) {
        this.builder = builder;
        this.stampNid = writeStamp(stamp);
    }

    /**
     * Records a library: its concept, named by its id, and its identity record, a tree whose
     * root is the ELM Library node holding the versioned identifier as written.
     *
     * @param libraryId the library's id as CQL writes it
     * @param version   the CQL version string, data on the identity record, empty when none
     * @param system    the identifier's system, empty when none
     * @return the library concept's public id
     */
    public PublicId library(String libraryId, String version, String system) {
        PublicId libraryPublicId = ElmIdentity.library(libraryId);
        int libraryNid = PrimitiveData.nid(libraryPublicId);
        RecordListBuilder<dev.ikm.tinkar.entity.ConceptVersionRecord> versions = RecordListBuilder.make();
        ConceptRecord bootstrap = ConceptRecord.makeNew(libraryPublicId, versions);
        versions.add(ConceptVersionRecordBuilder.builder().chronology(bootstrap).stampNid(stampNid).build());
        EntityService.get().putEntity(ConceptRecordBuilder.builder(bootstrap).versions(versions.toImmutable()).build());
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
                              org.eclipse.collections.api.list.ImmutableList<Object> fieldValues) {
        PublicIdentifierRecord identifier = PublicIdentifierRecord.make(semanticId);
        int nid = ScopedValue.where(PrimitiveData.SCOPED_PATTERN_PUBLICID_FOR_NID, pattern.publicId())
                .call(() -> PrimitiveData.nid(semanticId));
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
        return nid;
    }

    private static int writeStamp(Stamp stamp) {
        PublicId stampId = stamp.publicId();
        UUID primordial = stampId.asUuidArray()[0];
        int stampNid = EntityService.get().nidForStamp(stampId);
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
