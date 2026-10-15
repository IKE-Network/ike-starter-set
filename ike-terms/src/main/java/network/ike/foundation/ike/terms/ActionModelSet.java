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
 * Declares Komet's actions as concepts (ike-lab-documents topic {@code dev-komet-actions}): one
 * shape for what the rules engine offers in a menu and what the assistant calls as a tool, so
 * each kind of action is a concept that Java names through the generated bindings.
 *
 * <p><b>The action branch.</b> {@code Komet action} is the parent, with children by what an
 * action does: read, change, check, navigate. A kind of action is a concept beneath one of them,
 * defined for the clinicians and knowledge architects who use it. Activate and inactivate are
 * the first, as the smallest family the rules engine offers.
 *
 * <p><b>The action definition.</b> An {@code Action definition pattern} semantic on each action
 * concept names the pattern its input takes, the pattern its result takes, and the instructions
 * a model needs when it performs the action. A tool's schema comes from the input pattern, its
 * description from the concept's definition and those instructions.
 *
 * <p><b>Inputs and results.</b> Each run's input is a semantic of the action's input pattern whose
 * referenced component is the action's subject; its result is a semantic of the result pattern
 * whose referenced component is that input. An action that takes only its subject uses the
 * {@code Component action input pattern}; one that writes a version reports it in a
 * {@code Version change result pattern}. A failure is a result, never an exception: the outcome
 * says whether the action completed, was refused (nothing written), or failed.
 *
 * <p><b>The fully qualified names are frozen</b> once a checkpoint carries them: every concept and
 * pattern takes the set's derived identity, {@code T5(d890e06f…, "<name> (IkeFoundation)")}, and
 * recorded runs refer to them. Rename a synonym freely; never an FQN.
 */
final class ActionModelSet {

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    private ActionModelSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        set.concept(fqn("Action model")).at(inception)
                .synonym("Action model")
                .definition("The apparatus that describes what a person or the assistant can do in Komet:"
                        + " the kinds of action, the patterns their inputs and results take, and the"
                        + " definition that ties an action to them.")
                .isA(IKE_BASE_MODEL_CONCEPT);

        // ── The action definition ────────────────────────────────────────────
        concept(set, inception, "Action definition", "Action model",
                "The definition of one kind of action: the patterns its input and result take and how a"
                        + " model should perform it.");
        concept(set, inception, "Action performance", "Action model",
                "Performing a kind of action the same way wherever it is offered — a menu, the"
                        + " assistant, the headless runner: the purpose of the Action definition pattern"
                        + " and its fields.");
        concept(set, inception, "Input pattern", "Action model",
                "The pattern each run's input takes. Its fields are what the action needs besides its"
                        + " subject; a menu gathers them from the person, the assistant fills them as a tool's"
                        + " arguments, and both face the same allowed values.");
        concept(set, inception, "Result pattern", "Action model",
                "The pattern each run's result takes: what the action produced, and whether it completed.");
        concept(set, inception, "Model instructions", "Action model",
                "What a model must know when it performs the action, beyond the action's definition:"
                        + " what to check first, what never to do, how to report.");

        // ── Inputs ───────────────────────────────────────────────────────────
        concept(set, inception, "Action record", "Action model",
                "Recording what was done, to what, by whom and with what outcome, so a run can be"
                        + " audited, replayed or forked: the purpose of the input and result patterns and"
                        + " their fields.");
        concept(set, inception, "Action input", "Action model",
                "One run of an action, as asked for: a semantic of the action's input pattern whose"
                        + " referenced component is the action's subject — a component, a document or"
                        + " journal block, or a node in a logical definition. Its STAMP records who ran it"
                        + " and when; replaying the run performs the action again on this input.");
        concept(set, inception, "Performed action", "Action model",
                "The kind of action a run performed: a concept beneath Komet action.");

        // ── Results ──────────────────────────────────────────────────────────
        concept(set, inception, "Action result", "Action model",
                "What one run of an action produced: a semantic of the action's result pattern whose"
                        + " referenced component is the run's input.");
        concept(set, inception, "Action outcome", "Action model",
                "Whether a run of an action did what it was asked. A failure is an outcome, reported in"
                        + " the result, never an error raised past it.");
        concept(set, inception, "Action completed", "Action outcome",
                "The run did what it was asked, and its result says what it wrote or found.");
        concept(set, inception, "Action refused", "Action outcome",
                "The run did not start, because its subject or inputs did not allow it — a component"
                        + " already inactive, a value outside the allowed ones. Nothing was written.");
        concept(set, inception, "Action failed", "Action outcome",
                "The run started and could not finish. Nothing it began was committed.");
        concept(set, inception, "Written version", "Action model",
                "The STAMP of the version a run wrote; with the run's subject it names that version.");
        concept(set, inception, "Outcome message", "Action model",
                "Text for the person or the model about the outcome: why the run was refused or"
                        + " failed, or what to look at next. Empty when there is nothing to add.");

