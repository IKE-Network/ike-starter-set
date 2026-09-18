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

import network.ike.foundation.ike.elm.ElmCatalog.EnumerationValue;
import network.ike.foundation.ike.elm.ElmCatalog.Form;
import network.ike.foundation.ike.elm.ElmCatalog.KindValue;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmCatalog.PrimitiveValue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The catalog read back from the store says what the schema says: every node kind, its base,
 * and its positions with their form, their bounds, and what they hold.
 */
class ElmCatalogIT {

    private static ElmCatalog catalog;

    @BeforeAll
    static void load() throws Exception {
        catalog = Store.catalog();
    }

    @Test
    void everyNodeKindOfTheSchemaIsInTheCatalog() {
        assertEquals(270, catalog.kindCount(), "23 System types, 215 expression, 27 clinical, 5 library");
        assertTrue(catalog.kind("Exists").isKindOf(catalog.kind("Expression")));
        assertTrue(catalog.kind("Exists").isKindOf(catalog.kind("UnaryExpression")));
        assertFalse(catalog.kind("Exists").isKindOf(catalog.kind("Query")));
        assertEquals("Element", catalog.kind("Expression").base().orElseThrow().name());
        assertTrue(catalog.kind("Element").base().isEmpty());
    }

    @Test
    void aPlainValuedPositionIsAProperty() {
        PositionRule dataType = catalog.kind("Retrieve").position("dataType").orElseThrow();
        assertEquals(Form.PROPERTY, dataType.form());
        assertInstanceOf(PrimitiveValue.class, dataType.valueType());
        assertEquals("QName", ((PrimitiveValue) dataType.valueType()).name());
    }

    @Test
    void aNodeValuedPositionIsAnEdgeToAKind() {
        PositionRule operand = catalog.kind("Exists").position("operand").orElseThrow();
        assertEquals(Form.EDGE, operand.form());
        assertEquals(1, operand.minimum());
        assertEquals(1, operand.maximum());
        assertInstanceOf(KindValue.class, operand.valueType());
        assertEquals("Expression", ((KindValue) operand.valueType()).kind().name());
        assertFalse(operand.isRoles());
        assertFalse(operand.isList());
    }

    @Test
    void twoOrThreeOperandsAreRolesAndUnboundedPositionsAreLists() {
        assertTrue(catalog.kind("Equivalent").position("operand").orElseThrow().isRoles());
        assertTrue(catalog.kind("TernaryExpression").position("operand").orElseThrow().isRoles());
        assertTrue(catalog.kind("Query").position("source").orElseThrow().isList());
        assertTrue(catalog.kind("Sort").position("by").orElseThrow().isList());
    }

    @Test
    void anEnumeratedPositionHoldsOneOfTheEnumerationsValues() {
        PositionRule accessLevel = catalog.kind("ExpressionDef").position("accessLevel").orElseThrow();
        assertEquals(Form.PROPERTY, accessLevel.form());
        assertInstanceOf(EnumerationValue.class, accessLevel.valueType());
        EnumerationValue enumeration = (EnumerationValue) accessLevel.valueType();
        assertEquals(2, enumeration.valueNids().size(), "Public and Private");
        assertTrue(enumeration.valueNids().contains(
                dev.ikm.tinkar.common.service.PrimitiveData.nid(AccessModifier.PUBLIC.publicId())));
    }

    @Test
    void positionsAreSharedAcrossKindsButRuledPerKind() {
        NodeKind unary = catalog.kind("UnaryExpression");
        NodeKind nary = catalog.kind("NaryExpression");
        assertEquals(unary.position("operand").orElseThrow().position().nid(),
                nary.position("operand").orElseThrow().position().nid(), "one position concept, operand");
        assertEquals(1, unary.position("operand").orElseThrow().maximum());
        assertEquals(-1, nary.position("operand").orElseThrow().maximum());
    }
}
