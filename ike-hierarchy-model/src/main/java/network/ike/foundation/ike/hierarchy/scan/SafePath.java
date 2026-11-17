package network.ike.foundation.ike.hierarchy.scan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Optional;

/**
 * The containment check every path in this system passes through before it is read or written.
 *
 * <p>The rule is one sentence: a path is usable only if, after symbolic links are resolved, it
 * still lies beneath a declared scan root. There is no fallback. The processor this design
 * replaces resolved an unrecognised include target against the filesystem root and read whatever
 * it found, which made {@code include::chapter:../../../../etc/passwd[]} a working directive in a
 * documentation build. Nothing here resolves a path it was not given a root for.
 *
 * <p>Resolution is done with {@link Path#toRealPath} rather than {@link Path#normalize} because
 * normalising is a string operation: it collapses {@code a/../b} without ever asking the
 * filesystem, so it cannot see that {@code a} is a symbolic link pointing somewhere else
 * entirely. Only a real-path resolution closes that gap.
 */
public final class SafePath {

    private SafePath() {
    }

    /**
     * Resolves a directory to its real path, for use as a scan root.
     *
     * @param directory the candidate root directory
     * @return the resolved real path, or empty when the directory does not exist or is not a
     *         directory
     */
    public static Optional<Path> realDirectory(Path directory) {
        if (directory == null) {
            return Optional.empty();
        }
        try {
            Path real = directory.toRealPath();
            return Files.isDirectory(real) ? Optional.of(real) : Optional.empty();
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    /**
     * Resolves an existing path and confirms it lies beneath a root.
     *
     * @param realRoot  a root that has already been resolved by {@link #realDirectory}
     * @param candidate the path to check, which must already exist
     * @return the resolved real path, or empty when it does not exist or escapes the root
     */
    public static Optional<Path> contain(Path realRoot, Path candidate) {
        if (realRoot == null || candidate == null) {
            return Optional.empty();
        }
        try {
            Path real = candidate.toRealPath();
            return real.startsWith(realRoot) ? Optional.of(real) : Optional.empty();
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    /**
     * Confirms that a path a caller intends to <em>create</em> would land beneath a root.
     *
     * <p>A file that does not exist yet has no real path, so the check is applied to the deepest
     * ancestor that does exist. That ancestor is where a symbolic link could redirect the write,
     * so containing it contains the write.
     *
     * @param realRoot a root that has already been resolved by {@link #realDirectory}
     * @param target   the path the caller intends to write to
     * @return the target expressed beneath the resolved ancestor, or empty when the write would
     *         land outside the root
     */
    public static Optional<Path> containForWrite(Path realRoot, Path target) {
        if (realRoot == null || target == null) {
            return Optional.empty();
        }
        Path absolute = target.isAbsolute() ? target : realRoot.resolve(target);
        Path existing = absolute.normalize();
        int climbed = 0;
        while (existing != null && !Files.exists(existing, LinkOption.NOFOLLOW_LINKS)) {
            existing = existing.getParent();
            climbed++;
            if (climbed > 4096) {
                return Optional.empty();
            }
        }
        if (existing == null) {
            return Optional.empty();
        }
        Optional<Path> realExisting = contain(realRoot, existing);
        if (realExisting.isEmpty()) {
            return Optional.empty();
        }
        Path relative = existing.relativize(absolute.normalize());
        Path resolved = realExisting.get().resolve(relative).normalize();
        return resolved.startsWith(realRoot) ? Optional.of(resolved) : Optional.empty();
    }

    /**
     * Expresses a contained path relative to its root, using forward slashes on every platform.
     *
     * <p>Forward slashes are not cosmetic here: this string is what goes into the generated index
     * and therefore into the comparison that decides whether two builds produced the same result.
     * A path that renders differently on Windows would make the index non-reproducible.
     *
     * @param realRoot the resolved root
     * @param realPath a path already confirmed to lie beneath {@code realRoot}
     * @return the relative path with {@code /} separators
     * @throws IllegalArgumentException if {@code realPath} does not lie beneath {@code realRoot}
     */
    public static String relativise(Path realRoot, Path realPath) {
        if (realRoot == null || realPath == null) {
            throw new IllegalArgumentException("Both a root and a path are required");
        }
        if (!realPath.startsWith(realRoot)) {
            throw new IllegalArgumentException(realPath + " does not lie beneath " + realRoot);
        }
        return realRoot.relativize(realPath).toString().replace('\\', '/');
    }
}
