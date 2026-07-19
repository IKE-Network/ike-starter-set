package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Logical Definition" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section60 {

    private Section60() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Logical Definition", PublicIds.of(UUID.fromString("7dccd042-b0b8-5cec-a1bc-6de676b92f4b"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c844ccda-edec-497b-893e-e1383b990bbb")), IkeTerm.ENGLISH_LANGUAGE, "Logical Definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("105cffed-fdd4-407b-ba57-e061b06b8de2")), IkeTerm.ENGLISH_LANGUAGE, "Logical Definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6190514d-13aa-4e0a-a4ce-ff39251bb63f")), IkeTerm.ENGLISH_LANGUAGE, "The semantic value describing the purpose of the stated and inferred terminological axioms.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("fcd3d05f-6588-4bac-a2db-460b98e06ef0")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "7dccd042-b0b8-5cec-a1bc-6de676b92f4b")
                .statedAxioms(PublicIds.of(UUID.fromString("feb495c1-8a7b-5196-9930-38ddf89def89")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("35512707-9c3e-4a17-92f9-f1c65b561cd9")))
                .semanticOn(PublicIds.of(UUID.fromString("c844ccda-edec-497b-893e-e1383b990bbb")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d1a5704c-1755-4caf-b16a-81b3e1168757")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("105cffed-fdd4-407b-ba57-e061b06b8de2")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("af3c8eeb-eb54-433f-948a-da5151161aa2")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6190514d-13aa-4e0a-a4ce-ff39251bb63f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7df98043-df3c-4631-bcd0-f9e1b4fab587")), IkeTerm.PREFERRED)
                ;

        set.concept("EL++ Stated Concept Definition (SOLOR)", PublicIds.of(UUID.fromString("0c464a4a-a0bc-53ef-9c01-ef5a049f2656"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("73dee886-789a-468a-9a61-9f2c408fbc65")), IkeTerm.ENGLISH_LANGUAGE, "EL++ Stated Concept Definition (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8395874c-184b-46cc-a69a-2d3320410fc6")), IkeTerm.ENGLISH_LANGUAGE, "EL++ Stated Concept Definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("725c0f88-ee40-48e8-b07d-eb44da6ac24f")), IkeTerm.ENGLISH_LANGUAGE, "EL++ Stated Concept Definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e0d30d4f-5e20-493f-907f-93ef6bed39f2")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0c464a4a-a0bc-53ef-9c01-ef5a049f2656")
                .statedAxioms(PublicIds.of(UUID.fromString("1f0d3244-c905-566d-a0d4-e1aada8fa802")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LOGICAL_DEFINITION))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4ebe6d95-dd4a-4838-8079-80986ec57571")))
                .semanticOn(PublicIds.of(UUID.fromString("73dee886-789a-468a-9a61-9f2c408fbc65")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("39d6945a-0f52-4d9e-9d0f-430fb48419fd")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("8395874c-184b-46cc-a69a-2d3320410fc6")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("80233fc7-ba57-48e3-b0ed-a052a68b6fd8")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("725c0f88-ee40-48e8-b07d-eb44da6ac24f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6c8f5fa3-22ec-492d-9dde-c61ddb751c3a")), IkeTerm.PREFERRED)
                ;

        set.concept("El++ Inferred Concept Definition (SOLOR)", PublicIds.of(UUID.fromString("b2897aa0-a697-5bf2-9156-7a437c6a5057"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("18041b22-f993-4b08-8213-429d295b38d2")), IkeTerm.ENGLISH_LANGUAGE, "El++ Inferred Concept Definition (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ad206725-0750-41b3-9950-5e7759034fd4")), IkeTerm.ENGLISH_LANGUAGE, "EL++ Inferred Concept Definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("64109909-6e9a-4068-81d0-4cbad9dd37f6")), IkeTerm.ENGLISH_LANGUAGE, "El++ Inferred Concept Definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4b0ac9ec-1d82-4926-94f5-79d4a47f23e6")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b2897aa0-a697-5bf2-9156-7a437c6a5057")
                .statedAxioms(PublicIds.of(UUID.fromString("0fc042ad-6938-5b03-bb54-d513db1ebc14")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LOGICAL_DEFINITION))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("380717ff-9f51-47b2-8b4b-c0fcd9c7cff8")))
                .semanticOn(PublicIds.of(UUID.fromString("18041b22-f993-4b08-8213-429d295b38d2")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4fe4c2d9-01a3-4bb8-8dae-eb512be46698")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ad206725-0750-41b3-9950-5e7759034fd4")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3908da79-992b-4b3a-8e58-debfa62ba829")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("64109909-6e9a-4068-81d0-4cbad9dd37f6")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("545bb70c-2c9b-4ebc-97e8-6dbcd435e8b8")), IkeTerm.PREFERRED)
                ;

    }
}
