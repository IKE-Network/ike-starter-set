package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Concrete value operator" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section14 {

    private Section14() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Concrete value operator (SOLOR)", PublicIds.of(UUID.fromString("843b0b55-8785-5544-93f6-581da9cf1ff3"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4aa2e872-1652-4baf-8c63-09c958512777")), IkeTerm.ENGLISH_LANGUAGE, "Concrete value operator (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3db6cc33-e2cb-458d-a2c7-85932d4bc39b")), IkeTerm.ENGLISH_LANGUAGE, "Concrete value operator", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d885dabc-d314-4993-b171-7f0feba98c81")), IkeTerm.ENGLISH_LANGUAGE, "A concept that specifies value operators", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("a1acdfb0-d1d1-4cd5-a350-8dd7060dac60")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "843b0b55-8785-5544-93f6-581da9cf1ff3")
                .statedAxioms(PublicIds.of(UUID.fromString("8aa3eb09-fd9b-5265-8ca8-7a34385f9104")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5f3fdfa9-47dc-4e2c-a811-fc0626c1606d")))
                .semanticOn(PublicIds.of(UUID.fromString("4aa2e872-1652-4baf-8c63-09c958512777")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ef537b49-71df-4188-9ae4-f800464a4b24")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3db6cc33-e2cb-458d-a2c7-85932d4bc39b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a92c1170-c9c4-4d94-a24e-e28fe2e9ed72")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d885dabc-d314-4993-b171-7f0feba98c81")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("dbf1729b-5066-4020-bff4-2bdd3e06b74a")), IkeTerm.PREFERRED)
                ;

        set.concept("Less than or equal to (SOLOR)", PublicIds.of(UUID.fromString("6dfacbd5-8344-5794-9fda-bec95b2aa6c9"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("554dc4b1-b794-42b5-a3a6-499b40cdb6d9")), IkeTerm.ENGLISH_LANGUAGE, "Less than or equal to (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("069f33d8-6566-4fad-8b53-86bfaab12eeb")), IkeTerm.ENGLISH_LANGUAGE, "Less than or equal to", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d361fd77-3753-4a3a-8755-180df64ab362")), IkeTerm.ENGLISH_LANGUAGE, "A concept indicating the operator \"<=\"", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("05be9b16-9b77-4766-bb6a-f70b0fdb630a")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6dfacbd5-8344-5794-9fda-bec95b2aa6c9")
                .statedAxioms(PublicIds.of(UUID.fromString("76bf837d-6b64-5259-9454-eb0f32ad86ee")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCRETE_DOMAIN_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("24cbd41e-0eb9-46f2-aea3-9c6ac513fb70")))
                .semanticOn(PublicIds.of(UUID.fromString("554dc4b1-b794-42b5-a3a6-499b40cdb6d9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1540aac7-fe2a-4be6-850b-21c149f34d86")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("069f33d8-6566-4fad-8b53-86bfaab12eeb")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5f00b974-3434-482c-8585-ab4de97ad3c5")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d361fd77-3753-4a3a-8755-180df64ab362")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cf61160d-d94a-434d-ba10-a5a40e91f3ef")), IkeTerm.PREFERRED)
                ;

        set.concept("Minimum Value Operator (SOLOR)", PublicIds.of(UUID.fromString("ded98e42-f74a-4432-9ae7-01b94dc2fdea"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cee1a664-de5f-45c3-a549-7777aeb18bfc")), IkeTerm.ENGLISH_LANGUAGE, "Minimum Value Operator (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9c99394e-2156-47a6-8435-a7bf37ef8849")), IkeTerm.ENGLISH_LANGUAGE, "Minimum Value Operator; Minimum Domain Operator", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b7b53a01-207d-48f3-8f71-a70a89376313")), IkeTerm.ENGLISH_LANGUAGE, "The Value Operator assigned to the Minimum Value in a Range", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("06832c67-f14d-40e5-b89f-6e91ce86c160")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ded98e42-f74a-4432-9ae7-01b94dc2fdea")
                .statedAxioms(PublicIds.of(UUID.fromString("6ce65e64-7299-5baa-a64a-41599a3b13f1")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCRETE_DOMAIN_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ed446c46-62fe-4dc2-90b8-7b5c69827e32")))
                .semanticOn(PublicIds.of(UUID.fromString("cee1a664-de5f-45c3-a549-7777aeb18bfc")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fabfd618-7fa0-4002-8707-769b448cea8a")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9c99394e-2156-47a6-8435-a7bf37ef8849")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1359ed99-6cc4-4583-b766-e96829e401d3")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b7b53a01-207d-48f3-8f71-a70a89376313")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("67bd8c11-1203-4d32-843d-9b01250faf3b")), IkeTerm.PREFERRED)
                ;

        set.concept("Less than (SOLOR)", PublicIds.of(UUID.fromString("6f96e8cf-5568-5e49-8a90-aa6c65125ee9"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9fdc5a89-e340-4aec-942f-6b65a48df8a5")), IkeTerm.ENGLISH_LANGUAGE, "Less than (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b4de4ba3-9f97-43be-8ccd-8529551d375a")), IkeTerm.ENGLISH_LANGUAGE, "Less than", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ab7004b7-d20a-4d3a-80eb-6da33801a535")), IkeTerm.ENGLISH_LANGUAGE, "A concept indicating the operator \"<\"", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("689701c6-1413-47b7-b292-6eac0b22dd27")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6f96e8cf-5568-5e49-8a90-aa6c65125ee9")
                .statedAxioms(PublicIds.of(UUID.fromString("6e5827ae-fc35-5039-a1fd-c2c1fc1d8929")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCRETE_DOMAIN_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8f40b213-8bd5-459b-a09e-413014fed24c")))
                .semanticOn(PublicIds.of(UUID.fromString("9fdc5a89-e340-4aec-942f-6b65a48df8a5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b780d762-b76f-4718-8137-68ce5d1dfda7")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b4de4ba3-9f97-43be-8ccd-8529551d375a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2fcdf34c-8317-4b98-912e-c657cb994889")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ab7004b7-d20a-4d3a-80eb-6da33801a535")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("da3a9fc6-9947-4811-ae70-6544aa130855")), IkeTerm.PREFERRED)
                ;

        set.concept("Greater than or equal to (SOLOR)", PublicIds.of(UUID.fromString("c1baba19-e918-5d2c-8fa4-b0ad93e03186"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ec1f0576-6226-4e77-80ec-ac21f6b6fac5")), IkeTerm.ENGLISH_LANGUAGE, "Greater than or equal to (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("88ef8367-159c-4097-88eb-0bef93616c03")), IkeTerm.ENGLISH_LANGUAGE, "Greater than or equal to", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6b15ddb8-70db-4eb4-af84-3aa659304b31")), IkeTerm.ENGLISH_LANGUAGE, "A concept indicating the operator \">=\"", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ac45a513-6d56-4ca2-bac7-87200e56196b")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c1baba19-e918-5d2c-8fa4-b0ad93e03186")
                .statedAxioms(PublicIds.of(UUID.fromString("6d1a8fd8-8a25-5ba5-8ff5-53908f9f14de")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCRETE_DOMAIN_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("2e662e83-3ba2-4847-a871-81ca5f30c083")))
                .semanticOn(PublicIds.of(UUID.fromString("ec1f0576-6226-4e77-80ec-ac21f6b6fac5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b061b353-b705-42b3-8b62-608b08dbd42c")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("88ef8367-159c-4097-88eb-0bef93616c03")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("668990db-536c-4bb9-a3be-37faa4f2b5c7")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6b15ddb8-70db-4eb4-af84-3aa659304b31")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("95a43a2f-70be-4778-ac23-34a99326566f")), IkeTerm.PREFERRED)
                ;

        set.concept("Maximum Value Operator (SOLOR)", PublicIds.of(UUID.fromString("7b8916ab-fd50-41df-8fc2-0b2a7a78be6d"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e8837ba3-db2d-4b1b-ab2d-e8cf8e66ce1f")), IkeTerm.ENGLISH_LANGUAGE, "Maximum Value Operator (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("37574633-b1ec-4f6c-a578-ebb465fabb67")), IkeTerm.ENGLISH_LANGUAGE, "Maximum Value Operator; Maximum Domain Operator", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("78ea5bf8-8bdc-4c27-ac91-d467a4479f1f")), IkeTerm.ENGLISH_LANGUAGE, "The Value Operator assigned to the Maximum Value in a Range", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0ac45d50-14e8-4158-acdc-a531d8791c7e")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "7b8916ab-fd50-41df-8fc2-0b2a7a78be6d")
                .statedAxioms(PublicIds.of(UUID.fromString("67faa3fb-2c93-5d00-8213-71f07dc9f336")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCRETE_DOMAIN_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("bd5fd7f7-7798-4c56-989d-9cdfd2700f0f")))
                .semanticOn(PublicIds.of(UUID.fromString("e8837ba3-db2d-4b1b-ab2d-e8cf8e66ce1f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a012c0e1-f747-4d8b-b722-a242a339cc8d")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("37574633-b1ec-4f6c-a578-ebb465fabb67")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("eaa24bdf-2142-49cf-9914-3364cbb1cb05")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("78ea5bf8-8bdc-4c27-ac91-d467a4479f1f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cd212506-da63-4bcc-82c7-4ba1651eb5ce")), IkeTerm.PREFERRED)
                ;

        set.concept("Greater than (SOLOR)", PublicIds.of(UUID.fromString("65af466b-360c-58b2-8b7d-2854150029a8"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("14085a4b-e115-4d21-8fa6-54562692b8ed")), IkeTerm.ENGLISH_LANGUAGE, "Greater than (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("85a1f259-7466-48f8-9bd2-675ae881d4d1")), IkeTerm.ENGLISH_LANGUAGE, "Greater than", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("893179a4-ce13-437b-8bd2-5350c3084a65")), IkeTerm.ENGLISH_LANGUAGE, "A concept indicating the operator \">\"", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("d55cc418-72d1-4fb6-800d-6c7e61056759")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "65af466b-360c-58b2-8b7d-2854150029a8")
                .statedAxioms(PublicIds.of(UUID.fromString("12d6b35c-e416-5b50-a1b1-5a48666a9e72")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCRETE_DOMAIN_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ed892562-f795-4670-aee9-bff03ecf8da9")))
                .semanticOn(PublicIds.of(UUID.fromString("14085a4b-e115-4d21-8fa6-54562692b8ed")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("23d1a52c-0d78-4857-9b40-e36950274438")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("85a1f259-7466-48f8-9bd2-675ae881d4d1")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c50415e3-ff2e-4608-bd02-0f16c84a2487")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("893179a4-ce13-437b-8bd2-5350c3084a65")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f8445fdd-87de-4cc2-abe6-2ce5ac15e410")), IkeTerm.PREFERRED)
                ;

        set.concept("Equal to (SOLOR)", PublicIds.of(UUID.fromString("5c9b5844-1434-5111-83d5-cb7cb0be12d9"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("352cc7ca-295e-4dbd-b174-11cbc45e007c")), IkeTerm.ENGLISH_LANGUAGE, "Equal to (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e9d1a3b6-51c0-47da-8ab7-b929bbe6c649")), IkeTerm.ENGLISH_LANGUAGE, "Equal to", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("62183df2-2e8d-4418-aea4-90c69392e7b9")), IkeTerm.ENGLISH_LANGUAGE, "A concept indicating the operator \"=\"", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e717d898-9a22-4435-9e55-17d01010ead3")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "5c9b5844-1434-5111-83d5-cb7cb0be12d9")
                .statedAxioms(PublicIds.of(UUID.fromString("1ed8087e-d205-5e03-92ac-b86e50115de2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CONCRETE_DOMAIN_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("568c3f06-85a8-4846-bdc6-066f66239fa2")))
                .semanticOn(PublicIds.of(UUID.fromString("352cc7ca-295e-4dbd-b174-11cbc45e007c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ab408306-0013-4601-b4d4-33bd0828f144")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e9d1a3b6-51c0-47da-8ab7-b929bbe6c649")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("29c1d1ad-a646-4bd0-83d2-f2b9ad9aa3e4")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("62183df2-2e8d-4418-aea4-90c69392e7b9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ba6f59ed-9a99-42ec-be46-3c7709a64b79")), IkeTerm.PREFERRED)
                ;

    }
}
