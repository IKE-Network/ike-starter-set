package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Laterality" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section17 {

    private Section17() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Laterality (SOLOR)", PublicIds.of(UUID.fromString("26ca4590-bbe5-327c-a40a-ba56dc86996b"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("960f2aa1-4844-4b6c-aadb-15a2c8b62596")), KernelTerm.ENGLISH_LANGUAGE, "Laterality (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f6eb6e3e-09de-47a7-be73-141527d6d5f1")), KernelTerm.ENGLISH_LANGUAGE, "Laterality", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3622b35a-e8b8-48e0-afdb-4179c7061ac9")), KernelTerm.ENGLISH_LANGUAGE, "Laterality (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("17f1d7ea-056b-4801-a9e1-117dbb5f3ca6")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "26ca4590-bbe5-327c-a40a-ba56dc86996b")
                .statedAxioms(PublicIds.of(UUID.fromString("a531fcdd-db58-5110-8303-7a90d8539dbb")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object (SOLOR)", PublicIds.of("72765109-6b53-3814-9b05-34ebddd16592"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5db743cf-d96b-4d9a-8027-32f5d77d387b")))
                .semanticOn(PublicIds.of(UUID.fromString("960f2aa1-4844-4b6c-aadb-15a2c8b62596")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0f9553b5-1ec4-41ef-9562-6ff543000e8e")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f6eb6e3e-09de-47a7-be73-141527d6d5f1")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b5a4edc8-0478-4c47-adf0-407ab3730b0a")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3622b35a-e8b8-48e0-afdb-4179c7061ac9")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8e2f523d-e4bb-4ce7-85ca-b9637ba24d78")), KernelTerm.PREFERRED)
                ;

    }
}
