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
package network.ike.foundation.ike.terms;

import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.FieldDefinitionForEntity;
import dev.ikm.tinkar.entity.PatternEntityVersion;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The ledger gate for what is ours about model information (IKE-Network/ike-issues#1115): the
 * record patterns carry the settled fields with the purpose that says whose each field is, the
 * mark and the dialects exist, and the parent exists. The models themselves are imported
 * knowledge and are checked where they are imported.
 */
class ModelInformationIT {

    private static KnowledgeSet set;
    private static StampCalculator calculator;

    @BeforeAll
    static void composeAndWrite() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-model-ledger").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        set = new IkeSource().compose();
        set.write();
        calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
    }

    private static List<FieldDefinitionForEntity> fields(String patternFqn) {
        Latest<PatternEntityVersion> latest = calculator.latest(set.patternRef(patternFqn).nid());
        assertTrue(latest.isPresent(), patternFqn + " has a latest version");
        List<FieldDefinitionForEntity> fields = new ArrayList<>();
        for (FieldDefinitionForEntity field : latest.get().fieldDefinitions()) {
            fields.add(field);
        }
        return fields;
    }

    private static int nid(String fqn) {
        return set.conceptRef(fqn).nid();
    }

    @Test
    void theClassAndElementRecordsSayWhoseEachFieldIs() {
        int record = nid("Model information record (IkeFoundation)");
        int resolution = nid("Model resolution (IkeFoundation)");

        List<FieldDefinitionForEntity> clazz = fields(ModelInformationSet.CLASS_PATTERN_FQN);
        assertEquals(16, clazz.size());
        assertEquals(nid("Model class kind (IkeFoundation)"), clazz.get(0).meaningNid());
        assertEquals(nid("Class name (IkeFoundation)"), clazz.get(2).meaningNid());
        assertEquals(nid("Class base (IkeFoundation)"), clazz.get(6).meaningNid());
        assertEquals(IkeTerm.CONCEPT_FIELD.nid(), clazz.get(6).dataTypeNid());
        assertEquals(resolution, clazz.get(6).purposeNid(), "the resolved base is IKE's");
        assertEquals(nid("Class retrievable (IkeFoundation)"), clazz.get(7).meaningNid());
        assertEquals(IkeTerm.BOOLEAN_FIELD.nid(), clazz.get(7).dataTypeNid());
        assertEquals(nid("Class primary code element (IkeFoundation)"), clazz.get(9).meaningNid());
        assertEquals(IkeTerm.COMPONENT_FIELD.nid(), clazz.get(9).dataTypeNid());
        assertEquals(resolution, clazz.get(9).purposeNid());
        assertEquals(nid("Class target type (IkeFoundation)"), clazz.get(12).meaningNid());
        assertEquals(resolution, clazz.get(12).purposeNid());
        assertEquals(nid("Class model (IkeFoundation)"), clazz.get(15).meaningNid());
        assertEquals(resolution, clazz.get(15).purposeNid());
        for (int i : new int[] {0, 1, 2, 3, 4, 5, 7, 8, 10, 11, 13, 14}) {
            assertEquals(record, clazz.get(i).purposeNid(), "class field " + i + " is the file's record");
        }

        List<FieldDefinitionForEntity> element = fields(ModelInformationSet.ELEMENT_PATTERN_FQN);
        assertEquals(17, element.size());
        assertEquals(nid("Element name (IkeFoundation)"), element.get(0).meaningNid());
        assertEquals(nid("Element type (IkeFoundation)"), element.get(1).meaningNid());
        assertEquals(nid("Element class (IkeFoundation)"), element.get(2).meaningNid());
        assertEquals(IkeTerm.CONCEPT_FIELD.nid(), element.get(2).dataTypeNid());
        assertEquals(nid("Element type specifier (IkeFoundation)"), element.get(3).meaningNid());
        assertEquals(IkeTerm.DITREE_FIELD.nid(), element.get(3).dataTypeNid());
        assertEquals(resolution, element.get(2).purposeNid());
        assertEquals(resolution, element.get(3).purposeNid());
        for (int i = 4; i < 17; i++) {
            assertEquals(record, element.get(i).purposeNid(), "element field " + i + " is the file's record");
        }
        assertEquals(nid("Element binding value set (IkeFoundation)"), element.get(16).meaningNid());
    }

    @Test
    void theModelContextRelationshipConversionAndRequirementRecordsCarryTheirFields() {
        int record = nid("Model information record (IkeFoundation)");
        int resolution = nid("Model resolution (IkeFoundation)");
        List<FieldDefinitionForEntity> model = fields(ModelInformationSet.MODEL_PATTERN_FQN);
        assertEquals(13, model.size());
        assertEquals(nid("Model name (IkeFoundation)"), model.get(0).meaningNid());
        assertEquals(nid("Model version (IkeFoundation)"), model.get(1).meaningNid());
        assertEquals(nid("Model url (IkeFoundation)"), model.get(2).meaningNid());
        assertEquals(nid("Model case sensitive (IkeFoundation)"), model.get(10).meaningNid());
        assertEquals(IkeTerm.BOOLEAN_FIELD.nid(), model.get(10).dataTypeNid());
        for (FieldDefinitionForEntity field : model) {
            assertEquals(record, field.purposeNid(), "every model field is the file's record");
        }
        List<FieldDefinitionForEntity> requirement = fields(ModelInformationSet.REQUIREMENT_PATTERN_FQN);
        assertEquals(3, requirement.size());
        assertEquals(nid("Required model (IkeFoundation)"), requirement.get(2).meaningNid());
        assertEquals(resolution, requirement.get(2).purposeNid());
        List<FieldDefinitionForEntity> context = fields(ModelInformationSet.CONTEXT_PATTERN_FQN);
        assertEquals(5, context.size());
        assertEquals(nid("Context class (IkeFoundation)"), context.get(2).meaningNid());
        assertEquals(resolution, context.get(2).purposeNid());
        List<FieldDefinitionForEntity> relationship = fields(ModelInformationSet.RELATIONSHIP_PATTERN_FQN);
        assertEquals(4, relationship.size());
        assertEquals(nid("Relationship context (IkeFoundation)"), relationship.get(1).meaningNid());
        assertEquals(IkeTerm.COMPONENT_FIELD.nid(), relationship.get(1).dataTypeNid());
        List<FieldDefinitionForEntity> conversion = fields(ModelInformationSet.CONVERSION_PATTERN_FQN);
        assertEquals(4, conversion.size());
        assertEquals(nid("Conversion target class (IkeFoundation)"), conversion.get(2).meaningNid());
        assertEquals(nid("Conversion function (IkeFoundation)"), conversion.get(3).meaningNid());
    }

    @Test
    void theMarkTheDialectsAndTheParentExist() {
        int generation = nid("Model generation (IkeFoundation)");
        List<FieldDefinitionForEntity> mark = fields(ModelInformationSet.MARK_PATTERN_FQN);
        assertEquals(3, mark.size());
        assertEquals(nid("Mark model name (IkeFoundation)"), mark.get(0).meaningNid());
        assertEquals(nid("Mark retrievable (IkeFoundation)"), mark.get(1).meaningNid());
        assertEquals(nid("Mark code field (IkeFoundation)"), mark.get(2).meaningNid());
        assertEquals(IkeTerm.CONCEPT_FIELD.nid(), mark.get(2).dataTypeNid());
        for (FieldDefinitionForEntity field : mark) {
            assertEquals(generation, field.purposeNid(), "every mark field is IKE's generation");
        }
        for (String model : ModelInformationSet.DIALECTS) {
            List<FieldDefinitionForEntity> dialect = fields(ModelInformationSet.dialectPatternFqn(model));
            assertEquals(1, dialect.size(), model + " dialect has one field");
            assertEquals(nid(model + " dialect (IkeFoundation)"), dialect.get(0).meaningNid());
        }
        assertTrue(calculator.latest(nid(ModelInformationSet.ROOT_FQN)).isPresent(), "the Data model parent exists");
        assertTrue(calculator.latest(nid("Model information record (IkeFoundation)")).isPresent());
        assertTrue(calculator.latest(nid("Unresolved (IkeFoundation)")).isPresent(), "the unresolved marker exists");
    }
}
