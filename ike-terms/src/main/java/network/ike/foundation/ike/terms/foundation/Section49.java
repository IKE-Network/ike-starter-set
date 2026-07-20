package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Annotation property set" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section49 {

    private Section49() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Annotation property set", PublicIds.of("cb9e33de-f82c-495d-89fa-69afecbcd47d")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("69be3ae3-6f24-42ae-819e-a91a69959ab4"), IkeTerm.ENGLISH_LANGUAGE, "Annotation property set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c85fd08c-f0ba-4058-a963-738bcefb7c1b"), IkeTerm.ENGLISH_LANGUAGE, "Annotation property set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("da5b80d1-b026-4416-a21e-8d023580ea9b"), IkeTerm.ENGLISH_LANGUAGE, "The OWL annotation-property grouping: properties that annotate content without logical consequence, carried for OWL interchange.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("788c7955-1d9d-4de4-921d-77b723337b63"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "53f866d0-fd61-5c85-a16c-150bd619a0ac")
                .statedAxioms(PublicIds.of("d00a01be-fc68-5e82-af39-0b4cb2893e4f"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical expression model (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("e92b2100-73ca-4999-bdbe-ae39a3060bf7"))
                .semanticOn(PublicIds.of("69be3ae3-6f24-42ae-819e-a91a69959ab4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3b7cfed5-8b3e-4a5d-a4c0-4b78c5d3bf48"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c85fd08c-f0ba-4058-a963-738bcefb7c1b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("659c28c7-ac72-4fd8-a9da-7dd265560607"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("da5b80d1-b026-4416-a21e-8d023580ea9b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cb113102-65c1-4b7e-af8b-ecd26e46cae4"), IkeTerm.PREFERRED)
                ;

    }
}
