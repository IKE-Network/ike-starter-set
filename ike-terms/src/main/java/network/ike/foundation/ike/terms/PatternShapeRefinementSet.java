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
 * Mints the meaning/purpose concepts the corrected pattern shapes in
 * {@code foundation.Section71} reference: the SOLOR/Tinkar-inherited baseline collapsed
 * meaning and purpose into one concept for many patterns — a real modeling weakness KEC
 * flagged reviewing the rendered pattern-shape table (IKE-Network/ike-issues#880):
 * meaning names what kind of thing this is, purpose names why it is captured. Under the
 * inception flatten (IKE-Network/ike-issues#894) each corrected shape is the pattern's
 * <em>single</em> declared version, written in place at its section declaration; this
 * file contributes only the fresh concepts those shapes cite by derived identity
 * ({@code conceptRef} resolves the derivation, so section order is immaterial).
 * <p>
 * Two economies keep the concept count down without sacrificing rigor: (1) patterns
 * sharing an identical structural shape (five chronicle-shape patterns, five
 * version-shape patterns, two navigation patterns) share ONE purpose concept for that
 * shape, rather than minting a near-duplicate per pattern; (2) several shapes reuse
 * concepts this starter set <em>already has</em> — {@code Author}/{@code Module}/
 * {@code Path} as meaning (mirroring how {@code StatusValue} already correctly differs
 * from {@code StatusForVersion}), and {@code AuthorForVersion}/{@code ModuleForVersion}/
 * {@code PathForVersion}/{@code TimeForVersion}/{@code StatusForVersion} as purpose —
 * both families were already present, just never paired against a distinct meaning.
 * The IKE-Network/ike-issues#891 Model-Feature pointer fixes (a pattern's
 * referenced-component meaning must differ from every field meaning) contribute the
 * Originated Module/Path, Branch, Identified Component, and Axiom concepts.
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
        // The one declared inception stamp of the pre-release set
        // (IKE-Network/ike-issues#894).
        ActiveStamp inception = Ike.INCEPTION;

        // ── Comment pattern ─────────────────────────────────────────────
        set.concept("Subject of Commentary (IkeFoundation)").at(inception)
                .synonym("Subject of Commentary")
                .definition("The referenced-component role a Comment Pattern semantic's"
                        + " attachment target plays: the subject free-text commentary is"
                        + " about — distinct from Comment, which names the commentary's"
                        + " own content type, not the component being commented on.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"));

        set.concept("Editorial Clarification (IkeFoundation)").at(inception)
                .synonym("Editorial Clarification")
                .definition("Why a free-text comment is captured: to explain an authoring"
                        + " decision or provide context a formal field cannot, for a future"
                        + " reviewer or maintainer.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"));

        // ── Navigation: Inferred/Stated Navigation Pattern ──────────────
        // Both share one identical shape (meaning = IsA), so one purpose concept serves
        // both.
        set.concept("Taxonomy Navigation Cache (IkeFoundation)").at(inception)
                .synonym("Taxonomy Navigation Cache")
                .definition("Why a navigation pattern's referenced component carries an IsA"
                        + " semantic: a pre-computed parent/child structure so traversal"
                        + " doesn't require re-deriving from axioms every time.")
                .isA(set.conceptRef("Graph model (IkeFoundation)"));

        // ── Base Tinkar meta-model: chronicle-shape family ──────────────
        // One shared purpose concept covers why every chronicle-shape pattern exists.
        set.concept("Chronicle Identity and History (IkeFoundation)").at(inception)
                .synonym("Chronicle Identity and History")
                .definition("Why a chronicle-shape pattern's referenced component carries"
                        + " this semantic: to record that component's own identity"
                        + " (public id) alongside its complete version history.")
                .isA(set.conceptRef("Chronicle and version model (IkeFoundation)"));

        set.concept("Pattern Membership (IkeFoundation)").at(inception)
                .synonym("Pattern Membership")
                .definition("Why a Semantic Chronology Pattern's Semantic pattern field is"
                        + " recorded: to identify which pattern this semantic is an"
                        + " instance of.")
                .isA(set.conceptRef("Chronicle and version model (IkeFoundation)"));

        set.concept("Attachment Target (IkeFoundation)").at(inception)
                .synonym("Attachment Target")
                .definition("Why a Semantic Chronology Pattern's Semantic referenced"
                        + " component field is recorded: to identify what component this"
                        + " semantic is attached to.")
                .isA(set.conceptRef("Chronicle and version model (IkeFoundation)"));

        set.concept("Version History (IkeFoundation)").at(inception)
                .synonym("Version History")
                .definition("Why a Semantic Chronology Pattern's Semantic versions set is"
                        + " recorded: to hold every version of this semantic, in order —"
                        + " the semantic-level counterpart to the versions-field/set pair"
                        + " every other chronicle-shape pattern already names distinctly.")
                .isA(set.conceptRef("Chronicle and version model (IkeFoundation)"));

        // ── Base Tinkar meta-model: version-shape family ────────────────
        // Two shared purpose concepts cover the whole family.
        set.concept("Version Snapshot (IkeFoundation)").at(inception)
                .synonym("Version Snapshot")
                .definition("Why a version-shape pattern's referenced component carries"
                        + " this semantic: to record one point-in-time state of a"
                        + " chronicle — the STAMP it was committed with, plus whatever"
                        + " field values were true then.")
                .isA(set.conceptRef("Chronicle and version model (IkeFoundation)"));

        set.concept("Version Provenance (IkeFoundation)").at(inception)
                .synonym("Version Provenance")
                .definition("Why a version-shape pattern's own STAMP field is recorded: to"
                        + " say who committed this version, in what state, module, path,"
                        + " and when.")
                .isA(set.conceptRef("Provenance model (IkeFoundation)"));

        set.concept("Meaning Declaration (IkeFoundation)").at(inception)
                .synonym("Meaning Declaration")
                .definition("Why a Pattern Version Pattern's Pattern meaning field is"
                        + " recorded: to hold this pattern-version's own declared meaning"
                        + " concept.")
                .isA(set.conceptRef("Chronicle and version model (IkeFoundation)"));

        set.concept("Purpose Declaration (IkeFoundation)").at(inception)
                .synonym("Purpose Declaration")
                .definition("Why a Pattern Version Pattern's Pattern purpose field is"
                        + " recorded: to hold this pattern-version's own declared purpose"
                        + " concept.")
                .isA(set.conceptRef("Chronicle and version model (IkeFoundation)"));

        // ── Base Tinkar meta-model: module/path origins ─────────────────
        // Referenced-component meanings are distinct concepts (IKE-Network/ike-issues#891
        // — the Model-Feature pointer invariant: a pattern's referenced-component meaning
        // must differ from every field meaning), and each field carries its own purpose
        // rather than repeating the pattern's.
        set.concept("Module Lineage (IkeFoundation)").at(inception)
                .synonym("Module Lineage")
                .definition("Why a module's own origin record is captured: to track which"
                        + " modules a given module originated from.")
                .isA(set.conceptRef("Provenance model (IkeFoundation)"));

        set.concept("Originated Module (IkeFoundation)").at(inception)
                .synonym("Originated Module")
                .definition("What a Module origins pattern semantic's referenced component"
                        + " is: the module whose origins are declared — the module that"
                        + " originated from the modules the semantic names, distinct from"
                        + " Module origins, which names the origin-set value itself.")
                .isA(set.conceptRef("Provenance model (IkeFoundation)"));

        set.concept("Origin Module Set (IkeFoundation)").at(inception)
                .synonym("Origin Module Set")
                .definition("Why a module's origin set value is recorded: to name the"
                        + " modules this module originated from.")
                .isA(set.conceptRef("Provenance model (IkeFoundation)"));

        set.concept("Path Lineage (IkeFoundation)").at(inception)
                .synonym("Path Lineage")
                .definition("Why a path's own origin record is captured: to track which"
                        + " path it branched from, and when.")
                .isA(set.conceptRef("Provenance model (IkeFoundation)"));

        set.concept("Originated Path (IkeFoundation)").at(inception)
                .synonym("Originated Path")
                .definition("What a Path origins pattern semantic's referenced component"
                        + " is: the path whose branch point is declared — the path that"
                        + " originated from the path the semantic names, distinct from"
                        + " Path origins, which names the origin-record value itself.")
                .isA(set.conceptRef("Provenance model (IkeFoundation)"));

        set.concept("Branch Source (IkeFoundation)").at(inception)
                .synonym("Branch Source")
                .definition("Why the origin path value is recorded: to say which path this"
                        + " path branched from. The record's subject is the referenced"
                        + " component — the originated path — never this field.")
                .isA(set.conceptRef("Provenance model (IkeFoundation)"));

        set.concept("Branch Point (IkeFoundation)").at(inception)
                .synonym("Branch Point")
                .definition("Why the origin instant is recorded: to fix the moment this"
                        + " path branched from its origin — the point up to which the"
                        + " origin path's versions are visible from this path.")
                .isA(set.conceptRef("Provenance model (IkeFoundation)"));

        // ── STAMP pattern (domain) ───────────────────────────────────────
        // Status was already correct (StatusValue meaning / StatusForVersion purpose).
        // Author/Module/Path reuse existing general concepts as meanings. Time has no
        // general counterpart, so it alone needs one new meaning concept.
        set.concept("Time (IkeFoundation)").at(inception)
                .synonym("Time")
                .definition("A point in time, as a general concept — the meaning"
                        + " counterpart to Status value/Author/Module/Path: what kind of"
                        + " value a STAMP's time field holds, distinct from"
                        + " TimeForVersion, which names why it is recorded.")
                .isA(set.conceptRef("STAMP dimensions (IkeFoundation)"));

        set.concept("Commit Provenance (IkeFoundation)").at(inception)
                .synonym("Commit Provenance")
                .definition("Why a STAMP pattern semantic exists: to record who committed"
                        + " a version, in what state, module, path, and when.")
                .isA(set.conceptRef("Provenance model (IkeFoundation)"));

        // ── Description Pattern (domain) ────────────────────────────────
        set.concept("Description Attachment (IkeFoundation)").at(inception)
                .synonym("Description Attachment")
                .definition("Why a Description Pattern semantic exists: to attach a"
                        + " human-readable name or definition to a concept.")
                .isA(set.conceptRef("Description model (IkeFoundation)"));

        set.concept("Case Sensitivity Rule (IkeFoundation)").at(inception)
                .synonym("Case Sensitivity Rule")
                .definition("Why a description's case significance value is recorded: to"
                        + " say whether the description's text is case-sensitive.")
                .isA(set.conceptRef("Description model (IkeFoundation)"));

        set.concept("Description Role (IkeFoundation)").at(inception)
                .synonym("Description Role")
                .definition("Why a description's type value is recorded: to say which of"
                        + " the three description roles — fully qualified name, regular"
                        + " name, or definition — this description plays.")
                .isA(set.conceptRef("Description model (IkeFoundation)"));

        // ── Identifier Pattern (domain) ──────────────────────────────────
        set.concept("External Identity Mapping (IkeFoundation)").at(inception)
                .synonym("External Identity Mapping")
                .definition("Why an Identifier Pattern semantic exists: to record an"
                        + " alternate identifier a component carries in an external"
                        + " terminology's own identifier scheme.")
                .isA(set.conceptRef("Identifier model (IkeFoundation)"));

        set.concept("Identifier Authority (IkeFoundation)").at(inception)
                .synonym("Identifier Authority")
                .definition("Why an identifier source value is recorded: to say which"
                        + " identifier-issuing authority the identifier came from.")
                .isA(set.conceptRef("Identifier model (IkeFoundation)"));

        set.concept("Identifier Text (IkeFoundation)").at(inception)
                .synonym("Identifier Text")
                .definition("Why an identifier value is recorded: to hold the identifier's"
                        + " own literal text, once a source has been chosen.")
                .isA(set.conceptRef("Identifier model (IkeFoundation)"));

        set.concept("Identified Component (IkeFoundation)").at(inception)
                .synonym("Identified Component")
                .definition("What an Identifier Pattern semantic's referenced component"
                        + " is: the component an external identifier names — the carrier"
                        + " of an alternate identity in another identifier scheme,"
                        + " distinct from Identifier source, which names the field value"
                        + " saying where that identifier came from"
                        + " (IKE-Network/ike-issues#891).")
                .isA(set.conceptRef("Identifier model (IkeFoundation)"));

        // ── OWL Axiom Syntax Pattern (domain) ────────────────────────────
        set.concept("Axiomatized Component (IkeFoundation)").at(inception)
                .synonym("Axiomatized Component")
                .definition("What an OWL Axiom Syntax Pattern semantic's referenced"
                        + " component is: the component whose definitional axioms the"
                        + " semantic expresses — distinct from Axiom syntax, which names"
                        + " the syntax text the field holds.")
                .isA(set.conceptRef("Logical expression model (IkeFoundation)"));

        set.concept("Axiom Expression (IkeFoundation)").at(inception)
                .synonym("Axiom Expression")
                .definition("Why an OWL Axiom Syntax Pattern semantic exists: to express"
                        + " a component's definitional axioms as OWL functional-syntax"
                        + " text.")
                .isA(set.conceptRef("Logical expression model (IkeFoundation)"));

        // ── Value Constraint Pattern (domain) ────────────────────────────
        set.concept("Numeric Value Restriction (IkeFoundation)").at(inception)
                .synonym("Numeric Value Restriction")
                .definition("Why a Value Constraint Pattern semantic exists: to restrict"
                        + " which literal values are legal for a component — the"
                        + " numeric-domain counterpart to Field Value Restriction.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"));

        set.concept("Reference Range Authority (IkeFoundation)").at(inception)
                .synonym("Reference Range Authority")
                .definition("Why a value constraint's source value is recorded: to name"
                        + " the organization that specifies the constraint.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"));

        set.concept("Unit Example (IkeFoundation)").at(inception)
                .synonym("Unit Example")
                .definition("Why example UCUM units are recorded on a value constraint: to"
                        + " show a representative unit of measure for the constrained"
                        + " value, for a reader's reference.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"));
    }
}
