package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Data property set" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section50 {

    private Section50() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Data property set", PublicIds.of("6b8ed642-de72-4aee-953d-42e5db92c0ab")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d7d38c0b-78b8-41b7-abcb-3729885a764f"), IkeTerm.ENGLISH_LANGUAGE, "Data property set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a1f00e7b-fb74-4d79-a0a8-cd0c3e279e54"), IkeTerm.ENGLISH_LANGUAGE, "Data property set", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c6a25965-da90-4471-98f1-1bc2c0ad2fa9"), IkeTerm.ENGLISH_LANGUAGE, "The logical set grouping data-property axioms under a definition root. Mirrors LogicalAxiom.LogicalSet.DataPropertySet.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("cd9d66d6-d915-40db-bcd1-593ec6517cfe"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "53f866d0-fd61-5c85-a16c-150bd619a0ac")
                .statedAxioms(PublicIds.of("73ca869f-0593-5e07-8cf9-3516903fcf1d"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical set (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("6a8341c2-5049-4687-9264-2cf1c8b8e000"))
                .semanticOn(PublicIds.of("d7d38c0b-78b8-41b7-abcb-3729885a764f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cda49bc5-0c19-4452-bad8-afb3e91b3e51"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a1f00e7b-fb74-4d79-a0a8-cd0c3e279e54"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ac6dcdc2-8f82-4c29-b4ea-4d3fb66de3a4"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c6a25965-da90-4471-98f1-1bc2c0ad2fa9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2e5da358-10a5-446d-9b41-375af401c699"), IkeTerm.PREFERRED)
                ;

    }
}
