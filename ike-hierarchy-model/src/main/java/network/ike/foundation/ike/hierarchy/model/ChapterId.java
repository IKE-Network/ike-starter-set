package network.ike.foundation.ike.hierarchy.model;

import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * The stable, project-wide identity of a chapter.
 *
 * <p>A chapter identifier is the only coupling between a chapter file and the rest of the
 * project: nothing references a chapter by path, so a chapter file may be moved anywhere
 * beneath a scan root without any other file changing. Identifiers are therefore constrained
 * to a conservative, case-insensitive, filesystem- and URL-safe shape so that they can be used
 * unescaped in include targets, generated anchors, and index keys.
 *
 * <p>The permitted shape is lowercase kebab-case: an ASCII letter or digit, followed by any
 * number of ASCII letters, digits, or single hyphens, ending in a letter or digit. Identifiers
 * are normalised to lower case on construction, so {@code CQL} and {@code cql} are the same
 * identity and collide during validation.
 *
 * @param value the normalised, validated identifier text
 */
public record ChapterId(String value) implements Comparable<ChapterId> {

    /** The longest permitted identifier, bounding index size and generated anchor length. */
    public static final int MAX_LENGTH = 96;

    private static final Pattern SHAPE = Pattern.compile("[a-z0-9]+(?:-[a-z0-9]+)*");

    /**
     * Validates and normalises the identifier text.
     *
     * @throws IllegalArgumentException if the text is null, blank, over {@link #MAX_LENGTH}
     *                                  characters, or not lowercase kebab-case
     */
    public ChapterId {
        if (value == null) {
            throw new IllegalArgumentException("Chapter id must not be null");
        }
        value = value.trim().toLowerCase(Locale.ROOT);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Chapter id must not be blank");
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    "Chapter id exceeds " + MAX_LENGTH + " characters: " + value);
        }
        if (!SHAPE.matcher(value).matches()) {
            throw new IllegalArgumentException(
                    "Chapter id must be lowercase kebab-case (letters, digits, single hyphens): " + value);
        }
    }

    /**
     * Parses an identifier, returning empty rather than throwing when the text is unusable.
     *
     * <p>Used on the scanning path, where a malformed identifier in one file must be reported
     * as a validation violation naming that file rather than aborting the whole scan.
     *
     * @param text the raw identifier text, possibly null, blank, or malformed
     * @return the parsed identifier, or empty if {@code text} is not a well-formed identifier
     */
    public static Optional<ChapterId> parse(String text) {
        if (text == null || text.isBlank()) {
            return Optional.empty();
        }
        try {
            return Optional.of(new ChapterId(text));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    /**
     * Orders identifiers lexicographically, giving scans a deterministic tie-break.
     *
     * @param other the identifier to compare against
     * @return a negative integer, zero, or a positive integer per {@link Comparable}
     */
    @Override
    public int compareTo(ChapterId other) {
        return value.compareTo(other.value);
    }

    /**
     * Returns the identifier text, so an identifier interpolates cleanly into messages.
     *
     * @return the normalised identifier text
     */
    @Override
    public String toString() {
        return value;
    }
}
