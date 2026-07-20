package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Stated Definition" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section15 {

    private Section15() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Stated Definition (SOLOR)", PublicIds.of("28608bd3-ac73-4fe8-a5f0-1efe0d6650a8")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4ac3de47-2ea4-406a-96a2-129385e5cf24"), IkeTerm.ENGLISH_LANGUAGE, "Stated Definition (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("dc2ed861-13f8-4a9e-984d-0edf86f000ef"), IkeTerm.ENGLISH_LANGUAGE, "Stated Definition", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("935ce770-058a-4b05-a2c2-89fc77f57186"), IkeTerm.ENGLISH_LANGUAGE, "Relationships/Axioms of a concept that have been explicitly stated and defined", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("c22fa836-9fff-445d-bba6-f31642db2a75"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "28608bd3-ac73-4fe8-a5f0-1efe0d6650a8")
                .statedAxioms(PublicIds.of("d4b6662b-53a8-5718-8782-a56db798cbf5"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("432c5259-6b3f-4c13-b3ae-71649a752d61"))
                .semanticOn(PublicIds.of("4ac3de47-2ea4-406a-96a2-129385e5cf24"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bd7ccfea-0515-4e03-9d20-32217847970e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("dc2ed861-13f8-4a9e-984d-0edf86f000ef"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1914c19b-c017-400b-9316-6a924f991fbf"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("935ce770-058a-4b05-a2c2-89fc77f57186"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ea6e7687-b016-4e8d-9e78-639fd18ae536"), IkeTerm.PREFERRED)
                ;

    }
}
