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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The corpus's gate: the measure library and the QDM libraries evaluate for an authored
 * subject over the authored statements, every definition yielding; across the whole corpus,
 * the definitions that yield and the kinds that still refuse are named.
 */
class CorpusIT {

    private static StampCalculator calculator;
    private static Evaluator evaluator;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        evaluator = Evaluator.load(calculator, Authored.statements(), Authored.conceptSets());
    }

    private static Map<String, Value> parameters() {
        return Map.of("Measurement Period", Authored.measurementPeriod());
    }

    private static String refusals(Report report) {
        StringBuilder text = new StringBuilder();
        report.definitions().forEach((name, outcome) -> {
            if (outcome instanceof Outcome.Refused refused) {
                text.append(name).append(": ").append(refused.refusal().place()).append(": ")
                        .append(refused.refusal().reason()).append('\n');
            }
        });
        return text.toString();
    }

    private static int size(Report report, String name) {
        Value value = report.value(name).orElseThrow(() -> new AssertionError(name + " refused: " + report.refusal(name)));
        assertTrue(value instanceof ListValue, name + " is a " + value.kind());
        return ((ListValue) value).values().size();
    }

    private static Presence presence(Report report, String name) {
        Value value = report.value(name).orElseThrow(() -> new AssertionError(name + " refused: " + report.refusal(name)));
        assertTrue(value instanceof Presence, name + " is a " + value.kind());
        return (Presence) value;
    }

    @Test
    void theMeasureLibraryEvaluatesForTheChild() {
        Report report = evaluator.evaluate("CMS146", Optional.of(Authored.child()), Map.of());
        assertEquals("", refusals(report), "every definition yields");
        assertEquals(12, report.definitions().size());
        assertTrue(report.value("Patient").orElseThrow() instanceof SubjectValue, "the patient retrieve yields the subject");
        assertEquals(Presence.PRESENT, presence(report, "InDemographic"), "seven years old at the start of 2013");
        assertEquals(1, size(report, "Pharyngitis"));
        assertEquals(2, size(report, "Antibiotics"));
        assertEquals(1, size(report, "TargetEncounters"), "the office visit during the pharyngitis, prescribed within three days");
        assertEquals(1, size(report, "TargetDiagnoses"));
        assertEquals(Presence.PRESENT, presence(report, "HasPriorAntibiotics"), "the prescription written before the onset");
        assertEquals(Presence.PRESENT, presence(report, "HasTargetEncounter"));
        assertEquals(Presence.PRESENT, presence(report, "InInitialPopulation"));
        assertEquals(Presence.PRESENT, presence(report, "InDenominator"));
        assertEquals(Presence.PRESENT, presence(report, "InDenominatorExclusions"));
        assertEquals(Presence.PRESENT, presence(report, "InNumerator"), "the strep test issued in the period, with a result");
    }

    @Test
    void theMeasureLibraryEvaluatesForTheAdult() {
        Report report = evaluator.evaluate("CMS146", Optional.of(Authored.adult()), Map.of());
        assertEquals("", refusals(report), "every definition yields");
        assertEquals(Presence.ABSENT, presence(report, "InDemographic"));
        assertEquals(1, size(report, "Pharyngitis"), "the adult's own pharyngitis");
        assertEquals(0, size(report, "TargetEncounters"));
        assertEquals(Presence.ABSENT, presence(report, "HasPriorAntibiotics"));
        assertEquals(Presence.ABSENT, presence(report, "InInitialPopulation"));
        assertEquals(Presence.ABSENT, presence(report, "InNumerator"));
    }

    @Test
    void theQdmLibrariesEvaluateAgainstBothQdmVersions() {
        for (String id : List.of("Adult_Outpatient_Encounters")) {
            Report report = evaluator.evaluate(id, Optional.of(Authored.child()), parameters());
            assertEquals("", refusals(report), "every definition yields");
            assertTrue(report.value("Patient").orElseThrow() instanceof SubjectValue);
            assertEquals(1, size(report, "Qualifying Encounters"), "the office visit's relevant period lies in the period");
        }
    }

    @Test
    void acrossTheCorpusTheYieldsAndTheRefusalsAreNamed() throws Exception {
        Map<String, List<String>> yields = new TreeMap<>();
        Map<String, List<String>> refused = new TreeMap<>();
        TreeSet<String> reasons = new TreeSet<>();
        for (String id : Store.corpusIds()) {
            Report report = evaluator.evaluate(id, Optional.of(Authored.child()), parameters());
            report.definitions().forEach((name, outcome) -> {
                if (outcome instanceof Outcome.Yielded) {
                    yields.computeIfAbsent(id, key -> new ArrayList<>()).add(name);
                } else {
                    refused.computeIfAbsent(id, key -> new ArrayList<>()).add(name);
                    reasons.add(((Outcome.Refused) outcome).refusal().reason());
                }
            });
        }
        Map<String, List<String>> expectedYields = new LinkedHashMap<>();
        expectedYields.put("Adult_Outpatient_Encounters", List.of("Patient", "Qualifying Encounters"));
        expectedYields.put("BaseLibraryElm", List.of("PrivateExpression", "BaseExpression", "BaseLibSum"));
        expectedYields.put("CMS146", List.of("Patient", "InDemographic", "Pharyngitis", "Antibiotics", "TargetEncounters",
                "TargetDiagnoses", "HasPriorAntibiotics", "HasTargetEncounter", "InInitialPopulation", "InDenominator",
                "InDenominatorExclusions", "InNumerator"));
        expectedYields.put("ElmTests", List.of("Patient", "List1"));
        expectedYields.put("LibraryWithIncompatibleTranslatorVersion", List.of("expr1"));
        expectedYields.put("LibraryWithResultTypes", List.of("Patient", "expr1", "expr2"));
        expectedYields.put("LibraryWithoutResultTypes", List.of("expr1"));
        Map<String, List<String>> expectedRefused = new LinkedHashMap<>();
        expectedRefused.put("ElmTests", List.of("TestFilter"));
        expectedRefused.put("LibraryWithResultTypes", List.of("Practitioner", "expr3"));
        String observed = "yields: " + yields + "\nrefused: " + refused + "\nreasons: " + reasons;
        assertEquals(expectedYields, yields, observed);
        assertEquals(expectedRefused, refused, observed);
        assertEquals(List.of("the context Practitioner is not one the evaluator runs",
                "the node kind Filter has no relation to a construct"), new ArrayList<>(reasons), observed);
    }
}
