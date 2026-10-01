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
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.writer.StoreWriter;
import org.eclipse.collections.api.factory.Lists;

import java.util.List;

/**
 * Records a library as knowledge (IKE-Network/ike-issues#1110, #1112): one concept for the
 * library, one tree semantic per definition about that concept, each definition carrying its
 * name as a description in the CQL dialect, ordered list semantics where order carries meaning,
 * and one reference semantic per thing a definition names. Every identity comes from
 * {@link ElmIdentity}, so writing the same library twice finds the same components. The
 * store-side plumbing, stamps, version-aware writes, descriptions, and retirement, is the
 * {@link StoreWriter}'s.
 */
public final class ElmLibraryWriter {

    private final ElmTreeBuilder builder;
    private final StoreWriter store;

    /**
     * Creates a writer that records under one stamp.
     *
     * @param builder    the tree builder, driven by the catalog
     * @param calculator the view that decides which existing versions count
     * @param stamp      the stamp every new version is written under
     */
    public ElmLibraryWriter(ElmTreeBuilder builder, StampCalculator calculator, Stamp stamp) {
        this.builder = builder;
        this.store = new StoreWriter(calculator, stamp);
    }

    /**
     * What the writer has done so far.
     *
     * @return the counts
     */
    public StoreWriter.Counts counts() {
        return store.counts();
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
     * The store writer beneath this one, for records outside the library's own.
     *
     * @return the store writer
     */
    public StoreWriter store() {
        return store;
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
        int libraryNid = store.concept(libraryPublicId);
        store.describe(libraryNid, UuidT5Generator.get(libraryPublicId.asUuidArray()[0], "fqn"),
                libraryId + " (CQL library)", TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);
        store.describe(libraryNid, UuidT5Generator.get(libraryPublicId.asUuidArray()[0], "name"),
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
        int descriptionNid = store.describe(definitionNid, UuidT5Generator.get(definitionId.asUuidArray()[0], "name"),
                name, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE);
        store.dialect(descriptionNid, UuidT5Generator.get(definitionId.asUuidArray()[0], "cql-dialect"),
                IkeTerms.CQL_DIALECT_PATTERN, TinkarTerm.PREFERRED);
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
        store.semantic(listId, IkeTerms.ELM_ORDERED_LIST_PATTERN, PrimitiveData.nid(definition),
                Lists.immutable.of(itemNids));
        return listId;
    }

    /**
     * Records one thing a definition names, linked to what it means.
     *
     * @param definition  the definition semantic doing the naming
     * @param kindName    the ELM node kind of the naming node, for example {@code ValueSetRef}
     * @param target      the component the name means: a definition semantic, or a unit concept
     * @param name        the name as written
     * @param libraryName the library name as written, empty for the same library
     * @return the reference semantic's public id
     */
    public PublicId reference(PublicId definition, String kindName, PublicId target, String name, String libraryName) {
        PublicId referenceId = ElmIdentity.reference(definition, kindName, libraryName, name);
        EntityProxy.Concept kind = builder.catalog().kind(kindName).concept();
        int targetNid = PrimitiveData.nid(target);
        Object targetFacade = EntityService.get().getEntity(targetNid)
                .filter(entity -> entity instanceof dev.ikm.tinkar.entity.ConceptEntity)
                .map(entity -> (Object) EntityProxy.Concept.make(targetNid))
                .orElse(EntityProxy.Semantic.make(targetNid));
        store.semantic(referenceId, IkeTerms.ELM_REFERENCE_PATTERN, PrimitiveData.nid(definition),
                Lists.immutable.of(kind, targetFacade, name, libraryName));
        return referenceId;
    }

    /**
     * Retires a semantic: appends an inactive version carrying its latest content.
     *
     * @param semanticId the semantic's public id
     * @return true when a version was appended
     */
    public boolean retire(PublicId semanticId) {
        return store.retire(semanticId);
    }

    private int writeTree(PublicId semanticId, int aboutNid, DiTreeEntity tree) {
        return store.semantic(semanticId, IkeTerms.ELM_TREE_PATTERN, aboutNid, Lists.immutable.of(tree));
    }
}
