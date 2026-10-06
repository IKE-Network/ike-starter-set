package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Identifier source" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section61 {

    private Section61() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Identifier Source", PublicIds.of(UUID.fromString("5a87935c-d654-548f-82a2-0c06e3801162"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("06a40c30-50fb-43fc-a8e4-dab25cb44a02")), KernelTerm.ENGLISH_LANGUAGE, "Identifier Source", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6f49b6cf-f994-4dd6-ad93-559b0052eb39")), KernelTerm.ENGLISH_LANGUAGE, "Identifier source", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c629f584-ae95-4c94-9f50-60a0ce8304f8")), KernelTerm.ENGLISH_LANGUAGE, "An identifier used to label the identity of a unique component.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("d5cb9558-7ba2-4e5a-819f-8a41f2b4becc")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "5a87935c-d654-548f-82a2-0c06e3801162")
                .statedAxioms(PublicIds.of(UUID.fromString("b923ce88-e3ef-522f-bfe4-bec064f59794")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("df71af2e-9706-4578-bbc4-37cec482ee0a")))
                .semanticOn(PublicIds.of(UUID.fromString("06a40c30-50fb-43fc-a8e4-dab25cb44a02")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("93a5faad-79ae-4ed0-ab0d-084b74a8515d")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6f49b6cf-f994-4dd6-ad93-559b0052eb39")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d685c473-acc0-4540-924e-d8e6e799eafb")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c629f584-ae95-4c94-9f50-60a0ce8304f8")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3116d029-198b-46fb-bea3-96b36b78becc")), KernelTerm.PREFERRED)
                ;

        set.concept("UNIVERSALLY_UNIQUE_IDENTIFIER", PublicIds.of(UUID.fromString("845274b5-9644-3799-94c6-e0ea37e7d1a4"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d974705e-465f-4cf3-b56c-69307fa9c24b")), KernelTerm.ENGLISH_LANGUAGE, "UNIVERSALLY_UNIQUE_IDENTIFIER", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("99a356ec-3e20-4c5b-bf2c-ea5efb00f871")), KernelTerm.ENGLISH_LANGUAGE, "UUID", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("afaf9d6a-e9c4-4a6c-bf72-6db6eb50f20c")), KernelTerm.ENGLISH_LANGUAGE, "A universally unique identifier that uniquely represents a concept in IKE", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e91aa7fa-8113-4c9d-8826-120e6ea3a701")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "845274b5-9644-3799-94c6-e0ea37e7d1a4")
                .statedAxioms(PublicIds.of(UUID.fromString("37211859-d480-5798-ad1e-f1ef09f9c227")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelTerm.IDENTIFIER_SOURCE))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("3469c5a1-c988-4b56-bc45-12ca40063830")))
                .semanticOn(PublicIds.of(UUID.fromString("d974705e-465f-4cf3-b56c-69307fa9c24b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bc10932c-1761-41ea-86a7-5d8373f259dd")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("99a356ec-3e20-4c5b-bf2c-ea5efb00f871")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2b5be2a4-092d-43ba-804a-4d23840e3d79")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("afaf9d6a-e9c4-4a6c-bf72-6db6eb50f20c")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("79c4aa84-f10a-4ab1-ba3f-7ecfdbbc25cb")), KernelTerm.PREFERRED)
                ;

    }
}
