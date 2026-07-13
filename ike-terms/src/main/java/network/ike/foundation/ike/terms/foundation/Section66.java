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

/** The "NavigationCoordinate/Directed graph" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section66 {

    private Section66() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Stamp.active(PrimitiveData.INCEPTION_EPOCH, network.ike.foundation.ike.terms.Ike.IKE_COMMUNITY, network.ike.foundation.ike.terms.Ike.MODULE, TinkarTerm.DEVELOPMENT_PATH);

        set.concept("Directed graph (SOLOR)", PublicIds.of(UUID.fromString("47a787a7-bdce-528d-bfcc-fde1add8d599"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b68615c2-a0ad-49c0-a143-3dded633a60f")), TinkarTerm.ENGLISH_LANGUAGE, "Directed graph (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1e514d14-6863-433f-8beb-211eacede6a4")), TinkarTerm.ENGLISH_LANGUAGE, "NavigationCoordinate/Directed graph", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7411c406-b6d5-4778-8636-5a503bdbb421")), TinkarTerm.ENGLISH_LANGUAGE, "Directed graph", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4d6537f2-7063-40d2-88e7-fa379e903f81")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "47a787a7-bdce-528d-bfcc-fde1add8d599")
                .statedAxioms(PublicIds.of(UUID.fromString("1ec82607-cfb1-5716-8efd-4c052dd58c64")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.TINKAR_MODEL_CONCEPT))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4e7c45a6-f138-4a2f-a000-8331d034db3c")))
                .semanticOn(PublicIds.of(UUID.fromString("b68615c2-a0ad-49c0-a143-3dded633a60f")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8921d76e-8357-4f56-a933-2cb8772721ab")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1e514d14-6863-433f-8beb-211eacede6a4")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6629d5f5-0c8d-4024-ba6e-d21996b73298")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7411c406-b6d5-4778-8636-5a503bdbb421")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4dd0851b-c635-4fd1-98a4-41605ba6785f")), TinkarTerm.PREFERRED)
                ;

        set.concept("EL++ digraph (SOLOR)", PublicIds.of(UUID.fromString("ee04d7db-3407-568f-9b93-7b1f9f5bb0fc"))).at(inception)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("72c41b1d-f7e0-4d69-aef5-92430288ffb6")), TinkarTerm.ENGLISH_LANGUAGE, "EL++ digraph (SOLOR)", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2b649036-a2a3-47f3-9060-f7d2bcc19086")), TinkarTerm.ENGLISH_LANGUAGE, "EL++ digraph", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4870eae6-c757-48d5-b751-afc82e351d00")), TinkarTerm.ENGLISH_LANGUAGE, "The directed graph that results from classifying a set of EL++ axioms", TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, TinkarTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(TinkarTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c3626dd3-01df-44da-b8ba-4779d15dc208")), TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ee04d7db-3407-568f-9b93-7b1f9f5bb0fc")
                .statedAxioms(PublicIds.of(UUID.fromString("704783f9-4acc-529d-aad7-a260a9d72bd3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(TinkarTerm.DIRECTED_GRAPH))))
                .semantic(TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8d932453-0c75-4b6e-a9e9-207476ffa223")))
                .semanticOn(PublicIds.of(UUID.fromString("72c41b1d-f7e0-4d69-aef5-92430288ffb6")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fcf02de0-577b-4052-acf7-ea0c21575b28")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2b649036-a2a3-47f3-9060-f7d2bcc19086")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("32346100-e095-49d8-94ee-ac43270cc4f7")), TinkarTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4870eae6-c757-48d5-b751-afc82e351d00")), TinkarTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("85176aa0-45bc-46bf-8e38-101e5c4d5f68")), TinkarTerm.PREFERRED)
                ;

    }
}
