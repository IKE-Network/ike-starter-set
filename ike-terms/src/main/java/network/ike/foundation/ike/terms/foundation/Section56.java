package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Module" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section56 {

    private Section56() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        set.concept("Module", PublicIds.of(UUID.fromString("40d1c869-b509-32f8-b735-836eac577a67"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9bfa067d-05c5-42a1-a701-a22bc62c8748")), IkeTerm.ENGLISH_LANGUAGE, "Module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a875ca51-1fb1-4ba8-8196-4f5181865583")), IkeTerm.ENGLISH_LANGUAGE, "Module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("10933c80-b2cc-4569-8d23-b4d512e6459e")), IkeTerm.ENGLISH_LANGUAGE, "Module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ff7b7589-ae0e-4736-802d-b4d89b9ad008")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "40d1c869-b509-32f8-b735-836eac577a67")
                .statedAxioms(PublicIds.of(UUID.fromString("08ddbdb2-4c9b-51df-ac3f-b7f6031e57a8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROOT_VERTEX))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("05d9ccd8-cc6a-45e0-82cd-aa42f56751cc")))
                .semanticOn(PublicIds.of(UUID.fromString("9bfa067d-05c5-42a1-a701-a22bc62c8748")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5154e5df-ed72-484c-8f24-c79f1a4fc834")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a875ca51-1fb1-4ba8-8196-4f5181865583")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9df90fb5-de00-41ec-9a69-0d9fce6d178a")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("10933c80-b2cc-4569-8d23-b4d512e6459e")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("23e5352b-5fec-481d-8c58-3294ed22a730")), IkeTerm.PREFERRED)
                ;

        set.concept("Users module (SOLOR)", PublicIds.of(UUID.fromString("349161ba-9a6a-5c9c-a78f-281f19cfc057"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("55e6776e-94e2-45f0-8d7f-4904d45b1518")), IkeTerm.ENGLISH_LANGUAGE, "Users module (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bbdef7f2-41b6-449b-9514-73c9baccfa51")), IkeTerm.ENGLISH_LANGUAGE, "User module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2bef9c94-2989-490e-bbc9-ea3dbe676b66")), IkeTerm.ENGLISH_LANGUAGE, "Module - user", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ab1bd811-0087-44ad-9cc5-aebca40f572d")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "349161ba-9a6a-5c9c-a78f-281f19cfc057")
                .statedAxioms(PublicIds.of(UUID.fromString("f1359474-2adb-544e-bd7c-626bf33e21d3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.MODULE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e3537710-4479-4bd7-916a-122445f711f6")))
                .semanticOn(PublicIds.of(UUID.fromString("55e6776e-94e2-45f0-8d7f-4904d45b1518")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("dd23b4e0-8e80-41ad-bb31-faeb21354e9d")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bbdef7f2-41b6-449b-9514-73c9baccfa51")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f794e3e4-24c4-4143-bf98-b65c54c25789")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2bef9c94-2989-490e-bbc9-ea3dbe676b66")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7ee9d820-9eba-4162-b963-19ce27399d84")), IkeTerm.PREFERRED)
                ;

        set.concept("Development module (SOLOR)", PublicIds.of(UUID.fromString("529a7069-bd33-59e6-b2ce-537fa874360a"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3182f5f6-47f3-48a3-862e-004e705cfa83")), IkeTerm.ENGLISH_LANGUAGE, "Development module (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9a0354cc-5a4a-4de2-ad24-9bdf26c2fbc1")), IkeTerm.ENGLISH_LANGUAGE, "Development module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("23a8242a-9e86-4e00-b798-07bdf83b4422")), IkeTerm.ENGLISH_LANGUAGE, "Predefines or standard module within a system or application that is specifically designed to support the development phase of a project", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e7e96c4e-35d2-411e-ac34-1d183392a5b8")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "529a7069-bd33-59e6-b2ce-537fa874360a")
                .statedAxioms(PublicIds.of(UUID.fromString("1c8e0c3c-bd9f-5030-9551-9936537927d4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.MODULE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7b895bac-29e7-40d2-987f-de488fe8f81d")))
                .semanticOn(PublicIds.of(UUID.fromString("3182f5f6-47f3-48a3-862e-004e705cfa83")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2004e9c4-1ede-4b3b-ac51-d9f88ccef8ed")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9a0354cc-5a4a-4de2-ad24-9bdf26c2fbc1")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d81095a4-d585-447d-b9bf-5bf4ffc453b9")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("23a8242a-9e86-4e00-b798-07bdf83b4422")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("af940a09-8049-47e1-bbaa-9c973a8b7625")), IkeTerm.PREFERRED)
                ;

        set.concept("KOMET module (SOLOR)", PublicIds.of(UUID.fromString("34a6dae3-e5e9-50db-a9ee-69c1067911d8"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5e2987dd-0caf-4db3-80b4-f653da53391f")), IkeTerm.ENGLISH_LANGUAGE, "KOMET module (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("820bd3ec-11d9-4b75-b073-de187a689874")), IkeTerm.ENGLISH_LANGUAGE, "KOMET module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b057870b-3510-4a28-940e-7d0e17b86f1f")), IkeTerm.ENGLISH_LANGUAGE, "Komet specific values?", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("a42295ad-f07f-476c-a6df-9404f4082a00")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "34a6dae3-e5e9-50db-a9ee-69c1067911d8")
                .statedAxioms(PublicIds.of(UUID.fromString("98b4e207-c632-53f4-a25d-f3a47aaf7bf6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.MODULE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f6b2ba10-f0c2-4d75-905f-ff7362746d27")))
                .semanticOn(PublicIds.of(UUID.fromString("5e2987dd-0caf-4db3-80b4-f653da53391f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("52c605ea-4415-4c68-96c4-e8440b8414f7")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("820bd3ec-11d9-4b75-b073-de187a689874")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f05a9a08-82c1-4647-b862-b6b9d5e82054")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b057870b-3510-4a28-940e-7d0e17b86f1f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fe8840fc-4419-43fa-b00f-5cfad30ace4f")), IkeTerm.PREFERRED)
                ;

        set.concept("Primordial module", PublicIds.of(UUID.fromString("c2012321-3903-532e-8a5f-b13e4ca46e86"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("43c3dd2c-cf9f-4332-b6e7-def8d64ed50a")), IkeTerm.ENGLISH_LANGUAGE, "Primordial module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("464700eb-9ebe-44ce-8b9c-c7615653abf5")), IkeTerm.ENGLISH_LANGUAGE, "Primordial module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5dbcabc3-7845-4848-85e7-cfbec95dc617")), IkeTerm.ENGLISH_LANGUAGE, "", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ee0307fc-8ab3-4eed-9ebd-c1c4534772fd")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c2012321-3903-532e-8a5f-b13e4ca46e86")
                .statedAxioms(PublicIds.of(UUID.fromString("4051b732-5032-55f9-8e0c-122a42a27ff8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.MODULE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8a0b3eff-2860-45b2-86c4-4c3fd2623e21")))
                .semanticOn(PublicIds.of(UUID.fromString("43c3dd2c-cf9f-4332-b6e7-def8d64ed50a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7ede2775-2bae-483b-a20a-e307f9fe123d")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("464700eb-9ebe-44ce-8b9c-c7615653abf5")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3ef2a184-c9e6-41f0-8d39-298619f9b8a8")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5dbcabc3-7845-4848-85e7-cfbec95dc617")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("baf22431-1eb3-45e0-b555-76d6aac7b449")), IkeTerm.PREFERRED)
                ;

    }
}
