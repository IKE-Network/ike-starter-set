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

/** The "Relationship origin" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section69 {

    private Section69() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Relationship origin", PublicIds.of(UUID.fromString("ad22d43b-3ee7-550b-9660-a6e68af347c2"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("472c36ae-31a0-4a7c-a323-45c8a8f5e54a")), TinkarTerm.ENGLISH_LANGUAGE, "Relationship origin", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ef58a47b-f1e5-4eec-bbd0-09b3faacfc0a")), TinkarTerm.ENGLISH_LANGUAGE, "Relationship origin", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5bbef76e-4a3f-4571-86fc-0db0ade8234c")), TinkarTerm.ENGLISH_LANGUAGE, "Signifies path to parent concepts which are more general than the Tinkar term", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("1aac51d1-c9be-4815-be87-4b046cbae8c1")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ad22d43b-3ee7-550b-9660-a6e68af347c2")
                .statedAxioms(PublicIds.of(UUID.fromString("d623877c-1357-53d5-b30d-7cb559b8cde9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("605a98e3-6894-49ff-9ef2-c699b2bb8944")))
                .semanticOn(PublicIds.of(UUID.fromString("472c36ae-31a0-4a7c-a323-45c8a8f5e54a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6e6d95fb-aa73-4213-8a04-3fd3a981334b")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ef58a47b-f1e5-4eec-bbd0-09b3faacfc0a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0cf44be7-a9e1-4333-a93a-8bc787641c37")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5bbef76e-4a3f-4571-86fc-0db0ade8234c")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("396a8a45-eef7-4ccc-b12e-30b34b43b39e")), TinkarTerm.PREFERRED)
                ;

    }
}
