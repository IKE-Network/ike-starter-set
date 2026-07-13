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

/** The "Identifier source" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section61 {

    private Section61() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Identifier Source", PublicIds.of(UUID.fromString("5a87935c-d654-548f-82a2-0c06e3801162"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("06a40c30-50fb-43fc-a8e4-dab25cb44a02")), TinkarTerm.ENGLISH_LANGUAGE, "Identifier Source", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6f49b6cf-f994-4dd6-ad93-559b0052eb39")), TinkarTerm.ENGLISH_LANGUAGE, "Identifier source", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c629f584-ae95-4c94-9f50-60a0ce8304f8")), TinkarTerm.ENGLISH_LANGUAGE, "An identifier used to label the identity of a unique component.", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("d5cb9558-7ba2-4e5a-819f-8a41f2b4becc")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "5a87935c-d654-548f-82a2-0c06e3801162")
                .statedAxioms(PublicIds.of(UUID.fromString("b923ce88-e3ef-522f-bfe4-bec064f59794")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("df71af2e-9706-4578-bbc4-37cec482ee0a")))
                .semanticOn(PublicIds.of(UUID.fromString("06a40c30-50fb-43fc-a8e4-dab25cb44a02")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("93a5faad-79ae-4ed0-ab0d-084b74a8515d")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6f49b6cf-f994-4dd6-ad93-559b0052eb39")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d685c473-acc0-4540-924e-d8e6e799eafb")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("c629f584-ae95-4c94-9f50-60a0ce8304f8")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3116d029-198b-46fb-bea3-96b36b78becc")), TinkarTerm.PREFERRED)
                ;

        set.concept("UNIVERSALLY_UNIQUE_IDENTIFIER", PublicIds.of(UUID.fromString("845274b5-9644-3799-94c6-e0ea37e7d1a4"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d974705e-465f-4cf3-b56c-69307fa9c24b")), TinkarTerm.ENGLISH_LANGUAGE, "UNIVERSALLY_UNIQUE_IDENTIFIER", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("99a356ec-3e20-4c5b-bf2c-ea5efb00f871")), TinkarTerm.ENGLISH_LANGUAGE, "UUID", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("afaf9d6a-e9c4-4a6c-bf72-6db6eb50f20c")), TinkarTerm.ENGLISH_LANGUAGE, "A universally unique identifier that uniquely represents a concept in Tinkar", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("e91aa7fa-8113-4c9d-8826-120e6ea3a701")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "845274b5-9644-3799-94c6-e0ea37e7d1a4")
                .statedAxioms(PublicIds.of(UUID.fromString("37211859-d480-5798-ad1e-f1ef09f9c227")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.IDENTIFIER_SOURCE))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("3469c5a1-c988-4b56-bc45-12ca40063830")))
                .semanticOn(PublicIds.of(UUID.fromString("d974705e-465f-4cf3-b56c-69307fa9c24b")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("bc10932c-1761-41ea-86a7-5d8373f259dd")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("99a356ec-3e20-4c5b-bf2c-ea5efb00f871")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2b5be2a4-092d-43ba-804a-4d23840e3d79")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("afaf9d6a-e9c4-4a6c-bf72-6db6eb50f20c")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("79c4aa84-f10a-4ab1-ba3f-7ecfdbbc25cb")), TinkarTerm.PREFERRED)
                ;

    }
}
