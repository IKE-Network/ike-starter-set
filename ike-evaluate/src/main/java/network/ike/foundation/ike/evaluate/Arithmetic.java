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
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * The arithmetic kinds: addition and subtraction with unit conversion and calendar shifts,
 * multiplication and division by a plain number, negation, and the durations and differences
 * between instants, with the ages they give.
 */
final class Arithmetic {

    private Arithmetic() {
    }

    static void register(Operators registry) {
        registry.put("Add", (node, context) -> sum(node, context, false));
        registry.put("Subtract", (node, context) -> sum(node, context, true));
        registry.put("Multiply", (node, context) -> product(node, context, false));
        registry.put("Divide", (node, context) -> product(node, context, true));
        registry.put("Negate", (node, context) -> Operators.measure(Operators.single(node, context), context)
                .map(measure -> (Value) measure.negated()).orElse(Operators.missingMeasure()));
        registry.put("DurationBetween", (node, context) -> between(node, context, false));
        registry.put("DifferenceBetween", (node, context) -> between(node, context, true));
        registry.put("CalculateAgeAt", (node, context) -> between(node, context, false));
        registry.put("CalculateAge", (node, context) -> {
            Optional<Measure> birth = Operators.measure(Operators.single(node, context), context);
            Resolution precision = Operators.precision(node).orElseThrow(() -> context.refuse("an age needs a precision"));
            if (birth.isEmpty()) {
                return Operators.missingMeasure();
            }
            Instant now = context.evaluator().now();
            Measure today = Measure.point(Instants.millis(now), MeasureSemantic.EPOCH);
            return duration(birth.get(), today, precision, false);
        });
    }

    private static Value sum(TreeNode node, Context context, boolean subtract) {
        List<Value> operands = Operators.pair(node, context);
        Optional<Measure> a = Operators.measure(operands.get(0), context);
        Optional<Measure> b = Operators.measure(operands.get(1), context);
        if (a.isEmpty() || b.isEmpty()) {
            return Operators.missingMeasure();
        }
        Measure right = subtract ? b.get().negated() : b.get();
        if (Units.isTemporal(a.get().semantic()) && Units.isDuration(right.semantic())) {
            return Units.shift(a.get(), right).orElseThrow(() -> context.refuse("a duration added to an instant must be one number"));
        }
        if (!subtract && Units.isDuration(a.get().semantic()) && Units.isTemporal(right.semantic())) {
            return Units.shift(right, a.get()).orElseThrow(() -> context.refuse("a duration added to an instant must be one number"));
        }
        if (Units.isTemporal(a.get().semantic()) || Units.isTemporal(right.semantic())) {
            throw context.refuse("instants add only to durations; the difference of two instants is asked with DifferenceBetween");
        }
        Optional<Measure> converted = right.convertedTo(a.get().semantic());
        if (converted.isEmpty()) {
            throw context.refuse("the two measures are not commensurable");
        }
        Measure left = a.get();
        Measure other = converted.get();
        if (other.isPoint()) {
            BigDecimal amount = other.value();
            return left.mapBounds(bound -> bound.add(amount, Measure.PRECISION), left.semantic());
        }
        if (left.isPoint()) {
            BigDecimal amount = left.value();
            return other.mapBounds(bound -> bound.add(amount, Measure.PRECISION), left.semantic());
        }
        throw context.refuse("the sum of two spans is not read");
    }

    private static Value product(TreeNode node, Context context, boolean divide) {
        List<Value> operands = Operators.pair(node, context);
        Optional<Measure> a = Operators.measure(operands.get(0), context);
        Optional<Measure> b = Operators.measure(operands.get(1), context);
        if (a.isEmpty() || b.isEmpty()) {
            return Operators.missingMeasure();
        }
        Measure left = a.get();
        Measure right = b.get();
        if (!left.isPoint() || !right.isPoint()) {
            throw context.refuse("a product takes two numbers");
        }
        MeasureSemantic semantic;
        if (right.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS) {
            semantic = left.semantic();
        } else if (left.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS && !divide) {
            semantic = right.semantic();
        } else if (divide && left.semantic().commensurable(right.semantic()) && left.semantic().scale() == MeasureSemantic.Scale.UNIT) {
            Optional<Measure> converted = right.convertedTo(left.semantic());
            if (converted.isEmpty()) {
                throw context.refuse("the two measures are not commensurable");
            }
            right = converted.get();
            semantic = MeasureSemantic.DIMENSIONLESS;
        } else {
            throw context.refuse("a product of two units composes a unit, which the arithmetic family reads");
        }
        if (divide) {
            if (right.value().signum() == 0) {
                return Operators.missingMeasure();
            }
            return Measure.point(left.value().divide(right.value(), Measure.PRECISION), semantic);
        }
        return Measure.point(left.value().multiply(right.value(), Measure.PRECISION), semantic);
    }

    private static Value between(TreeNode node, Context context, boolean boundaries) {
        List<Value> operands = Operators.pair(node, context);
        Optional<Measure> a = Operators.measure(operands.get(0), context);
        Optional<Measure> b = Operators.measure(operands.get(1), context);
        Resolution precision = Operators.precision(node).orElseThrow(() -> context.refuse("a duration needs a precision"));
        if (a.isEmpty() || b.isEmpty()) {
            return Operators.missingMeasure();
        }
        if (!Units.isTemporal(a.get().semantic()) || !Units.isTemporal(b.get().semantic())) {
            throw context.refuse("a duration is between two instants");
        }
        return duration(a.get(), b.get(), precision, boundaries);
    }

    /**
     * Whole units, or boundaries crossed, from one instant to another: an uncertainty from the
     * least the count could be, the last moment of the first to the first moment of the second,
     * to the greatest, the first moment of the first to the last of the second, and a number
     * when the two agree. A written value ends on the start of its last unit, its last date
     * when written to the day or coarser, since periods are counted on the grid of the units
     * the values are written in.
     */
    static Value duration(Measure from, Measure to, Resolution precision, boolean boundaries) {
        if (!from.bounded() || !to.bounded()) {
            return Operators.missingMeasure();
        }
        Optional<Measure> aligned = to.convertedTo(from.semantic());
        if (aligned.isEmpty()) {
            return Operators.missingMeasure();
        }
        Measure until = aligned.get();
        long least = count(lastMoment(from), until.lower().get(), precision, boundaries);
        long greatest = count(from.lower().get(), lastMoment(until), precision, boundaries);
        if (least == greatest) {
            return Values.number(BigDecimal.valueOf(least));
        }
        return new Measure(Optional.of(BigDecimal.valueOf(Math.min(least, greatest))),
                Optional.of(BigDecimal.valueOf(Math.max(least, greatest))), true, true, MeasureSemantic.DIMENSIONLESS,
                Optional.empty(), false);
    }

    /**
     * The last moment a written value counts from: the start of its last unit, its last date
     * when written to the day or coarser, its last hour, minute, or second when written finer,
     * since each period is counted on the grid of the units it is written in.
     */
    private static BigDecimal lastMoment(Measure measure) {
        BigDecimal upper = measure.upper().get();
        if (measure.resolution().isEmpty()) {
            return upper;
        }
        return Instants.startOfUnit(upper, measure.resolution().get());
    }

    private static long count(BigDecimal from, BigDecimal to, Resolution precision, boolean boundaries) {
        Measure start = Measure.point(from, MeasureSemantic.EPOCH);
        Measure end = Measure.point(to, MeasureSemantic.EPOCH);
        return boundaries ? Instants.boundariesBetween(start, end, precision) : Instants.wholeUnitsBetween(start, end, precision);
    }
}
