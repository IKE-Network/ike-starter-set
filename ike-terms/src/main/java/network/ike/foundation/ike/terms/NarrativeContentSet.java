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

    private static final EntityProxy.Pattern PROSE_ELEMENT_PATTERN = EntityProxy.Pattern.make(
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
                        regular name, or the reverse), k:DialectAssemblagePreferenceListForLanguageCoordinate[]
                        (US before GB, or the reverse), and k:ModulePreferenceListForLanguageCoordinate[] (a
                        final tie-break when two descriptions are otherwise equally preferred). The calculator
                        matches language first, then walks description-type order, then prefers a dialect
                        acceptability of k:Preferred[] matching the dialect preference order, then breaks any
                        remaining tie by module preference.""");

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
                        ignore outright).""");

        set.concept("Path").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: Path (STAMP Concepts — Path)")), """
                        k:Path[] is the version-control lineage a version was committed on — the
                        k:PathField[] concept field. k:DevelopmentPath[] and k:PrimordialPath[] are this
                        starter set's own two paths; k:PathOriginsForStampPath[] records which path a path
                        itself branched from, so a `StampCoordinate` positioned on one path can still resolve
                        versions committed on an ancestor path before the branch point.""");

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

                        k:StatedAssemblageForLogicCoordinate[] names the pattern an author's own stated axioms
                        are recorded under (k:ELStatedAxiomsPattern[] in this starter set), and
                        k:InferredAssemblageForLogicCoordinate[] names the pattern the classifier's derived
                        axioms are written to (k:ELInferredAxiomsPattern[]) — stated is what was authored;
                        inferred is what the classifier concluded follows from it, computed, never
                        hand-written. k:ClassifierForLogicCoordinate[] names which classifier does that
                        computation (k:SnoRocketClassifier[] here), and
                        k:DescriptionLogicProfileForLogicCoordinate[] names the logic profile it classifies
                        against (k:ELLogicProfile[] — EL++, described below). k:RootForLogicCoordinate[]
                        anchors the whole taxonomy the coordinate reasons over.""");

        set.concept("Navigation vertex (SOLOR)").at(inception)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor("Narrative: NavigationVertex (Navigation Coordinates)")), """
                        Where a `LogicCoordinate` answers "what are this concept's axioms," a
                        `NavigationCoordinate` answers "what are this concept's parents and children" — a
                        faster question to ask repeatedly than re-deriving it from axioms every time.
                        k:StatedNavigationPattern[] and k:InferredNavigationPattern[] are the two caches
                        navigation can be read from — k:InferredNavigation[] the concrete pattern a
                        coordinate actually points at by default — each k:NavigationVertex[] recording a
                        concept's direct parents and children, filtered to whichever k:VertexStateSet[]
                        states the coordinate considers current.

                        Both are *derived*, not authored: a classifier run populates them from the stated (or
                        inferred) axioms, the same way it populates k:ELInferredAxiomsPattern[]. A freshly
                        authored ledger that has never been classified — this starter set's own, today — has
                        stated *axioms* (k:Axioms[] below) but no stated *navigation* at all yet, which is
                        exactly why this set's own documentation tooling reads taxonomy structure from stated
                        axioms directly rather than from navigation.""");

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
                        entire EL++ vocabulary — the classifier, the axiom patterns, the profile concept
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
                        Not every constraint in an EL++ definition names another concept — some constrain a
                        *literal* value instead: a lab reference range's upper bound, a dose's numeric
                        strength. k:ConcreteValueOperator[] is the parent of the comparison operators that
                        express these concrete-domain constraints: k:EqualTo[], k:GreaterThan[],
                        k:GreaterThanOrEqualTo[], k:LessThan[], k:LessThanOrEqualTo[], and the two range
                        endpoints k:MinimumValueOperator[] and k:MaximumValueOperator[]. These are exactly the
                        vocabulary k:ValueConstraintPattern[] draws on for its own min/max reference-range
                        fields (see the Semantic Field Model chapter) — concrete-domain reasoning is what lets
                        EL++ classification stay tractable even when a definition depends on a numeric
                        threshold, rather than requiring a distinct concept for every possible value.""");

        set.concept("Logical Definition").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: LogicalDefinition (EL++ Concepts — Logical Definitions and Grouping)")),
                        """
                        k:LogicalDefinition[] names the semantic value a stated or inferred terminological
                        axiom's own definition status carries — k:ELStatedConceptDefinition[] for what was
                        authored, k:ElInferredConceptDefinition[] for what the classifier concluded, mirroring
                        the same stated-versus-inferred split k:Axioms[] itself organizes around.

                        Two smaller, related vocabularies round out this set: k:Grouping[] distinguishes an
                        k:Exact[] match (source and target that are semantically or lexically identical) from
                        a k:Partial[] one, and k:DirectedGraph[] is the parent of k:ELDigraph[] — the directed
                        graph that results from classifying a full set of EL++ axioms, the data shape
                        k:SnoRocketClassifier[] itself produces and k:InferredNavigation[] is ultimately
                        derived from.""");

        // Semantic Field Model chapter (IKE-Network/ike-issues#880): the field-level meta-schema
        // — what kind of value a field holds, how it renders, and what its value can mean —
        // capped by Constraining Concept Fields, which introduces the new
        // ConceptFieldConstraintPattern (ConstraintPatternSet) this chapter is the natural home for.
        set.concept("Field categories").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: FieldCategories (Semantic Field Model — Field Categories)")), """
                        k:FieldCategories[] groups the field-level meta-schema concepts: the vocabulary
                        describing what *kind* of value a pattern's field holds, distinct from that field's
                        own particular meaning and purpose in any one pattern declaration.
                        k:ComponentField[] is the parent of every field kind whose value is a reference to
                        another component; k:ConceptField[] narrows that to concepts specifically, and is
                        itself the parent of the four STAMP-dimension field kinds this guide's STAMP chapter
                        already named — k:AuthorField[], k:ModuleField[], k:PathField[], k:StatusField[] —
                        plus k:FieldDefinitionMeaningField[] and k:FieldDefinitionPurposeField[], the field
                        kinds a pattern's own field definitions use to record each field's meaning and
                        purpose concepts: the same vocabulary every pattern declaration in this starter set's
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
                        k:DisplayFields[] captures a field's human-readable rendering in Komet's UI — display
                        type, not storage type: k:ConceptDisplayField[] shows a concept's human-readable
                        description rather than its raw identity, k:ComponentDisplayField[] the analogous
                        rendering for any component; k:ComponentIdDisplayList[] and k:ComponentIdDisplaySet[]
                        render an ordered or unordered collection of concept references, respectively.
                        k:StringDisplayField[], k:BooleanDisplayField[], k:IntegerDisplayField[],
                        k:FloatDisplayField[], k:DecimalDisplayField[], k:DoubleDisplayField[], and
                        k:ByteArrayDisplayField[] each render one of the primitive storage types;
                        k:ImageDisplayField[] and k:UUIDDisplayField[] round out the primitive display kinds.

                        Two structural kinds render graphs directly: k:DiGraphDisplayField[] (an ordered-pair
                        directed graph — the same shape k:ELDigraph[] takes) and k:DiTreeDisplayField[] (an
                        undirected tree with one designated root). k:LogicalExpressionDisplayField[] and
                        k:SemanticDisplayFieldType[] round out the set — a rendered axiom expression, and a
                        rendered list of a semantic's own fields, respectively.""");

        set.concept("Meaning").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: Meaning (Semantic Field Model — Field Value Vocabulary)")), """
                        k:Meaning[] is the broadest of these three groups: the vocabulary a pattern or
                        semantic's field draws its *interpretation* from, distinct from the field *category*
                        (k:FieldCategories[]) or *display* rendering (k:DisplayFields[]) vocabularies above.
                        k:DynamicColumnDataTypes[] names the actual storage data types a field's value can
                        take — k:Boolean[], k:Decimal[], k:Float[], k:Double[], k:Long[],
                        k:SignedInteger[], k:Array[], k:ByteArray[], and k:UUIDDataType[] — the same set a
                        pattern's own field declaration draws its data type from (`IkeTerm.LONG`,
                        `IkeTerm.STRING`, `IkeTerm.COMPONENT_FIELD`, and so on, throughout this starter set's
                        own source).

                        k:LiteralValue[] groups the value shapes a concrete field literal can take —
                        k:BooleanLiteral[] (TRUE/FALSE/UNKNOWN), k:FloatLiteral[], k:InstantLiteral[] — while
                        k:FieldSubstitution[] groups the analogous notion for a query template:
                        k:BooleanSubstitution[], k:ConceptSubstitution[], k:FloatSubstitution[],
                        k:InstantSubstitution[] each name what kind of value fills a placeholder when a
                        stored query actually runs. k:ConnectiveOperator[] (k:And[], k:Or[], k:PartOf[],
                        k:DisjointWith[]) and k:TaxonomyOperator[] (k:LogicallyEquivalentTo[]) round out the
                        operator vocabulary a field's meaning can name, and k:SemanticType[]
                        (k:ConceptSemantic[], k:ComponentSemantic[], k:MembershipSemantic[],
                        k:LogicalExpressionSemantic[]) names what kind of thing a whole semantic — not just
                        one field — represents.""");

        set.concept("Concept field constraint (IkeFoundation)").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ConceptFieldConstraint (Semantic Field Model — Constraining"
                                        + " Concept Fields)")), """
                        Some of the concept-typed field kinds above — k:AuthorField[], k:ModuleField[],
                        k:StatusField[], and others — are conventionally restricted to a known, bounded set
                        of legal values: only concepts kind-of k:Author[] make sense as a STAMP's author
                        field, only k:ActiveState[] and its k:StatusValue[] siblings as its status. Nothing in
                        the field-definition model above expresses that restriction — a field's declared data
                        type says it holds *a* concept, never *which* concepts. k:ConceptFieldConstraint[]
                        closes that gap: a semantic of this pattern, attached to the pattern being
                        constrained, names which of its fields is governed (k:ConstrainedField[], by that
                        field's own meaning concept) and which rule applies (k:ConstraintKind[]) — one of
                        k:KindOfFieldConstraint[] (the anchor concept plus every descendant, self included),
                        k:DescendantFieldConstraint[] (descendants only), k:LeafDescendantFieldConstraint[]
                        (leaf descendants only — excluding grouping concepts that exist only to organize
                        others), k:ImmediateChildFieldConstraint[] (direct children only), or
                        k:ValueSetFieldConstraint[] (membership in a named value set: every concept named by
                        an active semantic of another pattern, with k:ValueSetField[] naming which of that
                        pattern's own fields actually holds the concept, since it may carry other fields —
                        a sort order, for instance).

                        This starter set's own STAMP pattern demonstrates the taxonomy-relative kinds
                        directly: its author, module, and path fields are each constrained kind-of
                        k:Author[], k:Module[], and k:Path[] respectively, and its status field is
                        constrained to the immediate children of k:StatusValue[]. No tinkar-core code change
                        was needed to represent any of this — every constraint kind composes directly from
                        graph-walk operations a navigation calculator already provides; reading and enforcing
                        these constraints (in Komet's own concept-field editor, for instance) is a
                        deliberately separate, later concern from representing them.""");

        // Tinkar Base Model chapter (IKE-Network/ike-issues#880): the component/chronicle/
        // pattern-of-patterns meta-model every other chapter's own vocabulary ultimately
        // descends from.
        set.concept("Tinkar Model concept").at(expansion)
                .semantic(PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: TinkarModelConcept (Tinkar Base Model — Components and Chronicles)")),
                        """
                        k:ModelConcept[] anchors every concept in this guide that describes the knowledge
                        base's own structure rather than a domain it represents — the model-versus-data
                        distinction k:DataConcept[] draws on the other side (k:DefaultDataConcept[] and its
                        siblings group actual data values, not structural vocabulary). k:TinkarModelConcept[]
                        is the root of Tinkar's own meta-schema specifically: components, descriptions,
                        dialects, fields, and axioms — every chapter in this guide, from k:DescriptionPattern[]
                        to k:Axioms[] to k:FieldCategories[], ultimately descends from this one concept.

                        A component's persisted form is a *chronicle*: k:ChronicleProperties[] names what
                        every chronicle carries regardless of component kind — k:PrimordialUUIDForChronicle[]
                        (its own birth identity), k:SemanticListForChronicle[] (every semantic attached to
                        it), k:VersionListForChronicle[] (its own version history). k:ComponentChronologyPattern[]
                        and k:ComponentVersionPattern[] name the generic shape every chronicle/version pair
                        takes; k:ConceptVersionPattern[], k:PatternChronologyPattern[]/k:PatternVersionPattern[],
                        k:SemanticChronologyPattern[], and k:STAMPChronologyPattern[] specialize that shape for
                        each of the four component kinds this guide has already named. k:TinkarBaseModelComponentPattern[]
                        and k:KometBaseModelComponentPattern[] are membership tags, not shape descriptions: a
                        semantic of one of these patterns marks a component as belonging to Tinkar's own base
                        vocabulary or Komet's own — the same tagging convention k:SOLORConceptAssemblage[]
                        uses to mark a component as part of the SOLOR concept assemblage.

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
                        field — this starter set's own k:ConceptFieldConstraint[] semantics reuse exactly this
                        concept for the fields a given constraint kind doesn't use, rather than minting a
                        near-duplicate — while k:SandboxComponent[] and k:UninitializedComponent[] mark a
                        component as belonging to a sandbox authoring session or as not yet initialized,
                        respectively, rather than describing any real, committed content.

                        k:PropertySequence[], k:ReflexiveFeature[], and k:TransitiveFeature[] round out this
                        base model with description-logic property characteristics inherited from SOLOR: a
                        reflexive property relates every concept to itself; a transitive property, if it
                        relates A to B and B to C, also relates A to C — mathematical characteristics a
                        role's own semantics can carry, layered on top of the role vocabulary this guide's
                        EL++ Concepts chapter already named.""");
    }
}
