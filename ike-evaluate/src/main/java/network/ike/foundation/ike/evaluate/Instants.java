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
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * Instants and calendar spans as measures: a date, a date and time, or a time written to a
 * precision becomes a measure spanning the whole of what it could be, in milliseconds from the
 * epoch in UTC for dates and instants and from midnight for times. Arithmetic and durations go
 * through the calendar, so that a month is the month on the calendar.
 */
final class Instants {

    private Instants() {
    }

    /** The span of a date written to a precision: the whole year, month, or day, as a calendar measure. */
    static Measure date(int year, Optional<Integer> month, Optional<Integer> day) {
        LocalDate start;
        LocalDate end;
        Resolution resolution;
        if (month.isEmpty()) {
            start = LocalDate.of(year, 1, 1);
            end = start.plusYears(1);
            resolution = Resolution.YEAR;
        } else if (day.isEmpty()) {
            start = LocalDate.of(year, month.get(), 1);
            end = start.plusMonths(1);
            resolution = Resolution.MONTH;
        } else {
            start = LocalDate.of(year, month.get(), day.get());
            end = start.plusDays(1);
            resolution = Resolution.DAY;
        }
        return Measure.span(millis(start.atStartOfDay()), millis(end.atStartOfDay()).subtract(BigDecimal.ONE),
                MeasureSemantic.CALENDAR, resolution);
    }

    /**
     * The span of a date and time written to a precision, in UTC, an offset applied where given:
     * the whole of the finest component written.
     */
    static Measure dateTime(int year, Optional<Integer> month, Optional<Integer> day, Optional<Integer> hour,
                            Optional<Integer> minute, Optional<Integer> second, Optional<Integer> millisecond,
                            Optional<BigDecimal> offsetHours) {
        if (hour.isEmpty()) {
            Measure date = date(year, month, day);
            return new Measure(date.lower(), date.upper(), true, true, MeasureSemantic.EPOCH, date.resolution(), false);
        }
        LocalDateTime start = LocalDateTime.of(year, month.orElse(1), day.orElse(1), hour.get(), minute.orElse(0),
                second.orElse(0), millisecond.orElse(0) * 1_000_000);
        Resolution resolution = millisecond.isPresent() ? Resolution.MILLISECOND : second.isPresent() ? Resolution.SECOND
                : minute.isPresent() ? Resolution.MINUTE : Resolution.HOUR;
        LocalDateTime end = switch (resolution) {
            case HOUR -> start.plusHours(1);
            case MINUTE -> start.plusMinutes(1);
            case SECOND -> start.plusSeconds(1);
            default -> start.plus(1, ChronoUnit.MILLIS);
        };
        ZoneOffset offset = offsetHours.map(hours -> ZoneOffset.ofTotalSeconds(hours.multiply(BigDecimal.valueOf(3600)).intValue()))
                .orElse(ZoneOffset.UTC);
        return Measure.span(millis(start.atOffset(offset).toInstant()), millis(end.atOffset(offset).toInstant()).subtract(BigDecimal.ONE),
                MeasureSemantic.EPOCH, resolution);
    }

    /** The span of a time of day written to a precision, in milliseconds from midnight. */
    static Measure time(int hour, Optional<Integer> minute, Optional<Integer> second, Optional<Integer> millisecond) {
        long start = hour * 3_600_000L + minute.orElse(0) * 60_000L + second.orElse(0) * 1000L + millisecond.orElse(0);
        Resolution resolution = millisecond.isPresent() ? Resolution.MILLISECOND : second.isPresent() ? Resolution.SECOND
                : minute.isPresent() ? Resolution.MINUTE : Resolution.HOUR;
        long extent = resolution.milliseconds();
        return Measure.span(BigDecimal.valueOf(start), BigDecimal.valueOf(start + extent - 1), MeasureSemantic.DAY, resolution);
    }

    static BigDecimal millis(LocalDateTime local) {
        return millis(local.toInstant(ZoneOffset.UTC));
    }

    static BigDecimal millis(Instant instant) {
        return BigDecimal.valueOf(instant.toEpochMilli());
    }

    static ZonedDateTime at(BigDecimal millis) {
        return Instant.ofEpochMilli(millis.longValue()).atZone(ZoneOffset.UTC);
    }

