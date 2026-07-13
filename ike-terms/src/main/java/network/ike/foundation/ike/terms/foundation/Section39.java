package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Axiom origin" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section39 {

    private Section39() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        set.concept("Axiom origin (SOLOR)", PublicIds.of(UUID.fromString("b868bd83-5cd4-5d84-9cf7-b08674fbc79b"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("63db609e-892c-497a-8831-c218985f8f00")), IkeTerm.ENGLISH_LANGUAGE, "Axiom origin (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("28d8e2e4-9bd3-4298-adb3-779f7bf9251c")), IkeTerm.ENGLISH_LANGUAGE, "Axiom origin", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("032b9774-afb8-40e9-b3b1-0f953a78ca51")), IkeTerm.ENGLISH_LANGUAGE, "The parent concept for the axiom?", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("265924d2-ae16-4bc7-ae53-dc20694d40ae")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b868bd83-5cd4-5d84-9cf7-b08674fbc79b")
                .statedAxioms(PublicIds.of(UUID.fromString("42ea2dff-fe73-59d7-b8f4-2ab7863572d8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Axioms", PublicIds.of(UUID.fromString("20746b91-521a-45a6-89da-0fe32384a67f")))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5910b1fa-991c-47ea-a5ec-64279db8bf3f")))
                .semanticOn(PublicIds.of(UUID.fromString("63db609e-892c-497a-8831-c218985f8f00")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("92d63eb8-dc61-42a0-b880-ab76abbabba3")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("28d8e2e4-9bd3-4298-adb3-779f7bf9251c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1d5871a6-f3e1-437b-8e0b-93d2a08e004b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("032b9774-afb8-40e9-b3b1-0f953a78ca51")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6b64ebc5-7107-4b22-abfa-e96804a118d8")), IkeTerm.PREFERRED)
                ;

        set.concept("Stated premise type (SOLOR)", PublicIds.of(UUID.fromString("3b0dbd3b-2e53-3a30-8576-6c7fa7773060"), UUID.fromString("3fde38f6-e079-3cdc-a819-eda3ec74732d"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4b682274-a7f8-4315-9b45-89734600c5c5")), IkeTerm.ENGLISH_LANGUAGE, "Stated premise type (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("941aa4cb-6320-4733-966b-14c39ee00e76")), IkeTerm.ENGLISH_LANGUAGE, "Stated", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("164f5046-e620-4feb-b556-37efecc3e372")), IkeTerm.ENGLISH_LANGUAGE, "Stated relationship", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("aefe6fd0-df59-4709-b61b-7c715b957c09")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "3b0dbd3b-2e53-3a30-8576-6c7fa7773060")
                .statedAxioms(PublicIds.of(UUID.fromString("80ce27d5-5872-513a-8adf-ebf375ceee50")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.AXIOM_ORIGIN))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("71ef4700-597c-49af-968b-176ee3c6ff08")))
                .semanticOn(PublicIds.of(UUID.fromString("4b682274-a7f8-4315-9b45-89734600c5c5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("dfdcdae0-1670-4eda-b5f4-05f2c9240c28")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("941aa4cb-6320-4733-966b-14c39ee00e76")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e02a7c0a-7148-4b2e-b656-7fcd6e1e395e")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("164f5046-e620-4feb-b556-37efecc3e372")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fbcd8bee-1612-4480-9a6e-cbff35749e22")), IkeTerm.PREFERRED)
                ;

        set.concept("Inferred premise type (SOLOR)", PublicIds.of(UUID.fromString("a4c6bf72-8fb6-11db-b606-0800200c9a66"), UUID.fromString("1290e6ba-48d0-31d2-8d62-e133373c63f5"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("673de880-2c35-42c0-a374-657feed7b1d6")), IkeTerm.ENGLISH_LANGUAGE, "Inferred premise type (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2049c4a3-cef5-489b-ad58-8630908007c9")), IkeTerm.ENGLISH_LANGUAGE, "Inferred relationship / Inferred", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a2f28409-132a-4a82-8158-7e43af2d40b2")), IkeTerm.ENGLISH_LANGUAGE, "The axiom view following the application of the reasoner", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("b63b2d32-c577-4663-8bf9-fe810ecc6b38")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a4c6bf72-8fb6-11db-b606-0800200c9a66")
                .statedAxioms(PublicIds.of(UUID.fromString("7ed6053d-28f1-5065-85c5-061491e681c6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.AXIOM_ORIGIN))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("847ef220-39d5-48c1-9edb-88982cd52031")))
                .semanticOn(PublicIds.of(UUID.fromString("673de880-2c35-42c0-a374-657feed7b1d6")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("82aed77e-b42b-4ac7-a26d-083dc1a5426c")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2049c4a3-cef5-489b-ad58-8630908007c9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b7656d5c-62ed-40a9-b7c4-4a1d9ab0a1ea")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a2f28409-132a-4a82-8158-7e43af2d40b2")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("458ad54c-7f10-4229-b56a-733c154ca22d")), IkeTerm.PREFERRED)
                ;

    }
}
