package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelConcept;
import dev.ikm.tinkar.terms.KernelPattern;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Data property set" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section50 {

    private Section50() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Data property set", PublicIds.of(UUID.fromString("6b8ed642-de72-4aee-953d-42e5db92c0ab"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d7d38c0b-78b8-41b7-abcb-3729885a764f")), KernelConcept.ENGLISH_LANGUAGE, "Data property set", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a1f00e7b-fb74-4d79-a0a8-cd0c3e279e54")), KernelConcept.ENGLISH_LANGUAGE, "Data property set", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c6a25965-da90-4471-98f1-1bc2c0ad2fa9")), KernelConcept.ENGLISH_LANGUAGE, "Data property set (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("cd9d66d6-d915-40db-bcd1-593ec6517cfe")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "53f866d0-fd61-5c85-a16c-150bd619a0ac")
                .statedAxioms(PublicIds.of(UUID.fromString("73ca869f-0593-5e07-8cf9-3516903fcf1d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object properties (SOLOR)", PublicIds.of("3ef4311c-70c0-5149-9e06-53d745f85b15"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6a8341c2-5049-4687-9264-2cf1c8b8e000")))
                .semanticOn(PublicIds.of(UUID.fromString("d7d38c0b-78b8-41b7-abcb-3729885a764f")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cda49bc5-0c19-4452-bad8-afb3e91b3e51")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a1f00e7b-fb74-4d79-a0a8-cd0c3e279e54")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ac6dcdc2-8f82-4c29-b4ea-4d3fb66de3a4")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c6a25965-da90-4471-98f1-1bc2c0ad2fa9")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2e5da358-10a5-446d-9b41-375af401c699")), KernelConcept.PREFERRED)
                ;

    }
}
