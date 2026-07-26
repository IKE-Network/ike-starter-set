/*
 * Copyright © 2026 IKE Network (support@ike.network)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package network.ike.foundation.ike.terms;

import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;

/**
 * Mints the graph-structure family (IKE-Network/ike-issues#950): the baseline carried a
 * single fused entry — {@code Directed graph (SOLOR)} with the regular name
 * {@code NavigationCoordinate/Directed graph} — conflating a coordinate-model notion
 * with a mathematical structure, and left the structure family without its kinds. This
 * file contributes the missing kinds; the fused entry's repair is written in place at
 * its section declaration ({@code foundation.Section66}), which re-parents
 * {@code Directed graph} under the {@code Graph} minted here (registered in
 * {@code DELIBERATELY_REPARENTED_ISA}) and drops the coordinate half of the name. The
 * coordinate half becomes {@code Navigation coordinate properties} in
 * {@link CoordinateModelSet}.
 * <p>
 * The family is pure kind-of: {@code Graph} → {@code Tree}, {@code Graph} →
 * {@code Directed graph} (DiGraph), and {@code Directed tree} (DiTree) under
 * <em>both</em> {@code Directed graph} and {@code Tree} — the multi-parent placement is
 * the point, and is also why {@code EL++ digraph} stays a digraph: a classified
 * subsumption structure is a DAG precisely because concepts like DiTree have more than
 * one parent. {@code EL++ ditree}, minted here, names the axiom <em>form</em> — each
 * stated or inferred logical expression is one rooted directed tree — as distinct from
 * {@code EL++ digraph}, the classification <em>result</em> over a full axiom set
 * (settled: KEC 2026-07-25, IKE-Network/ike-issues#950).
 * <p>
 * Deliberately NOT placed here: {@code DiTree data type} / {@code DiGraph data type}
 * (Display Fields) and {@code DiTree default} / {@code DiGraph default} (defaults
 * apparatus). A field data type or a default-value provision is not a kind of tree or
 * graph — it is a model concept <em>about</em> values with that structure — so those
 * concepts keep their own families and their textual definitions name the structure
 * concept they carry instead of claiming kinship (no cross-hierarchy is-a; settled Q2:
 * placement is logically definitional, and textual and logical definitions must be
 * consistent and work together).
 */
final class GraphModelSet {

    private GraphModelSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // The one declared inception stamp of the pre-release set
        // (IKE-Network/ike-issues#894).
        ActiveStamp inception = Ike.INCEPTION;

        set.concept("Graph (IkeFoundation)").at(inception)
                .synonym("Graph")
                .definition("A structure of vertices connected by edges — the root of"
                        + " the structure family this model stores knowledge in. Its"
                        + " kinds specialize by edge discipline: Tree (connected,"
                        + " acyclic), Directed graph (every edge has a direction), and"
                        + " Directed tree (both at once). A concept whose values merely"
                        + " have this shape — a data type, a default — is about a graph,"
                        + " not a kind of graph, and lives with its own family.")
                .isA(IkeTerm.TINKAR_MODEL_CONCEPT);

        set.concept("Tree (IkeFoundation)").at(inception)
                .synonym("Tree")
                .definition("A connected, acyclic graph: between any two vertices there"
                        + " is exactly one path. A kind of Graph. When its edges also"
                        + " carry direction from a single root, it is a Directed tree —"
                        + " which is therefore a kind of Tree and a kind of Directed"
                        + " graph at once.")
                .isA(set.conceptRef("Graph (IkeFoundation)"));

        set.concept("Directed tree (IkeFoundation)").at(inception)
                .synonym("Directed tree")
                .synonym("DiTree")
                .definition("A rooted tree whose every edge is directed away from (or"
                        + " toward) the root: a kind of Directed graph and a kind of"
                        + " Tree at once — the multi-parent placement that makes a"
                        + " classified taxonomy a DAG rather than a tree. This is the"
                        + " shape of each stored logical expression (see EL++ ditree)"
                        + " and of the value a DiTree data type field carries.")
                .isA(IkeTerm.DIRECTED_GRAPH, set.conceptRef("Tree (IkeFoundation)"));

        set.concept("EL++ ditree (IkeFoundation)").at(inception)
                .synonym("EL++ ditree")
                .definition("The directed tree carrying one concept's EL++ axiom"
                        + " expression — the stored form of a single stated or inferred"
                        + " definition, with sets and atoms as vertices under one"
                        + " definition root. The axiom form, per concept; distinct from"
                        + " EL++ digraph, the classification result over a full set of"
                        + " EL++ axioms, which is a DAG because concepts may classify"
                        + " under more than one parent.")
                .isA(set.conceptRef("Directed tree (IkeFoundation)"));
    }
}
