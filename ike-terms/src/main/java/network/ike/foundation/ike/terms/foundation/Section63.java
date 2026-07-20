package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Creative Commons BY license" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section63 {

    private Section63() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Creative Commons BY license (SOLOR)", PublicIds.of("3415a972-7850-57cd-aa86-a572ca1c2ceb")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("432005a0-0bbb-40ae-a69a-7600fb22dd10"), IkeTerm.ENGLISH_LANGUAGE, "Creative Commons BY license (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("dbbdb8c5-fdb8-48df-b6a0-8a857b39cb81"), IkeTerm.ENGLISH_LANGUAGE, "Creative Commons BY license", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6901610c-5921-411f-b513-4bc507541d94"), IkeTerm.ENGLISH_LANGUAGE, "Creative Commons (CC) licenses are a set of public copyright licenses that enable the free distribution of an otherwise copyrighted work", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("edcfc1bf-bda2-4915-aa43-08b68306fcfd"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "3415a972-7850-57cd-aa86-a572ca1c2ceb")
                .statedAxioms(PublicIds.of("d27af530-31d3-5921-8f87-f4e3f0467593"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROOT_VERTEX))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8af204ce-df5e-49c5-90d9-bbcb33d1bcce"))
                .semanticOn(PublicIds.of("432005a0-0bbb-40ae-a69a-7600fb22dd10"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a28c4ee7-6d15-4f8b-b147-17f62bed2f8b"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("dbbdb8c5-fdb8-48df-b6a0-8a857b39cb81"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d79aa106-6c7f-4e64-9fb5-82d627e7547e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6901610c-5921-411f-b513-4bc507541d94"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3aa49fae-5f58-4b46-b3ea-8fbcede2ebd3"), IkeTerm.PREFERRED)
                ;

    }
}
