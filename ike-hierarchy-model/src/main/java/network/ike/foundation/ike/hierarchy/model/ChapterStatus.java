package network.ike.foundation.ike.hierarchy.model;

import java.util.Locale;
import java.util.Optional;

/**
 * The editorial lifecycle state of a chapter, mirroring the {@code status} vocabulary of
 * {@code IKE-TOPIC-REGISTRY.md} so that a decentralised chapter header and a registry entry
 * describe a chapter's maturity in the same words.
 *
 * <p>Status never affects hierarchy placement. It is carried in the index so that an assembly
 * can choose to exclude, for example, drafts from a published build without any chapter file
 * needing to know which assemblies exist.
 */
public enum ChapterStatus {

    /** Being written; not yet offered for review. */
    DRAFT,
    /** Offered for inclusion, awaiting a decision. */
    PROPOSED,
    /** Under review. */
    REVIEW,
    /** Accepted and published. This is the default when a chapter declares no status. */
    PUBLISHED,
    /** Superseded; retained for reference but not to be extended. */
    DEPRECATED;

    /** The status assumed for a chapter whose header declares none. */
    public static final ChapterStatus DEFAULT = PUBLISHED;

    /**
     * Parses a status token case-insensitively.
     *
     * @param text the raw status text from a chapter header, possibly null or blank
     * @return the matching status, or empty if {@code text} is null, blank, or unrecognised
     */
    public static Optional<ChapterStatus> parse(String text) {
        if (text == null || text.isBlank()) {
            return Optional.empty();
        }
        String token = text.trim().toUpperCase(Locale.ROOT);
        for (ChapterStatus candidate : values()) {
            if (candidate.name().equals(token)) {
                return Optional.of(candidate);
            }
        }
        return Optional.empty();
    }

    /**
     * Returns the lowercase token written into chapter headers and the index.
     *
     * @return the wire form of this status
     */
    public String token() {
        return name().toLowerCase(Locale.ROOT);
    }
}
