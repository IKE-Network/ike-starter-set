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

/** The "Component type focus" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section35 {

    private Section35() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Component type focus (SOLOR)", PublicIds.of(UUID.fromString("f1f179d0-26af-5123-9b29-9fc6cd01dd29"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("eb4bd537-5b29-449c-9798-aeb95d56cecd")), TinkarTerm.ENGLISH_LANGUAGE, "Component type focus (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0b65dda0-b2bd-48ae-a3ba-1e465daf4798")), TinkarTerm.ENGLISH_LANGUAGE, "Component type focus", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("253fab55-ce5b-42e8-9eea-cc856e24b921")), TinkarTerm.ENGLISH_LANGUAGE, "Focus type of component", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4b3ed6e0-49ff-443e-a945-d6ca2c52796f")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f1f179d0-26af-5123-9b29-9fc6cd01dd29")
                .statedAxioms(PublicIds.of(UUID.fromString("0fbf89bc-93c2-55b0-ae6e-9649d2b8db63")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f4cc29cc-bc14-4328-86ce-b86c0b54add3")))
                .semanticOn(PublicIds.of(UUID.fromString("eb4bd537-5b29-449c-9798-aeb95d56cecd")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("728661b5-cac7-466b-8cdb-e4d8e5263528")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0b65dda0-b2bd-48ae-a3ba-1e465daf4798")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("27d420ad-b09f-4911-b161-5b35310dc195")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("253fab55-ce5b-42e8-9eea-cc856e24b921")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("50f0a9f5-55d6-4b84-9206-a4f49290e550")), TinkarTerm.PREFERRED)
                ;

        set.concept("Concept focus (SOLOR)", PublicIds.of(UUID.fromString("dca9854d-9e4c-5e8a-8b30-6c1af6901bb8"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("229a5aea-9df5-4732-8d6b-8ed485074c41")), TinkarTerm.ENGLISH_LANGUAGE, "Concept focus (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("43902790-b740-44fb-b6cb-7a20020c5385")), TinkarTerm.ENGLISH_LANGUAGE, "Concept focus", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("70a95faa-822f-4098-904c-c2e0cef24ba6")), TinkarTerm.ENGLISH_LANGUAGE, "Concept focus", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("98b908a7-8fcd-44ec-afd9-338cfc07750d")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "dca9854d-9e4c-5e8a-8b30-6c1af6901bb8")
                .statedAxioms(PublicIds.of(UUID.fromString("496c2dab-7d21-5e0a-8bfc-f4396a463501")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.COMPONENT_TYPE_FOCUS))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("34f7a5a4-4664-4ceb-832b-ff5aaa907889")))
                .semanticOn(PublicIds.of(UUID.fromString("229a5aea-9df5-4732-8d6b-8ed485074c41")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("dbfddfa0-1c68-4ac2-8576-f16308e1251c")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("43902790-b740-44fb-b6cb-7a20020c5385")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b088ce55-115d-4f4b-a319-367b91cc39d0")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("70a95faa-822f-4098-904c-c2e0cef24ba6")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bdb1f062-144c-45dc-9e45-6472f68bf642")), TinkarTerm.PREFERRED)
                ;

        set.concept("Axiom focus (SOLOR)", PublicIds.of(UUID.fromString("9c6fbddd-58bd-5881-b926-c813bbff849b"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("823a7eee-fde7-4964-a407-1181e592eb34")), TinkarTerm.ENGLISH_LANGUAGE, "Axiom focus (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("37705299-7a2d-46b8-9760-daf643f68d77")), TinkarTerm.ENGLISH_LANGUAGE, "Axiom focus", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1709386f-9130-4f11-ac43-02fe7f9bb71d")), TinkarTerm.ENGLISH_LANGUAGE, "A statement or proposition that is assumed to be true without requiring proof, it serves as a foundation principles on which a system or theory is built. Focus refers to the central point of attention or concentration on a specific concept/axioms", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("a9ff2040-3a06-485e-b164-823f37c6ecfe")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "9c6fbddd-58bd-5881-b926-c813bbff849b")
                .statedAxioms(PublicIds.of(UUID.fromString("4e3bc3ec-dafb-535d-a6af-f08291071ae7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.COMPONENT_TYPE_FOCUS))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("70643d78-bcbe-4656-9206-53ee91853da0")))
                .semanticOn(PublicIds.of(UUID.fromString("823a7eee-fde7-4964-a407-1181e592eb34")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4291e69a-93e7-4839-92f2-b5cefc9d3dbb")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("37705299-7a2d-46b8-9760-daf643f68d77")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ff1cf8bc-b2ae-4048-b726-ff41735df3c3")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1709386f-9130-4f11-ac43-02fe7f9bb71d")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2afc7d9f-6acf-46e5-aef0-3424521895c0")), TinkarTerm.PREFERRED)
                ;

        set.concept("Description focus (SOLOR)", PublicIds.of(UUID.fromString("6edf734d-7f57-5430-9164-6ee0824fd94b"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("11614fdc-1dd7-4ea1-8c4e-62fc4feecef6")), TinkarTerm.ENGLISH_LANGUAGE, "Description focus (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("55c3d405-df44-49dc-a536-6dd2049ac5f5")), TinkarTerm.ENGLISH_LANGUAGE, "Description focus", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("abf0aa8d-427b-4e7e-9484-0717aa1d2622")), TinkarTerm.ENGLISH_LANGUAGE, "Description focus", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("dba3bcf4-66a5-4f56-a02d-24e190671e86")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6edf734d-7f57-5430-9164-6ee0824fd94b")
                .statedAxioms(PublicIds.of(UUID.fromString("c1ddad0b-615b-5290-bde4-290b6bceea91")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.COMPONENT_TYPE_FOCUS))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8dfbaa03-846b-4e78-bfa2-e366cf79689c")))
                .semanticOn(PublicIds.of(UUID.fromString("11614fdc-1dd7-4ea1-8c4e-62fc4feecef6")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a0657581-84aa-44ce-8ddd-8b101294fc6c")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("55c3d405-df44-49dc-a536-6dd2049ac5f5")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5a377fce-6fbb-4df6-ac56-5cd47e0b7e23")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("abf0aa8d-427b-4e7e-9484-0717aa1d2622")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("920b56b7-ee4c-48ea-9b1f-1ed5c30cc824")), TinkarTerm.PREFERRED)
                ;

    }
}
