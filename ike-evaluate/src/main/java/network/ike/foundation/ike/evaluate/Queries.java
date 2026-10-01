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
import java.util.Map;
import java.util.Optional;

/**
 * The query kinds: a query over one or more aliased sources with let bindings, correlation
 * constraints, a where clause, a return, a sort, or an aggregate, the closed-world existence of
 * a list, and the one element of a list. Several sources run over their product, each row a
 * tuple of the aliases.
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

    /** One row of a query: the values its aliases stand for, and the value it yields when unprojected. */
    private record Row(Context bound, Value yield) {
    }

    private static Value query(TreeNode node, Context context) {
        List<TreeNode> sources = node.items("source");
        if (sources.isEmpty()) {
            throw context.refuse("the query has no source");
        }
        List<String> aliases = new ArrayList<>();
        List<List<Value>> columns = new ArrayList<>();
        boolean singular = true;
        for (int i = 0; i < sources.size(); i++) {
            TreeNode source = sources.get(i);
            String alias = source.text("alias").orElseThrow(() -> context.refuse("the query's source has no alias"));
            Value value = context.evaluator().eval(source, context.at("source[" + (i + 1) + "]"));
            if (value.isMissing()) {
                return sources.size() == 1 ? Missing.ANY : new Missing(Value.Kind.LIST);
            }
            aliases.add(alias);
            if (value instanceof ListValue list) {
                singular = false;
                columns.add(list.values());
            } else {
                columns.add(List.of(value));
            }
        }
        List<Row> rows = new ArrayList<>();
        product(aliases, columns, 0, context, new java.util.LinkedHashMap<>(), rows);
        List<TreeNode> lets = node.items("let");
        for (TreeNode let : lets) {
            context.evaluator().admit(let, context.at("let"));
        }
        List<TreeNode> relationships = node.items("relationship");
        Optional<TreeNode> where = node.held("where");
        List<Row> kept = new ArrayList<>();
        for (Row row : rows) {
            Context bound = row.bound();
            for (TreeNode let : lets) {
                String name = let.text("identifier").orElseThrow(() -> context.refuse("a let clause has no identifier"));
                bound = bound.bind(name, Operators.operand(let, "expression", bound.at("let " + name)));
            }
            if (!related(relationships, bound) || !holds(where, bound)) {
                continue;
            }
            kept.add(new Row(bound, row.yield()));
        }
        Optional<TreeNode> aggregate = node.held("aggregate");
        if (aggregate.isPresent()) {
            return fold(aggregate.get(), kept, context);
        }
        Optional<TreeNode> returning = node.held("return");
        List<Value> yields = new ArrayList<>();
        boolean distinct = false;
        if (returning.isPresent()) {
            context.evaluator().admit(returning.get(), context.at("return"));
            distinct = returning.get().flag("distinct").orElse(true);
            for (Row row : kept) {
                yields.add(Operators.operand(returning.get(), "expression", row.bound().at("return")));
            }
        } else {
            for (Row row : kept) {
                yields.add(row.yield());
            }
        }
        Optional<TreeNode> sort = node.held("sort");
        if (sort.isPresent()) {
            context.evaluator().admit(sort.get(), context.at("sort"));
            yields = ordered(sort.get(), yields, aliases, context);
        }
        if (distinct) {
            yields = Lists.distinct(yields);
        }
        if (singular && sources.size() == 1 && sort.isEmpty()) {
            return yields.isEmpty() ? Missing.ANY : yields.get(0);
        }
        return new ListValue(yields);
    }

    /** The rows of the sources' product, each binding every alias; one source yields its elements, several yield tuples. */
    private static void product(List<String> aliases, List<List<Value>> columns, int depth, Context context,
                                java.util.LinkedHashMap<String, Value> chosen, List<Row> rows) {
        if (depth == aliases.size()) {
            Context bound = context;
            for (Map.Entry<String, Value> entry : chosen.entrySet()) {
                bound = bound.bind(entry.getKey(), entry.getValue());
            }
            Value yield = aliases.size() == 1 ? chosen.get(aliases.get(0)) : new TupleValue(new java.util.LinkedHashMap<>(chosen));
            rows.add(new Row(bound, yield));
            return;
        }
        for (Value value : columns.get(depth)) {
            chosen.put(aliases.get(depth), value);
            product(aliases, columns, depth + 1, context, chosen, rows);
            chosen.remove(aliases.get(depth));
        }
    }

    /** The rows folded through the accumulator the clause names. */
    private static Value fold(TreeNode aggregate, List<Row> rows, Context context) {
        context.evaluator().admit(aggregate, context.at("aggregate"));
        String name = aggregate.text("identifier").orElseThrow(() -> context.refuse("the aggregate clause has no identifier"));
        Value accumulator = Operators.optionalOperand(aggregate, "starting", context.at("aggregate")).orElse(Missing.ANY);
        List<Row> folded = rows;
        if (aggregate.flag("distinct").orElse(false)) {
            folded = new ArrayList<>();
            List<Value> seen = new ArrayList<>();
            for (Row row : rows) {
                if (Lists.distinct(concat(seen, row.yield())).size() > seen.size()) {
                    seen.add(row.yield());
                    folded.add(row);
                }
            }
        }
        for (Row row : folded) {
            accumulator = Operators.operand(aggregate, "expression", row.bound().bind(name, accumulator).at("aggregate " + name));
        }
        return accumulator;
    }

    private static List<Value> concat(List<Value> values, Value value) {
        List<Value> all = new ArrayList<>(values);
        all.add(value);
        return all;
    }

    /**
     * The yields in the order the sort clause's keys give, missing values first. Two measures
     * whose order is open, an instant written to the day beside an hour within it, sort by
     * their starts and then the coarser first, so that the day precedes its hours.
     */
    private static List<Value> ordered(TreeNode sort, List<Value> yields, List<String> aliases, Context context) {
        List<TreeNode> keys = sort.items("by");
        for (TreeNode key : keys) {
            context.evaluator().admit(key, context.at("sort"));
        }
        List<Value> sorted = new ArrayList<>(yields);
        sorted.sort((a, b) -> {
            for (TreeNode key : keys) {
                boolean descending = key.enumName("direction").map(direction -> direction.toLowerCase().startsWith("desc")).orElse(false);
                int order = compare(keyOf(key, a, aliases, context), keyOf(key, b, aliases, context));
                if (order != 0) {
                    return descending ? -order : order;
                }
            }
            return 0;
        });
        return sorted;
    }

    private static Value keyOf(TreeNode key, Value row, List<String> aliases, Context context) {
        switch (key.kindName()) {
            case "ByDirection" -> {
                return row;
            }
            case "ByColumn" -> {
                String path = key.text("path").orElseThrow(() -> context.refuse("a sort by column names no path"));
                return References.property(row, path, context);
            }
            case "ByExpression" -> {
                Context bound = context;
                for (String alias : aliases) {
                    bound = bound.bind(alias, row);
                }
                return Operators.operand(key, "expression", bound.bind("$this", row).at("sort"));
            }
            default -> throw context.refuse("the sort key " + key.kindName() + " is not read");
        }
    }

    private static int compare(Value a, Value b) {
        if (a.isMissing() || b.isMissing()) {
            return a.isMissing() && b.isMissing() ? 0 : a.isMissing() ? -1 : 1;
        }
        if (a instanceof Measure ma && b instanceof Measure mb) {
            if (Values.compare(ma, mb, Values.Order.LESS) == Presence.PRESENT) {
                return -1;
            }
            if (Values.compare(ma, mb, Values.Order.GREATER) == Presence.PRESENT) {
                return 1;
            }
            if (ma.bounded() && mb.bounded()) {
                int starts = ma.lower().get().compareTo(mb.lower().get());
                if (starts != 0) {
                    return starts;
                }
                return mb.upper().get().compareTo(ma.upper().get());
            }
            return 0;
        }
        if (a instanceof Text ta && b instanceof Text tb) {
            return ta.text().compareTo(tb.text());
        }
        if (a instanceof Presence pa && b instanceof Presence pb) {
            return Integer.compare(pa.ordinal(), pb.ordinal());
        }
        return 0;
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
