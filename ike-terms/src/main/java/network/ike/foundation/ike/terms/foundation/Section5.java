package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelConcept;
import dev.ikm.tinkar.terms.KernelPattern;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Object" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section5 {

    private Section5() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Object (SOLOR)", PublicIds.of(UUID.fromString("72765109-6b53-3814-9b05-34ebddd16592"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a0d24823-ced3-4430-be30-13d3ade9ff62")), KernelConcept.ENGLISH_LANGUAGE, "Object (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("597ae0fc-0449-463d-91c9-daf06233b1a4")), KernelConcept.ENGLISH_LANGUAGE, "Object", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c6a8fc8e-c991-40f6-9887-8ee6e1940650")), KernelConcept.ENGLISH_LANGUAGE, "The general supertype for structured values in the model — an encapsulation of data together with behavior, inherited from the baseline as the parent of value-shape concepts. A model concept, not domain content.", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("27197298-f81b-429a-b8f5-1dfe1fa774c1")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "72765109-6b53-3814-9b05-34ebddd16592")
                .statedAxioms(PublicIds.of(UUID.fromString("d540b2bb-7892-5d15-8820-7734c6c2ea75")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Model concept (SOLOR)", PublicIds.of("7bbd4210-381c-11e7-9598-0800200c9a66"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ea99aae5-50d3-4063-9bd1-0c3fa98e3ef1")))
                .semanticOn(PublicIds.of(UUID.fromString("a0d24823-ced3-4430-be30-13d3ade9ff62")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c4d74760-7363-402e-80a8-087de137dff0")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("597ae0fc-0449-463d-91c9-daf06233b1a4")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ef76fdb9-1e05-4172-bcf9-f49235295061")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c6a8fc8e-c991-40f6-9887-8ee6e1940650")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c6283bc7-6b2f-427f-b167-28acb4151738")), KernelConcept.PREFERRED)
                ;

    }
}
