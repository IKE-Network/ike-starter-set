package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Logic coordinate properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section22 {

    private Section22() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        set.concept("Logic coordinate properties (SOLOR)", PublicIds.of(UUID.fromString("1fa63819-5ac1-5938-95b1-47871a5f2b17"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bc1a1259-121e-4ef0-8964-d6740761ab0e")), IkeTerm.ENGLISH_LANGUAGE, "Logic coordinate properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6036c822-8ee6-462b-9e66-2f5c627384f8")), IkeTerm.ENGLISH_LANGUAGE, "Logic coordinate properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("54fa5cec-2dfa-468c-9d90-9d48ed7e9171")), IkeTerm.ENGLISH_LANGUAGE, "Structural characteristics of logical elements, Attributes of Logical coordinates, Mathematical Representation of logical relationships ?", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("3b3bc09e-b0d3-44e1-a2f1-f0b6354c639d")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1fa63819-5ac1-5938-95b1-47871a5f2b17")
                .statedAxioms(PublicIds.of(UUID.fromString("9fc148d7-7435-5d81-ac30-1920d697e039")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("61d88335-a658-40c5-a92f-d63ef7343f5d")))
                .semanticOn(PublicIds.of(UUID.fromString("bc1a1259-121e-4ef0-8964-d6740761ab0e")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5faac4a1-e121-4ee9-a727-fb35c2a9a4ee")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6036c822-8ee6-462b-9e66-2f5c627384f8")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2e672c86-4105-4cb5-931f-a9bf7f64ef6b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("54fa5cec-2dfa-468c-9d90-9d48ed7e9171")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2d2d6bc3-99e3-427d-a710-7004d1d82b7a")), IkeTerm.PREFERRED)
                ;

        set.concept("Module origins (SOLOR)", PublicIds.of(UUID.fromString("462862d4-5df9-426e-b785-a1264e24769f"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a3cf1284-f9ab-4cd9-ba4f-340218b31490")), IkeTerm.ENGLISH_LANGUAGE, "Module origins (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("664b13d0-506f-4f95-823b-c94369ec0d0b")), IkeTerm.ENGLISH_LANGUAGE, "Module origins", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("899291eb-daea-40c6-8f5f-6f939d0d5a47")), IkeTerm.ENGLISH_LANGUAGE, "Module origins", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("711e9637-5d8a-4f22-a430-5dde79b4dbaf")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "462862d4-5df9-426e-b785-a1264e24769f")
                .statedAxioms(PublicIds.of(UUID.fromString("89439dbb-6bbb-5a13-b407-1ea42986f6b2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LOGIC_COORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a324bfb5-1828-4f34-adcd-7fb01c133b4e")))
                .semanticOn(PublicIds.of(UUID.fromString("a3cf1284-f9ab-4cd9-ba4f-340218b31490")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2c7d1f18-0c98-4186-bc7a-6f8141bf0bc8")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("664b13d0-506f-4f95-823b-c94369ec0d0b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("835eb207-4b81-49dc-b159-ae4cea65eab5")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("899291eb-daea-40c6-8f5f-6f939d0d5a47")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9ea78933-489e-4b8e-898f-b34e5ec01a7c")), IkeTerm.PREFERRED)
                ;

        set.concept("Logic coordinate name (SOLOR)", PublicIds.of(UUID.fromString("78972f14-e0f6-5f72-bf82-59310b5f7b26"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ea334834-ee7e-42db-961c-2cec9a0eef8e")), IkeTerm.ENGLISH_LANGUAGE, "Logic coordinate name (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2b23f175-c8de-49fe-8924-165cafc6767e")), IkeTerm.ENGLISH_LANGUAGE, "Logic coordinate name", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c2fb48e1-6bd1-4314-af09-1fb46c7c2a0a")), IkeTerm.ENGLISH_LANGUAGE, "Logic coordinate name", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("39ce81db-cf01-414c-a608-7097e676126b")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "78972f14-e0f6-5f72-bf82-59310b5f7b26")
                .statedAxioms(PublicIds.of(UUID.fromString("e85b1a16-0680-5314-8342-b937b6f86676")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LOGIC_COORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("cacdf5b1-ac03-46b0-91d0-34f12a78dd95")))
                .semanticOn(PublicIds.of(UUID.fromString("ea334834-ee7e-42db-961c-2cec9a0eef8e")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("587da80e-ee92-4a79-a793-aa0cdd4cc406")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2b23f175-c8de-49fe-8924-165cafc6767e")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48c6be1e-71fd-4611-8dd1-a61ba46e2c32")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c2fb48e1-6bd1-4314-af09-1fb46c7c2a0a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4b61aaad-602f-4ebc-a225-8bf6ddb0db3a")), IkeTerm.PREFERRED)
                ;

    }
}
