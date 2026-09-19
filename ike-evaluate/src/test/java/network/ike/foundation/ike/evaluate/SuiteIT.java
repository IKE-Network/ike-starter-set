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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * The suite's gate: per family, three exact counts. Passed: the expression's value equals the
 * expected result's by IKE's own equality. Refused: a kind no relation admits, counted and
 * named, never failed. Recorded: yields a value that differs from the expected result, a
 * reading admitted as different, held under its relation. The invalid and untranslated tests
 * are kept as tests that must not translate.
 */
class SuiteIT {

    /**
     * Per family: passed, refused, recorded, as of the evaluation step (IKE-Network/ike-issues#1116).
     * No family is at zero refused yet: the conversions the translator inserts, As above all and
     * ToDecimal, run through every family and belong to the types family; Today and Now wait on
     * a clock construct. The recorded tests are the readings the topic records as IKE's own:
     * calendar months and years against UCUM's and against days, missing elements in tuples,
     * decimal equivalence at trailing zeros, precision kept honest on shifted and compared
     * instants, the leap-day anniversary, successor and predecessor on the ends of number
     * extents, and one millisecond parse the translator reads differently.
     */
    private static final Map<String, int[]> EXPECTED = new LinkedHashMap<>();

    static {
        EXPECTED.put("CqlAggregateFunctionsTest", new int[] {29, 21, 0});
        EXPECTED.put("CqlAggregateTest", new int[] {0, 9, 0});
        EXPECTED.put("CqlArithmeticFunctionsTest", new int[] {26, 203, 0});
        EXPECTED.put("CqlComparisonOperatorsTest", new int[] {215, 29, 15});
        EXPECTED.put("CqlConditionalOperatorsTest", new int[] {7, 2, 0});
        EXPECTED.put("CqlDateTimeOperatorsTest", new int[] {277, 25, 12});
        EXPECTED.put("CqlErrorsAndMessagingOperatorsTest", new int[] {0, 3, 0});
        EXPECTED.put("CqlIntervalOperatorsTest", new int[] {245, 150, 12});
        EXPECTED.put("CqlListOperatorsTest", new int[] {85, 146, 0});
        EXPECTED.put("CqlLogicalOperatorsTest", new int[] {18, 21, 0});
        EXPECTED.put("CqlNullologicalOperatorsTest", new int[] {12, 10, 0});
        EXPECTED.put("CqlQueryTests", new int[] {1, 11, 0});
        EXPECTED.put("CqlStringOperatorsTest", new int[] {0, 82, 0});
        EXPECTED.put("CqlTypeOperatorsTest", new int[] {0, 35, 0});
        EXPECTED.put("CqlTypesTest", new int[] {19, 2, 2});
        EXPECTED.put("ValueLiteralsAndSelectors", new int[] {24, 31, 0});
    }

