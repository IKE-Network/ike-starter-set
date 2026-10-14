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
 * A missing value of a kind: what CQL writes as null, of whatever type. A missing presence is
 * {@link Presence#INDETERMINATE} and is never a Missing; every other kind is missing through
 * this value.
 *
 * @param kind the kind the value would have had
 */
public record Missing(Kind kind) implements Value {

    /** A missing value of no settled kind. */
    public static final Missing ANY = new Missing(Kind.ANY);

    /**
     * Whether this value is missing: of its kind, with no content.
     *
     * @return true when missing
     */
    @Override
    public boolean isMissing() {
        return true;
    }

    /**
     * The missing value of a kind, Indeterminate for the presence kind.
     *
     * @param kind the kind
     * @return the missing value
     */
    public static Value of(Kind kind) {
        return kind == Kind.PRESENCE ? Presence.INDETERMINATE : new Missing(kind);
    }
}
