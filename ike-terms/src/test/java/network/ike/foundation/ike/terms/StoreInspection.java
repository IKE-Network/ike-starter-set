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

import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityHandle;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.EntityVersion;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.builder.generator.AxiomDecompiler;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;

import java.util.HashSet;
import java.util.Set;

/**
 * Read-only store probes shared by the ike-terms verification suites — extracted from
 * the retired {@code FoundationFidelityIT} when the baseline replay scaffold split into
 * {@link LedgerGatesIT} (ledger-only content gates), {@link BaselineIdentityAuditIT}
 * (the static identity audit), and {@link ConsumerMergeIT} (the in-the-field merge
 * model), IKE-Network/ike-issues#909. Each suite runs one {@code PrimitiveData}
 * lifecycle in its own forked JVM; these probes read whatever store that lifecycle
 * opened.
 */
final class StoreInspection {

    private StoreInspection() {
    }

    /**
     * The latest simple-isA parent nids of a component, resolved through the given
     * calculator over the component's stated-axiom semantics.
     *
     * @param calculator the stamp calculator whose "latest" answers
     * @param componentNid the component whose parents to resolve
     * @return the parent nids of the latest simple-isA axiom shape; empty when the
     *         latest axiom is not a simple isA, or when no axiom resolves
     */
    static Set<Integer> latestIsAParents(StampCalculator calculator, int componentNid) {
        Set<Integer> parents = new HashSet<>();
        calculator.forEachSemanticVersionForComponentOfPattern(
                EntityProxy.Concept.make(componentNid),
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

    /**
     * Whether any of this component's raw stated-axiom semantic versions (not just
     * calculator-latest) resolve to more than one distinct (simpleIsA, parents) shape —
     * the IKE-Network/ike-issues#875 detection: components with such histories answer
     * "latest" differently under different path-coordinate bootstraps, so parentage
     * comparisons exempt them (see {@code HISTORICALLY_AMBIGUOUS} accounting in
     * {@link ConsumerMergeIT} and the ambiguity column of the
     * {@link BaselineIdentityAuditIT} fixture).
     *
     * @param componentNid the component whose axiom history to inspect
     * @return {@code true} when the raw history spans more than one distinct shape
     */
    static boolean hasAmbiguousAxiomHistory(int componentNid) {
        Set<Object> distinctShapes = new HashSet<>();
        for (int semanticNid : EntityService.get()
                .semanticNidsForComponentOfPattern(componentNid, TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN.nid())) {
            for (Object versionObj : EntityHandle.get(semanticNid).expectSemantic().versions()) {
                SemanticEntityVersion version = (SemanticEntityVersion) versionObj;
                DiTreeEntity tree = (DiTreeEntity) version.fieldValues().get(0);
                AxiomDecompiler.Result result = AxiomDecompiler.decompile(tree);
                distinctShapes.add(result.simpleIsA()
                        ? Set.copyOf(result.parents().stream().map(parent -> parent.nid()).toList())
                        : "not-simple");
            }
        }
        return distinctShapes.size() > 1;
    }

    /**
     * Every stamp nid any concept, pattern, or semantic version in the store references
     * — the content-version stamp footprint {@link LedgerGatesIT}'s stamp-pair gate
     * holds to exactly the declared inception pair (IKE-Network/ike-issues#894).
     *
     * @return the stamp nids in use by content versions
     */
    static Set<Integer> versionStampNids() {
        Set<Integer> stampNids = new HashSet<>();
        EntityService.get().forEachConceptEntity(concept -> {
            for (EntityVersion version : concept.versions()) {
                stampNids.add(version.stampNid());
            }
        });
        EntityService.get().forEachPatternEntity(pattern -> {
            for (EntityVersion version : pattern.versions()) {
                stampNids.add(version.stampNid());
            }
        });
        PrimitiveData.get().forEachSemanticNid(semanticNid -> {
            for (Object versionObj : EntityHandle.get(semanticNid).expectSemantic().versions()) {
                stampNids.add(((SemanticEntityVersion) versionObj).stampNid());
            }
        });
        return stampNids;
    }
}
