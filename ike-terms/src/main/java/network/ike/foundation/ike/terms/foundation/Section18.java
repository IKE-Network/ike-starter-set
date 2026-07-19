package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Description type" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section18 {

    private Section18() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description type", PublicIds.of(UUID.fromString("ad0c19e8-2ccc-59c1-8b7e-c56c03aca8eb"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0f94e2ba-1c89-441e-9c83-972ce9b15d78")), IkeTerm.ENGLISH_LANGUAGE, "Description type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cb52d2a8-7bd2-4837-9ec3-2c8a4be26ab4")), IkeTerm.ENGLISH_LANGUAGE, "Description type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("401bb162-863a-474c-a354-b50a9ec2f57a")), IkeTerm.ENGLISH_LANGUAGE, "Specifying what type of description it is i.e. is it fully qualified or regular and etc.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("39071791-2abe-49d5-8fb1-94c0b9aa01e3")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ad0c19e8-2ccc-59c1-8b7e-c56c03aca8eb")
                .statedAxioms(PublicIds.of(UUID.fromString("6e6e293f-e8ac-58fb-88df-8fa6ad3ff3fe")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b51e1b3d-7d30-4678-8f36-3cdb4785daca")))
                .semanticOn(PublicIds.of(UUID.fromString("0f94e2ba-1c89-441e-9c83-972ce9b15d78")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("783f80cf-a3ee-416f-848e-98b9de56d06a")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cb52d2a8-7bd2-4837-9ec3-2c8a4be26ab4")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3de82ffa-4e32-481e-a00f-aaed54700b58")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("401bb162-863a-474c-a354-b50a9ec2f57a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("35a9a8ad-3037-4406-81ac-bac95287d440")), IkeTerm.PREFERRED)
                ;

        set.concept("Property set (SOLOR)", PublicIds.of(UUID.fromString("e273b5c0-c012-5e53-990c-aec5c2cb33a7"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6088a1a1-fb19-4b28-a82f-5d48a96254ec")), IkeTerm.ENGLISH_LANGUAGE, "Property set (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("55cc404c-d974-45ff-be0c-3ed71b434686")), IkeTerm.ENGLISH_LANGUAGE, "Property set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("38607879-0191-4c78-881a-1fc9e379ac3d")), IkeTerm.ENGLISH_LANGUAGE, "Property set (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("d475b206-9bc1-4875-b5d8-4060cf9d790d")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "e273b5c0-c012-5e53-990c-aec5c2cb33a7")
                .statedAxioms(PublicIds.of(UUID.fromString("22bbf247-37b9-5d7a-b6d8-74420e9e83a2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("eef28981-1d2e-4470-acac-45254aca1eef")))
                .semanticOn(PublicIds.of(UUID.fromString("6088a1a1-fb19-4b28-a82f-5d48a96254ec")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5edc48af-7a28-48f8-9b5e-10d1930bba41")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("55cc404c-d974-45ff-be0c-3ed71b434686")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("904de026-0060-419a-a261-f4ae33be0cba")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("38607879-0191-4c78-881a-1fc9e379ac3d")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f28c1634-c4d0-4b30-8360-26adee33519f")), IkeTerm.PREFERRED)
                ;

        set.concept("Extended relationship type (SOLOR)", PublicIds.of(UUID.fromString("d41d928f-8a97-55c1-aa6c-a289b413fbfd"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a0ba32ea-5c12-46de-9d68-d8baa6993c6b")), IkeTerm.ENGLISH_LANGUAGE, "Extended relationship type (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("825d77c1-b32c-46c1-9026-7567237f8633")), IkeTerm.ENGLISH_LANGUAGE, "Extended relationship type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1ef7a7f3-51a1-4fbb-8570-19626c9fa5fb")), IkeTerm.ENGLISH_LANGUAGE, "Used to store non-snomed relationship types when other terminologies are imported- especially when a relationship is mapped onto a snomed relationship type (such as isa)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("2444b671-ad74-486d-8d18-8f1eacc54abd")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "d41d928f-8a97-55c1-aa6c-a289b413fbfd")
                .statedAxioms(PublicIds.of(UUID.fromString("bdd3d8be-bff0-57ca-8525-ca3222b82867")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ac598797-8d16-4451-8524-c0d83e99cc04")))
                .semanticOn(PublicIds.of(UUID.fromString("a0ba32ea-5c12-46de-9d68-d8baa6993c6b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7bd68fc9-63cd-435d-80e0-afe400abfb3d")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("825d77c1-b32c-46c1-9026-7567237f8633")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bc003ed6-3873-49f5-8ddb-952fbbd9a589")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1ef7a7f3-51a1-4fbb-8570-19626c9fa5fb")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f947c418-ac28-439f-a653-88bc0722ee59")), IkeTerm.PREFERRED)
                ;

        set.concept("Description core type (SOLOR)", PublicIds.of(UUID.fromString("351955ff-30f4-5806-a0a5-5dda79756377"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("001782c3-ce14-44d0-8855-35ec9441d295")), IkeTerm.ENGLISH_LANGUAGE, "Description core type (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d1361450-6f1d-4f8e-b824-c9f08017be1f")), IkeTerm.ENGLISH_LANGUAGE, "Description core type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6f2c2e25-ad98-48e4-ac76-13153896ba08")), IkeTerm.ENGLISH_LANGUAGE, "Used to mark non-snomed descriptions as one of the core snomed types", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e3097d41-f74c-4588-ab27-1f33ee735dfa")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "351955ff-30f4-5806-a0a5-5dda79756377")
                .statedAxioms(PublicIds.of(UUID.fromString("4af6191c-6440-524f-aa99-17fb0270530b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("fd91837b-f834-4371-b73b-9be78a3bd665")))
                .semanticOn(PublicIds.of(UUID.fromString("001782c3-ce14-44d0-8855-35ec9441d295")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("784c4ceb-6d06-442b-90c8-d496e6e04f99")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d1361450-6f1d-4f8e-b824-c9f08017be1f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a4fc850a-2058-45d2-a3a5-343a05412227")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6f2c2e25-ad98-48e4-ac76-13153896ba08")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3e8f0fda-841b-49d0-86b7-f35966312a16")), IkeTerm.PREFERRED)
                ;

        set.concept("Unmodeled role concept (SOLOR)", PublicIds.of(UUID.fromString("4be7118f-e6ab-5dc7-bcba-b2cc8b028492"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7cb7fbc9-a45a-49e1-8aa4-37425386efc2")), IkeTerm.ENGLISH_LANGUAGE, "Unmodeled role concept (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7f1e6e04-5c66-41bc-8f8a-9b88d7283be9")), IkeTerm.ENGLISH_LANGUAGE, "Unmodeled role concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bccfbab3-45d5-44a1-9947-e78e61758a8f")), IkeTerm.ENGLISH_LANGUAGE, "Unmodeled role concept (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("116fd70d-3055-40a2-8db0-b6f907e33071")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "4be7118f-e6ab-5dc7-bcba-b2cc8b028492")
                .statedAxioms(PublicIds.of(UUID.fromString("a2a434ee-60c8-593a-8e91-5a42df4d3044")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("74757cba-b88f-42fe-a985-aa85da90681b")))
                .semanticOn(PublicIds.of(UUID.fromString("7cb7fbc9-a45a-49e1-8aa4-37425386efc2")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c1af3d52-d4b3-4cb3-a2fb-9f0dbca73a6d")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7f1e6e04-5c66-41bc-8f8a-9b88d7283be9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("50a1951f-35f2-424f-9a24-4b856f088247")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bccfbab3-45d5-44a1-9947-e78e61758a8f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6d19df1e-9f27-49ac-8a0f-299bbce2d736")), IkeTerm.PREFERRED)
                ;

        // Declared FQN and definition diverge from the baseline artifact (was "Concept assemblage for logic coordinate (SOLOR)"):
        // "assemblage" retired from this set's own terminology, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Concept pattern for logic coordinate", PublicIds.of(UUID.fromString("16486419-5d1c-574f-bde6-21910ad66f44"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a4575d99-48d9-4d4e-a8d3-e658d426ef49")), IkeTerm.ENGLISH_LANGUAGE, "Concept pattern for logic coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c6a2ef78-a7b5-4e6a-8822-a6f4cbcb0a77")), IkeTerm.ENGLISH_LANGUAGE, "Concepts to classify", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3edd7840-34a7-4175-885f-cbe9edfa4e9c")), IkeTerm.ENGLISH_LANGUAGE, "The pattern whose active semantics enumerate the SOLOR concepts a Logic Coordinate reasons over.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("566142d4-4e10-4dde-8871-dcd818d49e00")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "16486419-5d1c-574f-bde6-21910ad66f44")
                .statedAxioms(PublicIds.of(UUID.fromString("e022cd8c-be2a-5aa3-95c4-6022417547cd")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c43d2bd5-e5fa-45bd-a12e-2687e21b2e08")))
                .semanticOn(PublicIds.of(UUID.fromString("a4575d99-48d9-4d4e-a8d3-e658d426ef49")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8db4b1c9-88aa-4d82-80c4-ef5e76907682")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c6a2ef78-a7b5-4e6a-8822-a6f4cbcb0a77")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("74b464ed-0ce9-4016-a40d-9fe022cda482")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3edd7840-34a7-4175-885f-cbe9edfa4e9c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("56503fd1-0930-4e56-9d20-86f2bd0a04d5")), IkeTerm.PREFERRED)
                ;

        set.concept("Fully qualified name description type", PublicIds.of(UUID.fromString("00791270-77c9-32b6-b34f-d932569bd2bf"), UUID.fromString("5e1fe940-8faf-11db-b606-0800200c9a66"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("85564807-40b5-4648-8c8a-941b58a1e34b")), IkeTerm.ENGLISH_LANGUAGE, "Fully qualified name description type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d2f34451-80ce-4fd1-ae83-73ec1529c7c3")), IkeTerm.ENGLISH_LANGUAGE, "Fully qualified name", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a36787a0-f843-4514-bc63-75cf0e875046")), IkeTerm.ENGLISH_LANGUAGE, "Fully qualified name is a description that uniquely identifies and differentiates it from other concepts with similar descriptions", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("b868c1b5-c14f-4017-b297-25295d98bf1a")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "00791270-77c9-32b6-b34f-d932569bd2bf")
                .statedAxioms(PublicIds.of(UUID.fromString("b4b58afd-13d8-557b-9a5f-d31010cf1c51")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("2773b053-9e26-4a16-83eb-8d17151d666e")))
                .semanticOn(PublicIds.of(UUID.fromString("85564807-40b5-4648-8c8a-941b58a1e34b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d18d71ff-ab28-4c5d-98dc-4480eec6cd05")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d2f34451-80ce-4fd1-ae83-73ec1529c7c3")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("438ba199-df00-486a-9500-f2f5b255622b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a36787a0-f843-4514-bc63-75cf0e875046")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a20ef2a1-b8eb-47d1-aae0-d83c5fb8491b")), IkeTerm.PREFERRED)
                ;

        set.concept("Stated navigation (SOLOR)", PublicIds.of(UUID.fromString("614017af-9903-53d9-aab4-15fd02193dce"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("37595f1b-58eb-4f42-89d8-8863381138b5")), IkeTerm.ENGLISH_LANGUAGE, "Stated navigation (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6dcb7b8f-fd0e-4539-bad2-9ac0ce6b6e76")), IkeTerm.ENGLISH_LANGUAGE, "Stated navigation", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a8412b28-1371-404c-ae74-ff7471c0b6c9")), IkeTerm.ENGLISH_LANGUAGE, "Stated navigation (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f6781e5c-0818-4e5d-a3c3-cedebf989120")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "16486419-5d1c-574f-bde6-21910ad66f44")
                .statedAxioms(PublicIds.of(UUID.fromString("27ae49a7-31e0-5e2a-a2c8-fe04ec9a0011")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0fb9da13-c07e-4716-836a-b295cd4b2b0a")))
                .semanticOn(PublicIds.of(UUID.fromString("37595f1b-58eb-4f42-89d8-8863381138b5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a930748a-3cbb-4349-9c41-45716ed0551f")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6dcb7b8f-fd0e-4539-bad2-9ac0ce6b6e76")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a7cddedc-5061-45d9-b28a-5fe782445ed6")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a8412b28-1371-404c-ae74-ff7471c0b6c9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ad3bce59-81ff-4d37-95f2-a3d977a53552")), IkeTerm.PREFERRED)
                ;

        set.concept("Inferred navigation (SOLOR)", PublicIds.of(UUID.fromString("4bc6c333-7fc9-52f1-942d-f8decba19dc2"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("275d4108-3a8e-4151-960b-8cc47278a36c")), IkeTerm.ENGLISH_LANGUAGE, "Inferred navigation (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5f03b523-ef8e-4109-ac3e-6e42c3b83452")), IkeTerm.ENGLISH_LANGUAGE, "Inferred navigation", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8a402853-7da4-4a15-8800-7a3cb53f32a6")), IkeTerm.ENGLISH_LANGUAGE, "Inferred navigation (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e6b89b41-3921-43b5-ad47-b5f2c6f2c86d")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "16486419-5d1c-574f-bde6-21910ad66f44")
                .statedAxioms(PublicIds.of(UUID.fromString("9220c441-d480-557a-a73a-ef3c6604e699")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7b51452b-57f4-4db9-973f-bbf9cbddbdc3")))
                .semanticOn(PublicIds.of(UUID.fromString("275d4108-3a8e-4151-960b-8cc47278a36c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4ab812e3-dc3d-4fbd-82dd-d51cb4d2d396")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5f03b523-ef8e-4109-ac3e-6e42c3b83452")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9b25a4ea-1a33-4617-9c12-d4f79fdacdce")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("8a402853-7da4-4a15-8800-7a3cb53f32a6")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fcc37aa9-0733-4407-b297-a64d2222171a")), IkeTerm.PREFERRED)
                ;

        set.concept("Dynamic referenced component restriction (SOLOR)", PublicIds.of(UUID.fromString("0d94ceeb-e24f-5f1a-84b2-1ac35f671db5"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fa10b6c4-0f21-4b4f-9bb2-0f6f94e763db")), IkeTerm.ENGLISH_LANGUAGE, "Dynamic referenced component restriction (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("aebfebd2-8295-4cec-9b37-528c38488be7")), IkeTerm.ENGLISH_LANGUAGE, "Dynamic referenced component restriction", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("72808e6b-8296-478d-8512-93a325d7b83a")), IkeTerm.ENGLISH_LANGUAGE, "Dynamic referenced component restriction (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("9831c69b-b5c3-4698-9c2c-64bb4edbacaf")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0d94ceeb-e24f-5f1a-84b2-1ac35f671db5")
                .statedAxioms(PublicIds.of(UUID.fromString("33460f02-0af4-5374-960a-727cbed38e68")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8687fc79-af1d-4ce4-96d3-020d5e2c841e")))
                .semanticOn(PublicIds.of(UUID.fromString("fa10b6c4-0f21-4b4f-9bb2-0f6f94e763db")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("05991e0a-6739-4644-b7c6-96e176a81b4d")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("aebfebd2-8295-4cec-9b37-528c38488be7")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("78eef9f1-3f3e-47f8-8147-68e395180492")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("72808e6b-8296-478d-8512-93a325d7b83a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("98e078c5-5c20-41ff-badc-612d532f3d9f")), IkeTerm.PREFERRED)
                ;

        set.concept("Intrinsic role (SOLOR)", PublicIds.of(UUID.fromString("a2d37d2d-ac49-589f-ba36-ac9b8808b00b"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("225584c7-de10-429b-83cc-7d96a12392e5")), IkeTerm.ENGLISH_LANGUAGE, "Intrinsic role (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4933e83f-1e94-4781-9c24-5df791f36bae")), IkeTerm.ENGLISH_LANGUAGE, "Intrinsic role", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cc781b8e-46ad-4291-8528-f2c46c9fc2ac")), IkeTerm.ENGLISH_LANGUAGE, "Intrinsic role (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("346a97d2-0c14-45a1-902c-8af3dff3c063")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a2d37d2d-ac49-589f-ba36-ac9b8808b00b")
                .statedAxioms(PublicIds.of(UUID.fromString("fd26d582-6391-52a6-8bbc-8e2ca986aefc")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b3dc337b-abbd-4e2c-97cc-ee19304f6ddb")))
                .semanticOn(PublicIds.of(UUID.fromString("225584c7-de10-429b-83cc-7d96a12392e5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3022b119-eac2-4227-a233-0017269de4d3")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4933e83f-1e94-4781-9c24-5df791f36bae")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("454dc376-4668-44e0-832a-9f9a9d129917")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cc781b8e-46ad-4291-8528-f2c46c9fc2ac")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8961a14c-f745-49bc-9c32-9d583bcd1525")), IkeTerm.PREFERRED)
                ;

        set.concept("Inverse name (SOLOR)", PublicIds.of(UUID.fromString("c342d18a-ec1c-5583-bfe3-59e6324ae189"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5572b519-7edb-4cd5-be79-cbedf2a5b404")), IkeTerm.ENGLISH_LANGUAGE, "Inverse name (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cb22ead8-f8ab-44e1-ac74-11398e07e166")), IkeTerm.ENGLISH_LANGUAGE, "Inverse name", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("41cbcf80-d256-4fe9-99fe-5d603ae9365c")), IkeTerm.ENGLISH_LANGUAGE, "This is the extended description type that maye be attached to a description within a concept that defines as Association refex to signify that the referenced description  is the inverse of the association name", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("5c1699dd-dc54-4998-a624-05eec4b1da01")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c342d18a-ec1c-5583-bfe3-59e6324ae189")
                .statedAxioms(PublicIds.of(UUID.fromString("4578dab7-e5d8-5846-a532-e066a3108e12")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f67d46d1-cca7-4538-87c8-d06d93dca015")))
                .semanticOn(PublicIds.of(UUID.fromString("5572b519-7edb-4cd5-be79-cbedf2a5b404")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9e310728-a666-4101-b5fc-091c2fb23c77")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cb22ead8-f8ab-44e1-ac74-11398e07e166")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5e04ed22-c268-4851-8494-5376565799a6")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("41cbcf80-d256-4fe9-99fe-5d603ae9365c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6739379e-78fc-4c60-b01a-9b5cae340366")), IkeTerm.PREFERRED)
                ;

        set.concept("Property pattern implication (SOLOR)", PublicIds.of(UUID.fromString("e0de0d09-6e27-5738-bc8f-0fc94bb115fc"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9df6d78c-d3f8-4da4-a4f0-36945a710369")), IkeTerm.ENGLISH_LANGUAGE, "Property pattern implication (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3052fba2-c89f-4ce0-a6f3-85a7d8dd8773")), IkeTerm.ENGLISH_LANGUAGE, "Property pattern implication", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3bf933bf-38dc-413e-838c-82ceb8fb2f88")), IkeTerm.ENGLISH_LANGUAGE, "Property pattern implication (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("6ea895ce-e0b6-4a66-adff-3d6636cd3b01")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "e0de0d09-6e27-5738-bc8f-0fc94bb115fc")
                .statedAxioms(PublicIds.of(UUID.fromString("a25e18af-2b28-5920-aaa4-0ec7c1412423")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b5ebc2fe-e086-4d0f-bb6d-0e198309ff39")))
                .semanticOn(PublicIds.of(UUID.fromString("9df6d78c-d3f8-4da4-a4f0-36945a710369")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b66e6d98-1b6d-4ca2-8038-7fb8a9b596c6")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3052fba2-c89f-4ce0-a6f3-85a7d8dd8773")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("383a7731-553e-4400-bd69-2821480a9d27")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3bf933bf-38dc-413e-838c-82ceb8fb2f88")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9d09c435-a7cc-4460-a1a3-fe19bea807c6")), IkeTerm.PREFERRED)
                ;

        set.concept("Definition description type", PublicIds.of(UUID.fromString("700546a3-09c7-3fc2-9eb9-53d318659a09"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1741314b-48e2-4cfe-a1e1-b6b0dc46324c")), IkeTerm.ENGLISH_LANGUAGE, "Definition description type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("43f84d8d-1904-4ac1-86b6-fe24e5927c8e")), IkeTerm.ENGLISH_LANGUAGE, "Definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c0df65c1-49bb-4f59-9a29-7410f9f91995")), IkeTerm.ENGLISH_LANGUAGE, "Semantic value describing the description type for the description pattern is a definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("86a80690-d29c-43ae-a169-4e425ad01509")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "700546a3-09c7-3fc2-9eb9-53d318659a09")
                .statedAxioms(PublicIds.of(UUID.fromString("8c016404-4629-5509-a647-973fd7220e8f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f1708c09-53b7-430f-af12-9a88aa3c5e82")))
                .semanticOn(PublicIds.of(UUID.fromString("1741314b-48e2-4cfe-a1e1-b6b0dc46324c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e222370d-4296-4145-8bcd-a4bf865eb866")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("43f84d8d-1904-4ac1-86b6-fe24e5927c8e")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e4485626-ce44-453c-8349-a68ea56e4c82")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c0df65c1-49bb-4f59-9a29-7410f9f91995")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c479e165-7f02-49cc-806c-5b95bd549e58")), IkeTerm.PREFERRED)
                ;

        set.concept("SOLOR overlay module (SOLOR)", PublicIds.of(UUID.fromString("9ecc154c-e490-5cf8-805d-d2865d62aef3"), UUID.fromString("1f2016a6-960e-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8153389f-6806-429e-b5b2-9adf47ad0728")), IkeTerm.ENGLISH_LANGUAGE, "SOLOR overlay module (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3381c2e0-851c-4f99-a4a8-ee0131e6ebd3")), IkeTerm.ENGLISH_LANGUAGE, "SOLOR overlay module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fd55236f-de37-45d0-bd51-0b9ded34d5e4")), IkeTerm.ENGLISH_LANGUAGE, "SOLOR overlay module (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("58ca0b84-82b4-43e6-808f-10a14240f7c2")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "9ecc154c-e490-5cf8-805d-d2865d62aef3")
                .statedAxioms(PublicIds.of(UUID.fromString("dfd2cb5a-c93d-5cca-be14-50704fdd5987")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("2759aa9b-b709-4d27-8b65-290b06439574")))
                .semanticOn(PublicIds.of(UUID.fromString("8153389f-6806-429e-b5b2-9adf47ad0728")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8f817ba7-4a71-40f3-ab34-f49d8bc47f00")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3381c2e0-851c-4f99-a4a8-ee0131e6ebd3")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("54dea1c2-c145-45be-b233-3174df784483")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("fd55236f-de37-45d0-bd51-0b9ded34d5e4")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("971136be-ab5b-470b-9f6c-c1ff9693b9e2")), IkeTerm.PREFERRED)
                ;

        set.concept("Feature (SOLOR)", PublicIds.of(UUID.fromString("5e76a88e-794a-5fdd-8eb2-4a9e4b1386b6"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("32ef10ac-8a49-49cd-aa40-7d3836cdee4c")), IkeTerm.ENGLISH_LANGUAGE, "Feature (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b4648403-5150-4374-ac20-5b2485cedf90")), IkeTerm.ENGLISH_LANGUAGE, "Feature", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("203a38c7-e0c1-46ff-9520-44d06024908a")), IkeTerm.ENGLISH_LANGUAGE, "Feature (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("77b36125-3eb4-4adb-ad90-f121c446d4b9")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "5e76a88e-794a-5fdd-8eb2-4a9e4b1386b6")
                .statedAxioms(PublicIds.of(UUID.fromString("c1e45623-1c5b-5f32-859f-097cf115fc72")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("76da178e-c702-4c4e-a918-640151cf8393")))
                .semanticOn(PublicIds.of(UUID.fromString("32ef10ac-8a49-49cd-aa40-7d3836cdee4c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("70f84271-5551-48c4-905c-48955ca67199")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b4648403-5150-4374-ac20-5b2485cedf90")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("80f835c0-0aef-41a1-932b-86a4daab9660")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("203a38c7-e0c1-46ff-9520-44d06024908a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e1d1147e-2e46-4411-b9b3-8ad8b9c16c65")), IkeTerm.PREFERRED)
                ;

        set.concept("Regular name description type", PublicIds.of(UUID.fromString("8bfba944-3965-3946-9bcb-1e80a5da63a2"), UUID.fromString("d6fad981-7df6-3388-94d8-238cc0465a79"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("99e6f788-9b9b-4a05-aaf0-489080340030")), IkeTerm.ENGLISH_LANGUAGE, "Regular name description type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("878eac42-be60-44d7-848c-27d2e084b4d2")), IkeTerm.ENGLISH_LANGUAGE, "Regular name description type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c1870058-4aaa-4eb8-aec7-6e80d9c52430")), IkeTerm.ENGLISH_LANGUAGE, "There may be descriptions/synonyms marked as “regular.”", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("cc79eac3-acea-474b-ba29-e6464a4c5469")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8bfba944-3965-3946-9bcb-1e80a5da63a2")
                .statedAxioms(PublicIds.of(UUID.fromString("40135b6f-30ab-5abb-bb51-617d8eb9286e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("67cff2d9-6d46-4811-9935-95e826f03913")))
                .semanticOn(PublicIds.of(UUID.fromString("99e6f788-9b9b-4a05-aaf0-489080340030")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bb11419a-ba12-4f21-967c-43cc8fd157fa")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("878eac42-be60-44d7-848c-27d2e084b4d2")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2e8a7aca-bd8c-45fa-93f9-1913b452ab5b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c1870058-4aaa-4eb8-aec7-6e80d9c52430")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("aae61bea-1be1-4a91-8caf-39ee3b685be7")), IkeTerm.PREFERRED)
                ;

        set.concept("SnoRocket classifier (SOLOR)", PublicIds.of(UUID.fromString("1f201fac-960e-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ee431b64-b4eb-42b5-9c62-ba29fae7f3b9")), IkeTerm.ENGLISH_LANGUAGE, "SnoRocket classifier (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("009e5b82-2664-4092-8e24-82f137077f21")), IkeTerm.ENGLISH_LANGUAGE, "SnoRocket classifier", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9be33f38-bce4-49b3-bf9a-93f8a093a2e2")), IkeTerm.ENGLISH_LANGUAGE, "SnoRocket classifier (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("037f74c5-e9a2-423b-a8ae-0f4fefa8f826")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1f201fac-960e-11e5-8994-feff819cdc9f")
                .statedAxioms(PublicIds.of(UUID.fromString("15ed5e15-b91d-586b-a663-e105d6e84ea4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("54e0afc1-fac3-447f-9287-5098095f265e")))
                .semanticOn(PublicIds.of(UUID.fromString("ee431b64-b4eb-42b5-9c62-ba29fae7f3b9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0e903538-665b-41b9-a4ed-c3e0cbb66d3d")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("009e5b82-2664-4092-8e24-82f137077f21")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("098c24f4-4bb5-41f0-a044-8d55ef78c583")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9be33f38-bce4-49b3-bf9a-93f8a093a2e2")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ce968bd8-8935-4db8-9f97-e2f09bfeaf69")), IkeTerm.PREFERRED)
                ;

        set.concept("Extended description type (SOLOR)", PublicIds.of(UUID.fromString("5a2e7786-3e41-11dc-8314-0800200c9a66"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("427c8cb3-5a3f-4b26-b9f4-eea21cf25a35")), IkeTerm.ENGLISH_LANGUAGE, "Extended description type (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("51b048b3-6441-4302-85ff-d833ff1ef1ee")), IkeTerm.ENGLISH_LANGUAGE, "Extended description type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("613c2838-15e7-4b4f-b058-9f2c4cbfa0fa")), IkeTerm.ENGLISH_LANGUAGE, "Used to store non-snomed description types when other terminologies are imported", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("a8d029b4-8a1d-4422-ba0c-6ac2781ee0dd")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "5a2e7786-3e41-11dc-8314-0800200c9a66")
                .statedAxioms(PublicIds.of(UUID.fromString("f60ccf76-751b-57db-993b-09d9229de859")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("3b07f00c-771e-4697-b72f-3dcbb4819bc1")))
                .semanticOn(PublicIds.of(UUID.fromString("427c8cb3-5a3f-4b26-b9f4-eea21cf25a35")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a5edd7a0-9cf6-4235-9f3c-a72db05b66f1")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("51b048b3-6441-4302-85ff-d833ff1ef1ee")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c9f5801a-c93f-4e57-a3e3-bdc6f89e7e00")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("613c2838-15e7-4b4f-b058-9f2c4cbfa0fa")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e5749aed-0aa7-4d3d-b20e-0fa47a98f100")), IkeTerm.PREFERRED)
                ;

        set.concept("SOLOR module (SOLOR)", PublicIds.of(UUID.fromString("f680c868-f7e5-5d0e-91f2-615eca8f8fd2"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("29f4e60f-e438-4eb8-8abe-2498233ff35f")), IkeTerm.ENGLISH_LANGUAGE, "SOLOR module (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("39c5ca5a-74ea-4338-a128-cd13321565c9")), IkeTerm.ENGLISH_LANGUAGE, "SOLOR module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cc5e5b23-0792-4b09-ac91-ed4d3b62e6a3")), IkeTerm.ENGLISH_LANGUAGE, "SOLOR module (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("dac36a48-1ae2-4036-b326-b43470480014")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f680c868-f7e5-5d0e-91f2-615eca8f8fd2")
                .statedAxioms(PublicIds.of(UUID.fromString("eee042ff-af08-58c1-b9b6-7c7171bf4b7f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ac0aeee6-0c4e-405c-98c0-73c06a825bf2")))
                .semanticOn(PublicIds.of(UUID.fromString("29f4e60f-e438-4eb8-8abe-2498233ff35f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9e631b8d-69fb-41c2-be9c-0fd3e5bd4b78")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("39c5ca5a-74ea-4338-a128-cd13321565c9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5e40d9f7-8fe3-4c05-b6ea-e2128977003b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cc5e5b23-0792-4b09-ac91-ed4d3b62e6a3")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c075b514-36be-4e6f-8234-349049c35d9c")), IkeTerm.PREFERRED)
                ;

    }
}
