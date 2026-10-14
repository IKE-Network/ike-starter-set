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
 * Why a definition could not be evaluated, with its place: a node kind no relation admits, a
 * class no bridge covers, an element with no reading, a context with no subject, an operation
 * on a kind of value the construct does not take.
 *
 * @param place  where, the definition and the position within it
 * @param reason what, in plain words
 */
public record Refusal(String place, String reason) {
}
