package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Reflexive Feature" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section43 {

    private Section43() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Reflexive Feature (SOLOR)", PublicIds.of(UUID.fromString("7e779e4a-61ed-5c4a-aacc-03cf524b7c73"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8131e0b2-e9bf-43c5-b321-0b51a69f281c")), IkeTerm.ENGLISH_LANGUAGE, "Reflexive Feature (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("abed5968-5462-45ea-a0ae-64ddd5a16cc2")), IkeTerm.ENGLISH_LANGUAGE, "Reflexive Feature", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ea03caa6-658a-438c-bd46-0a14833d5c57")), IkeTerm.ENGLISH_LANGUAGE, "Reflexive property (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4d9b5297-ca69-4231-a399-9130c55d9009")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "7e779e4a-61ed-5c4a-aacc-03cf524b7c73")
                .statedAxioms(PublicIds.of(UUID.fromString("e217e187-27f3-5687-9407-05c2c61865d2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("6cd31ea8-0b07-44d3-b769-6dc3d8361258")))
                .semanticOn(PublicIds.of(UUID.fromString("8131e0b2-e9bf-43c5-b321-0b51a69f281c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f8c628f6-133d-4066-8400-344c429f7e3e")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("abed5968-5462-45ea-a0ae-64ddd5a16cc2")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8604aed2-51ad-419c-83c3-9ec1a6f4199a")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ea03caa6-658a-438c-bd46-0a14833d5c57")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("c0842297-0fb5-4c34-8135-02b717d8bd8b")), IkeTerm.PREFERRED)
                ;

    }
}
