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
package network.ike.foundation.ike.elm;

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.elm.ElmCatalog.Form;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * One ELM node as it is being built: its kind, the plain values it holds by position, the nodes
 * it holds by position, the roles first, second, and third, and the ordered lists it points at.
 * Each verb refuses a position the kind does not have, or a position asked for in the wrong
 * form, at once and in plain words; counts and value kinds are checked when the tree is built.
 */
public final class ElmNode {

    /**
     * A node held under a position or a role.
     *
     * @param position the position or role concept the argument vertex will mean
     * @param name     the position's name, or {@code first}, {@code second}, {@code third}
     * @param child    the node held
     */
    public record Argument(EntityProxy.Concept position, String name, ElmNode child) {
    }

    private final NodeKind kind;
    private final Map<String, Object> properties = new LinkedHashMap<>();
    private final List<Argument> arguments = new ArrayList<>();
    private final Map<String, PublicId> lists = new LinkedHashMap<>();

    ElmNode(NodeKind kind) {
        this.kind = kind;
    }

    /**
     * The node's kind.
     *
     * @return the kind
     */
    public NodeKind kind() {
        return kind;
    }

    /**
     * The plain values this node holds, by position name, in the order given.
     *
     * @return the properties
     */
    public Map<String, Object> properties() {
        return Collections.unmodifiableMap(properties);
    }

    /**
     * The nodes this node holds, in the order given.
     *
     * @return the arguments
     */
    public List<Argument> arguments() {
        return Collections.unmodifiableList(arguments);
    }

    /**
     * The ordered lists this node points at, by position name.
     *
     * @return the lists
     */
    public Map<String, PublicId> lists() {
        return Collections.unmodifiableMap(lists);
    }

    /**
     * Holds a plain value at a position: a string, a whole number, a decimal, a boolean, or a
     * value concept of an enumeration, given as the concept or as its bound enum constant.
     *
     * @param position the position's name as the schema writes it, for example {@code name}
     * @param value    the value
     * @return this node
     * @throws IllegalArgumentException if the kind has no such position or holds it as a node
     */
    public ElmNode property(String position, Object value) {
        PositionRule rule = rule(position);
        if (rule.form() != Form.PROPERTY) {
            throw new IllegalArgumentException(kind.name() + "'s " + position
                    + " holds a node, not a plain value; use edge(...)");
        }
        properties.put(position, value);
        return this;
    }

    /**
     * Holds a node at a position.
     *
     * @param position the position's name as the schema writes it, for example {@code operand}
     * @param child    the node held
     * @return this node
     * @throws IllegalArgumentException if the kind has no such position, holds it as a plain
     *                                  value, names its values as roles, or holds them as a list
     */
    public ElmNode edge(String position, ElmNode child) {
        PositionRule rule = rule(position);
        if (rule.form() != Form.EDGE) {
            throw new IllegalArgumentException(kind.name() + "'s " + position
                    + " holds a plain value, not a node; use property(...)");
        }
        if (rule.isRoles()) {
            throw new IllegalArgumentException(kind.name() + "'s " + position
                    + " takes " + rule.maximum() + " operands named first, second"
                    + (rule.maximum() == 3 ? ", and third" : "") + "; use first(...) and second(...)");
        }
        if (rule.isList()) {
            throw new IllegalArgumentException(kind.name() + "'s " + position
                    + " is a list; use list(...) with an ordered list semantic");
        }
        arguments.add(new Argument(rule.position(), position, child));
        return this;
    }

    /**
     * Holds the first of two or three operands.
     *
     * @param child the operand
     * @return this node
     * @throws IllegalArgumentException if the kind takes no fixed set of operands
     */
    public ElmNode first(ElmNode child) {
        return role(IkeTerms.ELM_FIRST_OPERAND_POSITION, "first", child);
    }

    /**
     * Holds the second of two or three operands.
     *
     * @param child the operand
     * @return this node
     * @throws IllegalArgumentException if the kind takes no fixed set of operands
     */
    public ElmNode second(ElmNode child) {
        return role(IkeTerms.ELM_SECOND_OPERAND_POSITION, "second", child);
    }

    /**
     * Holds the third of three operands.
     *
     * @param child the operand
     * @return this node
     * @throws IllegalArgumentException if the kind takes fewer than three operands
     */
    public ElmNode third(ElmNode child) {
        Optional<PositionRule> roles = rolesRule();
        if (roles.isEmpty() || roles.get().maximum() < 3) {
            throw new IllegalArgumentException(kind.name() + " takes no third operand");
        }
        return role(IkeTerms.ELM_THIRD_OPERAND_POSITION, "third", child);
    }

    /**
     * Points a list position at the ordered list semantic that holds its items.
     *
     * @param position     the position's name, for example {@code source}
     * @param orderedList  the ordered list semantic's public id
     * @return this node
     * @throws IllegalArgumentException if the kind has no such position or it is not a list
     */
    public ElmNode list(String position, PublicId orderedList) {
        PositionRule rule = rule(position);
        if (!rule.isList()) {
            throw new IllegalArgumentException(kind.name() + "'s " + position + " is not a list");
        }
        lists.put(position, orderedList);
        return this;
    }

    /**
     * The rule for the roles first, second, and third, when this kind takes two or three operands.
     *
     * @return the rule, or empty
     */
    public Optional<PositionRule> rolesRule() {
        for (PositionRule rule : kind.positions()) {
            if (rule.isRoles()) {
                return Optional.of(rule);
            }
        }
        return Optional.empty();
    }

    private ElmNode role(EntityProxy.Concept roleConcept, String name, ElmNode child) {
        if (rolesRule().isEmpty()) {
            throw new IllegalArgumentException(kind.name() + " takes no operands named " + name
                    + ": it has no position of exactly two or three values");
        }
        arguments.add(new Argument(roleConcept, name, child));
        return this;
    }

    private PositionRule rule(String position) {
        return kind.position(position).orElseThrow(() -> new IllegalArgumentException(
                kind.name() + " has no position named " + position));
    }
}
