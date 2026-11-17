package network.ike.foundation.ike.hierarchy.maven.support;

import java.util.ArrayList;
import java.util.List;

/**
 * What a goal did, collected so it can be logged by the caller rather than printed as work happens.
 *
 * <p>Separating doing from reporting is what makes the support classes testable without a Maven
 * {@code Log}, and what makes a dry run possible: the same code path produces the same report
 * whether or not anything was written.
 */
public final class GoalReport {

    private final List<String> lines = new ArrayList<>();
    private final List<String> warnings = new ArrayList<>();
    private final List<String> failures = new ArrayList<>();

    /**
     * Records an informational line.
     *
     * @param line the message
     * @return this report, for chaining
     */
    public GoalReport info(String line) {
        lines.add(line);
        return this;
    }

    /**
     * Records a warning that does not stop the build.
     *
     * @param line the message
     * @return this report, for chaining
     */
    public GoalReport warn(String line) {
        warnings.add(line);
        return this;
    }

    /**
     * Records a condition that must fail the build.
     *
     * @param line the message
     * @return this report, for chaining
     */
    public GoalReport fail(String line) {
        failures.add(line);
        return this;
    }

    /**
     * Returns the informational lines.
     *
     * @return the messages, in the order recorded
     */
    public List<String> infoLines() {
        return List.copyOf(lines);
    }

    /**
     * Returns the warnings.
     *
     * @return the messages, in the order recorded
     */
    public List<String> warnings() {
        return List.copyOf(warnings);
    }

    /**
     * Returns the failures.
     *
     * @return the messages, in the order recorded
     */
    public List<String> failures() {
        return List.copyOf(failures);
    }

    /**
     * Reports whether anything recorded here must fail the build.
     *
     * @return true when at least one failure was recorded
     */
    public boolean failed() {
        return !failures.isEmpty();
    }

    /**
     * Renders the failures as a single message suitable for an exception.
     *
     * @param headline the sentence to lead with
     * @return the headline followed by one indented line per failure
     */
    public String failureMessage(String headline) {
        StringBuilder builder = new StringBuilder(headline);
        for (String failure : failures) {
            builder.append(System.lineSeparator()).append("  - ").append(failure);
        }
        return builder.toString();
    }
}
