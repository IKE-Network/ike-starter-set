package network.ike.foundation.ike.hierarchy.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A defect that makes a discovered chapter set unusable as a hierarchy.
 *
 * <p>Every violation is fatal: a chapter that cannot be placed is a chapter that silently
 * disappears from the guide, which in a book of twenty-odd chapters is close to invisible. The
 * build fails and names both the identifier and the file, so the author who caused it can find
 * it without searching.
 *
 * <p>Sealed so that adding a new class of defect forces every reporting site to decide how to
 * render it.
 */
public sealed interface Violation {

    /**
     * Renders this violation as a single, self-contained line for a build log.
     *
     * @return a human-readable description naming the offending identifiers and files
     */
    String message();

    /**
     * Two chapter files claim the same identifier, so a reference to it is ambiguous.
     *
     * @param id    the contested identifier
     * @param first the path of one claimant, relative to its scan root
     * @param second the path of the other claimant, relative to its scan root
     */
    record DuplicateId(ChapterId id, String first, String second) implements Violation {
        @Override
        public String message() {
            return "Duplicate chapter id '" + id + "' declared by both " + first + " and " + second
                    + ". Chapter ids must be unique across every scan root.";
        }
    }

    /**
     * A chapter names a parent that no discovered file declares.
     *
     * @param id     the chapter with the unsatisfiable parent pointer
     * @param parent the identifier that was not found
     * @param path   the chapter's path, relative to its scan root
     */
    record DanglingParent(ChapterId id, ChapterId parent, String path) implements Violation {
        @Override
        public String message() {
            return "Chapter '" + id + "' (" + path + ") declares parent '" + parent
                    + "', which no discovered chapter or root declares.";
        }
    }

    /**
     * A chapter declares no parent and is not marked as a root, so there is nowhere to place it.
     *
     * @param id   the unplaceable chapter
     * @param path the chapter's path, relative to its scan root
     */
    record Orphan(ChapterId id, String path) implements Violation {
        @Override
        public String message() {
            return "Chapter '" + id + "' (" + path + ") declares no ':chapter-parent:' and is not "
                    + "marked ':chapter-root:', so it has no place in any assembly.";
        }
    }

    /**
     * Parent pointers form a loop, so no chapter in the loop can be placed.
     *
     * @param loop the identifiers forming the cycle, in traversal order
     */
    record Cycle(List<ChapterId> loop) implements Violation {
        /**
         * Copies the loop defensively so the violation stays immutable.
         *
         * @throws IllegalArgumentException if the loop is null or empty
         */
        public Cycle {
            if (loop == null || loop.isEmpty()) {
                throw new IllegalArgumentException("A cycle violation requires at least one identifier");
            }
            loop = canonicalise(loop);
        }

        /**
         * Rotates a loop to start at its lowest identifier.
         *
         * <p>The same cycle is discovered once per chapter whose parent chain runs into it, each
         * time entering at a different point. Rotating to a canonical starting identifier makes
         * those discoveries equal as records, so the violation set collapses them to one and the
         * build reports the cycle once rather than once per affected chapter.
         *
         * @param loop the loop as walked, in traversal order
         * @return an immutable copy rotated to begin at the lowest identifier
         */
        private static List<ChapterId> canonicalise(List<ChapterId> loop) {
            int pivot = 0;
            for (int i = 1; i < loop.size(); i++) {
                if (loop.get(i).compareTo(loop.get(pivot)) < 0) {
                    pivot = i;
                }
            }
            List<ChapterId> rotated = new java.util.ArrayList<>(loop.size());
            for (int i = 0; i < loop.size(); i++) {
                rotated.add(loop.get((pivot + i) % loop.size()));
            }
            return List.copyOf(rotated);
        }

        @Override
        public String message() {
            String rendered = loop.stream().map(ChapterId::value).collect(Collectors.joining(" -> "));
            return "Chapter parent pointers form a cycle: " + rendered + " -> " + loop.get(0) + ".";
        }
    }

    /**
     * A chapter sits deeper than AsciiDoc can render as a heading.
     *
     * @param id       the chapter that is too deep
     * @param depth    the depth it was found at, counting a root as zero
     * @param maxDepth the deepest permitted level
     */
    record DepthExceeded(ChapterId id, int depth, int maxDepth) implements Violation {
        @Override
        public String message() {
            return "Chapter '" + id + "' nests " + depth + " levels below its root, exceeding the "
                    + "maximum of " + maxDepth + ". AsciiDoc supports six heading levels; flatten "
                    + "the hierarchy or raise ike-hierarchy.maxDepth.";
        }
    }

    /**
     * A file declares a hierarchy attribute the parser could not make sense of.
     *
     * @param path   the offending file's path, relative to its scan root
     * @param detail what specifically could not be understood
     */
    record MalformedHeader(String path, String detail) implements Violation {
        @Override
        public String message() {
            return "Malformed chapter header in " + path + ": " + detail;
        }
    }

    /**
     * A path resolved outside every declared scan root, most often through a symbolic link.
     *
     * <p>This is the containment failure. It is reported rather than silently skipped so that a
     * link pointing somewhere it should not is visible in the build log instead of quietly
     * changing what the guide contains.
     *
     * @param path   the path as it was reached, before resolution
     * @param detail where it actually resolved to, and which root it escaped
     */
    record EscapesRoot(String path, String detail) implements Violation {
        @Override
        public String message() {
            return "Refusing to read " + path + ": " + detail;
        }
    }

    /**
     * A scan hit one of its own safety limits before it finished.
     *
     * <p>Reported rather than silently truncated: a scan that stops early has, by definition, not
     * seen every chapter, and a guide missing chapters it does not know about is worse than a
     * build that refuses to proceed.
     *
     * @param detail which limit was reached and where
     */
    record ScanLimitExceeded(String detail) implements Violation {
        @Override
        public String message() {
            return "Chapter scan stopped before completing: " + detail;
        }
    }

    /**
     * An assembly asked for a root that no file declares.
     *
     * @param root the requested root identifier
     */
    record MissingRoot(ChapterId root) implements Violation {
        @Override
        public String message() {
            return "No file declares ':chapter-root:' with id '" + root
                    + "', so the hierarchy beneath it cannot be assembled.";
        }
    }
}
