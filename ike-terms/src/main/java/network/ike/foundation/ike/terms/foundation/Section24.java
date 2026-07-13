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

/** The "Semantic properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section24 {

    private Section24() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Semantic properties (SOLOR)", PublicIds.of(UUID.fromString("b717ae48-5488-5dda-a980-97855001cc99"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b0e039ca-abe7-4e94-a8b3-4e18f8ca93b1")), TinkarTerm.ENGLISH_LANGUAGE, "Semantic properties (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("73bc1c6d-809e-4700-8899-864819e446d3")), TinkarTerm.ENGLISH_LANGUAGE, "Semantic properties", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("16ac69ca-0dd7-44f5-8185-24d7e5f85b3b")), TinkarTerm.ENGLISH_LANGUAGE, "The attributes or characteristics of a concept, term, or element that convey meaning or semantics in a given context", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4458556b-df3c-4d61-9a09-ba34629c7e0c")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b717ae48-5488-5dda-a980-97855001cc99")
                .statedAxioms(PublicIds.of(UUID.fromString("b909421f-66f5-5d4c-8186-fb49fc8a9a2e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.OBJECT_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("133f889d-846f-4d9a-a02f-cd54ed3c588f")))
                .semanticOn(PublicIds.of(UUID.fromString("b0e039ca-abe7-4e94-a8b3-4e18f8ca93b1")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7d16622b-0782-461e-aba3-0590a67adf07")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("73bc1c6d-809e-4700-8899-864819e446d3")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("19edf3d3-7ecc-485d-b8b7-4e32c42a9d7d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("16ac69ca-0dd7-44f5-8185-24d7e5f85b3b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("37116e60-c413-41e6-a59d-6c9e7ad761d3")), TinkarTerm.PREFERRED)
                ;

        set.concept("Referenced component nid for semantic (SOLOR)", PublicIds.of(UUID.fromString("a9ba4749-c11f-5f35-a991-21796fb89ddc"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("447541ca-8c02-4c3b-ac65-caa263f9fb5a")), TinkarTerm.ENGLISH_LANGUAGE, "Referenced component nid for semantic (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("91e611b8-d42c-4123-a65f-c3933f572219")), TinkarTerm.ENGLISH_LANGUAGE, "Referenced component id", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b2322b09-b1a9-4cf9-a62e-cbc46a87d088")), TinkarTerm.ENGLISH_LANGUAGE, "Component id Referenced", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("11a238b8-e3d7-452e-ac7b-003e356b696f")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a9ba4749-c11f-5f35-a991-21796fb89ddc")
                .statedAxioms(PublicIds.of(UUID.fromString("3e4e3641-efbb-5362-b5d8-5d6494fd0143")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.SEMANTIC_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("68b9838a-bb06-47c0-9e06-3e3e60cf99d3")))
                .semanticOn(PublicIds.of(UUID.fromString("447541ca-8c02-4c3b-ac65-caa263f9fb5a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5613209a-1cf6-4de9-9085-e6a40562ee5d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("91e611b8-d42c-4123-a65f-c3933f572219")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("71d59819-29c0-44ae-bfe8-5528db841ab1")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b2322b09-b1a9-4cf9-a62e-cbc46a87d088")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3f1e7734-094a-423d-a867-83533d2d5c03")), TinkarTerm.PREFERRED)
                ;

        set.concept("Component for semantic (SOLOR)", PublicIds.of(UUID.fromString("0bc32c16-698e-5719-8bd5-efa099c7d782"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("802f1865-bdf7-43ba-b285-57f420ba667a")), TinkarTerm.ENGLISH_LANGUAGE, "Component for semantic (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9c2b55e7-d80a-41bf-8535-c44b74230311")), TinkarTerm.ENGLISH_LANGUAGE, "Component", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1dffac55-e9cc-4dfa-97b2-f6eaa24178c6")), TinkarTerm.ENGLISH_LANGUAGE, "Component for semantic", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("fb7b4cd0-6f74-4019-90e7-5190d86b3ada")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0bc32c16-698e-5719-8bd5-efa099c7d782")
                .statedAxioms(PublicIds.of(UUID.fromString("8946c895-34dc-59fb-8d5d-de6f100a2468")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.SEMANTIC_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("78945800-8094-4589-8fa2-a2825c42b671")))
                .semanticOn(PublicIds.of(UUID.fromString("802f1865-bdf7-43ba-b285-57f420ba667a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("41002867-96ee-4b19-842d-9c5128119ae2")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9c2b55e7-d80a-41bf-8535-c44b74230311")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f70e2c9e-ff63-45d3-912f-011d12b2aa37")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1dffac55-e9cc-4dfa-97b2-f6eaa24178c6")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7ca2e8ea-1686-4772-9158-17b74aca4fb6")), TinkarTerm.PREFERRED)
                ;

        set.concept("Logic graph for semantic (SOLOR)", PublicIds.of(UUID.fromString("fc2a0662-2396-575b-95f0-e9b38a418620"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d3aa631b-5cab-407a-8772-4739771d3cba")), TinkarTerm.ENGLISH_LANGUAGE, "Logic graph for semantic (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e6027896-adf6-404f-b9f0-2f0c2bf9c231")), TinkarTerm.ENGLISH_LANGUAGE, "Logic graph", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8dc5703e-37d8-483f-ad87-f7f952c49749")), TinkarTerm.ENGLISH_LANGUAGE, "Semantic", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c1f010c4-a785-49b9-821d-93e1c00cd5fd")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "fc2a0662-2396-575b-95f0-e9b38a418620")
                .statedAxioms(PublicIds.of(UUID.fromString("95ccd943-17e4-5759-8b8b-2223863e9d3b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.SEMANTIC_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("df6f6d39-462b-4238-b852-dac17c238c25")))
                .semanticOn(PublicIds.of(UUID.fromString("d3aa631b-5cab-407a-8772-4739771d3cba")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5587e27d-cc36-4191-a0c9-a217d683ca7f")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e6027896-adf6-404f-b9f0-2f0c2bf9c231")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ad55ef0e-765f-4afa-a9ff-aaac30732bc0")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("8dc5703e-37d8-483f-ad87-f7f952c49749")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("99af4b0e-2890-40d0-b0d2-d979ff5ec80f")), TinkarTerm.PREFERRED)
                ;

        set.concept("Semantic field name (SOLOR)", PublicIds.of(UUID.fromString("15489c68-673d-503e-bff7-e9d59e5dc15c"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cd61037c-f284-4eca-9bf3-7af896c0a7ea")), TinkarTerm.ENGLISH_LANGUAGE, "Semantic field name (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7e3eb091-7817-4b0e-a248-411dbd2934e1")), TinkarTerm.ENGLISH_LANGUAGE, "Field name", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2be447bf-a577-4d07-84fc-a16b627ec09f")), TinkarTerm.ENGLISH_LANGUAGE, "Field name - semantics", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8aad6150-7e58-4ea0-8f75-6e097fb7aa85")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "15489c68-673d-503e-bff7-e9d59e5dc15c")
                .statedAxioms(PublicIds.of(UUID.fromString("b5f18d25-99ea-5a99-ad8e-1cc134e92dc7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.SEMANTIC_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9e08da3a-05e0-43f9-a725-6c7b2d9d739e")))
                .semanticOn(PublicIds.of(UUID.fromString("cd61037c-f284-4eca-9bf3-7af896c0a7ea")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b57a6487-fff3-4631-9785-29f4edd908ba")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7e3eb091-7817-4b0e-a248-411dbd2934e1")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48b1c76d-0493-433a-90f4-5d4a10c2cb51")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2be447bf-a577-4d07-84fc-a16b627ec09f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8715e30c-eb6b-4b4e-a842-ce6c135ee036")), TinkarTerm.PREFERRED)
                ;

    }
}
