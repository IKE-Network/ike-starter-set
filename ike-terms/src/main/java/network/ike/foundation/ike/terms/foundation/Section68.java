package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelConcept;
import dev.ikm.tinkar.terms.KernelPattern;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Relationship destination" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section68 {

    private Section68() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Relationship destination", PublicIds.of(UUID.fromString("a3dd69af-355c-54ce-ba13-2902a7ae9551"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c9aa7f3f-5f49-400b-9ae3-5ab20e4242c6")), KernelConcept.ENGLISH_LANGUAGE, "Relationship destination", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("07cb96f6-7779-4a45-bdeb-6f87de9c2efe")), KernelConcept.ENGLISH_LANGUAGE, "Relationship destination", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("29f2bc26-565f-4a6c-aa27-d9615eb51767")), KernelConcept.ENGLISH_LANGUAGE, "Signifies path to child concepts which are more specific than the concept", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("567a8d88-c63b-4b92-abe7-17202b88339d")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "a3dd69af-355c-54ce-ba13-2902a7ae9551")
                .statedAxioms(PublicIds.of(UUID.fromString("657957ed-4394-574a-bf5f-b2b2818a8f05")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e5f6e4ae-a4e6-411c-92cd-9ec38d394b11")))
                .semanticOn(PublicIds.of(UUID.fromString("c9aa7f3f-5f49-400b-9ae3-5ab20e4242c6")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("54ac13bb-fea5-4f7f-9a49-ca626f41bd87")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("07cb96f6-7779-4a45-bdeb-6f87de9c2efe")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2b2e606b-fcd0-4da5-a7c5-5fd435536190")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("29f2bc26-565f-4a6c-aa27-d9615eb51767")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1ab38166-b837-48e2-a01b-95a5d0d3ba85")), KernelConcept.PREFERRED)
                ;

    }
}
