package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Action properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section30 {

    private Section30() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Action properties (SOLOR)", PublicIds.of("80ba281c-7d47-57cf-8100-82b69bce998b")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bdd61a65-16b1-4525-95d9-3d2d2aa0d059"), IkeTerm.ENGLISH_LANGUAGE, "Action properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9fdaa71e-582d-41ab-b90c-5e510a9a707f"), IkeTerm.ENGLISH_LANGUAGE, "Action properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b2083605-6ae1-4611-8293-8dd2836058d7"), IkeTerm.ENGLISH_LANGUAGE, "The retired ISAAC action-rule vocabulary: the parameters a rule-driven authoring action took. Retained for identity compatibility.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("f0eff9b3-9cf5-4498-8795-1d0f90084b74"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "80ba281c-7d47-57cf-8100-82b69bce998b")
                .statedAxioms(PublicIds.of("d5791b11-b4df-5185-9ca9-35c8dd89ca90"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Legacy model concepts (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5b33a45c-934b-4819-9d14-0758a2eb44e3"))
                .semanticOn(PublicIds.of("bdd61a65-16b1-4525-95d9-3d2d2aa0d059"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("571ff96d-545c-43c3-bf9a-59cb5ac20c04"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9fdaa71e-582d-41ab-b90c-5e510a9a707f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("43119e3b-0e47-4a9a-8965-5d3dacf16a6c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b2083605-6ae1-4611-8293-8dd2836058d7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("57bdcd21-f64b-400a-8a2c-1ddbf3996fad"), IkeTerm.PREFERRED)
                ;

        set.concept("Role type to add (SOLOR)", PublicIds.of("0c3ca846-0374-5a5c-8da4-67e0e2e28868")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8c68407d-78db-4422-90a7-188734ebbef1"), IkeTerm.ENGLISH_LANGUAGE, "Role type to add (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("09c2f8fd-3347-4adc-8ea0-b1aa5bc2b91e"), IkeTerm.ENGLISH_LANGUAGE, "Role type to add", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("418cd90f-353c-41ef-bebe-53a6b26380bc"), IkeTerm.ENGLISH_LANGUAGE, "The retired action parameter naming which role type a rule-driven action would add to a concept's definition.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("037f08ab-f108-4092-9996-1e3ddefacebe"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0c3ca846-0374-5a5c-8da4-67e0e2e28868")
                .statedAxioms(PublicIds.of("911b1d9b-c5d6-54a0-8afe-d1f31c177b74"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ACTION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("1fd84f89-c367-496d-9473-7c08bca05ba3"))
                .semanticOn(PublicIds.of("8c68407d-78db-4422-90a7-188734ebbef1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("008fcae3-a7af-41a8-a254-77d1ce1ea689"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("09c2f8fd-3347-4adc-8ea0-b1aa5bc2b91e"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("194526bd-5a01-4b0d-a537-a6ac48844baa"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("418cd90f-353c-41ef-bebe-53a6b26380bc"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d57100c2-2608-4905-b1a7-6f624a931a23"), IkeTerm.PREFERRED)
                ;

        set.concept("Concept constraints(SOLOR)", PublicIds.of("081273cd-92dd-593c-9d9b-63d33838e70b")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("19d0a030-2c66-4469-9f47-7648d16d0f82"), IkeTerm.ENGLISH_LANGUAGE, "Concept constraints(SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8520a332-30bc-4609-ac20-5a3ccd4ae2e7"), IkeTerm.ENGLISH_LANGUAGE, "Concept constraints", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a5cd7454-d591-4eec-b673-54adaf5f6143"), IkeTerm.ENGLISH_LANGUAGE, "The retired action parameter holding the filters a rule-driven action applied when selecting which concepts to act on.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("adf23a48-d83a-4d0b-8d2f-3d729bf8e5f7"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "081273cd-92dd-593c-9d9b-63d33838e70b")
                .statedAxioms(PublicIds.of("1a4467fd-c36e-5569-bd07-c2dce2f880d3"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ACTION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("03e4c561-9142-4c3a-b0e1-a2209fafa64a"))
                .semanticOn(PublicIds.of("19d0a030-2c66-4469-9f47-7648d16d0f82"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("8385d54f-57c4-47c5-900c-f6016e5c7501"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("8520a332-30bc-4609-ac20-5a3ccd4ae2e7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fc111b11-d1d1-4412-8bb8-252750092bd8"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a5cd7454-d591-4eec-b673-54adaf5f6143"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2a38d65f-2419-4c1e-8aa6-e0d0f6087c31"), IkeTerm.PREFERRED)
                ;

        set.concept("Concept to find (SOLOR)", PublicIds.of("91687b29-3bbb-540b-9de6-91246c75afd0")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("78120fda-180c-420e-9a20-8e2e82102237"), IkeTerm.ENGLISH_LANGUAGE, "Concept to find (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1017797b-e4a9-440b-bd2c-612551f8932d"), IkeTerm.ENGLISH_LANGUAGE, "Concept to find", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d57bdfe1-1ff5-4338-9fb3-4d33e55e4cef"), IkeTerm.ENGLISH_LANGUAGE, "Find concept (if searching on Komet shows us the results 'details and further information?)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("982e8930-b0c1-4a47-b875-6dae1250e26c"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "91687b29-3bbb-540b-9de6-91246c75afd0")
                .statedAxioms(PublicIds.of("52592355-bda3-5f81-bed3-1ebb43026b4c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ACTION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("2229ac25-624c-49ae-95b7-ddf19e6ee1f5"))
                .semanticOn(PublicIds.of("78120fda-180c-420e-9a20-8e2e82102237"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b3b3eb0c-5120-4e1c-8208-4037d1b471f5"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("1017797b-e4a9-440b-bd2c-612551f8932d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4c203a89-b02b-4d71-ac11-422ccfae5170"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d57bdfe1-1ff5-4338-9fb3-4d33e55e4cef"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3e85bd62-6305-4ace-a4ac-e75f35ecbd70"), IkeTerm.PREFERRED)
                ;

        set.concept("Conditional triggers (SOLOR)", PublicIds.of("a3e4ac54-db82-5345-8713-7e0da98bbb0a")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("247dafde-70b4-42b0-9ded-906e58917711"), IkeTerm.ENGLISH_LANGUAGE, "Conditional triggers (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("539b6d48-7412-4858-95ea-81458a21cc3b"), IkeTerm.ENGLISH_LANGUAGE, "Conditional triggers", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1d59f2f2-6037-4a4e-8fc9-8618a23c82b2"), IkeTerm.ENGLISH_LANGUAGE, "Conditional triggers based on actions, reasoner", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("96555376-c0a3-424f-8034-5493ea16f58c"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a3e4ac54-db82-5345-8713-7e0da98bbb0a")
                .statedAxioms(PublicIds.of("4ee61e2d-0da6-5d40-96da-a4a1a04de2eb"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ACTION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5db65e9e-ec07-40fb-ab49-30b5a8714976"))
                .semanticOn(PublicIds.of("247dafde-70b4-42b0-9ded-906e58917711"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("19b386af-9c9f-4825-8279-7fbb5eed313d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("539b6d48-7412-4858-95ea-81458a21cc3b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2662f9b3-e9c9-4290-bfa4-bca0ced682b1"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("1d59f2f2-6037-4a4e-8fc9-8618a23c82b2"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("70912884-c636-4327-8a7d-abb6bf5ae1f1"), IkeTerm.PREFERRED)
                ;

    }
}
