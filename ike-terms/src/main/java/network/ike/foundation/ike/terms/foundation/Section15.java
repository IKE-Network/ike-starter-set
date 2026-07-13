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

/** The "Stated Definition" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section15 {

    private Section15() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Stated Definition (SOLOR)", PublicIds.of(UUID.fromString("28608bd3-ac73-4fe8-a5f0-1efe0d6650a8"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4ac3de47-2ea4-406a-96a2-129385e5cf24")), TinkarTerm.ENGLISH_LANGUAGE, "Stated Definition (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dc2ed861-13f8-4a9e-984d-0edf86f000ef")), TinkarTerm.ENGLISH_LANGUAGE, "Stated Definition", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("935ce770-058a-4b05-a2c2-89fc77f57186")), TinkarTerm.ENGLISH_LANGUAGE, "Relationships/Axioms of a concept that have been explicitly stated and defined", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c22fa836-9fff-445d-bba6-f31642db2a75")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "28608bd3-ac73-4fe8-a5f0-1efe0d6650a8")
                .statedAxioms(PublicIds.of(UUID.fromString("d4b6662b-53a8-5718-8782-a56db798cbf5")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("432c5259-6b3f-4c13-b3ae-71649a752d61")))
                .semanticOn(PublicIds.of(UUID.fromString("4ac3de47-2ea4-406a-96a2-129385e5cf24")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bd7ccfea-0515-4e03-9d20-32217847970e")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("dc2ed861-13f8-4a9e-984d-0edf86f000ef")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1914c19b-c017-400b-9316-6a924f991fbf")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("935ce770-058a-4b05-a2c2-89fc77f57186")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ea6e7687-b016-4e8d-9e78-639fd18ae536")), TinkarTerm.PREFERRED)
                ;

    }
}
