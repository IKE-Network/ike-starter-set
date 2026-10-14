package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelConcept;
import dev.ikm.tinkar.terms.KernelPattern;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Logical Definition" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section60 {

    private Section60() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Logical Definition", PublicIds.of(UUID.fromString("7dccd042-b0b8-5cec-a1bc-6de676b92f4b"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c844ccda-edec-497b-893e-e1383b990bbb")), KernelConcept.ENGLISH_LANGUAGE, "Logical Definition", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("105cffed-fdd4-407b-ba57-e061b06b8de2")), KernelConcept.ENGLISH_LANGUAGE, "Logical Definition", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6190514d-13aa-4e0a-a4ce-ff39251bb63f")), KernelConcept.ENGLISH_LANGUAGE, "The semantic value describing the purpose of the stated and inferred terminological axioms.", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("fcd3d05f-6588-4bac-a2db-460b98e06ef0")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "7dccd042-b0b8-5cec-a1bc-6de676b92f4b")
                .statedAxioms(PublicIds.of(UUID.fromString("feb495c1-8a7b-5196-9930-38ddf89def89")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("35512707-9c3e-4a17-92f9-f1c65b561cd9")))
                .semanticOn(PublicIds.of(UUID.fromString("c844ccda-edec-497b-893e-e1383b990bbb")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d1a5704c-1755-4caf-b16a-81b3e1168757")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("105cffed-fdd4-407b-ba57-e061b06b8de2")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("af3c8eeb-eb54-433f-948a-da5151161aa2")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6190514d-13aa-4e0a-a4ce-ff39251bb63f")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7df98043-df3c-4631-bcd0-f9e1b4fab587")), KernelConcept.PREFERRED)
                ;

        set.concept("EL++ Stated Concept Definition (SOLOR)", PublicIds.of(UUID.fromString("0c464a4a-a0bc-53ef-9c01-ef5a049f2656"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("73dee886-789a-468a-9a61-9f2c408fbc65")), KernelConcept.ENGLISH_LANGUAGE, "EL++ Stated Concept Definition (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8395874c-184b-46cc-a69a-2d3320410fc6")), KernelConcept.ENGLISH_LANGUAGE, "EL++ Stated Concept Definition", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("725c0f88-ee40-48e8-b07d-eb44da6ac24f")), KernelConcept.ENGLISH_LANGUAGE, "EL++ Stated Concept Definition", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e0d30d4f-5e20-493f-907f-93ef6bed39f2")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "0c464a4a-a0bc-53ef-9c01-ef5a049f2656")
                .statedAxioms(PublicIds.of(UUID.fromString("1f0d3244-c905-566d-a0d4-e1aada8fa802")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Logical Definition (SOLOR)", PublicIds.of("7dccd042-b0b8-5cec-a1bc-6de676b92f4b"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4ebe6d95-dd4a-4838-8079-80986ec57571")))
                .semanticOn(PublicIds.of(UUID.fromString("73dee886-789a-468a-9a61-9f2c408fbc65")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("39d6945a-0f52-4d9e-9d0f-430fb48419fd")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("8395874c-184b-46cc-a69a-2d3320410fc6")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("80233fc7-ba57-48e3-b0ed-a052a68b6fd8")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("725c0f88-ee40-48e8-b07d-eb44da6ac24f")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6c8f5fa3-22ec-492d-9dde-c61ddb751c3a")), KernelConcept.PREFERRED)
                ;

        set.concept("El++ Inferred Concept Definition (SOLOR)", PublicIds.of(UUID.fromString("b2897aa0-a697-5bf2-9156-7a437c6a5057"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("18041b22-f993-4b08-8213-429d295b38d2")), KernelConcept.ENGLISH_LANGUAGE, "El++ Inferred Concept Definition (SOLOR)", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ad206725-0750-41b3-9950-5e7759034fd4")), KernelConcept.ENGLISH_LANGUAGE, "EL++ Inferred Concept Definition", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("64109909-6e9a-4068-81d0-4cbad9dd37f6")), KernelConcept.ENGLISH_LANGUAGE, "El++ Inferred Concept Definition", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4b0ac9ec-1d82-4926-94f5-79d4a47f23e6")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "b2897aa0-a697-5bf2-9156-7a437c6a5057")
                .statedAxioms(PublicIds.of(UUID.fromString("0fc042ad-6938-5b03-bb54-d513db1ebc14")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Logical Definition (SOLOR)", PublicIds.of("7dccd042-b0b8-5cec-a1bc-6de676b92f4b"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("380717ff-9f51-47b2-8b4b-c0fcd9c7cff8")))
                .semanticOn(PublicIds.of(UUID.fromString("18041b22-f993-4b08-8213-429d295b38d2")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4fe4c2d9-01a3-4bb8-8dae-eb512be46698")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ad206725-0750-41b3-9950-5e7759034fd4")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3908da79-992b-4b3a-8e58-debfa62ba829")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("64109909-6e9a-4068-81d0-4cbad9dd37f6")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("545bb70c-2c9b-4ebc-97e8-6dbcd435e8b8")), KernelConcept.PREFERRED)
                ;

    }
}
