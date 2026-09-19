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
 * A value the evaluator holds, of one of IKE's own kinds (IKE-Network/ike-issues#1116): a
 * presence, a measure, a text, a concept, a concept set, a list, a tuple, a ratio, a statement,
 * a subject, or a missing value of a kind. Every value carries its kind; a missing value is a
 * value of its kind with no content.
 */
public sealed interface Value permits Presence, Measure, Text, ConceptValue, ConceptSetValue, ListValue, TupleValue,
        RatioValue, StatementValue, SubjectValue, Missing {

    /**
     * The kind of the value, for refusals and for missing values.
     *
     * @return the kind
     */
    Kind kind();

    /**
     * Whether the value is missing: a Missing value, or an Indeterminate presence, which is the
     * missing presence.
     *
     * @return true when missing
     */
    default boolean isMissing() {
        return false;
    }

    /** The kinds a value can be of. */
    enum Kind {
        /** A presence: Present, Absent, or Indeterminate. */
        PRESENCE,
        /** A measure: bounds on a measure semantic. */
        MEASURE,
        /** A text. */
        TEXT,
        /** A concept, by its code in its system and, where the store has it, its identity. */
        CONCEPT,
        /** A concept set, a value set under a view. */
        CONCEPT_SET,
        /** A list of values. */
        LIST,
        /** A tuple of named parts. */
        TUPLE,
        /** A ratio of two measures. */
        RATIO,
        /** A statement. */
        STATEMENT,
        /** A subject. */
        SUBJECT,
        /** A value of no settled kind, CQL's Any. */
        ANY
    }
}
