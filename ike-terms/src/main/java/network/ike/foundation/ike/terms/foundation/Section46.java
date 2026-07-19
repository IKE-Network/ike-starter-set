package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Annotation type" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section46 {

    private Section46() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Annotation type (SOLOR)", PublicIds.of(UUID.fromString("3fe77951-58c9-51b3-8e7e-65edcf7ace0a"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e013e8b5-a249-4db3-95c9-57a13b6a692b")), IkeTerm.ENGLISH_LANGUAGE, "Annotation type (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c702ad6a-07fa-40e8-a535-ddbcbcabb00c")), IkeTerm.ENGLISH_LANGUAGE, "Annotation type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b37b7688-0d3f-4821-a2d7-d104e6002c2c")), IkeTerm.ENGLISH_LANGUAGE, "Metadata about program elements, and annotation types define the structure of these annotations", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("d6b1cbb8-e764-438f-990e-981ab6891424")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "3fe77951-58c9-51b3-8e7e-65edcf7ace0a")
                .statedAxioms(PublicIds.of(UUID.fromString("c5cac924-73bc-575b-9878-2420bbb614b9")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROOT_VERTEX))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c652c1f0-bea5-467c-94c7-f6f35469b212")))
                .semanticOn(PublicIds.of(UUID.fromString("e013e8b5-a249-4db3-95c9-57a13b6a692b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8a3366bd-f92a-49af-b0d6-fdf1ec10a166")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c702ad6a-07fa-40e8-a535-ddbcbcabb00c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3b269d5d-4e0e-4a5e-9887-fdefce03ad04")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b37b7688-0d3f-4821-a2d7-d104e6002c2c")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7a45827a-fb35-4fda-9f77-e35292c0426f")), IkeTerm.PREFERRED)
                ;

        set.concept("Komet issue (SOLOR)", PublicIds.of(UUID.fromString("e1dd7bf2-224d-53a5-a5fb-7b25b05d17a6"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("85a9c582-d3a4-4516-b223-838fb0eb7b06")), IkeTerm.ENGLISH_LANGUAGE, "Komet issue (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a3ce1006-174d-480b-b90b-6f95f232fb62")), IkeTerm.ENGLISH_LANGUAGE, "Komet issue", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("623bc5b2-5d8c-4d9a-b27e-b69b653aa783")), IkeTerm.ENGLISH_LANGUAGE, "Komet being the 'annotation type' - specified type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("09f364a8-b193-44d2-8a5c-00bbc0a7e309")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "e1dd7bf2-224d-53a5-a5fb-7b25b05d17a6")
                .statedAxioms(PublicIds.of(UUID.fromString("4184d783-0736-51da-9bf5-21f48c015265")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ANNOTATION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8ddf18ce-be45-43d0-8950-bc3d560c8483")))
                .semanticOn(PublicIds.of(UUID.fromString("85a9c582-d3a4-4516-b223-838fb0eb7b06")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("10032686-d8f7-4ba3-8a62-18c5c006615f")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a3ce1006-174d-480b-b90b-6f95f232fb62")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("34743138-12e8-44e3-bde9-60492d6bd947")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("623bc5b2-5d8c-4d9a-b27e-b69b653aa783")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4affb066-2a4a-4049-8a04-ae32ee28f46a")), IkeTerm.PREFERRED)
                ;

        set.concept("Comment (SOLOR)", PublicIds.of(UUID.fromString("147832d4-b9b8-5062-8891-19f9c4e4760a"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4bd41127-d61f-419b-ac50-cc86eb32865a")), IkeTerm.ENGLISH_LANGUAGE, "Comment (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("af6ae756-23f0-46be-8b93-af4796925cb8")), IkeTerm.ENGLISH_LANGUAGE, "Comment", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("f8ba83f7-217b-4cbc-b0b8-d778faeedf55")), IkeTerm.ENGLISH_LANGUAGE, "A filed label to capture free text information which may be necessary to add or change (concepts, relationships, semantics, etc)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("62ba4737-c099-43c1-bc0b-e227257b1d9e")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "147832d4-b9b8-5062-8891-19f9c4e4760a")
                .statedAxioms(PublicIds.of(UUID.fromString("e7be0c75-a4eb-5e4a-bec8-947cd92f5d2c")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ANNOTATION_TYPE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("40805be0-2979-4aaa-88e0-8c9b91d2e4ac")))
                .semanticOn(PublicIds.of(UUID.fromString("4bd41127-d61f-419b-ac50-cc86eb32865a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("472528a1-5a3a-4af2-9bc9-d9ddeec31897")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("af6ae756-23f0-46be-8b93-af4796925cb8")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("78ae38b3-8ed4-401c-abc7-e714da5a1145")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("f8ba83f7-217b-4cbc-b0b8-d778faeedf55")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d329a531-93ab-4b16-b99d-1218762c0f64")), IkeTerm.PREFERRED)
                ;

    }
}
