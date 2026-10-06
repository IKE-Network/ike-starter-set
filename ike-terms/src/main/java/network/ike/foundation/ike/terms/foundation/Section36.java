package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Correlation properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section36 {

    private Section36() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Correlation properties (SOLOR)", PublicIds.of(UUID.fromString("8f682e00-3d9e-5506-bd19-b2169d6c8752"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f3261683-394f-4558-a9cb-ad54d40e6061")), KernelTerm.ENGLISH_LANGUAGE, "Correlation properties (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dd06c997-f501-4efa-8289-93d065256a3f")), KernelTerm.ENGLISH_LANGUAGE, "Correlation properties", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ad46376b-b4b0-4697-aa64-a24de9cd184b")), KernelTerm.ENGLISH_LANGUAGE, "Characteristics or measures that describe the relationship between two or more variables", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("da8c76a2-2d14-47d1-87c7-d3809011d51b")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "8f682e00-3d9e-5506-bd19-b2169d6c8752")
                .statedAxioms(PublicIds.of(UUID.fromString("9d9248b0-b71c-5599-b620-8b6030e59749")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object properties (SOLOR)", PublicIds.of("3ef4311c-70c0-5149-9e06-53d745f85b15"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("bbb285e7-816c-4ac0-9a13-10556db2c259")))
                .semanticOn(PublicIds.of(UUID.fromString("f3261683-394f-4558-a9cb-ad54d40e6061")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("05df2c63-4cf2-4b5f-973c-6d281e02677f")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("dd06c997-f501-4efa-8289-93d065256a3f")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a6c4b3a7-6580-4ef7-ae1a-8917d61e64b4")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ad46376b-b4b0-4697-aa64-a24de9cd184b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5554d292-3612-498d-ad46-291c3a816e55")), KernelTerm.PREFERRED)
                ;

        set.concept("Correlation reference expression (SOLOR)", PublicIds.of(UUID.fromString("acb73d95-7c96-590c-9f24-23da54f95ff2"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b3c18ea0-a7d5-4b25-90ba-e1f9f6731247")), KernelTerm.ENGLISH_LANGUAGE, "Correlation reference expression (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("642e4a8b-5200-411b-98bb-0cf533567195")), KernelTerm.ENGLISH_LANGUAGE, "Correlation reference expression", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c43860eb-03bc-486a-965f-ff04e89271a6")), KernelTerm.ENGLISH_LANGUAGE, "A value for correlation", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ac9b8eef-d5d4-4ad5-92a5-a84fd8e2ca96")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "acb73d95-7c96-590c-9f24-23da54f95ff2")
                .statedAxioms(PublicIds.of(UUID.fromString("35d89649-7fda-5e04-a6b4-e54c4ea366f7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Correlation properties (SOLOR)", PublicIds.of("8f682e00-3d9e-5506-bd19-b2169d6c8752"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e7238efe-96fe-4a25-89c4-1833bea067b1")))
                .semanticOn(PublicIds.of(UUID.fromString("b3c18ea0-a7d5-4b25-90ba-e1f9f6731247")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0beccd41-7d92-4403-bb92-0da29819bb07")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("642e4a8b-5200-411b-98bb-0cf533567195")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8c9dbe83-6f5a-4f77-91f2-95a826bd950a")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c43860eb-03bc-486a-965f-ff04e89271a6")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9d0162a3-e3d3-43c9-8e9d-7313867a475c")), KernelTerm.PREFERRED)
                ;

        set.concept("Correlation expression (SOLOR)", PublicIds.of(UUID.fromString("1711815f-99a1-5d1a-8f1e-75dc7bf41928"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("49efd8b7-dd12-4521-ace3-daafb3863247")), KernelTerm.ENGLISH_LANGUAGE, "Correlation expression (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0b876445-c9e5-45ff-97ab-752b810fd2ba")), KernelTerm.ENGLISH_LANGUAGE, "Correlation expression", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("311c6d54-29a6-40cb-8275-f3a1f8d7d88d")), KernelTerm.ENGLISH_LANGUAGE, "A value for Correlation properties", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("46b2b75e-f0e6-4733-842b-37f0424e646b")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "1711815f-99a1-5d1a-8f1e-75dc7bf41928")
                .statedAxioms(PublicIds.of(UUID.fromString("779cb579-d0a8-5621-a05a-5be1f3b82ebf")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Correlation properties (SOLOR)", PublicIds.of("8f682e00-3d9e-5506-bd19-b2169d6c8752"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ae53889b-2546-4b6d-a46f-f46fdf8f756e")))
                .semanticOn(PublicIds.of(UUID.fromString("49efd8b7-dd12-4521-ace3-daafb3863247")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("79d2e30c-6b83-489e-acaf-1afde20bc1ef")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0b876445-c9e5-45ff-97ab-752b810fd2ba")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a9f4cbaf-a000-413f-8fc1-cac4e27e70ff")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("311c6d54-29a6-40cb-8275-f3a1f8d7d88d")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("16111ce2-b314-40d7-8b7c-76cb2c2b63e8")), KernelTerm.PREFERRED)
                ;

    }
}
