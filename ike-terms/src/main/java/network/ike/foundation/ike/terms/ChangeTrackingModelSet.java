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
import dev.ikm.tinkar.terms.KernelConcept;

/**
 * Declares how a knowledge base records its transactions (IKE-Network/ike-issues#1308;
 * ike-lab-documents topic {@code dev-concurrent-work}), beside the records of what it is made of
 * in {@link SourceReleaseModelSet}.
 *
 * <p><b>Change transaction.</b> A transaction that writes uncommitted versions is recorded as one
 * {@code Change transaction pattern} semantic, referencing the {@code Change tracking module},
 * whose identity is the transaction's own UUID; every version is stamped by the transaction's
 * author. Its versions are the transaction's log:
 * written when it opens, when its basis moves, when the store is saved while it is open, and when
 * it is committed or cancelled. Its uncommitted stamps are not listed: each derives from the
 * transaction's UUID, so a reference to a stamp a change set may not carry is never written. Each version is written under a committed stamp of its own in the
 * {@code Change tracking module}, never under the transaction's uncommitted stamps, so a
 * cancelled transaction leaves its record. Bulk loads write none.
 *
 * <p><b>Basis.</b> The point in the store a transaction's changes were made against: a time on a
 * path, and, for a document materialized from git, the commit the edit started from. Two versions
 * of one component are concurrent when neither change's basis includes the other.
 *
 * <p><b>The fully qualified names are frozen</b> once a checkpoint carries them: tinkar-core's
 * {@code Transaction} names the pattern, its states and the module through the kernel bindings,
 * and writes the fields in the order declared here.
 */
final class ChangeTrackingModelSet {


    /** The change transaction pattern's birth name; its identity derives from it. */
    static final String CHANGE_TRANSACTION_PATTERN = "Change transaction pattern (IkeFoundation)";

    private ChangeTrackingModelSet() {
    }

    /**
     * Composes this section's declarations into the session, after {@link SourceReleaseModelSet},
     * whose provenance model it extends.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;
        String model = "Knowledge base provenance model";

        concept(set, inception, "Change tracking", model,
                "Recording each transaction that changes a knowledge base, inside the knowledge base:"
                        + " what it was made against, what it wrote, and how it ended, so pending work"
                        + " survives a restart and a change can be judged concurrent with another: the"
                        + " purpose of the change transaction pattern and its fields.");
        set.concept(fqn("Change tracking module")).at(inception)
                .synonym("Change tracking module")
                .definition("The module transaction records are written to: bookkeeping about how the"
                        + " knowledge base changed, not knowledge. It is an instance module: its records"
                        + " are the store's own, written to the instance change sets and never published"
                        + " with knowledge (IKE-Network/ike-issues#1313).")
                .isA(set.conceptRef(InstanceDataSet.INSTANCE_MODULE), set.conceptRef(fqn(model)));

        concept(set, inception, "Change transaction", model,
                "One transaction of changes to a knowledge base by one author: its name, its basis, what"
                        + " it has written while open, and whether it is open, committed or cancelled. Its record's"
                        + " versions are the transaction's log; the first says when it began.");
        concept(set, inception, "Transaction name", model,
                "The name the transaction was made with, which says what it is for.");
        concept(set, inception, "Transaction state", model,
                "Whether the transaction is still open, or how it ended.");
        concept(set, inception, "Transaction open", "Transaction state",
                "The transaction may still write; what it wrote is uncommitted.");
        concept(set, inception, "Transaction committed", "Transaction state",
                "The transaction ended by committing what it wrote.");
        concept(set, inception, "Transaction cancelled", "Transaction state",
                "The transaction ended by cancelling what it wrote; its versions are withdrawn, its"
                        + " record remains.");
        concept(set, inception, "Change basis", model,
                "The time of the point in the store the transaction's changes were made against: what"
                        + " its author could see. It moves forward when the transaction takes in later"
                        + " changes, as a rebase onto a newer commit does.");
        concept(set, inception, "Change basis path", model,
                "The path of the point in the store the transaction's changes were made against.");
        concept(set, inception, "External change basis", model,
                "What the changes were made against outside the knowledge base, such as the git commit"
                        + " a document edit started from; empty when there is none.");
        concept(set, inception, "Transaction components", model,
                "The components the transaction has written, as of the record's version, while it is"
                        + " open: complete once the store has been saved. A version saying how the"
                        + " transaction ended lists none; what it wrote is on its stamps.");

        ConceptFacade purpose = set.conceptRef(fqn("Change tracking"));
        set.pattern(CHANGE_TRANSACTION_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Change transaction")))
                .purpose(purpose)
                .field(set.conceptRef(fqn("Transaction name")), purpose, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Transaction state")), purpose, KernelConcept.CONCEPT_FIELD)
                .field(set.conceptRef(fqn("Change basis")), purpose, KernelConcept.INSTANT_LITERAL)
                .field(set.conceptRef(fqn("Change basis path")), purpose, KernelConcept.CONCEPT_FIELD)
                .field(set.conceptRef(fqn("External change basis")), purpose, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Transaction components")), purpose, KernelConcept.COMPONENT_ID_SET_FIELD)
                .synonym("Change transaction pattern")
                .definition("A transaction that wrote uncommitted versions, referencing the change tracking"
                        + " module, with the transaction's UUID as its identity and its author on every"
                        + " version's stamp: its name, its state, its basis (time,"
                        + " path, and any external basis such as a git commit), and, while it is open,"
                        + " the components it has written. Its uncommitted stamps are not listed: each"
                        + " derives from the transaction's UUID. Written in the change tracking module"
                        + " under committed stamps of its own, one version per lifecycle event.");
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }

    private static void concept(KnowledgeSet set, ActiveStamp stamp, String name, String parent, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(fqn(parent)));
    }
}
