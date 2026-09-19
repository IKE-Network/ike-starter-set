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
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.function.UnaryOperator;

/**
 * A measure: two bounds on a measure semantic, each included or not. A point is a measure whose
 * bounds coincide. A value written to a resolution, an instant written to a day, spans what it
 * could be, its bounds where the value could lie: an uncertainty. An extent, CQL's interval, is
 * a measure whose bounds are the ends of a range, every point of which is meant. The two are
 * told apart by the extent flag, since the same two bounds read differently: an uncertainty
 * overlapping another is Indeterminate where an extent overlapping another is decided. The
 * measure semantic says what the number means: a dimensionless number, a unit of UCUM or a
 * unit of time, the calendar for dates, the epoch for instants, the day for times of day. A
 * bound that is unknown is absent.
 *
 * @param lower         the lower bound, empty when unknown
 * @param upper         the upper bound, empty when unknown
 * @param lowerIncluded whether the lower bound is included
 * @param upperIncluded whether the upper bound is included
 * @param semantic      the measure semantic
 * @param resolution    the resolution the value or the extent's ends were written at, empty when none applies
 * @param extent        true for a range of points, false for one value, certain or uncertain
 */
public record Measure(Optional<BigDecimal> lower, Optional<BigDecimal> upper, boolean lowerIncluded, boolean upperIncluded,
                      MeasureSemantic semantic, Optional<Resolution> resolution, boolean extent) implements Value {

    /** Arithmetic on bounds, forty significant digits, half even. */
    public static final MathContext PRECISION = new MathContext(40, RoundingMode.HALF_EVEN);

    /**
     * The kind of this value.
     *
     * @return the kind
     */
    @Override
    public Kind kind() {
        return Kind.MEASURE;
    }

    /**
     * A point: a value known exactly.
     *
     * @param value    the value
     * @param semantic the measure semantic
     * @return the measure
     */
    public static Measure point(BigDecimal value, MeasureSemantic semantic) {
        return new Measure(Optional.of(value), Optional.of(value), true, true, semantic, Optional.empty(), false);
    }

    /**
     * A value written to a resolution, spanning what it could be.
     *
     * @param lower      the start of the span
     * @param upper      the end of the span
     * @param semantic   the measure semantic
     * @param resolution the resolution
     * @return the measure
     */
    public static Measure span(BigDecimal lower, BigDecimal upper, MeasureSemantic semantic, Resolution resolution) {
        return new Measure(Optional.of(lower), Optional.of(upper), true, true, semantic, Optional.of(resolution), false);
    }

    /**
     * An extent: a range of points between two ends. In time, where the points are
     * milliseconds, an excluded end steps to the included instant beside it, so that two
     * extents over the same instants read the same.
     *
     * @param lower         the lower end, empty when unknown
     * @param upper         the upper end, empty when unknown
     * @param lowerIncluded whether the lower end is included
     * @param upperIncluded whether the upper end is included
     * @param semantic      the measure semantic
     * @param resolution    the resolution the ends were written at, empty when none applies
     * @return the measure
     */
    public static Measure extent(Optional<BigDecimal> lower, Optional<BigDecimal> upper, boolean lowerIncluded,
                                 boolean upperIncluded, MeasureSemantic semantic, Optional<Resolution> resolution) {
        if (Units.isTemporal(semantic)) {
            Optional<BigDecimal> first = lowerIncluded ? lower : lower.map(bound -> bound.add(BigDecimal.ONE));
            Optional<BigDecimal> last = upperIncluded ? upper : upper.map(bound -> bound.subtract(BigDecimal.ONE));
            return new Measure(first, last, true, true, semantic, resolution, true);
        }
        return new Measure(lower, upper, lowerIncluded, upperIncluded, semantic, resolution, true);
    }

    /**
     * Whether both bounds are known.
     *
     * @return true when known
     */
    public boolean bounded() {
        return lower.isPresent() && upper.isPresent();
    }

    /**
     * Whether the bounds coincide: a value known exactly.
     *
     * @return true for a point
     */
    public boolean isPoint() {
        return bounded() && lower.get().compareTo(upper.get()) == 0;
    }

    /**
     * The value: the lower bound, which is the value of a point and the start of a span.
     *
     * @return the lower bound
     * @throws java.util.NoSuchElementException when the lower bound is unknown
     */
    public BigDecimal value() {
        return lower.orElseThrow();
    }

    /**
     * Whether two measures can be compared at all: the same kind of thing.
     *
     * @param other the other measure
     * @return true when commensurable
     */
    public boolean commensurable(Measure other) {
        return semantic.commensurable(other.semantic);
    }

    /**
     * This measure with its bounds expressed on another commensurable semantic.
     *
     * @param target the semantic to convert to
     * @return the converted measure, or empty when the two do not convert by a ratio
     */
    public Optional<Measure> convertedTo(MeasureSemantic target) {
        if (semantic.equals(target)) {
            return Optional.of(this);
        }
        Optional<BigDecimal> ratio = semantic.ratioTo(target);
        if (ratio.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new Measure(lower.map(bound -> bound.multiply(ratio.get(), PRECISION)),
                upper.map(bound -> bound.multiply(ratio.get(), PRECISION)), lowerIncluded, upperIncluded, target, resolution, extent));
    }

    /**
     * Whether this measure lies wholly before the other. Present when this measure's last
     * point is before the other's first, touching only when one of the two bounds is excluded.
     * Absent when nothing of this measure can be before anything of the other: for two extents,
     * whenever it is not Present; for two values written at the same resolution, likewise,
     * since they are compared at that resolution; for an uncertainty against a value written
     * differently, when its earliest possible value is no earlier than the other's latest.
     * Indeterminate otherwise, and when a bound is unknown.
     *
     * @param other the other measure, on a commensurable semantic
     * @return the presence
     */
    public Presence before(Measure other) {
        if (upper.isEmpty() || other.lower.isEmpty()) {
            return Presence.INDETERMINATE;
        }
        int order = upper.get().compareTo(other.lower.get());
        if (order < 0 || (order == 0 && !(upperIncluded && other.lowerIncluded))) {
            return Presence.PRESENT;
        }
        if (extent && other.extent) {
            return Presence.ABSENT;
        }
        if (!extent && !other.extent && resolution.equals(other.resolution)) {
            return Presence.ABSENT;
        }
        Optional<BigDecimal> earliest = extent ? upper : lower;
        Optional<BigDecimal> latest = other.extent ? other.lower : other.upper;
        if (earliest.isEmpty() || latest.isEmpty()) {
            return Presence.INDETERMINATE;
        }
        return earliest.get().compareTo(latest.get()) >= 0 ? Presence.ABSENT : Presence.INDETERMINATE;
    }

    /**
     * Whether this measure lies wholly after the other: the other before this.
     *
     * @param other the other measure, on a commensurable semantic
     * @return the presence
     */
    public Presence after(Measure other) {
        return other.before(this);
    }

    /**
     * Whether this measure lies within the other: every point of this between the other's
     * bounds. For an uncertainty against an extent, Present when the whole span lies inside,
     * Absent when it lies wholly outside, Indeterminate when it straddles an end. Two extents
     * are decided by their ends.
     *
     * @param other the other measure, on a commensurable semantic
     * @return the presence
     */
    public Presence within(Measure other) {
        if (!bounded() || !other.bounded()) {
            return Presence.INDETERMINATE;
        }
        int low = lower.get().compareTo(other.lower.get());
        int high = upper.get().compareTo(other.upper.get());
        boolean lowInside = low > 0 || (low == 0 && (other.lowerIncluded || !lowerIncluded));
        boolean highInside = high < 0 || (high == 0 && (other.upperIncluded || !upperIncluded));
        if (lowInside && highInside) {
            return Presence.PRESENT;
        }
        if (extent) {
            return Presence.ABSENT;
        }
        Presence apart = before(other).or(after(other));
        return apart == Presence.PRESENT ? Presence.ABSENT : Presence.INDETERMINATE;
    }

    /**
     * Whether the two measures share a point.
     *
     * @param other the other measure, on a commensurable semantic
     * @return the presence, Indeterminate where an uncertainty leaves it open
     */
    public Presence overlaps(Measure other) {
        Presence apart = before(other).or(after(other));
        return apart.not();
    }

    /**
     * Whether the two measures are the same. Two extents are the same when their ends and
     * inclusions agree. Two values are the same when their spans agree; written at the same
     * resolution and differing, they are not; written at different resolutions and
     * overlapping, Indeterminate, since the values could still be one; sharing no point,
     * Absent. An extent and a value are never the same.
     *
     * @param other the other measure
     * @return the presence
     */
    public Presence sameAs(Measure other) {
        if (!commensurable(other)) {
            return Presence.ABSENT;
        }
        Optional<Measure> converted = other.convertedTo(semantic);
        if (converted.isEmpty()) {
            return Presence.INDETERMINATE;
        }
        Measure that = converted.get();
        if (extent != that.extent) {
            return Presence.ABSENT;
        }
        if (!bounded() || !that.bounded()) {
            return Presence.INDETERMINATE;
        }
        boolean same = lower.get().compareTo(that.lower.get()) == 0 && upper.get().compareTo(that.upper.get()) == 0
                && lowerIncluded == that.lowerIncluded && upperIncluded == that.upperIncluded;
        if (same) {
            return Presence.PRESENT;
        }
        if (extent || resolution.equals(that.resolution)) {
            return Presence.ABSENT;
        }
        return sharesPoint(that) ? Presence.INDETERMINATE : Presence.ABSENT;
    }

    /** Whether the two bounded measures share at least one point. */
    private boolean sharesPoint(Measure that) {
        int low = lower.get().compareTo(that.upper.get());
        int high = that.lower.get().compareTo(upper.get());
        boolean startsInTime = low < 0 || (low == 0 && lowerIncluded && that.upperIncluded);
        boolean endsInTime = high < 0 || (high == 0 && that.lowerIncluded && upperIncluded);
        return startsInTime && endsInTime;
    }

    /**
     * The width: the upper bound less the lower, on the measure semantic.
     *
     * @return the width as a point, or a missing measure when a bound is unknown
     */
    public Value width() {
        if (!bounded()) {
            return new Missing(Kind.MEASURE);
        }
        return point(upper.get().subtract(lower.get(), PRECISION), semantic);
    }

    /**
     * A copy with both bounds transformed by one operation, kept on a semantic.
     *
     * @param operation the operation on a bound
     * @param target    the semantic of the result
     * @return the measure
     */
    public Measure mapBounds(UnaryOperator<BigDecimal> operation, MeasureSemantic target) {
        return new Measure(lower.map(operation), upper.map(operation), lowerIncluded, upperIncluded, target, resolution, extent);
    }

    /**
     * A copy with the bounds swapped and negated, for negation.
     *
     * @return the measure
     */
    public Measure negated() {
        return new Measure(upper.map(BigDecimal::negate), lower.map(BigDecimal::negate), upperIncluded, lowerIncluded,
                semantic, resolution, extent);
    }
}
