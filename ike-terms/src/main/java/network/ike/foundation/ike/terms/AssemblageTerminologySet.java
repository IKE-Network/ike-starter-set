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
 * The modern membership-pattern terminology (IKE-Network/ike-issues#880): KEC's rule —
 * treat "assemblage" the same way this project already treats the other rejected
 * philosophical/OWL-baggage term for describing IKE's own work. Pattern is the modern
 * equivalent Tinkar itself settled on: a pattern's own semantics — the components
 * carrying that pattern's public id — already are the set "assemblage" used to name.
 * <p>
 * Under the inception flatten (IKE-Network/ike-issues#894) the four SOLOR-inherited
 * concepts that carried "assemblage" in their fully qualified names are corrected in
 * place at their section declarations ({@code foundation.Section3}/{@code Section13}/
 * {@code Section18}, registered in {@code DELIBERATELY_RENAMED_FQNS}), and the three
 * already-correctly-modeled membership patterns ({@code Tinkar base model component
 * pattern}, {@code Komet base model component pattern}, {@code Version control path
 * pattern}) carry {@code Set membership (IkeFoundation)} as the purpose of their single
 * declared version in {@code foundation.Section71}. This file mints that purpose concept
 * and the fresh IKE-native {@code Solor Concepts Pattern (IkeFoundation)}.
 * <p>
 * {@code SOLORConceptAssemblage} (the pattern) is left untouched entirely — it is
 * dormant (zero live semantics anywhere in the ingested foundation, confirmed before this
 * file was written) — and is cited in the narrative only as legacy prior art, the same
 * treatment already given {@code TinkarTerm.CONCEPT_CONSTRAINTS} when
 * {@code ConstraintPatternSet} was minted. {@code Solor Concepts Pattern (IkeFoundation)}
 * is the fresh IKE-native replacement going forward. {@code Membership semantic (SOLOR)}
 * itself stays real and unrenamed — just no longer this project's own preferred
 * terminology.
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
        // The one declared inception stamp of the pre-release set
        // (IKE-Network/ike-issues#894).
        ActiveStamp inception = Ike.INCEPTION;

        // ── The modern membership-pattern purpose concept ──────────────────────
        set.concept("Set membership (IkeFoundation)").at(inception)
                .synonym("Set membership")
                .definition("A component's role as an element of a pattern's own set of"
                        + " semantics — the modern replacement for the deprecated SOLOR term"
                        + " Membership semantic.")
                .isA(IkeTerm.MODEL_CONCEPT);

        // ── Solor Concepts Pattern: the IKE-native replacement for the dormant ──
        // SOLORConceptAssemblage — untouched, cited as legacy prior art only.
        set.pattern("Solor Concepts Pattern (IkeFoundation)").at(inception)
                .meaning(set.conceptRef("Concept pattern for logic coordinate"))
                .purpose(set.conceptRef("Set membership (IkeFoundation)"));
    }
}
