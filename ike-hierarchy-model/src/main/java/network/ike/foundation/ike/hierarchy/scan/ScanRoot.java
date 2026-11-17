package network.ike.foundation.ike.hierarchy.scan;

import java.nio.file.Path;

/**
 * A directory the scanner is permitted to look for chapters in, and the identifier by which the
 * generated index refers to it.
 *
 * <p>Roots are the trust boundary. Chapter paths are recorded relative to a root and never as
 * absolute paths, so a consumer of the index can only reach files beneath a root it has itself
 * resolved — which means an index copied from another machine, or edited by hand, still cannot
 * name a file outside the project.
 *
 * <p>The identifier is a stable, machine-independent name for the directory, in practice a Maven
 * module's artifact identifier. It is what allows the same index to be read from a different
 * checkout path than the one that produced it.
 *
 * @param id        the stable identifier for this root
 * @param directory the directory to scan
 */
public record ScanRoot(String id, Path directory) {

    /**
     * Validates the root declaration.
     *
     * @throws IllegalArgumentException if the identifier is null or blank, or the directory is null
     */
    public ScanRoot {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("A scan root requires an identifier");
        }
        if (directory == null) {
            throw new IllegalArgumentException("Scan root '" + id + "' requires a directory");
        }
        id = id.trim();
    }
}
