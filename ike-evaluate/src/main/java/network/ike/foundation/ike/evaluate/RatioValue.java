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
 * A measure ratio: a numerator measure and a denominator measure kept as written, so that
 * 1:128 stays 1:128.
 *
 * @param numerator   the numerator
 * @param denominator the denominator
 */
public record RatioValue(Measure numerator, Measure denominator) implements Value {

    /**
     * The kind of this value.
     *
     * @return the kind
     */
    @Override
    public Kind kind() {
        return Kind.RATIO;
    }
}
