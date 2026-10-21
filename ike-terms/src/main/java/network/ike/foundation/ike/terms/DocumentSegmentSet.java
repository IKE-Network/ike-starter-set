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
 * Declares a document's text below the line as semantic vertices (IKE-Network/ike-issues#1313;
 * design {@code design-2026-10-21-stored-text-segments}): each sentence of a document's prose is a
 * vertex of its own, and so is each inline element, with its own identity, STAMP versions and
 * annotations, while every physical line keeps its Line source and the file still reads back byte
 * for byte. A sentence's identity names no line, so a reflow leaves it alone.
 *
 * <p><b>Two orders over one text.</b> A block's Members are its lines, the physical order; its
 * <em>Content</em> lists its sentences, the logical order. A sentence's Members are its inline
 * elements, and a footnote's Content is its own sentences. A sentence's <em>Text</em> is its source,
 * markup included, with runs of whitespace collapsed; text runs between elements are not vertices,
 * since they are DocBook's character data and take the sentence's STAMP.
 *
 * <p><b>Meanings are bare nouns.</b> Sentence, Emphasis, Strong, Monospace and the rest; the
 * reference kinds (Index term, Cross reference, Link, Footnote) are the inline references
 * {@link AsciiDocModelSet} already declares, and an inline element's Target, Term, Anchor id and
 * Attribute name reuse the keys that set and {@link DocumentVertexSet} declare.
 */
final class DocumentSegmentSet {

    private DocumentSegmentSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;
        String element = DocumentStructureSet.fqn("Document element");

        // ── Text segments ────────────────────────────────────────────────────────
        named(set, inception, "Text segment", "Text segment", element,
                "A unit of a document's text below the physical line, with an identity of its own"
                        + " that no line names, so it survives a reflow; the word is TEI's seg.");
        named(set, inception, "Sentence", "Sentence", fqn("Text segment"),
                "One sentence of a document's prose, found within one run of a block's text and never"
                        + " inside an inline element: its Text is its source with whitespace collapsed,"
                        + " its Members its inline elements. A revised sentence keeps its identity.");

        // ── Inline elements ──────────────────────────────────────────────────────
        named(set, inception, "Inline element", "Inline element", element,
                "An element inside a sentence, as DocBook's mixed content holds it: formatting, a"
                        + " quotation, a line break, an anchor, an attribute reference; the inline"
                        + " references (index terms, cross references, links, footnotes) are inline"
                        + " elements too.");
        inline(set, inception, "Emphasis", "Emphasized text, such as _this_; DocBook's emphasis.");
        inline(set, inception, "Strong", "Strongly emphasized text, such as *this*; DocBook's emphasis with role strong.");
        inline(set, inception, "Monospace", "Literal or code text, such as `this`; DocBook's literal.");
        inline(set, inception, "Highlight", "Highlighted text, such as #this#; DocBook's phrase with a role.");
        inline(set, inception, "Superscript", "Raised text, such as ^2^.");
        inline(set, inception, "Subscript", "Lowered text, such as ~2~.");
        inline(set, inception, "Quotation", "Text in curved quotation marks, such as \"`this`\"; DocBook's quote.");
        inline(set, inception, "Phrase", "Text given a role, such as [.term]#this#; DocBook's phrase.");
        inline(set, inception, "Line break", "A hard line break, a + at the end of a line.");
        named(set, inception, "Inline anchor", "Inline anchor", fqn("Inline element"),
                "An anchor inside the text, such as [[id]] or anchor:id[]: its Anchor id is a property.");
        inline(set, inception, "Attribute reference", "A reference to a document attribute, such as {topics},"
                + " kept as written: its Attribute name is a property.");

        // ── Property keys ────────────────────────────────────────────────────────
        String property = DocumentVertexSet.fqn("Document vertex property");
        named(set, inception, "Block content", "Content", property,
                "A block's sentences in order, the logical order of its text beside Members, the"
                        + " physical order of its lines; a footnote's own sentences likewise.");
        named(set, inception, "Segment text", "Text", property,
                "A sentence's or inline element's source, markup included, with each run of"
                        + " whitespace collapsed to one space and a hard line break kept.");
        named(set, inception, "Secondary term", "Secondary term", property,
                "An index term's second level, such as b in indexterm:[a, b].");
        named(set, inception, "Tertiary term", "Tertiary term", property,
                "An index term's third level.");
        named(set, inception, "Inline role", "Role", property,
                "The roles a phrase or a formatted element is given, such as term in [.term]#lease#.");
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

    private static void inline(KnowledgeSet set, ActiveStamp stamp, String name, String definition) {
        named(set, stamp, name, name, fqn("Inline element"), definition);
    }
}
