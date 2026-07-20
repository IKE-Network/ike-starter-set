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

/**
 * The definition completions of the meaning/purpose audit (IKE-Network/ike-issues#892):
 * every concept any ledger-declared pattern's latest version names as a meaning or
 * purpose — referenced component or field — must carry a textual definition that says
 * something a reader could not already read off the label. The audited inventory (34
 * patterns, 154 distinct meaning/purpose concepts) found 25 base-model chronicle/version
 * field concepts, plus the 27 the IKE-Network/ike-issues#922 sweep found undefined (Public ID field, the five chronicle-kind fields, the five versions
 * field/set pairs, the pattern-version declaration fields, the semantic-version fields,
 * STAMP field, Time field) that never carried a definition description at all. Each is
 * resumed here by its birth FQN (all were opened by the foundation sections'
 * identity-exact ingest) and given its first — and only — definition, grounded in how
 * the chronicle/version meta-model actually uses it.
 * <p>
 * The audit's other defect classes — the label echoes, the terminology-rule revisions
 * (IKE-Network/ike-issues#893), the garbled Semantic data type definition, and the
 * "Sementic" FQN typo — are corrected in place at their section declarations under the
 * inception flatten (IKE-Network/ike-issues#894), so no restatement lives here.
 * <p>
 * Two {@code LedgerGatesIT} gates hold the audit closed: every Model Feature's
 * meaning differs from its purpose, and every meaning/purpose concept carries a
 * definition whose normalized text differs from its labels — echoes cannot return.
 */
final class DefinitionCompletionSet {

    private DefinitionCompletionSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // The one declared inception stamp of the pre-release set
        // (IKE-Network/ike-issues#894).
        ActiveStamp completion = Ike.INCEPTION;

        // ── The 25 missing definitions: chronicle-shape fields ──────────
        // Each concept below is resumed by its birth FQN (opened by the foundation
        // sections' identity-exact ingest) and given its first definition description.
        // Meanings say what the field is and holds; the "... set" purposes say why the
        // field is recorded — the same meaning/purpose division of labor the pattern
        // declarations themselves observe (IKE-Network/ike-issues#880).

        set.concept("Public ID field").at(completion)
                .definition("The field kind holding a chronicle's public identity — the"
                        + " universally unique identifiers that name a component across"
                        + " every system it is exchanged with. The first field of every"
                        + " chronicle-shape pattern, recorded to uniquely identify"
                        + " knowledge graph components.");

        set.concept("Component field").at(completion)
                .definition("The field kind whose value references a component of any"
                        + " kind — concept, pattern, semantic, or STAMP. The parent of"
                        + " every reference-valued field kind, and the Component"
                        + " Chronology Pattern's referenced-component meaning: the"
                        + " component whose identity and history the chronicle records.");

        set.concept("Concept field").at(completion)
                .definition("A component field narrowed to concepts: its value references"
                        + " a concept specifically. The parent of the STAMP-dimension"
                        + " field kinds and of a pattern's meaning- and"
                        + " purpose-declaration field kinds, and the Concept Chronology"
                        + " Pattern's referenced-component meaning.");

        set.concept("Pattern field").at(completion)
                .definition("A component field narrowed to patterns: its value references"
                        + " a pattern. The Pattern Chronology Pattern's"
                        + " referenced-component meaning, and the parent of Semantic"
                        + " pattern field.");

        set.concept("Semantic field").at(completion)
                .definition("A component field narrowed to semantics: its value references"
                        + " a semantic. The Semantic Chronology Pattern's"
                        + " referenced-component meaning — the chronicle kind that must"
                        + " also record which pattern its semantic is an instance of and"
                        + " what it is attached to.");

        set.concept("STAMP field").at(completion)
                .definition("A component field whose value references a STAMP — the"
                        + " five-dimension provenance tuple a version was committed with."
                        + " The STAMP Chronology Pattern's referenced-component meaning,"
                        + " and the first field of every version-shape pattern, recorded"
                        + " for version provenance.");

        set.concept("Time field").at(completion)
                .definition("An instant field whose value is the time dimension of a"
                        + " STAMP — when the version was committed.");

