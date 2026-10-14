package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Grouping" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section38 {

    private Section38() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Grouping (SOLOR)", PublicIds.of(UUID.fromString("8d76ead7-6c75-5d25-84d4-ca76d928f8a6"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e273ad36-3e0c-422f-8118-42b42e873492")), KernelTerm.ENGLISH_LANGUAGE, "Grouping (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9117bc68-e104-4945-b26b-2034a0c87f67")), KernelTerm.ENGLISH_LANGUAGE, "Grouping", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f11b11e8-3da3-4f6f-9481-a7cde788b3c1")), KernelTerm.ENGLISH_LANGUAGE, "Grouping", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("080955e7-2531-4cac-ab76-740fe6f483ba")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "8d76ead7-6c75-5d25-84d4-ca76d928f8a6")
                .statedAxioms(PublicIds.of(UUID.fromString("036f72e0-499c-5561-96cc-dfc91110d52f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5b6f5ae3-2f9a-452c-9353-8f7645a47f3a")))
                .semanticOn(PublicIds.of(UUID.fromString("e273ad36-3e0c-422f-8118-42b42e873492")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("73a62fd5-edc6-48e8-98ba-62cb5525166d")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9117bc68-e104-4945-b26b-2034a0c87f67")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fa82534a-eb29-4f90-93f3-f833e8d503e7")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f11b11e8-3da3-4f6f-9481-a7cde788b3c1")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("465223c3-9592-4a14-a2e2-fb6608b5fd25")), KernelTerm.PREFERRED)
                ;

        set.concept("Exact (SOLOR)", PublicIds.of(UUID.fromString("8aa6421d-4966-5230-ae5f-aca96ee9c2c1"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0b8c7340-5221-492e-877d-b9f89614fd04")), KernelTerm.ENGLISH_LANGUAGE, "Exact (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("52c81302-8c22-4212-8f3a-f1ef47349093")), KernelTerm.ENGLISH_LANGUAGE, "Exact", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b5ad440d-20af-49bf-acd6-4fa93ae76a11")), KernelTerm.ENGLISH_LANGUAGE, "Source and target are semantic or exact lexical match", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("2a7237b5-b5b5-4768-8c35-67f361870b47")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "8aa6421d-4966-5230-ae5f-aca96ee9c2c1")
                .statedAxioms(PublicIds.of(UUID.fromString("d877910f-c4c0-5c4a-9544-5995df682231")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Grouping (SOLOR)", PublicIds.of("8d76ead7-6c75-5d25-84d4-ca76d928f8a6"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d7d57673-385d-45a7-a7c5-73e4dc49e8ae")))
                .semanticOn(PublicIds.of(UUID.fromString("0b8c7340-5221-492e-877d-b9f89614fd04")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("017a6e46-705b-4e4a-afe3-df3aa763233d")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("52c81302-8c22-4212-8f3a-f1ef47349093")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a4f4934d-8f17-476f-8d3e-6005b681c9c1")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b5ad440d-20af-49bf-acd6-4fa93ae76a11")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("50a04930-17fb-4bf1-bfc9-4f739d5041a6")), KernelTerm.PREFERRED)
                ;

        set.concept("Partial (SOLOR)", PublicIds.of(UUID.fromString("a7f9574c-8e8b-515d-9c21-9896063cc3b8"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b08b3e99-9ddc-4593-b8e8-fa7d4a87da2b")), KernelTerm.ENGLISH_LANGUAGE, "Partial (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c9f297c1-c42e-4cf8-9cd8-fa0fabc83887")), KernelTerm.ENGLISH_LANGUAGE, "Partial", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("03dbbf93-4a35-4768-a766-76f5cd0a3c4b")), KernelTerm.ENGLISH_LANGUAGE, "Exists in/ Inclusion of ?", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("38f0b479-5e18-48e3-8b29-d016616cac65")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "a7f9574c-8e8b-515d-9c21-9896063cc3b8")
                .statedAxioms(PublicIds.of(UUID.fromString("ba2c4173-ec03-51df-9988-a9afef20029e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Grouping (SOLOR)", PublicIds.of("8d76ead7-6c75-5d25-84d4-ca76d928f8a6"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("60d67466-a279-4735-92fa-02c8290a3866")))
                .semanticOn(PublicIds.of(UUID.fromString("b08b3e99-9ddc-4593-b8e8-fa7d4a87da2b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b1f4bce4-d174-44fb-be82-3c9e64700e3b")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c9f297c1-c42e-4cf8-9cd8-fa0fabc83887")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f127e8e0-63b1-48a9-b328-a2322fdfb867")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("03dbbf93-4a35-4768-a766-76f5cd0a3c4b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("77ff5144-9521-4326-9186-23d73772e8d8")), KernelTerm.PREFERRED)
                ;

    }
}
