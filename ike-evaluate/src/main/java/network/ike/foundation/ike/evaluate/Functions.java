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

import dev.ikm.tinkar.terms.EntityProxy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The arithmetic functions: magnitude, rounding, remainder and whole quotient, exponentiation
 * and logarithm, the limits a type writes, the written precision, the neighbouring values, and
 * the written boundaries (IKE-Network/ike-issues#1119). A computed decimal is written to eight
 * places, CQL's decimal precision; a whole number stays whole.
 */
final class Functions {

    /** CQL's decimal step: the eighth place. */
    static final BigDecimal STEP = new BigDecimal("0.00000001");

    private static final int PLACES = 8;

    private Functions() {
    }

    static void register(Operators registry) {
        registry.put("Abs", (node, context) -> unary(node, context, measure -> {
            if (measure.bounded() && measure.upper().get().signum() < 0) {
                return measure.negated();
            }
            return measure;
        }));
        registry.put("Ceiling", (node, context) -> unary(node, context, measure -> rounded(measure, 0, RoundingMode.CEILING, 0)));
        registry.put("Floor", (node, context) -> unary(node, context, measure -> rounded(measure, 0, RoundingMode.FLOOR, 0)));
        registry.put("Truncate", (node, context) -> unary(node, context, measure -> rounded(measure, 0, RoundingMode.DOWN, 0)));
        registry.put("Round", (node, context) -> {
            Optional<Measure> measure = Operators.measure(Operators.operand(node, "operand", context), context);
            if (measure.isEmpty()) {
                return Operators.missingMeasure();
            }
            Optional<Value> precision = Operators.optionalOperand(node, "precision", context);
            int places = 0;
            if (precision.isPresent()) {
                Optional<Measure> given = Operators.measure(precision.get(), context);
                if (given.isEmpty()) {
                    return Operators.missingMeasure();
                }
                places = given.get().value().intValueExact();
            }
            return rounded(measure.get(), places, RoundingMode.HALF_UP, Math.max(1, places));
        });
        registry.put("Exp", (node, context) -> unary(node, context, measure -> eight(Math.exp(measure.value().doubleValue()), measure.semantic())));
        registry.put("Ln", (node, context) -> unary(node, context, measure -> measure.value().signum() <= 0
                ? Operators.missingMeasure() : eight(Math.log(measure.value().doubleValue()), measure.semantic())));
        registry.put("Log", (node, context) -> binary(node, context, (value, base) -> {
            if (value.value().signum() <= 0 || base.value().signum() <= 0 || base.value().compareTo(BigDecimal.ONE) == 0) {
                return Operators.missingMeasure();
            }
            return eight(Math.log(value.value().doubleValue()) / Math.log(base.value().doubleValue()), value.semantic());
        }));
        registry.put("Power", (node, context) -> binary(node, context, Functions::power));
        registry.put("Modulo", (node, context) -> binary(node, context, (dividend, divisor) -> {
            Measure aligned = divisor.convertedTo(dividend.semantic()).orElseThrow(() ->
                    context.refuse("the remainder takes commensurable measures"));
            if (aligned.value().signum() == 0) {
                return Operators.missingMeasure();
            }
            return Measure.point(dividend.value().remainder(aligned.value(), Measure.PRECISION), dividend.semantic())
                    .annotatedLike(dividend).annotatedLike(divisor);
        }));
        registry.put("TruncatedDivide", (node, context) -> binary(node, context, (dividend, divisor) -> {
            Measure aligned = divisor.convertedTo(dividend.semantic()).orElseThrow(() ->
                    context.refuse("the whole quotient takes commensurable measures"));
            if (aligned.value().signum() == 0) {
                return Operators.missingMeasure();
            }
            BigDecimal quotient = dividend.value().divideToIntegralValue(aligned.value(), Measure.PRECISION);
            MeasureSemantic semantic = dividend.semantic().scale() == MeasureSemantic.Scale.UNIT
                    ? MeasureSemantic.DIMENSIONLESS : dividend.semantic();
            return Measure.point(quotient, semantic).annotatedLike(dividend).annotatedLike(divisor);
        }));
        registry.put("MaxValue", (node, context) -> limit(node, context, true));
        registry.put("MinValue", (node, context) -> limit(node, context, false));
        registry.put("Precision", (node, context) -> unary(node, context, measure -> {
            if (measure.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS || measure.semantic().scale() == MeasureSemantic.Scale.UNIT) {
                return whole(measure.places().orElseThrow(() -> context.refuse("the number was not written, so it has no written precision")));
            }
            Resolution resolution = measure.resolution().orElseThrow(() -> context.refuse("the value was not written to a resolution"));
            return whole(digits(resolution, measure.semantic().scale() == MeasureSemantic.Scale.DAY));
        }));
        registry.put("Successor", (node, context) -> unary(node, context, measure -> step(measure, 1, context)));
        registry.put("Predecessor", (node, context) -> unary(node, context, measure -> step(measure, -1, context)));
        registry.put("HighBoundary", (node, context) -> boundary(node, context, true));
        registry.put("LowBoundary", (node, context) -> boundary(node, context, false));
    }

    private interface Unary {
        Value of(Measure measure);
    }

    private interface Binary {
        Value of(Measure first, Measure second);
    }

    private static Value unary(TreeNode node, Context context, Unary function) {
        Optional<Measure> measure = Operators.measure(Operators.single(node, context), context);
        if (measure.isEmpty()) {
            return Operators.missingMeasure();
        }
        if (measure.get().extent()) {
            throw context.refuse("the " + node.kindName() + " takes a value, not an extent");
        }
        return function.of(measure.get());
    }

    private static Value binary(TreeNode node, Context context, Binary function) {
        List<Value> operands = Operators.pair(node, context);
        Optional<Measure> first = Operators.measure(operands.get(0), context);
        Optional<Measure> second = Operators.measure(operands.get(1), context);
        if (first.isEmpty() || second.isEmpty()) {
            return Operators.missingMeasure();
        }
        if (!first.get().isPoint() || !second.get().isPoint()) {
            throw context.refuse("the " + node.kindName() + " takes two numbers");
        }
        return function.of(first.get(), second.get());
    }

    private static Measure rounded(Measure measure, int scale, RoundingMode mode, int places) {
        return measure.mapBounds(bound -> bound.setScale(scale, mode), measure.semantic()).withPlaces(places);
    }

    /** A computed decimal at CQL's eight places. */
    static Measure eight(double value, MeasureSemantic semantic) {
        return Measure.point(new BigDecimal(Double.toString(value)).setScale(PLACES, RoundingMode.HALF_UP), semantic).withPlaces(PLACES);
    }

    private static Value whole(int value) {
        return Values.number(BigDecimal.valueOf(value)).withPlaces(0);
    }

    private static Value power(Measure base, Measure exponent) {
        BigDecimal power = exponent.value();
        if (power.stripTrailingZeros().scale() <= 0) {
            int whole = power.intValueExact();
            if (whole >= 0) {
                return Measure.point(base.value().pow(whole, Measure.PRECISION), base.semantic()).annotatedLike(base);
            }
            BigDecimal denominator = base.value().pow(-whole, Measure.PRECISION);
            if (denominator.signum() == 0) {
                return Operators.missingMeasure();
            }
            return Measure.point(BigDecimal.ONE.divide(denominator, PLACES, RoundingMode.HALF_UP), base.semantic()).withPlaces(PLACES);
        }
        double result = Math.pow(base.value().doubleValue(), power.doubleValue());
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            return Operators.missingMeasure();
        }
        return eight(result, base.semantic());
    }

    private static Value limit(TreeNode node, Context context, boolean greatest) {
        Object type = node.property("valueType").orElseThrow(() -> context.refuse("a limit names no type"));
        if (!(type instanceof EntityProxy.Concept concept)) {
            throw context.refuse("the type " + type + " is not resolved to a concept");
        }
        String name = Types.systemTypeName(concept.nid()).orElseThrow(() -> context.refuse("a limit is asked of a data model's class"));
        return switch (name) {
            case "Integer" -> whole(greatest ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            case "Long" -> Values.number(BigDecimal.valueOf(greatest ? Long.MAX_VALUE : Long.MIN_VALUE)).withPlaces(0);
            case "Decimal" -> Values.number(new BigDecimal((greatest ? "" : "-") + "99999999999999999999.99999999")).withPlaces(PLACES);
            case "Quantity" -> Measure.point(new BigDecimal((greatest ? "" : "-") + "99999999999999999999.99999999"),
                    MeasureSemantic.DIMENSIONLESS).withPlaces(PLACES);
            case "DateTime" -> greatest
                    ? Instants.dateTime(9999, Optional.of(12), Optional.of(31), Optional.of(23), Optional.of(59), Optional.of(59),
                            Optional.of(999), Optional.of(BigDecimal.ZERO))
                    : Instants.dateTime(1, Optional.of(1), Optional.of(1), Optional.of(0), Optional.of(0), Optional.of(0),
                            Optional.of(0), Optional.of(BigDecimal.ZERO));
            case "Date" -> greatest ? Instants.date(9999, Optional.of(12), Optional.of(31)) : Instants.date(1, Optional.of(1), Optional.of(1));
            case "Time" -> greatest ? Instants.time(23, Optional.of(59), Optional.of(59), Optional.of(999))
                    : Instants.time(0, Optional.of(0), Optional.of(0), Optional.of(0));
            default -> throw context.refuse("the type " + name + " has no limit");
        };
    }

    private static Value step(Measure measure, int direction, Context context) {
        if (Units.isTemporal(measure.semantic())) {
            Resolution resolution = measure.resolution().orElseThrow(() ->
                    context.refuse("the value was not written to a resolution, so it has no neighbour"));
            if (measure.semantic().scale() == MeasureSemantic.Scale.DAY) {
                BigDecimal amount = BigDecimal.valueOf(direction * resolution.milliseconds());
                return measure.mapBounds(bound -> bound.add(amount), measure.semantic());
            }
            return Instants.shift(measure, direction, resolution);
        }
        BigDecimal amount = measure.isWhole() ? BigDecimal.valueOf(direction) : STEP.multiply(BigDecimal.valueOf(direction));
        Measure moved = measure.mapBounds(bound -> bound.add(amount), measure.semantic());
        return measure.isWhole() ? moved : moved.withPlaces(Math.max(PLACES, measure.places().orElse(0)));
    }

    private static final Map<Integer, Resolution> DATE_DIGITS = Map.of(4, Resolution.YEAR, 6, Resolution.MONTH, 8, Resolution.DAY,
            10, Resolution.HOUR, 12, Resolution.MINUTE, 14, Resolution.SECOND, 17, Resolution.MILLISECOND);
    private static final Map<Integer, Resolution> TIME_DIGITS = Map.of(2, Resolution.HOUR, 4, Resolution.MINUTE, 6, Resolution.SECOND,
            9, Resolution.MILLISECOND);

    /** The digits a written resolution spans, as CQL counts them. */
    static int digits(Resolution resolution, boolean timeOfDay) {
        Map<Integer, Resolution> table = timeOfDay ? TIME_DIGITS : DATE_DIGITS;
        for (Map.Entry<Integer, Resolution> entry : table.entrySet()) {
            if (entry.getValue() == resolution) {
                return entry.getKey();
            }
        }
        return timeOfDay ? 9 : 17;
    }

    private static Value boundary(TreeNode node, Context context, boolean high) {
        List<Value> operands = Operators.operands(node, context);
        if (operands.isEmpty()) {
            throw context.refuse("a boundary is asked of nothing");
        }
        Optional<Measure> measure = Operators.measure(operands.get(0), context);
        if (measure.isEmpty()) {
            return Operators.missingMeasure();
        }
        Measure value = measure.get();
        if (value.extent()) {
            throw context.refuse("a boundary is asked of a value, not an extent");
        }
        Optional<Integer> precision = Optional.empty();
        if (operands.size() > 1 && !operands.get(1).isMissing()) {
            precision = Optional.of(Operators.measure(operands.get(1), context).orElseThrow().value().intValueExact());
        }
        if (Units.isTemporal(value.semantic())) {
            boolean timeOfDay = value.semantic().scale() == MeasureSemantic.Scale.DAY;
            Map<Integer, Resolution> table = timeOfDay ? TIME_DIGITS : DATE_DIGITS;
            int wanted = precision.orElse(timeOfDay ? 9 : value.semantic().scale() == MeasureSemantic.Scale.CALENDAR ? 8 : 17);
            Resolution target = table.get(wanted);
            if (target == null) {
                throw context.refuse("no resolution has " + wanted + " digits");
            }
            if (!value.bounded()) {
                return Operators.missingMeasure();
            }
            BigDecimal end = high ? value.upper().get() : value.lower().get();
            return Instants.widenTo(Measure.point(end, value.semantic()), target);
        }
        int places = value.places().orElse(0);
        int wanted = precision.orElse(PLACES);
        BigDecimal number = value.value();
        BigDecimal result;
        if (wanted >= places) {
            BigDecimal low = number.setScale(wanted, RoundingMode.FLOOR);
            result = high ? low.add(BigDecimal.ONE.movePointLeft(places).subtract(BigDecimal.ONE.movePointLeft(wanted))) : low;
        } else {
            result = number.setScale(wanted, high ? RoundingMode.CEILING : RoundingMode.FLOOR);
        }
        return Measure.point(result, value.semantic()).withPlaces(wanted);
    }
}
