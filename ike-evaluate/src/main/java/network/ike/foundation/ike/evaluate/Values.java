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

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * What the evaluator says of two values: whether they are the same, whether they are
 * equivalent, and how they are ordered, each as a presence, by IKE's own reading. Missing
 * values make equality Indeterminate and equivalence decided; measures compare as spans, so
 * two instants written to different precisions come out Indeterminate where they overlap.
 */
final class Values {

    private Values() {
    }

    /** CQL's equality: Indeterminate when either side is missing, else the same value or not. */
    static Presence equal(Value a, Value b) {
        if (a.isMissing() || b.isMissing()) {
            return Presence.INDETERMINATE;
        }
        if (a instanceof Presence pa && b instanceof Presence pb) {
            return Presence.of(pa == pb);
        }
        if (a instanceof Measure ma && b instanceof Measure mb) {
            return ma.sameAs(mb);
        }
        if (a instanceof Text ta && b instanceof Text tb) {
            return Presence.of(ta.text().equals(tb.text()));
        }
        if (a instanceof ConceptValue ca && b instanceof ConceptValue cb) {
            return Presence.of(ca.sameAs(cb));
        }
        if (a instanceof RatioValue ra && b instanceof RatioValue rb) {
            return ra.numerator().sameAs(rb.numerator()).and(ra.denominator().sameAs(rb.denominator()));
        }
        if (a instanceof ListValue la && b instanceof ListValue lb) {
            if (la.values().size() != lb.values().size()) {
                return Presence.ABSENT;
            }
            Presence all = Presence.PRESENT;
            for (int i = 0; i < la.values().size(); i++) {
                all = all.and(elementEqual(la.values().get(i), lb.values().get(i)));
            }
            return all;
        }
        if (a instanceof TupleValue ta && b instanceof TupleValue tb) {
            if (!ta.parts().keySet().equals(tb.parts().keySet())) {
                return Presence.ABSENT;
            }
            Presence all = Presence.PRESENT;
            for (Map.Entry<String, Value> part : ta.parts().entrySet()) {
                all = all.and(elementEqual(part.getValue(), tb.parts().get(part.getKey())));
            }
            return all;
        }
        if (a instanceof StatementValue sa && b instanceof StatementValue sb) {
            return Presence.of(sa.statement().id().equals(sb.statement().id()));
        }
        if (a instanceof SubjectValue sa && b instanceof SubjectValue sb) {
            return Presence.of(sa.subject().id().equals(sb.subject().id()));
        }
        if (a instanceof ConceptSetValue ca && b instanceof ConceptSetValue cb) {
            return Presence.of(ca.members().equals(cb.members()));
        }
        return Presence.ABSENT;
    }

    /** Two elements of a list or a tuple: missing beside missing is the same element. */
    private static Presence elementEqual(Value a, Value b) {
        if (a.isMissing() && b.isMissing()) {
            return Presence.PRESENT;
        }
        return equal(a, b);
    }

    /**
     * CQL's equivalence: two missing values are equivalent, a missing and a present one are not,
     * texts are read without regard to case or the amount of white space, and what equality
     * leaves Indeterminate equivalence decides as Absent.
     */
    static Presence equivalent(Value a, Value b) {
        if (a.isMissing() && b.isMissing()) {
            return Presence.PRESENT;
        }
        if (a.isMissing() || b.isMissing()) {
            return Presence.ABSENT;
        }
        if (a instanceof Text ta && b instanceof Text tb) {
            return Presence.of(normalized(ta.text()).equals(normalized(tb.text())));
        }
        if (a instanceof ListValue la && b instanceof ListValue lb) {
            if (la.values().size() != lb.values().size()) {
                return Presence.ABSENT;
            }
            for (int i = 0; i < la.values().size(); i++) {
                if (equivalent(la.values().get(i), lb.values().get(i)) != Presence.PRESENT) {
                    return Presence.ABSENT;
                }
            }
            return Presence.PRESENT;
        }
        if (a instanceof TupleValue ta && b instanceof TupleValue tb) {
            if (!ta.parts().keySet().equals(tb.parts().keySet())) {
                return Presence.ABSENT;
            }
            for (Map.Entry<String, Value> part : ta.parts().entrySet()) {
                if (equivalent(part.getValue(), tb.parts().get(part.getKey())) != Presence.PRESENT) {
                    return Presence.ABSENT;
                }
            }
            return Presence.PRESENT;
        }
        Presence same = equal(a, b);
        return same == Presence.PRESENT ? Presence.PRESENT : Presence.ABSENT;
    }

    private static String normalized(String text) {
        return text.trim().replaceAll("\\s+", " ").toLowerCase();
    }

    /** The orders the comparison operators ask for. */
    enum Order {
        /** Strictly greater. */
        GREATER,
        /** Greater or the same. */
        GREATER_OR_EQUAL,
        /** Strictly less. */
        LESS,
        /** Less or the same. */
        LESS_OR_EQUAL
    }

    /**
     * How two measures are ordered, as spans: Present when every point of one stands in the
     * order to every point of the other, Absent when none does, Indeterminate where they overlap
     * without being the same, and decided by sameness where they are the same span.
     */
    static Presence compare(Measure a, Measure b, Order order) {
        Optional<Measure> converted = b.convertedTo(a.semantic());
        if (converted.isEmpty()) {
            return Presence.INDETERMINATE;
        }
        Measure that = converted.get();
        Presence same = a.sameAs(that);
        if (same == Presence.PRESENT) {
            return Presence.of(order == Order.GREATER_OR_EQUAL || order == Order.LESS_OR_EQUAL);
        }
        Presence after = a.after(that);
        Presence before = a.before(that);
        switch (order) {
            case GREATER:
                return after == Presence.PRESENT ? Presence.PRESENT : before == Presence.PRESENT ? Presence.ABSENT : Presence.INDETERMINATE;
            case LESS:
                return before == Presence.PRESENT ? Presence.PRESENT : after == Presence.PRESENT ? Presence.ABSENT : Presence.INDETERMINATE;
            case GREATER_OR_EQUAL:
                return after == Presence.PRESENT ? Presence.PRESENT : before == Presence.PRESENT ? Presence.ABSENT : Presence.INDETERMINATE;
            default:
                return before == Presence.PRESENT ? Presence.PRESENT : after == Presence.PRESENT ? Presence.ABSENT : Presence.INDETERMINATE;
        }
    }

    /** Two measures at a precision: both widened to the whole unit around them, then compared as spans. */
    static Measure atPrecision(Measure measure, Optional<Resolution> precision) {
        if (precision.isEmpty() || measure.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS
                || measure.semantic().scale() == MeasureSemantic.Scale.UNIT) {
            return measure;
        }
        if (measure.resolution().isPresent() && !measure.resolution().get().finerThan(precision.get())) {
            return measure;
        }
        return Instants.widenTo(measure, precision.get());
    }

    /** A number as a point measure on the dimensionless number. */
    static Measure number(BigDecimal value) {
        return Measure.point(value, MeasureSemantic.DIMENSIONLESS);
    }

    /** The measures of a list that count: not missing, and measures. */
    static List<Measure> measures(ListValue list, Context context) {
        return list.values().stream().filter(value -> !value.isMissing()).map(value -> {
            if (value instanceof Measure measure) {
                return measure;
            }
            throw context.refuse("a measure aggregate takes measures; the list holds a " + value.kind());
        }).toList();
    }
}
