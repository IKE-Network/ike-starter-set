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
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * A unit reduced to UCUM's seven base units: an exponent on each base dimension and a magnitude
 * in the base units, computed by IKE from UCUM's definitions (IKE-Network/ike-issues#1114). The
 * dimensions keep the order the UCUM file lists its base units: length (L, the meter), time (T,
 * the second), mass (M, the gram), plane angle (A, the radian), temperature (C, the kelvin),
 * electric charge (Q, the coulomb), and luminous intensity (F, the candela).
 *
 * <p>Two units are commensurable when their dimensions agree, and convert by the ratio of their
 * magnitudes, except that a special unit, defined by a function rather than a factor, and an
 * arbitrary unit, which never converts, are flagged and refuse the ratio.
 *
 * @param exponents the exponent on each base dimension, seven of them, in the order above
 * @param magnitude the magnitude in the base units
 * @param special   whether any factor is a special unit
 * @param arbitrary whether any factor is an arbitrary unit
 */
public record UcumReduction(List<Integer> exponents, BigDecimal magnitude, boolean special, boolean arbitrary) {

    /** The base dimensions' letters, in the order the UCUM file lists its base units. */
    public static final List<String> DIMENSIONS = List.of("L", "T", "M", "A", "C", "Q", "F");

    /** The precision every magnitude is kept to: forty significant digits, rounded half even. */
    public static final MathContext PRECISION = new MathContext(40, RoundingMode.HALF_EVEN);

    /** The reduction of unity: no dimension, magnitude one. */
    public static final UcumReduction ONE = new UcumReduction(List.of(0, 0, 0, 0, 0, 0, 0), BigDecimal.ONE, false, false);

    /**
     * Checks the shape and normalizes the magnitude.
     *
     * @param exponents the exponent on each base dimension, seven of them
     * @param magnitude the magnitude in the base units
     * @param special   whether any factor is a special unit
     * @param arbitrary whether any factor is an arbitrary unit
     */
    public UcumReduction {
        if (exponents.size() != DIMENSIONS.size()) {
            throw new IllegalArgumentException("a reduction has " + DIMENSIONS.size() + " exponents, not " + exponents.size());
        }
        exponents = List.copyOf(exponents);
        magnitude = magnitude.stripTrailingZeros();
    }

    /**
     * The reduction of a base unit: exponent one on its dimension, magnitude one.
     *
     * @param dimension the dimension's letter, as the UCUM file writes it
     * @return the reduction
     */
    public static UcumReduction base(String dimension) {
        int index = DIMENSIONS.indexOf(dimension);
        if (index < 0) {
            throw new IllegalArgumentException("no base dimension " + dimension);
        }
        Integer[] exponents = new Integer[DIMENSIONS.size()];
        Arrays.fill(exponents, 0);
        exponents[index] = 1;
        return new UcumReduction(Arrays.asList(exponents), BigDecimal.ONE, false, false);
    }

    /**
     * A reduction read back from its recorded form.
     *
     * @param dimension the dimension text as {@link #dimension()} writes it
     * @param magnitude the magnitude
     * @param special   whether any factor is a special unit
     * @param arbitrary whether any factor is an arbitrary unit
     * @return the reduction
     */
    public static UcumReduction of(String dimension, BigDecimal magnitude, boolean special, boolean arbitrary) {
        Integer[] exponents = new Integer[DIMENSIONS.size()];
        Arrays.fill(exponents, 0);
        if (!dimension.equals("1")) {
            for (String part : dimension.split("\\.")) {
                String letter = part.substring(0, 1);
                int index = DIMENSIONS.indexOf(letter);
                if (index < 0) {
                    throw new IllegalArgumentException("no base dimension " + letter + " in " + dimension);
                }
                exponents[index] = part.length() == 1 ? 1 : Integer.parseInt(part.substring(1));
            }
        }
        return new UcumReduction(Arrays.asList(exponents), magnitude, special, arbitrary);
    }

    /**
     * The dimension as text: each base dimension's letter with its exponent when not one,
     * joined by periods, in the fixed order; {@code 1} when there is no dimension. The velocity
     * of a meter per second is {@code L.T-1}.
     *
     * @return the text
     */
    public String dimension() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < DIMENSIONS.size(); i++) {
            int exponent = exponents.get(i);
            if (exponent == 0) {
                continue;
            }
            if (text.length() > 0) {
                text.append('.');
            }
            text.append(DIMENSIONS.get(i));
            if (exponent != 1) {
                text.append(exponent);
            }
        }
        return text.length() == 0 ? "1" : text.toString();
    }

    /**
     * The product of two reductions: exponents added, magnitudes multiplied, flags joined.
     *
     * @param other the other reduction
     * @return the product
     */
    public UcumReduction times(UcumReduction other) {
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < DIMENSIONS.size(); i++) {
            sum.add(exponents.get(i) + other.exponents.get(i));
        }
        return new UcumReduction(sum, magnitude.multiply(other.magnitude, PRECISION),
                special || other.special, arbitrary || other.arbitrary);
    }

    /**
     * This reduction raised to a power: exponents multiplied, the magnitude raised.
     *
     * @param power the power, negative for a quotient
     * @return the power
     */
    public UcumReduction power(int power) {
        List<Integer> raised = new ArrayList<>();
        for (Integer exponent : exponents) {
            raised.add(exponent * power);
        }
        BigDecimal raisedMagnitude = power >= 0
                ? magnitude.pow(power, PRECISION)
                : BigDecimal.ONE.divide(magnitude.pow(-power, PRECISION), PRECISION);
        return new UcumReduction(raised, raisedMagnitude, special, arbitrary);
    }

    /**
     * This reduction with its magnitude multiplied by a factor.
     *
     * @param factor the factor
     * @return the scaled reduction
     */
    public UcumReduction scale(BigDecimal factor) {
        return new UcumReduction(exponents, magnitude.multiply(factor, PRECISION), special, arbitrary);
    }

    /**
     * This reduction with flags added.
     *
     * @param special   whether to mark it special
     * @param arbitrary whether to mark it arbitrary
     * @return the flagged reduction
     */
    public UcumReduction flagged(boolean special, boolean arbitrary) {
        return new UcumReduction(exponents, magnitude, this.special || special, this.arbitrary || arbitrary);
    }

    /**
     * Whether two reductions have the same dimension.
     *
     * @param other the other reduction
     * @return true when the exponents agree
     */
    public boolean commensurable(UcumReduction other) {
        return exponents.equals(other.exponents);
    }

    /**
     * How many of the other unit make one of this one: the ratio of the magnitudes when the
     * two are commensurable and neither is special or arbitrary; empty otherwise.
     *
     * @param other the other reduction
     * @return the ratio, or empty when the two do not convert by a ratio
     */
    public Optional<BigDecimal> ratioTo(UcumReduction other) {
        if (!commensurable(other) || special || arbitrary || other.special || other.arbitrary) {
            return Optional.empty();
        }
        return Optional.of(magnitude.divide(other.magnitude, PRECISION).stripTrailingZeros());
    }
}
