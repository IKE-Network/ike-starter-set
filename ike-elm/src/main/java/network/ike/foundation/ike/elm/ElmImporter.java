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
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.elm.ElmCatalog.EnumerationValue;
import network.ike.foundation.ike.elm.ElmCatalog.Form;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmCatalog.PrimitiveValue;
import network.ike.foundation.ike.elm.ElmDocument.Definition;
import network.ike.foundation.ike.elm.ElmDocument.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

/**
 * Imports an ELM library document into the running store (IKE-Network/ike-issues#1112): the
 * library concept, one definition semantic per definition, ordered lists where order carries
 * meaning, and a reference semantic for every distinct thing a definition names. Every name is
 * resolved before anything is written; an unresolvable name stops the import with its place
 * named. Importing the same document again writes nothing; a changed document appends
 * versions where it changed and retires what it dropped.
 */
public final class ElmImporter {

    /**
     * What an import did.
     *
     * @param libraryId           the library's id
     * @param library             the library concept's public id
     * @param definitions         how many definitions the document holds
     * @param references          how many distinct references were recorded
     * @param items               how many list items were recorded
     * @param lists               how many ordered lists were recorded
     * @param unresolvedTypeNames every type name met, as written; the worklist for the data type pass
     * @param counts              what the writer did: written, unchanged, versioned, retired
     */
    public record Report(String libraryId, PublicId library, int definitions, int references, int items, int lists,
                         Set<String> unresolvedTypeNames, ElmLibraryWriter.Counts counts) {
    }

    /** Reference node kind to the definition kind it names. */
    static final Map<String, String> REFERENCE_KINDS = Map.of(
            "ExpressionRef", "ExpressionDef",
            "FunctionRef", "FunctionDef",
            "ParameterRef", "ParameterDef",
            "ValueSetRef", "ValueSetDef",
            "CodeSystemRef", "CodeSystemDef",
            "CodeRef", "CodeDef",
            "ConceptRef", "ConceptDef");

    private final ElmCatalog catalog;
    private final StampCalculator calculator;
    private ElmLibraryWriter writer;

    /**
     * Creates an importer over a catalog and a view.
     *
     * @param catalog    the catalog
     * @param calculator the view that decides which existing versions count
     */
    public ElmImporter(ElmCatalog catalog, StampCalculator calculator) {
        this.catalog = catalog;
        this.calculator = calculator;
    }

    /**
     * Imports a document under a stamp. The store keeps one version per stamp, so each import
     * that should leave its own mark carries its own stamp; an import under an earlier stamp
     * replaces that stamp's versions rather than appending.
     *
     * @param document the library document
     * @param stamp    the stamp every new version is written under
     * @return what was done
     * @throws ElmImportException if a name cannot be resolved or an included library is missing;
     *                            nothing has been written
     */
    public Report importDocument(ElmDocument document, Stamp stamp) {
        this.writer = new ElmLibraryWriter(new ElmTreeBuilder(catalog), calculator, stamp);
        Node library = document.library();
        Node identifier = library.node("identifier").orElseThrow(() ->
                new ElmImportException(List.of("library: the document names no identifier")));
        String libraryId = identifier.text("id").orElseThrow(() ->
                new ElmImportException(List.of("library/identifier: the identifier has no id")));
        String version = identifier.text("version").orElse("");
        String system = identifier.text("system").orElse("");

        List<Definition> definitions = document.definitions();
        Map<Definition, PublicId> ids = new LinkedHashMap<>();
        Map<String, Map<String, List<Definition>>> byKindAndName = new HashMap<>();
        for (Definition definition : definitions) {
            ids.put(definition, ElmIdentity.definition(libraryId, definition.node().kind(), definition.name(),
                    operandTypes(definition.node())));
            byKindAndName.computeIfAbsent(definition.node().kind(), k -> new HashMap<>())
                    .computeIfAbsent(definition.name(), k -> new ArrayList<>()).add(definition);
        }
        Map<String, Node> includesByLocalName = new HashMap<>();
        for (Definition definition : definitions) {
            if (definition.node().kind().equals("IncludeDef")) {
                includesByLocalName.put(definition.name(), definition.node());
            }
        }

        // Resolve every reference before writing anything.
        List<String> problems = new ArrayList<>();
        Map<Definition, Map<ReferenceKey, PublicId>> resolved = new LinkedHashMap<>();
        for (Definition definition : definitions) {
            Map<ReferenceKey, PublicId> targets = new LinkedHashMap<>();
            collectReferences(definition.node(), definition.container() + "/def " + definition.name(),
                    libraryId, definition, byKindAndName, includesByLocalName, targets, problems);
            resolved.put(definition, targets);
        }
        if (!problems.isEmpty()) {
            throw new ElmImportException(problems);
        }

        // Write.
        Set<String> typeNames = new TreeSet<>();
        int[] itemCount = {0};
        int[] listCount = {0};
        PublicId libraryPublicId = writer.library(libraryId, version, system);
        Set<PublicId> imported = new HashSet<>();
        imported.add(ElmIdentity.libraryRecord(libraryId));
        int referenceCount = 0;
        for (Definition definition : definitions) {
            PublicId definitionId = ids.get(definition);
            ElmNode root = toElm(definition.node(), definition.node().kind(), definitionId, libraryId, typeNames,
                    itemCount, listCount);
            writer.definition(libraryId, root, definition.name(), operandTypes(definition.node()));
            imported.add(definitionId);
            for (Map.Entry<ReferenceKey, PublicId> reference : resolved.get(definition).entrySet()) {
                writer.reference(definitionId, reference.getKey().kind(), reference.getValue(),
                        reference.getKey().name(), reference.getKey().libraryName());
                referenceCount++;
            }
        }
        retireVanished(libraryPublicId, imported);
        return new Report(libraryId, libraryPublicId, definitions.size(), referenceCount, itemCount[0], listCount[0],
                Collections.unmodifiableSet(typeNames), writer.counts());
    }

