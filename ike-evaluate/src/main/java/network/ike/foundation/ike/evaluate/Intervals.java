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
