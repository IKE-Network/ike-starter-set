package network.ike.foundation.ike.hierarchy.maven.support;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import network.ike.foundation.ike.hierarchy.index.IndexedRoot;
import network.ike.foundation.ike.hierarchy.scan.SafePath;
import network.ike.foundation.ike.hierarchy.scan.ScanRoot;

/**
 * Turns the goals' configured root directories into resolved, contained scan roots.
 *
 * <p>Every configured root must resolve beneath the reactor root. That single rule is what bounds
 * the whole system: a chapter can live anywhere in the project, and nowhere outside it. A build
 * that configures a root pointing elsewhere — by accident, by a stale absolute path in someone's
 * settings, or through a symbolic link — is refused rather than quietly reading files from outside
 * the repository into the published guide.
 *
 * <p>The default is a single root at the reactor root itself, which is what makes "drop a file
 * anywhere in the project" literally true: no directory is privileged, and adding a module does
 * not require telling this plugin about it.
 */
public final class ScanRoots {

    /** The identifier used for the reactor root when it is scanned as a whole. */
    public static final String REACTOR_ROOT_ID = "reactor";

    private ScanRoots() {
    }

    /**
     * Resolves configured roots against the reactor root, refusing any that escape it.
     *
     * @param reactorRoot the reactor's root directory
     * @param configured  the configured root directories, relative to the reactor root; when empty
     *                    the reactor root itself is used
     * @param report      collects a failure for each configured root that cannot be used
     * @return the resolved roots, paired with the index records describing them
     */
    public static Resolved resolve(Path reactorRoot, List<String> configured, GoalReport report) {
        List<ScanRoot> scanRoots = new ArrayList<>();
        List<IndexedRoot> indexedRoots = new ArrayList<>();

        Optional<Path> realReactorRoot = SafePath.realDirectory(reactorRoot);
        if (realReactorRoot.isEmpty()) {
            report.fail("The reactor root '" + reactorRoot + "' is not a readable directory.");
            return new Resolved(List.of(), List.of(), reactorRoot);
        }
        Path base = realReactorRoot.get();

        if (configured == null || configured.isEmpty()) {
            scanRoots.add(new ScanRoot(REACTOR_ROOT_ID, base));
            indexedRoots.add(new IndexedRoot(REACTOR_ROOT_ID, "."));
            return new Resolved(scanRoots, indexedRoots, base);
        }

        for (String entry : configured) {
            if (entry == null || entry.isBlank()) {
                continue;
            }
            Path candidate = Path.of(entry.trim());
            Path absolute = candidate.isAbsolute() ? candidate : base.resolve(candidate);

            Optional<Path> real = SafePath.realDirectory(absolute);
            if (real.isEmpty()) {
                report.fail("Configured scan root '" + entry + "' does not exist or is not a directory.");
                continue;
            }
            if (!real.get().startsWith(base)) {
                report.fail("Scan root '" + entry + "' resolves to " + real.get()
                        + ", which is outside the reactor root " + base
                        + ". Chapters must live inside the project.");
                continue;
            }
            String relative = SafePath.relativise(base, real.get());
            String id = relative.isEmpty() ? REACTOR_ROOT_ID : relative;
            scanRoots.add(new ScanRoot(id, real.get()));
            indexedRoots.add(new IndexedRoot(id, relative.isEmpty() ? "." : relative));
        }
        return new Resolved(scanRoots, indexedRoots, base);
    }

    /**
     * The resolved roots, in both the form the scanner needs and the form the index records.
     *
     * @param scanRoots    the directories to scan
     * @param indexedRoots the same roots, expressed relative to the reactor root
     * @param reactorRoot  the resolved reactor root
     */
    public record Resolved(List<ScanRoot> scanRoots, List<IndexedRoot> indexedRoots, Path reactorRoot) {

        /**
         * Copies both lists defensively.
         *
         * @throws IllegalArgumentException if any component is null
         */
        public Resolved {
            if (scanRoots == null || indexedRoots == null || reactorRoot == null) {
                throw new IllegalArgumentException("Resolved roots require all three components");
            }
            scanRoots = List.copyOf(scanRoots);
            indexedRoots = List.copyOf(indexedRoots);
        }
    }
}
