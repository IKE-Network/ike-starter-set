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

import java.util.Optional;
import java.util.Set;

/**
 * Where evaluation gets the members of a value set: under a view, the concept set a value set
 * identifier denotes. A knowledge base answers from its reference sets; the gates author their
 * own.
 */
public interface ConceptSetSource {

    /**
     * The members of a value set.
     *
     * @param identifier the value set's identifier as the library wrote it
     * @return the members' nids, or empty when the source knows no such value set
     */
    Optional<Set<Integer>> members(String identifier);
}
