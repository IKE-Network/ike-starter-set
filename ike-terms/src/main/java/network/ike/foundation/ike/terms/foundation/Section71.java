package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The root concept section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section71 {

    private Section71() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Boolean field", PublicIds.of(UUID.fromString("4229683e-8772-4936-abd5-edc5a180f4d1"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ecd6c008-6959-4a14-8e9e-750b3764537b")), KernelTerm.ENGLISH_LANGUAGE, "Boolean field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("6d0719cc-28f0-414d-8512-0c2b9cbe217c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field definition data type field", PublicIds.of(UUID.fromString("02273b53-fce7-4cbe-921d-2cff67e81ad5")))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5b5a4b60-13c0-5c2a-84cb-0798aea1afbc")))
                ;

        set.concept("STAMP versions set", PublicIds.of(UUID.fromString("edb90567-7822-4129-a406-b359b825f922"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5e1ce34f-77ec-46ef-8f15-1c292e77c008")), KernelTerm.ENGLISH_LANGUAGE, "STAMP versions set", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("0afed167-46a1-4470-99bf-2bd6d907f3c5")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions set", PublicIds.of(UUID.fromString("54d670f1-234d-485a-a354-e1fa7eea1bf2")))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("fcab1c2e-35c9-5879-9f56-40667f046b04")))
                ;

        set.concept("Data Property Set Axioms", PublicIds.of(UUID.fromString("1402d311-0b4b-4014-81d2-e715c6696346"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("01e7bccd-a632-46e5-ab25-9ce3b0ee3113")), KernelTerm.ENGLISH_LANGUAGE, "Data Property Set Axioms", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a6335d66-ec82-5fc1-8b86-d06926a3a2b7")))
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f7a7bcb6-afbe-4617-9a28-773907fd2a70")), KernelTerm.ENGLISH_LANGUAGE, "Data Property Set Axioms", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("e01e07cd-c205-4e9d-97db-2d61a115ae9d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS), leb.ConceptAxiom(KernelTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS))))
                ;

        set.concept("STAMP versions field", PublicIds.of(UUID.fromString("b8251bea-4248-4a46-8b4a-349500693a9f"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cb751cf0-8d3f-4357-9df8-b17928c4a85f")), KernelTerm.ENGLISH_LANGUAGE, "STAMP versions field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("0ee2cdc9-6cc0-40ac-91fd-de2b12c60aac")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions field", PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c")))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("af493b91-d6e7-5ae4-b1b9-6a36a6554c52")))
                ;

        set.concept("Status field", PublicIds.of(UUID.fromString("f2c79ebb-3095-44ea-831f-992aed48801f"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("63089ce4-4fd4-4d51-b0a1-1465434022c0")), KernelTerm.ENGLISH_LANGUAGE, "Status field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .definition("""
                        A concept field whose value is the status dimension of a STAMP — \
                        the version's state (active, inactive, or otherwise) at the time \
                        it was committed.""")
                .statedAxioms(PublicIds.of(UUID.fromString("a5c5ea2d-2d81-4275-ba18-ada4fb00448b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5de39a0b-0e4f-5d21-a97b-e9f454fea78a")))
                ;

        set.concept("Time field", PublicIds.of(UUID.fromString("15293325-c16b-4f2e-8109-5b22b3355bcd"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a3b04559-ed05-4eb9-bba1-35102d20d071")), KernelTerm.ENGLISH_LANGUAGE, "Time field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("e5a8de94-8552-4837-9f2c-217a0e815984")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Instant field", PublicIds.of(UUID.fromString("e9bde1bc-aa72-430a-afe1-aa8aec8833b4")))))))
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("35233caa-f648-4baf-a1d1-ec4c6f125ae4")), KernelTerm.ENGLISH_LANGUAGE, "Time field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("fac6a8f8-2d40-59db-9882-283aad90b647")))
                ;

        set.concept("Author field", PublicIds.of(UUID.fromString("a9210ad6-cc48-47df-86e5-2192d56704a6"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a2849246-87e7-4cf1-8d24-22f09678ed72")), KernelTerm.ENGLISH_LANGUAGE, "Author field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .definition("""
                        A concept field whose value is the author dimension of a STAMP — \
                        who committed the version.""")
                .statedAxioms(PublicIds.of(UUID.fromString("cc364868-eabe-4a93-8381-7bdf84bb3df6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c8de0a4f-4868-53b0-909d-a4603b997e13")))
                ;

        set.concept("Component versions field", PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9cf3da8a-5214-4e20-9c77-198d1a7445a8")), KernelTerm.ENGLISH_LANGUAGE, "Component versions field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("15d5da72-8e12-4345-8962-1d14f652834b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of(UUID.fromString("ed230c7c-20f9-470d-8566-5057f92748a5")))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8e135ad6-6a8b-56b8-810b-6b45fbedddde")))
                ;

        set.concept("Module field", PublicIds.of(UUID.fromString("e6359a86-a1df-4721-8a1a-1f1f075ec3d9"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1a3627bd-09ec-421c-9c37-1fc6fd07d82c")), KernelTerm.ENGLISH_LANGUAGE, "Module field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .definition("""
                        A concept field whose value is the module dimension of a STAMP — \
                        the module the version belongs to.""")
                .statedAxioms(PublicIds.of(UUID.fromString("90a4ace9-c128-435d-9060-79d8920e0bd8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("239dce52-c668-57a1-8316-b1c8bd276d0c")))
                ;

        set.concept("Default Data Concept", PublicIds.of(UUID.fromString("4a32d2ad-baca-42b5-a432-4c4ae6431668"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8bbc697e-f51a-40a0-8af9-396f3b040cdd")), KernelTerm.ENGLISH_LANGUAGE, "Default Data Concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of(UUID.fromString("8f607d4f-ef9e-48eb-bb3f-b5a2806cf34b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Data Concept", PublicIds.of(UUID.fromString("ae7069d1-67fa-4470-a56f-0d24a8fcea83")))))))
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("246e55f7-c359-42ce-ac5d-79fd4fb1f088")), KernelTerm.ENGLISH_LANGUAGE, "Default Data Concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bce173b8-a806-4a98-953b-6abad7090d11")), KernelTerm.ENGLISH_LANGUAGE, "Default Data FQN", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("32c891e1-5a78-4922-a166-06400d088dea")), KernelTerm.ENGLISH_LANGUAGE, "Default Data - Other Name", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Three upstream placeholder seeds (a GB-dialect semantic 17c5b61f-e121-4c54-9eb3-e106f3983417,
                // an identifier semantic 8b7b452c-6de1-47b8-81fb-2e4cf58ca213, and a US-dialect semantic
                // 92548331-a460-4bdb-aa32-7162f2fb4f0d, all carrying Blank Concept placeholders) are
                // deliberately not adopted here — pre-bronze editorial: the starter set is pre-release,
                // so erroneous seeds are simply never created (Refs: IKE-Network/ike-issues#887).
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("bfa087e5-5e6e-5032-b204-03b22b931672")))
                ;

        set.concept("Data Concept", PublicIds.of(UUID.fromString("ae7069d1-67fa-4470-a56f-0d24a8fcea83"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("871e69f3-e844-4342-b56f-a22188feb129")), KernelTerm.ENGLISH_LANGUAGE, "Data Concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .definition("""
                        Groups concepts that represent data values and defaults — the \
                        data-carrying side of the model, as distinct from IKE base model \
                        concept's structural, self-descriptive side.""")
                .statedAxioms(PublicIds.of(UUID.fromString("137221ba-47a9-442a-a62a-dcdd20a0d50e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Model concept (SOLOR)", PublicIds.of("7bbd4210-381c-11e7-9598-0800200c9a66"))))))
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("515bf9ec-954d-42d8-a5e7-727e05b51602")), KernelTerm.ENGLISH_LANGUAGE, "Data Concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ac8d42ee-be33-5254-833c-cb6f688ba7f3")))
                ;

        // Shape diverges from the SOLOR baseline: purpose modernized to Set membership in place
        // (IKE-Network/ike-issues#880, #894).
        // Declared FQN diverges from the baseline artifact (was "Tinkar base model component
        // pattern"): the base model is IKE's; registered in DELIBERATELY_RENAMED_FQNS
        // (IKE-Network/ike-issues#1124).
        set.pattern("IKE base model component pattern", PublicIds.of(UUID.fromString("6070f6f5-893d-5144-adce-7d305c391cf9"))).at(inception)
                .meaning(EntityProxy.Concept.make("Starter Data Authoring (SOLOR)", PublicIds.of("070deb74-acc5-46bf-b9c6-eaee1b58ef52"))).purpose(set.conceptRef("Set membership (IkeFoundation)"))
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("29922b82-0026-4fe1-9a3f-c81563b7ff94")), KernelTerm.ENGLISH_LANGUAGE, "IKE base model component pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0711a763-56f7-4dcf-b4c2-77bfc514f3dc")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Description Pattern", PublicIds.of(UUID.fromString("a4de0039-2625-5842-8a4c-d1ce6aebf021"))).at(inception)
                .meaning(EntityProxy.Concept.make("Description semantic (SOLOR)", PublicIds.of("81487d5f-6115-51e2-a3b3-93d783888eb8"))).purpose(set.conceptRef("Description Attachment (IkeFoundation)")).field(KernelTerm.LANGUAGE_CONCEPT_NID_FOR_DESCRIPTION, KernelTerm.LANGUAGE, KernelTerm.COMPONENT_FIELD).field(KernelTerm.TEXT_FOR_DESCRIPTION, EntityProxy.Concept.make("Description (SOLOR)", PublicIds.of("87118daf-d28c-55fb-8657-cd6bc8425600")), KernelTerm.STRING).field(KernelTerm.DESCRIPTION_CASE_SIGNIFICANCE, set.conceptRef("Case Sensitivity Rule (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(KernelTerm.DESCRIPTION_TYPE, set.conceptRef("Description Role (IkeFoundation)"), KernelTerm.COMPONENT_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2aaa8391-e4fe-4ce1-b574-25967bdcd3c8")), KernelTerm.ENGLISH_LANGUAGE, "Description Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3142a96a-5ff8-4b08-98a9-0cf19ddc9345")), KernelTerm.ENGLISH_LANGUAGE, "Description Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("361dad43-0903-4065-9067-a2e65a44ddc7")), KernelTerm.ENGLISH_LANGUAGE, "Contains all metadata and human readable text that describes the concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1f9f73e4-554b-406c-92bc-2092865a0ca4")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Concept field pattern", PublicIds.of(UUID.fromString("3e510cb9-1666-4676-9334-d288a56bf155"))).at(inception)
                .meaning(EntityProxy.Concept.make("Concept field", PublicIds.of(UUID.fromString("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")))).purpose(set.conceptRef("Chronicle Identity and History (IkeFoundation)")).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Concept versions field", PublicIds.of(UUID.fromString("3a08b5f1-f17e-4db5-8cf9-c6540f26f241"))), EntityProxy.Concept.make("Concept versions set", PublicIds.of(UUID.fromString("806c7f9f-52f9-4b53-9758-122899b28a76"))), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1cb3e89f-96de-4fc5-8205-5eecaede0c15")), KernelTerm.ENGLISH_LANGUAGE, "Concept field pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("59e042f1-45ef-421f-bd14-77020233e576")), KernelTerm.ENGLISH_LANGUAGE, "Concept Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b112545c-6e2c-4340-81b6-a27801412f49")), KernelTerm.ENGLISH_LANGUAGE, "Concept Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("41886644-3879-41d1-b32e-ff281066b746")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5871819d-2af0-4a4b-9d9e-757951c73e7e")))
                .semanticOn(PublicIds.of(UUID.fromString("b112545c-6e2c-4340-81b6-a27801412f49")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6e242243-5509-432f-aa29-71e02104a4c9")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Semantic Chronology Pattern", PublicIds.of(UUID.fromString("5f0ad6ca-638e-4052-82b0-3f564ac99b3f"))).at(inception)
                .meaning(EntityProxy.Concept.make("Semantic field", PublicIds.of(UUID.fromString("8b6c69d7-a5aa-4db2-bcea-8c7b2817b02f")))).purpose(set.conceptRef("Chronicle Identity and History (IkeFoundation)")).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Semantic pattern field", PublicIds.of(UUID.fromString("19dd5dd3-1075-4113-a437-5f1f7c2d55bc"))), set.conceptRef("Pattern Membership (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Semantic referenced component field", PublicIds.of(UUID.fromString("4111ba1e-c818-4c5d-9fed-34d07298d009"))), set.conceptRef("Attachment Target (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Semantic versions set", PublicIds.of(UUID.fromString("4fd69aed-556f-4938-94cc-ea7ea707ccef"))), set.conceptRef("Version History (IkeFoundation)"), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("af8495f1-a122-4358-a214-a7af58b87ffd")), KernelTerm.ENGLISH_LANGUAGE, "Semantic Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e84623f1-c991-4998-ad86-8623248bcdd4")), KernelTerm.ENGLISH_LANGUAGE, "Semantic Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7cdd578f-ee8c-43d6-9cec-3311c494e78e")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("cdd3fe9d-90f0-44cb-b135-67d06a885ce1")))
                .semanticOn(PublicIds.of(UUID.fromString("e84623f1-c991-4998-ad86-8623248bcdd4")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("77e86eec-0532-4f35-a5db-df2974a77bcf")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("STAMP version field pattern", PublicIds.of(UUID.fromString("73c798cf-bc77-49a2-84f7-4c0f4bc4c012"))).at(inception)
                .meaning(EntityProxy.Concept.make("STAMP versions field", PublicIds.of(UUID.fromString("b8251bea-4248-4a46-8b4a-349500693a9f")))).purpose(set.conceptRef("Version Snapshot (IkeFoundation)")).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), set.conceptRef("Version Provenance (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Status field", PublicIds.of(UUID.fromString("f2c79ebb-3095-44ea-831f-992aed48801f"))), EntityProxy.Concept.make("Status for version (SOLOR)", PublicIds.of("0608e233-d79d-5076-985b-9b1ea4e14b4c")), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Time field", PublicIds.of(UUID.fromString("15293325-c16b-4f2e-8109-5b22b3355bcd"))), KernelTerm.TIME_FOR_VERSION, KernelTerm.STRING).field(EntityProxy.Concept.make("Author field", PublicIds.of(UUID.fromString("a9210ad6-cc48-47df-86e5-2192d56704a6"))), KernelTerm.AUTHOR_FOR_VERSION, KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Module field", PublicIds.of(UUID.fromString("e6359a86-a1df-4721-8a1a-1f1f075ec3d9"))), EntityProxy.Concept.make("Module for version (SOLOR)", PublicIds.of("67cd64f1-96d7-5110-b847-556c055ac063")), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Path field", PublicIds.of(UUID.fromString("6622a391-e2e6-45a0-97e1-c58cd0184092"))), EntityProxy.Concept.make("Path for version (SOLOR)", PublicIds.of("ad3dd2dd-ddb0-584c-bea4-c6d9b91d461f")), KernelTerm.COMPONENT_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fb0560ed-91a0-47d4-ae4f-b5294710d0d5")), KernelTerm.ENGLISH_LANGUAGE, "STAMP version field pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("35b4a268-6aa1-40bf-8a5d-2da53cc945e5")), KernelTerm.ENGLISH_LANGUAGE, "STAMP Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("efb979c4-19fe-4503-8393-26f543e4a86a")))
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("68a1db90-d8bf-478b-bb45-48ee01be6870")), KernelTerm.ENGLISH_LANGUAGE, "STAMP Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6b3b5585-14a9-4416-bb66-1c685dfe4686")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("91153646-f74a-439a-b4e5-1d95c521fdb8")))
                .semanticOn(PublicIds.of(UUID.fromString("68a1db90-d8bf-478b-bb45-48ee01be6870")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ff202c86-6b7b-4d03-bf73-2e8612e9dd19")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Component Chronology Pattern", PublicIds.of(UUID.fromString("c48db76d-5eb0-4ff5-84d0-5c3c4ec77767"))).at(inception)
                .meaning(EntityProxy.Concept.make("Component field", PublicIds.of(UUID.fromString("8bd36a0c-d05d-46b7-a79a-d11477705cc1")))).purpose(set.conceptRef("Chronicle Identity and History (IkeFoundation)")).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Component versions field", PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c"))), EntityProxy.Concept.make("Component versions set", PublicIds.of(UUID.fromString("54d670f1-234d-485a-a354-e1fa7eea1bf2"))), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0c46590f-ad05-4ca1-b61a-869b5e93ba10")), KernelTerm.ENGLISH_LANGUAGE, "Component Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("603ff6ab-4960-4bc0-bb5a-d9602860c1fe")), KernelTerm.ENGLISH_LANGUAGE, "Component Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1cdc6348-d59e-4120-b488-a11d8c308bf1")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9e81b610-7620-4faa-a845-a694e122a3dd")))
                .semanticOn(PublicIds.of(UUID.fromString("603ff6ab-4960-4bc0-bb5a-d9602860c1fe")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("973cce36-dc82-4f12-8197-5ec2714baac1")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Module origins pattern (SOLOR)", PublicIds.of(UUID.fromString("536b0ec4-4974-47ae-93a6-ae6c4d169780"))).at(inception)
                .meaning(set.conceptRef("Originated Module (IkeFoundation)")).purpose(set.conceptRef("Module Lineage (IkeFoundation)")).field(EntityProxy.Concept.make("Module origins (SOLOR)", PublicIds.of("462862d4-5df9-426e-b785-a1264e24769f")), set.conceptRef("Origin Module Set (IkeFoundation)"), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4a584a9a-b38d-4173-85c4-66658aa84cab")), KernelTerm.ENGLISH_LANGUAGE, "Module origins pattern (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5535793d-49e3-4e40-954e-dc7d80a8660d")), KernelTerm.ENGLISH_LANGUAGE, "Module origins pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dc8ea392-f203-4a34-ba8e-20b524404fcc")), KernelTerm.ENGLISH_LANGUAGE, "Pattern of module origins", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4fb597d3-2c22-475c-8535-878896f91683")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Identifier Pattern", PublicIds.of(UUID.fromString("5d60e14b-c410-5172-9559-3c4253278ae2"))).at(inception)
                .meaning(set.conceptRef("Identified Component (IkeFoundation)")).purpose(set.conceptRef("External Identity Mapping (IkeFoundation)")).field(KernelTerm.IDENTIFIER_SOURCE, set.conceptRef("Identifier Authority (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(KernelTerm.IDENTIFIER_VALUE, set.conceptRef("Identifier Text (IkeFoundation)"), KernelTerm.STRING)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f671a8b2-35d8-49d1-bacc-2aca84efe434")), KernelTerm.ENGLISH_LANGUAGE, "Identifier Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("31c54b87-1ed0-444f-b395-ad1da8692f81")), KernelTerm.ENGLISH_LANGUAGE, "Identifier Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6cb677cb-6c26-4d45-935c-840ccb0fcb79")), KernelTerm.ENGLISH_LANGUAGE, "An identifier pattern is used to identity a concept which contains the identifier source and the actual value.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e96cccb9-690e-479a-bfd7-449e434b2fc2")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Inferred Navigation Pattern", PublicIds.of(UUID.fromString("a53cc42d-c07e-5934-96b3-2ede3264474e"))).at(inception)
                .meaning(EntityProxy.Concept.make("Is-a (SOLOR)", PublicIds.of("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25", "46bccdc4-8fb6-11db-b606-0800200c9a66"))).purpose(set.conceptRef("Taxonomy Navigation Cache (IkeFoundation)")).field(KernelTerm.RELATIONSHIP_DESTINATION, EntityProxy.Concept.make("Is-a (SOLOR)", PublicIds.of("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25", "46bccdc4-8fb6-11db-b606-0800200c9a66")), KernelTerm.COMPONENT_ID_SET_FIELD).field(KernelTerm.RELATIONSHIP_ORIGIN, EntityProxy.Concept.make("Is-a (SOLOR)", PublicIds.of("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25", "46bccdc4-8fb6-11db-b606-0800200c9a66")), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("47656bb5-76dc-497f-bdc6-b612abeaf45b")), KernelTerm.ENGLISH_LANGUAGE, "Inferred Navigation Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9992ca7b-8bcf-4ba8-b194-5623eb2a0bed")), KernelTerm.ENGLISH_LANGUAGE, "Inferred Navigation Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5b55743d-2f1d-4f6e-ba06-ac9d8d1d2dfa")), KernelTerm.ENGLISH_LANGUAGE, "A pattern specifying the origins and destinations for concepts based on the inferred terminological axioms.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0e710d55-ae62-44e1-8d92-06966b6a282c")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Stated Navigation Pattern", PublicIds.of(UUID.fromString("d02957d6-132d-5b3c-adba-505f5778d998"))).at(inception)
                .meaning(EntityProxy.Concept.make("Is-a (SOLOR)", PublicIds.of("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25", "46bccdc4-8fb6-11db-b606-0800200c9a66"))).purpose(set.conceptRef("Taxonomy Navigation Cache (IkeFoundation)")).field(KernelTerm.RELATIONSHIP_DESTINATION, EntityProxy.Concept.make("Is-a (SOLOR)", PublicIds.of("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25", "46bccdc4-8fb6-11db-b606-0800200c9a66")), KernelTerm.COMPONENT_ID_SET_FIELD).field(KernelTerm.RELATIONSHIP_ORIGIN, EntityProxy.Concept.make("Is-a (SOLOR)", PublicIds.of("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25", "46bccdc4-8fb6-11db-b606-0800200c9a66")), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ef541837-419f-4477-9dd9-b037ba5f7470")), KernelTerm.ENGLISH_LANGUAGE, "Stated Navigation Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e95fcc4a-638f-401d-8027-44ebb1bee7ee")), KernelTerm.ENGLISH_LANGUAGE, "Stated Navigation Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f344e858-a5e4-4cf3-8fa8-8d50bdd4dd9f")), KernelTerm.ENGLISH_LANGUAGE, "A pattern specifying the origins and destinations for concepts based on the stated terminological axioms.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("64eda4d2-76c4-4176-83d1-f3719551cc9d")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Pattern Version Pattern", PublicIds.of(UUID.fromString("a90f8a4d-ae13-476b-98b8-814914f9704e"))).at(inception)
                .meaning(EntityProxy.Concept.make("Pattern versions field", PublicIds.of(UUID.fromString("7b8ecbbf-55b4-41bc-acbf-51824e74446a")))).purpose(set.conceptRef("Version Snapshot (IkeFoundation)")).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), set.conceptRef("Version Provenance (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Pattern meaning field", PublicIds.of(UUID.fromString("996d0023-a355-422f-a84d-16dda6ece1b0"))), set.conceptRef("Meaning Declaration (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Pattern purpose field", PublicIds.of(UUID.fromString("352c821b-7a11-454c-a127-48ad3206573d"))), set.conceptRef("Purpose Declaration (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Field definition field", PublicIds.of(UUID.fromString("14171f07-e74f-409a-b555-06b478818f76"))), EntityProxy.Concept.make("Field definitions set", PublicIds.of(UUID.fromString("975de83e-ab99-4a9e-9051-4cbf310a2123"))), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5bcd6ba3-de15-4f7c-978d-0d4cf6cbe23f")), KernelTerm.ENGLISH_LANGUAGE, "Pattern Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1e3baacc-aa99-490b-a6bb-2b83e819f7ae")), KernelTerm.ENGLISH_LANGUAGE, "Pattern Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d0ce915d-a121-4a3c-9f07-dd198bbbfe0f")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a98f1d31-86e1-48d6-bda8-048dd626c152")))
                .semanticOn(PublicIds.of(UUID.fromString("1e3baacc-aa99-490b-a6bb-2b83e819f7ae")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4fcb49f2-2ed7-4665-b7c7-fc6d6877d78a")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("STAMP Chronology Pattern", PublicIds.of(UUID.fromString("e16abc7a-2a7b-42af-b168-d77aec8116ea"))).at(inception)
                .meaning(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6")))).purpose(set.conceptRef("Chronicle Identity and History (IkeFoundation)")).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("STAMP versions field", PublicIds.of(UUID.fromString("b8251bea-4248-4a46-8b4a-349500693a9f"))), EntityProxy.Concept.make("STAMP versions set", PublicIds.of(UUID.fromString("edb90567-7822-4129-a406-b359b825f922"))), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8183b8f7-b9b5-4de2-a103-b7ced1a37188")), KernelTerm.ENGLISH_LANGUAGE, "STAMP Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1d4b2d6e-c003-456c-8c58-b8cdff3f4b4f")), KernelTerm.ENGLISH_LANGUAGE, "STAMP Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("44918826-bf99-4725-9731-306cf3d54437")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5bb51d01-4d23-4f57-b2d6-8d463a008d39")))
                .semanticOn(PublicIds.of(UUID.fromString("1d4b2d6e-c003-456c-8c58-b8cdff3f4b4f")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("70297491-52ac-443f-a9a4-c6e13b95285e")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

        set.pattern("EL++ Stated Axioms Pattern", PublicIds.of(UUID.fromString("e813eb92-7d07-5035-8d43-e81249f5b36e"))).at(inception)
                .meaning(EntityProxy.Concept.make("Stated Definition", PublicIds.of("28608bd3-ac73-4fe8-a5f0-1efe0d6650a8"))).purpose(EntityProxy.Concept.make("Logical Definition (SOLOR)", PublicIds.of("7dccd042-b0b8-5cec-a1bc-6de676b92f4b"))).field(KernelTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS, EntityProxy.Concept.make("Logical Definition (SOLOR)", PublicIds.of("7dccd042-b0b8-5cec-a1bc-6de676b92f4b")), KernelTerm.DITREE_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e16fee31-d619-4646-9a52-d16ebea5106e")), KernelTerm.ENGLISH_LANGUAGE, "EL++ Stated Axioms Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("194f2b92-7736-4301-9e03-14fb5d9cb13a")), KernelTerm.ENGLISH_LANGUAGE, "Stated definition pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1ce1bcdf-7527-4f8e-9406-611b9c84ed69")))
                ;

        // Shape diverges from the SOLOR baseline: purpose modernized to Set membership in place
        // (IKE-Network/ike-issues#880, #894).
        set.pattern("Version control path pattern", PublicIds.of(UUID.fromString("add1db57-72fe-53c8-a528-1614bda20ec6"))).at(inception)
                .meaning(EntityProxy.Concept.make("Path (SOLOR)", PublicIds.of("4459d8cf-5a6f-3952-9458-6d64324b27b7"))).purpose(set.conceptRef("Set membership (IkeFoundation)"))
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e0647541-c6e4-4be9-9e0a-c66ed712c48e")), KernelTerm.ENGLISH_LANGUAGE, "Version control path pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("84b52fdd-1a1c-4cea-b8a8-6c0d48522d4d")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Comment pattern", PublicIds.of(UUID.fromString("3734fb0a-4c14-5831-9a61-4743af609e7a"))).at(inception)
                .meaning(set.conceptRef("Subject of Commentary (IkeFoundation)")).purpose(set.conceptRef("Editorial Clarification (IkeFoundation)")).field(EntityProxy.Concept.make("Comment (SOLOR)", PublicIds.of("147832d4-b9b8-5062-8891-19f9c4e4760a")), set.conceptRef("Editorial Clarification (IkeFoundation)"), KernelTerm.STRING)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8e565bae-7a22-402e-bdbf-8f5ded827718")), KernelTerm.ENGLISH_LANGUAGE, "Comment pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("723a2333-a9e4-43f7-928f-db76d2f96bd8")), KernelTerm.ENGLISH_LANGUAGE, "Comment Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1934fc0e-b2d0-4464-9967-9a5698db0f26")))
                ;

        set.pattern("EL++ Inferred Axioms Pattern", PublicIds.of(UUID.fromString("9f011812-15c9-5b1b-85f8-bb262bc1b2a2"))).at(inception)
                .meaning(EntityProxy.Concept.make("Inferred Definition", PublicIds.of("b1abf4dc-9838-4b46-ac55-10c4f92ba10b"))).purpose(EntityProxy.Concept.make("Logical Definition (SOLOR)", PublicIds.of("7dccd042-b0b8-5cec-a1bc-6de676b92f4b"))).field(KernelTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS, EntityProxy.Concept.make("Logical Definition (SOLOR)", PublicIds.of("7dccd042-b0b8-5cec-a1bc-6de676b92f4b")), KernelTerm.DITREE_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fbfc2edd-7ddf-41f3-9c72-c583f0d10c2f")), KernelTerm.ENGLISH_LANGUAGE, "EL++ Inferred Axioms Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7b08e8f0-6879-4ef9-aa7c-c75ccda25b21")), KernelTerm.ENGLISH_LANGUAGE, "Inferred definition pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a23311f2-3b36-419f-9086-80c5dceecae6")))
                ;

        set.pattern("SOLOR concept assemblage (SOLOR)", PublicIds.of(UUID.fromString("d39b3ecd-9a80-5009-a8ac-0b947f95ca7c"))).at(inception)
                .meaning(EntityProxy.Concept.make("Concept assemblage for logic coordinate (SOLOR)", PublicIds.of("16486419-5d1c-574f-bde6-21910ad66f44"))).purpose(EntityProxy.Concept.make("Membership semantic (SOLOR)", PublicIds.of("4fa29287-a80e-5f83-abab-4b587973e7b7")))
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6783af77-56e5-4bda-b11e-f980fa89b224")), KernelTerm.ENGLISH_LANGUAGE, "SOLOR concept assemblage (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("75dcfa58-6cb9-4f5a-9355-2cf161453d57")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("OWL Axiom Syntax Pattern", PublicIds.of(UUID.fromString("c0ca180b-aae2-5fa1-9ab7-4a24f2dfe16b"))).at(inception)
                .meaning(set.conceptRef("Axiomatized Component (IkeFoundation)")).purpose(set.conceptRef("Axiom Expression (IkeFoundation)")).field(KernelTerm.AXIOM_SYNTAX, EntityProxy.Concept.make("Express axiom syntax (SOLOR)", PublicIds.of("db55557c-e9ee-4504-aae3-df695b6d6c57")), KernelTerm.STRING)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ecf5c52f-957c-4164-8721-95477acbcefc")), KernelTerm.ENGLISH_LANGUAGE, "OWL Axiom Syntax Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("97388687-b390-4d89-be6e-8c84a1244e56")))
                ;

        set.pattern("US Dialect Pattern", PublicIds.of(UUID.fromString("08f9112c-c041-56d3-b89b-63258f070074"))).at(inception)
                .meaning(KernelTerm.DESCRIPTION_ACCEPTABILITY).purpose(EntityProxy.Concept.make("Description semantic (SOLOR)", PublicIds.of("81487d5f-6115-51e2-a3b3-93d783888eb8"))).field(EntityProxy.Concept.make("US English dialect (SOLOR)", PublicIds.of("bca0a686-3516-3daf-8fcf-fe396d13cfad")), KernelTerm.DESCRIPTION_ACCEPTABILITY, KernelTerm.COMPONENT_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("413469a3-a340-4a55-8074-b44029765f93")), KernelTerm.ENGLISH_LANGUAGE, "US Dialect Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .definition("""
                        Records whether a description is preferred or acceptable in the \
                        United States English dialect — one field, that description's \
                        acceptability for this dialect.""")
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3fe6d66f-bcad-4859-b513-68f924143f1f")), KernelTerm.ENGLISH_LANGUAGE, "US Dialect Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("21b12d41-1083-4fd5-95ea-1aea8edf868f")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Pattern Chronology Pattern", PublicIds.of(UUID.fromString("5bc93adb-9d39-43fe-a7a4-1492245b7efb"))).at(inception)
                .meaning(EntityProxy.Concept.make("Pattern field", PublicIds.of(UUID.fromString("751790c7-e1e4-42bc-b531-54c54bd6eebd")))).purpose(set.conceptRef("Chronicle Identity and History (IkeFoundation)")).field(EntityProxy.Concept.make("Public ID field", PublicIds.of(UUID.fromString("196838c5-55f4-4e40-8618-b9ce60685c2f"))), EntityProxy.Concept.make("Uniquely identify knowledge graph components", PublicIds.of(UUID.fromString("dde9a93d-250c-449b-bea0-ba1133d1387b"))), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Pattern versions field", PublicIds.of(UUID.fromString("7b8ecbbf-55b4-41bc-acbf-51824e74446a"))), EntityProxy.Concept.make("Pattern versions set", PublicIds.of(UUID.fromString("a254ccee-ef02-4504-9645-0a2ed7af955d"))), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("28a31a01-d0b8-4d3f-b05b-503249b7f0ff")), KernelTerm.ENGLISH_LANGUAGE, "Pattern Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c004d891-8c23-487c-a066-f0842483303f")), KernelTerm.ENGLISH_LANGUAGE, "Pattern Chronology Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f91d93a4-2f5d-4913-9ef8-85fd5194d0a7")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d4cc73e7-fea9-44a0-be8e-91fa51fc78cf")))
                .semanticOn(PublicIds.of(UUID.fromString("c004d891-8c23-487c-a066-f0842483303f")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c97ec6b6-559d-4e3b-a063-602379d2cefa")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Component Version Pattern", PublicIds.of(UUID.fromString("a38b7d2d-8fa5-4206-9185-a1af9f81be2c"))).at(inception)
                .meaning(EntityProxy.Concept.make("Component versions field", PublicIds.of(UUID.fromString("1a852426-422a-48db-a618-c906ac4c8e6c")))).purpose(set.conceptRef("Version Snapshot (IkeFoundation)")).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), set.conceptRef("Version Provenance (IkeFoundation)"), KernelTerm.COMPONENT_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d8593553-14ad-4ff2-9287-e3846dd03f67")), KernelTerm.ENGLISH_LANGUAGE, "Component Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7ab5c487-7441-45d1-9f3b-e17e06f0b862")), KernelTerm.ENGLISH_LANGUAGE, "Component Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e113fc68-13ee-4cda-b833-2560faee6083")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("774e9825-9844-45cd-856e-6a38f4491d9c")))
                .semanticOn(PublicIds.of(UUID.fromString("7ab5c487-7441-45d1-9f3b-e17e06f0b862")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0b4d72a8-e8bf-43bd-9cfe-4f211af2f174")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #894), and the declared FQN diverges from the baseline
        // artifact (was "Sementic version field pattern" — inherited typo, IKE-Network/ike-issues#892,
        // #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.pattern("Semantic version field pattern", PublicIds.of(UUID.fromString("82f93e84-cee1-44bc-bb6d-4cc2a722048b"))).at(inception)
                .meaning(EntityProxy.Concept.make("Semantic versions field", PublicIds.of(UUID.fromString("aeb73410-a679-4ea8-93fe-7c4785599778")))).purpose(set.conceptRef("Version Snapshot (IkeFoundation)")).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), set.conceptRef("Version Provenance (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Semantic field field", PublicIds.of(UUID.fromString("f6572c76-b5c0-41da-99c0-4344694e7e3c"))), EntityProxy.Concept.make("Semantic field fields set", PublicIds.of(UUID.fromString("8dcfc1a1-31f2-46f7-8247-0a17a6d7c6c0"))), KernelTerm.COMPONENT_ID_SET_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d47fdb46-8ce0-4405-943a-b2420c7480f8")), KernelTerm.ENGLISH_LANGUAGE, "Semantic version field pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2caeaa6d-865c-4e61-8d48-c003487ee067")), KernelTerm.ENGLISH_LANGUAGE, "Semantic version field pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("515a0b47-f8d8-4a42-922a-20454a1c006b")), KernelTerm.ENGLISH_LANGUAGE, "Semantic Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("06418dca-6423-423e-ae9d-d9adeaac4c66")), KernelTerm.ENGLISH_LANGUAGE, "Semantic Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4a062843-1c52-4bf6-95a6-fef885ed8906")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("be55e51f-c9ac-4151-8bf9-bd82179bd4b9")))
                .semanticOn(PublicIds.of(UUID.fromString("06418dca-6423-423e-ae9d-d9adeaac4c66")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0119c1c6-2bc9-442f-b729-d5be78fd1083")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

        // Shape diverges from the SOLOR baseline: purpose modernized to Set membership in place
        // (IKE-Network/ike-issues#880, #894).
        set.pattern("Komet base model component pattern", PublicIds.of(UUID.fromString("bbbbf1fe-00f0-55e0-a19c-6300dbaab9b2"))).at(inception)
                .meaning(EntityProxy.Concept.make("Starter Data Authoring (SOLOR)", PublicIds.of("070deb74-acc5-46bf-b9c6-eaee1b58ef52"))).purpose(set.conceptRef("Set membership (IkeFoundation)"))
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d9c64ddb-5898-454e-be56-cab97d5dacef")), KernelTerm.ENGLISH_LANGUAGE, "Komet base model component pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.KOMET_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("542c82b0-8413-4452-8891-4d9b145eaaf4")))
                ;

        set.pattern("GB Dialect Pattern", PublicIds.of(UUID.fromString("561f817a-130e-5e56-984d-910e9991558c"))).at(inception)
                .meaning(KernelTerm.DESCRIPTION_ACCEPTABILITY).purpose(EntityProxy.Concept.make("Description semantic (SOLOR)", PublicIds.of("81487d5f-6115-51e2-a3b3-93d783888eb8"))).field(EntityProxy.Concept.make("GB English dialect (SOLOR)", PublicIds.of("eb9a5e42-3cba-356d-b623-3ed472e20b30")), KernelTerm.DESCRIPTION_ACCEPTABILITY, KernelTerm.COMPONENT_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("243fa7ea-ad48-4db4-9f96-ab4e9a17b7f5")), KernelTerm.ENGLISH_LANGUAGE, "GB Dialect Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4577ee47-f68d-4b5b-a89e-d48333ba98f3")), KernelTerm.ENGLISH_LANGUAGE, "GB Dialect Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5a7bbf87-20cf-4f40-a3cc-c8608b1f2b1a")), KernelTerm.ENGLISH_LANGUAGE, "Particular form of language specific form of English language, particular to Great Britain.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("59006b25-8452-473b-993b-2dbc255dba05")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Value Constraint Pattern", PublicIds.of(UUID.fromString("922697f7-36ba-4afc-9dd5-f29d54b0fdec"))).at(inception)
                .meaning(EntityProxy.Concept.make("Value Constraint", PublicIds.of("8c55fb86-92d8-42a9-ad70-1e23abbf7eec"))).purpose(set.conceptRef("Numeric Value Restriction (IkeFoundation)")).field(EntityProxy.Concept.make("Value Constraint Source", PublicIds.of("09aa031a-6290-4ec9-a44c-23928a767da3")), set.conceptRef("Reference Range Authority (IkeFoundation)"), KernelTerm.CONCEPT_FIELD).field(EntityProxy.Concept.make("Minimum Value Operator", PublicIds.of("ded98e42-f74a-4432-9ae7-01b94dc2fdea")), KernelTerm.CONCRETE_DOMAIN_OPERATOR, KernelTerm.CONCEPT_FIELD).field(EntityProxy.Concept.make("Reference Range Minimum", PublicIds.of("37c35a88-9e27-42ca-b626-186773c4b612")), EntityProxy.Concept.make("Reference Range", PublicIds.of("87ce975b-309b-47f4-a6c6-4ae6df6649a1")), KernelTerm.FLOAT_FIELD).field(EntityProxy.Concept.make("Maximum Value Operator", PublicIds.of("7b8916ab-fd50-41df-8fc2-0b2a7a78be6d")), KernelTerm.CONCRETE_DOMAIN_OPERATOR, KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Reference Range Maximum", PublicIds.of("72d58983-b1e1-4ca9-833f-0e40c1defd39")), EntityProxy.Concept.make("Reference Range", PublicIds.of("87ce975b-309b-47f4-a6c6-4ae6df6649a1")), KernelTerm.FLOAT_FIELD).field(EntityProxy.Concept.make("Example UCUM Units", PublicIds.of("80cd4978-314d-46e3-bc13-9980280ae955")), set.conceptRef("Unit Example (IkeFoundation)"), KernelTerm.STRING)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("24babbc7-557f-4271-b29d-7ca31a338eea")), KernelTerm.ENGLISH_LANGUAGE, "Value Constraint Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a4793cd2-937a-49ef-9aee-af3e5a64fa4c")), KernelTerm.ENGLISH_LANGUAGE, "Value Constraint Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5bc300be-5c42-4ffb-9234-44883d1b62de")), KernelTerm.ENGLISH_LANGUAGE, "A pattern specifying value constraint pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("90c93850-571a-4152-9350-6bab9f975478")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Path origins pattern (SOLOR)", PublicIds.of(UUID.fromString("70f89dd5-2cdb-59bb-bbaa-98527513547c"))).at(inception)
                .meaning(set.conceptRef("Originated Path (IkeFoundation)")).purpose(set.conceptRef("Path Lineage (IkeFoundation)")).field(EntityProxy.Concept.make("Path concept (SOLOR)", PublicIds.of("1b9d9f95-fc0a-55ac-b2e6-7c8b37660046")), set.conceptRef("Branch Source (IkeFoundation)"), KernelTerm.COMPONENT_FIELD).field(EntityProxy.Concept.make("Path origins (SOLOR)", PublicIds.of("6e6a112e-7d8c-53c7-aaf1-c46e2d69743c")), set.conceptRef("Branch Point (IkeFoundation)"), KernelTerm.INSTANT_LITERAL)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("eb634a74-90cf-4193-9401-2b30880d5830")), KernelTerm.ENGLISH_LANGUAGE, "Path origins pattern (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("68842268-30f1-40b9-8d83-c435eb9f08b9")), KernelTerm.ENGLISH_LANGUAGE, "Path origins pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("21a97ee2-f4c8-4936-802a-044bf0231307")), KernelTerm.ENGLISH_LANGUAGE, "Pattern of path origins", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c260acbc-f1c6-4dc7-921f-d62105e3dd7a")))
                ;

        // Shape diverges from the SOLOR baseline: meaning/purpose rigor revised in place
        // (IKE-Network/ike-issues#880, #891, #894).
        set.pattern("Concept Version Pattern", PublicIds.of(UUID.fromString("7943a5f1-538b-4fda-8acb-019e0bec125b"))).at(inception)
                .meaning(EntityProxy.Concept.make("Concept versions field", PublicIds.of(UUID.fromString("3a08b5f1-f17e-4db5-8cf9-c6540f26f241")))).purpose(set.conceptRef("Version Snapshot (IkeFoundation)")).field(EntityProxy.Concept.make("STAMP field", PublicIds.of(UUID.fromString("3d821e64-a2ee-4414-8949-1bc92ef5d5b6"))), set.conceptRef("Version Provenance (IkeFoundation)"), KernelTerm.COMPONENT_FIELD)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bc7364c4-6b2a-4a87-8f2b-1d08630f88e3")), KernelTerm.ENGLISH_LANGUAGE, "Concept Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e8fe8178-68d5-4619-8a2c-1debbb1fbfdf")), KernelTerm.ENGLISH_LANGUAGE, "Concept Version Pattern", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5731a032-945f-4ad1-8f97-a4b2314915c9")))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7eba42fd-7623-4734-abcd-4fc79fe0fbeb")))
                .semanticOn(PublicIds.of(UUID.fromString("e8fe8178-68d5-4619-8a2c-1debbb1fbfdf")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9ca7ec70-4245-4cd0-9280-4b193554cab1")), EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")))
                ;

    }
}
