package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelConcept;
import dev.ikm.tinkar.terms.KernelPattern;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Model concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section55 {

    private Section55() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Model concept", PublicIds.of(UUID.fromString("7bbd4210-381c-11e7-9598-0800200c9a66"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("639d8025-5286-44cb-a8fe-4e87f033c25e")), KernelConcept.ENGLISH_LANGUAGE, "Model concept", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bd0901b6-5c08-4b7d-81b8-110be13bfaa5")), KernelConcept.ENGLISH_LANGUAGE, "Model concept", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: one-rigorous-term revision in place (IKE-Network/ike-issues#893, #894).
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3e65ef28-f915-4773-beb5-a068361499b3")), KernelConcept.ENGLISH_LANGUAGE, "A concept representing a model construct within Integrated Knowledge Management — the structural and data-type terminology a knowledge base uses to describe itself, as distinct from the domain content it represents.", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("7e8070d0-9b18-4384-8074-d12c452963a1")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "7bbd4210-381c-11e7-9598-0800200c9a66")
                .statedAxioms(PublicIds.of(UUID.fromString("a9225dbd-f1c9-5e52-92b8-e768945b3169")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelConcept.ROOT_VERTEX))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a434b875-ed97-4264-aaff-ce353993d7a7")))
                .semanticOn(PublicIds.of(UUID.fromString("639d8025-5286-44cb-a8fe-4e87f033c25e")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("28fb2d1b-e939-4dfe-a243-7db4f33d8591")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bd0901b6-5c08-4b7d-81b8-110be13bfaa5")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4f2ee495-e3bb-48f9-a391-53efd540d1b2")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3e65ef28-f915-4773-beb5-a068361499b3")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("780dcd09-eadd-4032-b4d9-cc204a4a0511")), KernelConcept.PREFERRED)
                ;

    }
}
