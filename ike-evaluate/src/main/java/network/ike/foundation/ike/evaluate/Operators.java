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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The reading of each admitted node kind into the operands of the construct its relation names:
 * one operator per node kind, registered by family. The relations in the store decide what is
 * admitted; this registry says how an admitted kind is read. A kind admitted by a relation and
 * not registered here is refused as admitted and not yet read.
 */
final class Operators {

    /** How one node kind is read. */
    @FunctionalInterface
    interface Operator {
        /**
         * Reads a node into a value.
         *
         * @param node    the node
         * @param context where evaluation stands
         * @return the value
         * @throws Refused when the node cannot be read
         */
        Value apply(TreeNode node, Context context);
    }

    private final Map<String, Operator> byKind = new HashMap<>();

    Operators() {
        Literals.register(this);
        References.register(this);
        Logic.register(this);
        Comparisons.register(this);
        Intervals.register(this);
        Arithmetic.register(this);
        Aggregates.register(this);
        Queries.register(this);
        Clinical.register(this);
        Types.register(this);
        Components.register(this);
        Functions.register(this);
        Lists.register(this);
        Strings.register(this);
    }

    void put(String kind, Operator operator) {
        byKind.put(kind, operator);
    }

    Optional<Operator> of(String kind) {
        return Optional.ofNullable(byKind.get(kind));
    }

    int size() {
        return byKind.size();
    }

    // ── Shared readings ──

    /** The node held at a position, evaluated. */
    static Value operand(TreeNode node, String position, Context context) {
        TreeNode held = node.held(position).orElseThrow(() ->
                context.refuse("the " + node.kindName() + " holds nothing at " + position));
        return context.evaluator().eval(held, context.at(position));
    }

    /** The node held at a position, evaluated, or empty when the position is empty. */
    static Optional<Value> optionalOperand(TreeNode node, String position, Context context) {
        Optional<TreeNode> held = node.held(position);
        return held.map(tree -> context.evaluator().eval(tree, context.at(position)));
    }

    /** The operands, evaluated in order. */
    static List<Value> operands(TreeNode node, Context context) {
        List<TreeNode> trees = node.operands();
        List<Value> values = new ArrayList<>(trees.size());
        for (int i = 0; i < trees.size(); i++) {
            values.add(context.evaluator().eval(trees.get(i), context.at("operand[" + (i + 1) + "]")));
        }
        return values;
    }

    /** Exactly two operands. */
    static List<Value> pair(TreeNode node, Context context) {
        List<Value> values = operands(node, context);
        if (values.size() != 2) {
            throw context.refuse("the " + node.kindName() + " takes two operands and holds " + values.size());
        }
        return values;
    }

    /** Exactly one operand. */
    static Value single(TreeNode node, Context context) {
        List<Value> values = operands(node, context);
        if (values.size() != 1) {
            throw context.refuse("the " + node.kindName() + " takes one operand and holds " + values.size());
        }
        return values.get(0);
    }

    /** A value as a presence: a missing value is Indeterminate; anything else is refused. */
    static Presence presence(Value value, Context context) {
        if (value instanceof Presence presence) {
            return presence;
        }
        if (value.isMissing()) {
            return Presence.INDETERMINATE;
        }
        throw context.refuse("a presence was needed, and the value is a " + value.kind());
    }

    /** A value as a measure, empty when missing; anything else is refused. */
    static Optional<Measure> measure(Value value, Context context) {
        if (value instanceof Measure measure) {
            return Optional.of(measure);
        }
        if (value.isMissing()) {
            return Optional.empty();
        }
        throw context.refuse("a measure was needed, and the value is a " + value.kind());
    }

    /** The precision named on a node, as a resolution. */
    static Optional<Resolution> precision(TreeNode node) {
        return node.enumName("precision").map(name -> Resolution.valueOf(name.toUpperCase()));
    }

    /** A missing value of the kind a measure operation yields. */
    static Value missingMeasure() {
        return new Missing(Value.Kind.MEASURE);
    }
}
