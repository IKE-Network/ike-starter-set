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

import network.ike.foundation.ike.elm.ElmCatalog.EnumerationValue;
import network.ike.foundation.ike.elm.ElmCatalog.ExternalValue;
import network.ike.foundation.ike.elm.ElmCatalog.Form;
import network.ike.foundation.ike.elm.ElmCatalog.KindValue;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmCatalog.PrimitiveValue;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * What both readers share: the catalog decides what each member of a node is, and plain values
 * take one Java form whichever document form they came from.
 */
final class ElmReading {

    /** The member ELM uses for annotations, dropped on the way in. */
    static final String ANNOTATION = "annotation";

    private ElmReading() {
    }

    /**
     * The rule for a member of a kind, or a plain refusal naming the place.
     *
     * @param catalog the catalog
     * @param kind    the node kind
     * @param member  the member's name
     * @param path    where in the document, for the message
     * @return the rule
     * @throws IllegalArgumentException when the kind has no such position
     */
    static PositionRule rule(ElmCatalog catalog, NodeKind kind, String member, String path) {
        Optional<PositionRule> rule = kind.position(member);
        if (rule.isEmpty()) {
            throw new IllegalArgumentException(path + ": " + kind.name() + " has no position named " + member);
        }
        return rule.get();
    }

    /**
     * The kind a held node has: the one the document names, or the one the position declares.
     *
     * @param catalog  the catalog
     * @param rule     the position holding the node
     * @param declared the kind the document names, empty when it names none
     * @param path     where in the document, for the message
     * @return the kind, or empty when the position holds a type of another schema, which is dropped
     * @throws IllegalArgumentException when neither the document nor the catalog says the kind
     */
    static Optional<NodeKind> heldKind(ElmCatalog catalog, PositionRule rule, Optional<String> declared, String path) {
        if (rule.form() != Form.EDGE) {
            throw new IllegalArgumentException(path + ": " + rule.name() + " holds a plain value, not a node");
        }
        if (declared.isPresent()) {
            return Optional.of(catalog.kind(declared.get()));
        }
        if (rule.valueType() instanceof KindValue kindValue) {
            return Optional.of(kindValue.kind());
        }
        if (rule.valueType() instanceof ExternalValue) {
            return Optional.empty();
        }
        throw new IllegalArgumentException(path + ": " + rule.name() + " holds a node of no stated kind");
    }

    /**
     * A plain value in its one Java form: a boolean, a whole number, a decimal, or text. A
     * qualified name is given already in the braces form by the caller.
     *
     * @param rule the position holding the value
     * @param text the value as text
     * @param path where in the document, for the message
     * @return the value
     */
    static Object plain(PositionRule rule, String text, String path) {
        if (rule.form() != Form.PROPERTY) {
            throw new IllegalArgumentException(path + ": " + rule.name() + " holds a node, not a plain value");
        }
        if (rule.valueType() instanceof EnumerationValue) {
            return text;
        }
        if (rule.valueType() instanceof PrimitiveValue primitive) {
            try {
                return switch (primitive.name()) {
                    case "boolean" -> Boolean.valueOf(text);
                    case "int" -> Integer.valueOf(text);
                    case "long" -> Long.valueOf(text);
                    case "decimal" -> new BigDecimal(text);
                    default -> text;
                };
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(path + ": " + rule.name() + " must hold a " + primitive.name()
                        + " value; found " + text, e);
            }
        }
        return text;
    }
}
