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

/**
 * The Concept Field Constraint pattern (IKE-Network/ike-issues#880): a KB-native way to
 * constrain a concept-typed pattern field's legal values to a taxonomy-relative rule or
 * to membership in a value set, without any tinkar-core code change — the rules are
 * plain semantic data, and evaluating them is pure composition of graph-walk methods
 * ({@code kindOf}/{@code descendentsOf}/{@code childrenOf}) already present on
 * {@code NavigationCalculator}. Reading and enforcing these constraints (e.g. in Komet's
 * concept-field editor) is explicitly out of scope here — this file only mints the
 * representation and a handful of worked examples.
 * <p>
 * One shared pattern, "Concept Field Constraint Pattern", carries a {@code kind}
 * discriminator field rather than five separate patterns — fresh IKE-local identity
 * throughout (the closest existing concepts, {@code TinkarTerm.CONCEPT_CONSTRAINTS} and
 * {@code TinkarTerm.ASSEMBLAGE_FOR_CONSTRAINT}, are dead SOLOR stubs with zero live
 * references anywhere and no documented semantics of their own, so — unlike
 * {@link NarrativeContentSet}'s reuse of rich-surface's Prose element pattern — there is
 * no established meaning to confidently adopt here).
 * <p>
 * A constraint semantic attaches to the <b>pattern being constrained</b> (its
 * referencedComponent), naming which of that pattern's fields is governed (by the
 * field's own meaning concept — {@code Constrained field}), which kind of rule applies
 * ({@code Constraint kind}), and either an anchor concept (kind-of / descendant /
 * leaf-descendant / immediate-child) or a value-set pattern plus which of its fields
 * holds the actual concept (value-set membership). The store rejects null field values,
 * so every semantic populates all five fields — the three kind-specific fields not used
 * by a given kind are set to the existing {@code Blank Concept} sentinel (reused by
 * identity, not minted anew) rather than left absent.
 */
final class ConstraintPatternSet {

