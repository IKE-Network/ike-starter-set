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

/** The "Phenomenon" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section67 {

    private Section67() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Phenomenon", PublicIds.of(UUID.fromString("c2e8bc47-3353-5e02-b0d1-2a5916efed4d"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("16536037-20a7-4f00-8706-746478dea158")), TinkarTerm.ENGLISH_LANGUAGE, "Phenomenon", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("158091cd-2f8f-4433-9676-c2a5efa120a7")), TinkarTerm.ENGLISH_LANGUAGE, "Phenomenon", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a00ebc0b-894e-446d-8c07-5ec17c7109e5")), TinkarTerm.ENGLISH_LANGUAGE, "A unique thought, fact, or circumstance", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("1ad48bf3-49ee-4344-89b7-1f9a90e1451a")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c2e8bc47-3353-5e02-b0d1-2a5916efed4d")
                .statedAxioms(PublicIds.of(UUID.fromString("6c94350d-3c1b-5e58-9062-e625384b40c5")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.ROOT_VERTEX))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e5919a7f-e540-4a1b-af96-ade5363f625d")))
                .semanticOn(PublicIds.of(UUID.fromString("16536037-20a7-4f00-8706-746478dea158")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b3d9288f-efe5-41cc-b114-eb358ad6bc9e")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("158091cd-2f8f-4433-9676-c2a5efa120a7")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("128f3ccb-df24-4c95-b76b-a7561627a044")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a00ebc0b-894e-446d-8c07-5ec17c7109e5")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("832af60f-40c8-427c-ab88-739b703c1023")), TinkarTerm.PREFERRED)
                ;

        set.concept("Uncategorized phenomenon (SOLOR)", PublicIds.of(UUID.fromString("722f5ac8-1f5c-5d8f-96bb-370d79596f66"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e7999991-62cb-4409-83ba-742c43c404ef")), TinkarTerm.ENGLISH_LANGUAGE, "Uncategorized phenomenon (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1a6c85a0-1382-49c2-ae4b-082c678416a0")), TinkarTerm.ENGLISH_LANGUAGE, "Uncategorized phenomenon", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("801c0e27-5770-40f8-8eba-69af5864cac0")), TinkarTerm.ENGLISH_LANGUAGE, "Unknown", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("a0ca2cbf-0382-4888-8415-112c3defc202")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "722f5ac8-1f5c-5d8f-96bb-370d79596f66")
                .statedAxioms(PublicIds.of(UUID.fromString("e189f26a-ebb1-5149-9885-68ded4a19dd4")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.PHENOMENON))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("2e81f256-0b4d-43f4-963f-f239270ae273")))
                .semanticOn(PublicIds.of(UUID.fromString("e7999991-62cb-4409-83ba-742c43c404ef")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("336bbecd-5ad5-465e-bc94-6337dae56e63")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1a6c85a0-1382-49c2-ae4b-082c678416a0")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("cf97217e-2ae5-43e7-b6b9-ba9b1e4518aa")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("801c0e27-5770-40f8-8eba-69af5864cac0")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1be683a5-5a3a-4f74-862b-715f6ea5d0c2")), TinkarTerm.PREFERRED)
                ;

        set.concept("Example UCUM Units (SOLOR)", PublicIds.of(UUID.fromString("80cd4978-314d-46e3-bc13-9980280ae955"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("868bdeaa-1443-4e9c-99f7-39ae5c243952")), TinkarTerm.ENGLISH_LANGUAGE, "Example UCUM Units (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9edcd366-8719-46e8-bae8-4db0803dde0b")), TinkarTerm.ENGLISH_LANGUAGE, "Example UCUM Units", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7f77024c-7255-40a8-b57f-b023c09ca86a")), TinkarTerm.ENGLISH_LANGUAGE, "The Unified Code for Units of Measure (UCUM) is a code system intended to include all units of measures being contemporarily used in international science, engineering, and business. (www.unitsofmeasure.org) This field contains example units of measures for this term expressed as UCUM units.", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c900cb11-9fef-4000-995b-4d36d8f2ced4")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "80cd4978-314d-46e3-bc13-9980280ae955")
                .statedAxioms(PublicIds.of(UUID.fromString("fc087ef6-c9b1-54a8-9a79-f4d47579b989")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.PHENOMENON))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("d5743301-3c56-44a9-ba5a-d7762fbce46f")))
                .semanticOn(PublicIds.of(UUID.fromString("868bdeaa-1443-4e9c-99f7-39ae5c243952")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("1fa7d911-b595-4e16-ba4e-e83345acb040")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9edcd366-8719-46e8-bae8-4db0803dde0b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f8f5fc26-9074-47f3-b228-07041dc7d502")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7f77024c-7255-40a8-b57f-b023c09ca86a")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bae6d470-5abb-4ef9-ace3-a659284b1e13")), TinkarTerm.PREFERRED)
                ;

        set.concept("Health concept (SOLOR)", PublicIds.of(UUID.fromString("a892950a-0847-300c-b477-4e3cbb945225"), UUID.fromString("ee9ac5d2-a07c-3981-a57a-f7f26baf38d8"), UUID.fromString("f6daf03a-93d6-5bab-8dc9-f60c327cf012"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8924df61-b461-457d-a84c-cac12611b672")), TinkarTerm.ENGLISH_LANGUAGE, "Health concept (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("449763d9-282f-413a-87f3-76512cd8f997")), TinkarTerm.ENGLISH_LANGUAGE, "Health concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("9ff8c075-dc38-4b57-a600-9da437b68185")), TinkarTerm.ENGLISH_LANGUAGE, "Health concept", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("df69b5d4-991a-4fab-842b-842f36e09054")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a892950a-0847-300c-b477-4e3cbb945225")
                .statedAxioms(PublicIds.of(UUID.fromString("4c314321-94ac-56bf-bc12-77768ea59836")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.PHENOMENON))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8e1fe424-f7f9-4812-b381-03d8657e0e68")))
                .semanticOn(PublicIds.of(UUID.fromString("8924df61-b461-457d-a84c-cac12611b672")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7649c404-299e-4090-9e8c-6cc235eb03fa")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("449763d9-282f-413a-87f3-76512cd8f997")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("08bdc9c6-1539-49f8-9cf4-0a71cc0e6b85")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("9ff8c075-dc38-4b57-a600-9da437b68185")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("08d6484e-9351-44de-8915-87970e957581")), TinkarTerm.PREFERRED)
                ;

    }
}
