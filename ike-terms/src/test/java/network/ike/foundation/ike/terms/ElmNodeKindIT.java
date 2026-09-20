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
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.FieldDefinitionForEntity;
import dev.ikm.tinkar.entity.PatternEntityVersion;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The ledger gate for evaluation's knowledge (IKE-Network/ike-issues#1116): every admitted node
 * kind relates once, to the construct the section names, by the kind it claims; every target
 * carries a denotation; the constructs, readings, circumstance kinds, and the two patterns exist
 * with their fields.
 */
class ElmNodeKindIT {

    private static KnowledgeSet set;
    private static StampCalculator calculator;
    private static final Map<Integer, List<int[]>> RELATIONS = new HashMap<>();
    private static final Set<Integer> DENOTED = new HashSet<>();

    @BeforeAll
    static void composeAndWrite() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-node-kinds").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        set = new IkeSource().compose();
        set.write();
        calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
        EntityService.get().forEachSemanticOfPattern(set.patternRef(ExpressionLanguageSet.RELATION_PATTERN_FQN).nid(),
                semantic -> {
                    Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
                    if (latest.isPresent()) {
                        RELATIONS.computeIfAbsent(semantic.referencedComponentNid(), key -> new ArrayList<>()).add(new int[] {
                                ((EntityFacade) latest.get().fieldValues().get(0)).nid(),
                                ((EntityFacade) latest.get().fieldValues().get(1)).nid()});
                    }
                });
        EntityService.get().forEachSemanticOfPattern(set.patternRef(ExpressionLanguageSet.DENOTATION_PATTERN_FQN).nid(),
                semantic -> DENOTED.add(semantic.referencedComponentNid()));
    }

    private static int nid(String fqn) {
        return set.conceptRef(fqn).nid();
    }

    @Test
    @DisplayName("Every admitted node kind relates once, to the construct the section names, by the kind it claims")
    void everyAdmittedNodeKindRelatesOnce() {
        Map<String, Integer> claims = Map.of("identity", nid("Identity (IkeFoundation)"),
                "equivalence", nid("Logical equivalence (IkeFoundation)"),
                "extension", nid("Definitional extension (IkeFoundation)"),
                "conservative", nid("Conservative extension (IkeFoundation)"));
        Set<String> kinds = new HashSet<>();
        for (ElmNodeKindSet.Relation relation : ElmNodeKindSet.RELATIONS) {
            assertTrue(kinds.add(relation.kind()), relation.kind() + " is declared twice");
            List<int[]> found = RELATIONS.get(nid("ELM " + relation.kind() + " (ELM)"));
            assertEquals(1, found == null ? 0 : found.size(), relation.kind() + " relates exactly once");
            assertEquals(nid(relation.target()), found.get(0)[0], relation.kind() + " targets " + relation.target());
            assertEquals(claims.get(relation.claim()).intValue(), found.get(0)[1], relation.kind() + " claims " + relation.claim());
            boolean kindTarget = relation.target().endsWith(" kind (IkeFoundation)")
                    || relation.target().equals("Measure ratio (IkeFoundation)");
            assertTrue(kindTarget || DENOTED.contains(found.get(0)[0]), relation.target() + " carries a denotation");
        }
        assertEquals(120, kinds.size(), "the first families, the types family, the clock, and the date components: " + kinds.size() + " node kinds");
    }

    @Test
    @DisplayName("The constructs the families lacked exist with their denotations, and the readings and circumstance kinds exist")
    void theNewConstructsReadingsAndCircumstanceKindsExist() {
        for (String construct : List.of("Written value", "Missing value", "Definition reference", "Parameter reference",
                "Alias reference", "Property access", "Query", "Query source", "Singleton from list", "First present",
                "Kind assertion", "Kind test", "Kind conversion", "Conversion possible", "Part listing", "Deep part listing",
                "Evaluation moment", "Written component reading")) {
            int nid = nid(construct + " (IkeFoundation)");
            assertTrue(calculator.latest(nid).isPresent(), construct + " exists");
            assertTrue(DENOTED.contains(nid), construct + " carries a denotation");
        }
        for (String kind : List.of("List kind", "Tuple kind", "Nullary")) {
            assertTrue(calculator.latest(nid(kind + " (IkeFoundation)")).isPresent(), kind + " exists");
        }
        for (String reading : ElmNodeKindSet.READINGS) {
            assertTrue(calculator.latest(nid(reading + " (IkeFoundation)")).isPresent(), reading + " exists");
        }
        for (String circumstance : ElmNodeKindSet.CIRCUMSTANCE_KINDS) {
            assertTrue(calculator.latest(nid(circumstance + " (IkeFoundation)")).isPresent(), circumstance + " exists");
        }
        assertEquals(9, ElmNodeKindSet.READINGS.size());
    }

    @Test
    @DisplayName("The bridge and reading patterns carry their fields, purposed as the model bridge")
    void theBridgeAndReadingPatternsCarryTheirFields() {
        int bridge = nid("Model bridge (IkeFoundation)");
        Latest<PatternEntityVersion> bridgePattern = calculator.latest(set.patternRef(ElmNodeKindSet.BRIDGE_PATTERN_FQN).nid());
        List<FieldDefinitionForEntity> fields = new ArrayList<>();
        for (FieldDefinitionForEntity field : bridgePattern.get().fieldDefinitions()) {
            fields.add(field);
        }
        assertEquals(3, fields.size());
        assertEquals(nid("Bridge circumstance kind (IkeFoundation)"), fields.get(0).meaningNid());
        assertEquals(nid("Bridge disposition (IkeFoundation)"), fields.get(1).meaningNid());
        assertEquals(nid("Bridge relation kind (IkeFoundation)"), fields.get(2).meaningNid());
        for (FieldDefinitionForEntity field : fields) {
            assertEquals(bridge, field.purposeNid());
            assertEquals(IkeTerm.CONCEPT_FIELD.nid(), field.dataTypeNid());
        }
        Latest<PatternEntityVersion> readingPattern = calculator.latest(set.patternRef(ElmNodeKindSet.READING_PATTERN_FQN).nid());
        List<FieldDefinitionForEntity> reading = new ArrayList<>();
        for (FieldDefinitionForEntity field : readingPattern.get().fieldDefinitions()) {
            reading.add(field);
        }
        assertEquals(1, reading.size());
        assertEquals(nid("Element reading (IkeFoundation)"), reading.get(0).meaningNid());
        assertEquals(bridge, reading.get(0).purposeNid());
    }
}
