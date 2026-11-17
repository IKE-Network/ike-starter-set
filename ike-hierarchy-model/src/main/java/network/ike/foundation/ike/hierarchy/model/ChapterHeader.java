package network.ike.foundation.ike.hierarchy.model;

import java.util.Optional;

/**
 * The hierarchy declaration read from, or written to, the top of a chapter file.
 *
 * <p>This is the whole of a chapter's self-description. A file carrying one of these is a
 * chapter no matter which directory or which reactor module it sits in, and it knows where it
 * belongs without any other file knowing it exists.
 *
 * @param id       the chapter's stable identity
 * @param title    the display title, or empty to fall back to the file's level-1 heading
 * @param parent   the identifier this chapter hangs beneath, or empty when this is a root
 * @param order    the sort key among siblings; ties break on {@link ChapterId}
 * @param status   the editorial lifecycle state
 * @param root     whether this file is an assembly root rather than a placed chapter
 */
public record ChapterHeader(
        ChapterId id,
        Optional<String> title,
        Optional<ChapterId> parent,
        int order,
        ChapterStatus status,
        boolean root) {

    /** The sort key assumed for a chapter whose header declares none. */
    public static final int DEFAULT_ORDER = 500;

    /** The longest permitted title, bounding index size and guarding against pathological input. */
    public static final int MAX_TITLE_LENGTH = 300;

    /**
     * Normalises and checks the declaration's internal consistency.
     *
     * @throws IllegalArgumentException if required components are null, if the title exceeds
     *                                  {@link #MAX_TITLE_LENGTH}, if a root also declares a
     *                                  parent, or if a chapter is its own parent
     */
    public ChapterHeader {
        if (id == null) {
            throw new IllegalArgumentException("Chapter header requires an id");
        }
        if (title == null || parent == null || status == null) {
            throw new IllegalArgumentException("Chapter header components must not be null for " + id);
        }
        title = title.map(String::trim).filter(text -> !text.isEmpty());
        if (title.isPresent() && title.get().length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException(
                    "Chapter title exceeds " + MAX_TITLE_LENGTH + " characters for " + id);
        }
        if (root && parent.isPresent()) {
            throw new IllegalArgumentException(
                    "Chapter " + id + " is declared a root but also declares a parent");
        }
        if (parent.filter(id::equals).isPresent()) {
            throw new IllegalArgumentException("Chapter " + id + " declares itself as its own parent");
        }
    }

    /**
     * Creates the declaration for an assembly root, which has no parent and no sort key.
     *
     * @param id the root's identity
     * @return a root declaration
     */
    public static ChapterHeader root(ChapterId id) {
        return new ChapterHeader(id, Optional.empty(), Optional.empty(),
                DEFAULT_ORDER, ChapterStatus.DEFAULT, true);
    }

    /**
     * Returns the title to render, falling back to the identifier when none was declared and no
     * heading was found in the file.
     *
     * @return a non-blank display title
     */
    public String displayTitle() {
        return title.orElseGet(id::value);
    }
}
