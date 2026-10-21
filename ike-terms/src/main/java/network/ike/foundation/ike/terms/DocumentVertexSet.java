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

/**
 * Declares a structured document as semantic vertices (IKE-Network/ike-issues#1313; design
 * {@code design-2026-10-20-instance-data}): every line and every block of a document is a
 * semantic whose one field is a vertex, carrying the vertex's meaning concept and its properties
 * keyed by concept. The semantic gives the vertex identity, its own STAMP versions and an address
 * anything in its scope can reference.
 *
 * <p><b>Meanings are bare nouns.</b> A vertex reads by what it is: Section, Paragraph, Heading,
 * Prose. The block meanings are the document elements {@link DocumentStructureSet} and
 * {@link AsciiDocModelSet} declare, whose preferred synonyms are the bare nouns; this set adds the
 * meanings of lines, under <em>Document line</em>, and the property keys a vertex carries beyond
 * those sets' fields (Level, Title, Parameters, Members, Target, Term, Attribute name, Negated).
 *
 * <p><b>The template.</b> The <em>Document vertex pattern</em> is a template: nothing writes
 * elements against it. Each document derives a pattern of its own from it, written under the
 * document's module, so the document's vertices occupy one contiguous key range for their whole
 * life and deleting the document is one range delete. Parentage and order are a versioned Members
 * property on the parent vertex, since a semantic's referenced component is fixed on its
 * chronology: every vertex references its document's root.
 */
final class DocumentVertexSet {

    static final String ROOT_FQN = DocumentStructureSet.ROOT_FQN;

    /** The template every document's own vertex pattern is derived from. */
    static final String DOCUMENT_VERTEX_PATTERN = fqn("Document vertex pattern");

    private static final EntityProxy.Concept DISPLAY_FIELDS =
            EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of("4e627b9c-cecb-5563-82fc-cb0ee25113b1"));

    private DocumentVertexSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        // ── The vertex data type ─────────────────────────────────────────────────
        set.concept(fqn("Vertex data type")).at(inception)
                .synonym("Vertex data type")
                .definition("A field data type whose value is one vertex: its meaning concept and its"
                        + " properties keyed by concept, with no edges of its own. A semantic whose one"
                        + " field is a vertex is a vertex with an identity, its own STAMP versions and an"
                        + " address, which a directed tree held in one field does not give its vertices.")
                .isA(DISPLAY_FIELDS);

        // ── Line meanings ────────────────────────────────────────────────────────
        String element = DocumentStructureSet.fqn("Document element");
        named(set, inception, "Document line", "Document line", element,
                "One line of a structured document as a vertex: what the line is, with the parts its"
                        + " markup carried as properties and the line as written as its Line source.");
        line(set, inception, "Heading line", "Heading",
                "The line that opens a section, such as == Machine identity: its Level and Title are"
                        + " properties.");
        line(set, inception, "Block title line", "Block title",
                "A line naming the block below it, such as .Views and the layer: its Title is a"
                        + " property.");
        line(set, inception, "Block attribute line", "Block attributes",
                "A line of attributes for the block below it, such as [cols=\"1,3\"]: its Parameters"
                        + " are a property, kept as written.");
        line(set, inception, "Attribute entry line", "Attribute entry",
                "A document attribute set or unset, such as :topic-id: dev-example: its Attribute name"
                        + " and Attribute value are properties.");
        line(set, inception, "Anchor line", "Anchor",
                "A line naming an anchor for what follows, such as [[dev-example]]: its Anchor id is a"
                        + " property.");
        line(set, inception, "Item line", "Item",
                "The first line of a list item, such as * an item or term:: text: its Marker, Depth and"
                        + " Term or text are properties.");
        line(set, inception, "Delimiter line", "Delimiter",
                "A line that opens or closes a delimited block, such as ---- or |===.");
        line(set, inception, "Comment line", "Comment line",
                "A line comment, such as // a note to the authors; the bare word Comment names the"
                        + " kernel's comment pattern, so this keeps its qualifier.");
        line(set, inception, "Blank line", "Blank line",
                "An empty line, which separates blocks and ends a paragraph.");
        line(set, inception, "Prose line", "Prose",
                "A line of running text; under semantic line breaks, one claim.");
        line(set, inception, "Verbatim line", "Verbatim",
                "A line of a listing, a literal or a diagram, kept exactly as written.");

        // ── Property keys ────────────────────────────────────────────────────────
        named(set, inception, "Document vertex property", "Document vertex property", ROOT_FQN,
                "A key of a property a document vertex carries, beside the document fields reused as"
                        + " keys: Level, Title, Parameters, Members, Target, Term, Attribute name and"
                        + " Negated.");
        property(set, inception, "Line source", "Line source",
                "The line exactly as the file has it, markup included, so the file reads back byte for"
                        + " byte whatever the line's other properties say.");
        property(set, inception, "Attribute value", "Attribute value",
                "The value an attribute entry sets, empty when it only sets or unsets the attribute.");
        property(set, inception, "Anchor id", "Anchor id",
                "The id an anchor line names.");
        property(set, inception, "List marker", "Marker",
                "The marker an item line opens with, such as *, ., 1. or ::.");
        property(set, inception, "List depth", "Depth",
                "How deep an item sits in nested lists, from one.");

        // ── The template pattern ─────────────────────────────────────────────────
        named(set, inception, "Document vertex", "Document vertex", ROOT_FQN,
                "A line or a block of a structured document held as a semantic whose one field is its"
                        + " vertex: the meaning of the document vertex pattern and of every pattern a"
                        + " document derives from it.");
        named(set, inception, "Document vertex value", "Document vertex value", ROOT_FQN,
                "The vertex a document vertex semantic carries, its meaning concept and its"
                        + " properties: the field of the document vertex pattern.");
        ConceptFacade structure = set.conceptRef(DocumentStructureSet.fqn("Document structure"));
        set.pattern(DOCUMENT_VERTEX_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Document vertex")))
                .purpose(structure)
                .field(set.conceptRef(fqn("Document vertex value")), structure, set.conceptRef(fqn("Vertex data type")))
                .synonym("Document vertex pattern")
                .definition("The template every document's own vertex pattern is derived from: one field,"
                        + " a vertex. Nothing writes elements against the template itself; each document's"
                        + " pattern is written under the document's module, ephemeral for a document in git"
                        + " and instance otherwise, so its vertices hold one contiguous key range and"
                        + " deleting the document is one range delete.");
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }

    private static void named(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String parentFqn, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(synonym)
                .definition(definition)
                .isA(set.conceptRef(parentFqn));
    }

    private static void line(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String definition) {
        named(set, stamp, name, synonym, fqn("Document line"), definition);
    }

    private static void property(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String definition) {
        named(set, stamp, name, synonym, fqn("Document vertex property"), definition);
    }
}
