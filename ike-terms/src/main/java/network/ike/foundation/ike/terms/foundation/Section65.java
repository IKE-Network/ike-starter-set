package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Property Sequence" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section65 {

    private Section65() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Property Sequence (SOLOR)", PublicIds.of("d0d759fd-510f-475a-900e-b1439b4536e1")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("319a091a-8f84-4544-a6d7-8666bfe8aa8e"), IkeTerm.ENGLISH_LANGUAGE, "Property Sequence (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b124d5f9-f887-41c6-85cb-46f23c665f8a"), IkeTerm.ENGLISH_LANGUAGE, "Property Sequence", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.US_DIALECT_PATTERN, PublicIds.of("984a9210-2972-4f1a-a495-8451287afac9"), IkeTerm.PREFERRED)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8981cb20-2dbe-4a86-8fe0-82e65b621dd3"), IkeTerm.ENGLISH_LANGUAGE, "An ordered sequence of properties, as used by a property-sequence implication: the chain whose composition is asserted to imply another property.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("10aef8b3-994f-44b2-bb2b-5335c065586d"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "d0d759fd-510f-475a-900e-b1439b4536e1")
                .statedAxioms(PublicIds.of("c6489041-4b83-518d-9dd0-0c21e706ca50"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical expression model (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("c12be094-b8e8-41bc-bf81-67e7b8de02fd"))
                .semanticOn(PublicIds.of("319a091a-8f84-4544-a6d7-8666bfe8aa8e"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("756c2e66-18e7-4367-bfd7-0ef1211a7dfc"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("8981cb20-2dbe-4a86-8fe0-82e65b621dd3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1e9674ac-6368-4045-a9e4-fccdcd4f0ee5"), IkeTerm.PREFERRED)
                ;

    }
}
