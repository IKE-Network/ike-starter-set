package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Version" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section44 {

    private Section44() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Concept version (SOLOR)", PublicIds.of(UUID.fromString("c202f992-3f4b-5f30-9b32-e376f68367d1"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8d25fae5-479c-4e12-9969-9d1b8ec4ab8b")), TinkarTerm.ENGLISH_LANGUAGE, "Concept version (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("07cf84ba-7e48-4c15-80e1-19cfdde67c10")), TinkarTerm.ENGLISH_LANGUAGE, "Version", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f64ca0ab-815a-4a82-9233-8d33f921119a")), TinkarTerm.ENGLISH_LANGUAGE, "A filed that captures the version of the terminology that it came from", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("20f4c72c-b767-4544-b6a3-647f47b7d0e3")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c202f992-3f4b-5f30-9b32-e376f68367d1")
                .statedAxioms(PublicIds.of(UUID.fromString("00d53bf0-c4ed-57ab-91cf-21f9443d73b6")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6739e8fc-e90b-4cd4-8364-1ebca33d3730")))
                .semanticOn(PublicIds.of(UUID.fromString("8d25fae5-479c-4e12-9969-9d1b8ec4ab8b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("35680315-8e26-433f-81ff-0b01663334c1")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("07cf84ba-7e48-4c15-80e1-19cfdde67c10")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d7aaf9ad-2c99-4645-90a1-c7482f26c7fb")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f64ca0ab-815a-4a82-9233-8d33f921119a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("caf85104-09a1-45d4-9398-e6b5683c3a71")), TinkarTerm.PREFERRED)
                ;

    }
}
