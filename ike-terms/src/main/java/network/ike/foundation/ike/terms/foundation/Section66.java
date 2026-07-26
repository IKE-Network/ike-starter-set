package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/**
 * The "Directed graph" section — a taxonomy subtree of the retrofitted starter set
 * (IKE-Network/ike-issues#869). The baseline fused two concepts into this one entry:
 * its regular name read {@code NavigationCoordinate/Directed graph}, conflating a
 * coordinate-model notion with the mathematical structure. Split under
 * IKE-Network/ike-issues#950 (settled KEC 2026-07-25): the structure keeps this birth
 * identity — renamed in place to plain {@code Directed graph} (registered in
 * {@code DELIBERATELY_RENAMED_FQNS}) and re-parented from {@code Tinkar Model concept}
 * to the minted {@code Graph} ({@code GraphModelSet}, registered in
 * {@code DELIBERATELY_REPARENTED_ISA}) — while the coordinate half is a separate
 * concept, {@code Navigation coordinate properties}, minted in
 * {@code CoordinateModelSet}. {@code EL++ digraph} stays a digraph: the classification
 * result over a full axiom set is a DAG, not a tree (its per-concept axiom-form
 * counterpart is {@code EL++ ditree} in {@code GraphModelSet}).
 */
final class Section66 {

    private Section66() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        // Fused-name split (IKE-Network/ike-issues#950): birth FQN was "Directed graph
        // (SOLOR)" with regular name "NavigationCoordinate/Directed graph". The structure
        // meaning keeps this identity; descriptions repaired in place (pre-bronze,
        // IKE-Network/ike-issues#894), coordinate meaning re-minted in CoordinateModelSet.
        set.concept("Directed graph", PublicIds.of(UUID.fromString("47a787a7-bdce-528d-bfcc-fde1add8d599"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b68615c2-a0ad-49c0-a143-3dded633a60f")), IkeTerm.ENGLISH_LANGUAGE, "Directed graph", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("1e514d14-6863-433f-8beb-211eacede6a4")), IkeTerm.ENGLISH_LANGUAGE, "Directed graph", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7411c406-b6d5-4778-8636-5a503bdbb421")), IkeTerm.ENGLISH_LANGUAGE, "A graph whose every edge has a direction: a kind of Graph. When additionally connected and acyclic from a single root it is a Directed tree; the classification result over EL++ axioms (EL++ digraph) is this kind, a DAG, because a concept may classify under more than one parent.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4d6537f2-7063-40d2-88e7-fa379e903f81")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "47a787a7-bdce-528d-bfcc-fde1add8d599")
                .synonym("DiGraph")
                .statedAxioms(PublicIds.of(UUID.fromString("1ec82607-cfb1-5716-8efd-4c052dd58c64")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Graph (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("4e7c45a6-f138-4a2f-a000-8331d034db3c")))
                .semanticOn(PublicIds.of(UUID.fromString("b68615c2-a0ad-49c0-a143-3dded633a60f")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8921d76e-8357-4f56-a933-2cb8772721ab")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("1e514d14-6863-433f-8beb-211eacede6a4")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("6629d5f5-0c8d-4024-ba6e-d21996b73298")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7411c406-b6d5-4778-8636-5a503bdbb421")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4dd0851b-c635-4fd1-98a4-41605ba6785f")), IkeTerm.PREFERRED)
                ;

        set.concept("EL++ digraph (SOLOR)", PublicIds.of(UUID.fromString("ee04d7db-3407-568f-9b93-7b1f9f5bb0fc"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("72c41b1d-f7e0-4d69-aef5-92430288ffb6")), IkeTerm.ENGLISH_LANGUAGE, "EL++ digraph (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2b649036-a2a3-47f3-9060-f7d2bcc19086")), IkeTerm.ENGLISH_LANGUAGE, "EL++ digraph", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4870eae6-c757-48d5-b751-afc82e351d00")), IkeTerm.ENGLISH_LANGUAGE, "The directed graph that results from classifying a set of EL++ axioms", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c3626dd3-01df-44da-b8ba-4779d15dc208")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ee04d7db-3407-568f-9b93-7b1f9f5bb0fc")
                .statedAxioms(PublicIds.of(UUID.fromString("704783f9-4acc-529d-aad7-a260a9d72bd3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DIRECTED_GRAPH))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("8d932453-0c75-4b6e-a9e9-207476ffa223")))
                .semanticOn(PublicIds.of(UUID.fromString("72c41b1d-f7e0-4d69-aef5-92430288ffb6")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("fcf02de0-577b-4052-acf7-ea0c21575b28")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2b649036-a2a3-47f3-9060-f7d2bcc19086")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("32346100-e095-49d8-94ee-ac43270cc4f7")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4870eae6-c757-48d5-b751-afc82e351d00")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("85176aa0-45bc-46bf-8e38-101e5c4d5f68")), IkeTerm.PREFERRED)
                ;

    }
}
