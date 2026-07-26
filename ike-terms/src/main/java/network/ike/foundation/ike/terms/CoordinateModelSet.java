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
 * Mints the view-coordinate-model family (IKE-Network/ike-issues#950, settled KEC
 * 2026-07-25). The baseline piled every coordinate dimension flat under
 * {@code ImmutableCoordinate Properties} while three per-coordinate families
 * (Language/Logic/Path coordinate properties) sat apart under {@code Object properties},
 * and the navigation dimensions had no family at all — their would-be home was fused
 * into the {@code NavigationCoordinate/Directed graph} entry {@code foundation.Section66}
 * repairs. This file contributes the missing roots: {@code View coordinate model} plus
 * the {@code Stamp}/{@code Edit}/{@code Navigation coordinate properties} families. The
 * pre-existing families and every dimension concept are re-parented in place at their
 * section declarations (registered in {@code DELIBERATELY_REPARENTED_ISA}).
 * <p>
 * <b>Partonomy, stated logically (settled: machinery and definitional use).</b> The true
 * relation between a properties family and the model is composition, not kind-of alone —
 * a navigation coordinate is <em>part of</em> the view coordinate model. Each family
 * root therefore carries, alongside its is-a placement, an existential
 * {@code Part of} restriction on {@code View coordinate model}; each dimension concept
 * carries one on its family root. {@code Part of} is seated as a transitive role type at
 * its own declaration ({@code foundation.Section41}), so the reasoner derives dimension
 * ∘ family → model. EL++ has no inverse roles, so part→whole is the one canonical
 * direction — {@code has-part} is never minted. Textual and logical definitions are kept
 * consistent: each definition below says what the concept is (the is-a) and what it is
 * part of (the role), in the same breath the axioms state.
 */
final class CoordinateModelSet {

    private CoordinateModelSet() {
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

        set.concept("View coordinate model (IkeFoundation)").at(inception)
                .synonym("View coordinate model")
                .definition("The model family for the coordinates composing a view of"
                        + " the knowledge graph: a view coordinate is composed of a"
                        + " stamp coordinate (which versions are visible), language"
                        + " coordinates (which descriptions to prefer), a logic"
                        + " coordinate (how to reason), a navigation coordinate (how to"
                        + " traverse), and an edit coordinate (where changes are"
                        + " written). Each per-coordinate properties family placed here"
                        + " is part of this model — stated logically as a transitive"
                        + " Part of restriction, in the part-to-whole direction EL++"
                        + " supports.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Stamp coordinate properties (IkeFoundation)").at(inception)
                .synonym("Stamp coordinate properties")
                .definition("The dimensions of the stamp coordinate — the version"
                        + " filter of a view: allowed states, the module preference"
                        + " list, order, and exclusion set, the author set, and the"
                        + " position on path that together select which versions are"
                        + " visible. A model concept grouping those dimensions, and"
                        + " part of the view coordinate model — stated logically as a"
                        + " Part of restriction.")
                .statedAxioms(leb -> leb.NecessarySet(leb.And(
                        leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)")),
                        leb.SomeRole(IkeTerm.PART_OF,
                                leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)"))))));

        set.concept("Edit coordinate properties (IkeFoundation)").at(inception)
                .synonym("Edit coordinate properties")
                .definition("The dimensions of the edit coordinate — where a view"
                        + " writes: the author, the default and destination modules,"
                        + " the module and path options offered, and the promotion path"
                        + " that together govern how new versions are stamped. A model"
                        + " concept grouping those dimensions, and part of the view"
                        + " coordinate model — stated logically as a Part of"
                        + " restriction.")
                .statedAxioms(leb -> leb.NecessarySet(leb.And(
                        leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)")),
                        leb.SomeRole(IkeTerm.PART_OF,
                                leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)"))))));

        set.concept("Navigation coordinate properties (IkeFoundation)").at(inception)
                .synonym("Navigation coordinate properties")
                .definition("The dimensions of the navigation coordinate — how a view"
                        + " traverses parent/child structure: the navigation concept"
                        + " set naming which navigation patterns to read, the vertex"
                        + " state set filtering which states a vertex may be in, and"
                        + " the vertex sort ordering siblings. A model concept grouping"
                        + " those dimensions, and part of the view coordinate model —"
                        + " stated logically as a Part of restriction. The navigation"
                        + " coordinate is a coordinate-model notion; the directed graph"
                        + " it walks is a structure kind under Graph — the two concepts"
                        + " the baseline fused into one entry"
                        + " (IKE-Network/ike-issues#950).")
                .statedAxioms(leb -> leb.NecessarySet(leb.And(
                        leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)")),
                        leb.SomeRole(IkeTerm.PART_OF,
                                leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)"))))));
    }
}
