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
import dev.ikm.tinkar.entity.builder.Stamp;

import java.util.UUID;

/**
 * Completes the meaning/purpose definition audit (IKE-Network/ike-issues#892): every
 * concept any ledger-declared pattern's latest version names as a meaning or purpose —
 * referenced component or field — must carry a textual definition that says something a
 * reader could not already read off the label. The audited inventory (34 patterns, 154
 * distinct meaning/purpose concepts) found three defect classes, each corrected here:
 * <ul>
 *   <li><b>25 missing definitions</b> — the base-model chronicle/version field concepts
 *   (Public ID field, the five chronicle-kind fields, the five versions field/set pairs,
 *   the pattern-version declaration fields, the semantic-version fields, STAMP field,
 *   Time field) never carried a definition description at all. Each is resumed by its
 *   birth FQN (all were opened by the foundation sections' identity-exact ingest) and
 *   given one, grounded in how the chronicle/version meta-model actually uses it.</li>
 *   <li><b>9 label echoes</b> — Author, Module, Path concept, Module origins, Path
 *   origins, Version Properties, Membership semantic, and the EL++ Stated/Inferred
 *   terminological axioms each carried a definition description whose text merely
 *   repeats the label. Each established definition description is revised in place by
 *   declared-identity restatement — the {@link DataTypeDefaultsSet} rename mechanism,
 *   here aimed at the definition rather than the fully qualified name — so the original
 *   echo stays in history and a later-positioned view resolves the real text. The
 *   garbled inherited "Semantic data type" definition ("List of fields-  semantic")
 *   rides along, revised the same way.</li>
 *   <li><b>One FQN typo</b> — "Sementic version field pattern"
 *   ({@code 82f93e84-cee1-44bc-bb6d-4cc2a722048b}) is renamed to "Semantic version
 *   field pattern". The pattern's descriptions were declared with their established
 *   identities in {@code foundation.Section71}, so the rename restates both established
 *   FQN description semantics rather than using {@code reviseFullyQualifiedName} (the
 *   builder rejects the convenience verb once descriptions are explicit). The registry
 *   key stays the birth FQN.</li>
 * </ul>
 * Composed last of all, at a stamp later than every other scope in the session, so the
 * ledger keeps reading time-major: this file revises components nearly every earlier
 * scope has already touched.
 * <p>
 * Two {@code FoundationFidelityIT} gates hold this audit closed: every Model Feature's
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
        // Later than every other authoring pass in this project (2026-07-12 through
        // 2026-07-21T12): this file completes definitions on components nearly every
        // earlier scope already touches, so it composes last, at the latest stamp.
        ActiveStamp completion = Stamp.active("2026-07-23T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

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

        // ── The 9 label-echo revisions ──────────────────────────────────
        // Each concept's established definition description (declared with its
        // established identity in the foundation sections) is revised in place: a new
        // version of the same description semantic, real text replacing the label echo
        // (the DataTypeDefaultsSet declared-identity restatement mechanism,
        // IKE-Network/ike-issues#892). Field order verified against DataTypeDefaultsSet.

        set.concept("Author").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("a2892585-1d62-4ea6-9cd5-f93cbf4a37a9")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The concept identifying who committed a version — the author"
                                + " dimension of a STAMP, and the root of the value space an"
                                + " author field's concept is drawn from; distinct from Author"
                                + " for version, which names why the field is recorded.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Module").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("10933c80-b2cc-4569-8d23-b4d512e6459e")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The concept identifying the export or authoring boundary a"
                                + " version belongs to — the module dimension of a STAMP, and"
                                + " the root of the value space a module field's concept is"
                                + " drawn from; distinct from Module for version, which names"
                                + " why the field is recorded.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Path concept (SOLOR)").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("e371f3da-583a-48f2-b91b-7a15da88ba07")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "A concept that is itself a version-control path — the concept"
                                + " kind a path is represented by. As the Path origins"
                                + " pattern's first field meaning it names the field holding"
                                + " the origin path a path branched from.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Module origins (SOLOR)").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("899291eb-daea-40c6-8f5f-6f939d0d5a47")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The origin-set value a Module origins pattern semantic carries:"
                                + " the set of modules a module originated from — what the"
                                + " pattern's one field holds, distinct from Originated"
                                + " Module, the module whose origins are declared.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Path origins (SOLOR)").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("8218d3af-ef97-4717-8f68-2bc3ed36c335")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "A path's own origin record — the path-coordinate property saying"
                                + " where a path branched from. As the Path origins pattern's"
                                + " second field meaning it names the origin instant that"
                                + " record fixes: the branch point up to which the origin"
                                + " path's versions are visible.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Version Properties (SOLOR)").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("834597b6-cc91-4b1a-af82-f5f210d92959")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "What a STAMP pattern semantic means: the five-dimension"
                                + " provenance tuple of a version — status, time, author,"
                                + " module, and path together, as one value; the properties"
                                + " every version carries, rather than any single dimension"
                                + " alone.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Membership semantic (SOLOR)").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("ad8203ec-3758-4011-9d6b-2540e67cf971")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The semantic type carrying no fields: a semantic whose entire"
                                + " content is that its referenced component belongs to the"
                                + " pattern's own set. The SOLOR-era name for what this"
                                + " starter set's own content now calls Set membership.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        // ── Terminology-rule revisions (IKE-Network/ike-issues#893) ─────
        // Two established definition descriptions use "vocabulary"; the one-rigorous-term
        // rule says terminology. Same restatement mechanism as the echoes above.
        set.concept("Model concept").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("3e65ef28-f915-4773-beb5-a068361499b3")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "A concept representing a model construct within Integrated"
                                + " Knowledge Management — the structural and data-type"
                                + " terminology a knowledge base uses to describe itself, as"
                                + " distinct from the domain content it represents.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Tinkar Model concept").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("06d1eb76-87b4-440a-98c1-d0037f76a936")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "Root of Tinkar's own meta-schema terminology: the concepts Tinkar"
                                + " uses to describe its data model itself — components,"
                                + " descriptions, dialects, fields, and axioms — rather than"
                                + " any modeled domain.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("EL++ Stated terminological axioms").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("03f08d3b-f7e9-4feb-87f0-f9e5620ed277")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The stated side of a concept's EL++ terminological axioms: the"
                                + " definitional axioms an author actually wrote — necessary"
                                + " and sufficient sets, role restrictions — as distinct from"
                                + " what a classifier later infers. The EL++ Stated Axioms"
                                + " Pattern's one field carries them as a directed tree.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("EL++ Inferred terminological axioms").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("f85df6dd-2c5c-4d11-bc0c-a145a042fa32")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The inferred side of a concept's EL++ terminological axioms: the"
                                + " definitional axioms a classifier concluded follow from"
                                + " what was stated — computed, never hand-written. The EL++"
                                + " Inferred Axioms Pattern's one field carries them as a"
                                + " directed tree.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        // The garbled inherited definition ("List of fields-  semantic") on the Semantic
        // data type concept — not a meaning/purpose concept, but the same defect class,
        // fixed the same way (IKE-Network/ike-issues#892). The concept's FQN was already
        // revised to "Semantic data type" by DataTypeDefaultsSet; this aligns its
        // definition with that name and with its ConceptToDataType role.
        set.concept("Semantic display field type (SOLOR)").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("284f4bfa-5d38-4a7a-bcab-9df6710bcc94")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "A field that holds a reference to a semantic.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        // ── The "Sementic" FQN typo ─────────────────────────────────────
        // The pattern's descriptions were declared with their established identities in
        // foundation.Section71, so reviseFullyQualifiedName is unavailable by design
        // (the builder directs explicit-description components to restate the
        // established semantic instead). Both established FQN descriptions carry the
        // typo; both are revised to the corrected text. The registry key stays the
        // birth FQN, "Sementic version field pattern".
        set.pattern("Sementic version field pattern").at(completion)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("d47fdb46-8ce0-4405-943a-b2420c7480f8")),
                        IkeTerm.ENGLISH_LANGUAGE, "Semantic version field pattern",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("2caeaa6d-865c-4e61-8d48-c003487ee067")),
                        IkeTerm.ENGLISH_LANGUAGE, "Semantic version field pattern",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);
    }
}
