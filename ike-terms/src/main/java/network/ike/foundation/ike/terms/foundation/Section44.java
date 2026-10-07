package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Version" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section44 {

    private Section44() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Concept version (SOLOR)", PublicIds.of(UUID.fromString("c202f992-3f4b-5f30-9b32-e376f68367d1"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8d25fae5-479c-4e12-9969-9d1b8ec4ab8b")), KernelTerm.ENGLISH_LANGUAGE, "Concept version (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("07cf84ba-7e48-4c15-80e1-19cfdde67c10")), KernelTerm.ENGLISH_LANGUAGE, "Version", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f64ca0ab-815a-4a82-9233-8d33f921119a")), KernelTerm.ENGLISH_LANGUAGE, "A filed that captures the version of the terminology that it came from", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("20f4c72c-b767-4544-b6a3-647f47b7d0e3")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "c202f992-3f4b-5f30-9b32-e376f68367d1")
                .statedAxioms(PublicIds.of(UUID.fromString("00d53bf0-c4ed-57ab-91cf-21f9443d73b6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6739e8fc-e90b-4cd4-8364-1ebca33d3730")))
                .semanticOn(PublicIds.of(UUID.fromString("8d25fae5-479c-4e12-9969-9d1b8ec4ab8b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("35680315-8e26-433f-81ff-0b01663334c1")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("07cf84ba-7e48-4c15-80e1-19cfdde67c10")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d7aaf9ad-2c99-4645-90a1-c7482f26c7fb")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f64ca0ab-815a-4a82-9233-8d33f921119a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("caf85104-09a1-45d4-9398-e6b5683c3a71")), KernelTerm.PREFERRED)
                ;

    }
}
