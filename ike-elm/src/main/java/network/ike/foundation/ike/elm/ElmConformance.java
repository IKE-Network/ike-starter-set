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

import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.terms.ConceptFacade;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.elm.ElmCatalog.EnumerationValue;
import network.ike.foundation.ike.elm.ElmCatalog.Form;
import network.ike.foundation.ike.elm.ElmCatalog.KindValue;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmCatalog.PrimitiveValue;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Checks one of our trees against the ELM node catalog: every vertex a known node kind, every
 * property and every edge a position its kind allows, held in the allowed form, the allowed
 * number of times, holding a value or a node of the allowed kind. Two or three operands must be
 * named as the roles first, second, and third; a list position must point at an ordered list
 * semantic, except that a choice type specifier may hold its alternatives as a set, the way a
 * model element's type does. Problems are reported in plain words, one per line.
 */
public final class ElmConformance {

    private ElmConformance() {
    }

    /**
     * Checks a tree and throws when it does not conform.
     *
     * @param tree    the tree
     * @param catalog the catalog
     * @throws ElmConformanceException listing every problem found
     */
    public static void require(DiTreeEntity tree, ElmCatalog catalog) {
        List<String> problems = check(tree, catalog);
        if (!problems.isEmpty()) {
            throw new ElmConformanceException(problems);
        }
    }

    /**
     * Checks a tree and lists what does not conform.
     *
     * @param tree    the tree
     * @param catalog the catalog
     * @return the problems, empty when the tree conforms
     */
    public static List<String> check(DiTreeEntity tree, ElmCatalog catalog) {
        List<String> problems = new ArrayList<>();
        checkNode(tree, tree.root(), catalog, problems);
        return problems;
    }

    private static void checkNode(DiTreeEntity tree, EntityVertex vertex, ElmCatalog catalog, List<String> problems) {
        Optional<NodeKind> found = catalog.kindOf(vertex.getMeaningNid());
        if (found.isEmpty()) {
            problems.add("vertex " + vertex.vertexIndex() + " means a concept that is not a node kind of the catalog");
            return;
        }
        NodeKind kind = found.get();
        Map<String, Integer> counts = new HashMap<>();
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;

        for (int keyNid : vertex.properties().keySet().toArray()) {
            Optional<String> name = catalog.positionName(keyNid);
            if (name.isEmpty()) {
                problems.add(kind.name() + " holds a property keyed by a concept that is not a position");
                continue;
            }
            Optional<PositionRule> rule = kind.position(name.get());
            if (rule.isEmpty()) {
                problems.add(kind.name() + " does not hold a position named " + name.get());
                continue;
            }
            if (rule.get().form() != Form.PROPERTY) {
                problems.add(kind.name() + "'s " + name.get() + " holds a node, not a plain value");
                continue;
            }
            checkValue(kind, rule.get(), vertex.properties().get(keyNid), problems);
            counts.merge(name.get(), 1, Integer::sum);
        }

        ImmutableIntList successors = tree.successors(vertex.vertexIndex());
        for (int i = 0; i < successors.size(); i++) {
            EntityVertex argument = tree.vertex(successors.get(i));
            int meaning = argument.getMeaningNid();
            if (meaning == IkeTerms.ELM_FIRST_OPERAND_POSITION.nid()
                    || meaning == IkeTerms.ELM_SECOND_OPERAND_POSITION.nid()
                    || meaning == IkeTerms.ELM_THIRD_OPERAND_POSITION.nid()) {
                Optional<PositionRule> roles = rolesRule(kind);
                if (roles.isEmpty()) {
                    problems.add(kind.name() + " takes no operands named first, second, or third");
                    continue;
                }
                if (meaning == IkeTerms.ELM_FIRST_OPERAND_POSITION.nid()) {
                    firstCount++;
                } else if (meaning == IkeTerms.ELM_SECOND_OPERAND_POSITION.nid()) {
                    secondCount++;
                } else {
                    thirdCount++;
                    if (roles.get().maximum() < 3) {
                        problems.add(kind.name() + " takes no third operand");
                    }
                }
                checkHeldNode(tree, kind, roles.get(), argument, catalog, problems);
                continue;
            }
            Optional<String> name = catalog.positionName(meaning);
            if (name.isEmpty()) {
                problems.add(kind.name() + " has an edge whose argument vertex means a concept that is not a position");
                continue;
            }
            Optional<PositionRule> rule = kind.position(name.get());
            if (rule.isEmpty()) {
                problems.add(kind.name() + " does not hold a position named " + name.get());
                continue;
            }
            if (rule.get().form() != Form.EDGE) {
                problems.add(kind.name() + "'s " + name.get() + " holds a plain value, not a node");
                continue;
            }
            if (rule.get().isRoles()) {
                problems.add(kind.name() + "'s " + name.get() + " must be named first, second"
                        + (rule.get().maximum() == 3 ? ", and third" : "") + ", not " + name.get());
                continue;
            }
            counts.merge(name.get(), 1, Integer::sum);
            if (rule.get().isList() && kind.name().equals("ChoiceTypeSpecifier") && name.get().equals("choice")
                    && !argument.properties().containsKey(IkeTerms.ELM_LIST_ITEMS.nid())) {
                // A choice's alternatives have no order: a model element's type holds them as the
                // children of the choice position, a set, and a library's tree may hold them as an
                // ordered list; either conforms.
                ImmutableIntList alternatives = tree.successors(argument.vertexIndex());
                if (alternatives.isEmpty()) {
                    problems.add(kind.name() + "'s choice holds no alternative");
                }
                for (int j = 0; j < alternatives.size(); j++) {
                    checkNode(tree, tree.vertex(alternatives.get(j)), catalog, problems);
                }
                continue;
            }
            if (rule.get().isList()) {
                if (!argument.properties().containsKey(IkeTerms.ELM_LIST_ITEMS.nid())) {
                    problems.add(kind.name() + "'s " + name.get() + " is a list and must point at an ordered list semantic");
                }
                if (!tree.successors(argument.vertexIndex()).isEmpty()) {
                    problems.add(kind.name() + "'s " + name.get() + " is a list; its items live in the ordered list, not below the tree");
                }
                continue;
            }
            checkHeldNode(tree, kind, rule.get(), argument, catalog, problems);
        }

        for (PositionRule rule : kind.positions()) {
            if (rule.isRoles()) {
                if (firstCount != 1 || secondCount != 1 || (rule.maximum() == 3 ? thirdCount != 1 : thirdCount != 0)) {
                    problems.add(kind.name() + " needs exactly one first and one second operand"
                            + (rule.maximum() == 3 ? " and one third" : "") + "; found "
                            + firstCount + ", " + secondCount + ", " + thirdCount);
                }
                continue;
            }
            int count = counts.getOrDefault(rule.name(), 0);
            if (count < rule.minimum()) {
                problems.add(kind.name() + " needs at least " + rule.minimum() + " " + rule.name() + "; found " + count);
            }
            if (rule.maximum() >= 0 && count > rule.maximum()) {
                problems.add(kind.name() + " holds " + rule.name() + " " + count + " times; at most " + rule.maximum() + " allowed");
            }
        }
    }