    /** One thing a definition names, as written. */
    record ReferenceKey(String kind, String libraryName, String name) {
    }

    private void collectReferences(Node node, String path, String libraryId, Definition definition,
                                   Map<String, Map<String, List<Definition>>> byKindAndName,
                                   Map<String, Node> includesByLocalName, Map<ReferenceKey, PublicId> targets,
                                   List<String> problems) {
        String definitionKind = REFERENCE_KINDS.get(node.kind());
        if (definitionKind != null) {
            String name = node.text("name").orElse("");
            String libraryName = node.text("libraryName").orElse("");
            ReferenceKey key = new ReferenceKey(node.kind(), libraryName, name);
            if (!targets.containsKey(key)) {
                Optional<PublicId> target = resolve(node, definitionKind, name, libraryName, libraryId, byKindAndName,
                        includesByLocalName, path, problems);
                target.ifPresent(id -> targets.put(key, id));
            }
        }
        for (Map.Entry<String, List<Object>> member : node.members().entrySet()) {
            int index = 0;
            for (Object value : member.getValue()) {
                index++;
                if (value instanceof Node child) {
                    collectReferences(child, path + "/" + member.getKey() + "[" + index + "]", libraryId, definition,
                            byKindAndName, includesByLocalName, targets, problems);
                }
            }
        }
    }

    private Optional<PublicId> resolve(Node reference, String definitionKind, String name, String libraryName,
                                       String libraryId, Map<String, Map<String, List<Definition>>> byKindAndName,
                                       Map<String, Node> includesByLocalName, String path, List<String> problems) {
        List<String> signature = signatureTypes(reference);
        if (libraryName.isEmpty()) {
            List<Definition> candidates = byKindAndName.getOrDefault(definitionKind, Map.of())
                    .getOrDefault(name, List.of());
            if (definitionKind.equals("FunctionDef") && !signature.isEmpty()) {
                for (Definition candidate : candidates) {
                    if (operandTypes(candidate.node()).equals(signature)) {
                        return Optional.of(ElmIdentity.definition(libraryId, definitionKind, name, signature));
                    }
                }
                problems.add(path + ": no function " + name + " takes (" + String.join(", ", signature) + ")");
                return Optional.empty();
            }
            if (candidates.size() == 1) {
                return Optional.of(ElmIdentity.definition(libraryId, definitionKind, name,
                        operandTypes(candidates.get(0).node())));
            }
            if (candidates.isEmpty()) {
                problems.add(path + ": " + reference.kind() + " names " + name + ", and this library has no "
                        + definitionKind + " of that name");
            } else {
                problems.add(path + ": " + reference.kind() + " names " + name + " without a signature, and this"
                        + " library has " + candidates.size() + " functions of that name");
            }
            return Optional.empty();
        }
        Node include = includesByLocalName.get(libraryName);
        if (include == null) {
            problems.add(path + ": " + reference.kind() + " names " + libraryName + "." + name + ", and this library"
                    + " includes no library called " + libraryName);
            return Optional.empty();
        }
        String includedId = include.text("path").orElse("");
        if (!PrimitiveData.get().hasPublicId(ElmIdentity.library(includedId))) {
            problems.add(path + ": " + reference.kind() + " names " + libraryName + "." + name + ", and the included"
                    + " library " + includedId + " is not in the store; import it first");
            return Optional.empty();
        }
        PublicId target = ElmIdentity.definition(includedId, definitionKind, name, signature);
        if (!PrimitiveData.get().hasPublicId(target)) {
            problems.add(path + ": " + reference.kind() + " names " + libraryName + "." + name + ", and the library "
                    + includedId + " in the store has no " + definitionKind + " of that name"
                    + (signature.isEmpty() ? "" : " taking (" + String.join(", ", signature) + ")"));
            return Optional.empty();
        }
        return Optional.of(target);
    }

