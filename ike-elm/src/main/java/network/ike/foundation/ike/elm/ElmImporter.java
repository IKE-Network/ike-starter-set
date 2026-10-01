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
import network.ike.foundation.ike.model.ModelTypes;
import network.ike.foundation.ike.ucum.UcumSyntaxException;
import network.ike.foundation.ike.ucum.UcumTerm;
import network.ike.foundation.ike.ucum.UcumUnits;
import network.ike.foundation.ike.writer.StoreWriter;
import network.ike.foundation.ike.elm.ElmCatalog.EnumerationValue;
import network.ike.foundation.ike.elm.ElmCatalog.Form;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmCatalog.PrimitiveValue;
import network.ike.foundation.ike.elm.ElmDocument.Definition;
import network.ike.foundation.ike.elm.ElmDocument.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Imports an ELM library document into the running store (IKE-Network/ike-issues#1112): the
 * library concept, one definition semantic per definition, ordered lists where order carries
 * meaning, and a reference semantic for every distinct thing a definition names, a quantity's
 * unit among them: a CQL calendar word means IKE's unit of time, a UCUM code the unit's own
 * concept or a composed unit made on demand (IKE-Network/ike-issues#1114). Every name is
 * resolved before anything is written; an unresolvable name, or a unit code that cannot be
 * read, stops the import with its place named. Importing the same document again writes
 * nothing; a changed document appends versions where it changed and retires what it dropped.
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
     * @param propertyPaths       how many paths keep their text, the property accesses and the retrieve
     *                            paths that walk through a reference, the worklist for the evaluation
     *                            step's type inference
     * @param counts              what the writer did: written, unchanged, versioned, retired
     */
    public record Report(String libraryId, PublicId library, int definitions, int references, int items, int lists,
                         int propertyPaths, StoreWriter.Counts counts) {
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

    /** A CQL calendar word, singular or plural, to IKE's unit of time. */
    static final Map<String, EntityProxy.Concept> CALENDAR_UNITS = Map.ofEntries(
            Map.entry("year", IkeTerms.YEAR), Map.entry("years", IkeTerms.YEAR),
            Map.entry("month", IkeTerms.MONTH), Map.entry("months", IkeTerms.MONTH),
            Map.entry("week", IkeTerms.WEEK), Map.entry("weeks", IkeTerms.WEEK),
            Map.entry("day", IkeTerms.DAY), Map.entry("days", IkeTerms.DAY),
            Map.entry("hour", IkeTerms.HOUR), Map.entry("hours", IkeTerms.HOUR),
            Map.entry("minute", IkeTerms.MINUTE), Map.entry("minutes", IkeTerms.MINUTE),
            Map.entry("second", IkeTerms.SECOND), Map.entry("seconds", IkeTerms.SECOND),
            Map.entry("millisecond", IkeTerms.MILLISECOND), Map.entry("milliseconds", IkeTerms.MILLISECOND));

    private final ElmCatalog catalog;
    private final StampCalculator calculator;
    private ElmLibraryWriter writer;
    private UcumUnits units;
    private final Map<String, UcumTerm> pendingUnits = new LinkedHashMap<>();
    private ModelTypes types;
    private final Map<String, EntityProxy.Concept> typeConcepts = new HashMap<>();
    private int propertyPaths;
    private int unwalkedPaths;

    /** A using declaration: the model's name as the library calls it and the version it names. */
    private record Using(String localIdentifier, String version) {
    }

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
        this.units = UcumUnits.load(calculator);
        this.pendingUnits.clear();
        this.types = ModelTypes.load(calculator);
        this.typeConcepts.clear();
        this.propertyPaths = 0;
        this.unwalkedPaths = 0;
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

        // Resolve every type name, then every reference, before writing anything.
        List<String> problems = new ArrayList<>();
        Map<String, Using> usings = new HashMap<>();
        for (Definition definition : definitions) {
            if (definition.node().kind().equals("UsingDef")) {
                usings.put(definition.node().text("uri").orElse(""),
                        new Using(definition.name(), definition.node().text("version").orElse("")));
            }
        }
        for (Definition definition : definitions) {
            collectTypeNames(definition.node(), definition.container() + "/def " + definition.name(), usings, problems);
        }
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
        int[] itemCount = {0};
        int[] listCount = {0};
        PublicId libraryPublicId = writer.library(libraryId, version, system);
        for (UcumTerm unit : pendingUnits.values()) {
            units.write(unit, writer.store());
        }
        Set<PublicId> imported = new HashSet<>();
        imported.add(ElmIdentity.libraryRecord(libraryId));
        int referenceCount = 0;
        for (Definition definition : definitions) {
            PublicId definitionId = ids.get(definition);
            ElmNode root = toElm(definition.node(), definition.node().kind(), definitionId, libraryId,
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
                propertyPaths + unwalkedPaths, writer.counts());
    }

    /** One thing a definition names, as written. */
    record ReferenceKey(String kind, String libraryName, String name) {
    }

    /**
     * Walks a definition for every type name it writes, resolving each to a concept, and counts
     * the property accesses whose paths stay as text.
     */
    private void collectTypeNames(Node node, String path, Map<String, Using> usings, List<String> problems) {
        NodeKind kind = catalog.kind(node.kind());
        for (Map.Entry<String, List<Object>> member : node.members().entrySet()) {
            Optional<PositionRule> rule = kind.position(member.getKey());
            if (rule.isPresent() && rule.get().form() == Form.PROPERTY
                    && rule.get().valueType() instanceof PrimitiveValue primitive && primitive.name().equals("QName")) {
                resolveTypeName(String.valueOf(member.getValue().get(0)), path + "/" + member.getKey(), usings, problems);
            }
            for (Object value : member.getValue()) {
                if (value instanceof Node child) {
                    collectTypeNames(child, path + "/" + member.getKey(), usings, problems);
                }
            }
        }
        if (node.kind().equals("Property") && node.text("path").isPresent()) {
            propertyPaths++;
        }
    }

    /**
     * A type name resolves in three steps: its url finds the library's using declaration, name
     * and version find the model, and the model and the local name find the class. A System type
     * is the catalog's concept. Each failure is a problem naming the place.
     */
    private void resolveTypeName(String text, String place, Map<String, Using> usings, List<String> problems) {
        if (typeConcepts.containsKey(text)) {
            return;
        }
        Optional<EntityProxy.Concept> system = ElmTypeNames.systemType(text, catalog);
        if (system.isPresent()) {
            typeConcepts.put(text, system.get());
            return;
        }
        int close = text.indexOf('}');
        if (!text.startsWith("{") || close < 0) {
            problems.add(place + ": " + text + " is not a qualified type name");
            return;
        }
        String url = text.substring(1, close);
        String local = text.substring(close + 1);
        Using using = usings.get(url);
        if (using == null) {
            problems.add(place + " names " + text + ", and the library declares no using for " + url);
            return;
        }
        Optional<ModelTypes.Model> model;
        if (using.version().isEmpty()) {
            List<ModelTypes.Model> versions = types.versionsOf(using.localIdentifier());
            if (versions.size() == 1) {
                model = Optional.of(versions.get(0));
            } else if (versions.isEmpty()) {
                problems.add(place + " names " + text + ", and the store holds no model " + using.localIdentifier()
                        + "; import it first");
                return;
            } else {
                List<String> found = new ArrayList<>();
                for (ModelTypes.Model version : versions) {
                    found.add(version.name() + " " + version.version());
                }
                problems.add(place + " names " + text + ", the library declares no version for " + using.localIdentifier()
                        + ", and the store holds " + String.join(", ", found) + "; name one");
                return;
            }
        } else {
            model = types.model(using.localIdentifier(), using.version());
            if (model.isEmpty()) {
                problems.add(place + " names " + text + ", and the store holds no " + using.localIdentifier() + " "
                        + using.version() + "; import it first");
                return;
            }
        }
        Optional<ModelTypes.ClassEntry> entry = types.classOf(model.get(), local);
        if (entry.isEmpty()) {
            problems.add(place + " names " + text + ", and " + model.get().name()
                    + (model.get().version().isEmpty() ? "" : " " + model.get().version()) + " has no class " + local);
            return;
        }
        typeConcepts.put(text, EntityProxy.Concept.make(entry.get().nid()));
    }

    /**
     * A retrieve's code and date paths resolve to the elements they name on the class the retrieve
     * resolved. A dotted path is walked element by element while each step's element names one
     * class; a path that walks through a reference, as QUICK's medication.code does, cannot be
     * followed by structure alone, stays as written, and is counted with the property paths for
     * the evaluation step. A first segment the class does not have is refused with its place.
     */
    private void collectRetrievePaths(Node node, String path, Map<ReferenceKey, PublicId> targets, List<String> problems) {
        Optional<String> dataType = node.text("dataType");
        if (dataType.isEmpty() || !typeConcepts.containsKey(dataType.get())) {
            return;
        }
        int classNid = typeConcepts.get(dataType.get()).nid();
        for (String position : List.of("codeProperty", "dateProperty", "dateLowProperty", "dateHighProperty")) {
            Optional<String> written = node.text(position);
            if (written.isEmpty()) {
                continue;
            }
            ReferenceKey key = new ReferenceKey("Retrieve", dataType.get(), written.get());
            if (targets.containsKey(key)) {
                continue;
            }
            String[] segments = written.get().split("\\.");
            int current = classNid;
            PublicId element = null;
            boolean walked = true;
            for (int i = 0; i < segments.length && walked; i++) {
                Optional<PublicId> found = types.element(current, segments[i]);
                if (found.isEmpty()) {
                    if (i == 0) {
                        problems.add(path + ": Retrieve of " + dataType.get() + " names " + position + " " + written.get()
                                + ", and the class has no element " + segments[i]);
                        return;
                    }
                    walked = false;
                    break;
                }
                element = found.get();
                if (i < segments.length - 1) {
                    Optional<Integer> next = types.elementClass(element);
                    if (next.isEmpty()) {
                        walked = false;
                    } else {
                        current = next.get();
                    }
                }
            }
            if (walked) {
                targets.put(key, element);
            } else {
                unwalkedPaths++;
            }
        }
    }

    private void collectReferences(Node node, String path, String libraryId, Definition definition,
                                   Map<String, Map<String, List<Definition>>> byKindAndName,
                                   Map<String, Node> includesByLocalName, Map<ReferenceKey, PublicId> targets,
                                   List<String> problems) {
        if (node.kind().equals("Retrieve")) {
            collectRetrievePaths(node, path, targets, problems);
        }
        if (node.kind().equals("Quantity")) {
            Optional<String> unit = node.text("unit");
            if (unit.isPresent()) {
                ReferenceKey key = new ReferenceKey("Quantity", "", unit.get());
                if (!targets.containsKey(key)) {
                    resolveUnit(unit.get(), path, problems).ifPresent(id -> targets.put(key, id));
                }
            }
        }
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

    /**
     * A quantity's unit: a CQL calendar word, singular or plural, means IKE's unit of time;
     * anything else is a UCUM code, read against the units in the store, an atom's own concept
     * or a composed unit made when the library is written.
     */
    private Optional<PublicId> resolveUnit(String unit, String path, List<String> problems) {
        EntityProxy.Concept calendar = CALENDAR_UNITS.get(unit);
        if (calendar != null) {
            return Optional.of(calendar.publicId());
        }
        if (units.isEmpty()) {
            problems.add(path + ": Quantity's unit " + unit + " is a UCUM code, and the store holds no UCUM units;"
                    + " import UCUM first");
            return Optional.empty();
        }
        try {
            UcumTerm term = units.parse(unit);
            pendingUnits.putIfAbsent(term.canonicalCode(), term);
            return Optional.of(units.identity(term));
        } catch (UcumSyntaxException refused) {
            problems.add(path + ": Quantity's unit cannot be read: " + refused.getMessage());
            return Optional.empty();
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

    private ElmNode toElm(Node node, String path, PublicId definitionId, String libraryId,
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
                } else if (rule.valueType() instanceof PrimitiveValue primitive && primitive.name().equals("QName")) {
                    // Every type name was resolved before writing: a System type to the catalog's
                    // concept, a data model's type to its class concept.
                    String text = String.valueOf(value);
                    EntityProxy.Concept concept = typeConcepts.get(text);
                    if (concept == null) {
                        throw new ElmImportException(List.of(path + ": " + text + " was not resolved before writing"));
                    }
                    elm.property(name, concept);
                } else {
                    elm.property(name, value);
                }
                continue;
            }
            List<Node> children = node.nodes(name);
            String childPath = path + "/" + name;
            if (rule.isRoles()) {
                if (children.size() > 0) {
                    elm.first(toElm(children.get(0), childPath + "[1]", definitionId, libraryId, itemCount, listCount));
                }
                if (children.size() > 1) {
                    elm.second(toElm(children.get(1), childPath + "[2]", definitionId, libraryId, itemCount, listCount));
                }
                if (children.size() > 2) {
                    elm.third(toElm(children.get(2), childPath + "[3]", definitionId, libraryId, itemCount, listCount));
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
                    ElmNode item = toElm(child, child.kind(), itemId, libraryId, itemCount, listCount);
                    items.add(writer.item(libraryId, item, content));
                    itemCount[0]++;
                }
                elm.list(name, writer.orderedList(definitionId, childPath, items));
                listCount[0]++;
                continue;
            }
            for (Node child : children) {
                elm.edge(name, toElm(child, childPath, definitionId, libraryId, itemCount, listCount));
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
