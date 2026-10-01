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
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.builder.generator.AxiomDecompiler;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The ledger gate for how ELM trees are held (IKE-Network/ike-issues#1110): the three authored
 * patterns carry the settled fields, the three operand roles hang under the catalog's position
 * parent, and the regenerated catalog records each position's form, property or edge.
 */
class ElmTreeIT {

    private static KnowledgeSet set;
    private static StampCalculator calculator;

    @BeforeAll
    static void composeAndWrite() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-elm-tree").toFile());
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

    private static Set<Integer> statedParents(String conceptFqn) {
        Set<Integer> parents = new HashSet<>();
        calculator.forEachSemanticVersionForComponentOfPattern(set.conceptRef(conceptFqn),
                TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN,
                (semanticVersion, entityVersion, patternVersion) -> {
                    DiTreeEntity tree = (DiTreeEntity) semanticVersion.fieldValues().get(0);
                    AxiomDecompiler.Result result = AxiomDecompiler.decompile(tree);
                    if (result.simpleIsA()) {
                        result.parents().forEach(parent -> parents.add(parent.nid()));
                    }
                });
        return parents;
    }

    @Test
    void theTreePatternHoldsOneTree() {
        List<FieldDefinitionForEntity> fields = fields(ElmTreeSet.TREE_PATTERN_FQN);
        assertEquals(1, fields.size());
        assertEquals(set.conceptRef("ELM tree (ELM)").nid(), fields.get(0).meaningNid());
        assertEquals(set.conceptRef("ELM definition (ELM)").nid(), fields.get(0).purposeNid());
        assertEquals(IkeTerm.DITREE_FIELD.nid(), fields.get(0).dataTypeNid());
    }

    @Test
    void theOrderedListPatternHoldsOneOrderedListOfComponents() {
        List<FieldDefinitionForEntity> fields = fields(ElmTreeSet.ORDERED_LIST_PATTERN_FQN);
        assertEquals(1, fields.size());
        assertEquals(set.conceptRef("ELM list items (ELM)").nid(), fields.get(0).meaningNid());
        assertEquals(set.conceptRef("ELM order (ELM)").nid(), fields.get(0).purposeNid());
        assertEquals(IkeTerm.COMPONENT_ID_LIST_FIELD.nid(), fields.get(0).dataTypeNid());
    }

    @Test
    void theReferencePatternHoldsKindTargetAndTheNamesAsWritten() {
        List<FieldDefinitionForEntity> fields = fields(ElmTreeSet.REFERENCE_PATTERN_FQN);
        assertEquals(4, fields.size());
        assertEquals(set.conceptRef("ELM reference kind (ELM)").nid(), fields.get(0).meaningNid());
        assertEquals(IkeTerm.CONCEPT_FIELD.nid(), fields.get(0).dataTypeNid());
        assertEquals(set.conceptRef("ELM referenced definition (ELM)").nid(), fields.get(1).meaningNid());
        assertEquals(IkeTerm.COMPONENT_FIELD.nid(), fields.get(1).dataTypeNid());
        assertEquals(set.conceptRef("ELM name as written (ELM)").nid(), fields.get(2).meaningNid());
        assertEquals(IkeTerm.STRING.nid(), fields.get(2).dataTypeNid());
        assertEquals(set.conceptRef("ELM library name as written (ELM)").nid(), fields.get(3).meaningNid());
        assertEquals(IkeTerm.STRING.nid(), fields.get(3).dataTypeNid());
        int reference = set.conceptRef("ELM reference (ELM)").nid();
        for (FieldDefinitionForEntity field : fields) {
            assertEquals(reference, field.purposeNid(), "every reference field serves the reference");
        }
    }

    @Test
    void theThreeOperandRolesArePositionsOfTheCatalog() {
        int positionParent = set.conceptRef(ElmTreeSet.POSITION_PARENT_FQN).nid();
        for (String role : List.of(ElmTreeSet.FIRST_OPERAND_FQN, ElmTreeSet.SECOND_OPERAND_FQN,
                ElmTreeSet.THIRD_OPERAND_FQN)) {
            assertEquals(Set.of(positionParent), statedParents(role), role + " hangs under the position parent");
        }
    }

    @Test
    void theCatalogRecordsEachPositionsForm() {
        List<FieldDefinitionForEntity> fields = fields(ElmNodeCatalogSet.TYPE_POSITION_PATTERN_FQN);
        assertEquals(6, fields.size(), "position, value type, minimum, maximum, note, form");
        assertEquals(set.conceptRef("ELM form field (ELM)").nid(), fields.get(5).meaningNid());
        assertEquals(IkeTerm.COMPONENT_FIELD.nid(), fields.get(5).dataTypeNid());

        int propertyForm = set.conceptRef("ELM property form (ELM)").nid();
        int edgeForm = set.conceptRef("ELM edge form (ELM)").nid();
        int dataType = set.conceptRef("ELM dataType position (ELM)").nid();
        int codes = set.conceptRef("ELM codes position (ELM)").nid();
        List<int[]> seen = new ArrayList<>();
        calculator.forEachSemanticVersionForComponentOfPattern(set.conceptRef("ELM Retrieve (ELM)"),
                set.patternRef(ElmNodeCatalogSet.TYPE_POSITION_PATTERN_FQN),
                (semanticVersion, entityVersion, patternVersion) -> {
                    int position = ((EntityProxy.Concept) semanticVersion.fieldValues().get(0)).nid();
                    int form = ((EntityProxy.Concept) semanticVersion.fieldValues().get(5)).nid();
                    seen.add(new int[] {position, form});
                });
        assertTrue(seen.stream().anyMatch(pair -> pair[0] == dataType && pair[1] == propertyForm),
                "Retrieve's dataType, an attribute, is held as a property");
        assertTrue(seen.stream().anyMatch(pair -> pair[0] == codes && pair[1] == edgeForm),
                "Retrieve's codes, an element, is held as an edge");
    }

    @Test
    void theCatalogRootIsTheNodeCatalog() {
        assertEquals("ELM node catalog (ELM)", ElmNodeCatalogSet.ROOT_FQN);
        assertTrue(calculator.latest(set.conceptRef(ElmNodeCatalogSet.ROOT_FQN).nid()).isPresent());
    }
}
