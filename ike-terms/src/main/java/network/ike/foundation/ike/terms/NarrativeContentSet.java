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
 * Curated, long-form AsciiDoc manuscript content, attached to this set's own hub
 * koncepts (IKE-Network/ike-issues#879) — the KB-native alternative to hand-typed
 * prose living only in {@code ike-guide.adoc}. Not part of the ingested foundation
 * (the auto-generated, regeneration-locked {@code foundation.Section*} classes): this
 * is genuinely new curatorial content, so it lives in its own "IKE carriers"-style
 * section, wired from {@link IkeSource} alongside {@link ConceptSet}.
 * <p>
 * Each semantic is of {@code rich-surface-starter-knowledge}'s own
 * "Prose element pattern (RichSurfaceTerms)" (UUID {@code 89b831a1-e773-5f83-87a6-2cfc8e107fb0}) —
 * a single-{@code String}-field pattern for "an embedded prose block ... with
 * id-bearing k: tokens as the interchange form," reused by identity rather than
 * minting a near-duplicate in this set: one shared, ecosystem-wide convention for
 * "prose with k: tokens" beats two patterns modeling the same idea. No build-time
 * dependency on that module is needed — a {@code PublicId} is just a UUID, adopted
 * here exactly like any other external identity this set references.
 * <p>
 * Content here is real AsciiDoc source (paragraphs soft-wrapped across source lines,
 * a blank line between paragraphs, {@code k:} chip references inline) — the
 * {@code koncept-narrative} block macro splices it into the guide via
 * {@code Processor.parseContent}, so it is re-parsed as real AsciiDoc, not frozen as
 * raw text: embedded {@code k:} chips resolve exactly as they do in the guide's own
 * hand-typed prose.
 */
final class NarrativeContentSet {

    /**
     * The shared ecosystem-wide pattern for curated narrative prose (see the class
     * javadoc). Package-private: {@link DefaultsAndTemplatesSet} and
     * {@link DataTypeDefaultsSet} author their own koncepts' narratives against the same
     * identity — those koncepts are minted after this file composes, so their narratives
     * cannot live here without breaking the session's time-major reading order.
     */
    static final EntityProxy.Pattern PROSE_ELEMENT_PATTERN = EntityProxy.Pattern.make(
            "Prose element pattern (RichSurfaceTerms)",
            PublicIds.of(UUID.fromString("89b831a1-e773-5f83-87a6-2cfc8e107fb0")));

    private NarrativeContentSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active("2026-07-13T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);
        // A distinct, later authoring pass (IKE-Network/ike-issues#880): the manuscript
        // expansion chapters/subsections below, added after the pilot five above.
        ActiveStamp expansion = Stamp.active("2026-07-15T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        // The guide's five manuscript chapters (IKE-Network/ike-issues#879), each attached to
        // the hub koncept its own prose is centered on. The EL++ Concepts chapter (Axioms) was
        // the pilot proving the whole mechanism -- extraction, the block macro, and
        // embedded-chip resolution -- before the rest were migrated onto the same pattern.
        // STAMP Concepts is the one chapter with no single hub: its own chapter-intro and
        // closing synthesis paragraphs stay hand-typed in ike-guide.adoc, while each of its
        // four subsections (Status/Author/Module/Path) gets its own semantic below.

        set.pattern("Description Pattern").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: DescriptionPattern (Language Concepts)")), """
                        Every human-readable name in the knowledge base is a description: a
                        k:DescriptionPattern[] semantic attached to a concept, carrying the description's own
                        language, its text, its case significance, and which of three description types it
                        is — k:FullyQualifiedNameDescriptionType[] (the one formal, unique name every concept
                        must have), k:RegularNameDescriptionType[] (a synonym), or
                        k:DefinitionDescriptionType[] (the natural-language definition text this guide renders
                        for every koncept).

                        A description's acceptability within a dialect is a separate semantic layered on top
                        of it: k:USDialectPattern[] and k:GBDialectPattern[] each record whether a description
                        is k:Preferred[] or merely k:Acceptable[] for that dialect, so the same concept can
                        carry a British spelling and an American one side by side, each preferred in its own
                        dialect. Language itself is a concept too — k:EnglishLanguage[] and its siblings —
                        not a string constant.

                        A `LanguageCoordinate` picks one description out of all of a concept's candidates by
                        walking four preference lists, each itself modeled as a koncept:
                        k:LanguageNidForLanguageCoordinate[] (which language to prefer),
                        k:DescriptionTypePreferenceListForLanguageCoordinate[] (fully qualified name before
                        regular name, or the reverse), k:DialectPatternPreferenceListForLanguageCoordinate[]
                        (US before GB, or the reverse), and k:ModulePreferenceListForLanguageCoordinate[] (a
                        final tie-break when two descriptions are otherwise equally preferred). The calculator
                        matches language first, then walks description-type order, then prefers a dialect
                        acceptability of k:Preferred[] matching the dialect preference order, then breaks any
                        remaining tie by module preference.

                        As a pattern, k:DescriptionPattern[] itself carries a referenced-component meaning of
                        k:DescriptionSemantic[] — "purpose and meaning for the description pattern and dialect
                        patterns," in its own words, though a later revision (IKE-Network/ike-issues#880) gives
                        it a distinct purpose too: k:DescriptionAttachment[], naming why the pattern exists —
                        to attach a human-readable name or definition to a concept. Four fields each carry
                        their own meaning and purpose concept: k:LanguageConceptNidForDescription[] (meaning)
                        for k:Language[] (purpose), k:TextForDescription[] (meaning) for k:Description[]
                        (purpose), k:DescriptionCaseSignificance[] (meaning) for k:CaseSensitivityRule[]
                        (purpose — whether the text is case-sensitive), and k:DescriptionType[] (meaning) for
                        k:DescriptionRole[] (purpose — which of the three description roles this one plays).

                        The two dialect patterns named above share one shape, differing only in which
                        national dialect each is attached to: k:USDialectPattern[] and k:GBDialectPattern[]
                        each carry a referenced-component meaning of k:DescriptionAcceptability[] and a
                        purpose of k:DescriptionSemantic[], with one field — its meaning
                        k:UnitedStatesOfAmericaEnglishDialect[] for the US pattern,
                        k:GreatBritainEnglishDialect[] for the GB one, its purpose
                        k:DescriptionAcceptability[] in both — the field a description's
                        k:Preferred[]/k:Acceptable[] acceptability value is actually recorded against.""");

        set.concept("Status value").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: StatusValue (STAMP Concepts — Status)")), """
                        k:StatusValue[] is the concept field holding a version's state — one of
                        k:ActiveState[], k:InactiveState[], k:PrimordialState[], k:CanceledState[], or
                        k:WithdrawnState[]. A `StampCoordinate` doesn't accept just any state: its
                        k:AllowedStatesForStampCoordinate[] narrows which of these count as "current" when the
                        calculator resolves a component's latest version — ordinarily just k:ActiveState[], so
                        a retired or withdrawn version stops being what callers see by default without ever
                        being deleted.""");

        set.concept("Author").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: Author (STAMP Concepts — Author)")), """
                        k:Author[] identifies who committed a version, carried by the k:AuthorField[] concept
                        field. A version's own author is k:AuthorForVersion[]; a `StampCoordinate` doesn't
                        filter by author (identity, unlike state, module, and path, isn't part of "what's
                        current"), but an `EditCoordinate` does, via k:AuthorForEditCoordinate[] — the author
                        a new edit is stamped with. k:AuthorForStampCoordinate[] names the analogous idea
                        should a future coordinate ever need to filter by author.""");

        set.concept("Module").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: Module (STAMP Concepts — Module)")), """
                        k:Module[] groups versions by the export or authoring boundary they belong to — the
                        k:ModuleField[] concept field. k:DevelopmentModule[] and k:PrimordialModule[] are the
                        two this starter set's own content is stamped with. A `StampCoordinate` narrows which
                        modules count via k:ModulePreferenceListForStampCoordinate[] (preference order among
                        several acceptable modules) and k:ModuleExclusionSetForStampCoordinate[] (modules to
                        ignore outright).

                        A module's own lineage is tracked the same way a path's is: k:ModuleOriginsPattern[]
                        carries a referenced-component meaning of k:OriginatedModule[] — the module whose
                        origins are declared — and a purpose of k:ModuleLineage[] — why the record exists:
                        to track which modules a given module originated from — with one field,
                        k:ModuleOrigins[] (meaning) for k:OriginModuleSet[] (purpose), holding the set of
                        modules this module originated from — the module-level counterpart to
                        k:PathOriginsPattern[] below.""");

        set.concept("Path").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: Path (STAMP Concepts — Path)")), """
                        k:Path[] is the version-control lineage a version was committed on — the
                        k:PathField[] concept field. k:DevelopmentPath[] and k:PrimordialPath[] are this
                        starter set's own two paths; k:PathOriginsForStampPath[] records which path a path
                        itself branched from, so a `StampCoordinate` positioned on one path can still resolve
                        versions committed on an ancestor path before the branch point.

                        As a pattern, k:PathOriginsPattern[] itself carries a referenced-component meaning
                        of k:OriginatedPath[] — the path whose branch point is declared — and a purpose of
                        k:PathLineage[] — why the record exists: to track which path it branched from, and
                        when — and two fields: k:PathConcept[] (meaning) for k:BranchSource[] (purpose —
                        which path this path branched from; the record's subject is the referenced
                        component, never this field) and k:PathOrigins[] (meaning) for k:BranchPoint[]
                        (purpose — the moment this path branched, up to which the origin path's versions
                        are visible from it). k:VersionControlPathPattern[]
                        is simpler still — a referenced-component meaning of k:Path[] and purpose of
                        k:SetMembership[], with no fields of its own: a semantic of it merely marks a
                        component as belonging to version-control path management, the same bare
                        membership-pattern convention this guide's Tinkar Base Model chapter describes for
                        k:TinkarBaseModelComponentPattern[] and k:KometBaseModelComponentPattern[].""");

        set.concept("Author for edit coordinate (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: AuthorForEditCoordinate (STAMP Concepts — Edit"
                                + " Coordinate)")), """
                        Where a `StampCoordinate` only ever reads which version is current, an
                        `EditCoordinate` names the STAMP an author's *next* edit will be stamped with — a
                        distinct concern from any of the four dimensions above. k:AuthorForEditCoordinate[]
                        names the author a new edit is attributed to (mentioned already in the Author
                        subsection above); k:DefaultModuleForEditCoordinate[] names which module a new edit
                        lands in by default, with k:ModuleOptionsForEditCoordinate[] naming the full set an
                        author may choose from instead, and k:PathOptionsForEditCoordinate[] playing the
                        analogous role for path.

                        k:PromotionPathForEditCoordinate[] names a distinct idea again: not where a new edit
                        is committed, but which path a component is *promoted* to once its authoring is
                        complete — the sandbox-to-mainline movement k:SandboxPath[]/k:SandboxComponent[]
                        content eventually undergoes. k:DestinationModuleForEditCoordinate[] rounds this out
                        for the analogous author-to-export-module handoff.""");

        set.concept("Logic coordinate properties (SOLOR)").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: LogicCoordinateProperties (Logic Coordinates)")), """
                        A concept's formal, machine-processable meaning lives in its stated and inferred
                        logical axioms — separate from its human-readable descriptions. A `LogicCoordinate`
                        names which patterns and which classifier resolve that meaning, and — like the
                        preference lists on a `LanguageCoordinate` — each of its own fields is itself a
                        koncept: k:LogicCoordinateProperties[] groups them.

                        k:StatedPatternForLogicCoordinate[] names the pattern an author's own stated axioms
                        are recorded under (k:ELStatedAxiomsPattern[] in this starter set), and
                        k:InferredPatternForLogicCoordinate[] names the pattern the classifier's derived
                        axioms are written to (k:ELInferredAxiomsPattern[]) — stated is what was authored;
                        inferred is what the classifier concluded follows from it, computed, never
                        hand-written. k:ClassifierForLogicCoordinate[] names which classifier does that
                        computation (k:SnoRocketClassifier[] here), and
                        k:DescriptionLogicProfileForLogicCoordinate[] names the logic profile it classifies
                        against (k:ELLogicProfile[] — EL++, described below). k:RootForLogicCoordinate[]
                        anchors the whole taxonomy the coordinate reasons over.

                        k:SolorConceptsPattern[] is the membership pattern that marks a concept as belonging
                        to the SOLOR concept space a `LogicCoordinate` reasons over — a referenced-component
                        meaning of k:ConceptPatternForLogicCoordinate[] (the same pattern named just above,
                        for the concept dimension rather than the axiom dimension) and purpose of
                        k:SetMembership[], with no fields of its own: a semantic of it is simply an element
                        of its own set, nothing more. This is a fresh, IKE-native pattern, minted deliberately
                        rather than resuming k:SOLORConceptAssemblage[] — SOLOR's own dormant original for
                        this exact idea, which carries zero live semantics anywhere in this starter set's
                        ingested foundation, cited here as legacy prior art rather than resumed identity, the
                        same treatment k:ConceptConstraints[] gets in the Authoring Actions chapter.
                        k:SolorConceptsPattern[] is the same bare membership-pattern shape this guide's
                        Tinkar Base Model chapter describes for k:TinkarBaseModelComponentPattern[] and
                        k:KometBaseModelComponentPattern[].""");

        set.concept("Navigation vertex (SOLOR)").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: NavigationVertex (Navigation Coordinates)")), """
                        Where a `LogicCoordinate` answers "what are this concept's axioms," a
                        `NavigationCoordinate` answers "what are this concept's parents and children" — a
                        faster question to ask repeatedly than re-deriving it from axioms every time.
                        k:IsA[] is the relationship both questions are ultimately about — "designates the
                        parent-child relationship," in its own words, the one every k:NavigationVertex[]
                        exists to make fast to walk. k:StatedNavigationPattern[] and
                        k:InferredNavigationPattern[] are the two caches
                        navigation can be read from — k:InferredNavigation[] the concrete pattern a
                        coordinate actually points at by default — each k:NavigationVertex[] recording a
                        concept's direct parents and children, filtered to whichever k:VertexStateSet[]
                        states the coordinate considers current.

                        Both are *derived*, not authored: a classifier run populates them from the stated (or
                        inferred) axioms, the same way it populates k:ELInferredAxiomsPattern[]. A freshly
                        authored ledger that has never been classified — this starter set's own, today — has
                        stated *axioms* (k:Axioms[] below) but no stated *navigation* at all yet, which is
                        exactly why this set's own documentation tooling reads taxonomy structure from stated
                        axioms directly rather than from navigation.

                        k:StatedNavigationPattern[] and k:InferredNavigationPattern[] share one identical
                        shape, differing only in which store each populates: both carry a referenced-component
                        meaning of k:IsA[] and a purpose of k:TaxonomyNavigationCache[] — a pre-computed
                        parent/child structure so traversal doesn't require re-deriving from axioms every
                        time — and two fields, each already correctly distinguishing meaning from purpose:
                        k:RelationshipDestination[] (meaning) for k:IsA[] (purpose, the child-ward direction)
                        and k:RelationshipOrigin[] (meaning) for k:IsA[] again (the parent-ward direction) —
                        the same relationship-direction terminology this guide's Object Properties chapter
                        names as the generic idea these two fields specialize.""");

        set.concept("Axioms").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN, PublicIds.of(set.uuidFor("Narrative: Axioms (EL++ Concepts)")), """
                        k:Axioms[] groups every concept in this set's meta-schema that describes how a
                        concept's formal meaning is expressed: k:AxiomSyntax[] (the notation an axiom is
                        written in) and k:AxiomOrigin[] (whether an axiom was authored or derived) sit
                        alongside k:ELTerminologicalAxioms[] — this set's actual logic profile — which splits
                        into k:ELStatedTerminologicalAxioms[] (what was authored) and
                        k:ELInferredTerminologicalAxioms[] (what the classifier concluded). A separate
                        family, k:IntervalSetAxioms[], covers interval- and range-valued axioms rather than
                        terminological ones.

                        EL++ is the description-logic profile SNOMED CT and Tinkar both build on: expressive
                        enough for real terminological definitions (necessary conditions, role restrictions,
                        concrete-value constraints), restricted enough that classification stays tractable at
                        hundreds of thousands of concepts. This starter set can describe its own logic
                        because the identity-exact ingest (IKE-Network/ike-issues#872) brought in Tinkar's
                        entire EL++ terminology — the classifier, the axiom patterns, the profile concept
                        itself — as part of the same "fork and own" ingest that gave every other concept in
                        this guide its identity.""");

        // EL++ Concepts expansion (IKE-Network/ike-issues#880): the pilot narrative above named
        // the organizing categories; these four subsections describe what an axiom is actually
        // built from.
        set.concept("Role").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: Role (EL++ Concepts — Roles and Role Operators)")), """
                        A role is EL++'s mechanism for a relationship between a defined concept and another
                        concept — "has active ingredient," "has finding site," and so on. k:RoleGroup[] is the
                        pattern's top-level grouping; k:Role[] and k:RoleOperator[] both sit beneath it as
                        siblings, not parent and child — a role names *what* relationship holds
                        (k:RoleType[] identifies which relationship kind), while a role operator names *how*
                        that relationship is quantified over its target: k:ExistentialRestriction[] ("at least
                        one"), k:UniversalRestriction[] ("all of"), and two SOLOR-specific refinements —
                        k:ReferencedComponentSubtypeRestriction[] and k:ReferencedComponentTypeRestriction[] —
                        that further narrow which component kinds a dynamic field's value may legally
                        reference.

                        k:RoleGroup[] itself groups several attribute-or-role-value pairs so they are
                        considered together within one concept definition rather than combined freely across
                        the whole definition — the same distinction post-coordinated expressions in SNOMED CT
                        rely on to keep, for example, two different findings' own laterality from
                        cross-combining.""");

        set.concept("Inclusion set").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: InclusionSet (EL++ Concepts — Inclusion, Necessary, Sufficient Sets)")),
                        """
                        Beneath k:ELStatedTerminologicalAxioms[] and k:ELInferredTerminologicalAxioms[] sit
                        three kinds of role-set, each answering a different question about a concept's
                        definition. k:NecessarySet[] holds relationships that are always true of the concept
                        — necessary conditions, in description-logic terms — while k:SufficientSet[] holds
                        relationships that, together, are enough to fully differentiate the concept and its
                        subtypes from every other concept: a concept with at least one sufficient set is
                        *defined*, not merely *primitive*. k:InclusionSet[] is weaker than either — relationships
                        that are part of the concept's definition without being individually necessary, or
                        together sufficient. k:NecessaryButNotSufficientConceptDefinition[] names the
                        definition-status value a concept carries when its own role sets fall short of full
                        sufficiency — the everyday case for most authored content, since fully-differentiating,
                        sufficient definitions are the exception in any real terminology, not the rule.""");

        set.concept("Concrete value operator (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: ConcreteValueOperator (EL++ Concepts — Concrete"
                                + " Value Operators)")), """
                        Not every constraint in an EL{plus}{plus} definition names another concept — some
                        constrain a *literal* value instead: a lab reference range's upper bound, a dose's
                        numeric strength. k:ConcreteValueOperator[] is the parent of the comparison
                        operators that express these concrete-domain constraints: k:EqualTo[],
                        k:GreaterThan[], k:GreaterThanOrEqualTo[], k:LessThan[], k:LessThanOrEqualTo[], and
                        the two range endpoints k:MinimumValueOperator[] and k:MaximumValueOperator[].
                        These are exactly the operator concepts k:ValueConstraintPattern[] draws on for its
                        own min/max reference-range fields (see the Semantic Field Model chapter) —
                        concrete-domain reasoning is what lets EL{plus}{plus} classification stay tractable
                        even when a definition depends on a numeric threshold, rather than requiring a
                        distinct concept for every possible value.""");

        set.concept("Logical Definition").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: LogicalDefinition (EL++ Concepts — Logical Definitions and Grouping)")),
                        """
                        k:LogicalDefinition[] names the semantic value a stated or inferred terminological
                        axiom's own definition status carries — k:ELStatedConceptDefinition[] for what was
                        authored, k:ElInferredConceptDefinition[] for what the classifier concluded, mirroring
                        the same stated-versus-inferred split k:Axioms[] itself organizes around.
                        k:StatedDefinition[] and k:InferredDefinition[] name the underlying relationship sets
                        those definition-status values describe — "relationships/axioms of a concept that
                        have been explicitly stated" versus "inferred," the same distinction spelled out at
                        the level of individual relationships rather than a definition's overall status.

                        Two smaller, related concept families round out this set: k:Grouping[] distinguishes an
                        k:Exact[] match (source and target that are semantically or lexically identical) from
                        a k:Partial[] one, and k:DirectedGraph[] is the parent of k:ELDigraph[] — the directed
                        graph that results from classifying a full set of EL++ axioms, the data shape
                        k:SnoRocketClassifier[] itself produces and k:InferredNavigation[] is ultimately
                        derived from.

                        The stated/inferred split has its own pair of patterns beneath it: k:ELStatedAxiomsPattern[]
                        carries a referenced-component meaning of k:StatedDefinition[] and purpose of
                        k:LogicalDefinition[], with one field, k:ELStatedTerminologicalAxioms[] (meaning)
                        for k:LogicalDefinition[] (purpose); k:ELInferredAxiomsPattern[] is its
                        inferred-side twin — meaning k:InferredDefinition[], purpose k:LogicalDefinition[]
                        again, its field k:ELInferredTerminologicalAxioms[] for k:LogicalDefinition[]
                        likewise — the two concrete patterns
                        k:StatedPatternForLogicCoordinate[] and k:InferredPatternForLogicCoordinate[]
                        (named in the Logic Coordinates chapter) actually point at. k:OWLAxiomSyntaxPattern[]
                        is smaller still: a referenced-component meaning of k:AxiomatizedComponent[] — the
                        component whose definitional axioms the semantic expresses — and a purpose of
                        k:AxiomExpression[], with one field, k:AxiomSyntax[] for k:ExpressAxiomSyntax[],
                        holding the OWL functional-syntax text an axiom can optionally also be expressed
                        in.""");

        // Semantic Field Model chapter (IKE-Network/ike-issues#880): the field-level meta-schema
        // — what kind of value a field holds, how it renders, and what its value can mean —
        // capped by Constraining Fields, which introduces the field constraint apparatus
        // (ConstraintPatternSet, refactored per IKE-Network/ike-issues#890) this chapter is the
        // natural home for.
        set.concept("Field categories").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: FieldCategories (Semantic Field Model — Field Categories)")), """
                        k:FieldCategories[] groups the field-level meta-schema concepts: the terminology
                        describing what *kind* of value a pattern's field holds, distinct from that field's
                        own particular meaning and purpose in any one pattern declaration.
                        k:ComponentField[] is the parent of every field kind whose value is a reference to
                        another component; k:ConceptField[] narrows that to concepts specifically, and is
                        itself the parent of the four STAMP-dimension field kinds this guide's STAMP chapter
                        already named — k:AuthorField[], k:ModuleField[], k:PathField[], k:StatusField[] —
                        plus k:FieldDefinitionMeaningField[] and k:FieldDefinitionPurposeField[], the field
                        kinds a pattern's own field definitions use to record each field's meaning and
                        purpose concepts: the same terminology every pattern declaration in this starter set's
                        own source populates when it names a field's meaning, purpose, and data type.
                        k:PatternField[], k:SemanticField[], and k:STAMPField[] are the parallel
                        component-field kinds for referencing a pattern, a semantic, or a STAMP directly, each
                        further specialized (k:SemanticPatternField[] for the pattern a semantic is of;
                        k:SemanticReferencedComponentField[] for what it is attached to).

                        Sibling to k:ComponentField[] under k:FieldCategories[] itself sit the *collection*
                        field kinds — k:ComponentVersionsField[]/k:ComponentVersionsSet[] and their four
                        specializations for concept, pattern, semantic, and STAMP versions — the field kinds
                        that hold every version of a component rather than a single reference, and
                        k:StringField[] (parent of k:PublicIDField[]) for text-valued fields.
                        k:FieldDefinitionField[] and k:FieldDefinitionsSet[] name one field definition and the
                        whole set of a pattern's field definitions, respectively, while k:FieldValueField[]
                        names the field kind for an actual field *value* inside a semantic instance — the
                        same definition-versus-instance distinction that separates a pattern's own field
                        declarations from the values a semantic of it actually carries.""");

        set.concept("Display Fields").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: DisplayFields (Semantic Field Model — Display Fields)")), """
                        k:DisplayFields[] is a pattern's own field's declared data type — confirmed by
                        identity against `ConceptToDataType` (`dev.ikm.tinkar.terms`, tinkar-core), which
                        resolves exactly this family's members to their real `FieldDataType`, and exactly
                        what a pattern's own `.field(meaning, purpose, dataType)` declaration draws its
                        third argument from throughout this starter set's own source. Several members
                        carried misleading "display field" wording, as if a separate "how does this render"
                        concept sat behind some other, truer storage type — it does not, and every member
                        confirmed in use through `ConceptToDataType` has been renamed to say so plainly:
                        k:ConceptDataType[] holds a concept's identity, k:ComponentDataType[] the analogous
                        case for any component (concept, semantic, pattern, or STAMP, not restricted to
                        concepts); k:ComponentIdListDataType[] and k:ComponentIdSetDataType[] hold an
                        ordered or unordered collection of component references. k:StringDataType[] and
                        k:FloatDataType[] hold a sequence of characters and a fractional number,
                        respectively; k:BooleanDataType[], k:IntegerDataType[], k:DecimalDataType[],
                        k:ByteArrayDataType[], and k:ArrayDataType[] round out the renamed primitive and
                        collection kinds, and k:SemanticDataType[] holds a reference to a semantic. Only
                        the members `ConceptToDataType` does not recognize keep their display-era names
                        until each is checked the same way: k:DoubleDisplayField[], k:ImageDisplayField[],
                        k:UUIDDisplayField[], and k:LogicalExpressionDisplayField[] (a rendered axiom
                        expression).

                        Two structural kinds hold graphs directly: k:DiGraphDataType[] (an ordered-pair
                        directed graph — the same shape k:ELDigraph[] takes) and k:DiTreeDataType[] (a
                        directed tree obtained from an undirected one, one designated root), both likewise
                        renamed.""");

        set.concept("Meaning").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: Meaning (Semantic Field Model — Field Value Terminology)")), """
                        k:Meaning[] is the broadest of these three groups: the terminology a pattern or
                        semantic's field draws its *interpretation* from, distinct from the field *category*
                        (k:FieldCategories[]) or declared *data type* (k:DisplayFields[]) concept families above.
                        k:DynamicColumnDataTypes[] — k:Boolean[], k:Decimal[], k:Float[], k:Double[],
                        k:Long[], k:SignedInteger[], k:Array[], k:ByteArray[], and k:UUIDDataType[] — looks
                        like it should be the same family k:DisplayFields[] draws from, but it is a
                        separate, disjoint one: Komet's own pattern-authoring UI (`PatternFieldsController`,
                        kview) draws its "choose a data type" list from this branch, while a pattern's real
                        field declaration draws its `dataType` tag from k:DisplayFields[] instead
                        (`IkeTerm.LONG`, `IkeTerm.STRING`, `IkeTerm.COMPONENT_FIELD`, and so on, throughout
                        this starter set's own source) — two families that happen to describe the same idea
                        twice, not one. Reparented under k:Legacy[] here as a deprecation signal; the
                        disconnect on the komet side is tracked as ikmdev/komet#880.

                        k:LiteralValue[] groups the value shapes a concrete field literal can take —
                        k:BooleanLiteral[] (TRUE/FALSE/UNKNOWN), k:FloatLiteral[], k:InstantLiteral[] — while
                        k:FieldSubstitution[] groups the analogous notion for a query template:
                        k:BooleanSubstitution[], k:ConceptSubstitution[], k:FloatSubstitution[],
                        k:InstantSubstitution[] each name what kind of value fills a placeholder when a
                        stored query actually runs. k:ConnectiveOperator[] (k:And[], k:Or[], k:PartOf[],
                        k:DisjointWith[]) and k:TaxonomyOperator[] (k:LogicallyEquivalentTo[]) round out the
                        operator concepts a field's meaning can name, and k:SemanticType[]
                        (k:ConceptSemantic[], k:ComponentSemantic[], k:MembershipSemantic[],
                        k:LogicalExpressionSemantic[]) names what kind of thing a whole semantic — not just
                        one field — represents.""");

        set.concept("Constrained Pattern (IkeFoundation)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ConstrainedPattern (Semantic Field Model — Constraining"
                                        + " Fields)")), """
                        Some of the concept-typed field kinds above — k:AuthorField[], k:ModuleField[],
                        k:StatusField[], and others — are conventionally restricted to a known, bounded set
                        of legal values: only concepts kind-of k:Author[] make sense as a STAMP's author
                        field, only the immediate children of k:StatusValue[] as its status. Nothing in the
                        field-definition model above expresses that restriction — a field's declared data
                        type says it holds *a* concept, never *which* concepts, and the same holds for
                        every other data type.

                        Two constraint patterns close that gap, one per parameter shape — the pattern axis
                        is the parameter shape, never the datatype, and never a union carried by sentinel
                        values. Both attach to the pattern being constrained, and both share a
                        referenced-component meaning of k:ConstrainedPattern[] — the attachment target's
                        role: the pattern that has one of its own fields constrained, identical for both
                        shapes — and a purpose of k:FieldValueRestriction[]. A pattern's constraint
                        semantics compose conjunctively: each semantic is one conjunct, and a value is legal
                        only when every conjunct on its field holds.

                        k:TaxonomyFieldConstraintPattern[] is the intensional shape: the legal set is
                        derived from the taxonomy under the checking view. Its three fields each carry
                        their own meaning and purpose concept: k:ConstrainedField[] (meaning) for
                        k:ConstraintScope[] (purpose — which field this rule governs); k:ConstraintKind[]
                        for k:ConstraintRule[] (which rule applies); and k:ConstraintAnchorConcept[] for
                        k:TaxonomyReferencePoint[] (the concept the rule measures against).
                        k:ConstraintKind[]'s legal values are k:TaxonomyFieldConstraintKind[]'s four
                        children — k:KindOfFieldConstraint[] (the anchor plus every descendant, self
                        included), k:DescendantFieldConstraint[] (descendants only),
                        k:LeafDescendantFieldConstraint[] (leaf descendants only — excluding grouping
                        concepts that exist solely to organize others), and
                        k:ImmediateChildFieldConstraint[] (direct children only) — an identical tuple for
                        all four, which is exactly why they are kinds within one pattern rather than four
                        patterns. Concretely, this starter set's own STAMP pattern carries four such
                        semantics: constrained field = k:Author[], kind = k:KindOfFieldConstraint[],
                        anchor = k:Author[] — the same concept identifies both the field and the anchor
                        here, since a later revision (IKE-Network/ike-issues#880) gave the Author field
                        itself k:Author[] as its own meaning — likewise Module and Path, and a fourth
                        whose tuple reads constrained field = k:StatusValue[], kind =
                        k:ImmediateChildFieldConstraint[], anchor = k:StatusValue[] again: a concept can
                        serve as both a field's own meaning and a constraint's own anchor without
                        conflict, since the two roles are read from different fields entirely.

                        k:ValueSetFieldConstraintPattern[] is the extensional shape, and it is
                        datatype-universal: the members are enumerated as data, and the member type is
                        whatever the source pattern's named Model Feature declares, so this one shape
                        yields closed enumerations of any field datatype. Its four fields:
                        k:ConstrainedField[] for k:ConstraintScope[] again; k:ValueSetPattern[] (meaning)
                        for k:LegalValueSource[] (purpose — the pattern whose active semantics enumerate
                        the legal values); k:ValueSetField[] for k:ValueDisambiguation[] — naming the
                        Model Feature that holds the member value by its meaning concept, either a
                        declared field's meaning or the source pattern's referenced-component meaning
                        (membership patterns supported, no sentinel); and k:MemberMatchRelation[] for
                        k:MatchRule[] (purpose — how a value must match a member). The constraint is
                        satisfied when some member active under the checking view matches the value under
                        the named relation — membership itself carries the ordinary STAMP lifecycle, so
                        adding a member is authoring and removing one is retiring. This starter set's own
                        illustrative k:StarterSetAuthorRosterPattern[] shows why the Model-Feature pointer
                        is needed: each roster entry is a semantic with *two* fields, k:RosterAuthor[] and
                        k:RosterOrder[], and only the first is the value a member is matched against. The
                        worked constraint on k:PreferredReviewerPattern[] reads: constrained field =
                        k:PreferredReviewer[], value-set pattern = k:StarterSetAuthorRosterPattern[],
                        value-set field = k:RosterAuthor[], relation = k:EqualMatchRelation[].

                        How a value must match an enumerated member is itself a concept, never invented
                        syntax: k:MemberMatchRelation[] is a closed taxonomy whose relations are directed
                        and named in full. Evaluation dispatch stays code-sovereign — each relation's
                        evaluator declares its relation concept's identity in code, so code points at
                        knowledge and knowledge never carries an operative pointer at code: imported
                        content can never redirect what constraint checking executes. Admission is a
                        bijection, enforced by test: relation concepts correspond one-to-one with the
                        shipped evaluators, so minting a relation without shipping its evaluator fails,
                        and shipping an evaluator without minting its relation fails.
                        k:EqualMatchRelation[] is the sole admitted relation today: equality by the member
                        datatype's natural equality — entity references by identity, scalars by value,
                        byte arrays by content, Decimal by numeric equality, and Float by IEEE
                        comparison, so NaN matches nothing, keeping the loud-defaults coherence (an
                        unrevised NaN default fails its constraint until revised); graph types await the
                        isomorphic relations.

                        The apparatus constrains itself, as ordinary content: a
                        k:TaxonomyFieldConstraintPattern[] semantic on each constraint pattern holds its
                        own discriminator field to its closed taxonomy — k:ConstraintKind[]
                        immediate-child of k:TaxonomyFieldConstraintKind[], and the
                        k:MemberMatchRelation[] field immediate-child of k:MemberMatchRelation[].

                        Why mint fresh identity, rather than adopting k:ConceptConstraints[] — a real, if
                        long-dormant, SOLOR concept whose own definition, "defined filters for a given
                        concept," reads almost as if it were written for this exact mechanism? Because it
                        carries no live semantics anywhere in this ecosystem to confirm what "defined
                        filters" actually meant — no field shape, no worked example, no consuming code — and
                        adopting an identity on the strength of a plausible-sounding one-line gloss risks
                        importing an unintended meaning later, if that dormant concept's real intent turns
                        out to differ from what is built here. k:ConceptConstraints[] remains exactly where
                        it was — cited here as legacy prior art rather than resumed identity, a distinction
                        worth drawing plainly, since the rest of this starter set leans hard the other way
                        (adopting existing identity, as with k:AuthorForVersion[] and every other
                        SOLOR-sourced concept named in this guide) whenever a real, checkable definition
                        backs the reuse rather than merely a plausible-sounding name.

                        No pattern-model change was needed to represent any of this: every taxonomy
                        constraint kind composes directly from graph-walk operations a navigation
                        calculator already provides — k:KindOfFieldConstraint[] from `kindOf`,
                        k:DescendantFieldConstraint[] from `descendentsOf`,
                        k:ImmediateChildFieldConstraint[] from `childrenOf`, and
                        k:LeafDescendantFieldConstraint[] by filtering `descendentsOf` down to the nodes
                        `childrenOf` finds empty. Reading and *enforcing* these constraints — in Komet's own
                        field editors, for instance, which today have no such notion at all — is a
                        deliberately separate, later concern from representing them; what the representation
                        already makes possible today is exactly the candidate set a reader would want to
                        see, computed fresh every render, with no separate authoring step — the live listing
                        just below is every concept a k:KindOfFieldConstraint[] anchored at k:Author[] would
                        accept, walked from the same k:Author[] broader relationship the constraint's own
                        definition points at.""");

        // Tinkar Base Model chapter (IKE-Network/ike-issues#880): the component/chronicle/
        // pattern-of-patterns meta-model every other chapter's own terminology ultimately
        // descends from.
        set.concept("Tinkar Model concept").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: TinkarModelConcept (Tinkar Base Model — Components and Chronicles)")),
                        """
                        k:ModelConcept[] anchors every concept in this guide that describes the knowledge
                        base's own structure rather than a domain it represents — the model-versus-data
                        distinction k:DataConcept[] draws on the other side (k:DefaultDataConcept[] and its
                        siblings group actual data values, not structural terminology). k:TinkarModelConcept[]
                        is the root of Tinkar's own meta-schema specifically: components, descriptions,
                        dialects, fields, and axioms — every chapter in this guide, from k:DescriptionPattern[]
                        to k:Axioms[] to k:FieldCategories[], ultimately descends from this one concept.

                        A component's persisted form is a *chronicle*: k:ChronicleProperties[] names what
                        every chronicle carries regardless of component kind — k:PrimordialUUIDForChronicle[]
                        (its own birth identity), k:SemanticListForChronicle[] (every semantic attached to
                        it), k:VersionListForChronicle[] (its own version history). k:ComponentChronologyPattern[]
                        and k:ComponentVersionPattern[] name the generic shape every chronicle/version pair
                        takes; k:ConceptFieldPattern[]/k:ConceptVersionPattern[],
                        k:PatternChronologyPattern[]/k:PatternVersionPattern[],
                        k:SemanticChronologyPattern[]/k:SemanticVersionFieldPattern[], and
                        k:STAMPChronologyPattern[]/k:STAMPVersionFieldPattern[] specialize that shape for
                        each of the four component kinds this guide has already named.
                        k:TinkarBaseModelComponentPattern[] and k:KometBaseModelComponentPattern[] are
                        membership patterns, not shape descriptions — both carrying a referenced-component
                        meaning of k:StarterDataAuthoring[] and purpose of k:SetMembership[], with no fields
                        of their own: a semantic of one of these patterns marks a component as belonging to
                        Tinkar's own base terminology or Komet's own — the same membership-pattern convention
                        k:SolorConceptsPattern[] uses (discussed in the Logic Coordinates chapter) to mark
                        a component as part of the SOLOR concept space.

                        Each chronicle-shape pattern's own referenced component and fields make that
                        specialization concrete. k:ComponentChronologyPattern[] — the base shape — carries a
                        referenced-component meaning of k:ComponentField[] and a purpose of
                        k:ChronicleIdentityAndHistory[] — one shared concept naming why every chronicle-shape
                        pattern exists: to record a component's own identity alongside its complete version
                        history — and two fields, each with its own meaning and purpose concept:
                        k:PublicIDField[] (meaning) for k:UniquelyIdentifyKnowledgeGraphComponents[] (purpose),
                        and k:ComponentVersionsField[] (meaning) for k:ComponentVersionsSet[] (purpose) — every
                        chronicle's own identity plus its version list. k:ConceptFieldPattern[] and
                        k:PatternChronologyPattern[] specialize that same two-field shape for concepts and
                        patterns respectively (referenced-component meaning k:ConceptField[] or
                        k:PatternField[] in turn, the same shared purpose, fields
                        k:PublicIDField[]/k:ConceptVersionsField[] or
                        k:PublicIDField[]/k:PatternVersionsField[]). k:SemanticChronologyPattern[] carries two
                        fields more than its siblings — a semantic's own chronicle must also record which
                        pattern it is a semantic *of* and what it is *attached to* — a referenced-component
                        meaning of k:SemanticField[] and the same shared purpose, and four fields:
                        k:PublicIDField[]/k:UniquelyIdentifyKnowledgeGraphComponents[],
                        k:SemanticPatternField[] (meaning) for k:PatternMembership[] (purpose — which pattern
                        this semantic is an instance of), k:SemanticReferencedComponentField[] (meaning) for
                        k:AttachmentTarget[] (purpose — what this semantic is attached to), and
                        k:SemanticVersionsSet[] (meaning) for k:VersionHistory[] (purpose).
                        k:STAMPChronologyPattern[] rounds out the family — meaning k:STAMPField[], the same
                        shared purpose again, fields k:PublicIDField[]/k:UniquelyIdentifyKnowledgeGraphComponents[]
                        and k:STAMPVersionsField[]/k:STAMPVersionsSet[].

                        The version side mirrors this, with its own shared purpose concept:
                        k:ComponentVersionPattern[] and k:ConceptVersionPattern[] each carry a
                        referenced-component meaning of k:ComponentVersionsField[] or k:ConceptVersionsField[]
                        respectively, and a purpose of k:VersionSnapshot[] — why every version-shape pattern
                        exists: to record one point-in-time state of a chronicle. Each has a single field,
                        k:STAMPField[] (meaning) for k:VersionProvenance[] (purpose) — a version, at its
                        simplest, is just its own STAMP, recorded for provenance: who committed it, in what
                        state, module, path, and when. k:SemanticVersionFieldPattern[] adds a second field to
                        that base shape — meaning k:SemanticVersionsField[], the same shared purpose, fields
                        k:STAMPField[]/k:VersionProvenance[] and (already correctly distinct) meaning
                        k:SemanticFieldField[] for purpose k:SemanticFieldFieldsSet[] — a semantic's own
                        version must also carry the actual field values that version holds.
                        k:STAMPVersionFieldPattern[] is the richest of the chronicle/version family: meaning
                        k:STAMPVersionsField[], the same shared purpose, and six fields —
                        k:STAMPField[]/k:VersionProvenance[], plus k:StatusField[]/k:StatusForVersion[],
                        k:TimeField[]/k:TimeForVersion[] (data type k:StringDataType[]),
                        k:AuthorField[]/k:AuthorForVersion[], k:ModuleField[]/k:ModuleForVersion[], and
                        k:PathField[]/k:PathForVersion[] — the same k:StatusForVersion[]/k:AuthorForVersion[]/
                        k:ModuleForVersion[]/k:PathForVersion[]/k:TimeForVersion[] purpose concepts this guide's
                        own STAMP pattern (see the STAMP Concepts chapter) also uses; the base-model layer
                        specializes those five fields into a single, more directly authored five-field pattern.
                        k:PatternVersionPattern[] is richer still: meaning k:PatternVersionsField[], the same
                        shared purpose, and four fields — k:STAMPField[]/k:VersionProvenance[],
                        k:PatternMeaningField[] (meaning) for k:MeaningDeclaration[] (purpose),
                        k:PatternPurposeField[] (meaning) for k:PurposeDeclaration[] (purpose), and
                        k:FieldDefinitionField[] (purpose k:FieldDefinitionsSet[], data type
                        k:ComponentIdSetDataType[]) — literally the shape behind every pattern declaration in
                        this starter set's own source: the meaning, purpose, and field-definition list every
                        pattern this guide names is itself an instance of.

                        A semantic's own properties are named separately from its host chronicle's:
                        k:SemanticProperties[] groups k:ComponentForSemantic[] (which pattern it is of),
                        k:ReferencedComponentNidForSemantic[] (what it is attached to), k:LogicGraphForSemantic[]
                        (its axiom graph, when it carries one), and k:SemanticFieldName[] (a field's own name
                        within it). k:ConceptType[] names special *concept* kinds rather than component
                        kinds — k:AnonymousConcept[] (defined on the fly, without a dedicated name),
                        k:PathConcept[] (a concept that is itself a version-control path), and
                        k:SemanticFieldConcepts[] (a concept minted to serve as one semantic's field
                        value).""");

        set.concept("Object (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: Object (Tinkar Base Model — Base Model Primitives)")), """
                        Beneath k:Object[] sit the primitives every other component kind is ultimately built
                        from: k:NID[] names the native-store integer identity every component resolves to at
                        runtime — never replay-stable, so this guide's own tooling never renders one — and
                        k:AnyComponent[] is the generic container a field can hold when its value might be
                        any component kind at all, rather than one narrowed by a field's own data type.

                        Three further concepts under k:Object[] are sentinels, not real modeled content:
                        k:BlankConcept[] is a placeholder meaning no meaningful concept value applies to a
                        field — this starter set's own constraint apparatus deliberately carries no such
                        sentinel: one constraint pattern per parameter shape means every field of every
                        constraint semantic is meaningful — while k:SandboxComponent[] and k:UninitializedComponent[] mark a
                        component as belonging to a sandbox authoring session or as not yet initialized,
                        respectively, rather than describing any real, committed content.

                        k:PropertySequence[], k:ReflexiveFeature[], and k:TransitiveFeature[] round out this
                        base model with description-logic property characteristics inherited from SOLOR: a
                        reflexive property relates every concept to itself; a transitive property, if it
                        relates A to B and B to C, also relates A to C — mathematical characteristics a
                        role's own semantics can carry, layered on top of the role terminology this guide's
                        EL++ Concepts chapter already named.""");

        // Chapters 11-20 (IKE-Network/ike-issues#880, second pass): the remaining taxonomy
        // groups deferred from the first manuscript-expansion pass.

        set.concept("Value Constraint (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ValueConstraint (Value Constraints and Reference Ranges)")), """
                        Where k:TaxonomyFieldConstraintPattern[] and k:ValueSetFieldConstraintPattern[]
                        restrict which values are legal for a *pattern field*,
                        k:ValueConstraint[] restricts which *literal values* are legal for a component —
                        a numeric-domain cousin, and a much older idea in this starter set:
                        k:ValueConstraintPattern[]
                        (introduced in the EL++ Concepts chapter's Concrete Value Operators subsection) is
                        the pattern that carries it. k:ValueConstraintSource[] names the organization that
                        specifies the constraint — a reference-range source, for instance — and
                        k:ReferenceRange[] groups the two endpoints a numeric constraint actually bounds:
                        k:ReferenceRangeMinimum[] and k:ReferenceRangeMaximum[]. Together with
                        k:ConcreteValueOperator[]'s comparison operators, this terminology is what a
                        lab-value or dose constraint is actually built from — a component "has specific value
                        requirements that need to be met," in k:ValueConstraint[]'s own words, exactly the
                        framing the Semantic Field Model chapter's constraint patterns use for pattern
                        fields, just one domain over.

                        As a pattern, k:ValueConstraintPattern[] itself carries a referenced-component meaning
                        of k:ValueConstraint[] and a purpose of k:NumericValueRestriction[] — the
                        numeric-domain counterpart to k:FieldValueRestriction[] — and six fields, each with
                        its own meaning and purpose concept: k:ValueConstraintSource[] (meaning) for
                        k:ReferenceRangeAuthority[] (purpose — which organization specifies the constraint);
                        k:MinimumValueOperator[] and k:MaximumValueOperator[] (meaning) for
                        k:ConcreteValueOperator[] (purpose); k:ReferenceRangeMinimum[] and
                        k:ReferenceRangeMaximum[] (meaning) for k:ReferenceRange[] (purpose); and
                        k:ExampleUCUMUnits[] (meaning) for k:UnitExample[] (purpose — a representative unit
                        of measure for the constrained value, for a reader's reference).

                        k:DescriptionLogicProfile[] names the description-logic profile a set of axioms
                        classifies against — k:ELLogicProfile[] is this starter set's own (EL++, already
                        introduced in the EL++ Concepts chapter) — grouped here because it is, like
                        k:ValueConstraint[], a property *of* a component's logical shape rather than a
                        taxonomy-organizing concept in its own right.""");

        set.concept("Action properties (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ActionProperties (Authoring Actions and Legacy Constraints)")), """
                        k:ActionProperties[] groups the attributes of an authoring *action* — a step Komet
                        or another editor takes on the author's behalf, rather than a property of the
                        content itself. k:ConceptToFind[] names a concept a search action is looking for;
                        k:ConditionalTriggers[] names conditions, based on actions or the reasoner, that fire
                        further behavior; k:RoleTypeToAdd[] names the role type an "add role" action would
                        insert.

                        k:ConceptConstraints[] deserves particular attention here, having already been named
                        once in this guide's Semantic Field Model chapter: a real, if long-dormant, SOLOR
                        concept defined simply as "defined filters for a given concept" — a gloss close
                        enough to the constraint patterns' own purpose that the two are worth contrasting
                        directly. k:ConceptConstraints[] carries no field shape, no worked example, and no
                        consuming code anywhere in this ecosystem; it is a name for the idea of constraining
                        a concept, sitting here among other action-related SOLOR imports, never wired to
                        anything. k:TaxonomyFieldConstraintPattern[] and k:ValueSetFieldConstraintPattern[]
                        are the KB-native mechanism this starter set
                        actually built and demonstrated once that same need became concrete — reusing
                        k:ConceptConstraints[]'s identity was considered and deliberately declined, precisely
                        because a name alone, unaccompanied by any real structure, is not enough to safely
                        resume.""");

        set.concept("Description type").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: DescriptionType (Feature-Based and Intrinsic Roles)")), """
                        k:DescriptionType[] is best known from the Language Concepts chapter as the parent of
                        k:FullyQualifiedNameDescriptionType[], k:RegularNameDescriptionType[], and
                        k:DefinitionDescriptionType[] — but its remaining children are a different family
                        entirely: feature- and role-modeling refinements imported from SOLOR alongside the
                        description-type terminology, not further description types themselves.
                        k:IntrinsicRole[] and k:UnmodeledRoleConcept[] extend this guide's own EL++ Concepts
                        chapter — an intrinsic role is one inherent to a concept's own definition rather than
                        externally imposed, while an unmodeled role concept marks a relationship SNOMED CT or
                        Tinkar has not yet formally captured as a role. k:PropertySet[] and k:Feature[]
                        describe concrete-domain properties a concept can carry — the same family
                        k:ConcreteValueOperator[] and k:ValueConstraint[] operate on, with k:FeatureType[]
                        naming which kind of feature a given one is — and k:PropertyPatternImplication[] and
                        k:ConceptPatternForLogicCoordinate[] round out
                        the property-modeling side.

                        k:ExtendedRelationshipType[] and k:InverseName[] handle terminology-import edge
                        cases: a relationship type from an imported terminology that maps onto a SNOMED
                        relationship (such as is-a), and a description explicitly marked as the inverse of
                        an association's own name. k:DynamicReferencedComponentRestriction[] narrows which
                        component types a dynamic field's referenced component may legally be — the same
                        restriction idea the Roles and Role Operators subsection's
                        k:ReferencedComponentTypeRestriction[]/k:ReferencedComponentSubtypeRestriction[]
                        already introduced, here at the field-validation level rather than the axiom level.
                        k:SOLORModule[] and k:SOLOROverlayModule[] name the module and overlay-module SOLOR's
                        own imported content is stamped with — SOLOR's counterpart to this starter set's own
                        k:DevelopmentModule[]/k:PrimordialModule[]. k:DescriptionCoreType[] and
                        k:ExtendedDescriptionType[] close the loop back to descriptions proper: a marker for
                        a non-SNOMED description that still matches one of SNOMED's core types, and one that
                        does not.""");

        set.concept("Annotation type (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: AnnotationType (Annotations, Correlations and Editor Focus)")), """
                        k:AnnotationType[] groups metadata *about* a component rather than the component's
                        own defining content: k:Comment[] is free text an author attaches when something
                        needs explaining (this starter set's own k:CommentPattern[] carries exactly this),
                        and k:KometIssue[] is Komet's own specialization — an annotation type Komet itself
                        defines, layered on top of the generic annotation terminology. k:AnnotationPropertySet[]
                        names the SOLOR-imported set these annotation properties draw from.

                        As a pattern, k:CommentPattern[] originally carried, straight from its SOLOR
                        source, a referenced-component meaning and purpose of k:Comment[] for both slots,
                        with its single field also using k:Comment[] as both its own meaning and purpose —
                        four slots, one concept, conflating "what the field holds" (a comment) with "what
                        role the referenced component plays" (the subject that commentary is about). A
                        later revision splits these apart: the pattern's referenced-component meaning is now
                        k:SubjectOfCommentary[] — the referenced component's role, distinct from the
                        commentary's own content type — and its purpose is k:EditorialClarification[] — why
                        the commentary exists: to explain an authoring decision or provide context a formal
                        field can't capture. The field itself keeps k:Comment[] as its meaning (that part was
                        always correct — the field genuinely does hold a comment) but now carries
                        k:EditorialClarification[] as its purpose too, the same concept reused at both
                        levels; its data type, k:StringDataType[], is unchanged. Tinkar's own
                        `PatternVersion` model supports this cleanly: the original SOLOR-sourced version
                        stays in history untouched, and a `StampCoordinate` positioned after the revision
                        simply resolves the newer one. Two more small patterns round out this starter set's
                        own editorial
                        metadata: k:StarterSetAuthorRosterPattern[] (this guide's own illustrative value-set
                        example, introduced in the Semantic Field Model chapter) carries a referenced-component
                        meaning of k:StarterSetAuthorRoster[] and a purpose of k:RosterMembership[] — why the
                        pattern exists, to enumerate this starter set's own author roster as a value-set
                        source — and two fields: k:RosterAuthor[] (meaning) for k:RosterEntry[] (purpose) and
                        k:RosterOrder[] (meaning) for k:DisplaySequence[] (purpose, data type k:Long[]) — the
                        sort-order field that makes it a genuine two-field worked example for value-set field
                        disambiguation. k:PreferredReviewerPattern[] carries a referenced-component meaning of
                        k:PreferredReviewerAssignment[] and a purpose of k:ReviewRouting[] — why the pattern
                        exists, to direct a component's future edits to a specific reviewer — and one field,
                        k:PreferredReviewer[] (meaning) for k:AssignedReviewer[] (purpose) — which author is
                        the preferred reviewer for a given component's future edits.

                        k:CorrelationProperties[] groups a different kind of metadata: characteristics
                        describing the relationship *between* two or more variables, rather than an
                        annotation on one component alone. k:CorrelationExpression[] and
                        k:CorrelationReferenceExpression[] name the value and the reference value a
                        correlation compares.

                        k:ComponentTypeFocus[] names which kind of component an editor's attention is
                        currently on — k:AxiomFocus[], k:ConceptFocus[], and k:DescriptionFocus[] — a
                        UI-facing concern distinct from any of the component-kind concept families (concept,
                        pattern, semantic) this guide's Tinkar Base Model chapter already named, since
                        "focus" describes where an author is looking, not what a component is.
                        k:ConceptDetailsTreeTable[] names the tree-table view Komet renders a concept's
                        details in — one editor surface among several a concept's data can project
                        through.""");

        set.concept("Identifier Source").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: IdentifierSource (Identifiers)")), """
                        k:IdentifierSource[] names which identifier-issuing authority a component's
                        alternate identifier came from — the field-meaning concept k:IdentifierPattern[]
                        itself declares a field for. k:UNIVERSALLYUNIQUEIDENTIFIER[] is the one identifier
                        source every component in this starter set actually carries: the UUID itself, which
                        uniquely represents a concept in Tinkar independent of any external terminology's own
                        identifier scheme. k:IdentifierValue[] names the field holding the literal identifier
                        string once a source has been chosen — an SCTID, an external code, or, for the
                        universally-unique-identifier source, the UUID's own text form.

                        As a pattern, k:IdentifierPattern[] itself carries a referenced-component meaning of
                        k:IdentifiedComponent[] — the component an external identifier names, distinct from
                        the field-level k:IdentifierSource[] the discussion above named — and a purpose of
                        k:ExternalIdentityMapping[]: why the pattern exists, to record an alternate
                        identifier a component carries in an external terminology's own identifier scheme.
                        Two fields each carry their own meaning and purpose: k:IdentifierSource[] (meaning)
                        for k:IdentifierAuthority[] (purpose — which authority issued the identifier) and
                        k:IdentifierValue[] (meaning) for k:IdentifierText[] (purpose — the identifier's own
                        literal text).""");

        set.concept("Language coordinate properties (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: LanguageCoordinateProperties (Coordinate Properties: Language and"
                                        + " Path)")), """
                        The Language Concepts chapter already named k:LanguageCoordinateProperties[]'s own
                        four preference-list fields in the course of explaining how a `LanguageCoordinate`
                        resolves a description; k:LanguageCoordinateName[] and
                        k:DialectPatternPreferenceListForLanguageCoordinate[] are two of that same
                        coordinate's own field-meaning concepts, named here directly as members of the
                        property group they belong to, rather than only implicitly through the
                        preference-list discussion.

                        k:PathCoordinateProperties[] plays the analogous role for k:Path[]:
                        k:PathCoordinateName[] names the coordinate's own name field, and k:PathOrigins[]
                        names which path a path itself branched from — the same idea the STAMP Concepts
                        chapter's Path subsection already introduced as k:PathOriginsForStampPath[], here at
                        the coordinate-property level rather than the individual-path level.""");

        set.concept("Tree amalgam properties (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: TreeAmalgamProperties (Tree Amalgams)")), """
                        k:TreeAmalgamProperties[] names the property group behind a composite navigation
                        tree — a view that blends more than one taxonomy tree into a single presentation,
                        rather than walking one k:NavigationVertex[] structure alone. k:TreeList[] names the
                        member trees an amalgam combines, and k:InverseTreeList[] names the same idea
                        inverted — the trees an amalgam excludes, or walks in reverse, depending on how a
                        particular amalgam is configured. Komet's own multi-hierarchy navigation views (a
                        concept's SNOMED-style parents alongside its Tinkar-model parents, say, blended into
                        one tree) are exactly the kind of view this property group exists to support.""");

        set.concept("Phenomenon").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: Phenomenon (Clinical Phenomena and Domain Content)")), """
                        Every chapter so far has described this starter set's own meta-schema — the
                        terminology Tinkar and this starter set use to describe knowledge, not any particular
                        domain's content. k:Phenomenon[] is different: it groups genuine, if sparse, seed
                        *domain* content — "a unique thought, fact, or circumstance," in its own words —
                        included here to show what real authored content looks like sitting on top of
                        everything the rest of this guide describes. k:HealthConcept[] and
                        k:UncategorizedPhenomenon[] are its two organizing children, and
                        k:ExampleUCUMUnits[] names a field carrying example Unified Code for Units of Measure
                        values for a given term — the concrete-value terminology the EL++ Concepts chapter's
                        Concrete Value Operators subsection already introduced, applied here to real
                        measurement content rather than described only in the abstract.

                        k:HasActiveIngredient[], k:HasDoseForm[], and k:Laterality[] are three more seed
                        domain attributes, each a SOLOR-imported relationship type rather than a meta-schema
                        concept: a medicinal product's active ingredient, its dose form, and a finding or
                        procedure's left/right/bilateral sidedness — small, recognizable examples of exactly
                        the kind of role this guide's Roles and Role Operators subsection described in the
                        abstract, now anchored to real clinical content.""");

        set.concept("Object Properties (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ObjectProperties (Object Properties and Relationships)")), """
                        k:ObjectProperties[] names the general property-holding terminology every more
                        specific property group in this guide — k:ChronicleProperties[],
                        k:SemanticProperties[], k:ActionProperties[], k:CorrelationProperties[],
                        k:LanguageCoordinateProperties[], k:PathCoordinateProperties[],
                        k:TreeAmalgamProperties[], k:AnnotationPropertySet[], k:DataPropertySet[], and
                        k:PropertySequenceImplication[] among them — ultimately descends from: "objects are
                        instances of classes; properties describe the data an object can have," in its own
                        words.

                        k:RelationshipDestination[] and k:RelationshipOrigin[] name the two directions a
                        relationship between concepts can be walked: destination toward more specific, child
                        concepts, and origin toward more general, parent concepts — the same is-a direction
                        this guide's Navigation Coordinates chapter already described through
                        k:NavigationVertex[]'s own parent/child fields, named here as the generic
                        relationship-direction terminology those fields draw from. k:DataPropertySet[] and
                        k:PropertySequenceImplication[] close out the property family: a set of data-carrying
                        properties, and an implication one property sequence carries for another.""");

        set.concept("Integrated Knowledge Management (SOLOR)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: IntegratedKnowledgeManagement (Provenance and Root)")),
                        """
                        k:IntegratedKnowledgeManagement[] is the concept nearly every root-level concept family
                        in this guide ultimately descends from — k:ModelConcept[], k:Author[], k:Module[],
                        k:Path[], k:StatusValue[], k:Object[], k:AnnotationType[], k:Phenomenon[], and
                        k:CreativeCommonsBYLicense[] among them — "terminologies represented in a harmonized
                        manner," in its own words: the single organizing idea that this starter set,
                        Tinkar's own base model, and SOLOR's imported terminology are all, ultimately, one
                        coherent knowledge representation rather than three unrelated things bolted together.

                        k:IkeFoundationRoot[] is this starter set's own root, by contrast — the concept this
                        guide's very first chapter named as the anchor its whole append-only ledger is
                        rooted at, a child of k:ModelConcept[] rather than of
                        k:IntegratedKnowledgeManagement[] directly, since it is IKE's own specific starter
                        content, not a generic model concept. k:CreativeCommonsBYLicense[] names the license
                        this starter set's own content is released under.

                        A handful of component-chronicle-level fields round out this guide's coverage:
                        k:ConceptVersion[] captures which version of a source terminology a concept came
                        from, and k:Description[], k:DescriptionListForConcept[], k:DescriptionSemantic[],
                        and k:TextForDescription[] name the description-pattern fields the Language Concepts
                        chapter's own prose already explained in practice — cited here directly, by their own
                        field-meaning identity, for a reader who arrived at this guide's final chapter
                        looking for exactly this list.""");
    }
}
