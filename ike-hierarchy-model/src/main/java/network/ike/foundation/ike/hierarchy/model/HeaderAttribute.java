package network.ike.foundation.ike.hierarchy.model;

import java.util.Locale;
import java.util.Optional;

/**
 * The closed vocabulary of AsciiDoc attribute entries that carry a chapter's hierarchy
 * declaration.
 *
 * <p>These are the entire contract between a chapter file and the build. A chapter is
 * discoverable because it sets {@link #CHAPTER_ID}; it is placed because it sets
 * {@link #CHAPTER_PARENT} and {@link #CHAPTER_ORDER}. No sidecar file, registry entry, or edit
 * to a central document is involved, which is what makes a chapter relocatable to any directory
 * beneath a scan root.
 *
 * <p>Modelled as an enum rather than string constants so that the parser, the stamper, and the
 * decomposer cannot drift apart on spelling, and so that adding an attribute forces every
 * exhaustive switch over the vocabulary to be revisited.
 */
public enum HeaderAttribute {

    /** The chapter's stable identity. Required; its presence is what marks a file as a chapter. */
    CHAPTER_ID("chapter-id"),
    /** The chapter's display title. Optional; falls back to the file's level-1 heading. */
    CHAPTER_TITLE("chapter-title"),
    /** The identifier of the chapter or root this chapter hangs beneath. */
    CHAPTER_PARENT("chapter-parent"),
    /** The integer sort key among siblings. Optional; defaults to {@link ChapterHeader#DEFAULT_ORDER}. */
    CHAPTER_ORDER("chapter-order"),
    /** The editorial lifecycle state. Optional; defaults to {@link ChapterStatus#DEFAULT}. */
    CHAPTER_STATUS("chapter-status"),
    /** Valueless marker declaring this file an assembly root rather than a placed chapter. */
    CHAPTER_ROOT("chapter-root");

    /** The prefix every hierarchy attribute shares, used to cheaply filter header lines. */
    public static final String PREFIX = "chapter-";

    private final String attributeName;

    HeaderAttribute(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * Returns the AsciiDoc attribute name as it appears between colons in a chapter file.
     *
     * @return the attribute name, for example {@code chapter-id}
     */
    public String attributeName() {
        return attributeName;
    }

    /**
     * Returns the full attribute entry line for a value, ready to write into a file.
     *
     * @param value the attribute value; when null or blank the entry is written valueless
     * @return a single AsciiDoc attribute entry line, without a trailing newline
     */
    public String entry(String value) {
        if (value == null || value.isBlank()) {
            return ":" + attributeName + ":";
        }
        return ":" + attributeName + ": " + value;
    }

    /**
     * Resolves an attribute name to a member of the vocabulary.
     *
     * @param name the attribute name found between colons, possibly null or unrecognised
     * @return the matching attribute, or empty when the name is not part of this vocabulary
     */
    public static Optional<HeaderAttribute> fromAttributeName(String name) {
        if (name == null || name.isBlank()) {
            return Optional.empty();
        }
        String token = name.trim().toLowerCase(Locale.ROOT);
        for (HeaderAttribute candidate : values()) {
            if (candidate.attributeName.equals(token)) {
                return Optional.of(candidate);
            }
        }
        return Optional.empty();
    }
}
