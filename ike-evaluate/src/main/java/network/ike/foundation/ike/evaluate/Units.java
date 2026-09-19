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

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.ucum.UcumReduction;
import network.ike.foundation.ike.ucum.UcumSyntaxException;
import network.ike.foundation.ike.ucum.UcumTerm;
import network.ike.foundation.ike.ucum.UcumUnits;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The units a quantity can carry, read into measure semantics. A CQL calendar word, singular or
 * plural, means IKE's unit of time: weeks and finer are definite spans of seconds on the time
 * dimension; months and years are calendar spans, counted in months, since a month is the
 * month on the calendar and not a fixed number of seconds. Any other unit is a UCUM code read
 * against the units in the store, reduced to its dimension and magnitude, so that commensurable
 * units convert by their ratio.
 */
final class Units {

    /** The dimension of definite time: seconds, as UCUM reduces them. */
    static final String TIME = UcumReduction.base("T").dimension();

    /** The dimension of calendar time: months, which no number of seconds fixes. */
    static final String CALENDAR_TIME = "T.calendar";

    private static final Map<String, EntityProxy.Concept> CALENDAR_WORDS = Map.ofEntries(
            Map.entry("year", IkeTerms.YEAR), Map.entry("years", IkeTerms.YEAR),
            Map.entry("month", IkeTerms.MONTH), Map.entry("months", IkeTerms.MONTH),
            Map.entry("week", IkeTerms.WEEK), Map.entry("weeks", IkeTerms.WEEK),
            Map.entry("day", IkeTerms.DAY), Map.entry("days", IkeTerms.DAY),
            Map.entry("hour", IkeTerms.HOUR), Map.entry("hours", IkeTerms.HOUR),
            Map.entry("minute", IkeTerms.MINUTE), Map.entry("minutes", IkeTerms.MINUTE),
            Map.entry("second", IkeTerms.SECOND), Map.entry("seconds", IkeTerms.SECOND),
            Map.entry("millisecond", IkeTerms.MILLISECOND), Map.entry("milliseconds", IkeTerms.MILLISECOND));

    private final UcumUnits units;
    private final Map<String, MeasureSemantic> read = new HashMap<>();

    Units(UcumUnits units) {
        this.units = units;
    }

    /**
     * The measure semantic a unit text means.
     *
     * @param unit the unit as written, empty or 1 for a plain number
     * @return the semantic
     * @throws Refused when the unit cannot be read
     */
    MeasureSemantic semanticOf(String unit, Context context) {
        if (unit.isEmpty() || unit.equals("1")) {
            return MeasureSemantic.DIMENSIONLESS;
        }
        MeasureSemantic found = read.get(unit);
        if (found != null) {
            return found;
        }
        EntityProxy.Concept calendar = CALENDAR_WORDS.get(unit);
        if (calendar != null) {
            found = calendarSemantic(calendar);
        } else {
            if (units.isEmpty()) {
                throw context.refuse("the unit " + unit + " is a UCUM code, and the store holds no UCUM units");
            }
            try {
                UcumTerm term = units.parse(unit);
                UcumReduction reduction = term.reduce(units);
                PublicId identity = units.identity(term);
                int nid = PrimitiveData.get().hasPublicId(identity) ? PrimitiveData.nid(identity) : 0;
                found = MeasureSemantic.unit(nid, reduction.dimension(), reduction.magnitude());
            } catch (UcumSyntaxException refused) {
                throw context.refuse("the unit " + unit + " cannot be read: " + refused.getMessage());
            }
        }
        read.put(unit, found);
        return found;
    }

    /** IKE's unit of time as a semantic: a span of seconds, or of calendar months. */
    static MeasureSemantic calendarSemantic(EntityProxy.Concept unit) {
        if (unit.nid() == IkeTerms.YEAR.nid()) {
            return MeasureSemantic.unit(unit.nid(), CALENDAR_TIME, BigDecimal.valueOf(12));
        }
        if (unit.nid() == IkeTerms.MONTH.nid()) {
            return MeasureSemantic.unit(unit.nid(), CALENDAR_TIME, BigDecimal.ONE);
        }
        if (unit.nid() == IkeTerms.MILLISECOND.nid()) {
            return MeasureSemantic.unit(unit.nid(), TIME, new BigDecimal("0.001"));
        }
        return MeasureSemantic.unit(unit.nid(), TIME, BigDecimal.valueOf(seconds(unit)));
    }

