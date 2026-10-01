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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import network.ike.foundation.ike.elm.ElmCatalog.KindValue;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmDocument.Node;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Writes a document in ELM's JSON form, as the translator does: a node is an object, its
 * {@code type} written when the position it fills allows more than one kind, its members in
 * catalog order, a list as an array.
 */
public final class ElmJsonWriter {

    private final ElmCatalog catalog;
    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    /**
     * Creates a writer over a catalog.
     *
     * @param catalog the catalog
     */
    public ElmJsonWriter(ElmCatalog catalog) {
        this.catalog = catalog;
    }

    /**
     * Writes a document.
     *
     * @param document the document
     * @return the JSON text
     */
    public String write(ElmDocument document) {
        ObjectNode root = mapper.createObjectNode();
        root.set("library", object(document.library(), Optional.empty()));
        try {
            return mapper.writeValueAsString(root);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            throw new IllegalStateException("The document cannot be written as JSON", e);
        }
    }

    private ObjectNode object(Node node, Optional<PositionRule> filling) {
        ObjectNode object = mapper.createObjectNode();
        NodeKind kind = catalog.kind(node.kind());
        boolean declared = filling.isPresent() && filling.get().valueType() instanceof KindValue kindValue
                && kindValue.kind().name().equals(kind.name());
        if (filling.isPresent() && !declared) {
            object.put("type", node.kind());
        }
        for (Map.Entry<String, List<Object>> member : node.members().entrySet()) {
            PositionRule rule = kind.position(member.getKey()).orElseThrow();
            List<Object> values = member.getValue();
            if (values.size() == 1 && rule.maximum() == 1) {
                set(object, member.getKey(), values.get(0), rule);
                continue;
            }
            ArrayNode array = object.putArray(member.getKey());
            for (Object value : values) {
                if (value instanceof Node child) {
                    array.add(object(child, Optional.of(rule)));
                } else if (value instanceof Boolean bool) {
                    array.add(bool);
                } else if (value instanceof Integer number) {
                    array.add(number);
                } else if (value instanceof Long number) {
                    array.add(number);
                } else if (value instanceof BigDecimal number) {
                    array.add(number);
                } else {
                    array.add(String.valueOf(value));
                }
            }
        }
        return object;
    }

    private void set(ObjectNode object, String member, Object value, PositionRule rule) {
        if (value instanceof Node child) {
            object.set(member, object(child, Optional.of(rule)));
        } else if (value instanceof Boolean bool) {
            object.put(member, bool);
        } else if (value instanceof Integer number) {
            object.put(member, number);
        } else if (value instanceof Long number) {
            object.put(member, number);
        } else if (value instanceof BigDecimal number) {
            object.put(member, number);
        } else {
            object.put(member, String.valueOf(value));
        }
    }
}
