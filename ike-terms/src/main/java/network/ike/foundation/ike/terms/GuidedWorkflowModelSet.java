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

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.ConceptFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelConcept;

/**
 * Declares the guided workflow as concepts (ike-lab-documents topic {@code dev-guided-workflow},
 * "The workflow, its steps and its rules as concepts"; IKE-Network/ike-issues#1390): a named
 * list of steps for one kind of work, which Komet shows on a card beside the document the steps
 * write. The names and definitions are the ones KEC accepted on 2026-11-17.
 *
 * <p><b>The model.</b> {@code Guided workflow} is the parent of every workflow and
 * {@code Workflow step} the parent of every step. Who performs a step is given by the kind of
 * step it is: a {@code Tool step}, a {@code Language model step} or a {@code Person step}.
 *
 * <p><b>The two definitions.</b> A {@code Workflow definition pattern} semantic on a workflow
 * lists its steps in the order the card shows them and names the rule set that gives their
 * states. A {@code Step definition pattern} semantic on a step gives the steps whose results it
 * needs and the rule sets it runs. The order in which steps can be done comes from those needs,
 * never from the list.
 *
 * <p><b>The first workflow.</b> The intake of a 510(k) submission from its eSTAR export, and its
 * nine steps. A step's fully qualified name stands alone, and its regular name is the shorter
 * name the workflow card shows.
 *
 * <p><b>The rules.</b> The two rule sets of the guided workflow and their seven rules are
 * concepts beneath {@code Komet rule set} and {@code Komet rule} ({@link RuleModelSet}). A rule
 * is named by the sentence of what it does. Which rules a rule set has, and the text of a set,
 * are recorded as semantics of the {@code Rule source pattern} ({@link RuleModelSet}) once the
 * work on rules written in Komet (IKE-Network/ike-issues#1391) writes them; until then the text
 * is the plugin's.
 *
 * <p><b>The fully qualified names are frozen</b> once a checkpoint carries them: every concept and
 * pattern takes the set's derived identity, {@code T5(d890e06f…, "<name> (IkeFoundation)")}.
 * Rename a synonym freely; never an FQN.
 */
final class GuidedWorkflowModelSet {

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    /** The intake workflow's fully qualified name, without the set's suffix. */
    private static final String INTAKE = "Intake of a 510(k) submission from its eSTAR export";

    private static final String CHOOSE_EXPORT = "Choose the eSTAR export of a submission";
    private static final String READ_EXPORT = "Read the eSTAR export as a document";
    private static final String FIND_CONCEPTS = "Find the concepts the words of a document may name";
    private static final String SORT_PLACES = "Sort the places where concepts were found";
    private static final String ASK_MODEL = "Ask the language model about places with several candidates";
    private static final String JUDGE_PLACES = "Judge the places left for a person";
    private static final String ADD_CONCEPTS = "Add the concepts the knowledge base lacks";
    private static final String WRITE_RECORDS = "Write the records of a submission";
    private static final String WRITE_TEMPLATE = "Write the consult template of a submission";

    private static final String STEP_STATE_RULES = "Rules for the state of a workflow step";
    private static final String PLACE_SORTING_RULES = "Rules for sorting the places where concepts were found";

    private GuidedWorkflowModelSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        set.concept(fqn("Guided workflow model")).at(inception)
                .synonym("Guided workflow model")
                .definition("The concepts and patterns that describe a guided workflow. They are a"
                        + " workflow, its steps, what each step needs, and the rules it uses.")
                .isA(IKE_BASE_MODEL_CONCEPT);

        // ── The workflow and the kinds of step ───────────────────────────────
        concept(set, inception, "Guided workflow", "Guided workflow model",
                "A named list of steps for one kind of work. Komet shows the steps on a card and"
                        + " performs the ones a program can perform. The intake of a 510(k) submission"
                        + " from its eSTAR export is one.");
        concept(set, inception, "Workflow step", "Guided workflow model",
                "One piece of the work of a guided workflow, with a result that can be checked."
                        + " Reading an eSTAR export into a document is one.");
        concept(set, inception, "Tool step", "Workflow step",
                "A workflow step that a program in Komet performs, with no decision by a person."
                        + " Reading an eSTAR export into a document is one.");
        concept(set, inception, "Language model step", "Workflow step",
                "A workflow step in which Komet asks a language model one question with a fixed list"
                        + " of answers. One such step asks which of four candidate concepts the words"
                        + " \"Matrix protein (M) gene\" name.");
        concept(set, inception, "Person step", "Workflow step",
                "A workflow step in which a person decides, and Komet shows her what to decide."
                        + " Judging whether the word \"solution\" names a substance or a dose form is"
                        + " one.");

