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
package network.ike.foundation.ike.terms;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * What evaluation runs on (IKE-Network/ike-issues#1116): the checked relation from each
 * admitted ELM node kind to the construct it means, the evaluator's dispatch table as
 * knowledge; the constructs the first families lacked, the values a library writes and the
 * structure a query has; the readings a statement answers; the kinds of circumstance; and the
 * two patterns by which a model's class stands for a criterion and a model's element for a
 * reading. A node kind with no relation here is carried in a tree and refused at evaluation.
 */
final class ElmNodeKindSet {

    /** The parent of the three kinds of circumstance a statement has. */
    static final String CIRCUMSTANCE_KIND_FQN = "Circumstance kind (IkeFoundation)";

    /** The parent of what a model element answers when read off a statement. */
    static final String STATEMENT_READING_FQN = "Statement reading (IkeFoundation)";

    /** The criterion a retrievable class stands for, on the class. */
    static final String BRIDGE_PATTERN_FQN = "Model Class Bridge Pattern (IkeFoundation)";

    /** The statement reading a model element answers, on the element record. */
    static final String READING_PATTERN_FQN = "Model Element Reading Pattern (IkeFoundation)";

    /** The readings, in the order they are declared. */
    static final List<String> READINGS = List.of("Topic reading", "Circumstance kind reading", "Disposition reading",
            "Timing reading", "Timing start reading", "Timing end reading", "Result reading", "Statement time reading",
            "Subject birth date reading");

    /** The kinds of circumstance, in the order they are declared. */
    static final List<String> CIRCUMSTANCE_KINDS = List.of("Performance circumstance", "Request circumstance",
            "Narrative circumstance");

    /**
     * One admitted node kind: its family, the ELM node kind's name, the construct it means, the
     * relation's kind, and the reason in plain words.
     *
     * @param family  the family it lands with
     * @param kind    the node kind's name as the catalog writes it after ELM
     * @param target  the construct's fully qualified name
     * @param claim   the relation kind: identity, equivalence, extension, or conservative
     * @param reason  why, as the relation's seed says it
     */
    record Relation(String family, String kind, String target, String claim, String reason) {
    }

    /** The relations of this issue's families, in the order they are declared. */
    static final List<Relation> RELATIONS = List.of(
            // ── Literals and constructors ──
            new Relation("literals", "Literal", "Written value (IkeFoundation)", "identity",
                    "a value written in the text of a library, read by its type's relation"),
            new Relation("literals", "Null", "Missing value (IkeFoundation)", "identity",
                    "a missing value of the type it is written with"),
            new Relation("literals", "Quantity", "Measure kind (IkeFoundation)", "extension",
                    "a measure on the unit its code names, both bounds the written value"),
            new Relation("literals", "Interval", "Measure kind (IkeFoundation)", "extension",
                    "a measure with the written bounds and inclusivities on the point type's frame"),
            new Relation("literals", "Date", "Measure kind (IkeFoundation)", "extension",
                    "a measure on the Gregorian calendar spanning the written day, month, or year"),
            new Relation("literals", "DateTime", "Measure kind (IkeFoundation)", "extension",
                    "a measure on the epoch scale spanning the written precision, in the zone written"),
            new Relation("literals", "Time", "Measure kind (IkeFoundation)", "extension",
                    "a measure on the time of day spanning the written precision"),
            new Relation("literals", "Code", "Concept kind (IkeFoundation)", "equivalence",
                    "the concept the code denotes in its system"),
            new Relation("literals", "Concept", "Concept kind (IkeFoundation)", "equivalence",
                    "the concept its codes share"),
            new Relation("literals", "Ratio", "Measure ratio (IkeFoundation)", "identity",
                    "a numerator measure and a denominator measure kept as written"),
            new Relation("literals", "List", "List kind (IkeFoundation)", "identity",
                    "the written values in the written order"),
            new Relation("literals", "Tuple", "Tuple kind (IkeFoundation)", "identity",
                    "the written parts by their names"),
            // ── References and structure ──
            new Relation("references", "ExpressionRef", "Definition reference (IkeFoundation)", "identity",
                    "the value of the definition it names"),
            new Relation("references", "ParameterRef", "Parameter reference (IkeFoundation)", "identity",
                    "the value supplied for the parameter it names, or the parameter's default"),
            new Relation("references", "AliasRef", "Alias reference (IkeFoundation)", "identity",
                    "the current value of the query source it names"),
            new Relation("references", "QueryLetRef", "Alias reference (IkeFoundation)", "extension",
                    "the value of a let clause, an alias bound to an expression rather than a source"),
            new Relation("references", "Property", "Property access (IkeFoundation)", "identity",
                    "one part of a value by name, a statement's reading through the element or a tuple's part"),
            // ── Logical ──
            new Relation("logical", "And", "Presence AND (IkeFoundation)", "equivalence", "the three-row table"),
            new Relation("logical", "Or", "Presence OR (IkeFoundation)", "equivalence", "the three-row table"),
            new Relation("logical", "Not", "Presence NOT (IkeFoundation)", "equivalence", "the three-row table"),
            new Relation("logical", "Xor", "Presence exclusive OR (IkeFoundation)", "equivalence", "the three-row table"),
            new Relation("logical", "Implies", "Presence implication (IkeFoundation)", "equivalence", "the three-row table"),
            new Relation("logical", "If", "Conditional (IkeFoundation)", "extension",
                    "a conditional with Present fixed as the outcome that takes the branch"),
            new Relation("logical", "Case", "Conditional (IkeFoundation)", "extension",
                    "a conditional of several conditions with Present fixed as the outcome that takes a branch"),
            // ── Nullological ──
            new Relation("nullological", "IsNull", "Equal to (SOLOR)", "extension",
                    "a test against the missing value that comes out Present or Absent, never Indeterminate"),
            new Relation("nullological", "IsTrue", "Equal to (SOLOR)", "extension",
                    "a test against Present that comes out Present or Absent, never Indeterminate"),
            new Relation("nullological", "IsFalse", "Equal to (SOLOR)", "extension",
                    "a test against Absent that comes out Present or Absent, never Indeterminate"),
            new Relation("nullological", "Coalesce", "First present (IkeFoundation)", "identity",
                    "the first value that is not missing"),
            // ── Comparison ──
            new Relation("comparison", "Equal", "Equal to (SOLOR)", "equivalence", "the same value, missing when either side is missing"),
            new Relation("comparison", "Equivalent", "Equal to (SOLOR)", "extension",
                    "equality that holds between two missing values and reads text without regard to case"),
            new Relation("comparison", "NotEqual", "Equal to (SOLOR)", "extension", "the negation of equality"),
            new Relation("comparison", "Greater", "Greater than (SOLOR)", "equivalence", "the same order on measures"),
            new Relation("comparison", "GreaterOrEqual", "Greater than or equal to (SOLOR)", "equivalence", "the same order on measures"),
            new Relation("comparison", "Less", "Less than (SOLOR)", "equivalence", "the same order on measures"),
            new Relation("comparison", "LessOrEqual", "Less than or equal to (SOLOR)", "equivalence", "the same order on measures"),
            new Relation("comparison", "SameAs", "Equal to (SOLOR)", "extension", "equality of instants at a precision"),
            new Relation("comparison", "SameOrBefore", "Less than or equal to (SOLOR)", "extension", "the order of instants at a precision"),
            new Relation("comparison", "SameOrAfter", "Greater than or equal to (SOLOR)", "extension", "the order of instants at a precision"),
            new Relation("comparison", "Before", "Measure before (IkeFoundation)", "equivalence", "the whole of one measure before the whole of the other"),
            new Relation("comparison", "After", "Measure after (IkeFoundation)", "equivalence", "the whole of one measure after the whole of the other"),
            // ── Intervals ──
            new Relation("intervals", "In", "Measure within (IkeFoundation)", "extension",
                    "a point within a measure; over a list, one of the list's values"),
            new Relation("intervals", "IncludedIn", "Measure within (IkeFoundation)", "equivalence", "one measure within another"),
            new Relation("intervals", "Includes", "Measure contains (IkeFoundation)", "equivalence", "one measure containing another"),
            new Relation("intervals", "Contains", "Measure contains (IkeFoundation)", "extension",
                    "a measure containing a point; over a list, the list holding a value"),
            new Relation("intervals", "Overlaps", "Measure overlaps (IkeFoundation)", "equivalence", "two measures sharing a point"),
            new Relation("intervals", "OverlapsBefore", "Measure overlaps (IkeFoundation)", "extension",
                    "overlapping and starting before the other"),
            new Relation("intervals", "OverlapsAfter", "Measure overlaps (IkeFoundation)", "extension",
                    "overlapping and ending after the other"),
            new Relation("intervals", "Start", "Measure lower bound (IkeFoundation)", "equivalence", "the lower bound"),
            new Relation("intervals", "End", "Measure upper bound (IkeFoundation)", "equivalence", "the upper bound"),
            new Relation("intervals", "Width", "Measure width (IkeFoundation)", "equivalence", "the width"),
            new Relation("intervals", "Union", "Set OR (IkeFoundation)", "extension",
                    "of two measures, the one spanning both when they touch; of two lists, the values of both"),
            new Relation("intervals", "Intersect", "Set AND (IkeFoundation)", "extension",
                    "of two measures, the span they share; of two lists, the values in both"),
            new Relation("intervals", "Except", "Set difference (IkeFoundation)", "extension",
                    "of two measures, the span of the first outside the second; of two lists, the values of the first not in the second"),
            // ── Arithmetic ──
            new Relation("arithmetic", "Add", "Measure addition (IkeFoundation)", "equivalence", "the sum on the measure semantic"),
            new Relation("arithmetic", "Subtract", "Measure subtraction (IkeFoundation)", "equivalence", "the difference on the measure semantic"),
            new Relation("arithmetic", "Multiply", "Measure multiplication (IkeFoundation)", "equivalence", "the product"),
            new Relation("arithmetic", "Divide", "Measure division (IkeFoundation)", "equivalence", "the quotient"),
            new Relation("arithmetic", "Negate", "Measure subtraction (IkeFoundation)", "extension", "subtraction from zero"),
            new Relation("arithmetic", "DurationBetween", "Measure subtraction (IkeFoundation)", "extension",
                    "the difference between two instants in whole units of the precision"),
            new Relation("arithmetic", "DifferenceBetween", "Measure subtraction (IkeFoundation)", "extension",
                    "the boundaries of the precision crossed between two instants"),
            new Relation("arithmetic", "CalculateAge", "Measure subtraction (IkeFoundation)", "extension",
                    "the whole units of the precision from a birth date to today"),
            new Relation("arithmetic", "CalculateAgeAt", "Measure subtraction (IkeFoundation)", "extension",
                    "the whole units of the precision from a birth date to a date"),
            // ── Aggregates ──
            new Relation("aggregates", "Sum", "Measure sum (IkeFoundation)", "equivalence", "the sum of the members that count"),
            new Relation("aggregates", "Count", "Measure count (IkeFoundation)", "equivalence", "the number of members that count"),
            new Relation("aggregates", "Min", "Measure least (IkeFoundation)", "equivalence", "the least member"),
            new Relation("aggregates", "Max", "Measure greatest (IkeFoundation)", "equivalence", "the greatest member"),
            new Relation("aggregates", "Avg", "Measure mean (IkeFoundation)", "equivalence", "the mean of the members that count"),
            new Relation("aggregates", "Median", "Measure median (IkeFoundation)", "equivalence", "the median of the members that count"),
            new Relation("aggregates", "AllTrue", "Closed-world all present (IkeFoundation)", "equivalence",
                    "Present when every member is Present and for an empty list"),
            new Relation("aggregates", "AnyTrue", "Closed-world any present (IkeFoundation)", "equivalence",
                    "Present when any member is Present and Absent for an empty list"),
            // ── Queries ──
            new Relation("queries", "Query", "Query (IkeFoundation)", "identity",
                    "a pass over sources keeping what a condition admits and yielding what is returned"),
            new Relation("queries", "AliasedQuerySource", "Query source (IkeFoundation)", "identity",
                    "a source named by an alias"),
            new Relation("queries", "With", "Correlation constraint (IkeFoundation)", "extension",
                    "keeping a value when some value of another source relates to it as the condition says"),
            new Relation("queries", "Without", "Correlation constraint (IkeFoundation)", "extension",
                    "keeping a value when no value of another source relates to it as the condition says"),
            new Relation("queries", "Exists", "Closed-world existence (IkeFoundation)", "equivalence",
                    "Present when the list holds a value and Absent for an empty list"),
            new Relation("queries", "SingletonFrom", "Singleton from list (IkeFoundation)", "identity",
                    "the one value of a list of one"),
            // ── Clinical ──
            new Relation("clinical", "Retrieve", "Statement filter (IkeFoundation)", "extension",
                    "a filter whose criteria the class's bridge gives, the topic from the codes through the code path"),
            new Relation("clinical", "ValueSetRef", "Concept set kind (IkeFoundation)", "extension",
                    "the concept set the value set denotes under a view"),
            new Relation("clinical", "InValueSet", "Concept set membership (IkeFoundation)", "equivalence",
                    "whether the concept is in the set under the view"));

    private ElmNodeKindSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;
        EntityProxy.Concept modelRoot = set.conceptRef("Expression language model (IkeFoundation)");
        EntityProxy.Concept operandKind = set.conceptRef("Operand kind (IkeFoundation)");
        EntityProxy.Concept arity = set.conceptRef("Arity (IkeFoundation)");
        EntityProxy.Pattern denotations = set.patternRef(ExpressionLanguageSet.DENOTATION_PATTERN_FQN);
        EntityProxy.Pattern relations = set.patternRef(ExpressionLanguageSet.RELATION_PATTERN_FQN);

        // ── One more arity: an operator that takes nothing ──
        set.concept("Nullary (IkeFoundation)").at(inception)
                .synonym("Nullary")
                .definition("An operator that takes no operand: a literal, a reference, a retrieve.")
                .isA(arity);
        EntityProxy.Concept nullary = set.conceptRef("Nullary (IkeFoundation)");
        EntityProxy.Concept unary = set.conceptRef("Unary (IkeFoundation)");
        EntityProxy.Concept variadic = set.conceptRef("Variadic (IkeFoundation)");

        // ── Two more operand kinds: a list and a tuple ──
        set.concept("List kind (IkeFoundation)").at(inception)
                .synonym("List kind")
                .definition("An operand kind: an ordered collection of values of one kind, kept in the order given"
                        + " and allowing a value to repeat; what a query yields before it is reduced. It is"
                        + " not a set, which has no order and no repeats.")
                .isA(operandKind);
        set.concept("Tuple kind (IkeFoundation)").at(inception)
                .synonym("Tuple kind")
                .definition("An operand kind: a value of named parts, each a value of a kind of its own, read"
                        + " part by part by name.")
                .isA(operandKind);
        EntityProxy.Concept listKind = set.conceptRef("List kind (IkeFoundation)");
        EntityProxy.Concept tupleKind = set.conceptRef("Tuple kind (IkeFoundation)");

        // ── The constructs the first families lacked ──
        String[][] constructs = {
            {"Written value", "A value written in the text of a library, a number, a text, a date, a truth"
                    + " value, held under its type and read as its type's relation says: a number as a measure"
                    + " on the dimensionless number, a truth value as a presence, a date as a measure on the"
                    + " calendar.", "Nullary", "Operand kind", "Operand kind"},
            {"Missing value", "A value of a kind with no content: an Indeterminate presence, a measure with"
                    + " its measure semantic and no bounds, a reference to no concept, a list that is missing"
                    + " rather than empty. CQL's null, of whatever type it is written with.",
                    "Nullary", "Operand kind", "Operand kind"},
            {"Definition reference", "The use of a definition's value by its name; evaluating it is evaluating"
                    + " the definition, once, for the subject at hand.", "Nullary", "Operand kind", "Operand kind"},
            {"Parameter reference", "The use of a value supplied to a library when it is evaluated, or the"
                    + " parameter's default when none is supplied.", "Nullary", "Operand kind", "Operand kind"},
            {"Alias reference", "The value a query source's alias stands for at the moment it is read: one"
                    + " value of the source per pass.", "Nullary", "Operand kind", "Operand kind"},
            {"Property access", "Reading one part of a value by name: on a statement, the reading the named"
                    + " element stands for; on a tuple, the part of that name.", "Unary", "Operand kind", "Operand kind"},
            {"Query", "A pass over the values of one or more sources, alias by alias, keeping those a condition"
                    + " admits, correlating them with other sources where asked, and yielding what a return"
                    + " clause names, in order where sorted.", "Variadic", "List kind", "List kind"},
            {"Query source", "One source of a query, a list or a single value, named by the alias the query"
                    + " reads it through.", "Unary", "List kind", "List kind"},
            {"Singleton from list", "The one value of a list that holds one; a missing value for an empty list;"
                    + " a refusal for a list of more than one.", "Unary", "List kind", "Operand kind"},
            {"First present", "The first of its operands that is not a missing value, or a missing value when"
                    + " every operand is.", "Variadic", "Operand kind", "Operand kind"},
        };
        for (String[] construct : constructs) {
            set.concept(construct[0] + " (IkeFoundation)").at(inception)
                    .synonym(construct[0])
                    .definition(construct[1])
                    .isA(modelRoot)
                    .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: " + construct[0])),
                            set.conceptRef(construct[3] + " (IkeFoundation)"),
                            set.conceptRef(construct[4] + " (IkeFoundation)"),
                            set.conceptRef(construct[2] + " (IkeFoundation)"));
        }

        // ── The kinds of circumstance ──
        set.concept(CIRCUMSTANCE_KIND_FQN).at(inception)
                .synonym("Circumstance kind")
                .definition("What kind of circumstance a statement holds beside its topic, one of three, as the"
                        + " ANF structural definition gives them: a performance, a request, or a narrative.")
                .isA(modelRoot);
        EntityProxy.Concept circumstanceKind = set.conceptRef(CIRCUMSTANCE_KIND_FQN);
        String[][] circumstances = {
            {"Performance circumstance", "A circumstance kind: what was determined about the topic, a result as a"
                    + " measure, with what became of the act, when, and by what method."},
            {"Request circumstance", "A circumstance kind: what is sought about the topic, a requested result,"
                    + " with what became of the order, when it is wanted, and how often."},
            {"Narrative circumstance", "A circumstance kind: text about the topic that resists being structured,"
                    + " kept as written."},
        };
        for (String[] circumstance : circumstances) {
            set.concept(circumstance[0] + " (IkeFoundation)").at(inception)
                    .synonym(circumstance[0])
                    .definition(circumstance[1])
                    .isA(circumstanceKind);
        }

        // ── What a model element answers when read off a statement ──
        set.concept(STATEMENT_READING_FQN).at(inception)
                .synonym("Statement reading")
                .definition("What a model's element answers when a library reads it off a statement: one of a"
                        + " closed set, the statement's topic, its circumstance kind, its disposition, its timing"
                        + " whole or by an end, its result, its statement time, or a fact of the subject.")
                .isA(modelRoot);
        EntityProxy.Concept statementReading = set.conceptRef(STATEMENT_READING_FQN);
        String[][] readings = {
            {"Topic reading", "A statement reading: the statement's topic, a concept."},
            {"Circumstance kind reading", "A statement reading: which kind of circumstance the statement holds."},
            {"Disposition reading", "A statement reading: what became of the act or the order, a concept."},
            {"Timing reading", "A statement reading: when the circumstance held, a measure on the calendar."},
            {"Timing start reading", "A statement reading: the lower bound of the timing, an instant."},
            {"Timing end reading", "A statement reading: the upper bound of the timing, an instant."},
            {"Result reading", "A statement reading: the result of a performance, a measure."},
            {"Statement time reading", "A statement reading: when the statement was made, an instant."},
            {"Subject birth date reading", "A statement reading of the subject rather than the statement: the"
                    + " subject's birth date, a measure on the calendar."},
        };
        for (String[] reading : readings) {
            set.concept(reading[0] + " (IkeFoundation)").at(inception)
                    .synonym(reading[0])
                    .definition(reading[1])
                    .isA(statementReading);
        }

        // ── The bridge and the reading, on a model's class and element ──
        EntityProxy.Concept dataModel = set.conceptRef(ModelInformationSet.ROOT_FQN);
        set.concept("Model bridge (IkeFoundation)").at(inception)
                .synonym("Model bridge")
                .definition("Why a field is recorded: it says what a model's class or element stands for in IKE's"
                        + " own terms, authored by IKE and checked at admission, so that a library written against"
                        + " the model evaluates over statements.")
                .isA(dataModel);
        EntityProxy.Concept bridge = set.conceptRef("Model bridge (IkeFoundation)");
        String[][] fields = {
            {"Bridge circumstance kind", "The kind of circumstance a statement must hold to answer a retrieve of the class."},
            {"Bridge disposition", "The disposition a statement must carry to answer a retrieve of the class, or the"
                    + " unresolved marker when the class fixes none."},
            {"Bridge relation kind", "What the bridge claims: a definitional extension where the class is definable"
                    + " from what a statement says, a conservative extension where the class carries more."},
            {"Element reading", "The statement reading a model's element answers."},
        };
        for (String[] field : fields) {
            set.concept(field[0] + " (IkeFoundation)").at(inception)
                    .synonym(field[0])
                    .definition(field[1])
                    .isA(dataModel);
        }
        set.pattern(BRIDGE_PATTERN_FQN).at(inception)
                .meaning(dataModel)
                .purpose(bridge)
                .field(set.conceptRef("Bridge circumstance kind (IkeFoundation)"), bridge, IkeTerm.CONCEPT_FIELD)
                .field(set.conceptRef("Bridge disposition (IkeFoundation)"), bridge, IkeTerm.CONCEPT_FIELD)
                .field(set.conceptRef("Bridge relation kind (IkeFoundation)"), bridge, IkeTerm.CONCEPT_FIELD)
                .definition("The criterion a retrievable class stands for, on the class: the circumstance kind a"
                        + " statement must hold, the disposition it must carry when the class fixes one, and the"
                        + " relation kind the bridge claims. The topic constraint takes the retrieve's codes through"
                        + " the class's code path, which the class record resolves.");
        set.pattern(READING_PATTERN_FQN).at(inception)
                .meaning(dataModel)
                .purpose(bridge)
                .field(set.conceptRef("Element reading (IkeFoundation)"), bridge, IkeTerm.CONCEPT_FIELD)
                .definition("The statement reading a model's element answers, on the element record, so that a"
                        + " property access on a statement reads the timing, the result, the topic, or the"
                        + " subject's fact the element stands for.");

        // ── The relations: each admitted node kind to the construct it means ──
        Map<String, EntityProxy.Concept> claims = new LinkedHashMap<>();
        claims.put("identity", set.conceptRef("Identity (IkeFoundation)"));
        claims.put("equivalence", set.conceptRef("Logical equivalence (IkeFoundation)"));
        claims.put("extension", set.conceptRef("Definitional extension (IkeFoundation)"));
        claims.put("conservative", set.conceptRef("Conservative extension (IkeFoundation)"));
        for (Relation relation : RELATIONS) {
            set.concept("ELM " + relation.kind() + " (ELM)").at(inception)
                    .semantic(relations, PublicIds.of(set.uuidFor(
                                    "Construct relation: ELM " + relation.kind() + " is " + relation.reason())),
                            set.conceptRef(relation.target()), claims.get(relation.claim()));
        }
    }
}
