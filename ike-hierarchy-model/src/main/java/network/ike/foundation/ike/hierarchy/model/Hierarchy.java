package network.ike.foundation.ike.hierarchy.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A validated forest of chapters: every declared root, with its placed descendants beneath it.
 *
 * <p>An instance of this type only exists for a chapter set that passed validation, so consumers
 * never have to consider a dangling parent, a duplicate identifier, or a cycle. That is the point
 * of routing construction through {@link HierarchyValidator}: the invalid state is unrepresentable
 * downstream, and the failure is reported once, at the build step that scanned the files.
 *
 * @param roots     every declared assembly root, ordered by identifier
 * @param byId      every chapter and root discovered, keyed by identifier
 */
public record Hierarchy(List<HierarchyNode> roots, Map<ChapterId, Chapter> byId) {

    /**
     * Copies both collections defensively so the hierarchy stays immutable.
     *
     * @throws IllegalArgumentException if either collection is null
     */
    public Hierarchy {
        if (roots == null || byId == null) {
            throw new IllegalArgumentException("A hierarchy requires a root list and an index");
        }
        roots = List.copyOf(roots);
        byId = Map.copyOf(byId);
    }

    /**
     * Finds the root node with the supplied identifier.
     *
     * @param rootId the identifier of the assembly root to locate
     * @return the root node, or empty when no file declares that root
     */
    public Optional<HierarchyNode> root(ChapterId rootId) {
        return roots.stream().filter(node -> node.id().equals(rootId)).findFirst();
    }

    /**
     * Finds any node in the forest by identifier, root or otherwise.
     *
     * @param id the identifier to locate
     * @return the node, or empty when no chapter with that identifier was placed
     */
    public Optional<HierarchyNode> node(ChapterId id) {
        for (HierarchyNode candidate : roots) {
            Optional<HierarchyNode> found = find(candidate, id);
            if (found.isPresent()) {
                return found;
            }
        }
        return Optional.empty();
    }

    private static Optional<HierarchyNode> find(HierarchyNode node, ChapterId id) {
        if (node.id().equals(id)) {
            return Optional.of(node);
        }
        for (HierarchyNode child : node.children()) {
            Optional<HierarchyNode> found = find(child, id);
            if (found.isPresent()) {
                return found;
            }
        }
        return Optional.empty();
    }

    /**
     * Returns every node in the forest in document order: each root, then its descendants,
     * parents before children and siblings in their declared order.
     *
     * @return a flat, ordered list of every placed node
     */
    public List<HierarchyNode> inDocumentOrder() {
        List<HierarchyNode> ordered = new ArrayList<>();
        for (HierarchyNode node : roots) {
            node.visit(ordered::add);
        }
        return List.copyOf(ordered);
    }

    /**
     * Returns the chapters placed beneath a root or chapter, in document order, excluding the
     * node itself.
     *
     * @param id the identifier whose descendants are wanted
     * @return the ordered descendants, or an empty list when the identifier is unknown
     */
    public List<HierarchyNode> descendantsOf(ChapterId id) {
        Optional<HierarchyNode> start = node(id);
        if (start.isEmpty()) {
            return List.of();
        }
        List<HierarchyNode> ordered = new ArrayList<>();
        for (HierarchyNode child : start.get().children()) {
            child.visit(ordered::add);
        }
        return List.copyOf(ordered);
    }

    /**
     * Returns an empty hierarchy, used when a scan discovers no chapter files at all.
     *
     * @return a hierarchy with no roots and no chapters
     */
    public static Hierarchy empty() {
        return new Hierarchy(List.of(), new LinkedHashMap<>());
    }
}
