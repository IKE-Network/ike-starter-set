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
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.writer.StoreWriter;
import org.eclipse.collections.api.factory.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * How a UCUM thing becomes a concept in the store: its concept under its parent, its fully
 * qualified name, its names and print symbol as descriptions read in the UCUM dialect, its
 * definition as UCUM writes it, and its record semantic with every field verbatim and IKE's
 * reduction marked as IKE's.
 */
final class UcumConcepts {

    private UcumConcepts() {
    }

    /**
     * Writes a property concept under the UCUM property parent.
     *
     * @param writer   the writer
     * @param property the property as the file writes it
     * @return the concept's identity
     */
    static PublicId property(StoreWriter writer, String property) {
        PublicId id = UcumIdentity.property(property);
        int nid = writer.concept(id);
        writer.statedParent(id, IkeTerms.UCUM_PROPERTY.publicId());
        writer.describe(nid, UcumIdentity.description(id, "fqn"), property + " (UCUM property)",
                TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE, TinkarTerm.PREFERRED);
        named(writer, nid, id, "name 0", property, TinkarTerm.PREFERRED, TinkarTerm.PREFERRED);
        return id;
    }

    /**
     * Writes a unit concept, base or defined, under its property, with its record.
     *
     * @param writer              the writer
     * @param code                the case-sensitive code
     * @param caseInsensitiveCode the case-insensitive code
     * @param names               the names, in the file's order
     * @param printSymbol         the print symbol, empty when none
     * @param property            the property it measures
     * @param unitClass           the class, empty for a base unit
     * @param metric              whether metric
     * @param special             whether special
     * @param arbitrary           whether arbitrary
     * @param definitionValue     the number in the definition as written, empty for a base unit
     * @param definitionUnit      the unit in the definition as written, empty for a base unit
     * @param reduction           IKE's reduction
     * @return the concept's identity
     */
    static PublicId unit(StoreWriter writer, String code, String caseInsensitiveCode, List<String> names,
                         String printSymbol, String property, String unitClass, boolean metric, boolean special,
                         boolean arbitrary, String definitionValue, String definitionUnit, UcumReduction reduction) {
        PublicId id = UcumIdentity.unit(code);
        int nid = writer.concept(id);
        writer.statedParent(id, UcumIdentity.property(property));
        writer.describe(nid, UcumIdentity.description(id, "fqn"), names.get(0) + ", " + code + " (UCUM)",
                TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE, TinkarTerm.PREFERRED);
        for (int i = 0; i < names.size(); i++) {
            named(writer, nid, id, "name " + i, names.get(i), i == 0 ? TinkarTerm.PREFERRED : TinkarTerm.ACCEPTABLE,
                    TinkarTerm.PREFERRED);
        }
        if (!printSymbol.isEmpty() && !names.contains(printSymbol)) {
            named(writer, nid, id, "print symbol", printSymbol, TinkarTerm.ACCEPTABLE, TinkarTerm.ACCEPTABLE);
        }
        if (!definitionUnit.isEmpty()) {
            writer.describe(nid, UcumIdentity.description(id, "definition"),
                    (definitionValue + " " + definitionUnit).trim(), TinkarTerm.DEFINITION_DESCRIPTION_TYPE,
                    TinkarTerm.PREFERRED);
        }
        writer.semantic(UcumIdentity.record(id), IkeTerms.UCUM_UNIT_PATTERN, nid, Lists.immutable.of(
                code, caseInsensitiveCode, printSymbol, unitClass, metric, special, arbitrary,
                definitionValue, definitionUnit, reduction.dimension(), reduction.magnitude()));
        return id;
    }

