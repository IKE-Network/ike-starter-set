package network.ike.foundation.ike.hierarchy.model;

import java.util.List;
import java.util.function.Consumer;

/**
 * One placed chapter and the chapters placed beneath it.
 *
 * <p>Depth is the node's distance from its root, counting the root itself as zero. It is
 * computed once, when the tree is built, because it is what determines the heading level the
 * chapter renders at: a chapter at depth one is a {@code ==} chapter of the book, at depth two a
 * {@code ===} section, and so on. Storing it here means the renderer never has to re-derive it
 * and cannot disagree with the validator about how deep something is.
 *
 * @param chapter  the chapter at this position
 * @param depth    distance from the root, with the root itself at zero
 * @param children the chapters directly beneath, already ordered
 */
public record HierarchyNode(Chapter chapter, int depth, List<HierarchyNode> children) {

    /**
     * Copies the child list defensively so the tree stays immutable.
     *
     * @throws IllegalArgumentException if the chapter is null, the children list is null, or the
     *                                  depth is negative
     */
    public HierarchyNode {
        if (chapter == null) {
            throw new IllegalArgumentException("A hierarchy node requires a chapter");
        }
        if (children == null) {
            throw new IllegalArgumentException("A hierarchy node requires a child list");
        }
        if (depth < 0) {
            throw new IllegalArgumentException("Depth must not be negative for " + chapter.id());
        }
        children = List.copyOf(children);
    }

    /**
     * Returns this node's chapter identity.
     *
     * @return the chapter identifier
     */
    public ChapterId id() {
        return chapter.id();
    }

    /**
     * Visits this node and every node beneath it, parents before children, siblings in order.
     *
     * @param visitor invoked once per node in the subtree, starting with this node
     */
    public void visit(Consumer<HierarchyNode> visitor) {
        visitor.accept(this);
        for (HierarchyNode child : children) {
            child.visit(visitor);
        }
    }
}
