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

import java.util.Set;

/**
 * A concept set, the members a value set denotes under a view, by their nids, with the name a
 * library gave it.
 *
 * @param name    the value set's identifier as the library wrote it
 * @param members the members' nids
 */
public record ConceptSetValue(String name, Set<Integer> members) implements Value {

    /**
     * Keeps the members immutable.
     *
     * @param name    the name
     * @param members the members
     */
    public ConceptSetValue {
        members = Set.copyOf(members);
    }

    /**
     * The kind of this value.
     *
     * @return the kind
     */
    @Override
    public Kind kind() {
        return Kind.CONCEPT_SET;
    }

    /**
     * Whether a concept is a member.
     *
     * @param concept the concept
     * @return true when its identity is among the members
     */
    public boolean contains(ConceptValue concept) {
        return concept.nid().isPresent() && members.contains(concept.nid().get());
    }
}
