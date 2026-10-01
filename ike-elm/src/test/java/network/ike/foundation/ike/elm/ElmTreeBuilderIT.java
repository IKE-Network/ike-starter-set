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

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The builder builds the example define as one tree that conforms to the catalog, and refuses
 * a tree that does not: an unknown position, one operand too many, a value of the wrong kind.
 */
class ElmTreeBuilderIT {

    private static ElmTreeBuilder builder;
    private static final PublicId TREE = PublicIds.of(UUID.fromString("1b6f0d8e-4a3c-5e7f-9b2d-6c1a0e3f5d7b"));

    @BeforeAll
    static void load() throws Exception {
        builder = new ElmTreeBuilder(Store.catalog());
    }

    /** The example define's where clause: C.clinicalStatus ~ 'active'. */
    static ElmNode whereClause(ElmTreeBuilder b) {
        return b.node("Equivalent")
                .first(b.node("Property").property("path", "clinicalStatus").property("scope", "C"))
                .second(b.node("Literal")
                        .property("valueType", "{urn:hl7-org:elm-types:r1}String")
                        .property("value", "active"));
    }

    @Test
    void buildsTheExampleDefineAsOneConformingTree() {
        PublicId sources = PublicIds.of(UUID.fromString("7c2e9a10-3b4d-5f6e-8a9b-0c1d2e3f4a5b"));
        ElmNode define = builder.node("ExpressionDef")
                .property("name", "Has Diabetes")
                .property("context", "Patient")
                .property("accessLevel", AccessModifier.PUBLIC)
                .edge("expression", builder.node("Exists")
                        .edge("operand", builder.node("Query")
                                .list("source", sources)
                                .edge("where", whereClause(builder))));

        DiTreeEntity tree = builder.build(define, TREE);

        assertTrue(ElmConformance.check(tree, builder.catalog()).isEmpty());
        EntityVertex root = tree.root();
        assertEquals(IkeTerms.ELM_EXPRESSIONDEF.nid(), root.getMeaningNid());
        assertEquals("Has Diabetes", root.propertyFast(IkeTerms.ELM_NAME_POSITION));
        EntityProxy.Concept level = root.propertyFast(IkeTerms.ELM_ACCESSLEVEL_POSITION);
        assertEquals(PrimitiveData.nid(AccessModifier.PUBLIC.publicId()), level.nid());
        // root → expression (argument vertex) → Exists → operand → Query
        EntityVertex expression = tree.vertex(tree.successors(root.vertexIndex()).get(0));
        assertEquals(IkeTerms.ELM_EXPRESSION_POSITION.nid(), expression.getMeaningNid());
        EntityVertex exists = tree.vertex(tree.successors(expression.vertexIndex()).get(0));
        assertEquals(IkeTerms.ELM_EXISTS.nid(), exists.getMeaningNid());
        // The same tree built again is the same tree: every vertex id is derived.
        DiTreeEntity again = builder.build(define, TREE);
        assertEquals(tree.root().vertexId().asUuid(), again.root().vertexId().asUuid());
        assertEquals(tree.vertexMap().size(), again.vertexMap().size());
    }

    @Test
    void refusesAPositionTheKindDoesNotHave() {
        IllegalArgumentException refused = assertThrows(IllegalArgumentException.class,
                () -> builder.node("Retrieve").property("nonsense", "x"));
        assertEquals("Retrieve has no position named nonsense", refused.getMessage());
    }

    @Test
    void refusesOneOperandTooMany() {
        ElmNode exists = builder.node("Exists")
                .edge("operand", builder.node("Null"))
                .edge("operand", builder.node("Null"));
        ElmConformanceException refused = assertThrows(ElmConformanceException.class,
                () -> builder.build(exists, TREE));
        assertTrue(refused.getMessage().contains("Exists holds operand 2 times; at most 1 allowed"),
                refused.getMessage());
    }

    @Test
    void refusesAValueOfTheWrongKind() {
        ElmNode retrieve = builder.node("Retrieve")
                .property("dataType", "{http://hl7.org/fhir}Condition")
                .property("codeProperty", 42);
        ElmConformanceException refused = assertThrows(ElmConformanceException.class,
                () -> builder.build(retrieve, TREE));
        assertTrue(refused.getMessage().contains("Retrieve's codeProperty must hold a string value; found Integer"),
                refused.getMessage());
        // A literal's value is anySimpleType in the schema: any plain value is allowed there.
        assertTrue(ElmConformance.check(builder.build(builder.node("Literal")
                .property("valueType", "{urn:hl7-org:elm-types:r1}Integer").property("value", 42), TREE),
                builder.catalog()).isEmpty());

        ElmNode define = builder.node("ExpressionDef").property("name", "x").property("accessLevel", "Public")
                .edge("expression", builder.node("Null"));
        ElmConformanceException wrongChoice = assertThrows(ElmConformanceException.class,
                () -> builder.build(define, TREE));
        assertTrue(wrongChoice.getMessage().contains("must be one of the values of its enumeration"),
                wrongChoice.getMessage());
    }

    @Test
    void namesTwoOperandsAsRolesNeverAsAnOrder() {
        IllegalArgumentException refused = assertThrows(IllegalArgumentException.class,
                () -> builder.node("Equivalent").edge("operand", builder.node("Null")));
        assertTrue(refused.getMessage().contains("named first, second"), refused.getMessage());

        ElmNode halfDone = builder.node("Equivalent").first(builder.node("Null"));
        ElmConformanceException incomplete = assertThrows(ElmConformanceException.class,
                () -> builder.build(halfDone, TREE));
        assertTrue(incomplete.getMessage().contains("needs exactly one first and one second operand"),
                incomplete.getMessage());
        assertTrue(ElmConformance.check(builder.build(whereClause(builder), TREE), builder.catalog()).isEmpty());
    }

    @Test
    void aListPositionPointsAtAnOrderedListAndHoldsNothingBelow() {
        IllegalArgumentException refused = assertThrows(IllegalArgumentException.class,
                () -> builder.node("Query").edge("source", builder.node("AliasedQuerySource")));
        assertTrue(refused.getMessage().contains("is a list"), refused.getMessage());
        List<String> problems = ElmConformance.check(builder.build(builder.node("Query")
                .list("source", PublicIds.of(UUID.fromString("0a1b2c3d-4e5f-5a6b-8c7d-9e0f1a2b3c4d"))), TREE),
                builder.catalog());
        assertTrue(problems.isEmpty(), String.join("\n", problems));
    }
}
