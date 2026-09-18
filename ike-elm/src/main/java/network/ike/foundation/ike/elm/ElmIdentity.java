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
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;

import java.util.List;
import java.util.UUID;

/**
 * Identity for what a library becomes, derived and never random (IKE-Network/ike-issues#1110).
 * A library's seed is its id and nothing else: the CQL version string is data on its identity
 * record, so successive CQL versions become STAMP versions of the same semantics. A definition's
 * seed is its library, its kind, and its name, with operand types for an overloaded function. An
 * unnamed list item's seed is its library and what it contains. A list's seed is the definition
 * and the position path it fills. A reference's seed is the definition and what it names.
 */
public final class ElmIdentity {

    /** The type-5 namespace every ELM identity is derived under. */
    public static final UUID NAMESPACE = UUID.fromString("5f0c1c2e-6a2b-5d0e-9b1a-0e8c4b6a7d31");

    private ElmIdentity() {
    }

    /**
     * The library concept's identity.
     *
     * @param libraryId the library's id as CQL writes it, for example {@code Diabetes}
     * @return the derived public id
     */
    public static PublicId library(String libraryId) {
        return PublicIds.of(UuidT5Generator.get(NAMESPACE, "library " + libraryId));
    }

    /**
     * The library's identity record: the tree semantic whose root is the ELM Library node.
     *
     * @param libraryId the library's id
     * @return the derived public id
     */
    public static PublicId libraryRecord(String libraryId) {
        return PublicIds.of(UuidT5Generator.get(NAMESPACE, "library " + libraryId + "; record"));
    }

    /**
     * A definition semantic's identity.
     *
     * @param libraryId      the library's id
     * @param definitionKind the ELM node kind of the definition, for example {@code ExpressionDef}
     * @param name           the definition's name as written
     * @param operandTypes   the operand type names of a function definition, in order, empty otherwise
     * @return the derived public id
     */
    public static PublicId definition(String libraryId, String definitionKind, String name,
                                      List<String> operandTypes) {
        String seed = "library " + libraryId + "; " + definitionKind + " " + name;
        if (!operandTypes.isEmpty()) {
            seed = seed + " (" + String.join(", ", operandTypes) + ")";
        }
        return PublicIds.of(UuidT5Generator.get(NAMESPACE, seed));
    }

    /**
     * An unnamed list item's identity: its library and what it contains, so identical items
     * are one item and an edit makes a new one.
     *
     * @param libraryId the library's id
     * @param content   the item's content in its canonical text
     * @return the derived public id
     */
    public static PublicId item(String libraryId, String content) {
        return PublicIds.of(UuidT5Generator.get(NAMESPACE, "library " + libraryId + "; item " + content));
    }

    /**
     * An ordered list's identity: the definition it belongs to and the position path it fills.
     *
     * @param definition   the definition semantic's public id
     * @param positionPath the path of positions from the definition's root to the list, joined by slashes
     * @return the derived public id
     */
    public static PublicId list(PublicId definition, String positionPath) {
        return PublicIds.of(UuidT5Generator.get(definition.asUuidArray()[0], "list " + positionPath));
    }

    /**
     * A reference semantic's identity: the definition doing the naming and what it names.
     *
     * @param definition    the definition semantic's public id
     * @param referenceKind the ELM node kind of the reference, for example {@code ValueSetRef}
     * @param libraryName   the library name as written, empty for the same library
     * @param name          the name as written
     * @return the derived public id
     */
    public static PublicId reference(PublicId definition, String referenceKind, String libraryName, String name) {
        return PublicIds.of(UuidT5Generator.get(definition.asUuidArray()[0],
                "reference " + referenceKind + " " + libraryName + "." + name));
    }

    /**
     * A vertex's identity inside a tree: the tree's identity and the vertex's path of positions
     * and places from the root.
     *
     * @param tree the tree's public id
     * @param path the vertex's path, joined by slashes
     * @return the derived vertex UUID
     */
    public static UUID vertex(PublicId tree, String path) {
        return UuidT5Generator.get(tree.asUuidArray()[0], "vertex " + path);
    }
}
