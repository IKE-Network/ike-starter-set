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

/** The "Transitive Feature" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section48 {

    private Section48() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Transitive Feature (SOLOR)", PublicIds.of(UUID.fromString("53f866d0-fd61-5c85-a16c-150bd619a0ac"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8781d232-ce28-422c-9121-2c7d0df128ca")), TinkarTerm.ENGLISH_LANGUAGE, "Transitive Feature (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("89740fb9-ee44-439e-9ccb-e12942d6440a")), TinkarTerm.ENGLISH_LANGUAGE, "Transitive Feature", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c3fd417e-e68a-4bb5-82c1-8b8d211477dd")), TinkarTerm.ENGLISH_LANGUAGE, "Transitive property (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c799493c-2579-47c2-b439-78c72e5062e4")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "53f866d0-fd61-5c85-a16c-150bd619a0ac")
                .statedAxioms(PublicIds.of(UUID.fromString("70712d68-977d-517e-a64a-8cc555d42ea9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.OBJECT_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c24bb780-0931-42e8-a873-71cf6da39190")))
                .semanticOn(PublicIds.of(UUID.fromString("8781d232-ce28-422c-9121-2c7d0df128ca")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7bc7bdc4-5052-49f5-95d5-2113d080c5b5")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("89740fb9-ee44-439e-9ccb-e12942d6440a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a65ce473-8e73-4f22-aa90-1c7f701f50c7")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c3fd417e-e68a-4bb5-82c1-8b8d211477dd")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("749ae9bc-9a98-4382-a3de-2bf77962db0c")), TinkarTerm.PREFERRED)
                ;

    }
}
