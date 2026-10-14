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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A unit code read by UCUM's grammar: a number, the factors it multiplies, each a prefix if
 * any, an atom, and an exponent, and the annotations in braces, which mean nothing to the
 * algebra and are kept outside it (IKE-Network/ike-issues#1114). The factors are canonical:
 * factors on one prefixed atom are merged, exponents of zero dropped, and the rest ordered,
 * positive exponents before negative and by atom then prefix within each, so that one unit
 * spelled two ways, mg/dL and mg.dL-1, has one canonical code.
 *
 * @param asWritten   the code as it was written
 * @param number      the numeric factor, one when none was written
 * @param factors     the canonical factors
 * @param annotations the annotations, in the order written, without their braces
 */
public record UcumTerm(String asWritten, BigDecimal number, List<Factor> factors, List<String> annotations) {

    /**
     * One factor of a unit: a prefix, empty when none, an atom, and an exponent.
     *
     * @param prefix   the prefix's code, empty when none
     * @param atom     the atom's code
     * @param exponent the exponent, one when none was written
     */
    public record Factor(String prefix, String atom, int exponent) {

        /**
         * The factor's code: prefix, atom, and the exponent when not one.
         *
         * @return the code
         */
        public String code() {
            return prefix + atom + (exponent == 1 ? "" : Integer.toString(exponent));
        }
    }

    private static final Comparator<Factor> CANONICAL_ORDER = Comparator
            .comparingInt((Factor factor) -> factor.exponent() < 0 ? 1 : 0)
            .thenComparing(Factor::atom)
            .thenComparing(Factor::prefix);

    /**
     * Keeps the lists immutable.
     *
     * @param asWritten   the code as written
     * @param number      the numeric factor
     * @param factors     the factors
     * @param annotations the annotations
     */
    public UcumTerm {
        factors = List.copyOf(factors);
        annotations = List.copyOf(annotations);
    }

    /**
     * Makes a term from the factors as they were read, in canonical order.
     *
     * @param asWritten   the code as written
     * @param number      the numeric factor
     * @param read        the factors in the order read, possibly repeating a prefixed atom
     * @param annotations the annotations
     * @return the term
     */
    static UcumTerm of(String asWritten, BigDecimal number, List<Factor> read, List<String> annotations) {
        Map<String, Factor> merged = new LinkedHashMap<>();
        for (Factor factor : read) {
            String key = factor.prefix() + "|" + factor.atom();
            Factor before = merged.get(key);
            merged.put(key, before == null ? factor
                    : new Factor(factor.prefix(), factor.atom(), before.exponent() + factor.exponent()));
        }
        List<Factor> canonical = new ArrayList<>();
        for (Factor factor : merged.values()) {
            if (factor.exponent() != 0) {
                canonical.add(factor);
            }
        }
        canonical.sort(CANONICAL_ORDER);
        return new UcumTerm(asWritten, number, canonical, annotations);
    }

    /**
     * Whether the term means one atom alone: no number, no prefix, no power. Annotations do
     * not count; {@code m{tissue}} means the meter.
     *
     * @return true when the term is an atom
     */
    public boolean isAtom() {
        return number.compareTo(BigDecimal.ONE) == 0 && factors.size() == 1
                && factors.get(0).prefix().isEmpty() && factors.get(0).exponent() == 1;
    }

    /**
     * The atom a term that {@link #isAtom() is an atom} means.
     *
     * @return the atom's code
     * @throws IllegalStateException if the term is not an atom
     */
    public String atom() {
        if (!isAtom()) {
            throw new IllegalStateException(asWritten + " is not a single atom");
        }
        return factors.get(0).atom();
    }

    /**
     * The canonical code: the number when not one, then the canonical factors, joined by
     * periods; {@code 1} for unity. It is a UCUM code, reads back to the same term, and seeds
     * a composed unit's identity.
     *
     * @return the canonical code
     */
    public String canonicalCode() {
        StringBuilder code = new StringBuilder();
        if (number.compareTo(BigDecimal.ONE) != 0) {
            code.append(number.stripTrailingZeros().toPlainString());
        }
        for (Factor factor : factors) {
            if (code.length() > 0) {
                code.append('.');
            }
            code.append(factor.code());
        }
        return code.length() == 0 ? "1" : code.toString();
    }

    /**
     * Reduces the term to the base units: the number times each factor's atom, scaled by its
     * prefix, raised to its exponent.
     *
     * @param symbols where the atoms' reductions and the prefixes' factors come from
     * @return the reduction
     */
    public UcumReduction reduce(UcumSymbols symbols) {
        UcumReduction result = UcumReduction.ONE.scale(number);
        for (Factor factor : factors) {
            UcumReduction atom = symbols.reduction(factor.atom());
            if (!factor.prefix().isEmpty()) {
                atom = atom.scale(symbols.prefixFactor(factor.prefix()));
            }
            result = result.times(atom.power(factor.exponent()));
        }
        return result;
    }
}
