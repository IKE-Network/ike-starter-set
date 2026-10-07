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

import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;

import java.util.UUID;

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
        ActiveStamp inception = Ike.INCEPTION;

        // Both anchor into the base taxonomy so a KB that loads base + this set
        // navigates to it from the root — no orphan forest.
        set.concept("IkeFoundation module (IkeFoundation)").at(inception)
                .synonym("IkeFoundation module")
                .definition("The module scoping every stamp of the IkeFoundation content"
                        + " set; the export dimension for this knowledge.")
                .isA(EntityProxy.Concept.make("Module (SOLOR)", PublicIds.of("40d1c869-b509-32f8-b735-836eac577a67")));

        set.concept("IkeFoundation root (IkeFoundation)").at(inception)
                .synonym("IkeFoundation root")
                .definition("Root concept of the Ike starter set.")
                .isA(EntityProxy.Concept.make("Model concept (SOLOR)", PublicIds.of("7bbd4210-381c-11e7-9598-0800200c9a66")));

        // Community authorship: the IKE Network itself, attributed as author for
        // content synthesized by tooling on the Network's behalf (the
        // identity-exact starter-set ingest, #872) rather than by an individual
        // editor or an ingested upstream source. No dedicated "Author" taxonomy
        // root exists in the kernel — USER is the only real anchor, and it's
        // exactly what this set's own stamps used as a placeholder before this.
        set.concept("IKE Community (IkeFoundation)").at(inception)
                .synonym("IKE Community")
                .definition("Community authorship: the IKE Network itself, attributed"
                        + " as author for content synthesized by tooling on the"
                        + " Network's behalf (e.g. the identity-exact starter-set"
                        + " ingest, IKE-Network/ike-issues#872) rather than by an"
                        + " individual editor or an ingested upstream source.")
                .isA(KernelTerm.USER);

        // SNOMED CT's identifier source, under the identity the SNOMED knowledge base already
        // gives its identifier semantics (ab9a0e0a is on every one of them) and the two
        // KernelTerm.SCTID also carries, so those semantics resolve to a concept of the set.
        set.concept("SCTID (SOLOR)", PublicIds.of(
                        UUID.fromString("0418a591-f75b-39ad-be2c-3ab849326da9"),
                        UUID.fromString("87360947-e603-3397-804b-efd0fcc509b9"),
                        UUID.fromString("ab9a0e0a-6359-5462-859c-96c3d4ef2341"))).at(inception)
                .synonym("SNOMED CT identifier")
                .definition("The identifier source of SNOMED CT identifiers (SCTIDs): an identifier"
                        + " semantic whose source is this concept carries the SNOMED CT identifier of"
                        + " the component it identifies.")
                .isA(KernelTerm.IDENTIFIER_SOURCE);

        // The ingested foundation (the full starter-set ingest, #872) composes
        // in Foundation.FoundationSet, wired from IkeSource. The IKE carriers
        // section (new (IKE)-tagged content) lands separately when the wave-2
        // coordination concludes.
    }
}
