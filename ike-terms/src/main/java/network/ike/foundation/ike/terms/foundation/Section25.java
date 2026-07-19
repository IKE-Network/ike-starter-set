package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Value Constraint Source" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section25 {

    private Section25() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Value Constraint Source (SOLOR)", PublicIds.of(UUID.fromString("09aa031a-6290-4ec9-a44c-23928a767da3"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5a2b4035-b9b2-4ba7-94cc-2247d9da4ac7")), IkeTerm.ENGLISH_LANGUAGE, "Value Constraint Source (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("eefbcfa3-a607-4ffa-9f1e-e31ae15e84d1")), IkeTerm.ENGLISH_LANGUAGE, "Value Constraint Source", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("048579fe-498b-4a26-89d0-022a3ac8b457")), IkeTerm.ENGLISH_LANGUAGE, "The source organization of that specifies the constraint", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("3225f0d3-5552-4a55-9152-659b7f0cedca")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "09aa031a-6290-4ec9-a44c-23928a767da3")
                .statedAxioms(PublicIds.of(UUID.fromString("cb07bca1-ec7c-5cee-9f36-631b9bbf6a70")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("b64c734a-a62c-44fe-a8ea-ac10d52d8eb4")))
                .semanticOn(PublicIds.of(UUID.fromString("5a2b4035-b9b2-4ba7-94cc-2247d9da4ac7")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("23a9f3e6-155e-4373-8467-2494031f8d06")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("eefbcfa3-a607-4ffa-9f1e-e31ae15e84d1")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("aa7b524f-1863-4f8d-a347-3d999f052616")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("048579fe-498b-4a26-89d0-022a3ac8b457")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("266afb7f-aada-456a-b84a-5a1ce1cc4917")), IkeTerm.PREFERRED)
                ;

    }
}
