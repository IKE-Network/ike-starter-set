package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Concept details tree table" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section11 {

    private Section11() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Concept details tree table (SOLOR)", PublicIds.of(UUID.fromString("1655edd8-7b73-52c5-98b0-263d1ab3a90b"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d9f14a66-ee6a-42d6-8528-35235b05b1e1")), IkeTerm.ENGLISH_LANGUAGE, "Concept details tree table (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("38f00409-d08a-409c-b2a7-2990ae6e46c1")), IkeTerm.ENGLISH_LANGUAGE, "Concept details tree table", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1684fe7f-5be2-4f3f-97e6-52440a8ed3b5")), IkeTerm.ENGLISH_LANGUAGE, "Tree table with concept details", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c04d191c-8d52-422d-bbae-174db5fb4df2")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1655edd8-7b73-52c5-98b0-263d1ab3a90b")
                .statedAxioms(PublicIds.of(UUID.fromString("446fda85-53ab-5243-84dd-cb15fcec262c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6ea27f77-5bd9-406f-9b08-a7efa72cb3ad")))
                .semanticOn(PublicIds.of(UUID.fromString("d9f14a66-ee6a-42d6-8528-35235b05b1e1")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("edf525aa-5cf8-4349-93ff-03c9f7511209")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("38f00409-d08a-409c-b2a7-2990ae6e46c1")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6abe3262-12c0-4ede-97d0-d7330c526002")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1684fe7f-5be2-4f3f-97e6-52440a8ed3b5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ce3f053d-1bb6-4bc3-9b4e-0654d2d8b99d")), IkeTerm.PREFERRED)
                ;

    }
}
