package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Status" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section16 {

    private Section16() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Status value", PublicIds.of(UUID.fromString("10b873e2-8247-5ab5-9dec-4edef37fc219"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("51fb950f-13f1-47af-aead-b96bfade0d0d")), IkeTerm.ENGLISH_LANGUAGE, "Status value", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b9c331be-aff2-477e-9a29-47ca1acf6ac5")), IkeTerm.ENGLISH_LANGUAGE, "Status", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("07161dbe-3622-4d9c-b09e-2fbaf4f40831")), IkeTerm.ENGLISH_LANGUAGE, "The status of the STAMP Coordinate(Active, Cancelled, Inactive, Primordial)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("6fe50533-e0e9-4d5b-be11-897538b5c252")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "10b873e2-8247-5ab5-9dec-4edef37fc219")
                .statedAxioms(PublicIds.of(UUID.fromString("8cb9b059-8df3-565b-b1c9-824b652ba0c5")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROOT_VERTEX))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("494ca9e1-b326-45a4-a984-3914bd35e400")))
                .semanticOn(PublicIds.of(UUID.fromString("51fb950f-13f1-47af-aead-b96bfade0d0d")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48568678-884a-4e56-843e-a0a8bdf03f94")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b9c331be-aff2-477e-9a29-47ca1acf6ac5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0e98943d-f9f0-4c8a-a3ef-4c5d7ae78a4d")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("07161dbe-3622-4d9c-b09e-2fbaf4f40831")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0f872048-e4d7-4998-acd4-d085053bf9c0")), IkeTerm.PREFERRED)
                ;

        set.concept("Primordial state", PublicIds.of(UUID.fromString("b17bde5d-98ed-5416-97cf-2d837d75159d"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("649031a4-b75b-46ac-9374-0137484ba06b")), IkeTerm.ENGLISH_LANGUAGE, "Primordial state", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("93103615-c7f0-4b78-8627-d8a228dde206")), IkeTerm.ENGLISH_LANGUAGE, "Primordial", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d79fe391-e0fa-4687-a746-524f6cc7faa0")), IkeTerm.ENGLISH_LANGUAGE, "Concept used to represent a status for components that have not yet been released and exist in their most basic form.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("11c1649d-e0d0-47b7-87de-9b39843c6a17")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b17bde5d-98ed-5416-97cf-2d837d75159d")
                .statedAxioms(PublicIds.of(UUID.fromString("f3c9e034-d350-5f98-ac0e-40852e552aaf")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.STATUS_VALUE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d1730c00-d8d8-492d-bc2f-a94e6dacb066")))
                .semanticOn(PublicIds.of(UUID.fromString("649031a4-b75b-46ac-9374-0137484ba06b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("601cd3f5-bf1e-4c69-8220-3e91a3446ecf")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("93103615-c7f0-4b78-8627-d8a228dde206")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ac9b6995-5272-49f0-a325-5a4649da01ad")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d79fe391-e0fa-4687-a746-524f6cc7faa0")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("35635a0e-019a-4df8-95fe-e1474df155a3")), IkeTerm.PREFERRED)
                ;

        set.concept("Canceled state", PublicIds.of(UUID.fromString("b42c1948-7645-5da8-a888-de6ec020ab98"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("57fac2af-9a70-49c7-a64b-1944c418eb23")), IkeTerm.ENGLISH_LANGUAGE, "Canceled state", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fb9e8d41-67e3-4967-9d4a-4d4829fea456")), IkeTerm.ENGLISH_LANGUAGE, "Canceled", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("87a459e4-0538-4a03-a5d8-69903f13f2b4")), IkeTerm.ENGLISH_LANGUAGE, "Concept used to represent a status for components that are canceled", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("b2dd8740-8aa7-406f-9312-413ebfa810f8")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b42c1948-7645-5da8-a888-de6ec020ab98")
                .statedAxioms(PublicIds.of(UUID.fromString("2856f2d8-034d-5e8d-872a-8292ebb3e53f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.STATUS_VALUE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("094843d5-f01c-4d97-966d-e8b75242cb08")))
                .semanticOn(PublicIds.of(UUID.fromString("57fac2af-9a70-49c7-a64b-1944c418eb23")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6b4c7ca9-047c-4e2d-8e4e-dedc037a2de4")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("fb9e8d41-67e3-4967-9d4a-4d4829fea456")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c08d10b7-a854-4b9b-9393-d22a9f5e7d06")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("87a459e4-0538-4a03-a5d8-69903f13f2b4")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2349eac4-b53b-4566-b531-bb750e92882d")), IkeTerm.PREFERRED)
                ;

        set.concept("Active state", PublicIds.of(UUID.fromString("09f12001-0e4f-51e2-9852-44862a4a0db4"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("866d389b-67de-48af-b836-830cbe3a013d")), IkeTerm.ENGLISH_LANGUAGE, "Active state", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d46a997b-3ee8-4e72-8c97-cf6d60a4877b")), IkeTerm.ENGLISH_LANGUAGE, "Active", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3de0160f-ca66-4249-a8f5-dc4ed56075de")), IkeTerm.ENGLISH_LANGUAGE, "Concept used to represent a status for components that are active.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("7238dc80-f276-4a69-861c-6481bb0aba64")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "09f12001-0e4f-51e2-9852-44862a4a0db4")
                .statedAxioms(PublicIds.of(UUID.fromString("60438972-2aaf-52ec-b101-e9014e2ceb7c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.STATUS_VALUE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8120326e-47ad-40bb-b629-1292afcc20a0")))
                .semanticOn(PublicIds.of(UUID.fromString("866d389b-67de-48af-b836-830cbe3a013d")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0aed6644-6475-41b6-abdf-818c4de4c5c7")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d46a997b-3ee8-4e72-8c97-cf6d60a4877b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("211fa3be-8d30-4fef-b4bd-893486bb0b97")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3de0160f-ca66-4249-a8f5-dc4ed56075de")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2c0a4ed2-5254-46d8-8cdb-170c43415f25")), IkeTerm.PREFERRED)
                ;

        set.concept("Inactive state", PublicIds.of(UUID.fromString("03004053-c23e-5206-8514-fb551dd328f4"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5cbec2f0-9a5a-478b-8ec7-dd75752010ba")), IkeTerm.ENGLISH_LANGUAGE, "Inactive state", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6e8c8b01-8290-4748-976e-b8e26fd23dcd")), IkeTerm.ENGLISH_LANGUAGE, "Inactive", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("31570a4f-5aa4-45fd-9544-b24cadf08304")), IkeTerm.ENGLISH_LANGUAGE, "Concept used to represent a status for components that are no longer active", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e1059d68-47b3-492d-8328-4d69b8ecd1a1")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "03004053-c23e-5206-8514-fb551dd328f4")
                .statedAxioms(PublicIds.of(UUID.fromString("319fc2d9-5d3a-581c-bc58-43d12af64e6e")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.STATUS_VALUE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("14645470-965f-42d9-be89-a5db755403f3")))
                .semanticOn(PublicIds.of(UUID.fromString("5cbec2f0-9a5a-478b-8ec7-dd75752010ba")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0237bc6f-dcb9-457f-879d-8bc3b74e767f")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6e8c8b01-8290-4748-976e-b8e26fd23dcd")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("60e5d568-2c01-46ac-bd90-2f99f67a37a2")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("31570a4f-5aa4-45fd-9544-b24cadf08304")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1db30e40-d417-4f49-9e65-7ca21b95a6ae")), IkeTerm.PREFERRED)
                ;

        set.concept("Withdrawn state", PublicIds.of(UUID.fromString("35fd4750-6e43-5fa3-ba7f-f2ad376052bc"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c5bd826a-7d19-4c40-a225-8f6c3cab26c4")), IkeTerm.ENGLISH_LANGUAGE, "Withdrawn state", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3e53e122-bffa-4c3e-8722-20b41583ecae")), IkeTerm.ENGLISH_LANGUAGE, "Withdrawn", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("04a2fbe5-cee1-4900-88f9-19a34a9fbb54")), IkeTerm.ENGLISH_LANGUAGE, "Concept used to represent a status for components that are withdrawn.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("143a2b90-bc37-4cf4-b9b8-41138136f03d")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "35fd4750-6e43-5fa3-ba7f-f2ad376052bc")
                .statedAxioms(PublicIds.of(UUID.fromString("364053f3-c661-5420-a852-8320ab7b5793")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.STATUS_VALUE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("54899176-ed02-4367-b2c7-67f50e7542c1")))
                .semanticOn(PublicIds.of(UUID.fromString("c5bd826a-7d19-4c40-a225-8f6c3cab26c4")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("91cd0a09-7587-49cc-af08-98a31632544a")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3e53e122-bffa-4c3e-8722-20b41583ecae")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bb806294-37a0-4ce6-927e-21d7d42ba8d8")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("04a2fbe5-cee1-4900-88f9-19a34a9fbb54")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cd4c33ad-2f55-4d3f-bd82-718c04efa224")), IkeTerm.PREFERRED)
                ;

    }
}