    private static StampCalculator calculator;
    private static Evaluator evaluator;
    private static List<Manifest.Entry> manifest;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        evaluator = Evaluator.load(calculator, Authored.statements(), Authored.conceptSets());
        manifest = Manifest.read();
    }

    /**
     * Whether two values match: both missing, or the same by IKE's equality, element by
     * element. An uncertainty, which CQL writes as an interval, matches an extent with the same
     * ends, since the suite has no other way to write one.
     */
    static boolean matches(Value a, Value b) {
        if (a.isMissing() && b.isMissing()) {
            return true;
        }
        if (a.isMissing() || b.isMissing()) {
            return false;
        }
        if (a instanceof Measure ma && b instanceof Measure mb && ma.extent() != mb.extent()) {
            Measure uncertainty = ma.extent() ? mb : ma;
            Measure extent = ma.extent() ? ma : mb;
            if (uncertainty.resolution().isEmpty() && !uncertainty.isPoint() && extent.lowerIncluded() && extent.upperIncluded()) {
                return Values.equal(Measure.extent(uncertainty.lower(), uncertainty.upper(), true, true,
                        uncertainty.semantic(), Optional.empty()), extent) == Presence.PRESENT;
            }
            return false;
        }
        if (a instanceof ListValue la && b instanceof ListValue lb) {
            if (la.values().size() != lb.values().size()) {
                return false;
            }
            for (int i = 0; i < la.values().size(); i++) {
                if (!matches(la.values().get(i), lb.values().get(i))) {
                    return false;
                }
            }
            return true;
        }
        if (a instanceof TupleValue ta && b instanceof TupleValue tb) {
            if (!ta.parts().keySet().equals(tb.parts().keySet())) {
                return false;
            }
            for (String name : ta.parts().keySet()) {
                if (!matches(ta.parts().get(name), tb.parts().get(name))) {
                    return false;
                }
            }
            return true;
        }
        return Values.equal(a, b) == Presence.PRESENT;
    }

    private static String kindOf(Refusal refusal) {
        String reason = refusal.reason();
        String marker = "the node kind ";
        int at = reason.indexOf(marker);
        if (at < 0) {
            return "(" + reason + ")";
        }
        int end = reason.indexOf(' ', at + marker.length());
        return reason.substring(at + marker.length(), end < 0 ? reason.length() : end);
    }

    @Test
    void everyFamilyCountsAsTheLedgerSays() {
        Map<String, int[]> observed = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> refusedKinds = new TreeMap<>();
        Map<String, List<String>> recorded = new TreeMap<>();
        List<String> shouldNotTranslate = new ArrayList<>();
        for (String family : EXPECTED.keySet()) {
            Report report = evaluator.evaluate(family, Optional.empty(), Map.of());
            int[] counts = new int[3];
            for (Manifest.Entry entry : manifest) {
                if (!entry.file().equals(family)) {
                    continue;
                }
                if (!entry.translated()) {
                    if (report.definitions().containsKey(entry.name())) {
                        shouldNotTranslate.add(family + "/" + entry.name());
                    }
                    continue;
                }
                Outcome outcome = report.definitions().get(entry.name());
                Outcome expected = report.definitions().get(entry.name() + "_expected");
                if (outcome instanceof Outcome.Refused refused) {
                    counts[1]++;
                    refusedKinds.computeIfAbsent(family, key -> new TreeMap<>()).merge(kindOf(refused.refusal()), 1, Integer::sum);
                } else if (expected instanceof Outcome.Refused refused) {
                    counts[1]++;
                    refusedKinds.computeIfAbsent(family, key -> new TreeMap<>()).merge(kindOf(refused.refusal()), 1, Integer::sum);
                } else if (matches(((Outcome.Yielded) outcome).value(), ((Outcome.Yielded) expected).value())) {
                    counts[0]++;
                } else {
                    counts[2]++;
                    recorded.computeIfAbsent(family, key -> new ArrayList<>()).add(entry.name() + " = " + entry.expression()
                            + " -> " + ((Outcome.Yielded) outcome).value() + " expected " + entry.expected());
                }
            }
            observed.put(family, counts);
        }
        StringBuilder table = new StringBuilder("\nfamily passed refused recorded\n");
        observed.forEach((family, counts) -> table.append(family).append(' ').append(counts[0]).append(' ')
                .append(counts[1]).append(' ').append(counts[2]).append('\n'));
        table.append("refused kinds: ").append(refusedKinds).append('\n');
        recorded.forEach((family, entries) -> {
            table.append("recorded in ").append(family).append(":\n");
            entries.forEach(entry -> table.append("  ").append(entry).append('\n'));
        });
        System.out.println(table);
        assertEquals(List.of(), shouldNotTranslate, "the invalid and untranslated tests must not translate");
        for (Map.Entry<String, int[]> family : EXPECTED.entrySet()) {
            int[] counts = observed.get(family.getKey());
            assertFalse(family.getValue()[0] < 0, "the counts of " + family.getKey() + " are not pinned yet" + table);
            assertEquals(family.getValue()[0], counts[0], family.getKey() + " passed" + table);
            assertEquals(family.getValue()[1], counts[1], family.getKey() + " refused" + table);
            assertEquals(family.getValue()[2], counts[2], family.getKey() + " recorded" + table);
        }
    }

    @Test
    void theManifestHoldsTheWholeSuite() {
        assertEquals(1830, manifest.size());
        assertEquals(1779, manifest.stream().filter(Manifest.Entry::translated).count());
        assertEquals(40, manifest.stream().filter(entry -> entry.invalid() != null).count());
        assertEquals(11, manifest.stream().filter(entry -> entry.untranslated() != null).count());
    }
}
