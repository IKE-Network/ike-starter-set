package network.ike.foundation.ike.hierarchy.author;

import java.util.List;

/**
 * The result of stamping a hierarchy declaration into a file's lines.
 *
 * <p>{@code changed} is what makes the goal safe to re-run. Registering a chapter that is already
 * registered with the same placement rewrites nothing and reports nothing, so the command can sit
 * in a script, be run twice by an impatient author, or be re-run after an unrelated failure
 * without touching the file or producing a spurious diff.
 *
 * @param lines   the file's lines after stamping
 * @param changed whether anything actually differs from the input
 * @param notes   a human-readable account of what was added, changed, or removed
 */
public record StampOutcome(List<String> lines, boolean changed, List<String> notes) {

    /**
     * Copies both lists defensively.
     *
     * @throws IllegalArgumentException if either list is null
     */
    public StampOutcome {
        if (lines == null || notes == null) {
            throw new IllegalArgumentException("A stamp outcome requires both lists");
        }
        lines = List.copyOf(lines);
        notes = List.copyOf(notes);
    }
}
