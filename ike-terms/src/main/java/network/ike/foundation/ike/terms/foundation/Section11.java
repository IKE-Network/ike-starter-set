package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.InactiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Concept details tree table" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section11 {

    private Section11() {
    }

    static void compose(KnowledgeSet set) {
        InactiveStamp retirement = network.ike.foundation.ike.terms.Ike.RETIREMENT;

        // Retired in place (IKE-Network/ike-issues#1124): a Komet user-interface widget the
        // baseline filed as a base model concept. Opened at the retirement stamp without a
        // birth scope (IKE-Network/ike-issues#1130): one inactive version on the concept, one
        // on its stated definition (the baseline's own, restated), one on its base-model
        // membership. Descriptions and identifier stay with the baseline, so the name holds;
        // registered in DELIBERATELY_RETIRED.
        set.concept("Concept details tree table (SOLOR)", PublicIds.of(UUID.fromString("1655edd8-7b73-52c5-98b0-263d1ab3a90b"))).at(retirement)
                .retire()
                .retireStatedAxioms(PublicIds.of(UUID.fromString("446fda85-53ab-5243-84dd-cb15fcec262c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .retireSemantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6ea27f77-5bd9-406f-9b08-a7efa72cb3ad")))
                ;

    }
}
