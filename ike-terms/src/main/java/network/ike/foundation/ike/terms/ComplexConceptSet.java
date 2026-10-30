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

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.ConceptFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelConcept;

/**
 * Declares a complex concept's specification as a tree (IKE-Network/ike-issues#1312, under #812 of
 * epic #806, referencing the ANF epic #725; ike-lab-documents topics
 * {@code anf-complex-concept-architecture} and {@code dev-ditree-editor-skin-family}): the complex
 * concept pattern, whose one field is a {@code DITREE}, the meaning of each vertex of that tree,
 * the keys of the properties a vertex carries, and the values those properties take.
 *
 * <p><b>The tree.</b> The root is the specification, with two children: the complex concept's
 * description logic definition, an EL++ expression held by value, and exactly one expansion
 * specification. A uniform expansion carries its conjunction type, its shared measurement domain
 * and, for an OR conjunction, how a non-absent value is handled; its children are the member
 * phenomena, each linked to the whole by Statement composes when expanded. A focused expansion
 * carries its focus phenomenon; its children are the prerequisites, each an ANF statement held by
 * value, whose topic and result are the prerequisite and its fixed definitional value, with its
 * association semantic as a property.
 *
 * <p><b>Referenced component.</b> A semantic of the complex concept pattern references the
 * complex concept it specifies, as a concept's stated axioms do.
 */
final class ComplexConceptSet {

    static final String ROOT_FQN = "Complex concept model (IkeFoundation)";

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    private static final EntityProxy.Concept MODULE =
            EntityProxy.Concept.make("Module (SOLOR)", PublicIds.of("40d1c869-b509-32f8-b735-836eac577a67"));

    private ComplexConceptSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        set.concept(ROOT_FQN).at(inception)
                .synonym("Complex concept model")
                .definition("A complex concept's specification held as one tree: the complex concept"
                        + " pattern whose field is the tree, the meaning of each vertex, the keys of the"
                        + " properties a vertex carries, and the values those properties take.")
                .isA(IKE_BASE_MODEL_CONCEPT);

        // ── The specification and its vertices ───────────────────────────────────
        concept(set, inception, "Complex concept specification", ROOT_FQN,
                "What a complex concept is and what to do with it, the root vertex of its tree and the"
                        + " meaning of the complex concept pattern: its description logic definition and"
                        + " exactly one expansion specification, uniform or focused.");
        concept(set, inception, "Complex concept element", ROOT_FQN,
                "A vertex of a complex concept specification's tree beneath the root: the definition,"
                        + " the expansion, or a member or prerequisite of the expansion.");
        element(set, inception, "Complex concept definition",
                "What the complex concept is: its EL++ definition held by value, an is-a to the grouper"
                        + " or parent phenomenon and, for a uniform expansion, an assesses role to each"
                        + " member phenomenon.");
        element(set, inception, "Uniform expansion",
                "An expansion in which a single provided value distributes to every member, since the"
                        + " members share a measurement domain: a clause carrying the conjunction type,"
                        + " the measurement domain and, for an OR conjunction, how a non-absent value is"
                        + " handled, whose children are the members.");
        element(set, inception, "Focused expansion",
                "An expansion in which the provided value applies to one phenomenon, the focus, and"
                        + " the prerequisites carry fixed definitional values: a clause carrying the focus"
                        + " phenomenon, whose children are the prerequisites.");
        element(set, inception, "Expansion member",
                "A member of a uniform expansion: a reference to the phenomenon one expanded statement"
                        + " is about.");
        element(set, inception, "Expansion prerequisite",
                "A prerequisite of a focused expansion: an ANF statement held by value whose topic is"
                        + " the condition and whose result is its fixed definitional value, with its"
                        + " association semantic as a property.");

