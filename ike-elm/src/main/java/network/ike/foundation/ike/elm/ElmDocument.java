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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * An ELM library as a document, the one shape both readers produce and the exporter writes
 * (IKE-Network/ike-issues#1112). A node is its kind and its members: each member is a position
 * of the kind holding one or more values, a plain value or another node, in document order.
 * Plain values are strings, booleans, or numbers; a qualified type name is written in the
 * braces form, {@code {namespace}local}, whichever form it came from. Annotations are never
 * members: the readers drop them.
 *
 * @param library the root node, of kind {@code Library}
 */
public record ElmDocument(Node library) {

    /**
     * One ELM node.
     *
     * @param kind    the node kind as the catalog names it, for example {@code Retrieve}
     * @param members the positions filled, each with its values in document order
     */
    public record Node(String kind, Map<String, List<Object>> members) {

        /**
         * Creates a node with its members in document order.
         *
         * @param kind    the kind
         * @param members the members; copied
         */
        public Node {
            Map<String, List<Object>> copy = new LinkedHashMap<>();
            for (Map.Entry<String, List<Object>> entry : members.entrySet()) {
                copy.put(entry.getKey(), List.copyOf(entry.getValue()));
            }
            members = Collections.unmodifiableMap(copy);
        }

        /**
         * A single plain value of a member, as text.
         *
         * @param member the position's name
         * @return the value as text, or empty when the member is absent
         */
        public java.util.Optional<String> text(String member) {
            List<Object> values = members.get(member);
            if (values == null || values.isEmpty() || values.get(0) instanceof Node) {
                return java.util.Optional.empty();
            }
            return java.util.Optional.of(String.valueOf(values.get(0)));
        }

        /**
         * The nodes a member holds.
         *
         * @param member the position's name
         * @return the nodes, empty when the member is absent or holds plain values
         */
        public List<Node> nodes(String member) {
            List<Node> nodes = new ArrayList<>();
            for (Object value : members.getOrDefault(member, List.of())) {
                if (value instanceof Node node) {
                    nodes.add(node);
                }
            }
            return nodes;
        }

        /**
         * The first node a member holds.
         *
         * @param member the position's name
         * @return the node, or empty
         */
        public java.util.Optional<Node> node(String member) {
            List<Node> nodes = nodes(member);
            return nodes.isEmpty() ? java.util.Optional.empty() : java.util.Optional.of(nodes.get(0));
        }
    }

    /**
     * Builds nodes member by member, in document order.
     */
    public static final class NodeBuilder {
        private final String kind;
        private final Map<String, List<Object>> members = new LinkedHashMap<>();

        /**
         * Starts a node of a kind.
         *
         * @param kind the kind as the catalog names it
         */
        public NodeBuilder(String kind) {
            this.kind = kind;
        }

        /**
         * Adds one value to a member.
         *
         * @param member the position's name
         * @param value  a plain value or a {@link Node}
         * @return this builder
         */
        public NodeBuilder add(String member, Object value) {
            members.computeIfAbsent(member, k -> new ArrayList<>()).add(value);
            return this;
        }

        /**
         * Whether a member has been added.
         *
         * @param member the position's name
         * @return true when at least one value was added
         */
        public boolean has(String member) {
            return members.containsKey(member);
        }

        /**
         * The node.
         *
         * @return the node
         */
        public Node build() {
            return new Node(kind, members);
        }
    }

    /**
     * The nine containers of a library, in the schema's order, with the definition kind each holds.
     *
     * @return container position name to definition kind
     */
    public static Map<String, String> containers() {
        Map<String, String> containers = new LinkedHashMap<>();
        containers.put("usings", "UsingDef");
        containers.put("includes", "IncludeDef");
        containers.put("parameters", "ParameterDef");
        containers.put("codeSystems", "CodeSystemDef");
        containers.put("valueSets", "ValueSetDef");
        containers.put("codes", "CodeDef");
        containers.put("concepts", "ConceptDef");
        containers.put("contexts", "ContextDef");
        containers.put("statements", "ExpressionDef");
        return Collections.unmodifiableMap(containers);
    }

    /**
     * The definitions of the library, in document order: each with the container it came from.
     *
     * @return the definitions
     */
    public List<Definition> definitions() {
        List<Definition> definitions = new ArrayList<>();
        for (Map.Entry<String, String> container : containers().entrySet()) {
            for (Node containerNode : library.nodes(container.getKey())) {
                for (Node def : containerNode.nodes("def")) {
                    definitions.add(new Definition(container.getKey(), def));
                }
            }
        }
        return definitions;
    }

    /**
     * One definition of the library.
     *
     * @param container the container it came from, for example {@code statements}
     * @param node      the definition node, for example an ExpressionDef
     */
    public record Definition(String container, Node node) {

        /**
         * The definition's name as written: the local identifier of a using or an include, the
         * name of everything else.
         *
         * @return the name
         */
        public String name() {
            return node.text("name").or(() -> node.text("localIdentifier")).orElse("");
        }
    }
}
