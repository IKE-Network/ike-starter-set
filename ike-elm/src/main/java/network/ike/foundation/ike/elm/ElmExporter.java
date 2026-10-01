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

import dev.ikm.tinkar.common.id.IntIdList;
import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.terms.ConceptFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.model.ModelTypes;
import network.ike.foundation.ike.elm.ElmCatalog.EnumerationValue;
import network.ike.foundation.ike.elm.ElmCatalog.Form;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmDocument.Node;
import network.ike.foundation.ike.elm.ElmDocument.NodeBuilder;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Writes a library back out of the store as a document: the identity record, every active
 * definition in its container, ordered lists unfolded into their items, and roles first,
 * second, and third folded back into the operand list. Definitions within a container are
 * written in name order, since their order in a document carries no meaning.
 */
public final class ElmExporter {

    private final ElmCatalog catalog;
    private final StampCalculator calculator;
    private ModelTypes types;

    /**
     * Creates an exporter over a catalog and a view.
     *
     * @param catalog    the catalog
     * @param calculator the view that decides which versions count
     */
    public ElmExporter(ElmCatalog catalog, StampCalculator calculator) {
        this.catalog = catalog;
        this.calculator = calculator;
    }

    /**
     * Exports a library.
     *
     * @param libraryId the library's id
     * @return the document
     * @throws IllegalArgumentException if the store holds no such library
     */
    public ElmDocument export(String libraryId) {
        this.types = ModelTypes.load(calculator);
        PublicId libraryPublicId = ElmIdentity.library(libraryId);
        if (!PrimitiveData.get().hasPublicId(libraryPublicId)) {
            throw new IllegalArgumentException("The store holds no library called " + libraryId);
        }
        int libraryNid = PrimitiveData.nid(libraryPublicId);
        Node record = latestTree(PrimitiveData.nid(ElmIdentity.libraryRecord(libraryId)))
                .map(tree -> toNode(tree, tree.root()))
                .orElseThrow(() -> new IllegalArgumentException("The library " + libraryId + " has no identity record"));

        Map<String, List<Node>> byContainer = new LinkedHashMap<>();
        Map<String, String> containerOfKind = new LinkedHashMap<>();
        for (Map.Entry<String, String> container : ElmDocument.containers().entrySet()) {
            containerOfKind.put(container.getValue(), container.getKey());
        }
        EntityService.get().forEachSemanticForComponentOfPattern(libraryNid, IkeTerms.ELM_TREE_PATTERN.nid(), semantic -> {
            latestTree(semantic.nid()).ifPresent(tree -> {
                Optional<NodeKind> root = catalog.kindOf(tree.root().getMeaningNid());
                if (root.isEmpty()) {
                    return;
                }
                for (Map.Entry<String, String> entry : containerOfKind.entrySet()) {
                    if (root.get().isKindOf(catalog.kind(entry.getKey()))) {
                        byContainer.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                                .add(toNode(tree, tree.root()));
                        return;
                    }
                }
            });
        });

        NodeBuilder library = new NodeBuilder("Library");
        for (Map.Entry<String, List<Object>> member : record.members().entrySet()) {
            for (Object value : member.getValue()) {
                library.add(member.getKey(), value);
            }
        }
        for (String container : ElmDocument.containers().keySet()) {
            List<Node> definitions = byContainer.get(container);
            if (definitions == null) {
                continue;
            }
            definitions.sort(Comparator.comparing(node -> node.text("name").or(() -> node.text("localIdentifier")).orElse("")));
            NodeBuilder containerNode = new NodeBuilder("Library " + container);
            for (Node definition : definitions) {
                containerNode.add("def", definition);
            }
            library.add(container, containerNode.build());
        }
        return new ElmDocument(library.build());
    }

    private Optional<DiTreeEntity> latestTree(int semanticNid) {
        Latest<SemanticEntityVersion> latest = calculator.latest(semanticNid);
        if (latest.isAbsent()) {
            return Optional.empty();
        }
        Object field = latest.get().fieldValues().get(0);
        return field instanceof DiTreeEntity tree ? Optional.of(tree) : Optional.empty();
    }

    private Node toNode(DiTreeEntity tree, EntityVertex vertex) {
        NodeKind kind = catalog.kindOf(vertex.getMeaningNid()).orElseThrow(() ->
                new IllegalStateException("A stored vertex means a concept that is not a node kind of the catalog"));
        NodeBuilder builder = new NodeBuilder(kind.name());
        ImmutableIntList successors = tree.successors(vertex.vertexIndex());
        for (PositionRule rule : kind.positions()) {
            int positionNid = rule.position().nid();
            if (rule.form() == Form.PROPERTY) {
                if (vertex.properties().containsKey(positionNid)) {
                    Object value = vertex.properties().get(positionNid);
                    if (rule.valueType() instanceof EnumerationValue enumeration && value instanceof ConceptFacade concept) {
                        builder.add(rule.name(), enumeration.nameOf(concept.nid()).orElse(String.valueOf(concept.nid())));
                    } else if (value instanceof ConceptFacade concept) {
                        builder.add(rule.name(), ElmTypeNames.name(concept, catalog)
                                .or(() -> types.qualifiedName(concept))
                                .orElseThrow(() -> new IllegalStateException("A type-named position holds a concept"
                                        + " that is neither a System type of the catalog nor a class of a model")));
                    } else {
                        builder.add(rule.name(), value);
                    }
                }
                continue;
            }
            if (rule.isRoles()) {
                Node[] roles = new Node[3];
                for (int i = 0; i < successors.size(); i++) {
                    EntityVertex argument = tree.vertex(successors.get(i));
                    int meaning = argument.getMeaningNid();
                    int place = meaning == IkeTerms.ELM_FIRST_OPERAND_POSITION.nid() ? 0
                            : meaning == IkeTerms.ELM_SECOND_OPERAND_POSITION.nid() ? 1
                            : meaning == IkeTerms.ELM_THIRD_OPERAND_POSITION.nid() ? 2 : -1;
                    if (place >= 0) {
                        ImmutableIntList held = tree.successors(argument.vertexIndex());
                        if (!held.isEmpty()) {
                            roles[place] = toNode(tree, tree.vertex(held.get(0)));
                        }
                    }
                }
                for (Node role : roles) {
                    if (role != null) {
                        builder.add(rule.name(), role);
                    }
                }
                continue;
            }
            for (int i = 0; i < successors.size(); i++) {
                EntityVertex argument = tree.vertex(successors.get(i));
                if (argument.getMeaningNid() != positionNid) {
                    continue;
                }
                if (rule.isList()) {
                    Object list = argument.properties().get(IkeTerms.ELM_LIST_ITEMS.nid());
                    if (list instanceof EntityProxy.Semantic semantic) {
                        Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
                        if (latest.isPresent() && latest.get().fieldValues().get(0) instanceof IntIdList items) {
                            for (int j = 0; j < items.size(); j++) {
                                latestTree(items.get(j)).ifPresent(itemTree ->
                                        builder.add(rule.name(), toNode(itemTree, itemTree.root())));
                            }
                        }
                    }
                    continue;
                }
                ImmutableIntList held = tree.successors(argument.vertexIndex());
                if (!held.isEmpty()) {
                    builder.add(rule.name(), toNode(tree, tree.vertex(held.get(0))));
                }
            }
        }
        return builder.build();
    }
}
