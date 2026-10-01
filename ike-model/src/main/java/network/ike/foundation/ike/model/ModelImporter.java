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
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.model.ModelInfoFile.ClassInfo;
import network.ike.foundation.ike.model.ModelInfoFile.Context;
import network.ike.foundation.ike.model.ModelInfoFile.Conversion;
import network.ike.foundation.ike.model.ModelInfoFile.Element;
import network.ike.foundation.ike.model.ModelInfoFile.Relationship;
import network.ike.foundation.ike.model.ModelInfoFile.Requirement;
import network.ike.foundation.ike.model.ModelInfoFile.TypeSpecifier;
import network.ike.foundation.ike.writer.StoreWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Reads a model information file into the store as knowledge (IKE-Network/ike-issues#1115):
 * a concept for the model under the Data model parent, a concept for each class under its
 * base class, its name and label read in the model's dialect, its definition as the file
 * writes it, a class that extends a System type or has no base under the model's concept, since
 * nothing hangs under the catalog's types, a record for the model and for each class with every field verbatim and IKE's
 * resolution beside it, a record for each element with its type as a tree of the catalog's
 * type specifiers, and records for the contexts, the relationships, the conversions, and the
 * required models. Every name is resolved before anything is written; a class the file does
 * not declare, a model neither required nor targeted, or a required model absent from the
 * store stops the import with its place, and nothing is half-imported.
 *
 * <p>Two models are read differently. The System model's types are the catalog's concepts
 * already: no concept is made, no parent stated, and the file's members are checked against
 * the catalog's type positions instead of being recorded. A class whose identifier names a
 * component of the store, which is how the generator writes a pattern of IKE's own, is that
 * component, and gains its record and elements without a concept.
 */
public final class ModelImporter {

    /**
     * What an import did.
     *
     * @param model            the model's name
     * @param version          its version, empty when none
     * @param modelConcept     the model concept's public id
     * @param classes          how many classes the file declares
     * @param conceptsMade     how many class concepts were new to the store
     * @param elements         how many element records were written
     * @param contexts         how many contexts
     * @param relationships    how many relationships
     * @param conversions      how many conversions
     * @param requirements     how many required models
     * @param outsideTypes     how many element types name nothing in any model: the XML Schema types,
     *                         and an element the file leaves without a type
     * @param searchesSetAside how many search parameters the file gives, all set aside
     * @param counts           what the writer did: written, unchanged, versioned, retired
     */
    public record Report(String model, String version, PublicId modelConcept, int classes, int conceptsMade, int elements,
                         int contexts, int relationships, int conversions, int requirements, int outsideTypes,
                         int searchesSetAside, int bridges, int readings, StoreWriter.Counts counts) {
    }

    private static final String SYSTEM = "System";
    private static final String XML_SCHEMA = "xs";
    private static final String COMPONENT_IDENTIFIER = "urn:uuid:";

    private final StampCalculator calculator;

    /**
     * Creates an importer over a view.
     *
     * @param calculator the view that decides which existing versions count
     */
    public ModelImporter(StampCalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Imports a file under a stamp.
     *
     * @param file  the file, read
     * @param stamp the stamp every new version is written under
     * @return what was done
     * @throws ModelImportException if a name cannot be resolved or a required model is missing;
     *                              nothing has been written
     */
    public Report importModel(ModelInfoFile file, Stamp stamp) {
        Resolution resolution = new Resolution(file, ModelTypes.load(calculator));
        resolution.resolve();

        StoreWriter writer = new StoreWriter(calculator, stamp);
        String model = file.name();
        PublicId modelId = ModelIdentity.model(model, file.version());
        int modelNid = ModelConcepts.model(writer, file, modelId);
        EntityProxy.Concept modelConcept = EntityProxy.Concept.make(modelNid);
        for (Requirement requirement : file.requirements()) {
            ModelConcepts.requirement(writer, modelId, modelNid, requirement,
                    EntityProxy.Concept.make(resolution.required.get(requirement.name()).nid()));
        }

        int conceptsMade = 0;
        for (ClassInfo clazz : file.classes()) {
            PublicId id = resolution.own.get(clazz.qualifiedName());
            if (!resolution.system && !resolution.existing.contains(clazz.qualifiedName())) {
                boolean isNew = !ModelTypes.exists(id);
                ModelConcepts.classConcept(writer, file, clazz, id, resolution.bases.get(clazz.qualifiedName()));
                if (isNew) {
                    conceptsMade++;
                }
            }
        }
        int elements = 0;
        int relationships = 0;
        int bridges = 0;
        int readings = 0;
        for (ClassInfo clazz : file.classes()) {
            PublicId id = resolution.own.get(clazz.qualifiedName());
            int nid = PrimitiveData.nid(id);
            if (!resolution.system) {
                Optional<ModelBridges.Bridge> bridge = ModelBridges.bridgeFor(model, clazz.qualifiedName());
                if (bridge.isPresent()) {
                    ModelConcepts.bridge(writer, id, nid, bridge.get());
                    bridges++;
                }
            }
            ModelConcepts.classRecord(writer, id, nid, clazz, resolution.bases.get(clazz.qualifiedName()),
                    resolution.codeElements.getOrDefault(clazz.qualifiedName(), IkeTerms.UNRESOLVED),
                    resolution.targets.getOrDefault(clazz.qualifiedName(), IkeTerms.UNRESOLVED), modelConcept);
            if (!resolution.system) {
                for (Element element : clazz.elements()) {
                    PublicId elementId = ModelIdentity.element(id, element.name());
                    DiTreeEntity tree = ModelTypeTrees.build(element.type(), elementId, resolution::known);
                    EntityProxy.Concept elementClass = element.type().isNamed()
                            ? resolution.known(element.type().name()).orElse(IkeTerms.UNRESOLVED) : IkeTerms.UNRESOLVED;
                    ModelConcepts.element(writer, elementId, nid, element, elementClass, tree);
                    elements++;
                    Optional<ModelBridges.Reading> reading = ModelBridges.readingFor(model, clazz.qualifiedName(), element.name());
                    if (reading.isPresent()) {
                        ModelConcepts.reading(writer, elementId, PrimitiveData.nid(elementId), reading.get());
                        readings++;
                    }
                }
            }
            for (Relationship relationship : clazz.relationships()) {
                EntityFacade context = resolution.contextIds.containsKey(relationship.context())
                        ? EntityProxy.Semantic.make(PrimitiveData.nid(resolution.contextIds.get(relationship.context())))
                        : IkeTerms.UNRESOLVED;
                ModelConcepts.relationship(writer, id, nid, relationship, context);
                relationships++;
            }
        }
        for (Context context : file.contexts()) {
            ModelConcepts.context(writer, resolution.contextIds.get(context.name()), modelNid, context,
                    resolution.known(context.type()).orElse(IkeTerms.UNRESOLVED));
        }
        for (Conversion conversion : file.conversions()) {
            EntityProxy.Concept from = resolution.known(conversion.fromType()).orElseThrow();
            TypeSpecifier to = ModelInfoFile.parseTypeText(conversion.toType(), model);
            ModelConcepts.conversion(writer, from.publicId(), from.nid(), conversion,
                    to.isNamed() ? resolution.known(to.name()).orElse(IkeTerms.UNRESOLVED) : IkeTerms.UNRESOLVED);
        }
        return new Report(model, file.version(), modelId, file.classes().size(), conceptsMade, elements,
                file.contexts().size(), relationships, file.conversions().size(), file.requirements().size(),
                resolution.outside, file.searchesSetAside(), bridges, readings, writer.counts());
    }

    /** Everything a file names, resolved before anything is written. */
    private final class Resolution {

        private final ModelInfoFile file;
        private final ModelTypes types;
        private final String model;
        private final boolean system;
        private final List<String> problems = new ArrayList<>();
        private final Map<String, ModelTypes.Model> required = new LinkedHashMap<>();
        private Optional<ModelTypes.Model> target = Optional.empty();
        private final Map<String, PublicId> own = new LinkedHashMap<>();
        private final java.util.Set<String> existing = new java.util.HashSet<>();
        private final Map<String, EntityProxy.Concept> bases = new HashMap<>();
        private final Map<String, EntityFacade> codeElements = new HashMap<>();
        private final Map<String, EntityProxy.Concept> targets = new HashMap<>();
        private final Map<String, PublicId> contextIds = new LinkedHashMap<>();
        private final Map<String, Optional<EntityProxy.Concept>> names = new HashMap<>();
        private int outside;

        Resolution(ModelInfoFile file, ModelTypes types) {
            this.file = file;
            this.types = types;
            this.model = file.name();
            this.system = model.equals(SYSTEM);
        }

        void resolve() {
            for (Requirement requirement : file.requirements()) {
                Optional<ModelTypes.Model> found = types.model(requirement.name(), requirement.version());
                if (found.isEmpty()) {
                    problems.add(model + ": requires " + requirement.name() + " " + requirement.version()
                            + ", which is not in the store; import it first");
                } else {
                    required.put(requirement.name(), found.get());
                }
            }
            if (!file.targetUrl().isEmpty()) {
                for (ModelTypes.Model candidate : types.modelsAt(file.targetUrl())) {
                    if (candidate.version().equals(file.targetVersion())) {
                        target = Optional.of(candidate);
                    }
                }
            }
            stop();
            for (ClassInfo clazz : file.classes()) {
                PublicId id;
                if (system) {
                    Optional<EntityProxy.Concept> type = ModelConcepts.systemType(clazz.localName(model));
                    if (type.isEmpty()) {
                        problems.add(model + ": " + clazz.qualifiedName() + " is not a type of the catalog");
                        continue;
                    }
                    id = type.get().publicId();
                } else if (clazz.identifier().startsWith(COMPONENT_IDENTIFIER)
                        && ModelTypes.exists(PublicIds.of(clazz.identifier().substring(COMPONENT_IDENTIFIER.length())))) {
                    id = PublicIds.of(clazz.identifier().substring(COMPONENT_IDENTIFIER.length()));
                    existing.add(clazz.qualifiedName());
                } else {
                    id = ModelIdentity.classOf(model, file.version(), clazz.qualifiedName());
                }
                own.put(clazz.qualifiedName(), id);
            }
            stop();
            EntityProxy.Concept modelConcept = EntityProxy.Concept.make(
                    PrimitiveData.nid(ModelIdentity.model(model, file.version())));
            for (ClassInfo clazz : file.classes()) {
                String place = model + "." + clazz.localName(model);
                // A class hangs under its base when the base is a class of a model. A class with no
                // base, one whose base is a choice of types, as five QI-Core classes are, or one that
                // extends a System type hangs under its model, since nothing hangs under the catalog's
                // types; the base type stays verbatim in the record either way.
                boolean underModel = clazz.baseType().isEmpty() || clazz.baseType().contains("<")
                        || clazz.baseType().startsWith(SYSTEM + ".");
                if (!underModel) {
                    bases.put(clazz.qualifiedName(), strict(clazz.baseType(), place + " extends").orElse(modelConcept));
                } else {
                    if (clazz.baseType().startsWith(SYSTEM + ".")) {
                        strict(clazz.baseType(), place + " extends");
                    }
                    bases.put(clazz.qualifiedName(), modelConcept);
                }
                for (Element element : clazz.elements()) {
                    walk(element.type(), place + "." + element.name());
                }
                if (!clazz.target().isEmpty()) {
                    lenient(clazz.target()).ifPresent(concept -> targets.put(clazz.qualifiedName(), concept));
                }
                if (!clazz.primaryCodePath().isEmpty()) {
                    codePath(clazz).ifPresent(id -> codeElements.put(clazz.qualifiedName(),
                            EntityProxy.Semantic.make(PrimitiveData.nid(id))));
                }
            }
            for (Context context : file.contexts()) {
                contextIds.put(context.name(), ModelIdentity.context(model, file.version(), context.name()));
                strict(context.type(), model + " context " + context.name());
            }
            for (Conversion conversion : file.conversions()) {
                String place = model + " conversion by " + conversion.functionName();
                TypeSpecifier from = ModelInfoFile.parseTypeText(conversion.fromType(), model);
                if (!from.isNamed()) {
                    problems.add(place + " converts from " + conversion.fromType() + ", which is no class to hang on");
                } else {
                    strict(from.name(), place + " from");
                }
                walk(ModelInfoFile.parseTypeText(conversion.toType(), model), place + " to");
            }
            if (system) {
                checkSystemMembers();
            }
            stop();
        }

        private void stop() {
            if (!problems.isEmpty()) {
                throw new ModelImportException(problems);
            }
        }

        /** What a qualified name means, once resolved; empty for a name that means nothing in the store. */
        Optional<EntityProxy.Concept> known(String qualified) {
            return names.getOrDefault(qualified, Optional.empty());
        }

        private void walk(TypeSpecifier type, String place) {
            switch (type.form()) {
                case NAMED -> strict(type.name(), place);
                case LIST, INTERVAL -> walk(type.inner(), place);
                default -> {
                    for (TypeSpecifier alternative : type.choices()) {
                        walk(alternative, place);
                    }
                }
            }
        }

        private Optional<EntityProxy.Concept> strict(String qualified, String place) {
            return resolve(qualified, place, false);
        }

        private Optional<EntityProxy.Concept> lenient(String qualified) {
            return resolve(qualified, "", true);
        }

        private Optional<EntityProxy.Concept> resolve(String qualified, String place, boolean lenient) {
            if (qualified.isEmpty()) {
                if (!lenient && !place.isEmpty()) {
                    outside++;
                }
                return Optional.empty();
            }
            if (names.containsKey(qualified) && (lenient || names.get(qualified).isPresent())) {
                return names.get(qualified);
            }
            int dot = qualified.indexOf('.');
            String prefix = dot < 0 ? model : qualified.substring(0, dot);
            String local = dot < 0 ? qualified : qualified.substring(dot + 1);
            Optional<EntityProxy.Concept> found = Optional.empty();
            if (prefix.equals(model)) {
                PublicId id = own.get(qualified);
                if (id != null) {
                    found = Optional.of(EntityProxy.Concept.make(PrimitiveData.nid(id)));
                } else if (!lenient) {
                    problems.add(place + " names " + qualified + ", which the file does not declare");
                }
            } else if (prefix.equals(SYSTEM)) {
                found = ModelConcepts.systemType(local);
                if (found.isEmpty() && !lenient) {
                    problems.add(place + " names " + qualified + ", which is not a type of the catalog");
                }
            } else if (prefix.equals(XML_SCHEMA)) {
                if (!names.containsKey(qualified)) {
                    outside++;
                }
            } else {
                Optional<ModelTypes.Model> other = Optional.ofNullable(required.get(prefix));
                if (other.isEmpty() && target.isPresent() && target.get().name().equals(prefix)) {
                    other = target;
                }
                if (other.isEmpty() && types.versionsOf(prefix).size() == 1) {
                    other = Optional.of(types.versionsOf(prefix).get(0));
                }
                if (other.isEmpty()) {
                    if (!lenient) {
                        problems.add(place + " names " + qualified + " of model " + prefix + ", which this model neither"
                                + " requires nor targets and the store does not hold");
                    }
                } else {
                    Optional<ModelTypes.ClassEntry> entry = types.classOf(other.get(), local);
                    if (entry.isPresent()) {
                        found = Optional.of(EntityProxy.Concept.make(entry.get().nid()));
                    } else if (!lenient) {
                        problems.add(place + " names " + qualified + ", and " + ModelConcepts.title(other.get().name(),
                                other.get().version()) + " in the store has no class of that name");
                    }
                }
            }
            names.put(qualified, found);
            return found;
        }

        /** The element a code path names, walked element by element through the file's own classes. */
        private Optional<PublicId> codePath(ClassInfo clazz) {
            ClassInfo current = clazz;
            String[] segments = clazz.primaryCodePath().split("\\.");
            PublicId found = null;
            for (int i = 0; i < segments.length; i++) {
                Optional<ElementAt> element = elementInHierarchy(current, segments[i]);
                if (element.isEmpty()) {
                    return Optional.empty();
                }
                found = ModelIdentity.element(own.get(element.get().owner().qualifiedName()), segments[i]);
                if (i < segments.length - 1) {
                    TypeSpecifier type = element.get().element().type();
                    Optional<ClassInfo> next = type.isNamed() ? file.classNamed(type.name()) : Optional.empty();
                    if (next.isEmpty()) {
                        return Optional.empty();
                    }
                    current = next.get();
                }
            }
            return Optional.ofNullable(found);
        }

        private record ElementAt(ClassInfo owner, Element element) {
        }

        private Optional<ElementAt> elementInHierarchy(ClassInfo clazz, String name) {
            ClassInfo current = clazz;
            for (int depth = 0; depth < 64 && current != null; depth++) {
                for (Element element : current.elements()) {
                    if (element.name().equals(name)) {
                        return Optional.of(new ElementAt(current, element));
                    }
                }
                current = current.baseType().isEmpty() ? null : file.classNamed(current.baseType()).orElse(null);
            }
            return Optional.empty();
        }

        /** The System file's members must agree with the catalog's type positions, name and type. */
        private void checkSystemMembers() {
            for (ClassInfo clazz : file.classes()) {
                PublicId id = own.get(clazz.qualifiedName());
                if (id == null) {
                    continue;
                }
                Map<String, Integer> positions = new HashMap<>();
                EntityService.get().forEachSemanticForComponentOfPattern(PrimitiveData.nid(id),
                        IkeTerms.ELM_TYPE_POSITION_PATTERN.nid(), semantic -> {
                            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
                            if (latest.isAbsent()) {
                                return;
                            }
                            int positionNid = ((EntityFacade) latest.get().fieldValues().get(0)).nid();
                            int typeNid = ((EntityFacade) latest.get().fieldValues().get(1)).nid();
                            ModelConcepts.fullyQualifiedName(positionNid, calculator).ifPresent(text -> {
                                int cut = text.indexOf(" position");
                                if (text.startsWith("ELM ") && cut > 4) {
                                    positions.put(text.substring(4, cut), typeNid);
                                }
                            });
                        });
                for (Element element : clazz.elements()) {
                    TypeSpecifier named = element.type().isNamed() ? element.type()
                            : element.type().form() == ModelInfoFile.Form.LIST ? element.type().inner() : null;
                    Integer expected = named != null && named.isNamed()
                            ? known(named.name()).map(EntityProxy.Concept::nid).orElse(null) : null;
                    String member = clazz.qualifiedName() + "." + element.name();
                    if (!positions.containsKey(element.name())) {
                        problems.add(member + " is a member in the file and not a position in the catalog");
                    } else if (expected == null || positions.get(element.name()).intValue() != expected.intValue()) {
                        problems.add(member + " is " + element.typeAsWritten() + " in the file and another type in the catalog");
                    }
                }
            }
        }
    }
}
