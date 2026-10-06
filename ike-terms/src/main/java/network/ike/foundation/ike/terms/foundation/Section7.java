package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "IKE base model concept" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section7 {

    private Section7() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        // Declared FQN diverges from the baseline artifact (was "Tinkar Model concept (SOLOR)"):
        // the base model is IKE's; registered in DELIBERATELY_RENAMED_FQNS
        // (IKE-Network/ike-issues#1124).
        set.concept("IKE base model concept", PublicIds.of(UUID.fromString("bc59d656-83d3-47d8-9507-0e656ea95463"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("04f9eada-89fa-4c54-ac2f-3697c1bd937a")), KernelTerm.ENGLISH_LANGUAGE, "IKE base model concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f68dbfb0-d8d2-465c-8cb0-5088da74144f")), KernelTerm.ENGLISH_LANGUAGE, "IKE base model concept", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: one-rigorous-term revision in place (IKE-Network/ike-issues#893, #894).
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("06d1eb76-87b4-440a-98c1-d0037f76a936")), KernelTerm.ENGLISH_LANGUAGE, "Root of the base model's own terminology: the concepts the base model uses to describe itself — components, descriptions, dialects, fields, and axioms — rather than any modeled domain.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0ba9dda8-74e9-4a72-a8be-2addeadee1dd")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "bc59d656-83d3-47d8-9507-0e656ea95463")
                .statedAxioms(PublicIds.of(UUID.fromString("1a9cf116-2c51-50b4-9b38-55c1264921d9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Model concept (SOLOR)", PublicIds.of("7bbd4210-381c-11e7-9598-0800200c9a66"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("7fee622c-f65d-41bc-9d35-99d6398d5cb8")))
                .semanticOn(PublicIds.of(UUID.fromString("04f9eada-89fa-4c54-ac2f-3697c1bd937a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7782072d-6b16-4256-a491-eaf44e501ccb")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f68dbfb0-d8d2-465c-8cb0-5088da74144f")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b33c6112-7244-4e35-88c2-756dbd8a0319")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("06d1eb76-87b4-440a-98c1-d0037f76a936")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f04321f0-95ae-4cf8-8bc8-4a906ac83313")), KernelTerm.PREFERRED)
                ;

    }
}
