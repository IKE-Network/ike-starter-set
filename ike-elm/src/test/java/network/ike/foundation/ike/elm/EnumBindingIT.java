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
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import network.ike.foundation.ike.bindings.IkeTerms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Each enum constant is its concept: the public id it carries is the catalog concept's, and
 * that concept is a value of the enumeration the catalog names.
 */
class EnumBindingIT {

    private static StampCalculator calculator;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
    }

    @Test
    void everyConstantCarriesItsCatalogConceptsIdentity() {
        assertEquals(IkeTerms.ELM_ACCESSMODIFIER_PUBLIC.publicId().asUuidArray()[0],
                AccessModifier.PUBLIC.publicId().asUuidArray()[0]);
        assertEquals(IkeTerms.ELM_DATETIMEPRECISION_MILLISECOND.publicId().asUuidArray()[0],
                DateTimePrecision.MILLISECOND.publicId().asUuidArray()[0]);
        assertEquals(IkeTerms.ELM_SORTDIRECTION_DESCENDING.publicId().asUuidArray()[0],
                SortDirection.DESCENDING.publicId().asUuidArray()[0]);
        List<EnumConceptBinding> all = new java.util.ArrayList<>();
        all.addAll(List.of(AccessModifier.values()));
        all.addAll(List.of(DateTimePrecision.values()));
        all.addAll(List.of(SortDirection.values()));
        assertEquals(14, all.size());
        for (EnumConceptBinding constant : all) {
            int nid = PrimitiveData.nid(constant.publicId());
            assertTrue(calculator.latest(nid).isPresent(), constant + " is a concept in the store");
        }
    }

    @Test
    void theElmSpellingRoundTrips() {
        assertEquals(AccessModifier.PRIVATE, AccessModifier.ofElm("Private"));
        assertEquals(DateTimePrecision.WEEK, DateTimePrecision.ofElm("Week"));
        assertEquals(SortDirection.ASC, SortDirection.ofElm("asc"));
        assertEquals("descending", SortDirection.DESCENDING.elmValue());
    }
}
