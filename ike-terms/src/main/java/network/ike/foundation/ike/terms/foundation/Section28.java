package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Feature Type" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section28 {

    private Section28() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Feature Type (SOLOR)", PublicIds.of("c9120d8b-1acc-5267-9f33-fa716abdb69d")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("02d88c2c-bc20-4008-b66b-24fd7d7583a3"), IkeTerm.ENGLISH_LANGUAGE, "Feature Type (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0fa1c02a-8097-4ea0-bc8a-b4fe66466b4c"), IkeTerm.ENGLISH_LANGUAGE, "Feature Type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d3bc16dc-6834-4256-8ff9-1bb796f92d29"), IkeTerm.PREFERRED)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("57e35be0-99b5-48c7-89f3-212956d5fcce"), IkeTerm.ENGLISH_LANGUAGE, "The type vocabulary for feature atoms: names which measurable characteristic a feature axiom compares, the concrete-domain counterpart of a role type.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("7b022bae-e270-467b-86bb-7300b83fa58b"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c9120d8b-1acc-5267-9f33-fa716abdb69d")
                .statedAxioms(PublicIds.of("bc18e5cc-0c66-5b8f-a287-c4625175d1bf"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical expression model (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("e360e479-482c-4526-a21d-cc7ec5be7ba9"))
                .semanticOn(PublicIds.of("02d88c2c-bc20-4008-b66b-24fd7d7583a3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("119da844-1de7-48ee-bf2b-b9987331def3"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("57e35be0-99b5-48c7-89f3-212956d5fcce"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b5e28b59-c0aa-40fa-ab4d-479c44be96ce"), IkeTerm.PREFERRED)
                ;

    }
}
