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
 * Retires "assemblage" from this starter set's own vocabulary (IKE-Network/ike-issues#880,
 * follow-up to the pattern-shape rigor pass): KEC's rule — treat "assemblage" the same
 * way this project already treats the other rejected philosophical/OWL-baggage term for
 * describing IKE's own work. Pattern is the modern equivalent Tinkar itself settled on: a
 * pattern's own semantics — the components carrying that pattern's public id — already
 * are the set "assemblage" used to name.
 * <p>
 * Four SOLOR-inherited concepts carry "assemblage" directly in their birth fully
 * qualified name ({@code foundation.Section*} — regeneration-locked, not hand-edited,
 * one apiece scattered across {@code Section3}/{@code Section13}/{@code Section18}).
 * Their identity is untouched; each gets a new, later-active FQN and definition. Because
 * this is identity-exact ingested content, every one of its descriptions — FQN, regular
 * name, definition — was originally declared via the <em>generic</em> declared-identity
 * semantic verb ({@code ActiveScope.semantic(DESCRIPTION_PATTERN, declaredIdentity,
 * fieldValues...)}), each with its own explicit UUID replicated from the original SOLOR
 * data — not via the rich convenience verbs ({@code synonym}/{@code definition}/
 * {@code reviseFullyQualifiedName}), which only operate on derived-identity descriptions
 * and reject these with "declared explicitly with their established identities." So the
 * revision here restates each of those same declared UUIDs with new text — exactly the
 * "restating the same declared identity in a later scope appends a version of the same
 * semantic" behavior the generic verb already documents — a real new version, the prior
 * SOLOR-sourced text preserved in history, not erased. The derived {@code k:} identifier
 * used throughout the narrative therefore changes to match the new text: this is the
 * expected, desired behavior (KEC), not a hazard to guard against — the entity's real
 * identity (its {@code PublicId}) is what stays stable, never the display-derived lookup
 * key.
 * <p>
 * {@code SOLORConceptAssemblage} (the pattern) is left untouched entirely — it is
 * dormant (zero live semantics anywhere in the ingested foundation, confirmed before this
 * file was written) — and is cited in the narrative only as legacy prior art, the same
 * treatment already given {@code TinkarTerm.CONCEPT_CONSTRAINTS} when
 * {@code ConstraintPatternSet} was minted. {@code Solor Concepts Pattern (IkeFoundation)}
 * is the fresh IKE-native replacement going forward.
 * <p>
 * "Membership pattern" also replaces "membership tag"/"tagging convention" as the
 * standard phrase for this shape (a referenced-component meaning, a purpose of
 * {@code Set membership}, no fields) everywhere it appears — including the two
 * SOLOR-inherited membership patterns that were already correctly modeled
 * (meaning ≠ purpose) and so were out of scope for the earlier pattern-shape-rigor pass:
 * {@code Tinkar base model component pattern}, {@code Komet base model component
 * pattern}, and {@code Version control path pattern} each get a new version here,
 * replacing their purpose — {@code Membership semantic (SOLOR)}, itself a SOLOR-inherited
 * concept, name unchanged, still real, just no longer this project's own preferred
 * vocabulary — with the freshly minted {@code Set membership (IkeFoundation)}.
 */
final class AssemblageTerminologySet {

    private AssemblageTerminologySet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // Later than every other authoring pass in this project (2026-07-12/-13/-15/-16):
        // this file revises already-adopted concepts and patterns, so it must follow
        // every scope that already touches them.
        ActiveStamp terminology = Stamp.active("2026-07-17T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        // ── Modernize the 4 SOLOR-inherited "assemblage"-labeled concepts ──────
        // Each restates its own original FQN-description and definition-description
        // declared UUIDs (from foundation.Section3/13/18) with new text -- a new version
        // of each same semantic, not a new semantic.
        set.concept("Concept assemblage for logic coordinate (SOLOR)").at(terminology)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a4575d99-48d9-4d4e-a8d3-e658d426ef49")),
                        IkeTerm.ENGLISH_LANGUAGE, "Concept pattern for logic coordinate",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3edd7840-34a7-4175-885f-cbe9edfa4e9c")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The pattern whose active semantics enumerate the SOLOR concepts a Logic"
                                + " Coordinate reasons over.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Stated assemblage for logic coordinate (SOLOR)").at(terminology)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2d2997f8-8dc5-4767-ad82-e94ce091582b")),
                        IkeTerm.ENGLISH_LANGUAGE, "Stated pattern for logic coordinate",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2dfed1d4-9003-489f-9072-7bfc29f54637")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The pattern an author's own stated axioms are recorded under, for a Logic"
                                + " Coordinate.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Inferred assemblage for logic coordinate (SOLOR)").at(terminology)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4e5c376b-4a0c-44f1-abf1-27756e4c3b91")),
                        IkeTerm.ENGLISH_LANGUAGE, "Inferred pattern for logic coordinate",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("24282ba0-9334-4d1c-91cf-99ac3e7403ec")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The pattern the classifier's derived axioms are written to, for a Logic"
                                + " Coordinate.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Dialect assemblage preference list for language coordinate (SOLOR)").at(terminology)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fc463462-1f62-40b2-abdb-269863ce2e64")),
                        IkeTerm.ENGLISH_LANGUAGE, "Dialect pattern preference list for language coordinate",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("96271b7b-9813-42b5-a119-236dffe2d399")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "The preference order among dialect patterns a Language Coordinate consults"
                                + " when resolving a description's acceptability.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        // ── The modern membership-pattern purpose concept ──────────────────────
        set.concept("Set membership (IkeFoundation)").at(terminology)
                .synonym("Set membership")
                .definition("A component's role as an element of a pattern's own set of"
                        + " semantics — the modern replacement for the deprecated SOLOR term"
                        + " Membership semantic.")
                .isA(IkeTerm.MODEL_CONCEPT);

        // ── Solor Concepts Pattern: the IKE-native replacement for the dormant ──
        // SOLORConceptAssemblage — untouched, cited as legacy prior art only.
        set.pattern("Solor Concepts Pattern (IkeFoundation)").at(terminology)
                .meaning(set.conceptRef("Concept assemblage for logic coordinate (SOLOR)"))
                .purpose(set.conceptRef("Set membership (IkeFoundation)"));

        // ── The other membership patterns, modernized to match ─────────────────
        set.pattern("Tinkar base model component pattern").at(terminology)
                .meaning(IkeTerm.STARTER_DATA_AUTHORING)
                .purpose(set.conceptRef("Set membership (IkeFoundation)"));

        set.pattern("Komet base model component pattern").at(terminology)
                .meaning(IkeTerm.STARTER_DATA_AUTHORING)
                .purpose(set.conceptRef("Set membership (IkeFoundation)"));

        set.pattern("Version control path pattern").at(terminology)
                .meaning(IkeTerm.PATH)
                .purpose(set.conceptRef("Set membership (IkeFoundation)"));
    }
}
