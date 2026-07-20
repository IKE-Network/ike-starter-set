package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Has Active Ingredient" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section4 {

    private Section4() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Has Active Ingredient (SOLOR)", PublicIds.of("65bf3b7f-c854-36b5-81c3-4915461020a8")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6108e695-6a19-4632-92bc-a268f0180ead"), IkeTerm.ENGLISH_LANGUAGE, "Has Active Ingredient (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f6fd6a29-4492-496b-9cce-55e07d910a9f"), IkeTerm.ENGLISH_LANGUAGE, "Has Active Ingredient", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3da52372-3eb8-459a-a08a-1429cff5e3e1"), IkeTerm.ENGLISH_LANGUAGE, "Has active ingredient (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("4c1440af-e629-4d77-8076-2d8891fb3b78"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "65bf3b7f-c854-36b5-81c3-4915461020a8")
                .statedAxioms(PublicIds.of("6041af94-fe55-5775-a5ad-2684ef65dfc6"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("86a680e3-396c-46f6-a47e-0910ec47903a"))
                .semanticOn(PublicIds.of("6108e695-6a19-4632-92bc-a268f0180ead"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("76410bdc-4773-4066-8b5f-81f42a2d5d66"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f6fd6a29-4492-496b-9cce-55e07d910a9f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("709e01af-b730-4776-ba74-4b35e49306d3"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("3da52372-3eb8-459a-a08a-1429cff5e3e1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7e4a0173-6535-4b1e-8e7f-e02ab2704687"), IkeTerm.PREFERRED)
                ;

    }
}
