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

import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.ConceptFacade;
import dev.ikm.tinkar.terms.KernelConcept;

/**
 * Declares who is responsible for the work of an author (IKE-Network/ike-issues#1399). An assistant
 * is an author of its own, apart from the person who directs it, and an identity a person used earlier
 * is an author of its own too. One semantic of the {@code Responsible person pattern} on such an
 * author's concept names the person, and why. A reader of a document can then find who is responsible
 * for a line by KEC Claude. KEC settled the pattern and the wording on 2026-11-23.
 *
 * <p><b>The pattern.</b> Its meaning is {@code Author responsibility} and its purpose {@code Author
 * attribution}. It has two fields: {@code Responsible person}, the person's own author concept, and
 * {@code Responsibility reason}, which is {@code Directed assistant} or {@code Earlier identity}. An
 * author has at most one, under the identity made from the pattern and the author, so every machine
 * writes the same semantic. The relation of an assistant and its person is the delegation of W3C PROV
 * ({@code prov:actedOnBehalfOf}); {@code Earlier identity} is not a kind of delegation.
 *
 * <p><b>Beneath Git provenance model.</b> The authors the pattern is for are made from the email of a
 * git identity ({@code Git author}, {@link AsciiDocModelSet}), so the concepts are beneath that model.
 *
 * <p><b>The fully qualified names are frozen</b> once a checkpoint carries them: every concept and
 * pattern takes the set's derived identity, {@code T5(d890e06f…, "<name> (IkeFoundation)")}.
 */
final class AuthorResponsibilitySet {

    private AuthorResponsibilitySet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        concept(set, inception, "Author responsibility", "Git provenance model",
                "A relation between an author and a person, where the person is responsible for the"
                        + " author's work. Keith E Campbell is responsible for the work of KEC Claude, the"
                        + " assistant he directs. This is the meaning of the pattern.");
        concept(set, inception, "Author attribution", "Git provenance model",
                "The purpose of finding who is responsible for a change. A person reviewing a document"
                        + " sees a line by KEC Claude and finds that Keith E Campbell is responsible for"
                        + " it. This is the purpose of the pattern and of both of its fields.");
        concept(set, inception, "Responsible person", "Git provenance model",
                "The person who is responsible for the work of an author, recorded as that person's own"
                        + " author concept. For KEC Claude it is Keith E Campbell.");
        concept(set, inception, "Responsibility reason", "Git provenance model",
                "A reason that a person is responsible for the work of an author. A person may direct"
                        + " the author, as Keith E Campbell directs KEC Claude. Or the author may be an"
                        + " identity that the person used earlier.");
        concept(set, inception, "Directed assistant", "Responsibility reason",
                "A responsibility reason where the author is an assistant and the person directs it. KEC"
                        + " Claude is an assistant that Keith E Campbell directs.");
        concept(set, inception, "Earlier identity", "Responsibility reason",
                "A responsibility reason where the person and any assistants of that person used the"
                        + " author before each had an identity. Keith E Campbell and Claude both committed"
                        + " under one address before 2026-11-21, so a commit under it does not distinguish"
                        + " them.");

        ConceptFacade attribution = set.conceptRef(fqn("Author attribution"));
        set.pattern(fqn("Responsible person pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Author responsibility")))
                .purpose(attribution)
                .field(set.conceptRef(fqn("Responsible person")), attribution, KernelConcept.CONCEPT_FIELD)
                .field(set.conceptRef(fqn("Responsibility reason")), attribution, KernelConcept.CONCEPT_FIELD)
                .synonym("Responsible person pattern")
                .definition("On an author concept: the person responsible for the author's work, and the"
                        + " reason.");
    }

    private static String fqn(String name) {
        return name + " (IkeFoundation)";
    }

    private static void concept(KnowledgeSet set, ActiveStamp stamp, String name, String parent, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(fqn(parent)));
    }
}
