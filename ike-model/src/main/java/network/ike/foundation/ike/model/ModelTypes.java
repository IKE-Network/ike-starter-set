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
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.terms.ConceptFacade;
import dev.ikm.tinkar.terms.EntityFacade;
import network.ike.foundation.ike.bindings.IkeTerms;
import org.eclipse.collections.api.list.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The data models as the store holds them after import: each model with its name, version,
 * and url, each class with its model and its base, so that a type name met in a library
 * resolves to the class concept and a class concept writes back as the name a library uses.
 */
public final class ModelTypes {

    /**
     * A model in the store.
     *
     * @param nid     the model concept's nid
     * @param id      its public id
     * @param name    the model's name as the file writes it
     * @param version the version as written, empty when none
     * @param url     the url a library qualifies its types by
     */
    public record Model(int nid, PublicId id, String name, String version, String url) {
    }

    /**
     * A class in the store.
     *
     * @param nid           the class component's nid, a concept, or a pattern of IKE's own
     * @param modelNid      the model it belongs to
     * @param qualifiedName the name qualified by the model, as the record holds it
     * @param baseNid       the base class's nid, or the model's when the class has none
     */
    public record ClassEntry(int nid, int modelNid, String qualifiedName, int baseNid) {

        /**
         * The name without the model's qualifier.
         *
         * @param modelName the model's name
         * @return the local name
         */
        public String localName(String modelName) {
            return qualifiedName.startsWith(modelName + ".") ? qualifiedName.substring(modelName.length() + 1)
                    : qualifiedName;
        }
    }

    private final Map<Integer, Model> models = new LinkedHashMap<>();
    private final Map<Integer, ClassEntry> classes = new HashMap<>();
    private final Map<Integer, Map<String, ClassEntry>> byModelAndName = new HashMap<>();
    private final StampCalculator calculator;

