package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Any component" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section57 {

    private Section57() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Any component (SOLOR)", PublicIds.of(UUID.fromString("927da7ac-3403-5ccc-b07b-88f60cc3a5f8"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("53a6e512-e8c0-443e-a8bd-1dd1ccc3fde8")), KernelTerm.ENGLISH_LANGUAGE, "Any component (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("263121e2-86bd-4cfa-a0d7-9c93b859a6b1")), KernelTerm.ENGLISH_LANGUAGE, "Any component", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("40345f82-efb9-4997-8d85-f384eb2ee454")), KernelTerm.ENGLISH_LANGUAGE, "A general-purpose container to represent any component with generic data structure. Modifiable based on the specific requirements and characteristics of the components.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("bff53e1c-061b-4cc7-9523-180230794ec1")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "927da7ac-3403-5ccc-b07b-88f60cc3a5f8")
                .statedAxioms(PublicIds.of(UUID.fromString("4ad09fae-0371-5c99-a348-62c1ff152fc7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object (SOLOR)", PublicIds.of("72765109-6b53-3814-9b05-34ebddd16592"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d664581c-fe62-482c-a7b7-5da02b3c697a")))
                .semanticOn(PublicIds.of(UUID.fromString("53a6e512-e8c0-443e-a8bd-1dd1ccc3fde8")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9d20aed3-7622-4106-a905-94728d009d1b")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("263121e2-86bd-4cfa-a0d7-9c93b859a6b1")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3bf0cfea-007f-4ed4-8a1a-cd0df0721e5e")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("40345f82-efb9-4997-8d85-f384eb2ee454")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("65ef5326-4d06-4d8f-a246-9fa43f0fdddd")), KernelTerm.PREFERRED)
                ;

    }
}
