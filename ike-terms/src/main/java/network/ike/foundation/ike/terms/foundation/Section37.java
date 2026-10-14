package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Description" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section37 {

    private Section37() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description", PublicIds.of(UUID.fromString("87118daf-d28c-55fb-8657-cd6bc8425600"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e9863727-dda4-4c11-8c2d-3ddea5dadb83")), KernelTerm.ENGLISH_LANGUAGE, "Description", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d9801961-828b-47d9-b775-b52c6b80b478")), KernelTerm.ENGLISH_LANGUAGE, "Description", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2c6412c9-53c7-40f2-9771-b0ccd8333f4e")), KernelTerm.ENGLISH_LANGUAGE, "Human readable text for a concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("2b72794b-b10a-4adb-9285-6b7fce096309")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "87118daf-d28c-55fb-8657-cd6bc8425600")
                .statedAxioms(PublicIds.of(UUID.fromString("2f6ecd40-16c2-554d-8441-985afe25f358")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("676919e8-7ccf-415d-963f-b0e78cd99d17")))
                .semanticOn(PublicIds.of(UUID.fromString("e9863727-dda4-4c11-8c2d-3ddea5dadb83")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bfdd0fae-bdc7-4333-a700-3998efa2b458")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d9801961-828b-47d9-b775-b52c6b80b478")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cc5b9189-57f2-4c49-af84-7dfdb249b1e2")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2c6412c9-53c7-40f2-9771-b0ccd8333f4e")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4ee3b494-09ba-4711-b26a-ec1d0f9bf748")), KernelTerm.PREFERRED)
                ;

    }
}
