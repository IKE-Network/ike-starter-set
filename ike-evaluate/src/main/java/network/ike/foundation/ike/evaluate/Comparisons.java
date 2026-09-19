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

import java.util.List;
import java.util.Optional;

/**
 * The comparisons: sameness and equivalence by IKE's reading, order on measures and texts, and
 * the timing comparisons at a precision.
 */
final class Comparisons {

    private Comparisons() {
    }

    static void register(Operators registry) {
        registry.put("Equal", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return Values.equal(operands.get(0), operands.get(1));
        });
        registry.put("NotEqual", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return Values.equal(operands.get(0), operands.get(1)).not();
        });
        registry.put("Equivalent", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return Values.equivalent(operands.get(0), operands.get(1));
        });
        registry.put("Greater", (node, context) -> ordered(node, context, Values.Order.GREATER));
        registry.put("GreaterOrEqual", (node, context) -> ordered(node, context, Values.Order.GREATER_OR_EQUAL));
        registry.put("Less", (node, context) -> ordered(node, context, Values.Order.LESS));
        registry.put("LessOrEqual", (node, context) -> ordered(node, context, Values.Order.LESS_OR_EQUAL));
        registry.put("SameAs", (node, context) -> timing(node, context, (a, b) -> a.sameAs(b)));
        registry.put("Before", (node, context) -> timing(node, context, (a, b) -> endOf(a).before(startOf(b))));
        registry.put("After", (node, context) -> timing(node, context, (a, b) -> startOf(a).after(endOf(b))));
        registry.put("SameOrBefore", (node, context) -> timing(node, context, (a, b) ->
                endOf(a).before(startOf(b)).or(endOf(a).sameAs(startOf(b)))));
        registry.put("SameOrAfter", (node, context) -> timing(node, context, (a, b) ->
                startOf(a).after(endOf(b)).or(startOf(a).sameAs(endOf(b)))));
    }

    private static Value ordered(TreeNode node, Context context, Values.Order order) {
        List<Value> operands = Operators.pair(node, context);
        Value a = operands.get(0);
        Value b = operands.get(1);
        if (a.isMissing() || b.isMissing()) {
            return Presence.INDETERMINATE;
        }
        if (a instanceof Measure ma && b instanceof Measure mb) {
            return Values.compare(ma, mb, order);
        }
        if (a instanceof Text ta && b instanceof Text tb) {
            int sign = ta.text().compareTo(tb.text());
            return Presence.of(switch (order) {
                case GREATER -> sign > 0;
                case GREATER_OR_EQUAL -> sign >= 0;
                case LESS -> sign < 0;
                case LESS_OR_EQUAL -> sign <= 0;
            });
        }
        throw context.refuse("the " + node.kindName() + " compares a " + a.kind() + " with a " + b.kind());
    }

    /** The point an ordering compares at the start: an extent's first point, a value itself. */
    static Measure startOf(Measure measure) {
        return measure.extent() && Intervals.start(measure) instanceof Measure start ? start : measure;
    }

    /** The point an ordering compares at the end: an extent's last point, a value itself. */
    static Measure endOf(Measure measure) {
        return measure.extent() && Intervals.end(measure) instanceof Measure end ? end : measure;
    }

    /** A relation between two measures. */
    interface Relation {
        Presence of(Measure a, Measure b);
    }

    /** Two measures at the node's precision, related; a missing side is Indeterminate. */
    static Value timing(TreeNode node, Context context, Relation relation) {
        List<Value> operands = Operators.pair(node, context);
        Optional<Measure> a = Operators.measure(operands.get(0), context);
        Optional<Measure> b = Operators.measure(operands.get(1), context);
        if (a.isEmpty() || b.isEmpty()) {
            return Presence.INDETERMINATE;
        }
        Optional<Resolution> precision = Operators.precision(node);
        Measure left = Values.atPrecision(a.get(), precision);
        Optional<Measure> right = Values.atPrecision(b.get(), precision).convertedTo(left.semantic());
        if (right.isEmpty()) {
            return Presence.INDETERMINATE;
        }
        return relation.of(left, right.get());
    }
}
