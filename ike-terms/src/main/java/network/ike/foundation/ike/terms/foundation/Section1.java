package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Uninitialized" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section1 {

    private Section1() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Uninitialized Component (SOLOR)", PublicIds.of(UUID.fromString("55f74246-0a25-57ac-9473-a788d08fb656"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f600187f-94a9-4baf-8b44-46baba8d928a")), KernelTerm.ENGLISH_LANGUAGE, "Uninitialized Component (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("85cc6d4d-f3f9-4744-9abc-afec0c478014")), KernelTerm.ENGLISH_LANGUAGE, "Uninitialized", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ec5b3c93-5008-401d-a2ea-1983fc93e78c")), KernelTerm.ENGLISH_LANGUAGE, "Not initialized component", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("2b08c0fc-e724-418b-baae-d8f772acd413")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "55f74246-0a25-57ac-9473-a788d08fb656")
                .statedAxioms(PublicIds.of(UUID.fromString("da159ba1-1726-52a3-b682-8468457b51c4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object (SOLOR)", PublicIds.of("72765109-6b53-3814-9b05-34ebddd16592"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a995602b-9524-40a5-9dc2-0e8e47a504a3")))
                .semanticOn(PublicIds.of(UUID.fromString("f600187f-94a9-4baf-8b44-46baba8d928a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("92450d02-be57-4d54-8298-980579967beb")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("85cc6d4d-f3f9-4744-9abc-afec0c478014")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7d9621b5-4056-483a-a628-5dda73db18b2")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ec5b3c93-5008-401d-a2ea-1983fc93e78c")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("856c1121-2256-4bae-8d29-6c8d91091b4b")), KernelTerm.PREFERRED)
                ;

    }
}
