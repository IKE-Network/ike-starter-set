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
    }
}
