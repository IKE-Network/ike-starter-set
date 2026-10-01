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
package network.ike.foundation.ike.evaluate;

import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.terms.EntityFacade;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.elm.ElmCatalog;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The evaluator's dispatch table as the store holds it: for each node kind of the catalog, the
 * construct a checked relation admits it as, and the relation's kind. A node kind absent here
 * is refused at evaluation.
 */
public final class Admissions {

    /**
     * One admission.
     *
     * @param constructNid the construct the node kind means
     * @param relationNid  the kind of relation claimed
     */
    public record Admission(int constructNid, int relationNid) {
    }

    private final Map<Integer, Admission> byKind = new HashMap<>();

    private Admissions() {
    }

    /**
     * Reads the relations whose extending side is a node kind of the catalog.
     *
     * @param calculator the view
     * @param catalog    the catalog
     * @return the admissions
     */
    public static Admissions load(StampCalculator calculator, ElmCatalog catalog) {
        Admissions admissions = new Admissions();
        EntityService.get().forEachSemanticOfPattern(IkeTerms.CONSTRUCT_RELATION_PATTERN.nid(), semantic -> {
            int extending = semantic.referencedComponentNid();
            if (catalog.kindOf(extending).isEmpty()) {
                return;
            }
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isPresent()) {
                admissions.byKind.put(extending, new Admission(((EntityFacade) latest.get().fieldValues().get(0)).nid(),
                        ((EntityFacade) latest.get().fieldValues().get(1)).nid()));
            }
        });
        return admissions;
    }

    /**
     * The admission of a node kind.
     *
     * @param kindNid the node kind's concept
     * @return the admission, or empty when no relation admits it
     */
    public Optional<Admission> of(int kindNid) {
        return Optional.ofNullable(byKind.get(kindNid));
    }

    /**
     * How many node kinds are admitted.
     *
     * @return the count
     */
    public int size() {
        return byKind.size();
    }
}
