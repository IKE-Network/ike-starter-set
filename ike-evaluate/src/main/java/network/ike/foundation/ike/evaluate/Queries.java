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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The query kinds: a query over one aliased source with correlation constraints and a where
 * clause, the closed-world existence of a list, and the one element of a list. Clauses no
 * relation admits, a let, a return, a sort, an aggregate, or a second source, are refused by
 * name, since they belong to families of their own.
 */
final class Queries {

    private Queries() {
    }

    static void register(Operators registry) {
        registry.put("Query", Queries::query);
        registry.put("AliasedQuerySource", (node, context) -> Operators.operand(node, "expression", context));
        registry.put("With", (node, context) -> {
            throw context.refuse("a correlation constraint is read inside its query");
        });
        registry.put("Without", (node, context) -> {
            throw context.refuse("a correlation constraint is read inside its query");
        });
        registry.put("Exists", (node, context) -> {
            Value operand = Operators.single(node, context);
            if (operand.isMissing()) {
                return Presence.ABSENT;
            }
            if (!(operand instanceof ListValue list)) {
                throw context.refuse("existence is asked of a " + operand.kind());
            }
            return Presence.of(list.values().stream().anyMatch(value -> !value.isMissing()));
        });
        registry.put("SingletonFrom", (node, context) -> {
            Value operand = Operators.single(node, context);
            if (operand.isMissing()) {
                return Missing.ANY;
            }
            if (!(operand instanceof ListValue list)) {
                throw context.refuse("a singleton is asked of a " + operand.kind());
            }
            if (list.values().isEmpty()) {
                return Missing.ANY;
            }
            if (list.values().size() > 1) {
                throw context.refuse("the list holds " + list.values().size() + " elements, and one was asked for");
            }
            return list.values().get(0);
        });
    }

    private static Value query(TreeNode node, Context context) {
        for (String clause : List.of("let", "return", "sort", "aggregate")) {
            if (node.has(clause)) {
                throw context.refuse("the query's " + clause + " clause is of a kind no relation admits yet");
            }
        }
        List<TreeNode> sources = node.items("source");
        if (sources.size() != 1) {
            throw context.refuse("the query has " + sources.size() + " sources, and one is read");
        }
        TreeNode source = sources.get(0);
        String alias = source.text("alias").orElseThrow(() -> context.refuse("the query's source has no alias"));
        Value sourceValue = context.evaluator().eval(source, context.at("source"));
        boolean singular = !(sourceValue instanceof ListValue);
        List<Value> elements = singular ? List.of(sourceValue) : ((ListValue) sourceValue).values();
        if (sourceValue.isMissing()) {
            return Missing.ANY;
        }
        List<TreeNode> relationships = node.items("relationship");
        Optional<TreeNode> where = node.held("where");
        List<Value> kept = new ArrayList<>();
        for (Value element : elements) {
            Context bound = context.bind(alias, element);
            if (!related(relationships, bound) || !holds(where, bound)) {
                continue;
            }
            kept.add(element);
        }
        if (singular) {
            return kept.isEmpty() ? Missing.ANY : kept.get(0);
        }
        return new ListValue(kept);
    }

    private static boolean related(List<TreeNode> relationships, Context context) {
        for (int i = 0; i < relationships.size(); i++) {
            TreeNode relationship = relationships.get(i);
            Context at = context.at("relationship[" + (i + 1) + "]");
            context.evaluator().admit(relationship, at);
            boolean without = relationship.kindName().equals("Without");
            String alias = relationship.text("alias").orElseThrow(() -> at.refuse("the correlation has no alias"));
            Value related = Operators.operand(relationship, "expression", at);
            List<Value> candidates = related instanceof ListValue list ? list.values() : related.isMissing() ? List.of() : List.of(related);
            Optional<TreeNode> suchThat = relationship.held("suchThat");
            boolean any = false;
            for (Value candidate : candidates) {
                if (holds(suchThat, at.bind(alias, candidate))) {
                    any = true;
                    break;
                }
            }
            if (any == without) {
                return false;
            }
        }
        return true;
    }

    private static boolean holds(Optional<TreeNode> condition, Context context) {
        if (condition.isEmpty()) {
            return true;
        }
        Value value = context.evaluator().eval(condition.get(), context.at(condition.get().kindName()));
        return Operators.presence(value, context) == Presence.PRESENT;
    }
}
