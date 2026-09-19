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
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.model.ModelInfoFile.ClassInfo;
import network.ike.foundation.ike.model.ModelInfoFile.Context;
import network.ike.foundation.ike.model.ModelInfoFile.Conversion;
import network.ike.foundation.ike.model.ModelInfoFile.Element;
import network.ike.foundation.ike.model.ModelInfoFile.Relationship;
import network.ike.foundation.ike.model.ModelInfoFile.Requirement;
import network.ike.foundation.ike.writer.StoreWriter;
import org.eclipse.collections.api.factory.Lists;

import java.util.Map;
import java.util.Optional;

/**
 * How a model information thing becomes knowledge in the store: the model concept under the
 * Data model parent, a class concept under its base with its name and label read in the
 * model's dialect and its definition as the file writes it, and the records that hold every
 * field verbatim beside IKE's resolution.
 */
final class ModelConcepts {

    /** The System types by local name: the catalog's concepts, never made by an import. */
    private static final Map<String, EntityProxy.Concept> SYSTEM_TYPES = Map.ofEntries(
            Map.entry("Any", IkeTerms.ELM_SYSTEM_ANY), Map.entry("Boolean", IkeTerms.ELM_SYSTEM_BOOLEAN),
            Map.entry("Integer", IkeTerms.ELM_SYSTEM_INTEGER), Map.entry("Long", IkeTerms.ELM_SYSTEM_LONG),
            Map.entry("Decimal", IkeTerms.ELM_SYSTEM_DECIMAL), Map.entry("String", IkeTerms.ELM_SYSTEM_STRING),
            Map.entry("DateTime", IkeTerms.ELM_SYSTEM_DATETIME), Map.entry("Date", IkeTerms.ELM_SYSTEM_DATE),
            Map.entry("Time", IkeTerms.ELM_SYSTEM_TIME), Map.entry("Quantity", IkeTerms.ELM_SYSTEM_QUANTITY),
            Map.entry("Ratio", IkeTerms.ELM_SYSTEM_RATIO), Map.entry("Code", IkeTerms.ELM_SYSTEM_CODE),
            Map.entry("Concept", IkeTerms.ELM_SYSTEM_CONCEPT), Map.entry("Vocabulary", IkeTerms.ELM_SYSTEM_VOCABULARY),
            Map.entry("ValueSet", IkeTerms.ELM_SYSTEM_VALUESET), Map.entry("CodeSystem", IkeTerms.ELM_SYSTEM_CODESYSTEM),
            Map.entry("Interval", IkeTerms.ELM_SYSTEM_INTERVAL));

    /** The dialect each shipped model's names and labels are read in. */
    private static final Map<String, EntityProxy.Pattern> DIALECTS = Map.of(
            "FHIR", IkeTerms.FHIR_DIALECT_PATTERN, "QDM", IkeTerms.QDM_DIALECT_PATTERN,
            "QUICK", IkeTerms.QUICK_DIALECT_PATTERN, "QICore", IkeTerms.QI_CORE_DIALECT_PATTERN,
            "USCore", IkeTerms.US_CORE_DIALECT_PATTERN);

    private ModelConcepts() {
    }

    /**
     * The catalog's concept for a System type.
     *
     * @param localName the type's name without the model, for example {@code Quantity}
     * @return the concept, or empty when the catalog has no such type
     */
    static Optional<EntityProxy.Concept> systemType(String localName) {
        return Optional.ofNullable(SYSTEM_TYPES.get(localName));
    }

    /**
     * The dialect pattern of a model, when the ledger declares one.
     *
     * @param modelName the model's name as the file writes it
     * @return the pattern, or empty
     */
    static Optional<EntityProxy.Pattern> dialectPattern(String modelName) {
        return Optional.ofNullable(DIALECTS.get(modelName));
    }

    /**
     * How a model is titled: its name, then its version when it has one.
     *
     * @param name    the name
     * @param version the version, possibly empty
     * @return the title
     */
    static String title(String name, String version) {
        return version.isEmpty() ? name : name + " " + version;
    }