    /**
     * Writes a prefix concept under the UCUM prefix parent, with its record.
     *
     * @param writer the writer
     * @param prefix the prefix as the file writes it
     * @return the concept's identity
     */
    static PublicId prefix(StoreWriter writer, UcumEssence.Prefix prefix) {
        PublicId id = UcumIdentity.prefix(prefix.code());
        int nid = writer.concept(id);
        writer.statedParent(id, IkeTerms.UCUM_PREFIX.publicId());
        writer.describe(nid, UcumIdentity.description(id, "fqn"), prefix.name() + ", " + prefix.code() + " (UCUM)",
                TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE, TinkarTerm.PREFERRED);
        named(writer, nid, id, "name 0", prefix.name(), TinkarTerm.PREFERRED, TinkarTerm.PREFERRED);
        if (!prefix.printSymbol().isEmpty() && !prefix.printSymbol().equals(prefix.name())) {
            named(writer, nid, id, "print symbol", prefix.printSymbol(), TinkarTerm.ACCEPTABLE, TinkarTerm.ACCEPTABLE);
        }
        writer.describe(nid, UcumIdentity.description(id, "definition"), prefix.value(),
                TinkarTerm.DEFINITION_DESCRIPTION_TYPE, TinkarTerm.PREFERRED);
        writer.semantic(UcumIdentity.record(id), IkeTerms.UCUM_PREFIX_PATTERN, nid, Lists.immutable.of(
                prefix.code(), prefix.caseInsensitiveCode(), prefix.printSymbol(), prefix.factor()));
        return id;
    }

    /**
     * Writes a composed unit: a concept under the UCUM composed unit parent, named by its
     * canonical code, with its record. Writing the same canonical code twice finds the same
     * concept.
     *
     * @param writer    the writer
     * @param term      the term, whose canonical code is the identity
     * @param reduction IKE's reduction of it
     * @return the concept's identity
     */
    static PublicId composedUnit(StoreWriter writer, UcumTerm term, UcumReduction reduction) {
        String canonical = term.canonicalCode();
        PublicId id = UcumIdentity.composedUnit(canonical);
        int nid = writer.concept(id);
        writer.statedParent(id, IkeTerms.UCUM_COMPOSED_UNIT.publicId());
        writer.describe(nid, UcumIdentity.description(id, "fqn"), canonical + " (UCUM composed unit)",
                TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE, TinkarTerm.PREFERRED);
        named(writer, nid, id, "name 0", canonical, TinkarTerm.PREFERRED, TinkarTerm.PREFERRED);
        writer.semantic(UcumIdentity.record(id), IkeTerms.UCUM_COMPOSED_UNIT_PATTERN, nid, Lists.immutable.of(
                canonical, reduction.dimension(), reduction.magnitude(), reduction.special(), reduction.arbitrary()));
        return id;
    }

    /**
     * Writes the relation that says a UCUM unit is one of IKE's own concepts.
     *
     * @param writer   the writer
     * @param unit     the UCUM unit's concept
     * @param code     the unit's code, canonical for a composed unit
     * @param ours     IKE's concept
     * @param ourName  IKE's concept's name, the seed of the relation's identity
     */
    static void identity(StoreWriter writer, PublicId unit, String code, EntityProxy.Concept ours, String ourName) {
        writer.semantic(UcumIdentity.relation(code, ourName), IkeTerms.CONSTRUCT_RELATION_PATTERN,
                PrimitiveData.nid(unit), Lists.immutable.of(ours, IkeTerms.IDENTITY));
    }

    private static void named(StoreWriter writer, int nid, PublicId id, String role, String text,
                              EntityProxy.Concept usAcceptability, EntityProxy.Concept ucumAcceptability) {
        int description = writer.describe(nid, UcumIdentity.description(id, role), text,
                TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, usAcceptability);
        writer.dialect(description, UcumIdentity.description(id, role + " ucum-dialect"), IkeTerms.UCUM_DIALECT_PATTERN,
                ucumAcceptability);
    }

    /** A magnitude read back from a record. */
    static BigDecimal magnitude(Object field) {
        return (BigDecimal) field;
    }
}
