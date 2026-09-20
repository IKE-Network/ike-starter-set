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

import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The types family: a kind asserted, a kind tested, a value converted between kinds where
 * its content carries over, read from text in CQL's written forms or written out in them, a
 * measure converted between units, a System type built as an instance, the parts of a value,
 * and the evaluation's moment (IKE-Network/ike-issues#1117). Kinds are IKE's: a whole number
 * and a decimal are told apart by the places they were written with, and Integer and Long
 * are one kind.
 */
final class Types {

    private Types() {
    }

    /** What a type specifier or type name asks for. */
    sealed interface Target permits SystemTarget, ListTarget, IntervalTarget, TupleTarget, ChoiceTarget {
        /** Whether a value is of the kind, a missing value never. */
        boolean accepts(Value value);

        /** The missing value of the kind. */
        Value missing();

        /** The kind's name, for refusals. */
        String name();
    }

    /** One of the twenty-three System types, by its local name. */
    record SystemTarget(String name) implements Target {
        /**
         * Whether a value is of this kind, a missing value never.
         *
         * @param value the value
         * @return true when of the kind
         */
        @Override
        public boolean accepts(Value value) {
            if (value.isMissing()) {
                return false;
            }
            return switch (name) {
                case "Any" -> true;
                case "Boolean" -> value instanceof Presence;
                case "Integer", "Long" -> value instanceof Measure measure && !measure.extent()
                        && measure.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS && measure.isWhole();
                case "Decimal" -> value instanceof Measure measure && !measure.extent()
                        && measure.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS && !measure.isWhole();
                case "Quantity" -> value instanceof Measure measure && !measure.extent()
                        && measure.semantic().scale() == MeasureSemantic.Scale.UNIT;
                case "String" -> value instanceof Text;
                case "Date" -> value instanceof Measure measure && !measure.extent() && measure.semantic().scale() == MeasureSemantic.Scale.CALENDAR;
                case "DateTime" -> value instanceof Measure measure && !measure.extent() && measure.semantic().scale() == MeasureSemantic.Scale.EPOCH;
                case "Time" -> value instanceof Measure measure && !measure.extent() && measure.semantic().scale() == MeasureSemantic.Scale.DAY;
                case "Ratio" -> value instanceof RatioValue;
                case "Code" -> value instanceof ConceptValue;
                case "Concept" -> value instanceof ListValue list && list.values().stream().allMatch(item -> item instanceof ConceptValue);
                case "ValueSet", "CodeSystem", "Vocabulary" -> value instanceof ConceptSetValue;
                case "Interval" -> value instanceof Measure measure && measure.extent();
                case "IntegerInterval", "DecimalInterval" -> value instanceof Measure measure && measure.extent()
                        && measure.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS;
                case "QuantityInterval" -> value instanceof Measure measure && measure.extent() && measure.semantic().scale() == MeasureSemantic.Scale.UNIT;
                case "DateInterval" -> value instanceof Measure measure && measure.extent() && measure.semantic().scale() == MeasureSemantic.Scale.CALENDAR;
                case "DateTimeInterval" -> value instanceof Measure measure && measure.extent() && measure.semantic().scale() == MeasureSemantic.Scale.EPOCH;
                case "TimeInterval" -> value instanceof Measure measure && measure.extent() && measure.semantic().scale() == MeasureSemantic.Scale.DAY;
                default -> false;
            };
        }

        /** Whether an extent on a semantic could be an interval of this point type. */
        boolean acceptsScale(MeasureSemantic semantic) {
            return switch (name) {
                case "Integer", "Long", "Decimal" -> semantic.scale() == MeasureSemantic.Scale.DIMENSIONLESS;
                case "Quantity" -> semantic.scale() == MeasureSemantic.Scale.UNIT;
                case "Date" -> semantic.scale() == MeasureSemantic.Scale.CALENDAR;
                case "DateTime" -> semantic.scale() == MeasureSemantic.Scale.EPOCH;
                case "Time" -> semantic.scale() == MeasureSemantic.Scale.DAY;
                default -> true;
            };
        }

