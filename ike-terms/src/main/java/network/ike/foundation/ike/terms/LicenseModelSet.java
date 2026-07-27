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
 * Mints the licensing family (IKE-Network/ike-issues#952, settled KEC 2026-07-26): the
 * set is dual-licensed — Creative Commons Attribution for the knowledge content and
 * Apache 2.0 alongside it — and the licenses themselves are model concepts, so both
 * belong in the set. {@code License} is the family root under {@code Model concept};
 * the baseline's {@code Creative Commons BY license} re-parents under it at its own
 * section declaration ({@code foundation.Section63}, registered in
 * {@code DELIBERATELY_REPARENTED_ISA}), and {@code Apache 2.0 license} is minted here
 * beside it. The same dual licensing is declared in every POM of the reactor.
 */
final class LicenseModelSet {

    private LicenseModelSet() {
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

        set.concept("License (IkeFoundation)").at(inception)
                .synonym("License")
                .definition("The model family for content licenses — the terms a"
                        + " knowledge artifact is published and consumed under. This"
                        + " set is dual-licensed: Creative Commons Attribution for the"
                        + " knowledge content, Apache 2.0 alongside it, declared in"
                        + " every POM of the reactor and carried here as concepts"
                        + " (IKE-Network/ike-issues#952).")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Apache 2.0 license (IkeFoundation)").at(inception)
                .synonym("Apache 2.0 license")
                .definition("The Apache License, Version 2.0: a permissive license"
                        + " permitting use, modification, and distribution with"
                        + " attribution and license notice. One of the two licenses"
                        + " this knowledge set is published under — Apache 2.0 together"
                        + " with Creative Commons BY (dual licensing,"
                        + " IKE-Network/ike-issues#952).")
                .isA(set.conceptRef("License (IkeFoundation)"));
    }
}
