package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Author" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section6 {

    private Section6() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Author", PublicIds.of("f7495b58-6630-3499-a44e-2052b5fcf06c")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("96657b21-6469-4a6c-b052-023b4e1dc085"), IkeTerm.ENGLISH_LANGUAGE, "Author", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c8246260-2401-4442-95fc-c5dd6ee5b037"), IkeTerm.ENGLISH_LANGUAGE, "Author", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a2892585-1d62-4ea6-9cd5-f93cbf4a37a9"), IkeTerm.ENGLISH_LANGUAGE, "The concept identifying who committed a version — the author dimension of a STAMP, and the root of the value space an author field's concept is drawn from; distinct from Author for version, which names why the field is recorded.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("fc531f90-2ca7-4460-b38d-a037feffb526"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f7495b58-6630-3499-a44e-2052b5fcf06c")
                .statedAxioms(PublicIds.of("d6aedbb3-ae0b-59e7-958d-e788b91f3a1a"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("STAMP dimensions (IkeFoundation)")), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("7c40bd16-aad2-4187-b4a8-4362d34da30f"))
                .semanticOn(PublicIds.of("96657b21-6469-4a6c-b052-023b4e1dc085"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a3aa1616-bd7a-424e-8671-3f63d3dd315d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c8246260-2401-4442-95fc-c5dd6ee5b037"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("48ce398d-efb1-4a68-b962-8eb42d7e2744"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a2892585-1d62-4ea6-9cd5-f93cbf4a37a9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3c98f3f7-dba8-468a-8d3f-7d3b9a21175e"), IkeTerm.PREFERRED)
                ;

        set.concept("Gretel (User)", PublicIds.of("1c0023ed-559e-3311-9e55-bd4bd9e5628f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1f281cb9-06fe-49ba-bcc2-ad53387812c5"), IkeTerm.ENGLISH_LANGUAGE, "Gretel (User)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("485c77b6-2777-4ff9-b567-458ccc8a1323"), IkeTerm.ENGLISH_LANGUAGE, "Gretel", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c50f3345-e1d9-4103-bf2e-55739f777f3b"), IkeTerm.ENGLISH_LANGUAGE, "Default Author for Komet", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("b5868bac-1709-4a29-9f5e-1770d84bb66e"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1c0023ed-559e-3311-9e55-bd4bd9e5628f")
                .statedAxioms(PublicIds.of("40cb3877-1b48-5f52-9c57-9e46239e0cc4"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("a5bc8c8a-dd98-4bc4-990f-97b8ad9c96d7"))
                .semanticOn(PublicIds.of("1f281cb9-06fe-49ba-bcc2-ad53387812c5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c73e0ff7-4a4d-4240-8893-fdca22a4ed59"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("485c77b6-2777-4ff9-b567-458ccc8a1323"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6567247e-b130-40be-a2bd-433e2b37d733"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c50f3345-e1d9-4103-bf2e-55739f777f3b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d03202e7-b3da-4f7a-b350-79256c3114fb"), IkeTerm.PREFERRED)
                ;

        set.concept("Path for user (SOLOR)", PublicIds.of("12131382-1535-5a77-928b-6eacad221ea2")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d9daf884-7d7d-4b0a-bb33-7c5d72e18870"), IkeTerm.ENGLISH_LANGUAGE, "Path for user (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2ac3a662-8b8e-462d-9840-687aa36b5d08"), IkeTerm.ENGLISH_LANGUAGE, "Path for user", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ee57f842-3187-42a2-a285-3fa092552d18"), IkeTerm.ENGLISH_LANGUAGE, "Path for user", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("c8a1b2ac-6442-4551-865a-2b831400c316"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "12131382-1535-5a77-928b-6eacad221ea2")
                .statedAxioms(PublicIds.of("82e846f7-76a5-526c-96b5-20e64f1719ae"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("495f752c-6c8c-4f0e-8676-0670073d42aa"))
                .semanticOn(PublicIds.of("d9daf884-7d7d-4b0a-bb33-7c5d72e18870"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3ab9446f-8e06-4609-9882-2a9dba7616cb"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2ac3a662-8b8e-462d-9840-687aa36b5d08"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a18aef2c-bc76-40c2-a10a-9442538a97b1"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ee57f842-3187-42a2-a285-3fa092552d18"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0772541e-98b9-4f27-bb6e-c7164f63ddbd"), IkeTerm.PREFERRED)
                ;

        set.concept("Order for concept attachments  (SOLOR)", PublicIds.of("6167efcb-50e8-534d-9827-fdd60b02ae00")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bb3b7269-4663-4700-bac8-8b311b16d76b"), IkeTerm.ENGLISH_LANGUAGE, "Order for concept attachments  (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9bf4af36-b0ff-48d6-9b1d-7194b17fd9e3"), IkeTerm.ENGLISH_LANGUAGE, "Concept attachment order", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e267db9d-ab3e-426d-9841-e7b09193da88"), IkeTerm.ENGLISH_LANGUAGE, "Order in which concepts are attached", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("accf5ab0-76f2-44d9-b609-7a9054f23c94"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6167efcb-50e8-534d-9827-fdd60b02ae00")
                .statedAxioms(PublicIds.of("446cb1de-7ac9-5fb1-aebe-f54e4f453037"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("0889f798-bfe9-49fc-b282-986562c01237"))
                .semanticOn(PublicIds.of("bb3b7269-4663-4700-bac8-8b311b16d76b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("81ecd817-a695-45e1-91c4-2d15d1cebd46"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9bf4af36-b0ff-48d6-9b1d-7194b17fd9e3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("dcbb2082-d981-4b08-a70e-4a94e5db5d59"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("e267db9d-ab3e-426d-9841-e7b09193da88"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d302fd51-b6f2-4397-907b-620c2a4c2d7a"), IkeTerm.PREFERRED)
                ;

        set.concept("Order for description attachments (SOLOR)", PublicIds.of("69ee3f13-e2ba-5a96-9b91-5eecfad8e587")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("af67ff36-a50b-4c5b-a6be-92573ce24e7c"), IkeTerm.ENGLISH_LANGUAGE, "Order for description attachments (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("37a4e42d-9218-4b4c-a83c-4fab77a53ad7"), IkeTerm.ENGLISH_LANGUAGE, "Description attachment order", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("981fa129-e4cd-4132-8a21-e2ba11f4b6e7"), IkeTerm.ENGLISH_LANGUAGE, "Order in which descriptions are attached", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("b94cb792-2b97-4c5f-a1d5-0a0c6acc5bf7"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "69ee3f13-e2ba-5a96-9b91-5eecfad8e587")
                .statedAxioms(PublicIds.of("c0ecad74-1af6-534b-bd48-64100abc830c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("6b27f9b3-ffe6-43d2-9b96-5e1a4a25ce50"))
                .semanticOn(PublicIds.of("af67ff36-a50b-4c5b-a6be-92573ce24e7c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d9683c76-c246-4658-adb5-70a1202a64e8"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("37a4e42d-9218-4b4c-a83c-4fab77a53ad7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5966eb19-e491-424b-baab-8d29d880761c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("981fa129-e4cd-4132-8a21-e2ba11f4b6e7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c8277c7f-a97c-4509-88f2-88aada0fc209"), IkeTerm.PREFERRED)
                ;

        set.concept("Starter Data Authoring (SOLOR)", PublicIds.of("070deb74-acc5-46bf-b9c6-eaee1b58ef52")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("66c6793d-4eae-4383-a60e-d56c5a9a3788"), IkeTerm.ENGLISH_LANGUAGE, "Starter Data Authoring (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b5580a1a-6942-458e-9e9c-8b8e5d021b0c"), IkeTerm.ENGLISH_LANGUAGE, "Metadata Authoring", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3ffd23e7-62ca-4b60-baea-8bf57b8319e7"), IkeTerm.ENGLISH_LANGUAGE, "Define necessary minimum viable concepts to use Tinkar Data", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("0731569a-ed24-47d1-8f4c-053a875e04b3"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "070deb74-acc5-46bf-b9c6-eaee1b58ef52")
                .statedAxioms(PublicIds.of("4f899d97-b46b-5d9e-afe3-52b0e098c676"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("c69d5dcf-f6a1-49a7-af1a-21968979d353"))
                .semanticOn(PublicIds.of("66c6793d-4eae-4383-a60e-d56c5a9a3788"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2c08299a-0966-42d1-84ad-8f1d2f090a22"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b5580a1a-6942-458e-9e9c-8b8e5d021b0c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c21a63e2-3170-4b4b-9ccc-f5400674b212"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("3ffd23e7-62ca-4b60-baea-8bf57b8319e7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("781ab202-4b65-4ff6-a478-fa2dc4f52254"), IkeTerm.PREFERRED)
                ;

        set.concept("KOMET user (SOLOR)", PublicIds.of("61c1a544-2acf-58cd-8cc0-9ac581d4227e")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fe6b4a60-3548-44ee-a703-072fe9922fb1"), IkeTerm.ENGLISH_LANGUAGE, "KOMET user (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("22494eaa-13de-40b8-a11d-fb85ec3d4b20"), IkeTerm.ENGLISH_LANGUAGE, "KOMET user", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6ff489ff-2cea-41e9-92bb-37b4e0d4c4db"), IkeTerm.ENGLISH_LANGUAGE, "Authorized to author, edit and/or view in Komet", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("4a27d6cc-3488-4ed8-9ba1-d77857ca1a21"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "61c1a544-2acf-58cd-8cc0-9ac581d4227e")
                .statedAxioms(PublicIds.of("e5da5a39-5080-5fe7-9ea2-65e4198b3d7d"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("027b4080-a29e-4706-a086-4ccb89f2d78a"))
                .semanticOn(PublicIds.of("fe6b4a60-3548-44ee-a703-072fe9922fb1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5d67a069-eecd-4434-8da3-e146d0b29ff6"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("22494eaa-13de-40b8-a11d-fb85ec3d4b20"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("39974f67-19cb-42ec-a1c6-df22ef28f3f7"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6ff489ff-2cea-41e9-92bb-37b4e0d4c4db"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0a87d5a9-9e2a-4ac2-a2f9-2132f6d977e8"), IkeTerm.PREFERRED)
                ;

        set.concept("Module for user (SOLOR)", PublicIds.of("c8fd4f1b-d842-5245-9a7d-a58dc0ac1c11")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e1e48ab5-5f96-4373-b4d0-c585e689bfba"), IkeTerm.ENGLISH_LANGUAGE, "Module for user (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ad0c760b-7d8d-4bd0-99f0-fb3e1180590d"), IkeTerm.ENGLISH_LANGUAGE, "Module for user", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("cc33a3cb-3781-4745-8a88-e65fa6b47ed3"), IkeTerm.ENGLISH_LANGUAGE, "User preference for Module?", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("c0b34934-aa26-48bb-affb-2046614f25be"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c8fd4f1b-d842-5245-9a7d-a58dc0ac1c11")
                .statedAxioms(PublicIds.of("afcddf70-7b86-5f14-9f9c-6f2826b40691"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("a41a37f2-92fc-4aae-b11b-bd73cee9c788"))
                .semanticOn(PublicIds.of("e1e48ab5-5f96-4373-b4d0-c585e689bfba"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ed7e5825-471f-43a5-9c0b-626c4ebca1a0"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ad0c760b-7d8d-4bd0-99f0-fb3e1180590d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e643fbab-fecb-41ab-a26a-692bdfb82730"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("cc33a3cb-3781-4745-8a88-e65fa6b47ed3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("06c60a94-1750-43d1-816d-7fe9e927f58b"), IkeTerm.PREFERRED)
                ;

        set.concept("Tinkar Starter Data Author (User)", PublicIds.of("dd96b2ea-6d7b-3791-ad74-bbdc67c493c1")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6280c1e5-e3ee-4ae3-a88e-5a02dfa0dbb0"), IkeTerm.ENGLISH_LANGUAGE, "Tinkar Starter Data Author (User)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("432e4ea2-342b-4917-95bb-3e1b791723c0"), IkeTerm.ENGLISH_LANGUAGE, "Tinkar Starter Data Author", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6c1f2d80-e384-4af3-a3a6-d763546d978a"), IkeTerm.ENGLISH_LANGUAGE, "Tinkar Starter Data Author", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("484caf62-f88c-4908-b85d-c32f0d96dbce"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "dd96b2ea-6d7b-3791-ad74-bbdc67c493c1")
                .statedAxioms(PublicIds.of("4749ae4c-8587-5dfd-bc1a-f1c5951b14e0"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("6822a4d9-7bcd-462c-b75d-6322b682b629"))
                .semanticOn(PublicIds.of("6280c1e5-e3ee-4ae3-a88e-5a02dfa0dbb0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e5d1fd31-0406-4e00-994c-f028ca5fc62b"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("432e4ea2-342b-4917-95bb-3e1b791723c0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7344b74a-6ab0-4350-b489-87f4c1320cfa"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6c1f2d80-e384-4af3-a3a6-d763546d978a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("03548c1c-98a6-4860-a5c2-e17a164ee76a"), IkeTerm.PREFERRED)
                ;

        set.concept("Order for axiom attachments (SOLOR)", PublicIds.of("abcb0946-20e1-5483-8469-3e8fa0ce20c4")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("44990f87-a0a4-4cd1-a0c2-3e9be8895dba"), IkeTerm.ENGLISH_LANGUAGE, "Order for axiom attachments (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bc531c8b-f995-4067-81dc-49fcd065d08e"), IkeTerm.ENGLISH_LANGUAGE, "Axiom attachment order", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("42bd0984-8d26-43b4-a6ed-22928a6f7847"), IkeTerm.ENGLISH_LANGUAGE, "Order in which axioms are attached", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("0737df99-f5f8-4afe-845e-db0891d271f8"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "abcb0946-20e1-5483-8469-3e8fa0ce20c4")
                .statedAxioms(PublicIds.of("8dbb8e28-d4c1-5d7f-a003-d99a395d29ed"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("f6e730fe-ed8d-4538-9379-5b87dfea4ae9"))
                .semanticOn(PublicIds.of("44990f87-a0a4-4cd1-a0c2-3e9be8895dba"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f10482ed-cf47-4597-af15-600f9a29d9f6"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("bc531c8b-f995-4067-81dc-49fcd065d08e"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("45526838-583e-413a-8a10-0c9051456bae"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("42bd0984-8d26-43b4-a6ed-22928a6f7847"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("dffbcae1-a74b-4bd5-86f7-367dd95a82ee"), IkeTerm.PREFERRED)
                ;

        set.concept("KOMET user list (SOLOR", PublicIds.of("5e77558d-97d0-52b6-adf0-d54beb97b3a6")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3bc9a41e-a61e-4aab-80a9-f4da03131a97"), IkeTerm.ENGLISH_LANGUAGE, "KOMET user list (SOLOR", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d96c0f28-42a6-4817-a7d6-4baf52e3ebb4"), IkeTerm.ENGLISH_LANGUAGE, "KOMET user list", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f0dd8d7e-5733-4dbf-8ab5-ff4a3b4272ca"), IkeTerm.ENGLISH_LANGUAGE, "Inventory of authorized komet users", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("9e76e78d-20af-449d-b4cf-bcfbc3f4823a"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "5e77558d-97d0-52b6-adf0-d54beb97b3a6")
                .statedAxioms(PublicIds.of("0979c33c-4a97-5e72-8efd-a42a098ce2d4"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.USER))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("9908a246-597a-457c-96f0-21fcc9d29bfb"))
                .semanticOn(PublicIds.of("3bc9a41e-a61e-4aab-80a9-f4da03131a97"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3f314f11-56d2-4b57-bd40-e9fc33603fd9"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d96c0f28-42a6-4817-a7d6-4baf52e3ebb4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2a8af379-22d4-4b89-8dbb-e4428e43ae6a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f0dd8d7e-5733-4dbf-8ab5-ff4a3b4272ca"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("33859982-68b0-4f2c-923e-890f08ff200b"), IkeTerm.PREFERRED)
                ;

    }
}
