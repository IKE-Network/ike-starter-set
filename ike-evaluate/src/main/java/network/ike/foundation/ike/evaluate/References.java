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
import network.ike.foundation.ike.bindings.IkeTerms;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * The references: a definition, a parameter, an alias or a let, and a property access, the last
 * read through a tuple's parts, a statement's element readings, or a measure's ends.
 */
final class References {

    private References() {
    }

    static void register(Operators registry) {
        registry.put("ExpressionRef", (node, context) -> {
            String name = node.text("name").orElseThrow(() -> context.refuse("an expression reference has no name"));
            Library library = context.evaluator().libraryNamed(context.library(), node.text("libraryName").orElse(""), context);
            return context.evaluator().definitionValue(library, name, context);
        });
        registry.put("ParameterRef", (node, context) -> {
            String name = node.text("name").orElseThrow(() -> context.refuse("a parameter reference has no name"));
            Library library = context.evaluator().libraryNamed(context.library(), node.text("libraryName").orElse(""), context);
            return context.evaluator().parameterValue(library, name, context);
        });
        registry.put("AliasRef", References::alias);
        registry.put("QueryLetRef", References::alias);
        registry.put("Property", (node, context) -> {
            String path = node.text("path").orElseThrow(() -> context.refuse("a property access has no path"));
            Optional<String> scope = node.text("scope");
            Value source;
            if (scope.isPresent()) {
                source = context.environment().lookup(scope.get()).orElseThrow(() ->
                        context.refuse("the alias " + scope.get() + " is not in scope"));
            } else {
                source = Operators.operand(node, "source", context);
            }
            return property(source, path, context);
        });
    }

    private static Value alias(TreeNode node, Context context) {
        String name = node.text("name").orElseThrow(() -> context.refuse("an alias reference has no name"));
        return context.environment().lookup(name).orElseThrow(() -> context.refuse("the alias " + name + " is not in scope"));
    }

    /** A path read off a value, one segment at a time. */
    static Value property(Value source, String path, Context context) {
        Value current = source;
        for (String segment : path.split("\\.")) {
            current = segment(current, segment, context);
        }
        return current;
    }

    private static Value segment(Value source, String name, Context context) {
        if (source.isMissing()) {
            return Missing.ANY;
        }
        if (source instanceof TupleValue tuple) {
            Value part = tuple.parts().get(name);
            if (part == null) {
                throw context.refuse("the tuple has no element " + name);
            }
            return part;
        }
        if (source instanceof StatementValue statement) {
            return reading(statement.classNid(), name, context, readingNid -> statementReading(statement.statement(), readingNid, context));
        }
        if (source instanceof SubjectValue subject) {
            return reading(subject.classNid(), name, context, readingNid -> {
                if (readingNid == IkeTerms.SUBJECT_BIRTH_DATE_READING.nid()) {
                    return subject.subject().birthDate().map(Value.class::cast).orElse(Operators.missingMeasure());
                }
                throw context.refuse("the element " + name + " reads the statement, and the value is the subject");
            });
        }
        if (source instanceof Measure measure) {
            return measureProperty(measure, name, context);
        }
        if (source instanceof ConceptValue concept) {
            return switch (name) {
                case "code" -> new Text(concept.code());
                case "system" -> new Text(concept.system());
                case "version" -> new Text(concept.version());
                case "display" -> new Text(concept.display());
                default -> throw context.refuse("a concept has no element " + name);
            };
        }
        if (source instanceof RatioValue ratio) {
            return switch (name) {
                case "numerator" -> ratio.numerator();
                case "denominator" -> ratio.denominator();
                default -> throw context.refuse("a ratio has no element " + name);
            };
        }
        throw context.refuse("the element " + name + " cannot be read off a " + source.kind());
    }

    private interface ReadingValue {
        Value of(int readingNid);
    }

    private static Value reading(int classNid, String element, Context context, ReadingValue value) {
        Bridges bridges = context.evaluator().bridges();
        Optional<Integer> readingNid = bridges.readingOf(classNid, element);
        if (readingNid.isEmpty()) {
            throw context.refuse("the element " + element + " of " + bridges.types().qualifiedName(dev.ikm.tinkar.terms.EntityProxy.Concept.make(classNid)).orElse("the class")
                    + " has no reading");
        }
        return value.of(readingNid.get());
    }

    /** What a statement answers for a reading. */
    static Value statementReading(Statement statement, int readingNid, Context context) {
        if (readingNid == IkeTerms.TOPIC_READING.nid()) {
            return concept(statement.topicNid());
        }
        if (readingNid == IkeTerms.CIRCUMSTANCE_KIND_READING.nid()) {
            return concept(statement.circumstanceKindNid());
        }
        if (readingNid == IkeTerms.DISPOSITION_READING.nid()) {
            return statement.dispositionNid().map(References::concept).map(Value.class::cast).orElse(new Missing(Value.Kind.CONCEPT));
        }
        if (readingNid == IkeTerms.TIMING_READING.nid()) {
            return statement.timing();
        }
        if (readingNid == IkeTerms.TIMING_START_READING.nid()) {
            return Intervals.start(statement.timing());
        }
        if (readingNid == IkeTerms.TIMING_END_READING.nid()) {
            return Intervals.end(statement.timing());
        }
        if (readingNid == IkeTerms.RESULT_READING.nid()) {
            return statement.result().map(Value.class::cast).orElse(Operators.missingMeasure());
        }
        if (readingNid == IkeTerms.STATEMENT_TIME_READING.nid()) {
            return statement.statementTime();
        }
        if (readingNid == IkeTerms.SUBJECT_BIRTH_DATE_READING.nid()) {
            return statement.subject().birthDate().map(Value.class::cast).orElse(Operators.missingMeasure());
        }
        throw context.refuse("the reading " + PrimitiveData.text(readingNid) + " is not one the evaluator answers");
    }

    /** A concept value for a stored concept, named by its text in the store. */
    static ConceptValue concept(int nid) {
        return new ConceptValue("", "", "", PrimitiveData.text(nid), Optional.of(nid));
    }

    private static Value measureProperty(Measure measure, String name, Context context) {
        return switch (name) {
            case "low", "start" -> Intervals.start(measure);
            case "high", "end" -> Intervals.end(measure);
            case "lowClosed" -> Presence.of(measure.lowerIncluded());
            case "highClosed" -> Presence.of(measure.upperIncluded());
            case "value" -> measure.isPoint() ? Measure.point(measure.value(), MeasureSemantic.DIMENSIONLESS)
                    : new Measure(measure.lower(), measure.upper(), measure.lowerIncluded(), measure.upperIncluded(),
                            MeasureSemantic.DIMENSIONLESS, measure.resolution(), measure.extent(), measure.places(), measure.offset());
            case "numerator", "denominator" -> throw context.refuse("a measure is not a ratio");
            default -> throw context.refuse("a measure has no element " + name);
        };
    }

    /** A number as an integer, for components and counts. */
    static int integer(BigDecimal value) {
        return value.intValueExact();
    }
}
