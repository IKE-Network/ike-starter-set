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

/** The "Object" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section5 {

    private Section5() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Object (SOLOR)", PublicIds.of(UUID.fromString("72765109-6b53-3814-9b05-34ebddd16592"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a0d24823-ced3-4430-be30-13d3ade9ff62")), TinkarTerm.ENGLISH_LANGUAGE, "Object (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("597ae0fc-0449-463d-91c9-daf06233b1a4")), TinkarTerm.ENGLISH_LANGUAGE, "Object", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c6a8fc8e-c991-40f6-9887-8ee6e1940650")), TinkarTerm.ENGLISH_LANGUAGE, "An encapsulation of data together with procedures", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("27197298-f81b-429a-b8f5-1dfe1fa774c1")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "72765109-6b53-3814-9b05-34ebddd16592")
                .statedAxioms(PublicIds.of(UUID.fromString("d540b2bb-7892-5d15-8820-7734c6c2ea75")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ROOT_VERTEX))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ea99aae5-50d3-4063-9bd1-0c3fa98e3ef1")))
                .semanticOn(PublicIds.of(UUID.fromString("a0d24823-ced3-4430-be30-13d3ade9ff62")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c4d74760-7363-402e-80a8-087de137dff0")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("597ae0fc-0449-463d-91c9-daf06233b1a4")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ef76fdb9-1e05-4172-bcf9-f49235295061")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c6a8fc8e-c991-40f6-9887-8ee6e1940650")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c6283bc7-6b2f-427f-b167-28acb4151738")), TinkarTerm.PREFERRED)
                ;

    }
}
