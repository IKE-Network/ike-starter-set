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

import network.ike.foundation.ike.ucum.UcumEssence.BaseUnit;
import network.ike.foundation.ike.ucum.UcumEssence.Prefix;
import network.ike.foundation.ike.ucum.UcumEssence.Unit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The bundled file reads as the file it is: version 2.2 with its counts, and every field as
 * the file writes it.
 */
class UcumEssenceIT {

    private static UcumEssence essence;

    @BeforeAll
    static void read() throws IOException {
        essence = UcumEssence.read();
    }

    @Test
    @DisplayName("The file is UCUM 2.2: 24 prefixes, 7 base units, 305 units, 21 special, 41 arbitrary, 101 properties")
    void theFileIsVersionTwoPointTwoWithItsCounts() {
        assertEquals("2.2", essence.version());
        assertEquals("2024-06-17", essence.revisionDate());
        assertEquals(24, essence.prefixes().size());
        assertEquals(7, essence.baseUnits().size());
        assertEquals(305, essence.units().size());
        assertEquals(21, essence.units().stream().filter(Unit::special).count());
        assertEquals(41, essence.units().stream().filter(Unit::arbitrary).count());
        assertEquals(101, essence.properties().size(), "the distinct property texts, base units included");
        assertEquals(15, essence.units().stream().filter(unit -> unit.names().size() > 1).count(), "units the file names twice");
        assertEquals(312, essence.atomCodes().size(), "every base unit and unit is an atom");
        assertEquals(24, essence.prefixCodes().size());
    }

    @Test
    @DisplayName("Every field is as the file writes it")
    void everyFieldIsAsTheFileWritesIt() {
        BaseUnit meter = essence.baseUnit("m").orElseThrow();
        assertEquals("M", meter.caseInsensitiveCode());
        assertEquals("L", meter.dimension());
        assertEquals("meter", meter.name());
        assertEquals("m", meter.printSymbol());
        assertEquals("length", meter.property());

        Unit minute = essence.unit("min").orElseThrow();
        assertEquals("MIN", minute.caseInsensitiveCode());
        assertEquals(List.of("minute"), minute.names());
        assertEquals("min", minute.printSymbol());
        assertEquals("time", minute.property());
        assertEquals("iso1000", minute.unitClass());
        assertFalse(minute.metric());
        assertFalse(minute.special());
        assertFalse(minute.arbitrary());
        assertEquals("60", minute.definitionValue());
        assertEquals("s", minute.definitionUnit());
        assertTrue(minute.function().isEmpty());

        Unit celsius = essence.unit("Cel").orElseThrow();
        assertTrue(celsius.special());
        assertTrue(celsius.metric());
        assertEquals("cel(1 K)", celsius.definitionUnit(), "the definition as written names the function");
        assertEquals("", celsius.definitionValue(), "a special unit writes no value on its definition");
        assertEquals("1", celsius.definitionNumber(), "the number is the function's");
        assertEquals(new UcumEssence.Function("Cel", "1", "K"), celsius.function().orElseThrow());

        Unit mercury = essence.unit("m[Hg]").orElseThrow();
        assertEquals("133.3220", mercury.definitionValue());
        assertEquals("kPa", mercury.definitionUnit());
        assertEquals("m" + (char) 160 + "Hg", mercury.printSymbol(), "the no-break space the file writes stays");
        assertEquals("pressure", mercury.property());

        assertTrue(essence.unit("[hp_X]").orElseThrow().arbitrary());
        assertEquals(List.of("international unit"), essence.unit("[iU]").orElseThrow().names());
        assertEquals(2, essence.units().stream().filter(unit -> unit.names().contains("international unit")).count(),
                "two codes carry one name, and each keeps it");

        Prefix kilo = essence.prefix("k").orElseThrow();
        assertEquals("kilo", kilo.name());
        assertEquals("k", kilo.printSymbol());
        assertEquals("1e3", kilo.value());
        assertEquals(0, kilo.factor().compareTo(new BigDecimal("1000")));

        for (Unit unit : essence.units()) {
            assertTrue(unit.printSymbol().chars().noneMatch(Character::isISOControl),
                    unit.code() + ": the file's line breaks are collapsed");
            assertFalse(unit.names().isEmpty(), unit.code() + " has a name");
            assertFalse(unit.property().isEmpty(), unit.code() + " has a property");
        }
    }
}
