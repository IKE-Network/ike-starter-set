package network.ike.foundation.ike.hierarchy.author;

import java.text.Normalizer;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import network.ike.foundation.ike.hierarchy.model.ChapterId;

/**
 * Derives a chapter identifier from free text, such as a heading or a file name.
 *
 * <p>Used when an author registers a draft without naming an identifier. Accented characters are
 * decomposed and stripped rather than dropped outright, so "Coördinates" becomes
 * {@code coordinates} rather than {@code co-rdinates}, and a title that reduces to nothing usable
 * yields empty instead of a meaningless identifier.
 */
public final class Slug {

    private Slug() {
    }

    /**
     * Converts text to a chapter identifier.
     *
     * @param text the source text, such as a heading or file name
     * @return the derived identifier, or empty when the text contains nothing usable
     */
    public static Optional<ChapterId> from(String text) {
        if (text == null || text.isBlank()) {
            return Optional.empty();
        }
        String decomposed = Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}+", "");
        String slug = decomposed.toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-+|-+$", "");
        if (slug.isEmpty()) {
            return Optional.empty();
        }
        if (slug.length() > ChapterId.MAX_LENGTH) {
            slug = slug.substring(0, ChapterId.MAX_LENGTH).replaceAll("-+$", "");
        }
        return ChapterId.parse(slug);
    }

    /**
     * Converts text to an identifier that does not collide with any already taken.
     *
     * <p>Collisions are resolved by appending an ordinal rather than by failing, because
     * decomposing a real guide reliably produces two chapters whose titles slug identically, and
     * stopping the whole operation over it would be unhelpful.
     *
     * @param text  the source text
     * @param taken the identifiers already in use
     * @return an identifier not present in {@code taken}, or empty when the text yields nothing
     */
    public static Optional<ChapterId> unique(String text, Set<ChapterId> taken) {
        Optional<ChapterId> base = from(text);
        if (base.isEmpty() || taken == null) {
            return base;
        }
        if (!taken.contains(base.get())) {
            return base;
        }
        String stem = base.get().value();
        if (stem.length() > ChapterId.MAX_LENGTH - 4) {
            stem = stem.substring(0, ChapterId.MAX_LENGTH - 4).replaceAll("-+$", "");
        }
        for (int suffix = 2; suffix < 1000; suffix++) {
            Optional<ChapterId> candidate = ChapterId.parse(stem + "-" + suffix);
            if (candidate.isPresent() && !taken.contains(candidate.get())) {
                return candidate;
            }
        }
        return Optional.empty();
    }
}
