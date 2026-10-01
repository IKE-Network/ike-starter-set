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
package network.ike.foundation.ike.evaluate;

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.terms.EntityFacade;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.elm.ElmCatalog;
import network.ike.foundation.ike.elm.ElmIdentity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A library as the store holds it, read for evaluation: its definitions by kind and name, each
 * a stored tree, the references each definition makes, the libraries it includes by their local
 * names, and the models it declares.
 */
final class Library {

    /**
     * One definition.
     *
     * @param nid  the definition semantic's nid
     * @param kind the definition's node kind, ExpressionDef and the rest
     * @param name its name, or its local identifier for a using or an include
     * @param root the root of its tree
     */
    record Definition(int nid, String kind, String name, TreeNode root) {
    }

    /**
     * One thing a definition names, as written.
     *
     * @param kind        the naming node's kind
     * @param libraryName the library name as written, empty for the same library
     * @param name        the name as written
     */
    record ReferenceKey(String kind, String libraryName, String name) {
    }

    private final String id;
    private final int nid;
    private final Map<String, Map<String, Definition>> definitions = new LinkedHashMap<>();
    private final List<Definition> inOrder = new ArrayList<>();
    private final Map<Integer, Map<ReferenceKey, Integer>> references = new HashMap<>();
    private final StampCalculator calculator;
    private final ElmCatalog catalog;

    private Library(String id, int nid, StampCalculator calculator, ElmCatalog catalog) {
        this.id = id;
        this.nid = nid;
        this.calculator = calculator;
        this.catalog = catalog;
    }

    /**
     * Reads a library from the store.
     *
     * @param libraryId  the library's id
     * @param calculator the view
     * @param catalog    the catalog
     * @return the library, or empty when the store holds none by that id
     */
    static Optional<Library> load(String libraryId, StampCalculator calculator, ElmCatalog catalog) {
        PublicId libraryPublicId = ElmIdentity.library(libraryId);
        if (!PrimitiveData.get().hasPublicId(libraryPublicId)
                || EntityService.get().getEntity(PrimitiveData.nid(libraryPublicId)).isEmpty()) {
            return Optional.empty();
        }
        Library library = new Library(libraryId, PrimitiveData.nid(libraryPublicId), calculator, catalog);
        int recordNid = PrimitiveData.get().hasPublicId(ElmIdentity.libraryRecord(libraryId))
                ? PrimitiveData.nid(ElmIdentity.libraryRecord(libraryId)) : Integer.MIN_VALUE;
        EntityService.get().forEachSemanticForComponentOfPattern(library.nid, IkeTerms.ELM_TREE_PATTERN.nid(), semantic -> {
            if (semantic.nid() == recordNid) {
                return;
            }
            TreeNode.root(semantic.nid(), catalog, calculator).ifPresent(root -> {
                String name = root.text("name").or(() -> root.text("localIdentifier")).orElse("");
                Definition definition = new Definition(semantic.nid(), root.kindName(), name, root);
                library.definitions.computeIfAbsent(root.kindName(), key -> new LinkedHashMap<>()).put(name, definition);
                library.inOrder.add(definition);
            });
        });
        return Optional.of(library);
    }

    String id() {
        return id;
    }

    /** The definitions of one kind, by name. */
    Map<String, Definition> definitions(String kind) {
        return definitions.getOrDefault(kind, Map.of());
    }

    /** Every definition, in the order the store gave them. */
    List<Definition> definitions() {
        return inOrder;
    }

    Optional<Definition> definition(String kind, String name) {
        return Optional.ofNullable(definitions(kind).get(name));
    }

    /** What a definition names, resolved when the library was imported. */
    Map<ReferenceKey, Integer> referencesOf(Definition definition) {
        return references.computeIfAbsent(definition.nid(), nid -> {
            Map<ReferenceKey, Integer> found = new HashMap<>();
            EntityService.get().forEachSemanticForComponentOfPattern(nid, IkeTerms.ELM_REFERENCE_PATTERN.nid(), semantic -> {
                Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
                if (latest.isPresent()) {
                    int kindNid = ((EntityFacade) latest.get().fieldValues().get(0)).nid();
                    String kind = catalog.kindOf(kindNid).map(ElmCatalog.NodeKind::name).orElse("");
                    found.put(new ReferenceKey(kind, (String) latest.get().fieldValues().get(3),
                            (String) latest.get().fieldValues().get(2)), ((EntityFacade) latest.get().fieldValues().get(1)).nid());
                }
            });
            return found;
        });
    }

    /** The definition a stored semantic nid identifies. */
    Optional<Definition> definitionAt(int definitionNid) {
        for (Definition definition : inOrder) {
            if (definition.nid() == definitionNid) {
                return Optional.of(definition);
            }
        }
        return Optional.empty();
    }

    /** The library id an include's local name stands for. */
    Optional<String> includedLibraryId(String localName) {
        return definition("IncludeDef", localName).flatMap(include -> include.root().text("path"));
    }

    /** The using declaration for a model url, as (local identifier, version). */
    Optional<String[]> usingFor(String url) {
        for (Definition using : definitions("UsingDef").values()) {
            if (using.root().text("uri").orElse("").equals(url)) {
                return Optional.of(new String[] {using.name(), using.root().text("version").orElse("")});
            }
        }
        return Optional.empty();
    }
}
