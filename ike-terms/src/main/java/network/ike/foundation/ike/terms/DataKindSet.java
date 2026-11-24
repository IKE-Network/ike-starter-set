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

import java.util.UUID;

/**
 * Declares the kinds of data a knowledge base holds, named by who else gets the data
 * (IKE-Network/ike-issues#1313; design {@code design-2026-11-22-knowledge-shared-local}, settled by
 * KEC on 2026-11-22): the module parents that decide them, and the document modules written under
 * them before each document had a module of its own.
 *
 * <p><b>Kind by module.</b> A pattern's kind is the kind of the module its first version is
 * written under, read through the taxonomy with inheritance. A module that is a kind of
 * <em>Shared module</em>, at any depth, holds shared data, synced with the knowledge base in change
 * sets of its own. A module that is a kind of <em>Local module</em> holds local data, which never
 * syncs, such as a conversation journal. A <em>File module</em> is a local module whose data is
 * saved in a file outside the knowledge base, such as one document opened from a folder. Every
 * other module holds knowledge. Shared module and Local module are disjoint.
 *
 * <p><b>What the kinds commit to.</b> Data refers only to data shared at least as widely: knowledge
 * never refers to shared or local data, and shared data never refers to local data. Shared and
 * local data are grouped in scopes closed under reference, written to change sets of their own
 * kind, and can be removed. tinkar-core names the three parents in its kernel bindings, so its
 * commit validator reads a module's kind without depending on this set.
 *
 * <p><b>Identities.</b> Local module and File module keep the identities of the Instance module and
 * the Ephemeral module of 2026-10-20, so data already written under them keeps its kind; only their
 * names and definitions changed. A reference to either must follow this set's composition, since a
 * reference to a declared identity resolves only once it is declared.
 *
 * <p>The Conversation journal module ({@link DocumentStructureSet}) and the Change tracking module
 * ({@link ChangeTrackingModelSet}) are kinds of Local module.
 */
final class DataKindSet {

    /** The parent of every module of local data, which never syncs with the knowledge base. */
    static final String LOCAL_MODULE = fqn("Local module");

    /** The parent of every module of local data saved in a file outside the knowledge base. */
    static final String FILE_MODULE = fqn("File module");

    /** The parent of every module of shared data, synced with the knowledge base in change sets of its own. */
    static final String SHARED_MODULE = fqn("Shared module");

    /** The identity Local module keeps from the Instance module of 2026-10-20. */
    private static final UUID LOCAL_MODULE_UUID = UUID.fromString("e6b26869-7335-5d29-9346-1b44d8423fbf");

    /** The identity File module keeps from the Ephemeral module of 2026-10-20. */
    private static final UUID FILE_MODULE_UUID = UUID.fromString("a0c10c95-fdd1-5a2a-83c5-4b34c1f019fb");

    private static final EntityProxy.Concept MODULE_SOLOR =
            EntityProxy.Concept.make("Module (SOLOR)", PublicIds.of("40d1c869-b509-32f8-b735-836eac577a67"));

    private DataKindSet() {
    }

    /**
     * Composes this section's declarations into the session. Composed before every set that
     * refers to Local module or File module, because both have declared identities.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;
        ConceptFacade shared = set.conceptRef(SHARED_MODULE);

        set.concept(LOCAL_MODULE, PublicIds.of(LOCAL_MODULE_UUID)).at(inception)
                .synonym("Local module")
                .definition("A module whose data never syncs with the knowledge base, such as a conversation"
                        + " journal or the records of how the knowledge base changed. A module that is a kind"
                        + " of this one, at any depth, is a local module. Its data is written to change sets"
                        + " of its own, one file per module, and is never published with the knowledge base."
                        + " Knowledge and shared data never refer to it.")
                .statedAxioms(leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(MODULE_SOLOR),
                        leb.DisjointWithAxiom(shared))));
        ConceptFacade local = set.conceptRef(LOCAL_MODULE);

        set.concept(FILE_MODULE, PublicIds.of(FILE_MODULE_UUID)).at(inception)
                .synonym("File module")
                .definition("A local module whose data is saved in a file outside the knowledge base, such"
                        + " as the module of one document opened from a folder. A module that is a kind of"
                        + " this one, at any depth, is a file module. Komet removes its data when the"
                        + " knowledge base next opens, unless an edit is not yet saved to the file, and"
                        + " reads it from the file again when the document is next opened.")
                .isA(local);
        ConceptFacade file = set.conceptRef(FILE_MODULE);

        set.concept(SHARED_MODULE).at(inception)
                .synonym("Shared module")
                .definition("A module whose data is synced with the knowledge base but kept apart from its"
                        + " knowledge, such as a set of documents a team works on together. A module that is"
                        + " a kind of this one, at any depth, is a shared module. Its data is written to"
                        + " change sets of its own, one file per module, so a document can be deleted or"
                        + " made local without touching the knowledge. Knowledge never refers to it, and it"
                        + " never refers to local data.")
                .statedAxioms(leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(MODULE_SOLOR),
                        leb.DisjointWithAxiom(local))));

        set.concept(fqn("Git document module")).at(inception)
                .synonym("Git document module")
                .definition("A file module that documents opened from git were written under before each"
                        + " document had a module of its own. No new document is written under it.")
                .isA(file);

        set.concept(fqn("Authored document module")).at(inception)
                .synonym("Authored document module")
                .definition("A local module that documents written in Komet were written under before each"
                        + " document had a module of its own. No new document is written under it.")
                .isA(local);
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }
}
