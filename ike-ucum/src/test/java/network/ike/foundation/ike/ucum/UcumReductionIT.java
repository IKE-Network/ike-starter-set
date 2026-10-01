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

import network.ike.foundation.ike.ucum.UcumEssence.Unit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Every unit that is neither special nor arbitrary reduces to the base units, the known
 * reductions hold exactly, and the special and arbitrary units are flagged rather than
 * converted.
 */
class UcumReductionIT {

    private static UcumEssence essence;

    @BeforeAll
    static void read() throws IOException {
        essence = UcumEssence.read();
    }

    private static UcumReduction reduce(String code) {
        return UcumGrammar.parse(code, essence).reduce(essence);
    }

    private static void assertSame(String expected, BigDecimal actual, String message) {
        assertEquals(0, new BigDecimal(expected).compareTo(actual), message + ": expected " + expected + ", was " + actual);
    }

    @Test
    @DisplayName("Every unit that is neither special nor arbitrary reduces to the base units")
    void everyOrdinaryUnitReduces() {
        int ordinary = 0;
        for (Unit unit : essence.units()) {
            UcumReduction reduction = essence.reduction(unit.code());
            if (unit.arbitrary()) {
                assertTrue(reduction.arbitrary(), unit.code() + " is arbitrary");
                continue;
            }
            if (unit.special()) {
                assertTrue(reduction.special(), unit.code() + " is special");
                continue;
            }
            assertFalse(reduction.special() || reduction.arbitrary(), unit.code() + " converts by a ratio");
            assertTrue(reduction.magnitude().signum() > 0, unit.code() + " has a positive magnitude");
            ordinary++;
        }
        assertEquals(305 - 21 - 41, ordinary);
        for (UcumEssence.BaseUnit base : essence.baseUnits()) {
            UcumReduction reduction = essence.reduction(base.code());
            assertEquals(base.dimension(), reduction.dimension());
            assertSame("1", reduction.magnitude(), base.code());
        }
    }

    @Test
    @DisplayName("An hour is 3600 seconds, a liter a thousandth of a cubic meter, a millimeter of mercury 133.322 pascals")
    void theKnownReductionsHoldExactly() {
        UcumReduction hour = essence.reduction("h");
        assertEquals("T", hour.dimension());
        assertSame("3600", hour.magnitude(), "an hour in seconds");

        UcumReduction liter = essence.reduction("L");
        assertEquals("L3", liter.dimension());
        assertSame("0.001", liter.magnitude(), "a liter in cubic meters");

        UcumReduction mercury = reduce("mm[Hg]");
        UcumReduction pascal = essence.reduction("Pa");
        assertEquals("L-1.T-2.M", pascal.dimension());
        assertSame("133.322", mercury.ratioTo(pascal).orElseThrow(), "a millimeter of mercury in pascals");

        assertSame("100", reduce("g/L").ratioTo(reduce("mg/dL")).orElseThrow(), "grams per liter in milligrams per deciliter");
        assertEquals(0, new BigDecimal("1000").divide(new BigDecimal("3600"), UcumReduction.PRECISION)
                .compareTo(reduce("km/h").ratioTo(reduce("m/s")).orElseThrow()), "kilometers per hour in meters per second");
        assertSame("0.001", reduce("ms").magnitude(), "a millisecond in seconds");
        assertEquals("L.T-1", reduce("km/h").dimension());
    }

    @Test
    @DisplayName("Special and arbitrary units are flagged and refuse a ratio; unlike dimensions refuse one too")
    void flaggedUnitsRefuseARatio() {
        UcumReduction celsius = essence.reduction("Cel");
        assertTrue(celsius.special());
        assertEquals("C", celsius.dimension(), "a special unit still has its dimension");
        assertTrue(celsius.ratioTo(essence.reduction("K")).isEmpty(), "degrees Celsius do not convert by a ratio");
        assertTrue(essence.reduction("[pH]").special());
        assertTrue(essence.reduction("[IU]").arbitrary());
        assertTrue(essence.reduction("[IU]").ratioTo(UcumReduction.ONE).isEmpty(), "an arbitrary unit never converts");
        assertTrue(essence.reduction("m").ratioTo(essence.reduction("s")).isEmpty(), "length and time are not commensurable");
        assertFalse(essence.reduction("m").commensurable(essence.reduction("s")));
        assertTrue(reduce("mg/dL").commensurable(reduce("g/L")));
        assertEquals(UcumReduction.ONE, UcumReduction.of("1", BigDecimal.ONE, false, false));
        assertEquals(pascalLike(), UcumReduction.of("L-1.T-2.M", new BigDecimal("1000"), false, false),
                "a reduction reads back from its recorded form");
    }

    private static UcumReduction pascalLike() {
        return essence.reduction("Pa");
    }
}
