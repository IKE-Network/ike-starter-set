package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Text" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section51 {

    private Section51() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Text for description", PublicIds.of(UUID.fromString("8bdcbe5d-e92e-5c10-845e-b585e6061672"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c40a9699-87d4-4b3a-904f-11c80cb3920f")), IkeTerm.ENGLISH_LANGUAGE, "Text for description", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2dd1de47-9983-432f-829b-2f49a13a3711")), IkeTerm.ENGLISH_LANGUAGE, "Text", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6a56402d-5f5f-46ae-8376-7a7ff7c74f6f")), IkeTerm.ENGLISH_LANGUAGE, "Captures the human readable text for a description in Komet", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("bb16f4c5-38a3-4566-b4b0-be9e4986c5a9")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8bdcbe5d-e92e-5c10-845e-b585e6061672")
                .statedAxioms(PublicIds.of(UUID.fromString("33cc71b9-97d7-5b3e-9ec0-6f70dd3506e7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9c45a4ef-3778-464e-89b0-f2bc3862fea7")))
                .semanticOn(PublicIds.of(UUID.fromString("c40a9699-87d4-4b3a-904f-11c80cb3920f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("33ec3853-66ad-4be4-b1d3-859b3b28f3da")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2dd1de47-9983-432f-829b-2f49a13a3711")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f83d0a5c-8280-4355-96e0-646e664a33a3")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6a56402d-5f5f-46ae-8376-7a7ff7c74f6f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("559c69bd-e511-4824-94e2-54f88a3bfff0")), IkeTerm.PREFERRED)
                ;

    }
}
