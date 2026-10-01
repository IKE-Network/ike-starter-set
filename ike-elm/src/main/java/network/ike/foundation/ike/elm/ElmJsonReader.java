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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import network.ike.foundation.ike.elm.ElmCatalog.Form;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmDocument.Node;
import network.ike.foundation.ike.elm.ElmDocument.NodeBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

/**
 * Reads ELM in its JSON form, as the translator writes it: a node is an object whose
 * {@code type} names its kind, its other members are positions, and a list is an array. The
 * catalog decides what each member is; annotations are dropped; a member the kind does not have
 * is refused with its place named.
 */
public final class ElmJsonReader {

    private final ElmCatalog catalog;
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Creates a reader over a catalog.
     *
     * @param catalog the catalog
     */
    public ElmJsonReader(ElmCatalog catalog) {
        this.catalog = catalog;
    }

    /**
     * Reads a library document.
     *
     * @param in the JSON
     * @return the document
     * @throws IOException              if the JSON cannot be read
     * @throws IllegalArgumentException if the document does not follow the catalog
     */
    public ElmDocument read(InputStream in) throws IOException {
        JsonNode root = mapper.readTree(in);
        JsonNode library = root.get("library");
        if (library == null || !library.isObject()) {
            throw new IllegalArgumentException("library: the document has no library object at its top");
        }
        return new ElmDocument(node(library, catalog.kind("Library"), "library"));
    }

    private Node node(JsonNode object, NodeKind kind, String path) {
        NodeBuilder builder = new NodeBuilder(kind.name());
        Iterator<Map.Entry<String, JsonNode>> fields = object.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String member = field.getKey();
            if (member.equals("type") || member.equals(ElmReading.ANNOTATION) || field.getValue().isNull()) {
                continue;
            }
            PositionRule rule = ElmReading.rule(catalog, kind, member, path);
            JsonNode value = field.getValue();
            if (value.isArray()) {
                int index = 0;
                for (JsonNode element : value) {
                    index++;
                    add(builder, rule, element, path + "/" + member + "[" + index + "]");
                }
            } else {
                add(builder, rule, value, path + "/" + member);
            }
        }
        return builder.build();
    }

    private void add(NodeBuilder builder, PositionRule rule, JsonNode value, String path) {
        if (value.isNull()) {
            return;
        }
        if (rule.form() == Form.EDGE) {
            if (!value.isObject()) {
                throw new IllegalArgumentException(path + ": " + rule.name() + " holds a node, not a plain value");
            }
            Optional<String> declared = value.hasNonNull("type")
                    ? Optional.of(value.get("type").asText()) : Optional.empty();
            Optional<NodeKind> held = ElmReading.heldKind(catalog, rule, declared, path);
            held.ifPresent(kind -> builder.add(rule.name(), node(value, kind, path)));
            return;
        }
        if (value.isObject() || value.isArray()) {
            throw new IllegalArgumentException(path + ": " + rule.name() + " holds a plain value, not a node");
        }
        builder.add(rule.name(), ElmReading.plain(rule, value.asText(), path));
    }
}
