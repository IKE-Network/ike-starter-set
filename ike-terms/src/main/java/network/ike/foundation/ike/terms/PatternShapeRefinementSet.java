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

/**
 * Refines an already-adopted pattern's own declared shape (meaning, purpose, field
 * definitions) where the SOLOR/Tinkar-inherited version collapses meaning and purpose
 * into the same concept — a real modeling weakness KEC flagged reviewing the rendered
 * pattern-shape table (IKE-Network/ike-issues#880): reusing one concept for both loses
 * the distinction Tinkar's own model intends — meaning names what kind of thing this is,
 * purpose names why it is captured. Each pattern here is resumed by its already-adopted
 * identity ({@code foundation.Section71}'s own birth FQN, not hand-edited — that class
 * is regeneration-locked) and given a new {@code PatternVersion} layered on top via the
 * append-only ledger ({@code PatternBuilder}'s versioning model restates meaning,
 * purpose, and fields as a whole on each new version): the original SOLOR-sourced
 * version stays in history untouched; a {@code StampCoordinate} positioned after this
 * file's stamp resolves this revision instead.
 * <p>
 * This is a pilot for one pattern (Comment pattern) — a broader audit across the other
 * 30 patterns in this starter set is expected to follow, each proposed and confirmed
 * individually before landing here, not applied wholesale.
 *
 * <h2>Comment pattern</h2>
 * The SOLOR-inherited version sets meaning = purpose = {@code Comment} for both the
 * pattern's own referenced component and its single field — four slots, one concept.
 * That conflates two genuinely different things: "a field that holds a comment" (a
 * content-type classification — {@code Comment} is the correct meaning for the *field*)
 * versus "a pattern that enables commenting" (a role the *referenced component* plays —
 * it isn't itself a comment, it's the subject commentary is attached to). This revision:
 * <ul>
 *   <li>referenced-component meaning → {@code Subject of Commentary} (new) — the
 *   referenced component's role: the subject this pattern's commentary is about</li>
 *   <li>referenced-component purpose → {@code Editorial Clarification} (new) — why the
 *   commentary exists: explaining an authoring decision or providing context a formal
 *   field cannot capture, for a future reviewer or maintainer</li>
 *   <li>field meaning → {@code Comment} (unchanged — correctly names the field's own
 *   content type)</li>
 *   <li>field purpose → {@code Editorial Clarification} (the same concept as above,
 *   reused — the field's value serves the same functional role as the pattern as a
 *   whole)</li>
 * </ul>
 */
final class PatternShapeRefinementSet {

    private PatternShapeRefinementSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // Later than every other authoring pass in this project (2026-07-12/-13/-15):
        // this file revises already-adopted patterns, so it must follow every scope that
        // already touches them.
        ActiveStamp refinement = Stamp.active("2026-07-16T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        set.concept("Subject of Commentary (IkeFoundation)").at(refinement)
                .synonym("Subject of Commentary")
                .definition("The referenced-component role a Comment Pattern semantic's"
                        + " attachment target plays: the subject free-text commentary is"
                        + " about — distinct from Comment, which names the commentary's"
                        + " own content type, not the component being commented on.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Editorial Clarification (IkeFoundation)").at(refinement)
                .synonym("Editorial Clarification")
                .definition("Why a free-text comment is captured: to explain an authoring"
                        + " decision or provide context a formal field cannot, for a future"
                        + " reviewer or maintainer.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.pattern("Comment pattern").at(refinement)
                .meaning(set.conceptRef("Subject of Commentary (IkeFoundation)"))
                .purpose(set.conceptRef("Editorial Clarification (IkeFoundation)"))
                .field(IkeTerm.COMMENT, set.conceptRef("Editorial Clarification (IkeFoundation)"), IkeTerm.STRING);
    }
}
