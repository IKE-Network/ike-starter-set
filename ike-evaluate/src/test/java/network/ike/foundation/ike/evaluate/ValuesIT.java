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

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The values themselves: the presence tables, the spans of written instants, the calendar
 * shifts, the readings of before and within for uncertainties against extents, and the units.
 */
class ValuesIT {

    private static StampCalculator calculator;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
    }

    @Test
    void thePresenceTablesAreCqlsThreeValuedTables() {
        assertEquals(Presence.INDETERMINATE, Presence.PRESENT.and(Presence.INDETERMINATE));
        assertEquals(Presence.ABSENT, Presence.ABSENT.and(Presence.INDETERMINATE));
        assertEquals(Presence.PRESENT, Presence.PRESENT.or(Presence.INDETERMINATE));
        assertEquals(Presence.INDETERMINATE, Presence.ABSENT.or(Presence.INDETERMINATE));
        assertEquals(Presence.INDETERMINATE, Presence.INDETERMINATE.not());
        assertEquals(Presence.INDETERMINATE, Presence.PRESENT.xor(Presence.INDETERMINATE));
        assertEquals(Presence.PRESENT, Presence.ABSENT.implies(Presence.INDETERMINATE));
        assertEquals(Presence.INDETERMINATE, Presence.PRESENT.implies(Presence.INDETERMINATE));
        assertTrue(Presence.INDETERMINATE.isMissing());
    }

    @Test
    void aWrittenInstantSpansWhatItCouldBe() {
        Measure january = Instants.date(2014, Optional.of(1), Optional.empty());
        Measure fifteenth = Instants.date(2014, Optional.of(1), Optional.of(15));
        assertEquals(Presence.INDETERMINATE, january.sameAs(fifteenth), "a month against a day within it is open");
        assertEquals(Presence.INDETERMINATE, january.before(fifteenth));
        assertEquals(Presence.ABSENT, Instants.date(2014, Optional.of(2), Optional.empty()).sameAs(fifteenth));
        assertEquals(Presence.PRESENT, fifteenth.before(Instants.date(2014, Optional.of(1), Optional.of(16))));
        assertEquals(Presence.ABSENT, fifteenth.before(fifteenth));
        assertEquals(Presence.PRESENT, fifteenth.sameAs(Instants.date(2014, Optional.of(1), Optional.of(15))));
    }

    @Test
    void anExtentIsDecidedByItsEndsWhereAnUncertaintyIsOpen() {
        Measure week = Measure.extent(Optional.of(BigDecimal.ONE), Optional.of(BigDecimal.valueOf(7)), true, true,
                MeasureSemantic.DIMENSIONLESS, Optional.empty());
        Measure later = Measure.extent(Optional.of(BigDecimal.valueOf(5)), Optional.of(BigDecimal.TEN), true, true,
                MeasureSemantic.DIMENSIONLESS, Optional.empty());
        assertEquals(Presence.ABSENT, week.before(later), "two extents that overlap are decided");
        assertEquals(Presence.PRESENT, week.overlaps(later));
        assertEquals(Presence.ABSENT, week.sameAs(later));
        Measure inside = Values.number(BigDecimal.valueOf(3));
        assertEquals(Presence.PRESENT, inside.within(week));
        assertEquals(Presence.ABSENT, Values.number(BigDecimal.valueOf(8)).within(week));
        Measure halfOpen = Measure.extent(Optional.of(BigDecimal.ONE), Optional.of(BigDecimal.valueOf(7)), true, false,
                MeasureSemantic.DIMENSIONLESS, Optional.empty());
        assertEquals(Presence.ABSENT, Values.number(BigDecimal.valueOf(7)).within(halfOpen), "an excluded end is outside");
        Measure day = Instants.date(2014, Optional.of(1), Optional.of(15));
        Measure year = Measure.extent(Instants.date(2014, Optional.empty(), Optional.empty()).lower(),
                Instants.date(2014, Optional.empty(), Optional.empty()).upper(), true, true, MeasureSemantic.CALENDAR,
                Optional.of(Resolution.DAY));
        assertEquals(Presence.PRESENT, day.within(year));
        Measure straddling = Measure.extent(Instants.date(2014, Optional.of(1), Optional.of(15)).lower()
                .map(bound -> bound.add(BigDecimal.valueOf(3_600_000))), year.upper(), true, true, MeasureSemantic.CALENDAR,
                Optional.of(Resolution.DAY));
        assertEquals(Presence.INDETERMINATE, day.within(straddling), "a day straddling an extent's start is open");
    }

    @Test
    void theCalendarShiftsByWholeMonthsAndClampsTheDay() {
        Measure lastOfJanuary = Instants.date(2014, Optional.of(1), Optional.of(31));
        Measure shifted = Instants.shift(lastOfJanuary, 1, Resolution.MONTH);
        assertEquals(Presence.PRESENT, shifted.sameAs(Instants.date(2014, Optional.of(2), Optional.of(28))));
        assertEquals(2, Instants.wholeUnitsBetween(Instants.date(2014, Optional.of(1), Optional.of(1)),
                Instants.date(2014, Optional.of(3), Optional.of(15)), Resolution.MONTH));
        assertEquals(1, Instants.boundariesBetween(Instants.date(2013, Optional.of(12), Optional.of(31)),
                Instants.date(2014, Optional.of(1), Optional.of(1)), Resolution.YEAR));
        assertEquals(0, Instants.wholeUnitsBetween(Instants.date(2013, Optional.of(12), Optional.of(31)),
                Instants.date(2014, Optional.of(1), Optional.of(1)), Resolution.YEAR));
    }

    @Test
    void writtenPlacesAndOffsetsAreKeptAndWrittenOut() {
        Evaluator evaluator = Evaluator.load(calculator, Authored.statements(), Authored.conceptSets());
        Library library = evaluator.library("CMS146").orElseThrow();
        Context context = new Context(evaluator, library, Optional.empty(), Environment.EMPTY, Map.of(), "types");
        Measure five = Values.number(new BigDecimal("5"));
        Measure fivePointZero = Values.number(new BigDecimal("5.0"));
        assertTrue(five.isWhole());
        assertFalse(fivePointZero.isWhole());
        assertEquals(Presence.PRESENT, five.sameAs(fivePointZero), "places never bear on comparison");
        assertEquals("5", Types.render(five).orElseThrow());
        assertEquals("5.0", Types.render(fivePointZero).orElseThrow());
        assertEquals("18.55", Types.render(Values.number(new BigDecimal("18.55"))).orElseThrow());
        Value decimal = Types.convert(five, new Types.SystemTarget("Decimal"), context);
        assertEquals("5.0", Types.render(decimal).orElseThrow(), "a whole number becomes a decimal at one place");
        assertTrue(new Types.SystemTarget("Integer").accepts(five));
        assertFalse(new Types.SystemTarget("Integer").accepts(fivePointZero));
        assertTrue(new Types.SystemTarget("Decimal").accepts(fivePointZero));
        Measure quantity = Measure.point(new BigDecimal("5.5"), evaluator.units().semanticOf("cm", context)).withPlaces(1);
        assertEquals("5.5 'cm'", Types.render(quantity).orElseThrow());
        Value instant = Types.convert(new Text("2014-01-01T12:05:05.955+01:30"), new Types.SystemTarget("DateTime"), context);
        assertEquals("2014-01-01T12:05:05.955+01:30", Types.render(instant).orElseThrow(), "the written offset comes back");
        Measure utc = Instants.dateTime(2014, Optional.of(1), Optional.of(1), Optional.of(10), Optional.of(35), Optional.of(5),
                Optional.of(955), Optional.empty());
        assertEquals(Presence.PRESENT, ((Measure) instant).sameAs(utc), "the offset never bears on comparison");
        assertEquals("2000-01-01", Types.render(Instants.date(2000, Optional.of(1), Optional.of(1))).orElseThrow());
        Value day = Types.convert(new Text("2000-01-01"), new Types.SystemTarget("DateTime"), context);
        assertEquals("2000-01-01", Types.render(day).orElseThrow(), "no time part is written when none was");
        Value time = Types.convert(new Text("T14:30:00.0+05:30"), new Types.SystemTarget("Time"), context);
        assertEquals("14:30:00.000", Types.render(time).orElseThrow(), "a time's offset is dropped");
        assertTrue(Types.convert(new Text("2014/01/01"), new Types.SystemTarget("DateTime"), context).isMissing());
        assertEquals(Presence.ABSENT, Types.convert(new Text("NO"), new Types.SystemTarget("Boolean"), context));
        assertEquals(Presence.INDETERMINATE, new Types.SystemTarget("Boolean").missing());
        assertFalse(new Types.SystemTarget("Integer").accepts(Missing.ANY), "a missing value is of no kind");
    }

    @Test
    void uncertaintiesAddBoundToBoundAndMultiplyByTheirCorners() {
        Measure span = new Measure(Optional.of(BigDecimal.valueOf(17)), Optional.of(BigDecimal.valueOf(44)), true, true,
                MeasureSemantic.DIMENSIONLESS, Optional.empty(), false, Optional.of(0), Optional.empty());
        Measure minusTwo = Values.number(BigDecimal.valueOf(-2));
        Measure sum = (Measure) Arithmetic.duration(Instants.date(2014, Optional.of(1), Optional.of(15)),
                Instants.date(2014, Optional.of(2), Optional.empty()), Resolution.DAY, false);
        assertEquals(Presence.PRESENT, sum.sameAs(span), "seventeen to forty-four days");
        assertFalse(sum.extent(), "a duration between uncertain instants is an uncertainty, not an interval");
        assertEquals(Presence.PRESENT, Presence.of(minusTwo.value().signum() < 0));
    }

    @Test
    void theArithmeticFunctionsReadWrittenPlacesAndSpans() {
        Evaluator evaluator = Evaluator.load(calculator, Authored.statements(), Authored.conceptSets());
        Library library = evaluator.library("CMS146").orElseThrow();
        Context context = new Context(evaluator, library, Optional.empty(), Environment.EMPTY, Map.of(), "functions");
        Measure onePointZero = Values.number(new BigDecimal("1.0"));
        assertEquals("1.00000001", Types.render(Functions.eight(1.00000001, MeasureSemantic.DIMENSIONLESS)).orElseThrow());
        assertEquals(17, Functions.digits(Resolution.MILLISECOND, false));
        assertEquals(4, Functions.digits(Resolution.MINUTE, true));
        assertEquals(6, Functions.digits(Resolution.MONTH, false));
        Measure grams = Measure.point(new BigDecimal("2"), evaluator.units().semanticOf("g", context));
        Measure centimeters = Measure.point(new BigDecimal("3"), evaluator.units().semanticOf("cm", context));
        MeasureSemantic composed = Units.compose(grams.semantic(), centimeters.semantic(), false).orElseThrow();
        assertEquals("g.cm", composed.unit());
        assertTrue(composed.commensurable(evaluator.units().semanticOf("g.cm", context)), "the composed unit is UCUM's g.cm");
        assertEquals(Presence.PRESENT, Measure.point(BigDecimal.ONE, composed).sameAs(Measure.point(BigDecimal.ONE,
                evaluator.units().semanticOf("g.cm", context))));
        MeasureSemantic quotient = Units.compose(grams.semantic(), centimeters.semantic(), true).orElseThrow();
        assertEquals("g/cm", quotient.unit());
        assertTrue(Units.compose(grams.semantic(), grams.semantic(), true).isEmpty(), "a quotient of commensurable units is a plain number");
        assertTrue(Units.compose(evaluator.units().semanticOf("month", context), grams.semantic(), false).isEmpty(),
                "calendar time does not compose");
        assertFalse(onePointZero.isWhole());
    }

    @Test
    void aDurationShiftsAnInstantOnTheCalendarAndAUcumUnitConverts() {
        Evaluator evaluator = Evaluator.load(calculator, Authored.statements(), Authored.conceptSets());
        Library library = evaluator.library("CMS146").orElseThrow();
        Context context = new Context(evaluator, library, Optional.empty(), Environment.EMPTY, Map.of(), "values");
        Units units = evaluator.units();
        Measure thirtyDays = Measure.point(BigDecimal.valueOf(30), units.semanticOf("days", context));
        Measure onset = Instants.date(2013, Optional.of(3), Optional.of(1));
        Measure earlier = Units.shift(onset, thirtyDays.negated()).orElseThrow();
        assertEquals(Presence.PRESENT, earlier.sameAs(Instants.date(2013, Optional.of(1), Optional.of(30))));
        Measure oneMonth = Measure.point(BigDecimal.ONE, units.semanticOf("month", context));
        assertEquals(Presence.PRESENT, Units.shift(Instants.date(2014, Optional.of(1), Optional.of(31)), oneMonth).orElseThrow()
                .sameAs(Instants.date(2014, Optional.of(2), Optional.of(28))));
        Measure grams = Measure.point(BigDecimal.valueOf(1500), units.semanticOf("g", context));
        Measure kilograms = Measure.point(new BigDecimal("1.5"), units.semanticOf("kg", context));
        assertEquals(Presence.PRESENT, grams.sameAs(kilograms), "grams and kilograms convert by their ratio");
        assertFalse(grams.commensurable(Measure.point(BigDecimal.ONE, units.semanticOf("m", context))));
        assertEquals(Presence.PRESENT, Values.compare(Measure.point(BigDecimal.valueOf(2), units.semanticOf("h", context)),
                Measure.point(BigDecimal.valueOf(90), units.semanticOf("minutes", context)), Values.Order.GREATER),
                "a UCUM hour and the calendar word minute are both definite time");
        assertFalse(units.semanticOf("year", context).commensurable(units.semanticOf("days", context)),
                "calendar years are not a number of days");
    }
}
