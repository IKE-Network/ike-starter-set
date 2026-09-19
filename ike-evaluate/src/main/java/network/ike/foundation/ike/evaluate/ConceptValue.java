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

import java.util.List;
import java.util.Optional;

/**
 * A concept as a library writes it: a code in a system, with a version and a display where
 * given, and the concept's identity in the store where the code system is in the graph. Two
 * concepts are the same when their identities are, or, lacking identities, when code and
 * system agree.
 *
 * @param code    the code as written
 * @param system  the code system's identifier as written, empty when none
 * @param version the system's version as written, empty when none
 * @param display the display text as written, empty when none
 * @param nid     the concept's nid in the store, when the code resolves to one
 */
public record ConceptValue(String code, String system, String version, String display, Optional<Integer> nid)
        implements Value {

    /**
     * The kind of this value.
     *
     * @return the kind
     */
    @Override
    public Kind kind() {
        return Kind.CONCEPT;
    }

    /**
     * Whether two concepts are the same: by identity when both have one, else by code and system.
     *
     * @param other the other concept
     * @return true when the same
     */
    public boolean sameAs(ConceptValue other) {
        if (nid.isPresent() && other.nid.isPresent()) {
            return nid.get().intValue() == other.nid.get().intValue();
        }
        return code.equals(other.code) && system.equals(other.system);
    }

    /**
     * A CQL Concept: several codes for one idea, with a display. It is held as the list of its
     * codes, since a concept value with more than one code is one idea admitted several times.
     *
     * @param codes   the codes
     * @param display the display text
     * @return the codes as a list value
     */
    public static ListValue concept(List<ConceptValue> codes, String display) {
        return new ListValue(List.copyOf(codes));
    }
}
