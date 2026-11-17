package network.ike.foundation.ike.hierarchy.scan;

import java.util.List;

import network.ike.foundation.ike.hierarchy.model.Chapter;
import network.ike.foundation.ike.hierarchy.model.Violation;

/**
 * Everything a scan found: the chapters, and the reasons some files could not become chapters.
 *
 * <p>Both are returned together rather than the scan throwing on the first problem, so that one
 * build reports every broken file at once.
 *
 * @param chapters       every chapter discovered, ordered by root identifier then relative path
 * @param violations     every defect encountered while walking and reading
 * @param filesExamined  how many candidate files were opened, for build-log reporting
 */
public record ScanOutcome(List<Chapter> chapters, List<Violation> violations, int filesExamined) {

    /**
     * Copies both lists defensively.
     *
     * @throws IllegalArgumentException if either list is null or the count is negative
     */
    public ScanOutcome {
        if (chapters == null || violations == null) {
            throw new IllegalArgumentException("A scan outcome requires both lists");
        }
        if (filesExamined < 0) {
            throw new IllegalArgumentException("Files examined must not be negative");
        }
        chapters = List.copyOf(chapters);
        violations = List.copyOf(violations);
    }
}
