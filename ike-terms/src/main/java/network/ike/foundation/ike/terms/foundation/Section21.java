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

/** The "Axiom Syntax" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section21 {

    private Section21() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Axiom Syntax (SOLOR)", PublicIds.of(UUID.fromString("8da1c508-c2a2-4899-b26d-87f8b98a7558"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("10d5545f-429d-463b-9c84-3a189a0657e0")), TinkarTerm.ENGLISH_LANGUAGE, "Axiom Syntax (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7a1b2e82-9aea-47f1-928e-d1358bbc4531")), TinkarTerm.ENGLISH_LANGUAGE, "Axiom Syntax", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("eec5f49f-a2b5-492d-858f-c39d3302dbc7")), TinkarTerm.ENGLISH_LANGUAGE, "Syntax defining description logic", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("99c902ec-5b72-4f04-a6ab-1f14ddb9ae93")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8da1c508-c2a2-4899-b26d-87f8b98a7558")
                .statedAxioms(PublicIds.of(UUID.fromString("75a6b3a0-5f36-53e1-8273-f84387c33fd1")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Axioms", PublicIds.of(UUID.fromString("20746b91-521a-45a6-89da-0fe32384a67f")))))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("cf3c3e2d-013e-4ed7-8790-ad98b0355ce1")))
                .semanticOn(PublicIds.of(UUID.fromString("10d5545f-429d-463b-9c84-3a189a0657e0")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("22bc6a15-7c73-4e74-be86-60ae657f5bf8")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7a1b2e82-9aea-47f1-928e-d1358bbc4531")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a2d461de-2833-4a70-b899-2ab9d654dde2")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("eec5f49f-a2b5-492d-858f-c39d3302dbc7")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1b1aee32-3623-496a-ac53-326d531839b8")), TinkarTerm.PREFERRED)
                ;

        set.concept("Express axiom syntax (SOLOR)", PublicIds.of(UUID.fromString("db55557c-e9ee-4504-aae3-df695b6d6c57"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8b2ad7c5-1781-4117-939e-b72c91c175e5")), TinkarTerm.ENGLISH_LANGUAGE, "Express axiom syntax (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ecbfe97a-c068-4d98-9a4a-d024f389d250")), TinkarTerm.ENGLISH_LANGUAGE, "Express Axiom", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6aaf53ee-ff4b-43c9-9930-122db32d3a6e")), TinkarTerm.ENGLISH_LANGUAGE, "Expressing description logic through syntax", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0fab2a03-22df-4c2d-acfb-b954a2aca88e")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "db55557c-e9ee-4504-aae3-df695b6d6c57")
                .statedAxioms(PublicIds.of(UUID.fromString("dd255369-f881-55ec-b645-6674821b0ca6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.AXIOM_SYNTAX))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("298e8c38-1270-4b16-9dc8-dbe0ea2096a6")))
                .semanticOn(PublicIds.of(UUID.fromString("8b2ad7c5-1781-4117-939e-b72c91c175e5")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bfb9ad35-5b4e-4ac0-8de7-60ccc6e54e8c")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ecbfe97a-c068-4d98-9a4a-d024f389d250")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d2c9b18d-885b-494d-afc9-3c664c3bf71d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6aaf53ee-ff4b-43c9-9930-122db32d3a6e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("22e03191-7939-4062-b59d-b9eab28d3dde")), TinkarTerm.PREFERRED)
                ;

    }
}