        /**
         * The missing value of this kind.
         *
         * @return the missing value
         */
        @Override
        public Value missing() {
            return switch (name) {
                case "Boolean" -> Presence.INDETERMINATE;
                case "Integer", "Long", "Decimal", "Quantity", "Date", "DateTime", "Time", "Interval", "IntegerInterval",
                     "DecimalInterval", "QuantityInterval", "DateInterval", "DateTimeInterval", "TimeInterval" -> new Missing(Value.Kind.MEASURE);
                case "String" -> new Missing(Value.Kind.TEXT);
                case "Ratio" -> new Missing(Value.Kind.RATIO);
                case "Code" -> new Missing(Value.Kind.CONCEPT);
                case "Concept" -> new Missing(Value.Kind.LIST);
                case "ValueSet", "CodeSystem", "Vocabulary" -> new Missing(Value.Kind.CONCEPT_SET);
                default -> Missing.ANY;
            };
        }
    }

    /** A list of an element kind. */
    record ListTarget(Optional<Target> element) implements Target {
        /**
         * Whether a value is of this kind, a missing value never.
         *
         * @param value the value
         * @return true when of the kind
         */
        @Override
        public boolean accepts(Value value) {
            return value instanceof ListValue list && list.values().stream()
                    .allMatch(item -> item.isMissing() || element.map(target -> target.accepts(item)).orElse(true));
        }

        /**
         * The missing value of this kind.
         *
         * @return the missing value
         */
        @Override
        public Value missing() {
            return new Missing(Value.Kind.LIST);
        }

        /**
         * The kind's name, for refusals.
         *
         * @return the name
         */
        @Override
        public String name() {
            return "List<" + element.map(Target::name).orElse("Any") + ">";
        }
    }

    /** An interval of a point kind. */
    record IntervalTarget(Optional<Target> point) implements Target {
        /**
         * Whether a value is of this kind, a missing value never.
         *
         * @param value the value
         * @return true when of the kind
         */
        @Override
        public boolean accepts(Value value) {
            return value instanceof Measure measure && measure.extent()
                    && point.map(target -> !(target instanceof SystemTarget system) || system.acceptsScale(measure.semantic())).orElse(true);
        }

        /**
         * The missing value of this kind.
         *
         * @return the missing value
         */
        @Override
        public Value missing() {
            return new Missing(Value.Kind.MEASURE);
        }

        /**
         * The kind's name, for refusals.
         *
         * @return the name
         */
        @Override
        public String name() {
            return "Interval<" + point.map(Target::name).orElse("Any") + ">";
        }
    }

    /** A tuple. */
    record TupleTarget() implements Target {
        /**
         * Whether a value is of this kind, a missing value never.
         *
         * @param value the value
         * @return true when of the kind
         */
        @Override
        public boolean accepts(Value value) {
            return value instanceof TupleValue;
        }

        /**
         * The missing value of this kind.
         *
         * @return the missing value
         */
        @Override
        public Value missing() {
            return new Missing(Value.Kind.TUPLE);
        }

        /**
         * The kind's name, for refusals.
         *
         * @return the name
         */
        @Override
        public String name() {
            return "Tuple";
        }
    }

    /** One of several kinds. */
    record ChoiceTarget(List<Target> alternatives) implements Target {
        /**
         * Whether a value is of this kind, a missing value never.
         *
         * @param value the value
         * @return true when of the kind
         */
        @Override
        public boolean accepts(Value value) {
            return alternatives.stream().anyMatch(target -> target.accepts(value));
        }

        /**
         * The missing value of this kind.
         *
         * @return the missing value
         */
        @Override
        public Value missing() {
            return Missing.ANY;
        }

        /**
         * The kind's name, for refusals.
         *
         * @return the name
         */
        @Override
        public String name() {
            return "Choice";
        }
    }

    private static final Map<Integer, String> SYSTEM_TYPES = new HashMap<>();

