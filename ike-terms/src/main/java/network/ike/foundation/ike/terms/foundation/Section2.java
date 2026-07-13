package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Language" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section2 {

    private Section2() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Language", PublicIds.of(UUID.fromString("f56fa231-10f9-5e7f-a86d-a1d61b5b56e3"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("87dc1321-7db7-45cf-9237-145d78436cbb")), TinkarTerm.ENGLISH_LANGUAGE, "Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("17ba4aba-45ea-4715-81ac-d3b268d41175")), TinkarTerm.ENGLISH_LANGUAGE, "Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("82cc12f1-30a2-4557-8c86-b4bc5bbae063")), TinkarTerm.ENGLISH_LANGUAGE, "Specifies the language of the description text.", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("553e3d40-e19a-4440-ba0b-fce64f3692f8")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f56fa231-10f9-5e7f-a86d-a1d61b5b56e3")
                .statedAxioms(PublicIds.of(UUID.fromString("8772f036-a392-5231-94e7-9964c2497ccc")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b40e0744-67bf-422f-979a-5a947ede91df")))
                .semanticOn(PublicIds.of(UUID.fromString("87dc1321-7db7-45cf-9237-145d78436cbb")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("23a6626d-e8d5-408b-bd3b-a9caa37e3fbb")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("17ba4aba-45ea-4715-81ac-d3b268d41175")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("675b5756-c28c-4e57-956f-76438ccdf651")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("82cc12f1-30a2-4557-8c86-b4bc5bbae063")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c1078819-9547-48fd-a6b3-bcd52a223f3d")), TinkarTerm.PREFERRED)
                ;

        set.concept("Irish language (SOLOR)", PublicIds.of(UUID.fromString("58e82fc4-1492-5cf8-8997-43800360bbd6"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("854cc982-f7b2-4434-88f6-47bdef821652")), TinkarTerm.ENGLISH_LANGUAGE, "Irish language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0c8beffb-d982-44bc-8eda-08c8cc543e7e")), TinkarTerm.ENGLISH_LANGUAGE, "Irish language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("356fcaed-0d26-4247-9d57-4c2cc36a3b23")), TinkarTerm.ENGLISH_LANGUAGE, "Irish language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("70e78c8c-9703-4dfe-bc73-5a1873ae3070")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "58e82fc4-1492-5cf8-8997-43800360bbd6")
                .statedAxioms(PublicIds.of(UUID.fromString("ff3f0133-e7ad-5b97-a126-d7c7560ce72c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8d938b71-c20f-4034-8850-e86098df1642")))
                .semanticOn(PublicIds.of(UUID.fromString("854cc982-f7b2-4434-88f6-47bdef821652")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bb11a16d-5b50-451a-a703-58540f926915")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0c8beffb-d982-44bc-8eda-08c8cc543e7e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6ea63c7b-3f76-47fd-8c6d-b82927618311")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("356fcaed-0d26-4247-9d57-4c2cc36a3b23")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b8cc0066-ed51-45a2-adec-83c904c57778")), TinkarTerm.PREFERRED)
                ;

        set.concept("English Language", PublicIds.of(UUID.fromString("02018e5a-46ba-5297-92f1-6931b9f98a12"), UUID.fromString("06d905ea-c647-3af9-bfe5-2514e135b558"), UUID.fromString("45021920-9567-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2d1536b9-69a2-4a53-a324-80d38d38ca17")), TinkarTerm.ENGLISH_LANGUAGE, "English Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6e268da6-5e2c-44af-9564-4e764e9043cd")), TinkarTerm.ENGLISH_LANGUAGE, "English language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("11f09c95-a5eb-419b-8de5-8a0d72c46a7e")), TinkarTerm.ENGLISH_LANGUAGE, "Value for description language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("3d271ae6-0fe5-41cc-8f69-15745ff2dd10")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "02018e5a-46ba-5297-92f1-6931b9f98a12")
                .statedAxioms(PublicIds.of(UUID.fromString("0cecb670-1c27-5b87-b9a5-bcb1ad2d7a8f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("bdda09d9-0843-48ac-8a97-0985f983f868")))
                .semanticOn(PublicIds.of(UUID.fromString("2d1536b9-69a2-4a53-a324-80d38d38ca17")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("52c0acea-5d43-4fd4-a00a-77ce8cea9510")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6e268da6-5e2c-44af-9564-4e764e9043cd")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c50843a3-bd55-4806-9a49-a2210c1a6d5a")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("11f09c95-a5eb-419b-8de5-8a0d72c46a7e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8ee3e94a-d1b0-4da8-9494-4892e3baf754")), TinkarTerm.PREFERRED)
                ;

        set.concept("Czech language (SOLOR)", PublicIds.of(UUID.fromString("33aa2d26-0541-557c-b796-904cbf245101"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("223feabf-f0f2-418a-9051-8600eac5bc7c")), TinkarTerm.ENGLISH_LANGUAGE, "Czech language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("91baa056-d6e0-43db-849b-1b9eda41b7e9")), TinkarTerm.ENGLISH_LANGUAGE, "Czech language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a92013e4-0fa5-4562-ada2-f683d02b0ebb")), TinkarTerm.ENGLISH_LANGUAGE, "Czech Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f10d5123-384f-4bb8-a39d-86911d4a04f7")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "33aa2d26-0541-557c-b796-904cbf245101")
                .statedAxioms(PublicIds.of(UUID.fromString("5689b642-1d93-5e95-a403-e6cfda575f42")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("85d4ddb4-b392-4ac1-a949-8d6ccb2350da")))
                .semanticOn(PublicIds.of(UUID.fromString("223feabf-f0f2-418a-9051-8600eac5bc7c")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("949e8f32-a3c0-4bdd-86a9-d06f76cd94f4")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("91baa056-d6e0-43db-849b-1b9eda41b7e9")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cb03f1aa-a1a7-42d5-a153-3b7e1dd8a034")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a92013e4-0fa5-4562-ada2-f683d02b0ebb")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ff23ad9b-2834-422a-960c-e667c80a5ed2")), TinkarTerm.PREFERRED)
                ;

        set.concept("Danish language (SOLOR)", PublicIds.of(UUID.fromString("987681fb-f3ef-595d-90e2-067baf2bc71f"), UUID.fromString("45021f10-9567-11e5-8994-feff819cdc9f"), UUID.fromString("7e462e33-6d94-38ae-a044-492a857a6853"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("98f6bc71-fea5-4521-888e-b71b9d730e4f")), TinkarTerm.ENGLISH_LANGUAGE, "Danish language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ae65203a-be7d-4f7f-8670-deb0f19a6ff8")), TinkarTerm.ENGLISH_LANGUAGE, "Danish language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("54e3ffec-09e2-47b7-bcb9-0bbfb39230d6")), TinkarTerm.ENGLISH_LANGUAGE, "Danish Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f80232d9-97da-493e-8170-0a74f9bbc5d5")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "987681fb-f3ef-595d-90e2-067baf2bc71f")
                .statedAxioms(PublicIds.of(UUID.fromString("14b7a1bd-59fd-5b9e-bfe1-9c1c1e42d674")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1a4642f9-892c-4144-b017-fed6d5cb5622")))
                .semanticOn(PublicIds.of(UUID.fromString("98f6bc71-fea5-4521-888e-b71b9d730e4f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8863201c-ab6c-4156-bea8-a5ee52f3f5e7")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ae65203a-be7d-4f7f-8670-deb0f19a6ff8")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b2f29cf1-0bf5-4036-a0a7-7957b065a37b")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("54e3ffec-09e2-47b7-bcb9-0bbfb39230d6")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("dc1b1d06-e746-4379-8250-68caf2c1a288")), TinkarTerm.PREFERRED)
                ;

        set.concept("French Language (SOLOR)", PublicIds.of(UUID.fromString("8b23e636-a0bd-30fb-b8e2-1f77eaa3a87e"), UUID.fromString("01707e47-5f6d-555e-80af-3c1ffb297eaa"), UUID.fromString("45021dbc-9567-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c2e69dfe-3227-47cf-b167-2f6dc63e5e89")), TinkarTerm.ENGLISH_LANGUAGE, "French Language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ecc44ba8-a765-4644-8864-d3c98e9141f4")), TinkarTerm.ENGLISH_LANGUAGE, "French language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("26b8abbf-96f4-485e-9593-175dcc292dfa")), TinkarTerm.ENGLISH_LANGUAGE, "French Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c5dc6671-1595-4536-b97c-ec12343b986c")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8b23e636-a0bd-30fb-b8e2-1f77eaa3a87e")
                .statedAxioms(PublicIds.of(UUID.fromString("e4efff56-f81d-5674-8f97-d54623326058")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9908807b-919c-48c6-b133-e8ee1bf29b8c")))
                .semanticOn(PublicIds.of(UUID.fromString("c2e69dfe-3227-47cf-b167-2f6dc63e5e89")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fe8d0c89-a19e-419a-a631-ddff7c8b3c2b")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ecc44ba8-a765-4644-8864-d3c98e9141f4")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ff3c0739-38a1-4cdc-99ee-6098a0fa3df7")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("26b8abbf-96f4-485e-9593-175dcc292dfa")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bd725401-6ef5-4651-8438-1adc0fbbca50")), TinkarTerm.PREFERRED)
                ;

        set.concept("German Language (SOLOR)", PublicIds.of(UUID.fromString("5f144b18-76a8-5c7e-8480-55a5030d707f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e11d8cf8-a4dd-42d4-b7f1-d1184e546f6d")), TinkarTerm.ENGLISH_LANGUAGE, "German Language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bd45dbc8-1ba2-4b74-a9c2-2682692fb16a")), TinkarTerm.ENGLISH_LANGUAGE, "German language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("56534ec6-2f32-42ba-81bd-4016bd292720")), TinkarTerm.ENGLISH_LANGUAGE, "German Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("5e9908cb-9ec5-47bf-a25b-c9964737bf34")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "5f144b18-76a8-5c7e-8480-55a5030d707f")
                .statedAxioms(PublicIds.of(UUID.fromString("d2eb833d-a759-55e5-86f5-5b840e49e8c3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d88e14f2-5582-49ac-a678-340b61f3f6ee")))
                .semanticOn(PublicIds.of(UUID.fromString("e11d8cf8-a4dd-42d4-b7f1-d1184e546f6d")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("019c17b7-5809-4fe2-8641-c0e4be28371c")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bd45dbc8-1ba2-4b74-a9c2-2682692fb16a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("51b71a29-fc3f-49bf-82f0-1f5353fb5746")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("56534ec6-2f32-42ba-81bd-4016bd292720")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2032e935-d94b-48e9-8f98-49851556e915")), TinkarTerm.PREFERRED)
                ;

        set.concept("Polish Language (Language)", PublicIds.of(UUID.fromString("c924b887-da88-3a72-b8ea-fa86990467c9"), UUID.fromString("45022140-9567-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cca81c49-d69c-4b81-988d-4bf4d02a2211")), TinkarTerm.ENGLISH_LANGUAGE, "Polish Language (Language)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e6f25b8f-a97b-4710-9a18-ab6b4b078008")), TinkarTerm.ENGLISH_LANGUAGE, "Polish language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cd2aa44c-2ce7-46b0-8d1d-104977c162d5")), TinkarTerm.ENGLISH_LANGUAGE, "Polish Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c4eff24e-2354-490a-a05e-6664952e42ff")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c924b887-da88-3a72-b8ea-fa86990467c9")
                .statedAxioms(PublicIds.of(UUID.fromString("5db6f856-6d6d-5fcd-8565-9e119bd37591")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("74ab79a2-dbb3-474d-ad60-793cac1cbee3")))
                .semanticOn(PublicIds.of(UUID.fromString("cca81c49-d69c-4b81-988d-4bf4d02a2211")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5cb44da6-dca3-4f3c-af4c-ccb002d56564")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e6f25b8f-a97b-4710-9a18-ab6b4b078008")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1da2979e-7c40-463d-9604-8974feb93176")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cd2aa44c-2ce7-46b0-8d1d-104977c162d5")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d7803a33-56b0-4617-8031-9b9777fbf173")), TinkarTerm.PREFERRED)
                ;

        set.concept("Italian Language (SOLOR)", PublicIds.of(UUID.fromString("bdd59458-381a-5818-8577-60525f11ac6c"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e4ed6fc8-7f7a-4175-91bf-c62561b64bf7")), TinkarTerm.ENGLISH_LANGUAGE, "Italian Language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fd9b834a-cc73-4205-a9b7-c6ba911ab82b")), TinkarTerm.ENGLISH_LANGUAGE, "Italian language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1f820a2a-03f0-44b7-87ad-42b10ead09b0")), TinkarTerm.ENGLISH_LANGUAGE, "Italian language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("7a91d701-62dc-4b4b-9664-52634dedb6c6")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "bdd59458-381a-5818-8577-60525f11ac6c")
                .statedAxioms(PublicIds.of(UUID.fromString("578c2cdd-893a-5490-8a1d-588e6d7e8900")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f5e519e1-4307-40df-9936-244e04b69deb")))
                .semanticOn(PublicIds.of(UUID.fromString("e4ed6fc8-7f7a-4175-91bf-c62561b64bf7")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b6125291-8f75-4f36-9f55-35557c5fe13a")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("fd9b834a-cc73-4205-a9b7-c6ba911ab82b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d4792bea-55fb-455a-9445-9704a8b87449")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1f820a2a-03f0-44b7-87ad-42b10ead09b0")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0eee9fc6-ad02-4571-a368-4ee2f80ee37b")), TinkarTerm.PREFERRED)
                ;

        set.concept("Korean Language (SOLOR)", PublicIds.of(UUID.fromString("1464f995-d658-5e9d-86e0-8308a6fa57eb"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e77fc723-add8-498d-9a3d-66c80d94d52c")), TinkarTerm.ENGLISH_LANGUAGE, "Korean Language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("91fc72c6-f79b-4048-9648-1f46af0690cf")), TinkarTerm.ENGLISH_LANGUAGE, "Korean language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ea286819-1568-4d18-884e-ff917a12e165")), TinkarTerm.ENGLISH_LANGUAGE, "Korean language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4887b22d-39cf-4ec5-9348-cd5705f93faf")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1464f995-d658-5e9d-86e0-8308a6fa57eb")
                .statedAxioms(PublicIds.of(UUID.fromString("1bb8ceea-ca23-5069-897a-9d72d0f6b662")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("65642304-7398-4988-8b98-b4f15b696a98")))
                .semanticOn(PublicIds.of(UUID.fromString("e77fc723-add8-498d-9a3d-66c80d94d52c")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cffbc322-fb02-404a-97a2-d742940acf70")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("91fc72c6-f79b-4048-9648-1f46af0690cf")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c6ade260-9bab-4fc8-a02a-6c9d89406f3f")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ea286819-1568-4d18-884e-ff917a12e165")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1456563a-4eff-4bd8-9047-1eb450b91870")), TinkarTerm.PREFERRED)
                ;

        set.concept("Swedish language (SOLOR)", PublicIds.of(UUID.fromString("9784a791-8fdb-32f7-88da-74ab135fe4e3"), UUID.fromString("45022848-9567-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6478ee3e-ba21-435c-a666-b40e4b7d5dba")), TinkarTerm.ENGLISH_LANGUAGE, "Swedish language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9b736f73-798c-4717-a8ba-cdd9079b01bd")), TinkarTerm.ENGLISH_LANGUAGE, "Swedish language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0e358951-551a-4af3-9dbc-de56ac9b1b7d")), TinkarTerm.ENGLISH_LANGUAGE, "Swedish Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("2057bdc8-53ab-4738-a6f3-725ff2a24130")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "9784a791-8fdb-32f7-88da-74ab135fe4e3")
                .statedAxioms(PublicIds.of(UUID.fromString("5612f48e-2da7-5607-933f-8d275b6ca4a3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("807942dc-68be-471f-aa80-f334644a5f9b")))
                .semanticOn(PublicIds.of(UUID.fromString("6478ee3e-ba21-435c-a666-b40e4b7d5dba")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0eda926e-a7ae-45e9-8de8-33929755d9a2")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9b736f73-798c-4717-a8ba-cdd9079b01bd")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("41fc3b85-cb5e-4420-aa04-bc15242be37c")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0e358951-551a-4af3-9dbc-de56ac9b1b7d")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6522c894-2b6d-411d-8c9b-44334957cc70")), TinkarTerm.PREFERRED)
                ;

        set.concept("Russian language (SOLOR)", PublicIds.of(UUID.fromString("0818dbb7-3fe1-59d7-99c2-c8dc42ff2cce"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("454ec000-0316-465a-bb70-48d5eb4a2a99")), TinkarTerm.ENGLISH_LANGUAGE, "Russian language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("562028ac-c327-4d3b-b7f0-1a21064b8e10")), TinkarTerm.ENGLISH_LANGUAGE, "Russian language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4e771211-a2b5-4549-9d9b-dbbc56dc49bf")), TinkarTerm.ENGLISH_LANGUAGE, "Russian language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("d5ca63ec-6d56-4d90-978d-0ac5b8698eb2")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0818dbb7-3fe1-59d7-99c2-c8dc42ff2cce")
                .statedAxioms(PublicIds.of(UUID.fromString("6f078778-0893-53d9-832f-05c8a7bb1381")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("70f6b32b-042d-4de0-9146-a5c92b9ce7d0")))
                .semanticOn(PublicIds.of(UUID.fromString("454ec000-0316-465a-bb70-48d5eb4a2a99")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4436b9bb-85cb-402d-a5c3-2c39c0fd9704")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("562028ac-c327-4d3b-b7f0-1a21064b8e10")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ed95fe2c-ef69-482e-80cf-4db1ed9ac655")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4e771211-a2b5-4549-9d9b-dbbc56dc49bf")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5664dd41-6690-4ddb-82f7-1334cdf0189f")), TinkarTerm.PREFERRED)
                ;

        set.concept("Chinese language (SOLOR)", PublicIds.of(UUID.fromString("aacbc859-e9a0-5e01-b6a9-9a255a47b0c9"), UUID.fromString("ba2efe6b-fe56-3d91-ae0f-3b389628f74c"), UUID.fromString("45022532-9567-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("18978e58-9c05-48d7-a7ad-126135989917")), TinkarTerm.ENGLISH_LANGUAGE, "Chinese language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b142113e-58e6-48d3-a442-cd4188f5266d")), TinkarTerm.ENGLISH_LANGUAGE, "Chinese language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f2c6d51f-e245-433b-99ee-32ee95512e21")), TinkarTerm.ENGLISH_LANGUAGE, "Chinese language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("207d61ca-5d7f-49ad-9b1c-74b3f3036748")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "aacbc859-e9a0-5e01-b6a9-9a255a47b0c9")
                .statedAxioms(PublicIds.of(UUID.fromString("32c2617c-085c-5524-823c-5d5ceb97de4e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("76d4ee25-5607-43ea-b327-9696fc5e63d9")))
                .semanticOn(PublicIds.of(UUID.fromString("18978e58-9c05-48d7-a7ad-126135989917")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("02a494ea-a983-4da8-b578-01bf1a75e89c")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b142113e-58e6-48d3-a442-cd4188f5266d")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("13e2f279-c405-4224-8c74-b3efb8825fba")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f2c6d51f-e245-433b-99ee-32ee95512e21")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1c577c06-e399-4e29-a707-d297eb20363a")), TinkarTerm.PREFERRED)
                ;

        set.concept("Lithuanian language (SOLOR)", PublicIds.of(UUID.fromString("8fa63274-70e3-5b11-9669-1b7bdb372b1a"), UUID.fromString("e9645d95-8a1f-3825-8feb-0bc2ee825694"), UUID.fromString("45022410-9567-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3319936d-385b-4223-8cc8-b597a178ffbf")), TinkarTerm.ENGLISH_LANGUAGE, "Lithuanian language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a54ea45b-de0c-452e-8e5a-17b8d8e2e891")), TinkarTerm.ENGLISH_LANGUAGE, "Lithuanian Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("974f2cde-9f03-486c-903e-0af36d80c730")), TinkarTerm.ENGLISH_LANGUAGE, "Lithuanian Language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("39e946e7-b21d-4fd1-b775-e791b72e3a43")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8fa63274-70e3-5b11-9669-1b7bdb372b1a")
                .statedAxioms(PublicIds.of(UUID.fromString("ddd041d4-dc0a-5164-a0d7-801d9d41c35c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1bed5088-2956-4e63-9836-b67a4b92acfc")))
                .semanticOn(PublicIds.of(UUID.fromString("3319936d-385b-4223-8cc8-b597a178ffbf")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e6792721-0253-469c-8133-2f9303798176")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a54ea45b-de0c-452e-8e5a-17b8d8e2e891")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("04dba224-7842-4aba-b7fb-8655fb1407f5")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("974f2cde-9f03-486c-903e-0af36d80c730")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4e821540-012b-4981-9ef9-f7d02a391173")), TinkarTerm.PREFERRED)
                ;

        set.concept("Spanish language", PublicIds.of(UUID.fromString("0fcf44fb-d0a7-3a67-bc9f-eb3065ed3c8e"), UUID.fromString("45021c36-9567-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7d3ff970-0979-4fec-911a-04d2aa2b8f07")), TinkarTerm.ENGLISH_LANGUAGE, "Spanish language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b66f986d-046f-4c54-bdc9-c7e583d4e032")), TinkarTerm.ENGLISH_LANGUAGE, "Spanish language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("77a9358c-593b-4b86-be10-6c9de7833eb0")), TinkarTerm.ENGLISH_LANGUAGE, "Value for the description language dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8d50bfae-3650-4e5d-98c8-b502ee0de824")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0fcf44fb-d0a7-3a67-bc9f-eb3065ed3c8e")
                .statedAxioms(PublicIds.of(UUID.fromString("760bf182-0a61-574b-8671-3ed56c5d9cb1")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("bd533ba9-0514-4bd6-813e-42ecdd95e1d3")))
                .semanticOn(PublicIds.of(UUID.fromString("7d3ff970-0979-4fec-911a-04d2aa2b8f07")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("001cffa6-5acf-45a5-bf8b-6637121976f1")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b66f986d-046f-4c54-bdc9-c7e583d4e032")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("485cb1af-c794-4bcc-9e65-ce7adc06ca4d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("77a9358c-593b-4b86-be10-6c9de7833eb0")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e1d8171c-884a-4c23-a7d9-2fb4323aec0e")), TinkarTerm.PREFERRED)
                ;

        set.concept("Dutch language (SOLOR)", PublicIds.of(UUID.fromString("21d11bd1-3dab-5034-9625-81b9ae2bd8e7"), UUID.fromString("45022280-9567-11e5-8994-feff819cdc9f"), UUID.fromString("674ad858-0224-3f90-bcf0-bc4cab753d2d"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3b10d397-4441-44d5-8580-31f74f184d8f")), TinkarTerm.ENGLISH_LANGUAGE, "Dutch language (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2d31c484-c6c5-4bb9-bc79-ab4726108cc6")), TinkarTerm.ENGLISH_LANGUAGE, "Dutch language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("31e1a2cd-b330-4857-8caf-b54ae74707ac")), TinkarTerm.ENGLISH_LANGUAGE, "Dutch language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0d2665df-6332-4233-8944-05867a8b4fb5")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "21d11bd1-3dab-5034-9625-81b9ae2bd8e7")
                .statedAxioms(PublicIds.of(UUID.fromString("bb5fb759-0c54-5171-a2ee-7fb02682684e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LANGUAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("19f0e537-f193-4eac-b90b-a82eb4279cd1")))
                .semanticOn(PublicIds.of(UUID.fromString("3b10d397-4441-44d5-8580-31f74f184d8f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0a9bf38c-f953-44ef-8f3d-267583b643b6")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2d31c484-c6c5-4bb9-bc79-ab4726108cc6")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7245469a-aee7-4c29-932d-a525c07ffc49")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("31e1a2cd-b330-4857-8caf-b54ae74707ac")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e6d4c7b1-4f63-4019-9be2-18647bdd8308")), TinkarTerm.PREFERRED)
                ;

    }
}
