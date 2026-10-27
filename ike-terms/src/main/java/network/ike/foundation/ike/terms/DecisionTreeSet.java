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
 * Declares a decision tree as one tree in a decision tree pattern (design
 * {@code dev-decision-tree-blocks}, under IKE-Network/ike-issues#806): the terms of the
 * decision-tree profile of the property-graph block. A decision tree is the decision-analytic
 * model of Raiffa and Howard, a square where someone chooses, a circle where the world decides
 * and a leaf where the consequences are counted, rolled back by expected value at each circle and
 * the best branch at each square. It is the method form for a quantitative decision method
 * beside the criteria list of {@code dev-decision-method-blocks}; a bound-case evaluation of it
 * is a record. It is not a BPMN process and not a DMN decision table.
 *
 * <p><b>One tree, one decision.</b> The root vertex is the decision the tree informs. Edges carry
 * nothing, so a branch is a vertex: an alternative under a decision, an event under a chance.
 * Five node kinds, all bare nouns as vertex meanings read: Decision, Alternative, Chance, Event,
 * Outcome. A decision's children are its alternatives; an alternative's or an event's one
 * structural child is a chance, an outcome or a further decision; a chance's children are its
 * events, which partition what can happen at it, the residual written and never implied; an
 * outcome is a leaf.
 *
 * <p><b>Every number is an ANF measure.</b> A probability and a cost are measure vertices under
 * the node that carries them, with their bounds, their open flags and their measure semantic
 * under the kernel's interval-role property keys, exactly as {@link AnfStatementSet}'s measures
 * are. A point value is the measure whose bounds meet. The measure semantic fixes what is
 * intrinsic to the number: a probability's is the share of those at the node, a money cost's is
 * its currency at its price year, a health cost's is its unit of healthy life. The standpoint the
 * tree is read from, whose costs count, the price year money is brought to, the discounting, the
 * horizon and the price of a year of healthy life, is a <em>valuation coordinate</em>, one more
 * constituent of the view beside the stamp, language, logic, navigation and edit coordinates:
 * chosen at evaluation, never stored on the tree, and recorded by a decision record as the
 * coordinate it was rolled back under. Nothing computed is stored: the expected value at a
 * chance, the chosen branch at a decision and a sensitivity swing are computed on the view or
 * written into a decision record.
 *
 * <p><b>Situations are statements, names are concepts.</b> An alternative, an event and an
 * outcome each hold the ANF statements they are, referenced by identity under one Statement key;
 * a statement says what kind it is, a request for the alternative, a performance or a narrative
 * for what happens. A node names its concept through the kernel's concept reference key. A measure says where its
 * value comes from: estimated, cited from a source, or derived by an ELM definition from other
 * measures.
 */
final class DecisionTreeSet {

    static final String ROOT_FQN = "Decision tree model (IkeFoundation)";

    /** The pattern whose one field is the tree. */
    static final String DECISION_TREE_PATTERN = fqn("Decision tree pattern");

    /** The valuation coordinate's properties family, a constituent of the view coordinate model. */
    static final String VALUATION_COORDINATE_PROPERTIES = fqn("Valuation coordinate properties");

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    /** The transitive part-of role the coordinate families state their composition with. */
    private static final EntityProxy.Concept PART_OF =
            EntityProxy.Concept.make("Part of (SOLOR)", PublicIds.of("b4c3f6f9-6937-30fd-8412-d0c77f8a7f73"));

    private DecisionTreeSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        set.concept(ROOT_FQN).at(inception)
                .synonym("Decision tree model")
                .definition("A decision tree held as one tree: the pattern whose field is the tree, the"
                        + " meanings of its nodes and of the measures they carry, the keys of the"
                        + " properties a vertex carries, the measure semantics its probabilities and costs"
                        + " are read in, the valuation coordinate it is rolled back under, and the kinds"
                        + " of basis a measure's value rests on.")
                .isA(IKE_BASE_MODEL_CONCEPT);

        // ── The tree ─────────────────────────────────────────────────────────────
        concept(set, inception, "Decision tree", ROOT_FQN,
                "A decision-analytic model of one decision, held as one tree whose root is the decision"
                        + " and whose vertices are its alternatives, chances, events and outcomes with the"
                        + " measures they carry: the meaning of the decision tree pattern. Rolled back by"
                        + " the expected value at each chance and the best alternative at each decision,"
                        + " on the view, never stored. The method form of a quantitative decision method;"
                        + " an evaluation of it against a bound case is a decision record.");

        // ── Node kinds ───────────────────────────────────────────────────────────
        concept(set, inception, "Decision tree node", ROOT_FQN,
                "A vertex of a decision tree that is a node of the model rather than a measure: a"
                        + " decision, an alternative, a chance, an event or an outcome. A node names its"
                        + " concept through the kernel's concept reference key.");
        node(set, inception, "Decision node", "Decision",
                "The square: a point where the decider chooses among the alternatives that are its"
                        + " children. The root of every decision tree; a further decision may follow an"
                        + " alternative or an event deeper in the tree. Names the decision concept the"
                        + " tree informs.");
        node(set, inception, "Alternative node", "Alternative",
                "One course the decider may choose at a decision: a branch held as a vertex because"
                        + " edges carry nothing. It is an ANF request statement, the scan being a request"
                        + " for the imaging; it carries the money and health costs choosing it incurs as"
                        + " measure children, and one structural child, a chance, an outcome or a further"
                        + " decision.");
        node(set, inception, "Chance node", "Chance",
                "The circle: a point where the world decides. Names the uncertain quantity, and its"
                        + " children are the events that partition what can happen at it. Its expected"
                        + " value is the sum of each event's probability times what follows it, computed"
                        + " on the view.");
        node(set, inception, "Event node", "Event",
                "One of the things that can happen at a chance: a branch held as a vertex. It is an"
                        + " ANF situation statement; it carries its probability as a measure child, any"
                        + " costs the event itself incurs, and one structural child, a chance, an outcome"
                        + " or a further decision. The events of a chance sum to one within their bounds,"
                        + " and the one that is the remainder is marked residual rather than left"
                        + " unwritten.");
        node(set, inception, "Outcome node", "Outcome",
                "The leaf: the end of one path through the tree, where the consequences are counted."
                        + " It holds the ANF situation statements that hold there and carries the money"
                        + " and health costs the path is left with as measure children; it may instead"
                        + " fold in another decision's tree by reference.");

        // ── Measure kinds ────────────────────────────────────────────────────────
        concept(set, inception, "Decision measure", ROOT_FQN,
                "A vertex of a decision tree that is a measure a node carries: a probability or a"
                        + " cost. It carries its lower and upper bounds, whether each is open, and its"
                        + " measure semantic under the kernel's interval-role property keys, as an ANF"
                        + " measure does; a point value is the measure whose bounds meet, and a wider"
                        + " interval is the honest statement of what is known. Where its value comes from"
                        + " is its basis.");
        measure(set, inception, "Probability measure", "Probability",
                "The measure an event carries: the share of those at the chance who leave it by this"
                        + " event, on the Share at node semantic, bounded within zero and one.");
        measure(set, inception, "Money cost measure", "Money cost",
                "A cost in money an alternative, an event or an outcome carries, on a money semantic:"
                        + " what is billed for the care taken on that branch, or the money part of a"
                        + " rupture.");
        measure(set, inception, "Health cost measure", "Health cost",
                "A cost in health an alternative, an event or an outcome carries, on a health"
                        + " semantic: the years of healthy life a scan's harm, a complication or a rupture"
                        + " takes. Counted beside money, never folded into it in the tree; the price of a"
                        + " year of healthy life belongs to the valuation coordinate the tree is read"
                        + " under.");

        // ── Property keys ────────────────────────────────────────────────────────
        concept(set, inception, "Decision tree property", ROOT_FQN,
                "A key of a property a vertex of a decision tree carries, beside the kernel's concept"
                        + " reference and interval keys, which the tree reuses.");
        property(set, inception, "Statement",
                "The ANF statements a node is or holds: references to the statements, never copies of"
                        + " them. A statement says what kind it is, so one key serves the request an"
                        + " alternative is and the situations an event is or an outcome holds, which a"
                        + " bound case is tested against.");
        property(set, inception, "Derived from",
                "The ELM definition that computes a measure's value from other measures of the tree,"
                        + " a positive-scan probability from a sensitivity, a specificity and a"
                        + " prevalence: a reference to the definition. A measure with this key has the"
                        + " derived basis.");
        property(set, inception, "Measure basis",
                "What a measure's value rests on: a basis kind concept, estimated, cited or derived.");
        property(set, inception, "Basis source",
                "The source a cited measure's value is taken from: a reference to the citation or the"
                        + " document.");
        property(set, inception, "Tree reference",
                "The decision whose own tree folds in at this outcome or alternative, by reference,"
                        + " so one tree is never copied into another; what the folded tree rolls back to"
                        + " is an input here, and a record of this tree says so.");
        property(set, inception, "Input kind",
                "The kind of component of a case that is bound to this vertex when the tree is applied"
                        + " to the case: the measure or situation a record supplies, where the method"
                        + " leaves it open.");
        property(set, inception, "Residual",
                "Whether this event is the remainder of its chance's partition, whatever the other"
                        + " events leave: a boolean, true on at most one event of a chance.");

        // ── Measure semantics ────────────────────────────────────────────────────
        concept(set, inception, "Decision measure semantic", ROOT_FQN,
                "A measure semantic a decision measure is read in, named by the kernel's unit of"
                        + " measure key: the share of those at a node for a probability, a money"
                        + " semantic or a health semantic for a cost. It fixes what is intrinsic to the"
                        + " number; the standpoint it is read from is the valuation coordinate. Two"
                        + " measures roll back together only when their semantics agree or the"
                        + " coordinate brings them to one.");
        semantic(set, inception, "Share at node",
                "The measure semantic of a probability: the share of those at a chance who leave it by"
                        + " one event, a number between zero and one with no unit. The shares of a"
                        + " chance's events sum to one within their bounds.");
        semantic(set, inception, "Money semantic",
                "The measure semantic of a money cost: a currency at a price year, fixed together by"
                        + " one concept beneath this one, so that two money costs on the same semantic"
                        + " add and two on different ones are first brought to the valuation"
                        + " coordinate's price year.");
        semantic(set, inception, "Health semantic",
                "The measure semantic of a health cost: a unit of healthy life, the quality-adjusted"
                        + " life year or another, fixed by one concept beneath this one.");

        // ── The valuation coordinate ─────────────────────────────────────────────
        // One more constituent of the view, mirroring the stamp, edit and navigation
        // properties families of CoordinateModelSet: a properties family that is part of the
        // view coordinate model, and dimension concepts that are each part of the family.
        ConceptFacade viewCoordinateModel = set.conceptRef("View coordinate model (IkeFoundation)");
        set.concept(VALUATION_COORDINATE_PROPERTIES).at(inception)
                .synonym("Valuation coordinate properties")
                .definition("The dimensions of the valuation coordinate, the standpoint a decision tree"
                        + " is rolled back from: whose costs count, the price year money is brought to,"
                        + " the discounting, the horizon, and the price of a year of healthy life at"
                        + " which health and money are set against each other. Chosen at evaluation,"
                        + " never stored on the tree, and recorded by a decision record as the"
                        + " coordinate it was rolled back under. A model concept grouping those"
                        + " dimensions, and part of the view coordinate model, stated logically as a"
                        + " Part of restriction.")
                .statedAxioms(leb -> leb.NecessarySet(leb.And(
                        leb.ConceptAxiom(viewCoordinateModel),
                        leb.SomeRole(PART_OF, leb.ConceptAxiom(viewCoordinateModel)))));
        dimension(set, inception, "Perspective",
                "The perspective dimension of the valuation coordinate: whose costs count, the payer,"
                        + " the health system, the patient or society.");
        dimension(set, inception, "Price year",
                "The price-year dimension of the valuation coordinate: the year every money cost is"
                        + " brought to before costs are added.");
        dimension(set, inception, "Discounting",
                "The discounting dimension of the valuation coordinate: the rate at which costs and"
                        + " health in later years are reduced to the present.");
        dimension(set, inception, "Horizon",
                "The horizon dimension of the valuation coordinate: how far ahead consequences are"
                        + " counted.");
        dimension(set, inception, "Health price",
                "The health-price dimension of the valuation coordinate: the price of a year of"
                        + " healthy life, at which a health cost is set against a money cost when the"
                        + " tree is rolled back to one number.");

        // ── Basis kinds ──────────────────────────────────────────────────────────
        concept(set, inception, "Basis kind", ROOT_FQN,
                "What a measure's value rests on, the value of the Measure basis key: estimated,"
                        + " cited or derived.");
        basis(set, inception, "Estimated basis", "Estimated",
                "The value is the authors' own estimate, open to proposals for revision: the basis"
                        + " a model assumption has when it names no source.");
        basis(set, inception, "Cited basis", "Cited",
                "The value is taken from a source the measure names through its Basis source.");
        basis(set, inception, "Derived basis", "Derived",
                "The value is computed from other measures of the tree by the ELM definition the"
                        + " measure names through Derived from, and is never entered by hand.");

        // ── The pattern ──────────────────────────────────────────────────────────
        concept(set, inception, "Decision tree structure", ROOT_FQN,
                "Carrying a decision tree as a tree: the purpose of the decision tree pattern and its"
                        + " field.");
        concept(set, inception, "Decision tree content", ROOT_FQN,
                "The tree that is the decision tree: the field of the decision tree pattern.");

        ConceptFacade structure = set.conceptRef(fqn("Decision tree structure"));
        set.pattern(DECISION_TREE_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Decision tree")))
                .purpose(structure)
                .field(set.conceptRef(fqn("Decision tree content")), structure, KernelConcept.DITREE_FIELD)
                .synonym("Decision tree pattern")
                .definition("One decision tree, held as one tree about the decision concept it informs:"
                        + " its root is the decision, its vertices are the nodes and the measures they"
                        + " carry, and its vertex identities persist across versions, so a revised"
                        + " probability or cost is a new version of one vertex, never a new tree.");
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }

    private static void concept(KnowledgeSet set, ActiveStamp stamp, String name, String parentFqn, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(parentFqn));
    }

    private static void named(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String parentFqn,
                              String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(synonym)
                .definition(definition)
                .isA(set.conceptRef(parentFqn));
    }

    private static void node(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String definition) {
        named(set, stamp, name, synonym, fqn("Decision tree node"), definition);
    }

    private static void measure(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String definition) {
        named(set, stamp, name, synonym, fqn("Decision measure"), definition);
    }

    private static void property(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        concept(set, stamp, name, fqn("Decision tree property"), definition);
    }

    private static void semantic(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        concept(set, stamp, name, fqn("Decision measure semantic"), definition);
    }

    private static void basis(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String definition) {
        named(set, stamp, name, synonym, fqn("Basis kind"), definition);
    }

    /** A dimension of the valuation coordinate: a kind of its properties family, and part of it. */
    private static void dimension(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        ConceptFacade family = set.conceptRef(VALUATION_COORDINATE_PROPERTIES);
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .statedAxioms(leb -> leb.NecessarySet(leb.And(
                        leb.ConceptAxiom(family),
                        leb.SomeRole(PART_OF, leb.ConceptAxiom(family)))));
    }
}