    /**
     * A function definition's operand types, as written: the operand type name, or the canonical
     * text of its type specifier.
     */
    static List<String> operandTypes(Node definition) {
        if (!definition.kind().equals("FunctionDef")) {
            return List.of();
        }
        List<String> types = new ArrayList<>();
        for (Node operand : definition.nodes("operand")) {
            types.add(operand.text("operandType")
                    .or(() -> operand.node("operandTypeSpecifier").map(ElmImporter::typeText))
                    .orElse(""));
        }
        return types;
    }

    /** A function reference's written signature, as operand types. */
    static List<String> signatureTypes(Node reference) {
        List<String> types = new ArrayList<>();
        for (Node specifier : reference.nodes("signature")) {
            types.add(typeText(specifier));
        }
        return types;
    }

    private static String typeText(Node specifier) {
        if (specifier.kind().equals("NamedTypeSpecifier")) {
            return specifier.text("name").orElse(ElmCanonical.text(specifier));
        }
        return ElmCanonical.text(specifier);
    }

    private ElmNode toElm(Node node, String path, PublicId definitionId, String libraryId, Set<String> typeNames,
                          int[] itemCount, int[] listCount) {
        ElmNode elm = writer.builder().node(node.kind());
        NodeKind kind = elm.kind();
        for (Map.Entry<String, List<Object>> member : node.members().entrySet()) {
            String name = member.getKey();
            PositionRule rule = kind.position(name).orElseThrow(() -> new ElmImportException(List.of(
                    path + ": " + kind.name() + " has no position named " + name)));
            List<Object> values = member.getValue();
            if (rule.form() == Form.PROPERTY) {
                Object value = values.get(0);
                if (rule.valueType() instanceof EnumerationValue enumeration) {
                    String text = String.valueOf(value);
                    EntityProxy.Concept concept = enumeration.value(text).orElseThrow(() -> new ElmImportException(
                            List.of(path + ": " + kind.name() + "'s " + name + " is " + text + ", which is not a value of"
                                    + " its enumeration")));
                    elm.property(name, concept);
                } else {
                    if (rule.valueType() instanceof PrimitiveValue primitive && primitive.name().equals("QName")) {
                        typeNames.add(String.valueOf(value));
                    }
                    elm.property(name, value);
                }
                continue;
            }
            List<Node> children = node.nodes(name);
            String childPath = path + "/" + name;
            if (rule.isRoles()) {
                if (children.size() > 0) {
                    elm.first(toElm(children.get(0), childPath + "[1]", definitionId, libraryId, typeNames, itemCount, listCount));
                }
                if (children.size() > 1) {
                    elm.second(toElm(children.get(1), childPath + "[2]", definitionId, libraryId, typeNames, itemCount, listCount));
                }
                if (children.size() > 2) {
                    elm.third(toElm(children.get(2), childPath + "[3]", definitionId, libraryId, typeNames, itemCount, listCount));
                }
                continue;
            }
            if (rule.isList()) {
                List<PublicId> items = new ArrayList<>();
                for (Node child : children) {
                    // An item is identified by its content, and everything inside it, including
                    // any list of its own, hangs from that identity, not from the definition's.
                    String content = ElmCanonical.text(child);
                    PublicId itemId = ElmIdentity.item(libraryId, content);
                    ElmNode item = toElm(child, child.kind(), itemId, libraryId, typeNames, itemCount, listCount);
                    items.add(writer.item(libraryId, item, content));
                    itemCount[0]++;
                }
                elm.list(name, writer.orderedList(definitionId, childPath, items));
                listCount[0]++;
                continue;
            }
            for (Node child : children) {
                elm.edge(name, toElm(child, childPath, definitionId, libraryId, typeNames, itemCount, listCount));
            }
        }
        return elm;
    }

    private void retireVanished(PublicId libraryPublicId, Set<PublicId> imported) {
        int libraryNid = PrimitiveData.nid(libraryPublicId);
        List<PublicId> vanished = new ArrayList<>();
        EntityService.get().forEachSemanticForComponentOfPattern(libraryNid, IkeTerms.ELM_TREE_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isAbsent()) {
                return;
            }
            DiTreeEntity tree = (DiTreeEntity) latest.get().fieldValues().get(0);
            Optional<NodeKind> root = catalog.kindOf(tree.root().getMeaningNid());
            if (root.isPresent() && isDefinitionKind(root.get()) && !imported.contains(semantic.publicId())) {
                vanished.add(semantic.publicId());
            }
        });
        for (PublicId id : vanished) {
            writer.retire(id);
        }
    }

    private boolean isDefinitionKind(NodeKind kind) {
        for (String definitionKind : new LinkedHashSet<>(ElmDocument.containers().values())) {
            if (kind.isKindOf(catalog.kind(definitionKind))) {
                return true;
            }
        }
        return false;
    }
}
