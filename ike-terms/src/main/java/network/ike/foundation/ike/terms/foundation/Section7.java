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

/** The "Tinkar Model concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section7 {

    private Section7() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Tinkar Model concept", PublicIds.of(UUID.fromString("bc59d656-83d3-47d8-9507-0e656ea95463"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("04f9eada-89fa-4c54-ac2f-3697c1bd937a")), TinkarTerm.ENGLISH_LANGUAGE, "Tinkar Model concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f68dbfb0-d8d2-465c-8cb0-5088da74144f")), TinkarTerm.ENGLISH_LANGUAGE, "Tinkar Model concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("06d1eb76-87b4-440a-98c1-d0037f76a936")), TinkarTerm.ENGLISH_LANGUAGE, "", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0ba9dda8-74e9-4a72-a8be-2addeadee1dd")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "bc59d656-83d3-47d8-9507-0e656ea95463")
                .statedAxioms(PublicIds.of(UUID.fromString("1a9cf116-2c51-50b4-9b38-55c1264921d9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7fee622c-f65d-41bc-9d35-99d6398d5cb8")))
                .semanticOn(PublicIds.of(UUID.fromString("04f9eada-89fa-4c54-ac2f-3697c1bd937a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7782072d-6b16-4256-a491-eaf44e501ccb")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f68dbfb0-d8d2-465c-8cb0-5088da74144f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b33c6112-7244-4e35-88c2-756dbd8a0319")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("06d1eb76-87b4-440a-98c1-d0037f76a936")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f04321f0-95ae-4cf8-8bc8-4a906ac83313")), TinkarTerm.PREFERRED)
                ;

    }
}
