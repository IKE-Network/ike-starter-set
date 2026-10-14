package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Logic coordinate properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section22 {

    private Section22() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Logic coordinate properties (SOLOR)", PublicIds.of(UUID.fromString("1fa63819-5ac1-5938-95b1-47871a5f2b17"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bc1a1259-121e-4ef0-8964-d6740761ab0e")), KernelTerm.ENGLISH_LANGUAGE, "Logic coordinate properties (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6036c822-8ee6-462b-9e66-2f5c627384f8")), KernelTerm.ENGLISH_LANGUAGE, "Logic coordinate properties", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("54fa5cec-2dfa-468c-9d90-9d48ed7e9171")), KernelTerm.ENGLISH_LANGUAGE, "The dimensions of the logic coordinate — how a view reasons: the profile, the classifier, the root, the stated and inferred patterns, the concepts to classify, and the result digraph. A model concept grouping those dimensions, and part of the view coordinate model — stated logically as a Part of restriction.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("3b3bc09e-b0d3-44e1-a2f1-f0b6354c639d")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "1fa63819-5ac1-5938-95b1-47871a5f2b17")
                .statedAxioms(PublicIds.of(UUID.fromString("9fc148d7-7435-5d81-ac30-1920d697e039")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)")), leb.SomeRole(EntityProxy.Concept.make("Part of (SOLOR)", PublicIds.of("b4c3f6f9-6937-30fd-8412-d0c77f8a7f73")), leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("61d88335-a658-40c5-a92f-d63ef7343f5d")))
                .semanticOn(PublicIds.of(UUID.fromString("bc1a1259-121e-4ef0-8964-d6740761ab0e")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5faac4a1-e121-4ee9-a727-fb35c2a9a4ee")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6036c822-8ee6-462b-9e66-2f5c627384f8")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2e672c86-4105-4cb5-931f-a9bf7f64ef6b")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("54fa5cec-2dfa-468c-9d90-9d48ed7e9171")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2d2d6bc3-99e3-427d-a710-7004d1d82b7a")), KernelTerm.PREFERRED)
                ;

        set.concept("Module origins (SOLOR)", PublicIds.of(UUID.fromString("462862d4-5df9-426e-b785-a1264e24769f"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a3cf1284-f9ab-4cd9-ba4f-340218b31490")), KernelTerm.ENGLISH_LANGUAGE, "Module origins (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("664b13d0-506f-4f95-823b-c94369ec0d0b")), KernelTerm.ENGLISH_LANGUAGE, "Module origins", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("899291eb-daea-40c6-8f5f-6f939d0d5a47")), KernelTerm.ENGLISH_LANGUAGE, "The origin-set value a Module origins pattern semantic carries: the set of modules a module originated from — what the pattern's one field holds, distinct from Originated Module, the module whose origins are declared.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("711e9637-5d8a-4f22-a430-5dde79b4dbaf")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "462862d4-5df9-426e-b785-a1264e24769f")
                .statedAxioms(PublicIds.of(UUID.fromString("89439dbb-6bbb-5a13-b407-1ea42986f6b2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Logic coordinate properties (SOLOR)", PublicIds.of("1fa63819-5ac1-5938-95b1-47871a5f2b17"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a324bfb5-1828-4f34-adcd-7fb01c133b4e")))
                .semanticOn(PublicIds.of(UUID.fromString("a3cf1284-f9ab-4cd9-ba4f-340218b31490")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2c7d1f18-0c98-4186-bc7a-6f8141bf0bc8")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("664b13d0-506f-4f95-823b-c94369ec0d0b")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("835eb207-4b81-49dc-b159-ae4cea65eab5")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("899291eb-daea-40c6-8f5f-6f939d0d5a47")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9ea78933-489e-4b8e-898f-b34e5ec01a7c")), KernelTerm.PREFERRED)
                ;

        set.concept("Logic coordinate name (SOLOR)", PublicIds.of(UUID.fromString("78972f14-e0f6-5f72-bf82-59310b5f7b26"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ea334834-ee7e-42db-961c-2cec9a0eef8e")), KernelTerm.ENGLISH_LANGUAGE, "Logic coordinate name (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2b23f175-c8de-49fe-8924-165cafc6767e")), KernelTerm.ENGLISH_LANGUAGE, "Logic coordinate name", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c2fb48e1-6bd1-4314-af09-1fb46c7c2a0a")), KernelTerm.ENGLISH_LANGUAGE, "Logic coordinate name", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("39ce81db-cf01-414c-a608-7097e676126b")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "78972f14-e0f6-5f72-bf82-59310b5f7b26")
                .statedAxioms(PublicIds.of(UUID.fromString("e85b1a16-0680-5314-8342-b937b6f86676")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Logic coordinate properties (SOLOR)", PublicIds.of("1fa63819-5ac1-5938-95b1-47871a5f2b17"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("cacdf5b1-ac03-46b0-91d0-34f12a78dd95")))
                .semanticOn(PublicIds.of(UUID.fromString("ea334834-ee7e-42db-961c-2cec9a0eef8e")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("587da80e-ee92-4a79-a793-aa0cdd4cc406")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2b23f175-c8de-49fe-8924-165cafc6767e")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48c6be1e-71fd-4611-8dd1-a61ba46e2c32")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c2fb48e1-6bd1-4314-af09-1fb46c7c2a0a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4b61aaad-602f-4ebc-a225-8bf6ddb0db3a")), KernelTerm.PREFERRED)
                ;

    }
}
