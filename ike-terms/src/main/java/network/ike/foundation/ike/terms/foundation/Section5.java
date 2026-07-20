package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Object" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section5 {

    private Section5() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Object (SOLOR)", PublicIds.of("72765109-6b53-3814-9b05-34ebddd16592")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a0d24823-ced3-4430-be30-13d3ade9ff62"), IkeTerm.ENGLISH_LANGUAGE, "Object (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("597ae0fc-0449-463d-91c9-daf06233b1a4"), IkeTerm.ENGLISH_LANGUAGE, "Object", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c6a8fc8e-c991-40f6-9887-8ee6e1940650"), IkeTerm.ENGLISH_LANGUAGE, "An encapsulation of data together with procedures", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("27197298-f81b-429a-b8f5-1dfe1fa774c1"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "72765109-6b53-3814-9b05-34ebddd16592")
                .statedAxioms(PublicIds.of("d540b2bb-7892-5d15-8820-7734c6c2ea75"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Legacy model concepts (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("ea99aae5-50d3-4063-9bd1-0c3fa98e3ef1"))
                .semanticOn(PublicIds.of("a0d24823-ced3-4430-be30-13d3ade9ff62"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c4d74760-7363-402e-80a8-087de137dff0"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("597ae0fc-0449-463d-91c9-daf06233b1a4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ef76fdb9-1e05-4172-bcf9-f49235295061"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c6a8fc8e-c991-40f6-9887-8ee6e1940650"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c6283bc7-6b2f-427f-b167-28acb4151738"), IkeTerm.PREFERRED)
                ;

    }
}
