package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Description" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section37 {

    private Section37() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description", PublicIds.of("87118daf-d28c-55fb-8657-cd6bc8425600")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e9863727-dda4-4c11-8c2d-3ddea5dadb83"), IkeTerm.ENGLISH_LANGUAGE, "Description", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d9801961-828b-47d9-b775-b52c6b80b478"), IkeTerm.ENGLISH_LANGUAGE, "Description", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2c6412c9-53c7-40f2-9771-b0ccd8333f4e"), IkeTerm.ENGLISH_LANGUAGE, "Human readable text for a concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("2b72794b-b10a-4adb-9285-6b7fce096309"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "87118daf-d28c-55fb-8657-cd6bc8425600")
                .statedAxioms(PublicIds.of("2f6ecd40-16c2-554d-8441-985afe25f358"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("676919e8-7ccf-415d-963f-b0e78cd99d17"))
                .semanticOn(PublicIds.of("e9863727-dda4-4c11-8c2d-3ddea5dadb83"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bfdd0fae-bdc7-4333-a700-3998efa2b458"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d9801961-828b-47d9-b775-b52c6b80b478"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cc5b9189-57f2-4c49-af84-7dfdb249b1e2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2c6412c9-53c7-40f2-9771-b0ccd8333f4e"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4ee3b494-09ba-4711-b26a-ec1d0f9bf748"), IkeTerm.PREFERRED)
                ;

    }
}
