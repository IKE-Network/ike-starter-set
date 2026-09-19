/*
 * Copyright © 2026 IKE Network (support@ike.network)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package network.ike.foundation.ike.evaluate;

/**
 * A presence: what CQL calls a Boolean, read as the presence measure kind by logical
 * equivalence. Present is true, Absent is false, and Indeterminate is null, the missing
 * presence, and the connectives run the three-row table.
 */
public enum Presence implements Value {
    /** Present: true. */
    PRESENT,
    /** Absent: false. */
    ABSENT,
    /** Indeterminate: the missing presence, null. */
    INDETERMINATE;

    /**
     * The kind of this value.
     *
     * @return the kind
     */
    @Override
    public Kind kind() {
        return Kind.PRESENCE;
    }

    /**
     * Whether this value is missing: of its kind, with no content.
     *
     * @return true when missing
     */
    @Override
    public boolean isMissing() {
        return this == INDETERMINATE;
    }

    /**
     * The presence of a truth value.
     *
     * @param truth the truth value
     * @return Present or Absent
     */
    public static Presence of(boolean truth) {
        return truth ? PRESENT : ABSENT;
    }

    /**
     * Presence AND, the three-row table: Absent when either is Absent, Present when both are
     * Present, Indeterminate otherwise.
     *
     * @param other the other presence
     * @return the conjunction
     */
    public Presence and(Presence other) {
        if (this == ABSENT || other == ABSENT) {
            return ABSENT;
        }
        return this == PRESENT && other == PRESENT ? PRESENT : INDETERMINATE;
    }

    /**
     * Presence OR: Present when either is Present, Absent when both are Absent, Indeterminate
     * otherwise.
     *
     * @param other the other presence
     * @return the disjunction
     */
    public Presence or(Presence other) {
        if (this == PRESENT || other == PRESENT) {
            return PRESENT;
        }
        return this == ABSENT && other == ABSENT ? ABSENT : INDETERMINATE;
    }

    /**
     * Presence NOT: Present and Absent swap, Indeterminate stays.
     *
     * @return the negation
     */
    public Presence not() {
        return this == PRESENT ? ABSENT : this == ABSENT ? PRESENT : INDETERMINATE;
    }

    /**
     * Presence exclusive OR: Indeterminate when either is, else Present when the two differ.
     *
     * @param other the other presence
     * @return the exclusive disjunction
     */
    public Presence xor(Presence other) {
        if (this == INDETERMINATE || other == INDETERMINATE) {
            return INDETERMINATE;
        }
        return this != other ? PRESENT : ABSENT;
    }

    /**
     * Presence implication: not this, or the other.
     *
     * @param other the consequent
     * @return the implication
     */
    public Presence implies(Presence other) {
        return not().or(other);
    }
}
