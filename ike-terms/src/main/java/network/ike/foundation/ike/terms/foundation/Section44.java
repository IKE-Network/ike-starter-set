package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Version" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section44 {

    private Section44() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Concept version (SOLOR)", PublicIds.of("c202f992-3f4b-5f30-9b32-e376f68367d1")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8d25fae5-479c-4e12-9969-9d1b8ec4ab8b"), IkeTerm.ENGLISH_LANGUAGE, "Concept version (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("07cf84ba-7e48-4c15-80e1-19cfdde67c10"), IkeTerm.ENGLISH_LANGUAGE, "Version", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f64ca0ab-815a-4a82-9233-8d33f921119a"), IkeTerm.ENGLISH_LANGUAGE, "A filed that captures the version of the terminology that it came from", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("20f4c72c-b767-4544-b6a3-647f47b7d0e3"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c202f992-3f4b-5f30-9b32-e376f68367d1")
                .statedAxioms(PublicIds.of("00d53bf0-c4ed-57ab-91cf-21f9443d73b6"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("6739e8fc-e90b-4cd4-8364-1ebca33d3730"))
                .semanticOn(PublicIds.of("8d25fae5-479c-4e12-9969-9d1b8ec4ab8b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("35680315-8e26-433f-81ff-0b01663334c1"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("07cf84ba-7e48-4c15-80e1-19cfdde67c10"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d7aaf9ad-2c99-4645-90a1-c7482f26c7fb"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f64ca0ab-815a-4a82-9233-8d33f921119a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("caf85104-09a1-45d4-9398-e6b5683c3a71"), IkeTerm.PREFERRED)
                ;

    }
}
