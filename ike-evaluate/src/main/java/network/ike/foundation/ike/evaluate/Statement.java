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
package network.ike.foundation.ike.evaluate;

import dev.ikm.tinkar.common.id.PublicId;

import java.util.List;
import java.util.Optional;

/**
 * A statement as evaluation reads it, the query model's own reading: what a criterion tests.
 * The store-backed source fills this from the ANF pattern when it lands; until then the gates
 * author statements in this form (IKE-Network/ike-issues#1116).
 *
 * @param id                  the statement's identity
 * @param subject             the subject of record
 * @param topicNid            the topic, a concept
 * @param circumstanceKindNid the kind of circumstance, one of the ledger's three
 * @param dispositionNid      what became of the act or the order, a concept, empty when none
 * @param timing              when the circumstance held, a measure on the calendar or the epoch
 * @param result              the result of a performance, a measure, empty when none
 * @param statementTime       when the statement was made
 * @param associated          the statements this one is associated with
 */
public record Statement(PublicId id, Subject subject, int topicNid, int circumstanceKindNid, Optional<Integer> dispositionNid,
                        Measure timing, Optional<Measure> result, Measure statementTime, List<PublicId> associated) {

    /**
     * Keeps the associations immutable.
     *
     * @param id                  the identity
     * @param subject             the subject
     * @param topicNid            the topic
     * @param circumstanceKindNid the circumstance kind
     * @param dispositionNid      the disposition
     * @param timing              the timing
     * @param result              the result
     * @param statementTime       the statement time
     * @param associated          the associations
     */
    public Statement {
        associated = List.copyOf(associated);
    }
}
