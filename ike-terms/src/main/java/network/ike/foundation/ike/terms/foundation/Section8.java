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

/** The "Identifier Value" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section8 {

    private Section8() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Identifier Value (SOLOR)", PublicIds.of(UUID.fromString("b32dd26b-c3fc-487e-987e-16ace71a0d0f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("30feb16d-f515-42a4-920e-aeaa7706e4f3")), TinkarTerm.ENGLISH_LANGUAGE, "Identifier Value (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9d6c5a02-fd9e-4dbe-b02a-6c7008612c0b")), TinkarTerm.ENGLISH_LANGUAGE, "Identifier Value", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2ce31162-c756-4e73-84da-ae6337f8d9f4")), TinkarTerm.ENGLISH_LANGUAGE, "The literal string value identifier", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ff1246ef-f25a-4623-8f4a-2117bc07c61b")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b32dd26b-c3fc-487e-987e-16ace71a0d0f")
                .statedAxioms(PublicIds.of(UUID.fromString("3d08c515-d4de-5236-adda-9e81993d6751")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c735f799-4a85-42e2-82a4-5b72172facf7")))
                .semanticOn(PublicIds.of(UUID.fromString("30feb16d-f515-42a4-920e-aeaa7706e4f3")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("648175c8-df7f-4348-a26f-5d160bccab96")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9d6c5a02-fd9e-4dbe-b02a-6c7008612c0b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("43baca0f-f17d-45c7-b729-fb5b54cdad2b")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2ce31162-c756-4e73-84da-ae6337f8d9f4")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("36b967de-d261-48c1-bb11-94b0a9470119")), TinkarTerm.PREFERRED)
                ;

    }
}
