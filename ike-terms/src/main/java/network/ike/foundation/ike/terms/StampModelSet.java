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
 * Mints the {@code STAMP} model concept (IKE-Network/ike-issues#952, under the KEC
 * audit directive: naming, quality textual definitions, proper logical definitions
 * including partonomy). The baseline carried the five dimension families — Status
 * value, Time, Author, Module, Path — whose own definitions each say "the … dimension
 * of a STAMP", yet no STAMP concept existed for that partonomy to point at. Each
 * dimension family now carries, alongside its is-a under {@code Model concept}, an
 * existential {@code Part of} restriction on the STAMP minted here — textual and
 * logical definitions saying the same thing, in the same breath, exactly as the
 * coordinate families do with {@code View coordinate model}
 * (IKE-Network/ike-issues#950).
 */
final class StampModelSet {

    private StampModelSet() {
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

        set.concept("STAMP (IkeFoundation)").at(inception)
                .synonym("STAMP")
                .definition("The versioning tuple every component version carries:"
                        + " Status, Time, Author, Module, and Path — the five dimensions"
                        + " that place a version in the knowledge space and that every"
                        + " coordinate filters by. Each dimension family is part of this"
                        + " model concept — stated logically as a transitive Part of"
                        + " restriction — mirroring the stamp record's composition in"
                        + " code.")
                .isA(IkeTerm.MODEL_CONCEPT);
    }
}
