package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelConcept;
import dev.ikm.tinkar.terms.KernelPattern;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Description semantic" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section54 {

    private Section54() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Description semantic", PublicIds.of(UUID.fromString("81487d5f-6115-51e2-a3b3-93d783888eb8"))).at(inception)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("733ddf1e-145a-4ffc-b508-361680cddda9")), KernelConcept.ENGLISH_LANGUAGE, "Description semantic", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("be79bc92-ec04-4d33-be2b-b28c957082d9")), KernelConcept.ENGLISH_LANGUAGE, "Description semantic", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelPattern.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6fc11328-1eb6-4448-986c-57a9e517ff83")), KernelConcept.ENGLISH_LANGUAGE, "Purpose and meaning for the description pattern and dialect patterns", KernelConcept.DESCRIPTION_NOT_CASE_SENSITIVE, KernelConcept.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelPattern.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("ea291134-be63-48ff-afbe-e0b687ffa70d")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "81487d5f-6115-51e2-a3b3-93d783888eb8")
                .statedAxioms(PublicIds.of(UUID.fromString("4559c6fb-e128-5a4d-b6a9-bd3e9138b2e0")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"))))))
                .semantic(KernelPattern.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("39c53be7-7739-478e-bab8-c61aa7facaed")))
                .semanticOn(PublicIds.of(UUID.fromString("733ddf1e-145a-4ffc-b508-361680cddda9")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("614536d2-633d-4fb1-831c-e5c4d850905a")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("be79bc92-ec04-4d33-be2b-b28c957082d9")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f2c19f45-567f-45d5-aafc-90c3a89b23f6")), KernelConcept.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6fc11328-1eb6-4448-986c-57a9e517ff83")), KernelPattern.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("74c8d3a7-2814-4908-9fd3-c41435b1734b")), KernelConcept.PREFERRED)
                ;

    }
}
