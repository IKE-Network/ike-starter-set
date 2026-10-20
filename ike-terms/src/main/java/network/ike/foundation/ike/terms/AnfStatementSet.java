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
 * Declares an ANF statement as a tree (IKE-Network/ike-issues#1312, under #812 of epic #806,
 * referencing the ANF epic #725): the ANF statement pattern, whose one field is a {@code DITREE},
 * the meaning of each vertex of that tree, the keys of the properties a vertex carries, and the
 * association types a statement records against another.
 *
 * <p><b>One statement, one tree.</b> The root vertex is the statement; its two children are the
 * context, whose children are the envelope attributes of the structural definition, and exactly
 * one circumstance, a performance, a request or a narrative, whose children are that kind's
 * attributes. Every attribute is a vertex whose meaning is the attribute, so a changed result or
 * a re-grounded topic is a new version of one vertex, never a new statement. Associated
 * statements are reference vertices under the root, never subtrees.
 *
 * <p><b>Measures reuse the kernel.</b> A measure vertex carries its bounds, its open flags and its
 * unit under the kernel's interval-role property keys, unchanged, so the interval row that draws
 * an interval role draws a measure. Only the resolution has no kernel key and is declared here.
 *
 * <p><b>Nesting by value.</b> A topic, a subject of information, a purpose and an author's role
 * are EL++ expressions held whole as a {@code DITREE} vertex property, adapted by the logical
 * expression stack, edited on the extracted subtree and spliced back. The degenerate case is one
 * concept reference.
 *
 * <p><b>Provisional attributes.</b> An attribute the narrative lift could not ground carries no
 * concept: a candidate (a clear meaning the knowledge base lacks) carries its label, text,
 * disposition and nearest matches; a clarification (a question the narrative leaves open) carries
 * its field and question. The same keys serve a statement under construction in the editor.
 *
 * <p>The circumstance kinds themselves, Performance, Request and Narrative circumstance, are the
 * ones {@link ElmNodeKindSet} declares under Circumstance kind, reused unchanged as the
 * circumstance vertex meanings and as the value of the statement kind property.
 */
final class AnfStatementSet {

    static final String ROOT_FQN = "ANF statement model (IkeFoundation)";

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    private AnfStatementSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        set.concept(ROOT_FQN).at(inception)
                .synonym("ANF statement model")
                .definition("An ANF statement held as one tree: the statement pattern whose field is the"
                        + " tree, the meaning of each vertex, the keys of the properties a vertex carries,"
                        + " and the association types one statement records against another.")
                .isA(IKE_BASE_MODEL_CONCEPT);

        // ── The statement and its vertices ───────────────────────────────────────
        concept(set, inception, "ANF statement", ROOT_FQN,
                "A clinical statement in Analysis Normal Form, the root vertex of its tree and the"
                        + " meaning of the ANF statement pattern: a context and exactly one circumstance,"
                        + " a performance, a request or a narrative, with the kind as a property.");
        concept(set, inception, "ANF statement element", ROOT_FQN,
                "A vertex of an ANF statement's tree beneath the root: the context, a circumstance,"
                        + " or an attribute of either.");

        // The context and its envelope attributes.
        element(set, inception, "ANF context",
                "The envelope of a statement: a clause whose children are who and what the statement"
                        + " is about, its type, its authors and when it was made.");
        element(set, inception, "ANF subject of record",
                "Who the statement is about: a reference to the participant, with the participant's"
                        + " role as a property.");
        element(set, inception, "ANF subject of information",
                "Who or what the statement is about when that is not the subject of record, such as a"
                        + " relative in a family history: an expression held by value.");
        element(set, inception, "ANF topic",
                "What the statement is about: at authoring time an expression held by value, whose"
                        + " degenerate case is one concept reference; instance data keeps a concept, and"
                        + " a composed topic is promoted to a complex concept.");
        element(set, inception, "ANF statement type",
                "A reference to the statement's kind, a circumstance kind, the same the root carries"
                        + " as its statement kind property.");
        element(set, inception, "ANF author",
                "Who made the statement: a reference to the participant with the participant's role"
                        + " as an expression held by value; a statement may have several.");
        element(set, inception, "ANF statement time",
                "When the statement was made: a measure.");

        // Attributes any circumstance may carry.
        element(set, inception, "ANF timing",
                "When a performance occurred or a request is to be carried out: a measure.");
        element(set, inception, "ANF purpose",
                "Why a performance was done or a request made: an expression held by value; a"
                        + " circumstance may have several.");

        // Performance attributes.
        element(set, inception, "ANF result",
                "What a performance determined: a measure. Presence is the interval from one with no"
                        + " upper bound on the Presence scale and absence the interval from zero to zero,"
                        + " a result and never a negated topic.");
        element(set, inception, "ANF disposition",
                "What became of the act or the order: a concept reference.");
        element(set, inception, "ANF health risk",
                "The clinical interpretation of a result: a concept reference.");
        element(set, inception, "ANF normal range",
                "The reference range of a performance's result: a measure.");
        element(set, inception, "ANF method",
                "How a determination was made or a request is to be carried out: a concept reference.");
        element(set, inception, "ANF device",
                "The instrument used or to be used: a concept reference.");
        element(set, inception, "ANF body site",
                "The anatomical location: a concept reference.");
        element(set, inception, "ANF laterality",
                "Left, right or bilateral: a concept reference.");
        element(set, inception, "ANF approach",
                "The surgical approach or access route: a concept reference.");
        element(set, inception, "ANF specimen type",
                "The kind of specimen: a concept reference.");
        element(set, inception, "ANF specimen source site",
                "Where a specimen was or is to be taken from: a concept reference.");
        element(set, inception, "ANF participant",
                "Who performed or assisted, or who should: a reference to the participant with the"
                        + " participant's role as a property; a circumstance may have several.");

        // Request attributes.
        element(set, inception, "ANF priority",
                "Routine, urgent or stat: a concept reference.");
        element(set, inception, "ANF requested result",
                "The result a request seeks: a measure.");
        element(set, inception, "ANF repetition",
                "The schedule of a request: a clause whose children are the period start, the period"
                        + " duration, the event separation, the event duration and the event frequency.");
        element(set, inception, "ANF period start",
                "When a repetition's schedule begins: a measure.");
        element(set, inception, "ANF period duration",
                "How long a repetition's schedule runs: a measure.");
        element(set, inception, "ANF event separation",
                "The gap between a repetition's successive events: a measure.");
        element(set, inception, "ANF event duration",
                "How long each event of a repetition lasts: a measure.");
        element(set, inception, "ANF event frequency",
                "How often a repetition's events occur: a measure.");
        element(set, inception, "ANF conditional trigger",
                "A condition for a request's execution: a concept reference; a request may have"
                        + " several.");
        element(set, inception, "ANF location",
                "Where a request is to be carried out: a concept reference.");

        // Narrative.
        element(set, inception, "ANF narrative text",
                "The unstructured content of a narrative circumstance: text carried as the kernel's"
                        + " literal value, the escape valve for content that resists structure.");

        // Associated statements.
        element(set, inception, "ANF associated statement",
                "A reference from this statement to another, carrying the association type as a"
                        + " property; the other statement stays a reference, never a subtree.");

        // ── Property keys ────────────────────────────────────────────────────────
        concept(set, inception, "ANF statement property", ROOT_FQN,
                "A key of a property a vertex of an ANF statement's tree carries, beside the kernel's"
                        + " concept reference, literal value and interval keys, which the tree reuses.");
        property(set, inception, "ANF statement kind",
                "Which kind of statement the root vertex is: a circumstance kind, Performance, Request"
                        + " or Narrative, the kind of the statement's one circumstance.");
        property(set, inception, "ANF participant role",
                "The role of the participant a subject of record or a participant vertex references:"
                        + " a concept.");
        property(set, inception, "ANF author role expression",
                "The role of the participant an author vertex references, as an expression held by"
                        + " value: a tree.");
        property(set, inception, "ANF logical expression",
                "The expression a topic, a subject of information or a purpose vertex holds by value:"
                        + " a tree over the kernel's logical expression meanings.");
        property(set, inception, "ANF measure resolution",
                "The significant digits or precision of a measure's bounds: a decimal.");
        property(set, inception, "ANF associated statement reference",
                "The statement an associated statement vertex refers to: a component.");
        property(set, inception, "ANF association type",
                "How an associated statement relates to this one: a statement association concept.");
        property(set, inception, "ANF provisional label",
                "The label of a candidate concept an attribute would reference, a clear meaning the"
                        + " knowledge base does not yet carry.");
        property(set, inception, "ANF provisional text",
                "The narrative text a candidate concept's meaning came from.");
        property(set, inception, "ANF provisional disposition",
                "What is to be done with a candidate concept: pending, match an existing concept,"
                        + " post-coordinate, propose a new concept, align a synonym, or leave narrative.");
        property(set, inception, "ANF provisional nearest matches",
                "Identifiers of the existing concepts nearest a candidate's meaning, as evidence for"
                        + " its disposition.");
        property(set, inception, "ANF clarification field",
                "The attribute a clarification could not settle, a question the narrative leaves open.");
        property(set, inception, "ANF clarification question",
                "The question to put to the author about the attribute a clarification names.");

        // ── Association types ────────────────────────────────────────────────────
        concept(set, inception, "Statement association", ROOT_FQN,
                "How one ANF statement relates to another, recorded on the statement that is the"
                        + " association's source in its canonical direction; the inverse is recorded on"
                        + " the other statement under the inverse type.");
        association(set, inception, "Statement composes",
                "This statement is a part of the statement it references, which composes it; the"
                        + " canonical direction of composition, recorded on the part.");
        association(set, inception, "Statement composed of",
                "The statement it references is a part of this one: the inverse of Statement composes,"
                        + " recorded on the part as Statement composes.");
        association(set, inception, "Statement follows in time",
                "This statement's circumstance came after the one it references; the canonical"
                        + " direction of temporal order, recorded on the later statement.");
        association(set, inception, "Statement precedes in time",
                "This statement's circumstance came before the one it references: the inverse of"
                        + " Statement follows in time, recorded on the later statement as that.");
        association(set, inception, "Statement compares against",
                "This statement's result is compared against the one it references, such as a"
                        + " baseline.");
        association(set, inception, "Statement supports",
                "This statement is evidence for the one it references.");
        association(set, inception, "Statement contradicts",
                "This statement is evidence against the one it references.");
        association(set, inception, "Statement replicates",
                "This statement repeats the determination the one it references made.");
        association(set, inception, "Statement overrules",
                "This statement supersedes the one it references, which no longer stands.");
        association(set, inception, "Statement amends",
                "This statement corrects or extends the one it references, which still stands.");

        // ── The pattern ──────────────────────────────────────────────────────────
        concept(set, inception, "ANF statement structure", ROOT_FQN,
                "Carrying an ANF statement as a tree: the purpose of the ANF statement pattern and its"
                        + " field.");
        concept(set, inception, "ANF statement tree", ROOT_FQN,
                "The tree that is the statement: the field of the ANF statement pattern.");

        ConceptFacade structure = set.conceptRef(fqn("ANF statement structure"));
        set.pattern(fqn("ANF statement pattern")).at(inception)
                .meaning(set.conceptRef(fqn("ANF statement")))
                .purpose(structure)
                .field(set.conceptRef(fqn("ANF statement tree")), structure, KernelConcept.DITREE_FIELD)
                .synonym("ANF statement pattern")
                .definition("One clinical statement in Analysis Normal Form, held as one tree whose root"
                        + " is the statement, whose vertices are its context, its one circumstance and"
                        + " their attributes, and whose vertex identities persist across versions, so a"
                        + " changed attribute is a new version of one vertex.");
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
        concept(set, stamp, name, fqn("ANF statement element"), definition);
    }

    private static void property(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        concept(set, stamp, name, fqn("ANF statement property"), definition);
    }

    private static void association(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        concept(set, stamp, name, fqn("Statement association"), definition);
    }
}