    /**
     * Writes the model's concept under the Data model parent, named by its title, with its record.
     *
     * @param writer the writer
     * @param file   the file
     * @param id     the model's identity
     * @return the model concept's nid
     */
    static int model(StoreWriter writer, ModelInfoFile file, PublicId id) {
        int nid = writer.concept(id);
        writer.statedParent(id, IkeTerms.DATA_MODEL.publicId());
        String title = title(file.name(), file.version());
        writer.describe(nid, ModelIdentity.description(id, "fqn"), title + " (data model)",
                TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE, TinkarTerm.PREFERRED);
        writer.describe(nid, ModelIdentity.description(id, "name"), title, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE,
                TinkarTerm.PREFERRED);
        writer.semantic(ModelIdentity.record(id), IkeTerms.DATA_MODEL_RECORD_PATTERN, nid, Lists.immutable.of(
                file.name(), file.version(), file.url(), file.targetUrl(), file.targetVersion(), file.targetQualifier(),
                file.patientClassName(), file.patientClassIdentifier(), file.patientBirthDatePropertyName(),
                file.defaultContext(), file.caseSensitive().orElse(false), file.strictRetrieveTyping().orElse(false),
                file.schemaLocation()));
        return nid;
    }

    /**
     * Writes a requirement record on the model.
     *
     * @param writer      the writer
     * @param modelId     the model
     * @param modelNid    the model concept's nid
     * @param requirement the requirement as written
     * @param required    the required model's concept
     */
    static void requirement(StoreWriter writer, PublicId modelId, int modelNid, Requirement requirement,
                            EntityProxy.Concept required) {
        writer.semantic(ModelIdentity.requirement(modelId, requirement.name(), requirement.version()),
                IkeTerms.MODEL_REQUIREMENT_PATTERN, modelNid,
                Lists.immutable.of(requirement.name(), requirement.version(), required));
    }

    /**
     * Writes a class that is new to the store: its concept under its base, its names in the model's
     * dialect, and its definition as the file writes it.
     *
     * @param writer    the writer
     * @param file      the file
     * @param clazz     the class as written
     * @param id        the class's identity
     * @param base      the base class's concept, or the model's when the class has none
     * @return the class concept's nid
     */
    static int classConcept(StoreWriter writer, ModelInfoFile file, ClassInfo clazz, PublicId id,
                            EntityProxy.Concept base) {
        int nid = writer.concept(id);
        writer.statedParent(id, base.publicId());
        String local = clazz.localName(file.name());
        String title = title(file.name(), file.version());
        Optional<EntityProxy.Pattern> dialect = dialectPattern(file.name());
        writer.describe(nid, ModelIdentity.description(id, "fqn"), local + " (" + title + ")",
                TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE, TinkarTerm.PREFERRED);
        named(writer, nid, id, "name", local, TinkarTerm.PREFERRED, dialect);
        if (!clazz.label().isEmpty() && !clazz.label().equals(local)) {
            named(writer, nid, id, "label", clazz.label(), TinkarTerm.ACCEPTABLE, dialect);
        }
        if (!clazz.definition().isEmpty()) {
            writer.describe(nid, ModelIdentity.description(id, "definition"), clazz.definition(),
                    TinkarTerm.DEFINITION_DESCRIPTION_TYPE, TinkarTerm.PREFERRED);
        }
        return nid;
    }

    /**
     * Writes the class record on a class, new or already in the store.
     *
     * @param writer      the writer
     * @param classId     the class
     * @param classNid    the class component's nid
     * @param clazz       the class as written
     * @param base        the base class's concept, or the model's
     * @param codeElement the element the code path names, or the unresolved marker
     * @param target      the class of another model this one stands on, or the unresolved marker
     * @param model       the model's concept
     */
    static void classRecord(StoreWriter writer, PublicId classId, int classNid, ClassInfo clazz, EntityProxy.Concept base,
                            EntityFacade codeElement, EntityProxy.Concept target, EntityProxy.Concept model) {
        writer.semantic(ModelIdentity.record(classId), IkeTerms.MODEL_CLASS_PATTERN, classNid, Lists.immutable.of(
                clazz.kind(), clazz.namespace(), clazz.qualifiedName(), clazz.identifier(), clazz.label(),
                clazz.baseType(), base, clazz.retrievable(), clazz.primaryCodePath(), codeElement,
                clazz.primaryValueSetPath(), clazz.target(), target, clazz.description(), clazz.comment(), model));
    }

