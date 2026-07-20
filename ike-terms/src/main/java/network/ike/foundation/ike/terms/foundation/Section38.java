package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Grouping" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section38 {

    private Section38() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Grouping (SOLOR)", PublicIds.of("8d76ead7-6c75-5d25-84d4-ca76d928f8a6")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e273ad36-3e0c-422f-8118-42b42e873492"), IkeTerm.ENGLISH_LANGUAGE, "Grouping (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9117bc68-e104-4945-b26b-2034a0c87f67"), IkeTerm.ENGLISH_LANGUAGE, "Grouping", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f11b11e8-3da3-4f6f-9481-a7cde788b3c1"), IkeTerm.ENGLISH_LANGUAGE, "Grouping", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("080955e7-2531-4cac-ab76-740fe6f483ba"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8d76ead7-6c75-5d25-84d4-ca76d928f8a6")
                .statedAxioms(PublicIds.of("036f72e0-499c-5561-96cc-dfc91110d52f"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5b6f5ae3-2f9a-452c-9353-8f7645a47f3a"))
                .semanticOn(PublicIds.of("e273ad36-3e0c-422f-8118-42b42e873492"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("73a62fd5-edc6-48e8-98ba-62cb5525166d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9117bc68-e104-4945-b26b-2034a0c87f67"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fa82534a-eb29-4f90-93f3-f833e8d503e7"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f11b11e8-3da3-4f6f-9481-a7cde788b3c1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("465223c3-9592-4a14-a2e2-fb6608b5fd25"), IkeTerm.PREFERRED)
                ;

        set.concept("Exact (SOLOR)", PublicIds.of("8aa6421d-4966-5230-ae5f-aca96ee9c2c1")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0b8c7340-5221-492e-877d-b9f89614fd04"), IkeTerm.ENGLISH_LANGUAGE, "Exact (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("52c81302-8c22-4212-8f3a-f1ef47349093"), IkeTerm.ENGLISH_LANGUAGE, "Exact", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b5ad440d-20af-49bf-acd6-4fa93ae76a11"), IkeTerm.ENGLISH_LANGUAGE, "Source and target are semantic or exact lexical match", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("2a7237b5-b5b5-4768-8c35-67f361870b47"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8aa6421d-4966-5230-ae5f-aca96ee9c2c1")
                .statedAxioms(PublicIds.of("d877910f-c4c0-5c4a-9544-5995df682231"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.GROUPING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d7d57673-385d-45a7-a7c5-73e4dc49e8ae"))
                .semanticOn(PublicIds.of("0b8c7340-5221-492e-877d-b9f89614fd04"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("017a6e46-705b-4e4a-afe3-df3aa763233d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("52c81302-8c22-4212-8f3a-f1ef47349093"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a4f4934d-8f17-476f-8d3e-6005b681c9c1"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b5ad440d-20af-49bf-acd6-4fa93ae76a11"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("50a04930-17fb-4bf1-bfc9-4f739d5041a6"), IkeTerm.PREFERRED)
                ;

        set.concept("Partial (SOLOR)", PublicIds.of("a7f9574c-8e8b-515d-9c21-9896063cc3b8")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b08b3e99-9ddc-4593-b8e8-fa7d4a87da2b"), IkeTerm.ENGLISH_LANGUAGE, "Partial (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c9f297c1-c42e-4cf8-9cd8-fa0fabc83887"), IkeTerm.ENGLISH_LANGUAGE, "Partial", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("03dbbf93-4a35-4768-a766-76f5cd0a3c4b"), IkeTerm.ENGLISH_LANGUAGE, "Exists in/ Inclusion of ?", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("38f0b479-5e18-48e3-8b29-d016616cac65"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a7f9574c-8e8b-515d-9c21-9896063cc3b8")
                .statedAxioms(PublicIds.of("ba2c4173-ec03-51df-9988-a9afef20029e"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.GROUPING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("60d67466-a279-4735-92fa-02c8290a3866"))
                .semanticOn(PublicIds.of("b08b3e99-9ddc-4593-b8e8-fa7d4a87da2b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b1f4bce4-d174-44fb-be82-3c9e64700e3b"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c9f297c1-c42e-4cf8-9cd8-fa0fabc83887"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f127e8e0-63b1-48a9-b328-a2322fdfb867"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("03dbbf93-4a35-4768-a766-76f5cd0a3c4b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("77ff5144-9521-4326-9186-23d73772e8d8"), IkeTerm.PREFERRED)
                ;

    }
}