        // ── The two definitions ──────────────────────────────────────────────
        concept(set, inception, "Workflow definition", "Guided workflow model",
                "What sets one guided workflow apart from another. It is the workflow's steps and the"
                        + " rules that give their states.");
        concept(set, inception, "Step definition", "Guided workflow model",
                "What a workflow step needs before it can be done, and the rules it runs.");
        concept(set, inception, "Workflow guidance", "Guided workflow model",
                "Leading every run of one kind of work through the same steps. It is the purpose of"
                        + " the two definition patterns and of their fields.");
        concept(set, inception, "Workflow steps", "Guided workflow model",
                "The steps of a guided workflow, in the order the card lists them. The order in which"
                        + " the steps can be done comes from what each step needs.");
        concept(set, inception, "Workflow state rules", "Guided workflow model",
                "The rule set that gives each step of a workflow its state, such as Ready, Done or Out"
                        + " of date.");
        concept(set, inception, "Needed steps", "Guided workflow model",
                "The steps whose results a workflow step uses. The step can be done when each of them"
                        + " is done.");
        concept(set, inception, "Step rules", "Guided workflow model",
                "The rule sets a workflow step runs on what it works on. The step that sorts the places"
                        + " where concepts were found runs one.");

        ConceptFacade guidance = set.conceptRef(fqn("Workflow guidance"));
        set.pattern(fqn("Workflow definition pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Workflow definition")))
                .purpose(guidance)
                .field(set.conceptRef(fqn("Workflow steps")), guidance, KernelConcept.COMPONENT_ID_LIST_FIELD)
                .field(set.conceptRef(fqn("Workflow state rules")), guidance, KernelConcept.COMPONENT_FIELD)
                .synonym("Workflow definition pattern")
                .definition("The definition of the guided workflow it references: the workflow's"
                        + " steps, in the order the card lists them, and the rule set that gives each"
                        + " step its state.");
        set.pattern(fqn("Step definition pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Step definition")))
                .purpose(guidance)
                .field(set.conceptRef(fqn("Needed steps")), guidance, KernelConcept.COMPONENT_ID_SET_FIELD)
                .field(set.conceptRef(fqn("Step rules")), guidance, KernelConcept.COMPONENT_ID_SET_FIELD)
                .synonym("Step definition pattern")
                .definition("The definition of the workflow step it references: the steps whose"
                        + " results the step needs, and the rule sets it runs. The first set is empty"
                        + " for a step that needs nothing, and the second for a step that runs no rules.");

        // ── The rule sets and the rules ──────────────────────────────────────
        ruleSet(set, inception, STEP_STATE_RULES, "Step state rules",
                "A rule set that gives each step of a run its state. Komet runs it each time something"
                        + " in the run changes.");
        rule(set, inception, "A workflow step waits for each step it needs that is not done",
                "A Komet rule that marks a workflow step as waiting while a step it needs is not done."
                        + " The records wait for the judgments.");
        rule(set, inception, "A workflow step is out of date when a result it used was written again",
                "A Komet rule that marks a workflow step out of date when a result it used has a newer"
                        + " version. The records are out of date after a judgment is changed.");
        rule(set, inception, "A workflow step is out of date when a step it needs is out of date",
                "A Komet rule that marks a workflow step out of date when a step it needs is out of"
                        + " date. The consult template is out of date when the records are.");
        ruleSet(set, inception, PLACE_SORTING_RULES, "Place sorting rules",
                "A rule set that puts each place where a concept was found in a group. The step that"
                        + " sorts what was found runs it.");
        rule(set, inception, "A place of a single letter is set aside",
                "A Komet rule that sets aside a place whose words are one letter, such as \"A\".");
        rule(set, inception, "A place inside a longer place is set aside",
                "A Komet rule that sets aside a place whose words are part of a longer place. The word"
                        + " \"virus\" is set aside when \"influenza A virus\" is found at the same place.");
        rule(set, inception, "A place of one word that names only qualifier values or attributes is set aside",
                "A Komet rule that sets aside a place of one word when every concept the word may name"
                        + " is a qualifier value or an attribute. The word \"each\" is an example.");
        rule(set, inception, "A place with more than one candidate is left for the language model",
                "A Komet rule that leaves a place for the language model when its words may name more"
                        + " than one concept. The word \"solution\" may name a substance or a dose form.");

        // ── The first workflow: intake of a 510(k) from its eSTAR export ─────
        step(set, inception, CHOOSE_EXPORT, "Choose the export", "Person step",
                "A person step in which a person chooses the file with one submission's answers."
                        + " Its result is which file, which form and which version of the form.");
        step(set, inception, READ_EXPORT, "Read the export as a document", "Tool step",
                "A tool step that reads the chosen export into a document. The document is the"
                        + " submission as submitted, with every answer under its question.",
                CHOOSE_EXPORT);
        step(set, inception, FIND_CONCEPTS, "Find the concepts the words may name", "Tool step",
                "A tool step that searches the knowledge base for the concepts the words of a"
                        + " document may name. Its result is the places in the words, each with its"
                        + " candidate concepts.",
                READ_EXPORT);
        step(set, inception, SORT_PLACES, "Sort what was found", "Tool step",
                "A tool step that puts each place in one of four groups by rules. The groups are set"
                        + " aside, accepted, for the model and for a person.",
                FIND_CONCEPTS);
        step(set, inception, ASK_MODEL, "Ask the model about what is left open", "Language model step",
                "A language model step that asks, for each phrase with more than one candidate, which"
                        + " candidate the words name in their sentences. One of the answers is that"
                        + " they name none. The choice is shown to the person as a suggestion.",
                SORT_PLACES);
        // The model's choices help the person and are not something her judgment needs, so this
        // step needs the sorting and not the step that asks the model.
        step(set, inception, JUDGE_PLACES, "Judge what is left", "Person step",
                "A person step in which a person judges each phrase the sorting left for her. She"
                        + " also adds the places the search missed.",
                SORT_PLACES);
        step(set, inception, ADD_CONCEPTS, "Add the concepts the knowledge base lacks", "Person step",
                "A person step in which a person names the concepts that the judged words need and"
                        + " the knowledge base lacks. Komet adds them, such as a lens polymer or a"
                        + " lineage of a virus. Nothing is added when none is lacking.",
                JUDGE_PLACES);
        step(set, inception, WRITE_RECORDS, "Write the submission's records", "Tool step",
                "A tool step that writes a submission into the knowledge base from its export and the"
                        + " judgments. The records are the submission, its device, its predicate, and"
                        + " its materials or its targets.",
                JUDGE_PLACES, ADD_CONCEPTS);
        step(set, inception, WRITE_TEMPLATE, "Write the consult template", "Tool step",
                "A tool step that writes the document a reviewer starts her consult from. It is"
                        + " written from the submission's records.",
                WRITE_RECORDS);

        set.concept(fqn(INTAKE)).at(inception)
                .synonym("510(k) intake from an eSTAR export")
                .definition("A guided workflow that takes the answers of a 510(k) submission from its"
                        + " eSTAR export into the knowledge base. Its nine steps end with the"
                        + " submission's records and a template for the reviewer's consult.")
                .isA(set.conceptRef(fqn("Guided workflow")))
                .semantic(set.patternRef(fqn("Workflow definition pattern")),
                        PublicIds.of(set.uuidFor("Workflow definition: " + INTAKE)),
                        PublicIds.list.of(ids(set, CHOOSE_EXPORT, READ_EXPORT, FIND_CONCEPTS, SORT_PLACES,
                                ASK_MODEL, JUDGE_PLACES, ADD_CONCEPTS, WRITE_RECORDS, WRITE_TEMPLATE)),
                        set.conceptRef(fqn(STEP_STATE_RULES)));
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

    /**
     * A step of a workflow: a concept beneath the kind of step that gives its performer, with the
     * shorter name the workflow card shows as its regular name, and its definition semantic.
     *
     * @param name       the step's fully qualified name, without the set's suffix
     * @param cardName   the name the workflow card shows
     * @param kind       the kind of step: Tool step, Language model step or Person step
     * @param definition what the step does and what its result is
     * @param needs      the steps whose results this step needs, by fully qualified name
     */
    private static void step(KnowledgeSet set, ActiveStamp stamp, String name, String cardName, String kind,
                             String definition, String... needs) {
        set.concept(fqn(name)).at(stamp)
                .synonym(cardName)
                .definition(definition)
                .isA(set.conceptRef(fqn(kind)))
                .semantic(set.patternRef(fqn("Step definition pattern")),
                        PublicIds.of(set.uuidFor("Step definition: " + name)),
                        PublicIds.set.of(ids(set, needs)),
                        // the step that sorts runs the place sorting rules; no other step of the intake runs rules
                        name.equals(SORT_PLACES) ? PublicIds.set.of(ids(set, PLACE_SORTING_RULES)) : PublicIds.set.of(ids(set)));
    }

    /** A rule set of the guided workflow: a concept beneath Komet rule set, with the name the card shows. */
    private static void ruleSet(KnowledgeSet set, ActiveStamp stamp, String name, String cardName, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(cardName)
                .definition(definition)
                .isA(set.conceptRef(RuleModelSet.fqn("Komet rule set")));
    }

    /** A rule of the guided workflow: a concept beneath Komet rule, named by the sentence of what it does. */
    private static void rule(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(RuleModelSet.fqn("Komet rule")));
    }

    private static PublicId[] ids(KnowledgeSet set, String... names) {
        PublicId[] ids = new PublicId[names.length];
        for (int index = 0; index < names.length; index++) {
            ids[index] = set.conceptRef(fqn(names[index])).publicId();
        }
        return ids;
    }
}
