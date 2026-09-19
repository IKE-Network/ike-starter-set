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

import network.ike.foundation.ike.model.ModelInfoFile.ClassInfo;
import network.ike.foundation.ike.model.ModelInfoFile.Element;
import network.ike.foundation.ike.model.ModelInfoFile.Form;
import network.ike.foundation.ike.model.ModelInfoFile.TypeSpecifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The shipped files read as the files they are, validated against the schema, with their
 * counts, their names qualified, and their types in every form.
 */
class ModelInfoFileIT {

    private static ModelInfoFile system;
    private static ModelInfoFile qdm;
    private static ModelInfoFile quick;
    private static ModelInfoFile fhir;
    private static ModelInfoFile qicore;
    private static ModelInfoFile uscore;

    @BeforeAll
    static void read() throws IOException {
        system = ModelInfoFile.readShipped("system-modelinfo.xml");
        qdm = ModelInfoFile.readShipped("qdm-modelinfo-5.6.xml");
        quick = ModelInfoFile.readShipped("quick-modelinfo.xml");
        fhir = ModelInfoFile.readShipped("fhir-modelinfo-4.0.1.xml");
        qicore = ModelInfoFile.readShipped("qicore-modelinfo-4.1.1.xml");
        uscore = ModelInfoFile.readShipped("uscore-modelinfo-3.1.1.xml");
    }

    private static int elements(ModelInfoFile file) {
        int count = 0;
        for (ClassInfo clazz : file.classes()) {
            count += clazz.elements().size();
        }
        return count;
    }

    private static int retrievable(ModelInfoFile file) {
        int count = 0;
        for (ClassInfo clazz : file.classes()) {
            if (clazz.retrievable()) {
                count++;
            }
        }
        return count;
    }

    private static int relationships(ModelInfoFile file) {
        int count = 0;
        for (ClassInfo clazz : file.classes()) {
            count += clazz.relationships().size();
        }
        return count;
    }

    private static Map<Form, Integer> forms(ModelInfoFile file) {
        Map<Form, Integer> forms = new EnumMap<>(Form.class);
        for (ClassInfo clazz : file.classes()) {
            for (Element element : clazz.elements()) {
                forms.merge(element.type().form(), 1, Integer::sum);
            }
        }
        return forms;
    }

    private static Element element(ModelInfoFile file, String qualifiedClass, String name) {
        for (Element element : file.classNamed(qualifiedClass).orElseThrow().elements()) {
            if (element.name().equals(name)) {
                return element;
            }
        }
        throw new AssertionError(qualifiedClass + " has no element " + name);
    }

    @Test
    @DisplayName("The six shipped files read with their counts")
    void theShippedFilesReadWithTheirCounts() {
        assertEquals("System", system.name());
        assertEquals("1.0.0", system.version());
        assertEquals(16, system.classes().size());
        assertEquals(12, elements(system));

        assertEquals("QDM", qdm.name());
        assertEquals("5.6", qdm.version());
        assertEquals("urn:healthit-gov:qdm:v5_6", qdm.url());
        assertEquals(130, qdm.classes().size());
        assertEquals(321, elements(qdm));
        assertEquals(84, retrievable(qdm));
        assertEquals(1, qdm.contexts().size());
        assertEquals(List.of(), qdm.requirements(), "QDM declares no requirement");

        assertEquals("QUICK", quick.name());
        assertEquals("", quick.version(), "QUICK has no version");
        assertEquals("http://hl7.org/fhir", quick.url());
        assertEquals(450, quick.classes().size());
        assertEquals(2633, elements(quick));

        assertEquals("FHIR", fhir.name());
        assertEquals("4.0.1", fhir.version());
        assertEquals(931, fhir.classes().size());
        assertEquals(5000, elements(fhir));
        assertEquals(147, retrievable(fhir));
        assertEquals(264, fhir.conversions().size());
        assertEquals(5, fhir.contexts().size());
        assertEquals(299, relationships(fhir));
        assertEquals(1535, fhir.searchesSetAside());
        assertEquals(List.of(new ModelInfoFile.Requirement("System", "1.0.0")), fhir.requirements());
        assertEquals("FHIR.Patient", fhir.patientClassName());

        assertEquals(298, qicore.classes().size());
        assertEquals("http://hl7.org/fhir", qicore.targetUrl());
        assertEquals("", qicore.targetVersion(), "QI-Core names its target url without a version");
        assertEquals(List.of(new ModelInfoFile.Requirement("System", "1.0.0")), qicore.requirements(),
                "QI-Core requires System alone and reaches FHIR through its targets");
        assertEquals(164, uscore.classes().size());
    }

