package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Inferred Definition" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section53 {

    private Section53() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Inferred Definition (SOLOR)", PublicIds.of(UUID.fromString("b1abf4dc-9838-4b46-ac55-10c4f92ba10b"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f35c6ece-5318-4ea5-893e-93982a2e6b23")), KernelTerm.ENGLISH_LANGUAGE, "Inferred Definition (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("118d4591-a873-40bc-a077-31330828f82d")), KernelTerm.ENGLISH_LANGUAGE, "Inferred Definition", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("46936e5b-41cd-4289-ad51-ae66d5f848c5")), KernelTerm.ENGLISH_LANGUAGE, "The relationships/axioms of a concept that have been inferred", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("80740f00-2156-48a8-9e19-2eb4ea77a9ab")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "b1abf4dc-9838-4b46-ac55-10c4f92ba10b")
                .statedAxioms(PublicIds.of(UUID.fromString("b49a30ed-cee7-5e72-8790-a83177479a6c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("816a08ba-6fd0-447f-bcaf-a092c9e6c92a")))
                .semanticOn(PublicIds.of(UUID.fromString("f35c6ece-5318-4ea5-893e-93982a2e6b23")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("facc6714-b3fd-4f94-b232-e6023a64d604")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("118d4591-a873-40bc-a077-31330828f82d")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5212bf45-6f0c-4c31-99a1-bd158a54521a")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("46936e5b-41cd-4289-ad51-ae66d5f848c5")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f5eb7c75-6516-4c75-84b6-cc6b3f02faa7")), KernelTerm.PREFERRED)
                ;

    }
}
