package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Description list for concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section62 {

    private Section62() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description list for concept (SOLOR)", PublicIds.of(UUID.fromString("ab3e8771-7c7c-5e57-8acf-147b16da36e2"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dfe94b0f-e321-4652-b136-567216d9fa5b")), KernelTerm.ENGLISH_LANGUAGE, "Description list for concept (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("000803ce-c2f5-450c-bea0-1452812cc4bc")), KernelTerm.ENGLISH_LANGUAGE, "Description list for concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("57be3396-cf3f-40f7-ba9f-c6ba0b6b4239")), KernelTerm.ENGLISH_LANGUAGE, "List of description", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("070e006c-e1d2-41e7-9bdd-889f1423cdb2")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "ab3e8771-7c7c-5e57-8acf-147b16da36e2")
                .statedAxioms(PublicIds.of(UUID.fromString("9c152a95-cb08-53a5-8159-3862aabb925a")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ccc34d44-230c-4fd2-8ee9-c4dd459b3372")))
                .semanticOn(PublicIds.of(UUID.fromString("dfe94b0f-e321-4652-b136-567216d9fa5b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d5585846-bb39-481d-b372-192ecc05ed9f")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("000803ce-c2f5-450c-bea0-1452812cc4bc")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("08a02bd1-4617-4f8b-9803-dce23e3ed75d")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("57be3396-cf3f-40f7-ba9f-c6ba0b6b4239")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b886cc86-ce36-4687-87c1-bea89a9b7c39")), KernelTerm.PREFERRED)
                ;

    }
}
