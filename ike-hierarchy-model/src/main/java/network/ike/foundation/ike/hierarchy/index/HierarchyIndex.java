package network.ike.foundation.ike.hierarchy.index;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.Hierarchy;
import network.ike.foundation.ike.hierarchy.model.HierarchyNode;

/**
 * The build's single, validated statement of what chapters exist and where each one belongs.
 *
 * <p>The index is the seam between the two halves of the system. The Maven plugin does all the
 * discovery — walking directories, reading headers, checking containment, validating the forest —
 * and writes the answer here once. The Asciidoctor extension does none of that: it reads this file
 * and renders. Rendering therefore performs no directory walk, resolves no path it was not handed,
 * and produces the same document on every machine for a given tree, because the file it reads is
 * byte-identical on every machine.
 *
 * @param schema   the schema identifier, checked on read so a stale index fails loudly
 * @param maxDepth the depth limit the hierarchy was validated against
 * @param roots    every scan root, so a consumer can re-anchor chapter paths
 * @param chapters every placed chapter and root, in document order
 */
public record HierarchyIndex(
        String schema,
        int maxDepth,
        List<IndexedRoot> roots,
        List<IndexedChapter> chapters) {

    /** The schema identifier written into, and required by, every index this version produces. */
    public static final String SCHEMA = "ike-hierarchy-index/1";

    /** The conventional file name, relative to a module's build output directory. */
    public static final String FILE_NAME = "ike-hierarchy-index.json";

    /**
     * Copies both lists defensively and rejects an index of an unrecognised schema.
     *
     * @throws IllegalArgumentException if a list is null, or the schema is not {@link #SCHEMA}
     */
    public HierarchyIndex {
        if (roots == null || chapters == null) {
            throw new IllegalArgumentException("An index requires a root list and a chapter list");
        }
        if (!SCHEMA.equals(schema)) {
            throw new IllegalArgumentException(
                    "Unsupported index schema '" + schema + "'; this build writes and reads " + SCHEMA);
        }
        roots = List.copyOf(roots);
        chapters = List.copyOf(chapters);
    }

    /**
     * Flattens a validated hierarchy into an index.
     *
     * @param hierarchy the validated forest
     * @param roots     the scan roots, expressed relative to the project base
     * @param maxDepth  the depth limit validation used
     * @return the index ready to be written
     * @throws IllegalArgumentException if either argument is null
     */
    public static HierarchyIndex from(Hierarchy hierarchy, List<IndexedRoot> roots, int maxDepth) {
        if (hierarchy == null || roots == null) {
            throw new IllegalArgumentException("A hierarchy and its roots are both required");
        }
        List<IndexedChapter> entries = new ArrayList<>();
        for (HierarchyNode node : hierarchy.inDocumentOrder()) {
            entries.add(new IndexedChapter(
                    node.id(),
                    node.chapter().header().displayTitle(),
                    node.chapter().header().parent(),
                    node.chapter().header().order(),
                    node.chapter().header().status(),
                    node.chapter().header().root(),
                    node.depth(),
                    node.chapter().rootId(),
                    node.chapter().relativePath()));
        }
        return new HierarchyIndex(SCHEMA, maxDepth, roots, entries);
    }

    /**
     * Finds the recorded directory for a scan root.
     *
     * @param rootId the root identifier
     * @return the root's relative path, or empty when the index records no such root
     */
    public Optional<String> rootPath(String rootId) {
        return roots.stream()
                .filter(root -> root.id().equals(rootId))
                .map(IndexedRoot::path)
                .findFirst();
    }

    /**
     * Returns the chapters placed beneath an identifier, in document order, excluding the entry
     * itself.
     *
     * <p>Because entries are stored in document order with their depths, a subtree is the run of
     * entries following the named one that are deeper than it — no tree needs to be rebuilt to
     * answer this.
     *
     * @param id the root or chapter whose descendants are wanted
     * @return the ordered descendants, or an empty list when the identifier is not indexed
     */
    public List<IndexedChapter> descendantsOf(ChapterId id) {
        int start = -1;
        int startDepth = 0;
        for (int i = 0; i < chapters.size(); i++) {
            if (chapters.get(i).id().equals(id)) {
                start = i;
                startDepth = chapters.get(i).depth();
                break;
            }
        }
        if (start < 0) {
            return List.of();
        }
        List<IndexedChapter> subtree = new ArrayList<>();
        for (int i = start + 1; i < chapters.size(); i++) {
            IndexedChapter candidate = chapters.get(i);
            if (candidate.depth() <= startDepth) {
                break;
            }
            subtree.add(candidate);
        }
        return List.copyOf(subtree);
    }

    /**
     * Finds an indexed chapter by identifier.
     *
     * @param id the identifier to locate
     * @return the entry, or empty when the identifier is not indexed
     */
    public Optional<IndexedChapter> chapter(ChapterId id) {
        return chapters.stream().filter(entry -> entry.id().equals(id)).findFirst();
    }
}
