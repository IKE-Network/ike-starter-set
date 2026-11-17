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
import dev.ikm.tinkar.terms.EntityProxy;

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
 * <p><b>Not declared here yet.</b> The {@code Rule source pattern}, the pattern of the text of one
 * rule set, has its name and no fields: its fields are for the work on rules written in Komet to
 * settle, and the pattern is declared with them. Which rules a rule set has is recorded there too.
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
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }
}
