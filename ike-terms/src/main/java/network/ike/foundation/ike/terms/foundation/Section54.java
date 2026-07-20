package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Description semantic" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section54 {

    private Section54() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description semantic", PublicIds.of("81487d5f-6115-51e2-a3b3-93d783888eb8")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("733ddf1e-145a-4ffc-b508-361680cddda9"), IkeTerm.ENGLISH_LANGUAGE, "Description semantic", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("be79bc92-ec04-4d33-be2b-b28c957082d9"), IkeTerm.ENGLISH_LANGUAGE, "Description semantic", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6fc11328-1eb6-4448-986c-57a9e517ff83"), IkeTerm.ENGLISH_LANGUAGE, "Purpose and meaning for the description pattern and dialect patterns", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("ea291134-be63-48ff-afbe-e0b687ffa70d"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "81487d5f-6115-51e2-a3b3-93d783888eb8")
                .statedAxioms(PublicIds.of("4559c6fb-e128-5a4d-b6a9-bd3e9138b2e0"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT), leb.ConceptAxiom(IkeTerm.MEANING), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("39c53be7-7739-478e-bab8-c61aa7facaed"))
                .semanticOn(PublicIds.of("733ddf1e-145a-4ffc-b508-361680cddda9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("614536d2-633d-4fb1-831c-e5c4d850905a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("be79bc92-ec04-4d33-be2b-b28c957082d9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f2c19f45-567f-45d5-aafc-90c3a89b23f6"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6fc11328-1eb6-4448-986c-57a9e517ff83"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("74c8d3a7-2814-4908-9fd3-c41435b1734b"), IkeTerm.PREFERRED)
                ;

    }
}
