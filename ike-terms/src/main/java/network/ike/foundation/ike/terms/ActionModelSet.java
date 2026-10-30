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
 * the first, as the smallest family the rules engine offers; editing a document block is the
 * first action with an input beyond its subject.
 *
 * <p><b>The action definition.</b> An {@code Action definition pattern} semantic on each action
 * concept names the pattern its input takes, the pattern its result takes, and the instructions
 * a model needs when it performs the action. A tool's schema comes from the input pattern, its
 * description from the concept's definition and those instructions.
 *
 * <p><b>Inputs and results.</b> Each run's input is a semantic of the action's input pattern whose
 * referenced component is the action's subject; its result is a semantic of the result pattern
 * whose referenced component is that input. An action that takes only its subject uses the
 * {@code Component action input pattern}, and one with parameters has an input pattern of its own
 * ({@code Document block edit input pattern}); one that writes a version reports it in a
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

        concept(set, inception, "Replacement text", "Action model",
                "The text a run puts in place of its subject's: for a document block, the block's new"
                        + " lines, one per line.");
        concept(set, inception, "Complex concept name", "Action model",
                "The name a run gives the complex concept it creates, written as the concept's fully"
                        + " qualified name and its regular name.");

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

        set.pattern(fqn("Document block edit input pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Action input")))
                .purpose(record)
                .field(set.conceptRef(fqn("Performed action")), record, KernelConcept.CONCEPT_FIELD)
                .field(set.conceptRef(fqn("Replacement text")), record, KernelConcept.STRING)
                .synonym("Document block edit input pattern")
                .definition("The input of an action that replaces the text of a document block, the"
                        + " referenced component, which is the block's element semantic: the kind of"
                        + " action performed on it and the block's new text.");

        set.pattern(fqn("ANF statement tree input pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Action input")))
                .purpose(record)
                .field(set.conceptRef(fqn("Performed action")), record, KernelConcept.CONCEPT_FIELD)
                .field(set.conceptRef(fqn("ANF statement tree")), record, KernelConcept.DITREE_FIELD)
                .synonym("ANF statement tree input pattern")
                .definition("The input of an action that writes the tree of an ANF statement: the kind of"
                        + " action performed and the statement's tree. Its referenced component is the"
                        + " statement to edit, or the document block a new statement is added to.");

        set.pattern(fqn("Complex concept promotion input pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Action input")))
                .purpose(record)
                .field(set.conceptRef(fqn("Performed action")), record, KernelConcept.CONCEPT_FIELD)
                .field(set.conceptRef(fqn("Complex concept name")), record, KernelConcept.STRING)
                .synonym("Complex concept promotion input pattern")
                .definition("The input of an action that promotes an ANF statement's composed topic to a"
                        + " complex concept: the kind of action performed on the statement, the referenced"
                        + " component, and the name of the complex concept it creates.");

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
        changeAction(set, inception, "Edit document block", "Document block edit input pattern",
                "Replaces the text of one block of a document materialized from git, a block whose"
                        + " members are lines: an unchanged line keeps its element, a changed line gets a"
                        + " new version of it, a new line gets a provisional element until a commit gives"
                        + " it an identity, and a removed line leaves the block. The edit lands as"
                        + " uncommitted versions in the document's one pending edit, and the person's git"
                        + " commit of the file settles it.",
                "Edit only a block the person has asked to change, and only its text, one line per line;"
                        + " a block keeps at least one line. A block that holds other blocks is not edited"
                        + " as text: edit the blocks it holds. Refuse when an edit of the document by"
                        + " someone else is pending. Report what changed; the edit stays uncommitted until"
                        + " the person commits the document in git.");
        changeAction(set, inception, "Add ANF statement", "ANF statement tree input pattern",
                "Adds an ANF statement to a document block: writes a new semantic of the ANF statement"
                        + " pattern, under the edit coordinate, whose referenced component is the block and"
                        + " whose tree is the given one. The tree must be a well-formed statement: every"
                        + " vertex an ANF meaning, every child one its parent admits, and every attribute's"
                        + " own rules kept. A statement may still lack attributes; it is completed by"
                        + " editing it.",
                "Add a statement only to a block the person has asked you to add it to, and only one"
                        + " the person's text or request supports. Refuse when the subject is not a document"
                        + " block or the tree is not a well-formed statement, saying which rule it breaks."
                        + " Report the version written and the new statement's identifier; the person"
                        + " commits it.");
        changeAction(set, inception, "Edit ANF statement", "ANF statement tree input pattern",
                "Replaces the tree of one ANF statement with a new tree: writes a new version of the"
                        + " statement's semantic, under the edit coordinate, whose tree is the new one. The"
                        + " new tree must be a well-formed statement, as for adding one. A second edit by the"
                        + " same person replaces their pending version rather than stacking on it.",
                "Edit only a statement the person has asked to change. Keep the identity of every"
                        + " vertex you do not change, so its history follows it. Refuse when the new tree"
                        + " is not a well-formed statement, saying which rule it breaks, and when an edit"
                        + " of the statement by someone else is pending. Report the version written; the"
                        + " person commits it.");
        changeAction(set, inception, "Promote to complex concept", "Complex concept promotion input pattern",
                "Promotes an ANF statement's composed topic to a complex concept, as one uncommitted"
                        + " change: writes a new concept in the Complex concepts module with the given name,"
                        + " its complex concept specification with the composition as its definition and a"
                        + " focused expansion on the composition's parent concept to be finished in the"
                        + " complex concept editor, and a new version of the statement whose topic is the"
                        + " new concept. Instance data keeps a concept, never a composed expression.",
                "Promote only a topic the person has asked to promote, and name the complex concept as"
                        + " the person would. Refuse when the topic is already a single concept, when it"
                        + " names no parent concept, and when an edit of the statement is pending, since the"
                        + " promotion is one change. Report the new concept; the person finishes its"
                        + " expansion and commits it.");
        changeAction(set, inception, "Edit document sentence", "Document block edit input pattern",
                "Replaces the text of one sentence of a document materialized from git as semantic"
                        + " vertices (IKE-Network/ike-issues#1313): the sentence goes on a line of its own, a"
                        + " part of it on one line whose words survive keeps that line, and only changed text"
                        + " is broken anew, after a clause or a comma. The block's lines are then edited as"
                        + " Edit document block edits them, and the sentence gets a new version under its own"
                        + " identity. The input's subject is the sentence; its text is the replacement.",
                "Edit only a sentence the person has asked to change, and give its whole new text. Refuse"
                        + " a text that would change the document's structure, such as a line that would open"
                        + " a list or a section, and refuse when an edit of the document by someone else is"
                        + " pending. Report what changed; the edit stays uncommitted until the person commits"
                        + " the document in git.");
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
        changeAction(set, stamp, name, "Component action input pattern", definition, modelInstructions);
    }

    /** A change action whose input takes the named pattern and that reports the version it wrote. */
    private static void changeAction(KnowledgeSet set, ActiveStamp stamp, String name, String inputPattern,
                                     String definition, String modelInstructions) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(fqn("Change action")))
                .semantic(set.patternRef(fqn("Action definition pattern")),
                        PublicIds.of(set.uuidFor("Action definition: " + name)),
                        set.patternRef(fqn(inputPattern)),
                        set.patternRef(fqn("Version change result pattern")),
                        modelInstructions);
    }
}
