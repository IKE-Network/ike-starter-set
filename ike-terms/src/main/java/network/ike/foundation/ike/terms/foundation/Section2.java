package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Language" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section2 {

    private Section2() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Language", PublicIds.of("f56fa231-10f9-5e7f-a86d-a1d61b5b56e3")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("87dc1321-7db7-45cf-9237-145d78436cbb"), IkeTerm.ENGLISH_LANGUAGE, "Language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("17ba4aba-45ea-4715-81ac-d3b268d41175"), IkeTerm.ENGLISH_LANGUAGE, "Language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("82cc12f1-30a2-4557-8c86-b4bc5bbae063"), IkeTerm.ENGLISH_LANGUAGE, "Specifies the language of the description text.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("553e3d40-e19a-4440-ba0b-fce64f3692f8"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f56fa231-10f9-5e7f-a86d-a1d61b5b56e3")
                .statedAxioms(PublicIds.of("8772f036-a392-5231-94e7-9964c2497ccc"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("b40e0744-67bf-422f-979a-5a947ede91df"))
                .semanticOn(PublicIds.of("87dc1321-7db7-45cf-9237-145d78436cbb"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("23a6626d-e8d5-408b-bd3b-a9caa37e3fbb"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("17ba4aba-45ea-4715-81ac-d3b268d41175"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("675b5756-c28c-4e57-956f-76438ccdf651"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("82cc12f1-30a2-4557-8c86-b4bc5bbae063"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c1078819-9547-48fd-a6b3-bcd52a223f3d"), IkeTerm.PREFERRED)
                ;

        set.concept("Irish language (SOLOR)", PublicIds.of("58e82fc4-1492-5cf8-8997-43800360bbd6")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("854cc982-f7b2-4434-88f6-47bdef821652"), IkeTerm.ENGLISH_LANGUAGE, "Irish language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0c8beffb-d982-44bc-8eda-08c8cc543e7e"), IkeTerm.ENGLISH_LANGUAGE, "Irish language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("356fcaed-0d26-4247-9d57-4c2cc36a3b23"), IkeTerm.ENGLISH_LANGUAGE, "The Irish language, as a value for a description's language field: a language coordinate that names it selects Irish-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("70e78c8c-9703-4dfe-bc73-5a1873ae3070"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "58e82fc4-1492-5cf8-8997-43800360bbd6")
                .statedAxioms(PublicIds.of("ff3f0133-e7ad-5b97-a126-d7c7560ce72c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8d938b71-c20f-4034-8850-e86098df1642"))
                .semanticOn(PublicIds.of("854cc982-f7b2-4434-88f6-47bdef821652"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bb11a16d-5b50-451a-a703-58540f926915"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0c8beffb-d982-44bc-8eda-08c8cc543e7e"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6ea63c7b-3f76-47fd-8c6d-b82927618311"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("356fcaed-0d26-4247-9d57-4c2cc36a3b23"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b8cc0066-ed51-45a2-adec-83c904c57778"), IkeTerm.PREFERRED)
                ;

        set.concept("English Language", PublicIds.of("02018e5a-46ba-5297-92f1-6931b9f98a12", "06d905ea-c647-3af9-bfe5-2514e135b558", "45021920-9567-11e5-8994-feff819cdc9f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2d1536b9-69a2-4a53-a324-80d38d38ca17"), IkeTerm.ENGLISH_LANGUAGE, "English Language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6e268da6-5e2c-44af-9564-4e764e9043cd"), IkeTerm.ENGLISH_LANGUAGE, "English language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("11f09c95-a5eb-419b-8de5-8a0d72c46a7e"), IkeTerm.ENGLISH_LANGUAGE, "The English language, as a value for a description's language field: a language coordinate that names it selects English-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("3d271ae6-0fe5-41cc-8f69-15745ff2dd10"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "02018e5a-46ba-5297-92f1-6931b9f98a12")
                .statedAxioms(PublicIds.of("0cecb670-1c27-5b87-b9a5-bcb1ad2d7a8f"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("bdda09d9-0843-48ac-8a97-0985f983f868"))
                .semanticOn(PublicIds.of("2d1536b9-69a2-4a53-a324-80d38d38ca17"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("52c0acea-5d43-4fd4-a00a-77ce8cea9510"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6e268da6-5e2c-44af-9564-4e764e9043cd"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c50843a3-bd55-4806-9a49-a2210c1a6d5a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("11f09c95-a5eb-419b-8de5-8a0d72c46a7e"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("8ee3e94a-d1b0-4da8-9494-4892e3baf754"), IkeTerm.PREFERRED)
                ;

        set.concept("Czech language (SOLOR)", PublicIds.of("33aa2d26-0541-557c-b796-904cbf245101")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("223feabf-f0f2-418a-9051-8600eac5bc7c"), IkeTerm.ENGLISH_LANGUAGE, "Czech language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("91baa056-d6e0-43db-849b-1b9eda41b7e9"), IkeTerm.ENGLISH_LANGUAGE, "Czech language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a92013e4-0fa5-4562-ada2-f683d02b0ebb"), IkeTerm.ENGLISH_LANGUAGE, "The Czech language, as a value for a description's language field: a language coordinate that names it selects Czech-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("f10d5123-384f-4bb8-a39d-86911d4a04f7"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "33aa2d26-0541-557c-b796-904cbf245101")
                .statedAxioms(PublicIds.of("5689b642-1d93-5e95-a403-e6cfda575f42"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("85d4ddb4-b392-4ac1-a949-8d6ccb2350da"))
                .semanticOn(PublicIds.of("223feabf-f0f2-418a-9051-8600eac5bc7c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("949e8f32-a3c0-4bdd-86a9-d06f76cd94f4"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("91baa056-d6e0-43db-849b-1b9eda41b7e9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cb03f1aa-a1a7-42d5-a153-3b7e1dd8a034"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a92013e4-0fa5-4562-ada2-f683d02b0ebb"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ff23ad9b-2834-422a-960c-e667c80a5ed2"), IkeTerm.PREFERRED)
                ;

        set.concept("Danish language (SOLOR)", PublicIds.of("987681fb-f3ef-595d-90e2-067baf2bc71f", "45021f10-9567-11e5-8994-feff819cdc9f", "7e462e33-6d94-38ae-a044-492a857a6853")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("98f6bc71-fea5-4521-888e-b71b9d730e4f"), IkeTerm.ENGLISH_LANGUAGE, "Danish language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ae65203a-be7d-4f7f-8670-deb0f19a6ff8"), IkeTerm.ENGLISH_LANGUAGE, "Danish language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("54e3ffec-09e2-47b7-bcb9-0bbfb39230d6"), IkeTerm.ENGLISH_LANGUAGE, "The Danish language, as a value for a description's language field: a language coordinate that names it selects Danish-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("f80232d9-97da-493e-8170-0a74f9bbc5d5"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "987681fb-f3ef-595d-90e2-067baf2bc71f")
                .statedAxioms(PublicIds.of("14b7a1bd-59fd-5b9e-bfe1-9c1c1e42d674"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("1a4642f9-892c-4144-b017-fed6d5cb5622"))
                .semanticOn(PublicIds.of("98f6bc71-fea5-4521-888e-b71b9d730e4f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("8863201c-ab6c-4156-bea8-a5ee52f3f5e7"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ae65203a-be7d-4f7f-8670-deb0f19a6ff8"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b2f29cf1-0bf5-4036-a0a7-7957b065a37b"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("54e3ffec-09e2-47b7-bcb9-0bbfb39230d6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("dc1b1d06-e746-4379-8250-68caf2c1a288"), IkeTerm.PREFERRED)
                ;

        set.concept("French Language (SOLOR)", PublicIds.of("8b23e636-a0bd-30fb-b8e2-1f77eaa3a87e", "01707e47-5f6d-555e-80af-3c1ffb297eaa", "45021dbc-9567-11e5-8994-feff819cdc9f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c2e69dfe-3227-47cf-b167-2f6dc63e5e89"), IkeTerm.ENGLISH_LANGUAGE, "French Language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ecc44ba8-a765-4644-8864-d3c98e9141f4"), IkeTerm.ENGLISH_LANGUAGE, "French language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("26b8abbf-96f4-485e-9593-175dcc292dfa"), IkeTerm.ENGLISH_LANGUAGE, "The French language, as a value for a description's language field: a language coordinate that names it selects French-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("c5dc6671-1595-4536-b97c-ec12343b986c"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8b23e636-a0bd-30fb-b8e2-1f77eaa3a87e")
                .statedAxioms(PublicIds.of("e4efff56-f81d-5674-8f97-d54623326058"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("9908807b-919c-48c6-b133-e8ee1bf29b8c"))
                .semanticOn(PublicIds.of("c2e69dfe-3227-47cf-b167-2f6dc63e5e89"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fe8d0c89-a19e-419a-a631-ddff7c8b3c2b"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ecc44ba8-a765-4644-8864-d3c98e9141f4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ff3c0739-38a1-4cdc-99ee-6098a0fa3df7"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("26b8abbf-96f4-485e-9593-175dcc292dfa"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bd725401-6ef5-4651-8438-1adc0fbbca50"), IkeTerm.PREFERRED)
                ;

        set.concept("German Language (SOLOR)", PublicIds.of("5f144b18-76a8-5c7e-8480-55a5030d707f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e11d8cf8-a4dd-42d4-b7f1-d1184e546f6d"), IkeTerm.ENGLISH_LANGUAGE, "German Language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bd45dbc8-1ba2-4b74-a9c2-2682692fb16a"), IkeTerm.ENGLISH_LANGUAGE, "German language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("56534ec6-2f32-42ba-81bd-4016bd292720"), IkeTerm.ENGLISH_LANGUAGE, "The German language, as a value for a description's language field: a language coordinate that names it selects German-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("5e9908cb-9ec5-47bf-a25b-c9964737bf34"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "5f144b18-76a8-5c7e-8480-55a5030d707f")
                .statedAxioms(PublicIds.of("d2eb833d-a759-55e5-86f5-5b840e49e8c3"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d88e14f2-5582-49ac-a678-340b61f3f6ee"))
                .semanticOn(PublicIds.of("e11d8cf8-a4dd-42d4-b7f1-d1184e546f6d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("019c17b7-5809-4fe2-8641-c0e4be28371c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("bd45dbc8-1ba2-4b74-a9c2-2682692fb16a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("51b71a29-fc3f-49bf-82f0-1f5353fb5746"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("56534ec6-2f32-42ba-81bd-4016bd292720"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2032e935-d94b-48e9-8f98-49851556e915"), IkeTerm.PREFERRED)
                ;

        set.concept("Polish Language (Language)", PublicIds.of("c924b887-da88-3a72-b8ea-fa86990467c9", "45022140-9567-11e5-8994-feff819cdc9f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("cca81c49-d69c-4b81-988d-4bf4d02a2211"), IkeTerm.ENGLISH_LANGUAGE, "Polish Language (Language)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e6f25b8f-a97b-4710-9a18-ab6b4b078008"), IkeTerm.ENGLISH_LANGUAGE, "Polish language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("cd2aa44c-2ce7-46b0-8d1d-104977c162d5"), IkeTerm.ENGLISH_LANGUAGE, "The Polish language, as a value for a description's language field: a language coordinate that names it selects Polish-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("c4eff24e-2354-490a-a05e-6664952e42ff"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c924b887-da88-3a72-b8ea-fa86990467c9")
                .statedAxioms(PublicIds.of("5db6f856-6d6d-5fcd-8565-9e119bd37591"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("74ab79a2-dbb3-474d-ad60-793cac1cbee3"))
                .semanticOn(PublicIds.of("cca81c49-d69c-4b81-988d-4bf4d02a2211"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5cb44da6-dca3-4f3c-af4c-ccb002d56564"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("e6f25b8f-a97b-4710-9a18-ab6b4b078008"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1da2979e-7c40-463d-9604-8974feb93176"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("cd2aa44c-2ce7-46b0-8d1d-104977c162d5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d7803a33-56b0-4617-8031-9b9777fbf173"), IkeTerm.PREFERRED)
                ;

        set.concept("Italian Language (SOLOR)", PublicIds.of("bdd59458-381a-5818-8577-60525f11ac6c")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e4ed6fc8-7f7a-4175-91bf-c62561b64bf7"), IkeTerm.ENGLISH_LANGUAGE, "Italian Language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fd9b834a-cc73-4205-a9b7-c6ba911ab82b"), IkeTerm.ENGLISH_LANGUAGE, "Italian language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1f820a2a-03f0-44b7-87ad-42b10ead09b0"), IkeTerm.ENGLISH_LANGUAGE, "The Italian language, as a value for a description's language field: a language coordinate that names it selects Italian-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("7a91d701-62dc-4b4b-9664-52634dedb6c6"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "bdd59458-381a-5818-8577-60525f11ac6c")
                .statedAxioms(PublicIds.of("578c2cdd-893a-5490-8a1d-588e6d7e8900"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("f5e519e1-4307-40df-9936-244e04b69deb"))
                .semanticOn(PublicIds.of("e4ed6fc8-7f7a-4175-91bf-c62561b64bf7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b6125291-8f75-4f36-9f55-35557c5fe13a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("fd9b834a-cc73-4205-a9b7-c6ba911ab82b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d4792bea-55fb-455a-9445-9704a8b87449"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("1f820a2a-03f0-44b7-87ad-42b10ead09b0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0eee9fc6-ad02-4571-a368-4ee2f80ee37b"), IkeTerm.PREFERRED)
                ;

        set.concept("Korean Language (SOLOR)", PublicIds.of("1464f995-d658-5e9d-86e0-8308a6fa57eb")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e77fc723-add8-498d-9a3d-66c80d94d52c"), IkeTerm.ENGLISH_LANGUAGE, "Korean Language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("91fc72c6-f79b-4048-9648-1f46af0690cf"), IkeTerm.ENGLISH_LANGUAGE, "Korean language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ea286819-1568-4d18-884e-ff917a12e165"), IkeTerm.ENGLISH_LANGUAGE, "The Korean language, as a value for a description's language field: a language coordinate that names it selects Korean-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("4887b22d-39cf-4ec5-9348-cd5705f93faf"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1464f995-d658-5e9d-86e0-8308a6fa57eb")
                .statedAxioms(PublicIds.of("1bb8ceea-ca23-5069-897a-9d72d0f6b662"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("65642304-7398-4988-8b98-b4f15b696a98"))
                .semanticOn(PublicIds.of("e77fc723-add8-498d-9a3d-66c80d94d52c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cffbc322-fb02-404a-97a2-d742940acf70"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("91fc72c6-f79b-4048-9648-1f46af0690cf"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c6ade260-9bab-4fc8-a02a-6c9d89406f3f"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ea286819-1568-4d18-884e-ff917a12e165"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1456563a-4eff-4bd8-9047-1eb450b91870"), IkeTerm.PREFERRED)
                ;

        set.concept("Swedish language (SOLOR)", PublicIds.of("9784a791-8fdb-32f7-88da-74ab135fe4e3", "45022848-9567-11e5-8994-feff819cdc9f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6478ee3e-ba21-435c-a666-b40e4b7d5dba"), IkeTerm.ENGLISH_LANGUAGE, "Swedish language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9b736f73-798c-4717-a8ba-cdd9079b01bd"), IkeTerm.ENGLISH_LANGUAGE, "Swedish language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0e358951-551a-4af3-9dbc-de56ac9b1b7d"), IkeTerm.ENGLISH_LANGUAGE, "The Swedish language, as a value for a description's language field: a language coordinate that names it selects Swedish-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("2057bdc8-53ab-4738-a6f3-725ff2a24130"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "9784a791-8fdb-32f7-88da-74ab135fe4e3")
                .statedAxioms(PublicIds.of("5612f48e-2da7-5607-933f-8d275b6ca4a3"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("807942dc-68be-471f-aa80-f334644a5f9b"))
                .semanticOn(PublicIds.of("6478ee3e-ba21-435c-a666-b40e4b7d5dba"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0eda926e-a7ae-45e9-8de8-33929755d9a2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9b736f73-798c-4717-a8ba-cdd9079b01bd"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("41fc3b85-cb5e-4420-aa04-bc15242be37c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0e358951-551a-4af3-9dbc-de56ac9b1b7d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6522c894-2b6d-411d-8c9b-44334957cc70"), IkeTerm.PREFERRED)
                ;

        set.concept("Russian language (SOLOR)", PublicIds.of("0818dbb7-3fe1-59d7-99c2-c8dc42ff2cce")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("454ec000-0316-465a-bb70-48d5eb4a2a99"), IkeTerm.ENGLISH_LANGUAGE, "Russian language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("562028ac-c327-4d3b-b7f0-1a21064b8e10"), IkeTerm.ENGLISH_LANGUAGE, "Russian language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4e771211-a2b5-4549-9d9b-dbbc56dc49bf"), IkeTerm.ENGLISH_LANGUAGE, "The Russian language, as a value for a description's language field: a language coordinate that names it selects Russian-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("d5ca63ec-6d56-4d90-978d-0ac5b8698eb2"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0818dbb7-3fe1-59d7-99c2-c8dc42ff2cce")
                .statedAxioms(PublicIds.of("6f078778-0893-53d9-832f-05c8a7bb1381"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("70f6b32b-042d-4de0-9146-a5c92b9ce7d0"))
                .semanticOn(PublicIds.of("454ec000-0316-465a-bb70-48d5eb4a2a99"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4436b9bb-85cb-402d-a5c3-2c39c0fd9704"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("562028ac-c327-4d3b-b7f0-1a21064b8e10"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ed95fe2c-ef69-482e-80cf-4db1ed9ac655"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("4e771211-a2b5-4549-9d9b-dbbc56dc49bf"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5664dd41-6690-4ddb-82f7-1334cdf0189f"), IkeTerm.PREFERRED)
                ;

        set.concept("Chinese language (SOLOR)", PublicIds.of("aacbc859-e9a0-5e01-b6a9-9a255a47b0c9", "ba2efe6b-fe56-3d91-ae0f-3b389628f74c", "45022532-9567-11e5-8994-feff819cdc9f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("18978e58-9c05-48d7-a7ad-126135989917"), IkeTerm.ENGLISH_LANGUAGE, "Chinese language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b142113e-58e6-48d3-a442-cd4188f5266d"), IkeTerm.ENGLISH_LANGUAGE, "Chinese language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f2c6d51f-e245-433b-99ee-32ee95512e21"), IkeTerm.ENGLISH_LANGUAGE, "The Chinese language, as a value for a description's language field: a language coordinate that names it selects Chinese-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("207d61ca-5d7f-49ad-9b1c-74b3f3036748"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "aacbc859-e9a0-5e01-b6a9-9a255a47b0c9")
                .statedAxioms(PublicIds.of("32c2617c-085c-5524-823c-5d5ceb97de4e"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("76d4ee25-5607-43ea-b327-9696fc5e63d9"))
                .semanticOn(PublicIds.of("18978e58-9c05-48d7-a7ad-126135989917"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("02a494ea-a983-4da8-b578-01bf1a75e89c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b142113e-58e6-48d3-a442-cd4188f5266d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("13e2f279-c405-4224-8c74-b3efb8825fba"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f2c6d51f-e245-433b-99ee-32ee95512e21"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1c577c06-e399-4e29-a707-d297eb20363a"), IkeTerm.PREFERRED)
                ;

        set.concept("Lithuanian language (SOLOR)", PublicIds.of("8fa63274-70e3-5b11-9669-1b7bdb372b1a", "e9645d95-8a1f-3825-8feb-0bc2ee825694", "45022410-9567-11e5-8994-feff819cdc9f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3319936d-385b-4223-8cc8-b597a178ffbf"), IkeTerm.ENGLISH_LANGUAGE, "Lithuanian language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a54ea45b-de0c-452e-8e5a-17b8d8e2e891"), IkeTerm.ENGLISH_LANGUAGE, "Lithuanian Language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("974f2cde-9f03-486c-903e-0af36d80c730"), IkeTerm.ENGLISH_LANGUAGE, "The Lithuanian language, as a value for a description's language field: a language coordinate that names it selects Lithuanian-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("39e946e7-b21d-4fd1-b775-e791b72e3a43"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8fa63274-70e3-5b11-9669-1b7bdb372b1a")
                .statedAxioms(PublicIds.of("ddd041d4-dc0a-5164-a0d7-801d9d41c35c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("1bed5088-2956-4e63-9836-b67a4b92acfc"))
                .semanticOn(PublicIds.of("3319936d-385b-4223-8cc8-b597a178ffbf"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e6792721-0253-469c-8133-2f9303798176"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a54ea45b-de0c-452e-8e5a-17b8d8e2e891"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("04dba224-7842-4aba-b7fb-8655fb1407f5"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("974f2cde-9f03-486c-903e-0af36d80c730"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4e821540-012b-4981-9ef9-f7d02a391173"), IkeTerm.PREFERRED)
                ;

        set.concept("Spanish language", PublicIds.of("0fcf44fb-d0a7-3a67-bc9f-eb3065ed3c8e", "45021c36-9567-11e5-8994-feff819cdc9f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7d3ff970-0979-4fec-911a-04d2aa2b8f07"), IkeTerm.ENGLISH_LANGUAGE, "Spanish language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b66f986d-046f-4c54-bdc9-c7e583d4e032"), IkeTerm.ENGLISH_LANGUAGE, "Spanish language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("77a9358c-593b-4b86-be10-6c9de7833eb0"), IkeTerm.ENGLISH_LANGUAGE, "The Spanish language, as a value for a description's language field: a language coordinate that names it selects Spanish-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("8d50bfae-3650-4e5d-98c8-b502ee0de824"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0fcf44fb-d0a7-3a67-bc9f-eb3065ed3c8e")
                .statedAxioms(PublicIds.of("760bf182-0a61-574b-8671-3ed56c5d9cb1"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("bd533ba9-0514-4bd6-813e-42ecdd95e1d3"))
                .semanticOn(PublicIds.of("7d3ff970-0979-4fec-911a-04d2aa2b8f07"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("001cffa6-5acf-45a5-bf8b-6637121976f1"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b66f986d-046f-4c54-bdc9-c7e583d4e032"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("485cb1af-c794-4bcc-9e65-ce7adc06ca4d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("77a9358c-593b-4b86-be10-6c9de7833eb0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e1d8171c-884a-4c23-a7d9-2fb4323aec0e"), IkeTerm.PREFERRED)
                ;

        set.concept("Dutch language (SOLOR)", PublicIds.of("21d11bd1-3dab-5034-9625-81b9ae2bd8e7", "45022280-9567-11e5-8994-feff819cdc9f", "674ad858-0224-3f90-bcf0-bc4cab753d2d")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3b10d397-4441-44d5-8580-31f74f184d8f"), IkeTerm.ENGLISH_LANGUAGE, "Dutch language (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2d31c484-c6c5-4bb9-bc79-ab4726108cc6"), IkeTerm.ENGLISH_LANGUAGE, "Dutch language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("31e1a2cd-b330-4857-8caf-b54ae74707ac"), IkeTerm.ENGLISH_LANGUAGE, "The Dutch language, as a value for a description's language field: a language coordinate that names it selects Dutch-language descriptions for rendering.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("0d2665df-6332-4233-8944-05867a8b4fb5"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "21d11bd1-3dab-5034-9625-81b9ae2bd8e7")
                .statedAxioms(PublicIds.of("bb5fb759-0c54-5171-a2ee-7fb02682684e"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("19f0e537-f193-4eac-b90b-a82eb4279cd1"))
                .semanticOn(PublicIds.of("3b10d397-4441-44d5-8580-31f74f184d8f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0a9bf38c-f953-44ef-8f3d-267583b643b6"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2d31c484-c6c5-4bb9-bc79-ab4726108cc6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7245469a-aee7-4c29-932d-a525c07ffc49"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("31e1a2cd-b330-4857-8caf-b54ae74707ac"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e6d4c7b1-4f63-4019-9be2-18647bdd8308"), IkeTerm.PREFERRED)
                ;

    }
}
