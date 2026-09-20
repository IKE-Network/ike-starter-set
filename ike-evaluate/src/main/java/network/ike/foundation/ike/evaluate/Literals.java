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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The literals: a written value, a missing value, a quantity, an interval, a date, a date and
 * time, a time of day, a code, a concept, a ratio, a list, and a tuple, each read into the
 * value of the construct its relation names.
 */
final class Literals {

    private Literals() {
    }

    static void register(Operators registry) {
        registry.put("Literal", Literals::literal);
        registry.put("Null", (node, context) -> Missing.ANY);
        registry.put("Quantity", Literals::quantity);
        registry.put("Interval", Literals::interval);
        registry.put("Date", (node, context) -> {
            Optional<Integer> year = component(node, "year", context);
            if (year.isEmpty()) {
                return Operators.missingMeasure();
            }
            return Instants.date(year.get(), component(node, "month", context), component(node, "day", context));
        });
        registry.put("DateTime", (node, context) -> {
            Optional<Integer> year = component(node, "year", context);
            if (year.isEmpty()) {
                return Operators.missingMeasure();
            }
            Optional<BigDecimal> offset = Operators.optionalOperand(node, "timezoneOffset", context)
                    .flatMap(value -> Operators.measure(value, context)).map(Measure::value);
            return Instants.dateTime(year.get(), component(node, "month", context), component(node, "day", context),
                    component(node, "hour", context), component(node, "minute", context), component(node, "second", context),
                    component(node, "millisecond", context), offset);
        });
        registry.put("Time", (node, context) -> {
            Optional<Integer> hour = component(node, "hour", context);
            if (hour.isEmpty()) {
                return Operators.missingMeasure();
            }
            return Instants.time(hour.get(), component(node, "minute", context), component(node, "second", context),
                    component(node, "millisecond", context));
        });
        registry.put("Code", Literals::code);
        registry.put("Concept", (node, context) -> {
            List<ConceptValue> codes = new ArrayList<>();
            for (TreeNode item : node.items("code")) {
                codes.add(code(item, context.at("code")));
            }
            return ConceptValue.concept(codes, node.text("display").orElse(""));
        });
        registry.put("Ratio", (node, context) -> {
            Optional<Measure> numerator = Operators.measure(Operators.operand(node, "numerator", context), context);
            Optional<Measure> denominator = Operators.measure(Operators.operand(node, "denominator", context), context);
            if (numerator.isEmpty() || denominator.isEmpty()) {
                return new Missing(Value.Kind.RATIO);
            }
            return new RatioValue(numerator.get(), denominator.get());
        });
        registry.put("List", (node, context) -> {
            List<Value> values = new ArrayList<>();
            List<TreeNode> items = node.items("element");
            for (int i = 0; i < items.size(); i++) {
                values.add(context.evaluator().eval(items.get(i), context.at("element[" + (i + 1) + "]")));
            }
            return new ListValue(values);
        });
        registry.put("Tuple", (node, context) -> {
            Map<String, Value> parts = new LinkedHashMap<>();
            for (TreeNode element : node.items("element")) {
                String name = element.text("name").orElseThrow(() -> context.refuse("a tuple element has no name"));
                parts.put(name, Operators.operand(element, "value", context.at(name)));
            }
            return new TupleValue(parts);
        });
    }

    private static Value literal(TreeNode node, Context context) {
        Optional<Object> stored = node.property("valueType");
        String local;
        if (stored.isPresent() && stored.get() instanceof EntityProxy.Concept concept) {
            local = systemTypeName(concept.nid());
        } else {
            String type = stored.map(String::valueOf).orElse("");
            local = type.substring(type.indexOf('}') + 1);
        }
        String text = node.text("value").orElse("");
        return switch (local) {
            case "Boolean" -> Presence.of(Boolean.parseBoolean(text));
            case "Integer", "Long" -> Values.number(new BigDecimal(text)).withPlaces(0);
            case "Decimal" -> {
                BigDecimal number = new BigDecimal(text);
                yield Values.number(number).withPlaces(Math.max(1, number.scale()));
            }
            case "String" -> new Text(text);
            default -> throw context.refuse("a literal of type " + local + " is not read");
        };
    }