    private static synchronized Map<Integer, String> systemTypes() {
        if (SYSTEM_TYPES.isEmpty()) {
            EntityProxy.Concept[] concepts = {IkeTerms.ELM_SYSTEM_ANY, IkeTerms.ELM_SYSTEM_BOOLEAN, IkeTerms.ELM_SYSTEM_CODE,
                IkeTerms.ELM_SYSTEM_CODESYSTEM, IkeTerms.ELM_SYSTEM_CONCEPT, IkeTerms.ELM_SYSTEM_DATE, IkeTerms.ELM_SYSTEM_DATEINTERVAL,
                IkeTerms.ELM_SYSTEM_DATETIME, IkeTerms.ELM_SYSTEM_DATETIMEINTERVAL, IkeTerms.ELM_SYSTEM_DECIMAL,
                IkeTerms.ELM_SYSTEM_DECIMALINTERVAL, IkeTerms.ELM_SYSTEM_INTEGER, IkeTerms.ELM_SYSTEM_INTEGERINTERVAL,
                IkeTerms.ELM_SYSTEM_INTERVAL, IkeTerms.ELM_SYSTEM_LONG, IkeTerms.ELM_SYSTEM_QUANTITY, IkeTerms.ELM_SYSTEM_QUANTITYINTERVAL,
                IkeTerms.ELM_SYSTEM_RATIO, IkeTerms.ELM_SYSTEM_STRING, IkeTerms.ELM_SYSTEM_TIME, IkeTerms.ELM_SYSTEM_TIMEINTERVAL,
                IkeTerms.ELM_SYSTEM_VALUESET, IkeTerms.ELM_SYSTEM_VOCABULARY};
            String[] names = {"Any", "Boolean", "Code", "CodeSystem", "Concept", "Date", "DateInterval", "DateTime", "DateTimeInterval",
                "Decimal", "DecimalInterval", "Integer", "IntegerInterval", "Interval", "Long", "Quantity", "QuantityInterval", "Ratio",
                "String", "Time", "TimeInterval", "ValueSet", "Vocabulary"};
            for (int i = 0; i < concepts.length; i++) {
                SYSTEM_TYPES.put(concepts[i].nid(), names[i]);
            }
        }
        return SYSTEM_TYPES;
    }

    /** The System type a stored type concept names, empty for a data model's class. */
    static Optional<String> systemTypeName(int nid) {
        return Optional.ofNullable(systemTypes().get(nid));
    }

    private static Target system(int nid, Context context) {
        return new SystemTarget(systemTypeName(nid).orElseThrow(() ->
                context.refuse("the type " + PrimitiveData.text(nid) + " is a data model's class, and a model's instances are not values yet")));
    }

    /** The target a node names, as an attribute holding a type concept or as a held type specifier. */
    static Target target(TreeNode node, String attribute, String specifier, Context context) {
        Optional<Object> named = node.property(attribute);
        if (named.isPresent() && named.get() instanceof EntityProxy.Concept concept) {
            return system(concept.nid(), context);
        }
        TreeNode held = node.held(specifier).orElseThrow(() -> context.refuse("the " + node.kindName() + " names no type"));
        return specifier(held, context);
    }

    /** A type specifier tree read into a target. */
    static Target specifier(TreeNode tree, Context context) {
        switch (tree.kindName()) {
            case "NamedTypeSpecifier" -> {
                Object name = tree.property("name").orElseThrow(() -> context.refuse("a named type specifier has no name"));
                if (name instanceof EntityProxy.Concept concept) {
                    return system(concept.nid(), context);
                }
                throw context.refuse("the type " + name + " is not resolved to a concept");
            }
            case "ListTypeSpecifier" -> {
                return new ListTarget(tree.held("elementType").map(element -> specifier(element, context)));
            }
            case "IntervalTypeSpecifier" -> {
                return new IntervalTarget(tree.held("pointType").map(point -> specifier(point, context)));
            }
            case "TupleTypeSpecifier" -> {
                return new TupleTarget();
            }
            case "ChoiceTypeSpecifier" -> {
                List<Target> alternatives = new ArrayList<>();
                for (TreeNode choice : tree.items("choice")) {
                    alternatives.add(specifier(choice, context));
                }
                return new ChoiceTarget(alternatives);
            }
            default -> throw context.refuse("the type specifier " + tree.kindName() + " is not read");
        }
    }

