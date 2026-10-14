package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelConcept;
import dev.ikm.tinkar.terms.KernelPattern;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Meaning" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section41 {

    private Section41() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Meaning", PublicIds.of(UUID.fromString("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5159cb5c-0b50-44f3-90d5-f066bdbc02cd")), KernelConcept.ENGLISH_LANGUAGE, "Meaning", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("98bfa7ad-7328-461f-b808-91a3343b746d")), KernelConcept.ENGLISH_LANGUAGE, "Meaning", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cf7fe351-36b9-4b4d-a47a-b701537a8e77")), KernelConcept.ENGLISH_LANGUAGE, "The interpretation or explanation field for a pattern/semantics", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8faf1d86-144c-4639-bf4b-60abe7a7d830")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "a06158ff-e08a-5d7d-bcfa-6cbfdb138910")
                .statedAxioms(PublicIds.of(UUID.fromString("0a875a70-51ed-5f03-8111-c8a0a9732ba3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("cae8ef02-516d-476b-bbce-da8b09939889")))
                .semanticOn(PublicIds.of(UUID.fromString("5159cb5c-0b50-44f3-90d5-f066bdbc02cd")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("087bd92c-7f9a-4f06-936c-222d91440cfd")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("98bfa7ad-7328-461f-b808-91a3343b746d")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("21034324-f3d2-4035-8bf6-e4d094ada8c8")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cf7fe351-36b9-4b4d-a47a-b701537a8e77")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3fa8ee39-ba79-4179-8cc5-7481ba6e86dd")), KernelConcept.PREFERRED)
                ;

        // Stated parent diverges from the baseline artifact (was Meaning): reparented under
        // Legacy as a deprecation signal, flattened in place (IKE-Network/ike-issues#880, #894;
        // registered in DELIBERATELY_REPARENTED_ISA).
        set.concept("Dynamic column data types (SOLOR)", PublicIds.of(UUID.fromString("61da7e50-f606-5ba0-a0df-83fd524951e7"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2d43598c-8817-4d49-81fd-1de7361fc864")), KernelConcept.ENGLISH_LANGUAGE, "Dynamic column data types (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("82f089bc-26de-442c-9d56-577c24132c6e")), KernelConcept.ENGLISH_LANGUAGE, "Dynamic column data types", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5ae43eb1-3f7b-4519-be55-c6e54c22665a")), KernelConcept.ENGLISH_LANGUAGE, "Data storage system where the structure of the data can be altered or extended dynamically?", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4ec70de8-4467-4295-8f8a-e5f40d09e2b0")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "61da7e50-f606-5ba0-a0df-83fd524951e7")
                .statedAxioms(PublicIds.of(UUID.fromString("32b38296-36d0-55f4-b372-da94e78be9da")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Legacy (IkeFoundation)")))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1ac52dfa-5a1f-45fb-8f41-c901a113e26e")))
                .semanticOn(PublicIds.of(UUID.fromString("2d43598c-8817-4d49-81fd-1de7361fc864")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5800ff31-b0cc-4d40-b6b3-a8e46741fd59")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("82f089bc-26de-442c-9d56-577c24132c6e")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9ac15959-49f9-4b39-aea4-0f4ebf93aa7a")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5ae43eb1-3f7b-4519-be55-c6e54c22665a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("66051249-fe18-411d-b77d-ad3638ce7e1b")), KernelConcept.PREFERRED)
                ;

        set.concept("Boolean (SOLOR)", PublicIds.of(UUID.fromString("08f2fb74-980d-5157-b92c-4ff1eac6a506"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("21f3c602-3c09-4841-bcfe-badfb33137bb")), KernelConcept.ENGLISH_LANGUAGE, "Boolean (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6f6a7b5c-ec41-44e5-a25d-8f611a5535ea")), KernelConcept.ENGLISH_LANGUAGE, "Boolean", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("38ed0a3c-0347-47e5-aa7c-3d8887911f7b")), KernelConcept.ENGLISH_LANGUAGE, "Data type", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("1034d7e5-8d78-4d01-bd57-aef9ebacad01")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "08f2fb74-980d-5157-b92c-4ff1eac6a506")
                .statedAxioms(PublicIds.of(UUID.fromString("b2af0cd8-46a0-5e16-8bc8-d5eb32d37450")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of("61da7e50-f606-5ba0-a0df-83fd524951e7"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("30c74d8c-7566-4714-bbd0-7007e4530ab1")))
                .semanticOn(PublicIds.of(UUID.fromString("21f3c602-3c09-4841-bcfe-badfb33137bb")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3c849ba6-07c2-451a-bd80-6ff36e53ec3a")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6f6a7b5c-ec41-44e5-a25d-8f611a5535ea")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("74bbf125-930a-4666-8972-193c37c970aa")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("38ed0a3c-0347-47e5-aa7c-3d8887911f7b")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6f5368bd-2919-4b24-9c29-9ee72dfb7402")), KernelConcept.PREFERRED)
                ;

        set.concept("Float (SOLOR)", PublicIds.of(UUID.fromString("fb591801-7b37-525d-980d-98a1c63ceee0"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("74140663-79ce-49ff-8d7a-53b670a3915f")), KernelConcept.ENGLISH_LANGUAGE, "Float (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3fb778c2-b14b-4548-8ac0-de74b3427dd7")), KernelConcept.ENGLISH_LANGUAGE, "Float", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cc557716-22db-496c-847c-e35314e5f765")), KernelConcept.ENGLISH_LANGUAGE, "Data type", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("6481d05c-be69-49a5-99b1-8cf2d61f050a")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "fb591801-7b37-525d-980d-98a1c63ceee0")
                .statedAxioms(PublicIds.of(UUID.fromString("f75eb9b3-9b21-5f91-bdb5-5e25d27a14b3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of("61da7e50-f606-5ba0-a0df-83fd524951e7"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("cb58b0eb-4ae7-410a-b43e-2c0bb872d8ed")))
                .semanticOn(PublicIds.of(UUID.fromString("74140663-79ce-49ff-8d7a-53b670a3915f")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("573bee17-b667-4246-8717-01b05bdc5b51")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3fb778c2-b14b-4548-8ac0-de74b3427dd7")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5e656c0d-7f64-47dd-b68f-2fadc3a59d87")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cc557716-22db-496c-847c-e35314e5f765")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("259adabe-5e1a-4095-849a-9d8209f275e5")), KernelConcept.PREFERRED)
                ;

        set.concept("Signed integer (SOLOR)", PublicIds.of(UUID.fromString("1d1c2073-d98b-3dd3-8aad-a19c65aa5a0c"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("95074c43-fcec-48c1-87cf-80ba4a39b47a")), KernelConcept.ENGLISH_LANGUAGE, "Signed integer (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("afb59ca6-49b6-4bf6-ac23-e2be9ac2d803")), KernelConcept.ENGLISH_LANGUAGE, "Signed integer", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("51c1f835-303a-460c-9c72-ab068bff251c")), KernelConcept.ENGLISH_LANGUAGE, "Signed integer (Foundation metadata concept)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("40db11c5-7d08-4e53-a89f-fccd8de4ea04")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "1d1c2073-d98b-3dd3-8aad-a19c65aa5a0c")
                .statedAxioms(PublicIds.of(UUID.fromString("b762fe5b-1dbd-55da-8da4-859e100347c9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of("61da7e50-f606-5ba0-a0df-83fd524951e7"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c14c3c79-1ffa-44f7-b96a-27a9611b5fd6")))
                .semanticOn(PublicIds.of(UUID.fromString("95074c43-fcec-48c1-87cf-80ba4a39b47a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fd250fc9-ac7d-4767-acbe-91dbb321967f")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("afb59ca6-49b6-4bf6-ac23-e2be9ac2d803")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("87e22c5d-8f78-4e54-8610-ac96494124b2")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("51c1f835-303a-460c-9c72-ab068bff251c")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1c9f06e7-e54e-4ef9-a9e0-999e24be76f3")), KernelConcept.PREFERRED)
                ;

        set.concept("Double (SOLOR)", PublicIds.of(UUID.fromString("7172e6ac-a05a-5a34-8275-aef430b18207"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1d0f8f43-cf15-4fd6-a6fb-59e299364754")), KernelConcept.ENGLISH_LANGUAGE, "Double (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e37a0bfd-dc69-4636-a7d5-7d8289746be1")), KernelConcept.ENGLISH_LANGUAGE, "Double", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0f335f1f-9a1f-4e79-993b-b7651acb2af1")), KernelConcept.ENGLISH_LANGUAGE, "Data type", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0742a11c-c71f-48fd-bcfc-dd5d7fed0328")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "7172e6ac-a05a-5a34-8275-aef430b18207")
                .statedAxioms(PublicIds.of(UUID.fromString("52d06dbb-86e4-53b4-a3f9-3bee3c523acb")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of("61da7e50-f606-5ba0-a0df-83fd524951e7"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b499b157-e6ef-417f-80ec-463a4f08b0f1")))
                .semanticOn(PublicIds.of(UUID.fromString("1d0f8f43-cf15-4fd6-a6fb-59e299364754")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6a322068-1715-4b71-be70-e888a6ab3651")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e37a0bfd-dc69-4636-a7d5-7d8289746be1")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0c8ed0ef-f7e1-4413-9e9b-7d1f48e07db3")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0f335f1f-9a1f-4e79-993b-b7651acb2af1")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("12e858d3-8e5f-446c-bab3-80328c47a5d2")), KernelConcept.PREFERRED)
                ;

        set.concept("Decimal (SOLOR)", PublicIds.of(UUID.fromString("dccb0476-3b63-3d48-b5a2-85bd0ad2fa61"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cb461b47-87ce-47d3-944f-94a6395d2efa")), KernelConcept.ENGLISH_LANGUAGE, "Decimal (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("201365a8-533f-49eb-9656-71014e856d65")), KernelConcept.ENGLISH_LANGUAGE, "Decimal", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5cdb624d-4443-4240-ae71-53c156610cb5")), KernelConcept.ENGLISH_LANGUAGE, "Data type", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c90c04cb-a0b0-437e-9685-de5f003d56be")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "dccb0476-3b63-3d48-b5a2-85bd0ad2fa61")
                .statedAxioms(PublicIds.of(UUID.fromString("a4a45324-1359-5529-a8c6-5097820aeb54")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of("61da7e50-f606-5ba0-a0df-83fd524951e7"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("15491792-98a4-4368-bc7f-79b9cd7cb599")))
                .semanticOn(PublicIds.of(UUID.fromString("cb461b47-87ce-47d3-944f-94a6395d2efa")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e15eec56-f79e-4aa7-9d3f-d8c1224a87aa")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("201365a8-533f-49eb-9656-71014e856d65")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7b6421dd-2064-4906-81e6-bdd5cb58146a")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5cdb624d-4443-4240-ae71-53c156610cb5")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cef3a1f3-86b8-42eb-b89a-2f9591fd369b")), KernelConcept.PREFERRED)
                ;

        set.concept("Byte array (SOLOR)", PublicIds.of(UUID.fromString("9a84fecf-708d-5de4-9c5f-e17973229e0f"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ef5cdcd5-7c6e-4320-afd3-8d085d08a0b9")), KernelConcept.ENGLISH_LANGUAGE, "Byte array (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fb73f691-0fa4-4a38-809b-84f1dc8a1113")), KernelConcept.ENGLISH_LANGUAGE, "Byte array", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("536db750-3727-4840-83bd-4caf4a987c6e")), KernelConcept.ENGLISH_LANGUAGE, "Data type", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("76218c9c-afc8-441d-b9b6-79ab850be90f")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "9a84fecf-708d-5de4-9c5f-e17973229e0f")
                .statedAxioms(PublicIds.of(UUID.fromString("2eae21cb-1d88-5000-854f-0c58d3b50e9d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of("61da7e50-f606-5ba0-a0df-83fd524951e7"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("dc993942-1bf9-49d8-9080-a84497180e48")))
                .semanticOn(PublicIds.of(UUID.fromString("ef5cdcd5-7c6e-4320-afd3-8d085d08a0b9")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("37549210-8b31-4615-91e3-493e6aacdc5b")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("fb73f691-0fa4-4a38-809b-84f1dc8a1113")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3eeb2c70-d22f-4503-b21c-c68696215133")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("536db750-3727-4840-83bd-4caf4a987c6e")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8a732438-7ffc-455e-ad4a-d46a51dd88f7")), KernelConcept.PREFERRED)
                ;

        set.concept("Array (SOLOR)", PublicIds.of(UUID.fromString("318622e6-dd7a-5651-851d-2d5c2af85767"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f59d6143-207f-48f6-9b3c-3242acc273a3")), KernelConcept.ENGLISH_LANGUAGE, "Array (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f848a313-7299-4326-8875-ce592d8f0c7a")), KernelConcept.ENGLISH_LANGUAGE, "Array", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("be4b4de0-77ff-4965-a3ed-80ca93330d92")), KernelConcept.ENGLISH_LANGUAGE, "Linear data structure", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("24a2e83b-fd91-41ad-ac0e-e02b027c3afb")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "318622e6-dd7a-5651-851d-2d5c2af85767")
                .statedAxioms(PublicIds.of(UUID.fromString("fa7d23f1-29d9-53f8-8ab6-c380d18afbba")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of("61da7e50-f606-5ba0-a0df-83fd524951e7"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6e341229-6d94-47be-bf99-664cae73816b")))
                .semanticOn(PublicIds.of(UUID.fromString("f59d6143-207f-48f6-9b3c-3242acc273a3")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f33394a6-7ce9-4a0b-b0d3-6f9076902b5e")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f848a313-7299-4326-8875-ce592d8f0c7a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d27e6b63-331b-44e1-a41c-468bb15c1ccb")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("be4b4de0-77ff-4965-a3ed-80ca93330d92")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("40125fab-1747-4419-9eb2-c9e17846fc25")), KernelConcept.PREFERRED)
                ;

        set.concept("Long (SOLOR)", PublicIds.of(UUID.fromString("dea8cdf1-de75-5991-9791-79714e4a964d"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9853b828-cbeb-4182-82f2-28f3f921dbf7")), KernelConcept.ENGLISH_LANGUAGE, "Long (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("977bb498-5319-4c57-848d-394930d8a37d")), KernelConcept.ENGLISH_LANGUAGE, "Long", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cbe5f782-b67f-4348-8ac1-640c34ea1eac")), KernelConcept.ENGLISH_LANGUAGE, "Data type", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("1a234089-2b29-4b0d-abea-4176f54c35ba")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "dea8cdf1-de75-5991-9791-79714e4a964d")
                .statedAxioms(PublicIds.of(UUID.fromString("adfa5609-0ff3-5405-905a-cb5690cc6279")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of("61da7e50-f606-5ba0-a0df-83fd524951e7"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5de018e5-1de4-48d0-98be-812b25b8f690")))
                .semanticOn(PublicIds.of(UUID.fromString("9853b828-cbeb-4182-82f2-28f3f921dbf7")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("387f90b3-4835-4d9e-9a89-f789e7b1ed95")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("977bb498-5319-4c57-848d-394930d8a37d")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bd3beb25-234e-41b8-80f7-c016f7d9c5f8")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cbe5f782-b67f-4348-8ac1-640c34ea1eac")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("04bb4b8b-d54d-4eec-a6eb-0a37cc472756")), KernelConcept.PREFERRED)
                ;

        set.concept("UUID data type (SOLOR)", PublicIds.of(UUID.fromString("2faa9262-8fb2-11db-b606-0800200c9a66"), UUID.fromString("680f3f6c-7a2a-365d-b527-8c9a96dd1a94"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8f0ae03a-72f5-499e-9b6d-bd57adeba594")), KernelConcept.ENGLISH_LANGUAGE, "UUID data type (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("29ae6dec-dc5f-468d-93af-d13e7301dbfb")), KernelConcept.ENGLISH_LANGUAGE, "UUID data type", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0a0a714e-5bc9-481a-8233-000ebaecb1ca")), KernelConcept.ENGLISH_LANGUAGE, "Distinction of data type of UUID", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("9f437684-e8d7-401a-9b38-811ca4a2340b")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "2faa9262-8fb2-11db-b606-0800200c9a66")
                .statedAxioms(PublicIds.of(UUID.fromString("09d68d45-367f-5748-b6ea-e4b8c74ce376")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of("61da7e50-f606-5ba0-a0df-83fd524951e7"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("3be3b0ad-fe9d-4f20-b6f6-af91b1c98ad3")))
                .semanticOn(PublicIds.of(UUID.fromString("8f0ae03a-72f5-499e-9b6d-bd57adeba594")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2750e08d-4c72-4bea-9cf7-ec7b31619260")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("29ae6dec-dc5f-468d-93af-d13e7301dbfb")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("92ab0403-3610-496b-991d-90aef59568de")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0a0a714e-5bc9-481a-8233-000ebaecb1ca")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("221f9997-a4f1-456f-a7be-5ebf5fa241e0")), KernelConcept.PREFERRED)
                ;

        set.concept("Sufficient concept definition operator (SOLOR)", PublicIds.of(UUID.fromString("dfa80f36-dbe6-5006-8509-c497a26ceab5"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("992e601a-0857-4d9a-9dbe-e1669aae4b39")), KernelConcept.ENGLISH_LANGUAGE, "Sufficient concept definition operator (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bd2fd03b-5ba3-48da-990f-26572160a301")), KernelConcept.ENGLISH_LANGUAGE, "Sufficient concept definition operator", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bc82cf71-e37e-4b7c-89bd-1ca501da048a")), KernelConcept.ENGLISH_LANGUAGE, "Concept definition operator", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ec965168-85b0-4850-813c-e3ee700dfc5b")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "dfa80f36-dbe6-5006-8509-c497a26ceab5")
                .statedAxioms(PublicIds.of(UUID.fromString("28fbc2bd-9bd7-52d4-be79-280d7822b0f6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b4e6e22b-0cdb-4e2e-99ac-fd6ba52a599c")))
                .semanticOn(PublicIds.of(UUID.fromString("992e601a-0857-4d9a-9dbe-e1669aae4b39")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5133e092-4420-49bb-972d-01f2384b01b7")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bd2fd03b-5ba3-48da-990f-26572160a301")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1946c5fc-02c0-4b5c-883f-d99b2b5decdd")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bc82cf71-e37e-4b7c-89bd-1ca501da048a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("308f70eb-75c2-4958-b771-22e49f461552")), KernelConcept.PREFERRED)
                ;

        set.concept("Sufficient concept definition (SOLOR)", PublicIds.of(UUID.fromString("6d9cd46e-8a8f-310a-a298-3e55dcf7a986"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1621d6f2-58c6-450a-815a-bacfa3963ebc")), KernelConcept.ENGLISH_LANGUAGE, "Sufficient concept definition (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a540b12a-fcb5-47f9-ae0f-6b4e7dd573fe")), KernelConcept.ENGLISH_LANGUAGE, "Sufficient concept definition", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0266168d-62b4-4bbf-85bc-7aa7c8898605")), KernelConcept.ENGLISH_LANGUAGE, "Concept definition - Sufficient", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f1194610-0ac6-463b-bd59-a524025f7405")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "6d9cd46e-8a8f-310a-a298-3e55dcf7a986")
                .statedAxioms(PublicIds.of(UUID.fromString("ce3439cf-21ca-5304-b3a1-45f0a5cf5fe4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Sufficient concept definition operator (SOLOR)", PublicIds.of("dfa80f36-dbe6-5006-8509-c497a26ceab5"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("19762d92-0764-4b58-8f8c-d4873067b64c")))
                .semanticOn(PublicIds.of(UUID.fromString("1621d6f2-58c6-450a-815a-bacfa3963ebc")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2f136e3e-d30c-4af5-9b5d-7ee3b795357d")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a540b12a-fcb5-47f9-ae0f-6b4e7dd573fe")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1a73d63b-a138-4ad8-bcd6-650409ce4213")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0266168d-62b4-4bbf-85bc-7aa7c8898605")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6a24b0bc-f0d6-4f2f-89bf-136514d96d87")), KernelConcept.PREFERRED)
                ;

        set.concept("Taxonomy operator (SOLOR)", PublicIds.of(UUID.fromString("e9252365-7a43-57ea-bf94-3f23bab4ef99"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bd8599d4-72b7-48a6-a705-b0460a8c4ab3")), KernelConcept.ENGLISH_LANGUAGE, "Taxonomy operator (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6a30a50e-3987-442d-9f25-2cdbb16a0ce5")), KernelConcept.ENGLISH_LANGUAGE, "Taxonomy operator", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0ab2fd04-990b-48ab-8604-a33f79d609c7")), KernelConcept.ENGLISH_LANGUAGE, "An operator or set of operations applied within the context of a taxonomy", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("51b738c2-3b91-4115-8b21-48806f2c6d7b")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "e9252365-7a43-57ea-bf94-3f23bab4ef99")
                .statedAxioms(PublicIds.of(UUID.fromString("571792d7-f311-5867-90a7-07d4fb058721")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("74347c40-b684-4236-9b5a-e4e8c1306515")))
                .semanticOn(PublicIds.of(UUID.fromString("bd8599d4-72b7-48a6-a705-b0460a8c4ab3")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4e3eafe5-f8ab-4180-8340-412344591a2d")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6a30a50e-3987-442d-9f25-2cdbb16a0ce5")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c4839d88-811c-4511-b771-1ba19b50c477")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0ab2fd04-990b-48ab-8604-a33f79d609c7")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("36708c6b-6815-4ba5-8e72-4e8e9269ec2c")), KernelConcept.PREFERRED)
                ;

        set.concept("Logically equivalent to (Solor)", PublicIds.of(UUID.fromString("3642d9a3-8e23-5289-836b-366c0b1e2900"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fd286467-2650-414f-af0a-233226691502")), KernelConcept.ENGLISH_LANGUAGE, "Logically equivalent to (Solor)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9177628c-ab61-4899-b8f4-1e8f46362e69")), KernelConcept.ENGLISH_LANGUAGE, "Logically equivalent to", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b60e3e47-963d-4c5c-8c92-be80f28d2bbf")), KernelConcept.ENGLISH_LANGUAGE, "An operator for the reasoner to determine the equivalence", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("2f7b0ecf-a55e-4a8b-ad1e-4634e2c5b870")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "3642d9a3-8e23-5289-836b-366c0b1e2900")
                .statedAxioms(PublicIds.of(UUID.fromString("2690af96-d46e-51e6-8e4d-e5a73b159fb4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Taxonomy operator (SOLOR)", PublicIds.of("e9252365-7a43-57ea-bf94-3f23bab4ef99"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8cf0f051-38ad-42b7-9432-b4c70e74ebdf")))
                .semanticOn(PublicIds.of(UUID.fromString("fd286467-2650-414f-af0a-233226691502")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("96d36c64-c8e0-49dc-b0a8-1b4cd0aa401e")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9177628c-ab61-4899-b8f4-1e8f46362e69")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("37963c8b-f42c-4c78-9511-310216252f70")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b60e3e47-963d-4c5c-8c92-be80f28d2bbf")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9d1ab76a-88ea-4eb2-a291-6f158e66654e")), KernelConcept.PREFERRED)
                ;

        set.concept("Query clauses (SOLOR)", PublicIds.of(UUID.fromString("4905348c-ba1d-58ae-821f-52877d9acee3"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("52449865-aba1-4d32-86a8-4eec7d212c16")), KernelConcept.ENGLISH_LANGUAGE, "Query clauses (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("198ad857-d50a-4083-bd3c-8eb5e56733ad")), KernelConcept.ENGLISH_LANGUAGE, "Query clauses", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("adcea481-76aa-4c3d-b86a-6d34904b1d5a")), KernelConcept.ENGLISH_LANGUAGE, "A distinct component/query that serves a specific purpose", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ac3cee71-87cd-4874-bb61-e1440b553dd0")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "4905348c-ba1d-58ae-821f-52877d9acee3")
                .statedAxioms(PublicIds.of(UUID.fromString("45ee944a-71eb-5eff-83c6-06ee9bb4046a")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0a239fe5-f091-4bbe-a117-a49be10506ef")))
                .semanticOn(PublicIds.of(UUID.fromString("52449865-aba1-4d32-86a8-4eec7d212c16")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fd8987b2-7451-4ab5-9d31-1b6295d93b01")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("198ad857-d50a-4083-bd3c-8eb5e56733ad")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("009fb001-1936-4aac-aa51-40dfae37da58")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("adcea481-76aa-4c3d-b86a-6d34904b1d5a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("24df22bd-dd0b-445c-b6bd-5dec86028391")), KernelConcept.PREFERRED)
                ;

        set.concept("Boolean reference (SOLOR)", PublicIds.of(UUID.fromString("de49d207-a26e-5f8a-b905-953a4dd13c21"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bc8fe272-e40a-4eff-a434-8987cb17ecd7")), KernelConcept.ENGLISH_LANGUAGE, "Boolean reference (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b3964deb-42b8-4f57-b12e-5d0f60cc1767")), KernelConcept.ENGLISH_LANGUAGE, "Boolean reference", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f60d8160-8118-48a3-99eb-ec075d213398")), KernelConcept.ENGLISH_LANGUAGE, "Reference(a pointer) to a Boolean object", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("622158f2-7ffe-4291-a299-6c0ba5581b14")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "de49d207-a26e-5f8a-b905-953a4dd13c21")
                .statedAxioms(PublicIds.of(UUID.fromString("e3109aac-6b95-587a-b129-92bb39863904")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Query clauses (SOLOR)", PublicIds.of("4905348c-ba1d-58ae-821f-52877d9acee3"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("44278e23-656e-4d41-bc1e-06ebcab7e2c7")))
                .semanticOn(PublicIds.of(UUID.fromString("bc8fe272-e40a-4eff-a434-8987cb17ecd7")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("06852ceb-4904-48e1-b8c7-6f3ea8998dcf")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b3964deb-42b8-4f57-b12e-5d0f60cc1767")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0f84389e-5183-43d9-b862-c808ecf6dabe")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f60d8160-8118-48a3-99eb-ec075d213398")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b7eaf5f7-3bc7-41e2-a4b0-dc95a6e46313")), KernelConcept.PREFERRED)
                ;

        set.concept("View coordinate key (SOLOR)", PublicIds.of(UUID.fromString("4211cf36-bd75-586a-805c-51f059e2eaaa"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0ed182de-af4a-4ad2-ade9-7632b911225e")), KernelConcept.ENGLISH_LANGUAGE, "View coordinate key (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d84592c1-205b-4530-a63f-28d87830d140")), KernelConcept.ENGLISH_LANGUAGE, "View Key", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7834e25d-f559-485f-aa5c-f48b7f498c1a")), KernelConcept.ENGLISH_LANGUAGE, "View Key", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("91f727a9-fd62-4199-bb19-4c7a4603472a")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "4211cf36-bd75-586a-805c-51f059e2eaaa")
                .statedAxioms(PublicIds.of(UUID.fromString("74bb9fba-e9f5-5447-874a-77eddd635cae")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Query clauses (SOLOR)", PublicIds.of("4905348c-ba1d-58ae-821f-52877d9acee3"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0c96b847-97ab-4301-abfd-1edf839752f2")))
                .semanticOn(PublicIds.of(UUID.fromString("0ed182de-af4a-4ad2-ade9-7632b911225e")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("be3881fd-6e28-4fff-88bf-b980c35a9fae")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d84592c1-205b-4530-a63f-28d87830d140")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4ee64dfd-5d88-43a2-90cb-c90ec5e2720f")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7834e25d-f559-485f-aa5c-f48b7f498c1a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cfe828ee-c0a3-480e-9e69-c1485fa9d635")), KernelConcept.PREFERRED)
                ;

        set.concept("Literal value (SOLOR)", PublicIds.of(UUID.fromString("208a40a7-e615-5efa-9de0-2e2a5a8488b7"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fd1b6b39-6b4f-46fc-8c3a-8c22cd352e80")), KernelConcept.ENGLISH_LANGUAGE, "Literal value (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("553ebe06-4db7-40b6-9103-e693e4a27768")), KernelConcept.ENGLISH_LANGUAGE, "Literal value", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("66863206-a9c6-4c4b-ae52-4a274692c494")), KernelConcept.ENGLISH_LANGUAGE, "Fixed Value/Constant?", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("86b56924-1c29-4db2-a346-5bd97838ddf5")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "208a40a7-e615-5efa-9de0-2e2a5a8488b7")
                .statedAxioms(PublicIds.of(UUID.fromString("d17c01bd-276e-54fe-a466-f79115b2324e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5eb1d6ba-7782-44be-b9b8-8813e58b4e56")))
                .semanticOn(PublicIds.of(UUID.fromString("fd1b6b39-6b4f-46fc-8c3a-8c22cd352e80")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("04ca0c7e-93c1-486c-b82e-f9d03ce40482")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("553ebe06-4db7-40b6-9103-e693e4a27768")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("aa654b82-6c7b-46de-995d-bc3740cdf780")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("66863206-a9c6-4c4b-ae52-4a274692c494")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5b89ee85-6382-4c1a-a9db-e622b77c9784")), KernelConcept.PREFERRED)
                ;

        set.concept("Boolean literal (SOLOR)", PublicIds.of(UUID.fromString("49f41695-66a7-5471-846d-21c168f54c19"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8b4a5beb-4def-4ea1-ada8-471cea4d3e01")), KernelConcept.ENGLISH_LANGUAGE, "Boolean literal (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6923bd10-54d5-44b0-b3aa-d243c18a9da2")), KernelConcept.ENGLISH_LANGUAGE, "Boolean literal", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5ca5d500-702a-4496-a469-b5aaa970e899")), KernelConcept.ENGLISH_LANGUAGE, "TRUE, FALSE, UNKNOWN", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("decee676-21dd-4807-a6ea-000b30149a7d")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "49f41695-66a7-5471-846d-21c168f54c19")
                .statedAxioms(PublicIds.of(UUID.fromString("60be9b6a-a438-55e4-8cda-009b79ce0d5f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelConcept.LITERAL_VALUE))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4d3436a7-65e5-4c68-ac31-3a7867bc986a")))
                .semanticOn(PublicIds.of(UUID.fromString("8b4a5beb-4def-4ea1-ada8-471cea4d3e01")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("de134d79-eaa3-4de5-8333-a11b2108066b")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6923bd10-54d5-44b0-b3aa-d243c18a9da2")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8b3b8a21-f0e5-4df7-8f38-eb0ef4094b79")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5ca5d500-702a-4496-a469-b5aaa970e899")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("49129137-c547-4689-a29a-ec51c9405d8e")), KernelConcept.PREFERRED)
                ;

        set.concept("Float literal (SOLOR)", PublicIds.of(UUID.fromString("da754dd9-9961-5819-91f5-8245d49850b4"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d6cd8891-a948-4053-8a9d-8196112e2e87")), KernelConcept.ENGLISH_LANGUAGE, "Float literal (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("362320e4-0467-4ffd-851f-a675a082082a")), KernelConcept.ENGLISH_LANGUAGE, "Float literal", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9b63fe62-32b0-4520-8dfd-58ccbd604cb7")), KernelConcept.ENGLISH_LANGUAGE, "Numbers with decimal point or an exponential part", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("473a877a-3691-46c7-9bfe-60baf9b760aa")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "da754dd9-9961-5819-91f5-8245d49850b4")
                .statedAxioms(PublicIds.of(UUID.fromString("7496ce55-0d11-5ab1-a4a1-cb93398c696f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelConcept.LITERAL_VALUE))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9000e5f8-ee87-47a1-9afd-044af3f8c553")))
                .semanticOn(PublicIds.of(UUID.fromString("d6cd8891-a948-4053-8a9d-8196112e2e87")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3a153761-b60c-4c18-affe-316f780c665b")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("362320e4-0467-4ffd-851f-a675a082082a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5fb755bf-fce6-453a-805b-5115951f94f3")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9b63fe62-32b0-4520-8dfd-58ccbd604cb7")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a29d0c3e-804d-4058-8f29-ede705c23cde")), KernelConcept.PREFERRED)
                ;

        set.concept("Instant literal (SOLOR)", PublicIds.of(UUID.fromString("1fbf42e2-42b7-591f-b7fd-ba5de659529e"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("92443d1d-e301-4f71-a753-d12aca69ce74")), KernelConcept.ENGLISH_LANGUAGE, "Instant literal (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4f5ef218-1a4f-4fa9-8f4b-ae6f4c6b6f02")), KernelConcept.ENGLISH_LANGUAGE, "Instant literal", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b71b2c01-0721-490b-8e44-dd7d14ddc33a")), KernelConcept.ENGLISH_LANGUAGE, "May refer to a specific point in time which is often represented by a date or time value", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ac8cb662-0f6e-4b9c-8e5a-dfec7fd041f0")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "1fbf42e2-42b7-591f-b7fd-ba5de659529e")
                .statedAxioms(PublicIds.of(UUID.fromString("9f8680e4-1edb-52db-acba-03ff78c1686b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelConcept.LITERAL_VALUE))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e3f43af6-a5b3-458e-8c23-8e53d4f8a20a")))
                .semanticOn(PublicIds.of(UUID.fromString("92443d1d-e301-4f71-a753-d12aca69ce74")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0d2cd57b-ea88-4d7a-84d6-bfc2a3b42ab6")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4f5ef218-1a4f-4fa9-8f4b-ae6f4c6b6f02")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("666ad93c-69ad-4721-b9b9-6c49eed8a72a")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b71b2c01-0721-490b-8e44-dd7d14ddc33a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bd6face3-449e-47be-820d-2330cfe1d0bb")), KernelConcept.PREFERRED)
                ;

        set.concept("El profile set operator (SOLOR)", PublicIds.of(UUID.fromString("2352b7a2-11fd-5a68-8ece-fcb3b36570da"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1d66f299-b08b-4932-8bad-636d73e41093")), KernelConcept.ENGLISH_LANGUAGE, "El profile set operator (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b6618670-09f9-4d12-8daf-a45b0686d426")), KernelConcept.ENGLISH_LANGUAGE, "EL profile set operator", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("67ee1f67-396f-4742-ac24-abeb0bc93a7e")), KernelConcept.ENGLISH_LANGUAGE, "EL profile set operator", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8f38f1f0-bc98-4f15-873b-c187fa4f671e")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "2352b7a2-11fd-5a68-8ece-fcb3b36570da")
                .statedAxioms(PublicIds.of(UUID.fromString("60502269-2d6e-5b70-933f-936bf817d850")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e2214fc2-5822-4f9a-a4e6-3a1cb73f2734")))
                .semanticOn(PublicIds.of(UUID.fromString("1d66f299-b08b-4932-8bad-636d73e41093")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4041dd63-cfea-46f7-8974-47abf7114cf2")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b6618670-09f9-4d12-8daf-a45b0686d426")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("35dfd9cf-717c-4174-8157-33de8f018947")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("67ee1f67-396f-4742-ac24-abeb0bc93a7e")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3e250254-dbe8-4028-ae5f-3783fc50dc8b")), KernelConcept.PREFERRED)
                ;

        set.concept("Connective operator (SOLOR)", PublicIds.of(UUID.fromString("3fdcaadc-d972-58e9-84f1-b3a39903b076"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cd6e3dde-c4ee-41eb-92e6-5695f07362ca")), KernelConcept.ENGLISH_LANGUAGE, "Connective operator (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c9791adc-078a-4054-bea1-45bceb763e26")), KernelConcept.ENGLISH_LANGUAGE, "Connective operator", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("eff327b2-2412-4597-83d1-84af9bae076e")), KernelConcept.ENGLISH_LANGUAGE, "A field that captures what the operator is (logical connective)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ede9d3e0-8aee-43d1-9c5f-6c6c616dbc8a")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "3fdcaadc-d972-58e9-84f1-b3a39903b076")
                .statedAxioms(PublicIds.of(UUID.fromString("31c7ab09-a4fa-59b6-837a-527f61bc00db")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0a99546d-890e-478e-a44d-68f95a3f1ba4")))
                .semanticOn(PublicIds.of(UUID.fromString("cd6e3dde-c4ee-41eb-92e6-5695f07362ca")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("175a1e40-7dd4-4970-a7f2-e891031e3bcc")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c9791adc-078a-4054-bea1-45bceb763e26")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("59148f47-fddc-4bfb-bdce-e8e180abfc2a")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("eff327b2-2412-4597-83d1-84af9bae076e")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c1532d8d-0404-4f29-ad0c-8bd4e68d276f")), KernelConcept.PREFERRED)
                ;

        // Partonomy seat (IKE-Network/ike-issues#950): the baseline filed Part of under
        // Connective operator, but part-of is not a logical connective like And/Or — it
        // is a role type. Property-shaped definition, SNOMED-style: the PropertySet's
        // Role type reference is a super-role edge, and Transitive Feature marks the
        // role transitive (ElkSnomedDataBuilder reads exactly this shape). Part→whole is
        // the one canonical direction — EL++ has no inverse roles, so has-part is never
        // minted. Registered in DELIBERATELY_PROPERTY_SHAPED.
        set.concept("Part of (SOLOR)", PublicIds.of(UUID.fromString("b4c3f6f9-6937-30fd-8412-d0c77f8a7f73"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e113e1e1-beca-4094-9681-5d9be32b1808")), KernelConcept.ENGLISH_LANGUAGE, "Part of (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3f8ead82-e795-46d1-b2c5-861006540a85")), KernelConcept.ENGLISH_LANGUAGE, "Part of", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("137c6a4a-4771-4f9b-ac38-d4e51a8d7852")), KernelConcept.ENGLISH_LANGUAGE, "The partonomy role type: an existential Part of restriction in a definition states that the defined concept is part of the restriction's whole, in the part-to-whole direction. Declared transitive, so part-of chains compose during classification; distinct from kind-of, which the taxonomy alone carries.", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f52672c9-fb15-4672-84d0-37ca6416ed6f")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "b4c3f6f9-6937-30fd-8412-d0c77f8a7f73")
                .statedAxioms(PublicIds.of(UUID.fromString("d26656f3-219b-577c-ac5d-84d397928be0")), leb -> leb.PropertySet(leb.And(leb.ConceptAxiom(KernelConcept.ROLE_TYPE), leb.ConceptAxiom(EntityProxy.Concept.make("Transitive Feature (SOLOR)", PublicIds.of("53f866d0-fd61-5c85-a16c-150bd619a0ac"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("853068d1-b199-4188-b522-58fcfa7a2234")))
                .semanticOn(PublicIds.of(UUID.fromString("e113e1e1-beca-4094-9681-5d9be32b1808")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("eedf3bfa-b8fb-4279-a822-e5ad6c43c223")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3f8ead82-e795-46d1-b2c5-861006540a85")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8a1499c9-640b-401e-8585-e0b6dc792b2f")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("137c6a4a-4771-4f9b-ac38-d4e51a8d7852")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2a83c14e-e7d7-4dee-8332-68f830780e71")), KernelConcept.PREFERRED)
                ;

        set.concept("Definition root (SOLOR)", PublicIds.of(UUID.fromString("e7271c01-6ed4-5240-963f-34d1f24153b0"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("47b18a9f-2225-42e2-903e-b404ddb7da6f")), KernelConcept.ENGLISH_LANGUAGE, "Definition root (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("95958dcb-81d2-42b5-98a0-3bf06192f41a")), KernelConcept.ENGLISH_LANGUAGE, "Definition root", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9531fd02-7674-45f5-b682-ca2a3a51f5f4")), KernelConcept.ENGLISH_LANGUAGE, "Definition root", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("9762a4d9-a9ce-45a7-bd8e-dc6a7cb2be3f")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "e7271c01-6ed4-5240-963f-34d1f24153b0")
                .statedAxioms(PublicIds.of(UUID.fromString("47a048e5-d731-5961-a989-4f4088fa5ef2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical expression vertex (IkeFoundation)")))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("39200da6-8767-4f88-bc9b-5f4ae9cf8db4")))
                .semanticOn(PublicIds.of(UUID.fromString("47b18a9f-2225-42e2-903e-b404ddb7da6f")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("388ae25b-8e27-46a5-a3ad-8dfbcbce6939")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("95958dcb-81d2-42b5-98a0-3bf06192f41a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("29829acd-2d6c-4533-b65f-5214a4ae6e3b")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9531fd02-7674-45f5-b682-ca2a3a51f5f4")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a4fd7f5c-ee67-4764-96df-e0b52148af9e")), KernelConcept.PREFERRED)
                ;

        set.concept("Concept reference (SOLOR)", PublicIds.of(UUID.fromString("e89148c7-4fe2-52f8-abb9-6a53605d20cb"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d1b64b1d-08bd-47ef-94bd-a2c97d5e50df")), KernelConcept.ENGLISH_LANGUAGE, "Concept reference (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e1f6334b-9f0a-4345-8ca8-6523d4a048e3")), KernelConcept.ENGLISH_LANGUAGE, "Concept reference", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("49d9cf9c-c233-4fff-b9bd-e8fe9270ae1a")), KernelConcept.ENGLISH_LANGUAGE, "A field to capture a reference to validate concept", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f6d9952c-91b9-476d-839d-a0354d38cc3f")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "e89148c7-4fe2-52f8-abb9-6a53605d20cb")
                .statedAxioms(PublicIds.of(UUID.fromString("d42be61b-7e1e-5e2a-9b04-4f36b30e0e2e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical expression vertex (IkeFoundation)")))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8a83de71-d243-4ec7-8654-90b3cef169ce")))
                .semanticOn(PublicIds.of(UUID.fromString("d1b64b1d-08bd-47ef-94bd-a2c97d5e50df")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6e2ce9e7-e21d-4a45-8500-9ae892a7b025")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e1f6334b-9f0a-4345-8ca8-6523d4a048e3")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("286ee738-5916-411d-a50d-37801192d04d")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("49d9cf9c-c233-4fff-b9bd-e8fe9270ae1a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ff73ed91-a41b-4be3-9ca6-f683b0338d1c")), KernelConcept.PREFERRED)
                ;

        set.concept("Disjoint with (SOLOR)", PublicIds.of(UUID.fromString("f8433993-9a2d-5377-b564-80a45c7b7824"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("89246399-f1ba-4b42-9ea8-9d3f477e7f56")), KernelConcept.ENGLISH_LANGUAGE, "Disjoint with (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8225cd3d-ffa1-4b1c-95e9-b96646a05812")), KernelConcept.ENGLISH_LANGUAGE, "Disjoint with", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("588e4e87-66b5-4ff0-b06c-25514e8ebcc6")), KernelConcept.ENGLISH_LANGUAGE, "An operator", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ec0b9179-b45f-42e1-b703-2d1450bf826a")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "f8433993-9a2d-5377-b564-80a45c7b7824")
                .statedAxioms(PublicIds.of(UUID.fromString("ea322501-e677-5423-a234-f834b72b3874")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Connective operator (SOLOR)", PublicIds.of("3fdcaadc-d972-58e9-84f1-b3a39903b076"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b50d5c8f-85da-48de-9280-1f249895e314")))
                .semanticOn(PublicIds.of(UUID.fromString("89246399-f1ba-4b42-9ea8-9d3f477e7f56")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cd05cb10-b5b1-4d17-8480-587b385e88fc")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("8225cd3d-ffa1-4b1c-95e9-b96646a05812")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0df7a52e-3791-45f5-a7c0-b777cd38855d")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("588e4e87-66b5-4ff0-b06c-25514e8ebcc6")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("be4311b9-3f4f-4b90-a040-5370550a5bf9")), KernelConcept.PREFERRED)
                ;

        set.concept("EL++ AND (SOLOR)", PublicIds.of(UUID.fromString("fa113d51-07d2-587c-8930-0bce207d506d"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("67fbbff2-ee64-4cc4-ad55-10341abf791c")), KernelConcept.ENGLISH_LANGUAGE, "EL++ AND (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fe20c680-3ce1-4183-9932-9f8f7d3b6d47")), KernelConcept.ENGLISH_LANGUAGE, "EL++ AND", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("da48766d-c894-4b83-8848-0c384503ec35")), KernelConcept.ENGLISH_LANGUAGE, "A connective operator that joins two or more classes and requires every one of them: the result is the class of things that belong to every operand class, their intersection. The EL++ conjunction, and the connective every stated axiom in this set is built with. Renamed and re-parented in place from the inherited And (IKE-Network/ike-issues#1089).", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("28fc9d8e-8189-4158-ac67-08092ba7d884")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "fa113d51-07d2-587c-8930-0bce207d506d")
                .statedAxioms(PublicIds.of(UUID.fromString("62a05e95-5cff-57d1-9d4e-d7ac7dfd2764")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Generic AND (IkeFoundation)")))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9551c20a-5297-4f86-9886-1f331652bb2b")))
                .semanticOn(PublicIds.of(UUID.fromString("67fbbff2-ee64-4cc4-ad55-10341abf791c")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0b26d822-9ece-4e14-92ca-03d13fd1dde6")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("fe20c680-3ce1-4183-9932-9f8f7d3b6d47")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a04645ce-97cc-4043-8f4e-cfae6308adff")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("da48766d-c894-4b83-8848-0c384503ec35")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2e2f50ca-9f0e-4306-a233-69d7a7027ab2")), KernelConcept.PREFERRED)
                ;

        set.concept("Generic OR (SOLOR)", PublicIds.of(UUID.fromString("2c940bcf-22a8-5fc9-b232-580021e758ed"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d1bdda9f-406e-48bc-ad51-b8b5a98ef8b6")), KernelConcept.ENGLISH_LANGUAGE, "Generic OR (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("31ff3b02-bc11-4961-ab92-98445fef6666")), KernelConcept.ENGLISH_LANGUAGE, "Generic OR", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("86aa1210-ce5b-43c0-8992-7bbec849a129")), KernelConcept.ENGLISH_LANGUAGE, "A connective operator that joins two or more operands of one kind into a result of that same kind. The operation combines all of the operands to produce the result, and their order and grouping make no difference. OR means any one operand is enough, so the result is whatever is at least one of the operands. Adding another operand can only widen the result, never narrow it. Each descendant applies this to one kind of operand: Set OR keeps the members found in any operand set, whatever kind of thing they are, and Presence OR is Present when any operand is Present. EL++ has no OR, so there is no class instance; the inherited Or concept is the generic itself, keeping the identity the axiom adaptor holds for a disjunction vertex (IKE-Network/ike-issues#1089).", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("fe01ce11-9845-4f40-bb2a-dd8b915b9870")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "2c940bcf-22a8-5fc9-b232-580021e758ed")
                .statedAxioms(PublicIds.of(UUID.fromString("2fafc0bd-a2bf-5f75-b51d-981213022bf8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Connective operator (SOLOR)", PublicIds.of("3fdcaadc-d972-58e9-84f1-b3a39903b076"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("debb47cb-b51c-40ea-879f-1796ba500cfa")))
                .semanticOn(PublicIds.of(UUID.fromString("d1bdda9f-406e-48bc-ad51-b8b5a98ef8b6")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("05b505f4-1a3e-4a0c-8e8f-069ca241e814")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("31ff3b02-bc11-4961-ab92-98445fef6666")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cab62a72-5d6c-415a-8925-1b9daf624672")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("86aa1210-ce5b-43c0-8992-7bbec849a129")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1de136f7-b416-467b-b065-eb6846714482")), KernelConcept.PREFERRED)
                ;

        set.concept("Presentation unit different (SOLOR)", PublicIds.of(UUID.fromString("e86d3887-717b-545f-b6b5-611210913b23"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5f2c86be-8c05-4029-84bc-3f46f2dae260")), KernelConcept.ENGLISH_LANGUAGE, "Presentation unit different (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d031a50d-9d36-43a7-8cf0-dd5587342b7a")), KernelConcept.ENGLISH_LANGUAGE, "Presentation unit different", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("959e694a-8d31-4ed4-8471-ab16408f6324")), KernelConcept.ENGLISH_LANGUAGE, "Unit difference", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("00ac89e2-1a3d-4bbf-bdda-3236d84e5502")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "e86d3887-717b-545f-b6b5-611210913b23")
                .statedAxioms(PublicIds.of(UUID.fromString("09d399ff-a165-533a-be5f-69187ba5a10f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("03a39435-794a-4a77-a56e-3c763d22d687")))
                .semanticOn(PublicIds.of(UUID.fromString("5f2c86be-8c05-4029-84bc-3f46f2dae260")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("eb5540d2-d5e6-4a2c-8efc-93885d7e88e8")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d031a50d-9d36-43a7-8cf0-dd5587342b7a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1b3c50b2-13ee-434a-9698-fc17139c8d53")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("959e694a-8d31-4ed4-8471-ab16408f6324")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a4fe49a2-9032-40a2-a2bf-dcf849b1b635")), KernelConcept.PREFERRED)
                ;

        set.concept("Semantic type (SOLOR)", PublicIds.of(UUID.fromString("3daac6c4-78c5-5271-9c63-6e28f80e0c52"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f88d7c03-b8e2-4121-957d-c3754f359aa2")), KernelConcept.ENGLISH_LANGUAGE, "Semantic type (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("00e92c69-7bf6-4eef-a5ba-dc833890ecb1")), KernelConcept.ENGLISH_LANGUAGE, "Semantic type", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d50522c6-cb40-46b5-bc15-bc2702c5e504")), KernelConcept.ENGLISH_LANGUAGE, "Type- semantic", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("b7b0fefb-ffb9-414e-8b8b-cee3e080c9ed")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "3daac6c4-78c5-5271-9c63-6e28f80e0c52")
                .statedAxioms(PublicIds.of(UUID.fromString("11f47aa2-72c7-58e8-8c6c-0da878a2fedc")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("078c710a-e6cf-4b74-b7b3-478dff2b29ef")))
                .semanticOn(PublicIds.of(UUID.fromString("f88d7c03-b8e2-4121-957d-c3754f359aa2")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9623971f-2542-4e3d-9e18-76fa4cb4627e")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("00e92c69-7bf6-4eef-a5ba-dc833890ecb1")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5e81206b-c46b-4e71-bd95-0d4ab99b7386")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d50522c6-cb40-46b5-bc15-bc2702c5e504")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fe350630-3652-404e-bf94-4845eaa40874")), KernelConcept.PREFERRED)
                ;

        set.concept("Membership semantic (SOLOR)", PublicIds.of(UUID.fromString("4fa29287-a80e-5f83-abab-4b587973e7b7"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1999d47f-ad03-46e4-89e4-b6321a66ef46")), KernelConcept.ENGLISH_LANGUAGE, "Membership semantic (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("043e8209-636a-478b-b77c-dddae5c83b54")), KernelConcept.ENGLISH_LANGUAGE, "Membership semantic", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ad8203ec-3758-4011-9d6b-2540e67cf971")), KernelConcept.ENGLISH_LANGUAGE, "The semantic type carrying no fields: a semantic whose entire content is that its referenced component belongs to the pattern's own set. The SOLOR-era name for what this starter set's own content now calls Set membership.", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("704fd75a-22fd-418d-a689-931eb699e624")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "4fa29287-a80e-5f83-abab-4b587973e7b7")
                .statedAxioms(PublicIds.of(UUID.fromString("a59d2482-f28e-5012-a3fa-800ac95f4caa")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Semantic type (SOLOR)", PublicIds.of("3daac6c4-78c5-5271-9c63-6e28f80e0c52"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("039dd526-8474-4d53-9af1-e7d326f973a7")))
                .semanticOn(PublicIds.of(UUID.fromString("1999d47f-ad03-46e4-89e4-b6321a66ef46")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("10398842-6944-42a2-9831-60f35bede0e0")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("043e8209-636a-478b-b77c-dddae5c83b54")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c4e4ea0f-992e-491d-b53c-e3999ac99578")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ad8203ec-3758-4011-9d6b-2540e67cf971")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9e68f675-38a0-45e9-a1bc-afe30dbbed20")), KernelConcept.PREFERRED)
                ;

        set.concept("Logical expression semantic (SOLOR)", PublicIds.of(UUID.fromString("d19306b1-4744-5028-a715-17ca4a4d657f"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e2a5e8ea-ec82-4236-89a9-cff292fc1225")), KernelConcept.ENGLISH_LANGUAGE, "Logical expression semantic (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("63a7785c-9270-4028-855a-0faaa7c58324")), KernelConcept.ENGLISH_LANGUAGE, "Logical expression semantic", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0f0262b2-61cd-4797-8316-6553201af838")), KernelConcept.ENGLISH_LANGUAGE, "Logical expression semantic", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("5e781d0c-5e94-4810-aa6c-eae8290a4b87")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "d19306b1-4744-5028-a715-17ca4a4d657f")
                .statedAxioms(PublicIds.of(UUID.fromString("989a7a4b-fea8-5a0d-8b7f-62d49317aef2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Semantic type (SOLOR)", PublicIds.of("3daac6c4-78c5-5271-9c63-6e28f80e0c52"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("83b4fd7e-bae8-4f09-bffd-90f7c8752edf")))
                .semanticOn(PublicIds.of(UUID.fromString("e2a5e8ea-ec82-4236-89a9-cff292fc1225")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a04efdc4-4ae0-4517-b709-4ac703eab0e7")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("63a7785c-9270-4028-855a-0faaa7c58324")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3efae622-ce0c-4550-83b6-6df157b75990")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0f0262b2-61cd-4797-8316-6553201af838")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b2e43065-a3e7-4874-90b2-e611c8b64a35")), KernelConcept.PREFERRED)
                ;

        set.concept("Component semantic (SOLOR)", PublicIds.of(UUID.fromString("127e7274-0b88-5519-a9db-85d4b9ce6a4a"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("69512191-8bae-4d04-96ce-342d7507de03")), KernelConcept.ENGLISH_LANGUAGE, "Component semantic (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a4356a8f-1507-4732-8fde-119140ccdca2")), KernelConcept.ENGLISH_LANGUAGE, "Component Semantic", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1d057ec5-29cb-4d4f-84e4-a25582bea512")), KernelConcept.ENGLISH_LANGUAGE, "Component semantic", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("d7f5ee7c-29c8-479c-b6bc-59221e9eab95")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "127e7274-0b88-5519-a9db-85d4b9ce6a4a")
                .statedAxioms(PublicIds.of(UUID.fromString("94b7696e-01d7-5f28-a1f4-7340daea487d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Semantic type (SOLOR)", PublicIds.of("3daac6c4-78c5-5271-9c63-6e28f80e0c52"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("33b0ff7c-b355-4035-a320-c8cfcb7116ee")))
                .semanticOn(PublicIds.of(UUID.fromString("69512191-8bae-4d04-96ce-342d7507de03")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c8970f83-675f-43c5-a794-f6d5c2bf6a6f")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a4356a8f-1507-4732-8fde-119140ccdca2")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9e5ae8fb-03aa-4264-9b05-fa92e197ae09")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1d057ec5-29cb-4d4f-84e4-a25582bea512")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a985e148-f269-4727-a26f-447d555f63e7")), KernelConcept.PREFERRED)
                ;

        set.concept("Concept semantic (SOLOR)", PublicIds.of(UUID.fromString("fbf054fb-ceaf-5ab8-b946-bbcc4835ce07"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bcfa9b7d-b7ab-4248-8bc9-fa3a4f07c681")), KernelConcept.ENGLISH_LANGUAGE, "Concept semantic (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("befeb927-3bf1-492f-87ca-181d89badd1a")), KernelConcept.ENGLISH_LANGUAGE, "Concept semantic", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("00676b82-c18a-461e-b6b7-75b1877afb8d")), KernelConcept.ENGLISH_LANGUAGE, "Value to define a given semantic as a concept", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("a90e7353-5262-4b4a-a7b4-260e943b57d3")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "fbf054fb-ceaf-5ab8-b946-bbcc4835ce07")
                .statedAxioms(PublicIds.of(UUID.fromString("a9c452a1-ed41-54a6-8bf7-bf4862a6c055")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Semantic type (SOLOR)", PublicIds.of("3daac6c4-78c5-5271-9c63-6e28f80e0c52"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("16c4481e-6cb6-4ccf-9dd9-a4cee72a22c1")))
                .semanticOn(PublicIds.of(UUID.fromString("bcfa9b7d-b7ab-4248-8bc9-fa3a4f07c681")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("88a8c0b2-1a01-490d-aa62-cc6dc5aabadf")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("befeb927-3bf1-492f-87ca-181d89badd1a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9bdace3b-8404-4650-b6e0-04b0689d6d6e")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("00676b82-c18a-461e-b6b7-75b1877afb8d")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0c1a22c0-1288-4fca-8b07-194a35fa7075")), KernelConcept.PREFERRED)
                ;

        set.concept("Field substitution (SOLOR)", PublicIds.of(UUID.fromString("8fdce1aa-ca82-5abc-8cfa-230c14688abc"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8cf086e0-64a7-42be-9e54-c6e7ce0a6c38")), KernelConcept.ENGLISH_LANGUAGE, "Field substitution (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7b3b5efe-f8c6-4a5f-9eee-bf70aaef5a88")), KernelConcept.ENGLISH_LANGUAGE, "Field substitution", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("053f5a81-88bc-4c6c-ab8f-cbe151769414")), KernelConcept.ENGLISH_LANGUAGE, "Replacing a placeholder variable in a field with a specific value", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("174f8333-6624-441a-ba67-5302240479c5")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "8fdce1aa-ca82-5abc-8cfa-230c14688abc")
                .statedAxioms(PublicIds.of(UUID.fromString("04e038c4-924f-563d-8bea-3f050e39a41d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("fcc1fc26-6db4-4495-897b-8c251aec7e54")))
                .semanticOn(PublicIds.of(UUID.fromString("8cf086e0-64a7-42be-9e54-c6e7ce0a6c38")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c7afc494-3c5e-4f3c-95b2-f9a9ef09de8f")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7b3b5efe-f8c6-4a5f-9eee-bf70aaef5a88")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d54d416a-303e-4b33-bdd8-90fa5367e790")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("053f5a81-88bc-4c6c-ab8f-cbe151769414")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e44fb04a-ec2c-4384-9df7-ab2a9e9f133b")), KernelConcept.PREFERRED)
                ;

        set.concept("Concept substitution (SOLOR)", PublicIds.of(UUID.fromString("23483990-b738-5f43-bc03-befd43928a37"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2b2f6d2c-e424-48e9-8bd7-f49a68979bd7")), KernelConcept.ENGLISH_LANGUAGE, "Concept substitution (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f1172066-51a0-4bc4-9a5e-40f47b71acc6")), KernelConcept.ENGLISH_LANGUAGE, "Concept substitution", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4ac1517d-d86c-49e6-8750-979191b2f400")), KernelConcept.ENGLISH_LANGUAGE, "Substitution for concept", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("3bebbc7b-1ec5-4516-9f19-432712c45454")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "23483990-b738-5f43-bc03-befd43928a37")
                .statedAxioms(PublicIds.of(UUID.fromString("95cd4824-576d-5564-b531-af1484128295")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field substitution (SOLOR)", PublicIds.of("8fdce1aa-ca82-5abc-8cfa-230c14688abc"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f4a9847f-f95a-468f-b8af-8d069d552921")))
                .semanticOn(PublicIds.of(UUID.fromString("2b2f6d2c-e424-48e9-8bd7-f49a68979bd7")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("88d972f9-5796-4b80-9586-6d44cf2a98ea")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f1172066-51a0-4bc4-9a5e-40f47b71acc6")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("96ba1185-81c6-4270-ae6c-e604bd2f712b")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4ac1517d-d86c-49e6-8750-979191b2f400")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6d9222bf-15ad-4b4f-883d-20466ab3eb19")), KernelConcept.PREFERRED)
                ;

        set.concept("Boolean substitution (SOLOR)", PublicIds.of(UUID.fromString("03559f9d-f1e4-5485-894b-4d457f145d54"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("824d7961-66ce-4068-8412-6b6d1870b921")), KernelConcept.ENGLISH_LANGUAGE, "Boolean substitution (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b5bf50a8-05ab-4431-850f-4d57e410c471")), KernelConcept.ENGLISH_LANGUAGE, "Boolean substitution", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4ce9be33-bbd1-449c-8e20-0e3efd81131e")), KernelConcept.ENGLISH_LANGUAGE, "The process of replacing or substituting boolean values or expression in a logical context", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("99f0276a-c3a8-492c-88a2-9df2c2560acc")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "03559f9d-f1e4-5485-894b-4d457f145d54")
                .statedAxioms(PublicIds.of(UUID.fromString("13fd7530-1829-58a6-94df-ba350df1f522")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field substitution (SOLOR)", PublicIds.of("8fdce1aa-ca82-5abc-8cfa-230c14688abc"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("aa6e103d-6251-4315-bebb-b7ed3ef6b5e6")))
                .semanticOn(PublicIds.of(UUID.fromString("824d7961-66ce-4068-8412-6b6d1870b921")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8e55d6b2-5f19-4d92-b0ee-082e82fd384e")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b5bf50a8-05ab-4431-850f-4d57e410c471")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("12d33654-df5a-4aa0-b039-d76c0576daf6")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4ce9be33-bbd1-449c-8e20-0e3efd81131e")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a5ef6f85-3583-4a96-9467-3a70a5d5e1dd")), KernelConcept.PREFERRED)
                ;

        set.concept("Float substitution (SOLOR)", PublicIds.of(UUID.fromString("cf18fe25-bd21-586e-9da4-da6cb335fd12"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ebf281e6-c131-4c42-9f40-b060a1ca3f82")), KernelConcept.ENGLISH_LANGUAGE, "Float substitution (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a7c34ee5-ce24-49c1-b0fe-31c2334603b7")), KernelConcept.ENGLISH_LANGUAGE, "Float substitution", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6a7aebf2-4c73-4fd3-bfb9-c6bacf596628")), KernelConcept.ENGLISH_LANGUAGE, "Float substitution", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e5049540-7099-4c5b-8899-997ce8d691fa")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "cf18fe25-bd21-586e-9da4-da6cb335fd12")
                .statedAxioms(PublicIds.of(UUID.fromString("4fcb8491-9a09-580b-8e57-86841657b067")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field substitution (SOLOR)", PublicIds.of("8fdce1aa-ca82-5abc-8cfa-230c14688abc"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a27d8540-179f-4cc1-a58c-95b5cb8ef167")))
                .semanticOn(PublicIds.of(UUID.fromString("ebf281e6-c131-4c42-9f40-b060a1ca3f82")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48b4aac5-8c8e-4162-993b-8570272d3b11")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a7c34ee5-ce24-49c1-b0fe-31c2334603b7")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("95b7660b-ca83-4b40-a4e2-209a3d4f3b44")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6a7aebf2-4c73-4fd3-bfb9-c6bacf596628")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("119038a0-ba8b-4a53-a54e-027b3fdd5200")), KernelConcept.PREFERRED)
                ;

        set.concept("Instant substitution (SOLOR)", PublicIds.of(UUID.fromString("56599345-31c5-5817-9d36-57dd3a626b3a"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8c9f17f6-d07a-4ff7-bb04-ec8eabf1148e")), KernelConcept.ENGLISH_LANGUAGE, "Instant substitution (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e4e4c66f-8ffd-407a-9738-f9433002a4d6")), KernelConcept.ENGLISH_LANGUAGE, "Instant substitution", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0c15be4b-c27b-406e-a358-011579b1ae5a")), KernelConcept.ENGLISH_LANGUAGE, "Substitution of instant literal?", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("1dd27a33-9841-4880-84f0-731a9b6f25a9")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "56599345-31c5-5817-9d36-57dd3a626b3a")
                .statedAxioms(PublicIds.of(UUID.fromString("2a084388-a673-5f07-90e6-4dd7e6f7da9b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Field substitution (SOLOR)", PublicIds.of("8fdce1aa-ca82-5abc-8cfa-230c14688abc"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("eb62e683-b51b-4dd2-b8f0-699285f2e2c3")))
                .semanticOn(PublicIds.of(UUID.fromString("8c9f17f6-d07a-4ff7-bb04-ec8eabf1148e")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("49c189bf-df57-42eb-8df9-c5d75bb2104f")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e4e4c66f-8ffd-407a-9738-f9433002a4d6")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("76404adc-11c0-46c5-906d-d35f87c5266b")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0c15be4b-c27b-406e-a358-011579b1ae5a")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("65f07d63-c736-49ee-84ed-bc07e0ab020b")), KernelConcept.PREFERRED)
                ;

        set.concept("Text comparison measure semantic (SOLOR)", PublicIds.of(UUID.fromString("b1531e68-4e7a-5194-b1f9-9aaace269372"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a801859c-2567-45e6-a2ba-16775c79ec92")), KernelConcept.ENGLISH_LANGUAGE, "Text comparison measure semantic (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("31cd5129-3daf-40ff-bed3-54327c16cf5e")), KernelConcept.ENGLISH_LANGUAGE, "Text comparison", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("db885379-127b-4c1a-a54f-0cac54367b95")), KernelConcept.ENGLISH_LANGUAGE, "Text comparison with a focus on semantic meaning involves evaluating the similarity or relatedness between pieces of text based on their underlying meaning rather than just their surface structure.", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0010946f-1487-464e-82ba-8c84999afa2d")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "b1531e68-4e7a-5194-b1f9-9aaace269372")
                .statedAxioms(PublicIds.of(UUID.fromString("0421d127-d86e-5058-831f-d64f1641380f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("77718e76-e891-4675-8971-fe77823eefef")))
                .semanticOn(PublicIds.of(UUID.fromString("a801859c-2567-45e6-a2ba-16775c79ec92")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("059ae086-23b0-4776-b851-18f2c0e32a02")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("31cd5129-3daf-40ff-bed3-54327c16cf5e")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("80a64330-4a06-4bae-b287-178cf856ad05")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("db885379-127b-4c1a-a54f-0cac54367b95")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f664f280-52dd-4f15-8333-1e4d3ea5d7de")), KernelConcept.PREFERRED)
                ;

        set.concept("Case insensitive evaluation (SOLOR)", PublicIds.of(UUID.fromString("74bbdaff-f061-5807-b334-3c88ac3e9421"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("343679d7-b488-4b14-b934-01f8491bd538")), KernelConcept.ENGLISH_LANGUAGE, "Case insensitive evaluation (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("02d483bf-b203-4317-9de5-a750120522a8")), KernelConcept.ENGLISH_LANGUAGE, "Ignore case", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("64889612-262d-4df9-bd21-0190e4150f05")), KernelConcept.ENGLISH_LANGUAGE, "Evaluates values regardless of the case", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8713da2a-efbd-40df-8696-9342ded82480")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "74bbdaff-f061-5807-b334-3c88ac3e9421")
                .statedAxioms(PublicIds.of(UUID.fromString("40b3b2c3-94a0-54ed-9b62-e3e3de512d17")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Text comparison measure semantic (SOLOR)", PublicIds.of("b1531e68-4e7a-5194-b1f9-9aaace269372"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a1579e96-7b89-4438-983e-a1a2ae495aba")))
                .semanticOn(PublicIds.of(UUID.fromString("343679d7-b488-4b14-b934-01f8491bd538")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("62a58feb-9cec-40e8-80c2-df311d30ef4f")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("02d483bf-b203-4317-9de5-a750120522a8")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("90a02ab4-36c2-4cf5-be4d-bcaea69370cb")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("64889612-262d-4df9-bd21-0190e4150f05")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("de533026-90a1-43c2-b339-da63a90dd726")), KernelConcept.PREFERRED)
                ;

        set.concept("Case sensitive evaluation (SOLOR)", PublicIds.of(UUID.fromString("a95e5dbc-a179-57f9-9cdd-6de8c026396d"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("03e60776-79d2-42d6-aa4d-389de6969f80")), KernelConcept.ENGLISH_LANGUAGE, "Case sensitive evaluation (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("64fa3aab-ccd4-4c87-802e-4b0bca107ccc")), KernelConcept.ENGLISH_LANGUAGE, "Compare case", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6ec81c0d-30ff-4723-bd71-01b8750eb746")), KernelConcept.ENGLISH_LANGUAGE, "Evaluated based on the case", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("cfd8e056-2915-4c6f-a89a-123244f983e2")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "a95e5dbc-a179-57f9-9cdd-6de8c026396d")
                .statedAxioms(PublicIds.of(UUID.fromString("237b4b00-05b9-538c-8e30-193bd9eb0c9f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Text comparison measure semantic (SOLOR)", PublicIds.of("b1531e68-4e7a-5194-b1f9-9aaace269372"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("2280f4a8-58be-49ed-a59d-80f95e761e84")))
                .semanticOn(PublicIds.of(UUID.fromString("03e60776-79d2-42d6-aa4d-389de6969f80")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b1ecb8dc-ec90-43d1-9724-b34a0c2704b7")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("64fa3aab-ccd4-4c87-802e-4b0bca107ccc")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("78edfb63-1b67-4067-93fb-db392fd91b6a")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6ec81c0d-30ff-4723-bd71-01b8750eb746")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48ef818a-d3fc-465a-8c5e-7f112e6e91e9")), KernelConcept.PREFERRED)
                ;

    }
}
