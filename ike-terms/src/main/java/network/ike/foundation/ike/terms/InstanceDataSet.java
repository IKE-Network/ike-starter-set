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
package network.ike.foundation.ike.terms;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.ConceptFacade;
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * Declares the kinds of data a store holds besides knowledge (IKE-Network/ike-issues#1313; design
 * {@code design-2026-10-20-instance-data}): the two module parents that decide them, and the
 * modules documents are written under.
 *
 * <p><b>Kind by module.</b> A pattern's kind is the kind of the module its first version is
 * written under, read through the taxonomy with inheritance: a module that is a kind of
 * <em>Ephemeral module</em>, at any depth, holds ephemeral data, data whose record is elsewhere and
 * which can be rebuilt from it, such as a document persisted in git; a module that is a kind of
 * <em>Instance module</em> holds instance data, whose only record is the store, such as a
 * conversation journal or a document not in git. Every other module holds knowledge. The two
 * parents are disjoint, and a module's kind is fixed once anything is written under it.
 *
 * <p><b>What the kinds commit to.</b> Knowledge is shared, append-only and governed, and never
 * references ephemeral or instance data. Ephemeral and instance data are grouped in scopes closed
 * under reference, written to change sets of their own kind, and can be deleted. tinkar-core
 * names the two parents in its kernel bindings, so its commit validator reads a module's kind
 * without depending on this set.
 *
 * <p>The Conversation journal module ({@link DocumentStructureSet}) and the Change tracking module
 * ({@link ChangeTrackingModelSet}) are kinds of Instance module.
 */
final class InstanceDataSet {

    /** The parent of every module whose data can be rebuilt from a record elsewhere. */
    static final String EPHEMERAL_MODULE = fqn("Ephemeral module");

    /** The parent of every module whose data has no record but the store. */
    static final String INSTANCE_MODULE = fqn("Instance module");

    private static final EntityProxy.Concept MODULE_SOLOR =
            EntityProxy.Concept.make("Module (SOLOR)", PublicIds.of("40d1c869-b509-32f8-b735-836eac577a67"));

    private InstanceDataSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;
        ConceptFacade ephemeral = set.conceptRef(EPHEMERAL_MODULE);
        ConceptFacade instance = set.conceptRef(INSTANCE_MODULE);

        set.concept(EPHEMERAL_MODULE).at(inception)
                .synonym("Ephemeral module")
                .definition("A module whose data has its record elsewhere and can be rebuilt from it, as"
                        + " a document persisted in git is materialized from its repository. A module that"
                        + " is a kind of this one, at any depth, is ephemeral. Its data is written to"
                        + " ephemeral change sets named for the module, replays what happened since its"
                        + " record last held it, and can be dropped at any time; knowledge never references"
                        + " it.")
                .statedAxioms(leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(MODULE_SOLOR),
                        leb.DisjointWithAxiom(instance))));

        set.concept(INSTANCE_MODULE).at(inception)
                .synonym("Instance module")
                .definition("A module whose data has no record but the store: a conversation journal, a"
                        + " document not persisted in git, the record a transaction keeps. A module that is"
                        + " a kind of this one, at any depth, is an instance module. Its data is written to"
                        + " instance change sets, never published with knowledge, and can be deleted as a"
                        + " unit; knowledge never references it.")
                .statedAxioms(leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(MODULE_SOLOR),
                        leb.DisjointWithAxiom(ephemeral))));

        set.concept(fqn("Git document module")).at(inception)
                .synonym("Git document module")
                .definition("The module a document materialized from a git repository is written under"
                        + " when no module of its own working tree is chosen: ephemeral, since the"
                        + " repository is its record.")
                .isA(ephemeral);

        set.concept(fqn("Authored document module")).at(inception)
                .synonym("Authored document module")
                .definition("The module a document authored in Komet is written under until it is"
                        + " committed to a repository: an instance module, since until then the store is"
                        + " its only record.")
                .isA(instance);
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }
}