    private ModelTypes(StampCalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Reads the models and their classes from the store on a view.
     *
     * @param calculator the view that decides which versions count
     * @return the types; empty when no model has been imported
     */
    public static ModelTypes load(StampCalculator calculator) {
        ModelTypes types = new ModelTypes(calculator);
        EntityService.get().forEachSemanticOfPattern(IkeTerms.DATA_MODEL_RECORD_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isAbsent()) {
                return;
            }
            ImmutableList<Object> fields = latest.get().fieldValues();
            int nid = semantic.referencedComponentNid();
            types.models.put(nid, new Model(nid, EntityService.get().getEntity(nid).orElseThrow().publicId(),
                    (String) fields.get(0), (String) fields.get(1), (String) fields.get(2)));
        });
        EntityService.get().forEachSemanticOfPattern(IkeTerms.MODEL_CLASS_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isAbsent()) {
                return;
            }
            ImmutableList<Object> fields = latest.get().fieldValues();
            int nid = semantic.referencedComponentNid();
            ClassEntry entry = new ClassEntry(nid, ((EntityFacade) fields.get(15)).nid(), (String) fields.get(2),
                    ((EntityFacade) fields.get(6)).nid());
            types.classes.put(nid, entry);
            types.byModelAndName.computeIfAbsent(entry.modelNid(), key -> new HashMap<>()).put(entry.qualifiedName(), entry);
        });
        return types;
    }

    /**
     * Whether the store holds no model.
     *
     * @return true when nothing was imported
     */
    public boolean isEmpty() {
        return models.isEmpty();
    }

    /**
     * The models in the store.
     *
     * @return the models
     */
    public List<Model> models() {
        return Collections.unmodifiableList(new ArrayList<>(models.values()));
    }

    /**
     * A model by its name and version.
     *
     * @param name    the name
     * @param version the version, empty for a model that has none
     * @return the model, or empty
     */
    public Optional<Model> model(String name, String version) {
        for (Model model : models.values()) {
            if (model.name().equals(name) && model.version().equals(version)) {
                return Optional.of(model);
            }
        }
        return Optional.empty();
    }

    /**
     * The versions of a model in the store.
     *
     * @param name the model's name
     * @return the models with that name
     */
    public List<Model> versionsOf(String name) {
        List<Model> found = new ArrayList<>();
        for (Model model : models.values()) {
            if (model.name().equals(name)) {
                found.add(model);
            }
        }
        return found;
    }

    /**
     * The models a library's url names.
     *
     * @param url the url
     * @return the models at that url, several when versions share it
     */
    public List<Model> modelsAt(String url) {
        List<Model> found = new ArrayList<>();
        for (Model model : models.values()) {
            if (model.url().equals(url)) {
                found.add(model);
            }
        }
        return found;
    }

    /**
     * A model by its concept.
     *
     * @param nid the model concept's nid
     * @return the model, or empty
     */
    public Optional<Model> modelOf(int nid) {
        return Optional.ofNullable(models.get(nid));
    }

    /**
     * A class of a model by its local name.
     *
     * @param model     the model
     * @param localName the name a library writes after the model's url
     * @return the class, or empty when the model has none of that name
     */
    public Optional<ClassEntry> classOf(Model model, String localName) {
        Map<String, ClassEntry> named = byModelAndName.get(model.nid());
        if (named == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(named.get(model.name() + "." + localName));
    }

    /**
     * A class by its component.
     *
     * @param nid the class component's nid
     * @return the class, or empty when the component is no class
     */
    public Optional<ClassEntry> classEntry(int nid) {
        return Optional.ofNullable(classes.get(nid));
    }

    /**
     * An element of a class by its name, found on the class or on a base of it.
     *
     * @param classNid the class
     * @param name     the element's name
     * @return the element record's public id, or empty
     */
    public Optional<PublicId> element(int classNid, String name) {
        int current = classNid;
        for (int depth = 0; depth < 64 && classes.containsKey(current); depth++) {
            ClassEntry entry = classes.get(current);
            PublicId id = ModelIdentity.element(EntityService.get().getEntity(entry.nid()).orElseThrow().publicId(), name);
            if (exists(id)) {
                return Optional.of(id);
            }
            if (entry.baseNid() == current) {
                break;
            }
            current = entry.baseNid();
        }
        return Optional.empty();
    }

    /**
     * Whether a component exists in the store. A public id can carry a nid before anything is
     * written under it, so having a nid is not enough.
     *
     * @param id the public id
     * @return true when the store holds a component under it
     */
    public static boolean exists(PublicId id) {
        return PrimitiveData.get().hasPublicId(id) && EntityService.get().getEntity(PrimitiveData.nid(id)).isPresent();
    }

    /**
     * The class an element's type names, when it names exactly one.
     *
     * @param elementId the element record
     * @return the class's nid, or empty when the element's type names no single class
     */
    public Optional<Integer> elementClass(PublicId elementId) {
        if (!exists(elementId)) {
            return Optional.empty();
        }
        Latest<SemanticEntityVersion> latest = calculator.latest(PrimitiveData.nid(elementId));
        if (latest.isAbsent()) {
            return Optional.empty();
        }
        int nid = ((EntityFacade) latest.get().fieldValues().get(2)).nid();
        return nid == IkeTerms.UNRESOLVED.nid() || !classes.containsKey(nid) ? Optional.empty() : Optional.of(nid);
    }

    /**
     * The name a library writes for a class: the model's url in braces, then the local name.
     *
     * @param concept the class concept
     * @return the qualified name, or empty when the concept is no class
     */
    public Optional<String> qualifiedName(ConceptFacade concept) {
        ClassEntry entry = classes.get(concept.nid());
        if (entry == null) {
            return Optional.empty();
        }
        Model model = models.get(entry.modelNid());
        if (model == null) {
            return Optional.empty();
        }
        return Optional.of("{" + model.url() + "}" + entry.localName(model.name()));
    }
}
