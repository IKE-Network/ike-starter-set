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

/** The "Model concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section55 {

    private Section55() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Model concept", PublicIds.of(UUID.fromString("7bbd4210-381c-11e7-9598-0800200c9a66"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("639d8025-5286-44cb-a8fe-4e87f033c25e")), TinkarTerm.ENGLISH_LANGUAGE, "Model concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bd0901b6-5c08-4b7d-81b8-110be13bfaa5")), TinkarTerm.ENGLISH_LANGUAGE, "Model concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3e65ef28-f915-4773-beb5-a068361499b3")), TinkarTerm.ENGLISH_LANGUAGE, "", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("7e8070d0-9b18-4384-8074-d12c452963a1")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "7bbd4210-381c-11e7-9598-0800200c9a66")
                .statedAxioms(PublicIds.of(UUID.fromString("a9225dbd-f1c9-5e52-92b8-e768945b3169")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ROOT_VERTEX))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a434b875-ed97-4264-aaff-ce353993d7a7")))
                .semanticOn(PublicIds.of(UUID.fromString("639d8025-5286-44cb-a8fe-4e87f033c25e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("28fb2d1b-e939-4dfe-a243-7db4f33d8591")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("bd0901b6-5c08-4b7d-81b8-110be13bfaa5")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4f2ee495-e3bb-48f9-a391-53efd540d1b2")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3e65ef28-f915-4773-beb5-a068361499b3")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("780dcd09-eadd-4032-b4d9-cc204a4a0511")), TinkarTerm.PREFERRED)
                ;

    }
}
