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

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.FieldDefinitionForEntity;
import dev.ikm.tinkar.entity.PatternEntityVersion;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.model.ModelInfoFile.ClassInfo;
import network.ike.foundation.ike.model.ModelInfoFile.Element;
import network.ike.foundation.ike.writer.StoreWriter;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The generator gate (IKE-Network/ike-issues#1115): a family of the ledger's patterns, marked,
 * writes as model information that validates against the schema, imports back, and resolves
 * every class to its pattern and every element to its field.
 */
class ModelInfoGeneratorIT {

    private static StampCalculator calculator;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        // The generated file requires the System model, imported here if another gate has not.
        new ModelImporter(calculator).importModel(ModelInfoFile.readShipped("system-modelinfo.xml"), Store.nextStamp());
    }

    private static void mark(StoreWriter writer, EntityProxy.Pattern pattern, String model, boolean retrievable,
                             EntityProxy.Concept codeField) {
        writer.semantic(PublicIds.of(UuidT5Generator.get(pattern.publicId().asUuidArray()[0], "class mark " + model)),
                IkeTerms.MODEL_CLASS_MARK_PATTERN, pattern.nid(), Lists.immutable.of(model, retrievable, codeField));
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

    private static Set<String> fieldNames(EntityProxy.Pattern pattern, ModelInfoGenerator generator) {
        Set<String> names = new HashSet<>();
        Latest<PatternEntityVersion> latest = calculator.latest(pattern.nid());
        for (FieldDefinitionForEntity field : latest.get().fieldDefinitions()) {
            names.add(generator.nameOf(field.meaningNid()).orElseThrow());
        }
        return names;
    }

    @Test
    @DisplayName("A marked family writes as model information that imports back to its patterns and fields")
    void aMarkedFamilyWritesAsModelInformationThatImportsBackToItsPatterns() throws Exception {
        StoreWriter writer = new StoreWriter(calculator, Store.nextStamp());
        mark(writer, IkeTerms.UCUM_UNIT_PATTERN, "UCUM", false, IkeTerms.UCUM_CODE);
        mark(writer, IkeTerms.UCUM_PREFIX_PATTERN, "UCUM", false, IkeTerms.UCUM_CODE);
        ModelInfoGenerator generator = new ModelInfoGenerator(calculator);
        assertTrue(generator.isMarked(IkeTerms.UCUM_UNIT_PATTERN.nid(), "UCUM"));

        String xml = generator.write("UCUM", "2.2", "urn:ike:model:ucum");
        ModelInfoFile file = ModelInfoFile.readValidated(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
        assertEquals("UCUM", file.name());
        assertEquals("2.2", file.version());
        assertEquals(List.of(new ModelInfoFile.Requirement("System", "1.0.0")), file.requirements());
        assertEquals(2, file.classes().size());
        ClassInfo unit = file.classNamed("UCUM.UCUM Unit").orElseThrow();
        assertEquals("urn:uuid:" + IkeTerms.UCUM_UNIT_PATTERN.publicId().asUuidArray()[0], unit.identifier(),
                "the class carries the pattern's identity");
        assertEquals("UCUM code", unit.primaryCodePath());
        assertEquals(11, unit.elements().size());
        assertEquals("System.String", element(unit, "UCUM code").type().name());
        assertEquals("System.Boolean", element(unit, "UCUM metric").type().name());
        assertEquals("System.Decimal", element(unit, "Unit magnitude").type().name());
        ClassInfo prefix = file.classNamed("UCUM.UCUM Prefix").orElseThrow();
        assertEquals(4, prefix.elements().size());

        ModelImporter.Report report = new ModelImporter(calculator).importModel(file, Store.nextStamp());
        assertEquals(2, report.classes());
        assertEquals(0, report.conceptsMade(), "the classes are the patterns; no concept is made");
        assertEquals(15, report.elements());
        List<ImmutableList<Object>> records = semanticsAbout(IkeTerms.UCUM_UNIT_PATTERN.nid(), IkeTerms.MODEL_CLASS_PATTERN);
        assertEquals(1, records.size(), "the class record hangs on the pattern");
        assertEquals("UCUM.UCUM Unit", records.get(0).get(2));
        assertEquals(PrimitiveData.nid(ModelIdentity.model("UCUM", "2.2")), ((EntityFacade) records.get(0).get(15)).nid());

        Set<String> elements = new HashSet<>();
        for (ImmutableList<Object> record : semanticsAbout(IkeTerms.UCUM_UNIT_PATTERN.nid(), IkeTerms.MODEL_ELEMENT_PATTERN)) {
            elements.add((String) record.get(0));
            if (record.get(0).equals("UCUM code")) {
                assertEquals(IkeTerms.ELM_SYSTEM_STRING.nid(), ((EntityFacade) record.get(2)).nid());
            }
        }
        assertEquals(fieldNames(IkeTerms.UCUM_UNIT_PATTERN, generator), elements, "every element is a field of the pattern");

        ModelTypes types = ModelTypes.load(calculator);
        ModelTypes.Model model = types.model("UCUM", "2.2").orElseThrow();
        assertEquals(IkeTerms.UCUM_UNIT_PATTERN.nid(), types.classOf(model, "UCUM Unit").orElseThrow().nid(),
                "a library's type name resolves to the pattern");
        assertEquals("{urn:ike:model:ucum}UCUM Unit", types.qualifiedName(EntityProxy.Concept.make(IkeTerms.UCUM_UNIT_PATTERN.nid())).orElseThrow());
    }

    private static Element element(ClassInfo clazz, String name) {
        for (Element element : clazz.elements()) {
            if (element.name().equals(name)) {
                return element;
            }
        }
        throw new AssertionError(clazz.qualifiedName() + " has no element " + name);
    }
}
