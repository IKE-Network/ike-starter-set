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

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.terms.EntityFacade;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.model.ModelTypes;

import java.util.Optional;

/**
 * The bridges and readings as the store holds them: for a class concept, the criterion it stands
 * for; for an element record, the statement reading it answers. Both are authored knowledge
 * written when a model is imported (IKE-Network/ike-issues#1116).
 */
final class Bridges {

    /**
     * The criterion a class stands for.
     *
     * @param circumstanceKindNid the circumstance kind a statement must hold
     * @param dispositionNid      the disposition it must carry, empty when the class fixes none
     * @param relationNid         the kind of relation the bridge claims
     */
    record Bridge(int circumstanceKindNid, Optional<Integer> dispositionNid, int relationNid) {
    }

    private final StampCalculator calculator;
    private final ModelTypes types;

    Bridges(StampCalculator calculator, ModelTypes types) {
        this.calculator = calculator;
        this.types = types;
    }

    ModelTypes types() {
        return types;
    }

    /** The bridge on a class, if one is authored. */
    Optional<Bridge> bridgeOf(int classNid) {
        Bridge[] found = {null};
        EntityService.get().forEachSemanticForComponentOfPattern(classNid, IkeTerms.MODEL_CLASS_BRIDGE_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isPresent() && found[0] == null) {
                int disposition = ((EntityFacade) latest.get().fieldValues().get(1)).nid();
                found[0] = new Bridge(((EntityFacade) latest.get().fieldValues().get(0)).nid(),
                        disposition == IkeTerms.UNRESOLVED.nid() ? Optional.empty() : Optional.of(disposition),
                        ((EntityFacade) latest.get().fieldValues().get(2)).nid());
            }
        });
        return Optional.ofNullable(found[0]);
    }

    /** The reading an element of a class answers, found on the class or a base of it. */
    Optional<Integer> readingOf(int classNid, String elementName) {
        Optional<PublicId> element = types.element(classNid, elementName);
        if (element.isEmpty()) {
            return Optional.empty();
        }
        int elementNid = PrimitiveData.nid(element.get());
        Integer[] found = {null};
        EntityService.get().forEachSemanticForComponentOfPattern(elementNid, IkeTerms.MODEL_ELEMENT_READING_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isPresent() && found[0] == null) {
                found[0] = ((EntityFacade) latest.get().fieldValues().get(0)).nid();
            }
        });
        return Optional.ofNullable(found[0]);
    }

    /** Whether a class is the patient class of its model. */
    boolean isPatientClass(int classNid) {
        Optional<ModelTypes.ClassEntry> entry = types.classEntry(classNid);
        if (entry.isEmpty()) {
            return false;
        }
        Optional<ModelTypes.Model> model = types.modelOf(entry.get().modelNid());
        return model.isPresent() && model.get().patientClass().equals(entry.get().qualifiedName());
    }
}
