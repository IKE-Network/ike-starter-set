package network.ike.foundation.ike.hierarchy.maven.support;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import network.ike.foundation.ike.hierarchy.author.AtomicFiles;
import network.ike.foundation.ike.hierarchy.author.DecomposedChapter;
import network.ike.foundation.ike.hierarchy.author.Decomposition;
import network.ike.foundation.ike.hierarchy.author.GuideDecomposer;
import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.scan.SafePath;

/**
 * Splits an assembly document into decentralised chapter files.
 *
 * <p>This is the migration goal, and it is destructive in the way that matters: it rewrites a
 * document someone spent a long time writing. So it does the entire operation in memory, checks
 * every destination for containment and for an existing file, and only then writes anything. A run
 * that would overwrite an existing chapter file, or that would write outside the guide's own
 * directory, fails having changed nothing.
 *
 * <p>It also defaults to not writing at all. An author is expected to run it once to see the plan,
 * read the list of chapters it proposes, and then run it again with {@code -Dwrite=true}.
 */
public final class GuideSplitter {

    private GuideSplitter() {
    }

    /**
     * Decomposes an assembly document into chapter files.
     *
     * @param reactorRoot   the reactor's root directory
     * @param guideFile     the assembly document, absolute or relative to the reactor root
     * @param requestedRoot the identifier the guide will declare, or empty to derive one
     * @param subdirectory  where chapter files go, relative to the guide's own directory
     * @param write         whether to write, or only report the plan
     * @return what happened, or would happen
     */
    public static GoalReport run(Path reactorRoot, String guideFile, Optional<String> requestedRoot,
                                 String subdirectory, boolean write) {

        GoalReport report = new GoalReport();
        Optional<Path> realReactorRoot = SafePath.realDirectory(reactorRoot);
        if (realReactorRoot.isEmpty()) {
            return report.fail("The reactor root '" + reactorRoot + "' is not a readable directory.");
        }
        Path base = realReactorRoot.get();

        if (guideFile == null || guideFile.isBlank()) {
            return report.fail("No guide was given. Pass -Dfile=<path to the assembly .adoc>.");
        }
        Path requested = Path.of(guideFile.trim());
        Optional<Path> contained =
                SafePath.contain(base, requested.isAbsolute() ? requested : base.resolve(requested));
        if (contained.isEmpty()) {
            return report.fail("The guide '" + guideFile + "' does not exist inside the project.");
        }
        Path guide = contained.get();
        Path guideDirectory = guide.getParent();
        if (guideDirectory == null) {
            return report.fail("Could not determine the guide's directory.");
        }

        Optional<ChapterId> rootId = resolveRootId(requestedRoot, guide, report);
        if (rootId.isEmpty()) {
            return report;
        }

        List<String> lines;
        try {
            lines = Files.readAllLines(guide, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return report.fail("Could not read " + guide + ": " + e.getMessage());
        }

        Decomposition decomposition;
        try {
            decomposition = GuideDecomposer.decompose(lines, rootId.get(), subdirectory);
        } catch (IllegalArgumentException e) {
            return report.fail(e.getMessage());
        }

        if (decomposition.chapters().isEmpty()) {
            return report.fail("No top-level sections were found in " + SafePath.relativise(base, guide)
                    + ", so there is nothing to decompose.");
        }

        Map<Path, String> pending = planWrites(decomposition, guideDirectory, base, report);
        if (report.failed()) {
            return report;
        }

        report.info("Decomposing " + SafePath.relativise(base, guide) + " into "
                + decomposition.chapters().size() + " chapter file(s) beneath root '"
                + rootId.get() + "':");
        for (DecomposedChapter chapter : decomposition.chapters()) {
            report.info(String.format("  %-40s order %-5d %s",
                    chapter.relativePath(), chapter.header().order(), chapter.header().displayTitle()));
        }

        if (!write) {
            report.info("Dry run: nothing was written. Re-run with -Dwrite=true to apply.");
            return report;
        }
        return applyWrites(pending, guide, decomposition, base, report);
    }

    /**
     * Works out every file that would be written, refusing to overwrite anything that exists.
     */
    private static Map<Path, String> planWrites(Decomposition decomposition, Path guideDirectory,
                                                Path base, GoalReport report) {
        Map<Path, String> pending = new LinkedHashMap<>();
        for (DecomposedChapter chapter : decomposition.chapters()) {
            Optional<Path> destination =
                    SafePath.containForWrite(base, guideDirectory.resolve(chapter.relativePath()));
            if (destination.isEmpty()) {
                report.fail("Chapter '" + chapter.header().id() + "' would be written outside the "
                        + "project, to " + chapter.relativePath() + ".");
                continue;
            }
            if (Files.exists(destination.get())) {
                report.fail(SafePath.relativise(base, destination.get())
                        + " already exists. Move it aside, or choose another subdirectory with "
                        + "-Dsubdirectory=<name>.");
                continue;
            }
            if (pending.put(destination.get(), AtomicFiles.join(chapter.lines())) != null) {
                report.fail("Two chapters would be written to " + chapter.relativePath() + ".");
            }
        }
        return pending;
    }

    /**
     * Writes the chapter files first and the rewritten guide last.
     *
     * <p>Order matters on failure. If a chapter write fails, the guide still contains every
     * section, so nothing has been lost; had the guide been emptied first, a failure partway
     * through would leave the content in neither place.
     */
    private static GoalReport applyWrites(Map<Path, String> pending, Path guide,
                                          Decomposition decomposition, Path base, GoalReport report) {
        List<Path> written = new ArrayList<>();
        for (Map.Entry<Path, String> entry : pending.entrySet()) {
            try {
                AtomicFiles.write(entry.getKey(), entry.getValue());
                written.add(entry.getKey());
            } catch (IOException e) {
                report.fail("Could not write " + entry.getKey() + ": " + e.getMessage());
                report.fail("Wrote " + written.size() + " chapter file(s) before failing; "
                        + SafePath.relativise(base, guide) + " was left unchanged.");
                return report;
            }
        }
        try {
            AtomicFiles.write(guide, AtomicFiles.join(decomposition.guideLines()));
        } catch (IOException e) {
            return report.fail("Chapter files were written, but " + SafePath.relativise(base, guide)
                    + " could not be updated: " + e.getMessage());
        }
        report.info("Wrote " + written.size() + " chapter file(s) and rewrote "
                + SafePath.relativise(base, guide) + " as an assembly root.");
        report.info("Review the result with git diff, then build to regenerate the index.");
        return report;
    }

    private static Optional<ChapterId> resolveRootId(Optional<String> requestedRoot, Path guide,
                                                     GoalReport report) {
        if (requestedRoot.isPresent() && !requestedRoot.get().isBlank()) {
            Optional<ChapterId> parsed = ChapterId.parse(requestedRoot.get());
            if (parsed.isEmpty()) {
                report.fail("'" + requestedRoot.get() + "' is not a valid chapter id for -Droot.");
            }
            return parsed;
        }
        Path name = guide.getFileName();
        String stem = name == null ? "" : name.toString().replaceFirst("\\.(adoc|asciidoc)$", "");
        Optional<ChapterId> derived =
                network.ike.foundation.ike.hierarchy.author.Slug.from(stem);
        if (derived.isEmpty()) {
            report.fail("Could not derive a root id from '" + stem + "'. Pass -Droot=<id>.");
        }
        return derived;
    }
}
