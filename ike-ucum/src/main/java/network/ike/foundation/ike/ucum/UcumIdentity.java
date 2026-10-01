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
package network.ike.foundation.ike.ucum;

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;

import java.util.UUID;

/**
 * Where every UCUM component gets its identity (IKE-Network/ike-issues#1114): derived, never
 * random, from what the component is. A unit or a prefix is identified by its case-sensitive
 * code, which UCUM keeps unique; a property by its text; a composed unit by its canonical
 * code, so one unit spelled two ways is one concept; and everything hung on a concept, its
 * record, its descriptions, and its relations, from the concept's own identity.
 */
public final class UcumIdentity {

    /** The namespace every UCUM identity is derived under. */
    public static final UUID NAMESPACE = UUID.fromString("9a2f6c4e-3b7d-5e18-8c0a-6f1d2b3e4a57");

    private UcumIdentity() {
    }

    private static PublicId of(String seed) {
        return PublicIds.of(UuidT5Generator.get(NAMESPACE, seed));
    }

    /**
     * The concept for a base unit or a defined unit.
     *
     * @param code the case-sensitive code
     * @return the identity
     */
    public static PublicId unit(String code) {
        return of("UCUM unit " + code);
    }

    /**
     * The concept for a prefix.
     *
     * @param code the case-sensitive code
     * @return the identity
     */
    public static PublicId prefix(String code) {
        return of("UCUM prefix " + code);
    }

    /**
     * The concept for a property, the parent of the units that measure it.
     *
     * @param property the property as the file writes it
     * @return the identity
     */
    public static PublicId property(String property) {
        return of("UCUM property " + property);
    }

    /**
     * The concept for a composed unit.
     *
     * @param canonicalCode the canonical code
     * @return the identity
     */
    public static PublicId composedUnit(String canonicalCode) {
        return of("UCUM composed unit " + canonicalCode);
    }

    /**
     * The record semantic hung on a concept: the unit, prefix, or composed-unit pattern's.
     *
     * @param concept the concept
     * @return the identity
     */
    public static PublicId record(PublicId concept) {
        return PublicIds.of(UuidT5Generator.get(concept.asUuidArray()[0], "record"));
    }

    /**
     * A description or dialect semantic hung on a concept, by its role.
     *
     * @param concept the concept
     * @param role    the role, for example {@code fqn}, {@code name 0}, or {@code print symbol}
     * @return the identity
     */
    public static UUID description(PublicId concept, String role) {
        return UuidT5Generator.get(concept.asUuidArray()[0], role);
    }

    /**
     * The relation semantic that says a UCUM unit is one of IKE's own concepts.
     *
     * @param code     the unit's code, canonical for a composed unit
     * @param ourName  the name of IKE's concept
     * @return the identity
     */
    public static PublicId relation(String code, String ourName) {
        return of("Construct relation: UCUM " + code + " is " + ourName);
    }
}
