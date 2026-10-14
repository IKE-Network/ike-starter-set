package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Description-logic profile" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section12 {

    private Section12() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description-logic profile (SOLOR)", PublicIds.of(UUID.fromString("14eadb10-fbd0-5999-af37-05728a8503af"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f312cb55-2104-483e-8dcf-9fddf944550a")), KernelTerm.ENGLISH_LANGUAGE, "Description-logic profile (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5e59b5f6-353d-4297-b1a0-e8cdd42f8664")), KernelTerm.ENGLISH_LANGUAGE, "Description-logic profile", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f57a49ab-d651-4061-996a-8cef9dac1627")), KernelTerm.ENGLISH_LANGUAGE, "Description-logic profile", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("188ab10f-7a9d-42c5-a9c8-d05ec409fdd6")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "14eadb10-fbd0-5999-af37-05728a8503af")
                .statedAxioms(PublicIds.of(UUID.fromString("d351e33f-6494-56e5-9289-b0eb650dcd79")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8ba07217-ecbf-46a8-a3a2-4466e8522845")))
                .semanticOn(PublicIds.of(UUID.fromString("f312cb55-2104-483e-8dcf-9fddf944550a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("14d4db6d-3d41-473d-8ef0-b24bfb601a29")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5e59b5f6-353d-4297-b1a0-e8cdd42f8664")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("50c3d42b-2781-43bc-8b9a-328756e91f27")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f57a49ab-d651-4061-996a-8cef9dac1627")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ad7eb0fb-1615-44bb-adbf-f63674086597")), KernelTerm.PREFERRED)
                ;

        set.concept("EL++ logic profile (SOLOR)", PublicIds.of(UUID.fromString("1f201e12-960e-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("50877775-d8e3-47ea-b720-e9ad7f594cea")), KernelTerm.ENGLISH_LANGUAGE, "EL++ logic profile (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("88e752f6-d809-4b14-a2aa-eac57d1cab48")), KernelTerm.ENGLISH_LANGUAGE, "EL ++ logic profile", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("67d1b85b-b4c8-4d13-bfe6-bfba8144c528")), KernelTerm.ENGLISH_LANGUAGE, "EL ++ profile", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("186e1a51-1c91-4d8d-94f1-ef3f1fd7c7c7")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "1f201e12-960e-11e5-8994-feff819cdc9f")
                .statedAxioms(PublicIds.of(UUID.fromString("fb1af2fa-d384-58b8-9cf0-f3e00ee88afe")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Description-logic profile (SOLOR)", PublicIds.of("14eadb10-fbd0-5999-af37-05728a8503af"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("1352fa09-de8f-4b94-bc70-cdfb5cc961e9")))
                .semanticOn(PublicIds.of(UUID.fromString("50877775-d8e3-47ea-b720-e9ad7f594cea")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e67a8a3d-5ed7-47e6-ab5a-1e1451e7ce7c")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("88e752f6-d809-4b14-a2aa-eac57d1cab48")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("df1f38d4-b3ff-4dd3-a659-0cb029eac2db")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("67d1b85b-b4c8-4d13-bfe6-bfba8144c528")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("264857b1-70ed-40f9-83fe-d41935a668b5")), KernelTerm.PREFERRED)
                ;

    }
}
