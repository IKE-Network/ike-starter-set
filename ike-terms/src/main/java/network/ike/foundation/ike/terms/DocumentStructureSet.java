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
 * Declares the structure a document and a conversation journal have in common
 * (IKE-Network/ike-issues#844): one block model for both, so a block of a topic
 * materialized from git and a block of a conversation with the Komet assistant are the
 * same kind of semantic, and an action's subject is that semantic either way.
 *
 * <p><b>Lines, then blocks.</b> A structured document's lines are prose elements
 * ({@link ProseElementSet}), one per line, ordered by the journal manifest. The elements
 * declared here group lines: a section, a paragraph, a listing, a table, a list, and in a
 * journal a turn. Each is one semantic of the document block pattern, whose members are
 * its lines and child elements in order, and which gets a new version only when one of
 * its fields changes. Where a block's identity comes from depends on its origin: a block
 * of a git document takes its identifying line's identity, and a journal block is given
 * one when its turn is written.
 *
 * <p><b>Neutral names.</b> The structure here is the part AsciiDoc and Markdown share. What
 * only AsciiDoc has — example and sidebar blocks, admonitions, diagrams, bibliography
 * entries, inline references, includes, conditionals, the topic attributes — stays in
 * {@link AsciiDocModelSet}, in the AsciiDoc document module, as children of these
 * elements. Everything here stamps in the foundation module, so a store holding
 * conversations needs no AsciiDoc vocabulary.
 */
final class DocumentStructureSet {

    static final String ROOT_FQN = "Document structure model (IkeFoundation)";

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    private DocumentStructureSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp foundation = Ike.INCEPTION;

        set.concept(ROOT_FQN).at(foundation)
                .synonym("Document structure model")
                .definition("The structure a document and a conversation journal have in common:"
                        + " lines held as prose elements in the order a manifest gives them, and"
                        + " the elements that group them, so either is held line for line with its"
                        + " provenance and given back unchanged.")
                .isA(IKE_BASE_MODEL_CONCEPT);

        // ── Elements ─────────────────────────────────────────────────────────────
        concept(set, foundation, "Structured document", ROOT_FQN,
                "Anything held as lines in manifest order and grouped into elements: a"
                        + " document materialized from a repository, or a conversation journal.");
        concept(set, foundation, "Document element", ROOT_FQN,
                "Anything that groups a structured document's lines: a section, a block, a"
                        + " row, a cell, a list item, a conversation turn. The lines themselves"
                        + " are prose elements, which these elements group.");
        named(set, foundation, "Document section", "Section", fqn("Document element"),
                "A section: a heading of some level and the elements beneath it until the next"
                        + " heading of that level or shallower.");
        concept(set, foundation, "Document block", fqn("Document element"),
                "A block-level element grouping lines: the paragraphs, listings, quotations,"
                        + " lists, tables and images a section or a turn contains.");
        named(set, foundation, "Document paragraph", "Paragraph", fqn("Document block"),
                "A run of prose lines up to a blank line; under semantic line breaks each line is"
                        + " one claim, so the paragraph groups claims and the line keeps the"
                        + " provenance.");
        named(set, foundation, "Document listing", "Listing", fqn("Document block"),
                "A delimited block of text kept as written, such as an AsciiDoc ---- listing or a"
                        + " Markdown fenced block; its language or other tag is in its parameters.");
        named(set, foundation, "Document quotation", "Quotation", fqn("Document block"),
                "A quotation block, with its attribution in its parameters when it has one.");
        named(set, foundation, "Document table", "Table", fqn("Document block"),
                "A table; its column specification and options are its parameters, its rows its"
                        + " members.");
        named(set, foundation, "Document table row", "Row", fqn("Document block"),
                "One row of a table; its cells are its members.");
        named(set, foundation, "Document table cell", "Cell", fqn("Document block"),
                "One cell of a table row; its lines are its members.");
        named(set, foundation, "Document list", "List", fqn("Document block"),
                "An unordered, ordered or description list; the kind is in its parameters, its"
                        + " items its members.");
        named(set, foundation, "Document list item", "List item", fqn("Document block"),
                "One item of a list, with its continuation blocks as members; a description"
                        + " list item's term is its title.");
        named(set, foundation, "Document image", "Image", fqn("Document block"),
                "An image; the target and the alternative text are in its parameters.");
        named(set, foundation, "Document opaque block", "Opaque block", fqn("Document block"),
                "A block the parse recognises but does not model, kept verbatim so the document"
                        + " reads back unchanged.");

        // ── Fields and purpose ───────────────────────────────────────────────────
        concept(set, foundation, "Document field", ROOT_FQN,
                "A field of the document block pattern.");
        concept(set, foundation, "Document element kind", fqn("Document field"),
                "Which element a block semantic is: a concept under Document element.");
        named(set, foundation, "Document element level", "Level", fqn("Document field"),
                "A section's heading level, or a list's nesting depth.");
        named(set, foundation, "Document element title", "Title", fqn("Document field"),
                "A section's heading text, a block's title, a description list item's term.");
        named(set, foundation, "Document element parameters", "Parameters", fqn("Document field"),
                "The element's parameters as written, such as an AsciiDoc attribute line or a"
                        + " Markdown fence's info string, kept verbatim so the document reads back"
                        + " unchanged; a reader parses what it needs.");
        named(set, foundation, "Document element members", "Members", fqn("Document field"),
                "The lines and elements an element contains, in order.");
        concept(set, foundation, "Document structure", ROOT_FQN,
                "Carrying a structured document's structure: the purpose of the document block"
                        + " and document attributes patterns and their fields.");

        ConceptFacade structure = set.conceptRef(fqn("Document structure"));
        set.pattern(fqn("Document block pattern")).at(foundation)
                .meaning(set.conceptRef(fqn("Document element")))
                .purpose(structure)
                .field(set.conceptRef(fqn("Document element kind")), structure, KernelConcept.COMPONENT_FIELD)
                .field(set.conceptRef(fqn("Document element level")), structure, KernelConcept.INTEGER_FIELD)
                .field(set.conceptRef(fqn("Document element title")), structure, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Document element parameters")), structure, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Document element members")), structure, KernelConcept.COMPONENT_ID_LIST_FIELD)
                .synonym("Document block pattern")
                .definition("One element of a structured document — a section, a block, a row, a"
                        + " cell, a list, an item or a turn — with its kind, level, title,"
                        + " verbatim parameters and ordered members; a new version only when one"
                        + " of these changes.");

        // ── Conversation journals ────────────────────────────────────────────────
        named(set, foundation, "Conversation journal", "Journal", fqn("Structured document"),
                "A conversation held as a structured document: each conversation is anchored by"
                        + " an instance of this concept, its turns' lines are prose elements in"
                        + " manifest order, and its turns and their blocks are document elements.");
        named(set, foundation, "Conversation turn", "Turn", fqn("Document element"),
                "One turn of a conversation, by a person or by the Komet assistant; its members"
                        + " are its blocks. Who wrote it is the STAMP author of its versions, never"
                        + " a field.");
        set.concept(fqn("Komet assistant")).at(foundation)
                .synonym("Komet assistant")
                .definition("The author of the Komet assistant's turns in a conversation journal,"
                        + " and of what the assistant proposes; a person settles what it proposes.")
                .isA(KernelConcept.USER);
        set.concept(fqn("Conversation journal module")).at(foundation)
                .synonym("Conversation journal module")
                .definition("The module every conversation journal's lines, elements and manifest"
                        + " stamp in, so conversations can be carried or omitted as a unit. A journal's"
                        + " only record is the store, so the module is an instance module"
                        + " (IKE-Network/ike-issues#1313).")
                .isA(set.conceptRef(InstanceDataSet.INSTANCE_MODULE));
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }

    /**
     * A concept whose preferred synonym is the bare noun a vertex of its kind is read by, while its
     * fully qualified name keeps the qualifying words (IKE-Network/ike-issues#1313).
     */
    private static void named(KnowledgeSet set, ActiveStamp stamp, String name, String synonym, String parentFqn, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(synonym)
                .definition(definition)
                .isA(set.conceptRef(parentFqn));
    }

    private static void concept(KnowledgeSet set, ActiveStamp stamp, String name, String parentFqn, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(parentFqn));
    }
}
