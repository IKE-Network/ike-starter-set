package network.ike.foundation.ike.hierarchy.maven.support;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import network.ike.foundation.ike.hierarchy.author.AtomicFiles;
import network.ike.foundation.ike.hierarchy.index.HierarchyIndex;
import network.ike.foundation.ike.hierarchy.index.IndexCodec;
import network.ike.foundation.ike.hierarchy.model.Hierarchy;
import network.ike.foundation.ike.hierarchy.model.HierarchyResult;
import network.ike.foundation.ike.hierarchy.model.HierarchyValidator;
import network.ike.foundation.ike.hierarchy.model.Violation;
import network.ike.foundation.ike.hierarchy.scan.ChapterScanner;
import network.ike.foundation.ike.hierarchy.scan.ScanLimits;
import network.ike.foundation.ike.hierarchy.scan.ScanOutcome;

/**
 * Scans, validates, and writes the hierarchy index.
 *
 * <p>The whole discovery cost of the system is paid here, once per build, by one goal. Everything
 * downstream — including document rendering — reads the result instead of repeating the work.
 *
 * <p>The index is only written when validation succeeds. Writing a partial index would leave the
 * next build rendering a guide that silently omits whatever failed, which is precisely the outcome
 * the strict policy exists to prevent; leaving the previous index in place means a broken build
 * fails rather than half-succeeding.
 */
public final class IndexBuilder {

    private IndexBuilder() {
    }

    /**
     * Runs a full scan-validate-write cycle.
     *
     * @param reactorRoot     the reactor's root directory
     * @param configuredRoots the configured scan roots, or empty for the reactor root
     * @param indexFile       where to write the index
     * @param maxDepth        the deepest nesting permitted
     * @param limits          the scan bounds
     * @param write           whether to write the index, or only report what would happen
     * @return the index when validation succeeded, and a report of what happened either way
     */
    public static Outcome run(Path reactorRoot, List<String> configuredRoots, Path indexFile,
                              int maxDepth, ScanLimits limits, boolean write) {

        GoalReport report = new GoalReport();
        ScanRoots.Resolved roots = ScanRoots.resolve(reactorRoot, configuredRoots, report);
        if (report.failed()) {
            return new Outcome(Optional.empty(), report);
        }

        ScanOutcome scan = ChapterScanner.scan(roots.scanRoots(), limits);
        report.info("Examined " + scan.filesExamined() + " AsciiDoc files across "
                + roots.scanRoots().size() + " scan root(s); found "
                + scan.chapters().size() + " chapter(s).");

        for (Violation violation : scan.violations()) {
            report.fail(violation.message());
        }

        HierarchyResult result = HierarchyValidator.validate(scan.chapters(), maxDepth);
        switch (result) {
            case HierarchyResult.Invalid invalid -> {
                for (Violation violation : invalid.violations()) {
                    report.fail(violation.message());
                }
                return new Outcome(Optional.empty(), report);
            }
            case HierarchyResult.Valid valid -> {
                if (report.failed()) {
                    return new Outcome(Optional.empty(), report);
                }
                return writeIndex(valid.hierarchy(), roots, indexFile, maxDepth, write, report);
            }
        }
    }

    private static Outcome writeIndex(Hierarchy hierarchy, ScanRoots.Resolved roots, Path indexFile,
                                      int maxDepth, boolean write, GoalReport report) {

        HierarchyIndex index = HierarchyIndex.from(hierarchy, roots.indexedRoots(), maxDepth);
        int rootCount = hierarchy.roots().size();
        report.info("Placed " + index.chapters().size() + " entries under " + rootCount
                + " assembly root(s): " + hierarchy.roots().stream()
                .map(node -> node.id().value()).toList());

        if (!write) {
            report.info("Dry run: the index was not written.");
            return new Outcome(Optional.of(index), report);
        }
        try {
            AtomicFiles.write(indexFile, IndexCodec.write(index));
            report.info("Wrote " + indexFile);
        } catch (IOException e) {
            report.fail("Could not write the index to " + indexFile + ": " + e.getMessage());
            return new Outcome(Optional.empty(), report);
        }
        return new Outcome(Optional.of(index), report);
    }

    /**
     * The result of an index build.
     *
     * @param index  the index, present only when validation succeeded
     * @param report what happened
     */
    public record Outcome(Optional<HierarchyIndex> index, GoalReport report) {

        /**
         * Checks both components are present.
         *
         * @throws IllegalArgumentException if either is null
         */
        public Outcome {
            if (index == null || report == null) {
                throw new IllegalArgumentException("An index outcome requires both components");
            }
        }
    }
}
