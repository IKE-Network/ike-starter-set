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
 * The taxonomy organization revision (IKE-Network/ike-issues#915): KEC's review of the
 * opened knowledge base (2026-07-19) found 75 concepts sitting flat under Model concept
 * — "we can do better." This set mints the structural concepts of the revision; the
 * accompanying edits move existing concepts under them (authored-set {@code .isA()}
 * rewires for IKE-minted concepts, section {@code statedAxioms} edits with
 * divergence-registry entries for historic ones).
 * <p>
 * Three organizing principles, each carried by this file's definitions:
 * <ul>
 * <li><b>STAMP dimensions are operational content, not meta-schema.</b> The five value
 * spaces the versioning machinery selects STAMP constituents from — Status value, Time,
 * Author, Module, Path — gather under a root-level organizer. A root's double duty as a
 * STAMP field meaning does not make its subtree meta-schema: the Path subtree is the
 * actual version-control lineage graph, not a description of one.</li>
 * <li><b>Model concept fans out by subsystem.</b> The subsystem organizers replace the 75-way
 * flat fan-out, one per model subsystem, so the taxonomy under Model concept reads as a
 * table of contents of the meta-schema itself.</li>
 * <li><b>The logical-expression taxonomy mirrors the sealed {@code LogicalAxiom}
 * hierarchy in code</b> ({@code dev.ikm.tinkar.entity.graph.adaptor.axiom.LogicalAxiom}):
 * what the compiler enforces as the closed set of axiom kinds, the knowledge base states
 * as the closed taxonomy of axiom-kind concepts — one structure, visible to both. The
 * graph-representation concepts (vertex, edge, graph, tree) get the same treatment:
 * first-class, defined, and organized, where before they appeared only as scattered
 * display-field and navigation concepts.</li>
 * </ul>
 */
final class ModelOrganizationSet {

    private ModelOrganizationSet() {
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

        // ── The STAMP dimensions organizer ──────────────────────────────
        // Machinery, so it files under Model concept (KEC ruling, 2026-07-19: the
        // taxonomy root is the domain's front page — IKE-Network/ike-issues#918);
        // the operational-vs-meta-schema distinction lives on in the definition.
        set.concept("STAMP dimensions (IkeFoundation)").at(inception)
                .synonym("STAMP dimensions")
                .definition("The five value spaces the versioning machinery selects a"
                        + " version's STAMP constituents from: Status value, Time,"
                        + " Author, Module, and Path. Machinery, so it files under"
                        + " Model concept — yet each dimension's subtree is operational"
                        + " content, not meta-schema: the statuses versions actually"
                        + " carry, the authors who actually commit, the modules and"
                        + " paths content actually lives on. A dimension root's double"
                        + " duty as a STAMP field meaning does not make its subtree a"
                        + " description of anything.")
                .isA(IkeTerm.MODEL_CONCEPT);

        // ── The nine subsystem organizers under Model concept ───────────
        set.concept("Chronicle and version model (IkeFoundation)").at(inception)
                .synonym("Chronicle and version model")
                .definition("The meta-schema of chronicles and their versions: the field"
                        + " kinds every chronicle shape records (public identity, the"
                        + " versions collection), the field kinds every version shape"
                        + " records (STAMP, the pattern-declaration and semantic-value"
                        + " slots), and the meaning/purpose concepts those shapes"
                        + " declare. This subsystem describes how knowledge is carried;"
                        + " what any of it is about belongs to the domain content"
                        + " itself.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Description model (IkeFoundation)").at(inception)
                .synonym("Description model")
                .definition("The meta-schema of human-language rendering: how a"
                        + " component's descriptions attach, which roles a description"
                        + " plays (fully qualified name, regular name, definition), and"
                        + " the rules — case sensitivity, dialect acceptability — a"
                        + " rendering surface applies when choosing what to show.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Identifier model (IkeFoundation)").at(inception)
                .synonym("Identifier model")
                .definition("The meta-schema of identity interchange: how a component"
                        + " carries identifiers minted by external authorities, which"
                        + " authority stands behind each identifier, and how an external"
                        + " identity maps onto a knowledge-base component. Distinct from"
                        + " public identity itself (a chronicle-model concern): this"
                        + " subsystem is about the identifiers other systems know a"
                        + " component by.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Provenance model (IkeFoundation)").at(inception)
                .synonym("Provenance model")
                .definition("The meta-schema of where content came from: the role"
                        + " concepts of commit provenance, module lineage (which modules"
                        + " a module originated from), and path lineage (which path a"
                        + " path branched from, and when). The STAMP dimensions"
                        + " themselves are operational value spaces at the taxonomy"
                        + " root; this subsystem holds the concepts that describe"
                        + " provenance relationships among them.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Logical expression model (IkeFoundation)").at(inception)
                .synonym("Logical expression model")
                .definition("The meta-schema of stated and inferred definitions: the"
                        + " closed taxonomy of logical-axiom kinds — mirroring, one for"
                        + " one, the sealed LogicalAxiom hierarchy the platform's"
                        + " reasoner and builders compile against — together with the"
                        + " operator vocabularies those axioms use. What the compiler"
                        + " enforces as the closed set of axiom kinds, this subtree"
                        + " states as the closed taxonomy of axiom-kind concepts.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Graph model (IkeFoundation)").at(inception)
                .synonym("Graph model")
                .definition("The meta-schema of graph representation and processing:"
                        + " vertexes that carry a meaning and properties, edges that"
                        + " connect them, graphs assembled from both, and trees as the"
                        + " single-parent special case. Logical expressions, navigation"
                        + " structures, and version-control lineage are all carried as"
                        + " graphs; this subsystem names the representation those"
                        + " carriers share.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Constraint model (IkeFoundation)").at(inception)
                .synonym("Constraint model")
                .definition("The meta-schema of field constraints"
                        + " (IKE-Network/ike-issues#890): the constraint-declaration"
                        + " roles (constrained pattern and field, rule, scope, anchor),"
                        + " the taxonomy constraint kinds, the value-set apparatus with"
                        + " its member match relations, and the restriction concepts"
                        + " constraint patterns declare as meanings and purposes."
                        + " Constraints are first-class pattern content — declared,"
                        + " versioned, and exchanged like any other knowledge.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Defaults and templates model (IkeFoundation)").at(inception)
                .synonym("Defaults and templates model")
                .definition("The meta-schema of authoring support content"
                        + " (IKE-Network/ike-issues#885): the attachment points default"
                        + " value and template semantics reference, the per-data-type"
                        + " default concepts, and the exemplar/provision concepts the"
                        + " Data Type Defaults apparatus declares. Support content"
                        + " itself lives in the Defaults and templates module; these"
                        + " are the foundation concepts that describe it.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("View coordinate model (IkeFoundation)").at(inception)
                .synonym("View coordinate model")
                .definition("The meta-schema of views: the coordinate property families"
                        + " a rendering or editing surface assembles into a reproducible"
                        + " way of looking — stamp, language, logic, and path coordinate"
                        + " properties, and the immutable-coordinate property"
                        + " vocabulary. A coordinate's constituents are dimensions;"
                        + " these concepts name them.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Editorial model (IkeFoundation)").at(inception)
                .synonym("Editorial model")
                .definition("The meta-schema of editorial workflow: commentary and its"
                        + " subjects, review routing and reviewer assignment, and the"
                        + " author-roster apparatus. These concepts describe how people"
                        + " work on the knowledge base — as distinct from what the"
                        + " knowledge base asserts.")
                .isA(IkeTerm.MODEL_CONCEPT);

        // ── The LogicalAxiom mirror: structural parents ─────────────────
        // Existing EL++ concepts reorganize under these (the accompanying section
        // edits); only the structure the code already has is minted — nothing invented.
        set.concept("Logical axiom (IkeFoundation)").at(inception)
                .synonym("Logical axiom")
                .definition("The root of the logical-axiom taxonomy: one element of a"
                        + " stated or inferred definition's expression graph. Mirrors"
                        + " the sealed interface LogicalAxiom: every axiom is an atom,"
                        + " a definition root, or a logical set — a closed alternative"
                        + " the compiler enforces in code and this taxonomy states as"
                        + " knowledge.")
                .isA(set.conceptRef("Logical expression model (IkeFoundation)"));

        set.concept("Atom (IkeFoundation)").at(inception)
                .synonym("Atom")
                .definition("A logical axiom that participates in a set's expression"
                        + " rather than framing one: connectives (and, or), concept"
                        + " references, disjoint-with assertions, property sequence"
                        + " implications, and the typed atoms (role, interval role,"
                        + " feature). Mirrors LogicalAxiom.Atom in the sealed"
                        + " hierarchy.")
                .isA(set.conceptRef("Logical axiom (IkeFoundation)"));

        set.concept("Typed atom (IkeFoundation)").at(inception)
                .synonym("Typed atom")
                .definition("An atom that carries a type concept naming which relation"
                        + " or feature it asserts: a role (existential restriction"
                        + " over a role type), an interval role (a role bounded to an"
                        + " interval), or a feature (a concrete-domain comparison"
                        + " against a feature type). Mirrors LogicalAxiom.Atom."
                        + "TypedAtom in the sealed hierarchy.")
                .isA(set.conceptRef("Atom (IkeFoundation)"));

        set.concept("Logical set (IkeFoundation)").at(inception)
                .synonym("Logical set")
                .definition("A logical axiom that groups atoms under a definition root"
                        + " and fixes their force: necessary (always true of the"
                        + " concept), sufficient (enough to classify an individual as"
                        + " the concept), property, data property, interval property,"
                        + " and inclusion sets. Mirrors LogicalAxiom.LogicalSet in the"
                        + " sealed hierarchy.")
                .isA(set.conceptRef("Logical axiom (IkeFoundation)"));

        // ── The graph-representation concepts ───────────────────────────
        set.concept("Graph (IkeFoundation)").at(inception)
                .synonym("Graph")
                .definition("A set of vertexes and the edges that connect them — the"
                        + " representation logical expressions, navigation structures,"
                        + " and lineage records are all carried in. A graph as carried"
                        + " here is directed: each edge runs from one vertex to"
                        + " another, and processing follows that direction.")
                .isA(set.conceptRef("Graph model (IkeFoundation)"));

        set.concept("Tree (IkeFoundation)").at(inception)
                .synonym("Tree")
                .definition("A graph in which every vertex except the root has exactly"
                        + " one predecessor, so every vertex is reached by exactly one"
                        + " path from the root. The platform's DiTree carrier holds"
                        + " definition expressions this way; the general DiGraph"
                        + " carrier relaxes the single-predecessor restriction.")
                .isA(set.conceptRef("Graph (IkeFoundation)"));

        set.concept("Vertex (IkeFoundation)").at(inception)
                .synonym("Vertex")
                .definition("A node of a graph: it carries a meaning — the concept"
                        + " naming what this vertex asserts or denotes — and zero or"
                        + " more properties, each a concept-keyed value. Edges are"
                        + " recorded as vertex adjacency, so the vertex is the unit of"
                        + " both content and connection.")
                .isA(set.conceptRef("Graph model (IkeFoundation)"));

        set.concept("Edge (IkeFoundation)").at(inception)
                .synonym("Edge")
                .definition("A directed connection from one vertex of a graph to"
                        + " another. In the platform's carriers an edge is adjacency —"
                        + " recorded on the vertexes it connects, carrying no"
                        + " properties of its own; what an edge means is given by the"
                        + " meanings of the vertexes it joins.")
                .isA(set.conceptRef("Graph model (IkeFoundation)"));

        set.concept("Vertex meaning (IkeFoundation)").at(inception)
                .synonym("Vertex meaning")
                .definition("The concept a vertex denotes: what this node of the graph"
                        + " asserts, names, or stands for. Every vertex carries exactly"
                        + " one meaning; processing dispatches on it — a definition"
                        + " root, an and-connective, a role — the way code dispatches"
                        + " on a sealed type.")
                .isA(set.conceptRef("Graph model (IkeFoundation)"));

        set.concept("Vertex property (IkeFoundation)").at(inception)
                .synonym("Vertex property")
                .definition("A concept-keyed value carried on a vertex: the key is a"
                        + " concept naming what the value is (a role type, an operator,"
                        + " a literal), and the value is any field data type. Properties"
                        + " are how a vertex carries the particulars its meaning calls"
                        + " for.")
                .isA(set.conceptRef("Graph model (IkeFoundation)"));
    }
}
