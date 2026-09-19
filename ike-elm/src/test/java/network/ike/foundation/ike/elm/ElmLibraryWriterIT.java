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

import dev.ikm.tinkar.common.id.IntIdList;
import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.terms.Ike;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The example library becomes one concept and its semantics: the identity record, a using, a
 * value set, a context, a define with its name in the CQL dialect, one ordered list with one
 * item, and one reference from the define to the value set. Written again, it is the same
 * library, because every identity is derived.
 */
class ElmLibraryWriterIT {

    private static StampCalculator calculator;
    private static ElmTreeBuilder builder;
    private static ElmLibraryWriter writer;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        builder = new ElmTreeBuilder(Store.catalog());
        writer = new ElmLibraryWriter(builder, calculator, Ike.INCEPTION);
    }

    private static ImmutableList<Object> fields(int semanticNid) {
        Latest<SemanticEntityVersion> latest = calculator.latest(semanticNid);
        assertTrue(latest.isPresent(), "semantic " + semanticNid + " has a latest version");
        return latest.get().fieldValues();
    }

    private static List<Integer> semanticsAbout(int componentNid, EntityProxy.Pattern pattern) {
        List<Integer> nids = new ArrayList<>();
        EntityService.get().forEachSemanticForComponentOfPattern(componentNid, pattern.nid(),
                semantic -> nids.add(semantic.nid()));
        return nids;
    }

    private static PublicId writeDiabetes() {
        PublicId library = writer.library("Diabetes", "1.0", "");
        writer.definition("Diabetes", builder.node("UsingDef")
                .property("localIdentifier", "FHIR").property("uri", "http://hl7.org/fhir")
                .property("version", "4.0.1"), "FHIR", List.of());
        PublicId valueSet = writer.definition("Diabetes", builder.node("ValueSetDef")
                .property("name", "Diabetes").property("id", "http://example.org/vs/diabetes"), "Diabetes", List.of());
        writer.definition("Diabetes", builder.node("ContextDef").property("name", "Patient"), "Patient", List.of());

        ElmNode source = builder.node("AliasedQuerySource").property("alias", "C")
                .edge("expression", builder.node("Retrieve")
                        .property("dataType", "{http://hl7.org/fhir}Condition")
                        .property("codeProperty", "code")
                        .edge("codes", builder.node("ValueSetRef").property("name", "Diabetes")));
        PublicId item = writer.item("Diabetes", source, "AliasedQuerySource C = [Condition: Diabetes]");
        PublicId define = ElmIdentity.definition("Diabetes", "ExpressionDef", "Has Diabetes", List.of());
        PublicId sources = writer.orderedList(define, "expression/operand/source", List.of(item));
        PublicId written = writer.definition("Diabetes", builder.node("ExpressionDef")
                .property("name", "Has Diabetes").property("context", "Patient")
                .property("accessLevel", AccessModifier.PUBLIC)
                .edge("expression", builder.node("Exists")
                        .edge("operand", builder.node("Query")
                                .list("source", sources)
                                .edge("where", ElmTreeBuilderIT.whereClause(builder)))), "Has Diabetes", List.of());
        assertEquals(define, written, "the define's identity is derived before it is written");
        writer.reference(define, "ValueSetRef", valueSet, "Diabetes", "");
        return library;
    }

    @Test
    void theLibraryBecomesOneConceptAndItsSemantics() {
        PublicId library = writeDiabetes();
        int libraryNid = PrimitiveData.nid(library);
        assertTrue(calculator.latest(libraryNid).isPresent(), "the library concept has a version");

        List<Integer> trees = semanticsAbout(libraryNid, IkeTerms.ELM_TREE_PATTERN);
        assertEquals(6, trees.size(), "identity record, using, value set, context, define, and one item");
        for (int nid : trees) {
            DiTreeEntity tree = (DiTreeEntity) fields(nid).get(0);
            assertTrue(ElmConformance.check(tree, builder.catalog()).isEmpty(), "every stored tree conforms");
        }

        int defineNid = PrimitiveData.nid(ElmIdentity.definition("Diabetes", "ExpressionDef", "Has Diabetes", List.of()));
        List<Integer> descriptions = semanticsAbout(defineNid, TinkarTerm.DESCRIPTION_PATTERN);
        assertEquals(1, descriptions.size());
        assertEquals("Has Diabetes", fields(descriptions.get(0)).get(1));
        assertEquals(1, semanticsAbout(descriptions.get(0), IkeTerms.CQL_DIALECT_PATTERN).size(),
                "the name is a description in the CQL dialect");

        List<Integer> lists = semanticsAbout(defineNid, IkeTerms.ELM_ORDERED_LIST_PATTERN);
        assertEquals(1, lists.size());
        IntIdList items = (IntIdList) fields(lists.get(0)).get(0);
        assertEquals(1, items.size());
        assertEquals(PrimitiveData.nid(ElmIdentity.item("Diabetes", "AliasedQuerySource C = [Condition: Diabetes]")),
                items.get(0));

        List<Integer> references = semanticsAbout(defineNid, IkeTerms.ELM_REFERENCE_PATTERN);
        assertEquals(1, references.size());
        ImmutableList<Object> fields = fields(references.get(0));
        assertEquals(IkeTerms.ELM_VALUESETREF.nid(), ((EntityProxy.Concept) fields.get(0)).nid());
        assertEquals(PrimitiveData.nid(ElmIdentity.definition("Diabetes", "ValueSetDef", "Diabetes", List.of())),
                ((EntityProxy.Semantic) fields.get(1)).nid());
        assertEquals("Diabetes", fields.get(2));
        assertEquals("", fields.get(3));
    }

    @Test
    void writtenAgainItIsTheSameLibrary() {
        PublicId first = writeDiabetes();
        PublicId second = writeDiabetes();
        assertEquals(first, second);
        assertEquals(6, semanticsAbout(PrimitiveData.nid(first), IkeTerms.ELM_TREE_PATTERN).size(),
                "no second set of semantics appears");
    }
}
