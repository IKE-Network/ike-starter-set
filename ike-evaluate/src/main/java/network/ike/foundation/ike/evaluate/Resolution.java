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
 * The resolution a measure was written at: the precision of an instant, from a year down to a
 * millisecond, with the number of milliseconds a whole unit of it spans where that is fixed.
 * A month and a year vary in length, so their spans are computed on the calendar.
 */
public enum Resolution {
    /** A year. */
    YEAR(0),
    /** A month. */
    MONTH(0),
    /** A week, seven days. */
    WEEK(7L * 24 * 60 * 60 * 1000),
    /** A day. */
    DAY(24L * 60 * 60 * 1000),
    /** An hour. */
    HOUR(60L * 60 * 1000),
    /** A minute. */
    MINUTE(60L * 1000),
    /** A second. */
    SECOND(1000),
    /** A millisecond. */
    MILLISECOND(1);

    private final long milliseconds;

    Resolution(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    /**
     * The milliseconds a whole unit spans, zero for a month or a year, which vary.
     *
     * @return the span
     */
    public long milliseconds() {
        return milliseconds;
    }

    /**
     * Whether this resolution is finer than another.
     *
     * @param other the other
     * @return true when finer
     */
    public boolean finerThan(Resolution other) {
        return ordinal() > other.ordinal();
    }
}
