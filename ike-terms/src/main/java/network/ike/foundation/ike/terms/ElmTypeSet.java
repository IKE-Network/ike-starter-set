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
package network.ike.foundation.ike.terms;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * The data type pass (IKE-Network/ike-issues#1113): each of the 23 ELM System types, concepts of
 * the generated {@link ElmNodeCatalogSet}, related to the IKE concept for the same idea by one
 * checked relation of the construct relation pattern. AUTHORED, never regenerated. HL7's ELM is
 * the Expression Logical Model of the Clinical Quality Language specification, and not Elm, the
 * programming language for browser user interfaces.
 *
 * <p>Numbers are measures on the dimensionless number; Boolean is presence; String is the string
 * data type; dates and times are measures on their time scales; a quantity is a measure on its
 * unit; a ratio is a measure ratio; codes are concepts; vocabularies are concept sets; intervals
 * are measures; Any is the root operand kind.
 */
final class ElmTypeSet {

    private ElmTypeSet() {
    }

    /**
     * Composes this section's relations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;
        EntityProxy.Pattern relations = set.patternRef(ExpressionLanguageSet.RELATION_PATTERN_FQN);
        EntityProxy.Concept identity = set.conceptRef("Identity (IkeFoundation)");
        EntityProxy.Concept equivalence = set.conceptRef("Logical equivalence (IkeFoundation)");
        EntityProxy.Concept extension = set.conceptRef("Definitional extension (IkeFoundation)");

        EntityProxy.Concept measureKind = set.conceptRef("Measure kind (IkeFoundation)");
        EntityProxy.Concept presenceMeasureKind = set.conceptRef("Presence measure kind (IkeFoundation)");
        EntityProxy.Concept conceptKind = set.conceptRef("Concept kind (IkeFoundation)");
        EntityProxy.Concept conceptSetKind = set.conceptRef("Concept set kind (IkeFoundation)");
        EntityProxy.Concept operandKind = set.conceptRef("Operand kind (IkeFoundation)");
        EntityProxy.Concept measureRatio = set.conceptRef("Measure ratio (IkeFoundation)");
        EntityProxy.Concept string = IkeTerm.STRING;

        // ── Numbers: measures on the dimensionless number ──
        relate(set, inception, relations, "Integer", measureKind, extension,
                "a measure on the dimensionless number, both bounds the value, resolution one");
        relate(set, inception, relations, "Long", measureKind, extension,
                "a measure on the dimensionless number, both bounds the value, resolution one; the"
                        + " 64-bit range is a machine limit, not meaning");
        relate(set, inception, relations, "Decimal", measureKind, extension,
                "a measure on the dimensionless number, both bounds the value, resolution the decimal"
                        + " place the value is written to");

        // ── Boolean: presence ──
        relate(set, inception, relations, "Boolean", presenceMeasureKind, equivalence,
                "true is Present, false is Absent, null is Indeterminate, the three-row table");

        // ── String: the string data type ──
        relate(set, inception, relations, "String", string, identity,
                "a sequence of characters read as nothing more, the same idea admitted twice");

        // ── Dates and times: measures on time scales ──
        relate(set, inception, relations, "Date", measureKind, extension,
                "a measure on the Gregorian calendar date, read as an instant, resolution the precision"
                        + " written, so a date known to the month is the whole month");
        relate(set, inception, relations, "DateTime", measureKind, extension,
                "a measure on the epoch scale, read as an instant, in the time zone its offset gives,"
                        + " resolution the precision written");
        relate(set, inception, relations, "Time", measureKind, extension,
                "a measure on the time of day, read as an instant, resolution the precision written");

        // ── Quantity: a measure on its unit ──
        relate(set, inception, relations, "Quantity", measureKind, extension,
                "a measure on the unit its UCUM code names, both bounds the value, resolution the decimal"
                        + " place written; the units of time are concepts already, the rest wait for the"
                        + " UCUM family and stay text on the measure until then");

        // ── Ratio: a measure ratio ──
        relate(set, inception, relations, "Ratio", measureRatio, identity,
                "a numerator measure and a denominator measure, kept as written");

        // ── Codes: concepts ──
        relate(set, inception, relations, "Code", conceptKind, equivalence,
                "the concept that carries the code, given the code system is in the graph; the display"
                        + " text travels with the value and is not part of the meaning");
        relate(set, inception, relations, "Concept", conceptKind, equivalence,
                "the concept its codes share, given their code systems are in the graph");

        // ── Vocabularies: concept sets ──
        relate(set, inception, relations, "Vocabulary", conceptSetKind, extension,
                "the set of concepts a named collection of codes denotes under a view");
        relate(set, inception, relations, "ValueSet", conceptSetKind, extension,
                "the set of concepts the value set expands to under a view");
        relate(set, inception, relations, "CodeSystem", conceptSetKind, extension,
                "every concept of the code system under a view");

        // ── Intervals: measures ──
        relate(set, inception, relations, "Interval", measureKind, extension,
                "a measure whose bounds and inclusivities are the interval's, whose frame is its point"
                        + " type's, and whose resolution is unstated");
        relate(set, inception, relations, "IntegerInterval", measureKind, extension,
                "a measure on the dimensionless number with resolution one, bounds and inclusivities"
                        + " the interval's");
        relate(set, inception, relations, "DecimalInterval", measureKind, extension,
                "a measure on the dimensionless number, bounds and inclusivities the interval's,"
                        + " resolution unstated");
        relate(set, inception, relations, "QuantityInterval", measureKind, extension,
                "a measure on the unit of its bounds, bounds and inclusivities the interval's");
        relate(set, inception, relations, "DateInterval", measureKind, extension,
                "a measure on the Gregorian calendar date, read as a period, bounds and inclusivities"
                        + " the interval's");
        relate(set, inception, relations, "DateTimeInterval", measureKind, extension,
                "a measure on the epoch scale, read as a period, bounds and inclusivities the"
                        + " interval's");
        relate(set, inception, relations, "TimeInterval", measureKind, extension,
                "a measure on the time of day, read as a period, bounds and inclusivities the"
                        + " interval's");

        // ── Any: the root ──
        relate(set, inception, relations, "Any", operandKind, equivalence,
                "the top of one family is the top of the other, each meaning any value at all");
    }

    /**
     * States one type relation: the System type's concept, a later scope on the concept the
     * catalog declares, gains a relation semantic naming its target and its kind. The reason is
     * the seed of the semantic's identity and the plain words the record keeps.
     */
    private static void relate(KnowledgeSet set, ActiveStamp inception, EntityProxy.Pattern relations,
                               String systemType, EntityProxy.Concept target, EntityProxy.Concept kind,
                               String reason) {
        set.concept("ELM System " + systemType + " (ELM)").at(inception)
                .semantic(relations, PublicIds.of(set.uuidFor(
                                "Construct relation: ELM System " + systemType + " is " + reason)),
                        target, kind);
    }
}
