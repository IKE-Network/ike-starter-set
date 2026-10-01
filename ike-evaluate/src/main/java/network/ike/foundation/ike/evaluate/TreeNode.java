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

import dev.ikm.tinkar.common.id.IntIdList;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.elm.ElmCatalog;
import network.ike.foundation.ike.elm.ElmCatalog.EnumerationValue;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * One node of a stored tree as the evaluator reads it: its kind from the catalog, its plain
 * values by position name, the nodes it holds by position name, its operands in their roles,
 * and the items of an ordered list, read from the list semantic the position points at.
 */
final class TreeNode {

    private final DiTreeEntity tree;
    private final EntityVertex vertex;
    private final NodeKind kind;
    private final ElmCatalog catalog;
    private final StampCalculator calculator;

    TreeNode(DiTreeEntity tree, EntityVertex vertex, ElmCatalog catalog, StampCalculator calculator) {
        this.tree = tree;
        this.vertex = vertex;
        this.catalog = catalog;
        this.calculator = calculator;
        this.kind = catalog.kindOf(vertex.getMeaningNid()).orElseThrow(() ->
                new IllegalStateException("a stored vertex means a concept that is not a node kind of the catalog"));
    }

    static Optional<TreeNode> root(int treeSemanticNid, ElmCatalog catalog, StampCalculator calculator) {
        Latest<SemanticEntityVersion> latest = calculator.latest(treeSemanticNid);
        if (latest.isAbsent() || !(latest.get().fieldValues().get(0) instanceof DiTreeEntity tree)) {
            return Optional.empty();
        }
        return Optional.of(new TreeNode(tree, tree.root(), catalog, calculator));
    }

    NodeKind kind() {
        return kind;
    }

    String kindName() {
        return kind.name();
    }

    int kindNid() {
        return vertex.getMeaningNid();
    }

    /** A plain value at a position, as stored: text, number, concept. */
    Optional<Object> property(String position) {
        Optional<PositionRule> rule = kind.position(position);
        if (rule.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(vertex.properties().get(rule.get().position().nid()));
    }

    Optional<String> text(String position) {
        return property(position).map(String::valueOf);
    }

    /** A yes-or-no attribute at a position, as stored or as written. */
    Optional<Boolean> flag(String position) {
        return property(position).map(value -> value instanceof Boolean flag ? flag : Boolean.valueOf(String.valueOf(value)));
    }

    /** A number at a position, as stored or as written. */
    Optional<BigDecimal> number(String position) {
        return property(position).map(value -> value instanceof BigDecimal decimal ? decimal
                : value instanceof Number number ? new BigDecimal(number.toString()) : new BigDecimal(String.valueOf(value)));
    }

    /** The name of an enumeration value at a position, as the catalog spells it. */
    Optional<String> enumName(String position) {
        Optional<PositionRule> rule = kind.position(position);
        Optional<Object> value = property(position);
        if (rule.isEmpty() || value.isEmpty()) {
            return Optional.empty();
        }
        if (value.get() instanceof EntityProxy.Concept concept && rule.get().valueType() instanceof EnumerationValue enumeration) {
            return enumeration.nameOf(concept.nid());
        }
        return Optional.of(String.valueOf(value.get()));
    }

    /** Whether a position holds anything: a property, a held node, or items. */
    boolean has(String position) {
        return property(position).isPresent() || argument(position).isPresent();
    }

    /** The one node held at a position. */
    Optional<TreeNode> held(String position) {
        Optional<EntityVertex> argument = argument(position);
        if (argument.isEmpty()) {
            return Optional.empty();
        }
        ImmutableIntList children = tree.successors(argument.get().vertexIndex());
        return children.isEmpty() ? Optional.empty() : Optional.of(child(children.get(0)));
    }

    /** The items of an ordered list at a position, in order. */
    List<TreeNode> items(String position) {
        List<TreeNode> items = new ArrayList<>();
        Optional<EntityVertex> argument = argument(position);
        if (argument.isEmpty()) {
            return items;
        }
        Object list = argument.get().properties().get(IkeTerms.ELM_LIST_ITEMS.nid());
        if (list instanceof EntityProxy.Semantic semantic) {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isPresent() && latest.get().fieldValues().get(0) instanceof IntIdList itemNids) {
                for (int i = 0; i < itemNids.size(); i++) {
                    root(itemNids.get(i), catalog, calculator).ifPresent(items::add);
                }
            }
            return items;
        }
        ImmutableIntList children = tree.successors(argument.get().vertexIndex());
        for (int i = 0; i < children.size(); i++) {
            items.add(child(children.get(i)));
        }
        return items;
    }

    /** The operands: the one held operand, the roles first, second, and third, or the operand list. */
    List<TreeNode> operands() {
        Optional<TreeNode> single = held("operand");
        if (single.isPresent() && kind.position("operand").map(rule -> !rule.isRoles() && !rule.isList()).orElse(false)) {
            return List.of(single.get());
        }
        List<TreeNode> roles = new ArrayList<>();
        role(IkeTerms.ELM_FIRST_OPERAND_POSITION).ifPresent(roles::add);
        role(IkeTerms.ELM_SECOND_OPERAND_POSITION).ifPresent(roles::add);
        role(IkeTerms.ELM_THIRD_OPERAND_POSITION).ifPresent(roles::add);
        if (!roles.isEmpty()) {
            return roles;
        }
        return items("operand");
    }

    Optional<TreeNode> role(EntityProxy.Concept position) {
        ImmutableIntList successors = tree.successors(vertex.vertexIndex());
        for (int i = 0; i < successors.size(); i++) {
            EntityVertex argument = tree.vertex(successors.get(i));
            if (argument.getMeaningNid() == position.nid()) {
                ImmutableIntList children = tree.successors(argument.vertexIndex());
                return children.isEmpty() ? Optional.empty() : Optional.of(child(children.get(0)));
            }
        }
        return Optional.empty();
    }

    private Optional<EntityVertex> argument(String position) {
        Optional<PositionRule> rule = kind.position(position);
        if (rule.isEmpty()) {
            return Optional.empty();
        }
        int positionNid = rule.get().position().nid();
        ImmutableIntList successors = tree.successors(vertex.vertexIndex());
        for (int i = 0; i < successors.size(); i++) {
            EntityVertex argument = tree.vertex(successors.get(i));
            if (argument.getMeaningNid() == positionNid) {
                return Optional.of(argument);
            }
        }
        return Optional.empty();
    }

    private TreeNode child(int index) {
        return new TreeNode(tree, tree.vertex(index), catalog, calculator);
    }
}
