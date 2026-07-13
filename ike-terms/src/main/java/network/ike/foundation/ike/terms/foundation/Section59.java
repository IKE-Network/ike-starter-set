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

/** The "Has Dose Form" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section59 {

    private Section59() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        set.concept("Has Dose Form (SOLOR)", PublicIds.of(UUID.fromString("072e7737-e22e-36b5-89d2-4815f0529c63"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("07c5cd2c-f7a6-4b73-b3f2-1869d022fcbe")), IkeTerm.ENGLISH_LANGUAGE, "Has Dose Form (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d1f3ea71-bb37-460c-af24-9df9a669bc9b")), IkeTerm.ENGLISH_LANGUAGE, "Has Dose Form", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("30e80350-e1fa-4a94-8cac-20ca18e6dc5a")), IkeTerm.ENGLISH_LANGUAGE, "Has dose form (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("16488072-3849-4755-9db0-0f69e5f2ef15")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "072e7737-e22e-36b5-89d2-4815f0529c63")
                .statedAxioms(PublicIds.of(UUID.fromString("9f399e84-a89d-582f-827b-3fddc70bcc5f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5f28d10f-3f04-4f6d-af9e-d41229f22d58")))
                .semanticOn(PublicIds.of(UUID.fromString("07c5cd2c-f7a6-4b73-b3f2-1869d022fcbe")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bcdbe50a-af12-48bb-86f7-05fae4ef2a57")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d1f3ea71-bb37-460c-af24-9df9a669bc9b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5901ba61-9475-4967-93a0-93f196db99b7")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("30e80350-e1fa-4a94-8cac-20ca18e6dc5a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6c444b4a-57ec-4be6-9a8a-ddcb823b9c22")), IkeTerm.PREFERRED)
                ;

    }
}
