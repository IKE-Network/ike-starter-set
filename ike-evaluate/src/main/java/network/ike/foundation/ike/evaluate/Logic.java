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
 * The logical and nullological kinds: the presence connectives, the conditionals, and the
 * direct readings of a missing value.
 */
final class Logic {

    private Logic() {
    }

    static void register(Operators registry) {
        registry.put("And", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return Operators.presence(operands.get(0), context).and(Operators.presence(operands.get(1), context));
        });
        registry.put("Or", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return Operators.presence(operands.get(0), context).or(Operators.presence(operands.get(1), context));
        });
        registry.put("Xor", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return Operators.presence(operands.get(0), context).xor(Operators.presence(operands.get(1), context));
        });
        registry.put("Implies", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            return Operators.presence(operands.get(0), context).implies(Operators.presence(operands.get(1), context));
        });
        registry.put("Not", (node, context) -> Operators.presence(Operators.single(node, context), context).not());
        registry.put("If", (node, context) -> {
            Presence condition = Operators.presence(Operators.operand(node, "condition", context), context);
            return condition == Presence.PRESENT ? Operators.operand(node, "then", context) : Operators.operand(node, "else", context);
        });
        registry.put("Case", (node, context) -> {
            Optional<Value> comparand = Operators.optionalOperand(node, "comparand", context);
            List<TreeNode> items = node.items("caseItem");
            for (int i = 0; i < items.size(); i++) {
                Context at = context.at("caseItem[" + (i + 1) + "]");
                Value when = Operators.operand(items.get(i), "when", at);
                boolean taken = comparand.isPresent()
                        ? Values.equal(comparand.get(), when) == Presence.PRESENT
                        : Operators.presence(when, at) == Presence.PRESENT;
                if (taken) {
                    return Operators.operand(items.get(i), "then", at);
                }
            }
            return Operators.operand(node, "else", context);
        });
        registry.put("IsNull", (node, context) -> Presence.of(Operators.single(node, context).isMissing()));
        registry.put("IsTrue", (node, context) -> Presence.of(Operators.single(node, context) == Presence.PRESENT));
        registry.put("IsFalse", (node, context) -> Presence.of(Operators.single(node, context) == Presence.ABSENT));
        registry.put("Coalesce", (node, context) -> {
            List<Value> operands = Operators.operands(node, context);
            if (operands.size() == 1 && operands.get(0) instanceof ListValue list) {
                operands = list.values();
            }
            for (Value operand : operands) {
                if (!operand.isMissing()) {
                    return operand;
                }
            }
            return Missing.ANY;
        });
    }
}
