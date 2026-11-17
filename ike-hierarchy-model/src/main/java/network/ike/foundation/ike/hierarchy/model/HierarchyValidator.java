package network.ike.foundation.ike.hierarchy.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Turns a flat set of discovered chapters into a validated forest, or into the complete list of
 * reasons it cannot become one.
 *
 * <p>This is the whole of the hierarchy's consistency logic, and it is a pure function of its
 * inputs: no filesystem, no Maven, no Asciidoctor. That is deliberate. The rules that decide
 * whether a guide is well formed are the part of this system most worth testing exhaustively, so
 * they are kept where they can be tested with nothing but a list of records.
 *
 * <p>Validation reports every defect it finds rather than stopping at the first. An author who
 * has just moved a directory of chapters wants one build that lists all six broken parent
 * pointers, not six builds that each reveal one.
 */
public final class HierarchyValidator {

    /** The deepest nesting assumed when a caller expresses no preference. */
    public static final int DEFAULT_MAX_DEPTH = 4;

    /** The deepest nesting AsciiDoc can render, since headings stop at five levels below document title. */
    public static final int ABSOLUTE_MAX_DEPTH = 5;

    private HierarchyValidator() {
    }

    /**
     * Validates a chapter set at the default depth limit.
     *
     * @param chapters every chapter and root discovered by a scan, in discovery order
     * @return a valid forest, or the violations preventing one
     */
    public static HierarchyResult validate(List<Chapter> chapters) {
        return validate(chapters, DEFAULT_MAX_DEPTH);
    }

    /**
     * Validates a chapter set, checking identity, placement, and nesting depth.
     *
     * @param chapters every chapter and root discovered by a scan, in discovery order
     * @param maxDepth the deepest permitted nesting, counting a root as zero; clamped to
     *                 {@link #ABSOLUTE_MAX_DEPTH}
     * @return a valid forest, or every violation preventing one
     * @throws IllegalArgumentException if {@code chapters} is null
     */
    public static HierarchyResult validate(List<Chapter> chapters, int maxDepth) {
        if (chapters == null) {
            throw new IllegalArgumentException("Chapter list must not be null");
        }
        int depthLimit = Math.min(Math.max(maxDepth, 1), ABSOLUTE_MAX_DEPTH);
        Set<Violation> violations = new LinkedHashSet<>();

        Map<ChapterId, Chapter> byId = indexById(chapters, violations);
        Map<ChapterId, Integer> depths = resolveDepths(byId, depthLimit, violations);

        if (!violations.isEmpty()) {
            return new HierarchyResult.Invalid(List.copyOf(violations));
        }
        if (byId.isEmpty()) {
            return new HierarchyResult.Valid(Hierarchy.empty());
        }
        return new HierarchyResult.Valid(buildForest(byId, depths));
    }

    /**
     * Indexes chapters by identifier, recording a violation for each contested identifier.
     *
     * <p>The first claimant of an identifier wins the index slot so that downstream resolution
     * still has something to work with while the violation list is being assembled; the result is
     * discarded anyway, since any duplicate makes the whole set invalid.
     */
    private static Map<ChapterId, Chapter> indexById(List<Chapter> chapters, Set<Violation> violations) {
        Map<ChapterId, Chapter> byId = new LinkedHashMap<>();
        for (Chapter chapter : chapters) {
            Chapter existing = byId.putIfAbsent(chapter.id(), chapter);
            if (existing != null) {
                violations.add(new Violation.DuplicateId(
                        chapter.id(), existing.relativePath(), chapter.relativePath()));
            }
        }
        return byId;
    }

