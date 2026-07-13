package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Author" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section6 {

    private Section6() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Author", PublicIds.of(UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("96657b21-6469-4a6c-b052-023b4e1dc085")), TinkarTerm.ENGLISH_LANGUAGE, "Author", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c8246260-2401-4442-95fc-c5dd6ee5b037")), TinkarTerm.ENGLISH_LANGUAGE, "Author", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a2892585-1d62-4ea6-9cd5-f93cbf4a37a9")), TinkarTerm.ENGLISH_LANGUAGE, "Author", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("fc531f90-2ca7-4460-b38d-a037feffb526")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f7495b58-6630-3499-a44e-2052b5fcf06c")
                .statedAxioms(PublicIds.of(UUID.fromString("d6aedbb3-ae0b-59e7-958d-e788b91f3a1a")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ROOT_VERTEX))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7c40bd16-aad2-4187-b4a8-4362d34da30f")))
                .semanticOn(PublicIds.of(UUID.fromString("96657b21-6469-4a6c-b052-023b4e1dc085")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a3aa1616-bd7a-424e-8671-3f63d3dd315d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c8246260-2401-4442-95fc-c5dd6ee5b037")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48ce398d-efb1-4a68-b962-8eb42d7e2744")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a2892585-1d62-4ea6-9cd5-f93cbf4a37a9")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3c98f3f7-dba8-468a-8d3f-7d3b9a21175e")), TinkarTerm.PREFERRED)
                ;

        set.concept("Gretel (User)", PublicIds.of(UUID.fromString("1c0023ed-559e-3311-9e55-bd4bd9e5628f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1f281cb9-06fe-49ba-bcc2-ad53387812c5")), TinkarTerm.ENGLISH_LANGUAGE, "Gretel (User)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("485c77b6-2777-4ff9-b567-458ccc8a1323")), TinkarTerm.ENGLISH_LANGUAGE, "Gretel", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c50f3345-e1d9-4103-bf2e-55739f777f3b")), TinkarTerm.ENGLISH_LANGUAGE, "Default Author for Komet", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("b5868bac-1709-4a29-9f5e-1770d84bb66e")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1c0023ed-559e-3311-9e55-bd4bd9e5628f")
                .statedAxioms(PublicIds.of(UUID.fromString("40cb3877-1b48-5f52-9c57-9e46239e0cc4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a5bc8c8a-dd98-4bc4-990f-97b8ad9c96d7")))
                .semanticOn(PublicIds.of(UUID.fromString("1f281cb9-06fe-49ba-bcc2-ad53387812c5")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c73e0ff7-4a4d-4240-8893-fdca22a4ed59")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("485c77b6-2777-4ff9-b567-458ccc8a1323")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6567247e-b130-40be-a2bd-433e2b37d733")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c50f3345-e1d9-4103-bf2e-55739f777f3b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d03202e7-b3da-4f7a-b350-79256c3114fb")), TinkarTerm.PREFERRED)
                ;

        set.concept("Path for user (SOLOR)", PublicIds.of(UUID.fromString("12131382-1535-5a77-928b-6eacad221ea2"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d9daf884-7d7d-4b0a-bb33-7c5d72e18870")), TinkarTerm.ENGLISH_LANGUAGE, "Path for user (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2ac3a662-8b8e-462d-9840-687aa36b5d08")), TinkarTerm.ENGLISH_LANGUAGE, "Path for user", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ee57f842-3187-42a2-a285-3fa092552d18")), TinkarTerm.ENGLISH_LANGUAGE, "Path for user", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c8a1b2ac-6442-4551-865a-2b831400c316")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "12131382-1535-5a77-928b-6eacad221ea2")
                .statedAxioms(PublicIds.of(UUID.fromString("82e846f7-76a5-526c-96b5-20e64f1719ae")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("495f752c-6c8c-4f0e-8676-0670073d42aa")))
                .semanticOn(PublicIds.of(UUID.fromString("d9daf884-7d7d-4b0a-bb33-7c5d72e18870")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3ab9446f-8e06-4609-9882-2a9dba7616cb")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2ac3a662-8b8e-462d-9840-687aa36b5d08")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a18aef2c-bc76-40c2-a10a-9442538a97b1")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ee57f842-3187-42a2-a285-3fa092552d18")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0772541e-98b9-4f27-bb6e-c7164f63ddbd")), TinkarTerm.PREFERRED)
                ;

        set.concept("Order for concept attachments  (SOLOR)", PublicIds.of(UUID.fromString("6167efcb-50e8-534d-9827-fdd60b02ae00"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bb3b7269-4663-4700-bac8-8b311b16d76b")), TinkarTerm.ENGLISH_LANGUAGE, "Order for concept attachments  (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9bf4af36-b0ff-48d6-9b1d-7194b17fd9e3")), TinkarTerm.ENGLISH_LANGUAGE, "Concept attachment order", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e267db9d-ab3e-426d-9841-e7b09193da88")), TinkarTerm.ENGLISH_LANGUAGE, "Order in which concepts are attached", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("accf5ab0-76f2-44d9-b609-7a9054f23c94")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6167efcb-50e8-534d-9827-fdd60b02ae00")
                .statedAxioms(PublicIds.of(UUID.fromString("446cb1de-7ac9-5fb1-aebe-f54e4f453037")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0889f798-bfe9-49fc-b282-986562c01237")))
                .semanticOn(PublicIds.of(UUID.fromString("bb3b7269-4663-4700-bac8-8b311b16d76b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("81ecd817-a695-45e1-91c4-2d15d1cebd46")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9bf4af36-b0ff-48d6-9b1d-7194b17fd9e3")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("dcbb2082-d981-4b08-a70e-4a94e5db5d59")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e267db9d-ab3e-426d-9841-e7b09193da88")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d302fd51-b6f2-4397-907b-620c2a4c2d7a")), TinkarTerm.PREFERRED)
                ;

        set.concept("Order for description attachments (SOLOR)", PublicIds.of(UUID.fromString("69ee3f13-e2ba-5a96-9b91-5eecfad8e587"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("af67ff36-a50b-4c5b-a6be-92573ce24e7c")), TinkarTerm.ENGLISH_LANGUAGE, "Order for description attachments (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("37a4e42d-9218-4b4c-a83c-4fab77a53ad7")), TinkarTerm.ENGLISH_LANGUAGE, "Description attachment order", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("981fa129-e4cd-4132-8a21-e2ba11f4b6e7")), TinkarTerm.ENGLISH_LANGUAGE, "Order in which descriptions are attached", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("b94cb792-2b97-4c5f-a1d5-0a0c6acc5bf7")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "69ee3f13-e2ba-5a96-9b91-5eecfad8e587")
                .statedAxioms(PublicIds.of(UUID.fromString("c0ecad74-1af6-534b-bd48-64100abc830c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6b27f9b3-ffe6-43d2-9b96-5e1a4a25ce50")))
                .semanticOn(PublicIds.of(UUID.fromString("af67ff36-a50b-4c5b-a6be-92573ce24e7c")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d9683c76-c246-4658-adb5-70a1202a64e8")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("37a4e42d-9218-4b4c-a83c-4fab77a53ad7")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5966eb19-e491-424b-baab-8d29d880761c")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("981fa129-e4cd-4132-8a21-e2ba11f4b6e7")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c8277c7f-a97c-4509-88f2-88aada0fc209")), TinkarTerm.PREFERRED)
                ;

        set.concept("Starter Data Authoring (SOLOR)", PublicIds.of(UUID.fromString("070deb74-acc5-46bf-b9c6-eaee1b58ef52"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("66c6793d-4eae-4383-a60e-d56c5a9a3788")), TinkarTerm.ENGLISH_LANGUAGE, "Starter Data Authoring (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b5580a1a-6942-458e-9e9c-8b8e5d021b0c")), TinkarTerm.ENGLISH_LANGUAGE, "Metadata Authoring", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3ffd23e7-62ca-4b60-baea-8bf57b8319e7")), TinkarTerm.ENGLISH_LANGUAGE, "Define necessary minimum viable concepts to use Tinkar Data", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0731569a-ed24-47d1-8f4c-053a875e04b3")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "070deb74-acc5-46bf-b9c6-eaee1b58ef52")
                .statedAxioms(PublicIds.of(UUID.fromString("4f899d97-b46b-5d9e-afe3-52b0e098c676")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c69d5dcf-f6a1-49a7-af1a-21968979d353")))
                .semanticOn(PublicIds.of(UUID.fromString("66c6793d-4eae-4383-a60e-d56c5a9a3788")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2c08299a-0966-42d1-84ad-8f1d2f090a22")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b5580a1a-6942-458e-9e9c-8b8e5d021b0c")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c21a63e2-3170-4b4b-9ccc-f5400674b212")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3ffd23e7-62ca-4b60-baea-8bf57b8319e7")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("781ab202-4b65-4ff6-a478-fa2dc4f52254")), TinkarTerm.PREFERRED)
                ;

        set.concept("KOMET user (SOLOR)", PublicIds.of(UUID.fromString("61c1a544-2acf-58cd-8cc0-9ac581d4227e"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fe6b4a60-3548-44ee-a703-072fe9922fb1")), TinkarTerm.ENGLISH_LANGUAGE, "KOMET user (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("22494eaa-13de-40b8-a11d-fb85ec3d4b20")), TinkarTerm.ENGLISH_LANGUAGE, "KOMET user", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6ff489ff-2cea-41e9-92bb-37b4e0d4c4db")), TinkarTerm.ENGLISH_LANGUAGE, "Authorized to author, edit and/or view in Komet", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4a27d6cc-3488-4ed8-9ba1-d77857ca1a21")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "61c1a544-2acf-58cd-8cc0-9ac581d4227e")
                .statedAxioms(PublicIds.of(UUID.fromString("e5da5a39-5080-5fe7-9ea2-65e4198b3d7d")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("027b4080-a29e-4706-a086-4ccb89f2d78a")))
                .semanticOn(PublicIds.of(UUID.fromString("fe6b4a60-3548-44ee-a703-072fe9922fb1")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5d67a069-eecd-4434-8da3-e146d0b29ff6")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("22494eaa-13de-40b8-a11d-fb85ec3d4b20")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("39974f67-19cb-42ec-a1c6-df22ef28f3f7")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6ff489ff-2cea-41e9-92bb-37b4e0d4c4db")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0a87d5a9-9e2a-4ac2-a2f9-2132f6d977e8")), TinkarTerm.PREFERRED)
                ;

        set.concept("Module for user (SOLOR)", PublicIds.of(UUID.fromString("c8fd4f1b-d842-5245-9a7d-a58dc0ac1c11"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e1e48ab5-5f96-4373-b4d0-c585e689bfba")), TinkarTerm.ENGLISH_LANGUAGE, "Module for user (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ad0c760b-7d8d-4bd0-99f0-fb3e1180590d")), TinkarTerm.ENGLISH_LANGUAGE, "Module for user", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("cc33a3cb-3781-4745-8a88-e65fa6b47ed3")), TinkarTerm.ENGLISH_LANGUAGE, "User preference for Module?", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c0b34934-aa26-48bb-affb-2046614f25be")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c8fd4f1b-d842-5245-9a7d-a58dc0ac1c11")
                .statedAxioms(PublicIds.of(UUID.fromString("afcddf70-7b86-5f14-9f9c-6f2826b40691")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a41a37f2-92fc-4aae-b11b-bd73cee9c788")))
                .semanticOn(PublicIds.of(UUID.fromString("e1e48ab5-5f96-4373-b4d0-c585e689bfba")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ed7e5825-471f-43a5-9c0b-626c4ebca1a0")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ad0c760b-7d8d-4bd0-99f0-fb3e1180590d")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e643fbab-fecb-41ab-a26a-692bdfb82730")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("cc33a3cb-3781-4745-8a88-e65fa6b47ed3")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("06c60a94-1750-43d1-816d-7fe9e927f58b")), TinkarTerm.PREFERRED)
                ;

        set.concept("Tinkar Starter Data Author (User)", PublicIds.of(UUID.fromString("dd96b2ea-6d7b-3791-ad74-bbdc67c493c1"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6280c1e5-e3ee-4ae3-a88e-5a02dfa0dbb0")), TinkarTerm.ENGLISH_LANGUAGE, "Tinkar Starter Data Author (User)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("432e4ea2-342b-4917-95bb-3e1b791723c0")), TinkarTerm.ENGLISH_LANGUAGE, "Tinkar Starter Data Author", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6c1f2d80-e384-4af3-a3a6-d763546d978a")), TinkarTerm.ENGLISH_LANGUAGE, "Tinkar Starter Data Author", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("484caf62-f88c-4908-b85d-c32f0d96dbce")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "dd96b2ea-6d7b-3791-ad74-bbdc67c493c1")
                .statedAxioms(PublicIds.of(UUID.fromString("4749ae4c-8587-5dfd-bc1a-f1c5951b14e0")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6822a4d9-7bcd-462c-b75d-6322b682b629")))
                .semanticOn(PublicIds.of(UUID.fromString("6280c1e5-e3ee-4ae3-a88e-5a02dfa0dbb0")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e5d1fd31-0406-4e00-994c-f028ca5fc62b")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("432e4ea2-342b-4917-95bb-3e1b791723c0")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7344b74a-6ab0-4350-b489-87f4c1320cfa")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6c1f2d80-e384-4af3-a3a6-d763546d978a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("03548c1c-98a6-4860-a5c2-e17a164ee76a")), TinkarTerm.PREFERRED)
                ;

        set.concept("Order for axiom attachments (SOLOR)", PublicIds.of(UUID.fromString("abcb0946-20e1-5483-8469-3e8fa0ce20c4"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("44990f87-a0a4-4cd1-a0c2-3e9be8895dba")), TinkarTerm.ENGLISH_LANGUAGE, "Order for axiom attachments (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bc531c8b-f995-4067-81dc-49fcd065d08e")), TinkarTerm.ENGLISH_LANGUAGE, "Axiom attachment order", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("42bd0984-8d26-43b4-a6ed-22928a6f7847")), TinkarTerm.ENGLISH_LANGUAGE, "Order in which axioms are attached", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0737df99-f5f8-4afe-845e-db0891d271f8")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "abcb0946-20e1-5483-8469-3e8fa0ce20c4")
                .statedAxioms(PublicIds.of(UUID.fromString("8dbb8e28-d4c1-5d7f-a003-d99a395d29ed")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("f6e730fe-ed8d-4538-9379-5b87dfea4ae9")))
                .semanticOn(PublicIds.of(UUID.fromString("44990f87-a0a4-4cd1-a0c2-3e9be8895dba")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f10482ed-cf47-4597-af15-600f9a29d9f6")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bc531c8b-f995-4067-81dc-49fcd065d08e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("45526838-583e-413a-8a10-0c9051456bae")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("42bd0984-8d26-43b4-a6ed-22928a6f7847")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("dffbcae1-a74b-4bd5-86f7-367dd95a82ee")), TinkarTerm.PREFERRED)
                ;

        set.concept("KOMET user list (SOLOR", PublicIds.of(UUID.fromString("5e77558d-97d0-52b6-adf0-d54beb97b3a6"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3bc9a41e-a61e-4aab-80a9-f4da03131a97")), TinkarTerm.ENGLISH_LANGUAGE, "KOMET user list (SOLOR", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d96c0f28-42a6-4817-a7d6-4baf52e3ebb4")), TinkarTerm.ENGLISH_LANGUAGE, "KOMET user list", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f0dd8d7e-5733-4dbf-8ab5-ff4a3b4272ca")), TinkarTerm.ENGLISH_LANGUAGE, "Inventory of authorized komet users", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("9e76e78d-20af-449d-b4cf-bcfbc3f4823a")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "5e77558d-97d0-52b6-adf0-d54beb97b3a6")
                .statedAxioms(PublicIds.of(UUID.fromString("0979c33c-4a97-5e72-8efd-a42a098ce2d4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.USER))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("9908a246-597a-457c-96f0-21fcc9d29bfb")))
                .semanticOn(PublicIds.of(UUID.fromString("3bc9a41e-a61e-4aab-80a9-f4da03131a97")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3f314f11-56d2-4b57-bd40-e9fc33603fd9")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d96c0f28-42a6-4817-a7d6-4baf52e3ebb4")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2a8af379-22d4-4b89-8dbb-e4428e43ae6a")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f0dd8d7e-5733-4dbf-8ab5-ff4a3b4272ca")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("33859982-68b0-4f2c-923e-890f08ff200b")), TinkarTerm.PREFERRED)
                ;

    }
}
