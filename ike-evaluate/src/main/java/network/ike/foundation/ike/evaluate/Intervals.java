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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The interval and membership kinds: within, contains, overlaps, the ends and the width, and
 * the set operations, on extents and on lists.
 */
final class Intervals {

    private Intervals() {
    }

    static void register(Operators registry) {
        registry.put("In", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return membership(operands.get(0), operands.get(1), Operators.precision(node), context);
        });
        registry.put("Contains", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return membership(operands.get(1), operands.get(0), Operators.precision(node), context);
        });
        registry.put("IncludedIn", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return inclusion(operands.get(0), operands.get(1), Operators.precision(node), context);
        });
        registry.put("Includes", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return inclusion(operands.get(1), operands.get(0), Operators.precision(node), context);
        });
        registry.put("Overlaps", (node, context) -> Comparisons.timing(node, context, Measure::overlaps));
        registry.put("OverlapsBefore", (node, context) -> Comparisons.timing(node, context, (a, b) ->
                a.overlaps(b).and(startsBefore(a, b))));
        registry.put("OverlapsAfter", (node, context) -> Comparisons.timing(node, context, (a, b) ->
                a.overlaps(b).and(endsAfter(a, b))));
        registry.put("Start", (node, context) -> Operators.measure(Operators.single(node, context), context)
                .map(Intervals::start).orElse(Operators.missingMeasure()));
        registry.put("End", (node, context) -> Operators.measure(Operators.single(node, context), context)
                .map(Intervals::end).orElse(Operators.missingMeasure()));
        registry.put("Width", (node, context) -> Operators.measure(Operators.single(node, context), context)
                .map(Intervals::width).orElse(Operators.missingMeasure()));
        registry.put("Meets", (node, context) -> Comparisons.timing(node, context, (a, b) -> meets(a, b, true).or(meets(b, a, true))));
        registry.put("MeetsBefore", (node, context) -> Comparisons.timing(node, context, (a, b) -> meets(a, b, true)));
        registry.put("MeetsAfter", (node, context) -> Comparisons.timing(node, context, (a, b) -> meets(b, a, true)));
        registry.put("Starts", (node, context) -> Comparisons.timing(node, context, (a, b) -> {
            Presence sameStart = Comparisons.startOf(a).sameAs(Comparisons.startOf(b));
            Presence endsNoLater = Comparisons.endOf(a).before(Comparisons.endOf(b)).or(Comparisons.endOf(a).sameAs(Comparisons.endOf(b)));
            return sameStart.and(endsNoLater);
        }));
        registry.put("Ends", (node, context) -> Comparisons.timing(node, context, (a, b) -> {
            Presence sameEnd = Comparisons.endOf(a).sameAs(Comparisons.endOf(b));
            Presence startsNoEarlier = Comparisons.startOf(a).after(Comparisons.startOf(b)).or(Comparisons.startOf(a).sameAs(Comparisons.startOf(b)));
            return sameEnd.and(startsNoEarlier);
        }));
        registry.put("PointFrom", (node, context) -> {
            Optional<Measure> measure = Operators.measure(Operators.single(node, context), context);
            if (measure.isEmpty()) {
                return Operators.missingMeasure();
            }
            Measure extent = measure.get();
            if (!extent.extent()) {
                return extent;
            }
            if (!extent.bounded()) {
                return Operators.missingMeasure();
            }
            if (extent.lower().get().compareTo(extent.upper().get()) != 0
                    && !(Units.isTemporal(extent.semantic()) && extent.resolution().isPresent()
                    && Instants.widenTo(Measure.point(extent.lower().get(), extent.semantic()), extent.resolution().get()).upper().get()
                    .compareTo(extent.upper().get()) == 0)) {
                throw context.refuse("the extent holds more than one point");
            }
            Value point = start(extent);
            return point instanceof Measure measurePoint && extent.places().isPresent() ? measurePoint.withPlaces(extent.places().get()) : point;
        });
        registry.put("ProperIn", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return properMembership(operands.get(0), operands.get(1), Operators.precision(node), context);
        });
        registry.put("ProperContains", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return properMembership(operands.get(1), operands.get(0), Operators.precision(node), context);
        });
        registry.put("ProperIncludedIn", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return properInclusion(operands.get(0), operands.get(1), Operators.precision(node), context);
        });
        registry.put("ProperIncludes", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return properInclusion(operands.get(1), operands.get(0), Operators.precision(node), context);
        });
        registry.put("Collapse", Intervals::collapse);
        registry.put("Expand", Intervals::expand);
        registry.put("Union", (node, context) -> setOperation(node, context, Intervals::unionOf, Intervals::unionOf));
        registry.put("Intersect", (node, context) -> setOperation(node, context, Intervals::intersectionOf, Intervals::intersectionOf));
        registry.put("Except", (node, context) -> setOperation(node, context, Intervals::exceptOf, Intervals::exceptOf));
    }

    /** Whether an element is in a collection: a list by sameness, an extent by lying within. */
    static Presence membership(Value element, Value collection, Optional<Resolution> precision, Context context) {
        if (collection.isMissing()) {
            return Presence.INDETERMINATE;
        }
        if (collection instanceof ListValue list) {
            if (element.isMissing()) {
                return Presence.of(list.values().stream().anyMatch(Value::isMissing));
            }
            for (Value item : list.values()) {
                if (Values.equal(element, item) == Presence.PRESENT) {
                    return Presence.PRESENT;
                }
            }
            return Presence.ABSENT;
        }
        if (collection instanceof Measure extent) {
            if (element.isMissing()) {
                return Presence.INDETERMINATE;
            }
            Measure point = Operators.measure(element, context).orElseThrow();
            Measure left = Values.atPrecision(point, precision);
            Optional<Measure> right = Values.atPrecision(extent, precision).convertedTo(left.semantic());
            if (right.isEmpty()) {
                return Presence.INDETERMINATE;
            }
            return left.within(right.get());
        }
        throw context.refuse("membership is asked of a " + collection.kind());
    }

    /** Whether one collection lies within another: lists by every element, extents by their ends. */
    static Presence inclusion(Value inner, Value outer, Optional<Resolution> precision, Context context) {
        if (inner.isMissing() || outer.isMissing()) {
            return Presence.INDETERMINATE;
        }
        if (inner instanceof ListValue list && outer instanceof ListValue) {
            for (Value item : list.values()) {
                if (membership(item, outer, precision, context) != Presence.PRESENT) {
                    return Presence.ABSENT;
                }
            }
            return Presence.PRESENT;
        }
        if (inner instanceof Measure a && outer instanceof Measure b) {
            Measure left = Values.atPrecision(a, precision);
            Optional<Measure> right = Values.atPrecision(b, precision).convertedTo(left.semantic());
            if (right.isEmpty()) {
                return Presence.INDETERMINATE;
            }
            return left.within(right.get());
        }
        if (inner instanceof Measure) {
            return membership(inner, outer, precision, context);
        }
        throw context.refuse("inclusion is asked of a " + inner.kind() + " in a " + outer.kind());
    }

    private static Presence startsBefore(Measure a, Measure b) {
        if (a.lower().isEmpty() || b.lower().isEmpty()) {
            return Presence.INDETERMINATE;
        }
        int order = a.lower().get().compareTo(b.lower().get());
        return Presence.of(order < 0 || (order == 0 && a.lowerIncluded() && !b.lowerIncluded()));
    }

    private static Presence endsAfter(Measure a, Measure b) {
        if (a.upper().isEmpty() || b.upper().isEmpty()) {
            return Presence.INDETERMINATE;
        }
        int order = a.upper().get().compareTo(b.upper().get());
        return Presence.of(order > 0 || (order == 0 && a.upperIncluded() && !b.upperIncluded()));
    }

    /** The start of a measure: an extent's first point written at its ends' resolution; a value itself. */
    static Value start(Measure measure) {
        if (!measure.extent()) {
            return measure;
        }
        if (measure.lower().isEmpty()) {
            return Operators.missingMeasure();
        }
        return end(measure.lower().get(), measure);
    }

    /** The end of a measure: an extent's last point written at its ends' resolution; a value itself. */
    static Value end(Measure measure) {
        if (!measure.extent()) {
            return measure;
        }
        if (measure.upper().isEmpty()) {
            return Operators.missingMeasure();
        }
        return end(measure.upper().get(), measure);
    }

    private static Measure end(BigDecimal bound, Measure extent) {
        Measure point = Measure.point(bound, extent.semantic());
        if (extent.resolution().isPresent() && Units.isTemporal(extent.semantic())) {
            return Instants.widenTo(point, extent.resolution().get());
        }
        return point;
    }

    /** The width of an extent: its span, in milliseconds for time. */
    static Value width(Measure measure) {
        if (!measure.bounded()) {
            return Operators.missingMeasure();
        }
        BigDecimal span = measure.upper().get().subtract(measure.lower().get(), Measure.PRECISION);
        if (Units.isTemporal(measure.semantic())) {
            return Measure.point(span.add(BigDecimal.ONE), Units.milliseconds());
        }
        return Measure.point(span, measure.semantic());
    }

    /** The step at which an extent's neighbour lies: one for whole ends, the eighth place for decimals, a millisecond in time. */
    static BigDecimal stepOf(Measure extent) {
        if (Units.isTemporal(extent.semantic())) {
            return BigDecimal.ONE;
        }
        return extent.places().isPresent() && extent.places().get() == 0 ? BigDecimal.ONE : Functions.STEP;
    }

    /** Whether the first extent's end is the neighbour of the second's start. */
    private static Presence meets(Measure first, Measure second, boolean directed) {
        if (!first.extent() || !second.extent()) {
            return Presence.ABSENT;
        }
        if (first.upper().isEmpty() || second.lower().isEmpty()) {
            return Presence.INDETERMINATE;
        }
        BigDecimal end = first.upperIncluded() ? first.upper().get() : first.upper().get().subtract(stepOf(first));
        BigDecimal start = second.lowerIncluded() ? second.lower().get() : second.lower().get().add(stepOf(second));
        return Presence.of(end.add(stepOf(first)).compareTo(start) == 0);
    }

    /** Membership with sameness at an end ruled out, or in a list of more than one element. */
    static Presence properMembership(Value element, Value collection, Optional<Resolution> precision, Context context) {
        if (collection.isMissing()) {
            return Presence.INDETERMINATE;
        }
        if (collection instanceof ListValue list) {
            Presence in = membership(element, collection, precision, context);
            return in.and(Presence.of(list.values().size() > 1));
        }
        if (collection instanceof Measure extent && !element.isMissing()) {
            Presence within = membership(element, collection, precision, context);
            if (within != Presence.PRESENT) {
                return within;
            }
            Measure point = Values.atPrecision(Operators.measure(element, context).orElseThrow(), precision);
            Measure widened = Values.atPrecision(extent, precision);
            Presence atStart = point.sameAs(Comparisons.startOf(widened));
            Presence atEnd = point.sameAs(Comparisons.endOf(widened));
            return atStart.or(atEnd).not();
        }
        return membership(element, collection, precision, context);
    }

    /** Inclusion with sameness ruled out. */
    static Presence properInclusion(Value inner, Value outer, Optional<Resolution> precision, Context context) {
        Presence included = inclusion(inner, outer, precision, context);
        if (included != Presence.PRESENT) {
            return included;
        }
        if (inner instanceof ListValue a && outer instanceof ListValue b) {
            return Presence.of(!(inclusion(outer, inner, precision, context) == Presence.PRESENT && a.values().size() == b.values().size()));
        }
        if (inner instanceof Measure a && outer instanceof Measure b) {
            Measure left = Values.atPrecision(a, precision);
            Optional<Measure> right = Values.atPrecision(b, precision).convertedTo(left.semantic());
            if (right.isEmpty()) {
                return Presence.INDETERMINATE;
            }
            return left.sameAs(right.get()).not();
        }
        return Presence.PRESENT;
    }

    private static Value collapse(TreeNode node, Context context) {
        List<Value> operands = Operators.operands(node, context);
        if (operands.isEmpty()) {
            throw context.refuse("collapse takes a list of extents");
        }
        Value source = operands.get(0);
        if (source.isMissing()) {
            return new Missing(Value.Kind.LIST);
        }
        if (!(source instanceof ListValue list)) {
            throw context.refuse("collapse takes a list of extents, not a " + source.kind());
        }
        Optional<Measure> per = operands.size() > 1 ? Operators.measure(operands.get(1), context) : Optional.empty();
        List<Measure> extents = new ArrayList<>();
        for (Value item : list.values()) {
            if (item.isMissing()) {
                continue;
            }
            Measure extent = Operators.measure(item, context).orElseThrow();
            if (!extent.extent() || !extent.bounded()) {
                continue;
            }
            extents.add(extent);
        }
        extents.sort((a, b) -> a.lower().get().compareTo(b.lower().get()));
        List<Value> merged = new ArrayList<>();
        Measure current = null;
        for (Measure extent : extents) {
            if (current == null) {
                current = extent;
                continue;
            }
            Measure aligned = extent.convertedTo(current.semantic()).orElseThrow(() -> context.refuse("the extents are not commensurable"));
            BigDecimal step = per.isPresent() ? per.get().convertedTo(current.semantic()).map(Measure::value).orElse(stepOf(current)) : stepOf(current);
            boolean joins = current.overlaps(aligned) == Presence.PRESENT || touches(current, aligned)
                    || current.upper().get().add(step).compareTo(aligned.lower().get()) >= 0;
            if (joins) {
                if (aligned.upper().get().compareTo(current.upper().get()) > 0) {
                    current = Measure.extent(current.lower(), aligned.upper(), current.lowerIncluded(), aligned.upperIncluded(),
                            current.semantic(), current.resolution().or(aligned::resolution));
                    current = extent.places().isPresent() ? current.withPlaces(extent.places().get()) : current;
                }
            } else {
                merged.add(current);
                current = extent;
            }
        }
        if (current != null) {
            merged.add(current);
        }
        return new ListValue(merged);
    }

    private static Value expand(TreeNode node, Context context) {
        List<Value> operands = Operators.operands(node, context);
        if (operands.isEmpty()) {
            throw context.refuse("expand takes a list of extents or an extent");
        }
        Value source = operands.get(0);
        if (source.isMissing()) {
            return new Missing(Value.Kind.LIST);
        }
        Optional<Measure> per = operands.size() > 1 ? Operators.measure(operands.get(1), context) : Optional.empty();
        boolean points = !(source instanceof ListValue);
        List<Measure> extents = new ArrayList<>();
        if (source instanceof ListValue list) {
            for (Value item : list.values()) {
                if (!item.isMissing()) {
                    Measure extent = Operators.measure(item, context).orElseThrow();
                    if (extent.extent() && extent.bounded()) {
                        extents.add(extent);
                    }
                }
            }
        } else {
            Measure extent = Operators.measure(source, context).orElseThrow();
            if (extent.extent() && extent.bounded()) {
                extents.add(extent);
            }
        }
        List<Value> units = new ArrayList<>();
        for (Measure extent : extents) {
            units.addAll(partition(extent, per, points, context));
        }
        return new ListValue(units);
    }

    /** The unit extents of a step covering an extent, or their starts. */
    private static List<Value> partition(Measure extent, Optional<Measure> per, boolean points, Context context) {
        List<Value> units = new ArrayList<>();
        if (Units.isTemporal(extent.semantic())) {
            Resolution written = extent.resolution().orElse(Resolution.MILLISECOND);
            Resolution unit;
            long count = 1;
            if (per.isPresent()) {
                unit = Units.unitResolution(per.get().semantic());
                count = per.get().value().longValue();
                if (unit.finerThan(written)) {
                    return units;
                }
            } else {
                unit = written;
            }
            BigDecimal end = extent.upper().get();
            Measure cursor = Instants.widenTo(Measure.point(extent.lower().get(), extent.semantic()), unit);
            int guard = 0;
            while (cursor.lower().get().compareTo(end) <= 0 && guard++ < 100_000) {
                Measure last = count == 1 ? cursor : Instants.shift(cursor, count - 1, unit);
                if (points) {
                    units.add(cursor);
                } else {
                    units.add(Measure.extent(cursor.lower(), last.upper(), true, true, extent.semantic(), Optional.of(unit)));
                }
                cursor = Instants.shift(cursor, count, unit);
            }
            return units;
        }
        BigDecimal step;
        int places;
        if (per.isPresent()) {
            Measure aligned = per.get().convertedTo(extent.semantic()).orElseThrow(() -> context.refuse("the per is not commensurable with the extent"));
            step = aligned.value();
            places = Math.max(0, step.stripTrailingZeros().scale());
        } else {
            step = stepOf(extent);
            places = extent.places().orElse(0);
        }
        if (step.signum() <= 0) {
            throw context.refuse("the per must be positive");
        }
        BigDecimal fine = BigDecimal.ONE.movePointLeft(places);
        BigDecimal start = extent.lower().get().setScale(places, java.math.RoundingMode.CEILING);
        if (!extent.lowerIncluded() && start.compareTo(extent.lower().get()) == 0) {
            start = start.add(fine);
        }
        BigDecimal end = extent.upper().get().setScale(places, java.math.RoundingMode.FLOOR);
        if (!extent.upperIncluded() && end.compareTo(extent.upper().get()) == 0) {
            end = end.subtract(fine);
        } else if (extent.upperIncluded() && extent.places().orElse(0) < places) {
            end = end.add(BigDecimal.ONE.movePointLeft(extent.places().orElse(0))).subtract(fine);
        }
        BigDecimal cursor = start;
        int guard = 0;
        while (cursor.add(step).subtract(fine).compareTo(end) <= 0 && guard++ < 100_000) {
            BigDecimal last = cursor.add(step).subtract(fine);
            if (points) {
                units.add(Measure.point(cursor, extent.semantic()).withPlaces(places));
            } else {
                units.add(Measure.extent(Optional.of(cursor), Optional.of(last), true, true, extent.semantic(), Optional.empty()).withPlaces(places));
            }
            cursor = cursor.add(step);
        }
        return units;
    }

    private interface ListOperation {
        List<Value> of(List<Value> a, List<Value> b);
    }

    private interface ExtentOperation {
        Value of(Measure a, Measure b, Context context);
    }

    private static Value setOperation(TreeNode node, Context context, ListOperation lists, ExtentOperation extents) {
        List<Value> operands = Operators.operands(node, context);
        if (operands.isEmpty()) {
            throw context.refuse("the " + node.kindName() + " holds no operands");
        }
        Value result = operands.get(0);
        for (int i = 1; i < operands.size(); i++) {
            Value other = operands.get(i);
            if (result.isMissing() || other.isMissing()) {
                if (result instanceof ListValue || other instanceof ListValue) {
                    result = result.isMissing() ? other : result;
                    continue;
                }
                return Missing.ANY;
            }
            if (result instanceof ListValue a && other instanceof ListValue b) {
                result = new ListValue(lists.of(a.values(), b.values()));
            } else if (result instanceof Measure a && other instanceof Measure b) {
                result = extents.of(a, b, context);
            } else {
                throw context.refuse("the " + node.kindName() + " joins a " + result.kind() + " with a " + other.kind());
            }
        }
        return result;
    }

    private static boolean sameOrBothMissing(Value a, Value b) {
        return (a.isMissing() && b.isMissing()) || Values.equal(a, b) == Presence.PRESENT;
    }

    private static boolean has(List<Value> values, Value value) {
        return values.stream().anyMatch(item -> sameOrBothMissing(item, value));
    }

    private static List<Value> unionOf(List<Value> a, List<Value> b) {
        List<Value> result = new ArrayList<>();
        for (Value value : a) {
            if (!has(result, value)) {
                result.add(value);
            }
        }
        for (Value value : b) {
            if (!has(result, value)) {
                result.add(value);
            }
        }
        return result;
    }

    private static List<Value> intersectionOf(List<Value> a, List<Value> b) {
        List<Value> result = new ArrayList<>();
        for (Value value : a) {
            if (has(b, value) && !has(result, value)) {
                result.add(value);
            }
        }
        return result;
    }

    private static List<Value> exceptOf(List<Value> a, List<Value> b) {
        List<Value> result = new ArrayList<>();
        for (Value value : a) {
            if (!has(b, value) && !has(result, value)) {
                result.add(value);
            }
        }
        return result;
    }

    private static Optional<Measure> aligned(Measure a, Measure b, Context context) {
        Optional<Measure> converted = b.convertedTo(a.semantic());
        if (converted.isEmpty()) {
            throw context.refuse("the two extents are not commensurable");
        }
        return converted;
    }

    private static boolean touches(Measure a, Measure b) {
        return a.bounded() && b.bounded() && (a.upper().get().compareTo(b.lower().get()) == 0 && (a.upperIncluded() || b.lowerIncluded())
                || b.upper().get().compareTo(a.lower().get()) == 0 && (b.upperIncluded() || a.lowerIncluded()));
    }

    private static Value unionOf(Measure a, Measure first, Context context) {
        Measure b = aligned(a, first, context).get();
        if (a.overlaps(b) != Presence.PRESENT && !touches(a, b)) {
            return Operators.missingMeasure();
        }
        boolean lowerFromA = lowerFirst(a, b);
        boolean upperFromA = upperLast(a, b);
        return Measure.extent(lowerFromA ? a.lower() : b.lower(), upperFromA ? a.upper() : b.upper(),
                lowerFromA ? a.lowerIncluded() : b.lowerIncluded(), upperFromA ? a.upperIncluded() : b.upperIncluded(),
                a.semantic(), a.resolution().or(b::resolution));
    }

    private static Value intersectionOf(Measure a, Measure first, Context context) {
        Measure b = aligned(a, first, context).get();
        if (a.overlaps(b) != Presence.PRESENT) {
            return Operators.missingMeasure();
        }
        boolean lowerFromA = !lowerFirst(a, b);
        boolean upperFromA = !upperLast(a, b);
        return Measure.extent(lowerFromA ? a.lower() : b.lower(), upperFromA ? a.upper() : b.upper(),
                lowerFromA ? a.lowerIncluded() : b.lowerIncluded(), upperFromA ? a.upperIncluded() : b.upperIncluded(),
                a.semantic(), a.resolution().or(b::resolution));
    }

    private static Value exceptOf(Measure a, Measure first, Context context) {
        Measure b = aligned(a, first, context).get();
        if (a.overlaps(b) != Presence.PRESENT) {
            return a;
        }
        if (!a.bounded() || !b.bounded()) {
            return Operators.missingMeasure();
        }
        int head = b.lower().get().compareTo(a.lower().get());
        boolean coversHead = head < 0 || (head == 0 && (b.lowerIncluded() || !a.lowerIncluded()));
        int tail = b.upper().get().compareTo(a.upper().get());
        boolean coversTail = tail > 0 || (tail == 0 && (b.upperIncluded() || !a.upperIncluded()));
        if (coversHead && coversTail) {
            return Operators.missingMeasure();
        }
        if (coversHead) {
            return Measure.extent(b.upper(), a.upper(), !b.upperIncluded(), a.upperIncluded(), a.semantic(), a.resolution());
        }
        if (coversTail) {
            return Measure.extent(a.lower(), b.lower(), a.lowerIncluded(), !b.lowerIncluded(), a.semantic(), a.resolution());
        }
        return Operators.missingMeasure();
    }

    private static boolean lowerFirst(Measure a, Measure b) {
        if (a.lower().isEmpty()) {
            return true;
        }
        if (b.lower().isEmpty()) {
            return false;
        }
        int order = a.lower().get().compareTo(b.lower().get());
        return order < 0 || (order == 0 && a.lowerIncluded());
    }

    private static boolean upperLast(Measure a, Measure b) {
        if (a.upper().isEmpty()) {
            return true;
        }
        if (b.upper().isEmpty()) {
            return false;
        }
        int order = a.upper().get().compareTo(b.upper().get());
        return order > 0 || (order == 0 && a.upperIncluded());
    }
}
