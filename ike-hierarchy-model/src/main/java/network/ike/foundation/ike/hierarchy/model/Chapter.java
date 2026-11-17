package network.ike.foundation.ike.hierarchy.model;

import java.nio.file.Path;

/**
 * A chapter as discovered on disk: its self-declared hierarchy header, bound to the location it
 * was found at.
 *
 * <p>The location is held as a path relative to the scan root rather than an absolute path, for
 * two reasons. It keeps the generated index reproducible across machines and checkouts, so two
 * builds of the same tree produce byte-identical indexes. And it means a consumer of the index
 * can only ever re-anchor a chapter beneath a root it already trusts — a tampered or stale index
 * cannot name a path outside the project, because it has no way to express one.
 *
 * @param header       the chapter's self-declaration
 * @param relativePath the chapter file's location relative to {@code rootId}'s directory,
 *                     always using {@code /} separators
 * @param rootId       the identifier of the scan root this chapter was discovered beneath
 */
public record Chapter(ChapterHeader header, String relativePath, String rootId) {

    /**
     * Validates the binding of a declaration to a location.
     *
     * @throws IllegalArgumentException if any component is null or blank, or if the relative
     *                                  path is absolute or contains a {@code ..} segment
     */
    public Chapter {
        if (header == null) {
            throw new IllegalArgumentException("Chapter requires a header");
        }
        if (relativePath == null || relativePath.isBlank()) {
            throw new IllegalArgumentException("Chapter " + header.id() + " requires a relative path");
        }
        if (rootId == null || rootId.isBlank()) {
            throw new IllegalArgumentException("Chapter " + header.id() + " requires a root id");
        }
        relativePath = relativePath.replace('\\', '/').trim();
        if (relativePath.startsWith("/")) {
            throw new IllegalArgumentException(
                    "Chapter " + header.id() + " path must be relative to its root: " + relativePath);
        }
        for (String segment : relativePath.split("/")) {
            if (segment.equals("..")) {
                throw new IllegalArgumentException(
                        "Chapter " + header.id() + " path escapes its root: " + relativePath);
            }
        }
    }

    /**
     * Returns this chapter's identity, a shorthand for {@code header().id()}.
     *
     * @return the chapter identifier
     */
    public ChapterId id() {
        return header.id();
    }

    /**
     * Resolves this chapter's file beneath the supplied root directory.
     *
     * <p>Callers must still confirm containment with
     * {@code network.ike.foundation.ike.hierarchy.scan.SafePath} before reading the result: this
     * method performs no filesystem access and so cannot see a symbolic link that leaves the
     * root.
     *
     * @param rootDirectory the directory the chapter's root identifier refers to
     * @return the resolved chapter file path
     */
    public Path resolveAgainst(Path rootDirectory) {
        Path resolved = rootDirectory;
        for (String segment : relativePath.split("/")) {
            resolved = resolved.resolve(segment);
        }
        return resolved;
    }
}
