package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Native Identifier" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section58 {

    private Section58() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("NID (SOLOR)", PublicIds.of(UUID.fromString("d1a17272-9785-51aa-8bde-cc556ab32ebb"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("12912da5-305a-44a0-ac4f-2b231863480f")), KernelTerm.ENGLISH_LANGUAGE, "NID (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("56ac1e29-4b8f-4bb3-9ee8-1cc5d18b0196")), KernelTerm.ENGLISH_LANGUAGE, "Native Identifier", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7d5321fe-8f3e-4fce-a360-aa66406d54e9")), KernelTerm.ENGLISH_LANGUAGE, "Data type", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("722b1d3c-d7b4-4ecd-8a78-fdaaed924457")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "d1a17272-9785-51aa-8bde-cc556ab32ebb")
                .statedAxioms(PublicIds.of(UUID.fromString("b46a332e-33db-5f04-85e7-baa5d63227a8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object (SOLOR)", PublicIds.of("72765109-6b53-3814-9b05-34ebddd16592"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0ad01e4b-9661-4cf2-981e-c67b7aff014b")))
                .semanticOn(PublicIds.of(UUID.fromString("12912da5-305a-44a0-ac4f-2b231863480f")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("13f035c5-90b3-4203-913a-90c8cd17c957")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("56ac1e29-4b8f-4bb3-9ee8-1cc5d18b0196")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8d71faac-ff15-45c8-9031-ad09eceda32b")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7d5321fe-8f3e-4fce-a360-aa66406d54e9")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e56152b7-5ae5-4733-af91-ac700fde5a5d")), KernelTerm.PREFERRED)
                ;

    }
}
