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

/** The "Is a" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section52 {

    private Section52() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Is-a", PublicIds.of(UUID.fromString("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25"), UUID.fromString("46bccdc4-8fb6-11db-b606-0800200c9a66"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b18eb010-2033-45e9-8691-ae408aca8a18")), TinkarTerm.ENGLISH_LANGUAGE, "Is-a", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d6666e7a-cc14-4cfd-b9a0-057948862a19")), TinkarTerm.ENGLISH_LANGUAGE, "Is a", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("edb22f1b-47f8-4e30-aba0-648b62ace8ca")), TinkarTerm.ENGLISH_LANGUAGE, "Designates the parent child relationship", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("8cdfb6bd-5b4e-4f0e-9f47-01d0b508b28c")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c93a30b9-ba77-3adb-a9b8-4589c9f8fb25")
                .statedAxioms(PublicIds.of(UUID.fromString("30e6715e-e330-58e6-bddf-3601625b76c7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("337c47d2-1953-4f0d-934b-f1d927081b99")))
                .semanticOn(PublicIds.of(UUID.fromString("b18eb010-2033-45e9-8691-ae408aca8a18")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8bcc501c-a490-4c80-bf38-950a48d4dbe4")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d6666e7a-cc14-4cfd-b9a0-057948862a19")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ddd08cb7-1fef-4482-89a9-30567b87ed45")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("edb22f1b-47f8-4e30-aba0-648b62ace8ca")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("66a52bb6-4b88-4dad-949d-cf1f572be8b9")), TinkarTerm.PREFERRED)
                ;

    }
}
