package network.ike.foundation.ike.hierarchy.model;

import java.util.List;

/**
 * The outcome of validating a discovered chapter set.
 *
 * <p>Sealed with exactly two cases so that a caller cannot read a hierarchy without having first
 * dealt with the possibility that there isn't one. The build's strictness policy lives at the
 * single point that switches over this type, not scattered through the scanning code.
 */
public sealed interface HierarchyResult {

    /**
     * Returns the violations found, empty when validation succeeded.
     *
     * @return the violation list, never null
     */
    List<Violation> violations();

    /**
     * A chapter set that placed cleanly.
     *
     * @param hierarchy the validated forest
     */
    record Valid(Hierarchy hierarchy) implements HierarchyResult {
        /**
         * Checks that a valid result actually carries a hierarchy.
         *
         * @throws IllegalArgumentException if the hierarchy is null
         */
        public Valid {
            if (hierarchy == null) {
                throw new IllegalArgumentException("A valid result requires a hierarchy");
            }
        }

        @Override
        public List<Violation> violations() {
            return List.of();
        }
    }

    /**
     * A chapter set with at least one defect. No hierarchy is offered, because a partially placed
     * forest is exactly the silent-omission failure this design exists to prevent.
     *
     * @param violations every defect found, in discovery order
     */
    record Invalid(List<Violation> violations) implements HierarchyResult {
        /**
         * Copies the violation list defensively and rejects an empty one.
         *
         * @throws IllegalArgumentException if the list is null or empty
         */
        public Invalid {
            if (violations == null || violations.isEmpty()) {
                throw new IllegalArgumentException("An invalid result requires at least one violation");
            }
            violations = List.copyOf(violations);
        }
    }

    /**
     * Renders every violation as a single multi-line block for a build failure message.
     *
     * @return one line per violation, or an empty string when there are none
     */
    default String report() {
        StringBuilder builder = new StringBuilder();
        for (Violation violation : violations()) {
            builder.append("  - ").append(violation.message()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
