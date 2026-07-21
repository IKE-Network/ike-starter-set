package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Purpose" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section64 {

    private Section64() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Purpose", PublicIds.of("c3dffc48-6493-54df-a2f0-14be8ba03091")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f0b05661-0bff-4bf2-9568-5ae5e3dc94f5"), IkeTerm.ENGLISH_LANGUAGE, "Purpose", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9e815a92-6438-405f-a00e-2692bbf869c0"), IkeTerm.ENGLISH_LANGUAGE, "Purpose", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0ecc5a56-ef03-4210-8dd2-bad08d94bad1"), IkeTerm.ENGLISH_LANGUAGE, "The reason for which a Tinkar value in a pattern was created or for which it exist.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("273fc3d5-bd50-4bc3-88c2-a87ebbd35a97"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c3dffc48-6493-54df-a2f0-14be8ba03091")
                .statedAxioms(PublicIds.of("d67636a4-1d54-54eb-9840-74367968de97"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("2327114e-720a-4648-9583-650477767e4f"))
                .semanticOn(PublicIds.of("f0b05661-0bff-4bf2-9568-5ae5e3dc94f5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b5f7329e-f91a-4d8c-ad21-c9a761cf5184"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9e815a92-6438-405f-a00e-2692bbf869c0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c0d1627a-3536-468a-a095-ac09fc17f255"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0ecc5a56-ef03-4210-8dd2-bad08d94bad1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c3bb4727-e18d-4a54-bb75-b20d9c722b96"), IkeTerm.PREFERRED)
                ;

        set.concept("Navigation (SOLOR)", PublicIds.of("4d9707d8-adf0-5b15-89fc-039e4ff6fec8")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("74d77d37-0b36-431d-a1bc-b4e023a79c19"), IkeTerm.ENGLISH_LANGUAGE, "Navigation (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("db897443-7146-44bf-9b95-a8522eec7620"), IkeTerm.ENGLISH_LANGUAGE, "Navigation", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("32fca61e-c947-4674-984b-42de6acb35ba"), IkeTerm.ENGLISH_LANGUAGE, "Groups navigation: the precomputed parent and child adjacency structures a navigator renders, and the concepts that classify them.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("3a98ccf5-9a3c-4d04-a2e5-fd2189f2be65"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "4d9707d8-adf0-5b15-89fc-039e4ff6fec8")
                .statedAxioms(PublicIds.of("24151757-85c1-5f77-a343-dcf1a1223ebd"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("2d584c8c-6aa1-4d6b-9dfb-d440295586c2"))
                .semanticOn(PublicIds.of("74d77d37-0b36-431d-a1bc-b4e023a79c19"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("58a0cceb-74a5-4abc-a6f2-3fb780ccdc00"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("db897443-7146-44bf-9b95-a8522eec7620"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5f43a37d-678c-4379-a3bd-35dbb47783a6"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("32fca61e-c947-4674-984b-42de6acb35ba"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("401c8742-a5b1-4d79-9145-5d9cf5cce762"), IkeTerm.PREFERRED)
                ;

        set.concept("Navigation concept set (SOLOR)", PublicIds.of("fc965c5d-ad17-555e-bcb5-b78fd45c8c5f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8e051e4f-72b3-4889-8e33-201556752813"), IkeTerm.ENGLISH_LANGUAGE, "Navigation concept set (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("36ff964b-1503-4a99-a1d0-2f5acc9c6820"), IkeTerm.ENGLISH_LANGUAGE, "Navigation set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("99253983-b68f-4193-90f3-12d354e4e6cb"), IkeTerm.ENGLISH_LANGUAGE, "The navigation-coordinate dimension holding the concept set a navigator traverses, scoping navigation to a chosen part of the taxonomy.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("260629c1-3ce7-4149-b840-5314737cb7c4"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "fc965c5d-ad17-555e-bcb5-b78fd45c8c5f")
                .statedAxioms(PublicIds.of("561e4bac-7fed-52a5-8be4-a48435f60bc8"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.NAVIGATION))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("88634391-20f0-4a6a-8b07-b7dcc739569b"))
                .semanticOn(PublicIds.of("8e051e4f-72b3-4889-8e33-201556752813"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7276310e-982c-4656-9914-2ae254f09e1a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("36ff964b-1503-4a99-a1d0-2f5acc9c6820"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("9950a59e-0529-4802-b332-6c553c4595fc"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("99253983-b68f-4193-90f3-12d354e4e6cb"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e8bb53d5-2a7e-4063-a20c-0f3801f7daf6"), IkeTerm.PREFERRED)
                ;

        set.concept("Navigation vertex (SOLOR)", PublicIds.of("c7f01834-34ca-5f8b-8f80-193fbeb12eae")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("294959ce-e10d-4909-9250-94d80b9d646f"), IkeTerm.ENGLISH_LANGUAGE, "Navigation vertex (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6930ec4d-dc6a-4d67-8df1-fbc2ae3d42fa"), IkeTerm.ENGLISH_LANGUAGE, "Navigation vertex", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5f73add0-258c-457c-b95f-97ccf0a34e7d"), IkeTerm.ENGLISH_LANGUAGE, "A vertex as it appears in navigation: one node of the precomputed navigation graph, presenting the concept it stands for.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("909d36f0-2927-4ea0-b8fa-bb148ac86c0b"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c7f01834-34ca-5f8b-8f80-193fbeb12eae")
                .statedAxioms(PublicIds.of("c9153e98-2218-5a5a-aa86-6b961f3ba8c6"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Vertex (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("66352f99-addb-4059-aa99-bd72fd5fb02f"))
                .semanticOn(PublicIds.of("294959ce-e10d-4909-9250-94d80b9d646f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("8ba626d3-c8d2-42cd-8172-ce2bee6f2b0f"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6930ec4d-dc6a-4d67-8df1-fbc2ae3d42fa"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("82d15b6e-140c-4dc1-9e59-5ed15f21b846"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("5f73add0-258c-457c-b95f-97ccf0a34e7d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5a9fc28e-8ddf-419a-b86d-1b4d315bed15"), IkeTerm.PREFERRED)
                ;

        set.concept("Is-a inferred navigation (SOLOR)", PublicIds.of("b620768f-1479-5afa-a027-5a9ae6caf0d5")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("df7c458c-5066-4f4b-a33d-4f6bd11ecb2b"), IkeTerm.ENGLISH_LANGUAGE, "Is-a inferred navigation (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("014eed70-29c3-4c5c-95e3-a57b9af7ec2d"), IkeTerm.ENGLISH_LANGUAGE, "Is-a inferred navigation", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1b7bbc5c-0efa-4344-9444-25d2c019ffe6"), IkeTerm.ENGLISH_LANGUAGE, "Designates the parent child relationship following the application of the reasoner", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("02947123-a8ed-41a3-bb66-e38dbb1d16b3"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b620768f-1479-5afa-a027-5a9ae6caf0d5")
                .statedAxioms(PublicIds.of("c5b57cbf-fbd2-50f9-bce3-11783d689203"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Legacy model concepts (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("1728e365-6f31-46ae-a026-a0a74467bea5"))
                .semanticOn(PublicIds.of("df7c458c-5066-4f4b-a33d-4f6bd11ecb2b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b7a71ca0-0b1b-43dd-b98d-604ece34ef0e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("014eed70-29c3-4c5c-95e3-a57b9af7ec2d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("31529253-c884-4acf-8f35-28797d79c566"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("1b7bbc5c-0efa-4344-9444-25d2c019ffe6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("23cdbbd5-1e2c-473e-bbf1-78c35e71de97"), IkeTerm.PREFERRED)
                ;

        set.concept("Is-a stated navigation (SOLOR)", PublicIds.of("d555dde9-c97e-5480-819a-7472eda3dbfa")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("31b4e8f4-0c80-48a2-b7e2-955bd3709ea9"), IkeTerm.ENGLISH_LANGUAGE, "Is-a stated navigation (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("dfc7314d-c6cb-4e9a-ad26-dec0f12c47b8"), IkeTerm.ENGLISH_LANGUAGE, "Is-a stated navigation", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("10c77b6d-661a-44b5-909e-59af35f8c500"), IkeTerm.ENGLISH_LANGUAGE, "Designates the parent child relationship as authored", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("bd1740cb-9fee-4194-9576-9ce1e364a958"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "d555dde9-c97e-5480-819a-7472eda3dbfa")
                .statedAxioms(PublicIds.of("daf4090b-0161-5c11-a372-b7f593944849"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Legacy model concepts (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("69f34aaf-ef61-4f99-befd-fdb0bcb83815"))
                .semanticOn(PublicIds.of("31b4e8f4-0c80-48a2-b7e2-955bd3709ea9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("59ea9bf9-870a-4bb1-be1c-d85122a7410a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("dfc7314d-c6cb-4e9a-ad26-dec0f12c47b8"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bc1abdd3-4585-4baf-84cb-afd29105125a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("10c77b6d-661a-44b5-909e-59af35f8c500"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0d4f76b0-b83f-48ac-8ebd-d8e027f79821"), IkeTerm.PREFERRED)
                ;

    }
}
