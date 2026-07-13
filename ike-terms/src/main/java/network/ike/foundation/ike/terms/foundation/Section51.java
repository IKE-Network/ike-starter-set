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

/** The "Text" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section51 {

    private Section51() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Text for description", PublicIds.of(UUID.fromString("8bdcbe5d-e92e-5c10-845e-b585e6061672"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c40a9699-87d4-4b3a-904f-11c80cb3920f")), TinkarTerm.ENGLISH_LANGUAGE, "Text for description", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2dd1de47-9983-432f-829b-2f49a13a3711")), TinkarTerm.ENGLISH_LANGUAGE, "Text", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6a56402d-5f5f-46ae-8376-7a7ff7c74f6f")), TinkarTerm.ENGLISH_LANGUAGE, "Captures the human readable text for a description in Komet", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("bb16f4c5-38a3-4566-b4b0-be9e4986c5a9")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8bdcbe5d-e92e-5c10-845e-b585e6061672")
                .statedAxioms(PublicIds.of(UUID.fromString("33cc71b9-97d7-5b3e-9ec0-6f70dd3506e7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9c45a4ef-3778-464e-89b0-f2bc3862fea7")))
                .semanticOn(PublicIds.of(UUID.fromString("c40a9699-87d4-4b3a-904f-11c80cb3920f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("33ec3853-66ad-4be4-b1d3-859b3b28f3da")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2dd1de47-9983-432f-829b-2f49a13a3711")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f83d0a5c-8280-4355-96e0-646e664a33a3")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6a56402d-5f5f-46ae-8376-7a7ff7c74f6f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("559c69bd-e511-4824-94e2-54f88a3bfff0")), TinkarTerm.PREFERRED)
                ;

    }
}
