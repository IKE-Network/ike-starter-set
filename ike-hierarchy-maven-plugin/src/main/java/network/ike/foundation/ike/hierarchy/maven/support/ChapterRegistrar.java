package network.ike.foundation.ike.hierarchy.maven.support;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import network.ike.foundation.ike.hierarchy.author.AtomicFiles;
import network.ike.foundation.ike.hierarchy.author.HeaderStamper;
import network.ike.foundation.ike.hierarchy.author.Slug;
import network.ike.foundation.ike.hierarchy.author.StampOutcome;
import network.ike.foundation.ike.hierarchy.model.Chapter;
import network.ike.foundation.ike.hierarchy.model.ChapterHeader;
import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.ChapterStatus;
import network.ike.foundation.ike.hierarchy.scan.ChapterScanner;
import network.ike.foundation.ike.hierarchy.scan.HeaderParseResult;
import network.ike.foundation.ike.hierarchy.scan.HeaderParser;
import network.ike.foundation.ike.hierarchy.scan.SafePath;
import network.ike.foundation.ike.hierarchy.scan.ScanLimits;
import network.ike.foundation.ike.hierarchy.scan.ScanOutcome;

/**
 * Registers an existing AsciiDoc file as a chapter, in the place it already occupies.
 *
 * <p>This is the one command. It does not move the file, split it, rename it, or copy it into a
 * conventional directory, and it does not edit the guide. It adds a few attribute entries to the
 * file the author is already working on, and from that moment the chapter is part of the guide.
 *
 * <p>Two checks run before anything is written. The file must lie inside the project, so a stray
 * path cannot pull an outside document into the published guide. And the identifier must not
 * already belong to a different file, because a duplicate would fail the next build with a
 * confusing error at a distance rather than a clear one here, at the moment it was introduced.
 */
public final class ChapterRegistrar {

    private ChapterRegistrar() {
    }

