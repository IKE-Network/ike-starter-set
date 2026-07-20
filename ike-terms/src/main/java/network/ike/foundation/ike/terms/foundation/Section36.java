package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Correlation properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section36 {

    private Section36() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Correlation properties (SOLOR)", PublicIds.of("8f682e00-3d9e-5506-bd19-b2169d6c8752")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f3261683-394f-4558-a9cb-ad54d40e6061"), IkeTerm.ENGLISH_LANGUAGE, "Correlation properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("dd06c997-f501-4efa-8289-93d065256a3f"), IkeTerm.ENGLISH_LANGUAGE, "Correlation properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ad46376b-b4b0-4697-aa64-a24de9cd184b"), IkeTerm.ENGLISH_LANGUAGE, "Characteristics or measures that describe the relationship between two or more variables", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("da8c76a2-2d14-47d1-87c7-d3809011d51b"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8f682e00-3d9e-5506-bd19-b2169d6c8752")
                .statedAxioms(PublicIds.of("9d9248b0-b71c-5599-b620-8b6030e59749"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("bbb285e7-816c-4ac0-9a13-10556db2c259"))
                .semanticOn(PublicIds.of("f3261683-394f-4558-a9cb-ad54d40e6061"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("05df2c63-4cf2-4b5f-973c-6d281e02677f"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("dd06c997-f501-4efa-8289-93d065256a3f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a6c4b3a7-6580-4ef7-ae1a-8917d61e64b4"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ad46376b-b4b0-4697-aa64-a24de9cd184b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5554d292-3612-498d-ad46-291c3a816e55"), IkeTerm.PREFERRED)
                ;

        set.concept("Correlation reference expression (SOLOR)", PublicIds.of("acb73d95-7c96-590c-9f24-23da54f95ff2")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b3c18ea0-a7d5-4b25-90ba-e1f9f6731247"), IkeTerm.ENGLISH_LANGUAGE, "Correlation reference expression (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("642e4a8b-5200-411b-98bb-0cf533567195"), IkeTerm.ENGLISH_LANGUAGE, "Correlation reference expression", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c43860eb-03bc-486a-965f-ff04e89271a6"), IkeTerm.ENGLISH_LANGUAGE, "A value for correlation", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("ac9b8eef-d5d4-4ad5-92a5-a84fd8e2ca96"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "acb73d95-7c96-590c-9f24-23da54f95ff2")
                .statedAxioms(PublicIds.of("35d89649-7fda-5e04-a6b4-e54c4ea366f7"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CORRELATION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("e7238efe-96fe-4a25-89c4-1833bea067b1"))
                .semanticOn(PublicIds.of("b3c18ea0-a7d5-4b25-90ba-e1f9f6731247"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0beccd41-7d92-4403-bb92-0da29819bb07"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("642e4a8b-5200-411b-98bb-0cf533567195"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("8c9dbe83-6f5a-4f77-91f2-95a826bd950a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c43860eb-03bc-486a-965f-ff04e89271a6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("9d0162a3-e3d3-43c9-8e9d-7313867a475c"), IkeTerm.PREFERRED)
                ;

        set.concept("Correlation expression (SOLOR)", PublicIds.of("1711815f-99a1-5d1a-8f1e-75dc7bf41928")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("49efd8b7-dd12-4521-ace3-daafb3863247"), IkeTerm.ENGLISH_LANGUAGE, "Correlation expression (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0b876445-c9e5-45ff-97ab-752b810fd2ba"), IkeTerm.ENGLISH_LANGUAGE, "Correlation expression", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("311c6d54-29a6-40cb-8275-f3a1f8d7d88d"), IkeTerm.ENGLISH_LANGUAGE, "A value for Correlation properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("46b2b75e-f0e6-4733-842b-37f0424e646b"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1711815f-99a1-5d1a-8f1e-75dc7bf41928")
                .statedAxioms(PublicIds.of("779cb579-d0a8-5621-a05a-5be1f3b82ebf"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CORRELATION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("ae53889b-2546-4b6d-a46f-f46fdf8f756e"))
                .semanticOn(PublicIds.of("49efd8b7-dd12-4521-ace3-daafb3863247"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("79d2e30c-6b83-489e-acaf-1afde20bc1ef"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0b876445-c9e5-45ff-97ab-752b810fd2ba"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a9f4cbaf-a000-413f-8fc1-cac4e27e70ff"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("311c6d54-29a6-40cb-8275-f3a1f8d7d88d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("16111ce2-b314-40d7-8b7c-76cb2c2b63e8"), IkeTerm.PREFERRED)
                ;

    }
}
