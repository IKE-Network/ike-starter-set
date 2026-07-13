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

/** The "Dialect" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section42 {

    private Section42() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Dialect", PublicIds.of(UUID.fromString("b9c34574-c9ac-503b-aa24-456a0ec949a2"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e27a2e74-522f-43d9-8d3a-abcf85464249")), TinkarTerm.ENGLISH_LANGUAGE, "Dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7734e718-574f-471e-9226-55ac92050fd0")), TinkarTerm.ENGLISH_LANGUAGE, "Dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("18e365e5-d3ca-4683-b9ff-0f3b6b99b834")), TinkarTerm.ENGLISH_LANGUAGE, "Specifies the dialect of the language.", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("5b2fec62-ef4d-4de9-ad89-3638e42cdad9")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b9c34574-c9ac-503b-aa24-456a0ec949a2")
                .statedAxioms(PublicIds.of(UUID.fromString("900bb8b3-cf73-583f-9ba8-67f11eb14b75")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("75896b13-5ecf-4090-8ff9-b6808a6f543e")))
                .semanticOn(PublicIds.of(UUID.fromString("e27a2e74-522f-43d9-8d3a-abcf85464249")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6a9c7687-8767-4ceb-9964-0abccc291a89")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7734e718-574f-471e-9226-55ac92050fd0")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5cc66139-27c1-4ae9-9adb-95786c86d7d3")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("18e365e5-d3ca-4683-b9ff-0f3b6b99b834")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2b06e768-00bb-451f-a456-ac1229e4b0af")), TinkarTerm.PREFERRED)
                ;

        set.concept("French dialect (SOLOR)", PublicIds.of(UUID.fromString("75d00a0d-8e46-5e42-ad34-3e46269b28a3"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0ef42af4-296c-43d1-8a33-99e827465f2e")), TinkarTerm.ENGLISH_LANGUAGE, "French dialect (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("097899b3-0bba-4954-a97e-f3e2bbfd4c5e")), TinkarTerm.ENGLISH_LANGUAGE, "French dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("661c3b42-e715-4f49-b5a7-94513c91042e")), TinkarTerm.ENGLISH_LANGUAGE, "French dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c3b9ff5e-4fc6-4417-91e1-6d3f161c58d0")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "75d00a0d-8e46-5e42-ad34-3e46269b28a3")
                .statedAxioms(PublicIds.of(UUID.fromString("3c5aecfd-0edc-514c-a2c3-6525994cdb8f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.DIALECT_ASSEMBLAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("639946d6-e2db-4e4d-8efb-9026d926c98b")))
                .semanticOn(PublicIds.of(UUID.fromString("0ef42af4-296c-43d1-8a33-99e827465f2e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2aba6d59-e838-4741-945c-06015805ed54")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("097899b3-0bba-4954-a97e-f3e2bbfd4c5e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("17de341a-17f2-422f-9abb-eaf6efc00186")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("661c3b42-e715-4f49-b5a7-94513c91042e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6c6f5341-7e7a-407b-b9f9-08a7207f0344")), TinkarTerm.PREFERRED)
                ;

        set.concept("Czech dialect (SOLOR)", PublicIds.of(UUID.fromString("6979e268-0b59-542f-bac0-313c5ddf6a2e"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("defff0c5-6abb-4491-b815-294bbd8400cd")), TinkarTerm.ENGLISH_LANGUAGE, "Czech dialect (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6c499a82-5fc8-4e2d-98f3-acb924480383")), TinkarTerm.ENGLISH_LANGUAGE, "Czech dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bd600561-1f19-4967-ad78-fbb7100d2d85")), TinkarTerm.ENGLISH_LANGUAGE, "Czech dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4818f20b-6f98-4fa0-b8be-8249d81ecfcb")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6979e268-0b59-542f-bac0-313c5ddf6a2e")
                .statedAxioms(PublicIds.of(UUID.fromString("53028e91-3925-5a28-94d8-063b14ae85e1")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.DIALECT_ASSEMBLAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("843ecf74-66be-4cf8-a324-ed80a353089f")))
                .semanticOn(PublicIds.of(UUID.fromString("defff0c5-6abb-4491-b815-294bbd8400cd")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1326dc7c-63a6-4c29-af03-8358de6b1347")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6c499a82-5fc8-4e2d-98f3-acb924480383")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8d6afe15-59b1-40a8-9d05-24c4b223f9b1")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bd600561-1f19-4967-ad78-fbb7100d2d85")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fff84543-dbf7-43d2-8f2a-6ca64b6b9cee")), TinkarTerm.PREFERRED)
                ;

        set.concept("English Dialect", PublicIds.of(UUID.fromString("c0836284-f631-3c86-8cfc-56a67814efab"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("df2f7a39-4c43-44a0-9c6a-389e8cbcc5b4")), TinkarTerm.ENGLISH_LANGUAGE, "English Dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6002b5d3-acde-410a-ace6-77483eb42675")), TinkarTerm.ENGLISH_LANGUAGE, "English dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("06685d78-f37a-4477-9a8f-40de71d1105e")), TinkarTerm.ENGLISH_LANGUAGE, "Specifies the dialect of the English language", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8c07b937-1d1b-4eef-89d4-7203f257faa3")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c0836284-f631-3c86-8cfc-56a67814efab")
                .statedAxioms(PublicIds.of(UUID.fromString("ed8394bc-403b-5a4b-844d-abd17132a609")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.DIALECT_ASSEMBLAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("28a30da3-4fa0-45ac-8065-8ecb35bec422")))
                .semanticOn(PublicIds.of(UUID.fromString("df2f7a39-4c43-44a0-9c6a-389e8cbcc5b4")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ce66a7cb-e108-4648-a0c2-275d62a94013")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6002b5d3-acde-410a-ace6-77483eb42675")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("918de053-4c95-431b-b221-edf254a0c478")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("06685d78-f37a-4477-9a8f-40de71d1105e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("86d4a1ec-c9a7-43fc-9f4b-3ee9d757e185")), TinkarTerm.PREFERRED)
                ;

        set.concept("United States of America English dialect (SOLOR)", PublicIds.of(UUID.fromString("bca0a686-3516-3daf-8fcf-fe396d13cfad"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3323461b-bd47-4983-9834-4a0107cc6b32")), TinkarTerm.ENGLISH_LANGUAGE, "United States of America English dialect (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("48d28963-18cc-4320-8acb-56cdaabba533")), TinkarTerm.ENGLISH_LANGUAGE, "US English dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1f506d54-4ef6-4a9d-b17a-6b71eb23df2b")), TinkarTerm.ENGLISH_LANGUAGE, "USA -english dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("95418370-de98-41c8-8080-6b7286bcecb7")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "bca0a686-3516-3daf-8fcf-fe396d13cfad")
                .statedAxioms(PublicIds.of(UUID.fromString("2a5ec588-b8d5-5330-9655-57d94e458c27")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ENGLISH_DIALECT_ASSEMBLAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("86a16ea5-9b9f-46d5-aef5-86cc77e6dc0e")))
                .semanticOn(PublicIds.of(UUID.fromString("3323461b-bd47-4983-9834-4a0107cc6b32")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f47e905b-a958-4534-bdca-e8515bf37f19")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("48d28963-18cc-4320-8acb-56cdaabba533")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fd4a3ad7-de90-462a-86b7-04f7dcdd452d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1f506d54-4ef6-4a9d-b17a-6b71eb23df2b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e1d62499-f457-4613-9324-b2a72f536eb8")), TinkarTerm.PREFERRED)
                ;

        set.concept("US Nursing dialect (SOLOR)", PublicIds.of(UUID.fromString("6e447636-1085-32ff-bc36-6748a45255de"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("43980dc9-6f04-4db5-8dd4-bdd444fffb99")), TinkarTerm.ENGLISH_LANGUAGE, "US Nursing dialect (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bba397e6-f779-4338-9add-c7e4f9da0b3d")), TinkarTerm.ENGLISH_LANGUAGE, "United States English Nursing Dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3c6bd686-bb75-46bb-8b0c-bdf9440b666a")), TinkarTerm.ENGLISH_LANGUAGE, "Nursing Dialect -US English", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("95cc8eef-7df2-4dd1-b899-8893e4c95cd7")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6e447636-1085-32ff-bc36-6748a45255de")
                .statedAxioms(PublicIds.of(UUID.fromString("0508b395-55ef-57b4-aa90-26d65b89052c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.US_ENGLISH_DIALECT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f4dca074-06f9-4fde-932f-2079cad52e41")))
                .semanticOn(PublicIds.of(UUID.fromString("43980dc9-6f04-4db5-8dd4-bdd444fffb99")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("dcb83da1-cd10-4004-8e3d-7c535264edaa")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bba397e6-f779-4338-9add-c7e4f9da0b3d")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ba7f1f0c-9863-41ff-a9c2-d296144986d4")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3c6bd686-bb75-46bb-8b0c-bdf9440b666a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("27340f96-c17d-4fc6-8186-1ff37206b5a4")), TinkarTerm.PREFERRED)
                ;

        set.concept("Great Britain English dialect", PublicIds.of(UUID.fromString("eb9a5e42-3cba-356d-b623-3ed472e20b30"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("50be4a11-9078-498e-9669-e3eac31ae2a9")), TinkarTerm.ENGLISH_LANGUAGE, "Great Britain English dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c5140135-7131-4b83-9c20-63fb31ff4978")), TinkarTerm.ENGLISH_LANGUAGE, "GB English dialect / GB English", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7bf3f100-f1ba-4496-8088-65398f3ca40d")), TinkarTerm.ENGLISH_LANGUAGE, "Great Britain: English Language reference set", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("7efb76b9-ae18-4bf8-a0ad-143940d19029")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "eb9a5e42-3cba-356d-b623-3ed472e20b30")
                .statedAxioms(PublicIds.of(UUID.fromString("9d20953a-fcd8-590e-94dc-305378a1b0d9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ENGLISH_DIALECT_ASSEMBLAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("af558753-2fc6-4876-8a19-efe3889ba127")))
                .semanticOn(PublicIds.of(UUID.fromString("50be4a11-9078-498e-9669-e3eac31ae2a9")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9bba436d-78ad-4dc3-b83c-25eb4c2d6658")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c5140135-7131-4b83-9c20-63fb31ff4978")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0ebf0e4b-e285-470b-821b-1a3f2c2eefef")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7bf3f100-f1ba-4496-8088-65398f3ca40d")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("af97ab4e-30d4-419f-a951-1863f0200d95")), TinkarTerm.PREFERRED)
                ;

        set.concept("Korean dialect (SOLOR)", PublicIds.of(UUID.fromString("6fb2eb9c-fb9e-5959-802c-fb17bcba3079"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6f1fa174-e86a-42f4-b429-850480768b4e")), TinkarTerm.ENGLISH_LANGUAGE, "Korean dialect (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("638c8c89-633c-451c-8c88-0886789d4198")), TinkarTerm.ENGLISH_LANGUAGE, "Korean dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bfed8bdf-10b5-425b-8a49-49220ea375a3")), TinkarTerm.ENGLISH_LANGUAGE, "Korean dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("09d589bb-185f-414b-8cc9-bdda1167055f")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6fb2eb9c-fb9e-5959-802c-fb17bcba3079")
                .statedAxioms(PublicIds.of(UUID.fromString("a5ff5596-3502-53a5-adbd-adebe8b1aba3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.DIALECT_ASSEMBLAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6bc07c75-8b7f-44d7-8e53-8b21dd8d1aeb")))
                .semanticOn(PublicIds.of(UUID.fromString("6f1fa174-e86a-42f4-b429-850480768b4e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("82cd0929-22e9-4717-87eb-df7754c9f871")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("638c8c89-633c-451c-8c88-0886789d4198")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3d2084e4-5bf7-4e11-8c4f-e9ca2e2aeb9d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bfed8bdf-10b5-425b-8a49-49220ea375a3")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b5695a06-352f-421a-9f9b-4d875742dc2b")), TinkarTerm.PREFERRED)
                ;

        set.concept("Standard Korean dialect (SOLOR)", PublicIds.of(UUID.fromString("f90722cc-5e40-5b9b-a2a6-f4dfa312a6a9"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0bb85f7d-90b1-464b-8d91-6d10fbf10c8c")), TinkarTerm.ENGLISH_LANGUAGE, "Standard Korean dialect (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("06203e8a-7c94-4821-bf4c-84dc04c35e32")), TinkarTerm.ENGLISH_LANGUAGE, "Standard Korean Dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5db6074f-7d2c-46a3-b624-ced9f610877c")), TinkarTerm.ENGLISH_LANGUAGE, "Standard", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("861fd290-ad46-4766-b310-aeda2b2b33c7")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f90722cc-5e40-5b9b-a2a6-f4dfa312a6a9")
                .statedAxioms(PublicIds.of(UUID.fromString("45455d08-c8f8-5357-ba90-3133441c3fc8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.KOREAN_DIALECT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0d00a0a6-2c11-49b3-8e82-fa244e86e210")))
                .semanticOn(PublicIds.of(UUID.fromString("0bb85f7d-90b1-464b-8d91-6d10fbf10c8c")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0f18fb41-ab04-43c6-ac2c-330797b3bf99")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("06203e8a-7c94-4821-bf4c-84dc04c35e32")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0cf21802-d4bd-43ea-bb2a-c01f6e378a46")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5db6074f-7d2c-46a3-b624-ced9f610877c")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c4abcb1f-1ab2-41fd-be32-26d2da6719ee")), TinkarTerm.PREFERRED)
                ;

        set.concept("Irish dialect (SOLOR)", PublicIds.of(UUID.fromString("c0f77638-6274-5b40-b832-ac1cba7ec515"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("49129cff-1f61-4e4e-bae9-f83bb326c86f")), TinkarTerm.ENGLISH_LANGUAGE, "Irish dialect (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("660673ea-b14e-449e-ada5-93eb01bea3ec")), TinkarTerm.ENGLISH_LANGUAGE, "Irish dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("aec9a33b-933b-4d2c-bf84-3dc42eb756ae")), TinkarTerm.ENGLISH_LANGUAGE, "Irish dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("83c68499-4304-416f-a734-4c1d28648698")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c0f77638-6274-5b40-b832-ac1cba7ec515")
                .statedAxioms(PublicIds.of(UUID.fromString("e5179b1e-7d31-52ce-beda-365c78596030")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.DIALECT_ASSEMBLAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("fe38ae26-51bd-4d3f-90b7-bc5f28ffb771")))
                .semanticOn(PublicIds.of(UUID.fromString("49129cff-1f61-4e4e-bae9-f83bb326c86f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4e7bb390-8940-4cd6-97cf-7109bd80f3db")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("660673ea-b14e-449e-ada5-93eb01bea3ec")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0a5fb1a8-d2fa-486c-9e38-65c0b1165dd7")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("aec9a33b-933b-4d2c-bf84-3dc42eb756ae")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ae5e3ff6-2430-42e5-9374-e1d195ae58bd")), TinkarTerm.PREFERRED)
                ;

        set.concept("Russian dialect (SOLOR)", PublicIds.of(UUID.fromString("300126d1-2604-579f-a59b-e3c1179a173a"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3523d548-adf2-430c-9f66-ab7b8438db25")), TinkarTerm.ENGLISH_LANGUAGE, "Russian dialect (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("75c7d00b-b0bb-42dc-ad31-3d81dbf84392")), TinkarTerm.ENGLISH_LANGUAGE, "Russian dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f51277d0-9090-410a-9d73-933ad0eb94ad")), TinkarTerm.ENGLISH_LANGUAGE, "Russian Dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("1cdbaa45-9946-476e-a2e6-9c1c5034a8a5")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "300126d1-2604-579f-a59b-e3c1179a173a")
                .statedAxioms(PublicIds.of(UUID.fromString("c3f1f39b-5b3b-5fb8-809f-4dffd6182f33")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.DIALECT_ASSEMBLAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("817dadcb-8db3-4d3c-accf-65346432576b")))
                .semanticOn(PublicIds.of(UUID.fromString("3523d548-adf2-430c-9f66-ab7b8438db25")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7d5f32db-0ee7-4e83-8d16-2e182206f287")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("75c7d00b-b0bb-42dc-ad31-3d81dbf84392")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7750314c-a7ec-4bdf-8c1f-1d037835ca5d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f51277d0-9090-410a-9d73-933ad0eb94ad")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("587120e5-6c65-4ef5-a2be-771d37f9154a")), TinkarTerm.PREFERRED)
                ;

        set.concept("Polish dialect (SOLOR)", PublicIds.of(UUID.fromString("315cd879-1557-5a30-b325-a5d3df9e1c2b"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bb67b96d-cc78-488d-9625-6837f9b866b5")), TinkarTerm.ENGLISH_LANGUAGE, "Polish dialect (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("48129a86-df33-41eb-8ad1-f43e506792a1")), TinkarTerm.ENGLISH_LANGUAGE, "Polish dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("48fca292-79ea-4728-9bb1-02f3b01e4045")), TinkarTerm.ENGLISH_LANGUAGE, "Polish Dialect", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("65e78fd7-7253-4d88-909d-4bcb99fe7a4a")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "315cd879-1557-5a30-b325-a5d3df9e1c2b")
                .statedAxioms(PublicIds.of(UUID.fromString("de56c510-e859-561c-bca2-37e20333325d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.DIALECT_ASSEMBLAGE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8a48873f-83d5-4a4a-a342-139e0c1f2171")))
                .semanticOn(PublicIds.of(UUID.fromString("bb67b96d-cc78-488d-9625-6837f9b866b5")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("30d98993-8152-4316-8447-cd07d536f698")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("48129a86-df33-41eb-8ad1-f43e506792a1")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ae90aebe-24df-4066-a687-f677a0a26188")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("48fca292-79ea-4728-9bb1-02f3b01e4045")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("75191ff4-d907-4d07-b162-5ae445f98447")), TinkarTerm.PREFERRED)
                ;

    }
}
