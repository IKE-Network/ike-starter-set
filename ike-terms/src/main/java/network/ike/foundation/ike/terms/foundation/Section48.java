package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Transitive Feature" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section48 {

    private Section48() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Transitive Feature (SOLOR)", PublicIds.of("53f866d0-fd61-5c85-a16c-150bd619a0ac")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8781d232-ce28-422c-9121-2c7d0df128ca"), IkeTerm.ENGLISH_LANGUAGE, "Transitive Feature (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("89740fb9-ee44-439e-9ccb-e12942d6440a"), IkeTerm.ENGLISH_LANGUAGE, "Transitive Feature", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c3fd417e-e68a-4bb5-82c1-8b8d211477dd"), IkeTerm.ENGLISH_LANGUAGE, "Transitive property (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("c799493c-2579-47c2-b439-78c72e5062e4"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "53f866d0-fd61-5c85-a16c-150bd619a0ac")
                .statedAxioms(PublicIds.of("70712d68-977d-517e-a64a-8cc555d42ea9"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical expression model (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("c24bb780-0931-42e8-a873-71cf6da39190"))
                .semanticOn(PublicIds.of("8781d232-ce28-422c-9121-2c7d0df128ca"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7bc7bdc4-5052-49f5-95d5-2113d080c5b5"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("89740fb9-ee44-439e-9ccb-e12942d6440a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a65ce473-8e73-4f22-aa90-1c7f701f50c7"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c3fd417e-e68a-4bb5-82c1-8b8d211477dd"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("749ae9bc-9a98-4382-a3de-2bf77962db0c"), IkeTerm.PREFERRED)
                ;

    }
}
