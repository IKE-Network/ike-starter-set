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

import network.ike.foundation.ike.elm.ElmDocument.Node;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The canonical text of a node: its kind and its members with the members sorted by name and
 * every plain value written the same way whichever form it came from. Two nodes with the same
 * canonical text say the same thing. It is what a round trip compares and what an unnamed
 * list item's identity is derived from.
 */
public final class ElmCanonical {

    private ElmCanonical() {
    }

    /**
     * The canonical text of a document: that of its library node.
     *
     * @param document the document
     * @return the text
     */
    public static String text(ElmDocument document) {
        return text(document.library());
    }

    /**
     * The canonical text of a node.
     *
     * @param node the node
     * @return the text
     */
    public static String text(Node node) {
        StringBuilder out = new StringBuilder();
        append(node, out);
        return out.toString();
    }

    private static void append(Node node, StringBuilder out) {
        out.append('{').append(quote(node.kind()));
        Map<String, List<Object>> sorted = new TreeMap<>(node.members());
        for (Map.Entry<String, List<Object>> member : sorted.entrySet()) {
            List<Object> values = new ArrayList<>();
            for (Object value : member.getValue()) {
                // An empty container of a library says nothing; it is not part of the meaning.
                if (value instanceof Node child && child.kind().startsWith("Library ") && child.members().isEmpty()) {
                    continue;
                }
                values.add(value);
            }
            if (values.isEmpty()) {
                continue;
            }
            out.append(' ').append(member.getKey()).append(":[");
            List<String> parts = new ArrayList<>();
            for (Object value : values) {
                if (value instanceof Node child) {
                    StringBuilder inner = new StringBuilder();
                    append(child, inner);
                    parts.add(inner.toString());
                } else {
                    parts.add(quote(plainText(value)));
                }
            }
            if (node.kind().startsWith("Library ") && member.getKey().equals("def")) {
                // A container's definitions carry no order: names resolve them, not places.
                parts.sort(null);
            }
            out.append(String.join(",", parts)).append(']');
        }
        out.append('}');
    }

    /**
     * A plain value as canonical text: booleans as true or false, whole numbers as digits,
     * decimals without trailing zeros, text as itself.
     *
     * @param value the value
     * @return the text
     */
    public static String plainText(Object value) {
        if (value instanceof BigDecimal decimal) {
            return decimal.stripTrailingZeros().toPlainString();
        }
        return String.valueOf(value);
    }

    private static String quote(String text) {
        return '"' + text.replace("\\", "\\\\").replace("\"", "\\\"") + '"';
    }
}
