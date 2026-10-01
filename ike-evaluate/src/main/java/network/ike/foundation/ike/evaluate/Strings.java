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
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * The text kinds: joining, affix tests, positions, case, pattern matching and replacement,
 * splitting, and slicing, with the message that passes its source through
 * (IKE-Network/ike-issues#1122). A missing operand gives a missing result throughout.
 */
final class Strings {

    private Strings() {
    }

    static void register(Operators registry) {
        registry.put("Concatenate", (node, context) -> {
            StringBuilder joined = new StringBuilder();
            for (Value operand : Operators.operands(node, context)) {
                if (operand.isMissing()) {
                    return new Missing(Value.Kind.TEXT);
                }
                joined.append(text(operand, context));
            }
            return new Text(joined.toString());
        });
        registry.put("Combine", (node, context) -> {
            Value source = Operators.operand(node, "source", context);
            if (source.isMissing()) {
                return new Missing(Value.Kind.TEXT);
            }
            Optional<Value> separator = Operators.optionalOperand(node, "separator", context);
            String between = separator.isPresent() && !separator.get().isMissing() ? text(separator.get(), context) : "";
            List<Value> parts = Lists.list(source, context);
            if (parts.isEmpty()) {
                return new Missing(Value.Kind.TEXT);
            }
            StringBuilder joined = new StringBuilder();
            boolean first = true;
            for (Value part : parts) {
                if (part.isMissing()) {
                    continue;
                }
                if (!first) {
                    joined.append(between);
                }
                joined.append(text(part, context));
                first = false;
            }
            return first ? new Missing(Value.Kind.TEXT) : new Text(joined.toString());
        });
        registry.put("StartsWith", (node, context) -> affix(node, context, true));
        registry.put("EndsWith", (node, context) -> affix(node, context, false));
        registry.put("PositionOf", (node, context) -> position(node, context, true));
        registry.put("LastPositionOf", (node, context) -> position(node, context, false));
        registry.put("Lower", (node, context) -> {
            Value value = Operators.single(node, context);
            return value.isMissing() ? new Missing(Value.Kind.TEXT) : new Text(text(value, context).toLowerCase());
        });
        registry.put("Upper", (node, context) -> {
            Value value = Operators.single(node, context);
            return value.isMissing() ? new Missing(Value.Kind.TEXT) : new Text(text(value, context).toUpperCase());
        });
        registry.put("Matches", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            if (operands.get(0).isMissing() || operands.get(1).isMissing()) {
                return Presence.INDETERMINATE;
            }
            return Presence.of(pattern(text(operands.get(1), context), context).matcher(text(operands.get(0), context)).matches());
        });
        registry.put("ReplaceMatches", (node, context) -> {
            List<Value> operands = Operators.operands(node, context);
            if (operands.size() != 3) {
                throw context.refuse("a replacement takes a text, a pattern, and a substitution");
            }
            if (operands.stream().anyMatch(Value::isMissing)) {
                return new Missing(Value.Kind.TEXT);
            }
            return new Text(pattern(text(operands.get(1), context), context).matcher(text(operands.get(0), context))
                    .replaceAll(text(operands.get(2), context)));
        });
        registry.put("Split", (node, context) -> {
            Value source = Operators.operand(node, "stringToSplit", context);
            if (source.isMissing()) {
                return new Missing(Value.Kind.LIST);
            }
            String whole = text(source, context);
            Optional<Value> separator = Operators.optionalOperand(node, "separator", context);
            if (separator.isEmpty() || separator.get().isMissing()) {
                return new ListValue(List.of(new Text(whole)));
            }
            String at = text(separator.get(), context);
            List<Value> parts = new ArrayList<>();
            if (at.isEmpty()) {
                parts.add(new Text(whole));
                return new ListValue(parts);
            }
            int from = 0;
            int found;
            while ((found = whole.indexOf(at, from)) >= 0) {
                parts.add(new Text(whole.substring(from, found)));
                from = found + at.length();
            }
            parts.add(new Text(whole.substring(from)));
            return new ListValue(parts);
        });
        registry.put("Substring", (node, context) -> {
            Value source = Operators.operand(node, "stringToSub", context);
            Value startValue = Operators.operand(node, "startIndex", context);
            if (source.isMissing() || startValue.isMissing()) {
                return new Missing(Value.Kind.TEXT);
            }
            String whole = text(source, context);
            int start = Lists.whole(startValue, context).orElseThrow();
            if (start < 0 || start >= whole.length()) {
                return whole.isEmpty() && start == 0 ? new Text("") : new Missing(Value.Kind.TEXT);
            }
            Optional<Value> lengthValue = Operators.optionalOperand(node, "length", context);
            if (lengthValue.isPresent() && !lengthValue.get().isMissing()) {
                int length = Lists.whole(lengthValue.get(), context).orElseThrow();
                if (length < 0) {
                    return new Missing(Value.Kind.TEXT);
                }
                return new Text(whole.substring(start, Math.min(whole.length(), start + length)));
            }
            return new Text(whole.substring(start));
        });
        registry.put("Message", (node, context) -> {
            Value source = Operators.operand(node, "source", context);
            Optional<Value> condition = Operators.optionalOperand(node, "condition", context);
            Optional<Value> severity = Operators.optionalOperand(node, "severity", context);
            if (condition.isPresent() && condition.get() == Presence.PRESENT && severity.isPresent()
                    && severity.get() instanceof Text level && level.text().equalsIgnoreCase("Error")) {
                Optional<Value> message = Operators.optionalOperand(node, "message", context);
                Optional<Value> code = Operators.optionalOperand(node, "code", context);
                throw context.refuse("the library raised an error" + code.map(value -> " " + Types.render(value).orElse("")).orElse("")
                        + message.map(value -> ": " + Types.render(value).orElse("")).orElse(""));
            }
            return source;
        });
    }

    /** A value as text; refused when it is not a text. */
    static String text(Value value, Context context) {
        if (value instanceof Text text) {
            return text.text();
        }
        throw context.refuse("a text was needed, and the value is a " + value.kind());
    }

    private static Pattern pattern(String expression, Context context) {
        try {
            return Pattern.compile(expression);
        } catch (PatternSyntaxException refused) {
            throw context.refuse("the pattern cannot be read: " + refused.getDescription());
        }
    }

    private static Value affix(TreeNode node, Context context, boolean start) {
        List<Value> operands = Operators.pair(node, context);
        if (operands.get(0).isMissing() || operands.get(1).isMissing()) {
            return Presence.INDETERMINATE;
        }
        String whole = text(operands.get(0), context);
        String part = text(operands.get(1), context);
        return Presence.of(start ? whole.startsWith(part) : whole.endsWith(part));
    }

    private static Value position(TreeNode node, Context context, boolean first) {
        Value pattern = Operators.operand(node, "pattern", context);
        Value whole = Operators.operand(node, "string", context);
        if (pattern.isMissing() || whole.isMissing()) {
            return Operators.missingMeasure();
        }
        String haystack = text(whole, context);
        String needle = text(pattern, context);
        int at = first ? haystack.indexOf(needle) : haystack.lastIndexOf(needle);
        return Values.number(BigDecimal.valueOf(at)).withPlaces(0);
    }
}