    private ConstraintPatternSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // Earlier than NarrativeContentSet's own stamps (2026-07-13 / -07-15): this file
        // mints the Concept Field Constraint Pattern that NarrativeContentSet's Semantic
        // Field Model chapter writes about, and also adds semantics to "STAMP pattern"/
        // "Description Pattern" — components NarrativeContentSet's original narratives also
        // touch. Ledger scopes on one component must be strictly chronological across the
        // whole session, so this file's stamp must precede every stamp that touches the
        // same shared components.
        ActiveStamp inception = Stamp.active("2026-07-12T12:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        // ── Field constraint kind + its 5 values ────────────────────────
        set.concept("Field constraint kind (IkeFoundation)").at(inception)
                .synonym("Field constraint kind")
                .definition("The kind of membership rule a Concept Field Constraint Pattern"
                        + " semantic expresses: which concepts are legal values for the"
                        + " constrained pattern field.")
                .isA(IkeTerm.MODEL_CONCEPT);
        EntityProxy.Concept fieldConstraintKind = set.conceptRef("Field constraint kind (IkeFoundation)");

        set.concept("Kind-of field constraint (IkeFoundation)").at(inception)
                .synonym("Kind-of field constraint")
                .definition("Legal values are the anchor concept itself plus every one of its"
                        + " descendants (self included) — Tinkar's own \"kind of\" relation.")
                .isA(fieldConstraintKind);

        set.concept("Descendant field constraint (IkeFoundation)").at(inception)
                .synonym("Descendant field constraint")
                .definition("Legal values are every descendant of the anchor concept, not"
                        + " including the anchor concept itself.")
                .isA(fieldConstraintKind);

        set.concept("Leaf descendant field constraint (IkeFoundation)").at(inception)
                .synonym("Leaf descendant field constraint")
                .definition("Legal values are the anchor concept's leaf descendants only —"
                        + " descendants with no children of their own — excluding grouping"
                        + " concepts that exist only to organize other concepts.")
                .isA(fieldConstraintKind);

        set.concept("Immediate child field constraint (IkeFoundation)").at(inception)
                .synonym("Immediate child field constraint")
                .definition("Legal values are the anchor concept's direct children only, not"
                        + " deeper descendants.")
                .isA(fieldConstraintKind);

        set.concept("Value-set field constraint (IkeFoundation)").at(inception)
                .synonym("Value-set field constraint")
                .definition("Legal values are every concept named by an active semantic of a"
                        + " named value-set pattern — an enumeration authored as data, not"
                        + " derived from taxonomy structure.")
                .isA(fieldConstraintKind);

        // ── The constraint pattern's own field-meaning concepts ─────────
        set.concept("Constrained field (IkeFoundation)").at(inception)
                .synonym("Constrained field")
                .definition("The field-meaning concept of the pattern field this constraint"
                        + " governs.")
                .isA(IkeTerm.CONCEPT_FIELD);

        set.concept("Constraint kind (IkeFoundation)").at(inception)
                .synonym("Constraint kind")
                .definition("Which Field constraint kind this constraint semantic expresses.")
                .isA(IkeTerm.CONCEPT_FIELD);

        set.concept("Constraint anchor concept (IkeFoundation)").at(inception)
                .synonym("Constraint anchor concept")
                .definition("The concept a kind-of, descendant, leaf-descendant, or"
                        + " immediate-child constraint is relative to.")
                .isA(IkeTerm.CONCEPT_FIELD);

        set.concept("Value-set pattern (IkeFoundation)").at(inception)
                .synonym("Value-set pattern")
                .definition("For a value-set constraint, the pattern whose active semantics"
                        + " enumerate the legal concepts.")
                .isA(IkeTerm.CONCEPT_FIELD);

        set.concept("Value-set field (IkeFoundation)").at(inception)
                .synonym("Value-set field")
                .definition("For a value-set constraint, the field-meaning concept of the"
                        + " value-set pattern's field that holds the actual concept value —"
                        + " disambiguating when that pattern carries other fields, such as a"
                        + " sort order.")
                .isA(IkeTerm.CONCEPT_FIELD);

        // "Blank Concept" (foundation.Section70) is already exactly this sentinel — "a
        // placeholder meaning no meaningful value applies here, not a modeled domain concept
        // itself" — reused by identity rather than minting a near-duplicate for this pattern
        // alone; the store rejects null field values, so every semantic must populate all five.
        EntityProxy.Concept notApplicable = set.conceptRef("Blank Concept");

        set.concept("Concept field constraint (IkeFoundation)").at(inception)
                .synonym("Concept field constraint")
                .definition("Constrains a concept-typed pattern field's legal values to a"
                        + " taxonomy-relative rule (kind-of, descendant, leaf-descendant,"
                        + " immediate-child) or to membership in a value set.")
                .isA(IkeTerm.MODEL_CONCEPT);

        // ── The pattern's own referenced-component and field-purpose concepts ──
        // A first pass minted this pattern with meaning = purpose at every slot (KEC
        // flagged the same weakness reviewing the rendered pattern-shape table for
        // Comment pattern, IKE-Network/ike-issues#880): each field's own MEANING concept
        // above (Constrained field, Constraint kind, ...) already correctly names what
        // kind of selector value the field holds, so it stays unchanged; only PURPOSE —
        // why that value is recorded — needed a distinct concept. The referenced
        // component's own meaning was worse than merely repeated: naming it "Concept
        // field constraint" described the constraint *mechanism*, not the role the
        // referenced component (the pattern being constrained) actually plays.
        set.concept("Constrained Pattern (IkeFoundation)").at(inception)
                .synonym("Constrained Pattern")
                .definition("The referenced-component role a Concept Field Constraint Pattern"
                        + " semantic's attachment target plays: the pattern that has one of its"
                        + " own fields constrained — distinct from Concept field constraint,"
                        + " which names the constraint mechanism itself, not the pattern it is"
                        + " applied to.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Field Value Restriction (IkeFoundation)").at(inception)
                .synonym("Field Value Restriction")
                .definition("Why a Concept Field Constraint Pattern semantic exists: to restrict"
                        + " which concepts are legal values for one of the constrained pattern's"
                        + " own fields.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Constraint Scope (IkeFoundation)").at(inception)
                .synonym("Constraint Scope")
                .definition("Why the Constrained field value is recorded: to say which field of"
                        + " the constrained pattern this rule applies to.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Constraint Rule (IkeFoundation)").at(inception)
                .synonym("Constraint Rule")
                .definition("Why the Constraint kind value is recorded: to say which rule —"
                        + " kind-of, descendant, leaf-descendant, immediate-child, or"
                        + " value-set — applies.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Taxonomy Reference Point (IkeFoundation)").at(inception)
                .synonym("Taxonomy Reference Point")
                .definition("Why the Constraint anchor concept value is recorded: to give a"
                        + " kind-of, descendant, leaf-descendant, or immediate-child rule"
                        + " something concrete to measure against.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Legal Value Source (IkeFoundation)").at(inception)
                .synonym("Legal Value Source")
                .definition("Why the Value-set pattern value is recorded: to name the pattern"
                        + " whose active semantics enumerate the legal concepts for a value-set"
                        + " constraint.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Value Disambiguation (IkeFoundation)").at(inception)
                .synonym("Value Disambiguation")
                .definition("Why the Value-set field value is recorded: to say which field of"
                        + " the value-set pattern actually holds the concept, when that pattern"
                        + " carries other fields too, such as a sort order.")
                .isA(IkeTerm.MODEL_CONCEPT);

        // ── The pattern itself ───────────────────────────────────────────
        set.pattern("Concept Field Constraint Pattern (IkeFoundation)").at(inception)
                .meaning(set.conceptRef("Constrained Pattern (IkeFoundation)"))
                .purpose(set.conceptRef("Field Value Restriction (IkeFoundation)"))
                .field(set.conceptRef("Constrained field (IkeFoundation)"),
                        set.conceptRef("Constraint Scope (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Constraint kind (IkeFoundation)"),
                        set.conceptRef("Constraint Rule (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Constraint anchor concept (IkeFoundation)"),
                        set.conceptRef("Taxonomy Reference Point (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Value-set pattern (IkeFoundation)"),
                        set.conceptRef("Legal Value Source (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Value-set field (IkeFoundation)"),
                        set.conceptRef("Value Disambiguation (IkeFoundation)"), IkeTerm.COMPONENT_FIELD);

        EntityProxy.Pattern conceptFieldConstraintPattern =
                set.patternRef("Concept Field Constraint Pattern (IkeFoundation)");
        EntityProxy.Concept kindOf = set.conceptRef("Kind-of field constraint (IkeFoundation)");
        EntityProxy.Concept immediateChild = set.conceptRef("Immediate child field constraint (IkeFoundation)");
        EntityProxy.Concept valueSetKind = set.conceptRef("Value-set field constraint (IkeFoundation)");
        EntityProxy.Concept constrainedFieldMeaning = set.conceptRef("Constrained field (IkeFoundation)");
        EntityProxy.Concept constraintKindMeaning = set.conceptRef("Constraint kind (IkeFoundation)");
        EntityProxy.Concept anchorMeaning = set.conceptRef("Constraint anchor concept (IkeFoundation)");
        EntityProxy.Concept valueSetPatternMeaning = set.conceptRef("Value-set pattern (IkeFoundation)");
        EntityProxy.Concept valueSetFieldMeaning = set.conceptRef("Value-set field (IkeFoundation)");

        // ── Worked examples: kind-of, on real STAMP-pattern and ─────────
        // Description-pattern fields (each field's own meaning concept per
        // Section71.java's actual .field(...) declarations, verified against
        // ike-koncepts.yml before writing).
        set.pattern("STAMP pattern").at(inception)
                .semantic(conceptFieldConstraintPattern,
                        PublicIds.of(set.uuidFor("Constraint: STAMP pattern Author field kind-of Author")),
                        set.conceptRef("Author"), kindOf, set.conceptRef("Author"),
                        notApplicable, notApplicable)
                .semantic(conceptFieldConstraintPattern,
                        PublicIds.of(set.uuidFor("Constraint: STAMP pattern Module field kind-of Module")),
                        set.conceptRef("Module"), kindOf, set.conceptRef("Module"),
                        notApplicable, notApplicable)
                .semantic(conceptFieldConstraintPattern,
                        PublicIds.of(set.uuidFor("Constraint: STAMP pattern Path field kind-of Path")),
                        set.conceptRef("Path"), kindOf, set.conceptRef("Path"),
                        notApplicable, notApplicable)
                .semantic(conceptFieldConstraintPattern,
                        PublicIds.of(set.uuidFor(
                                "Constraint: STAMP pattern Status field immediate-child of Status value")),
                        set.conceptRef("Status value"), immediateChild, set.conceptRef("Status value"),
                        notApplicable, notApplicable);

        set.pattern("Description Pattern").at(inception)
                .semantic(conceptFieldConstraintPattern,
                        PublicIds.of(set.uuidFor("Constraint: Description Pattern Language field kind-of Language")),
                        set.conceptRef("Language concept nid for description (SOLOR)"), kindOf,
                        set.conceptRef("Language"), notApplicable, notApplicable);

        // ── Worked example: value-set membership ────────────────────────
        // A small, self-contained illustration (not part of the ingested foundation):
        // a "roster" pattern whose active semantics enumerate concepts, one field of
        // which (Roster order) is NOT the concept value itself — demonstrating why a
        // value-set constraint must name which field holds the concept.
        set.concept("Starter set author roster (IkeFoundation)").at(inception)
                .synonym("Starter set author roster")
                .definition("Illustrative value-set source: an ordered roster of this"
                        + " starter set's own authors, demonstrating a Value-set field"
                        + " constraint's value-set pattern.")
                .isA(IkeTerm.MODEL_CONCEPT);
        set.concept("Roster author (IkeFoundation)").at(inception)
                .synonym("Roster author")
                .definition("The author concept named by one roster entry.")
                .isA(IkeTerm.CONCEPT_FIELD);
        set.concept("Roster order (IkeFoundation)").at(inception)
                .synonym("Roster order")
                .definition("The roster entry's display order — the \"additional"
                        + " characteristic\" field a value-set constraint's Value-set field"
                        + " disambiguates against.")
                .isA(IkeTerm.MODEL_CONCEPT);

        // Meaning/purpose rigor (IKE-Network/ike-issues#880): the pattern's own
        // referenced-component meaning stays "Starter set author roster" (it correctly
        // names what the roster is); purpose and each field's purpose get their own
        // distinct concept instead of repeating that same meaning.
        set.concept("Roster Membership (IkeFoundation)").at(inception)
                .synonym("Roster Membership")
                .definition("Why a Starter Set Author Roster Pattern semantic exists: to"
                        + " enumerate this starter set's own author roster as a value-set"
                        + " source.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Roster Entry (IkeFoundation)").at(inception)
                .synonym("Roster Entry")
                .definition("Why a roster author value is recorded: to name one member of"
                        + " the roster.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Display Sequence (IkeFoundation)").at(inception)
                .synonym("Display Sequence")
                .definition("Why a roster order value is recorded: to say where this entry"
                        + " falls in the roster's own display order.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Starter Set Author Roster Pattern (IkeFoundation)").at(inception)
                .meaning(set.conceptRef("Starter set author roster (IkeFoundation)"))
                .purpose(set.conceptRef("Roster Membership (IkeFoundation)"))
                .field(set.conceptRef("Roster author (IkeFoundation)"),
                        set.conceptRef("Roster Entry (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Roster order (IkeFoundation)"),
                        set.conceptRef("Display Sequence (IkeFoundation)"), IkeTerm.LONG)
                .semantic(set.patternRef("Starter Set Author Roster Pattern (IkeFoundation)"),
                        PublicIds.of(set.uuidFor("Roster entry: Gretel")),
                        set.conceptRef("Gretel (User)"), 1L)
                .semantic(set.patternRef("Starter Set Author Roster Pattern (IkeFoundation)"),
                        PublicIds.of(set.uuidFor("Roster entry: IKE Community")),
                        set.conceptRef("IKE Community (IkeFoundation)"), 2L)
                .semantic(set.patternRef("Starter Set Author Roster Pattern (IkeFoundation)"),
                        PublicIds.of(set.uuidFor("Roster entry: KOMET user")),
                        set.conceptRef("KOMET user (SOLOR)"), 3L)
                .semantic(set.patternRef("Starter Set Author Roster Pattern (IkeFoundation)"),
                        PublicIds.of(set.uuidFor("Roster entry: Tinkar Starter Data Author")),
                        set.conceptRef("Tinkar Starter Data Author (User)"), 4L);

        set.concept("Preferred reviewer (IkeFoundation)").at(inception)
                .synonym("Preferred reviewer")
                .definition("Illustrative constrained field: the reviewer a"
                        + " Preferred Reviewer Pattern semantic names.")
                .isA(IkeTerm.CONCEPT_FIELD);
        set.concept("Preferred reviewer assignment (IkeFoundation)").at(inception)
                .synonym("Preferred reviewer assignment")
                .definition("Illustrative pattern whose single field is constrained to"
                        + " membership in the starter set author roster, demonstrating a"
                        + " Value-set field constraint end to end.")
                .isA(IkeTerm.MODEL_CONCEPT);

        // Meaning/purpose rigor (IKE-Network/ike-issues#880): meaning stays "Preferred
        // reviewer assignment" (it correctly names what the referenced component is);
        // purpose and the field's purpose get their own distinct concepts.
        set.concept("Review Routing (IkeFoundation)").at(inception)
                .synonym("Review Routing")
                .definition("Why a Preferred Reviewer Pattern semantic exists: to direct a"
                        + " component's future edits to a specific reviewer.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Assigned Reviewer (IkeFoundation)").at(inception)
                .synonym("Assigned Reviewer")
                .definition("Why a preferred reviewer value is recorded: to name which"
                        + " author is the preferred reviewer.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Preferred Reviewer Pattern (IkeFoundation)").at(inception)
                .meaning(set.conceptRef("Preferred reviewer assignment (IkeFoundation)"))
                .purpose(set.conceptRef("Review Routing (IkeFoundation)"))
                .field(set.conceptRef("Preferred reviewer (IkeFoundation)"),
                        set.conceptRef("Assigned Reviewer (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .semantic(conceptFieldConstraintPattern,
                        PublicIds.of(set.uuidFor(
                                "Constraint: Preferred Reviewer Pattern reviewer field value-set roster")),
                        set.conceptRef("Preferred reviewer (IkeFoundation)"), valueSetKind, notApplicable,
                        set.patternRef("Starter Set Author Roster Pattern (IkeFoundation)"),
                        set.conceptRef("Roster author (IkeFoundation)"));
    }
}
