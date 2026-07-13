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
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.TinkarTerm;

/**
 * The concept section of the IkeFoundation ledger: the module concept, the set root, and
 * the set's content concepts. Sections name what, never when — delivery phasing
 * lives in issues, not source.
 */
final class ConceptSet {

    private ConceptSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // Curator identity resolved: author is Ike.IKE_COMMUNITY, minted below —
        // a derived-identity reference (T5 of the birth FQN), so citing it here,
        // before its own set.concept(...) call runs, is exactly as safe as the
        // forward reference to Ike.MODULE on the same line (IKE-Network/ike-issues#872).
        ActiveStamp inception = Stamp.active("2026-07-12T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        // Both anchor into the base taxonomy so a KB that loads base + this set
        // navigates to it from the root — no orphan forest.
        set.concept("IkeFoundation module (IkeFoundation)").at(inception)
                .synonym("IkeFoundation module")
                .definition("The module scoping every stamp of the IkeFoundation content"
                        + " set; the export dimension for this knowledge.")
                .isA(TinkarTerm.MODULE);

        set.concept("IkeFoundation root (IkeFoundation)").at(inception)
                .synonym("IkeFoundation root")
                .definition("Root concept of the Ike starter set.")
                .isA(TinkarTerm.MODEL_CONCEPT);

        // Community authorship: the IKE Network itself, attributed as author for
        // content synthesized by tooling on the Network's behalf (the
        // identity-exact starter-set ingest, #872) rather than by an individual
        // editor or an ingested upstream source. No dedicated "Author" taxonomy
        // root exists in TinkarTerm — USER is the only real anchor, and it's
        // exactly what this set's own stamps used as a placeholder before this.
        set.concept("IKE Community (IkeFoundation)").at(inception)
                .synonym("IKE Community")
                .definition("Community authorship: the IKE Network itself, attributed"
                        + " as author for content synthesized by tooling on the"
                        + " Network's behalf (e.g. the identity-exact starter-set"
                        + " ingest, IKE-Network/ike-issues#872) rather than by an"
                        + " individual editor or an ingested upstream source.")
                .isA(TinkarTerm.USER);

        // The ingested foundation (the full starter-set ingest, #872) composes
        // in Foundation.FoundationSet, wired from IkeSource. The IKE carriers
        // section (new (IKE)-tagged content) lands separately when the wave-2
        // coordination concludes.
    }
}
