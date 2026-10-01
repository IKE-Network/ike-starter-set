package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.InactiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Author" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section6 {

    private Section6() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;
        InactiveStamp retirement = network.ike.foundation.ike.terms.Ike.RETIREMENT;

        set.concept("Author", PublicIds.of(UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("96657b21-6469-4a6c-b052-023b4e1dc085")), IkeTerm.ENGLISH_LANGUAGE, "Author", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c8246260-2401-4442-95fc-c5dd6ee5b037")), IkeTerm.ENGLISH_LANGUAGE, "Author", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a2892585-1d62-4ea6-9cd5-f93cbf4a37a9")), IkeTerm.ENGLISH_LANGUAGE, "The concept identifying who committed a version — the author dimension of a STAMP, and the root of the value space an author field's concept is drawn from; distinct from Author for version, which names why the field is recorded.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("fc531f90-2ca7-4460-b38d-a037feffb526")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f7495b58-6630-3499-a44e-2052b5fcf06c")
                .statedAxioms(PublicIds.of(UUID.fromString("d6aedbb3-ae0b-59e7-958d-e788b91f3a1a")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.MODEL_CONCEPT), leb.SomeRole(IkeTerm.PART_OF, leb.ConceptAxiom(set.conceptRef("STAMP (IkeFoundation)"))))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7c40bd16-aad2-4187-b4a8-4362d34da30f")))
                .semanticOn(PublicIds.of(UUID.fromString("96657b21-6469-4a6c-b052-023b4e1dc085")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a3aa1616-bd7a-424e-8671-3f63d3dd315d")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c8246260-2401-4442-95fc-c5dd6ee5b037")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48ce398d-efb1-4a68-b962-8eb42d7e2744")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a2892585-1d62-4ea6-9cd5-f93cbf4a37a9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3c98f3f7-dba8-468a-8d3f-7d3b9a21175e")), IkeTerm.PREFERRED)
                ;

        set.concept("Gretel (User)", PublicIds.of(UUID.fromString("1c0023ed-559e-3311-9e55-bd4bd9e5628f"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1f281cb9-06fe-49ba-bcc2-ad53387812c5")), IkeTerm.ENGLISH_LANGUAGE, "Gretel (User)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("485c77b6-2777-4ff9-b567-458ccc8a1323")), IkeTerm.ENGLISH_LANGUAGE, "Gretel", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c50f3345-e1d9-4103-bf2e-55739f777f3b")), IkeTerm.ENGLISH_LANGUAGE, "Default Author for Komet", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("b5868bac-1709-4a29-9f5e-1770d84bb66e")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1c0023ed-559e-3311-9e55-bd4bd9e5628f")
                .statedAxioms(PublicIds.of(UUID.fromString("40cb3877-1b48-5f52-9c57-9e46239e0cc4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a5bc8c8a-dd98-4bc4-990f-97b8ad9c96d7")))
                .semanticOn(PublicIds.of(UUID.fromString("1f281cb9-06fe-49ba-bcc2-ad53387812c5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c73e0ff7-4a4d-4240-8893-fdca22a4ed59")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("485c77b6-2777-4ff9-b567-458ccc8a1323")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6567247e-b130-40be-a2bd-433e2b37d733")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c50f3345-e1d9-4103-bf2e-55739f777f3b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d03202e7-b3da-4f7a-b350-79256c3114fb")), IkeTerm.PREFERRED)
                ;

        // Retired in place (IKE-Network/ike-issues#1124): application preference and
        // user-interface machinery the baseline filed as kinds of Author, none of it a
        // kind of user and none of it cited as a field value. Each is opened at the
        // retirement stamp without a birth scope (IKE-Network/ike-issues#1130): one
        // inactive version on the concept, one on its stated definition (the baseline's
        // own, restated), one on its base-model membership. Descriptions and identifier
        // stay with the baseline, so the names hold; registered in DELIBERATELY_RETIRED.
        set.concept("Path for user (SOLOR)", PublicIds.of(UUID.fromString("12131382-1535-5a77-928b-6eacad221ea2"))).at(retirement)
                .retire()
                .retireStatedAxioms(PublicIds.of(UUID.fromString("82e846f7-76a5-526c-96b5-20e64f1719ae")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .retireSemantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("495f752c-6c8c-4f0e-8676-0670073d42aa")))
                ;

        // Retired in place (IKE-Network/ike-issues#1124), as Path for user above.
        set.concept("Order for concept attachments  (SOLOR)", PublicIds.of(UUID.fromString("6167efcb-50e8-534d-9827-fdd60b02ae00"))).at(retirement)
                .retire()
                .retireStatedAxioms(PublicIds.of(UUID.fromString("446cb1de-7ac9-5fb1-aebe-f54e4f453037")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .retireSemantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0889f798-bfe9-49fc-b282-986562c01237")))
                ;

        // Retired in place (IKE-Network/ike-issues#1124), as Path for user above.
        set.concept("Order for description attachments (SOLOR)", PublicIds.of(UUID.fromString("69ee3f13-e2ba-5a96-9b91-5eecfad8e587"))).at(retirement)
                .retire()
                .retireStatedAxioms(PublicIds.of(UUID.fromString("c0ecad74-1af6-534b-bd48-64100abc830c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .retireSemantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6b27f9b3-ffe6-43d2-9b96-5e1a4a25ce50")))
                ;

        set.concept("Starter Data Authoring (SOLOR)", PublicIds.of(UUID.fromString("070deb74-acc5-46bf-b9c6-eaee1b58ef52"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("66c6793d-4eae-4383-a60e-d56c5a9a3788")), IkeTerm.ENGLISH_LANGUAGE, "Starter Data Authoring (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b5580a1a-6942-458e-9e9c-8b8e5d021b0c")), IkeTerm.ENGLISH_LANGUAGE, "Metadata Authoring", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3ffd23e7-62ca-4b60-baea-8bf57b8319e7")), IkeTerm.ENGLISH_LANGUAGE, "The baseline's starter-data authoring activity — an activity, not a user (this ledger's own stamps use IKE Community). Still referenced as the meaning of the IKE and Komet base-model membership patterns, so it stays live and resolvable; filed under Legacy pending a purpose-built meaning concept for those patterns.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0731569a-ed24-47d1-8f4c-053a875e04b3")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "070deb74-acc5-46bf-b9c6-eaee1b58ef52")
                .statedAxioms(PublicIds.of(UUID.fromString("4f899d97-b46b-5d9e-afe3-52b0e098c676")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Legacy (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c69d5dcf-f6a1-49a7-af1a-21968979d353")))
                .semanticOn(PublicIds.of(UUID.fromString("66c6793d-4eae-4383-a60e-d56c5a9a3788")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2c08299a-0966-42d1-84ad-8f1d2f090a22")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b5580a1a-6942-458e-9e9c-8b8e5d021b0c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c21a63e2-3170-4b4b-9ccc-f5400674b212")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3ffd23e7-62ca-4b60-baea-8bf57b8319e7")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("781ab202-4b65-4ff6-a478-fa2dc4f52254")), IkeTerm.PREFERRED)
                ;

        set.concept("KOMET user (SOLOR)", PublicIds.of(UUID.fromString("61c1a544-2acf-58cd-8cc0-9ac581d4227e"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fe6b4a60-3548-44ee-a703-072fe9922fb1")), IkeTerm.ENGLISH_LANGUAGE, "KOMET user (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("22494eaa-13de-40b8-a11d-fb85ec3d4b20")), IkeTerm.ENGLISH_LANGUAGE, "KOMET user", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6ff489ff-2cea-41e9-92bb-37b4e0d4c4db")), IkeTerm.ENGLISH_LANGUAGE, "Authorized to author, edit and/or view in Komet", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4a27d6cc-3488-4ed8-9ba1-d77857ca1a21")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "61c1a544-2acf-58cd-8cc0-9ac581d4227e")
                .statedAxioms(PublicIds.of(UUID.fromString("e5da5a39-5080-5fe7-9ea2-65e4198b3d7d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("027b4080-a29e-4706-a086-4ccb89f2d78a")))
                .semanticOn(PublicIds.of(UUID.fromString("fe6b4a60-3548-44ee-a703-072fe9922fb1")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5d67a069-eecd-4434-8da3-e146d0b29ff6")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("22494eaa-13de-40b8-a11d-fb85ec3d4b20")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("39974f67-19cb-42ec-a1c6-df22ef28f3f7")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6ff489ff-2cea-41e9-92bb-37b4e0d4c4db")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0a87d5a9-9e2a-4ac2-a2f9-2132f6d977e8")), IkeTerm.PREFERRED)
                ;

        // Retired in place (IKE-Network/ike-issues#1124), as Path for user above.
        set.concept("Module for user (SOLOR)", PublicIds.of(UUID.fromString("c8fd4f1b-d842-5245-9a7d-a58dc0ac1c11"))).at(retirement)
                .retire()
                .retireStatedAxioms(PublicIds.of(UUID.fromString("afcddf70-7b86-5f14-9f9c-6f2826b40691")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .retireSemantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a41a37f2-92fc-4aae-b11b-bd73cee9c788")))
                ;

        // Declared FQN diverges from the baseline artifact (was "Tinkar Starter Data Author
        // (User)"): the user recorded on the baseline's own versions, described by what it
        // is rather than by the upstream name; registered in DELIBERATELY_RENAMED_FQNS
        // (IKE-Network/ike-issues#1124).
        set.concept("Baseline starter data author (User)", PublicIds.of(UUID.fromString("dd96b2ea-6d7b-3791-ad74-bbdc67c493c1"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6280c1e5-e3ee-4ae3-a88e-5a02dfa0dbb0")), IkeTerm.ENGLISH_LANGUAGE, "Baseline starter data author (User)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("432e4ea2-342b-4917-95bb-3e1b791723c0")), IkeTerm.ENGLISH_LANGUAGE, "Baseline starter data author", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6c1f2d80-e384-4af3-a3a6-d763546d978a")), IkeTerm.ENGLISH_LANGUAGE, "The user recorded as author on the baseline's own versions: the starter data this set was retrofitted from, an authoring activity rather than a person. This ledger's versions are authored by IKE Community.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("484caf62-f88c-4908-b85d-c32f0d96dbce")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "dd96b2ea-6d7b-3791-ad74-bbdc67c493c1")
                .statedAxioms(PublicIds.of(UUID.fromString("4749ae4c-8587-5dfd-bc1a-f1c5951b14e0")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6822a4d9-7bcd-462c-b75d-6322b682b629")))
                .semanticOn(PublicIds.of(UUID.fromString("6280c1e5-e3ee-4ae3-a88e-5a02dfa0dbb0")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e5d1fd31-0406-4e00-994c-f028ca5fc62b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("432e4ea2-342b-4917-95bb-3e1b791723c0")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7344b74a-6ab0-4350-b489-87f4c1320cfa")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6c1f2d80-e384-4af3-a3a6-d763546d978a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("03548c1c-98a6-4860-a5c2-e17a164ee76a")), IkeTerm.PREFERRED)
                ;

        // Retired in place (IKE-Network/ike-issues#1124), as Path for user above.
        set.concept("Order for axiom attachments (SOLOR)", PublicIds.of(UUID.fromString("abcb0946-20e1-5483-8469-3e8fa0ce20c4"))).at(retirement)
                .retire()
                .retireStatedAxioms(PublicIds.of(UUID.fromString("8dbb8e28-d4c1-5d7f-a003-d99a395d29ed")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .retireSemantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f6e730fe-ed8d-4538-9379-5b87dfea4ae9")))
                ;

        // Retired in place (IKE-Network/ike-issues#1124), as Path for user above.
        set.concept("KOMET user list (SOLOR)", PublicIds.of(UUID.fromString("5e77558d-97d0-52b6-adf0-d54beb97b3a6"))).at(retirement)
                .retire()
                .retireStatedAxioms(PublicIds.of(UUID.fromString("0979c33c-4a97-5e72-8efd-a42a098ce2d4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .retireSemantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9908a246-597a-457c-96f0-21fcc9d29bfb")))
                ;

    }
}
