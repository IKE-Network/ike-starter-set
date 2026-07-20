package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Inferred Definition" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section53 {

    private Section53() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Inferred Definition (SOLOR)", PublicIds.of("b1abf4dc-9838-4b46-ac55-10c4f92ba10b")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f35c6ece-5318-4ea5-893e-93982a2e6b23"), IkeTerm.ENGLISH_LANGUAGE, "Inferred Definition (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("118d4591-a873-40bc-a077-31330828f82d"), IkeTerm.ENGLISH_LANGUAGE, "Inferred Definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("46936e5b-41cd-4289-ad51-ae66d5f848c5"), IkeTerm.ENGLISH_LANGUAGE, "The relationships/axioms of a concept that have been inferred", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("80740f00-2156-48a8-9e19-2eb4ea77a9ab"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b1abf4dc-9838-4b46-ac55-10c4f92ba10b")
                .statedAxioms(PublicIds.of("b49a30ed-cee7-5e72-8790-a83177479a6c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("816a08ba-6fd0-447f-bcaf-a092c9e6c92a"))
                .semanticOn(PublicIds.of("f35c6ece-5318-4ea5-893e-93982a2e6b23"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("facc6714-b3fd-4f94-b232-e6023a64d604"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("118d4591-a873-40bc-a077-31330828f82d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5212bf45-6f0c-4c31-99a1-bd158a54521a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("46936e5b-41cd-4289-ad51-ae66d5f848c5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f5eb7c75-6516-4c75-84b6-cc6b3f02faa7"), IkeTerm.PREFERRED)
                ;

    }
}
