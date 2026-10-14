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

import dev.ikm.tinkar.common.bind.ClassConceptBinding;
import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;

import java.util.Map;

/**
 * Builds one of our trees from {@link ElmNode}s, driven by the catalog: a vertex per ELM node,
 * properties for the plain values it holds, an argument vertex between a node and each node it
 * holds, and a list reference where a position's items live in an ordered list semantic. The
 * built tree is checked against the catalog before it is returned, so a tree that does not
 * conform never exists.
 */
public final class ElmTreeBuilder {

    private final ElmCatalog catalog;

    /**
     * Creates a builder over a catalog.
     *
     * @param catalog the catalog read from the store
     */
    public ElmTreeBuilder(ElmCatalog catalog) {
        this.catalog = catalog;
    }

    /**
     * The catalog this builder is driven by.
     *
     * @return the catalog
     */
    public ElmCatalog catalog() {
        return catalog;
    }

    /**
     * Starts a node of a kind.
     *
     * @param kindName the kind's name as the schema writes it, for example {@code Retrieve}
     * @return the node, ready to hold values and nodes
     * @throws IllegalArgumentException if the catalog has no such kind
     */
    public ElmNode node(String kindName) {
        return new ElmNode(catalog.kind(kindName));
    }

    /**
     * Builds the tree under a root node and checks it against the catalog.
     *
     * @param root   the root node
     * @param treeId the identity the tree belongs to; every vertex's id is derived from it and
     *               the vertex's path, so the same tree built twice is the same tree
     * @return the tree
     * @throws ElmConformanceException if the tree does not conform to the catalog
     */
    public DiTreeEntity build(ElmNode root, PublicId treeId) {
        DiTreeEntity.Builder builder = DiTreeEntity.builder();
        EntityVertex rootVertex = add(builder, root, treeId, root.kind().name());
        builder.setRoot(rootVertex);
        DiTreeEntity tree = builder.build();
        ElmConformance.require(tree, catalog);
        return tree;
    }

    private EntityVertex add(DiTreeEntity.Builder builder, ElmNode node, PublicId treeId, String path) {
        EntityVertex vertex = EntityVertex.make(ElmIdentity.vertex(treeId, path), node.kind().concept().nid());
        for (Map.Entry<String, Object> property : node.properties().entrySet()) {
            ElmCatalog.PositionRule rule = node.kind().position(property.getKey()).orElseThrow();
            vertex.putUncommittedProperty(rule.position().nid(), stored(property.getValue()));
        }
        if (!node.properties().isEmpty()) {
            vertex.commitProperties();
        }
        builder.addVertex(vertex);
        int place = 0;
        for (ElmNode.Argument argument : node.arguments()) {
            place++;
            String argumentPath = path + "/" + argument.name() + "#" + place;
            EntityVertex argumentVertex = EntityVertex.make(ElmIdentity.vertex(treeId, argumentPath),
                    argument.position().nid());
            builder.addVertex(argumentVertex);
            builder.addEdge(argumentVertex.vertexIndex(), vertex.vertexIndex());
            EntityVertex child = add(builder, argument.child(), treeId,
                    argumentPath + "/" + argument.child().kind().name());
            builder.addEdge(child.vertexIndex(), argumentVertex.vertexIndex());
        }
        for (Map.Entry<String, PublicId> list : node.lists().entrySet()) {
            ElmCatalog.PositionRule rule = node.kind().position(list.getKey()).orElseThrow();
            EntityVertex argumentVertex = EntityVertex.make(ElmIdentity.vertex(treeId, path + "/" + list.getKey()),
                    rule.position().nid());
            argumentVertex.putUncommittedProperty(IkeTerms.ELM_LIST_ITEMS.nid(),
                    EntityProxy.Semantic.make(PrimitiveData.nid(list.getValue())));
            argumentVertex.commitProperties();
            builder.addVertex(argumentVertex);
            builder.addEdge(argumentVertex.vertexIndex(), vertex.vertexIndex());
        }
        return vertex;
    }

    /**
     * The form a value takes inside a vertex: a bound enum constant becomes its concept; other
     * values are stored as given.
     */
    private static Object stored(Object value) {
        if (value instanceof ClassConceptBinding binding) {
            return EntityProxy.Concept.make(PrimitiveData.nid(binding.publicId()));
        }
        return value;
    }
}
