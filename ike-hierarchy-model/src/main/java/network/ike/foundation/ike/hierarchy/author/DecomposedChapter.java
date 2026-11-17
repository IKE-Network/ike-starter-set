package network.ike.foundation.ike.hierarchy.author;

import java.util.List;

import network.ike.foundation.ike.hierarchy.model.ChapterHeader;

/**
 * One chapter file that decomposing an assembly document would produce.
 *
 * <p>Returned rather than written, so the goal that calls the decomposer can run the whole
 * operation in preview mode, apply the containment checks to every destination before creating
 * anything, and only then commit — instead of discovering a problem halfway through carving up
 * someone's guide.
 *
 * @param header       the declaration the new file will carry
 * @param relativePath where the file goes, relative to the assembly document's own directory
 * @param lines        the file's complete contents, without line terminators
 */
public record DecomposedChapter(ChapterHeader header, String relativePath, List<String> lines) {

    /**
     * Validates and copies the chapter.
     *
     * @throws IllegalArgumentException if a field is null, the path is blank or absolute, or the
     *                                  path contains a {@code ..} segment
     */
    public DecomposedChapter {
        if (header == null || lines == null) {
            throw new IllegalArgumentException("A decomposed chapter requires a header and lines");
        }
        if (relativePath == null || relativePath.isBlank()) {
            throw new IllegalArgumentException(
                    "Decomposed chapter '" + header.id() + "' requires a path");
        }
        relativePath = relativePath.replace('\\', '/').trim();
        if (relativePath.startsWith("/")) {
            throw new IllegalArgumentException(
                    "Decomposed chapter '" + header.id() + "' path must be relative: " + relativePath);
        }
        for (String segment : relativePath.split("/")) {
            if (segment.equals("..")) {
                throw new IllegalArgumentException(
                        "Decomposed chapter '" + header.id() + "' path escapes the guide directory");
            }
        }
        lines = List.copyOf(lines);
    }
}
