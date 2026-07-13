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

/** The "Action properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section30 {

    private Section30() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Action properties (SOLOR)", PublicIds.of(UUID.fromString("80ba281c-7d47-57cf-8100-82b69bce998b"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bdd61a65-16b1-4525-95d9-3d2d2aa0d059")), TinkarTerm.ENGLISH_LANGUAGE, "Action properties (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9fdaa71e-582d-41ab-b90c-5e510a9a707f")), TinkarTerm.ENGLISH_LANGUAGE, "Action properties", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b2083605-6ae1-4611-8293-8dd2836058d7")), TinkarTerm.ENGLISH_LANGUAGE, "Attributes of an action object", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f0eff9b3-9cf5-4498-8795-1d0f90084b74")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "80ba281c-7d47-57cf-8100-82b69bce998b")
                .statedAxioms(PublicIds.of(UUID.fromString("d5791b11-b4df-5185-9ca9-35c8dd89ca90")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.OBJECT_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5b33a45c-934b-4819-9d14-0758a2eb44e3")))
                .semanticOn(PublicIds.of(UUID.fromString("bdd61a65-16b1-4525-95d9-3d2d2aa0d059")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("571ff96d-545c-43c3-bf9a-59cb5ac20c04")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9fdaa71e-582d-41ab-b90c-5e510a9a707f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("43119e3b-0e47-4a9a-8965-5d3dacf16a6c")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b2083605-6ae1-4611-8293-8dd2836058d7")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("57bdcd21-f64b-400a-8a2c-1ddbf3996fad")), TinkarTerm.PREFERRED)
                ;

        set.concept("Role type to add (SOLOR)", PublicIds.of(UUID.fromString("0c3ca846-0374-5a5c-8da4-67e0e2e28868"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8c68407d-78db-4422-90a7-188734ebbef1")), TinkarTerm.ENGLISH_LANGUAGE, "Role type to add (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("09c2f8fd-3347-4adc-8ea0-b1aa5bc2b91e")), TinkarTerm.ENGLISH_LANGUAGE, "Role type to add", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("418cd90f-353c-41ef-bebe-53a6b26380bc")), TinkarTerm.ENGLISH_LANGUAGE, "Action - add role type", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("037f08ab-f108-4092-9996-1e3ddefacebe")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0c3ca846-0374-5a5c-8da4-67e0e2e28868")
                .statedAxioms(PublicIds.of(UUID.fromString("911b1d9b-c5d6-54a0-8afe-d1f31c177b74")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ACTION_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1fd84f89-c367-496d-9473-7c08bca05ba3")))
                .semanticOn(PublicIds.of(UUID.fromString("8c68407d-78db-4422-90a7-188734ebbef1")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("008fcae3-a7af-41a8-a254-77d1ce1ea689")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("09c2f8fd-3347-4adc-8ea0-b1aa5bc2b91e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("194526bd-5a01-4b0d-a537-a6ac48844baa")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("418cd90f-353c-41ef-bebe-53a6b26380bc")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d57100c2-2608-4905-b1a7-6f624a931a23")), TinkarTerm.PREFERRED)
                ;

        set.concept("Concept constraints(SOLOR)", PublicIds.of(UUID.fromString("081273cd-92dd-593c-9d9b-63d33838e70b"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("19d0a030-2c66-4469-9f47-7648d16d0f82")), TinkarTerm.ENGLISH_LANGUAGE, "Concept constraints(SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8520a332-30bc-4609-ac20-5a3ccd4ae2e7")), TinkarTerm.ENGLISH_LANGUAGE, "Concept constraints", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a5cd7454-d591-4eec-b673-54adaf5f6143")), TinkarTerm.ENGLISH_LANGUAGE, "Defined filters for a given concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("adf23a48-d83a-4d0b-8d2f-3d729bf8e5f7")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "081273cd-92dd-593c-9d9b-63d33838e70b")
                .statedAxioms(PublicIds.of(UUID.fromString("1a4467fd-c36e-5569-bd07-c2dce2f880d3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ACTION_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("03e4c561-9142-4c3a-b0e1-a2209fafa64a")))
                .semanticOn(PublicIds.of(UUID.fromString("19d0a030-2c66-4469-9f47-7648d16d0f82")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8385d54f-57c4-47c5-900c-f6016e5c7501")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("8520a332-30bc-4609-ac20-5a3ccd4ae2e7")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fc111b11-d1d1-4412-8bb8-252750092bd8")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a5cd7454-d591-4eec-b673-54adaf5f6143")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2a38d65f-2419-4c1e-8aa6-e0d0f6087c31")), TinkarTerm.PREFERRED)
                ;

        set.concept("Concept to find (SOLOR)", PublicIds.of(UUID.fromString("91687b29-3bbb-540b-9de6-91246c75afd0"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("78120fda-180c-420e-9a20-8e2e82102237")), TinkarTerm.ENGLISH_LANGUAGE, "Concept to find (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1017797b-e4a9-440b-bd2c-612551f8932d")), TinkarTerm.ENGLISH_LANGUAGE, "Concept to find", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d57bdfe1-1ff5-4338-9fb3-4d33e55e4cef")), TinkarTerm.ENGLISH_LANGUAGE, "Find concept (if searching on Komet shows us the results 'details and further information?)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("982e8930-b0c1-4a47-b875-6dae1250e26c")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "91687b29-3bbb-540b-9de6-91246c75afd0")
                .statedAxioms(PublicIds.of(UUID.fromString("52592355-bda3-5f81-bed3-1ebb43026b4c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ACTION_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("2229ac25-624c-49ae-95b7-ddf19e6ee1f5")))
                .semanticOn(PublicIds.of(UUID.fromString("78120fda-180c-420e-9a20-8e2e82102237")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b3b3eb0c-5120-4e1c-8208-4037d1b471f5")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1017797b-e4a9-440b-bd2c-612551f8932d")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4c203a89-b02b-4d71-ac11-422ccfae5170")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d57bdfe1-1ff5-4338-9fb3-4d33e55e4cef")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3e85bd62-6305-4ace-a4ac-e75f35ecbd70")), TinkarTerm.PREFERRED)
                ;

        set.concept("Conditional triggers (SOLOR)", PublicIds.of(UUID.fromString("a3e4ac54-db82-5345-8713-7e0da98bbb0a"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("247dafde-70b4-42b0-9ded-906e58917711")), TinkarTerm.ENGLISH_LANGUAGE, "Conditional triggers (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("539b6d48-7412-4858-95ea-81458a21cc3b")), TinkarTerm.ENGLISH_LANGUAGE, "Conditional triggers", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1d59f2f2-6037-4a4e-8fc9-8618a23c82b2")), TinkarTerm.ENGLISH_LANGUAGE, "Conditional triggers based on actions, reasoner", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("96555376-c0a3-424f-8034-5493ea16f58c")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a3e4ac54-db82-5345-8713-7e0da98bbb0a")
                .statedAxioms(PublicIds.of(UUID.fromString("4ee61e2d-0da6-5d40-96da-a4a1a04de2eb")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ACTION_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5db65e9e-ec07-40fb-ab49-30b5a8714976")))
                .semanticOn(PublicIds.of(UUID.fromString("247dafde-70b4-42b0-9ded-906e58917711")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("19b386af-9c9f-4825-8279-7fbb5eed313d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("539b6d48-7412-4858-95ea-81458a21cc3b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2662f9b3-e9c9-4290-bfa4-bca0ced682b1")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1d59f2f2-6037-4a4e-8fc9-8618a23c82b2")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("70912884-c636-4327-8a7d-abb6bf5ae1f1")), TinkarTerm.PREFERRED)
                ;

    }
}
