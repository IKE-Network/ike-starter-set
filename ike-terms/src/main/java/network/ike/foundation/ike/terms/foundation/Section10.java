package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "EL++ terminological axioms" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section10 {

    private Section10() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("EL++ terminological axioms", PublicIds.of(UUID.fromString("b3ec50c4-e8cf-4720-b192-31374705f3b7"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9af7194a-fcc8-4be4-b3ad-c33e0265389e")), IkeTerm.ENGLISH_LANGUAGE, "EL++ terminological axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a6645bde-62f5-4500-ad84-be9131e01cb9")), IkeTerm.ENGLISH_LANGUAGE, "EL++ terminological axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fc8f52d8-401c-4b98-abab-46745c61023f")), IkeTerm.ENGLISH_LANGUAGE, "The set of relationships or axioms has defined by the EL++ Logic", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("fdfb68b6-0bc8-489e-8919-c94f46767b7e")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b3ec50c4-e8cf-4720-b192-31374705f3b7")
                .statedAxioms(PublicIds.of(UUID.fromString("bd15f222-c3b0-5f0b-88b0-79591505e1f2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Axioms", PublicIds.of(UUID.fromString("20746b91-521a-45a6-89da-0fe32384a67f")))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("2b8ba933-a12b-41d4-bafa-2b344eb1dfbe")))
                .semanticOn(PublicIds.of(UUID.fromString("9af7194a-fcc8-4be4-b3ad-c33e0265389e")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9eb40ccd-8f08-494e-9380-55795d0e7bab")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a6645bde-62f5-4500-ad84-be9131e01cb9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("15ca4cb3-40cf-4f39-8fed-3fe2cf35a952")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("fc8f52d8-401c-4b98-abab-46745c61023f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ea31813e-d187-48e3-80e8-1f7c53b36f9e")), IkeTerm.PREFERRED)
                ;

        set.concept("EL++ Inferred terminological axioms", PublicIds.of(UUID.fromString("b6d3be7d-1d7f-5c44-a425-5357f878c212"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a4a4599b-6e3a-43a9-a3bc-27ea285af7d3")), IkeTerm.ENGLISH_LANGUAGE, "EL++ Inferred terminological axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2fd741ec-9142-4985-b64a-b4a3c12d2fb0")), IkeTerm.ENGLISH_LANGUAGE, "EL++ Inferred terminological axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f85df6dd-2c5c-4d11-bc0c-a145a042fa32")), IkeTerm.ENGLISH_LANGUAGE, "The inferred side of a concept's EL++ terminological axioms: the definitional axioms a classifier concluded follow from what was stated — computed, never hand-written. The EL++ Inferred Axioms Pattern's one field carries them as a directed tree.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4904979b-3c30-42a4-bc11-ca2e37b0a00e")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b6d3be7d-1d7f-5c44-a425-5357f878c212")
                .statedAxioms(PublicIds.of(UUID.fromString("0d4bd9b8-63d9-5573-9f5a-3e36e960ef63")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_TERMINOLOGICAL_AXIOMS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d850a9c6-e1ec-4fe9-a626-2abe782e5044")))
                .semanticOn(PublicIds.of(UUID.fromString("a4a4599b-6e3a-43a9-a3bc-27ea285af7d3")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c947791d-387b-4cd2-be27-1612ebd9f3c0")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2fd741ec-9142-4985-b64a-b4a3c12d2fb0")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("14be2795-a810-4b50-bce0-83c0001d8776")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f85df6dd-2c5c-4d11-bc0c-a145a042fa32")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("79b7bd80-21bb-4d3c-bb09-8de07d8acaf0")), IkeTerm.PREFERRED)
                ;

        set.concept("Necessary set", PublicIds.of(UUID.fromString("acaa2eba-8364-5493-b24c-b3884d34bb60"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dbe4d313-d421-4170-add0-bc900728f964")), IkeTerm.ENGLISH_LANGUAGE, "Necessary set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b9cbe784-cd4e-4d6a-9872-d9fdfda5128f")), IkeTerm.ENGLISH_LANGUAGE, "Necessary set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f7a3bbe6-7838-47fe-8d8b-e8e334178ebb")), IkeTerm.ENGLISH_LANGUAGE, "A set of relationships that is always true of a concept.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("83a3c2a7-0d5f-412c-bbc6-7298240d6942")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "acaa2eba-8364-5493-b24c-b3884d34bb60")
                .statedAxioms(PublicIds.of(UUID.fromString("2e34b3ee-a3fa-5a91-9908-84ba3fd08f65")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS), leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("589c6060-72fb-4b74-b32a-bb8ff12af5b8")))
                .semanticOn(PublicIds.of(UUID.fromString("dbe4d313-d421-4170-add0-bc900728f964")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f5fec04a-1e52-44ba-8cf3-bae25c157077")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b9cbe784-cd4e-4d6a-9872-d9fdfda5128f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("acad7efe-6ebc-4b39-a26f-ac3c3514a5a3")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f7a3bbe6-7838-47fe-8d8b-e8e334178ebb")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b45526c9-0bd0-4ee4-bda3-46500445d72b")), IkeTerm.PREFERRED)
                ;

        set.concept("Inclusion set", PublicIds.of(UUID.fromString("def77c09-e1eb-40f2-931a-e7cf2ce0e597"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f7901556-eb9a-40fe-99e8-9c71a81031d2")), IkeTerm.ENGLISH_LANGUAGE, "Inclusion set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f3df02f7-f20c-44f9-b863-c93b2d3b66b0")), IkeTerm.ENGLISH_LANGUAGE, "Inclusion set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("14893c1e-7845-4702-a97d-2fce1a5bd387")), IkeTerm.ENGLISH_LANGUAGE, "A set of relationships that indicate something is has an inclusion. Not necessarily or sufficient but inclusive.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("9159c637-9499-42ed-a4d1-88e493104454")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "def77c09-e1eb-40f2-931a-e7cf2ce0e597")
                .statedAxioms(PublicIds.of(UUID.fromString("21a2f5cb-5e71-5051-8fb1-7cb2310df095")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS), leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8a180a9a-53a7-4616-82f6-d08aa693d9b8")))
                .semanticOn(PublicIds.of(UUID.fromString("f7901556-eb9a-40fe-99e8-9c71a81031d2")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f9a120c9-c7d3-4d7e-a37b-2b9f20e0ff47")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f3df02f7-f20c-44f9-b863-c93b2d3b66b0")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a2fe21d4-7c44-4c17-8a0c-5a62e5120007")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("14893c1e-7845-4702-a97d-2fce1a5bd387")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("eca25d26-8c84-4c86-b6f0-adcdb0a9055e")), IkeTerm.PREFERRED)
                ;

        set.concept("Role group", PublicIds.of(UUID.fromString("a63f4bf2-a040-11e5-8994-feff819cdc9f"), UUID.fromString("f97abff6-a221-57a1-9cd6-e79e723bfe2a"), UUID.fromString("051fbfed-3c40-3130-8c09-889cb7b7b5b6"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("30d7a8e1-5016-4d6f-825b-4dff31fb9262")), IkeTerm.ENGLISH_LANGUAGE, "Role group", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5917a05f-9961-4cd7-888e-4c6afcbde15e")), IkeTerm.ENGLISH_LANGUAGE, "Role group", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9f1ece03-c65a-4a5a-bc3b-faacaf9cb862")), IkeTerm.ENGLISH_LANGUAGE, "An association between a set of attribute or axiom value pairs that causes them to be considered together within a concept definition or post coordinated expression.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("78c1eba4-0308-425b-82e1-848c6e3c6951")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a63f4bf2-a040-11e5-8994-feff819cdc9f")
                .statedAxioms(PublicIds.of(UUID.fromString("286556d5-021b-58de-8e1b-5c2214eefc49")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS), leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7cd59858-fb69-480b-a16f-ab9a537583f2")))
                .semanticOn(PublicIds.of(UUID.fromString("30d7a8e1-5016-4d6f-825b-4dff31fb9262")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5069682b-56a3-4eea-874f-7165dcbacec1")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5917a05f-9961-4cd7-888e-4c6afcbde15e")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e9d79e12-512a-4d52-b850-5401b1c42183")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9f1ece03-c65a-4a5a-bc3b-faacaf9cb862")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("22b5f499-04e9-4882-833b-8f7d1cf93332")), IkeTerm.PREFERRED)
                ;

        set.concept("Role", PublicIds.of(UUID.fromString("46ae9325-dd24-5008-8fda-80cf1f0977c7"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0b77ade4-d22f-4108-bd31-615193f2a6c0")), IkeTerm.ENGLISH_LANGUAGE, "Role", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("64064881-2d75-4088-98a8-921df318e4b1")), IkeTerm.ENGLISH_LANGUAGE, "Role", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c0c104ee-c9f7-41d4-b8b4-7c3b6eed1af9")), IkeTerm.ENGLISH_LANGUAGE, "Is an abstract representation of a high-level role for a therapeutic medicinal product; the concepts are not intended to describe a detailed indication for therapeutic use nor imply that therapeutic use is appropriate in all clinical situations.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("a2513143-590f-47e6-b368-a83d5b8e4156")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "46ae9325-dd24-5008-8fda-80cf1f0977c7")
                .statedAxioms(PublicIds.of(UUID.fromString("403755ab-e752-5f8c-8a14-974739e31cbd")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_GROUP), leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS), leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9381cb99-9b29-4024-bfc0-45ccc338ea91")))
                .semanticOn(PublicIds.of(UUID.fromString("0b77ade4-d22f-4108-bd31-615193f2a6c0")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("12b6e026-96cf-458c-8410-7d93c8263337")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("64064881-2d75-4088-98a8-921df318e4b1")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5b7eba2f-2e46-4299-91c1-6eb19996d7ec")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c0c104ee-c9f7-41d4-b8b4-7c3b6eed1af9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("29318645-2b9a-4ee2-86b0-5423494df192")), IkeTerm.PREFERRED)
                ;

        set.concept("Role type", PublicIds.of(UUID.fromString("76320274-be2a-5ba0-b3e8-e6d2e383ee6a"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8d118e29-50cf-4000-8780-437da636ddb2")), IkeTerm.ENGLISH_LANGUAGE, "Role type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2450d5ab-7652-41fa-904f-2c6f98248a00")), IkeTerm.ENGLISH_LANGUAGE, "Role type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bc530a82-230c-4d0f-9201-0948ea29ee7f")), IkeTerm.ENGLISH_LANGUAGE, "Refers to a concept that represents a particular kind of relationship that can exist between two entities. It defines the specific function or responsibility that one entity plays in relation to another.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ab0c2dbb-18c3-42a1-876c-71bbacf879bd")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "76320274-be2a-5ba0-b3e8-e6d2e383ee6a")
                .statedAxioms(PublicIds.of(UUID.fromString("0305a7d3-1795-5758-b281-39fd284fd6a6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d68cf9eb-1600-4daa-b121-996a212ea43b")))
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("17127aed-6a1a-4d86-91b3-dace9f765e5e")), IkeTerm.ENGLISH_LANGUAGE, "Logical Role Type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semanticOn(PublicIds.of(UUID.fromString("8d118e29-50cf-4000-8780-437da636ddb2")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("47950d00-8450-4e3e-84b5-b80734c8ca6b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2450d5ab-7652-41fa-904f-2c6f98248a00")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ba6fdc9d-46f3-4611-8f98-a6c8b806b532")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bc530a82-230c-4d0f-9201-0948ea29ee7f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cd6d9c88-c03c-40cf-b47b-dd3f0aaab1da")), IkeTerm.PREFERRED)
                ;

        set.concept("Role operator", PublicIds.of(UUID.fromString("f9860cb8-a7c7-5743-9d7c-ffc6e8a24a0f"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b09bb49f-8f58-4872-bf08-2022b1bfcbc8")), IkeTerm.ENGLISH_LANGUAGE, "Role operator", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1212c7a7-8ba3-4ab2-8e66-896047c18e12")), IkeTerm.ENGLISH_LANGUAGE, "Role operator", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("09466eae-c6a2-412a-83e6-0495e4ab8f25")), IkeTerm.ENGLISH_LANGUAGE, "Concept that is used to describe universal vs existential restrictions.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("58931507-3054-4db1-8292-ee5bb6617258")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f9860cb8-a7c7-5743-9d7c-ffc6e8a24a0f")
                .statedAxioms(PublicIds.of(UUID.fromString("5fd317e2-fe68-5607-ba34-3a7c652a7df0")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_GROUP))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8e0f2420-38fc-4587-9860-fc90b40ed9e1")))
                .semanticOn(PublicIds.of(UUID.fromString("b09bb49f-8f58-4872-bf08-2022b1bfcbc8")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("96e10e72-c90c-493a-90a3-e160fae881c1")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1212c7a7-8ba3-4ab2-8e66-896047c18e12")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a58f2a29-467e-43cf-b4c9-97ed9065f54b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("09466eae-c6a2-412a-83e6-0495e4ab8f25")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9076534f-64a3-48cc-b2ee-ee2dff3b9d5f")), IkeTerm.PREFERRED)
                ;

        set.concept("Referenced component type restriction (SOLOR)", PublicIds.of(UUID.fromString("902f97b6-2ef4-59d7-b6f9-01278a00061c"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("073ce3b9-150b-4deb-b95e-768ba2cfdf31")), IkeTerm.ENGLISH_LANGUAGE, "Referenced component type restriction (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("148e2e5b-dc1b-4f9e-a1fe-7e29aacb5cb0")), IkeTerm.ENGLISH_LANGUAGE, "Referenced component type restriction", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e0c64bc5-0f79-4e63-bdc7-ad8aa3ef9daf")), IkeTerm.ENGLISH_LANGUAGE, "Stores the (Optional) referenced component type restriction selection which will be used by the validator to check the user input for the referenced component when creating an instance of a dynamic field", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4e17cb89-ec71-4be5-8fa2-8be8ecaffdac")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "902f97b6-2ef4-59d7-b6f9-01278a00061c")
                .statedAxioms(PublicIds.of(UUID.fromString("507b7c58-5c0f-5963-8ddf-f5512453dc54")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("52741372-bacf-4151-956f-43f9b1bff58a")))
                .semanticOn(PublicIds.of(UUID.fromString("073ce3b9-150b-4deb-b95e-768ba2cfdf31")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6d06865c-26d8-4012-93ee-93808d08922f")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("148e2e5b-dc1b-4f9e-a1fe-7e29aacb5cb0")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("28bcfebb-2477-415e-a748-484e86597a50")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e0c64bc5-0f79-4e63-bdc7-ad8aa3ef9daf")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7dd66fdb-f61a-4ef1-8078-42ceb712a521")), IkeTerm.PREFERRED)
                ;

        set.concept("Existential restriction", PublicIds.of(UUID.fromString("91e9080f-78f6-5d23-891d-f5b6e77995c8"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("13b265f8-1b9b-4214-925e-f945d83ccdb5")), IkeTerm.ENGLISH_LANGUAGE, "Existential restriction", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6d95545c-c1c7-44fd-aba5-c473abb6ad6a")), IkeTerm.ENGLISH_LANGUAGE, "Existential restriction", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("60efac68-e7a2-4a54-842b-46bb5b618f1c")), IkeTerm.ENGLISH_LANGUAGE, "Existential restrictions describe objects that participate in at least one relationship along a specified property to objects of a specified class.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("1f846f9a-8445-4f7c-8b50-48686f83eb45")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "91e9080f-78f6-5d23-891d-f5b6e77995c8")
                .statedAxioms(PublicIds.of(UUID.fromString("3b34fa02-777f-5621-ab86-ae0573fec19d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0dc50c86-f428-4c60-91f0-43628d866876")))
                .semanticOn(PublicIds.of(UUID.fromString("13b265f8-1b9b-4214-925e-f945d83ccdb5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("121398df-d1ae-424a-af84-e57b3479c51a")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6d95545c-c1c7-44fd-aba5-c473abb6ad6a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b0dc39ec-7474-4e80-8a97-65db820cfba0")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("60efac68-e7a2-4a54-842b-46bb5b618f1c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3eb70d3e-c773-43b4-88da-b6d57b5cd3d3")), IkeTerm.PREFERRED)
                ;

        set.concept("Referenced component subtype restriction (SOLOR)", PublicIds.of(UUID.fromString("8af1045e-1122-5072-9f29-ce7da9337915"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1f06a267-e0ba-497a-87a9-7984d9da94aa")), IkeTerm.ENGLISH_LANGUAGE, "Referenced component subtype restriction (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("eaf3a38e-8e12-4275-8658-ebb7930ebc0f")), IkeTerm.ENGLISH_LANGUAGE, "Referenced component subtype restriction", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4510872c-3297-4fa5-9a9e-63a6e57e5ea6")), IkeTerm.ENGLISH_LANGUAGE, "Stores the (optional) referenced component type sub restriction selection which will be used by the validator to check the user input for the referenced component when creating an instance of a dynamic field.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("6d80b522-86ce-4ebd-b7fd-e033f7cff4be")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8af1045e-1122-5072-9f29-ce7da9337915")
                .statedAxioms(PublicIds.of(UUID.fromString("e4fcf291-c5ca-55e5-8cdb-8e03d4cb3bf6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("43419177-4155-4eeb-9842-15b7a1d9fb88")))
                .semanticOn(PublicIds.of(UUID.fromString("1f06a267-e0ba-497a-87a9-7984d9da94aa")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("124778b0-a741-4ad6-9261-ea47c86cd985")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("eaf3a38e-8e12-4275-8658-ebb7930ebc0f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9292acaa-5a8a-4513-9c27-29c11622c425")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4510872c-3297-4fa5-9a9e-63a6e57e5ea6")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("13526539-e5b4-45dc-a1a0-5149e4a3c464")), IkeTerm.PREFERRED)
                ;

        set.concept("Universal Restriction", PublicIds.of(UUID.fromString("fc18c082-c6ad-52d2-b568-cc9568ace6c9"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3bdcbe73-658f-495c-a18a-bdd9e61b7d68")), IkeTerm.ENGLISH_LANGUAGE, "Universal Restriction", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("39cfd581-243a-4bce-b0e9-8f084c2fe859")), IkeTerm.ENGLISH_LANGUAGE, "Universal Restriction", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("16c34569-6c2e-4d4a-b540-3b792171d1eb")), IkeTerm.ENGLISH_LANGUAGE, "Universal restrictions constrain the relationships along a given property to concepts that are members of a specific class.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ccbb556c-9401-4a0f-a9e9-c09179e09a95")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "fc18c082-c6ad-52d2-b568-cc9568ace6c9")
                .statedAxioms(PublicIds.of(UUID.fromString("619956d1-f2ec-55ac-970f-b79b4f86d407")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_OPERATOR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("289e6198-0343-48f7-8248-19f90fe916c6")))
                .semanticOn(PublicIds.of(UUID.fromString("3bdcbe73-658f-495c-a18a-bdd9e61b7d68")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a2993868-7288-4086-861f-256fc13a8bc3")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("39cfd581-243a-4bce-b0e9-8f084c2fe859")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("41a5ccc5-fdab-46c6-94a8-647821c17edb")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("16c34569-6c2e-4d4a-b540-3b792171d1eb")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9648a5b7-d235-4a9e-933c-d4d4ae66a7ee")), IkeTerm.PREFERRED)
                ;

        set.concept("Role restriction (SOLOR)", PublicIds.of(UUID.fromString("988bb02a-9b4a-4ef9-937e-fa8a6afc6c42"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9c30a496-3fc7-41c4-994d-627d5573c4f3")), IkeTerm.ENGLISH_LANGUAGE, "Role restriction (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("254bb31e-14eb-4133-bf29-0d0136d4020f")), IkeTerm.ENGLISH_LANGUAGE, "Role value", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bd1981e4-c208-41f0-9086-ee708966a30c")), IkeTerm.ENGLISH_LANGUAGE, "Role restriction", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e1297b0a-d7ae-47b8-b02c-b0864c375e02")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "988bb02a-9b4a-4ef9-937e-fa8a6afc6c42")
                .statedAxioms(PublicIds.of(UUID.fromString("d770960d-83da-5c4b-8020-80f74bf073c9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9138f75c-772b-455f-a478-71f93185787b")))
                .semanticOn(PublicIds.of(UUID.fromString("9c30a496-3fc7-41c4-994d-627d5573c4f3")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0622bfe7-60a9-49e0-b94e-c28c7dc5668e")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("254bb31e-14eb-4133-bf29-0d0136d4020f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("404136fe-4e4a-41ff-a530-dc476e908716")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bd1981e4-c208-41f0-9086-ee708966a30c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a5cd7161-17b5-47be-8f7b-250f6b3bd04a")), IkeTerm.PREFERRED)
                ;

        set.concept("Sufficient set", PublicIds.of(UUID.fromString("8aa48cfd-485b-5140-beb9-0d122f7812d9"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9ac45e3c-bbdb-4376-a19a-2a8aa72897e9")), IkeTerm.ENGLISH_LANGUAGE, "Sufficient set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e7af572c-2371-4f17-a666-140d1cdd2d59")), IkeTerm.ENGLISH_LANGUAGE, "Sufficient set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3c74371f-27c9-44cd-9568-09a22f1246f9")), IkeTerm.ENGLISH_LANGUAGE, "A set of relationships that differentiate a concept and its subtypes from all other concepts. A concept that contains at least one set of necessary and sufficient conditions is considered defined.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8f67d2ab-04fc-4600-ab22-b0c2522a3ff2")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8aa48cfd-485b-5140-beb9-0d122f7812d9")
                .statedAxioms(PublicIds.of(UUID.fromString("be162423-8f34-57f0-8a23-abf799e6274d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS), leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("29234907-29cc-4de2-9902-9f8a6f219e9c")))
                .semanticOn(PublicIds.of(UUID.fromString("9ac45e3c-bbdb-4376-a19a-2a8aa72897e9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4df77c0d-8e19-4c65-a72d-233500b86a15")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e7af572c-2371-4f17-a666-140d1cdd2d59")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("15ed03c4-4913-4570-aef4-d0c3ff71e858")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3c74371f-27c9-44cd-9568-09a22f1246f9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("98303205-9171-406d-9c7b-d1275ebf4971")), IkeTerm.PREFERRED)
                ;

        set.concept("Necessary but not sufficient concept definition (SOLOR)", PublicIds.of(UUID.fromString("e1a12059-3b01-3296-9532-d10e49d0afc3"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("005206d3-b2f9-40b3-973e-39077436a01c")), IkeTerm.ENGLISH_LANGUAGE, "Necessary but not sufficient concept definition (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0303b760-9b7d-4d26-93b5-e78d3c7b636c")), IkeTerm.ENGLISH_LANGUAGE, "Necessary but not sufficient concept definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("25b1bf26-a26d-49a3-9292-31a1d01ad543")), IkeTerm.ENGLISH_LANGUAGE, "Not sufficiently defined by necessary conditions definition status", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("380430f4-c5db-4982-87a7-aed9118a0f4e")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "e1a12059-3b01-3296-9532-d10e49d0afc3")
                .statedAxioms(PublicIds.of(UUID.fromString("c042aafb-bcfc-51eb-bc91-d535208375cf")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS), leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b221128c-7618-4c4e-bc38-97c52fe05972")))
                .semanticOn(PublicIds.of(UUID.fromString("005206d3-b2f9-40b3-973e-39077436a01c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("321d776a-594c-461e-870a-b5246b242fc1")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("0303b760-9b7d-4d26-93b5-e78d3c7b636c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b6b3ecba-41f8-4f20-8132-2af8420cc2e9")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("25b1bf26-a26d-49a3-9292-31a1d01ad543")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b9f2671e-3b22-48ad-b310-a2293cfe21c8")), IkeTerm.PREFERRED)
                ;

        set.concept("EL++ Stated terminological axioms", PublicIds.of(UUID.fromString("1412bd09-eb0c-5107-9756-10c1c417d385"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d6fd661d-2e5d-4816-b973-382f4aba81de")), IkeTerm.ENGLISH_LANGUAGE, "EL++ Stated terminological axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e180c86b-64b1-46a1-b3da-6e59b9bc3533")), IkeTerm.ENGLISH_LANGUAGE, "EL++ Stated terminological axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("03f08d3b-f7e9-4feb-87f0-f9e5620ed277")), IkeTerm.ENGLISH_LANGUAGE, "The stated side of a concept's EL++ terminological axioms: the definitional axioms an author actually wrote — necessary and sufficient sets, role restrictions — as distinct from what a classifier later infers. The EL++ Stated Axioms Pattern's one field carries them as a directed tree.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("7c8d0f75-7f21-43d8-a612-8df903e5e6b6")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1412bd09-eb0c-5107-9756-10c1c417d385")
                .statedAxioms(PublicIds.of(UUID.fromString("f009cf0f-2f60-5cd6-b291-07f8137a2362")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.EL_PLUS_PLUS_TERMINOLOGICAL_AXIOMS))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("111fc35a-ea12-4f7c-b804-0ba80a84cc64")))
                .semanticOn(PublicIds.of(UUID.fromString("d6fd661d-2e5d-4816-b973-382f4aba81de")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("070a47ce-b990-4b66-83d7-0317fee101be")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e180c86b-64b1-46a1-b3da-6e59b9bc3533")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("453acf84-1bc6-4642-9acc-0a9a66555caf")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("03f08d3b-f7e9-4feb-87f0-f9e5620ed277")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("176494d5-0c27-43b3-ba30-25d9647ae7c4")), IkeTerm.PREFERRED)
                ;

    }
}
