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

/** The "Property Sequence" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section65 {

    private Section65() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Property Sequence (SOLOR)", PublicIds.of(UUID.fromString("d0d759fd-510f-475a-900e-b1439b4536e1"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("319a091a-8f84-4544-a6d7-8666bfe8aa8e")), TinkarTerm.ENGLISH_LANGUAGE, "Property Sequence (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b124d5f9-f887-41c6-85cb-46f23c665f8a")), TinkarTerm.ENGLISH_LANGUAGE, "Property Sequence", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("984a9210-2972-4f1a-a495-8451287afac9")), TinkarTerm.PREFERRED)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8981cb20-2dbe-4a86-8fe0-82e65b621dd3")), TinkarTerm.ENGLISH_LANGUAGE, "Property sequence (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("10aef8b3-994f-44b2-bb2b-5335c065586d")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "d0d759fd-510f-475a-900e-b1439b4536e1")
                .statedAxioms(PublicIds.of(UUID.fromString("c6489041-4b83-518d-9dd0-0c21e706ca50")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.OBJECT_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c12be094-b8e8-41bc-bf81-67e7b8de02fd")))
                .semanticOn(PublicIds.of(UUID.fromString("319a091a-8f84-4544-a6d7-8666bfe8aa8e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("756c2e66-18e7-4367-bfd7-0ef1211a7dfc")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("8981cb20-2dbe-4a86-8fe0-82e65b621dd3")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1e9674ac-6368-4045-a9e4-fccdcd4f0ee5")), TinkarTerm.PREFERRED)
                ;

    }
}
