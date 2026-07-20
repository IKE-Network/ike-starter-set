package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Component type focus" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section35 {

    private Section35() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Component type focus (SOLOR)", PublicIds.of("f1f179d0-26af-5123-9b29-9fc6cd01dd29")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("eb4bd537-5b29-449c-9798-aeb95d56cecd"), IkeTerm.ENGLISH_LANGUAGE, "Component type focus (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0b65dda0-b2bd-48ae-a3ba-1e465daf4798"), IkeTerm.ENGLISH_LANGUAGE, "Component type focus", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("253fab55-ce5b-42e8-9eea-cc856e24b921"), IkeTerm.ENGLISH_LANGUAGE, "Focus type of component", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("4b3ed6e0-49ff-443e-a945-d6ca2c52796f"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f1f179d0-26af-5123-9b29-9fc6cd01dd29")
                .statedAxioms(PublicIds.of("0fbf89bc-93c2-55b0-ae6e-9649d2b8db63"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("f4cc29cc-bc14-4328-86ce-b86c0b54add3"))
                .semanticOn(PublicIds.of("eb4bd537-5b29-449c-9798-aeb95d56cecd"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("728661b5-cac7-466b-8cdb-e4d8e5263528"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0b65dda0-b2bd-48ae-a3ba-1e465daf4798"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("27d420ad-b09f-4911-b161-5b35310dc195"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("253fab55-ce5b-42e8-9eea-cc856e24b921"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("50f0a9f5-55d6-4b84-9206-a4f49290e550"), IkeTerm.PREFERRED)
                ;

        set.concept("Concept focus (SOLOR)", PublicIds.of("dca9854d-9e4c-5e8a-8b30-6c1af6901bb8")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("229a5aea-9df5-4732-8d6b-8ed485074c41"), IkeTerm.ENGLISH_LANGUAGE, "Concept focus (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("43902790-b740-44fb-b6cb-7a20020c5385"), IkeTerm.ENGLISH_LANGUAGE, "Concept focus", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("70a95faa-822f-4098-904c-c2e0cef24ba6"), IkeTerm.ENGLISH_LANGUAGE, "Concept focus", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("98b908a7-8fcd-44ec-afd9-338cfc07750d"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "dca9854d-9e4c-5e8a-8b30-6c1af6901bb8")
                .statedAxioms(PublicIds.of("496c2dab-7d21-5e0a-8bfc-f4396a463501"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.COMPONENT_TYPE_FOCUS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("34f7a5a4-4664-4ceb-832b-ff5aaa907889"))
                .semanticOn(PublicIds.of("229a5aea-9df5-4732-8d6b-8ed485074c41"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("dbfddfa0-1c68-4ac2-8576-f16308e1251c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("43902790-b740-44fb-b6cb-7a20020c5385"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b088ce55-115d-4f4b-a319-367b91cc39d0"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("70a95faa-822f-4098-904c-c2e0cef24ba6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bdb1f062-144c-45dc-9e45-6472f68bf642"), IkeTerm.PREFERRED)
                ;

        set.concept("Axiom focus (SOLOR)", PublicIds.of("9c6fbddd-58bd-5881-b926-c813bbff849b")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("823a7eee-fde7-4964-a407-1181e592eb34"), IkeTerm.ENGLISH_LANGUAGE, "Axiom focus (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("37705299-7a2d-46b8-9760-daf643f68d77"), IkeTerm.ENGLISH_LANGUAGE, "Axiom focus", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1709386f-9130-4f11-ac43-02fe7f9bb71d"), IkeTerm.ENGLISH_LANGUAGE, "A statement or proposition that is assumed to be true without requiring proof, it serves as a foundation principles on which a system or theory is built. Focus refers to the central point of attention or concentration on a specific concept/axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("a9ff2040-3a06-485e-b164-823f37c6ecfe"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "9c6fbddd-58bd-5881-b926-c813bbff849b")
                .statedAxioms(PublicIds.of("4e3bc3ec-dafb-535d-a6af-f08291071ae7"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.COMPONENT_TYPE_FOCUS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("70643d78-bcbe-4656-9206-53ee91853da0"))
                .semanticOn(PublicIds.of("823a7eee-fde7-4964-a407-1181e592eb34"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4291e69a-93e7-4839-92f2-b5cefc9d3dbb"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("37705299-7a2d-46b8-9760-daf643f68d77"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ff1cf8bc-b2ae-4048-b726-ff41735df3c3"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("1709386f-9130-4f11-ac43-02fe7f9bb71d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2afc7d9f-6acf-46e5-aef0-3424521895c0"), IkeTerm.PREFERRED)
                ;

        set.concept("Description focus (SOLOR)", PublicIds.of("6edf734d-7f57-5430-9164-6ee0824fd94b")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("11614fdc-1dd7-4ea1-8c4e-62fc4feecef6"), IkeTerm.ENGLISH_LANGUAGE, "Description focus (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("55c3d405-df44-49dc-a536-6dd2049ac5f5"), IkeTerm.ENGLISH_LANGUAGE, "Description focus", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("abf0aa8d-427b-4e7e-9484-0717aa1d2622"), IkeTerm.ENGLISH_LANGUAGE, "Description focus", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("dba3bcf4-66a5-4f56-a02d-24e190671e86"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6edf734d-7f57-5430-9164-6ee0824fd94b")
                .statedAxioms(PublicIds.of("c1ddad0b-615b-5290-bde4-290b6bceea91"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.COMPONENT_TYPE_FOCUS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8dfbaa03-846b-4e78-bfa2-e366cf79689c"))
                .semanticOn(PublicIds.of("11614fdc-1dd7-4ea1-8c4e-62fc4feecef6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a0657581-84aa-44ce-8ddd-8b101294fc6c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("55c3d405-df44-49dc-a536-6dd2049ac5f5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5a377fce-6fbb-4df6-ac56-5cd47e0b7e23"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("abf0aa8d-427b-4e7e-9484-0717aa1d2622"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("920b56b7-ee4c-48ea-9b1f-1ed5c30cc824"), IkeTerm.PREFERRED)
                ;

    }
}
