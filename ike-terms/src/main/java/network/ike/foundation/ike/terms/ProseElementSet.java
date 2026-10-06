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

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * Declares the shared prose-element apparatus at its foundation home
 * (IKE-Network/ike-issues#937): the "Prose element pattern (RichSurfaceTerms)" this
 * set's own narrative content attaches its prose semantics to
 * ({@link NarrativeContentSet}, {@link DefaultsAndTemplatesSet},
 * {@link DataTypeDefaultsSet}), and the three role concepts the pattern's declaration
 * references — its meaning (Prose element), its purpose and field purpose (Element
 * content), and its field meaning (Prose content). Before this section existed the
 * pattern was cited by a bare {@code EntityProxy} handle and never declared, so the
 * standalone artifact shipped dangling references — caught by the export accounting
 * (IKE-Network/ike-issues#933) and ruled by the closure principle this section
 * satisfies: every reference resolves within the set's own declarations; shared terms
 * are declared in ike-terms, and referencing sets reuse them, never the reverse.
 * <p>
 * The identities are adopted, not minted: each is the established RichSurfaceTerms
 * derivation {@code T5(eaa95241-1a1b-4c48-8266-4be1fe9124b0, birth FQN)} — the same
 * identities {@code rich-surface-starter-knowledge} declares — so the two sets converge
 * component-for-component when merged into one store, and the descriptions authored
 * here land on the same component-anchored semantic identities as rich-surface's own
 * (versions of one description, not duplicates). The (RichSurfaceTerms) birth tag is
 * kept: the tag records the set of birth, and adoption preserves identity, name
 * included.
 */
final class ProseElementSet {

    /**
     * Birth FQN of the shared prose-element pattern. Reference the pattern with
     * {@code set.patternRef(PROSE_ELEMENT_PATTERN_FQN)} after this section composes —
     * the registry answers the declared identity.
     */
    static final String PROSE_ELEMENT_PATTERN_FQN = "Prose element pattern (RichSurfaceTerms)";

    /**
     * The declared identity of the shared prose-element pattern, as a typed handle —
     * for callers that need the identity itself (fidelity gates, nid resolution) rather
     * than a session reference. Ledger sections reference the pattern with
     * {@code set.patternRef(PROSE_ELEMENT_PATTERN_FQN)}, which the registry resolves to
     * this same identity once {@link #compose(KnowledgeSet)} has declared it.
     */
    static final EntityProxy.Pattern PROSE_ELEMENT_PATTERN = EntityProxy.Pattern.make(
            PROSE_ELEMENT_PATTERN_FQN, PublicIds.of("89b831a1-e773-5f83-87a6-2cfc8e107fb0"));

    private ProseElementSet() {
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

        set.concept("Prose element (RichSurfaceTerms)",
                        PublicIds.of("e1d18f0d-77fb-572e-b395-62fb5de63257")).at(inception)
                .synonym("Prose element")
                .definition("An embedded prose block: the journal owns the content, carried"
                        + " as text on the prose element pattern.")
                .isA(EntityProxy.Concept.make("Model concept (SOLOR)", PublicIds.of("7bbd4210-381c-11e7-9598-0800200c9a66")));

        set.concept("Prose content (RichSurfaceTerms)",
                        PublicIds.of("cee59367-e4eb-5bbf-839e-453e4b686230")).at(inception)
                .synonym("Prose content")
                .definition("A prose block's text: lightweight markup whose inline concept"
                        + " references are id-bearing k: tokens — the interchange form.")
                .isA(EntityProxy.Concept.make("Model concept (SOLOR)", PublicIds.of("7bbd4210-381c-11e7-9598-0800200c9a66")));

        set.concept("Element content (RichSurfaceTerms)",
                        PublicIds.of("6507e073-af86-5ec3-bb26-35fde45c2bfe")).at(inception)
                .synonym("Element content")
                .definition("Carrying an element's content: the purpose shared by the"
                        + " element patterns and their fields.")
                .isA(EntityProxy.Concept.make("Model concept (SOLOR)", PublicIds.of("7bbd4210-381c-11e7-9598-0800200c9a66")));

        set.pattern(PROSE_ELEMENT_PATTERN_FQN,
                        PROSE_ELEMENT_PATTERN.publicId()).at(inception)
                .meaning(set.conceptRef("Prose element (RichSurfaceTerms)"))
                .purpose(set.conceptRef("Element content (RichSurfaceTerms)"))
                .field(set.conceptRef("Prose content (RichSurfaceTerms)"),
                        set.conceptRef("Element content (RichSurfaceTerms)"), KernelTerm.STRING)
                .synonym("Prose element pattern")
                .definition("An embedded prose block: text whose id-bearing k: tokens are"
                        + " the interchange form.");
    }
}
