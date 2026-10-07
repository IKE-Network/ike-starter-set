package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Identifier Value" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section8 {

    private Section8() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Identifier Value (SOLOR)", PublicIds.of(UUID.fromString("b32dd26b-c3fc-487e-987e-16ace71a0d0f"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("30feb16d-f515-42a4-920e-aeaa7706e4f3")), KernelTerm.ENGLISH_LANGUAGE, "Identifier Value (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9d6c5a02-fd9e-4dbe-b02a-6c7008612c0b")), KernelTerm.ENGLISH_LANGUAGE, "Identifier Value", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2ce31162-c756-4e73-84da-ae6337f8d9f4")), KernelTerm.ENGLISH_LANGUAGE, "The literal string value identifier", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ff1246ef-f25a-4623-8f4a-2117bc07c61b")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "b32dd26b-c3fc-487e-987e-16ace71a0d0f")
                .statedAxioms(PublicIds.of(UUID.fromString("3d08c515-d4de-5236-adda-9e81993d6751")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c735f799-4a85-42e2-82a4-5b72172facf7")))
                .semanticOn(PublicIds.of(UUID.fromString("30feb16d-f515-42a4-920e-aeaa7706e4f3")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("648175c8-df7f-4348-a26f-5d160bccab96")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9d6c5a02-fd9e-4dbe-b02a-6c7008612c0b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("43baca0f-f17d-45c7-b729-fb5b54cdad2b")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2ce31162-c756-4e73-84da-ae6337f8d9f4")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("36b967de-d261-48c1-bb11-94b0a9470119")), KernelTerm.PREFERRED)
                ;

    }
}
