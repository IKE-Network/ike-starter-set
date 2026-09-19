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

/**
 * Thrown while a definition evaluates when something is refused; the evaluator turns it into
 * the definition's outcome.
 */
public final class Refused extends RuntimeException {

    private final Refusal refusal;

    /**
     * Creates the refusal.
     *
     * @param place  where
     * @param reason what
     */
    public Refused(String place, String reason) {
        super(place + ": " + reason);
        this.refusal = new Refusal(place, reason);
    }

    /**
     * The refusal.
     *
     * @return the refusal
     */
    public Refusal refusal() {
        return refusal;
    }
}
