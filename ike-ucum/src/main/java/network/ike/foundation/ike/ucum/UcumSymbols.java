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
import java.util.Set;

/**
 * What the grammar and the reduction need to know about UCUM's atoms and prefixes: which codes
 * exist, which atoms take a prefix, what each atom reduces to, and what each prefix multiplies
 * by. The unmodified UCUM file answers at import time; the store answers afterwards.
 */
public interface UcumSymbols {

    /**
     * The codes of every atom, base units and defined units alike, case-sensitive.
     *
     * @return the codes
     */
    Set<String> atomCodes();

    /**
     * The codes of every prefix, case-sensitive.
     *
     * @return the codes
     */
    Set<String> prefixCodes();

    /**
     * Whether an atom is metric, and so takes a prefix.
     *
     * @param atomCode the atom's code
     * @return true when it is metric
     */
    boolean metric(String atomCode);

    /**
     * What an atom reduces to in the base units.
     *
     * @param atomCode the atom's code
     * @return its reduction
     * @throws IllegalArgumentException if no atom has that code
     */
    UcumReduction reduction(String atomCode);

    /**
     * What a prefix multiplies by.
     *
     * @param prefixCode the prefix's code
     * @return its factor
     * @throws IllegalArgumentException if no prefix has that code
     */
    BigDecimal prefixFactor(String prefixCode);
}
