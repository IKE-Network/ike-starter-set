package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Logic coordinate properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section22 {

    private Section22() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Logic coordinate properties (SOLOR)", PublicIds.of(UUID.fromString("1fa63819-5ac1-5938-95b1-47871a5f2b17"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bc1a1259-121e-4ef0-8964-d6740761ab0e")), TinkarTerm.ENGLISH_LANGUAGE, "Logic coordinate properties (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6036c822-8ee6-462b-9e66-2f5c627384f8")), TinkarTerm.ENGLISH_LANGUAGE, "Logic coordinate properties", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("54fa5cec-2dfa-468c-9d90-9d48ed7e9171")), TinkarTerm.ENGLISH_LANGUAGE, "Structural characteristics of logical elements, Attributes of Logical coordinates, Mathematical Representation of logical relationships ?", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("3b3bc09e-b0d3-44e1-a2f1-f0b6354c639d")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1fa63819-5ac1-5938-95b1-47871a5f2b17")
                .statedAxioms(PublicIds.of(UUID.fromString("9fc148d7-7435-5d81-ac30-1920d697e039")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.OBJECT_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("61d88335-a658-40c5-a92f-d63ef7343f5d")))
                .semanticOn(PublicIds.of(UUID.fromString("bc1a1259-121e-4ef0-8964-d6740761ab0e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("5faac4a1-e121-4ee9-a727-fb35c2a9a4ee")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6036c822-8ee6-462b-9e66-2f5c627384f8")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2e672c86-4105-4cb5-931f-a9bf7f64ef6b")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("54fa5cec-2dfa-468c-9d90-9d48ed7e9171")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2d2d6bc3-99e3-427d-a710-7004d1d82b7a")), TinkarTerm.PREFERRED)
                ;

        set.concept("Module origins (SOLOR)", PublicIds.of(UUID.fromString("462862d4-5df9-426e-b785-a1264e24769f"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a3cf1284-f9ab-4cd9-ba4f-340218b31490")), TinkarTerm.ENGLISH_LANGUAGE, "Module origins (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("664b13d0-506f-4f95-823b-c94369ec0d0b")), TinkarTerm.ENGLISH_LANGUAGE, "Module origins", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("899291eb-daea-40c6-8f5f-6f939d0d5a47")), TinkarTerm.ENGLISH_LANGUAGE, "Module origins", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("711e9637-5d8a-4f22-a430-5dde79b4dbaf")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "462862d4-5df9-426e-b785-a1264e24769f")
                .statedAxioms(PublicIds.of(UUID.fromString("89439dbb-6bbb-5a13-b407-1ea42986f6b2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LOGIC_COORDINATE_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("a324bfb5-1828-4f34-adcd-7fb01c133b4e")))
                .semanticOn(PublicIds.of(UUID.fromString("a3cf1284-f9ab-4cd9-ba4f-340218b31490")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2c7d1f18-0c98-4186-bc7a-6f8141bf0bc8")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("664b13d0-506f-4f95-823b-c94369ec0d0b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("835eb207-4b81-49dc-b159-ae4cea65eab5")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("899291eb-daea-40c6-8f5f-6f939d0d5a47")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9ea78933-489e-4b8e-898f-b34e5ec01a7c")), TinkarTerm.PREFERRED)
                ;

        set.concept("Logic coordinate name (SOLOR)", PublicIds.of(UUID.fromString("78972f14-e0f6-5f72-bf82-59310b5f7b26"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ea334834-ee7e-42db-961c-2cec9a0eef8e")), TinkarTerm.ENGLISH_LANGUAGE, "Logic coordinate name (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2b23f175-c8de-49fe-8924-165cafc6767e")), TinkarTerm.ENGLISH_LANGUAGE, "Logic coordinate name", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c2fb48e1-6bd1-4314-af09-1fb46c7c2a0a")), TinkarTerm.ENGLISH_LANGUAGE, "Logic coordinate name", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("39ce81db-cf01-414c-a608-7097e676126b")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "78972f14-e0f6-5f72-bf82-59310b5f7b26")
                .statedAxioms(PublicIds.of(UUID.fromString("e85b1a16-0680-5314-8342-b937b6f86676")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.LOGIC_COORDINATE_PROPERTIES))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("cacdf5b1-ac03-46b0-91d0-34f12a78dd95")))
                .semanticOn(PublicIds.of(UUID.fromString("ea334834-ee7e-42db-961c-2cec9a0eef8e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("587da80e-ee92-4a79-a793-aa0cdd4cc406")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2b23f175-c8de-49fe-8924-165cafc6767e")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("48c6be1e-71fd-4611-8dd1-a61ba46e2c32")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c2fb48e1-6bd1-4314-af09-1fb46c7c2a0a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4b61aaad-602f-4ebc-a225-8bf6ddb0db3a")), TinkarTerm.PREFERRED)
                ;

    }
}