    private static long seconds(EntityProxy.Concept unit) {
        if (unit.nid() == IkeTerms.WEEK.nid()) {
            return 604_800L;
        }
        if (unit.nid() == IkeTerms.DAY.nid()) {
            return 86_400L;
        }
        if (unit.nid() == IkeTerms.HOUR.nid()) {
            return 3_600L;
        }
        if (unit.nid() == IkeTerms.MINUTE.nid()) {
            return 60L;
        }
        return 1L;
    }

    /** The semantic of a span of milliseconds, for widths and differences of instants. */
    static MeasureSemantic milliseconds() {
        return MeasureSemantic.unit(IkeTerms.MILLISECOND.nid(), TIME, new BigDecimal("0.001"));
    }

    /**
     * Whether a semantic is a duration: definite time or calendar time.
     *
     * @param semantic the semantic
     * @return true for a duration
     */
    static boolean isDuration(MeasureSemantic semantic) {
        return semantic.scale() == MeasureSemantic.Scale.UNIT
                && (semantic.dimension().equals(TIME) || semantic.dimension().equals(CALENDAR_TIME));
    }

    /**
     * Whether a semantic places a value in time: on the calendar, the epoch, or the day.
     *
     * @param semantic the semantic
     * @return true for an instant, a date, or a time of day
     */
    static boolean isTemporal(MeasureSemantic semantic) {
        return semantic.scale() == MeasureSemantic.Scale.CALENDAR || semantic.scale() == MeasureSemantic.Scale.EPOCH
                || semantic.scale() == MeasureSemantic.Scale.DAY;
    }

    /**
     * A temporal measure moved by a duration, on the calendar: months and years by whole
     * months, definite time by its milliseconds.
     *
     * @param measure  the instant, date, or time of day
     * @param duration a point duration
     * @return the shifted measure, or empty when the duration is not a point
     */
    static Optional<Measure> shift(Measure measure, Measure duration) {
        if (!duration.isPoint()) {
            return Optional.empty();
        }
        BigDecimal amount = duration.value().multiply(duration.semantic().magnitude(), Measure.PRECISION);
        Measure shifted;
        if (duration.semantic().dimension().equals(CALENDAR_TIME)) {
            shifted = Instants.shift(measure, amount.longValue(), Resolution.MONTH);
        } else {
            BigDecimal millis = amount.multiply(BigDecimal.valueOf(1000), Measure.PRECISION);
            if (measure.semantic().scale() == MeasureSemantic.Scale.DAY) {
                shifted = measure.mapBounds(bound -> bound.add(millis, Measure.PRECISION), measure.semantic());
            } else {
                shifted = Instants.shift(measure, millis.longValue(), Resolution.MILLISECOND);
            }
        }
        return Optional.of(atResolution(shifted, finer(measure.resolution(), unitResolution(duration.semantic()))));
    }

    /**
     * The resolution a duration's unit is written at: the calendar word's own unit, or the
     * millisecond for a UCUM unit, which is definite.
     */
    static Resolution unitResolution(MeasureSemantic semantic) {
        int nid = semantic.unitNid();
        if (nid == IkeTerms.YEAR.nid()) {
            return Resolution.YEAR;
        }
        if (nid == IkeTerms.MONTH.nid()) {
            return Resolution.MONTH;
        }
        if (nid == IkeTerms.WEEK.nid() || nid == IkeTerms.DAY.nid()) {
            return Resolution.DAY;
        }
        if (nid == IkeTerms.HOUR.nid()) {
            return Resolution.HOUR;
        }
        if (nid == IkeTerms.MINUTE.nid()) {
            return Resolution.MINUTE;
        }
        if (nid == IkeTerms.SECOND.nid()) {
            return Resolution.SECOND;
        }
        return Resolution.MILLISECOND;
    }

    private static Optional<Resolution> finer(Optional<Resolution> written, Resolution unit) {
        if (written.isEmpty()) {
            return written;
        }
        return Optional.of(unit.finerThan(written.get()) ? unit : written.get());
    }

    private static Measure atResolution(Measure measure, Optional<Resolution> resolution) {
        return new Measure(measure.lower(), measure.upper(), measure.lowerIncluded(), measure.upperIncluded(),
                measure.semantic(), resolution, measure.extent());
    }
}