    /**
     * Writes an element record on its class.
     *
     * @param writer       the writer
     * @param elementId    the element's identity
     * @param classNid     the class component's nid
     * @param element      the element as written
     * @param elementClass the class the type names when it names one, or the unresolved marker
     * @param tree         the type as a tree
     */
    static void element(StoreWriter writer, PublicId elementId, int classNid, Element element,
                        EntityProxy.Concept elementClass, DiTreeEntity tree) {
        writer.semantic(elementId, IkeTerms.MODEL_ELEMENT_PATTERN, classNid, Lists.immutable.of(
                element.name(), element.typeAsWritten(), elementClass, tree, element.minimum(), element.maximum(),
                element.prohibited(), element.mustSupport(), element.oneBased(), element.target(), element.label(),
                element.description(), element.definition(), element.comment(), element.bindingName(),
                element.bindingStrength(), element.bindingValueSet()));
    }

    /**
     * Writes a context record on the model.
     *
     * @param writer       the writer
     * @param contextId    the context's identity
     * @param modelNid     the model concept's nid
     * @param context      the context as written
     * @param contextClass the class that is the context
     */
    static void context(StoreWriter writer, PublicId contextId, int modelNid, Context context,
                        EntityProxy.Concept contextClass) {
        writer.semantic(contextId, IkeTerms.MODEL_CONTEXT_PATTERN, modelNid, Lists.immutable.of(
                context.name(), context.type(), contextClass, context.keyElement(), context.birthDateElement()));
    }

    /**
     * Writes a relationship record on a class.
     *
     * @param writer       the writer
     * @param classId      the class
     * @param classNid     the class component's nid
     * @param relationship the relationship as written
     * @param contextRecord the context's record on the model, or the unresolved marker
     */
    static void relationship(StoreWriter writer, PublicId classId, int classNid, Relationship relationship,
                             EntityFacade contextRecord) {
        writer.semantic(ModelIdentity.relationship(classId, relationship.context(), relationship.keyElement(), relationship.toTarget()),
                IkeTerms.MODEL_CONTEXT_RELATIONSHIP_PATTERN, classNid, Lists.immutable.of(
                        relationship.context(), contextRecord, relationship.keyElement(), relationship.toTarget()));
    }

    /**
     * Writes a conversion record on the type converted from.
     *
     * @param writer     the writer
     * @param fromId     the type converted from
     * @param fromNid    its nid
     * @param conversion the conversion as written
     * @param target     the type converted to
     */
    static void conversion(StoreWriter writer, PublicId fromId, int fromNid, Conversion conversion,
                           EntityProxy.Concept target) {
        writer.semantic(ModelIdentity.conversion(fromId, conversion.toType(), conversion.functionName()),
                IkeTerms.MODEL_CONVERSION_PATTERN, fromNid, Lists.immutable.of(
                        conversion.fromType(), conversion.toType(), target, conversion.functionName()));
    }

    /**
     * A component's fully qualified name on a view.
     *
     * @param nid        the component
     * @param calculator the view
     * @return the text, or empty
     */
    static Optional<String> fullyQualifiedName(int nid, StampCalculator calculator) {
        return descriptionOfType(nid, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE.nid(), calculator);
    }

    /**
     * A component's regular name on a view, the first found.
     *
     * @param nid        the component
     * @param calculator the view
     * @return the text, or empty
     */
    static Optional<String> regularName(int nid, StampCalculator calculator) {
        return descriptionOfType(nid, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE.nid(), calculator);
    }

    private static Optional<String> descriptionOfType(int nid, int typeNid, StampCalculator calculator) {
        String[] found = {null};
        EntityService.get().forEachSemanticForComponentOfPattern(nid, TinkarTerm.DESCRIPTION_PATTERN.nid(), semantic -> {
            if (found[0] != null) {
                return;
            }
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isPresent() && ((EntityFacade) latest.get().fieldValues().get(3)).nid() == typeNid) {
                found[0] = (String) latest.get().fieldValues().get(1);
            }
        });
        return Optional.ofNullable(found[0]);
    }

    private static void named(StoreWriter writer, int nid, PublicId id, String role, String text,
                              EntityProxy.Concept usAcceptability, Optional<EntityProxy.Pattern> dialect) {
        int description = writer.describe(nid, ModelIdentity.description(id, role), text,
                TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, usAcceptability);
        if (dialect.isPresent()) {
            writer.dialect(description, ModelIdentity.description(id, role + " model-dialect"), dialect.get(),
                    TinkarTerm.PREFERRED);
        }
    }
}