    /**
     * A calendar or epoch measure with the same span moved by whole units of a resolution, on the
     * calendar: adding a month to January 31 lands on the last day of February.
     */
    static Measure shift(Measure measure, long amount, Resolution unit) {
        ChronoUnit chrono = chrono(unit);
        java.util.function.UnaryOperator<BigDecimal> move = bound -> millis(at(bound).plus(amount, chrono).toInstant());
        return measure.mapBounds(move, measure.semantic());
    }

    /** Whole units of a resolution from the start of one measure to the start of another, on the calendar. */
    static long wholeUnitsBetween(Measure from, Measure to, Resolution unit) {
        return chrono(unit).between(at(from.value()), at(to.value()));
    }

    /** Boundaries of a resolution crossed from one measure's start to another's. */
    static long boundariesBetween(Measure from, Measure to, Resolution unit) {
        ZonedDateTime a = at(from.value()).truncatedTo(truncation(unit));
        ZonedDateTime b = at(to.value()).truncatedTo(truncation(unit));
        if (unit == Resolution.YEAR) {
            return b.getYear() - a.getYear();
        }
        if (unit == Resolution.MONTH) {
            return (b.getYear() - a.getYear()) * 12L + (b.getMonthValue() - a.getMonthValue());
        }
        return chrono(unit).between(a, b);
    }

    /** The span of a measure widened to a coarser resolution: the whole year, month, or day around it. */
    static Measure widenTo(Measure measure, Resolution resolution) {
        if (!measure.bounded()) {
            return measure;
        }
        ZonedDateTime start = at(measure.lower().get());
        ZonedDateTime end = at(measure.upper().get());
        ZonedDateTime from;
        ZonedDateTime to;
        switch (resolution) {
            case YEAR -> {
                from = start.truncatedTo(ChronoUnit.DAYS).withDayOfYear(1);
                to = end.truncatedTo(ChronoUnit.DAYS).withDayOfYear(1).plusYears(1);
            }
            case MONTH -> {
                from = start.truncatedTo(ChronoUnit.DAYS).withDayOfMonth(1);
                to = end.truncatedTo(ChronoUnit.DAYS).withDayOfMonth(1).plusMonths(1);
            }
            case WEEK -> {
                from = start.truncatedTo(ChronoUnit.DAYS);
                to = end.truncatedTo(ChronoUnit.DAYS).plusWeeks(1);
            }
            default -> {
                ChronoUnit chrono = truncation(resolution);
                from = start.truncatedTo(chrono);
                to = end.truncatedTo(chrono).plus(1, chrono);
            }
        }
        return new Measure(Optional.of(millis(from.toInstant())), Optional.of(millis(to.toInstant()).subtract(BigDecimal.ONE)),
                true, true, measure.semantic(), Optional.of(resolution), measure.extent());
    }

    /** The start of the unit an instant falls in: the day for a day or coarser, else the hour, minute, second, or millisecond. */
    static BigDecimal startOfUnit(BigDecimal millis, Resolution resolution) {
        return millis(at(millis).truncatedTo(truncation(resolution)).toInstant());
    }

    private static ChronoUnit chrono(Resolution unit) {
        return switch (unit) {
            case YEAR -> ChronoUnit.YEARS;
            case MONTH -> ChronoUnit.MONTHS;
            case WEEK -> ChronoUnit.WEEKS;
            case DAY -> ChronoUnit.DAYS;
            case HOUR -> ChronoUnit.HOURS;
            case MINUTE -> ChronoUnit.MINUTES;
            case SECOND -> ChronoUnit.SECONDS;
            case MILLISECOND -> ChronoUnit.MILLIS;
        };
    }

    private static ChronoUnit truncation(Resolution unit) {
        return switch (unit) {
            case YEAR, MONTH, WEEK, DAY -> ChronoUnit.DAYS;
            case HOUR -> ChronoUnit.HOURS;
            case MINUTE -> ChronoUnit.MINUTES;
            case SECOND -> ChronoUnit.SECONDS;
            case MILLISECOND -> ChronoUnit.MILLIS;
        };
    }

    /** A time-of-day measure as a local time, for display and checks. */
    static LocalTime localTime(Measure measure) {
        return LocalTime.ofNanoOfDay(measure.value().longValue() * 1_000_000L);
    }
}