    private static void checkHeldNode(DiTreeEntity tree, NodeKind kind, PositionRule rule, EntityVertex argument,
                                      ElmCatalog catalog, List<String> problems) {
        ImmutableIntList held = tree.successors(argument.vertexIndex());
        if (held.size() != 1) {
            problems.add(kind.name() + "'s " + rule.name() + " must hold exactly one node; found " + held.size());
            return;
        }
        EntityVertex child = tree.vertex(held.get(0));
        Optional<NodeKind> childKind = catalog.kindOf(child.getMeaningNid());
        if (childKind.isEmpty()) {
            problems.add(kind.name() + "'s " + rule.name() + " holds a vertex that is not a node kind of the catalog");
            return;
        }
        if (rule.valueType() instanceof KindValue kindValue && !childKind.get().isKindOf(kindValue.kind())) {
            problems.add(kind.name() + "'s " + rule.name() + " must hold a " + kindValue.kind().name()
                    + " or a kind that extends it; found " + childKind.get().name());
        }
        checkNode(tree, child, catalog, problems);
    }

    private static void checkValue(NodeKind kind, PositionRule rule, Object value, List<String> problems) {
        if (rule.valueType() instanceof EnumerationValue enumeration) {
            if (!(value instanceof ConceptFacade concept) || !enumeration.valueNids().contains(concept.nid())) {
                problems.add(kind.name() + "'s " + rule.name() + " must be one of the values of its enumeration");
            }
            return;
        }
        if (rule.valueType() instanceof PrimitiveValue primitive) {
            if (primitive.name().equals("QName") && value instanceof ConceptFacade) {
                return; // a System type held as the catalog's concept
            }
            boolean ok = switch (primitive.name()) {
                case "boolean" -> value instanceof Boolean;
                case "int", "long" -> value instanceof Integer || value instanceof Long;
                case "decimal" -> value instanceof Number;
                case "anySimpleType", "anyType" -> value instanceof String || value instanceof Number
                        || value instanceof Boolean;
                default -> value instanceof String;
            };
            if (!ok) {
                problems.add(kind.name() + "'s " + rule.name() + " must hold a " + primitive.name()
                        + " value; found " + (value == null ? "nothing" : value.getClass().getSimpleName()));
            }
        }
    }

    private static Optional<PositionRule> rolesRule(NodeKind kind) {
        for (PositionRule rule : kind.positions()) {
            if (rule.isRoles()) {
                return Optional.of(rule);
            }
        }
        return Optional.empty();
    }
}
