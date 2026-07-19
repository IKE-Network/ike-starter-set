package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Native Identifier" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section58 {

    private Section58() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("NID (SOLOR)", PublicIds.of(UUID.fromString("d1a17272-9785-51aa-8bde-cc556ab32ebb"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("12912da5-305a-44a0-ac4f-2b231863480f")), IkeTerm.ENGLISH_LANGUAGE, "NID (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("56ac1e29-4b8f-4bb3-9ee8-1cc5d18b0196")), IkeTerm.ENGLISH_LANGUAGE, "Native Identifier", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7d5321fe-8f3e-4fce-a360-aa66406d54e9")), IkeTerm.ENGLISH_LANGUAGE, "Data type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("722b1d3c-d7b4-4ecd-8a78-fdaaed924457")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "d1a17272-9785-51aa-8bde-cc556ab32ebb")
                .statedAxioms(PublicIds.of(UUID.fromString("b46a332e-33db-5f04-85e7-baa5d63227a8")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("0ad01e4b-9661-4cf2-981e-c67b7aff014b")))
                .semanticOn(PublicIds.of(UUID.fromString("12912da5-305a-44a0-ac4f-2b231863480f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("13f035c5-90b3-4203-913a-90c8cd17c957")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("56ac1e29-4b8f-4bb3-9ee8-1cc5d18b0196")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8d71faac-ff15-45c8-9031-ad09eceda32b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7d5321fe-8f3e-4fce-a360-aa66406d54e9")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e56152b7-5ae5-4733-af91-ac700fde5a5d")), IkeTerm.PREFERRED)
                ;

    }
}
