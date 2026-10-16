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
 * Declares what classification concludes beyond the taxonomy's edges: the concepts a
 * classified concept is logically equivalent to. The inferred navigation pattern records
 * parents and children only, and equivalent concepts share both, so without this pattern a
 * classification's equivalences were held in memory and lost when it finished.
 * <p>
 * The pattern reuses the foundation's concepts rather than minting its own, in the navigation
 * patterns' shape: its meaning is {@code Logically equivalent to}, the operator the reasoner
 * determines equivalence with, as theirs is {@code Is-a}; its one field's meaning is
 * {@code Relationship destination}, as their parents field's is; and its purpose is the
 * {@code Taxonomy Navigation Cache} they share — a pre-computed classification result, so
 * traversal need not re-derive it from the axioms.
 */
final class ClassificationModelSet {

    private static final EntityProxy.Concept LOGICALLY_EQUIVALENT_TO =
            EntityProxy.Concept.make("Logically equivalent to (Solor)", PublicIds.of("3642d9a3-8e23-5289-836b-366c0b1e2900"));

    /** The equivalence pattern's birth name; its identity derives from it. */
    static final String INFERRED_EQUIVALENCE_PATTERN = "Inferred equivalence pattern (IkeFoundation)";

    private ClassificationModelSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        ConceptFacade purpose = set.conceptRef("Taxonomy Navigation Cache (IkeFoundation)");
        set.pattern(INFERRED_EQUIVALENCE_PATTERN).at(inception)
                .meaning(LOGICALLY_EQUIVALENT_TO)
                .purpose(purpose)
                .field(KernelConcept.RELATIONSHIP_DESTINATION, purpose, KernelConcept.COMPONENT_ID_SET_FIELD)
                .synonym("Inferred equivalence pattern")
                .definition("The concepts classification found the referenced concept logically"
                        + " equivalent to, never including the concept itself. Written beside the"
                        + " inferred navigation semantic only for a concept with equivalents; when a"
                        + " later classification finds none, the set is empty.");
    }
}