    /**
     * Registers a chapter file.
     *
     * @param reactorRoot     the reactor's root directory
     * @param configuredRoots the configured scan roots, used for the duplicate check
     * @param file            the chapter file, absolute or relative to the reactor root
     * @param requestedId     the identifier to assign, or empty to derive one from the file
     * @param requestedTitle  the title to assign, or empty to derive/preserve
     * @param parent          the identifier to place the chapter beneath, or empty for a root
     * @param order           the sort key, or empty for the default
     * @param status          the lifecycle status, or empty for the default
     * @param asRoot          whether to declare the file an assembly root instead of a chapter
     * @param limits          the scan bounds used for the duplicate check
     * @param write           whether to write the file, or only report what would happen
     * @return what happened
     */
    public static GoalReport run(Path reactorRoot, List<String> configuredRoots, String file,
                                 Optional<String> requestedId, Optional<String> requestedTitle,
                                 Optional<String> parent,
                                 Optional<Integer> order, Optional<String> status,
                                 boolean asRoot, ScanLimits limits, boolean write) {

        GoalReport report = new GoalReport();
        ScanRoots.Resolved roots = ScanRoots.resolve(reactorRoot, configuredRoots, report);
        if (report.failed()) {
            return report;
        }
        Path base = roots.reactorRoot();

        if (file == null || file.isBlank()) {
            return report.fail("No file was given. Pass -Dfile=<path to the .adoc file>.");
        }
        Path requested = Path.of(file.trim());
        Path absolute = requested.isAbsolute() ? requested : base.resolve(requested);

        Optional<Path> contained = SafePath.contain(base, absolute);
        if (contained.isEmpty()) {
            return report.fail("The file '" + file + "' does not exist inside the project, or "
                    + "resolves outside it. Chapters must live beneath " + base + ".");
        }
        Path target = contained.get();
        if (!Files.isRegularFile(target)) {
            return report.fail("'" + file + "' is not a regular file.");
        }

        List<String> lines;
        try {
            lines = Files.readAllLines(target, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return report.fail("Could not read " + target + ": " + e.getMessage());
        }

        HeaderParseResult parseResult = HeaderParser.parse(lines, limits);
        Optional<ChapterHeader> existing = (parseResult instanceof HeaderParseResult.Parsed p)
                ? Optional.of(p.header())
                : Optional.empty();

        Optional<ChapterId> id = resolveId(requestedId, existing, target, report);
        if (id.isEmpty()) {
            return report;
        }

        Optional<ChapterHeader> header = buildHeader(id.get(), existing, requestedTitle, parent, order, status, asRoot, report);
        if (header.isEmpty()) {
            return report;
        }

        if (!checkIdIsFree(roots, limits, id.get(), target, base, report)) {
            return report;
        }

        return stamp(target, base, lines, header.get(), write, report);
    }

    private static Optional<ChapterId> resolveId(Optional<String> requestedId,
                                                 Optional<ChapterHeader> existing,
                                                 Path target,
                                                 GoalReport report) {
        if (requestedId.isPresent() && !requestedId.get().isBlank()) {
            Optional<ChapterId> parsed = ChapterId.parse(requestedId.get());
            if (parsed.isEmpty()) {
                report.fail("'" + requestedId.get() + "' is not a valid chapter id. Use lowercase "
                        + "letters, digits and single hyphens, for example 'getting-started'.");
            }
            return parsed;
        }
        if (existing.isPresent()) {
            return Optional.of(existing.get().id());
        }
        Path name = target.getFileName();
        String stem = name == null ? "" : name.toString().replaceFirst("\\.(adoc|asciidoc)$", "");
        Optional<ChapterId> derived = Slug.from(stem);
        if (derived.isEmpty()) {
            report.fail("Could not derive a chapter id from the file name '" + stem
                    + "'. Pass one with -Did=<chapter-id>.");
        } else {
            report.info("Derived chapter id '" + derived.get() + "' from the file name.");
        }
        return derived;
    }

    private static Optional<ChapterHeader> buildHeader(ChapterId id, Optional<ChapterHeader> existing,
                                                       Optional<String> requestedTitle,
                                                       Optional<String> parent,
                                                       Optional<Integer> order,
                                                       Optional<String> status, boolean asRoot,
                                                       GoalReport report) {
        if (asRoot) {
            if (parent.isPresent() && !parent.get().isBlank()) {
                report.fail("A chapter cannot be both a root and placed beneath a parent. "
                        + "Drop either -Droot or -Dparent.");
                return Optional.empty();
            }
            return Optional.of(ChapterHeader.root(id));
        }
        Optional<ChapterId> parentId = parent.filter(p -> !p.isBlank()).flatMap(ChapterId::parse);
        if (parentId.isEmpty() && existing.isPresent()) {
            parentId = existing.get().parent();
        }
        if (parentId.isEmpty()) {
            report.fail("No parent was given. Pass -Dparent=<chapter-id of the parent>, or "
                    + "-Droot to declare this file an assembly root.");
            return Optional.empty();
        }
        Optional<String> title = requestedTitle.filter(t -> !t.isBlank());
        if (title.isEmpty() && existing.isPresent()) {
            title = existing.get().title();
        }
        int resolvedOrder = order.orElseGet(() -> existing.map(ChapterHeader::order).orElse(ChapterHeader.DEFAULT_ORDER));
        ChapterStatus resolvedStatus = existing.map(ChapterHeader::status).orElse(ChapterStatus.DEFAULT);
        if (status.isPresent() && !status.get().isBlank()) {
            Optional<ChapterStatus> parsed = ChapterStatus.parse(status.get());
            if (parsed.isEmpty()) {
                report.fail("'" + status.get() + "' is not a valid status. Use one of: draft, "
                        + "proposed, review, published, deprecated.");
                return Optional.empty();
            }
            resolvedStatus = parsed.get();
        }
        try {
            return Optional.of(new ChapterHeader(id, title, parentId, resolvedOrder, resolvedStatus, false));
        } catch (IllegalArgumentException e) {
            report.fail(e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * Confirms the identifier is not already taken by a different file.
     *
     * <p>Re-registering the same file under the same identifier is legitimate — that is what makes
     * the command re-runnable — so the check compares paths, not just identifiers.
     */
    private static boolean checkIdIsFree(ScanRoots.Resolved roots, ScanLimits limits, ChapterId id,
                                         Path target, Path base, GoalReport report) {

        ScanOutcome scan = ChapterScanner.scan(roots.scanRoots(), limits);
        String targetRelative = SafePath.relativise(base, target);

        for (Chapter existing : scan.chapters()) {
            if (!existing.id().equals(id)) {
                continue;
            }
            String existingPath = existing.rootId().equals(ScanRoots.REACTOR_ROOT_ID)
                    ? existing.relativePath()
                    : existing.rootId() + "/" + existing.relativePath();
            if (!existingPath.equals(targetRelative)) {
                report.fail("Chapter id '" + id + "' is already declared by " + existingPath
                        + ". Choose a different id with -Did, or remove the other declaration.");
                return false;
            }
        }
        return true;
    }

    private static GoalReport stamp(Path target, Path base, List<String> lines, ChapterHeader header, boolean write,
                                    GoalReport report) {
        StampOutcome outcome = HeaderStamper.stamp(lines, header);
        String relative = SafePath.relativise(base, target);

        if (!outcome.changed()) {
            report.info(relative + " already declares this placement; nothing to do.");
            return report;
        }
        outcome.notes().forEach(note -> report.info("  " + note));

        if (!write) {
            report.info("Dry run: " + relative + " was not modified.");
            return report;
        }
        try {
            AtomicFiles.write(target, AtomicFiles.join(outcome.lines()));
        } catch (IOException e) {
            return report.fail("Could not write " + target + ": " + e.getMessage());
        }
        report.info("Registered " + relative + " as chapter '" + header.id() + "'"
                + header.parent().map(p -> " beneath '" + p + "'").orElse(" as an assembly root")
                + ".");
        report.info("Run the build to regenerate the index and see it in the guide.");
        return report;
    }
}
