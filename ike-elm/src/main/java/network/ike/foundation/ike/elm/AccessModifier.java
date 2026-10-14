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
 * The ELM access modifier: who may see a definition. One constant per value concept of the
 * catalog's enumeration ELM AccessModifier, each carrying that concept's public id, so the
 * constant and the concept are one thing seen from two sides. Hand-written to the shape the
 * bindings goal will emit (IKE-Network/ike-issues#1111).
 */
public enum AccessModifier implements EnumConceptBinding {

    /** Visible to other libraries. */
    @PublicIdAnnotation(@UuidAnnotation("9b885daf-839c-581a-8206-e892b6e67647"))
    @RegularName("ELM AccessModifier Public")
    PUBLIC("Public"),

    /** Visible only inside its own library. */
    @PublicIdAnnotation(@UuidAnnotation("2d134842-7ddc-5c98-96ad-db5a7982c2df"))
    @RegularName("ELM AccessModifier Private")
    PRIVATE("Private");

    private final String elmValue;

    AccessModifier(String elmValue) {
        this.elmValue = elmValue;
    }

    /**
     * The value as ELM writes it.
     *
     * @return the ELM spelling, {@code Public} or {@code Private}
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
    public static AccessModifier ofElm(String elmValue) {
        for (AccessModifier value : values()) {
            if (value.elmValue.equals(elmValue)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No ELM access modifier is written " + elmValue);
    }
}
