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
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * The date components: one component of an instant or a time of day read as it was written,
 * in the offset it was written with, at its written resolution; the written offset itself;
 * and the date or the time of day of an instant (IKE-Network/ike-issues#1118).
 */
final class Components {

    private Components() {
    }

    static void register(Operators registry) {
        registry.put("DateTimeComponentFrom", Components::component);
        registry.put("TimezoneOffsetFrom", Components::offset);
        registry.put("TimezoneFrom", Components::offset);
        registry.put("DateFrom", (node, context) -> Types.convert(Operators.single(node, context), new Types.SystemTarget("Date"), context));
        registry.put("TimeFrom", (node, context) -> {
            Value value = Operators.single(node, context);
            if (value instanceof Measure measure && measure.semantic().scale() == MeasureSemantic.Scale.EPOCH
                    && !(measure.resolution().isPresent() && measure.resolution().get().finerThan(Resolution.DAY))) {
                return Operators.missingMeasure();
            }
            return Types.convert(value, new Types.SystemTarget("Time"), context);
        });
    }

    private static Value component(TreeNode node, Context context) {
        Resolution precision = Operators.precision(node).orElseThrow(() -> context.refuse("a component reading names no component"));
        Optional<Measure> measure = Operators.measure(Operators.single(node, context), context);
        if (measure.isEmpty()) {
            return Operators.missingMeasure();
        }
        Measure value = measure.get();
        if (value.extent() || !Units.isTemporal(value.semantic())) {
            throw context.refuse("a component is read off an instant or a time of day, not a " + value.kind()
                    + (value.extent() ? " extent" : ""));
        }
        if (precision == Resolution.WEEK) {
            throw context.refuse("the calendar has no week component");
        }
        boolean timeOfDay = value.semantic().scale() == MeasureSemantic.Scale.DAY;
        if (timeOfDay && !precision.finerThan(Resolution.DAY)) {
            throw context.refuse("a time of day has no " + precision.name().toLowerCase());
        }
        if (value.resolution().isPresent() && precision.finerThan(value.resolution().get())) {
            return Operators.missingMeasure();
        }
        if (timeOfDay) {
            java.time.LocalTime at = Instants.localTime(value);
            return whole(switch (precision) {
                case HOUR -> at.getHour();
                case MINUTE -> at.getMinute();
                case SECOND -> at.getSecond();
                default -> at.getNano() / 1_000_000;
            });
        }
        ZonedDateTime at = Instants.at(value.value()).withZoneSameInstant(ZoneOffset.ofTotalSeconds(value.offset().orElse(0) * 60));
        return whole(switch (precision) {
            case YEAR -> at.getYear();
            case MONTH -> at.getMonthValue();
            case DAY -> at.getDayOfMonth();
            case HOUR -> at.getHour();
            case MINUTE -> at.getMinute();
            case SECOND -> at.getSecond();
            default -> at.getNano() / 1_000_000;
        });
    }

    private static Value offset(TreeNode node, Context context) {
        Optional<Measure> measure = Operators.measure(Operators.single(node, context), context);
        if (measure.isEmpty()) {
            return Operators.missingMeasure();
        }
        Measure value = measure.get();
        if (value.extent() || value.semantic().scale() != MeasureSemantic.Scale.EPOCH) {
            throw context.refuse("an offset is read off an instant, not a " + value.kind());
        }
        if (value.offset().isEmpty()) {
            return Operators.missingMeasure();
        }
        BigDecimal hours = BigDecimal.valueOf(value.offset().get()).divide(BigDecimal.valueOf(60), 2, java.math.RoundingMode.HALF_EVEN);
        return Values.number(hours).withPlaces(2);
    }

    private static Value whole(int component) {
        return Values.number(BigDecimal.valueOf(component)).withPlaces(0);
    }
}
