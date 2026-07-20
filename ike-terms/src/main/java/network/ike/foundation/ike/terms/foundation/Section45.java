package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Description case significance" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section45 {

    private Section45() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description case significance", PublicIds.of("c3dde9ea-b144-5f49-845a-20cc7d305250", "f30b0312-2c85-3e65-8609-2d89f8437d34")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("60e732f5-b3b4-4ebd-b6ae-66122fc4e76c"), IkeTerm.ENGLISH_LANGUAGE, "Description case significance", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a460e8cc-74a9-460e-87db-b340d763f15b"), IkeTerm.ENGLISH_LANGUAGE, "Description case significance", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ea380386-a5cb-4e1e-9419-6097f0411e69"), IkeTerm.ENGLISH_LANGUAGE, "Specifies how to handle the description text in terms of case sensitivity", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("0333c0ec-64a3-451c-b8e7-0ddddd0f1ad3"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c3dde9ea-b144-5f49-845a-20cc7d305250")
                .statedAxioms(PublicIds.of("bc6d523f-953c-5e7a-b9ea-a30efcf8444b"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5c68ac1a-d1a8-4e98-9675-8a7e019823af"))
                .semanticOn(PublicIds.of("60e732f5-b3b4-4ebd-b6ae-66122fc4e76c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fabc6be1-7725-4fc4-98fa-747d9c2b610d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a460e8cc-74a9-460e-87db-b340d763f15b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a5fb88df-61bb-4c56-b06c-5a207d4ee3c6"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ea380386-a5cb-4e1e-9419-6097f0411e69"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fbb721da-a7ba-483e-943b-d42432b33756"), IkeTerm.PREFERRED)
                ;

        set.concept("Description not case sensitive", PublicIds.of("ecea41a2-f596-3d98-99d1-771b667e55b8")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fe9b4e5c-268b-40e8-b857-462b2e8aa6d0"), IkeTerm.ENGLISH_LANGUAGE, "Description not case sensitive", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("abdbd41a-4aa3-4a3f-8a89-86fd70760170"), IkeTerm.ENGLISH_LANGUAGE, "Case insensitive", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b7456e5f-362a-4eda-a164-4fdd0c10c284"), IkeTerm.ENGLISH_LANGUAGE, "Value which designate character as not sensitive for a given description", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("e27cd9cb-4a46-46cf-bff5-535212b4e2b8"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ecea41a2-f596-3d98-99d1-771b667e55b8")
                .statedAxioms(PublicIds.of("fe4f7734-04dd-5bd6-ad8a-eabdd8679d31"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_CASE_SIGNIFICANCE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("324592b9-7aa6-4aee-a6d1-1f19deb90f01"))
                .semanticOn(PublicIds.of("fe9b4e5c-268b-40e8-b857-462b2e8aa6d0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bfca1e09-3472-4126-8bd6-8d9bf4eadbad"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("abdbd41a-4aa3-4a3f-8a89-86fd70760170"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0ddbf988-cd8d-4e1d-a473-7e4373d138fe"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b7456e5f-362a-4eda-a164-4fdd0c10c284"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("06b1e0ba-d7e7-4c8f-9bcc-ad3df7b7e81a"), IkeTerm.PREFERRED)
                ;

        set.concept("Description case sensitive", PublicIds.of("0def37bc-7e1b-384b-a6a3-3e3ceee9c52e")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7b6f5f49-6f8c-47e2-8cb5-48ee23f012f7"), IkeTerm.ENGLISH_LANGUAGE, "Description case sensitive", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4d493cd4-cef0-4b29-9707-555d4f62cc14"), IkeTerm.ENGLISH_LANGUAGE, "Case sensitive", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e5217e0c-ce8b-4370-a36b-40531d3808d1"), IkeTerm.ENGLISH_LANGUAGE, "Assumes the description is dependent on capitalization", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("e3be2ad4-e110-4faf-9e5a-0b5453068ea4"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0def37bc-7e1b-384b-a6a3-3e3ceee9c52e")
                .statedAxioms(PublicIds.of("7a8112d7-5964-52f3-a407-d1735df168ae"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_CASE_SIGNIFICANCE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("774294cf-e427-4e7a-bf84-e7d5d635a2b1"))
                .semanticOn(PublicIds.of("7b6f5f49-6f8c-47e2-8cb5-48ee23f012f7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7b6c8e87-8c62-48e7-ab30-9f300f597f77"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("4d493cd4-cef0-4b29-9707-555d4f62cc14"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("43d603ab-dd16-45b3-9a0a-fbe5c8f028ba"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("e5217e0c-ce8b-4370-a36b-40531d3808d1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("94403a29-d0fd-4242-9b2f-d72f21b32f2b"), IkeTerm.PREFERRED)
                ;

        set.concept("Not Applicable (SOLOR)", PublicIds.of("d4cc29ae-c0c1-563a-985d-5165a768dd44")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5222f597-204b-42d0-b8e2-e8a417e3b51f"), IkeTerm.ENGLISH_LANGUAGE, "Not Applicable (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("825ee6e6-806d-47a0-a697-c10dbcf0c493"), IkeTerm.ENGLISH_LANGUAGE, "Not applicable", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("076f4b20-4e54-4128-8870-04c27b3332ac"), IkeTerm.ENGLISH_LANGUAGE, "Not available", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("63959872-7836-48b7-8ef2-0f6a0751f5c2"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "d4cc29ae-c0c1-563a-985d-5165a768dd44")
                .statedAxioms(PublicIds.of("b0f9be37-3958-5347-bac3-c34d463e2641"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_CASE_SIGNIFICANCE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("ee6ca243-3edb-48a4-b2c9-872dfe64de14"))
                .semanticOn(PublicIds.of("5222f597-204b-42d0-b8e2-e8a417e3b51f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("9f3adc3d-f469-487b-b3c5-b222cc3c7a98"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("825ee6e6-806d-47a0-a697-c10dbcf0c493"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cc5c2d96-7d2e-4544-84aa-ad3b1aa77b7c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("076f4b20-4e54-4128-8870-04c27b3332ac"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("8328dfbb-91e7-4ac1-a2ac-a8f493007698"), IkeTerm.PREFERRED)
                ;

        set.concept("Description initial character case sensitive (SOLOR)", PublicIds.of("17915e0d-ed38-3488-a35c-cda966db306a")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("567778b4-65bb-4903-84b9-04035224f4c0"), IkeTerm.ENGLISH_LANGUAGE, "Description initial character case sensitive (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9e36698c-f5d7-45e6-8580-c12ad4e040b6"), IkeTerm.ENGLISH_LANGUAGE, "Initial character case insensitive", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e2a079ca-ca64-4cd0-8ff0-56a35dd0b614"), IkeTerm.ENGLISH_LANGUAGE, "Value which designates initial character as sensitive for a given description", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("9dbdc2e1-e150-4568-9862-3935f8d0fc29"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "17915e0d-ed38-3488-a35c-cda966db306a")
                .statedAxioms(PublicIds.of("ff575434-9d01-583d-bd4e-326f681c37af"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_CASE_SIGNIFICANCE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("24b4046b-d34e-4d7e-99a6-0a043fa3bcdb"))
                .semanticOn(PublicIds.of("567778b4-65bb-4903-84b9-04035224f4c0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("79ccb9c2-f61e-478a-8c67-a062601c4cca"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9e36698c-f5d7-45e6-8580-c12ad4e040b6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0d027e24-b127-4db4-950e-1a78a6f44fe9"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("e2a079ca-ca64-4cd0-8ff0-56a35dd0b614"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ecfe20d9-ccca-42f6-8723-4e7ae6ff32ab"), IkeTerm.PREFERRED)
                ;

    }
}
