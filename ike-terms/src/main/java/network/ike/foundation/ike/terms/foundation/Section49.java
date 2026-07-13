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

/** The "Annotation property set" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section49 {

    private Section49() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Annotation property set", PublicIds.of(UUID.fromString("cb9e33de-f82c-495d-89fa-69afecbcd47d"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("69be3ae3-6f24-42ae-819e-a91a69959ab4")), TinkarTerm.ENGLISH_LANGUAGE, "Annotation property set", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c85fd08c-f0ba-4058-a963-738bcefb7c1b")), TinkarTerm.ENGLISH_LANGUAGE, "Annotation property set", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("da5b80d1-b026-4416-a21e-8d023580ea9b")), TinkarTerm.ENGLISH_LANGUAGE, "Annotation property set (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("788c7955-1d9d-4de4-921d-77b723337b63")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "53f866d0-fd61-5c85-a16c-150bd619a0ac")
                .statedAxioms(PublicIds.of(UUID.fromString("d00a01be-fc68-5e82-af39-0b4cb2893e4f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.OBJECT_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e92b2100-73ca-4999-bdbe-ae39a3060bf7")))
                .semanticOn(PublicIds.of(UUID.fromString("69be3ae3-6f24-42ae-819e-a91a69959ab4")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3b7cfed5-8b3e-4a5d-a4c0-4b78c5d3bf48")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c85fd08c-f0ba-4058-a963-738bcefb7c1b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("659c28c7-ac72-4fd8-a9da-7dd265560607")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("da5b80d1-b026-4416-a21e-8d023580ea9b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cb113102-65c1-4b7e-af8b-ecd26e46cae4")), TinkarTerm.PREFERRED)
                ;

    }
}
