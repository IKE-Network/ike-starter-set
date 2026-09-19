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
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.model.ModelInfoFile.ClassInfo;
import network.ike.foundation.ike.model.ModelInfoFile.Element;
import network.ike.foundation.ike.model.ModelInfoFile.Form;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The import gate (IKE-Network/ike-issues#1115): the six files import with their counts, every
 * class and element carries its fields verbatim with IKE's resolution beside them, names and
 * labels are read in the model's dialect, code paths, contexts, relationships, conversions,
 * and requirements are recorded, the System model makes no concept, importing again writes
 * nothing, a corrected file appends versions, and an unresolvable file is refused with its place.
 */
class ModelImporterIT {

    private static StampCalculator calculator;
    private static ModelInfoFile system;
    private static ModelInfoFile qdm;
    private static ModelInfoFile quick;
    private static ModelInfoFile fhir;
    private static ModelImporter.Report systemReport;
    private static ModelImporter.Report qdmReport;
    private static ModelImporter.Report quickReport;
    private static ModelImporter.Report fhirReport;
    private static ModelImporter.Report qicoreReport;
    private static ModelImporter.Report uscoreReport;

    private record Description(int nid, String text, int typeNid) {
    }

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        ModelImporter importer = new ModelImporter(calculator);
        system = ModelInfoFile.readShipped("system-modelinfo.xml");
        qdm = ModelInfoFile.readShipped("qdm-modelinfo-5.6.xml");
        quick = ModelInfoFile.readShipped("quick-modelinfo.xml");
        fhir = ModelInfoFile.readShipped("fhir-modelinfo-4.0.1.xml");
        systemReport = importer.importModel(system, Store.nextStamp());
        qdmReport = importer.importModel(qdm, Store.nextStamp());
        quickReport = importer.importModel(quick, Store.nextStamp());
        fhirReport = importer.importModel(fhir, Store.nextStamp());
        qicoreReport = importer.importModel(ModelInfoFile.readShipped("qicore-modelinfo-4.1.1.xml"), Store.nextStamp());
        uscoreReport = importer.importModel(ModelInfoFile.readShipped("uscore-modelinfo-3.1.1.xml"), Store.nextStamp());
    }

    private static int nid(PublicId id) {
        return PrimitiveData.nid(id);
    }

    private static List<ImmutableList<Object>> semanticsAbout(int componentNid, EntityProxy.Pattern pattern) {
        List<ImmutableList<Object>> fields = new ArrayList<>();
        EntityService.get().forEachSemanticForComponentOfPattern(componentNid, pattern.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isPresent()) {
                fields.add(latest.get().fieldValues());
            }
        });
        return fields;
    }

    private static ImmutableList<Object> record(int componentNid, EntityProxy.Pattern pattern) {
        List<ImmutableList<Object>> records = semanticsAbout(componentNid, pattern);
        assertEquals(1, records.size(), "one record of " + pattern.description() + " on " + componentNid);
        return records.get(0);
    }

    private static ImmutableList<Object> latestFields(PublicId semanticId) {
        Latest<SemanticEntityVersion> latest = calculator.latest(nid(semanticId));
        assertTrue(latest.isPresent(), semanticId + " exists");
        return latest.get().fieldValues();
    }

    private static Set<Integer> statedParents(PublicId concept) {
        Set<Integer> parents = new HashSet<>();
        for (ImmutableList<Object> fields : semanticsAbout(nid(concept), TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN)) {
            DiTreeEntity tree = (DiTreeEntity) fields.get(0);
            collect(tree, tree.root(), parents);
        }
        return parents;
    }

    private static void collect(DiTreeEntity tree, EntityVertex vertex, Set<Integer> found) {
        for (Object value : vertex.properties().values()) {
            if (value instanceof EntityFacade facade) {
                found.add(facade.nid());
            }
        }
        for (int child : tree.successors(vertex.vertexIndex()).toArray()) {
            collect(tree, tree.vertex(child), found);
        }
    }

    private static List<Description> descriptions(int componentNid) {
        List<Description> found = new ArrayList<>();
        EntityService.get().forEachSemanticForComponentOfPattern(componentNid, TinkarTerm.DESCRIPTION_PATTERN.nid(),
                semantic -> {
                    Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
                    if (latest.isPresent()) {
                        ImmutableList<Object> fields = latest.get().fieldValues();
                        found.add(new Description(semantic.nid(), (String) fields.get(1), ((EntityFacade) fields.get(3)).nid()));
                    }
                });
        return found;
    }

    private static boolean hasDescription(int componentNid, EntityProxy.Concept type, String text, EntityProxy.Pattern dialect) {
        for (Description description : descriptions(componentNid)) {
            if (description.typeNid() == type.nid() && description.text().equals(text)
                    && (dialect == null || !semanticsAbout(description.nid(), dialect).isEmpty())) {
                return true;
            }
        }
        return false;
    }

    private static PublicId classId(ModelInfoFile file, String qualifiedName) {
        return ModelIdentity.classOf(file.name(), file.version(), qualifiedName);
    }

    private static PublicId modelId(ModelInfoFile file) {
        return ModelIdentity.model(file.name(), file.version());
    }

    @Test
    @DisplayName("The six files import with their counts, and the System model makes no concept")
    void theSixFilesImportWithTheirCounts() {
        assertEquals(16, systemReport.classes());
        assertEquals(0, systemReport.conceptsMade(), "the System types are the catalog's");
        assertEquals(0, systemReport.elements(), "the System members are the catalog's positions");
        assertEquals(130, qdmReport.classes());
        assertEquals(130, qdmReport.conceptsMade());
        assertEquals(321, qdmReport.elements());
        assertEquals(1, qdmReport.contexts());
        assertEquals(0, qdmReport.requirements(), "QDM declares none");
        assertEquals(1, fhirReport.requirements());
        assertEquals(450, quickReport.classes());
        assertEquals(2633, quickReport.elements());
        assertEquals(1, quickReport.outsideTypes(), "the one XML Schema type in QUICK");
        assertEquals(931, fhirReport.classes());
        assertEquals(931, fhirReport.conceptsMade());
        assertEquals(5000, fhirReport.elements());
        assertEquals(264, fhirReport.conversions());
        assertEquals(5, fhirReport.contexts());
        assertEquals(299, fhirReport.relationships());
        assertEquals(1535, fhirReport.searchesSetAside());
        assertEquals(298, qicoreReport.classes());
        assertEquals(164, uscoreReport.classes());
        assertEquals(0, fhirReport.counts().versioned());
        ImmutableList<Object> quantity = record(IkeTerms.ELM_SYSTEM_QUANTITY.nid(), IkeTerms.MODEL_CLASS_PATTERN);
        assertEquals("System.Quantity", quantity.get(2));
        assertEquals(nid(modelId(system)), ((EntityFacade) quantity.get(15)).nid(), "the record names the System model");
        assertTrue(statedParents(modelId(fhir)).contains(IkeTerms.DATA_MODEL.nid()), "a model hangs under Data model");
        assertTrue(hasDescription(nid(modelId(fhir)), TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE,
                "FHIR 4.0.1 (data model)", null));
        assertTrue(hasDescription(nid(modelId(quick)), TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE,
                "QUICK (data model)", null));
    }

    @Test
    @DisplayName("Every class carries its fields verbatim, under its base class, in its model's dialect")
    void everyClassCarriesItsFieldsVerbatimUnderItsBase() {
        for (ModelInfoFile file : List.of(fhir, qdm)) {
            int modelNid = nid(modelId(file));
            EntityProxy.Pattern dialect = file.name().equals("FHIR") ? IkeTerms.FHIR_DIALECT_PATTERN : IkeTerms.QDM_DIALECT_PATTERN;
            for (ClassInfo clazz : file.classes()) {
                PublicId id = classId(file, clazz.qualifiedName());
                int nid = nid(id);
                ImmutableList<Object> fields = record(nid, IkeTerms.MODEL_CLASS_PATTERN);
                assertEquals(clazz.kind(), fields.get(0));
                assertEquals(clazz.namespace(), fields.get(1));
                assertEquals(clazz.qualifiedName(), fields.get(2));
                assertEquals(clazz.identifier(), fields.get(3));
                assertEquals(clazz.label(), fields.get(4));
                assertEquals(clazz.baseType(), fields.get(5));
                assertEquals(clazz.retrievable(), fields.get(7));
                assertEquals(clazz.primaryCodePath(), fields.get(8));
                assertEquals(clazz.primaryValueSetPath(), fields.get(10));
                assertEquals(clazz.target(), fields.get(11));
                assertEquals(clazz.description(), fields.get(13));
                assertEquals(clazz.comment(), fields.get(14));
                assertEquals(modelNid, ((EntityFacade) fields.get(15)).nid());
                int base = ((EntityFacade) fields.get(6)).nid();
                int expectedBase = clazz.baseType().isEmpty() || clazz.baseType().startsWith("System.") ? modelNid
                        : nid(classId(file, clazz.baseType()));
                assertEquals(expectedBase, base, clazz.qualifiedName() + " base");
                assertTrue(statedParents(id).contains(expectedBase), clazz.qualifiedName() + " hangs under its base");
                String local = clazz.localName(file.name());
                assertTrue(hasDescription(nid, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE,
                        local + " (" + ModelConcepts.title(file.name(), file.version()) + ")", null), clazz.qualifiedName() + " fqn");
                assertTrue(hasDescription(nid, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, local, dialect),
                        clazz.qualifiedName() + " is found by its name in the dialect");
                if (!clazz.label().isEmpty() && !clazz.label().equals(local)) {
                    assertTrue(hasDescription(nid, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, clazz.label(), dialect),
                            clazz.qualifiedName() + " is found by its label in the dialect");
                }
                if (!clazz.definition().isEmpty()) {
                    assertTrue(hasDescription(nid, TinkarTerm.DEFINITION_DESCRIPTION_TYPE, clazz.definition(), null),
                            clazz.qualifiedName() + " definition");
                }
            }
        }
        assertTrue(hasDescription(nid(classId(qdm, "QDM.PositiveEncounterPerformed")), TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE,
                "Encounter, Performed", IkeTerms.QDM_DIALECT_PATTERN), "a QDM author's name for the class");
    }

    @Test
    @DisplayName("Every element carries its fields verbatim, the class resolved where the type names one, the tree otherwise")
    void everyElementCarriesItsFieldsAndItsType() {
        int checked = 0;
        for (ClassInfo clazz : fhir.classes()) {
            PublicId id = classId(fhir, clazz.qualifiedName());
            for (Element element : clazz.elements()) {
                ImmutableList<Object> fields = latestFields(ModelIdentity.element(id, element.name()));
                assertEquals(element.name(), fields.get(0));
                assertEquals(element.typeAsWritten(), fields.get(1));
                assertEquals(element.mustSupport(), fields.get(7));
                assertEquals(element.definition(), fields.get(12));
                assertEquals(element.bindingName(), fields.get(14));
                assertEquals(element.bindingStrength(), fields.get(15));
                int elementClass = ((EntityFacade) fields.get(2)).nid();
                DiTreeEntity tree = (DiTreeEntity) fields.get(3);
                if (element.type().form() == Form.NAMED) {
                    int expected = element.type().name().startsWith("System.")
                            ? ModelConcepts.systemType(element.type().name().substring(7)).orElseThrow().nid()
                            : nid(classId(fhir, element.type().name()));
                    assertEquals(expected, elementClass, clazz.qualifiedName() + "." + element.name());
                    assertEquals(IkeTerms.ELM_NAMEDTYPESPECIFIER.nid(), tree.root().getMeaningNid());
                    assertEquals(expected, ((EntityFacade) tree.root().properties().get(IkeTerms.ELM_NAME_POSITION.nid())).nid());
                } else {
                    assertEquals(IkeTerms.UNRESOLVED.nid(), elementClass, clazz.qualifiedName() + "." + element.name()
                            + " names more than one class");
                    assertEquals(element.type().form() == Form.LIST ? IkeTerms.ELM_LISTTYPESPECIFIER.nid()
                            : IkeTerms.ELM_CHOICETYPESPECIFIER.nid(), tree.root().getMeaningNid());
                }
                checked++;
            }
        }
        assertEquals(5000, checked);

        DiTreeEntity identifier = (DiTreeEntity) latestFields(ModelIdentity.element(classId(fhir, "FHIR.Condition"), "identifier")).get(3);
        EntityVertex argument = identifier.vertex(identifier.successors(identifier.root().vertexIndex()).get(0));
        assertEquals(IkeTerms.ELM_ELEMENTTYPE_POSITION.nid(), argument.getMeaningNid(), "a list holds its item type at the elementType position");
        EntityVertex item = identifier.vertex(identifier.successors(argument.vertexIndex()).get(0));
        assertEquals(IkeTerms.ELM_NAMEDTYPESPECIFIER.nid(), item.getMeaningNid());
        assertEquals(nid(classId(fhir, "FHIR.Identifier")), ((EntityFacade) item.properties().get(IkeTerms.ELM_NAME_POSITION.nid())).nid());

        DiTreeEntity subject = (DiTreeEntity) latestFields(ModelIdentity.element(classId(fhir, "FHIR.ActivityDefinition"), "subject")).get(3);
        EntityVertex choice = subject.vertex(subject.successors(subject.root().vertexIndex()).get(0));
        assertEquals(IkeTerms.ELM_CHOICE_POSITION.nid(), choice.getMeaningNid());
        assertEquals(2, subject.successors(choice.vertexIndex()).size(), "the alternatives are the children of the choice position");

        ImmutableList<Object> outside = latestFields(ModelIdentity.element(classId(quick, "QUICK.base64Binary"), "value"));
        assertEquals(IkeTerms.UNRESOLVED.nid(), ((EntityFacade) outside.get(2)).nid());
        DiTreeEntity outsideTree = (DiTreeEntity) outside.get(3);
        assertEquals("xs.base64Binary", outsideTree.root().properties().get(IkeTerms.ELM_NAME_POSITION.nid()),
                "a type outside every model stays text in the tree");
    }

    @Test
    @DisplayName("Code paths resolve to elements, and contexts, relationships, conversions, and requirements are recorded")
    void codePathsContextsRelationshipsConversionsAndRequirements() {
        PublicId condition = classId(fhir, "FHIR.Condition");
        ImmutableList<Object> conditionRecord = record(nid(condition), IkeTerms.MODEL_CLASS_PATTERN);
        assertEquals(nid(ModelIdentity.element(condition, "code")), ((EntityFacade) conditionRecord.get(9)).nid(),
                "the code path resolves to the element it names");

        ClassInfo profile = qdm.classes().stream()
                .filter(clazz -> clazz.kind().equals("ProfileInfo") && clazz.elements().isEmpty() && !clazz.primaryCodePath().isEmpty())
                .findFirst().orElseThrow();
        ImmutableList<Object> profileRecord = record(nid(classId(qdm, profile.qualifiedName())), IkeTerms.MODEL_CLASS_PATTERN);
        assertTrue(((EntityFacade) profileRecord.get(9)).nid() != IkeTerms.UNRESOLVED.nid(),
                profile.qualifiedName() + " resolves its code path through its base class");

        List<ImmutableList<Object>> contexts = semanticsAbout(nid(modelId(fhir)), IkeTerms.MODEL_CONTEXT_PATTERN);
        assertEquals(5, contexts.size());
        ImmutableList<Object> patient = contexts.stream().filter(fields -> fields.get(0).equals("Patient")).findFirst().orElseThrow();
        assertEquals("FHIR.Patient", patient.get(1));
        assertEquals(nid(classId(fhir, "FHIR.Patient")), ((EntityFacade) patient.get(2)).nid());
        assertEquals("id", patient.get(3));
        assertEquals("birthDate.value", patient.get(4));

        List<ImmutableList<Object>> relationships = semanticsAbout(nid(condition), IkeTerms.MODEL_CONTEXT_RELATIONSHIP_PATTERN);
        assertFalse(relationships.isEmpty(), "Condition reaches a context");
        ImmutableList<Object> toPatient = relationships.stream().filter(fields -> fields.get(0).equals("Patient")).findFirst().orElseThrow();
        assertEquals(nid(ModelIdentity.context(fhir.name(), fhir.version(), "Patient")), ((EntityFacade) toPatient.get(1)).nid());
        assertEquals(fhir.classNamed("FHIR.Condition").orElseThrow().relationships().stream()
                .filter(relationship -> relationship.context().equals("Patient")).findFirst().orElseThrow().keyElement(), toPatient.get(2));
        assertEquals(false, toPatient.get(3));

        List<ImmutableList<Object>> conversions = semanticsAbout(nid(classId(fhir, "FHIR.Coding")), IkeTerms.MODEL_CONVERSION_PATTERN);
        ImmutableList<Object> toCode = conversions.stream().filter(fields -> fields.get(1).equals("System.Code")).findFirst().orElseThrow();
        assertEquals("FHIR.Coding", toCode.get(0));
        assertEquals(IkeTerms.ELM_SYSTEM_CODE.nid(), ((EntityFacade) toCode.get(2)).nid());
        assertEquals("FHIRHelpers.ToCode", toCode.get(3));

        List<ImmutableList<Object>> requirements = semanticsAbout(nid(modelId(fhir)), IkeTerms.MODEL_REQUIREMENT_PATTERN);
        assertEquals(1, requirements.size());
        assertEquals("System", requirements.get(0).get(0));
        assertEquals(nid(modelId(system)), ((EntityFacade) requirements.get(0).get(2)).nid());
    }

    @Test
    @DisplayName("The store answers a library's questions: models by url, classes by local name, elements through bases")
    void theStoreAnswersALibrarysQuestions() {
        ModelTypes types = ModelTypes.load(calculator);
        assertFalse(types.isEmpty());
        ModelTypes.Model fhirModel = types.model("FHIR", "4.0.1").orElseThrow();
        assertEquals(2, types.modelsAt("http://hl7.org/fhir").size(), "FHIR and QUICK share the url");
        assertEquals(1, types.versionsOf("QDM").size());
        ModelTypes.ClassEntry condition = types.classOf(fhirModel, "Condition").orElseThrow();
        assertEquals(nid(classId(fhir, "FHIR.Condition")), condition.nid());
        assertEquals(fhirModel.nid(), condition.modelNid());
        assertEquals(nid(classId(fhir, "FHIR.DomainResource")), condition.baseNid());
        assertEquals(nid(ModelIdentity.element(classId(fhir, "FHIR.Condition"), "code")), nid(types.element(condition.nid(), "code").orElseThrow()));
        assertEquals(nid(ModelIdentity.element(classId(fhir, "FHIR.DomainResource"), "text")), nid(types.element(condition.nid(), "text").orElseThrow()),
                "an element found on a base");
        assertTrue(types.element(condition.nid(), "nothing").isEmpty());
        assertEquals("{http://hl7.org/fhir}Condition", types.qualifiedName(EntityProxy.Concept.make(condition.nid())).orElseThrow());
        ModelTypes.Model systemModel = types.model("System", "1.0.0").orElseThrow();
        assertEquals(IkeTerms.ELM_SYSTEM_QUANTITY.nid(), types.classOf(systemModel, "Quantity").orElseThrow().nid());
        assertEquals("{urn:hl7-org:elm-types:r1}Quantity", types.qualifiedName(IkeTerms.ELM_SYSTEM_QUANTITY).orElseThrow());
        ModelTypes.Model quickModel = types.model("QUICK", "").orElseThrow();
        assertEquals("{http://hl7.org/fhir}Composition.Event",
                types.qualifiedName(EntityProxy.Concept.make(types.classOf(quickModel, "Composition.Event").orElseThrow().nid())).orElseThrow());
    }

    @Test
    @DisplayName("Importing a file again writes nothing, and a corrected file appends versions")
    void importingAgainWritesNothingAndACorrectedFileAppendsVersions() throws IOException {
        ModelImporter importer = new ModelImporter(calculator);
        ModelImporter.Report again = importer.importModel(qdm, Store.nextStamp());
        assertEquals(0, again.counts().written());
        assertEquals(0, again.counts().versioned());
        assertEquals(0, again.conceptsMade());

        byte[] original;
        try (java.io.InputStream in = ModelInfoFile.class.getResourceAsStream(ModelInfoFile.DIRECTORY + "qdm-modelinfo-5.6.xml")) {
            original = in.readAllBytes();
        }
        String text = new String(original, StandardCharsets.UTF_8);
        String marker = "name=\"QDM.Patient\"";
        assertTrue(text.contains(marker));
        String corrected = text.replace(marker, marker + " comment=\"a corrected file\"");
        ModelImporter.Report correction = importer.importModel(
                ModelInfoFile.read(new ByteArrayInputStream(corrected.getBytes(StandardCharsets.UTF_8))), Store.nextStamp());
        assertEquals(1, correction.counts().versioned(), "one record changed");
        assertEquals(0, correction.counts().written());
        assertEquals("a corrected file", record(nid(classId(qdm, "QDM.Patient")), IkeTerms.MODEL_CLASS_PATTERN).get(14));
        ModelImporter.Report restored = importer.importModel(qdm, Store.nextStamp());
        assertEquals(1, restored.counts().versioned());
    }

    @Test
    @DisplayName("An unresolvable file is refused with its place, and nothing is written")
    void anUnresolvableFileIsRefusedWithItsPlace() throws IOException {
        ModelImporter importer = new ModelImporter(calculator);
        String requiresNowhere = """
                <modelInfo xmlns="urn:hl7-org:elm-modelinfo:r1" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                           name="Tiny" version="1" url="urn:tiny">
                   <requiredModelInfo name="Nowhere" version="1.0"/>
                   <typeInfo xsi:type="ClassInfo" namespace="Tiny" name="Thing" retrievable="true"/>
                </modelInfo>
                """;
        ModelImportException missing = assertThrows(ModelImportException.class, () -> importer.importModel(
                ModelInfoFile.read(new ByteArrayInputStream(requiresNowhere.getBytes(StandardCharsets.UTF_8))), Store.nextStamp()));
        assertTrue(missing.getMessage().contains("Tiny: requires Nowhere 1.0, which is not in the store; import it first"), missing.getMessage());
        assertFalse(ModelTypes.exists(ModelIdentity.model("Tiny", "1")), "nothing was written");

        String undeclared = """
                <modelInfo xmlns="urn:hl7-org:elm-modelinfo:r1" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                           name="Tiny" version="1" url="urn:tiny">
                   <requiredModelInfo name="System" version="1.0.0"/>
                   <typeInfo xsi:type="ClassInfo" namespace="Tiny" name="Thing" retrievable="true">
                      <element name="part" elementType="Tiny.Nothing"/>
                      <element name="far" elementType="Elsewhere.Thing"/>
                   </typeInfo>
                </modelInfo>
                """;
        ModelImportException unresolved = assertThrows(ModelImportException.class, () -> importer.importModel(
                ModelInfoFile.read(new ByteArrayInputStream(undeclared.getBytes(StandardCharsets.UTF_8))), Store.nextStamp()));
        assertTrue(unresolved.getMessage().contains("Tiny.Thing.part names Tiny.Nothing, which the file does not declare"), unresolved.getMessage());
        assertTrue(unresolved.getMessage().contains("Tiny.Thing.far names Tiny.Elsewhere.Thing, which the file does not declare"),
                "a name whose first part is no model the file knows belongs to the file's own model: " + unresolved.getMessage());
        assertFalse(ModelTypes.exists(ModelIdentity.model("Tiny", "1")), "nothing was written");
    }
}