        // ── Property keys ────────────────────────────────────────────────────────
        concept(set, inception, "Complex concept property", ROOT_FQN,
                "The key of a property a complex concept specification's vertex carries.");
        property(set, inception, "Definition expression",
                "The EL++ expression a complex concept definition holds by value, as a DITREE.");
        property(set, inception, "Expansion conjunction",
                "Whether a uniform expansion's members are joined by AND or by OR, which decides which"
                        + " provided values distribute safely.");
        property(set, inception, "Measurement domain",
                "The scale every member of a uniform expansion is measured on, such as presence.");
        property(set, inception, "Unsafe distribution policy",
                "How an OR-conjunction uniform expansion handles a non-absent value, which says that at"
                        + " least one member holds the value but not which.");
        property(set, inception, "Focus phenomenon",
                "The phenomenon a focused expansion's provided value applies to.");
        property(set, inception, "Prerequisite statement",
                "The ANF statement a prerequisite holds by value, as a DITREE.");
        property(set, inception, "Prerequisite association",
                "How a prerequisite's statement relates to the focus statement when expanded.");

        // ── Values ───────────────────────────────────────────────────────────────
        concept(set, inception, "Expansion conjunction type", ROOT_FQN,
                "The value of an expansion conjunction.");
        concept(set, inception, "AND conjunction", fqn("Expansion conjunction type"),
                "Every member holds the provided value; any provided interval distributes safely.");
        concept(set, inception, "OR conjunction", fqn("Expansion conjunction type"),
                "At least one member holds the provided value; only the absent interval distributes"
                        + " safely.");
        concept(set, inception, "Unsafe distribution handling", ROOT_FQN,
                "The value of an unsafe distribution policy.");
        concept(set, inception, "Refuse expansion", fqn("Unsafe distribution handling"),
                "Expand nothing, and ask the clinician which members hold the value.");
        concept(set, inception, "Flag as indeterminate positive", fqn("Unsafe distribution handling"),
                "Expand every member, each flagged as indeterminate positive.");
        concept(set, inception, "Retain compound code", fqn("Unsafe distribution handling"),
                "Keep the compound code as given, without expansion.");
        concept(set, inception, "Expansion association", ROOT_FQN,
                "How an expanded prerequisite statement relates to the focus statement.");
        concept(set, inception, "Precondition association", fqn("Expansion association"),
                "The prerequisite is a condition the focus's code stipulates must hold for the"
                        + " observation to be valid; its value is definitional, not observed.");

        // ── The module ───────────────────────────────────────────────────────────
        set.concept(fqn("Complex concepts module")).at(inception)
                .synonym("Complex concepts module")
                .definition("The module complex concepts are written under: concepts whose definition and"
                        + " expansion live in their complex concept specification, kept out of the reasoner's"
                        + " working set and placed under their declared parent after classification. A"
                        + " composed topic promoted to a complex concept is written here.")
                .isA(MODULE);

        // ── The pattern ──────────────────────────────────────────────────────────
        concept(set, inception, "Complex concept structure", ROOT_FQN,
                "The purpose of the complex concept pattern: to hold a complex concept's specification"
                        + " as one tree.");
        concept(set, inception, "Complex concept tree", ROOT_FQN,
                "The tree that is the specification: the field of the complex concept pattern.");

        ConceptFacade structure = set.conceptRef(fqn("Complex concept structure"));
        set.pattern(fqn("Complex concept pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Complex concept specification")))
                .purpose(structure)
                .field(set.conceptRef(fqn("Complex concept tree")), structure, KernelConcept.DITREE_FIELD)
                .synonym("Complex concept pattern")
                .definition("One complex concept's specification, held as one tree whose root is the"
                        + " specification and whose children are its description logic definition and"
                        + " its expansion. Its referenced component is the complex concept it specifies.");
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }

    private static void concept(KnowledgeSet set, ActiveStamp stamp, String name, String parentFqn, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(parentFqn));
    }

    private static void element(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        concept(set, stamp, name, fqn("Complex concept element"), definition);
    }

    private static void property(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        concept(set, stamp, name, fqn("Complex concept property"), definition);
    }
}
