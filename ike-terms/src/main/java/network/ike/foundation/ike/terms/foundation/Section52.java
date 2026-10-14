package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Is a" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section52 {

    private Section52() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Is-a", PublicIds.of(UUID.fromString("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25"), UUID.fromString("46bccdc4-8fb6-11db-b606-0800200c9a66"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b18eb010-2033-45e9-8691-ae408aca8a18")), KernelTerm.ENGLISH_LANGUAGE, "Is-a", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d6666e7a-cc14-4cfd-b9a0-057948862a19")), KernelTerm.ENGLISH_LANGUAGE, "Is a", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("edb22f1b-47f8-4e30-aba0-648b62ace8ca")), KernelTerm.ENGLISH_LANGUAGE, "Designates the parent child relationship", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8cdfb6bd-5b4e-4f0e-9f47-01d0b508b28c")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "c93a30b9-ba77-3adb-a9b8-4589c9f8fb25")
                .statedAxioms(PublicIds.of(UUID.fromString("30e6715e-e330-58e6-bddf-3601625b76c7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("337c47d2-1953-4f0d-934b-f1d927081b99")))
                .semanticOn(PublicIds.of(UUID.fromString("b18eb010-2033-45e9-8691-ae408aca8a18")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8bcc501c-a490-4c80-bf38-950a48d4dbe4")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d6666e7a-cc14-4cfd-b9a0-057948862a19")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ddd08cb7-1fef-4482-89a9-30567b87ed45")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("edb22f1b-47f8-4e30-aba0-648b62ace8ca")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("66a52bb6-4b88-4dad-949d-cf1f572be8b9")), KernelTerm.PREFERRED)
                ;

    }
}