        // ── The versions field/set pairs ────────────────────────────────
        // In the chronicle shape the "versions field" is the field's meaning (what the
        // slot is) and the "versions set" its purpose (why it is recorded: the complete
        // history). The version-shape patterns then resume each "versions field" as
        // their own referenced-component meaning.

        set.concept("Component versions field").at(completion)
                .definition("The field kind holding a chronicle's version collection —"
                        + " one entry per committed version of the component. Every"
                        + " chronicle-shape pattern declares it beside the public id, and"
                        + " the Component Version Pattern carries it as its own"
                        + " referenced-component meaning.");

        set.concept("Component versions set").at(completion)
                .definition("Why a chronicle's versions field is recorded: to hold every"
                        + " version the component has ever had — the complete history a"
                        + " chronicle exists to keep alongside its identity.");

        set.concept("Concept versions field").at(completion)
                .definition("The component versions field narrowed to concept chronicles:"
                        + " its value collects a concept's own versions. The Concept"
                        + " Version Pattern's referenced-component meaning.");

        set.concept("Concept versions set").at(completion)
                .definition("Why a concept chronicle's versions field is recorded: to"
                        + " hold every version the concept has ever had — the"
                        + " concept-chronicle specialization of Component versions set.");

        set.concept("Pattern versions field").at(completion)
                .definition("The component versions field narrowed to pattern chronicles:"
                        + " its value collects a pattern's own versions. The Pattern"
                        + " Version Pattern's referenced-component meaning.");

        set.concept("Pattern versions set").at(completion)
                .definition("Why a pattern chronicle's versions field is recorded: to"
                        + " hold every version the pattern has ever had — the"
                        + " pattern-chronicle specialization of Component versions set.");

        set.concept("Semantic versions field").at(completion)
                .definition("The component versions field narrowed to semantic"
                        + " chronicles: its value collects a semantic's own versions. The"
                        + " Semantic version field pattern's referenced-component"
                        + " meaning.");

        set.concept("Semantic versions set").at(completion)
                .definition("Why a semantic chronicle's versions field is recorded: to"
                        + " hold every version the semantic has ever had — the"
                        + " semantic-chronicle specialization of Component versions"
                        + " set.");

        set.concept("STAMP versions field").at(completion)
                .definition("The component versions field narrowed to STAMP chronicles:"
                        + " its value collects a STAMP's own versions. The STAMP version"
                        + " field pattern's referenced-component meaning.");

        set.concept("STAMP versions set").at(completion)
                .definition("Why a STAMP chronicle's versions field is recorded: to hold"
                        + " every version the STAMP has ever had — the STAMP-chronicle"
                        + " specialization of Component versions set.");

        // ── The pattern-version declaration fields ──────────────────────

        set.concept("Pattern meaning field").at(completion)
                .definition("A concept field whose value is a pattern version's declared"
                        + " meaning concept — naming what a semantic of the pattern is"
                        + " about.");

        set.concept("Pattern purpose field").at(completion)
                .definition("A concept field whose value is a pattern version's declared"
                        + " purpose concept — naming why semantics of the pattern are"
                        + " captured.");

        set.concept("Field definition field").at(completion)
                .definition("The field kind naming a pattern version's field-definition"
                        + " slot: each value is one field definition — the meaning,"
                        + " purpose, and data type the pattern declares for one of its"
                        + " fields.");

        set.concept("Field definitions set").at(completion)
                .definition("Why a pattern version's field-definition field is recorded:"
                        + " to hold the pattern's complete, ordered field definitions —"
                        + " the declared shape every semantic of the pattern must fit.");

        // ── The semantic-version and semantic-chronicle fields ──────────

        set.concept("Semantic field field").at(completion)
                .definition("The field kind naming a semantic version's field-value slot:"
                        + " each value is one field the version actually carries, as"
                        + " distinct from the field definition its pattern declares.");

        set.concept("Semantic field fields set").at(completion)
                .definition("Why a semantic version's field-value field is recorded: to"
                        + " hold, together, every field value that version carries — the"
                        + " value-side counterpart to a pattern's Field definitions"
                        + " set.");

        set.concept("Semantic pattern field").at(completion)
                .definition("A pattern field whose value identifies which pattern a"
                        + " semantic is an instance of — the field a semantic chronicle"
                        + " records for pattern membership.");

