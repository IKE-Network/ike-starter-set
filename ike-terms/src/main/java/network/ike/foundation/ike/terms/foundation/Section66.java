package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Directed graph" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section66 {

    private Section66() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Directed graph (SOLOR)", PublicIds.of("47a787a7-bdce-528d-bfcc-fde1add8d599")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b68615c2-a0ad-49c0-a143-3dded633a60f"), IkeTerm.ENGLISH_LANGUAGE, "Directed graph (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("1e514d14-6863-433f-8beb-211eacede6a4"), IkeTerm.ENGLISH_LANGUAGE, "NavigationCoordinate/Directed graph", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7411c406-b6d5-4778-8636-5a503bdbb421"), IkeTerm.ENGLISH_LANGUAGE, "A graph whose edges each run from one vertex to another, so processing follows the direction: the representational data structure navigation, lineage, and expression content is carried in. A coordinate can configure a view of a directed graph -- which graphs to include, under what STAMP, with what combining rules -- but a coordinate is configuration, never the structure itself.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("4d6537f2-7063-40d2-88e7-fa379e903f81"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "47a787a7-bdce-528d-bfcc-fde1add8d599")
                .statedAxioms(PublicIds.of("1ec82607-cfb1-5716-8efd-4c052dd58c64"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Graph (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("4e7c45a6-f138-4a2f-a000-8331d034db3c"))
                .semanticOn(PublicIds.of("b68615c2-a0ad-49c0-a143-3dded633a60f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("8921d76e-8357-4f56-a933-2cb8772721ab"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("1e514d14-6863-433f-8beb-211eacede6a4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6629d5f5-0c8d-4024-ba6e-d21996b73298"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("7411c406-b6d5-4778-8636-5a503bdbb421"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4dd0851b-c635-4fd1-98a4-41605ba6785f"), IkeTerm.PREFERRED)
                ;

        set.concept("EL++ ditree", PublicIds.of("ee04d7db-3407-568f-9b93-7b1f9f5bb0fc")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("72c41b1d-f7e0-4d69-aef5-92430288ffb6"), IkeTerm.ENGLISH_LANGUAGE, "EL++ ditree", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2b649036-a2a3-47f3-9060-f7d2bcc19086"), IkeTerm.ENGLISH_LANGUAGE, "EL++ ditree", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4870eae6-c757-48d5-b751-afc82e351d00"), IkeTerm.ENGLISH_LANGUAGE, "The directed graph that results from classifying a set of EL++ axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("c3626dd3-01df-44da-b8ba-4779d15dc208"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ee04d7db-3407-568f-9b93-7b1f9f5bb0fc")
                .statedAxioms(PublicIds.of("704783f9-4acc-529d-aad7-a260a9d72bd3"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Tree (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8d932453-0c75-4b6e-a9e9-207476ffa223"))
                .semanticOn(PublicIds.of("72c41b1d-f7e0-4d69-aef5-92430288ffb6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fcf02de0-577b-4052-acf7-ea0c21575b28"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2b649036-a2a3-47f3-9060-f7d2bcc19086"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("32346100-e095-49d8-94ee-ac43270cc4f7"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("4870eae6-c757-48d5-b751-afc82e351d00"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("85176aa0-45bc-46bf-8e38-101e5c4d5f68"), IkeTerm.PREFERRED)
                ;

    }
}
