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

import dev.ikm.tinkar.common.bind.EnumConceptBinding;
import dev.ikm.tinkar.common.bind.annotations.names.RegularName;
import dev.ikm.tinkar.common.bind.annotations.publicid.PublicIdAnnotation;
import dev.ikm.tinkar.common.bind.annotations.publicid.UuidAnnotation;

/**
 * The ELM sort direction. ELM spells each direction two ways, short and long, and keeps them
 * as four values, so this enum has four constants, one per value concept of the catalog's
 * enumeration ELM SortDirection, each carrying that concept's public id. Hand-written to the
 * shape the bindings goal will emit (IKE-Network/ike-issues#1111).
 */
public enum SortDirection implements EnumConceptBinding {

    /** Ascending, the short spelling. */
    @PublicIdAnnotation(@UuidAnnotation("9af5d965-ae8c-5458-89ba-581fcf548a27"))
    @RegularName("ELM SortDirection asc")
    ASC("asc"),

    /** Ascending, the long spelling. */
    @PublicIdAnnotation(@UuidAnnotation("b2231dfb-b681-5fa6-adc3-ac92ebfdc03c"))
    @RegularName("ELM SortDirection ascending")
    ASCENDING("ascending"),

    /** Descending, the short spelling. */
    @PublicIdAnnotation(@UuidAnnotation("7d2501a4-2a5f-5851-a78a-fed0b2b6d57c"))
    @RegularName("ELM SortDirection desc")
    DESC("desc"),

    /** Descending, the long spelling. */
    @PublicIdAnnotation(@UuidAnnotation("c1da68c8-1e1b-5e7e-afe1-6286ccb7b5d1"))
    @RegularName("ELM SortDirection descending")
    DESCENDING("descending");

    private final String elmValue;

    SortDirection(String elmValue) {
        this.elmValue = elmValue;
    }

    /**
     * The value as ELM writes it.
     *
     * @return the ELM spelling
     */
    public String elmValue() {
        return elmValue;
    }

    /**
     * The constant for a value as ELM writes it.
     *
     * @param elmValue the ELM spelling
     * @return the constant
     * @throws IllegalArgumentException if no constant carries that spelling
     */
    public static SortDirection ofElm(String elmValue) {
        for (SortDirection value : values()) {
            if (value.elmValue.equals(elmValue)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No ELM sort direction is written " + elmValue);
    }
}
