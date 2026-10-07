package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Has Active Ingredient" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section4 {

    private Section4() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Has Active Ingredient (SOLOR)", PublicIds.of(UUID.fromString("65bf3b7f-c854-36b5-81c3-4915461020a8"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6108e695-6a19-4632-92bc-a268f0180ead")), KernelTerm.ENGLISH_LANGUAGE, "Has Active Ingredient (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f6fd6a29-4492-496b-9cce-55e07d910a9f")), KernelTerm.ENGLISH_LANGUAGE, "Has Active Ingredient", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3da52372-3eb8-459a-a08a-1429cff5e3e1")), KernelTerm.ENGLISH_LANGUAGE, "Has active ingredient (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4c1440af-e629-4d77-8076-2d8891fb3b78")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "65bf3b7f-c854-36b5-81c3-4915461020a8")
                .statedAxioms(PublicIds.of(UUID.fromString("6041af94-fe55-5775-a5ad-2684ef65dfc6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object (SOLOR)", PublicIds.of("72765109-6b53-3814-9b05-34ebddd16592"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("86a680e3-396c-46f6-a47e-0910ec47903a")))
                .semanticOn(PublicIds.of(UUID.fromString("6108e695-6a19-4632-92bc-a268f0180ead")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("76410bdc-4773-4066-8b5f-81f42a2d5d66")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f6fd6a29-4492-496b-9cce-55e07d910a9f")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("709e01af-b730-4776-ba74-4b35e49306d3")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3da52372-3eb8-459a-a08a-1429cff5e3e1")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7e4a0173-6535-4b1e-8e7f-e02ab2704687")), KernelTerm.PREFERRED)
                ;

    }
}
