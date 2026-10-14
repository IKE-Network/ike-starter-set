package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Creative Commons BY license" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section63 {

    private Section63() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Creative Commons BY license (SOLOR)", PublicIds.of(UUID.fromString("3415a972-7850-57cd-aa86-a572ca1c2ceb"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("432005a0-0bbb-40ae-a69a-7600fb22dd10")), KernelTerm.ENGLISH_LANGUAGE, "Creative Commons BY license (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dbbdb8c5-fdb8-48df-b6a0-8a857b39cb81")), KernelTerm.ENGLISH_LANGUAGE, "Creative Commons BY license", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6901610c-5921-411f-b513-4bc507541d94")), KernelTerm.ENGLISH_LANGUAGE, "The Creative Commons Attribution license: free distribution of an otherwise copyrighted work, with attribution to its source. One of the two licenses this knowledge set is published under — Creative Commons BY together with Apache 2.0 (dual licensing, IKE-Network/ike-issues#952).", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("edcfc1bf-bda2-4915-aa43-08b68306fcfd")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "3415a972-7850-57cd-aa86-a572ca1c2ceb")
                .statedAxioms(PublicIds.of(UUID.fromString("d27af530-31d3-5921-8f87-f4e3f0467593")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("License (IkeFoundation)")))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8af204ce-df5e-49c5-90d9-bbcb33d1bcce")))
                .semanticOn(PublicIds.of(UUID.fromString("432005a0-0bbb-40ae-a69a-7600fb22dd10")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a28c4ee7-6d15-4f8b-b147-17f62bed2f8b")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("dbbdb8c5-fdb8-48df-b6a0-8a857b39cb81")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d79aa106-6c7f-4e64-9fb5-82d627e7547e")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6901610c-5921-411f-b513-4bc507541d94")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3aa49fae-5f58-4b46-b3ea-8fbcede2ebd3")), KernelTerm.PREFERRED)
                ;

    }
}
