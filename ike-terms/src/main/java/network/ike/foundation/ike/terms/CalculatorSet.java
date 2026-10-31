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
 * Declares a medical calculator as one tree in a calculator pattern (design
 * {@code dev-calculator-blocks}, under IKE-Network/ike-issues#806): the terms of the calculator
 * profile of the property-graph block, the third profile after the logical definition and the
 * decision tree of {@link DecisionTreeSet}. A calculator is a published equation over a few
 * clinical inputs, the ten-year atherosclerotic cardiovascular risk of the Pooled Cohort Equations
 * being the first: its inputs, the statements they bind to, the strata of cited coefficients it is
 * read with, the form of its formula, and the guideline bands laid over its result. It is a method
 * in the sense of {@code dev-decision-method-blocks}, promoted into the Kompendium and read by
 * reference; a use of it in a document binds the document's ANF statements to its inputs and is a
 * record.
 *
 * <p><b>One tree, one calculator.</b> The root vertex names the calculator's concept. Its children
 * are the output, the inputs, the equation terms, the strata, the formula and the bands. An input
 * declares what may bind there: the ANF topic a bound statement must have, the measure semantic the
 * equation expects, held under the kernel's unit of measure key, the domain the equation is valid
 * over, held under the kernel's interval keys, whether it is required, which of several statements
 * is taken and how old it may be, and what the evaluator does when nothing binds. A stratum holds
 * the coefficients one published equation of the family states, each named by the equation term or
 * the stratum constant it multiplies, and the conditions on the inputs that select it. An equation
 * term is a quantity derived from the inputs through the derivation keys {@link DecisionTreeSet}
 * declares, so the natural logarithm of an age and its product with another term are stated, never
 * hidden in code; the formula names the derivation kind that folds the selected stratum's
 * coefficients and terms into the result.
 *
 * <p><b>Every number is an ANF measure.</b> A coefficient, a domain, a plausible range and a band's
 * interval are measures with bounds under the kernel's interval keys, as the decision tree's are.
 * The result carries the bounds the inputs' bounds give it: a point reading gives a point, a reading
 * with a stated resolution or a missing input swept over a plausible range gives an interval, which
 * is the measurement of what the record did not say. Nothing computed is stored on the calculator;
 * recording a result writes an ANF determination whose method is the calculator and whose
 * supported-by associations name the statements bound.
 *
 * <p><b>Missing is never absent.</b> An input with no statement bound is not determinable unless the
 * method says otherwise through its when-missing policy: a plausible range the equation is swept
 * over, drawn hollow and widening the result, or an assumed value the method's author stands behind,
 * drawn as an assumption. A presence input is never taken as absent by default, the ANF guide's
 * missing-data rule carried into the evaluator.
 */
final class CalculatorSet {

    static final String ROOT_FQN = "Calculator model (IkeFoundation)";

    /** The pattern whose one field is the calculator's tree. */
    static final String CALCULATOR_PATTERN = fqn("Calculator pattern");

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    private CalculatorSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        set.concept(ROOT_FQN).at(inception)
                .synonym("Calculator model")
                .definition("A medical calculator held as one tree: the pattern whose field is the tree,"
                        + " the meanings of its vertices, the keys of the properties a vertex carries"
                        + " beside those the decision tree model and the kernel already declare, the"
                        + " policies for an input nothing binds to, and the derivation kinds its terms"
                        + " and its formula are computed with.")
                .isA(IKE_BASE_MODEL_CONCEPT);

        // ── The calculator ───────────────────────────────────────────────────────
        concept(set, inception, "Calculator", ROOT_FQN,
                "A published equation over a few clinical inputs, held as one tree whose root names the"
                        + " calculator and whose vertices are its output, its inputs, its equation terms,"
                        + " its strata of cited coefficients, its formula and the guideline bands laid"
                        + " over its result: the meaning of the calculator pattern. A method promoted"
                        + " into the Kompendium and read by reference; a use of it binds a document's"
                        + " ANF statements to its inputs and is a record. Nothing computed is stored on"
                        + " it.");

        // ── Vertex kinds ─────────────────────────────────────────────────────────
        concept(set, inception, "Calculator element", ROOT_FQN,
                "A vertex of a calculator's tree: the root, an input, the output, an equation term, a"
                        + " stratum and what it holds, the formula, a band, or one of the measures an"
                        + " input carries for its conversion, its recency and its missing value.");
        element(set, inception, "Calculator node", "Calculator root",
                "The root of a calculator's tree. Names the calculator's concept through the kernel's"
                        + " concept reference key and the publication it is taken from through the"
                        + " decision tree model's Basis source key.");
        element(set, inception, "Input node", "Input",
                "One quantity the equation reads, named through the kernel's concept reference key. It"
                        + " declares what may bind there: the ANF topic a bound statement must have, the"
                        + " measure semantic the equation expects under the kernel's unit of measure key,"
                        + " the domain the equation is valid over under the kernel's interval keys, the"
                        + " concept values it admits where the input is a concept rather than a number,"
                        + " whether it is required, and the when-missing policy. It carries conversion,"
                        + " recency and missing value measures as children.");
        element(set, inception, "Output node", "Output",
                "What the calculator determines: the topic concept of the determination a recording"
                        + " writes, under the kernel's concept reference key; the measure semantic the"
                        + " result is written in, under the unit of measure key, a share over the"
                        + " calculator's horizon under this equation; the result's domain under the"
                        + " interval keys; and the scale the result is shown at.");
        element(set, inception, "Equation term node", "Equation term",
                "A quantity the formula multiplies a coefficient by, derived from the inputs and from"
                        + " other terms through the decision tree model's Derived from and Derivation"
                        + " operands keys: the natural logarithm of an age, the product of two"
                        + " logarithms, the complement of a presence. Named through the kernel's concept"
                        + " reference key, so a stratum's coefficient names it.");
        element(set, inception, "Stratum node", "Stratum",
                "One published equation of the family, selected by the values of the inputs its"
                        + " conditions name: the white male equation of the Pooled Cohort family. Holds"
                        + " its coefficients and its conditions as children. A calculator with one"
                        + " equation has one stratum with no condition.");
        element(set, inception, "Stratum condition node", "Stratum condition",
                "One condition that selects a stratum: the input it tests, through the kernel's concept"
                        + " reference key, and the concept value the bound statement must carry, through"
                        + " the Condition value key. A stratum is selected when every condition holds.");
        element(set, inception, "Coefficient node", "Coefficient",
                "A number a stratum states: the coefficient of one equation term, or a constant of the"
                        + " stratum the formula reads, a baseline survival or the mean of the terms."
                        + " Names what it belongs to through the kernel's concept reference key and"
                        + " carries its value as a measure under the interval keys, with its basis and"
                        + " source, cited from the publication.");
        element(set, inception, "Formula node", "Formula",
                "How the selected stratum's coefficients and the equation terms fold into the result: a"
                        + " derivation kind with a native implementation, through the decision tree"
                        + " model's Derived from key, reading the stratum constants it needs through"
                        + " Derivation operands, or an ELM definition by identity.");
        element(set, inception, "Band node", "Band",
                "An interval of the result a guideline names: low, borderline, intermediate, high."
                        + " Names the band concept through the kernel's concept reference key, its"
                        + " interval under the interval keys at the output's scale, and the guideline"
                        + " through Basis source.");
        element(set, inception, "Conversion node", "Conversion",
                "A measure semantic an input admits beside the one the equation expects, and the"
                        + " factor that brings a value on it to the expected one: the semantic under the"
                        + " kernel's unit of measure key, the factor under the interval keys. A bound"
                        + " statement on a semantic the input does not admit is not determinable.");
        element(set, inception, "Recency node", "Recency",
                "How old a bound statement may be, as a measure under the kernel's interval keys with"
                        + " its unit: the window the latest statement is taken within when the input"
                        + " binds by policy rather than by identity.");
        element(set, inception, "Missing value node", "Missing value",
                "The bounds the evaluator uses when nothing binds to the input, under the kernel's"
                        + " interval keys: the plausible range the equation is swept over, or the"
                        + " assumed value, as the input's when-missing policy says.");

        // ── Property keys ────────────────────────────────────────────────────────
        concept(set, inception, "Calculator property", ROOT_FQN,
                "A key of a property a vertex of a calculator's tree carries, beside the kernel's"
                        + " concept reference, interval and unit of measure keys and the decision tree"
                        + " model's Derived from, Derivation operands, Measure basis and Basis source,"
                        + " which the calculator reuses.");
        property(set, inception, "Input topic constraint",
                "The ANF topic a statement bound to an input must have, or a concept it must be a kind"
                        + " of: a reference to the concept.");
        property(set, inception, "Required input",
                "Whether the equation cannot run without this input: a boolean. A required input with"
                        + " nothing bound and no when-missing policy makes the result not determinable.");
        property(set, inception, "Admitted values",
                "The concepts an input may take where it is a concept rather than a number, male or"
                        + " female for a sex input: references to the concepts. A bound statement whose"
                        + " topic is one of them supplies that value.");
        property(set, inception, "When missing",
                "What the evaluator does when nothing binds to an input: a when-missing policy concept,"
                        + " not determinable, plausible range or assumed value.");
        property(set, inception, "Condition value",
                "The concept value a stratum condition requires of its input: a reference to the"
                        + " concept.");
        property(set, inception, "Result scale",
                "The factor the result is multiplied by for display and for the bands' intervals, one"
                        + " hundred for a share shown as a percentage: a number, one when absent.");

        // ── When-missing policies ────────────────────────────────────────────────
        concept(set, inception, "When-missing policy", ROOT_FQN,
                "What an evaluator does when nothing binds to an input, the value of the When missing"
                        + " key: not determinable, plausible range or assumed value. Never absent: a"
                        + " presence input with no statement is not taken as a negative result.");
        policy(set, inception, "Not determinable when missing", "Not determinable",
                "The default: the result is not determinable, with a finding naming the input.");
        policy(set, inception, "Plausible range when missing", "Plausible range",
                "The equation is swept over the input's missing value bounds, so the result widens by"
                        + " what the input could be; the sweep is shown as the input's own interval and"
                        + " a recording carries the interim disposition.");
        policy(set, inception, "Assumed value when missing", "Assumed value",
                "The equation reads the input's missing value bounds as if observed, an assumption the"
                        + " method's author stands behind, shown as an assumption and carried into a"
                        + " recording's disposition.");

        // ── Derivation kinds ─────────────────────────────────────────────────────
        // Under the decision tree model's Derivation kind, which the calculator's terms and formula
        // name through the same Derived from key.
        derivation(set, inception, "Natural logarithm derivation", "Natural logarithm",
                "The natural logarithm of its one operand, missing of a non-positive value: the form"
                        + " most risk equations read an age, a pressure or a cholesterol in.");
        derivation(set, inception, "Cox survival derivation", "Cox survival",
                "The chance of the event over the horizon under a Cox proportional-hazards equation:"
                        + " one minus the baseline survival to the power of the exponential of the"
                        + " selected stratum's coefficients times their equation terms, less the"
                        + " stratum's mean of the terms. Operands: the baseline survival, then the"
                        + " mean, each a stratum constant. Evaluated pointwise over the corners of the"
                        + " inputs' bounds, since the equation is monotone in each input, so a bounded"
                        + " input gives honest bounds without the dependency problem of interval"
                        + " arithmetic.");

        // ── The pattern ──────────────────────────────────────────────────────────
        concept(set, inception, "Calculator structure", ROOT_FQN,
                "Carrying a calculator as a tree: the purpose of the calculator pattern and its field.");
        concept(set, inception, "Calculator content", ROOT_FQN,
                "The tree that is the calculator: the field of the calculator pattern.");

        ConceptFacade structure = set.conceptRef(fqn("Calculator structure"));
        set.pattern(CALCULATOR_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Calculator")))
                .purpose(structure)
                .field(set.conceptRef(fqn("Calculator content")), structure, KernelConcept.DITREE_FIELD)
                .synonym("Calculator pattern")
                .definition("One calculator, held as one tree about the calculator concept it defines:"
                        + " its root names the calculator, its vertices are the output, the inputs, the"
                        + " equation terms, the strata with their coefficients and conditions, the"
                        + " formula and the bands, and its vertex identities persist across versions,"
                        + " so a recalibrated coefficient is a new version of one vertex, never a new"
                        + " calculator.");
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

    private static void element(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String definition) {
        named(set, stamp, name, synonym, fqn("Calculator element"), definition);
    }

    private static void property(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        concept(set, stamp, name, fqn("Calculator property"), definition);
    }

    private static void policy(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String definition) {
        named(set, stamp, name, synonym, fqn("When-missing policy"), definition);
    }

    private static void derivation(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String definition) {
        named(set, stamp, name, synonym, DecisionTreeSet.fqn("Derivation kind"), definition);
    }
}
