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
 * The ELM date time precision: how fine a date or time comparison is. One constant per value
 * concept of the catalog's enumeration ELM DateTimePrecision, each carrying that concept's
 * public id. Hand-written to the shape the bindings goal will emit
 * (IKE-Network/ike-issues#1111).
 */
public enum DateTimePrecision implements EnumConceptBinding {

    /** To the year. */
    @PublicIdAnnotation(@UuidAnnotation("9f524641-5cb0-55fe-a12f-95714d1b12eb"))
    @RegularName("ELM DateTimePrecision Year")
    YEAR("Year"),

    /** To the month. */
    @PublicIdAnnotation(@UuidAnnotation("4e6711cc-8f63-58f3-8c3a-0d3642f48f84"))
    @RegularName("ELM DateTimePrecision Month")
    MONTH("Month"),

    /** To the week. */
    @PublicIdAnnotation(@UuidAnnotation("dad0119d-8c04-5fd1-90b6-90250e3aee1f"))
    @RegularName("ELM DateTimePrecision Week")
    WEEK("Week"),

    /** To the day. */
    @PublicIdAnnotation(@UuidAnnotation("5602942d-f6e1-5338-a8c6-5831ce26a47a"))
    @RegularName("ELM DateTimePrecision Day")
    DAY("Day"),

    /** To the hour. */
    @PublicIdAnnotation(@UuidAnnotation("258d1995-6b8b-584d-97dd-4a3d2ba86dc1"))
    @RegularName("ELM DateTimePrecision Hour")
    HOUR("Hour"),

    /** To the minute. */
    @PublicIdAnnotation(@UuidAnnotation("96eec598-fc71-5b11-89d1-d4b0937d3627"))
    @RegularName("ELM DateTimePrecision Minute")
    MINUTE("Minute"),

    /** To the second. */
    @PublicIdAnnotation(@UuidAnnotation("b9289375-9264-55fc-96e7-f5fba92d9bb8"))
    @RegularName("ELM DateTimePrecision Second")
    SECOND("Second"),

    /** To the millisecond. */
    @PublicIdAnnotation(@UuidAnnotation("1289b1ea-429b-541b-b4c1-e8ac9c289f19"))
    @RegularName("ELM DateTimePrecision Millisecond")
    MILLISECOND("Millisecond");

    private final String elmValue;

    DateTimePrecision(String elmValue) {
        this.elmValue = elmValue;
    }

    /**
     * The value as ELM writes it.
     *
     * @return the ELM spelling, {@code Year} through {@code Millisecond}
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
    public static DateTimePrecision ofElm(String elmValue) {
        for (DateTimePrecision value : values()) {
            if (value.elmValue.equals(elmValue)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No ELM date time precision is written " + elmValue);
    }
}
