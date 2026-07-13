package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Any component" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section57 {

    private Section57() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        set.concept("Any component (SOLOR)", PublicIds.of(UUID.fromString("927da7ac-3403-5ccc-b07b-88f60cc3a5f8"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("53a6e512-e8c0-443e-a8bd-1dd1ccc3fde8")), IkeTerm.ENGLISH_LANGUAGE, "Any component (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("263121e2-86bd-4cfa-a0d7-9c93b859a6b1")), IkeTerm.ENGLISH_LANGUAGE, "Any component", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("40345f82-efb9-4997-8d85-f384eb2ee454")), IkeTerm.ENGLISH_LANGUAGE, "A general-purpose container to represent any component with generic data structure. Modifiable based on the specific requirements and characteristics of the components.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("bff53e1c-061b-4cc7-9523-180230794ec1")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "927da7ac-3403-5ccc-b07b-88f60cc3a5f8")
                .statedAxioms(PublicIds.of(UUID.fromString("4ad09fae-0371-5c99-a348-62c1ff152fc7")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d664581c-fe62-482c-a7b7-5da02b3c697a")))
                .semanticOn(PublicIds.of(UUID.fromString("53a6e512-e8c0-443e-a8bd-1dd1ccc3fde8")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9d20aed3-7622-4106-a905-94728d009d1b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("263121e2-86bd-4cfa-a0d7-9c93b859a6b1")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3bf0cfea-007f-4ed4-8a1a-cd0df0721e5e")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("40345f82-efb9-4997-8d85-f384eb2ee454")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("65ef5326-4d06-4d8f-a246-9fa43f0fdddd")), IkeTerm.PREFERRED)
                ;

    }
}
