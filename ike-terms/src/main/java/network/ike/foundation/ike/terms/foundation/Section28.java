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

/** The "Feature Type" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section28 {

    private Section28() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Feature Type (SOLOR)", PublicIds.of(UUID.fromString("c9120d8b-1acc-5267-9f33-fa716abdb69d"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("02d88c2c-bc20-4008-b66b-24fd7d7583a3")), TinkarTerm.ENGLISH_LANGUAGE, "Feature Type (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0fa1c02a-8097-4ea0-bc8a-b4fe66466b4c")), TinkarTerm.ENGLISH_LANGUAGE, "Feature Type", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d3bc16dc-6834-4256-8ff9-1bb796f92d29")), TinkarTerm.PREFERRED)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("57e35be0-99b5-48c7-89f3-212956d5fcce")), TinkarTerm.ENGLISH_LANGUAGE, "Feature type (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("7b022bae-e270-467b-86bb-7300b83fa58b")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c9120d8b-1acc-5267-9f33-fa716abdb69d")
                .statedAxioms(PublicIds.of(UUID.fromString("bc18e5cc-0c66-5b8f-a287-c4625175d1bf")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.OBJECT_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e360e479-482c-4526-a21d-cc7ec5be7ba9")))
                .semanticOn(PublicIds.of(UUID.fromString("02d88c2c-bc20-4008-b66b-24fd7d7583a3")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("119da844-1de7-48ee-bf2b-b9987331def3")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("57e35be0-99b5-48c7-89f3-212956d5fcce")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b5e28b59-c0aa-40fa-ab4d-479c44be96ce")), TinkarTerm.PREFERRED)
                ;

    }
}
