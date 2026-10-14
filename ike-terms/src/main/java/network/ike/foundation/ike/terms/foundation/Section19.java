package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Display fields" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section19 {

    private Section19() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Display Fields", PublicIds.of(UUID.fromString("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a257e851-3b27-4a70-81cc-2d65b75dba97")), KernelTerm.ENGLISH_LANGUAGE, "Display Fields", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("39ef586e-2771-4798-b73e-c020072f89f3")), KernelTerm.ENGLISH_LANGUAGE, "Display fields", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a4959e78-202a-46e5-9c79-34112fafe15b")), KernelTerm.ENGLISH_LANGUAGE, "Captures the human readable terms", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("5b80e4ca-1c58-4fb6-92f6-1c3ee534ea67")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "4e627b9c-cecb-5563-82fc-cb0ee25113b1")
                .statedAxioms(PublicIds.of(UUID.fromString("5a294018-3c3a-5ccb-b7cf-c8c3ce148a12")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("76f6e604-3307-4e83-8dee-fd89178c8de5")))
                .semanticOn(PublicIds.of(UUID.fromString("a257e851-3b27-4a70-81cc-2d65b75dba97")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6383534e-3ba9-4954-9472-4baa8d77e2df")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("39ef586e-2771-4798-b73e-c020072f89f3")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("db898047-3840-47aa-aa8f-12a23c7c22ff")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a4959e78-202a-46e5-9c79-34112fafe15b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("26e2b5ae-3e5e-4ca7-a8a7-6af69bf99b79")), KernelTerm.PREFERRED)
                ;

        set.concept("Double display field (SOLOR)", PublicIds.of(UUID.fromString("85ff6e8f-9151-5428-a5f0-e07844b69260"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bb643634-8936-44db-ab45-e227b50a3746")), KernelTerm.ENGLISH_LANGUAGE, "Double display field (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fcaf602c-c187-4b58-9d9e-348f09da7ab9")), KernelTerm.ENGLISH_LANGUAGE, "Double display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a5778bce-0d89-4812-aad8-432120ddb140")), KernelTerm.ENGLISH_LANGUAGE, "A data value (type of structure for data)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("6f22709a-6c22-4571-96f8-28881e1e71da")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "85ff6e8f-9151-5428-a5f0-e07844b69260")
                .statedAxioms(PublicIds.of(UUID.fromString("9a054d51-ecf7-5d68-8417-4ebb2301f1a8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f8fe370a-8758-4a27-91b3-57193b0becf2")))
                .semanticOn(PublicIds.of(UUID.fromString("bb643634-8936-44db-ab45-e227b50a3746")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("60c944c0-65cd-4bcb-9c68-607da0f87dc8")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("fcaf602c-c187-4b58-9d9e-348f09da7ab9")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d30c73d7-add5-49da-b9ba-c7f77e45bb47")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a5778bce-0d89-4812-aad8-432120ddb140")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3c001218-12b8-4aba-a527-2bf31e69f932")), KernelTerm.PREFERRED)
                ;

        set.concept("Logical expression display field (SOLOR)", PublicIds.of(UUID.fromString("c16eb414-8840-54f8-9bd2-e2f1ab37e19d"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("065a1596-7d61-452d-99ba-cfdb26952cfd")), KernelTerm.ENGLISH_LANGUAGE, "Logical expression display field (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("935062f1-c330-467d-b46f-3304c99f7d88")), KernelTerm.ENGLISH_LANGUAGE, "Logical expression display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("74d2862c-4b9a-4f5f-947a-c696ef233f07")), KernelTerm.ENGLISH_LANGUAGE, "Logical expression field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("91123457-13c5-4336-aa25-4363ad1161c9")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "c16eb414-8840-54f8-9bd2-e2f1ab37e19d")
                .statedAxioms(PublicIds.of(UUID.fromString("9a1905ba-e3a8-50f9-9140-748ab3adc7b8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c6aa9352-8da2-4cce-9621-1e69559607bc")))
                .semanticOn(PublicIds.of(UUID.fromString("065a1596-7d61-452d-99ba-cfdb26952cfd")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("992b32eb-51c4-4310-a156-01f57adb5922")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("935062f1-c330-467d-b46f-3304c99f7d88")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2827a229-dd7b-4f2f-92dd-f004fede282d")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("74d2862c-4b9a-4f5f-947a-c696ef233f07")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4a5a15cc-e37e-4bf0-8682-aedb1fc53804")), KernelTerm.PREFERRED)
                ;

        set.concept("UUID display field (SOLOR)", PublicIds.of(UUID.fromString("dea8cb0f-9bb5-56bb-af27-a14943cb24ba"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8539795f-88a2-4813-bf12-a4daa667a539")), KernelTerm.ENGLISH_LANGUAGE, "UUID display field (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("660272c9-cc6d-4c6d-a1c1-5e20987f008d")), KernelTerm.ENGLISH_LANGUAGE, "UUID display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e26cbd32-d2b2-4852-8e85-63a87d1365ff")), KernelTerm.ENGLISH_LANGUAGE, "Universally unique identifier field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("33f70b25-61a6-4862-97c4-8de5018047e6")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "dea8cb0f-9bb5-56bb-af27-a14943cb24ba")
                .statedAxioms(PublicIds.of(UUID.fromString("e28f2d3b-9054-516a-929d-c977e9b84131")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("082b7305-e1fb-4b4f-87e6-c7c8501bf4ab")))
                .semanticOn(PublicIds.of(UUID.fromString("8539795f-88a2-4813-bf12-a4daa667a539")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e822c661-ce13-4194-bea8-d0cf6b248d73")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("660272c9-cc6d-4c6d-a1c1-5e20987f008d")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6a2dca4d-00bc-466e-ba78-4ffb72fbae14")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e26cbd32-d2b2-4852-8e85-63a87d1365ff")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4e86de1d-6d65-4d90-840a-61df832fcf6c")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Integer display Field"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#885, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Integer data type", PublicIds.of(UUID.fromString("ff59c300-9c4e-5e77-a35d-6a133eb3440f"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a28c2f47-376b-4b28-a0d7-e8036989072c")), KernelTerm.ENGLISH_LANGUAGE, "Integer data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e3bfdc5f-4b60-484c-93db-cdcff43616c3")), KernelTerm.ENGLISH_LANGUAGE, "Integer display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("33f4e9cb-3030-4d04-9ed3-f26180fc58e8")), KernelTerm.ENGLISH_LANGUAGE, "Data type that represents some range of mathematical integers", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("09432660-b8dd-4b24-b68e-717cf418fa25")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "ff59c300-9c4e-5e77-a35d-6a133eb3440f")
                .statedAxioms(PublicIds.of(UUID.fromString("7a6ff33b-b3dc-565b-b845-b090afee5f2d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c23f7773-d5f9-4ac5-a719-7be3e87d9cfe")))
                .semanticOn(PublicIds.of(UUID.fromString("a28c2f47-376b-4b28-a0d7-e8036989072c")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e58693b7-7350-4dc0-b61e-568353123520")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e3bfdc5f-4b60-484c-93db-cdcff43616c3")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7efbc6c1-c9bd-4421-9698-fed6c671c036")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("33f4e9cb-3030-4d04-9ed3-f26180fc58e8")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f763a947-3dff-4d1f-ae3b-36b904a8747f")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Component display field"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Component data type", PublicIds.of(UUID.fromString("fb00d132-fcc3-5cbf-881d-4bcc4b4c91b3"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("09cf7374-aa84-4ea9-91cc-793182cca0da")), KernelTerm.ENGLISH_LANGUAGE, "Component data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7484b839-09c3-4f92-8e67-a25cce1b131c")), KernelTerm.ENGLISH_LANGUAGE, "Component display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3ed2ec1f-e5a4-42d0-916e-f7f555f58204")), KernelTerm.ENGLISH_LANGUAGE, "A field that identifies any component -- concept, semantic, pattern, or STAMP -- by reference, not restricted to concepts.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("119bf1b5-5207-48f8-8ba0-0a37f6d0dfe2")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "fb00d132-fcc3-5cbf-881d-4bcc4b4c91b3")
                .statedAxioms(PublicIds.of(UUID.fromString("60079b55-1394-5683-8038-497783c513d4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("07696f02-835b-47fe-971f-db40ff457bcf")))
                .semanticOn(PublicIds.of(UUID.fromString("09cf7374-aa84-4ea9-91cc-793182cca0da")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9509d2aa-1929-4f67-b6d1-74b8a7466807")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7484b839-09c3-4f92-8e67-a25cce1b131c")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7043c359-dd9d-4da9-b980-a20154a01943")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3ed2ec1f-e5a4-42d0-916e-f7f555f58204")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("519c53ea-1d60-4df1-bf77-40dca51b3e25")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "String display field"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("String data type", PublicIds.of(UUID.fromString("a46aaf11-b37a-32d6-abdc-707f084ec8f5"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("26bed67f-21b7-4623-a6b9-246afe790e95")), KernelTerm.ENGLISH_LANGUAGE, "String data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d2afae18-d526-4bd4-a7d7-758d0b73757a")), KernelTerm.ENGLISH_LANGUAGE, "String display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3062c285-a7b4-4760-ac8d-97204f8ce8cc")), KernelTerm.ENGLISH_LANGUAGE, "A sequence of characters, either as a literal constant or as a variable. Strings could be used to represent terms from code systems or URLs, textual definitions, etc.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("fd05e7ae-54ad-47f9-8f3d-a7d0511c2dc3")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "a46aaf11-b37a-32d6-abdc-707f084ec8f5")
                .statedAxioms(PublicIds.of(UUID.fromString("e7cd45b1-2e48-5a04-a669-de7a559651b7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5fef7506-bd2f-407e-89ab-15d7ed4c7001")))
                .semanticOn(PublicIds.of(UUID.fromString("26bed67f-21b7-4623-a6b9-246afe790e95")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("14728945-d416-4389-9a04-f0db518eaf91")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d2afae18-d526-4bd4-a7d7-758d0b73757a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7bdc03b9-8082-4ee6-b1df-26a36beaffc0")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3062c285-a7b4-4760-ac8d-97204f8ce8cc")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b3668f7e-4b96-42ac-905c-4249df546aab")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Concept display field (SOLOR)"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Concept data type", PublicIds.of(UUID.fromString("ac8f1f54-c7c6-5fc7-b1a8-ebb04b918557"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ff9a1615-8006-4168-8417-921f0fe5ee15")), KernelTerm.ENGLISH_LANGUAGE, "Concept data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2eb35bda-1edf-487c-9fc9-3527df29be58")), KernelTerm.ENGLISH_LANGUAGE, "Concept display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("626c0837-b710-4cf0-9b3f-193754768492")), KernelTerm.ENGLISH_LANGUAGE, "Field for the human readable description for the given concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("96199db4-a984-45b7-8b38-8ba84483b9ba")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "ac8f1f54-c7c6-5fc7-b1a8-ebb04b918557")
                .statedAxioms(PublicIds.of(UUID.fromString("59672b98-86e5-5b90-baa0-389297ffc17b")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b0b3fb34-32b4-4f90-8761-554d35b166f9")))
                .semanticOn(PublicIds.of(UUID.fromString("ff9a1615-8006-4168-8417-921f0fe5ee15")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4617157b-6014-4edd-a05e-0b28bd5addd6")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2eb35bda-1edf-487c-9fc9-3527df29be58")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0f8459d2-dd14-4a69-8aab-3210d2c4b793")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("626c0837-b710-4cf0-9b3f-193754768492")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0f59ae11-6bbe-451e-8181-639c80813336")), KernelTerm.PREFERRED)
                ;

        set.concept("Vertex display field (SOLOR)", PublicIds.of(UUID.fromString("3e56c6b6-5371-11eb-ae93-0242ac130002"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c6840c7d-3b9f-40d3-b9e9-f35f3499aeda")), KernelTerm.ENGLISH_LANGUAGE, "Vertex display field (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e940f489-69d0-42eb-adf1-f1edc572e7d7")), KernelTerm.ENGLISH_LANGUAGE, "Vertex display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("869eb45e-0287-496a-bf07-894d65b5c97c")), KernelTerm.ENGLISH_LANGUAGE, "Field for Vertex", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("9d6699da-bc87-4ce1-9a5b-7fa011ba8110")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "3e56c6b6-5371-11eb-ae93-0242ac130002")
                .statedAxioms(PublicIds.of(UUID.fromString("27fc021d-2fd2-5d73-bbd4-7d96e8188740")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("15e413b7-5589-4cbe-8f2e-f6ad601b9afc")))
                .semanticOn(PublicIds.of(UUID.fromString("c6840c7d-3b9f-40d3-b9e9-f35f3499aeda")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8f8bb722-a929-4919-a65d-9dc54060bc21")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e940f489-69d0-42eb-adf1-f1edc572e7d7")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9ff6746d-c84a-490b-9ede-1ca6e14bda7e")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("869eb45e-0287-496a-bf07-894d65b5c97c")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3138e759-b18c-4ee1-82af-0f6b6ac1ea0c")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Component Id display list"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#885, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Component Id list data type", PublicIds.of(UUID.fromString("e553d3f1-63e1-4292-a3a9-af646fe44292"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("02047230-d771-4a21-b17c-19d94ddb2fc8")), KernelTerm.ENGLISH_LANGUAGE, "Component Id list data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("54ebd96c-b3d1-44be-af7d-285757b7bd1a")), KernelTerm.ENGLISH_LANGUAGE, "Component Id display list", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e8c9285f-a7e1-4d30-9f19-92e9cedf3719")), KernelTerm.ENGLISH_LANGUAGE, "An ordered list of component ids.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("87c0844e-ca78-4dbc-a090-b0210ec4a78c")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "e553d3f1-63e1-4292-a3a9-af646fe44292")
                .statedAxioms(PublicIds.of(UUID.fromString("858200bb-0fe1-5b5a-a439-f3c0f2d85a76")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4717a0e8-944c-40f9-b14d-28425baff6b6")))
                .semanticOn(PublicIds.of(UUID.fromString("02047230-d771-4a21-b17c-19d94ddb2fc8")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("de72fe1a-938d-4e6f-a21a-ccb5359951cb")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("54ebd96c-b3d1-44be-af7d-285757b7bd1a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("40543636-af91-47c8-89ff-d6ac6c2f25e4")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e8c9285f-a7e1-4d30-9f19-92e9cedf3719")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d43f9c6e-5384-4d08-a258-6ed37729cd27")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "DiGraph display field"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#885, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("DiGraph data type", PublicIds.of(UUID.fromString("60113dfe-2bad-11eb-adc1-0242ac120002"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ffa4ed98-142d-49dc-a0ad-2bb72397527c")), KernelTerm.ENGLISH_LANGUAGE, "DiGraph data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a72c6e67-6781-46c6-89a0-7e4d021b8ec6")), KernelTerm.ENGLISH_LANGUAGE, "DiGraph display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("242ac229-b3f9-4562-a320-87fa74b77638")), KernelTerm.ENGLISH_LANGUAGE, "A field data type whose values are directed graphs — the structure kind named by Directed graph (DiGraph) under Graph. A display-field concept about that structure, not a kind of graph, which is why it lives under Display Fields rather than in the graph family (IKE-Network/ike-issues#950).", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("45db3644-68d0-4007-80c2-835681537053")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "60113dfe-2bad-11eb-adc1-0242ac120002")
                .statedAxioms(PublicIds.of(UUID.fromString("e02e29ae-b70b-5388-8578-0028d029bb60")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("ab6d0083-1ad9-49d1-aa9d-c5e528fd548d")))
                .semanticOn(PublicIds.of(UUID.fromString("ffa4ed98-142d-49dc-a0ad-2bb72397527c")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("23e0bed6-8669-4e94-b30e-ff368efcef86")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a72c6e67-6781-46c6-89a0-7e4d021b8ec6")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b4095a38-21b8-49e7-adb6-c1fd9c5bc74d")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("242ac229-b3f9-4562-a320-87fa74b77638")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a00b4785-14f6-44e2-8ea6-eb72d8758025")), KernelTerm.PREFERRED)
                ;

        set.concept("Image display field (SOLOR)", PublicIds.of(UUID.fromString("cd9ea037-0af9-586b-9369-7bc044cdb8f7"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9907f5d7-94e6-43dd-bbab-bcd1a074408c")), KernelTerm.ENGLISH_LANGUAGE, "Image display field (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("da892f75-6a6c-4b01-9f20-94435a0affb7")), KernelTerm.ENGLISH_LANGUAGE, "Image display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cbd56fe8-6ec2-4c17-bd40-a7c25363bb68")), KernelTerm.ENGLISH_LANGUAGE, "An image", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("24526c3c-b320-47c2-8a23-6f9c9d49f46a")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "cd9ea037-0af9-586b-9369-7bc044cdb8f7")
                .statedAxioms(PublicIds.of(UUID.fromString("3091da19-a725-588e-9dad-15aca89340d7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9f5bbf3a-e327-494d-99a1-88af90f0e572")))
                .semanticOn(PublicIds.of(UUID.fromString("9907f5d7-94e6-43dd-bbab-bcd1a074408c")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("98a967bb-cb41-4ed8-86a5-eaeff9d61cfc")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("da892f75-6a6c-4b01-9f20-94435a0affb7")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8a2477b7-39c0-4bdf-9c81-b8da2a233b8b")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cbd56fe8-6ec2-4c17-bd40-a7c25363bb68")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b0117baa-5a02-4d35-b2d2-a1af0b4af6f9")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Component Id display set"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#885, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Component Id set data type", PublicIds.of(UUID.fromString("e283af51-2e8f-44fa-9bf1-89a99a7c7631"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9335dd4d-c3d9-4d1e-b17b-3edc6f2e3151")), KernelTerm.ENGLISH_LANGUAGE, "Component Id set data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0fa46b23-cfd6-4a0c-8e3c-80d8b7e1e5f4")), KernelTerm.ENGLISH_LANGUAGE, "Component Id display set", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9ab0315d-c338-4a40-86f9-9df320c51feb")), KernelTerm.ENGLISH_LANGUAGE, "An unordered set of component ids.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("32729b6a-d45b-4c83-a797-b89a6167753d")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "e283af51-2e8f-44fa-9bf1-89a99a7c7631")
                .statedAxioms(PublicIds.of(UUID.fromString("3aa0a60d-a946-501f-9cc7-ec21cfac08e2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("241e6dde-1c8c-4b99-b968-08ea4be83ede")))
                .semanticOn(PublicIds.of(UUID.fromString("9335dd4d-c3d9-4d1e-b17b-3edc6f2e3151")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("92ab7e22-57ed-424a-b07b-8b8e9a93c5b6")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0fa46b23-cfd6-4a0c-8e3c-80d8b7e1e5f4")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d46e0bc1-10a0-4577-9f11-2509598c2cfd")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9ab0315d-c338-4a40-86f9-9df320c51feb")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ada05080-070e-490e-9086-b60a1d8eea02")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Boolean display field (SOLOR)"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#885, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Boolean data type", PublicIds.of(UUID.fromString("d6b9e2cc-31c6-5e80-91b7-7537690aae32"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3344f24a-e9fd-48cd-a709-b2ea2def893e")), KernelTerm.ENGLISH_LANGUAGE, "Boolean data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c4d49fb5-afe9-4e0a-843b-e54d4e7b80ce")), KernelTerm.ENGLISH_LANGUAGE, "Boolean display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f5d91bb8-9343-48aa-a551-0e357b656a95")), KernelTerm.ENGLISH_LANGUAGE, "True (1) or false (0)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4a1796ba-61e9-4a73-ace3-86e6a5e9d326")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "d6b9e2cc-31c6-5e80-91b7-7537690aae32")
                .statedAxioms(PublicIds.of(UUID.fromString("a46a4415-3fa6-5345-9230-e81fccd518da")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("52f42c08-3fea-423a-ba7f-975c6c018074")))
                .semanticOn(PublicIds.of(UUID.fromString("3344f24a-e9fd-48cd-a709-b2ea2def893e")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a1e7b6fa-6b3a-4b06-9654-8bb1992fd1a4")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c4d49fb5-afe9-4e0a-843b-e54d4e7b80ce")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("db94c188-4668-418b-b677-45a3afae2ece")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f5d91bb8-9343-48aa-a551-0e357b656a95")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6fc28210-7ec9-4a8f-bb1a-d6922682813f")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Semantic display field type (SOLOR)"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#885, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Semantic data type", PublicIds.of(UUID.fromString("9c3dfc88-51e4-5e51-a59a-88dd580162b7"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("59a6ae3f-6b53-4926-8b0b-fd49dae999d5")), KernelTerm.ENGLISH_LANGUAGE, "Semantic data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0c5b1d71-7ce1-4cea-adce-03c02ee6233e")), KernelTerm.ENGLISH_LANGUAGE, "Semantic display field type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("284f4bfa-5d38-4a7a-bcab-9df6710bcc94")), KernelTerm.ENGLISH_LANGUAGE, "A field that holds a reference to a semantic.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f911e1a9-559f-4cc4-8fb1-69b3518daa6e")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "9c3dfc88-51e4-5e51-a59a-88dd580162b7")
                .statedAxioms(PublicIds.of(UUID.fromString("fcb232b0-bc6e-5806-bda1-1cbcd4fc3a07")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a7632b06-777e-45c7-981d-12f86bb3eaaf")))
                .semanticOn(PublicIds.of(UUID.fromString("59a6ae3f-6b53-4926-8b0b-fd49dae999d5")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("632045cc-3c8c-4825-a6fd-6a016ae5c542")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0c5b1d71-7ce1-4cea-adce-03c02ee6233e")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("206ad40d-275b-4c7b-88d2-1edb9064d720")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("284f4bfa-5d38-4a7a-bcab-9df6710bcc94")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3a433939-3bab-424d-97e9-e59d84e30fb0")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Decimal display field"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#885, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Decimal data type", PublicIds.of(UUID.fromString("b413fe94-4ada-4aee-96f9-22be19699d40"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0d3129bb-6402-468b-806e-7e2f376b3855")), KernelTerm.ENGLISH_LANGUAGE, "Decimal data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5e1647a9-1ccd-48a2-a906-348bdab3bc67")), KernelTerm.ENGLISH_LANGUAGE, "Decimal display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("635b6a1e-67c5-41e2-b3bb-e02049e00d40")), KernelTerm.ENGLISH_LANGUAGE, "Represents values as high-precision decimal values.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("363d7cb7-1cd5-4df4-9487-68f8669f879a")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "b413fe94-4ada-4aee-96f9-22be19699d40")
                .statedAxioms(PublicIds.of(UUID.fromString("0ab2612a-4a87-5388-9eb1-01de31430d86")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("de310d0f-2241-4ae1-909c-13d93282c318")))
                .semanticOn(PublicIds.of(UUID.fromString("0d3129bb-6402-468b-806e-7e2f376b3855")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8d06d467-31d9-4b1d-88ca-c8609946a70f")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5e1647a9-1ccd-48a2-a906-348bdab3bc67")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2011eee3-1eb7-445c-8298-87373086ebf9")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("635b6a1e-67c5-41e2-b3bb-e02049e00d40")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bad571fc-7c09-4f8d-9498-e5aff87b40be")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Array display field (Solor)"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#885, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Array data type", PublicIds.of(UUID.fromString("b168ad04-f814-5036-b886-fd4913de88c8"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a4cae3de-908d-47cd-9d3a-754c88dd2c96")), KernelTerm.ENGLISH_LANGUAGE, "Array data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("db44e027-8834-47eb-bf74-11421ac598d6")), KernelTerm.ENGLISH_LANGUAGE, "Array display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1af49208-c703-4a9e-9861-c3778ef0634d")), KernelTerm.ENGLISH_LANGUAGE, "A lexical set of semantically related elements/items", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("48ca16b5-f8b6-46e3-a27f-64a774b32803")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "b168ad04-f814-5036-b886-fd4913de88c8")
                .statedAxioms(PublicIds.of(UUID.fromString("bae2d4c4-f5f1-5cb8-bfb2-671ad6ca2141")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c101651d-79d6-49d2-bdd8-a045eddb072d")))
                .semanticOn(PublicIds.of(UUID.fromString("a4cae3de-908d-47cd-9d3a-754c88dd2c96")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f9dadd0e-65ec-446c-813d-452b8630bf10")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("db44e027-8834-47eb-bf74-11421ac598d6")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a67aa3db-56b3-4657-b4d0-36d910609cca")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1af49208-c703-4a9e-9861-c3778ef0634d")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a614d04a-9e15-4d1e-b83d-3acc16e85560")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Float display field"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Float data type", PublicIds.of(UUID.fromString("6efe7087-3e3c-5b45-8109-90d7652b1506"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("176c19e5-cd96-4a35-9d69-b2cfdaa95bb4")), KernelTerm.ENGLISH_LANGUAGE, "Float data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c1538df2-a302-46a6-bfd6-c448ea963f69")), KernelTerm.ENGLISH_LANGUAGE, "Float display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("42895bb6-91e1-4161-b40f-af5b7898231b")), KernelTerm.ENGLISH_LANGUAGE, "Represents values as high-precision fractional values.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f8236c8a-016f-4ddc-934d-4d456a6ea54b")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "6efe7087-3e3c-5b45-8109-90d7652b1506")
                .statedAxioms(PublicIds.of(UUID.fromString("e42f8c6d-8c08-54b3-acbf-476290a46d7f")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("3ca4dff3-a97c-45bf-a369-04941eac8676")))
                .semanticOn(PublicIds.of(UUID.fromString("176c19e5-cd96-4a35-9d69-b2cfdaa95bb4")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("396f740e-460e-4904-8e94-26aa382887bb")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c1538df2-a302-46a6-bfd6-c448ea963f69")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("03ec7769-76f9-45a0-8a8f-428c65917035")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("42895bb6-91e1-4161-b40f-af5b7898231b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e7d2653c-ef1f-4396-9af5-1d1c4dd18f14")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Byte array display field (SOLOR)"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#885, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Byte array data type", PublicIds.of(UUID.fromString("dbdd8df2-aec3-596b-88fc-7b83b5594a45"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("36f3d937-c58b-425c-bb05-302bb3770734")), KernelTerm.ENGLISH_LANGUAGE, "Byte array data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("713d1666-1c64-41f3-8ea4-c90076a3392b")), KernelTerm.ENGLISH_LANGUAGE, "Byte array display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cbc98f10-b9c5-40fa-9ad1-56be6a0929e4")), KernelTerm.ENGLISH_LANGUAGE, "An array of bytes", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0c6df78e-07d2-4876-b2ab-b09209ebc910")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "dbdd8df2-aec3-596b-88fc-7b83b5594a45")
                .statedAxioms(PublicIds.of(UUID.fromString("e196e05b-afb5-51e2-8052-c064f6959682")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("dcb7bb7a-fb0c-46ff-88fa-2f83284a5b07")))
                .semanticOn(PublicIds.of(UUID.fromString("36f3d937-c58b-425c-bb05-302bb3770734")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e8740619-7192-4bce-ad1c-2823ae476417")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("713d1666-1c64-41f3-8ea4-c90076a3392b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("dea4fa54-6151-4dba-8224-adcb4b0c4a6a")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cbc98f10-b9c5-40fa-9ad1-56be6a0929e4")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f08e6139-1ac9-4ab6-802d-07029224ca3c")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "DiTree display field"):
        // ConceptToDataType-confirmed real data type, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("DiTree data type", PublicIds.of(UUID.fromString("32f64fc6-5371-11eb-ae93-0242ac130002"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("42547119-239c-4901-82d9-e49c6e2734fb")), KernelTerm.ENGLISH_LANGUAGE, "DiTree data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("adc7696a-c864-47e8-8f32-d3b4f639354d")), KernelTerm.ENGLISH_LANGUAGE, "DiTree display field", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2eca023f-90a9-4aaf-a835-b19d8ea1c8a7")), KernelTerm.ENGLISH_LANGUAGE, "A field data type whose values are directed trees — the structure kind named by Directed tree (DiTree) under Directed graph and Tree; each stored logical expression is one such value. A display-field concept about that structure, not a kind of tree, which is why it lives under Display Fields rather than in the graph family (IKE-Network/ike-issues#950).", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("43eb2671-2823-48f8-9a06-65dbe7ec08a9")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "32f64fc6-5371-11eb-ae93-0242ac130002")
                .statedAxioms(PublicIds.of(UUID.fromString("8aed1bc4-43a9-5f76-9f2f-c2b2039f2759")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9ab05525-f643-422f-be9b-3f8679296b4b")))
                .semanticOn(PublicIds.of(UUID.fromString("42547119-239c-4901-82d9-e49c6e2734fb")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cff98d60-53be-4898-b962-1437608d3e69")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("adc7696a-c864-47e8-8f32-d3b4f639354d")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f32b4bba-beb2-46d0-bcd7-97a82127ee5f")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2eca023f-90a9-4aaf-a835-b19d8ea1c8a7")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6cf2ee08-5655-46b4-839a-e094ba78ec70")), KernelTerm.PREFERRED)
                ;

    }
}
