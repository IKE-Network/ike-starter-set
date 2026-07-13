package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Grouping" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section38 {

    private Section38() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Grouping (SOLOR)", PublicIds.of(UUID.fromString("8d76ead7-6c75-5d25-84d4-ca76d928f8a6"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e273ad36-3e0c-422f-8118-42b42e873492")), TinkarTerm.ENGLISH_LANGUAGE, "Grouping (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9117bc68-e104-4945-b26b-2034a0c87f67")), TinkarTerm.ENGLISH_LANGUAGE, "Grouping", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f11b11e8-3da3-4f6f-9481-a7cde788b3c1")), TinkarTerm.ENGLISH_LANGUAGE, "Grouping", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("080955e7-2531-4cac-ab76-740fe6f483ba")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8d76ead7-6c75-5d25-84d4-ca76d928f8a6")
                .statedAxioms(PublicIds.of(UUID.fromString("036f72e0-499c-5561-96cc-dfc91110d52f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5b6f5ae3-2f9a-452c-9353-8f7645a47f3a")))
                .semanticOn(PublicIds.of(UUID.fromString("e273ad36-3e0c-422f-8118-42b42e873492")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("73a62fd5-edc6-48e8-98ba-62cb5525166d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9117bc68-e104-4945-b26b-2034a0c87f67")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fa82534a-eb29-4f90-93f3-f833e8d503e7")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f11b11e8-3da3-4f6f-9481-a7cde788b3c1")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("465223c3-9592-4a14-a2e2-fb6608b5fd25")), TinkarTerm.PREFERRED)
                ;

        set.concept("Exact (SOLOR)", PublicIds.of(UUID.fromString("8aa6421d-4966-5230-ae5f-aca96ee9c2c1"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0b8c7340-5221-492e-877d-b9f89614fd04")), TinkarTerm.ENGLISH_LANGUAGE, "Exact (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("52c81302-8c22-4212-8f3a-f1ef47349093")), TinkarTerm.ENGLISH_LANGUAGE, "Exact", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b5ad440d-20af-49bf-acd6-4fa93ae76a11")), TinkarTerm.ENGLISH_LANGUAGE, "Source and target are semantic or exact lexical match", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("2a7237b5-b5b5-4768-8c35-67f361870b47")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8aa6421d-4966-5230-ae5f-aca96ee9c2c1")
                .statedAxioms(PublicIds.of(UUID.fromString("d877910f-c4c0-5c4a-9544-5995df682231")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.GROUPING))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d7d57673-385d-45a7-a7c5-73e4dc49e8ae")))
                .semanticOn(PublicIds.of(UUID.fromString("0b8c7340-5221-492e-877d-b9f89614fd04")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("017a6e46-705b-4e4a-afe3-df3aa763233d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("52c81302-8c22-4212-8f3a-f1ef47349093")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a4f4934d-8f17-476f-8d3e-6005b681c9c1")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b5ad440d-20af-49bf-acd6-4fa93ae76a11")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("50a04930-17fb-4bf1-bfc9-4f739d5041a6")), TinkarTerm.PREFERRED)
                ;

        set.concept("Partial (SOLOR)", PublicIds.of(UUID.fromString("a7f9574c-8e8b-515d-9c21-9896063cc3b8"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b08b3e99-9ddc-4593-b8e8-fa7d4a87da2b")), TinkarTerm.ENGLISH_LANGUAGE, "Partial (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c9f297c1-c42e-4cf8-9cd8-fa0fabc83887")), TinkarTerm.ENGLISH_LANGUAGE, "Partial", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("03dbbf93-4a35-4768-a766-76f5cd0a3c4b")), TinkarTerm.ENGLISH_LANGUAGE, "Exists in/ Inclusion of ?", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("38f0b479-5e18-48e3-8b29-d016616cac65")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a7f9574c-8e8b-515d-9c21-9896063cc3b8")
                .statedAxioms(PublicIds.of(UUID.fromString("ba2c4173-ec03-51df-9988-a9afef20029e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.GROUPING))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("60d67466-a279-4735-92fa-02c8290a3866")))
                .semanticOn(PublicIds.of(UUID.fromString("b08b3e99-9ddc-4593-b8e8-fa7d4a87da2b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b1f4bce4-d174-44fb-be82-3c9e64700e3b")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c9f297c1-c42e-4cf8-9cd8-fa0fabc83887")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f127e8e0-63b1-48a9-b328-a2322fdfb867")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("03dbbf93-4a35-4768-a766-76f5cd0a3c4b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("77ff5144-9521-4326-9186-23d73772e8d8")), TinkarTerm.PREFERRED)
                ;

    }
}
