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
package network.ike.foundation.ike.ucum;

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.writer.StoreWriter;
import org.eclipse.collections.api.list.ImmutableList;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * The UCUM units as the store holds them after import: the atoms and prefixes read back from
 * their records, so that a unit code met later, in a library's quantity, is read by the
 * grammar against the knowledge in the graph, and a composed unit is made on demand, once,
 * identified by its canonical code.
 */
public final class UcumUnits implements UcumSymbols {

    private record Atom(String code, boolean metric, UcumReduction reduction) {
    }

    private final Map<String, Atom> atoms = new LinkedHashMap<>();
    private final Map<String, BigDecimal> prefixes = new LinkedHashMap<>();

    private UcumUnits() {
    }

    /**
     * Reads the atoms and prefixes from the store on a view.
     *
     * @param calculator the view that decides which versions count
     * @return the units; empty when UCUM has not been imported
     */
    public static UcumUnits load(StampCalculator calculator) {
        UcumUnits units = new UcumUnits();
        EntityService.get().forEachSemanticOfPattern(IkeTerms.UCUM_UNIT_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isAbsent()) {
                return;
            }
            ImmutableList<Object> fields = latest.get().fieldValues();
            String code = (String) fields.get(0);
            units.atoms.put(code, new Atom(code, (Boolean) fields.get(4), UcumReduction.of((String) fields.get(9),
                    UcumConcepts.magnitude(fields.get(10)), (Boolean) fields.get(5), (Boolean) fields.get(6))));
        });
        EntityService.get().forEachSemanticOfPattern(IkeTerms.UCUM_PREFIX_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isAbsent()) {
                return;
            }
            ImmutableList<Object> fields = latest.get().fieldValues();
            units.prefixes.put((String) fields.get(0), UcumConcepts.magnitude(fields.get(3)));
        });
        return units;
    }

    /**
     * Whether the store holds no UCUM units.
     *
     * @return true when nothing was imported
     */
    public boolean isEmpty() {
        return atoms.isEmpty();
    }

    /**
     * Reads a unit code against the store's atoms and prefixes.
     *
     * @param code the code as written
     * @return the term
     * @throws UcumSyntaxException if the code cannot be read; the place is named
     */
    public UcumTerm parse(String code) {
        return UcumGrammar.parse(code, this);
    }

    /**
     * The concept a term means: the atom's own concept for a single atom, else the composed
     * unit's, whether or not it has been written yet.
     *
     * @param term the term
     * @return the concept's identity
     */
    public PublicId identity(UcumTerm term) {
        return term.isAtom() ? UcumIdentity.unit(term.atom()) : UcumIdentity.composedUnit(term.canonicalCode());
    }

    /**
     * The concept a term means, written if it is a composed unit not yet in the store.
     *
     * @param term   the term
     * @param writer the writer
     * @return the concept's identity
     */
    public PublicId write(UcumTerm term, StoreWriter writer) {
        if (term.isAtom()) {
            return UcumIdentity.unit(term.atom());
        }
        return UcumConcepts.composedUnit(writer, term, term.reduce(this));
    }

    @Override
    public Set<String> atomCodes() {
        return Collections.unmodifiableSet(atoms.keySet());
    }

    @Override
    public Set<String> prefixCodes() {
        return Collections.unmodifiableSet(prefixes.keySet());
    }

    @Override
    public boolean metric(String atomCode) {
        Atom atom = atoms.get(atomCode);
        return atom != null && atom.metric();
    }

    @Override
    public UcumReduction reduction(String atomCode) {
        Atom atom = atoms.get(atomCode);
        if (atom == null) {
            throw new IllegalArgumentException("no UCUM unit " + atomCode + " in the store");
        }
        return atom.reduction();
    }

    @Override
    public BigDecimal prefixFactor(String prefixCode) {
        BigDecimal factor = prefixes.get(prefixCode);
        if (factor == null) {
            throw new IllegalArgumentException("no UCUM prefix " + prefixCode + " in the store");
        }
        return factor;
    }
}
