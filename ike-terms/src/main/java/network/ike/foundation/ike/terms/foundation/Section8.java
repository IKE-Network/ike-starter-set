package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Identifier Value" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section8 {

    private Section8() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Identifier Value (SOLOR)", PublicIds.of("b32dd26b-c3fc-487e-987e-16ace71a0d0f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("30feb16d-f515-42a4-920e-aeaa7706e4f3"), IkeTerm.ENGLISH_LANGUAGE, "Identifier Value (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9d6c5a02-fd9e-4dbe-b02a-6c7008612c0b"), IkeTerm.ENGLISH_LANGUAGE, "Identifier Value", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2ce31162-c756-4e73-84da-ae6337f8d9f4"), IkeTerm.ENGLISH_LANGUAGE, "The literal string value identifier", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("ff1246ef-f25a-4623-8f4a-2117bc07c61b"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b32dd26b-c3fc-487e-987e-16ace71a0d0f")
                .statedAxioms(PublicIds.of("3d08c515-d4de-5236-adda-9e81993d6751"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("c735f799-4a85-42e2-82a4-5b72172facf7"))
                .semanticOn(PublicIds.of("30feb16d-f515-42a4-920e-aeaa7706e4f3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("648175c8-df7f-4348-a26f-5d160bccab96"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9d6c5a02-fd9e-4dbe-b02a-6c7008612c0b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("43baca0f-f17d-45c7-b729-fb5b54cdad2b"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2ce31162-c756-4e73-84da-ae6337f8d9f4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("36b967de-d261-48c1-bb11-94b0a9470119"), IkeTerm.PREFERRED)
                ;

    }
}
