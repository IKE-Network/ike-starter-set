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

/** The "Description list for concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section62 {

    private Section62() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Description list for concept (SOLOR)", PublicIds.of(UUID.fromString("ab3e8771-7c7c-5e57-8acf-147b16da36e2"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dfe94b0f-e321-4652-b136-567216d9fa5b")), TinkarTerm.ENGLISH_LANGUAGE, "Description list for concept (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("000803ce-c2f5-450c-bea0-1452812cc4bc")), TinkarTerm.ENGLISH_LANGUAGE, "Description list for concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("57be3396-cf3f-40f7-ba9f-c6ba0b6b4239")), TinkarTerm.ENGLISH_LANGUAGE, "List of description", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("070e006c-e1d2-41e7-9bdd-889f1423cdb2")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ab3e8771-7c7c-5e57-8acf-147b16da36e2")
                .statedAxioms(PublicIds.of(UUID.fromString("9c152a95-cb08-53a5-8159-3862aabb925a")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ccc34d44-230c-4fd2-8ee9-c4dd459b3372")))
                .semanticOn(PublicIds.of(UUID.fromString("dfe94b0f-e321-4652-b136-567216d9fa5b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d5585846-bb39-481d-b372-192ecc05ed9f")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("000803ce-c2f5-450c-bea0-1452812cc4bc")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("08a02bd1-4617-4f8b-9803-dce23e3ed75d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("57be3396-cf3f-40f7-ba9f-c6ba0b6b4239")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b886cc86-ce36-4687-87c1-bea89a9b7c39")), TinkarTerm.PREFERRED)
                ;

    }
}
