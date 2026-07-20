package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Value Constraint" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section34 {

    private Section34() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Value Constraint (SOLOR)", PublicIds.of("8c55fb86-92d8-42a9-ad70-1e23abbf7eec")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bf1086cc-8c63-4f9f-a2b9-4bada7a2f2a4"), IkeTerm.ENGLISH_LANGUAGE, "Value Constraint (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3eccfc77-b029-4f21-b5ea-4404ff9fa00d"), IkeTerm.ENGLISH_LANGUAGE, "Value Constraint", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("698e246d-4d19-42f6-932a-c86003a219dc"), IkeTerm.ENGLISH_LANGUAGE, "A component has specific value requirements that needs to be met", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("d19583d1-fb77-4c76-a902-33df7d21f873"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "8c55fb86-92d8-42a9-ad70-1e23abbf7eec")
                .statedAxioms(PublicIds.of("f0b576b8-0b9c-56ee-a5ab-98a6915afb70"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("b19dd4ae-e3c2-4d6d-8093-7878089961b7"))
                .semanticOn(PublicIds.of("bf1086cc-8c63-4f9f-a2b9-4bada7a2f2a4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f9e8f428-23cc-4226-92f5-85c0b2e81dab"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("3eccfc77-b029-4f21-b5ea-4404ff9fa00d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d025af10-d093-4cc0-a338-64c0752a5b26"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("698e246d-4d19-42f6-932a-c86003a219dc"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fe33f383-8bf8-437c-b0d9-2b2a2b44ec88"), IkeTerm.PREFERRED)
                ;

    }
}
