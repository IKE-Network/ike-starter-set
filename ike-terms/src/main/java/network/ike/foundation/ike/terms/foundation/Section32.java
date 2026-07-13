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

/** The "Property sequence implication" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section32 {

    private Section32() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Property sequence implication", PublicIds.of(UUID.fromString("9a47a5db-42a6-49ee-9083-54bc305a9456"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("02a235ac-797a-441f-8f3f-6ba0cc702549")), TinkarTerm.ENGLISH_LANGUAGE, "Property sequence implication", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("512c1f3e-e079-43a3-afb2-201332f61b45")), TinkarTerm.ENGLISH_LANGUAGE, "Property sequence implication", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("21b38d2d-3b4a-4e69-82cd-ca2eb38cbb9f")), TinkarTerm.ENGLISH_LANGUAGE, "Property sequence implication (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("99fae8da-dd4e-4f46-87b9-bc7c1d078d6e")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "53f866d0-fd61-5c85-a16c-150bd619a0ac")
                .statedAxioms(PublicIds.of(UUID.fromString("14f32de1-40b0-599b-bbaf-017aed72d2e8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.OBJECT_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d48040a4-ade7-4243-bb7c-3d174f107520")))
                .semanticOn(PublicIds.of(UUID.fromString("02a235ac-797a-441f-8f3f-6ba0cc702549")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("79e115d0-8d03-4d52-96d5-91f8df8edb4d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("512c1f3e-e079-43a3-afb2-201332f61b45")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d18dc2c2-c71c-476b-a5df-b6af30e51dca")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("21b38d2d-3b4a-4e69-82cd-ca2eb38cbb9f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1b07440a-1aa4-4a06-b04f-9a928426c712")), TinkarTerm.PREFERRED)
                ;

    }
}
