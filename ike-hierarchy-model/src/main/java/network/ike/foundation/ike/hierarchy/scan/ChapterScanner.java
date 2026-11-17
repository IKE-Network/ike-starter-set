package network.ike.foundation.ike.hierarchy.scan;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

import network.ike.foundation.ike.hierarchy.model.Chapter;
import network.ike.foundation.ike.hierarchy.model.Violation;

/**
 * Walks the declared scan roots and collects every file that declares itself a chapter.
 *
 * <p>This is the step that makes the system decentralised: nothing tells the scanner what
 * chapters exist or where they live. It is given a set of roots, and any AsciiDoc file beneath
 * any of them that carries a {@code :chapter-id:} becomes part of the guide. Moving a chapter
 * from one module to another is a {@code git mv} and nothing else.
 *
 * <p>Every path the scanner is prepared to read passes {@link SafePath}, and the result is
 * recorded relative to the root it was found under, so nothing downstream ever handles an
 * absolute path or a path it could not have derived from a root it was given.
 *
 * <p>Results are sorted by root identifier and then relative path before being returned. The walk
 * order of a directory is filesystem-dependent, and an index whose contents depend on which
 * machine produced it is an index that cannot be diffed or cached.
 */
public final class ChapterScanner {

    private static final String ADOC = ".adoc";
    private static final String ASCIIDOC = ".asciidoc";

    private ChapterScanner() {
    }

    /**
     * Scans every root and returns the chapters found together with any defects encountered.
     *
     * <p>A defect in one file never stops the scan. The caller receives everything that was
     * discovered and everything that was wrong, and decides what to do with both.
     *
     * @param roots  the directories to scan, each with the identifier chapter paths are recorded
     *               relative to
     * @param limits the bounds the walk will respect
     * @return the chapters discovered and the violations encountered
     * @throws IllegalArgumentException if either argument is null
     */
    public static ScanOutcome scan(List<ScanRoot> roots, ScanLimits limits) {
        if (roots == null || limits == null) {
            throw new IllegalArgumentException("Roots and limits are both required");
        }
        List<Chapter> chapters = new ArrayList<>();
        List<Violation> violations = new ArrayList<>();
        int examined = 0;

        for (ScanRoot root : roots) {
            Optional<Path> realRoot = SafePath.realDirectory(root.directory());
            if (realRoot.isEmpty()) {
                continue;
            }
            examined = scanRoot(root, realRoot.get(), limits, chapters, violations, examined);
        }

        chapters.sort(Comparator.comparing(Chapter::rootId).thenComparing(Chapter::relativePath));
        return new ScanOutcome(List.copyOf(chapters), List.copyOf(violations), examined);
    }

    private static int scanRoot(ScanRoot root, Path realRoot, ScanLimits limits,
                                List<Chapter> chapters, List<Violation> violations, int examined) {

        List<Path> candidates = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(realRoot, limits.maxDirectoryDepth())) {
            // Files.walk does not follow directory symbolic links unless asked to, so an excluded
            // directory cannot be re-entered through a link, and a link loop cannot be walked.
            walk.filter(path -> !isExcluded(realRoot, path, limits))
                    .filter(ChapterScanner::hasAsciiDocSuffix)
                    .forEach(candidates::add);
        } catch (IOException e) {
            violations.add(new Violation.ScanLimitExceeded(
                    "could not walk scan root '" + root.id() + "': " + e.getMessage()));
            return examined;
        }

        for (Path candidate : candidates) {
            if (examined >= limits.maxFiles()) {
                violations.add(new Violation.ScanLimitExceeded(
                        "examined the maximum of " + limits.maxFiles() + " files while scanning '"
                                + root.id() + "'; narrow the scan roots or raise "
                                + "ike-hierarchy.maxFiles"));
                return examined;
            }
            examined++;
            readCandidate(root, realRoot, candidate, limits, chapters, violations);
        }
        return examined;
    }

    /**
     * Reads one candidate file, refusing anything that escapes the root or exceeds the size cap.
     */
    private static void readCandidate(ScanRoot root, Path realRoot, Path candidate,
                                      ScanLimits limits, List<Chapter> chapters,
                                      List<Violation> violations) {

        Optional<Path> contained = SafePath.contain(realRoot, candidate);
        if (contained.isEmpty()) {
            violations.add(new Violation.EscapesRoot(
                    describe(realRoot, candidate),
                    "it resolves outside scan root '" + root.id() + "', most likely through a "
                            + "symbolic link. Chapters must live beneath a declared root."));
            return;
        }
        Path real = contained.get();

        long size;
        try {
            size = Files.size(real);
        } catch (IOException e) {
            violations.add(new Violation.MalformedHeader(
                    SafePath.relativise(realRoot, real), "could not be read: " + e.getMessage()));
            return;
        }
        if (size > limits.maxFileBytes()) {
            violations.add(new Violation.ScanLimitExceeded(
                    "file '" + describe(realRoot, real) + "' is " + size + " bytes, exceeding the maximum of "
                            + limits.maxFileBytes() + " bytes"));
            return;
        }

        List<String> lines;
        try {
            lines = Files.readAllLines(real, StandardCharsets.UTF_8);
        } catch (MalformedInputException e) {
            violations.add(new Violation.MalformedHeader(
                    SafePath.relativise(realRoot, real), "is not valid UTF-8 text"));
            return;
        } catch (IOException e) {
            violations.add(new Violation.MalformedHeader(
                    SafePath.relativise(realRoot, real), "could not be read: " + e.getMessage()));
            return;
        }

        String relative = SafePath.relativise(realRoot, real);
        HeaderParseResult result = HeaderParser.parse(lines, limits);
        switch (result) {
            case HeaderParseResult.NotAChapter ignored -> {
                // Ordinary AsciiDoc file; nothing to do.
            }
            case HeaderParseResult.Malformed malformed ->
                    violations.add(new Violation.MalformedHeader(relative, malformed.detail()));
            case HeaderParseResult.Parsed parsed ->
                    chapters.add(new Chapter(parsed.header(), relative, root.id()));
        }
    }

    /**
     * Reports whether a path lies inside a directory the walk refuses to enter.
     *
     * <p>Checked per path segment rather than per directory because {@link Files#walk} yields a
     * flat stream: filtering the stream is the only place the decision can be made, and a nested
     * {@code target} several levels down must be excluded just as firmly as one at the top.
     */
    private static boolean isExcluded(Path realRoot, Path path, ScanLimits limits) {
        Path relative = realRoot.relativize(path);
        for (Path segment : relative) {
            if (limits.excludes(segment.toString())) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasAsciiDocSuffix(Path path) {
        if (!Files.isRegularFile(path)) {
            return false;
        }
        String name = path.getFileName().toString().toLowerCase(Locale.ROOT);
        return name.endsWith(ADOC) || name.endsWith(ASCIIDOC);
    }

    /**
     * Describes a path for a violation message without leaking an absolute path when it can be
     * expressed relative to the root.
     */
    private static String describe(Path realRoot, Path path) {
        try {
            if (path.startsWith(realRoot)) {
                return realRoot.relativize(path).toString().replace('\\', '/');
            }
        } catch (IllegalArgumentException ignored) {
            // Fall through to the file name.
        }
        Path name = path.getFileName();
        return name == null ? path.toString() : name.toString();
    }

    /**
     * Reports whether a path is a symbolic link, for callers that want to explain a refusal.
     *
     * @param path the path to test
     * @return true when the path itself is a symbolic link
     */
    public static boolean isSymbolicLink(Path path) {
        return path != null && Files.isSymbolicLink(path)
                && !Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS);
    }
}
