package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Relationship origin" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section69 {

    private Section69() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Relationship origin", PublicIds.of("ad22d43b-3ee7-550b-9660-a6e68af347c2")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("472c36ae-31a0-4a7c-a323-45c8a8f5e54a"), IkeTerm.ENGLISH_LANGUAGE, "Relationship origin", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ef58a47b-f1e5-4eec-bbd0-09b3faacfc0a"), IkeTerm.ENGLISH_LANGUAGE, "Relationship origin", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5bbef76e-4a3f-4571-86fc-0db0ade8234c"), IkeTerm.ENGLISH_LANGUAGE, "Signifies path to parent concepts which are more general than the Tinkar term", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("1aac51d1-c9be-4815-be87-4b046cbae8c1"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ad22d43b-3ee7-550b-9660-a6e68af347c2")
                .statedAxioms(PublicIds.of("d623877c-1357-53d5-b30d-7cb559b8cde9"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("605a98e3-6894-49ff-9ef2-c699b2bb8944"))
                .semanticOn(PublicIds.of("472c36ae-31a0-4a7c-a323-45c8a8f5e54a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6e6d95fb-aa73-4213-8a04-3fd3a981334b"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ef58a47b-f1e5-4eec-bbd0-09b3faacfc0a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0cf44be7-a9e1-4333-a93a-8bc787641c37"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("5bbef76e-4a3f-4571-86fc-0db0ade8234c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("396a8a45-eef7-4ccc-b12e-30b34b43b39e"), IkeTerm.PREFERRED)
                ;

    }
}
