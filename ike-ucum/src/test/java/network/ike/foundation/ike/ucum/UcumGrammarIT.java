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

import network.ike.foundation.ike.ucum.UcumTerm.Factor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The grammar reads UCUM's codes as the specification gives them, one unit spelled two ways
 * reads to one canonical code, and a code that cannot be read is refused with its place.
 */
class UcumGrammarIT {

    private static UcumEssence essence;

    @BeforeAll
    static void read() throws IOException {
        essence = UcumEssence.read();
    }

    private static UcumTerm parse(String code) {
        return UcumGrammar.parse(code, essence);
    }

    @Test
    @DisplayName("Composed codes parse: mm[Hg], kg.m/s2, 10*3/uL, {cells}/uL")
    void composedCodesParse() {
        UcumTerm mercury = parse("mm[Hg]");
        assertEquals(List.of(new Factor("m", "m[Hg]", 1)), mercury.factors());
        assertEquals("mm[Hg]", mercury.canonicalCode());
        assertFalse(mercury.isAtom(), "a prefixed atom is composed");

        assertEquals("kg.m.s-2", parse("kg.m/s2").canonicalCode());
        assertEquals("10*3.uL-1", parse("10*3/uL").canonicalCode());

        UcumTerm cells = parse("{cells}/uL");
        assertEquals("uL-1", cells.canonicalCode(), "an annotation is outside the meaning");
        assertEquals(List.of("cells"), cells.annotations());

        assertEquals("min-1", parse("/min").canonicalCode());
        assertEquals("m.s-2", parse("(m/s)/s").canonicalCode());
        assertEquals("2.[pi].rad", parse("2.[pi].rad").canonicalCode());
        assertEquals("1", parse("1").canonicalCode());
        assertEquals("1", parse("{score}").canonicalCode());
        assertEquals("10*-5", parse("10*-5").canonicalCode());
    }

    @Test
    @DisplayName("mg/dL and mg.dL-1 are one canonical code, and a single atom is the atom")
    void oneUnitSpelledTwoWaysIsOneCode() {
        assertEquals("mg.dL-1", parse("mg/dL").canonicalCode());
        assertEquals("mg.dL-1", parse("mg.dL-1").canonicalCode());
        assertEquals("mg.dL-1", parse("dL-1.mg").canonicalCode());
        assertEquals("m", parse("m.m/m").canonicalCode(), "factors on one atom merge");
        assertEquals("1", parse("m/m").canonicalCode());

        assertTrue(parse("m").isAtom());
        assertEquals("m", parse("m{tissue}").atom(), "an annotation does not unmake an atom");
        assertEquals("cd", parse("cd").atom(), "the candela, not a centi-day");
        assertEquals("Pa", parse("Pa").atom(), "the pascal, not a peta-year");
        assertEquals("kat", parse("kat").atom());
        assertEquals(List.of(new Factor("m", "s", 1)), parse("ms").factors(), "milli on the second");
        assertEquals(List.of(new Factor("n", "m", 1)), parse("nm").factors());
        assertEquals(List.of(new Factor("da", "m", 1)), parse("dam").factors(), "the longest prefix");
        assertEquals("[in_i]", parse("[in_i]").atom());
        assertEquals(0, parse("100").number().compareTo(new BigDecimal(100)));
    }

    @Test
    @DisplayName("A code that cannot be read is refused with its place")
    void aMalformedCodeIsRefusedWithItsPlace() {
        UcumSyntaxException doubled = assertThrows(UcumSyntaxException.class, () -> parse("mg//dL"));
        assertEquals(3, doubled.position());
        assertEquals("mg//dL", doubled.code());
        assertTrue(doubled.getMessage().startsWith("'mg//dL' at 3: "), doubled.getMessage());

        assertEquals(0, assertThrows(UcumSyntaxException.class, () -> parse("xyz")).position());
        UcumSyntaxException prefixed = assertThrows(UcumSyntaxException.class, () -> parse("kd"));
        assertTrue(prefixed.getMessage().contains("d is not metric and takes no prefix"), prefixed.getMessage());
        assertEquals(1, assertThrows(UcumSyntaxException.class, () -> parse("m(")).position(), "a parenthesis where a period or solidus belongs");
        assertTrue(assertThrows(UcumSyntaxException.class, () -> parse("{cells")).getMessage().contains("not closed"));
        assertEquals(0, assertThrows(UcumSyntaxException.class, () -> parse("")).position());
        assertEquals(2, assertThrows(UcumSyntaxException.class, () -> parse("m-")).position());
        assertEquals(1, assertThrows(UcumSyntaxException.class, () -> parse("m)")).position());
        assertEquals(1, assertThrows(UcumSyntaxException.class, () -> parse("m s")).position(), "a space is nothing UCUM writes");
    }
}
