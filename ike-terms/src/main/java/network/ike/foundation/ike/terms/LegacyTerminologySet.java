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
 * Mints the top-level {@code Legacy} branch — a visible deprecation signal for
 * dormant/superseded content (IKE-Network/ike-issues#880 follow-up). Content filed here
 * stays live and resolvable, just flagged in the taxonomy as a near-future removal
 * candidate rather than left silently mixed in among current terminology.
 * <p>
 * First occupant: {@code Dynamic column data types (SOLOR)} ({@code DynamicColumnDataTypes}
 * and its 9 children — Boolean/Decimal/Float/Double/Long/Array/ByteArray/SignedInteger/
 * UUIDDataType). Investigation found it is <em>not</em> dead: {@code komet}'s
 * {@code PatternFieldsController} (kview) walks its descendants to populate a pattern-authoring
 * "choose a data type" list — but that list is disconnected from {@code ConceptToDataType}'s
 * own recognized set (the family a pattern's real field declarations actually use), so
 * picking from it would produce a field whose declared dataType throws
 * {@code UnsupportedOperationException} if ever resolved. Under the inception flatten
 * (IKE-Network/ike-issues#894) the reparent is written in place at the concept's section
 * declaration ({@code foundation.Section41}, registered in
 * {@code DELIBERATELY_REPARENTED_ISA}); this file contributes only the branch concept,
 * which that declaration cites by derived identity.
 * <p>
 * {@code Legacy} sits directly under {@code Integrated Knowledge Management (SOLOR)} — the
 * true root nearly every top-level branch in this guide descends from (see
 * {@code IntegratedKnowledgeManagement}'s own narrative) — as a sibling of
 * {@code ModelConcept}, {@code Author}, {@code Module}, and the rest, rather than nested under
 * any one of them: a deprecation signal is general-purpose and should be able to receive
 * content reparented out of <em>any</em> branch, not just the model-concept family
 * {@code Dynamic column data types} happened to be filed under.
 */
final class LegacyTerminologySet {

    private LegacyTerminologySet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // The one declared inception stamp of the pre-release set
        // (IKE-Network/ike-issues#894).
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Legacy (IkeFoundation)").at(inception)
                .synonym("Legacy")
                .definition("A visible deprecation signal, not a functional restriction:"
                        + " content reparented here is dormant or superseded and a candidate"
                        + " for removal in a near-future revision. Being under Legacy says"
                        + " nothing about whether the content is still resolvable or"
                        + " referenced elsewhere -- it may well be -- only that it is no"
                        + " longer this project's preferred terminology going forward.")
                .isA(set.conceptRef("Integrated Knowledge Management (SOLOR)"));
    }
}
