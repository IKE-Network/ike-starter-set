package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Description acceptability" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section40 {

    private Section40() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description acceptability", PublicIds.of("96b61063-0d29-5aea-9652-3f5f328aadc3")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("80efdccd-27a4-464e-8b45-a12f2cdcb596"), IkeTerm.ENGLISH_LANGUAGE, "Description acceptability", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("55dc1c93-0dc1-4c23-bda2-79ba419919aa"), IkeTerm.ENGLISH_LANGUAGE, "Description acceptability", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5106ab62-8cc5-485d-9a86-5ea2205423ef"), IkeTerm.ENGLISH_LANGUAGE, "Whether a given human readable text for a concept is permissible", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("2f394465-f048-4922-b06c-20db15af9711"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "96b61063-0d29-5aea-9652-3f5f328aadc3")
                .statedAxioms(PublicIds.of("575aa454-9a66-5676-96a4-3af39800d0f9"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT), leb.ConceptAxiom(IkeTerm.MEANING), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("29fd1ad4-f526-4c82-bb74-9da756c2db0e"))
                .semanticOn(PublicIds.of("80efdccd-27a4-464e-8b45-a12f2cdcb596"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("901a9194-a5c5-49bf-94af-c273e002930c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("55dc1c93-0dc1-4c23-bda2-79ba419919aa"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("31dbeb20-b045-4aa2-bbcb-8213bdc00e58"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("5106ab62-8cc5-485d-9a86-5ea2205423ef"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("138731ee-b6ac-4d53-b17e-9148a41f409e"), IkeTerm.PREFERRED)
                ;

        set.concept("Preferred (SOLOR)", PublicIds.of("266f1bc3-3361-39f3-bffe-69db9daea56e")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("dff6e3d1-e02c-4b44-8819-f90b8140fd7f"), IkeTerm.ENGLISH_LANGUAGE, "Preferred (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a591be55-fc99-4feb-9d6c-7fc26c692dc6"), IkeTerm.ENGLISH_LANGUAGE, "Preferred", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("135bd64e-6118-4fde-9207-9c0b65a27619"), IkeTerm.ENGLISH_LANGUAGE, "The acceptability value marking a description as the one to show first in a dialect: at most one preferred description per description type per dialect.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("e0725ca0-f2a6-41a5-b09d-6ed5d524e03e"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "266f1bc3-3361-39f3-bffe-69db9daea56e")
                .statedAxioms(PublicIds.of("192a1b8b-39c7-517d-8159-406d4533e9c0"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_ACCEPTABILITY))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("9ca806ad-9142-4d28-ac33-9166e7a35df2"))
                .semanticOn(PublicIds.of("dff6e3d1-e02c-4b44-8819-f90b8140fd7f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("733c3619-0225-467f-bd52-6ceed3194c9b"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a591be55-fc99-4feb-9d6c-7fc26c692dc6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("99766f93-bb47-4782-84ea-c8672d47efb3"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("135bd64e-6118-4fde-9207-9c0b65a27619"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("abf76c49-8530-4ceb-8566-506bba91218f"), IkeTerm.PREFERRED)
                ;

        set.concept("Acceptable (foundation metadata concept)", PublicIds.of("12b9e103-060e-3256-9982-18c1191af60e")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a1df9cd0-5dd9-4646-9a2b-437d7867ba72"), IkeTerm.ENGLISH_LANGUAGE, "Acceptable (foundation metadata concept)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fa68ea30-e41a-46ad-94d7-a2152f4e1a29"), IkeTerm.ENGLISH_LANGUAGE, "Acceptable", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0aa2bbb9-e172-4694-8d1e-228003977c5c"), IkeTerm.ENGLISH_LANGUAGE, "Specifies that a description is acceptable, but not preferred within a language or dialect.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("f1d1e043-9fe5-4aeb-8e86-9a2b668ed559"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "12b9e103-060e-3256-9982-18c1191af60e")
                .statedAxioms(PublicIds.of("504c0a7f-f30d-56ae-99be-422aa624ed72"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_ACCEPTABILITY))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("f11448d5-87a2-4e60-84b6-66e542592e56"))
                .semanticOn(PublicIds.of("a1df9cd0-5dd9-4646-9a2b-437d7867ba72"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c77d8065-eccc-4cae-888b-afdaa68da1d0"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("fa68ea30-e41a-46ad-94d7-a2152f4e1a29"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ff2e9ff5-29b5-4f6b-adc1-6e5be4b1194d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0aa2bbb9-e172-4694-8d1e-228003977c5c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("72289516-cf78-4db6-87f4-b214d21cc1f1"), IkeTerm.PREFERRED)
                ;

    }
}
