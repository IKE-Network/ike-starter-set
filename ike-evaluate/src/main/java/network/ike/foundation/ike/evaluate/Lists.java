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
 * The list kinds: repeats removed, the first and last element, one level flattened, an
 * element's position, the element or character at a position, a collection's size, and a
 * slice (IKE-Network/ike-issues#1121).
 */
final class Lists {

    private Lists() {
    }

    static void register(Operators registry) {
        registry.put("Distinct", (node, context) -> {
            Value source = Operators.single(node, context);
            if (source.isMissing()) {
                return new Missing(Value.Kind.LIST);
            }
            return new ListValue(distinct(list(source, context)));
        });
        registry.put("First", (node, context) -> {
            Value source = Operators.operand(node, "source", context);
            if (source.isMissing()) {
                return Missing.ANY;
            }
            List<Value> values = list(source, context);
            return values.isEmpty() ? Missing.ANY : values.get(0);
        });
        registry.put("Last", (node, context) -> {
            Value source = Operators.operand(node, "source", context);
            if (source.isMissing()) {
                return Missing.ANY;
            }
            List<Value> values = list(source, context);
            return values.isEmpty() ? Missing.ANY : values.get(values.size() - 1);
        });
        registry.put("Flatten", (node, context) -> {
            Value source = Operators.single(node, context);
            if (source.isMissing()) {
                return new Missing(Value.Kind.LIST);
            }
            List<Value> flat = new ArrayList<>();
            for (Value element : list(source, context)) {
                if (element.isMissing()) {
                    flat.add(element);
                } else if (element instanceof ListValue inner) {
                    flat.addAll(inner.values());
                } else {
                    throw context.refuse("flattening takes a list of lists, and an element is a " + element.kind());
                }
            }
            return new ListValue(flat);
        });
        registry.put("IndexOf", (node, context) -> {
            Value source = Operators.operand(node, "source", context);
            Value element = Operators.operand(node, "element", context);
            if (source.isMissing() || element.isMissing()) {
                return Operators.missingMeasure();
            }
            List<Value> values = list(source, context);
            for (int i = 0; i < values.size(); i++) {
                if (Values.equal(values.get(i), element) == Presence.PRESENT) {
                    return Values.number(BigDecimal.valueOf(i)).withPlaces(0);
                }
            }
            return Values.number(BigDecimal.valueOf(-1)).withPlaces(0);
        });
        registry.put("Indexer", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            Value source = operands.get(0);
            Optional<Integer> index = whole(operands.get(1), context);
            if (source.isMissing() || index.isEmpty()) {
                return source instanceof Text || source.isMissing() && node.kindName().isEmpty() ? new Missing(Value.Kind.TEXT) : Missing.ANY;
            }
            if (source instanceof Text text) {
                int at = index.get();
                return at < 0 || at >= text.text().length() ? new Missing(Value.Kind.TEXT) : new Text(text.text().substring(at, at + 1));
            }
            List<Value> values = list(source, context);
            int at = index.get();
            return at < 0 || at >= values.size() ? Missing.ANY : values.get(at);
        });
        registry.put("Length", (node, context) -> {
            Value source = Operators.single(node, context);
            if (source instanceof Text text) {
                return Values.number(BigDecimal.valueOf(text.text().length())).withPlaces(0);
            }
            if (source.isMissing()) {
                return source.kind() == Value.Kind.TEXT ? Operators.missingMeasure() : Values.number(BigDecimal.ZERO).withPlaces(0);
            }
            return Values.number(BigDecimal.valueOf(list(source, context).size())).withPlaces(0);
        });
        registry.put("Slice", (node, context) -> {
            Value source = Operators.operand(node, "source", context);
            if (source.isMissing()) {
                return new Missing(Value.Kind.LIST);
            }
            List<Value> values = list(source, context);
            Optional<Integer> start = Operators.optionalOperand(node, "startIndex", context).flatMap(value -> whole(value, context));
            Optional<Integer> end = Operators.optionalOperand(node, "endIndex", context).flatMap(value -> whole(value, context));
            int from = Math.max(0, start.orElse(0));
            int to = Math.min(values.size(), end.orElse(values.size()));
            if (to <= from) {
                return new ListValue(List.of());
            }
            return new ListValue(new ArrayList<>(values.subList(from, to)));
        });
    }

    /** A value as a list of values; refused when it is not a list. */
    static List<Value> list(Value value, Context context) {
        if (value instanceof ListValue list) {
            return list.values();
        }
        throw context.refuse("a list was needed, and the value is a " + value.kind());
    }

    /** A whole number from a value, empty when missing. */
    static Optional<Integer> whole(Value value, Context context) {
        if (value.isMissing()) {
            return Optional.empty();
        }
        return Optional.of(Operators.measure(value, context).orElseThrow().value().intValueExact());
    }

    /** The values with repeats removed, a missing value the same as a missing value. */
    static List<Value> distinct(List<Value> values) {
        List<Value> result = new ArrayList<>();
        for (Value value : values) {
            boolean seen = false;
            for (Value kept : result) {
                if ((kept.isMissing() && value.isMissing()) || Values.equal(kept, value) == Presence.PRESENT) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                result.add(value);
            }
        }
        return result;
    }
}