    @Test
    @DisplayName("Names are qualified by their model and localized without it")
    void namesAreQualifiedAndLocalized() {
        ClassInfo condition = fhir.classNamed("FHIR.Condition").orElseThrow();
        assertEquals("Condition", condition.name(), "the file writes the name apart from the namespace");
        assertEquals("FHIR", condition.namespace());
        assertEquals("Condition", condition.localName("FHIR"));
        assertEquals("FHIR.DomainResource", condition.baseType());
        assertTrue(condition.retrievable());
        assertEquals("code", condition.primaryCodePath());
        assertEquals("http://hl7.org/fhir/StructureDefinition/Condition", condition.identifier());
        assertEquals("ClassInfo", condition.kind());

        ClassInfo event = quick.classNamed("QUICK.Composition.Event").orElseThrow();
        assertEquals("Composition.Event", event.localName("QUICK"));
        ClassInfo patient = qdm.classNamed("QDM.Patient").orElseThrow();
        assertEquals("Patient", patient.localName("QDM"));
        assertEquals("System.Any", patient.baseType());
        ClassInfo quantity = system.classNamed("System.Quantity").orElseThrow();
        assertEquals("System.Decimal", element(system, "System.Quantity", "value").type().name());
        assertEquals("System.String", element(system, "System.Quantity", "unit").type().name());
        assertEquals(2, quantity.elements().size());
        assertEquals(65, qdm.classes().stream().filter(clazz -> clazz.kind().equals("ProfileInfo")).count());
    }

    @Test
    @DisplayName("Types read in every form: named, list, interval, choice, and the older attribute grammar")
    void typesReadInEveryForm() {
        Element identifier = element(fhir, "FHIR.Condition", "identifier");
        assertEquals(Form.LIST, identifier.type().form());
        assertEquals("FHIR.Identifier", identifier.type().inner().name());
        assertEquals("List<FHIR.Identifier>", identifier.typeAsWritten(), "the nested form in CQL's syntax");
        Element subject = element(fhir, "FHIR.ActivityDefinition", "subject");
        assertEquals(Form.CHOICE, subject.type().form());
        assertEquals(List.of("FHIR.CodeableConcept", "FHIR.Reference"),
                subject.type().choices().stream().map(TypeSpecifier::name).toList());
        assertEquals("Choice<FHIR.CodeableConcept, FHIR.Reference>", subject.typeAsWritten());
        assertEquals("FHIR.CodeableConcept", element(fhir, "FHIR.Condition", "clinicalStatus").type().name());
        assertEquals("ConditionClinicalStatus", element(fhir, "FHIR.Condition", "clinicalStatus").bindingName());
        assertEquals("Required", element(fhir, "FHIR.Condition", "clinicalStatus").bindingStrength());

        Map<Form, Integer> fhirForms = forms(fhir);
        assertEquals(3304, fhirForms.get(Form.NAMED));
        assertEquals(1510, fhirForms.get(Form.LIST));
        assertEquals(186, fhirForms.get(Form.CHOICE));
        assertFalse(fhirForms.containsKey(Form.INTERVAL));
        Map<Form, Integer> qdmForms = forms(qdm);
        assertEquals(63, qdmForms.get(Form.LIST), "text lists and nested lists alike");
        assertEquals(23, qdmForms.get(Form.INTERVAL));
        assertEquals(8, qdmForms.get(Form.CHOICE));

        TypeSpecifier codes = ModelInfoFile.parseTypeText("list<System.Code>", "QDM");
        assertEquals(Form.LIST, codes.form());
        assertEquals("System.Code", codes.inner().name());
        TypeSpecifier nested = ModelInfoFile.parseTypeText("list<interval<System.DateTime>>", "QDM");
        assertEquals(Form.LIST, nested.form());
        assertEquals(Form.INTERVAL, nested.inner().form());
        assertEquals("System.DateTime", nested.inner().inner().name());
        assertEquals("QDM.Encounter", ModelInfoFile.parseTypeText("Encounter", "QDM").name(), "an unqualified name takes the model");

        Element period = element(qicore, "QICore.Address", "period");
        assertEquals(Form.INTERVAL, period.type().form());
        assertEquals("System.DateTime", period.type().inner().name());
        assertEquals("xs.base64Binary", element(quick, "QUICK.base64Binary", "value").type().name(),
                "the one type outside every model is kept as written");
    }

    @Test
    @DisplayName("A file of a kind the reader does not read is refused, and validation catches a file off the schema")
    void anUnreadKindOrAnInvalidFileIsRefused() {
        String tuple = """
                <modelInfo xmlns="urn:hl7-org:elm-modelinfo:r1" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                           name="Tiny" version="1" url="urn:tiny">
                   <typeInfo xsi:type="TupleTypeInfo"/>
                </modelInfo>
                """;
        ModelImportException refused = assertThrows(ModelImportException.class,
                () -> ModelInfoFile.read(new ByteArrayInputStream(tuple.getBytes(StandardCharsets.UTF_8))));
        assertTrue(refused.getMessage().contains("Tiny: type 1 is a TupleTypeInfo"), refused.getMessage());

        String invalid = """
                <modelInfo xmlns="urn:hl7-org:elm-modelinfo:r1" name="Tiny" url="urn:tiny">
                   <bogus/>
                </modelInfo>
                """;
        IOException notValid = assertThrows(IOException.class,
                () -> ModelInfoFile.readValidated(new ByteArrayInputStream(invalid.getBytes(StandardCharsets.UTF_8))));
        assertTrue(notValid.getMessage().contains("not valid"), notValid.getMessage());
        IOException shipped = assertThrows(IOException.class, () -> {
            try (java.io.InputStream in = ModelInfoFile.class.getResourceAsStream(ModelInfoFile.DIRECTORY + "fhir-modelinfo-4.0.1.xml")) {
                ModelInfoFile.readValidated(in);
            }
        });
        assertTrue(shipped.getMessage().contains("valueSet"),
                "the translator's own FHIR file carries bindings without the value set its schema requires: " + shipped.getMessage());
    }
}
