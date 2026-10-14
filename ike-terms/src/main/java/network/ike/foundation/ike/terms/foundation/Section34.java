package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Value Constraint" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section34 {

    private Section34() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Value Constraint (SOLOR)", PublicIds.of(UUID.fromString("8c55fb86-92d8-42a9-ad70-1e23abbf7eec"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bf1086cc-8c63-4f9f-a2b9-4bada7a2f2a4")), KernelTerm.ENGLISH_LANGUAGE, "Value Constraint (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3eccfc77-b029-4f21-b5ea-4404ff9fa00d")), KernelTerm.ENGLISH_LANGUAGE, "Value Constraint", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("698e246d-4d19-42f6-932a-c86003a219dc")), KernelTerm.ENGLISH_LANGUAGE, "A component has specific value requirements that needs to be met", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("d19583d1-fb77-4c76-a902-33df7d21f873")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "8c55fb86-92d8-42a9-ad70-1e23abbf7eec")
                .statedAxioms(PublicIds.of(UUID.fromString("f0b576b8-0b9c-56ee-a5ab-98a6915afb70")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b19dd4ae-e3c2-4d6d-8093-7878089961b7")))
                .semanticOn(PublicIds.of(UUID.fromString("bf1086cc-8c63-4f9f-a2b9-4bada7a2f2a4")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f9e8f428-23cc-4226-92f5-85c0b2e81dab")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3eccfc77-b029-4f21-b5ea-4404ff9fa00d")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d025af10-d093-4cc0-a338-64c0752a5b26")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("698e246d-4d19-42f6-932a-c86003a219dc")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fe33f383-8bf8-437c-b0d9-2b2a2b44ec88")), KernelTerm.PREFERRED)
                ;

    }
}
