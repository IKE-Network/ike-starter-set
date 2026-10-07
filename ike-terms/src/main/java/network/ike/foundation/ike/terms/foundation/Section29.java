package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Object properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section29 {

    private Section29() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Object Properties (SOLOR)", PublicIds.of(UUID.fromString("3ef4311c-70c0-5149-9e06-53d745f85b15"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5e102098-9a68-4590-84ad-d4fa4aa2cd87")), KernelTerm.ENGLISH_LANGUAGE, "Object Properties (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("8cc0211e-61cc-48f3-b261-9a26db8e2545")), KernelTerm.ENGLISH_LANGUAGE, "Object properties", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("73568509-74f6-4723-913d-36b2c45ed83a")), KernelTerm.ENGLISH_LANGUAGE, "Objects are instances of classes, the properties describe the data or attributes that an object can have", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("0a3572ce-764c-43a0-bfaf-c9ceae7a44d2")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "3ef4311c-70c0-5149-9e06-53d745f85b15")
                .statedAxioms(PublicIds.of(UUID.fromString("058f2138-c65c-5856-a7fa-f52e7bbeb750")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Object (SOLOR)", PublicIds.of("72765109-6b53-3814-9b05-34ebddd16592"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("48af6523-77da-4997-8be0-0cbe09c0c4a9")))
                .semanticOn(PublicIds.of(UUID.fromString("5e102098-9a68-4590-84ad-d4fa4aa2cd87")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2388d1d4-c982-432e-91e9-dcc79fdfec35")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("8cc0211e-61cc-48f3-b261-9a26db8e2545")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f2c1c0e1-f556-41ca-9b36-e19212cc8e20")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("73568509-74f6-4723-913d-36b2c45ed83a")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0491047a-0cd6-4455-a8e7-6509b1bc7d91")), KernelTerm.PREFERRED)
                ;

    }
}
