package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Value Range" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section33 {

    private Section33() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Reference Range (SOLOR)", PublicIds.of(UUID.fromString("87ce975b-309b-47f4-a6c6-4ae6df6649a1"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fa0eb5ff-1244-42c4-a470-7f4f194056b8")), KernelTerm.ENGLISH_LANGUAGE, "Reference Range (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2ca16f39-2999-47b7-9b68-5eef352bc2f7")), KernelTerm.ENGLISH_LANGUAGE, "Value Range", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("149f56a8-d656-4176-929a-2b71fbdc118a")), KernelTerm.ENGLISH_LANGUAGE, "The range of values specific to a component", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8184e0ce-343b-4c85-97f3-e24ca40926f9")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "87ce975b-309b-47f4-a6c6-4ae6df6649a1")
                .statedAxioms(PublicIds.of(UUID.fromString("d3c01223-8471-52b0-888e-c53d920e0675")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8de1e320-f168-417b-917e-10b576d3ff51")))
                .semanticOn(PublicIds.of(UUID.fromString("fa0eb5ff-1244-42c4-a470-7f4f194056b8")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6d679ad1-1e54-4dd4-96c8-455010a2cc55")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2ca16f39-2999-47b7-9b68-5eef352bc2f7")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f1cf8d7a-77d4-47ef-9f6d-96200aa37cf8")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("149f56a8-d656-4176-929a-2b71fbdc118a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a3fc25a6-2f3e-4965-89fb-c079652c7180")), KernelTerm.PREFERRED)
                ;

        set.concept("Reference Range Minimum (SOLOR)", PublicIds.of(UUID.fromString("37c35a88-9e27-42ca-b626-186773c4b612"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e704406f-6dae-420c-8ba6-04a534108a68")), KernelTerm.ENGLISH_LANGUAGE, "Reference Range Minimum (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6ca3179e-7930-44a2-ad65-39df871acfe5")), KernelTerm.ENGLISH_LANGUAGE, "Minimum Value", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9144070a-f05d-430a-b74f-c520511557c2")), KernelTerm.ENGLISH_LANGUAGE, "The lowest possible value for a component", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e767a63e-72e0-4320-b12f-535505585068")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "37c35a88-9e27-42ca-b626-186773c4b612")
                .synonym("Min Value")
                .statedAxioms(PublicIds.of(UUID.fromString("1934f2ef-705e-5bc5-9617-dfdafdb22f54")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Reference Range", PublicIds.of("87ce975b-309b-47f4-a6c6-4ae6df6649a1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1c711869-4e73-4c14-be33-e67dfc264226")))
                .semanticOn(PublicIds.of(UUID.fromString("e704406f-6dae-420c-8ba6-04a534108a68")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5e3d227a-28e2-4096-b443-a10fc8449c99")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6ca3179e-7930-44a2-ad65-39df871acfe5")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("acc3eab9-84ba-4543-92eb-1549c837a039")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9144070a-f05d-430a-b74f-c520511557c2")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d078d4b2-ef07-4699-8774-fe6f6cca87e0")), KernelTerm.PREFERRED)
                ;

        set.concept("Reference Range Maximum (SOLOR)", PublicIds.of(UUID.fromString("72d58983-b1e1-4ca9-833f-0e40c1defd39"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7a00bf1e-fc1b-41f0-8801-022116d9c918")), KernelTerm.ENGLISH_LANGUAGE, "Reference Range Maximum (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ecf44545-d958-47fc-b4fe-38c6366a1242")), KernelTerm.ENGLISH_LANGUAGE, "Maximum Value", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8b43571f-a594-411c-a26e-49b70daa04cc")), KernelTerm.ENGLISH_LANGUAGE, "The highest possible value for a component", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("a44124ea-4c9b-4744-975e-1b3dc720c26f")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "72d58983-b1e1-4ca9-833f-0e40c1defd39")
                .synonym("Max Value")
                .statedAxioms(PublicIds.of(UUID.fromString("22861d9d-154d-5c34-b325-5b6babe9fda6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Reference Range", PublicIds.of("87ce975b-309b-47f4-a6c6-4ae6df6649a1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("32fa2f6a-5c73-408c-83cb-eaf5fe47c868")))
                .semanticOn(PublicIds.of(UUID.fromString("7a00bf1e-fc1b-41f0-8801-022116d9c918")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c472588d-86ea-4311-9482-d2a62ac72c44")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ecf44545-d958-47fc-b4fe-38c6366a1242")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1a8f1f4a-a8fd-4eaf-8bac-fcc7f4201b28")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("8b43571f-a594-411c-a26e-49b70daa04cc")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d56e0831-98c9-4eb4-9067-d425456dada1")), KernelTerm.PREFERRED)
                ;

    }
}
