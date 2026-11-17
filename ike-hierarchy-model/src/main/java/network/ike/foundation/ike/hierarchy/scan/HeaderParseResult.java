package network.ike.foundation.ike.hierarchy.scan;

import network.ike.foundation.ike.hierarchy.model.ChapterHeader;

/**
 * What reading the top of an AsciiDoc file established about it.
 *
 * <p>Three outcomes, and the distinction between the last two is the one that matters. A file
 * with no {@code :chapter-id:} is simply not a chapter — an included fragment, a scratch draft, a
 * README — and is skipped without comment. A file that declares an identifier but gets some part
 * of the declaration wrong is a chapter its author expected to appear in the guide, so it fails
 * the build instead of vanishing.
 */
public sealed interface HeaderParseResult {

    /** A file that declares no chapter identity, and is therefore not part of any hierarchy. */
    record NotAChapter() implements HeaderParseResult {
    }

    /**
     * A well-formed chapter declaration.
     *
     * @param header the parsed declaration
     */
    record Parsed(ChapterHeader header) implements HeaderParseResult {
        /**
         * Checks that a parsed result carries a header.
         *
         * @throws IllegalArgumentException if the header is null
         */
        public Parsed {
            if (header == null) {
                throw new IllegalArgumentException("A parsed result requires a header");
            }
        }
    }

    /**
     * A file that meant to declare a chapter but could not be understood.
     *
     * @param detail what specifically was wrong, phrased for the author who must fix it
     */
    record Malformed(String detail) implements HeaderParseResult {
        /**
         * Checks that a malformed result explains itself.
         *
         * @throws IllegalArgumentException if the detail is null or blank
         */
        public Malformed {
            if (detail == null || detail.isBlank()) {
                throw new IllegalArgumentException("A malformed result requires a detail message");
            }
        }
    }
}
