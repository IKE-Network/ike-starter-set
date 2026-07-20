package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Has Dose Form" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section59 {

    private Section59() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Has Dose Form (SOLOR)", PublicIds.of("072e7737-e22e-36b5-89d2-4815f0529c63")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("07c5cd2c-f7a6-4b73-b3f2-1869d022fcbe"), IkeTerm.ENGLISH_LANGUAGE, "Has Dose Form (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d1f3ea71-bb37-460c-af24-9df9a669bc9b"), IkeTerm.ENGLISH_LANGUAGE, "Has Dose Form", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("30e80350-e1fa-4a94-8cac-20ca18e6dc5a"), IkeTerm.ENGLISH_LANGUAGE, "Has dose form (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("16488072-3849-4755-9db0-0f69e5f2ef15"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "072e7737-e22e-36b5-89d2-4815f0529c63")
                .statedAxioms(PublicIds.of("9f399e84-a89d-582f-827b-3fddc70bcc5f"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5f28d10f-3f04-4f6d-af9e-d41229f22d58"))
                .semanticOn(PublicIds.of("07c5cd2c-f7a6-4b73-b3f2-1869d022fcbe"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bcdbe50a-af12-48bb-86f7-05fae4ef2a57"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d1f3ea71-bb37-460c-af24-9df9a669bc9b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5901ba61-9475-4967-93a0-93f196db99b7"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("30e80350-e1fa-4a94-8cac-20ca18e6dc5a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6c444b4a-57ec-4be6-9a8a-ddcb823b9c22"), IkeTerm.PREFERRED)
                ;

    }
}
