package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Description list for concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section62 {

    private Section62() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description list for concept (SOLOR)", PublicIds.of("ab3e8771-7c7c-5e57-8acf-147b16da36e2")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("dfe94b0f-e321-4652-b136-567216d9fa5b"), IkeTerm.ENGLISH_LANGUAGE, "Description list for concept (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("000803ce-c2f5-450c-bea0-1452812cc4bc"), IkeTerm.ENGLISH_LANGUAGE, "Description list for concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("57be3396-cf3f-40f7-ba9f-c6ba0b6b4239"), IkeTerm.ENGLISH_LANGUAGE, "The field holding every description attached to a concept, so a rendering surface can choose among them by language, dialect, and type.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("070e006c-e1d2-41e7-9bdd-889f1423cdb2"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ab3e8771-7c7c-5e57-8acf-147b16da36e2")
                .statedAxioms(PublicIds.of("9c152a95-cb08-53a5-8159-3862aabb925a"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("ccc34d44-230c-4fd2-8ee9-c4dd459b3372"))
                .semanticOn(PublicIds.of("dfe94b0f-e321-4652-b136-567216d9fa5b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d5585846-bb39-481d-b372-192ecc05ed9f"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("000803ce-c2f5-450c-bea0-1452812cc4bc"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("08a02bd1-4617-4f8b-9803-dce23e3ed75d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("57be3396-cf3f-40f7-ba9f-c6ba0b6b4239"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b886cc86-ce36-4687-87c1-bea89a9b7c39"), IkeTerm.PREFERRED)
                ;

    }
}