        // ── Patterns ─────────────────────────────────────────────────────────
        ConceptFacade definitionPurpose = set.conceptRef(fqn("Action performance"));
        set.pattern(fqn("Action definition pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Action definition")))
                .purpose(definitionPurpose)
                .field(set.conceptRef(fqn("Input pattern")), definitionPurpose, KernelConcept.COMPONENT_FIELD)
                .field(set.conceptRef(fqn("Result pattern")), definitionPurpose, KernelConcept.COMPONENT_FIELD)
                .field(set.conceptRef(fqn("Model instructions")), definitionPurpose, KernelConcept.STRING)
                .synonym("Action definition pattern")
                .definition("The definition of the action concept it references: the pattern each run's"
                        + " input takes, the pattern its result takes, and the instructions a model needs"
                        + " when it performs the action.");

        ConceptFacade record = set.conceptRef(fqn("Action record"));
        set.pattern(fqn("Component action input pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Action input")))
                .purpose(record)
                .field(set.conceptRef(fqn("Performed action")), record, KernelConcept.CONCEPT_FIELD)
                .synonym("Component action input pattern")
                .definition("The input of an action that takes nothing but its subject, the referenced"
                        + " component: the kind of action performed on it.");

        set.pattern(fqn("Version change result pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Action result")))
                .purpose(record)
                .field(set.conceptRef(fqn("Action outcome")), record, KernelConcept.CONCEPT_FIELD)
                .field(set.conceptRef(fqn("Written version")), record, KernelConcept.COMPONENT_FIELD)
                .field(set.conceptRef(fqn("Outcome message")), record, KernelConcept.STRING)
                .synonym("Version change result pattern")
                .definition("The result of an action that writes a new version of its subject, referencing"
                        + " the run's input: the outcome, the STAMP of the version written (the outcome"
                        + " concept itself when nothing was written), and a message.");

        // ── The action branch ────────────────────────────────────────────────
        concept(set, inception, "Komet action", "Action model",
                "Something a person or the assistant does to the knowledge base through Komet, with a"
                        + " defined input and result: offered in a menu by the rules that decide when it"
                        + " makes sense, and offered to the assistant as a tool under the same rules.");
        concept(set, inception, "Read action", "Komet action",
                "An action that reports on the knowledge base and changes nothing in it.");
        concept(set, inception, "Change action", "Komet action",
                "An action that writes: a new component, or a new version of one. What it writes lands"
                        + " under the edit coordinate, and is uncommitted until the person commits it.");
        concept(set, inception, "Check action", "Komet action",
                "An action that judges content against a rule or a method and reports findings, writing"
                        + " nothing but its result.");
        concept(set, inception, "Navigate action", "Komet action",
                "An action that changes what a person sees — focus, window, layout — and nothing in the"
                        + " knowledge base.");

        changeAction(set, inception, "Activate component",
                "Makes an inactive component active again: writes a new version of the subject with"
                        + " state active and every field as the latest version has it. Earlier versions,"
                        + " including the inactive one, remain.",
                "Activate only a component the person has asked to restore. Refuse when the subject is"
                        + " already active. Report the version written; the person commits it.");
        changeAction(set, inception, "Inactivate component",
                "Retires a component: writes a new version of the subject with state inactive and every"
                        + " field as the latest version has it. Nothing is deleted; earlier versions remain,"
                        + " and the component can be activated again.",
                "Inactivate only a component the person has asked to retire; disagreement with content is"
                        + " a refutation, not an inactivation. Refuse when the subject is already inactive."
                        + " Report the version written; the person commits it.");
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

    /** A change action that takes only its subject and reports the version it wrote. */
    private static void changeAction(KnowledgeSet set, ActiveStamp stamp, String name, String definition,
                                     String modelInstructions) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(fqn("Change action")))
                .semantic(set.patternRef(fqn("Action definition pattern")),
                        PublicIds.of(set.uuidFor("Action definition: " + name)),
                        set.patternRef(fqn("Component action input pattern")),
                        set.patternRef(fqn("Version change result pattern")),
                        modelInstructions);
    }
}
