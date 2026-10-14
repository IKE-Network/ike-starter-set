package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Author" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section6 {

    private Section6() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Author", PublicIds.of(UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("96657b21-6469-4a6c-b052-023b4e1dc085")), KernelTerm.ENGLISH_LANGUAGE, "Author", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c8246260-2401-4442-95fc-c5dd6ee5b037")), KernelTerm.ENGLISH_LANGUAGE, "Author", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a2892585-1d62-4ea6-9cd5-f93cbf4a37a9")), KernelTerm.ENGLISH_LANGUAGE, "The concept identifying who committed a version — the author dimension of a STAMP, and the root of the value space an author field's concept is drawn from; distinct from Author for version, which names why the field is recorded.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("fc531f90-2ca7-4460-b38d-a037feffb526")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "f7495b58-6630-3499-a44e-2052b5fcf06c")
                .statedAxioms(PublicIds.of(UUID.fromString("d6aedbb3-ae0b-59e7-958d-e788b91f3a1a")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Model concept (SOLOR)", PublicIds.of("7bbd4210-381c-11e7-9598-0800200c9a66"))), leb.SomeRole(EntityProxy.Concept.make("Part of (SOLOR)", PublicIds.of("b4c3f6f9-6937-30fd-8412-d0c77f8a7f73")), leb.ConceptAxiom(set.conceptRef("STAMP (IkeFoundation)"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7c40bd16-aad2-4187-b4a8-4362d34da30f")))
                .semanticOn(PublicIds.of(UUID.fromString("96657b21-6469-4a6c-b052-023b4e1dc085")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a3aa1616-bd7a-424e-8671-3f63d3dd315d")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c8246260-2401-4442-95fc-c5dd6ee5b037")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48ce398d-efb1-4a68-b962-8eb42d7e2744")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a2892585-1d62-4ea6-9cd5-f93cbf4a37a9")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3c98f3f7-dba8-468a-8d3f-7d3b9a21175e")), KernelTerm.PREFERRED)
                ;

        set.concept("Gretel (User)", PublicIds.of(UUID.fromString("1c0023ed-559e-3311-9e55-bd4bd9e5628f"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1f281cb9-06fe-49ba-bcc2-ad53387812c5")), KernelTerm.ENGLISH_LANGUAGE, "Gretel (User)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("485c77b6-2777-4ff9-b567-458ccc8a1323")), KernelTerm.ENGLISH_LANGUAGE, "Gretel", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c50f3345-e1d9-4103-bf2e-55739f777f3b")), KernelTerm.ENGLISH_LANGUAGE, "Default Author for Komet", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("b5868bac-1709-4a29-9f5e-1770d84bb66e")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "1c0023ed-559e-3311-9e55-bd4bd9e5628f")
                .statedAxioms(PublicIds.of(UUID.fromString("40cb3877-1b48-5f52-9c57-9e46239e0cc4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelTerm.USER))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a5bc8c8a-dd98-4bc4-990f-97b8ad9c96d7")))
                .semanticOn(PublicIds.of(UUID.fromString("1f281cb9-06fe-49ba-bcc2-ad53387812c5")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c73e0ff7-4a4d-4240-8893-fdca22a4ed59")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("485c77b6-2777-4ff9-b567-458ccc8a1323")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6567247e-b130-40be-a2bd-433e2b37d733")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c50f3345-e1d9-4103-bf2e-55739f777f3b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d03202e7-b3da-4f7a-b350-79256c3114fb")), KernelTerm.PREFERRED)
                ;

        set.concept("Starter Data Authoring (SOLOR)", PublicIds.of(UUID.fromString("070deb74-acc5-46bf-b9c6-eaee1b58ef52"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("66c6793d-4eae-4383-a60e-d56c5a9a3788")), KernelTerm.ENGLISH_LANGUAGE, "Starter Data Authoring (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b5580a1a-6942-458e-9e9c-8b8e5d021b0c")), KernelTerm.ENGLISH_LANGUAGE, "Metadata Authoring", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3ffd23e7-62ca-4b60-baea-8bf57b8319e7")), KernelTerm.ENGLISH_LANGUAGE, "The baseline's starter-data authoring activity — an activity, not a user (this ledger's own stamps use IKE Community). Still referenced as the meaning of the IKE and Komet base-model membership patterns, so it stays live and resolvable; filed under Legacy pending a purpose-built meaning concept for those patterns.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0731569a-ed24-47d1-8f4c-053a875e04b3")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "070deb74-acc5-46bf-b9c6-eaee1b58ef52")
                .statedAxioms(PublicIds.of(UUID.fromString("4f899d97-b46b-5d9e-afe3-52b0e098c676")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Legacy (IkeFoundation)")))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c69d5dcf-f6a1-49a7-af1a-21968979d353")))
                .semanticOn(PublicIds.of(UUID.fromString("66c6793d-4eae-4383-a60e-d56c5a9a3788")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2c08299a-0966-42d1-84ad-8f1d2f090a22")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b5580a1a-6942-458e-9e9c-8b8e5d021b0c")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c21a63e2-3170-4b4b-9ccc-f5400674b212")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3ffd23e7-62ca-4b60-baea-8bf57b8319e7")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("781ab202-4b65-4ff6-a478-fa2dc4f52254")), KernelTerm.PREFERRED)
                ;

        set.concept("KOMET user (SOLOR)", PublicIds.of(UUID.fromString("61c1a544-2acf-58cd-8cc0-9ac581d4227e"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fe6b4a60-3548-44ee-a703-072fe9922fb1")), KernelTerm.ENGLISH_LANGUAGE, "KOMET user (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("22494eaa-13de-40b8-a11d-fb85ec3d4b20")), KernelTerm.ENGLISH_LANGUAGE, "KOMET user", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6ff489ff-2cea-41e9-92bb-37b4e0d4c4db")), KernelTerm.ENGLISH_LANGUAGE, "Authorized to author, edit and/or view in Komet", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4a27d6cc-3488-4ed8-9ba1-d77857ca1a21")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "61c1a544-2acf-58cd-8cc0-9ac581d4227e")
                .statedAxioms(PublicIds.of(UUID.fromString("e5da5a39-5080-5fe7-9ea2-65e4198b3d7d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelTerm.USER))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("027b4080-a29e-4706-a086-4ccb89f2d78a")))
                .semanticOn(PublicIds.of(UUID.fromString("fe6b4a60-3548-44ee-a703-072fe9922fb1")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5d67a069-eecd-4434-8da3-e146d0b29ff6")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("22494eaa-13de-40b8-a11d-fb85ec3d4b20")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("39974f67-19cb-42ec-a1c6-df22ef28f3f7")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6ff489ff-2cea-41e9-92bb-37b4e0d4c4db")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0a87d5a9-9e2a-4ac2-a2f9-2132f6d977e8")), KernelTerm.PREFERRED)
                ;

        // Declared FQN diverges from the baseline artifact (was "Tinkar Starter Data Author
        // (User)"): the user recorded on the baseline's own versions, described by what it
        // is rather than by the upstream name; registered in DELIBERATELY_RENAMED_FQNS
        // (IKE-Network/ike-issues#1124).
        set.concept("Baseline starter data author (User)", PublicIds.of(UUID.fromString("dd96b2ea-6d7b-3791-ad74-bbdc67c493c1"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6280c1e5-e3ee-4ae3-a88e-5a02dfa0dbb0")), KernelTerm.ENGLISH_LANGUAGE, "Baseline starter data author (User)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("432e4ea2-342b-4917-95bb-3e1b791723c0")), KernelTerm.ENGLISH_LANGUAGE, "Baseline starter data author", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6c1f2d80-e384-4af3-a3a6-d763546d978a")), KernelTerm.ENGLISH_LANGUAGE, "The user recorded as author on the baseline's own versions: the starter data this set was retrofitted from, an authoring activity rather than a person. This ledger's versions are authored by IKE Community.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("484caf62-f88c-4908-b85d-c32f0d96dbce")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "dd96b2ea-6d7b-3791-ad74-bbdc67c493c1")
                .statedAxioms(PublicIds.of(UUID.fromString("4749ae4c-8587-5dfd-bc1a-f1c5951b14e0")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(KernelTerm.USER))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6822a4d9-7bcd-462c-b75d-6322b682b629")))
                .semanticOn(PublicIds.of(UUID.fromString("6280c1e5-e3ee-4ae3-a88e-5a02dfa0dbb0")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e5d1fd31-0406-4e00-994c-f028ca5fc62b")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("432e4ea2-342b-4917-95bb-3e1b791723c0")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7344b74a-6ab0-4350-b489-87f4c1320cfa")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6c1f2d80-e384-4af3-a3a6-d763546d978a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("03548c1c-98a6-4860-a5c2-e17a164ee76a")), KernelTerm.PREFERRED)
                ;

    }
}
