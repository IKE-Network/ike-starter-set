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
 * The aggregates over a list: sum, count, least, greatest, mean, median, and the closed-world
 * all and any over presences. Missing elements do not count; an empty list yields a missing
 * measure, a count of none, all Present, or any Absent.
 */
final class Aggregates {

    private Aggregates() {
    }

    static void register(Operators registry) {
        registry.put("Count", (node, context) -> {
            Optional<List<Value>> source = source(node, context);
            long count = source.map(values -> values.stream().filter(value -> !value.isMissing()).count()).orElse(0L);
            return Values.number(BigDecimal.valueOf(count));
        });
        registry.put("Sum", (node, context) -> measures(node, context).map(measures -> measures.isEmpty()
                ? Operators.missingMeasure() : sum(measures, context)).orElse(Operators.missingMeasure()));
        registry.put("Min", (node, context) -> extreme(node, context, Values.Order.LESS));
        registry.put("Max", (node, context) -> extreme(node, context, Values.Order.GREATER));
        registry.put("Avg", (node, context) -> measures(node, context).map(measures -> {
            if (measures.isEmpty()) {
                return Operators.missingMeasure();
            }
            Value total = sum(measures, context);
            if (total instanceof Measure sum && sum.isPoint()) {
                return Measure.point(sum.value().divide(BigDecimal.valueOf(measures.size()), Measure.PRECISION), sum.semantic());
            }
            return total;
        }).orElse(Operators.missingMeasure()));
        registry.put("Median", (node, context) -> measures(node, context).map(measures -> {
            if (measures.isEmpty()) {
                return Operators.missingMeasure();
            }
            List<Measure> sorted = new ArrayList<>(aligned(measures, context));
            sorted.sort((a, b) -> a.value().compareTo(b.value()));
            int middle = sorted.size() / 2;
            if (sorted.size() % 2 == 1) {
                return sorted.get(middle);
            }
            BigDecimal mean = sorted.get(middle - 1).value().add(sorted.get(middle).value())
                    .divide(BigDecimal.valueOf(2), Measure.PRECISION);
            return Measure.point(mean, sorted.get(0).semantic());
        }).orElse(Operators.missingMeasure()));
        registry.put("AllTrue", (node, context) -> {
            Optional<List<Value>> source = source(node, context);
            if (source.isEmpty()) {
                return Presence.PRESENT;
            }
            for (Value value : source.get()) {
                if (!value.isMissing() && Operators.presence(value, context) == Presence.ABSENT) {
                    return Presence.ABSENT;
                }
            }
            return Presence.PRESENT;
        });
        registry.put("AnyTrue", (node, context) -> {
            Optional<List<Value>> source = source(node, context);
            if (source.isEmpty()) {
                return Presence.ABSENT;
            }
            for (Value value : source.get()) {
                if (!value.isMissing() && Operators.presence(value, context) == Presence.PRESENT) {
                    return Presence.PRESENT;
                }
            }
            return Presence.ABSENT;
        });
    }

    /** The elements of the source list, the path applied to each when one is named; empty when the source is missing. */
    private static Optional<List<Value>> source(TreeNode node, Context context) {
        Value source = Operators.operand(node, "source", context);
        if (source.isMissing()) {
            return Optional.empty();
        }
        if (!(source instanceof ListValue list)) {
            throw context.refuse("an aggregate takes a list, and the source is a " + source.kind());
        }
        Optional<String> path = node.text("path");
        if (path.isEmpty()) {
            return Optional.of(list.values());
        }
        List<Value> read = new ArrayList<>();
        for (Value element : list.values()) {
            read.add(References.property(element, path.get(), context));
        }
        return Optional.of(read);
    }

    private static Optional<List<Measure>> measures(TreeNode node, Context context) {
        return source(node, context).map(values -> Values.measures(new ListValue(values), context));
    }

    private static List<Measure> aligned(List<Measure> measures, Context context) {
        List<Measure> result = new ArrayList<>();
        MeasureSemantic semantic = measures.get(0).semantic();
        for (Measure measure : measures) {
            result.add(measure.convertedTo(semantic).orElseThrow(() -> context.refuse("the measures are not commensurable")));
        }
        return result;
    }

    private static Value sum(List<Measure> measures, Context context) {
        List<Measure> aligned = aligned(measures, context);
        BigDecimal total = BigDecimal.ZERO;
        for (Measure measure : aligned) {
            if (!measure.isPoint()) {
                throw context.refuse("a sum takes numbers, and an element is a span");
            }
            total = total.add(measure.value(), Measure.PRECISION);
        }
        return Measure.point(total, aligned.get(0).semantic());
    }

    private static Value extreme(TreeNode node, Context context, Values.Order order) {
        Optional<List<Value>> source = source(node, context);
        if (source.isEmpty()) {
            return Missing.ANY;
        }
        Value best = null;
        for (Value value : source.get()) {
            if (value.isMissing()) {
                continue;
            }
            if (best == null) {
                best = value;
            } else if (best instanceof Measure a && value instanceof Measure b) {
                if (Values.compare(b, a, order) == Presence.PRESENT) {
                    best = value;
                }
            } else if (best instanceof Text a && value instanceof Text b) {
                int sign = b.text().compareTo(a.text());
                if (order == Values.Order.LESS ? sign < 0 : sign > 0) {
                    best = value;
                }
            } else {
                throw context.refuse("an extreme is asked of a " + best.kind() + " and a " + value.kind());
            }
        }
        return best == null ? Missing.ANY : best;
    }
}
