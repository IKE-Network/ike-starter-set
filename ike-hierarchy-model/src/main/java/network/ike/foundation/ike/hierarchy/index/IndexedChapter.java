package network.ike.foundation.ike.hierarchy.index;

import java.util.Optional;

import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.ChapterStatus;

/**
 * One placed chapter, flattened for the index.
 *
 * <p>The index stores the forest as a list in document order with each entry's depth, rather than
 * as nested objects. A consumer rendering a subtree wants exactly this: a sequence of chapters and
 * the heading level each belongs at. Keeping it flat also caps the index's nesting depth at a
 * constant, so a hierarchy of any shape parses at the same, small stack depth.
 *
 * @param id     the chapter's stable identity
 * @param title  the resolved display title
 * @param parent the parent's identity, or empty when this entry is a root
 * @param order  the declared sort key among siblings
 * @param status the editorial lifecycle state
 * @param root   whether this entry is an assembly root rather than a placed chapter
 * @param depth  distance from the root, with the root itself at zero
 * @param rootId the identifier of the scan root the file was found beneath
 * @param path   the file's path relative to that scan root, using {@code /} separators
 */
public record IndexedChapter(
        ChapterId id,
        String title,
        Optional<ChapterId> parent,
        int order,
        ChapterStatus status,
        boolean root,
        int depth,
        String rootId,
        String path) {

    /**
     * Validates the entry.
     *
     * @throws IllegalArgumentException if a required field is null or blank, the depth is
     *                                  negative, or the path is absolute or escapes its root
     */
    public IndexedChapter {
        if (id == null || parent == null || status == null) {
            throw new IllegalArgumentException("An indexed chapter requires id, parent and status");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Indexed chapter '" + id + "' requires a title");
        }
        if (rootId == null || rootId.isBlank()) {
            throw new IllegalArgumentException("Indexed chapter '" + id + "' requires a root id");
        }
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Indexed chapter '" + id + "' requires a path");
        }
        if (depth < 0) {
            throw new IllegalArgumentException("Indexed chapter '" + id + "' has a negative depth");
        }
        path = path.replace('\\', '/').trim();
        if (path.startsWith("/")) {
            throw new IllegalArgumentException(
                    "Indexed chapter '" + id + "' path must be relative to its root: " + path);
        }
        for (String segment : path.split("/")) {
            if (segment.equals("..")) {
                throw new IllegalArgumentException(
                        "Indexed chapter '" + id + "' path escapes its root: " + path);
            }
        }
    }
}
