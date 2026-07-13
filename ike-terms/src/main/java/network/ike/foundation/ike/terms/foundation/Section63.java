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

/** The "Creative Commons BY license" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section63 {

    private Section63() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Creative Commons BY license (SOLOR)", PublicIds.of(UUID.fromString("3415a972-7850-57cd-aa86-a572ca1c2ceb"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("432005a0-0bbb-40ae-a69a-7600fb22dd10")), TinkarTerm.ENGLISH_LANGUAGE, "Creative Commons BY license (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dbbdb8c5-fdb8-48df-b6a0-8a857b39cb81")), TinkarTerm.ENGLISH_LANGUAGE, "Creative Commons BY license", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6901610c-5921-411f-b513-4bc507541d94")), TinkarTerm.ENGLISH_LANGUAGE, "Creative Commons (CC) licenses are a set of public copyright licenses that enable the free distribution of an otherwise copyrighted work", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("edcfc1bf-bda2-4915-aa43-08b68306fcfd")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "3415a972-7850-57cd-aa86-a572ca1c2ceb")
                .statedAxioms(PublicIds.of(UUID.fromString("d27af530-31d3-5921-8f87-f4e3f0467593")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ROOT_VERTEX))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8af204ce-df5e-49c5-90d9-bbcb33d1bcce")))
                .semanticOn(PublicIds.of(UUID.fromString("432005a0-0bbb-40ae-a69a-7600fb22dd10")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("a28c4ee7-6d15-4f8b-b147-17f62bed2f8b")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("dbbdb8c5-fdb8-48df-b6a0-8a857b39cb81")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d79aa106-6c7f-4e64-9fb5-82d627e7547e")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6901610c-5921-411f-b513-4bc507541d94")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3aa49fae-5f58-4b46-b3ea-8fbcede2ebd3")), TinkarTerm.PREFERRED)
                ;

    }
}
