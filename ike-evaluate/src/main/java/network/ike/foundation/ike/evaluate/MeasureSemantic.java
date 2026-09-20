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

import java.math.BigDecimal;
import java.util.Optional;

/**
 * What a measure's number means: the coordinate system its value is read in. A dimensionless
 * number; a unit, UCUM's or a unit of time, by the unit concept with its reduction to the base
 * units so that commensurable units convert; the calendar, on which a date is a span of days
 * counted in milliseconds from the epoch; the epoch, on which an instant is milliseconds from
 * 1970 in UTC; the day, on which a time is milliseconds from midnight.
 *
 * @param scale     the scale
 * @param unitNid   the unit concept, for a unit
 * @param dimension the unit's dimension text, for a unit, as the UCUM record holds it
 * @param magnitude the unit's magnitude in the base units, for a unit
  * @param unit      the unit as written, 1 for a plain number, empty on a time scale
 */
public record MeasureSemantic(Scale scale, int unitNid, String dimension, BigDecimal magnitude, String unit) {

    /** The scales a measure can be read on. */
    public enum Scale {
        /** A dimensionless number. */
        DIMENSIONLESS,
        /** A unit, with its reduction. */
        UNIT,
        /** The Gregorian calendar, a span of days in milliseconds from the epoch. */
        CALENDAR,
        /** The epoch, an instant in milliseconds from 1970 in UTC. */
        EPOCH,
        /** The day, a time in milliseconds from midnight. */
        DAY
    }

    /** The dimensionless number. */
    public static final MeasureSemantic DIMENSIONLESS = new MeasureSemantic(Scale.DIMENSIONLESS, 0, "1", BigDecimal.ONE, "1");

    /** The Gregorian calendar. */
    public static final MeasureSemantic CALENDAR = new MeasureSemantic(Scale.CALENDAR, 0, "T", BigDecimal.ONE, "");

    /** The epoch. */
    public static final MeasureSemantic EPOCH = new MeasureSemantic(Scale.EPOCH, 0, "T", BigDecimal.ONE, "");

    /** The day, for a time of day. */
    public static final MeasureSemantic DAY = new MeasureSemantic(Scale.DAY, 0, "T", BigDecimal.ONE, "");

    /**
     * A unit.
     *
     * @param unitNid   the unit concept
     * @param dimension its dimension text
     * @param magnitude its magnitude in the base units
     * @return the semantic
     */
    public static MeasureSemantic unit(int unitNid, String dimension, BigDecimal magnitude) {
        return new MeasureSemantic(Scale.UNIT, unitNid, dimension, magnitude, "");
    }

    /**
     * A unit semantic that remembers the unit as written, for writing the measure out.
     *
     * @param unitNid   the unit's concept nid, 0 when none
     * @param dimension the dimension
     * @param magnitude the magnitude on the dimension's base
     * @param unit      the unit as written
     * @return the semantic
     */
    public static MeasureSemantic unit(int unitNid, String dimension, BigDecimal magnitude, String unit) {
        return new MeasureSemantic(Scale.UNIT, unitNid, dimension, magnitude, unit);
    }

    /**
     * Whether two semantics compare: the same scale, and for units the same dimension.
     *
     * @param other the other semantic
     * @return true when commensurable
     */
    public boolean commensurable(MeasureSemantic other) {
        if (scale != other.scale) {
            return scale == Scale.CALENDAR && other.scale == Scale.EPOCH || scale == Scale.EPOCH && other.scale == Scale.CALENDAR;
        }
        return scale != Scale.UNIT || dimension.equals(other.dimension);
    }

    /**
     * How many of the other make one of this: the ratio of magnitudes for commensurable units,
     * one for the same scale otherwise; empty when the two do not convert.
     *
     * @param other the other semantic
     * @return the ratio
     */
    public Optional<BigDecimal> ratioTo(MeasureSemantic other) {
        if (!commensurable(other)) {
            return Optional.empty();
        }
        if (scale != Scale.UNIT) {
            return Optional.of(BigDecimal.ONE);
        }
        if (magnitude.signum() == 0 || other.magnitude.signum() == 0) {
            return Optional.empty();
        }
        return Optional.of(magnitude.divide(other.magnitude, Measure.PRECISION));
    }
}
