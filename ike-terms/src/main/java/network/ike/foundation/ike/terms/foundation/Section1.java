package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Uninitialized" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section1 {

    private Section1() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Uninitialized Component (SOLOR)", PublicIds.of("55f74246-0a25-57ac-9473-a788d08fb656")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f600187f-94a9-4baf-8b44-46baba8d928a"), IkeTerm.ENGLISH_LANGUAGE, "Uninitialized Component (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("85cc6d4d-f3f9-4744-9abc-afec0c478014"), IkeTerm.ENGLISH_LANGUAGE, "Uninitialized", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ec5b3c93-5008-401d-a2ea-1983fc93e78c"), IkeTerm.ENGLISH_LANGUAGE, "Not initialized component", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("2b08c0fc-e724-418b-baae-d8f772acd413"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "55f74246-0a25-57ac-9473-a788d08fb656")
                .statedAxioms(PublicIds.of("da159ba1-1726-52a3-b682-8468457b51c4"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("a995602b-9524-40a5-9dc2-0e8e47a504a3"))
                .semanticOn(PublicIds.of("f600187f-94a9-4baf-8b44-46baba8d928a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("92450d02-be57-4d54-8298-980579967beb"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("85cc6d4d-f3f9-4744-9abc-afec0c478014"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7d9621b5-4056-483a-a628-5dda73db18b2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ec5b3c93-5008-401d-a2ea-1983fc93e78c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("856c1121-2256-4bae-8d29-6c8d91091b4b"), IkeTerm.PREFERRED)
                ;

    }
}
