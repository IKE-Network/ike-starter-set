package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Annotation property set" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section49 {

    private Section49() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Annotation property set", PublicIds.of(UUID.fromString("cb9e33de-f82c-495d-89fa-69afecbcd47d"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("69be3ae3-6f24-42ae-819e-a91a69959ab4")), KernelTerm.ENGLISH_LANGUAGE, "Annotation property set", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c85fd08c-f0ba-4058-a963-738bcefb7c1b")), KernelTerm.ENGLISH_LANGUAGE, "Annotation property set", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("da5b80d1-b026-4416-a21e-8d023580ea9b")), KernelTerm.ENGLISH_LANGUAGE, "Annotation property set (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("788c7955-1d9d-4de4-921d-77b723337b63")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "53f866d0-fd61-5c85-a16c-150bd619a0ac")
                .statedAxioms(PublicIds.of(UUID.fromString("d00a01be-fc68-5e82-af39-0b4cb2893e4f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object properties (SOLOR)", PublicIds.of("3ef4311c-70c0-5149-9e06-53d745f85b15"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e92b2100-73ca-4999-bdbe-ae39a3060bf7")))
                .semanticOn(PublicIds.of(UUID.fromString("69be3ae3-6f24-42ae-819e-a91a69959ab4")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3b7cfed5-8b3e-4a5d-a4c0-4b78c5d3bf48")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c85fd08c-f0ba-4058-a963-738bcefb7c1b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("659c28c7-ac72-4fd8-a9da-7dd265560607")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("da5b80d1-b026-4416-a21e-8d023580ea9b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cb113102-65c1-4b7e-af8b-ecd26e46cae4")), KernelTerm.PREFERRED)
                ;

    }
}
