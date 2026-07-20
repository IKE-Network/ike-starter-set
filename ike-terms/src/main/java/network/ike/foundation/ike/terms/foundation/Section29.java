package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Object properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section29 {

    private Section29() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Object Properties (SOLOR)", PublicIds.of("3ef4311c-70c0-5149-9e06-53d745f85b15")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5e102098-9a68-4590-84ad-d4fa4aa2cd87"), IkeTerm.ENGLISH_LANGUAGE, "Object Properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8cc0211e-61cc-48f3-b261-9a26db8e2545"), IkeTerm.ENGLISH_LANGUAGE, "Object properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("73568509-74f6-4723-913d-36b2c45ed83a"), IkeTerm.ENGLISH_LANGUAGE, "Objects are instances of classes, the properties describe the data or attributes that an object can have", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("0a3572ce-764c-43a0-bfaf-c9ceae7a44d2"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "3ef4311c-70c0-5149-9e06-53d745f85b15")
                .statedAxioms(PublicIds.of("058f2138-c65c-5856-a7fa-f52e7bbeb750"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Legacy model concepts (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("48af6523-77da-4997-8be0-0cbe09c0c4a9"))
                .semanticOn(PublicIds.of("5e102098-9a68-4590-84ad-d4fa4aa2cd87"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2388d1d4-c982-432e-91e9-dcc79fdfec35"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("8cc0211e-61cc-48f3-b261-9a26db8e2545"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f2c1c0e1-f556-41ca-9b36-e19212cc8e20"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("73568509-74f6-4723-913d-36b2c45ed83a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0491047a-0cd6-4455-a8e7-6509b1bc7d91"), IkeTerm.PREFERRED)
                ;

    }
}
