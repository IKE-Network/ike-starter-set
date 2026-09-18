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
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * How ELM logic is held in IKE (IKE-Network/ike-issues#1110): the three patterns and the
 * authored positions that sit beside the generated {@link ElmNodeCatalogSet}. AUTHORED,
 * never regenerated: the catalog says what an ELM node may hold; this section says how a
 * library's definitions, ordered lists, and references are recorded as semantics.
 *
 * <p>One semantic per definition of a library, holding one tree whose vertices are ELM
 * nodes. Two or three operands are the roles first, second, and third. A true list leaves
 * the tree as an ordered list semantic whose items are trees of their own. Every thing a
 * definition names is a reference semantic linking to the definition it means. HL7's ELM is
 * the Expression Logical Model of the Clinical Quality Language specification, and not Elm,
 * the programming language for browser user interfaces.
 */
final class ElmTreeSet {

    /** The authored family root: how ELM trees are held. */
    static final String ROOT_FQN = "ELM trees (ELM)";

    /** One definition of a library, or its identity record, as one tree of ELM nodes. */
    static final String TREE_PATTERN_FQN = "ELM tree pattern (ELM)";

    /** The items an ELM list position holds, in order. */
    static final String ORDERED_LIST_PATTERN_FQN = "ELM ordered list pattern (ELM)";

    /** One thing a definition names, linked to the definition it means. */
    static final String REFERENCE_PATTERN_FQN = "ELM reference pattern (ELM)";

    /** The catalog's parent of every position; the three roles hang under it. */
    static final String POSITION_PARENT_FQN = "ELM position (ELM)";

    /** The three roles that replace the catalog's operand where a node kind takes two or three. */
    static final String FIRST_OPERAND_FQN = "ELM first operand position (ELM)";
    static final String SECOND_OPERAND_FQN = "ELM second operand position (ELM)";
    static final String THIRD_OPERAND_FQN = "ELM third operand position (ELM)";

    private ElmTreeSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        // ── The family root ──
        set.concept(ROOT_FQN).at(inception)
                .synonym("ELM trees")
                .definition("How ELM logic is held in IKE: one tree per definition of a library,"
                        + " ordered lists where order carries meaning, and references as links."
                        + " The ELM node catalog says what each node may hold; this family says how"
                        + " a library's definitions are recorded as semantics.")
                .isA(IkeTerm.MODEL_CONCEPT);
        EntityProxy.Concept root = set.conceptRef(ROOT_FQN);
        EntityProxy.Concept positionParent = set.conceptRef(POSITION_PARENT_FQN);

        // ── The three operand roles ──
        set.concept(FIRST_OPERAND_FQN).at(inception)
                .synonym("ELM first operand position")
                .definition("The first of the two or three operands an ELM operator takes. Where a"
                        + " node kind takes exactly two or three operands, our tree names them first,"
                        + " second, and third in place of the catalog's operand, so that no order is"
                        + " needed to tell them apart.")
                .isA(positionParent);
        set.concept(SECOND_OPERAND_FQN).at(inception)
                .synonym("ELM second operand position")
                .definition("The second of the two or three operands an ELM operator takes, named in"
                        + " place of the catalog's operand where a node kind takes exactly two or"
                        + " three.")
                .isA(positionParent);
        set.concept(THIRD_OPERAND_FQN).at(inception)
                .synonym("ELM third operand position")
                .definition("The third of the three operands an ELM operator takes, named in place of"
                        + " the catalog's operand where a node kind takes exactly three.")
                .isA(positionParent);

        // ── The tree pattern ──
        set.concept("ELM library of definitions (ELM)").at(inception)
                .synonym("ELM library of definitions")
                .definition("A library of definitions, as ELM gives it: the concept a tree semantic"
                        + " is about. One library concept per library id; its CQL versions are"
                        + " versions of its definition semantics, and the version string is data on"
                        + " its identity record.")
                .isA(root);
        set.concept("ELM tree (ELM)").at(inception)
                .synonym("ELM tree")
                .definition("A tree whose vertices are ELM nodes: the one field of the ELM tree"
                        + " pattern. A vertex is one ELM node kind; a position that holds a plain"
                        + " value is a property on the vertex; a position that holds a node is an"
                        + " edge, named by an argument vertex between the two whose meaning is the"
                        + " position filled. The tree carries no order.")
                .isA(root);
        set.concept("ELM definition (ELM)").at(inception)
                .synonym("ELM definition")
                .definition("One definition of a library as ELM gives it: a using, an include, a"
                        + " parameter, a code system, a value set, a code, a concept, a context, an"
                        + " expression define, or a function define, or the library's own identity"
                        + " record. Why a tree is recorded.")
                .isA(root);
        set.pattern(TREE_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef("ELM library of definitions (ELM)"))
                .purpose(set.conceptRef("ELM definition (ELM)"))
                .field(set.conceptRef("ELM tree (ELM)"), set.conceptRef("ELM definition (ELM)"),
                        IkeTerm.DITREE_FIELD)
                .definition("One definition of a library, or the library's own identity record, as"
                        + " one tree of ELM nodes, about the library concept. One field: the tree."
                        + " Each definition semantic also carries a description with its name in the"
                        + " CQL dialect, so the index finds definitions by name.");

        // ── The ordered list pattern ──
        set.concept("ELM list items (ELM)").at(inception)
                .synonym("ELM list items")
                .definition("The items of one ELM list position, in order: the one field of the ELM"
                        + " ordered list pattern. Each item is an ELM tree semantic of its own, about"
                        + " the library, identified by what it contains.")
                .isA(root);
        set.concept("ELM order (ELM)").at(inception)
                .synonym("ELM order")
                .definition("The order of items where ELM order carries meaning, such as the items of"
                        + " a sort, the items of a case, the elements of a list, or the operands of a"
                        + " function. Why a list is recorded apart from the tree.")
                .isA(root);
        set.pattern(ORDERED_LIST_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef("ELM definition (ELM)"))
                .purpose(set.conceptRef("ELM order (ELM)"))
                .field(set.conceptRef("ELM list items (ELM)"), set.conceptRef("ELM order (ELM)"),
                        IkeTerm.COMPONENT_ID_LIST_FIELD)
                .definition("The items an ELM list position holds, in order, each an ELM tree of its"
                        + " own, about the definition whose tree points at the list. One field: the"
                        + " items. Reordering is a new version of the list; editing an item is a new"
                        + " item.");

        // ── The reference pattern ──
        set.concept("ELM reference (ELM)").at(inception)
                .synonym("ELM reference")
                .definition("A thing a definition names: another define, a value set, a code, a code"
                        + " system, a concept, a parameter, a function, or an included library. Why a"
                        + " reference is recorded: so that every name is a link the store can follow"
                        + " and check.")
                .isA(root);
        set.concept("ELM reference kind (ELM)").at(inception)
                .synonym("ELM reference kind")
                .definition("The kind of thing a definition names, as one of the catalog's reference"
                        + " node kinds, such as ELM ValueSetRef or ELM ExpressionRef.")
                .isA(root);
        set.concept("ELM referenced definition (ELM)").at(inception)
                .synonym("ELM referenced definition")
                .definition("The definition a name means, as a direct link to that definition's"
                        + " semantic.")
                .isA(root);
        set.concept("ELM name as written (ELM)").at(inception)
                .synonym("ELM name as written")
                .definition("The name exactly as the library writes it.")
                .isA(root);
        set.concept("ELM library name as written (ELM)").at(inception)
                .synonym("ELM library name as written")
                .definition("The library name exactly as written, empty when the thing named is in"
                        + " the same library.")
                .isA(root);
        EntityProxy.Concept reference = set.conceptRef("ELM reference (ELM)");
        set.pattern(REFERENCE_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef("ELM definition (ELM)"))
                .purpose(reference)
                .field(set.conceptRef("ELM reference kind (ELM)"), reference, IkeTerm.CONCEPT_FIELD)
                .field(set.conceptRef("ELM referenced definition (ELM)"), reference,
                        IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("ELM name as written (ELM)"), reference, IkeTerm.STRING)
                .field(set.conceptRef("ELM library name as written (ELM)"), reference, IkeTerm.STRING)
                .definition("One thing a definition names, about the definition semantic that names"
                        + " it: the kind of thing, the definition it is as a link, and the names as"
                        + " written. One semantic per distinct thing named, not per place it is named;"
                        + " the tree keeps only the name as written.");
    }
}
