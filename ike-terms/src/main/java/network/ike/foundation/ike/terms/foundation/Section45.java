package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Description case significance" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section45 {

    private Section45() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description case significance", PublicIds.of(UUID.fromString("c3dde9ea-b144-5f49-845a-20cc7d305250"), UUID.fromString("f30b0312-2c85-3e65-8609-2d89f8437d34"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("60e732f5-b3b4-4ebd-b6ae-66122fc4e76c")), KernelTerm.ENGLISH_LANGUAGE, "Description case significance", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a460e8cc-74a9-460e-87db-b340d763f15b")), KernelTerm.ENGLISH_LANGUAGE, "Description case significance", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ea380386-a5cb-4e1e-9419-6097f0411e69")), KernelTerm.ENGLISH_LANGUAGE, "Specifies how to handle the description text in terms of case sensitivity", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0333c0ec-64a3-451c-b8e7-0ddddd0f1ad3")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "c3dde9ea-b144-5f49-845a-20cc7d305250")
                .statedAxioms(PublicIds.of(UUID.fromString("bc6d523f-953c-5e7a-b9ea-a30efcf8444b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5c68ac1a-d1a8-4e98-9675-8a7e019823af")))
                .semanticOn(PublicIds.of(UUID.fromString("60e732f5-b3b4-4ebd-b6ae-66122fc4e76c")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fabc6be1-7725-4fc4-98fa-747d9c2b610d")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a460e8cc-74a9-460e-87db-b340d763f15b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a5fb88df-61bb-4c56-b06c-5a207d4ee3c6")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ea380386-a5cb-4e1e-9419-6097f0411e69")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fbb721da-a7ba-483e-943b-d42432b33756")), KernelTerm.PREFERRED)
                ;

        set.concept("Description not case sensitive", PublicIds.of(UUID.fromString("ecea41a2-f596-3d98-99d1-771b667e55b8"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fe9b4e5c-268b-40e8-b857-462b2e8aa6d0")), KernelTerm.ENGLISH_LANGUAGE, "Description not case sensitive", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("abdbd41a-4aa3-4a3f-8a89-86fd70760170")), KernelTerm.ENGLISH_LANGUAGE, "Case insensitive", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b7456e5f-362a-4eda-a164-4fdd0c10c284")), KernelTerm.ENGLISH_LANGUAGE, "Value which designate character as not sensitive for a given description", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e27cd9cb-4a46-46cf-bff5-535212b4e2b8")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "ecea41a2-f596-3d98-99d1-771b667e55b8")
                .statedAxioms(PublicIds.of(UUID.fromString("fe4f7734-04dd-5bd6-ad8a-eabdd8679d31")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelTerm.DESCRIPTION_CASE_SIGNIFICANCE))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("324592b9-7aa6-4aee-a6d1-1f19deb90f01")))
                .semanticOn(PublicIds.of(UUID.fromString("fe9b4e5c-268b-40e8-b857-462b2e8aa6d0")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bfca1e09-3472-4126-8bd6-8d9bf4eadbad")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("abdbd41a-4aa3-4a3f-8a89-86fd70760170")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0ddbf988-cd8d-4e1d-a473-7e4373d138fe")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b7456e5f-362a-4eda-a164-4fdd0c10c284")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("06b1e0ba-d7e7-4c8f-9bcc-ad3df7b7e81a")), KernelTerm.PREFERRED)
                ;

        set.concept("Description case sensitive", PublicIds.of(UUID.fromString("0def37bc-7e1b-384b-a6a3-3e3ceee9c52e"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7b6f5f49-6f8c-47e2-8cb5-48ee23f012f7")), KernelTerm.ENGLISH_LANGUAGE, "Description case sensitive", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4d493cd4-cef0-4b29-9707-555d4f62cc14")), KernelTerm.ENGLISH_LANGUAGE, "Case sensitive", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e5217e0c-ce8b-4370-a36b-40531d3808d1")), KernelTerm.ENGLISH_LANGUAGE, "Assumes the description is dependent on capitalization", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e3be2ad4-e110-4faf-9e5a-0b5453068ea4")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "0def37bc-7e1b-384b-a6a3-3e3ceee9c52e")
                .statedAxioms(PublicIds.of(UUID.fromString("7a8112d7-5964-52f3-a407-d1735df168ae")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelTerm.DESCRIPTION_CASE_SIGNIFICANCE))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("774294cf-e427-4e7a-bf84-e7d5d635a2b1")))
                .semanticOn(PublicIds.of(UUID.fromString("7b6f5f49-6f8c-47e2-8cb5-48ee23f012f7")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7b6c8e87-8c62-48e7-ab30-9f300f597f77")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4d493cd4-cef0-4b29-9707-555d4f62cc14")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("43d603ab-dd16-45b3-9a0a-fbe5c8f028ba")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e5217e0c-ce8b-4370-a36b-40531d3808d1")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("94403a29-d0fd-4242-9b2f-d72f21b32f2b")), KernelTerm.PREFERRED)
                ;

        set.concept("Not Applicable (SOLOR)", PublicIds.of(UUID.fromString("d4cc29ae-c0c1-563a-985d-5165a768dd44"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5222f597-204b-42d0-b8e2-e8a417e3b51f")), KernelTerm.ENGLISH_LANGUAGE, "Not Applicable (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("825ee6e6-806d-47a0-a697-c10dbcf0c493")), KernelTerm.ENGLISH_LANGUAGE, "Not applicable", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("076f4b20-4e54-4128-8870-04c27b3332ac")), KernelTerm.ENGLISH_LANGUAGE, "Not available", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("63959872-7836-48b7-8ef2-0f6a0751f5c2")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "d4cc29ae-c0c1-563a-985d-5165a768dd44")
                .statedAxioms(PublicIds.of(UUID.fromString("b0f9be37-3958-5347-bac3-c34d463e2641")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelTerm.DESCRIPTION_CASE_SIGNIFICANCE))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ee6ca243-3edb-48a4-b2c9-872dfe64de14")))
                .semanticOn(PublicIds.of(UUID.fromString("5222f597-204b-42d0-b8e2-e8a417e3b51f")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9f3adc3d-f469-487b-b3c5-b222cc3c7a98")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("825ee6e6-806d-47a0-a697-c10dbcf0c493")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cc5c2d96-7d2e-4544-84aa-ad3b1aa77b7c")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("076f4b20-4e54-4128-8870-04c27b3332ac")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8328dfbb-91e7-4ac1-a2ac-a8f493007698")), KernelTerm.PREFERRED)
                ;

        set.concept("Description initial character case sensitive (SOLOR)", PublicIds.of(UUID.fromString("17915e0d-ed38-3488-a35c-cda966db306a"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("567778b4-65bb-4903-84b9-04035224f4c0")), KernelTerm.ENGLISH_LANGUAGE, "Description initial character case sensitive (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9e36698c-f5d7-45e6-8580-c12ad4e040b6")), KernelTerm.ENGLISH_LANGUAGE, "Initial character case insensitive", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e2a079ca-ca64-4cd0-8ff0-56a35dd0b614")), KernelTerm.ENGLISH_LANGUAGE, "Value which designates initial character as sensitive for a given description", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("9dbdc2e1-e150-4568-9862-3935f8d0fc29")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "17915e0d-ed38-3488-a35c-cda966db306a")
                .statedAxioms(PublicIds.of(UUID.fromString("ff575434-9d01-583d-bd4e-326f681c37af")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelTerm.DESCRIPTION_CASE_SIGNIFICANCE))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("24b4046b-d34e-4d7e-99a6-0a043fa3bcdb")))
                .semanticOn(PublicIds.of(UUID.fromString("567778b4-65bb-4903-84b9-04035224f4c0")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("79ccb9c2-f61e-478a-8c67-a062601c4cca")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9e36698c-f5d7-45e6-8580-c12ad4e040b6")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0d027e24-b127-4db4-950e-1a78a6f44fe9")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e2a079ca-ca64-4cd0-8ff0-56a35dd0b614")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ecfe20d9-ccca-42f6-8723-4e7ae6ff32ab")), KernelTerm.PREFERRED)
                ;

    }
}
