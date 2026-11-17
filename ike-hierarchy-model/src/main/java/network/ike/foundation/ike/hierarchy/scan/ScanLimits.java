package network.ike.foundation.ike.hierarchy.scan;

import java.util.Set;

/**
 * The bounds a chapter scan will not exceed.
 *
 * <p>Discovery is decentralised, which means the scan is pointed at directories whose contents
 * nobody enumerated in advance. Every one of these limits exists because an unbounded walk over
 * an unknown tree is a way for an ordinary mistake — a checked-in dependency directory, a
 * generated output folder, a very large pasted file — to turn a documentation build into a
 * runaway. Reaching a limit is reported as a violation rather than silently truncating the scan.
 *
 * @param maxFiles              the most candidate files a single scan will examine
 * @param maxFileBytes          the largest file whose header will be read
 * @param maxHeaderLines        how far into a file the header parser will look for attributes
 * @param maxValueLength        the longest attribute value accepted
 * @param maxDirectoryDepth     how deep beneath a scan root the walk will descend
 * @param excludedDirectoryNames directory names never descended into, matched exactly
 */
public record ScanLimits(
        int maxFiles,
        long maxFileBytes,
        int maxHeaderLines,
        int maxValueLength,
        int maxDirectoryDepth,
        Set<String> excludedDirectoryNames) {

    /**
     * Copies the exclusion set defensively and rejects nonsensical bounds.
     *
     * @throws IllegalArgumentException if any numeric bound is not positive, or the exclusion set
     *                                  is null
     */
    public ScanLimits {
        if (maxFiles <= 0 || maxFileBytes <= 0 || maxHeaderLines <= 0
                || maxValueLength <= 0 || maxDirectoryDepth <= 0) {
            throw new IllegalArgumentException("Every scan limit must be positive");
        }
        if (excludedDirectoryNames == null) {
            throw new IllegalArgumentException("Scan limits require an exclusion set");
        }
        excludedDirectoryNames = Set.copyOf(excludedDirectoryNames);
    }

    /**
     * Returns the limits used when a build expresses no preference.
     *
     * <p>The excluded names are the directories that, in a Maven project, either contain build
     * output that would duplicate every chapter it copies, or contain third-party content that is
     * not ours to place in the guide.
     *
     * @return a conservative default suitable for a documentation reactor
     */
    public static ScanLimits defaults() {
        return new ScanLimits(
                5_000,
                8L * 1024 * 1024,
                200,
                500,
                24,
                Set.of("target", "build", "out", ".git", ".idea", ".mvn",
                        "node_modules", ".gradle", ".settings"));
    }

    /**
     * Reports whether a directory name is one the walk refuses to descend into.
     *
     * @param name the directory's own name, without any parent path
     * @return true when the directory must be skipped
     */
    public boolean excludes(String name) {
        return name != null && excludedDirectoryNames.contains(name);
    }
}
