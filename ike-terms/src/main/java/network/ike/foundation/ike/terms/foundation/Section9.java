package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Concept type" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section9 {

    private Section9() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Concept type (SOLOR)", PublicIds.of("106f3ba1-63b8-5596-8dbe-524fa2e89fc0")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bd9173e4-36ff-43c2-b1a7-aaaadf6f0d26"), IkeTerm.ENGLISH_LANGUAGE, "Concept type (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d7371127-ba27-4c3d-8c73-4de1a9e327a6"), IkeTerm.ENGLISH_LANGUAGE, "Concept type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0976a5d1-792c-4801-a20b-32ae4d4c6869"), IkeTerm.ENGLISH_LANGUAGE, "A field that captures a defined concept label", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("11c2420e-a03c-4163-b443-d95f39a9d686"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "106f3ba1-63b8-5596-8dbe-524fa2e89fc0")
                .statedAxioms(PublicIds.of("1329bbbf-1328-5a3a-bc44-c47806714491"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("1f752d82-7c3a-41ee-b279-fe92ec359b27"))
                .semanticOn(PublicIds.of("bd9173e4-36ff-43c2-b1a7-aaaadf6f0d26"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b8f7e427-808d-4b1b-8e18-4089976fe3c0"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d7371127-ba27-4c3d-8c73-4de1a9e327a6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2538c2fe-0869-488e-bf02-85d56b5c54a5"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0976a5d1-792c-4801-a20b-32ae4d4c6869"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("af6404b4-0923-4cfa-876c-b9dd3798b33d"), IkeTerm.PREFERRED)
                ;

        set.concept("Anonymous concept (SOLOR)", PublicIds.of("f8f936d4-3ac7-5629-9f65-9452608056a1")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5b7be698-9054-40c2-b7d8-9dd95f01d4c0"), IkeTerm.ENGLISH_LANGUAGE, "Anonymous concept (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ec7a682f-548a-4a6e-b422-e96ccb71a1ec"), IkeTerm.ENGLISH_LANGUAGE, "Anonymous concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("41c0422a-4fdd-4489-be80-5340d2b827e2"), IkeTerm.ENGLISH_LANGUAGE, "Concepts or entities that do not have a specific, named identity, (defined on-the-fly without a dedicated name)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("76246e43-6254-4799-bbea-589ac20eb880"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f8f936d4-3ac7-5629-9f65-9452608056a1")
                .statedAxioms(PublicIds.of("7a02d3b4-9041-5385-9e25-f5719500382d"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCEPT_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("98407c2f-8e37-49a3-8b8f-55c0d653f439"))
                .semanticOn(PublicIds.of("5b7be698-9054-40c2-b7d8-9dd95f01d4c0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6aafa93c-977a-41b1-8307-0272fc4c190e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ec7a682f-548a-4a6e-b422-e96ccb71a1ec"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d42c90ee-573a-4d2c-8afd-25409effa724"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("41c0422a-4fdd-4489-be80-5340d2b827e2"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d2d367bc-c5f7-4e66-9ed7-a7bbde293510"), IkeTerm.PREFERRED)
                ;

        set.concept("Path concept (SOLOR)", PublicIds.of("1b9d9f95-fc0a-55ac-b2e6-7c8b37660046")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("59df2d01-eabe-482f-bfd9-b42bf714b998"), IkeTerm.ENGLISH_LANGUAGE, "Path concept (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("14275036-cd69-4513-a001-7c365c6f8907"), IkeTerm.ENGLISH_LANGUAGE, "Path concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e371f3da-583a-48f2-b91b-7a15da88ba07"), IkeTerm.ENGLISH_LANGUAGE, "A concept that is itself a version-control path — the concept kind a path is represented by. As the Path origins pattern's first field meaning it names the field holding the origin path a path branched from.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("e7709db3-c541-4506-9054-9b21de7ee390"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1b9d9f95-fc0a-55ac-b2e6-7c8b37660046")
                .statedAxioms(PublicIds.of("1ee07fee-643a-5c0e-bb14-3ccdfb3b315d"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCEPT_TYPE), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("06473ccc-3b24-4c37-886a-9de35ef642b3"))
                .semanticOn(PublicIds.of("59df2d01-eabe-482f-bfd9-b42bf714b998"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("979780e2-b897-4a84-aaf6-659ba2f130f7"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("14275036-cd69-4513-a001-7c365c6f8907"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("529e5915-ffd6-4682-be08-1fec522b4a9f"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("e371f3da-583a-48f2-b91b-7a15da88ba07"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a6ef1db4-ae4f-40ea-bce9-3484f9bdddbd"), IkeTerm.PREFERRED)
                ;

        set.concept("Semantic field concepts (SOLOR)", PublicIds.of("b4316cb8-14fe-5b32-b03b-f5f966c87819")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("44326fea-270c-4e02-980a-c6647d6006af"), IkeTerm.ENGLISH_LANGUAGE, "Semantic field concepts (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4b0567e0-9385-4f8f-bbc4-240431bcc05d"), IkeTerm.ENGLISH_LANGUAGE, "Semantic field concepts", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("adc5c6a6-e04c-4479-ac65-b908a10fc7bc"), IkeTerm.ENGLISH_LANGUAGE, "The concept type for concepts that serve as semantic field values in the base model.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("6df82d36-6256-442c-8709-7639c0e888a4"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b4316cb8-14fe-5b32-b03b-f5f966c87819")
                .statedAxioms(PublicIds.of("ecea102a-9c57-55f5-89d9-100260eccf8d"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCEPT_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("755022a5-339d-4409-8158-d7e99e2d7d24"))
                .semanticOn(PublicIds.of("44326fea-270c-4e02-980a-c6647d6006af"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("87b624d4-9b5b-4f83-acbe-29616d677d3e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("4b0567e0-9385-4f8f-bbc4-240431bcc05d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b1472b2f-9314-4fd8-9d81-f628225a1fb3"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("adc5c6a6-e04c-4479-ac65-b908a10fc7bc"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0b9e5bb6-3ff7-423c-8adf-16722935af0d"), IkeTerm.PREFERRED)
                ;

    }
}
