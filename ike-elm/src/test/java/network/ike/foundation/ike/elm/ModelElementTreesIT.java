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

import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import network.ike.foundation.ike.bindings.IkeTerms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * One checker holds both: every element type tree the model import wrote, named, list,
 * interval, and choice alike, conforms to the catalog the way a library's tree does
 * (IKE-Network/ike-issues#1115).
 */
class ModelElementTreesIT {

    private static StampCalculator calculator;
    private static ElmCatalog catalog;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        catalog = Store.catalog();
    }

    @Test
    @DisplayName("Every model element's type tree conforms to the catalog, choices as sets among them")
    void everyElementTypeTreeConformsToTheCatalog() {
        int[] trees = {0};
        int[] choices = {0};
        int[] lists = {0};
        List<String> problems = new ArrayList<>();
        EntityService.get().forEachSemanticOfPattern(IkeTerms.MODEL_ELEMENT_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isAbsent()) {
                return;
            }
            DiTreeEntity tree = (DiTreeEntity) latest.get().fieldValues().get(3);
            trees[0]++;
            if (tree.root().getMeaningNid() == IkeTerms.ELM_CHOICETYPESPECIFIER.nid()) {
                choices[0]++;
            }
            if (tree.root().getMeaningNid() == IkeTerms.ELM_LISTTYPESPECIFIER.nid()) {
                lists[0]++;
            }
            for (String problem : ElmConformance.check(tree, catalog)) {
                if (problems.size() < 10) {
                    problems.add(latest.get().fieldValues().get(0) + ": " + problem);
                }
            }
        });
        assertEquals(List.of(), problems, "every element type tree conforms");
        assertTrue(trees[0] > 8000, "the store holds the elements of QUICK, FHIR 4.0.1, and two QDM versions: " + trees[0]);
        assertTrue(choices[0] > 0, "FHIR's and QDM's choice types are among them: " + choices[0]);
        assertTrue(lists[0] > 0, "and the lists: " + lists[0]);
    }
}
