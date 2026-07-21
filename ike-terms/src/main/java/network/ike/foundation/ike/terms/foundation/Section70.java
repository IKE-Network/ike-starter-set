package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Tinkar root concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section70 {

    private Section70() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Interval role", PublicIds.of("ed9d3506-65ad-48ea-bd01-95474fecdbc4")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f610144f-c698-4b6c-b726-349e10c899dc"), IkeTerm.ENGLISH_LANGUAGE, "Interval role", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("81f96e15-1880-4106-a935-11fbbd07a1e5"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Typed atom (IkeFoundation)")))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5a26885c-eb3b-42cd-9490-c6764d03e780"), IkeTerm.ENGLISH_LANGUAGE, "Interval role", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("cdeb2f92-ee84-54d9-9f51-a3ae68c74a60"))
                ;

        set.concept("Instant field", PublicIds.of("e9bde1bc-aa72-430a-afe1-aa8aec8833b4")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a97517f2-2eb3-4d81-b04d-a46cc6ee92d3"), IkeTerm.ENGLISH_LANGUAGE, "Instant field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("aa9b7173-026e-485c-9b00-09110f870090"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field definition data type field", PublicIds.of("02273b53-fce7-4cbe-921d-2cff67e81ad5"))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("26fb7513-b75f-5d3b-a813-4911f2c7392f"))
                ;

        set.concept("String field", PublicIds.of("27d3905b-b19a-41ff-bed1-fc55f49f8ce4")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3adf93b7-58f2-4600-80c4-b0d9c88fa0c5"), IkeTerm.ENGLISH_LANGUAGE, "String field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("361cacd1-4b4d-40f7-865e-ceec635621d9"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field definition data type field", PublicIds.of("02273b53-fce7-4cbe-921d-2cff67e81ad5"))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("68fd41fd-442e-5c39-a7e0-37c0dd47eda8"))
                ;

        set.concept("Field definition purpose field", PublicIds.of("93239959-50e6-4645-b5fc-6d47da92e666")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("320a45be-a2ca-4915-a387-7a631212001a"), IkeTerm.ENGLISH_LANGUAGE, "Field definition purpose field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("ad9adc92-a9ef-4dec-aee8-6c0c03e7265d"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e"))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("254a16fc-8e7e-5399-a731-49fdf6e0533b"))
                ;

        set.concept("Interval Type", PublicIds.of("ba3191ee-a260-41a6-99fd-74a22fdc937e")).at(inception)
                .statedAxioms(PublicIds.of(set.uuidFor("Stated axioms: Interval Type")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Interval Set Axioms", PublicIds.of("b253e725-d7cd-46e3-bc3a-5db8b3ffbd52"))))))
                ;

        set.concept("Upper Bound Open", PublicIds.of("c20b3b1e-112f-4cb2-b901-4046db844629")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9eafb031-4b17-4589-bd50-ae70c5908ffb"), IkeTerm.ENGLISH_LANGUAGE, "Upper Bound Open", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("33bf57b2-3a21-4980-901a-93d976b32dc5"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Temporal Set Axioms", PublicIds.of("b253e725-d7cd-46e3-bc3a-5db8b3ffbd52"))))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("30cac71b-1115-4e0f-9ed8-a0861e5ca0d9"), IkeTerm.ENGLISH_LANGUAGE, "Upper Bound Open", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("11bf7b9c-637f-5b63-9814-48068879fb72"))
                ;

        set.concept("Integer field", PublicIds.of("db249d1f-ea2e-4608-ae13-166ed20ca825")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4190db17-c49d-4686-9652-55c043796e94"), IkeTerm.ENGLISH_LANGUAGE, "Integer field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("7b13ef94-9390-4025-9472-f949ac5dced9"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field definition data type field", PublicIds.of("02273b53-fce7-4cbe-921d-2cff67e81ad5"))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("29c63076-b25f-5408-965c-7197043d6f19"))
                ;

        set.concept("Path field", PublicIds.of("6622a391-e2e6-45a0-97e1-c58cd0184092")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("caf4bc68-0641-4b79-9f10-c64baf689399"), IkeTerm.ENGLISH_LANGUAGE, "Path field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .definition("""
                        A concept field whose value is the path dimension of a STAMP — \
                        the path the version was committed on.""")
                .statedAxioms(PublicIds.of("98c878ac-8de4-4768-ac58-320e015daf02"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("7475aa07-c8e5-50d6-bb31-334edd0ceff8"))
                ;

        set.concept("Include Lower Bound", PublicIds.of("2300a210-d722-48af-8c36-118a3f980312")).at(inception)
                .statedAxioms(PublicIds.of(set.uuidFor("Stated axioms: Include Lower Bound")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Interval Set Axioms", PublicIds.of("b253e725-d7cd-46e3-bc3a-5db8b3ffbd52"))))))
                ;

        set.concept("Concept field", PublicIds.of("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f75590d7-49e1-42fc-afb0-490b7f8236cf"), IkeTerm.ENGLISH_LANGUAGE, "Concept field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("4e4ef60b-c909-4ac2-a993-12c5cffb3a98"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component field", PublicIds.of("8bd36a0c-d05d-46b7-a79a-d11477705cc1"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("30a298db-142e-5209-b294-dedf96d86f95"))
                ;

        set.concept("Semantic versions field", PublicIds.of("aeb73410-a679-4ea8-93fe-7c4785599778")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0c68481a-0d59-434d-802c-a1dd8268f536"), IkeTerm.ENGLISH_LANGUAGE, "Semantic versions field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("5fa410a1-c221-4e82-9987-e8fa032c75c1"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions field", PublicIds.of("1a852426-422a-48db-a618-c906ac4c8e6c"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("02bd7335-4109-50d6-8539-09e2127949e3"))
                ;

        set.concept("Semantic field field", PublicIds.of("f6572c76-b5c0-41da-99c0-4344694e7e3c")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fc5eedd2-db8b-4a1c-8375-27335d57a7bc"), IkeTerm.ENGLISH_LANGUAGE, "Semantic field field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("cc3d0c0d-de28-4b9c-905c-53c16cd189cd"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of("ed230c7c-20f9-470d-8566-5057f92748a5"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("45395adb-9157-4710-8810-1a92b0bc1757"), IkeTerm.ENGLISH_LANGUAGE, "Semantic field field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("de300f46-a593-55b1-bb7d-194a4069b7ae"))
                ;

        set.concept("Semantic field fields set", PublicIds.of("8dcfc1a1-31f2-46f7-8247-0a17a6d7c6c0")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9fc81e4e-ee6c-47e5-b450-8eec37c1489e"), IkeTerm.ENGLISH_LANGUAGE, "Semantic field fields set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("ab83903b-b4e2-41ba-9aec-db3913cfc80f"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of("ed230c7c-20f9-470d-8566-5057f92748a5"))), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("20922df6-f4c5-5305-a34f-d2cfbfc9eb5c"))
                ;

        set.concept("Feature Role Type", PublicIds.of("acb8d47e-adac-491d-bc60-78e94cacd312")).at(inception)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("a47b9598-2805-5263-8242-553866371e31"))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("409fe4ec-332d-4058-9c09-9d096c8a09ac"), IkeTerm.ENGLISH_LANGUAGE, "Feature Role Type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("39763e1b-7115-4261-a249-b1095fb420ae"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_TYPE))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4296aed0-9607-464e-bb52-68eae3107a57"), IkeTerm.ENGLISH_LANGUAGE, "Feature Role Type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                ;

        set.concept("Field value field", PublicIds.of("7e4a96fc-0522-4d74-a7d1-ca74be3bc236")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5e9aa5cb-6888-4582-a474-38d4c63fc445"), IkeTerm.ENGLISH_LANGUAGE, "Field value field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("6df7921f-6132-41be-9013-4e7f477eeafe"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of("ed230c7c-20f9-470d-8566-5057f92748a5"))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5564945a-baa2-5642-8d40-6138561216d5"))
                ;

        set.concept("Pattern versions set", PublicIds.of("a254ccee-ef02-4504-9645-0a2ed7af955d")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9ff7977c-e27d-4ebb-a494-f8e01f590d61"), IkeTerm.ENGLISH_LANGUAGE, "Pattern versions set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("fcdf7362-dcb4-4cbc-a066-ea08ae96ac14"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions set", PublicIds.of("54d670f1-234d-485a-a354-e1fa7eea1bf2"))), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("a3aed4d3-7817-5675-ad9f-fe690ba6b199"))
                ;

        set.concept("Component versions set", PublicIds.of("54d670f1-234d-485a-a354-e1fa7eea1bf2")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("77cef2f7-7515-4166-a289-83e20ed8bda5"), IkeTerm.ENGLISH_LANGUAGE, "Component versions set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("7a890c14-b8a2-468c-a29d-071af59797a1"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of("ed230c7c-20f9-470d-8566-5057f92748a5"))), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("fd4de866-ae89-56e5-b54a-2023ca848d5b"))
                ;

        set.concept("Interval Set Axioms", PublicIds.of("b253e725-d7cd-46e3-bc3a-5db8b3ffbd52")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0f689d87-b5ff-48c7-b626-deb91972b101"), IkeTerm.ENGLISH_LANGUAGE, "Interval Set Axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6ea5db6a-19ea-4aa4-b9ae-8b35ce26c039"), IkeTerm.ENGLISH_LANGUAGE, "Interval Set Axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("b9ea8484-5bf0-4db9-9e7f-ecb2b2388c15"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Axioms", PublicIds.of("20746b91-521a-45a6-89da-0fe32384a67f"))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("ac63da3e-0c4a-5d86-9805-fa14a069ccb3"))
                ;

        set.concept("Axioms", PublicIds.of("20746b91-521a-45a6-89da-0fe32384a67f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1e0fc030-ec28-4e18-b021-ceaa1d1e3ee4"), IkeTerm.ENGLISH_LANGUAGE, "Axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .definition("""
                        Groups the logical-axiom meta-schema concepts: the terminology for \
                        expressing a concept's formal, machine-processable meaning — EL++ \
                        terminological axioms, interval-set axioms, and their syntax and \
                        origin.""")
                .statedAxioms(PublicIds.of("6151c4c3-bc96-4b86-9e0c-a05b64396db5"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2708aab3-d7ca-47f0-a7fc-a9b41c45e2c9"), IkeTerm.ENGLISH_LANGUAGE, "Axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8ac2ff67-d2b2-5e69-a0ff-f82d73ef61e9"))
                ;

        set.concept("Blank Concept", PublicIds.of("cd23d88d-2fcd-4007-8829-97e37bf336aa")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fddf5dfb-702a-4ef1-84a2-e2c8881f10b5"), IkeTerm.ENGLISH_LANGUAGE, "Blank Concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .definition("""
                        The editor's empty-value marker: what an editing surface writes into a component-valued field a person has deliberately cleared, and what it tests for when asking whether that field is empty. An authored, persisted value -- distinct from Uninitialized Component, the platform's null-object for a reference that was never set at all. Neither asserts anything about the world; a claim that no value applies would need a concept this set does not yet carry.""")
                .statedAxioms(PublicIds.of("7b1742ae-98e7-4562-bd47-d20a0b35127e"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("395a8595-4e3a-5f2c-935f-28ab6c0d2fff"))
                ;

        set.concept("Temporal Axiom", PublicIds.of("5144d836-18d8-4881-a377-2d4640b710a9")).at(inception)
                .statedAxioms(PublicIds.of(set.uuidFor("Stated axioms: Temporal Axiom")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Axioms", PublicIds.of("20746b91-521a-45a6-89da-0fe32384a67f"))))))
                ;

        set.concept("Interval Role Type", PublicIds.of("6fa58611-af37-402e-a0c2-6ee1d6068651")).at(inception)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("f349d6b6-81f6-5749-832c-2b795b2833cd"))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("81a84029-57d2-46f2-847d-6bddbfc7d43c"), IkeTerm.ENGLISH_LANGUAGE, "Interval Role Type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("46a1f78e-6975-4ec7-ac36-c2e2bb5f9ced"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_TYPE))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9c9d31d2-e1df-448e-988d-94649386173d"), IkeTerm.ENGLISH_LANGUAGE, "Interval Role Type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                ;

        set.concept("Pattern meaning field", PublicIds.of("996d0023-a355-422f-a84d-16dda6ece1b0")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("22d8038d-bbe5-4626-aa64-59d617b06ed2"), IkeTerm.ENGLISH_LANGUAGE, "Pattern meaning field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("59a4c494-4f1f-407f-bc0e-50e124725ab7"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("75742c74-5b59-5069-94a3-af52a183fdb4"))
                ;

        set.concept("Property set Axioms", PublicIds.of("ca2fdefd-0481-41cb-8074-41a78f94034d")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c0cf1277-9f8e-40e9-9f7d-a334c853ab0e"), IkeTerm.ENGLISH_LANGUAGE, "Property set Axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("39b5c17f-09d4-5153-8da5-9da71b5d73bb"))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("682373f9-fd96-46bd-820f-b44960290e6a"), IkeTerm.ENGLISH_LANGUAGE, "Property set Axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("a1bf12b7-2faf-4fd6-ad8f-e86d0e0775f6"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical set (IkeFoundation)")))))
                ;

        set.concept("Public ID field", PublicIds.of("196838c5-55f4-4e40-8618-b9ce60685c2f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1d7c9dc9-5886-4c91-a39e-222296b7a3d3"), IkeTerm.ENGLISH_LANGUAGE, "Public ID field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("95a8f7f5-6e82-47a3-bdac-ffce75726494"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("String field", PublicIds.of("27d3905b-b19a-41ff-bed1-fc55f49f8ce4"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d3b567b8-599f-5a2d-8ab6-a6134e792176"))
                ;

        set.concept("Uniquely identify knowledge graph components", PublicIds.of("dde9a93d-250c-449b-bea0-ba1133d1387b")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("84995eba-4c29-4461-8c95-7cec6f4f12c0"), IkeTerm.ENGLISH_LANGUAGE, "Uniquely identify knowledge graph components", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("5035431d-756f-476b-8684-b2d8776f491e"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.SEMANTIC_PROPERTIES), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3df98820-750e-440b-8dc0-b6181a732493"), IkeTerm.ENGLISH_LANGUAGE, "The purpose of this externally valid identifier—based on a list of UUIDs—is to provide a globally unique reference to each entity that is reliable across different systems and databases. This ensures consistent identification, serialization, and lookup of entities regardless of their storage location or implementation details.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("72282a9b-280f-5393-8cd7-4a59b0844fd9"))
                ;

        set.concept("Concept versions field", PublicIds.of("3a08b5f1-f17e-4db5-8cf9-c6540f26f241")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("67271240-9116-45a4-9622-3cbe9149d355"), IkeTerm.ENGLISH_LANGUAGE, "Concept versions field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("585d09e9-3bbc-4806-9071-344ea449b5af"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions field", PublicIds.of("1a852426-422a-48db-a618-c906ac4c8e6c"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("7b84bd4c-2e8e-5781-ab5a-3c7147359bca"))
                ;

        set.concept("Concept versions set", PublicIds.of("806c7f9f-52f9-4b53-9758-122899b28a76")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a1bcfd86-7970-4a54-922d-adad1895e061"), IkeTerm.ENGLISH_LANGUAGE, "Concept versions set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("9d107603-10a8-4928-a3be-2b26f854408b"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions set", PublicIds.of("54d670f1-234d-485a-a354-e1fa7eea1bf2"))), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("b2aa911a-e94b-5da6-af9a-8ef44d99cbdc"))
                ;

        set.concept("Field definition data type field", PublicIds.of("02273b53-fce7-4cbe-921d-2cff67e81ad5")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3f336a02-a965-470a-b4fd-dfa7ecb8f2d8"), IkeTerm.ENGLISH_LANGUAGE, "Field definition data type field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("4710800b-ad37-4ec9-9ec2-f9b9a77e109c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of("ed230c7c-20f9-470d-8566-5057f92748a5"))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("090eb280-d300-57d0-98be-e77694d68fe1"))
                ;

        set.concept("Pattern purpose field", PublicIds.of("352c821b-7a11-454c-a127-48ad3206573d")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("18ec7dcd-fe02-4d3b-88b6-a446c5d04498"), IkeTerm.ENGLISH_LANGUAGE, "Pattern purpose field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("27ff9977-e815-490b-a26a-3407d5ee0548"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("29d1f0d4-537a-52e8-9771-de353141fb1d"))
                ;

        set.concept("Pattern field", PublicIds.of("751790c7-e1e4-42bc-b531-54c54bd6eebd")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1edef18a-20a1-45e9-b351-89a84649426b"), IkeTerm.ENGLISH_LANGUAGE, "Pattern field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("172d9e69-6a3a-4303-9e28-7d2d2e3b5562"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component field", PublicIds.of("8bd36a0c-d05d-46b7-a79a-d11477705cc1"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("b2c9e0d2-0192-526e-b248-82e629525378"))
                ;

        set.concept("Pattern versions field", PublicIds.of("7b8ecbbf-55b4-41bc-acbf-51824e74446a")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("03ef1ffa-2c30-4bd8-b1d0-bb4e17e01b2b"), IkeTerm.ENGLISH_LANGUAGE, "Pattern versions field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("6102d9a1-66a1-4468-a5da-705affc7710e"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions field", PublicIds.of("1a852426-422a-48db-a618-c906ac4c8e6c"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fc925094-e901-4192-b641-fd1061c1a203"), IkeTerm.ENGLISH_LANGUAGE, "Pattern versions field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("4be32931-498f-5dd8-8e13-090a7faa0680"))
                ;

        set.concept("Unit of Measure", PublicIds.of("40afdda5-89d6-4b80-8181-1ddd6eb92dc8")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d39215af-3ff1-42bd-9c6a-b5a59177a8d5"), IkeTerm.ENGLISH_LANGUAGE, "Unit of Measure", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("d910c0ed-7110-48b7-a638-5166d3ef5fbe"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Temporal Set Axioms", PublicIds.of("b253e725-d7cd-46e3-bc3a-5db8b3ffbd52"))))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8eae0ae5-4008-4ed0-a59a-9c079521197e"), IkeTerm.ENGLISH_LANGUAGE, "Unit of Measure", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("54928fcd-7499-54c6-84ef-c6ab311e3543"))
                ;

        set.concept("Field definitions set", PublicIds.of("975de83e-ab99-4a9e-9051-4cbf310a2123")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7639982f-9ccf-42c4-aad1-d9743ec59e39"), IkeTerm.ENGLISH_LANGUAGE, "Field definitions set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("ea7512bc-fd34-4ada-8833-cd121418da0c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of("ed230c7c-20f9-470d-8566-5057f92748a5"))), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("9ad1de67-18e1-550d-aef9-d85ecfa6fba5"))
                ;

        set.concept("Lower Bound Open", PublicIds.of("a0096ba1-0718-4c03-ad8f-8143c44091e7")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("95c87fd6-1f02-4e52-bb1d-86b229fd5e6b"), IkeTerm.ENGLISH_LANGUAGE, "Lower Bound Open", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("c0926fba-3758-4cc9-aebc-2e001b2560bf"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Temporal Set Axioms", PublicIds.of("b253e725-d7cd-46e3-bc3a-5db8b3ffbd52"))))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("92167484-69d4-4488-a2b1-169750138f85"), IkeTerm.ENGLISH_LANGUAGE, "Lower Bound Open", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("611332e4-38b7-5639-9303-92f5e84fc038"))
                ;

        set.concept("Semantic field", PublicIds.of("8b6c69d7-a5aa-4db2-bcea-8c7b2817b02f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d0b00d78-00df-4358-b2a3-e4b713f19a06"), IkeTerm.ENGLISH_LANGUAGE, "Semantic field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("1b48485e-ef4f-4de2-b30c-785b42f5d7c6"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component field", PublicIds.of("8bd36a0c-d05d-46b7-a79a-d11477705cc1"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("6027de68-e80c-58b0-8032-62a5bc6f51ea"))
                ;

        set.concept("Interval property set", PublicIds.of("9afc988a-3724-4754-8b74-651426472b19")).at(inception)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("282c95a7-41cf-5b1b-95ef-ed71e4493ae1"))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("774d6b87-b69c-4f0a-a1db-9dc11979d173"), IkeTerm.ENGLISH_LANGUAGE, "Interval property set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("55e609b4-111c-474d-8b71-fb1a1bea1201"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical set (IkeFoundation)")))))
                ;

        set.concept("Semantic pattern field", PublicIds.of("19dd5dd3-1075-4113-a437-5f1f7c2d55bc")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c6c8c1b3-95cc-485b-adbf-5c218cbf1241"), IkeTerm.ENGLISH_LANGUAGE, "Semantic pattern field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("d5e2fc81-268b-4510-b82e-c982f68bd975"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Pattern field", PublicIds.of("751790c7-e1e4-42bc-b531-54c54bd6eebd"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("9d1e6d38-030d-59d6-a6f7-bf180724cb66"))
                ;

        set.concept("Semantic referenced component field", PublicIds.of("4111ba1e-c818-4c5d-9fed-34d07298d009")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0562f9bf-867e-47d3-bcac-c37e170df2f2"), IkeTerm.ENGLISH_LANGUAGE, "Semantic referenced component field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("0fcea18e-0f47-46b8-b015-0a32404041a3"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component field", PublicIds.of("8bd36a0c-d05d-46b7-a79a-d11477705cc1"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("f4800036-6f1d-5c09-8e0a-3410d9032dae"))
                ;

        set.concept("Semantic versions set", PublicIds.of("4fd69aed-556f-4938-94cc-ea7ea707ccef")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("05e65c46-6c96-4eff-b10a-6200991da097"), IkeTerm.ENGLISH_LANGUAGE, "Semantic versions set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("b536e963-e938-4d7f-910f-eae3f8cc6ab2"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component versions set", PublicIds.of("54d670f1-234d-485a-a354-e1fa7eea1bf2"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d81283c1-cccb-5ac3-90f8-784dadca8313"))
                ;

        set.concept("Field definition meaning field", PublicIds.of("74dffbed-0bef-44a4-8ad6-8cff84fe47ae")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1ef0b24c-239c-4e11-a11c-1cd09d3028d3"), IkeTerm.ENGLISH_LANGUAGE, "Field definition meaning field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("ac9d8ee5-11eb-40ee-8222-58ab6aeb0828"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Concept field", PublicIds.of("ebe2aa74-f100-41b2-8d75-2d8f06ce5e4e"))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d3fb8cda-0d19-5c54-bf2d-a909ac5071e0"))
                ;

        set.concept("Interval Lower Bound", PublicIds.of("52b3e38a-fccb-4779-aa61-4e87abd56419")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9f5130bd-791d-469d-b1c3-6f95ff918fd4"), IkeTerm.ENGLISH_LANGUAGE, "Interval Lower Bound", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("aa693314-dd72-46b6-bfe0-87a9aa1a1c9b"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Temporal Set Axioms", PublicIds.of("b253e725-d7cd-46e3-bc3a-5db8b3ffbd52"))))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("cfcfd411-c8bc-4b90-bec7-97dee2eb2e7c"), IkeTerm.ENGLISH_LANGUAGE, "Interval Lower Bound", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("c376de0a-a8f9-536c-8e33-432c0a9db06d"))
                ;

        set.concept("Include Upper Bound", PublicIds.of("990b7e1d-3dcc-4c6e-a068-e30400607d50")).at(inception)
                .statedAxioms(PublicIds.of(set.uuidFor("Stated axioms: Include Upper Bound")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Interval Set Axioms", PublicIds.of("b253e725-d7cd-46e3-bc3a-5db8b3ffbd52"))))))
                ;

        set.concept("Field definition field", PublicIds.of("14171f07-e74f-409a-b555-06b478818f76")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("293a9980-baf8-4d28-a938-d102d04d1ef2"), IkeTerm.ENGLISH_LANGUAGE, "Field definition field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("334b5dc8-dcad-43d9-9a94-abb0dbd45363"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of("ed230c7c-20f9-470d-8566-5057f92748a5"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d7d3959f-0743-5e88-a6db-5de059a7ccdd"))
                ;

        set.concept("Field categories", PublicIds.of("ed230c7c-20f9-470d-8566-5057f92748a5")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("64478cb5-6d8e-4e02-9f80-f084cb15df8e"), IkeTerm.ENGLISH_LANGUAGE, "Field categories", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .definition("""
                        Groups the field-level meta-schema concepts: the terminology \
                        describing what kind of value — a component, a field definition, a \
                        semantic field, or a set of these — a semantic's field can hold.""")
                .statedAxioms(PublicIds.of("f2446156-e60e-4a7f-a859-0558b282903b"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("86c16e94-be65-5020-8542-61a611c03abd"))
                ;

        set.concept("Interval Upper Bound", PublicIds.of("6565f774-ff6c-4882-832f-31ddc462adf7")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bdb2979c-4ab9-4262-95fb-de68acccf2bc"), IkeTerm.ENGLISH_LANGUAGE, "Interval Upper Bound", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("3d3053bf-0bbc-468c-a1bb-45c33ee7c0ae"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Temporal Set Axioms", PublicIds.of("b253e725-d7cd-46e3-bc3a-5db8b3ffbd52"))))))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a5b0f7cc-7605-4e1e-ba4c-3da028c6de48"), IkeTerm.ENGLISH_LANGUAGE, "Interval Upper Bound", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("77d073b9-da92-5111-b3f4-e4b10aca8f06"))
                ;

        set.concept("STAMP field", PublicIds.of("3d821e64-a2ee-4414-8949-1bc92ef5d5b6")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("636175a0-1d83-43ba-bd94-1a4979ea17b2"), IkeTerm.ENGLISH_LANGUAGE, "STAMP field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("a7efeead-9f9a-4ae8-a029-eef2ba6f665d"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Component field", PublicIds.of("8bd36a0c-d05d-46b7-a79a-d11477705cc1"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d2948b12-e23f-5c0d-9741-a2613b849db8"))
                ;

        set.concept("Component field", PublicIds.of("8bd36a0c-d05d-46b7-a79a-d11477705cc1")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("71037904-d49d-4bbd-a1f7-792c50e4593a"), IkeTerm.ENGLISH_LANGUAGE, "Component field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("4a691220-158e-44a3-8fcc-8582cf501a86"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field categories", PublicIds.of("ed230c7c-20f9-470d-8566-5057f92748a5"))), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("73c02ad4-723b-5532-8ac7-440906695f8e"))
                ;

        set.concept("Implication set", PublicIds.of("ee467a5b-9292-4e0a-a165-3b1a359a8c98")).at(inception)
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("4eb568f9-3448-56ac-ad8e-66560500babb"))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("537c11d3-af91-4eb3-8b30-ffd171ee8156"), IkeTerm.ENGLISH_LANGUAGE, "Implication set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .statedAxioms(PublicIds.of("7d9d85e7-5d00-461a-8d74-30efb1455a87"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical set (IkeFoundation)")))))
                ;

        set.concept("Integrated Knowledge Management (SOLOR)", PublicIds.of("7c21b6c5-cf11-5af9-893b-743f004c97f5")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f3269aab-5826-4449-a8b7-58e31fb3b17f"), IkeTerm.ENGLISH_LANGUAGE, "Integrated Knowledge Management (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5e4a045b-6478-458d-a7e4-3f79f8d0ffc2"), IkeTerm.PREFERRED)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("11568433-3b80-4029-99c8-b8fc9eedecfc"), IkeTerm.ENGLISH_LANGUAGE, "Tinkar root concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.US_DIALECT_PATTERN, PublicIds.of("834b6a5b-6e24-4c9f-864c-38da26b13e7b"), IkeTerm.PREFERRED)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("df2c4fca-9555-42ed-9277-2809df76f918"), IkeTerm.ENGLISH_LANGUAGE, "Terminologies that are represented in a harmonized manner", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.US_DIALECT_PATTERN, PublicIds.of("9c6d041b-4943-41b7-af09-e14e72de9992"), IkeTerm.PREFERRED)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("252259d4-07f5-46c8-b92d-082b3448d567"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "7c21b6c5-cf11-5af9-893b-743f004c97f5")
                .statedAxioms(PublicIds.of("63a463d8-dbe2-5e6c-8391-2eff13f43af9"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROOT_VERTEX))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5b353251-e33a-4c54-a6da-d119c758caf1"))
                ;

    }
}
