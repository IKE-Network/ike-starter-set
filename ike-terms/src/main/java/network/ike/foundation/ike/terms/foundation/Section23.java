package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Sandbox component" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section23 {

    private Section23() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Sandbox component (SOLOR)", PublicIds.of("c93829b2-aa78-5a84-ac9a-c34307844166")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("690b90ad-1079-4e6a-96fa-2c2d784bd3dc"), IkeTerm.ENGLISH_LANGUAGE, "Sandbox component (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("217c4474-d7f7-440d-9841-a6962cb7f937"), IkeTerm.ENGLISH_LANGUAGE, "Sandbox component", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("989ed925-0d60-4aae-a13d-8653b4433de4"), IkeTerm.ENGLISH_LANGUAGE, "Sandbox component", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("49201078-06e2-4ae0-a13a-84d3ed75d758"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c93829b2-aa78-5a84-ac9a-c34307844166")
                .statedAxioms(PublicIds.of("fd59589b-5fbc-5422-908f-3a488f5cba59"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Legacy model concepts (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("2f407eeb-41bc-4218-a94d-536f39fadd0c"))
                .semanticOn(PublicIds.of("690b90ad-1079-4e6a-96fa-2c2d784bd3dc"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4a5b30de-c690-40ad-a933-bd6080067fbd"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("217c4474-d7f7-440d-9841-a6962cb7f937"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("77cf6f42-11bf-4414-9eaa-f45577e18bf1"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("989ed925-0d60-4aae-a13d-8653b4433de4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0295074e-b827-4707-aae5-cb15a5ce4410"), IkeTerm.PREFERRED)
                ;

        set.concept("Sandbox module (SOLOR)", PublicIds.of("c5daf0e9-30dc-5b3e-a521-d6e6e72c8a95")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c7411ff6-6a96-40f4-b3df-d5169b010554"), IkeTerm.ENGLISH_LANGUAGE, "Sandbox module (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("36f61803-f512-42a3-8da4-7fcb9e3e25aa"), IkeTerm.ENGLISH_LANGUAGE, "Sandbox module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2e56cf98-c9a5-42d0-a68f-eafc7e00e3c9"), IkeTerm.ENGLISH_LANGUAGE, "Sandbox module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("afb01686-5bbf-460f-b488-4d01ce719fe6"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c5daf0e9-30dc-5b3e-a521-d6e6e72c8a95")
                .statedAxioms(PublicIds.of("fba03f97-308f-5a38-9dc1-9139c36990d9"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.MODULE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("3f1198fa-b933-4f26-a04d-c6d24f7e78e8"))
                .semanticOn(PublicIds.of("c7411ff6-6a96-40f4-b3df-d5169b010554"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fd9d6893-6eb2-4bab-9bd4-dc503e54a01f"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("36f61803-f512-42a3-8da4-7fcb9e3e25aa"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("66eb3061-ab49-4570-b1fb-593c15477cba"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2e56cf98-c9a5-42d0-a68f-eafc7e00e3c9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("02c0f2e5-5ae7-4dc7-a588-f103f48452c3"), IkeTerm.PREFERRED)
                ;

        set.concept("Sandbox path module (SOLOR)", PublicIds.of("715bd36d-6090-5b37-8ae7-88c9e532010e")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9e36a9a3-7e1e-4675-83c3-a441578e7762"), IkeTerm.ENGLISH_LANGUAGE, "Sandbox path module (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("625c06dc-8f26-4916-a684-6e70b79070a3"), IkeTerm.ENGLISH_LANGUAGE, "Sandbox Path module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6c78053c-0780-4cff-884e-c114f176c39f"), IkeTerm.ENGLISH_LANGUAGE, "Sandbox path module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("16e40379-7714-4984-bdbd-7173de774fea"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "715bd36d-6090-5b37-8ae7-88c9e532010e")
                .statedAxioms(PublicIds.of("266561f2-26b4-5233-b53e-5c9f38471c43"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.SANDBOX_MODULE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("febb4bc7-8265-4ef9-a39c-507713384e67"))
                .semanticOn(PublicIds.of("9e36a9a3-7e1e-4675-83c3-a441578e7762"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fbffd7c1-46a7-4b2f-9685-d539f9391c99"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("625c06dc-8f26-4916-a684-6e70b79070a3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ec3cc122-dbe9-43de-9d84-a0fae3cbbd21"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6c78053c-0780-4cff-884e-c114f176c39f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6960eb29-da81-410f-bfad-eabcb124c3a6"), IkeTerm.PREFERRED)
                ;

    }
}
