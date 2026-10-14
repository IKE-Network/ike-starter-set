package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelConcept;
import dev.ikm.tinkar.terms.KernelPattern;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Description acceptability" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section40 {

    private Section40() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description acceptability", PublicIds.of(UUID.fromString("96b61063-0d29-5aea-9652-3f5f328aadc3"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("80efdccd-27a4-464e-8b45-a12f2cdcb596")), KernelConcept.ENGLISH_LANGUAGE, "Description acceptability", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("55dc1c93-0dc1-4c23-bda2-79ba419919aa")), KernelConcept.ENGLISH_LANGUAGE, "Description acceptability", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5106ab62-8cc5-485d-9a86-5ea2205423ef")), KernelConcept.ENGLISH_LANGUAGE, "Whether a given human readable text for a concept is permissible", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("2f394465-f048-4922-b06c-20db15af9711")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "96b61063-0d29-5aea-9652-3f5f328aadc3")
                .statedAxioms(PublicIds.of(UUID.fromString("575aa454-9a66-5676-96a4-3af39800d0f9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("29fd1ad4-f526-4c82-bb74-9da756c2db0e")))
                .semanticOn(PublicIds.of(UUID.fromString("80efdccd-27a4-464e-8b45-a12f2cdcb596")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("901a9194-a5c5-49bf-94af-c273e002930c")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("55dc1c93-0dc1-4c23-bda2-79ba419919aa")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("31dbeb20-b045-4aa2-bbcb-8213bdc00e58")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5106ab62-8cc5-485d-9a86-5ea2205423ef")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("138731ee-b6ac-4d53-b17e-9148a41f409e")), KernelConcept.PREFERRED)
                ;

        set.concept("Preferred (SOLOR)", PublicIds.of(UUID.fromString("266f1bc3-3361-39f3-bffe-69db9daea56e"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dff6e3d1-e02c-4b44-8819-f90b8140fd7f")), KernelConcept.ENGLISH_LANGUAGE, "Preferred (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a591be55-fc99-4feb-9d6c-7fc26c692dc6")), KernelConcept.ENGLISH_LANGUAGE, "Preferred", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("135bd64e-6118-4fde-9207-9c0b65a27619")), KernelConcept.ENGLISH_LANGUAGE, "Preferred( Foundation metadata concept)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e0725ca0-f2a6-41a5-b09d-6ed5d524e03e")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "266f1bc3-3361-39f3-bffe-69db9daea56e")
                .statedAxioms(PublicIds.of(UUID.fromString("192a1b8b-39c7-517d-8159-406d4533e9c0")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelConcept.DESCRIPTION_ACCEPTABILITY))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9ca806ad-9142-4d28-ac33-9166e7a35df2")))
                .semanticOn(PublicIds.of(UUID.fromString("dff6e3d1-e02c-4b44-8819-f90b8140fd7f")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("733c3619-0225-467f-bd52-6ceed3194c9b")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a591be55-fc99-4feb-9d6c-7fc26c692dc6")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("99766f93-bb47-4782-84ea-c8672d47efb3")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("135bd64e-6118-4fde-9207-9c0b65a27619")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("abf76c49-8530-4ceb-8566-506bba91218f")), KernelConcept.PREFERRED)
                ;

        set.concept("Acceptable (foundation metadata concept)", PublicIds.of(UUID.fromString("12b9e103-060e-3256-9982-18c1191af60e"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a1df9cd0-5dd9-4646-9a2b-437d7867ba72")), KernelConcept.ENGLISH_LANGUAGE, "Acceptable (foundation metadata concept)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fa68ea30-e41a-46ad-94d7-a2152f4e1a29")), KernelConcept.ENGLISH_LANGUAGE, "Acceptable", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0aa2bbb9-e172-4694-8d1e-228003977c5c")), KernelConcept.ENGLISH_LANGUAGE, "Specifies that a description is acceptable, but not preferred within a language or dialect.", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f1d1e043-9fe5-4aeb-8e86-9a2b668ed559")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "12b9e103-060e-3256-9982-18c1191af60e")
                .statedAxioms(PublicIds.of(UUID.fromString("504c0a7f-f30d-56ae-99be-422aa624ed72")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelConcept.DESCRIPTION_ACCEPTABILITY))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f11448d5-87a2-4e60-84b6-66e542592e56")))
                .semanticOn(PublicIds.of(UUID.fromString("a1df9cd0-5dd9-4646-9a2b-437d7867ba72")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c77d8065-eccc-4cae-888b-afdaa68da1d0")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("fa68ea30-e41a-46ad-94d7-a2152f4e1a29")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ff2e9ff5-29b5-4f6b-adc1-6e5be4b1194d")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0aa2bbb9-e172-4694-8d1e-228003977c5c")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("72289516-cf78-4db6-87f4-b214d21cc1f1")), KernelConcept.PREFERRED)
                ;

    }
}
