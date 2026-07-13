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

/** The "Tinkar root concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section71 {

    private Section71() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Boolean field", PublicIds.of(UUID.fromString("4229683e-8772-4936-abd5-edc5a180f4d1"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ecd6c008-6959-4a14-8e9e-750b3764537b")), TinkarTerm.ENGLISH_LANGUAGE, "Boolean field", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("6d0719cc-28f0-414d-8512-0c2b9cbe217c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field definition data type field", PublicIds.of(UUID.fromString("02273b53-fce7-4cbe-921d-2cff67e81ad5")))))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5b5a4b60-13c0-5c2a-84cb-0798aea1afbc")))
                ;

        set.concept("STAMP versions set", PublicIds.of(UUID.fromString("edb90567-7822-4129-a406-b359b825f922"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5e1ce34f-77ec-46ef-8f15-1c292e77c008")), TinkarTerm.ENGLISH_LANGUAGE, "STAMP versions set", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("0afed167-46a1-4470-99bf-2bd6d907f3c5")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions set", PublicIds.of(UUID.fromString("54d670f1-234d-485a-a354-e1fa7eea1bf2")))))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("fcab1c2e-35c9-5879-9f56-40667f046b04")))
                ;

        set.concept("Data Property Set Axioms", PublicIds.of(UUID.fromString("1402d311-0b4b-4014-81d2-e715c6696346"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("01e7bccd-a632-46e5-ab25-9ce3b0ee3113")), TinkarTerm.ENGLISH_LANGUAGE, "Data Property Set Axioms", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a6335d66-ec82-5fc1-8b86-d06926a3a2b7")))
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f7a7bcb6-afbe-4617-9a28-773907fd2a70")), TinkarTerm.ENGLISH_LANGUAGE, "Data Property Set Axioms", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("e01e07cd-c205-4e9d-97db-2d61a115ae9d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS), leb.ConceptAxiom(TinkarTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS))))
                ;

        set.concept("STAMP versions field", PublicIds.of(UUID.fromString("b8251bea-4248-4a46-8b4a-349500693a9f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cb751cf0-8d3f-4357-9df8-b17928c4a85f")), TinkarTerm.ENGLISH_LANGUAGE, "STAMP versions field", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("0ee2cdc9-6cc0-40ac-91fd-de2b12c60aac")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions field", PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c")))))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("af493b91-d6e7-5ae4-b1b9-6a36a6554c52")))
                ;

        set.concept("Status field", PublicIds.of(UUID.fromString("f2c79ebb-3095-44ea-831f-992aed48801f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("63089ce4-4fd4-4d51-b0a1-1465434022c0")), TinkarTerm.ENGLISH_LANGUAGE, "Status field", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("a5c5ea2d-2d81-4275-ba18-ada4fb00448b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")))))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5de39a0b-0e4f-5d21-a97b-e9f454fea78a")))
                ;

        set.concept("Time field", PublicIds.of(UUID.fromString("15293325-c16b-4f2e-8109-5b22b3355bcd"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a3b04559-ed05-4eb9-bba1-35102d20d071")), TinkarTerm.ENGLISH_LANGUAGE, "Time field", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("e5a8de94-8552-4837-9f2c-217a0e815984")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Instant field", PublicIds.of(UUID.fromString("e9bde1bc-aa72-430a-afe1-aa8aec8833b4")))))))
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("35233caa-f648-4baf-a1d1-ec4c6f125ae4")), TinkarTerm.ENGLISH_LANGUAGE, "Time field", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("fac6a8f8-2d40-59db-9882-283aad90b647")))
                ;

        set.concept("Author field", PublicIds.of(UUID.fromString("a9210ad6-cc48-47df-86e5-2192d56704a6"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a2849246-87e7-4cf1-8d24-22f09678ed72")), TinkarTerm.ENGLISH_LANGUAGE, "Author field", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("cc364868-eabe-4a93-8381-7bdf84bb3df6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")))))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c8de0a4f-4868-53b0-909d-a4603b997e13")))
                ;

        set.concept("Component versions field", PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9cf3da8a-5214-4e20-9c77-198d1a7445a8")), TinkarTerm.ENGLISH_LANGUAGE, "Component versions field", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("15d5da72-8e12-4345-8962-1d14f652834b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of(UUID.fromString("ed230c7c-20f9-470d-8566-5057f92748a5")))))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8e135ad6-6a8b-56b8-810b-6b45fbedddde")))
                ;

        set.concept("Module field", PublicIds.of(UUID.fromString("e6359a86-a1df-4721-8a1a-1f1f075ec3d9"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1a3627bd-09ec-421c-9c37-1fc6fd07d82c")), TinkarTerm.ENGLISH_LANGUAGE, "Module field", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("90a4ace9-c128-435d-9060-79d8920e0bd8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")))))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("239dce52-c668-57a1-8316-b1c8bd276d0c")))
                ;

        set.concept("Default Data Concept", PublicIds.of(UUID.fromString("4a32d2ad-baca-42b5-a432-4c4ae6431668"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8bbc697e-f51a-40a0-8af9-396f3b040cdd")), TinkarTerm.ENGLISH_LANGUAGE, "Default Data Concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("8f607d4f-ef9e-48eb-bb3f-b5a2806cf34b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Data Concept", PublicIds.of(UUID.fromString("ae7069d1-67fa-4470-a56f-0d24a8fcea83")))))))
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("246e55f7-c359-42ce-ac5d-79fd4fb1f088")), TinkarTerm.ENGLISH_LANGUAGE, "Default Data Concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bce173b8-a806-4a98-953b-6abad7090d11")), TinkarTerm.ENGLISH_LANGUAGE, "Default Data FQN", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("32c891e1-5a78-4922-a166-06400d088dea")), TinkarTerm.ENGLISH_LANGUAGE, "Default Data - Other Name", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.GB_DIALECT_PATTERN, PublicIds.of(UUID.fromString("17c5b61f-e121-4c54-9eb3-e106f3983417")), EntityProxy.Concept.make("Blank Concept", PublicIds.of(UUID.fromString("cd23d88d-2fcd-4007-8829-97e37bf336aa"))))
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8b7b452c-6de1-47b8-81fb-2e4cf58ca213")), EntityProxy.Concept.make("Blank Concept", PublicIds.of(UUID.fromString("cd23d88d-2fcd-4007-8829-97e37bf336aa"))), "Default Data - Identifier Value")
                .semantic(TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("92548331-a460-4bdb-aa32-7162f2fb4f0d")), EntityProxy.Concept.make("Blank Concept", PublicIds.of(UUID.fromString("cd23d88d-2fcd-4007-8829-97e37bf336aa"))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("bfa087e5-5e6e-5032-b204-03b22b931672")))
                ;

        set.concept("Data Concept", PublicIds.of(UUID.fromString("ae7069d1-67fa-4470-a56f-0d24a8fcea83"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("871e69f3-e844-4342-b56f-a22188feb129")), TinkarTerm.ENGLISH_LANGUAGE, "Data Concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("137221ba-47a9-442a-a62a-dcdd20a0d50e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.MODEL_CONCEPT))))
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("515bf9ec-954d-42d8-a5e7-727e05b51602")), TinkarTerm.ENGLISH_LANGUAGE, "Data Concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ac8d42ee-be33-5254-833c-cb6f688ba7f3")))
                ;

        set.pattern("Tinkar base model component pattern", PublicIds.of(UUID.fromString("6070f6f5-893d-5144-adce-7d305c391cf9"))).at(inception)
                .meaning(TinkarTerm.STARTER_DATA_AUTHORING).purpose(TinkarTerm.MEMBERSHIP_SEMANTIC)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("29922b82-0026-4fe1-9a3f-c81563b7ff94")), TinkarTerm.ENGLISH_LANGUAGE, "Tinkar base model component pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0711a763-56f7-4dcf-b4c2-77bfc514f3dc")))
                ;

        set.pattern("Description Pattern", PublicIds.of(UUID.fromString("a4de0039-2625-5842-8a4c-d1ce6aebf021"))).at(inception)
                .meaning(TinkarTerm.DESCRIPTION_SEMANTIC).purpose(TinkarTerm.DESCRIPTION_SEMANTIC).field(TinkarTerm.LANGUAGE_CONCEPT_NID_FOR_DESCRIPTION, TinkarTerm.LANGUAGE, TinkarTerm.COMPONENT_FIELD).field(TinkarTerm.TEXT_FOR_DESCRIPTION, TinkarTerm.DESCRIPTION, TinkarTerm.STRING).field(TinkarTerm.DESCRIPTION_CASE_SIGNIFICANCE, TinkarTerm.DESCRIPTION_CASE_SIGNIFICANCE, TinkarTerm.COMPONENT_FIELD).field(TinkarTerm.DESCRIPTION_TYPE, TinkarTerm.DESCRIPTION_TYPE, TinkarTerm.COMPONENT_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2aaa8391-e4fe-4ce1-b574-25967bdcd3c8")), TinkarTerm.ENGLISH_LANGUAGE, "Description Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3142a96a-5ff8-4b08-98a9-0cf19ddc9345")), TinkarTerm.ENGLISH_LANGUAGE, "Description Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("361dad43-0903-4065-9067-a2e65a44ddc7")), TinkarTerm.ENGLISH_LANGUAGE, "Contains all metadata and human readable text that describes the concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1f9f73e4-554b-406c-92bc-2092865a0ca4")))
                ;

        set.pattern("Concept field pattern", PublicIds.of(UUID.fromString("3e510cb9-1666-4676-9334-d288a56bf155"))).at(inception)
                .meaning(EntityProxy.Concept.make("Concept field", PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")))).purpose(EntityProxy.Concept.make("Concept field", PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")))).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Concept versions field", PublicIds.of(UUID.fromString("3a08b5f1-f17e-4db5-8cf9-c6540f26f241"))), EntityProxy.Concept.make("Concept versions set", PublicIds.of(UUID.fromString("806c7f9f-52f9-4b53-9758-122899b28a76"))), TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1cb3e89f-96de-4fc5-8205-5eecaede0c15")), TinkarTerm.ENGLISH_LANGUAGE, "Concept field pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("59e042f1-45ef-421f-bd14-77020233e576")), TinkarTerm.ENGLISH_LANGUAGE, "Concept Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b112545c-6e2c-4340-81b6-a27801412f49")), TinkarTerm.ENGLISH_LANGUAGE, "Concept Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("41886644-3879-41d1-b32e-ff281066b746")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5871819d-2af0-4a4b-9d9e-757951c73e7e")))
                .semanticOn(PublicIds.of(UUID.fromString("b112545c-6e2c-4340-81b6-a27801412f49")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6e242243-5509-432f-aa29-71e02104a4c9")), TinkarTerm.ACCEPTABLE)
                ;

        set.pattern("STAMP pattern", PublicIds.of(UUID.fromString("9fd67fee-abf9-551d-9d0e-76a4b1e8b4ee"))).at(inception)
                .meaning(TinkarTerm.VERSION_PROPERTIES).purpose(TinkarTerm.VERSION_PROPERTIES).field(TinkarTerm.STATUS_VALUE, TinkarTerm.STATUS_FOR_VERSION, TinkarTerm.COMPONENT_FIELD).field(TinkarTerm.TIME_FOR_VERSION, TinkarTerm.TIME_FOR_VERSION, TinkarTerm.LONG).field(TinkarTerm.AUTHOR_FOR_VERSION, TinkarTerm.AUTHOR_FOR_VERSION, TinkarTerm.COMPONENT_FIELD).field(TinkarTerm.MODULE_FOR_VERSION, TinkarTerm.MODULE_FOR_VERSION, TinkarTerm.COMPONENT_FIELD).field(TinkarTerm.PATH_FOR_VERSION, TinkarTerm.PATH_FOR_VERSION, TinkarTerm.COMPONENT_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e7ae5ae3-9abd-49b3-bbb8-eccb4f406bb8")), TinkarTerm.ENGLISH_LANGUAGE, "STAMP pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9614a691-a160-473d-b0d9-5af6084ceeee")))
                ;

        set.pattern("Semantic Chronology Pattern", PublicIds.of(UUID.fromString("5f0ad6ca-638e-4052-82b0-3f564ac99b3f"))).at(inception)
                .meaning(EntityProxy.Concept.make("Semantic field", PublicIds.of(UUID.fromString("8b6c69d7-a5aa-4db2-bcea-8c7b2817b02f")))).purpose(EntityProxy.Concept.make("Semantic field", PublicIds.of(UUID.fromString("8b6c69d7-a5aa-4db2-bcea-8c7b2817b02f")))).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Semantic pattern field", PublicIds.of(UUID.fromString("19dd5dd3-1075-4113-a437-5f1f7c2d55bc"))), EntityProxy.Concept.make("Semantic pattern field", PublicIds.of(UUID.fromString("19dd5dd3-1075-4113-a437-5f1f7c2d55bc"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Semantic referenced component field", PublicIds.of(UUID.fromString("4111ba1e-c818-4c5d-9fed-34d07298d009"))), EntityProxy.Concept.make("Semantic referenced component field", PublicIds.of(UUID.fromString("4111ba1e-c818-4c5d-9fed-34d07298d009"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Semantic versions set", PublicIds.of(UUID.fromString("4fd69aed-556f-4938-94cc-ea7ea707ccef"))), EntityProxy.Concept.make("Semantic versions set", PublicIds.of(UUID.fromString("4fd69aed-556f-4938-94cc-ea7ea707ccef"))), TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("af8495f1-a122-4358-a214-a7af58b87ffd")), TinkarTerm.ENGLISH_LANGUAGE, "Semantic Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e84623f1-c991-4998-ad86-8623248bcdd4")), TinkarTerm.ENGLISH_LANGUAGE, "Semantic Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7cdd578f-ee8c-43d6-9cec-3311c494e78e")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("cdd3fe9d-90f0-44cb-b135-67d06a885ce1")))
                .semanticOn(PublicIds.of(UUID.fromString("e84623f1-c991-4998-ad86-8623248bcdd4")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("77e86eec-0532-4f35-a5db-df2974a77bcf")), TinkarTerm.ACCEPTABLE)
                ;

        set.pattern("STAMP version field pattern", PublicIds.of(UUID.fromString("73c798cf-bc77-49a2-84f7-4c0f4bc4c012"))).at(inception)
                .meaning(EntityProxy.Concept.make("STAMP versions field", PublicIds.of(UUID.fromString("b8251bea-4248-4a46-8b4a-349500693a9f")))).purpose(EntityProxy.Concept.make("STAMP versions field", PublicIds.of(UUID.fromString("b8251bea-4248-4a46-8b4a-349500693a9f")))).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Status field", PublicIds.of(UUID.fromString("f2c79ebb-3095-44ea-831f-992aed48801f"))), EntityProxy.Concept.make("Status field", PublicIds.of(UUID.fromString("f2c79ebb-3095-44ea-831f-992aed48801f"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Time field", PublicIds.of(UUID.fromString("15293325-c16b-4f2e-8109-5b22b3355bcd"))), EntityProxy.Concept.make("Time field", PublicIds.of(UUID.fromString("15293325-c16b-4f2e-8109-5b22b3355bcd"))), TinkarTerm.STRING).field(EntityProxy.Concept.make("Author field", PublicIds.of(UUID.fromString("a9210ad6-cc48-47df-86e5-2192d56704a6"))), EntityProxy.Concept.make("Author field", PublicIds.of(UUID.fromString("a9210ad6-cc48-47df-86e5-2192d56704a6"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Module field", PublicIds.of(UUID.fromString("e6359a86-a1df-4721-8a1a-1f1f075ec3d9"))), EntityProxy.Concept.make("Module field", PublicIds.of(UUID.fromString("e6359a86-a1df-4721-8a1a-1f1f075ec3d9"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Path field", PublicIds.of(UUID.fromString("6622a391-e2e6-45a0-97e1-c58cd0184092"))), EntityProxy.Concept.make("Path field", PublicIds.of(UUID.fromString("6622a391-e2e6-45a0-97e1-c58cd0184092"))), TinkarTerm.COMPONENT_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fb0560ed-91a0-47d4-ae4f-b5294710d0d5")), TinkarTerm.ENGLISH_LANGUAGE, "STAMP version field pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("35b4a268-6aa1-40bf-8a5d-2da53cc945e5")), TinkarTerm.ENGLISH_LANGUAGE, "STAMP Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("efb979c4-19fe-4503-8393-26f543e4a86a")))
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("68a1db90-d8bf-478b-bb45-48ee01be6870")), TinkarTerm.ENGLISH_LANGUAGE, "STAMP Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6b3b5585-14a9-4416-bb66-1c685dfe4686")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("91153646-f74a-439a-b4e5-1d95c521fdb8")))
                .semanticOn(PublicIds.of(UUID.fromString("68a1db90-d8bf-478b-bb45-48ee01be6870")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ff202c86-6b7b-4d03-bf73-2e8612e9dd19")), TinkarTerm.ACCEPTABLE)
                ;

        set.pattern("Component Chronology Pattern", PublicIds.of(UUID.fromString("c48db76d-5eb0-4ff5-84d0-5c3c4ec77767"))).at(inception)
                .meaning(EntityProxy.Concept.make("Component field", PublicIds.of(UUID.fromString("8bd36a0c-d05d-46b7-a79a-d11477705cc1")))).purpose(EntityProxy.Concept.make("Component field", PublicIds.of(UUID.fromString("8bd36a0c-d05d-46b7-a79a-d11477705cc1")))).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Component versions field", PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c"))), EntityProxy.Concept.make("Component versions set", PublicIds.of(UUID.fromString("54d670f1-234d-485a-a354-e1fa7eea1bf2"))), TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0c46590f-ad05-4ca1-b61a-869b5e93ba10")), TinkarTerm.ENGLISH_LANGUAGE, "Component Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("603ff6ab-4960-4bc0-bb5a-d9602860c1fe")), TinkarTerm.ENGLISH_LANGUAGE, "Component Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1cdc6348-d59e-4120-b488-a11d8c308bf1")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9e81b610-7620-4faa-a845-a694e122a3dd")))
                .semanticOn(PublicIds.of(UUID.fromString("603ff6ab-4960-4bc0-bb5a-d9602860c1fe")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("973cce36-dc82-4f12-8197-5ec2714baac1")), TinkarTerm.ACCEPTABLE)
                ;

        set.pattern("Module origins pattern (SOLOR)", PublicIds.of(UUID.fromString("536b0ec4-4974-47ae-93a6-ae6c4d169780"))).at(inception)
                .meaning(TinkarTerm.MODULE_ORIGINS).purpose(TinkarTerm.MODULE_ORIGINS).field(TinkarTerm.MODULE_ORIGINS, TinkarTerm.MODULE_ORIGINS, TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4a584a9a-b38d-4173-85c4-66658aa84cab")), TinkarTerm.ENGLISH_LANGUAGE, "Module origins pattern (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5535793d-49e3-4e40-954e-dc7d80a8660d")), TinkarTerm.ENGLISH_LANGUAGE, "Module origins pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dc8ea392-f203-4a34-ba8e-20b524404fcc")), TinkarTerm.ENGLISH_LANGUAGE, "Pattern of module origins", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4fb597d3-2c22-475c-8535-878896f91683")))
                ;

        set.pattern("Identifier Pattern", PublicIds.of(UUID.fromString("5d60e14b-c410-5172-9559-3c4253278ae2"))).at(inception)
                .meaning(TinkarTerm.IDENTIFIER_SOURCE).purpose(TinkarTerm.IDENTIFIER_SOURCE).field(TinkarTerm.IDENTIFIER_SOURCE, TinkarTerm.IDENTIFIER_SOURCE, TinkarTerm.COMPONENT_FIELD).field(TinkarTerm.IDENTIFIER_VALUE, TinkarTerm.IDENTIFIER_VALUE, TinkarTerm.STRING)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f671a8b2-35d8-49d1-bacc-2aca84efe434")), TinkarTerm.ENGLISH_LANGUAGE, "Identifier Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("31c54b87-1ed0-444f-b395-ad1da8692f81")), TinkarTerm.ENGLISH_LANGUAGE, "Identifier Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6cb677cb-6c26-4d45-935c-840ccb0fcb79")), TinkarTerm.ENGLISH_LANGUAGE, "An identifier pattern is used to identity a concept which contains the identifier source and the actual value.", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e96cccb9-690e-479a-bfd7-449e434b2fc2")))
                ;

        set.pattern("Inferred Navigation Pattern", PublicIds.of(UUID.fromString("a53cc42d-c07e-5934-96b3-2ede3264474e"))).at(inception)
                .meaning(TinkarTerm.IS_A).purpose(TinkarTerm.IS_A).field(TinkarTerm.RELATIONSHIP_DESTINATION, TinkarTerm.IS_A, TinkarTerm.COMPONENT_ID_SET_FIELD).field(TinkarTerm.RELATIONSHIP_ORIGIN, TinkarTerm.IS_A, TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("47656bb5-76dc-497f-bdc6-b612abeaf45b")), TinkarTerm.ENGLISH_LANGUAGE, "Inferred Navigation Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9992ca7b-8bcf-4ba8-b194-5623eb2a0bed")), TinkarTerm.ENGLISH_LANGUAGE, "Inferred Navigation Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5b55743d-2f1d-4f6e-ba06-ac9d8d1d2dfa")), TinkarTerm.ENGLISH_LANGUAGE, "A pattern specifying the origins and destinations for concepts based on the inferred terminological axioms.", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0e710d55-ae62-44e1-8d92-06966b6a282c")))
                ;

        set.pattern("Stated Navigation Pattern", PublicIds.of(UUID.fromString("d02957d6-132d-5b3c-adba-505f5778d998"))).at(inception)
                .meaning(TinkarTerm.IS_A).purpose(TinkarTerm.IS_A).field(TinkarTerm.RELATIONSHIP_DESTINATION, TinkarTerm.IS_A, TinkarTerm.COMPONENT_ID_SET_FIELD).field(TinkarTerm.RELATIONSHIP_ORIGIN, TinkarTerm.IS_A, TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ef541837-419f-4477-9dd9-b037ba5f7470")), TinkarTerm.ENGLISH_LANGUAGE, "Stated Navigation Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e95fcc4a-638f-401d-8027-44ebb1bee7ee")), TinkarTerm.ENGLISH_LANGUAGE, "Stated Navigation Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f344e858-a5e4-4cf3-8fa8-8d50bdd4dd9f")), TinkarTerm.ENGLISH_LANGUAGE, "A pattern specifying the origins and destinations for concepts based on the stated terminological axioms.", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("64eda4d2-76c4-4176-83d1-f3719551cc9d")))
                ;

        set.pattern("Pattern Version Pattern", PublicIds.of(UUID.fromString("a90f8a4d-ae13-476b-98b8-814914f9704e"))).at(inception)
                .meaning(EntityProxy.Concept.make("Pattern versions field", PublicIds.of(UUID.fromString("7b8ecbbf-55b4-41bc-acbf-51824e74446a")))).purpose(EntityProxy.Concept.make("Pattern versions field", PublicIds.of(UUID.fromString("7b8ecbbf-55b4-41bc-acbf-51824e74446a")))).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Pattern meaning field", PublicIds.of(UUID.fromString("996d0023-a355-422f-a84d-16dda6ece1b0"))), EntityProxy.Concept.make("Pattern meaning field", PublicIds.of(UUID.fromString("996d0023-a355-422f-a84d-16dda6ece1b0"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Pattern purpose field", PublicIds.of(UUID.fromString("352c821b-7a11-454c-a127-48ad3206573d"))), EntityProxy.Concept.make("Pattern purpose field", PublicIds.of(UUID.fromString("352c821b-7a11-454c-a127-48ad3206573d"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Field definition field", PublicIds.of(UUID.fromString("14171f07-e74f-409a-b555-06b478818f76"))), EntityProxy.Concept.make("Field definitions set", PublicIds.of(UUID.fromString("975de83e-ab99-4a9e-9051-4cbf310a2123"))), TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5bcd6ba3-de15-4f7c-978d-0d4cf6cbe23f")), TinkarTerm.ENGLISH_LANGUAGE, "Pattern Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1e3baacc-aa99-490b-a6bb-2b83e819f7ae")), TinkarTerm.ENGLISH_LANGUAGE, "Pattern Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d0ce915d-a121-4a3c-9f07-dd198bbbfe0f")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a98f1d31-86e1-48d6-bda8-048dd626c152")))
                .semanticOn(PublicIds.of(UUID.fromString("1e3baacc-aa99-490b-a6bb-2b83e819f7ae")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4fcb49f2-2ed7-4665-b7c7-fc6d6877d78a")), TinkarTerm.ACCEPTABLE)
                ;

        set.pattern("STAMP Chronology Pattern", PublicIds.of(UUID.fromString("e16abc7a-2a7b-42af-b168-d77aec8116ea"))).at(inception)
                .meaning(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6")))).purpose(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6")))).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("STAMP versions field", PublicIds.of(UUID.fromString("b8251bea-4248-4a46-8b4a-349500693a9f"))), EntityProxy.Concept.make("STAMP versions set", PublicIds.of(UUID.fromString("edb90567-7822-4129-a406-b359b825f922"))), TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8183b8f7-b9b5-4de2-a103-b7ced1a37188")), TinkarTerm.ENGLISH_LANGUAGE, "STAMP Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1d4b2d6e-c003-456c-8c58-b8cdff3f4b4f")), TinkarTerm.ENGLISH_LANGUAGE, "STAMP Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("44918826-bf99-4725-9731-306cf3d54437")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5bb51d01-4d23-4f57-b2d6-8d463a008d39")))
                .semanticOn(PublicIds.of(UUID.fromString("1d4b2d6e-c003-456c-8c58-b8cdff3f4b4f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("70297491-52ac-443f-a9a4-c6e13b95285e")), TinkarTerm.ACCEPTABLE)
                ;

        set.pattern("EL++ Stated Axioms Pattern", PublicIds.of(UUID.fromString("e813eb92-7d07-5035-8d43-e81249f5b36e"))).at(inception)
                .meaning(TinkarTerm.STATED_DEFINITION).purpose(TinkarTerm.LOGICAL_DEFINITION).field(TinkarTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS, TinkarTerm.LOGICAL_DEFINITION, TinkarTerm.DITREE_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e16fee31-d619-4646-9a52-d16ebea5106e")), TinkarTerm.ENGLISH_LANGUAGE, "EL++ Stated Axioms Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("194f2b92-7736-4301-9e03-14fb5d9cb13a")), TinkarTerm.ENGLISH_LANGUAGE, "Stated definition pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1ce1bcdf-7527-4f8e-9406-611b9c84ed69")))
                ;

        set.pattern("Version control path pattern", PublicIds.of(UUID.fromString("add1db57-72fe-53c8-a528-1614bda20ec6"))).at(inception)
                .meaning(TinkarTerm.PATH).purpose(TinkarTerm.MEMBERSHIP_SEMANTIC)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e0647541-c6e4-4be9-9e0a-c66ed712c48e")), TinkarTerm.ENGLISH_LANGUAGE, "Version control path pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("84b52fdd-1a1c-4cea-b8a8-6c0d48522d4d")))
                ;

        set.pattern("Comment pattern", PublicIds.of(UUID.fromString("3734fb0a-4c14-5831-9a61-4743af609e7a"))).at(inception)
                .meaning(TinkarTerm.COMMENT).purpose(TinkarTerm.COMMENT).field(TinkarTerm.COMMENT, TinkarTerm.COMMENT, TinkarTerm.STRING)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8e565bae-7a22-402e-bdbf-8f5ded827718")), TinkarTerm.ENGLISH_LANGUAGE, "Comment pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("723a2333-a9e4-43f7-928f-db76d2f96bd8")), TinkarTerm.ENGLISH_LANGUAGE, "Comment Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1934fc0e-b2d0-4464-9967-9a5698db0f26")))
                ;

        set.pattern("EL++ Inferred Axioms Pattern", PublicIds.of(UUID.fromString("9f011812-15c9-5b1b-85f8-bb262bc1b2a2"))).at(inception)
                .meaning(TinkarTerm.INFERRED_DEFINITION).purpose(TinkarTerm.LOGICAL_DEFINITION).field(TinkarTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS, TinkarTerm.LOGICAL_DEFINITION, TinkarTerm.DITREE_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fbfc2edd-7ddf-41f3-9c72-c583f0d10c2f")), TinkarTerm.ENGLISH_LANGUAGE, "EL++ Inferred Axioms Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7b08e8f0-6879-4ef9-aa7c-c75ccda25b21")), TinkarTerm.ENGLISH_LANGUAGE, "Inferred definition pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a23311f2-3b36-419f-9086-80c5dceecae6")))
                ;

        set.pattern("SOLOR concept assemblage (SOLOR)", PublicIds.of(UUID.fromString("d39b3ecd-9a80-5009-a8ac-0b947f95ca7c"))).at(inception)
                .meaning(TinkarTerm.CONCEPT_ASSEMBLAGE_FOR_LOGIC_COORDINATE).purpose(TinkarTerm.MEMBERSHIP_SEMANTIC)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6783af77-56e5-4bda-b11e-f980fa89b224")), TinkarTerm.ENGLISH_LANGUAGE, "SOLOR concept assemblage (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("75dcfa58-6cb9-4f5a-9355-2cf161453d57")))
                ;

        set.pattern("OWL Axiom Syntax Pattern", PublicIds.of(UUID.fromString("c0ca180b-aae2-5fa1-9ab7-4a24f2dfe16b"))).at(inception)
                .meaning(TinkarTerm.AXIOM_SYNTAX).purpose(TinkarTerm.EXPRESS_AXIOM_SYNTAX).field(TinkarTerm.AXIOM_SYNTAX, TinkarTerm.EXPRESS_AXIOM_SYNTAX, TinkarTerm.STRING)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ecf5c52f-957c-4164-8721-95477acbcefc")), TinkarTerm.ENGLISH_LANGUAGE, "OWL Axiom Syntax Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("97388687-b390-4d89-be6e-8c84a1244e56")))
                ;

        set.pattern("US Dialect Pattern", PublicIds.of(UUID.fromString("08f9112c-c041-56d3-b89b-63258f070074"))).at(inception)
                .meaning(TinkarTerm.DESCRIPTION_ACCEPTABILITY).purpose(TinkarTerm.DESCRIPTION_SEMANTIC).field(TinkarTerm.US_ENGLISH_DIALECT, TinkarTerm.DESCRIPTION_ACCEPTABILITY, TinkarTerm.COMPONENT_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("413469a3-a340-4a55-8074-b44029765f93")), TinkarTerm.ENGLISH_LANGUAGE, "US Dialect Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3fe6d66f-bcad-4859-b513-68f924143f1f")), TinkarTerm.ENGLISH_LANGUAGE, "US Dialect Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("21b12d41-1083-4fd5-95ea-1aea8edf868f")))
                ;

        set.pattern("Pattern Chronology Pattern", PublicIds.of(UUID.fromString("5bc93adb-9d39-43fe-a7a4-1492245b7efb"))).at(inception)
                .meaning(EntityProxy.Concept.make("Pattern field", PublicIds.of(UUID.fromString("751790c7-e1e4-42bc-b531-54c54bd6eebd")))).purpose(EntityProxy.Concept.make("Pattern field", PublicIds.of(UUID.fromString("751790c7-e1e4-42bc-b531-54c54bd6eebd")))).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Pattern versions field", PublicIds.of(UUID.fromString("7b8ecbbf-55b4-41bc-acbf-51824e74446a"))), EntityProxy.Concept.make("Pattern versions set", PublicIds.of(UUID.fromString("a254ccee-ef02-4504-9645-0a2ed7af955d"))), TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("28a31a01-d0b8-4d3f-b05b-503249b7f0ff")), TinkarTerm.ENGLISH_LANGUAGE, "Pattern Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c004d891-8c23-487c-a066-f0842483303f")), TinkarTerm.ENGLISH_LANGUAGE, "Pattern Chronology Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f91d93a4-2f5d-4913-9ef8-85fd5194d0a7")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d4cc73e7-fea9-44a0-be8e-91fa51fc78cf")))
                .semanticOn(PublicIds.of(UUID.fromString("c004d891-8c23-487c-a066-f0842483303f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c97ec6b6-559d-4e3b-a063-602379d2cefa")), TinkarTerm.ACCEPTABLE)
                ;

        set.pattern("Component Version Pattern", PublicIds.of(UUID.fromString("a38b7d2d-8fa5-4206-9185-a1af9f81be2c"))).at(inception)
                .meaning(EntityProxy.Concept.make("Component versions field", PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c")))).purpose(EntityProxy.Concept.make("Component versions field", PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c")))).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), TinkarTerm.COMPONENT_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d8593553-14ad-4ff2-9287-e3846dd03f67")), TinkarTerm.ENGLISH_LANGUAGE, "Component Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7ab5c487-7441-45d1-9f3b-e17e06f0b862")), TinkarTerm.ENGLISH_LANGUAGE, "Component Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e113fc68-13ee-4cda-b833-2560faee6083")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("774e9825-9844-45cd-856e-6a38f4491d9c")))
                .semanticOn(PublicIds.of(UUID.fromString("7ab5c487-7441-45d1-9f3b-e17e06f0b862")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0b4d72a8-e8bf-43bd-9cfe-4f211af2f174")), TinkarTerm.ACCEPTABLE)
                ;

        set.pattern("Sementic version field pattern", PublicIds.of(UUID.fromString("82f93e84-cee1-44bc-bb6d-4cc2a722048b"))).at(inception)
                .meaning(EntityProxy.Concept.make("Semantic versions field", PublicIds.of(UUID.fromString("aeb73410-a679-4ea8-93fe-7c4785599778")))).purpose(EntityProxy.Concept.make("Semantic versions field", PublicIds.of(UUID.fromString("aeb73410-a679-4ea8-93fe-7c4785599778")))).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), TinkarTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Semantic field field", PublicIds.of(UUID.fromString("f6572c76-b5c0-41da-99c0-4344694e7e3c"))), EntityProxy.Concept.make("Semantic field fields set", PublicIds.of(UUID.fromString("8dcfc1a1-31f2-46f7-8247-0a17a6d7c6c0"))), TinkarTerm.COMPONENT_ID_SET_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d47fdb46-8ce0-4405-943a-b2420c7480f8")), TinkarTerm.ENGLISH_LANGUAGE, "Sementic version field pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2caeaa6d-865c-4e61-8d48-c003487ee067")), TinkarTerm.ENGLISH_LANGUAGE, "Sementic version field pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("515a0b47-f8d8-4a42-922a-20454a1c006b")), TinkarTerm.ENGLISH_LANGUAGE, "Semantic Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("06418dca-6423-423e-ae9d-d9adeaac4c66")), TinkarTerm.ENGLISH_LANGUAGE, "Semantic Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4a062843-1c52-4bf6-95a6-fef885ed8906")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("be55e51f-c9ac-4151-8bf9-bd82179bd4b9")))
                .semanticOn(PublicIds.of(UUID.fromString("06418dca-6423-423e-ae9d-d9adeaac4c66")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0119c1c6-2bc9-442f-b729-d5be78fd1083")), TinkarTerm.ACCEPTABLE)
                ;

        set.pattern("Komet base model component pattern", PublicIds.of(UUID.fromString("bbbbf1fe-00f0-55e0-a19c-6300dbaab9b2"))).at(inception)
                .meaning(TinkarTerm.STARTER_DATA_AUTHORING).purpose(TinkarTerm.MEMBERSHIP_SEMANTIC)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d9c64ddb-5898-454e-be56-cab97d5dacef")), TinkarTerm.ENGLISH_LANGUAGE, "Komet base model component pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.KOMET_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("542c82b0-8413-4452-8891-4d9b145eaaf4")))
                ;

        set.pattern("GB Dialect Pattern", PublicIds.of(UUID.fromString("561f817a-130e-5e56-984d-910e9991558c"))).at(inception)
                .meaning(TinkarTerm.DESCRIPTION_ACCEPTABILITY).purpose(TinkarTerm.DESCRIPTION_SEMANTIC).field(TinkarTerm.GB_ENGLISH_DIALECT, TinkarTerm.DESCRIPTION_ACCEPTABILITY, TinkarTerm.COMPONENT_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("243fa7ea-ad48-4db4-9f96-ab4e9a17b7f5")), TinkarTerm.ENGLISH_LANGUAGE, "GB Dialect Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4577ee47-f68d-4b5b-a89e-d48333ba98f3")), TinkarTerm.ENGLISH_LANGUAGE, "GB Dialect Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5a7bbf87-20cf-4f40-a3cc-c8608b1f2b1a")), TinkarTerm.ENGLISH_LANGUAGE, "Particular form of language specific form of English language, particular to Great Britain.", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("59006b25-8452-473b-993b-2dbc255dba05")))
                ;

        set.pattern("Value Constraint Pattern", PublicIds.of(UUID.fromString("922697f7-36ba-4afc-9dd5-f29d54b0fdec"))).at(inception)
                .meaning(TinkarTerm.VALUE_CONSTRAINT).purpose(TinkarTerm.VALUE_CONSTRAINT).field(TinkarTerm.VALUE_CONSTRAINT_SOURCE, TinkarTerm.VALUE_CONSTRAINT_SOURCE, TinkarTerm.CONCEPT_FIELD).field(TinkarTerm.MINIMUM_VALUE_OPERATOR, TinkarTerm.CONCRETE_DOMAIN_OPERATOR, TinkarTerm.CONCEPT_FIELD).field(TinkarTerm.REFERENCE_RANGE_MINIMUM, TinkarTerm.REFERENCE_RANGE, TinkarTerm.FLOAT_FIELD).field(TinkarTerm.MAXIMUM_VALUE_OPERATOR, TinkarTerm.CONCRETE_DOMAIN_OPERATOR, TinkarTerm.COMPONENT_FIELD).field(TinkarTerm.REFERENCE_RANGE_MAXIMUM, TinkarTerm.REFERENCE_RANGE, TinkarTerm.FLOAT_FIELD).field(TinkarTerm.EXAMPLE_UCUM_UNITS, TinkarTerm.EXAMPLE_UCUM_UNITS, TinkarTerm.STRING)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("24babbc7-557f-4271-b29d-7ca31a338eea")), TinkarTerm.ENGLISH_LANGUAGE, "Value Constraint Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a4793cd2-937a-49ef-9aee-af3e5a64fa4c")), TinkarTerm.ENGLISH_LANGUAGE, "Value Constraint Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5bc300be-5c42-4ffb-9234-44883d1b62de")), TinkarTerm.ENGLISH_LANGUAGE, "A pattern specifying value constraint pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("90c93850-571a-4152-9350-6bab9f975478")))
                ;

        set.pattern("Path origins pattern (SOLOR)", PublicIds.of(UUID.fromString("70f89dd5-2cdb-59bb-bbaa-98527513547c"))).at(inception)
                .meaning(TinkarTerm.PATH_ORIGINS).purpose(TinkarTerm.PATH_ORIGINS).field(TinkarTerm.PATH_CONCEPT, TinkarTerm.PATH_CONCEPT, TinkarTerm.COMPONENT_FIELD).field(TinkarTerm.PATH_ORIGINS, TinkarTerm.PATH_ORIGINS, TinkarTerm.INSTANT_LITERAL)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("eb634a74-90cf-4193-9401-2b30880d5830")), TinkarTerm.ENGLISH_LANGUAGE, "Path origins pattern (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("68842268-30f1-40b9-8d83-c435eb9f08b9")), TinkarTerm.ENGLISH_LANGUAGE, "Path origins pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("21a97ee2-f4c8-4936-802a-044bf0231307")), TinkarTerm.ENGLISH_LANGUAGE, "Pattern of path origins", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c260acbc-f1c6-4dc7-921f-d62105e3dd7a")))
                ;

        set.pattern("Concept Version Pattern", PublicIds.of(UUID.fromString("7943a5f1-538b-4fda-8acb-019e0bec125b"))).at(inception)
                .meaning(EntityProxy.Concept.make("Concept versions field", PublicIds.of(UUID.fromString("3a08b5f1-f17e-4db5-8cf9-c6540f26f241")))).purpose(EntityProxy.Concept.make("Concept versions field", PublicIds.of(UUID.fromString("3a08b5f1-f17e-4db5-8cf9-c6540f26f241")))).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), TinkarTerm.COMPONENT_FIELD)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bc7364c4-6b2a-4a87-8f2b-1d08630f88e3")), TinkarTerm.ENGLISH_LANGUAGE, "Concept Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e8fe8178-68d5-4619-8a2c-1debbb1fbfdf")), TinkarTerm.ENGLISH_LANGUAGE, "Concept Version Pattern", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5731a032-945f-4ad1-8f97-a4b2314915c9")))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7eba42fd-7623-4734-abcd-4fc79fe0fbeb")))
                .semanticOn(PublicIds.of(UUID.fromString("e8fe8178-68d5-4619-8a2c-1debbb1fbfdf")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9ca7ec70-4245-4cd0-9280-4b193554cab1")), TinkarTerm.ACCEPTABLE)
                ;

    }
}