        set.concept("Semantic referenced component field").at(completion)
                .definition("A component field whose value identifies the component a"
                        + " semantic is attached to — the field a semantic chronicle"
                        + " records for its attachment target.");

        // ── The #922 name-fidelity wave: the 27 concepts the sweep found with no
        // definition at all — the interval-axiom vocabulary, the field kinds the
        // original 25 did not reach, the baseline axiom groupings, and two module-era
        // anchors. Same resume-by-birth-FQN idiom as above.
        set.concept("Interval Set Axioms").at(completion)
                .definition("Groups the interval-axiom vocabulary: the bound values, openness markers, and unit of measure an interval-valued assertion carries.");

        set.concept("Interval Lower Bound").at(completion)
                .definition("The field holding an interval's lower bound value.");

        set.concept("Interval Upper Bound").at(completion)
                .definition("The field holding an interval's upper bound value.");

        set.concept("Include Lower Bound").at(completion)
                .definition("The field saying whether an interval includes its lower bound: closed when included, open when not.");

        set.concept("Include Upper Bound").at(completion)
                .definition("The field saying whether an interval includes its upper bound: closed when included, open when not.");

        set.concept("Lower Bound Open").at(completion)
                .definition("The marker that an interval's lower bound is open: the bound value itself lies outside the interval.");

        set.concept("Upper Bound Open").at(completion)
                .definition("The marker that an interval's upper bound is open: the bound value itself lies outside the interval.");

        set.concept("Unit of Measure").at(completion)
                .definition("The field naming the unit an interval's bounds are expressed in.");

        set.concept("Interval Type").at(completion)
                .definition("The concept naming which kind of interval an interval assertion carries.");

        set.concept("Temporal Axiom").at(completion)
                .definition("Groups axioms about time: the temporal counterpart of the interval-axiom vocabulary.");

        set.concept("Interval role").at(completion)
                .definition("The typed atom asserting a role bounded to an interval: a role whose filler is constrained by interval bounds. Mirrors LogicalAxiom.Atom.TypedAtom.IntervalRole in the sealed hierarchy.");

        set.concept("Interval property set").at(completion)
                .definition("The logical set grouping interval-property axioms under a definition root. Mirrors LogicalAxiom.LogicalSet.IntervalPropertySet in the sealed hierarchy.");

        set.concept("Interval Role Type").at(completion)
                .definition("The role-type vocabulary for interval roles: names which relation an interval role asserts.");

        set.concept("Feature Role Type").at(completion)
                .definition("The role type marking a role as feature-valued: the bridge between role machinery and concrete-domain features.");

        set.concept("Property set Axioms").at(completion)
                .definition("A baseline grouping for property-set axioms, retained for identity compatibility: the platform's set meaning is Property set.");

        set.concept("Data Property Set Axioms").at(completion)
                .definition("A baseline grouping for data-property-set axioms, retained for identity compatibility: the platform's set meaning is Data property set.");

        set.concept("Implication set").at(completion)
                .definition("A baseline grouping for implication axioms, retained for identity compatibility: property-sequence implications are the atoms it grouped.");

        set.concept("Boolean field").at(completion)
                .definition("The field kind for boolean-valued fields: a pattern field holding true or false.");

        set.concept("Integer field").at(completion)
                .definition("The field kind for integer-valued fields: a pattern field holding a whole number.");

        set.concept("String field").at(completion)
                .definition("The field kind for string-valued fields: a pattern field holding text.");

        set.concept("Instant field").at(completion)
                .definition("The field kind for instant-valued fields: a pattern field holding a point in time.");

        set.concept("Field definition data type field").at(completion)
                .definition("The field kind naming a field definition's data type slot: which data type a pattern declares for one of its fields.");

        set.concept("Field definition meaning field").at(completion)
                .definition("The field kind naming a field definition's meaning slot: the concept saying what the declared field is.");

        set.concept("Field definition purpose field").at(completion)
                .definition("The field kind naming a field definition's purpose slot: the concept saying why the declared field is recorded.");

        set.concept("Field value field").at(completion)
                .definition("The field kind for one field value a semantic version actually carries, as distinct from the field definition its pattern declares.");

        set.concept("Default Data Concept").at(completion)
                .definition("The baseline's placeholder anchor for default data, retained for identity compatibility with upstream stores; its placeholder seeds are deliberately not adopted here.");

    }
}
