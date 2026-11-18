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
 * Declares the names every rule needs (ike-lab-documents topics {@code dev-rules-as-knowledge} and
 * {@code dev-guided-workflow}): a rule is a concept, and so is the set it is written in. KEC
 * accepted these names on 2026-11-17, for the rules of the guided workflow
 * (IKE-Network/ike-issues#1390) and for rules written in Komet (IKE-Network/ike-issues#1391).
 *
 * <p><b>The parents.</b> {@code Komet rule} is the parent of every rule and {@code Komet rule set}
 * the parent of every rule set, under {@code Rule model}. The name is {@code Komet rule} and not
 * {@code Rule}, as an action is a {@code Komet action}: the set already has {@code Constraint Rule}
 * and {@code Match Rule}, which are about the fields of a pattern.
 *
 * <p><b>The text of a rule set.</b> The {@code Rule source pattern} is the pattern of the text of
 * one rule set. One semantic of it is on each rule set concept, and its versions are the versions
 * of the text. Its meaning is {@code Rule source} and its purpose {@code Rule execution}. It has
 * three fields: {@code Rule set text}, the text as it was written, in Java; {@code Declared
 * rules}, the rules the text declares, each a kind of {@code Komet rule}; and {@code Rules API
 * version}, the version of Komet's rules API the text was written for. It has no field for in use
 * or removed: the status of the version says that. KEC accepted these parts on 2026-11-17
 * (IKE-Network/ike-issues#1391).
 *
 * <p><b>The fully qualified names are frozen</b> once a checkpoint carries them: every concept
 * takes the set's derived identity, {@code T5(d890e06f…, "<name> (IkeFoundation)")}.
 */
final class RuleModelSet {

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    private RuleModelSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        set.concept(fqn("Rule model")).at(inception)
                .synonym("Rule model")
                .definition("The concepts and patterns that describe the rules Komet runs. They are a"
                        + " rule, the set it is written in, and the text of a set.")
                .isA(IKE_BASE_MODEL_CONCEPT);
        set.concept(fqn("Komet rule")).at(inception)
                .synonym("Komet rule")
                .definition("A condition that Komet checks against the facts it is given, with what Komet"
                        + " does when the condition is met. \"A workflow step waits for each step it"
                        + " needs that is not done\" is one.")
                .isA(set.conceptRef(fqn("Rule model")));
        set.concept(fqn("Komet rule set")).at(inception)
                .synonym("Komet rule set")
                .definition("Rules that are written as one text and are put in use together. The rules"
                        + " for the state of a workflow step are one set.")
                .isA(set.conceptRef(fqn("Rule model")));

        // ── The text of a rule set ───────────────────────────────────────────
        set.concept(fqn("Rule source")).at(inception)
                .synonym("Rule source")
                .definition("The text of a rule set, in the form Komet compiles. It is the meaning of the"
                        + " rule source pattern.")
                .isA(set.conceptRef(fqn("Rule model")));
        set.concept(fqn("Rule execution")).at(inception)
                .synonym("Rule execution")
                .definition("Compiling the text of a rule set and running its rules. It is the purpose of"
                        + " the rule source pattern and of its fields.")
                .isA(set.conceptRef(fqn("Rule model")));
        set.concept(fqn("Rule set text")).at(inception)
                .synonym("Rule set text")
                .definition("The text of a rule set as it was written, in Java.")
                .isA(set.conceptRef(fqn("Rule model")));
        set.concept(fqn("Declared rules")).at(inception)
                .synonym("Declared rules")
                .definition("The rules the text of a rule set declares, each a kind of Komet rule.")
                .isA(set.conceptRef(fqn("Rule model")));
        set.concept(fqn("Rules API version")).at(inception)
                .synonym("Rules API version")
                .definition("The version of Komet's rules API the text of a rule set was written for.")
                .isA(set.conceptRef(fqn("Rule model")));

        ConceptFacade execution = set.conceptRef(fqn("Rule execution"));
        set.pattern(fqn("Rule source pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Rule source")))
                .purpose(execution)
                .field(set.conceptRef(fqn("Rule set text")), execution, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Declared rules")), execution, KernelConcept.COMPONENT_ID_SET_FIELD)
                .field(set.conceptRef(fqn("Rules API version")), execution, KernelConcept.STRING)
                .synonym("Rule source pattern")
                .definition("The text of the rule set it references: the text as it was written, the"
                        + " rules the text declares, and the version of Komet's rules API it was"
                        + " written for.");
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }
}
