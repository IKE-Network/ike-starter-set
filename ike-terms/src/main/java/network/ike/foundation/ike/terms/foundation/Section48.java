package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Transitive Feature" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section48 {

    private Section48() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Transitive Feature (SOLOR)", PublicIds.of(UUID.fromString("53f866d0-fd61-5c85-a16c-150bd619a0ac"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8781d232-ce28-422c-9121-2c7d0df128ca")), KernelTerm.ENGLISH_LANGUAGE, "Transitive Feature (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("89740fb9-ee44-439e-9ccb-e12942d6440a")), KernelTerm.ENGLISH_LANGUAGE, "Transitive Feature", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c3fd417e-e68a-4bb5-82c1-8b8d211477dd")), KernelTerm.ENGLISH_LANGUAGE, "Transitive property (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c799493c-2579-47c2-b439-78c72e5062e4")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "53f866d0-fd61-5c85-a16c-150bd619a0ac")
                .statedAxioms(PublicIds.of(UUID.fromString("70712d68-977d-517e-a64a-8cc555d42ea9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object properties (SOLOR)", PublicIds.of("3ef4311c-70c0-5149-9e06-53d745f85b15"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c24bb780-0931-42e8-a873-71cf6da39190")))
                .semanticOn(PublicIds.of(UUID.fromString("8781d232-ce28-422c-9121-2c7d0df128ca")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7bc7bdc4-5052-49f5-95d5-2113d080c5b5")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("89740fb9-ee44-439e-9ccb-e12942d6440a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a65ce473-8e73-4f22-aa90-1c7f701f50c7")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c3fd417e-e68a-4bb5-82c1-8b8d211477dd")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("749ae9bc-9a98-4382-a3de-2bf77962db0c")), KernelTerm.PREFERRED)
                ;

    }
}
