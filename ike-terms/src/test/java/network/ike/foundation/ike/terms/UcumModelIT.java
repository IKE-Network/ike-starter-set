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
 * The ledger gate for what is ours about UCUM (IKE-Network/ike-issues#1114): the four patterns
 * carry the settled fields, and the parents exist. The units themselves are imported knowledge
 * and are checked where they are imported.
 */
class UcumModelIT {

    private static KnowledgeSet set;
    private static StampCalculator calculator;

    @BeforeAll
    static void composeAndWrite() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-ucum-model").toFile());
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

    @Test
    void theUnitPatternRecordsWhatUcumSaysAndWhatIkeComputes() {
        List<FieldDefinitionForEntity> fields = fields(UcumModelSet.UNIT_PATTERN_FQN);
        assertEquals(11, fields.size());
        assertEquals(set.conceptRef("UCUM code (IkeFoundation)").nid(), fields.get(0).meaningNid());
        assertEquals(IkeTerm.STRING.nid(), fields.get(0).dataTypeNid());
        assertEquals(set.conceptRef("UCUM metric (IkeFoundation)").nid(), fields.get(4).meaningNid());
        assertEquals(IkeTerm.BOOLEAN_FIELD.nid(), fields.get(4).dataTypeNid());
        assertEquals(set.conceptRef("Unit dimension (IkeFoundation)").nid(), fields.get(9).meaningNid());
        assertEquals(set.conceptRef("Unit magnitude (IkeFoundation)").nid(), fields.get(10).meaningNid());
        assertEquals(IkeTerm.DECIMAL_FIELD.nid(), fields.get(10).dataTypeNid());
        int record = set.conceptRef("UCUM record (IkeFoundation)").nid();
        int reduction = set.conceptRef("Unit reduction (IkeFoundation)").nid();
        for (int i = 0; i < 9; i++) {
            assertEquals(record, fields.get(i).purposeNid(), "field " + i + " is UCUM's record");
        }
        assertEquals(reduction, fields.get(9).purposeNid());
        assertEquals(reduction, fields.get(10).purposeNid());
    }

    @Test
    void thePrefixAndComposedUnitPatternsCarryTheirFields() {
        List<FieldDefinitionForEntity> prefix = fields(UcumModelSet.PREFIX_PATTERN_FQN);
        assertEquals(4, prefix.size());
        assertEquals(set.conceptRef("UCUM prefix factor (IkeFoundation)").nid(), prefix.get(3).meaningNid());
        assertEquals(IkeTerm.DECIMAL_FIELD.nid(), prefix.get(3).dataTypeNid());
        List<FieldDefinitionForEntity> composed = fields(UcumModelSet.COMPOSED_UNIT_PATTERN_FQN);
        assertEquals(5, composed.size());
        assertEquals(set.conceptRef("Unit canonical code (IkeFoundation)").nid(), composed.get(0).meaningNid());
        assertEquals(set.conceptRef("UCUM arbitrary (IkeFoundation)").nid(), composed.get(4).meaningNid());
    }

    @Test
    void theDialectAndTheParentsExist() {
        List<FieldDefinitionForEntity> dialect = fields(UcumModelSet.DIALECT_PATTERN_FQN);
        assertEquals(1, dialect.size());
        assertEquals(set.conceptRef("UCUM dialect (IkeFoundation)").nid(), dialect.get(0).meaningNid());
        for (String parent : List.of(UcumModelSet.ROOT_FQN, UcumModelSet.PROPERTY_FQN, UcumModelSet.PREFIX_FQN,
                UcumModelSet.COMPOSED_UNIT_FQN)) {
            assertTrue(calculator.latest(set.conceptRef(parent).nid()).isPresent(), parent + " exists");
        }
    }
}
