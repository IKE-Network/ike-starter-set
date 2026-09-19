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
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The importer's own gate: references resolve or the import refuses before writing, versions
 * appear only where content changed, a dropped definition is retired, the two forms of one
 * library import to the same semantics, and the type names met are reported.
 */
class ElmImporterIT {

    private static ElmCatalog catalog;
    private static StampCalculator calculator;
    private static ElmImporter importer;

    private static final String BASE = """
            {"library": {"identifier": {"id": "Base", "version": "1"},
              "schemaIdentifier": {"id": "urn:hl7-org:elm", "version": "r1"},
              "statements": {"def": [
                {"name": "Two", "context": "Patient", "accessLevel": "Public",
                 "expression": {"type": "Literal", "valueType": "{urn:hl7-org:elm-types:r1}Integer", "value": "2"}},
                {"name": "Three", "context": "Patient", "accessLevel": "Public",
                 "expression": {"type": "Literal", "valueType": "{urn:hl7-org:elm-types:r1}Integer", "value": "3"}}
              ]}}}
            """;

    private static final String BASE_WITHOUT_THREE = """
            {"library": {"identifier": {"id": "Base", "version": "1"},
              "schemaIdentifier": {"id": "urn:hl7-org:elm", "version": "r1"},
              "statements": {"def": [
                {"name": "Two", "context": "Patient", "accessLevel": "Public",
                 "expression": {"type": "Literal", "valueType": "{urn:hl7-org:elm-types:r1}Integer", "value": "2"}}
              ]}}}
            """;

