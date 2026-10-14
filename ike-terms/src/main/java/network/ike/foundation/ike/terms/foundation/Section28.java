package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Feature Type" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section28 {

    private Section28() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Feature Type (SOLOR)", PublicIds.of(UUID.fromString("c9120d8b-1acc-5267-9f33-fa716abdb69d"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("02d88c2c-bc20-4008-b66b-24fd7d7583a3")), KernelTerm.ENGLISH_LANGUAGE, "Feature Type (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0fa1c02a-8097-4ea0-bc8a-b4fe66466b4c")), KernelTerm.ENGLISH_LANGUAGE, "Feature Type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d3bc16dc-6834-4256-8ff9-1bb796f92d29")), KernelTerm.PREFERRED)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("57e35be0-99b5-48c7-89f3-212956d5fcce")), KernelTerm.ENGLISH_LANGUAGE, "Feature type (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("7b022bae-e270-467b-86bb-7300b83fa58b")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "c9120d8b-1acc-5267-9f33-fa716abdb69d")
                .statedAxioms(PublicIds.of(UUID.fromString("bc18e5cc-0c66-5b8f-a287-c4625175d1bf")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object properties (SOLOR)", PublicIds.of("3ef4311c-70c0-5149-9e06-53d745f85b15"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e360e479-482c-4526-a21d-cc7ec5be7ba9")))
                .semanticOn(PublicIds.of(UUID.fromString("02d88c2c-bc20-4008-b66b-24fd7d7583a3")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("119da844-1de7-48ee-bf2b-b9987331def3")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("57e35be0-99b5-48c7-89f3-212956d5fcce")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b5e28b59-c0aa-40fa-ab4d-479c44be96ce")), KernelTerm.PREFERRED)
                ;

    }
}
