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
package network.ike.foundation.ike.model;

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.model.ModelInfoFile.TypeSpecifier;

import java.util.Optional;
import java.util.function.Function;

/**
 * An element's type held as the same small tree a library's type specifier is held as: the
 * vertices are the catalog's named, list, interval, and choice type specifier kinds, each
 * position an argument vertex as in a library's tree, and each named type the class concept
 * it resolves to, or the name as written when it resolves to nothing. A choice's alternatives
 * are the children of its choice position, a set, since a choice has no order.
 */
final class ModelTypeTrees {

    private ModelTypeTrees() {
    }

    /**
     * Builds the tree of a type specifier.
     *
     * @param type      the type as the file gives it
     * @param elementId the element record the tree belongs to, the root of every vertex identity
     * @param resolve   what a qualified name means, empty when it means nothing in the store
     * @return the tree
     */
    static DiTreeEntity build(TypeSpecifier type, PublicId elementId,
                              Function<String, Optional<EntityProxy.Concept>> resolve) {
        DiTreeEntity.Builder builder = DiTreeEntity.builder();
        EntityVertex root = add(builder, type, elementId, "type", resolve);
        builder.setRoot(root);
        return builder.build();
    }

    private static EntityVertex add(DiTreeEntity.Builder builder, TypeSpecifier type, PublicId elementId, String path,
                                    Function<String, Optional<EntityProxy.Concept>> resolve) {
        switch (type.form()) {
            case NAMED: {
                EntityVertex vertex = EntityVertex.make(ModelIdentity.vertex(elementId, path),
                        IkeTerms.ELM_NAMEDTYPESPECIFIER.nid());
                Object value = resolve.apply(type.name()).map(concept -> (Object) concept).orElse(type.name());
                vertex.putUncommittedProperty(IkeTerms.ELM_NAME_POSITION.nid(), value);
                vertex.commitProperties();
                builder.addVertex(vertex);
                return vertex;
            }
            case LIST:
                return held(builder, IkeTerms.ELM_LISTTYPESPECIFIER, IkeTerms.ELM_ELEMENTTYPE_POSITION, "elementType",
                        type, elementId, path, resolve);
            case INTERVAL:
                return held(builder, IkeTerms.ELM_INTERVALTYPESPECIFIER, IkeTerms.ELM_POINTTYPE_POSITION, "pointType",
                        type, elementId, path, resolve);
            default: {
                EntityVertex vertex = EntityVertex.make(ModelIdentity.vertex(elementId, path),
                        IkeTerms.ELM_CHOICETYPESPECIFIER.nid());
                builder.addVertex(vertex);
                EntityVertex argument = EntityVertex.make(ModelIdentity.vertex(elementId, path + "/choice"),
                        IkeTerms.ELM_CHOICE_POSITION.nid());
                builder.addVertex(argument);
                builder.addEdge(argument.vertexIndex(), vertex.vertexIndex());
                int index = 0;
                for (TypeSpecifier alternative : type.choices()) {
                    index++;
                    EntityVertex child = add(builder, alternative, elementId, path + "/choice/" + index, resolve);
                    builder.addEdge(child.vertexIndex(), argument.vertexIndex());
                }
                return vertex;
            }
        }
    }

    private static EntityVertex held(DiTreeEntity.Builder builder, EntityProxy.Concept kind, EntityProxy.Concept position,
                                     String positionName, TypeSpecifier type, PublicId elementId, String path,
                                     Function<String, Optional<EntityProxy.Concept>> resolve) {
        EntityVertex vertex = EntityVertex.make(ModelIdentity.vertex(elementId, path), kind.nid());
        builder.addVertex(vertex);
        EntityVertex argument = EntityVertex.make(ModelIdentity.vertex(elementId, path + "/" + positionName), position.nid());
        builder.addVertex(argument);
        builder.addEdge(argument.vertexIndex(), vertex.vertexIndex());
        EntityVertex child = add(builder, type.inner(), elementId, path + "/" + positionName + "/type", resolve);
        builder.addEdge(child.vertexIndex(), argument.vertexIndex());
        return vertex;
    }
}