    /** The local name of a System type held as the catalog's concept for it. */
    private static String systemTypeName(int nid) {
        if (nid == IkeTerms.ELM_SYSTEM_BOOLEAN.nid()) {
            return "Boolean";
        }
        if (nid == IkeTerms.ELM_SYSTEM_INTEGER.nid()) {
            return "Integer";
        }
        if (nid == IkeTerms.ELM_SYSTEM_LONG.nid()) {
            return "Long";
        }
        if (nid == IkeTerms.ELM_SYSTEM_DECIMAL.nid()) {
            return "Decimal";
        }
        if (nid == IkeTerms.ELM_SYSTEM_STRING.nid()) {
            return "String";
        }
        return PrimitiveData.text(nid);
    }

    private static Value quantity(TreeNode node, Context context) {
        Optional<BigDecimal> value = node.number("value");
        if (value.isEmpty()) {
            return Operators.missingMeasure();
        }
        return Measure.point(value.get(), context.evaluator().units().semanticOf(node.text("unit").orElse(""), context))
                .withPlaces(Math.max(0, value.get().scale()));
    }

    private static Value interval(TreeNode node, Context context) {
        Optional<Measure> low = Operators.optionalOperand(node, "low", context).flatMap(value -> Operators.measure(value, context));
        Optional<Measure> high = Operators.optionalOperand(node, "high", context).flatMap(value -> Operators.measure(value, context));
        if (low.isEmpty() && high.isEmpty()) {
            return Operators.missingMeasure();
        }
        boolean lowClosed = closed(node, "lowClosed", "lowClosedExpression", context);
        boolean highClosed = closed(node, "highClosed", "highClosedExpression", context);
        MeasureSemantic semantic = low.map(Measure::semantic).orElseGet(() -> high.get().semantic());
        Optional<Measure> aligned = high;
        if (high.isPresent() && low.isPresent()) {
            aligned = high.get().convertedTo(semantic);
            if (aligned.isEmpty()) {
                throw context.refuse("the interval's ends are not commensurable");
            }
        }
        Optional<Measure> highEnd = aligned;
        Optional<Resolution> resolution = low.flatMap(Measure::resolution).or(() -> highEnd.flatMap(Measure::resolution));
        Optional<BigDecimal> lower = low.flatMap(end -> lowClosed ? end.lower() : end.upper());
        Optional<BigDecimal> upper = highEnd.flatMap(end -> highClosed ? end.upper() : end.lower());
        return Measure.extent(lower, upper, lowClosed, highClosed, semantic, resolution);
    }

    private static boolean closed(TreeNode node, String attribute, String expression, Context context) {
        Optional<Boolean> written = node.flag(attribute);
        if (written.isPresent()) {
            return written.get();
        }
        Optional<Value> evaluated = Operators.optionalOperand(node, expression, context);
        return evaluated.map(value -> Operators.presence(value, context) == Presence.PRESENT).orElse(true);
    }

    /** One component of a date or time: an integer expression, empty when missing or absent. */
    private static Optional<Integer> component(TreeNode node, String position, Context context) {
        Optional<Value> value = Operators.optionalOperand(node, position, context);
        if (value.isEmpty() || value.get().isMissing()) {
            return Optional.empty();
        }
        Optional<Measure> measure = Operators.measure(value.get(), context);
        if (measure.isEmpty() || !measure.get().isPoint()) {
            throw context.refuse("the " + position + " of a date or time must be one number");
        }
        return Optional.of(measure.get().value().intValueExact());
    }

    /** A code: its code, its system read through the library's code system definitions, and its display. */
    static ConceptValue code(TreeNode node, Context context) {
        String code = node.text("code").orElse("");
        Optional<TreeNode> reference = node.held("system");
        String[] system = reference.isPresent() ? codeSystem(reference.get(), context) : new String[] {"", ""};
        return new ConceptValue(code, system[0], system[1], node.text("display").orElse(""), Optional.empty());
    }

    /** The id and version a code system reference names, through the library's code system definitions. */
    static String[] codeSystem(TreeNode reference, Context context) {
        String name = reference.text("name").orElse("");
        Library library = context.evaluator().libraryNamed(context.library(), reference.text("libraryName").orElse(""), context);
        Optional<Library.Definition> definition = library.definition("CodeSystemDef", name);
        if (definition.isEmpty()) {
            throw context.refuse("no code system " + name + " is defined in " + library.id());
        }
        return new String[] {definition.get().root().text("id").orElse(""), definition.get().root().text("version").orElse("")};
    }
}
