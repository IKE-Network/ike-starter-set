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

import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The bridge's gate: a library retrieving conditions in a value set against authored
 * statements yields the statement set the topics say; a path reads the timing's start; an
 * unbridged class, a path without a reading, and an unsupported context are refused with
 * their place; Patient context sees one subject's statements, unfiltered sees all.
 */
class BridgeIT {

    private static final String LIBRARY = """
            {"library": {"identifier": {"id": "BridgeGate", "version": "1"},
              "schemaIdentifier": {"id": "urn:hl7-org:elm", "version": "r1"},
              "usings": {"def": [{"localIdentifier": "System", "uri": "urn:hl7-org:elm-types:r1"},
                                 {"localIdentifier": "QUICK", "uri": "http://hl7.org/fhir"}]},
              "valueSets": {"def": [{"name": "Pharyngitis", "id": "2.16.840.1.113883.3.464.1003.102.12.1011", "accessLevel": "Public"}]},
              "statements": {"def": [
                {"name": "Conditions", "context": "Patient", "accessLevel": "Public",
                 "expression": {"type": "Retrieve", "dataType": "{http://hl7.org/fhir}Condition", "codeProperty": "code",
                                "codeComparator": "in", "codes": {"type": "ValueSetRef", "name": "Pharyngitis"}}},
                {"name": "Onset", "context": "Patient", "accessLevel": "Public",
                 "expression": {"type": "Property", "path": "onsetDateTime",
                                "source": {"type": "SingletonFrom", "operand": {"type": "ExpressionRef", "name": "Conditions"}}}},
                {"name": "Unbridged", "context": "Patient", "accessLevel": "Public",
                 "expression": {"type": "Retrieve", "dataType": "{http://hl7.org/fhir}Procedure"}},
                {"name": "NoReading", "context": "Patient", "accessLevel": "Public",
                 "expression": {"type": "Property", "path": "category",
                                "source": {"type": "SingletonFrom", "operand": {"type": "ExpressionRef", "name": "Conditions"}}}},
                {"name": "InEncounterContext", "context": "Encounter", "accessLevel": "Public",
                 "expression": {"type": "Literal", "valueType": "{urn:hl7-org:elm-types:r1}Boolean", "value": "true"}},
                {"name": "Everyone", "context": "Unfiltered", "accessLevel": "Public",
                 "expression": {"type": "Retrieve", "dataType": "{http://hl7.org/fhir}Condition"}}
              ]}}}
            """;

    private static StampCalculator calculator;
    private static Evaluator evaluator;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        Store.importJson(LIBRARY);
        evaluator = Evaluator.load(calculator, Authored.statements(), Authored.conceptSets());
    }

    @Test
    void aRetrieveYieldsTheStatementsTheTopicsSay() {
        Report report = evaluator.evaluate("BridgeGate", Optional.of(Authored.child()), Map.of());
        Value conditions = report.value("Conditions").orElseThrow(() -> new AssertionError(report.refusal("Conditions")));
        assertTrue(conditions instanceof ListValue, "a retrieve yields a statement set");
        ListValue list = (ListValue) conditions;
        assertEquals(1, list.values().size(), "the child's one pharyngitis");
        StatementValue statement = (StatementValue) list.values().get(0);
        assertEquals(Authored.id("statement child pharyngitis"), statement.statement().id());
    }

    @Test
    void aPathReadsTheTimingsStart() {
        Report report = evaluator.evaluate("BridgeGate", Optional.of(Authored.child()), Map.of());
        Value onset = report.value("Onset").orElseThrow(() -> new AssertionError(report.refusal("Onset")));
        assertTrue(onset instanceof Measure);
        assertEquals(Presence.PRESENT, ((Measure) onset).sameAs(Authored.day(2013, 3, 1)),
                "onsetDateTime reads the timing's start, written to the day");
    }

    @Test
    void whatCannotBeBridgedOrReadIsRefusedWithItsPlace() {
        Report report = evaluator.evaluate("BridgeGate", Optional.of(Authored.child()), Map.of());
        Refusal unbridged = report.refusal("Unbridged").orElseThrow();
        assertEquals("BridgeGate/Unbridged/expression", unbridged.place());
        assertTrue(unbridged.reason().contains("no bridge is authored on Procedure of QUICK"), unbridged.reason());
        Refusal noReading = report.refusal("NoReading").orElseThrow();
        assertEquals("BridgeGate/NoReading/expression", noReading.place());
        assertTrue(noReading.reason().contains("the element category of {http://hl7.org/fhir}Condition has no reading"),
                noReading.reason());
        Refusal context = report.refusal("InEncounterContext").orElseThrow();
        assertEquals("BridgeGate/InEncounterContext", context.place());
        assertTrue(context.reason().contains("the context Encounter is not one the evaluator runs"), context.reason());
    }

    @Test
    void patientContextSeesOneSubjectAndUnfilteredSeesAll() {
        Report child = evaluator.evaluate("BridgeGate", Optional.of(Authored.child()), Map.of());
        assertEquals(3, ((ListValue) child.value("Everyone").orElseThrow()).values().size(),
                "with a subject given, the child's performances: the pharyngitis, the visit, the strep test;"
                        + " without codes the bridge constrains the circumstance kind alone");
        Report everyone = evaluator.evaluate("BridgeGate", Optional.empty(), Map.of());
        assertEquals(4, ((ListValue) everyone.value("Everyone").orElseThrow()).values().size(),
                "unfiltered, every performance of both subjects");
        Refusal conditions = everyone.refusal("Conditions").orElseThrow();
        assertTrue(conditions.reason().contains("Patient context, and no subject was given"), conditions.reason());
    }
}
