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
import dev.ikm.tinkar.terms.EntityProxy;

import java.util.UUID;

/**
 * Refines an already-adopted pattern's own declared shape (meaning, purpose, field
 * definitions) where the SOLOR/Tinkar-inherited version collapses meaning and purpose
 * into the same concept — a real modeling weakness KEC flagged reviewing the rendered
 * pattern-shape table (IKE-Network/ike-issues#880): reusing one concept for both loses
 * the distinction Tinkar's own model intends — meaning names what kind of thing this is,
 * purpose names why it is captured. Each pattern here is resumed by its already-adopted
 * identity ({@code foundation.Section71}'s own birth FQN, not hand-edited — that class
 * is regeneration-locked) and given a new {@code PatternVersion} layered on top via the
 * append-only ledger ({@code PatternBuilder}'s versioning model restates meaning,
 * purpose, and fields as a whole on each new version): the original SOLOR-sourced
 * version stays in history untouched; a {@code StampCoordinate} positioned after this
 * file's stamp resolves this revision instead.
 * <p>
 * Comment pattern was the pilot; KEC then asked for the same treatment across every
 * other pattern in the starter set, including the base Tinkar meta-model (chronicle and
 * version shapes) rather than only IKE's own domain-facing patterns. Two economies keep
 * the concept count down without sacrificing rigor: (1) patterns sharing an identical
 * structural shape (five chronicle-shape patterns, five version-shape patterns, two
 * navigation patterns) share ONE purpose concept for that shape, rather than minting a
 * near-duplicate per pattern; (2) several fields reuse concepts this starter set
 * <em>already has</em> — {@code Author}/{@code Module}/{@code Path} as meaning
 * (mirroring how {@code StatusValue} already correctly differs from
 * {@code StatusForVersion}), and {@code AuthorForVersion}/{@code ModuleForVersion}/
 * {@code PathForVersion}/{@code TimeForVersion}/{@code StatusForVersion} as purpose —
 * both families were already present, just never paired against a distinct meaning.
 *
 * <h2>Comment pattern</h2>
 * The SOLOR-inherited version sets meaning = purpose = {@code Comment} for both the
 * pattern's own referenced component and its single field — four slots, one concept.
 * That conflates two genuinely different things: "a field that holds a comment" (a
 * content-type classification — {@code Comment} is the correct meaning for the *field*)
 * versus "a pattern that enables commenting" (a role the *referenced component* plays —
 * it isn't itself a comment, it's the subject commentary is attached to). This revision:
 * <ul>
 *   <li>referenced-component meaning → {@code Subject of Commentary} (new) — the
 *   referenced component's role: the subject this pattern's commentary is about</li>
 *   <li>referenced-component purpose → {@code Editorial Clarification} (new) — why the
 *   commentary exists: explaining an authoring decision or providing context a formal
 *   field cannot capture, for a future reviewer or maintainer</li>
 *   <li>field meaning → {@code Comment} (unchanged — correctly names the field's own
 *   content type)</li>
 *   <li>field purpose → {@code Editorial Clarification} (the same concept as above,
 *   reused — the field's value serves the same functional role as the pattern as a
 *   whole)</li>
 * </ul>
 */
final class PatternShapeRefinementSet {

