package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Tinkar Model concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section7 {

    private Section7() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Tinkar Model concept", PublicIds.of(UUID.fromString("bc59d656-83d3-47d8-9507-0e656ea95463"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("04f9eada-89fa-4c54-ac2f-3697c1bd937a")), IkeTerm.ENGLISH_LANGUAGE, "Tinkar Model concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f68dbfb0-d8d2-465c-8cb0-5088da74144f")), IkeTerm.ENGLISH_LANGUAGE, "Tinkar Model concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: one-rigorous-term revision in place (IKE-Network/ike-issues#893, #894).
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("06d1eb76-87b4-440a-98c1-d0037f76a936")), IkeTerm.ENGLISH_LANGUAGE, "Root of Tinkar's own meta-schema terminology: the concepts Tinkar uses to describe its data model itself — components, descriptions, dialects, fields, and axioms — rather than any modeled domain.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0ba9dda8-74e9-4a72-a8be-2addeadee1dd")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "bc59d656-83d3-47d8-9507-0e656ea95463")
                .statedAxioms(PublicIds.of(UUID.fromString("1a9cf116-2c51-50b4-9b38-55c1264921d9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7fee622c-f65d-41bc-9d35-99d6398d5cb8")))
                .semanticOn(PublicIds.of(UUID.fromString("04f9eada-89fa-4c54-ac2f-3697c1bd937a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7782072d-6b16-4256-a491-eaf44e501ccb")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f68dbfb0-d8d2-465c-8cb0-5088da74144f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b33c6112-7244-4e35-88c2-756dbd8a0319")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("06d1eb76-87b4-440a-98c1-d0037f76a936")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f04321f0-95ae-4cf8-8bc8-4a906ac83313")), IkeTerm.PREFERRED)
                ;

    }
}
