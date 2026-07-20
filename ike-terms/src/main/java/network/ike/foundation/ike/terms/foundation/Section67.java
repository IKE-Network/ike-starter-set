package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Phenomenon" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section67 {

    private Section67() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Phenomenon", PublicIds.of("c2e8bc47-3353-5e02-b0d1-2a5916efed4d")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("16536037-20a7-4f00-8706-746478dea158"), IkeTerm.ENGLISH_LANGUAGE, "Phenomenon", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("158091cd-2f8f-4433-9676-c2a5efa120a7"), IkeTerm.ENGLISH_LANGUAGE, "Phenomenon", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a00ebc0b-894e-446d-8c07-5ec17c7109e5"), IkeTerm.ENGLISH_LANGUAGE, "A unique thought, fact, or circumstance", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("1ad48bf3-49ee-4344-89b7-1f9a90e1451a"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c2e8bc47-3353-5e02-b0d1-2a5916efed4d")
                .statedAxioms(PublicIds.of("6c94350d-3c1b-5e58-9062-e625384b40c5"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.ROOT_VERTEX))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("e5919a7f-e540-4a1b-af96-ade5363f625d"))
                .semanticOn(PublicIds.of("16536037-20a7-4f00-8706-746478dea158"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b3d9288f-efe5-41cc-b114-eb358ad6bc9e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("158091cd-2f8f-4433-9676-c2a5efa120a7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("128f3ccb-df24-4c95-b76b-a7561627a044"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a00ebc0b-894e-446d-8c07-5ec17c7109e5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("832af60f-40c8-427c-ab88-739b703c1023"), IkeTerm.PREFERRED)
                ;

        set.concept("Uncategorized phenomenon (SOLOR)", PublicIds.of("722f5ac8-1f5c-5d8f-96bb-370d79596f66")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e7999991-62cb-4409-83ba-742c43c404ef"), IkeTerm.ENGLISH_LANGUAGE, "Uncategorized phenomenon (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1a6c85a0-1382-49c2-ae4b-082c678416a0"), IkeTerm.ENGLISH_LANGUAGE, "Uncategorized phenomenon", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("801c0e27-5770-40f8-8eba-69af5864cac0"), IkeTerm.ENGLISH_LANGUAGE, "Unknown", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("a0ca2cbf-0382-4888-8415-112c3defc202"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "722f5ac8-1f5c-5d8f-96bb-370d79596f66")
                .statedAxioms(PublicIds.of("e189f26a-ebb1-5149-9885-68ded4a19dd4"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PHENOMENON))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("2e81f256-0b4d-43f4-963f-f239270ae273"))
                .semanticOn(PublicIds.of("e7999991-62cb-4409-83ba-742c43c404ef"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("336bbecd-5ad5-465e-bc94-6337dae56e63"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("1a6c85a0-1382-49c2-ae4b-082c678416a0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cf97217e-2ae5-43e7-b6b9-ba9b1e4518aa"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("801c0e27-5770-40f8-8eba-69af5864cac0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1be683a5-5a3a-4f74-862b-715f6ea5d0c2"), IkeTerm.PREFERRED)
                ;

        set.concept("Example UCUM Units (SOLOR)", PublicIds.of("80cd4978-314d-46e3-bc13-9980280ae955")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("868bdeaa-1443-4e9c-99f7-39ae5c243952"), IkeTerm.ENGLISH_LANGUAGE, "Example UCUM Units (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9edcd366-8719-46e8-bae8-4db0803dde0b"), IkeTerm.ENGLISH_LANGUAGE, "Example UCUM Units", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7f77024c-7255-40a8-b57f-b023c09ca86a"), IkeTerm.ENGLISH_LANGUAGE, "The Unified Code for Units of Measure (UCUM) is a code system intended to include all units of measures being contemporarily used in international science, engineering, and business. (www.unitsofmeasure.org) This field contains example units of measures for this term expressed as UCUM units.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("c900cb11-9fef-4000-995b-4d36d8f2ced4"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "80cd4978-314d-46e3-bc13-9980280ae955")
                .statedAxioms(PublicIds.of("fc087ef6-c9b1-54a8-9a79-f4d47579b989"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PHENOMENON))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d5743301-3c56-44a9-ba5a-d7762fbce46f"))
                .semanticOn(PublicIds.of("868bdeaa-1443-4e9c-99f7-39ae5c243952"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1fa7d911-b595-4e16-ba4e-e83345acb040"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9edcd366-8719-46e8-bae8-4db0803dde0b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f8f5fc26-9074-47f3-b228-07041dc7d502"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("7f77024c-7255-40a8-b57f-b023c09ca86a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bae6d470-5abb-4ef9-ace3-a659284b1e13"), IkeTerm.PREFERRED)
                ;

        set.concept("Health concept (SOLOR)", PublicIds.of("a892950a-0847-300c-b477-4e3cbb945225", "ee9ac5d2-a07c-3981-a57a-f7f26baf38d8", "f6daf03a-93d6-5bab-8dc9-f60c327cf012")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8924df61-b461-457d-a84c-cac12611b672"), IkeTerm.ENGLISH_LANGUAGE, "Health concept (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("449763d9-282f-413a-87f3-76512cd8f997"), IkeTerm.ENGLISH_LANGUAGE, "Health concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9ff8c075-dc38-4b57-a600-9da437b68185"), IkeTerm.ENGLISH_LANGUAGE, "Health concept", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("df69b5d4-991a-4fab-842b-842f36e09054"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a892950a-0847-300c-b477-4e3cbb945225")
                .statedAxioms(PublicIds.of("4c314321-94ac-56bf-bc12-77768ea59836"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PHENOMENON))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8e1fe424-f7f9-4812-b381-03d8657e0e68"))
                .semanticOn(PublicIds.of("8924df61-b461-457d-a84c-cac12611b672"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7649c404-299e-4090-9e8c-6cc235eb03fa"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("449763d9-282f-413a-87f3-76512cd8f997"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("08bdc9c6-1539-49f8-9cf4-0a71cc0e6b85"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9ff8c075-dc38-4b57-a600-9da437b68185"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("08d6484e-9351-44de-8915-87970e957581"), IkeTerm.PREFERRED)
                ;

    }
}