    static void register(Operators registry) {
        registry.put("As", (node, context) -> {
            Target target = target(node, "asType", "asTypeSpecifier", context);
            Value value = Operators.single(node, context);
            if (value.isMissing()) {
                return target.missing();
            }
            if (target.accepts(value)) {
                return value;
            }
            if (node.flag("strict").orElse(false)) {
                throw context.refuse("the value is a " + value.kind() + ", asserted strictly to be " + target.name());
            }
            return target.missing();
        });
        registry.put("Is", (node, context) -> {
            Target target = target(node, "isType", "isTypeSpecifier", context);
            return Presence.of(target.accepts(Operators.single(node, context)));
        });
        registry.put("Convert", (node, context) -> {
            Target target = target(node, "toType", "toTypeSpecifier", context);
            return convert(Operators.single(node, context), target, context);
        });
        registry.put("CanConvert", (node, context) -> {
            Target target = target(node, "toType", "toTypeSpecifier", context);
            return possible(Operators.single(node, context), target, context);
        });
        for (String name : List.of("Boolean", "Concept", "Date", "DateTime", "Decimal", "Integer", "Long", "Quantity", "Ratio", "String", "Time")) {
            registry.put("To" + name, (node, context) -> convert(Operators.single(node, context), new SystemTarget(name), context));
            registry.put("ConvertsTo" + name, (node, context) -> possible(Operators.single(node, context), new SystemTarget(name), context));
        }
        registry.put("ToList", (node, context) -> {
            Value value = Operators.single(node, context);
            return value.isMissing() ? new ListValue(List.of()) : new ListValue(List.of(value));
        });
        registry.put("ToChars", (node, context) -> {
            Value value = Operators.single(node, context);
            if (value.isMissing()) {
                return new Missing(Value.Kind.LIST);
            }
            if (!(value instanceof Text text)) {
                throw context.refuse("the characters of a " + value.kind() + " are not read");
            }
            List<Value> characters = new ArrayList<>();
            text.text().codePoints().forEach(point -> characters.add(new Text(new String(Character.toChars(point)))));
            return new ListValue(characters);
        });
        registry.put("ConvertQuantity", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            Optional<Measure> converted = convertQuantity(operands.get(0), operands.get(1), context);
            return converted.isPresent() ? converted.get() : Operators.missingMeasure();
        });
        registry.put("CanConvertQuantity", (node, context) -> {
            List<Value> operands = Operators.pair(node, context);
            if (operands.get(0).isMissing() || operands.get(1).isMissing()) {
                return Presence.INDETERMINATE;
            }
            return Presence.of(convertQuantity(operands.get(0), operands.get(1), context).isPresent());
        });
        registry.put("Instance", Types::instance);
        registry.put("Children", (node, context) -> parts(Operators.operand(node, "source", context), false, context));
        registry.put("Descendents", (node, context) -> parts(Operators.operand(node, "source", context), true, context));
        registry.put("Descendants", (node, context) -> parts(Operators.operand(node, "source", context), true, context));
        registry.put("Today", (node, context) -> {
            ZonedDateTime now = Instants.at(Instants.millis(context.evaluator().now()));
            return Instants.date(now.getYear(), Optional.of(now.getMonthValue()), Optional.of(now.getDayOfMonth()));
        });
        registry.put("Now", (node, context) -> {
            ZonedDateTime now = Instants.at(Instants.millis(context.evaluator().now()));
            return Instants.dateTime(now.getYear(), Optional.of(now.getMonthValue()), Optional.of(now.getDayOfMonth()),
                    Optional.of(now.getHour()), Optional.of(now.getMinute()), Optional.of(now.getSecond()),
                    Optional.of(now.getNano() / 1_000_000), Optional.empty());
        });
        registry.put("TimeOfDay", (node, context) -> {
            ZonedDateTime now = Instants.at(Instants.millis(context.evaluator().now()));
            return Instants.time(now.getHour(), Optional.of(now.getMinute()), Optional.of(now.getSecond()), Optional.of(now.getNano() / 1_000_000));
        });
    }

    // ── Conversion ──

    private static Presence possible(Value value, Target target, Context context) {
        if (value.isMissing()) {
            return Presence.INDETERMINATE;
        }
        return Presence.of(!convert(value, target, context).isMissing());
    }

    /**
     * A value converted to a target kind: the content re-expressed where it carries over, and
     * the missing value of the target kind where text does not read.
     */
    static Value convert(Value value, Target target, Context context) {
        if (!(target instanceof SystemTarget system)) {
            throw context.refuse("conversion to " + target.name() + " is not read");
        }
        if (value.isMissing()) {
            return system.missing();
        }
        if (system.accepts(value) && !system.name().equals("Decimal")) {
            return value;
        }
        String name = system.name();
        Value converted = switch (name) {
            case "Boolean" -> value instanceof Text text ? booleanOf(text.text()) : null;
            case "Integer", "Long" -> wholeOf(value);
            case "Decimal" -> decimalOf(value);
            case "String" -> render(value).map(text -> (Value) new Text(text)).orElse(null);
            case "Date" -> dateOf(value, context);
            case "DateTime" -> dateTimeOf(value, context);
            case "Time" -> timeOf(value, context);
            case "Quantity" -> quantityOf(value, context);
            case "Ratio" -> value instanceof Text text ? ratioOf(text.text(), context) : null;
            case "Concept" -> value instanceof ConceptValue code ? ConceptValue.concept(List.of(code), code.display()) : null;
            default -> null;
        };
        if (converted == null) {
            throw context.refuse("a " + value.kind() + " does not convert to " + name);
        }
        return converted;
    }

    private static Value booleanOf(String text) {
        String word = text.trim().toLowerCase();
        if (Set.of("true", "t", "yes", "y", "1").contains(word)) {
            return Presence.PRESENT;
        }
        if (Set.of("false", "f", "no", "n", "0").contains(word)) {
            return Presence.ABSENT;
        }
        return Presence.INDETERMINATE;
    }

    private static final Pattern WHOLE = Pattern.compile("[+-]?\\d+");
    private static final Pattern DECIMAL = Pattern.compile("[+-]?\\d+(\\.\\d+)?");
    private static final Pattern DATE = Pattern.compile("(\\d{4})(?:-(\\d{2})(?:-(\\d{2}))?)?");
    private static final Pattern DATE_TIME = Pattern.compile(
            "(\\d{4})(?:-(\\d{2})(?:-(\\d{2})(?:T(\\d{2})(?::(\\d{2})(?::(\\d{2})(?:\\.(\\d{1,3}))?)?)?)?)?)?(Z|[+-]\\d{2}:\\d{2})?");
    private static final Pattern TIME = Pattern.compile("T?(\\d{2})(?::(\\d{2})(?::(\\d{2})(?:\\.(\\d{1,3}))?)?)?(Z|[+-]\\d{2}:\\d{2})?");
    private static final Pattern QUANTITY = Pattern.compile("([+-]?\\d+(?:\\.\\d+)?)\\s*(?:'([^']*)')?");

    private static Value wholeOf(Value value) {
        if (value instanceof Presence presence) {
            return Values.number(BigDecimal.valueOf(presence == Presence.PRESENT ? 1 : 0)).withPlaces(0);
        }
        if (value instanceof Text text) {
            String trimmed = text.text().trim();
            if (!WHOLE.matcher(trimmed).matches()) {
                return new Missing(Value.Kind.MEASURE);
            }
            return Values.number(new BigDecimal(trimmed)).withPlaces(0);
        }
        if (value instanceof Measure measure && measure.isPoint() && measure.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS) {
            BigDecimal stripped = measure.value().stripTrailingZeros();
            if (stripped.scale() > 0) {
                return new Missing(Value.Kind.MEASURE);
            }
            return Values.number(stripped.setScale(0)).withPlaces(0);
        }
        return null;
    }

    private static Value decimalOf(Value value) {
        if (value instanceof Presence presence) {
            return Values.number(new BigDecimal(presence == Presence.PRESENT ? "1.0" : "0.0")).withPlaces(1);
        }
        if (value instanceof Text text) {
            String trimmed = text.text().trim();
            if (!DECIMAL.matcher(trimmed).matches()) {
                return new Missing(Value.Kind.MEASURE);
            }
            BigDecimal number = new BigDecimal(trimmed);
            return Values.number(number).withPlaces(Math.max(1, number.scale()));
        }
        if (value instanceof Measure measure && measure.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS) {
            return measure.withPlaces(Math.max(1, measure.places().orElse(0)));
        }
        return null;
    }

    private static Value dateOf(Value value, Context context) {
        if (value instanceof Text text) {
            Matcher matcher = DATE.matcher(text.text().trim());
            if (!matcher.matches()) {
                return new Missing(Value.Kind.MEASURE);
            }
            return Instants.date(Integer.parseInt(matcher.group(1)), part(matcher, 2), part(matcher, 3));
        }
        if (value instanceof Measure measure && measure.semantic().scale() == MeasureSemantic.Scale.EPOCH && !measure.extent()) {
            Measure widened = measure.resolution().isPresent() && !measure.resolution().get().finerThan(Resolution.DAY)
                    ? measure : Instants.widenTo(measure, Resolution.DAY);
            return new Measure(widened.lower(), widened.upper(), true, true, MeasureSemantic.CALENDAR, widened.resolution(), false,
                    Optional.empty(), Optional.empty());
        }
        return null;
    }

    private static Value dateTimeOf(Value value, Context context) {
        if (value instanceof Text text) {
            Matcher matcher = DATE_TIME.matcher(text.text().trim());
            if (!matcher.matches()) {
                return new Missing(Value.Kind.MEASURE);
            }
            Optional<BigDecimal> offset = offsetHours(matcher.group(8));
            return Instants.dateTime(Integer.parseInt(matcher.group(1)), part(matcher, 2), part(matcher, 3), part(matcher, 4),
                    part(matcher, 5), part(matcher, 6), millis(matcher.group(7)), offset);
        }
        if (value instanceof Measure measure && measure.semantic().scale() == MeasureSemantic.Scale.CALENDAR && !measure.extent()) {
            return new Measure(measure.lower(), measure.upper(), true, true, MeasureSemantic.EPOCH, measure.resolution(), false,
                    Optional.empty(), Optional.empty());
        }
        return null;
    }

    private static Value timeOf(Value value, Context context) {
        if (value instanceof Text text) {
            Matcher matcher = TIME.matcher(text.text().trim());
            if (!matcher.matches()) {
                return new Missing(Value.Kind.MEASURE);
            }
            int hour = Integer.parseInt(matcher.group(1));
            Optional<Integer> minute = part(matcher, 2);
            Optional<Integer> second = part(matcher, 3);
            if (hour > 23 || minute.orElse(0) > 59 || second.orElse(0) > 59) {
                return new Missing(Value.Kind.MEASURE);
            }
            return Instants.time(hour, minute, second, millis(matcher.group(4)));
        }
        if (value instanceof Measure measure && measure.semantic().scale() == MeasureSemantic.Scale.EPOCH && !measure.extent()
                && measure.resolution().isPresent() && measure.resolution().get().finerThan(Resolution.DAY)) {
            ZonedDateTime start = Instants.at(measure.value());
            return Instants.time(start.getHour(), Optional.of(start.getMinute()), Optional.of(start.getSecond()),
                    Optional.of(start.getNano() / 1_000_000)).withPlaces(0);
        }
        return null;
    }

    private static Value quantityOf(Value value, Context context) {
        if (value instanceof Text text) {
            Matcher matcher = QUANTITY.matcher(text.text().trim());
            if (!matcher.matches()) {
                return new Missing(Value.Kind.MEASURE);
            }
            BigDecimal number = new BigDecimal(matcher.group(1));
            String unit = matcher.group(2) == null ? "" : matcher.group(2);
            return Measure.point(number, context.evaluator().units().semanticOf(unit, context)).withPlaces(Math.max(0, number.scale()));
        }
        if (value instanceof Measure measure && !measure.extent()
                && (measure.semantic().scale() == MeasureSemantic.Scale.DIMENSIONLESS || measure.semantic().scale() == MeasureSemantic.Scale.UNIT)) {
            return measure;
        }
        return null;
    }

    private static Value ratioOf(String text, Context context) {
        int colon = text.indexOf(':');
        if (colon < 0) {
            return new Missing(Value.Kind.RATIO);
        }
        Value numerator = quantityOf(new Text(text.substring(0, colon)), context);
        Value denominator = quantityOf(new Text(text.substring(colon + 1)), context);
        if (numerator instanceof Measure top && denominator instanceof Measure bottom) {
            return new RatioValue(top, bottom);
        }
        return new Missing(Value.Kind.RATIO);
    }

    private static Optional<Integer> part(Matcher matcher, int group) {
        return Optional.ofNullable(matcher.group(group)).map(Integer::parseInt);
    }

    private static Optional<Integer> millis(String digits) {
        if (digits == null) {
            return Optional.empty();
        }
        return Optional.of(Integer.parseInt((digits + "00").substring(0, 3)));
    }

    private static Optional<BigDecimal> offsetHours(String written) {
        if (written == null) {
            return Optional.empty();
        }
        if (written.equals("Z")) {
            return Optional.of(BigDecimal.ZERO);
        }
        int sign = written.charAt(0) == '-' ? -1 : 1;
        int hours = Integer.parseInt(written.substring(1, 3));
        int minutes = Integer.parseInt(written.substring(4, 6));
        return Optional.of(BigDecimal.valueOf(sign * (hours * 60 + minutes)).divide(BigDecimal.valueOf(60), Measure.PRECISION));
    }

    private static Optional<Measure> convertQuantity(Value quantity, Value unit, Context context) {
        Optional<Measure> measure = Operators.measure(quantity, context);
        if (measure.isEmpty() || unit.isMissing()) {
            return Optional.empty();
        }
        if (!(unit instanceof Text text)) {
            throw context.refuse("the unit to convert to must be text");
        }
        MeasureSemantic target = context.evaluator().units().semanticOf(text.text(), context);
        return measure.get().convertedTo(target);
    }

    // ── Writing out ──

    /**
     * A value written out in CQL's written form: a presence as true or false, a number with the
     * places it was written with, a quantity as its number and quoted unit, a date to its
     * resolution, an instant with the offset it was written with, a time of day, a text as is,
     * a ratio as its two quantities.
     */
    static Optional<String> render(Value value) {
        if (value instanceof Presence presence) {
            return presence == Presence.INDETERMINATE ? Optional.empty() : Optional.of(presence == Presence.PRESENT ? "true" : "false");
        }
        if (value instanceof Text text) {
            return Optional.of(text.text());
        }
        if (value instanceof RatioValue ratio) {
            Optional<String> top = render(ratio.numerator());
            Optional<String> bottom = render(ratio.denominator());
            return top.isPresent() && bottom.isPresent() ? Optional.of(top.get() + ":" + bottom.get()) : Optional.empty();
        }
        if (!(value instanceof Measure measure) || measure.extent() || !measure.bounded()) {
            return Optional.empty();
        }
        return switch (measure.semantic().scale()) {
            case DIMENSIONLESS -> Optional.of(number(measure.value(), measure.places()));
            case UNIT -> Optional.of(number(measure.value(), measure.places()) + " '" + measure.semantic().unit() + "'");
            case CALENDAR -> Optional.of(date(Instants.at(measure.value()), measure.resolution().orElse(Resolution.DAY)));
            case EPOCH -> Optional.of(dateTime(measure));
            case DAY -> Optional.of(time(Instants.localTime(measure), measure.resolution().orElse(Resolution.MILLISECOND)));
        };
    }

    static String number(BigDecimal value, Optional<Integer> places) {
        BigDecimal stripped = value.stripTrailingZeros();
        int written = places.orElse(Math.max(0, stripped.scale()));
        if (stripped.scale() < written) {
            stripped = stripped.setScale(written);
        }
        return stripped.toPlainString();
    }

    private static String date(ZonedDateTime at, Resolution resolution) {
        return switch (resolution) {
            case YEAR -> at.format(DateTimeFormatter.ofPattern("uuuu"));
            case MONTH -> at.format(DateTimeFormatter.ofPattern("uuuu-MM"));
            default -> at.format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
        };
    }

    private static String time(LocalTime at, Resolution resolution) {
        return switch (resolution) {
            case HOUR -> at.format(DateTimeFormatter.ofPattern("HH"));
            case MINUTE -> at.format(DateTimeFormatter.ofPattern("HH:mm"));
            case SECOND -> at.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            default -> at.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        };
    }

    private static String dateTime(Measure measure) {
        ZoneOffset zone = ZoneOffset.ofTotalSeconds(measure.offset().orElse(0) * 60);
        ZonedDateTime at = Instant.ofEpochMilli(measure.value().longValue()).atZone(zone);
        Resolution resolution = measure.resolution().orElse(Resolution.MILLISECOND);
        StringBuilder text = new StringBuilder(date(at, resolution));
        if (resolution.finerThan(Resolution.DAY)) {
            text.append('T').append(time(at.toLocalTime(), resolution));
        }
        if (measure.offset().isPresent()) {
            int minutes = Math.abs(measure.offset().get());
            text.append(measure.offset().get() < 0 ? '-' : '+').append(String.format("%02d:%02d", minutes / 60, minutes % 60));
        }
        return text.toString();
    }

    // ── Instances and parts ──

    private static Value instance(TreeNode node, Context context) {
        Object classType = node.property("classType").orElseThrow(() -> context.refuse("an instance names no class"));
        if (!(classType instanceof EntityProxy.Concept concept)) {
            throw context.refuse("the instance's class " + classType + " is not resolved to a concept");
        }
        String name = systemTypeName(concept.nid()).orElseThrow(() ->
                context.refuse("the class " + PrimitiveData.text(concept.nid()) + " is a data model's, and a model's instances are not values yet"));
        Map<String, Value> parts = new HashMap<>();
        Map<String, TreeNode> trees = new HashMap<>();
        for (TreeNode element : node.items("element")) {
            String part = element.text("name").orElseThrow(() -> context.refuse("an instance element has no name"));
            TreeNode held = element.held("value").orElseThrow(() -> context.refuse("the instance element " + part + " holds no value"));
            trees.put(part, held);
            if (!held.kindName().equals("CodeSystemRef")) {
                parts.put(part, context.evaluator().eval(held, context.at(part)));
            }
        }
        switch (name) {
            case "Code" -> {
                String[] system = trees.containsKey("system") ? Literals.codeSystem(trees.get("system"), context) : new String[] {"", ""};
                return new ConceptValue(text(parts, "code"), system[0], system[1], text(parts, "display"), Optional.empty());
            }
            case "Concept" -> {
                Value codes = parts.getOrDefault("codes", new ListValue(List.of()));
                if (!(codes instanceof ListValue list)) {
                    throw context.refuse("a concept's codes must be a list");
                }
                List<ConceptValue> members = new ArrayList<>();
                for (Value code : list.values()) {
                    if (code instanceof ConceptValue member) {
                        members.add(member);
                    }
                }
                return ConceptValue.concept(members, text(parts, "display"));
            }
            case "Quantity" -> {
                Optional<Measure> value = Operators.measure(parts.getOrDefault("value", Missing.ANY), context);
                if (value.isEmpty()) {
                    return Operators.missingMeasure();
                }
                return Measure.point(value.get().value(), context.evaluator().units().semanticOf(text(parts, "unit"), context))
                        .withPlaces(value.get().places().orElse(0));
            }
            case "Ratio" -> {
                Optional<Measure> top = Operators.measure(parts.getOrDefault("numerator", Missing.ANY), context);
                Optional<Measure> bottom = Operators.measure(parts.getOrDefault("denominator", Missing.ANY), context);
                return top.isPresent() && bottom.isPresent() ? new RatioValue(top.get(), bottom.get()) : new Missing(Value.Kind.RATIO);
            }
            case "ValueSet", "CodeSystem", "Vocabulary" -> {
                String id = text(parts, "id");
                Set<Integer> members = context.evaluator().conceptSets().members(id).orElse(Set.of());
                String label = parts.containsKey("name") ? text(parts, "name") : id;
                return new ConceptSetValue(label, members);
            }
            default -> throw context.refuse("an instance of " + name + " is not read");
        }
    }

    private static String text(Map<String, Value> parts, String name) {
        Value value = parts.get(name);
        if (value == null || value.isMissing()) {
            return "";
        }
        return render(value).orElse("");
    }

    private static Value parts(Value source, boolean deep, Context context) {
        if (source.isMissing()) {
            return new Missing(Value.Kind.LIST);
        }
        List<Value> found = new ArrayList<>();
        collect(source, deep, found, context);
        return new ListValue(found);
    }

    private static void collect(Value source, boolean deep, List<Value> found, Context context) {
        List<Value> children;
        if (source instanceof TupleValue tuple) {
            children = new ArrayList<>(tuple.parts().values());
        } else if (source instanceof ListValue list) {
            children = list.values();
        } else {
            throw context.refuse("the parts of a " + source.kind() + " are not read");
        }
        for (Value child : children) {
            found.add(child);
            if (deep && (child instanceof TupleValue || child instanceof ListValue)) {
                collect(child, true, found, context);
            }
        }
    }
}
