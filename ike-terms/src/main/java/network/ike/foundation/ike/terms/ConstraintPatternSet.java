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
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * The field constraint apparatus (IKE-Network/ike-issues#890, refining the #880
 * original): a KB-native way to constrain a pattern field's legal values, with the
 * rules authored as plain semantic data. The organizing rule is that <b>the pattern
 * axis is the parameter shape</b> — one constraint pattern per parameter tuple, never
 * one per datatype, and never a union-by-sentinel (a kind or relation field
 * discriminates within a shape only when every field stays meaningful for every kind).
 * Two shapes exist today:
 * <ul>
 *   <li><b>Taxonomy Field Constraint Pattern</b> — (Constrained field, Constraint
 *       kind, Constraint anchor concept). Intensional: the legal set is derived from
 *       the taxonomy under the checking view, the kind selecting the
 *       {@code NavigationCalculator} walk. The four kinds — kind-of, descendant,
 *       leaf-descendant, immediate-child — share this identical tuple, so one pattern
 *       carries them all with the kind as a genuine parameter.</li>
 *   <li><b>Value-set Field Constraint Pattern</b> — (Constrained field, Value-set
 *       pattern, Value-set field, Member match relation). Extensional and
 *       datatype-universal: the member type is declared by the source pattern's named
 *       Model Feature, so this one shape yields closed enumerations of any field
 *       datatype. How a value must match a member is a concept from the closed Member
 *       match relation taxonomy below; evaluation dispatch stays code-sovereign via
 *       the {@code MemberMatchEvaluator} service seam whose {@code ConstraintTerm}
 *       bindings restate these identities in code (IKE-Network/ike-issues#889),
 *       admission gated by the bijection test in {@code LedgerGatesIT}.</li>
 * </ul>
 * A constraint semantic attaches to the <b>pattern being constrained</b> (its
 * referencedComponent) and is first-class content of that pattern: no module, no
 * exclusion, declared descriptive identities, retrieval by enumeration, and
 * conjunctive composition — each semantic is one conjunct, and all must hold. Every
 * field of every constraint semantic is meaningful — no Blank Concept sentinel
 * anywhere in this story.
 * <p>
 * Fresh IKE-local identity throughout: the closest existing concepts,
 * {@code TinkarTerm.CONCEPT_CONSTRAINTS} and {@code TinkarTerm.ASSEMBLAGE_FOR_CONSTRAINT},
 * are dead SOLOR stubs with zero live references anywhere and no documented semantics
 * of their own, so — unlike {@link NarrativeContentSet}'s reuse of rich-surface's
 * Prose element pattern — there is no established meaning to confidently adopt here.
 * Reading and enforcing these constraints (e.g. in Komet's field editors) is
 * explicitly out of scope: this file mints the representation, the worked examples,
 * the apparatus's own bootstrap self-constraints, and the apparatus koncepts' curated
 * narratives for the guide's Field Constraints chapter (IKE-Network/ike-issues#888),
 * which complement the Constrained Pattern hub narrative in
 * {@link NarrativeContentSet}.
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
        // The one declared inception stamp of the pre-release set: every scope of every
        // file authors at this time, so ledger chronology (non-decreasing stamp times per
        // component) holds trivially (IKE-Network/ike-issues#894).
        ActiveStamp inception = Ike.INCEPTION;

        // ── Taxonomy field constraint kind + its 4 values ───────────────
        // The four taxonomy-relative kinds share one identical parameter tuple, so one
        // pattern carries them all with the kind as a genuine parameter. Value-set
        // membership carries a different tuple entirely, so it is a pattern of its own
        // below — a shape, never a fifth kind (IKE-Network/ike-issues#890).
        set.concept("Taxonomy field constraint kind (IkeFoundation)").at(inception)
                .synonym("Taxonomy field constraint kind")
                .definition("The kind of taxonomy-relative rule a Taxonomy Field Constraint"
                        + " Pattern semantic expresses: which concepts are legal values for"
                        + " the constrained pattern field, derived from the taxonomy under"
                        + " the checking view.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"));
        EntityProxy.Concept taxonomyKind = set.conceptRef("Taxonomy field constraint kind (IkeFoundation)");

        set.concept("Kind-of field constraint (IkeFoundation)").at(inception)
                .synonym("Kind-of field constraint")
                .definition("Legal values are the anchor concept itself plus every one of its"
                        + " descendants (self included) — Tinkar's own \"kind of\" relation.")
                .isA(taxonomyKind);

        set.concept("Descendant field constraint (IkeFoundation)").at(inception)
                .synonym("Descendant field constraint")
                .definition("Legal values are every descendant of the anchor concept, not"
                        + " including the anchor concept itself.")
                .isA(taxonomyKind);

        set.concept("Leaf descendant field constraint (IkeFoundation)").at(inception)
                .synonym("Leaf descendant field constraint")
                .definition("Legal values are the anchor concept's leaf descendants only —"
                        + " descendants with no children of their own — excluding grouping"
                        + " concepts that exist only to organize other concepts.")
                .isA(taxonomyKind);

        set.concept("Immediate child field constraint (IkeFoundation)").at(inception)
                .synonym("Immediate child field constraint")
                .definition("Legal values are the anchor concept's direct children only, not"
                        + " deeper descendants.")
                .isA(taxonomyKind);

        // ── The constraint patterns' field-meaning concepts ─────────────
        set.concept("Constrained field (IkeFoundation)").at(inception)
                .synonym("Constrained field")
                .definition("The field-meaning concept of the pattern field this constraint"
                        + " governs.")
                .isA(IkeTerm.CONCEPT_FIELD, IkeTerm.MEANING);

        set.concept("Constraint kind (IkeFoundation)").at(inception)
                .synonym("Constraint kind")
                .definition("Which Taxonomy field constraint kind this constraint semantic"
                        + " expresses.")
                .isA(IkeTerm.CONCEPT_FIELD, IkeTerm.MEANING);

        set.concept("Constraint anchor concept (IkeFoundation)").at(inception)
                .synonym("Constraint anchor concept")
                .definition("The concept a kind-of, descendant, leaf-descendant, or"
                        + " immediate-child constraint is relative to.")
                .isA(IkeTerm.CONCEPT_FIELD, IkeTerm.MEANING);

        set.concept("Value-set pattern (IkeFoundation)").at(inception)
                .synonym("Value-set pattern")
                .definition("For a value-set constraint, the pattern whose active semantics"
                        + " enumerate the legal values.")
                .isA(IkeTerm.CONCEPT_FIELD, IkeTerm.MEANING);

        set.concept("Value-set field (IkeFoundation)").at(inception)
                .synonym("Value-set field")
                .definition("For a value-set constraint, the Model Feature of the value-set"
                        + " pattern that holds the member value, named by its meaning"
                        + " concept: a declared field's meaning, or the value-set pattern's"
                        + " referenced-component meaning when the members are the referenced"
                        + " components themselves (a membership pattern) — disambiguating"
                        + " when that pattern carries other fields, such as a sort order.")
                .isA(IkeTerm.CONCEPT_FIELD, IkeTerm.MEANING);

        // ── The member match relation taxonomy ──────────────────────────
        // How a value must match an enumerated member is a concept, never invented
        // syntax. Evaluation dispatch is code-sovereign: each MemberMatchEvaluator
        // implementation declares its relation concept identity in code (code points at
        // knowledge, never knowledge at operative code pointers), and tinkar-core's
        // ConstraintTerm restates these two birth-FQN derivations against this set's
        // namespace, so the mints below are exactly the identities code declares
        // (IKE-Network/ike-issues#889). The relation parent concept below is also the
        // Value-set Field Constraint Pattern's fourth field MEANING — the field's value
        // IS a member match relation.
        set.concept("Member match relation (IkeFoundation)").at(inception)
                .synonym("Member match relation")
                .definition("The closed taxonomy of relations a Value-set Field Constraint"
                        + " Pattern semantic can require between a constrained field's value"
                        + " and an enumerated member. Relations are directed and named in"
                        + " full, and a relation is admitted only when its evaluator ships"
                        + " in code: relation concepts correspond one-to-one with the"
                        + " service-loaded evaluators — the bijection gate.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"), IkeTerm.MEANING)
                // Curated narrative (IKE-Network/ike-issues#888): domain description OF
                // this koncept, complementing the Constrained Pattern hub narrative
                // (NarrativeContentSet).
                .semantic(NarrativeContentSet.PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: MemberMatchRelation (Field Constraints — The Member"
                                        + " Match Relation)")), """
                        k:MemberMatchRelation[] is the closed taxonomy of relations a
                        k:ValueSetFieldConstraintPattern[] semantic can require between a constrained
                        field's value and an enumerated member — and it is also that pattern's fourth
                        field's own meaning: the field's value *is* a relation from this taxonomy. How
                        a value must match a member is a concept, never invented syntax, and relations
                        are directed and named in full — a value containing a member fragment and a
                        value contained in a member would be different relations, each with its own
                        name.

                        Admission is evaluator-backed. Dispatch stays code-sovereign through a typed
                        `MemberMatchEvaluator` service seam: each evaluator declares in code which
                        relation concept it evaluates — code points at knowledge, never knowledge at
                        operative code pointers, so imported content can never redirect what
                        constraint checking executes — and each evaluator states its own operand type
                        discipline, since what "the types must agree" means is itself
                        relation-relative. The admission gate is a bijection, enforced by test: the
                        relations — this concept's children under the checking view — correspond
                        one-to-one with the service-loaded evaluators, so minting a relation without
                        shipping its evaluator fails, and shipping an evaluator without minting its
                        relation fails.""");
        EntityProxy.Concept memberMatchRelation = set.conceptRef("Member match relation (IkeFoundation)");

        set.concept("Equal match relation (IkeFoundation)").at(inception)
                .synonym("Equal")
                .definition("A value matches a member when they are equal by the member"
                        + " datatype's natural equality: entity references by identity,"
                        + " scalars by value, byte arrays by content, and Decimal by numeric"
                        + " equality (compareTo == 0 — an identical-representation rule"
                        + " would be its own relation). Float compares by IEEE semantics, so"
                        + " NaN matches nothing — keeping the loud-defaults coherence: an"
                        + " unrevised NaN default fails its constraint until revised. Graph"
                        + " types are outside this relation's operand conformance — graph"
                        + " enumerations await the isomorphic relations.")
                .isA(memberMatchRelation)
                // Curated narrative (IKE-Network/ike-issues#888) — see the parent
                // relation's note above.
                .semantic(NarrativeContentSet.PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: EqualMatchRelation (Field Constraints — The Member"
                                        + " Match Relation)")), """
                        k:EqualMatchRelation[] — Equal, the sole relation admitted today — matches a
                        value to a member when they are equal by the member datatype's natural
                        equality, with the rulings made deliberately, datatype by datatype: entity
                        references match by identity, whatever facade form carries them; String,
                        Boolean, Integer, Long, and Instant match by value; byte arrays by content;
                        arrays elementwise; id lists by order-sensitive element identity and id sets
                        by membership. Decimal matches by numeric equality — `compareTo == 0`, so 2.5
                        admits 2.50 — an identical-representation rule would be its own relation,
                        never an ambiguity inside this one. Float compares by IEEE semantics, so `NaN`
                        matches nothing, itself included — keeping the loud-defaults coherence: an
                        unrevised `NaN` default fails its constraint until someone chooses a real
                        value.

                        Graph types sit outside Equal's operand conformance: graph enumerations await
                        the isomorphic relations, which is where the canonical-form equality question
                        belongs — deferred, never silently decided here.""");

        // ── The patterns' referenced-component and field-purpose concepts ──
        // Meaning/purpose rigor (IKE-Network/ike-issues#880): each field's own MEANING
        // concept above names what kind of selector value the field holds; PURPOSE — why
        // that value is recorded — is a distinct concept per field. The referenced
        // component's meaning names the role the attachment target plays, never the
        // constraint mechanism. That attachment role is identical for both constraint
        // shapes — the pattern that has one of its own fields constrained — so
        // Constrained Pattern and Field Value Restriction serve both patterns
        // (IKE-Network/ike-issues#890).
        set.concept("Constrained Pattern (IkeFoundation)").at(inception)
                .synonym("Constrained Pattern")
                .definition("The referenced-component role a field constraint semantic's"
                        + " attachment target plays: the pattern that has one of its own"
                        + " fields constrained — one attachment role, shared by the Taxonomy"
                        + " Field Constraint Pattern and the Value-set Field Constraint"
                        + " Pattern, and distinct from the constraint mechanisms themselves.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"), IkeTerm.MEANING);

        set.concept("Field Value Restriction (IkeFoundation)").at(inception)
                .synonym("Field Value Restriction")
                .definition("Why a field constraint semantic exists: to restrict which"
                        + " values are legal for one of the constrained pattern's own"
                        + " fields.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"), IkeTerm.PURPOSE);

        set.concept("Constraint Scope (IkeFoundation)").at(inception)
                .synonym("Constraint Scope")
                .definition("Why the Constrained field value is recorded: to say which field"
                        + " of the constrained pattern this rule applies to.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"), IkeTerm.PURPOSE);

        set.concept("Constraint Rule (IkeFoundation)").at(inception)
                .synonym("Constraint Rule")
                .definition("Why the Constraint kind value is recorded: to say which"
                        + " taxonomy-relative rule — kind-of, descendant, leaf-descendant,"
                        + " or immediate-child — applies.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"), IkeTerm.PURPOSE);

        set.concept("Taxonomy Reference Point (IkeFoundation)").at(inception)
                .synonym("Taxonomy Reference Point")
                .definition("Why the Constraint anchor concept value is recorded: to give a"
                        + " kind-of, descendant, leaf-descendant, or immediate-child rule"
                        + " something concrete to measure against.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"), IkeTerm.PURPOSE);

        set.concept("Legal Value Source (IkeFoundation)").at(inception)
                .synonym("Legal Value Source")
                .definition("Why the Value-set pattern value is recorded: to name the pattern"
                        + " whose active semantics enumerate the legal values for a value-set"
                        + " constraint.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"), IkeTerm.PURPOSE);

        set.concept("Value Disambiguation (IkeFoundation)").at(inception)
                .synonym("Value Disambiguation")
                .definition("Why the Value-set field value is recorded: to say which Model"
                        + " Feature of the value-set pattern actually holds the member"
                        + " value, when that pattern carries other fields too, such as a"
                        + " sort order.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"), IkeTerm.PURPOSE);

        // "Match Rule" parallels "Constraint Rule": each names why a discriminator
        // field's value is recorded — which rule applies (text pass, 2026-07-18).
        set.concept("Match Rule (IkeFoundation)").at(inception)
                .synonym("Match Rule")
                .definition("Why the Member match relation value is recorded: to say how a"
                        + " constrained field's value must match an enumerated member —"
                        + " which member match relation the constraint holds under.")
                .isA(set.conceptRef("Constraint model (IkeFoundation)"), IkeTerm.PURPOSE);

        // ── The taxonomy-shape pattern ───────────────────────────────────
        set.pattern("Taxonomy Field Constraint Pattern (IkeFoundation)").at(inception)
                .meaning(set.conceptRef("Constrained Pattern (IkeFoundation)"))
                .purpose(set.conceptRef("Field Value Restriction (IkeFoundation)"))
                .field(set.conceptRef("Constrained field (IkeFoundation)"),
                        set.conceptRef("Constraint Scope (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Constraint kind (IkeFoundation)"),
                        set.conceptRef("Constraint Rule (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Constraint anchor concept (IkeFoundation)"),
                        set.conceptRef("Taxonomy Reference Point (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                // Curated narrative (IKE-Network/ike-issues#888): domain description OF
                // this pattern, complementing — never repeating — the Constrained
                // Pattern hub narrative (NarrativeContentSet), which carries the
                // shape-level, field-by-field walk-through for both constraint shapes.
                .semantic(NarrativeContentSet.PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: TaxonomyFieldConstraintPattern (Field Constraints — The"
                                        + " Taxonomy Field Constraint)")), """
                        k:TaxonomyFieldConstraintPattern[] is the intensional constraint shape: a
                        semantic of it stores a rule, never a list. The legal set for the
                        k:ConstrainedField[] is derived from the knowledge graph under the checking
                        view's navigation coordinate — walked from the k:ConstraintAnchorConcept[] by
                        whichever of k:TaxonomyFieldConstraintKind[]'s four children the
                        k:ConstraintKind[] field names. The four kinds are four editorial intents about
                        a taxonomy region: k:KindOfFieldConstraint[] says the anchor is itself a legal
                        value, alongside everything beneath it; k:DescendantFieldConstraint[] says the
                        anchor is a header — legal values sit strictly beneath it;
                        k:LeafDescendantFieldConstraint[] says only the concrete leaves qualify, never
                        the grouping concepts that exist to organize them; and
                        k:ImmediateChildFieldConstraint[] says the taxonomy is a closed one-level value
                        list — exactly how the STAMP pattern's status field holds to the immediate
                        children of k:StatusValue[].

                        Because the legal set is derived rather than copied, governing it moves to
                        whoever governs that taxonomy region: minting a new kind of k:Author[] extends
                        what every author-constrained field accepts, with no constraint edit anywhere.
                        And because the derivation runs under a view, the legal set is view-relative —
                        two checking views can answer differently — so checking is an authoring-time
                        and QA-time calculator operation, never a property a stored value carries with
                        it.""");

        // ── The value-set-shape pattern ──────────────────────────────────
        set.pattern("Value-set Field Constraint Pattern (IkeFoundation)").at(inception)
                .meaning(set.conceptRef("Constrained Pattern (IkeFoundation)"))
                .purpose(set.conceptRef("Field Value Restriction (IkeFoundation)"))
                .field(set.conceptRef("Constrained field (IkeFoundation)"),
                        set.conceptRef("Constraint Scope (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Value-set pattern (IkeFoundation)"),
                        set.conceptRef("Legal Value Source (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Value-set field (IkeFoundation)"),
                        set.conceptRef("Value Disambiguation (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(memberMatchRelation,
                        set.conceptRef("Match Rule (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                // Curated narrative (IKE-Network/ike-issues#888) — see the taxonomy
                // pattern's note above.
                .semantic(NarrativeContentSet.PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ValueSetFieldConstraintPattern (Field Constraints — The"
                                        + " Value-set Field Constraint)")), """
                        k:ValueSetFieldConstraintPattern[] is the extensional constraint shape: the
                        legal values are enumerated as data — the active semantics of the named
                        k:ValueSetPattern[] — and the constraint is satisfied when some member active
                        under the checking view matches the constrained field's value under the named
                        k:MemberMatchRelation[]. The shape is datatype-universal: the member type rides
                        the source pattern's own declared Model Feature, the one the k:ValueSetField[]
                        pointer names by its meaning concept, so this one four-field shape yields
                        closed enumerations of any field datatype — allowed Strings, allowed Integers,
                        allowed concepts — never a pattern per datatype.

                        Membership carries the ordinary STAMP lifecycle, member by member: adding a
                        member is authoring a semantic of the value-set pattern, removing one is
                        retiring it, and every membership change carries its own provenance — who,
                        when, in which module, on which path. What the value set contains is answered
                        through the stamp calculus — active-under-the-checking-view membership — so
                        the legal set evolves version by version, with no edit to the constraint
                        semantic itself.""");

        EntityProxy.Pattern taxonomyConstraintPattern =
                set.patternRef("Taxonomy Field Constraint Pattern (IkeFoundation)");
        EntityProxy.Pattern valueSetConstraintPattern =
                set.patternRef("Value-set Field Constraint Pattern (IkeFoundation)");
        EntityProxy.Concept kindOf = set.conceptRef("Kind-of field constraint (IkeFoundation)");
        EntityProxy.Concept immediateChild = set.conceptRef("Immediate child field constraint (IkeFoundation)");
        EntityProxy.Concept constraintKindMeaning = set.conceptRef("Constraint kind (IkeFoundation)");
        EntityProxy.Concept equalMatchRelation = set.conceptRef("Equal match relation (IkeFoundation)");

        // ── Bootstrap self-application: the apparatus constrains itself ──
        // Ordinary content, not special machinery: each pattern's own discriminator
        // field is immediate-child constrained to its closed taxonomy
        // (IKE-Network/ike-issues#890).
        set.pattern("Taxonomy Field Constraint Pattern (IkeFoundation)").at(inception)
                .semantic(taxonomyConstraintPattern,
                        PublicIds.of(set.uuidFor("Taxonomy Field Constraint: Taxonomy Field Constraint"
                                + " Pattern Constraint kind field immediate-child of Taxonomy field"
                                + " constraint kind")),
                        constraintKindMeaning, immediateChild, taxonomyKind);

        set.pattern("Value-set Field Constraint Pattern (IkeFoundation)").at(inception)
                .semantic(taxonomyConstraintPattern,
                        PublicIds.of(set.uuidFor("Taxonomy Field Constraint: Value-set Field Constraint"
                                + " Pattern Member match relation field immediate-child of Member match"
                                + " relation")),
                        memberMatchRelation, immediateChild, memberMatchRelation);

        // ── Worked examples: taxonomy constraints on real STAMP-pattern ──
        // and Description-pattern fields (each field's own meaning concept per
        // Section71.java's actual .field(...) declarations, verified against
        // ike-koncepts.yml before writing).
        set.pattern("STAMP pattern").at(inception)
                .semantic(taxonomyConstraintPattern,
                        PublicIds.of(set.uuidFor(
                                "Taxonomy Field Constraint: STAMP pattern Author field kind-of Author")),
                        set.conceptRef("Author"), kindOf, set.conceptRef("Author"))
                .semantic(taxonomyConstraintPattern,
                        PublicIds.of(set.uuidFor(
                                "Taxonomy Field Constraint: STAMP pattern Module field kind-of Module")),
                        set.conceptRef("Module"), kindOf, set.conceptRef("Module"))
                .semantic(taxonomyConstraintPattern,
                        PublicIds.of(set.uuidFor(
                                "Taxonomy Field Constraint: STAMP pattern Path field kind-of Path")),
                        set.conceptRef("Path"), kindOf, set.conceptRef("Path"))
                .semantic(taxonomyConstraintPattern,
                        PublicIds.of(set.uuidFor("Taxonomy Field Constraint: STAMP pattern Status field"
                                + " immediate-child of Status value")),
                        set.conceptRef("Status value"), immediateChild, set.conceptRef("Status value"));

        set.pattern("Description Pattern").at(inception)
                .semantic(taxonomyConstraintPattern,
                        PublicIds.of(set.uuidFor("Taxonomy Field Constraint: Description Pattern Language"
                                + " field kind-of Language")),
                        set.conceptRef("Language concept nid for description (SOLOR)"), kindOf,
                        set.conceptRef("Language"));

        // ── Worked example: value-set membership ────────────────────────
        // A small, self-contained illustration (not part of the ingested foundation):
        // a "roster" pattern whose active semantics enumerate concepts, one field of
        // which (Roster order) is NOT the member value itself — demonstrating why a
        // value-set constraint must name which Model Feature holds the member.
        set.concept("Starter set author roster (IkeFoundation)").at(inception)
                .synonym("Starter set author roster")
                .definition("Illustrative value-set source: an ordered roster of this"
                        + " starter set's own authors, demonstrating a Value-set Field"
                        + " Constraint Pattern's value-set pattern.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"), IkeTerm.MEANING);
        set.concept("Roster author (IkeFoundation)").at(inception)
                .synonym("Roster author")
                .definition("The author concept named by one roster entry.")
                .isA(IkeTerm.CONCEPT_FIELD, IkeTerm.MEANING);
        set.concept("Roster order (IkeFoundation)").at(inception)
                .synonym("Roster order")
                .definition("The roster entry's display order — the \"additional"
                        + " characteristic\" field a value-set constraint's Value-set field"
                        + " disambiguates against.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"), IkeTerm.MEANING);

        // Meaning/purpose rigor (IKE-Network/ike-issues#880): the pattern's own
        // referenced-component meaning stays "Starter set author roster" (it correctly
        // names what the roster is); purpose and each field's purpose get their own
        // distinct concept instead of repeating that same meaning.
        set.concept("Roster Membership (IkeFoundation)").at(inception)
                .synonym("Roster Membership")
                .definition("Why a Starter Set Author Roster Pattern semantic exists: to"
                        + " enumerate this starter set's own author roster as a value-set"
                        + " source.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"), IkeTerm.PURPOSE);

        set.concept("Roster Entry (IkeFoundation)").at(inception)
                .synonym("Roster Entry")
                .definition("Why a roster author value is recorded: to name one member of"
                        + " the roster.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"), IkeTerm.PURPOSE);

        set.concept("Display Sequence (IkeFoundation)").at(inception)
                .synonym("Display Sequence")
                .definition("Why a roster order value is recorded: to say where this entry"
                        + " falls in the roster's own display order.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"), IkeTerm.PURPOSE);

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
                .isA(IkeTerm.CONCEPT_FIELD, IkeTerm.MEANING);
        set.concept("Preferred reviewer assignment (IkeFoundation)").at(inception)
                .synonym("Preferred reviewer assignment")
                .definition("Illustrative pattern whose single field is constrained to"
                        + " membership in the starter set author roster, demonstrating a"
                        + " Value-set Field Constraint Pattern end to end.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"), IkeTerm.MEANING);

        // Meaning/purpose rigor (IKE-Network/ike-issues#880): meaning stays "Preferred
        // reviewer assignment" (it correctly names what the referenced component is);
        // purpose and the field's purpose get their own distinct concepts.
        set.concept("Review Routing (IkeFoundation)").at(inception)
                .synonym("Review Routing")
                .definition("Why a Preferred Reviewer Pattern semantic exists: to direct a"
                        + " component's future edits to a specific reviewer.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"), IkeTerm.PURPOSE);

        set.concept("Assigned Reviewer (IkeFoundation)").at(inception)
                .synonym("Assigned Reviewer")
                .definition("Why a preferred reviewer value is recorded: to name which"
                        + " author is the preferred reviewer.")
                .isA(set.conceptRef("Editorial model (IkeFoundation)"), IkeTerm.PURPOSE);

        set.pattern("Preferred Reviewer Pattern (IkeFoundation)").at(inception)
                .meaning(set.conceptRef("Preferred reviewer assignment (IkeFoundation)"))
                .purpose(set.conceptRef("Review Routing (IkeFoundation)"))
                .field(set.conceptRef("Preferred reviewer (IkeFoundation)"),
                        set.conceptRef("Assigned Reviewer (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .semantic(valueSetConstraintPattern,
                        PublicIds.of(set.uuidFor("Value-set Field Constraint: Preferred Reviewer Pattern"
                                + " reviewer field Equal to a Starter Set Author Roster author")),
                        set.conceptRef("Preferred reviewer (IkeFoundation)"),
                        set.patternRef("Starter Set Author Roster Pattern (IkeFoundation)"),
                        set.conceptRef("Roster author (IkeFoundation)"), equalMatchRelation);
    }
}
