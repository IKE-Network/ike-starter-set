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
 * Mints a top-level {@code Legacy} branch and moves dormant/superseded content there as a
 * visible deprecation signal (IKE-Network/ike-issues#880 follow-up) — reparenting, not
 * retiring: the content stays live and resolvable, just flagged in the taxonomy as a
 * near-future removal candidate rather than left silently mixed in among current vocabulary.
 * <p>
 * First occupant: {@code Dynamic column data types (SOLOR)} ({@code DynamicColumnDataTypes}
 * and its 9 children — Boolean/Decimal/Float/Double/Long/Array/ByteArray/SignedInteger/
 * UUIDDataType). Investigation (this session) found it is <em>not</em> dead: {@code komet}'s
 * {@code PatternFieldsController} (kview) walks its descendants to populate a pattern-authoring
 * "choose a data type" list — but that list is disconnected from {@code ConceptToDataType}'s
 * own 15-concept recognized set (the {@code ...field}/{@code ...display field} family a
 * pattern's real field declarations actually use), so picking from it would produce a field
 * whose declared dataType throws {@code UnsupportedOperationException} if ever resolved. Filed
 * as ikmdev/komet#{@code TODO} to track elimination on the komet side; reparenting here just
 * flags the starter-set content as legacy in the meantime, it doesn't fix the komet-side gap.
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
        // Later than every other authoring pass in this project (2026-07-12/-13/-15/-16/-17):
        // this file revises an already-adopted concept's own stated axioms, so it must follow
        // every scope that already touches it.
        ActiveStamp legacy = Stamp.active("2026-07-18T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        set.concept("Legacy (IkeFoundation)").at(legacy)
                .synonym("Legacy")
                .definition("A visible deprecation signal, not a functional restriction:"
                        + " content reparented here is dormant or superseded and a candidate"
                        + " for removal in a near-future revision. Being under Legacy says"
                        + " nothing about whether the content is still resolvable or"
                        + " referenced elsewhere -- it may well be -- only that it is no"
                        + " longer this project's preferred vocabulary going forward.")
                .isA(set.conceptRef("Integrated Knowledge Management (SOLOR)"));

        // Reparent Dynamic column data types under Legacy -- restating its own declared
        // stated-axioms UUID (from foundation.Section41) with new content is a new version of
        // the same semantic, exactly the mechanism AssemblageTerminologySet already used for
        // description revisions, applied here to an axiom revision instead.
        set.concept("Dynamic column data types (SOLOR)").at(legacy)
                .statedAxioms(PublicIds.of(UUID.fromString("32b38296-36d0-55f4-b372-da94e78be9da")),
                        leb -> leb.NecessarySet(leb.And(
                                leb.ConceptAxiom(set.conceptRef("Legacy (IkeFoundation)")))));
    }
}