    private PatternShapeRefinementSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // Later than every other authoring pass in this project (2026-07-12/-13/-15):
        // this file revises already-adopted patterns, so it must follow every scope that
        // already touches them.
        ActiveStamp refinement = Stamp.active("2026-07-16T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        set.concept("Subject of Commentary (IkeFoundation)").at(refinement)
                .synonym("Subject of Commentary")
                .definition("The referenced-component role a Comment Pattern semantic's"
                        + " attachment target plays: the subject free-text commentary is"
                        + " about — distinct from Comment, which names the commentary's"
                        + " own content type, not the component being commented on.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Editorial Clarification (IkeFoundation)").at(refinement)
                .synonym("Editorial Clarification")
                .definition("Why a free-text comment is captured: to explain an authoring"
                        + " decision or provide context a formal field cannot, for a future"
                        + " reviewer or maintainer.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Comment pattern").at(refinement)
                .meaning(set.conceptRef("Subject of Commentary (IkeFoundation)"))
                .purpose(set.conceptRef("Editorial Clarification (IkeFoundation)"))
                .field(IkeTerm.COMMENT, set.conceptRef("Editorial Clarification (IkeFoundation)"), IkeTerm.STRING);

        // ── Navigation: Inferred/Stated Navigation Pattern ──────────────
        // Both share one identical shape (meaning = purpose = IsA); fields are already
        // fine (RelationshipDestination/RelationshipOrigin each differ from IsA).
        set.concept("Taxonomy Navigation Cache (IkeFoundation)").at(refinement)
                .synonym("Taxonomy Navigation Cache")
                .definition("Why a navigation pattern's referenced component carries an IsA"
                        + " semantic: a pre-computed parent/child structure so traversal"
                        + " doesn't require re-deriving from axioms every time.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Inferred Navigation Pattern").at(refinement)
                .meaning(IkeTerm.IS_A)
                .purpose(set.conceptRef("Taxonomy Navigation Cache (IkeFoundation)"))
                .field(IkeTerm.RELATIONSHIP_DESTINATION, IkeTerm.IS_A, IkeTerm.COMPONENT_ID_SET_FIELD)
                .field(IkeTerm.RELATIONSHIP_ORIGIN, IkeTerm.IS_A, IkeTerm.COMPONENT_ID_SET_FIELD);

        set.pattern("Stated Navigation Pattern").at(refinement)
                .meaning(IkeTerm.IS_A)
                .purpose(set.conceptRef("Taxonomy Navigation Cache (IkeFoundation)"))
                .field(IkeTerm.RELATIONSHIP_DESTINATION, IkeTerm.IS_A, IkeTerm.COMPONENT_ID_SET_FIELD)
                .field(IkeTerm.RELATIONSHIP_ORIGIN, IkeTerm.IS_A, IkeTerm.COMPONENT_ID_SET_FIELD);

        // ── Base Tinkar meta-model: chronicle-shape family ──────────────
        // Component/Concept/Pattern/STAMP/Semantic Chronology Pattern all specialize one
        // shape: a referenced-component meaning naming which component kind (already
        // accurate — ComponentField, ConceptField, ... — left unchanged), a public ID
        // field, and a versions field/set pair. One shared purpose concept covers why
        // every one of these chronicle-shape patterns exists.
        set.concept("Chronicle Identity and History (IkeFoundation)").at(refinement)
                .synonym("Chronicle Identity and History")
                .definition("Why a chronicle-shape pattern's referenced component carries"
                        + " this semantic: to record that component's own identity"
                        + " (public id) alongside its complete version history.")
                .isA(IkeTerm.MODEL_CONCEPT);

        EntityProxy.Concept publicIdField = EntityProxy.Concept.make("Public ID field",
                PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f")));
        EntityProxy.Concept uniquelyIdentify = EntityProxy.Concept.make("Uniquely identify knowledge graph components",
                PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b")));
        EntityProxy.Concept chronicleIdentityAndHistory = set.conceptRef("Chronicle Identity and History (IkeFoundation)");

        set.pattern("Component Chronology Pattern").at(refinement)
                .meaning(EntityProxy.Concept.make("Component field",
                        PublicIds.of(UUID.fromString("8bd36a0c-d05d-46b7-a79a-d11477705cc1"))))
                .purpose(chronicleIdentityAndHistory)
                .field(publicIdField, uniquelyIdentify, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Component versions field",
                                PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c"))),
                        EntityProxy.Concept.make("Component versions set",
                                PublicIds.of(UUID.fromString("54d670f1-234d-485a-a354-e1fa7eea1bf2"))),
                        IkeTerm.COMPONENT_ID_SET_FIELD);

        set.pattern("Concept field pattern").at(refinement)
                .meaning(EntityProxy.Concept.make("Concept field",
                        PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e"))))
                .purpose(chronicleIdentityAndHistory)
                .field(publicIdField, uniquelyIdentify, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Concept versions field",
                                PublicIds.of(UUID.fromString("3a08b5f1-f17e-4db5-8cf9-c6540f26f241"))),
                        EntityProxy.Concept.make("Concept versions set",
                                PublicIds.of(UUID.fromString("806c7f9f-52f9-4b53-9758-122899b28a76"))),
                        IkeTerm.COMPONENT_ID_SET_FIELD);

        set.pattern("Pattern Chronology Pattern").at(refinement)
                .meaning(EntityProxy.Concept.make("Pattern field",
                        PublicIds.of(UUID.fromString("751790c7-e1e4-42bc-b531-54c54bd6eebd"))))
                .purpose(chronicleIdentityAndHistory)
                .field(publicIdField, uniquelyIdentify, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Pattern versions field",
                                PublicIds.of(UUID.fromString("7b8ecbbf-55b4-41bc-acbf-51824e74446a"))),
                        EntityProxy.Concept.make("Pattern versions set",
                                PublicIds.of(UUID.fromString("a254ccee-ef02-4504-9645-0a2ed7af955d"))),
                        IkeTerm.COMPONENT_ID_SET_FIELD);

        EntityProxy.Concept stampField = EntityProxy.Concept.make("STAMP field",
                PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6")));

        set.pattern("STAMP Chronology Pattern").at(refinement)
                .meaning(stampField)
                .purpose(chronicleIdentityAndHistory)
                .field(publicIdField, uniquelyIdentify, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("STAMP versions field",
                                PublicIds.of(UUID.fromString("b8251bea-4248-4a46-8b4a-349500693a9f"))),
                        EntityProxy.Concept.make("STAMP versions set",
                                PublicIds.of(UUID.fromString("edb90567-7822-4129-a406-b359b825f922"))),
                        IkeTerm.COMPONENT_ID_SET_FIELD);

        set.concept("Pattern Membership (IkeFoundation)").at(refinement)
                .synonym("Pattern Membership")
                .definition("Why a Semantic Chronology Pattern's Semantic pattern field is"
                        + " recorded: to identify which pattern this semantic is an"
                        + " instance of.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Attachment Target (IkeFoundation)").at(refinement)
                .synonym("Attachment Target")
                .definition("Why a Semantic Chronology Pattern's Semantic referenced"
                        + " component field is recorded: to identify what component this"
                        + " semantic is attached to.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Version History (IkeFoundation)").at(refinement)
                .synonym("Version History")
                .definition("Why a Semantic Chronology Pattern's Semantic versions set is"
                        + " recorded: to hold every version of this semantic, in order —"
                        + " the semantic-level counterpart to the versions-field/set pair"
                        + " every other chronicle-shape pattern already names distinctly.")
                .isA(IkeTerm.MODEL_CONCEPT);

        EntityProxy.Concept semanticPatternField = EntityProxy.Concept.make("Semantic pattern field",
                PublicIds.of(UUID.fromString("19dd5dd3-1075-4113-a437-5f1f7c2d55bc")));
        EntityProxy.Concept semanticReferencedComponentField = EntityProxy.Concept.make(
                "Semantic referenced component field",
                PublicIds.of(UUID.fromString("4111ba1e-c818-4c5d-9fed-34d07298d009")));
        EntityProxy.Concept semanticVersionsSet = EntityProxy.Concept.make("Semantic versions set",
                PublicIds.of(UUID.fromString("4fd69aed-556f-4938-94cc-ea7ea707ccef")));

        set.pattern("Semantic Chronology Pattern").at(refinement)
                .meaning(EntityProxy.Concept.make("Semantic field",
                        PublicIds.of(UUID.fromString("8b6c69d7-a5aa-4db2-bcea-8c7b2817b02f"))))
                .purpose(chronicleIdentityAndHistory)
                .field(publicIdField, uniquelyIdentify, IkeTerm.COMPONENT_FIELD)
                .field(semanticPatternField, set.conceptRef("Pattern Membership (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(semanticReferencedComponentField, set.conceptRef("Attachment Target (IkeFoundation)"),
                        IkeTerm.COMPONENT_FIELD)
                .field(semanticVersionsSet, set.conceptRef("Version History (IkeFoundation)"), IkeTerm.COMPONENT_ID_SET_FIELD);

        // ── Base Tinkar meta-model: version-shape family ────────────────
        // Component/Concept/Semantic/STAMP/Pattern Version Pattern all specialize one
        // shape: a referenced-component meaning naming which versions-field kind
        // (already accurate, left unchanged), plus a self-collapsed STAMP field every
        // one of them repeats. Two shared purpose concepts cover the whole family.
        set.concept("Version Snapshot (IkeFoundation)").at(refinement)
                .synonym("Version Snapshot")
                .definition("Why a version-shape pattern's referenced component carries"
                        + " this semantic: to record one point-in-time state of a"
                        + " chronicle — the STAMP it was committed with, plus whatever"
                        + " field values were true then.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Version Provenance (IkeFoundation)").at(refinement)
                .synonym("Version Provenance")
                .definition("Why a version-shape pattern's own STAMP field is recorded: to"
                        + " say who committed this version, in what state, module, path,"
                        + " and when.")
                .isA(IkeTerm.MODEL_CONCEPT);

        EntityProxy.Concept versionSnapshot = set.conceptRef("Version Snapshot (IkeFoundation)");
        EntityProxy.Concept versionProvenance = set.conceptRef("Version Provenance (IkeFoundation)");

        set.pattern("Component Version Pattern").at(refinement)
                .meaning(EntityProxy.Concept.make("Component versions field",
                        PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c"))))
                .purpose(versionSnapshot)
                .field(stampField, versionProvenance, IkeTerm.COMPONENT_FIELD);

        set.pattern("Concept Version Pattern").at(refinement)
                .meaning(EntityProxy.Concept.make("Concept versions field",
                        PublicIds.of(UUID.fromString("3a08b5f1-f17e-4db5-8cf9-c6540f26f241"))))
                .purpose(versionSnapshot)
                .field(stampField, versionProvenance, IkeTerm.COMPONENT_FIELD);

        set.pattern("Sementic version field pattern").at(refinement)
                .meaning(EntityProxy.Concept.make("Semantic versions field",
                        PublicIds.of(UUID.fromString("aeb73410-a679-4ea8-93fe-7c4785599778"))))
                .purpose(versionSnapshot)
                .field(stampField, versionProvenance, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Semantic field field",
                                PublicIds.of(UUID.fromString("f6572c76-b5c0-41da-99c0-4344694e7e3c"))),
                        EntityProxy.Concept.make("Semantic field fields set",
                                PublicIds.of(UUID.fromString("8dcfc1a1-31f2-46f7-8247-0a17a6d7c6c0"))),
                        IkeTerm.COMPONENT_ID_SET_FIELD);

        set.pattern("STAMP version field pattern").at(refinement)
                .meaning(EntityProxy.Concept.make("STAMP versions field",
                        PublicIds.of(UUID.fromString("b8251bea-4248-4a46-8b4a-349500693a9f"))))
                .purpose(versionSnapshot)
                .field(stampField, versionProvenance, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Status field",
                                PublicIds.of(UUID.fromString("f2c79ebb-3095-44ea-831f-992aed48801f"))),
                        IkeTerm.STATUS_FOR_VERSION, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Time field",
                                PublicIds.of(UUID.fromString("15293325-c16b-4f2e-8109-5b22b3355bcd"))),
                        IkeTerm.TIME_FOR_VERSION, IkeTerm.STRING)
                .field(EntityProxy.Concept.make("Author field",
                                PublicIds.of(UUID.fromString("a9210ad6-cc48-47df-86e5-2192d56704a6"))),
                        IkeTerm.AUTHOR_FOR_VERSION, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Module field",
                                PublicIds.of(UUID.fromString("e6359a86-a1df-4721-8a1a-1f1f075ec3d9"))),
                        IkeTerm.MODULE_FOR_VERSION, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Path field",
                                PublicIds.of(UUID.fromString("6622a391-e2e6-45a0-97e1-c58cd0184092"))),
                        IkeTerm.PATH_FOR_VERSION, IkeTerm.COMPONENT_FIELD);

        set.concept("Meaning Declaration (IkeFoundation)").at(refinement)
                .synonym("Meaning Declaration")
                .definition("Why a Pattern Version Pattern's Pattern meaning field is"
                        + " recorded: to hold this pattern-version's own declared meaning"
                        + " concept.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Purpose Declaration (IkeFoundation)").at(refinement)
                .synonym("Purpose Declaration")
                .definition("Why a Pattern Version Pattern's Pattern purpose field is"
                        + " recorded: to hold this pattern-version's own declared purpose"
                        + " concept.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Pattern Version Pattern").at(refinement)
                .meaning(EntityProxy.Concept.make("Pattern versions field",
                        PublicIds.of(UUID.fromString("7b8ecbbf-55b4-41bc-acbf-51824e74446a"))))
                .purpose(versionSnapshot)
                .field(stampField, versionProvenance, IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Pattern meaning field",
                                PublicIds.of(UUID.fromString("996d0023-a355-422f-a84d-16dda6ece1b0"))),
                        set.conceptRef("Meaning Declaration (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Pattern purpose field",
                                PublicIds.of(UUID.fromString("352c821b-7a11-454c-a127-48ad3206573d"))),
                        set.conceptRef("Purpose Declaration (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(EntityProxy.Concept.make("Field definition field",
                                PublicIds.of(UUID.fromString("14171f07-e74f-409a-b555-06b478818f76"))),
                        EntityProxy.Concept.make("Field definitions set",
                                PublicIds.of(UUID.fromString("975de83e-ab99-4a9e-9051-4cbf310a2123"))),
                        IkeTerm.COMPONENT_ID_SET_FIELD);

        // ── Base Tinkar meta-model: module/path origins ─────────────────
        set.concept("Module Lineage (IkeFoundation)").at(refinement)
                .synonym("Module Lineage")
                .definition("Why a module's own origin record is captured: to track which"
                        + " modules a given module originated from.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Module origins pattern (SOLOR)").at(refinement)
                .meaning(IkeTerm.MODULE_ORIGINS)
                .purpose(set.conceptRef("Module Lineage (IkeFoundation)"))
                .field(IkeTerm.MODULE_ORIGINS, set.conceptRef("Module Lineage (IkeFoundation)"),
                        IkeTerm.COMPONENT_ID_SET_FIELD);

        set.concept("Path Lineage (IkeFoundation)").at(refinement)
                .synonym("Path Lineage")
                .definition("Why a path's own origin record is captured: to track which"
                        + " path it branched from, and when.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Origin Subject (IkeFoundation)").at(refinement)
                .synonym("Origin Subject")
                .definition("Why a Path origins pattern's Path concept field is recorded:"
                        + " to say which path this origin record is about.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Path origins pattern (SOLOR)").at(refinement)
                .meaning(IkeTerm.PATH_ORIGINS)
                .purpose(set.conceptRef("Path Lineage (IkeFoundation)"))
                .field(IkeTerm.PATH_CONCEPT, set.conceptRef("Origin Subject (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(IkeTerm.PATH_ORIGINS, set.conceptRef("Path Lineage (IkeFoundation)"), IkeTerm.INSTANT_LITERAL);

        // ── STAMP pattern (domain) ───────────────────────────────────────
        // Status was already correct (StatusValue meaning / StatusForVersion purpose).
        // Author/Module/Path get a nearly-free fix: Author/Module/Path already exist as
        // general concepts distinct from AuthorForVersion/ModuleForVersion/
        // PathForVersion, mirroring Status exactly. Time has no general counterpart yet,
        // so it alone needs one new meaning concept.
        set.concept("Time (IkeFoundation)").at(refinement)
                .synonym("Time")
                .definition("A point in time, as a general concept — the meaning"
                        + " counterpart to Status value/Author/Module/Path: what kind of"
                        + " value a STAMP's time field holds, distinct from"
                        + " TimeForVersion, which names why it is recorded.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Commit Provenance (IkeFoundation)").at(refinement)
                .synonym("Commit Provenance")
                .definition("Why a STAMP pattern semantic exists: to record who committed"
                        + " a version, in what state, module, path, and when.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("STAMP pattern").at(refinement)
                .meaning(IkeTerm.VERSION_PROPERTIES)
                .purpose(set.conceptRef("Commit Provenance (IkeFoundation)"))
                .field(IkeTerm.STATUS_VALUE, IkeTerm.STATUS_FOR_VERSION, IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Time (IkeFoundation)"), IkeTerm.TIME_FOR_VERSION, IkeTerm.LONG)
                .field(set.conceptRef("Author"), IkeTerm.AUTHOR_FOR_VERSION, IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Module"), IkeTerm.MODULE_FOR_VERSION, IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Path"), IkeTerm.PATH_FOR_VERSION, IkeTerm.COMPONENT_FIELD);

        // ── Description Pattern (domain) ────────────────────────────────
        // Language/Text fields were already correct (their meaning/purpose already
        // differ). CaseSignificance and DescriptionType were each self-collapsed.
        set.concept("Description Attachment (IkeFoundation)").at(refinement)
                .synonym("Description Attachment")
                .definition("Why a Description Pattern semantic exists: to attach a"
                        + " human-readable name or definition to a concept.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Case Sensitivity Rule (IkeFoundation)").at(refinement)
                .synonym("Case Sensitivity Rule")
                .definition("Why a description's case significance value is recorded: to"
                        + " say whether the description's text is case-sensitive.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Description Role (IkeFoundation)").at(refinement)
                .synonym("Description Role")
                .definition("Why a description's type value is recorded: to say which of"
                        + " the three description roles — fully qualified name, regular"
                        + " name, or definition — this description plays.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Description Pattern").at(refinement)
                .meaning(IkeTerm.DESCRIPTION_SEMANTIC)
                .purpose(set.conceptRef("Description Attachment (IkeFoundation)"))
                .field(IkeTerm.LANGUAGE_CONCEPT_NID_FOR_DESCRIPTION, IkeTerm.LANGUAGE, IkeTerm.COMPONENT_FIELD)
                .field(IkeTerm.TEXT_FOR_DESCRIPTION, IkeTerm.DESCRIPTION, IkeTerm.STRING)
                .field(IkeTerm.DESCRIPTION_CASE_SIGNIFICANCE, set.conceptRef("Case Sensitivity Rule (IkeFoundation)"),
                        IkeTerm.COMPONENT_FIELD)
                .field(IkeTerm.DESCRIPTION_TYPE, set.conceptRef("Description Role (IkeFoundation)"), IkeTerm.COMPONENT_FIELD);

        // ── Identifier Pattern (domain) ──────────────────────────────────
        set.concept("External Identity Mapping (IkeFoundation)").at(refinement)
                .synonym("External Identity Mapping")
                .definition("Why an Identifier Pattern semantic exists: to record an"
                        + " alternate identifier a component carries in an external"
                        + " terminology's own identifier scheme.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Identifier Authority (IkeFoundation)").at(refinement)
                .synonym("Identifier Authority")
                .definition("Why an identifier source value is recorded: to say which"
                        + " identifier-issuing authority the identifier came from.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Identifier Text (IkeFoundation)").at(refinement)
                .synonym("Identifier Text")
                .definition("Why an identifier value is recorded: to hold the identifier's"
                        + " own literal text, once a source has been chosen.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Identifier Pattern").at(refinement)
                .meaning(IkeTerm.IDENTIFIER_SOURCE)
                .purpose(set.conceptRef("External Identity Mapping (IkeFoundation)"))
                .field(IkeTerm.IDENTIFIER_SOURCE, set.conceptRef("Identifier Authority (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(IkeTerm.IDENTIFIER_VALUE, set.conceptRef("Identifier Text (IkeFoundation)"), IkeTerm.STRING);

        // ── Value Constraint Pattern (domain) ────────────────────────────
        // Min/max operator and reference-range fields were already correct (their
        // meaning/purpose already differ). ValueConstraintSource and ExampleUCUMUnits
        // were each self-collapsed.
        set.concept("Numeric Value Restriction (IkeFoundation)").at(refinement)
                .synonym("Numeric Value Restriction")
                .definition("Why a Value Constraint Pattern semantic exists: to restrict"
                        + " which literal values are legal for a component — the"
                        + " numeric-domain counterpart to Field Value Restriction.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Reference Range Authority (IkeFoundation)").at(refinement)
                .synonym("Reference Range Authority")
                .definition("Why a value constraint's source value is recorded: to name"
                        + " the organization that specifies the constraint.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Unit Example (IkeFoundation)").at(refinement)
                .synonym("Unit Example")
                .definition("Why example UCUM units are recorded on a value constraint: to"
                        + " show a representative unit of measure for the constrained"
                        + " value, for a reader's reference.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Value Constraint Pattern").at(refinement)
                .meaning(IkeTerm.VALUE_CONSTRAINT)
                .purpose(set.conceptRef("Numeric Value Restriction (IkeFoundation)"))
                .field(IkeTerm.VALUE_CONSTRAINT_SOURCE, set.conceptRef("Reference Range Authority (IkeFoundation)"),
                        IkeTerm.CONCEPT_FIELD)
                .field(IkeTerm.MINIMUM_VALUE_OPERATOR, IkeTerm.CONCRETE_DOMAIN_OPERATOR, IkeTerm.CONCEPT_FIELD)
                .field(IkeTerm.REFERENCE_RANGE_MINIMUM, IkeTerm.REFERENCE_RANGE, IkeTerm.FLOAT_FIELD)
                .field(IkeTerm.MAXIMUM_VALUE_OPERATOR, IkeTerm.CONCRETE_DOMAIN_OPERATOR, IkeTerm.COMPONENT_FIELD)
                .field(IkeTerm.REFERENCE_RANGE_MAXIMUM, IkeTerm.REFERENCE_RANGE, IkeTerm.FLOAT_FIELD)
                .field(IkeTerm.EXAMPLE_UCUM_UNITS, set.conceptRef("Unit Example (IkeFoundation)"), IkeTerm.STRING);
    }
}
