package network.ike.foundation.ike.hierarchy.index;

/**
 * A scan root as recorded in the index: a stable identifier and the directory it refers to,
 * expressed relative to the project base.
 *
 * <p>The path is relative rather than absolute so the index does not encode the machine that
 * produced it, and — more importantly — so that a consumer must re-anchor it beneath a base
 * directory it obtained from its own build rather than from the index. An index cannot name a
 * directory outside the project because it has no syntax capable of expressing one.
 *
 * @param id   the stable root identifier, in practice a Maven artifact identifier
 * @param path the directory relative to the project base, using {@code /} separators
 */
public record IndexedRoot(String id, String path) {

    /**
     * Validates and normalises the root record.
     *
     * @throws IllegalArgumentException if either field is null or blank, or the path is absolute
     *                                  or contains a {@code ..} segment
     */
    public IndexedRoot {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("An indexed root requires an identifier");
        }
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Indexed root '" + id + "' requires a path");
        }
        id = id.trim();
        path = path.replace('\\', '/').trim();
        if (path.startsWith("/")) {
            throw new IllegalArgumentException(
                    "Indexed root '" + id + "' path must be relative to the project base: " + path);
        }
        for (String segment : path.split("/")) {
            if (segment.equals("..")) {
                throw new IllegalArgumentException(
                        "Indexed root '" + id + "' path escapes the project base: " + path);
            }
        }
    }
}