    private static final String DEPENDENT = """
            {"library": {"identifier": {"id": "Dependent", "version": "1"},
              "schemaIdentifier": {"id": "urn:hl7-org:elm", "version": "r1"},
              "includes": {"def": [{"localIdentifier": "B", "path": "Base", "version": "1"}]},
              "statements": {"def": [
                {"name": "Twice", "context": "Patient", "accessLevel": "Public",
                 "expression": {"type": "Add",
                   "operand": [{"type": "ExpressionRef", "libraryName": "B", "name": "Two"},
                               {"type": "ExpressionRef", "libraryName": "B", "name": "Two"}]}}
              ]}}}
            """;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        catalog = Store.catalog();
        importer = new ElmImporter(catalog, calculator);
    }

    private static ElmDocument json(String text) throws IOException {
        return new ElmJsonReader(catalog).read(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)));
    }

    private static List<Integer> semanticsAbout(int componentNid, EntityProxy.Pattern pattern) {
        List<Integer> nids = new ArrayList<>();
        EntityService.get().forEachSemanticForComponentOfPattern(componentNid, pattern.nid(), semantic -> nids.add(semantic.nid()));
        return nids;
    }

    private static int versionsOf(PublicId semantic) {
        java.util.Optional<dev.ikm.tinkar.entity.SemanticRecord> record = EntityService.get().getEntity(PrimitiveData.nid(semantic));
        return record.map(r -> r.versions().size()).orElse(0);
    }

    @Test
    void aReferenceIntoAMissingLibraryIsRefusedBeforeAnythingIsWritten() throws IOException {
        // Its own names, so no other gate's import can satisfy the include.
        String orphan = DEPENDENT.replace("\"Dependent\"", "\"Orphan\"").replace("\"Base\"", "\"Nowhere\"");
        ElmImportException refused = assertThrows(ElmImportException.class,
                () -> importer.importDocument(json(orphan), Store.nextStamp()));
        assertTrue(refused.getMessage().contains("the included library Nowhere is not in the store; import it first"),
                refused.getMessage());
        assertTrue(refused.getMessage().contains("statements/def Twice/expression[1]/operand[1]"), refused.getMessage());
        assertFalse(PrimitiveData.get().hasPublicId(ElmIdentity.library("Orphan")), "nothing was written");
    }

    @Test
    void referencesAcrossLibrariesBecomeLinksOnceTheIncludeIsInTheStore() throws IOException {
        importer.importDocument(json(BASE), Store.nextStamp());
        ElmImporter.Report report = importer.importDocument(json(DEPENDENT), Store.nextStamp());
        assertEquals(1, report.references(), "one distinct thing named, though it is named twice");
        PublicId twice = ElmIdentity.definition("Dependent", "ExpressionDef", "Twice", List.of());
        List<Integer> references = semanticsAbout(PrimitiveData.nid(twice), IkeTerms.ELM_REFERENCE_PATTERN);
        assertEquals(1, references.size());
        Latest<SemanticEntityVersion> reference = calculator.latest(references.get(0));
        Object target = reference.get().fieldValues().get(1);
        assertEquals(PrimitiveData.nid(ElmIdentity.definition("Base", "ExpressionDef", "Two", List.of())),
                ((EntityProxy.Semantic) target).nid());
    }

    @Test
    void importedAgainNothingIsWrittenAndEditedOnlyTheEditedDefinitionGainsAVersion() throws IOException {
        importer.importDocument(json(BASE), Store.nextStamp());
        ElmImporter.Report again = importer.importDocument(json(BASE), Store.nextStamp());
        assertEquals(0, again.counts().written(), "the same text writes nothing new");
        assertEquals(0, again.counts().versioned(), "and appends no version");
        PublicId two = ElmIdentity.definition("Base", "ExpressionDef", "Two", List.of());
        PublicId three = ElmIdentity.definition("Base", "ExpressionDef", "Three", List.of());
        assertEquals(1, versionsOf(two));

        importer.importDocument(json(BASE.replace("\"value\": \"2\"", "\"value\": \"22\"")), Store.nextStamp());
        assertEquals(2, versionsOf(two), "the edited define has two versions");
        assertEquals(1, versionsOf(three), "the untouched define has one");

        // Dropping Three retires it: it keeps its versions and gains an inactive one, so the
        // active-only view no longer sees it, and the export no longer carries it.
        importer.importDocument(json(BASE.replace("\"value\": \"22\"", "\"value\": \"2\"")), Store.nextStamp());
        importer.importDocument(json(BASE_WITHOUT_THREE), Store.nextStamp());
        assertTrue(calculator.latest(PrimitiveData.nid(three)).isAbsent(), "Three is retired on the active view");
        assertEquals(2, versionsOf(three), "its history is kept");
        ElmDocument exported = new ElmExporter(catalog, calculator).export("Base");
        assertEquals(List.of("Two"), exported.definitions().stream().map(ElmDocument.Definition::name).toList());
    }

    @Test
    void theJsonAndTheXmlOfOneLibraryImportToTheSameSemantics() throws IOException {
        Path dir = Path.of("src", "test", "resources", "elm-fixtures", "org", "cqframework", "cql", "elm", "serializing");
        importer.importDocument(ElmRoundTripIT.read(dir.resolve("CMS146v2_Expected_SignatureLevel_None.json"), catalog),
                Store.nextStamp());
        ElmImporter.Report xml = importer.importDocument(
                ElmRoundTripIT.read(dir.resolve("CMS146v2_Expected_SignatureLevel_None.xml"), catalog), Store.nextStamp());
        assertEquals(0, xml.counts().written(), "the XML form says what the JSON form said");
        assertEquals(0, xml.counts().versioned());
    }

    @Test
    void aSystemTypeNameBecomesItsConceptAndOnlyModelTypesAreReported() throws IOException {
        ElmImporter.Report report = importer.importDocument(json(BASE), Store.nextStamp());
        assertEquals(List.of(), List.copyOf(report.unresolvedTypeNames()), "Integer is a System type, resolved");
        PublicId two = ElmIdentity.definition("Base", "ExpressionDef", "Two", List.of());
        Latest<SemanticEntityVersion> latest = calculator.latest(PrimitiveData.nid(two));
        dev.ikm.tinkar.entity.graph.DiTreeEntity tree = (dev.ikm.tinkar.entity.graph.DiTreeEntity) latest.get().fieldValues().get(0);
        // root ExpressionDef → expression (argument) → Literal, whose valueType is the concept ELM System Integer
        dev.ikm.tinkar.entity.graph.EntityVertex argument = tree.vertex(tree.successors(tree.root().vertexIndex()).get(0));
        dev.ikm.tinkar.entity.graph.EntityVertex literal = tree.vertex(tree.successors(argument.vertexIndex()).get(0));
        Object valueType = literal.properties().get(IkeTerms.ELM_VALUETYPE_POSITION.nid());
        assertTrue(valueType instanceof EntityProxy.Concept, "a System type is stored as its concept");
        assertEquals(IkeTerms.ELM_SYSTEM_INTEGER.nid(), ((EntityProxy.Concept) valueType).nid());

        ElmImporter.Report fhir = importer.importDocument(json(BASE.replace("\"Base\"", "\"Modelled\"")
                .replace("{urn:hl7-org:elm-types:r1}Integer", "{http://hl7.org/fhir}Condition")), Store.nextStamp());
        assertEquals(List.of("{http://hl7.org/fhir}Condition"), List.copyOf(fhir.unresolvedTypeNames()),
                "a data model's type stays text and is reported");
    }
}