    /**
     * Walks every chapter's parent chain to its root, recording the depth reached and any defect
     * met on the way.
     *
     * <p>Each chapter has at most one parent, so the chain is a simple walk rather than a search.
     * A chain that revisits an identifier it has already stepped through is a cycle, and the
     * portion of the walk from that identifier onward is exactly the loop to report. Depths for
     * every identifier on a successful walk are memoised, so a deep guide costs one traversal per
     * chapter, not one per chapter per level.
     */
    private static Map<ChapterId, Integer> resolveDepths(
            Map<ChapterId, Chapter> byId, int depthLimit, Set<Violation> violations) {

        Map<ChapterId, Integer> depths = new LinkedHashMap<>();
        for (ChapterId start : byId.keySet()) {
            if (depths.containsKey(start)) {
                continue;
            }
            List<ChapterId> walk = new ArrayList<>();
            Set<ChapterId> onWalk = new LinkedHashSet<>();
            ChapterId cursor = start;

            while (true) {
                if (!onWalk.add(cursor)) {
                    violations.add(new Violation.Cycle(walk.subList(walk.indexOf(cursor), walk.size())));
                    break;
                }
                walk.add(cursor);

                Chapter chapter = byId.get(cursor);
                ChapterHeader header = chapter.header();

                if (header.root()) {
                    memoise(walk, depths, depthLimit, violations, 0);
                    break;
                }
                Integer known = depths.get(cursor);
                if (known != null) {
                    // The remainder of this chain has already been resolved; graft onto it.
                    memoise(walk.subList(0, walk.size() - 1), depths, depthLimit, violations, known + 1);
                    break;
                }
                Optional<ChapterId> parent = header.parent();
                if (parent.isEmpty()) {
                    violations.add(new Violation.Orphan(cursor, chapter.relativePath()));
                    break;
                }
                if (!byId.containsKey(parent.get())) {
                    violations.add(new Violation.DanglingParent(
                            cursor, parent.get(), chapter.relativePath()));
                    break;
                }
                cursor = parent.get();
            }
        }
        return depths;
    }

    /**
     * Assigns depths to a completed walk, deepest-first, and flags anything past the limit.
     *
     * @param walk       the walk from the starting chapter up towards its root
     * @param depths     the memo table to populate
     * @param depthLimit the deepest permitted nesting
     * @param violations the accumulating violation set
     * @param tailDepth  the depth of the final element of {@code walk}
     */
    private static void memoise(List<ChapterId> walk, Map<ChapterId, Integer> depths,
                                int depthLimit, Set<Violation> violations, int tailDepth) {
        for (int i = walk.size() - 1; i >= 0; i--) {
            int depth = tailDepth + (walk.size() - 1 - i);
            ChapterId id = walk.get(i);
            depths.put(id, depth);
            if (depth > depthLimit) {
                violations.add(new Violation.DepthExceeded(id, depth, depthLimit));
            }
        }
    }

    /**
     * Assembles the forest from a fully resolved chapter set.
     *
     * <p>Siblings are ordered by their declared sort key and then by identifier. The identifier
     * tie-break is what makes a build reproducible: two chapters that both forgot to declare an
     * order still come out in the same sequence on every machine, rather than in whatever order
     * the filesystem happened to hand them over.
     */
    private static Hierarchy buildForest(Map<ChapterId, Chapter> byId, Map<ChapterId, Integer> depths) {
        Map<ChapterId, List<Chapter>> childrenByParent = new LinkedHashMap<>();
        List<Chapter> roots = new ArrayList<>();

        for (Chapter chapter : byId.values()) {
            if (chapter.header().root()) {
                roots.add(chapter);
            } else {
                chapter.header().parent().ifPresent(parent ->
                        childrenByParent.computeIfAbsent(parent, key -> new ArrayList<>()).add(chapter));
            }
        }

        Comparator<Chapter> siblingOrder =
                Comparator.comparingInt((Chapter chapter) -> chapter.header().order())
                        .thenComparing(Chapter::id);
        childrenByParent.values().forEach(siblings -> siblings.sort(siblingOrder));
        roots.sort(Comparator.comparing(Chapter::id));

        List<HierarchyNode> rootNodes = new ArrayList<>();
        for (Chapter root : roots) {
            rootNodes.add(buildNode(root, childrenByParent, depths));
        }
        return new Hierarchy(rootNodes, byId);
    }

    private static HierarchyNode buildNode(Chapter chapter,
                                           Map<ChapterId, List<Chapter>> childrenByParent,
                                           Map<ChapterId, Integer> depths) {
        List<HierarchyNode> children = new ArrayList<>();
        for (Chapter child : childrenByParent.getOrDefault(chapter.id(), List.of())) {
            children.add(buildNode(child, childrenByParent, depths));
        }
        return new HierarchyNode(chapter, depths.getOrDefault(chapter.id(), 0), children);
    }
}
