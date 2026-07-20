package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Laterality" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section17 {

    private Section17() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Laterality (SOLOR)", PublicIds.of("26ca4590-bbe5-327c-a40a-ba56dc86996b")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("960f2aa1-4844-4b6c-aadb-15a2c8b62596"), IkeTerm.ENGLISH_LANGUAGE, "Laterality (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f6eb6e3e-09de-47a7-be73-141527d6d5f1"), IkeTerm.ENGLISH_LANGUAGE, "Laterality", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3622b35a-e8b8-48e0-afdb-4179c7061ac9"), IkeTerm.ENGLISH_LANGUAGE, "A domain role type from the anatomy model: distinguishes sided body structures, left from right. Held as a SNOMED-heritage example; migrates to a domain starter set when one exists.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("17f1d7ea-056b-4801-a9e1-117dbb5f3ca6"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "26ca4590-bbe5-327c-a40a-ba56dc86996b")
                .statedAxioms(PublicIds.of("a531fcdd-db58-5110-8303-7a90d8539dbb"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROLE_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5db743cf-d96b-4d9a-8027-32f5d77d387b"))
                .semanticOn(PublicIds.of("960f2aa1-4844-4b6c-aadb-15a2c8b62596"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0f9553b5-1ec4-41ef-9562-6ff543000e8e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f6eb6e3e-09de-47a7-be73-141527d6d5f1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b5a4edc8-0478-4c47-adf0-407ab3730b0a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("3622b35a-e8b8-48e0-afdb-4179c7061ac9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("8e2f523d-e4bb-4ce7-85ca-b9637ba24d78"), IkeTerm.PREFERRED)
                ;

    }
}
