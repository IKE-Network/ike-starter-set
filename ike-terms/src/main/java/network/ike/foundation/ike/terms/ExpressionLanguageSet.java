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
import dev.ikm.tinkar.entity.builder.ConceptBuilder;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * The query-operator apparatus (IKE-Network/ike-issues#1089): the operators a query
 * language over ANF needs, each saying what it takes and what it yields, and each related
 * explicitly to the three logics the set integrates: Clinical Quality Language, the SNOMED
 * CT Expression Constraint Language, and EL++. The answer is never a matter of matching
 * names. A logic's keyword <i>names</i> a construct of the set (a keyword binding, admitted
 * only when what the construct takes and yields supports it), and a construct either is the
 * same construct as a core one, or stands in one of three <b>checked relations</b> to it
 * (logical equivalence, definitional extension, conservative extension), or carries a
 * denotation and no relation at all. "Distinct" is the absence of a relation semantic,
 * never a placeholder value.
 * <p>
 * <b>One AND, four places it is used.</b> AND means every operand is required, not just
 * some of them, so the result is only what is all of the operands at once, and adding an
 * operand can only narrow the result, never widen it. In the EL++ layer the operands are classes; in the topic layer, sets of
 * concepts; in the statement layer, sets of statements; in the presence layer, presence
 * values, where the whole is Present only if every part is Present, Absent if any part is
 * Absent, and Indeterminate otherwise. The set says exactly that: a {@code Generic AND}
 * with no keyword in any logic, and four instances beneath it by is-a, {@code EL++ AND}
 * (the inherited And concept, keeping its identity), {@code Concept set AND},
 * {@code Statement set AND}, and {@code Presence AND}. Every keyword binds to an instance,
 * never to the parent, because two things are the same construct only when they work on
 * the same kind of thing. OR is the same shape, with the inherited Or concept as the
 * {@code Generic OR} itself, since EL++ has no OR and there is no class instance. NOT gets
 * no generic: EL++ has none, the two set layers share a {@code Generic set difference}, and
 * {@code Presence NOT} swaps a presence value, which is a different thing.
 * <p>
 * <b>Naming discipline.</b> A fully qualified name is the layer qualifier plus the
 * shared word: Generic, EL++, Concept set, Statement set, Presence, Subject set. The US
 * English preferred name is the qualified name. Each logic is a dialect of English (CQL
 * dialect, ECL dialect, EL++ dialect), and in its own dialect the construct a logic names
 * reads as the bare keyword, spelled as that logic spells it, while everything the logic
 * does not name falls back to the qualified name. No view ever shows four things called
 * AND. One ledger declaration produces both the keyword binding and the dialect-scoped
 * name, so there is one source.
 * <p>
 * <b>The kinds come from ANF's structural definition, and there is no truth-value
 * kind.</b> A value is a measure: two bounds plus a measure semantic. A presence value is
 * a measure on the Presence semantic, and it is one of three. Present: the determination
 * found the topic present. Absent: it found the topic absent. Indeterminate: it could not
 * tell, the presence form of an indeterminate result, a determination that could not
 * arrive at a value within its frame of reference. Every criterion a query puts to a statement yields a presence value.
 * Testing stored bounds exactly is always decisive; a comparison, a containment, a timing
 * relation, or an existence over a measure with width is Indeterminate when the threshold or date it
 * compares against is inside the recorded range. Criteria combine by Presence AND, OR, and NOT. A query's answer sorts
 * its candidates into three groups, present, absent, and indeterminate; keeping one group
 * is a choice the author names, never a default, and the set operations act on groups
 * already sorted. A statement carries one result measure and its cross-cutting
 * measurements (timing, statement time, normal range), which measure other dimensions of
 * the statement and are the dimensions a criterion names. The store speaks only for
 * itself: absence of a statement means no record here, never "never assessed."
 * <p>
 * Seven patterns carry this: the Expression Language Keyword Pattern (binding
 * language, keyword text, lexical role), the Construct Denotation Pattern (operand kind,
 * result kind, arity), the Literal Denotation Pattern (result kind, lower bound, upper
 * bound), the Construct Relation Pattern (core construct, construct relation), and one
 * Dialect Pattern per logic, of the same shape as the US and GB dialect patterns. The
 * check each relation must pass follows from the relation and the result kind and is never
 * stored: finite checks run in {@code ExpressionLanguageIT}; concept-set equality runs
 * over the reasoner conformance kit (IKE-Network/ike-issues#1092).
 * <p>
 * Design topic: {@code dev-expression-language-relations} in ike-lab-documents.
 */
final class ExpressionLanguageSet {

    /** Birth FQN of the keyword-binding pattern. */
    static final String KEYWORD_PATTERN_FQN = "Expression Language Keyword Pattern (IkeFoundation)";

    /** Birth FQN of the operator-denotation pattern. */
    static final String DENOTATION_PATTERN_FQN = "Construct Denotation Pattern (IkeFoundation)";

    /** Birth FQN of the literal-denotation pattern. */
    static final String LITERAL_PATTERN_FQN = "Literal Denotation Pattern (IkeFoundation)";

    /** Birth FQN of the relation pattern. */
    static final String RELATION_PATTERN_FQN = "Construct Relation Pattern (IkeFoundation)";

    /** Birth FQN of the CQL dialect pattern. */
    static final String CQL_DIALECT_PATTERN_FQN = "CQL Dialect Pattern (IkeFoundation)";

    /** Birth FQN of the ECL dialect pattern. */
    static final String ECL_DIALECT_PATTERN_FQN = "ECL Dialect Pattern (IkeFoundation)";

    /** Birth FQN of the EL++ dialect pattern. */
    static final String EL_DIALECT_PATTERN_FQN = "EL++ Dialect Pattern (IkeFoundation)";

    /** Birth FQN of the generic conjunction. */
    static final String GENERIC_AND_FQN = "Generic AND (IkeFoundation)";

    /** Birth FQN of the generic disjunction: the inherited Or concept, renamed in place. */
    static final String GENERIC_OR_FQN = "Generic OR (SOLOR)";

    /** Birth FQN of the generic set difference. */
    static final String GENERIC_SET_DIFFERENCE_FQN = "Generic set difference (IkeFoundation)";

    /** Birth FQN of the EL++ conjunction: the inherited And concept, renamed in place. */
    static final String EL_AND_FQN = "EL++ AND (SOLOR)";

    /** Birth FQN of the home for the two non-operator node kinds of an EL++ expression tree. */
    static final String LOGICAL_EXPRESSION_VERTEX_FQN = "Logical expression vertex (IkeFoundation)";

    private ExpressionLanguageSet() {
    }

    /** One logic: its language concept, its dialect pattern, and the label its ids use. */
    private record Logic(String label, EntityProxy.Concept language, EntityProxy.Pattern dialectPattern) {
    }

    /**
     * Binds a keyword to what a scope declares (a construct, a kind, or a literal) and
     * gives it that logic's dialect-scoped name from the same declaration: the keyword
     * binding semantic, a case-sensitive regular-name description spelled as the logic
     * spells it, and that description's acceptability in the logic's dialect. One
     * source; the gate checks the two agree.
     *
     * @param scope     the owning component's active scope
     * @param set       the knowledge set
     * @param keywords  the keyword pattern
     * @param logic     the binding logic
     * @param keyword   the keyword text, verbatim
     * @param role      the lexical role
     * @param preferred whether this spelling is the logic's preferred name for the owner
     * @param owner     the owner's plain name, for descriptive semantic identities
     * @return the scope, for chaining
     */
    private static ConceptBuilder.ActiveScope keyword(ConceptBuilder.ActiveScope scope, KnowledgeSet set,
            EntityProxy.Pattern keywords, Logic logic, String keyword, EntityProxy.Concept role,
            boolean preferred, String owner) {
        String descriptionId = "Description: " + logic.label() + " '" + keyword + "' on " + owner;
        return scope
                .semantic(keywords,
                        PublicIds.of(set.uuidFor(
                                "Keyword binding: " + logic.label() + " '" + keyword + "' names " + owner)),
                        logic.language(), keyword, role)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(set.uuidFor(descriptionId)),
                        IkeTerm.ENGLISH_LANGUAGE, keyword, set.conceptRef("Description case sensitive"),
                        IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semanticOn(PublicIds.of(set.uuidFor(descriptionId)), logic.dialectPattern(),
                        PublicIds.of(set.uuidFor(
                                "Dialect: " + logic.label() + " '" + keyword + "' on " + owner)),
                        preferred ? IkeTerm.PREFERRED : IkeTerm.ACCEPTABLE);
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // The one declared inception stamp of the pre-release set
        // (IKE-Network/ike-issues#894).
        ActiveStamp inception = Ike.INCEPTION;

        EntityProxy.Pattern proseElementPattern =
                set.patternRef(ProseElementSet.PROSE_ELEMENT_PATTERN_FQN);

        // ── Family root ─────────────────────────────────────────────────
        set.concept("Expression language model (IkeFoundation)").at(inception)
                .synonym("Expression language model")
                .definition("The concepts and patterns that represent the operators a query"
                        + " language over ANF needs, and relate each one explicitly to the logics"
                        + " it overlaps: the logics and their dialects; the keyword bindings that"
                        + " admit a construct to a logic; the denotations that say what a construct"
                        + " takes and what it yields; and the checked relations between a construct"
                        + " and a core construct, which are logical equivalence, definitional"
                        + " extension, and conservative extension.")
                .isA(IkeTerm.MODEL_CONCEPT)
                .semantic(proseElementPattern,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ExpressionLanguageModel (Expression Languages — One AND, Four"
                                        + " Places)")), """
                        k:ExpressionLanguageModel[] represents the operators a query over ANF needs and
                        answers the question every overlapping logic raises. CQL, ECL, and EL++ all spell
                        an AND, a comparison, and a descendant-of. Are those the set's operators or not?
                        The answer is never a matter of matching names. A keyword names a construct of the
                        set, and the binding is admitted only when what the construct takes and yields
                        supports it. A construct is the same construct as a core one, or stands in one of
                        three checked relations to it, k:LogicalEquivalence[], k:DefinitionalExtension[], or
                        k:ConservativeExtension[], or it carries a denotation and no relation at all. Each
                        relation is a claim of the kind a proof can settle. The set records the claim as
                        data and the build runs the check.

                        There is one idea of AND and four places it is used. AND means every operand is
                        required, not just some of them, so the result is only what is all of the
                        operands at once, and adding an operand can only narrow the result, never
                        widen it. k:GenericAND[] holds the idea and no keyword. k:ELAND[],
                        k:ConceptSetAND[], k:StatementSetAND[], and k:PresenceAND[] are its instances, one
                        for each kind of thing an operator works on, and every keyword binds to an
                        instance. Two things are the same construct only when they work on the same kind
                        of thing. NOT gets no generic, because EL++ has none, the set layers share
                        k:GenericSetDifference[], and k:PresenceNOT[] swaps a presence value. That is the check
                        that the shape is right.""");
        EntityProxy.Concept modelRoot = set.conceptRef("Expression language model (IkeFoundation)");

        // ── Logics and their dialects ───────────────────────────────────
        set.concept("Expression language (IkeFoundation)").at(inception)
                .synonym("Expression language")
                .definition("A logic whose expressions are evaluated over this set's content or"
                        + " over ANF statements. A member of this family is the value of a keyword"
                        + " binding's Binding language field, and the logic's allowed constructs"
                        + " are exactly the constructs its keyword bindings name. Each has a"
                        + " dialect of English through which its own spellings display.")
                .isA(modelRoot);
        EntityProxy.Concept expressionLanguage = set.conceptRef("Expression language (IkeFoundation)");

        set.concept("Clinical Quality Language (IkeFoundation)").at(inception)
                .synonym("Clinical Quality Language")
                .synonym("CQL")
                .definition("An expression language: the language for clinical quality measure and"
                        + " decision-support logic. Every CQL value is represented as an ANF"
                        + " measure with nothing left over: a Boolean as a presence measure, a"
                        + " Quantity or an Interval as a measure with bounds and inclusivity, a"
                        + " date as a measure on a date-time semantic. Once null is read as"
                        + " Indeterminate, CQL's three-valued and, or, and not are the presence"
                        + " connectives, and CQL's own tables follow from them row for row.")
                .isA(expressionLanguage);

        set.concept("SNOMED CT Expression Constraint Language (IkeFoundation)").at(inception)
                .synonym("SNOMED CT Expression Constraint Language")
                .synonym("ECL")
                .definition("An expression language: the language for selecting sets of concepts"
                        + " from a classified terminology by is-a, refinement, and set operations."
                        + " Every ECL construct is definable from the EL++ core and computes a"
                        + " concept set under a view: new names, no new logic. In a query over ANF"
                        + " it is the topic layer.")
                .isA(expressionLanguage);

        set.concept("EL++ (IkeFoundation)").at(inception)
                .synonym("EL++")
                .definition("An expression language: the description-logic profile this set's"
                        + " stated and inferred axioms are written in, with class intersection,"
                        + " existential restriction, necessary and sufficient sets, and"
                        + " disjointness. It has no surface syntax of its own. The one keyword"
                        + " bound to it, AND, is the set's own rendering of its conjunction,"
                        + " carried by its dialect.")
                .isA(expressionLanguage);

        set.concept("CQL dialect (IkeFoundation)").at(inception)
                .synonym("CQL dialect")
                .definition("The dialect of English in which a construct CQL names reads as CQL's"
                        + " keyword, spelled as CQL spells it. Everything CQL does not name falls"
                        + " back to the next dialect in the language coordinate's preference list.")
                .isA(set.conceptRef("English Dialect"));
        set.concept("ECL dialect (IkeFoundation)").at(inception)
                .synonym("ECL dialect")
                .definition("The dialect of English in which a construct ECL names reads as ECL's"
                        + " token, spelled as ECL spells it.")
                .isA(set.conceptRef("English Dialect"));
        set.concept("EL++ dialect (IkeFoundation)").at(inception)
                .synonym("EL++ dialect")
                .definition("The dialect of English in which the EL++ conjunction reads as AND."
                        + " That is the set's own rendering, since EL++ has no surface syntax.")
                .isA(set.conceptRef("English Dialect"));

        set.pattern(CQL_DIALECT_PATTERN_FQN).at(inception)
                .meaning(IkeTerm.DESCRIPTION_ACCEPTABILITY)
                .purpose(IkeTerm.DESCRIPTION_SEMANTIC)
                .field(set.conceptRef("CQL dialect (IkeFoundation)"), IkeTerm.DESCRIPTION_ACCEPTABILITY,
                        IkeTerm.COMPONENT_FIELD)
                .definition("Records whether a description is preferred or acceptable in the CQL"
                        + " dialect. One field: that description's acceptability for this dialect.");
        set.pattern(ECL_DIALECT_PATTERN_FQN).at(inception)
                .meaning(IkeTerm.DESCRIPTION_ACCEPTABILITY)
                .purpose(IkeTerm.DESCRIPTION_SEMANTIC)
                .field(set.conceptRef("ECL dialect (IkeFoundation)"), IkeTerm.DESCRIPTION_ACCEPTABILITY,
                        IkeTerm.COMPONENT_FIELD)
                .definition("Records whether a description is preferred or acceptable in the ECL"
                        + " dialect. One field: that description's acceptability for this dialect.");
        set.pattern(EL_DIALECT_PATTERN_FQN).at(inception)
                .meaning(IkeTerm.DESCRIPTION_ACCEPTABILITY)
                .purpose(IkeTerm.DESCRIPTION_SEMANTIC)
                .field(set.conceptRef("EL++ dialect (IkeFoundation)"), IkeTerm.DESCRIPTION_ACCEPTABILITY,
                        IkeTerm.COMPONENT_FIELD)
                .definition("Records whether a description is preferred or acceptable in the EL++"
                        + " dialect. One field: that description's acceptability for this dialect.");

        Logic cql = new Logic("CQL", set.conceptRef("Clinical Quality Language (IkeFoundation)"),
                set.patternRef(CQL_DIALECT_PATTERN_FQN));
        Logic ecl = new Logic("ECL", set.conceptRef("SNOMED CT Expression Constraint Language (IkeFoundation)"),
                set.patternRef(ECL_DIALECT_PATTERN_FQN));
        Logic el = new Logic("EL++", set.conceptRef("EL++ (IkeFoundation)"),
                set.patternRef(EL_DIALECT_PATTERN_FQN));

        // ── Lexical role (closed) ───────────────────────────────────────
        set.concept("Lexical role (IkeFoundation)").at(inception)
                .synonym("Lexical role")
                .definition("The place a keyword occupies in its logic's grammar, which decides"
                        + " what kind of thing the keyword's binding names. Also the meaning of the"
                        + " Expression Language Keyword Pattern's third field, whose value is one"
                        + " of its members: Operator keyword, Type keyword, Unit keyword, and"
                        + " Literal keyword.")
                .isA(modelRoot);
        EntityProxy.Concept lexicalRole = set.conceptRef("Lexical role (IkeFoundation)");

        set.concept("Operator keyword (IkeFoundation)").at(inception)
                .synonym("Operator keyword")
                .definition("A lexical role: the keyword names an operation applied to operands, so"
                        + " the binding names a construct.")
                .isA(lexicalRole);
        EntityProxy.Concept operatorKeyword = set.conceptRef("Operator keyword (IkeFoundation)");

        set.concept("Type keyword (IkeFoundation)").at(inception)
                .synonym("Type keyword")
                .definition("A lexical role: the keyword names a type of the logic, so the binding"
                        + " names the operand kind that type is represented as.")
                .isA(lexicalRole);
        EntityProxy.Concept typeKeyword = set.conceptRef("Type keyword (IkeFoundation)");

        set.concept("Unit keyword (IkeFoundation)").at(inception)
                .synonym("Unit keyword")
                .definition("A lexical role: the keyword names a unit of measure or of time"
                        + " precision. Singular and plural spellings are two bindings on one unit"
                        + " concept.")
                .isA(lexicalRole);

        set.concept("Literal keyword (IkeFoundation)").at(inception)
                .synonym("Literal keyword")
                .definition("A lexical role: the keyword is itself a fixed value of the logic, so"
                        + " the binding names the literal that carries that value's bounds.")
                .isA(lexicalRole);
        EntityProxy.Concept literalKeyword = set.conceptRef("Literal keyword (IkeFoundation)");

        // ── Construct relation (closed) ─────────────────────────────────
        set.concept("Construct relation (IkeFoundation)").at(inception)
                .synonym("Construct relation")
                .definition("A relation between a construct and a core construct whose truth a"
                        + " check can settle, recorded so that the build runs the check. Also the"
                        + " meaning of the Construct Relation Pattern's second field, whose value"
                        + " is one of its members: Logical equivalence, Definitional extension, and"
                        + " Conservative extension. There is no member for \"unrelated\". A"
                        + " construct with no relation semantic is simply distinct, and recording"
                        + " that as a value would put a placeholder in a field. An instance's is-a"
                        + " to its generic parent is a different claim, the same idea at another"
                        + " kind, and is not a construct relation.")
                .isA(modelRoot);
        EntityProxy.Concept constructRelation = set.conceptRef("Construct relation (IkeFoundation)");

        set.concept("Logical equivalence (IkeFoundation)").at(inception)
                .synonym("Logical equivalence")
                .definition("A construct relation in which the two constructs give the same result"
                        + " on every input and agree on operand kind, result kind, and arity. The"
                        + " check is equality of results over every input: every combination where"
                        + " the inputs are finite, and equality over the conformance corpus for"
                        + " concept sets.")
                .isA(constructRelation);
        EntityProxy.Concept logicalEquivalence = set.conceptRef("Logical equivalence (IkeFoundation)");

        set.concept("Definitional extension (IkeFoundation)").at(inception)
                .synonym("Definitional extension")
                .definition("A construct relation in which the construct can be defined using only"
                        + " what the core construct already says: new names, no new logic. The"
                        + " kinds need not agree, so a construct that computes concept sets may"
                        + " extend a core construct that builds classes. The check is that the"
                        + " construct's own evaluation equals its definition over a corpus.")
                .isA(constructRelation);
        EntityProxy.Concept definitionalExtension = set.conceptRef("Definitional extension (IkeFoundation)");

        set.concept("Conservative extension (IkeFoundation)").at(inception)
                .synonym("Conservative extension")
                .definition("A construct relation in which the construct agrees with the core"
                        + " construct on everything the core covers, and covers more. Operand kind,"
                        + " result kind, and arity agree, and the added coverage is the extension."
                        + " The check is agreement on every input the core covers. No current"
                        + " construct claims it. The three-valued connectives that would have"
                        + " claimed it turned out to be ordinary measure arithmetic instead.")
                .isA(constructRelation);

        // ── Operand kind (closed): what an operator works on, from ANF ──
        set.concept("Operand kind (IkeFoundation)").at(inception)
                .synonym("Operand kind")
                .definition("The kind of thing an operator works on or yields, taken from ANF's"
                        + " structural definition. Also the meaning of the Construct Denotation"
                        + " Pattern's first field. A generic operator is typed at this root,"
                        + " meaning any kind. Kinds are what make a relation claim well-formed, and"
                        + " what tell apart two constructs that one keyword names. There is no"
                        + " truth-value kind: what a determination, a criterion, or a derived"
                        + " criterion yields is a presence measure. Its members are Class kind,"
                        + " Axiom kind, Concept kind, Concept set kind, Measure kind with Presence"
                        + " measure kind beneath it, Statement set kind, and Subject set kind.")
                .isA(modelRoot);
        EntityProxy.Concept operandKind = set.conceptRef("Operand kind (IkeFoundation)");

        set.concept("Class kind (IkeFoundation)").at(inception)
                .synonym("Class kind")
                .definition("An operand kind: the set of things a concept stands for in a model,"
                        + " which is what the EL++ class constructors take and yield. The EL++"
                        + " layer.")
                .isA(operandKind);
        EntityProxy.Concept classKind = set.conceptRef("Class kind (IkeFoundation)");

        set.concept("Axiom kind (IkeFoundation)").at(inception)
                .synonym("Axiom kind")
                .definition("An operand kind: a terminological axiom, which is what an EL++ axiom"
                        + " former yields: a necessary set, a sufficient set, a disjointness, or an"
                        + " is-a.")
                .isA(operandKind);
        EntityProxy.Concept axiomKind = set.conceptRef("Axiom kind (IkeFoundation)");

        set.concept("Concept kind (IkeFoundation)").at(inception)
                .synonym("Concept kind")
                .definition("An operand kind: one concept of the knowledge layer, the topic of a"
                        + " statement, the anchor of a Descendant of or Ancestor of, and the value"
                        + " a CQL Code or Concept is represented as.")
                .isA(operandKind);
        EntityProxy.Concept conceptKind = set.conceptRef("Concept kind (IkeFoundation)");

        set.concept("Concept set kind (IkeFoundation)").at(inception)
                .synonym("Concept set kind")
                .definition("An operand kind: a finite set of concepts computed under a view, which"
                        + " is what the ECL operators and the taxonomy field constraint kinds"
                        + " yield, and what a topic constraint selects statements by. The topic"
                        + " layer.")
                .isA(operandKind);
        EntityProxy.Concept conceptSetKind = set.conceptRef("Concept set kind (IkeFoundation)");

        set.concept("Measure kind (IkeFoundation)").at(inception)
                .synonym("Measure kind")
                .definition("An operand kind: an ANF measure, a lower and an upper bound, the"
                        + " inclusivity of each, a resolution, and the measure semantic that is its"
                        + " frame of reference. Every value in a query over ANF is one: a result, a"
                        + " timing, a normal range, a CQL Quantity, Interval, Decimal, or DateTime."
                        + " Two measures can be compared only when they share a semantic, and every"
                        + " operator on measures requires it.")
                .isA(operandKind);
        EntityProxy.Concept measureKind = set.conceptRef("Measure kind (IkeFoundation)");

        set.concept("Presence measure kind (IkeFoundation)").at(inception)
                .synonym("Presence measure kind")
                .definition("A measure kind: a measure on the Presence semantic, whose value is one"
                        + " of three. Present: the determination found the topic present. Absent:"
                        + " it found the topic absent. Indeterminate: it could not tell. It"
                        + " is what a determination records, what a comparison, a criterion, or a"
                        + " derived criterion yields, and what a CQL Boolean is represented as:"
                        + " true is Present, false is Absent, and null is Indeterminate when it"
                        + " stands for a determination that did not resolve. Like every measure it"
                        + " has two bounds, and Indeterminate is the value whose bounds cover the"
                        + " whole presence frame, both points at once, so it is a value with width"
                        + " and not a third truth value. The presence layer.")
                .isA(measureKind);
        EntityProxy.Concept presenceMeasureKind = set.conceptRef("Presence measure kind (IkeFoundation)");

        set.concept("Statement set kind (IkeFoundation)").at(inception)
                .synonym("Statement set kind")
                .definition("An operand kind: a set of ANF statements, which is what a retrieve"
                        + " yields and what a filter narrows. Each statement carries its topic, its"
                        + " circumstance, one result measure with its cross-cutting measurements,"
                        + " and its subject. Every stored value has definite bounds, and a"
                        + " criterion over them yields a presence value that may be Present,"
                        + " Absent, or Indeterminate. The statement layer.")
                .isA(operandKind);
        EntityProxy.Concept statementSetKind = set.conceptRef("Statement set kind (IkeFoundation)");

        set.concept("Subject set kind (IkeFoundation)").at(inception)
                .synonym("Subject set kind")
                .definition("An operand kind: a set of subjects of record, which is what a query"
                        + " over ANF ultimately answers with, the subjects for which a statement"
                        + " set is not empty.")
                .isA(operandKind);
        EntityProxy.Concept subjectSetKind = set.conceptRef("Subject set kind (IkeFoundation)");

        // ── Arity (closed) ──────────────────────────────────────────────
        set.concept("Arity (IkeFoundation)").at(inception)
                .synonym("Arity")
                .definition("How many operands an operator takes. A concept rather than a number,"
                        + " so that \"any number\" is a value and not a placeholder. A literal"
                        + " takes no operands and has no arity; it carries a literal denotation"
                        + " instead. Its members are Unary, Binary, and Variadic.")
                .isA(modelRoot);
        EntityProxy.Concept arity = set.conceptRef("Arity (IkeFoundation)");

        set.concept("Unary (IkeFoundation)").at(inception)
                .synonym("Unary")
                .definition("An arity: one operand. An operator with a fixed parameter, such as the"
                        + " attribute of an existential restriction, the concept set of a topic"
                        + " constraint, or the criterion of a filter, is unary in its operand.")
                .isA(arity);
        EntityProxy.Concept unary = set.conceptRef("Unary (IkeFoundation)");

        set.concept("Binary (IkeFoundation)").at(inception)
                .synonym("Binary")
                .definition("An arity: two operands.")
                .isA(arity);
        EntityProxy.Concept binary = set.conceptRef("Binary (IkeFoundation)");

        set.concept("Variadic (IkeFoundation)").at(inception)
                .synonym("Variadic")
                .definition("An arity: any number of operands, as with the EL++ set formers and the"
                        + " concept-set and statement-set ANDs and ORs.")
                .isA(arity);
        EntityProxy.Concept variadic = set.conceptRef("Variadic (IkeFoundation)");

        // ── Field-meaning concepts ──────────────────────────────────────
        set.concept("Binding language (IkeFoundation)").at(inception)
                .synonym("Binding language")
                .definition("The logic a keyword binding admits the named construct, kind, or"
                        + " literal to.")
                .isA(IkeTerm.CONCEPT_FIELD);
        EntityProxy.Concept bindingLanguage = set.conceptRef("Binding language (IkeFoundation)");

        set.concept("Keyword text (IkeFoundation)").at(inception)
                .synonym("Keyword text")
                .definition("The spelling in the binding logic, exactly as written, with the case"
                        + " the logic's grammar uses. Also the text of the dialect-scoped name the"
                        + " same declaration produces.")
                .isA(modelRoot);
        EntityProxy.Concept keywordText = set.conceptRef("Keyword text (IkeFoundation)");

        set.concept("Core construct (IkeFoundation)").at(inception)
                .synonym("Core construct")
                .definition("The construct a relation assertion relates the extending construct to:"
                        + " a construct of the EL++ core.")
                .isA(IkeTerm.CONCEPT_FIELD);
        EntityProxy.Concept coreConstruct = set.conceptRef("Core construct (IkeFoundation)");

        set.concept("Result kind (IkeFoundation)").at(inception)
                .synonym("Result kind")
                .definition("The operand kind of the result a construct or a literal yields.")
                .isA(IkeTerm.CONCEPT_FIELD);
        EntityProxy.Concept resultKind = set.conceptRef("Result kind (IkeFoundation)");

        set.concept("Lower bound value (IkeFoundation)").at(inception)
                .synonym("Lower bound value")
                .definition("The lower bound of a literal's measure, as a whole number on the"
                        + " result kind's scale: 0 or 1 on the Presence semantic.")
                .isA(modelRoot);

        set.concept("Upper bound value (IkeFoundation)").at(inception)
                .synonym("Upper bound value")
                .definition("The upper bound of a literal's measure, as a whole number on the"
                        + " result kind's scale. Equal to the lower bound for Present and Absent,"
                        + " one greater for Indeterminate.")
                .isA(modelRoot);

        // ── Purposes and pattern meanings ───────────────────────────────
        set.concept("Keyword binding (IkeFoundation)").at(inception)
                .synonym("Keyword binding")
                .definition("What an Expression Language Keyword Pattern semantic is: one spelling,"
                        + " in one logic, of one construct, kind, or literal.")
                .isA(modelRoot);
        set.concept("Construct admission (IkeFoundation)").at(inception)
                .synonym("Construct admission")
                .definition("Why a keyword binding exists: to admit what it names to the logic's"
                        + " allowed set. Identity is enforced at admission by checking what the"
                        + " construct takes and yields.")
                .isA(modelRoot);
        set.concept("Language membership (IkeFoundation)").at(inception)
                .synonym("Language membership")
                .definition("Why the Binding language field is recorded: the logic's allowed"
                        + " constructs are exactly the constructs its bindings name.")
                .isA(modelRoot);
        set.concept("Surface spelling (IkeFoundation)").at(inception)
                .synonym("Surface spelling")
                .definition("Why the Keyword text field is recorded: the spelling in the logic, so"
                        + " that spelling variants are two bindings on one construct, and one"
                        + " spelling naming two constructs is visible.")
                .isA(modelRoot);
        set.concept("Grammatical placement (IkeFoundation)").at(inception)
                .synonym("Grammatical placement")
                .definition("Why the Lexical role field is recorded: where in the logic's grammar"
                        + " the keyword stands, and so what kind of thing the binding names.")
                .isA(modelRoot);

        set.concept("Construct denotation (IkeFoundation)").at(inception)
                .synonym("Construct denotation")
                .definition("What a Construct Denotation Pattern semantic is: what one operator"
                        + " takes and what it yields, recorded as operand kind, result kind, and"
                        + " arity.")
                .isA(modelRoot);
        set.concept("Well-typed relation (IkeFoundation)").at(inception)
                .synonym("Well-typed relation")
                .definition("Why a denotation exists: a relation between two constructs is a claim"
                        + " only when both sides say what they take and yield; the kinds decide"
                        + " which relations are even possible; and one keyword naming two"
                        + " constructs is legitimate only when their operand kinds differ.")
                .isA(modelRoot);
        set.concept("Operand typing (IkeFoundation)").at(inception)
                .synonym("Operand typing")
                .definition("Why the Operand kind field is recorded: what the operator takes.")
                .isA(modelRoot);
        set.concept("Result typing (IkeFoundation)").at(inception)
                .synonym("Result typing")
                .definition("Why the Result kind field is recorded: what the operator yields. The"
                        + " result kind also decides which check runs: every combination of the"
                        + " three presence values for presence measures, and corpus equality for"
                        + " concept sets.")
                .isA(modelRoot);
        set.concept("Operand count (IkeFoundation)").at(inception)
                .synonym("Operand count")
                .definition("Why the Arity field is recorded: how many operands the operator takes.")
                .isA(modelRoot);

        set.concept("Literal denotation (IkeFoundation)").at(inception)
                .synonym("Literal denotation")
                .definition("What a Literal Denotation Pattern semantic is: the kind and the bounds"
                        + " of one literal, a fixed value of the query language.")
                .isA(modelRoot);
        set.concept("Fixed value (IkeFoundation)").at(inception)
                .synonym("Fixed value")
                .definition("Why a literal denotation exists: a literal is a value, not an"
                        + " operator, so what is recorded is its bounds rather than what it takes"
                        + " and yields. A logic's literal keyword then names bounds, which is how"
                        + " CQL's true, false, and null become Present, Absent, and Indeterminate"
                        + " as data the gate can check.")
                .isA(modelRoot);
        set.concept("Literal lower bound (IkeFoundation)").at(inception)
                .synonym("Literal lower bound")
                .definition("Why the literal's lower bound is recorded: the low end of the value it"
                        + " stands for.")
                .isA(modelRoot);
        set.concept("Literal upper bound (IkeFoundation)").at(inception)
                .synonym("Literal upper bound")
                .definition("Why the literal's upper bound is recorded: the high end of the value"
                        + " it stands for.")
                .isA(modelRoot);

        set.concept("Construct relation assertion (IkeFoundation)").at(inception)
                .synonym("Construct relation assertion")
                .definition("What a Construct Relation Pattern semantic is: a checked claim that"
                        + " the referenced construct bears the named relation to the core"
                        + " construct.")
                .isA(modelRoot);
        set.concept("Checked relation (IkeFoundation)").at(inception)
                .synonym("Checked relation")
                .definition("Why a relation assertion exists: to record a claim of the kind a proof"
                        + " can settle, whose check the build runs, in place of an editorial"
                        + " correspondence.")
                .isA(modelRoot);
        set.concept("Relation target (IkeFoundation)").at(inception)
                .synonym("Relation target")
                .definition("Why the Core construct field is recorded: which core construct the"
                        + " claim is about.")
                .isA(modelRoot);
        set.concept("Relation kind (IkeFoundation)").at(inception)
                .synonym("Relation kind")
                .definition("Why the Construct relation field is recorded: which of the three"
                        + " checked relations is claimed, and therefore which check runs.")
                .isA(modelRoot);

        // ── The four apparatus patterns ─────────────────────────────────
        set.pattern(KEYWORD_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef("Keyword binding (IkeFoundation)"))
                .purpose(set.conceptRef("Construct admission (IkeFoundation)"))
                .field(bindingLanguage, set.conceptRef("Language membership (IkeFoundation)"),
                        IkeTerm.COMPONENT_FIELD)
                .field(keywordText, set.conceptRef("Surface spelling (IkeFoundation)"), IkeTerm.STRING)
                .field(lexicalRole, set.conceptRef("Grammatical placement (IkeFoundation)"),
                        IkeTerm.COMPONENT_FIELD)
                .semantic(proseElementPattern,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ExpressionLanguageKeywordPattern (Expression Languages — Which"
                                        + " Operators a Logic Allows)")), """
                        k:ExpressionLanguageKeywordPattern[] admits a keyword to a logic: a semantic on the
                        construct, kind, or literal the keyword names, recording the k:BindingLanguage[],
                        the k:KeywordText[] exactly as written, and the keyword's k:LexicalRole[]. "Which
                        operators are allowed in CQL" is a query, not a list: the bindings whose logic is
                        k:ClinicalQualityLanguage[]. Membership is by construction, and a parallel
                        reference set would only drift. The role says what kind of thing is named. An
                        operator keyword names an operator with a k:ConstructDenotationPattern[] semantic,
                        a type keyword names the k:OperandKind[] the type is represented as, and a literal
                        keyword names a literal with a k:LiteralDenotationPattern[] semantic.

                        The same declaration gives the construct its name in that logic's dialect. In the
                        k:CQLDialect[] the presence AND reads as `and`, and the three other ANDs keep
                        their qualified names. Spelling variants are two bindings on one construct. One
                        spelling naming two constructs in one logic is legitimate only when their operand
                        kinds differ, which is how ECL's `<` on a concept and on a concrete value stay
                        apart. A reserved word earns a construct only when it names an operation, a type,
                        or a unit with evaluation semantics; syntax markers stay in the logic's grammar
                        description.""");

        set.pattern(DENOTATION_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef("Construct denotation (IkeFoundation)"))
                .purpose(set.conceptRef("Well-typed relation (IkeFoundation)"))
                .field(operandKind, set.conceptRef("Operand typing (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(resultKind, set.conceptRef("Result typing (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(arity, set.conceptRef("Operand count (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .semantic(proseElementPattern,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ConstructDenotationPattern (Expression Languages — Kinds Make"
                                        + " the Claims Well-Typed)")), """
                        k:ConstructDenotationPattern[] says what an operator takes and what it yields:
                        k:OperandKind[], k:ResultKind[], and k:Arity[]. A relation between two constructs
                        is a claim only when both sides carry one, and the kinds decide which relations
                        are possible before any check runs. The kinds are ANF's: k:ClassKind[] and
                        k:AxiomKind[] for the knowledge layer, k:ConceptKind[] and k:ConceptSetKind[] for
                        topic selection, k:MeasureKind[] and k:PresenceMeasureKind[] for values,
                        determinations, and criteria, k:StatementSetKind[] and k:SubjectSetKind[] for what
                        a query narrows and answers with. There is no truth-value kind, and a generic
                        operator is typed at the root, meaning any kind.

                        That is what settles the question spelling hides. k:ELAND[] is class
                        intersection, class in and class out. k:PresenceAND[] is presence value in and
                        out, the `and` of criteria: Present only if every part is Present, Absent if any
                        part is Absent, and Indeterminate otherwise. k:StatementSetAND[] is statement set
                        in and out, a set operation on groups a filter has already sorted.
                        k:ConceptSetAND[] is a concept-set operator that is definable from class
                        intersection. Four instances, one generic, one word, and the kinds say which is
                        which.""");

        set.pattern(LITERAL_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef("Literal denotation (IkeFoundation)"))
                .purpose(set.conceptRef("Fixed value (IkeFoundation)"))
                .field(resultKind, set.conceptRef("Result typing (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Lower bound value (IkeFoundation)"),
                        set.conceptRef("Literal lower bound (IkeFoundation)"), IkeTerm.INTEGER_FIELD)
                .field(set.conceptRef("Upper bound value (IkeFoundation)"),
                        set.conceptRef("Literal upper bound (IkeFoundation)"), IkeTerm.INTEGER_FIELD)
                .semantic(proseElementPattern,
                        PublicIds.of(set.uuidFor(
                                "Narrative: LiteralDenotationPattern (Expression Languages — The Middle"
                                        + " as a Value)")), """
                        k:LiteralDenotationPattern[] records a literal by its bounds rather than by what
                        it takes and yields: a k:ResultKind[] and a lower and an upper bound on that
                        kind's scale. The three presence literals are the unexcluded middle as data.
                        k:PresentLiteral[] means the determination found the topic present.
                        k:AbsentLiteral[] means it found the topic absent. k:IndeterminateLiteral[]
                        means it could not tell: the presence form of k:IndeterminateResult[], a
                        determination that could not arrive at a value within its frame of reference. Its bounds cover the whole presence frame, both
                        points at once, so it is a value with width, not a third truth value, and a
                        query asks for it by name exactly as it asks for presence or absence.

                        CQL's `true`, `false`, and `null` are literal keywords naming those three
                        literals, and that binding is what makes CQL's three-valued connectives ordinary
                        measure arithmetic. The gate evaluates k:PresenceAND[], k:PresenceOR[], and
                        k:PresenceNOT[] over the three literals and finds CQL's specified tables row for
                        row. No third truth value and no propagation rules; the same outcomes, explained
                        by the two bounds and the distance between them. Null itself does not survive
                        normalization. A determination made and unresolved is Indeterminate. A result not
                        sought, or sought and not obtained, is the status of the act on the circumstance,
                        with no result at all, and the reason is an associated statement of its own. The
                        infinities are bounds. Nothing else is a value at all.""");

        set.pattern(RELATION_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef("Construct relation assertion (IkeFoundation)"))
                .purpose(set.conceptRef("Checked relation (IkeFoundation)"))
                .field(coreConstruct, set.conceptRef("Relation target (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .field(constructRelation, set.conceptRef("Relation kind (IkeFoundation)"), IkeTerm.COMPONENT_FIELD)
                .semantic(proseElementPattern,
                        PublicIds.of(set.uuidFor(
                                "Narrative: ConstructRelationPattern (Expression Languages — Obligations"
                                        + " Are Derived, and They Run)")), """
                        k:ConstructRelationPattern[] records a checked claim on the extending construct:
                        which k:CoreConstruct[] it relates to and which k:ConstructRelation[] holds.
                        k:LogicalEquivalence[] means the two give the same result on every input;
                        k:DescendantFieldConstraint[] and k:DescendantOf[] compute one concept set from
                        two homes. k:DefinitionalExtension[] means the construct can be defined using only
                        what the core already says, new names and no new logic, as every ECL operator is
                        defined from is-a and existential restriction. k:ConservativeExtension[] means
                        agreement on everything the core covers plus more coverage; no current construct
                        claims it. There is no value for "unrelated". A construct with no relation
                        semantic is distinct, and the value layer's operators, arithmetic on measures, are
                        distinct from the EL++ core by design. An instance's is-a to k:GenericAND[] is not
                        a construct relation either. It says the same idea at another kind, which is a
                        different claim.

                        No check is stored. It follows from the relation and the result kind. Where the
                        inputs are finite, every combination is tried, inside this set's own integration
                        test. For concept sets, equality is checked over the reasoner conformance kit. An
                        assertion whose check cannot run fails the gate rather than standing as prose.""");

        EntityProxy.Pattern keywords = set.patternRef(KEYWORD_PATTERN_FQN);
        EntityProxy.Pattern denotations = set.patternRef(DENOTATION_PATTERN_FQN);
        EntityProxy.Pattern literals = set.patternRef(LITERAL_PATTERN_FQN);
        EntityProxy.Pattern relations = set.patternRef(RELATION_PATTERN_FQN);

        // ── The generics: one idea, no keyword ──────────────────────────
        set.concept(GENERIC_AND_FQN).at(inception)
                .synonym("Generic AND")
                .definition("A connective operator that joins two or more operands of one kind into"
                        + " a result of that same kind. The operation combines all of the operands"
                        + " to produce the result, and their order and grouping make no difference."
                        + " AND means every operand is required, not just some of them, so the"
                        + " result is only what is all of the operands at once. Adding another"
                        + " operand can only narrow the result, never widen it. Each descendant"
                        + " applies this to one kind of operand: EL++ AND builds the class of"
                        + " things that belong to every operand class at once, Concept set AND and"
                        + " Statement set AND keep the members found in every operand set, and"
                        + " Presence AND is Present only when both parts are Present.")
                .isA(IkeTerm.CONNECTIVE_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Generic AND")),
                        operandKind, operandKind, variadic);
        EntityProxy.Concept genericAnd = set.conceptRef(GENERIC_AND_FQN);

        // The inherited Or concept is the Generic OR itself: EL++ has no disjunction, so
        // there is no class instance, and the identity code holds for a disjunction
        // vertex stays meaningful as the generic. Renamed in place at foundation.Section41.
        set.concept(GENERIC_OR_FQN).at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Generic OR")),
                        operandKind, operandKind, variadic);
        EntityProxy.Concept genericOr = set.conceptRef(GENERIC_OR_FQN);

        set.concept(GENERIC_SET_DIFFERENCE_FQN).at(inception)
                .synonym("Generic set difference")
                .definition("A connective operator that takes two operands of one kind and produces"
                        + " a result of that same kind. Set difference means take the first operand and"
                        + " leave out whatever is also the second. Here the order of the operands"
                        + " matters. Each descendant applies this to one kind of operand: Concept"
                        + " set difference, Statement set difference, and Subject set difference keep the members"
                        + " of the first set that are not in the second. Not negation: EL++ has no"
                        + " negation, and Presence NOT swaps a presence value, which is a different"
                        + " thing with no generic.")
                .isA(IkeTerm.CONNECTIVE_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Generic set difference")),
                        operandKind, operandKind, binary);
        EntityProxy.Concept genericMinus = set.conceptRef(GENERIC_SET_DIFFERENCE_FQN);

        set.concept(LOGICAL_EXPRESSION_VERTEX_FQN).at(inception)
                .synonym("Logical expression vertex")
                .definition("The kinds of node in an EL++ expression tree that are not operators:"
                        + " the definition root that anchors an expression, and the concept"
                        + " reference that names a class. Their inherited home beside the"
                        + " connectives was a filing accident.")
                .isA(IkeTerm.TINKAR_MODEL_CONCEPT);

        // ── Type keywords: CQL's types normalize to ANF kinds ───────────
        keyword(set.concept("Presence measure kind (IkeFoundation)").at(inception), set, keywords,
                cql, "Boolean", typeKeyword, true, "Presence measure kind");
        ConceptBuilder.ActiveScope measureScope = set.concept("Measure kind (IkeFoundation)").at(inception);
        measureScope = keyword(measureScope, set, keywords, cql, "Quantity", typeKeyword, true, "Measure kind");
        for (String type : new String[] {"Integer", "Decimal", "Interval", "Date", "DateTime", "Time"}) {
            measureScope = keyword(measureScope, set, keywords, cql, type, typeKeyword, false, "Measure kind");
        }
        ConceptBuilder.ActiveScope conceptScope = set.concept("Concept kind (IkeFoundation)").at(inception);
        conceptScope = keyword(conceptScope, set, keywords, cql, "Code", typeKeyword, true, "Concept kind");
        keyword(conceptScope, set, keywords, cql, "Concept", typeKeyword, false, "Concept kind");

        // ── Indeterminate result: the general idea the presence literal instantiates ──
        set.concept("Indeterminate result (IkeFoundation)").at(inception)
                .synonym("Indeterminate result")
                .definition("An indeterminate result means a determination was performed but could"
                        + " not arrive at a value within its frame of reference. The frame of"
                        + " reference is what the measure semantic names: millimoles per liter for"
                        + " a serum sodium, present or absent for a finding on a film, the calendar"
                        + " for a date. The result covers the whole frame: it says the"
                        + " determination was done, and no more. It is a fact about this"
                        + " determination only; a later determination may succeed. It is never a"
                        + " stand-in for missing information. A result that was not sought, or was"
                        + " sought and not obtained, is recorded as the status of the act. The"
                        + " reason is an associated statement. A subject with no statement at all"
                        + " simply has no record here.")
                .isA(modelRoot);
        EntityProxy.Concept indeterminateResult = set.conceptRef("Indeterminate result (IkeFoundation)");

        // ── Presence literals: the middle as a value ────────────────────
        keyword(set.concept("Present literal (IkeFoundation)").at(inception)
                .synonym("Present literal")
                .definition("One of the three presence values: the determination found the topic"
                        + " present. The value CQL's true names.")
                .isA(IkeTerm.LITERAL_VALUE)
                .semantic(literals, PublicIds.of(set.uuidFor("Literal denotation: Present literal")),
                        presenceMeasureKind, 1, 1),
                set, keywords, cql, "true", literalKeyword, true, "Present literal");

        keyword(set.concept("Absent literal (IkeFoundation)").at(inception)
                .synonym("Absent literal")
                .definition("One of the three presence values: the determination found the topic"
                        + " absent. Absent is a finding, not a gap: a subject with no statement on"
                        + " the topic has no record, not an Absent. The value CQL's false names.")
                .isA(IkeTerm.LITERAL_VALUE)
                .semantic(literals, PublicIds.of(set.uuidFor("Literal denotation: Absent literal")),
                        presenceMeasureKind, 0, 0),
                set, keywords, cql, "false", literalKeyword, true, "Absent literal");

        keyword(set.concept("Indeterminate literal (IkeFoundation)").at(inception)
                .synonym("Indeterminate literal")
                .definition("An indeterminate result on the presence frame of reference, and one of"
                        + " the three presence values: the determination could not tell whether the"
                        + " topic was present or absent. It arises in two ways. A"
                        + " determination may report it directly, as with a test read in its"
                        + " equivocal zone. Or it may come from comparing a recorded range with a"
                        + " threshold or a date inside that range: an HbA1c recorded between 8.5"
                        + " and 9.5 against a threshold of 9, or a determination dated to sometime"
                        + " in March against the 15th. Any measure a statement carries can be"
                        + " recorded as a range, so any of them can produce it, and the answer"
                        + " carries the measure that produced it, so the reader can see why. It is"
                        + " the one presence value that NOT leaves unchanged, and it is what CQL's"
                        + " null becomes when null stands for a determination that was performed"
                        + " and did not resolve.")
                .isA(IkeTerm.LITERAL_VALUE, indeterminateResult)
                .semantic(literals, PublicIds.of(set.uuidFor("Literal denotation: Indeterminate literal")),
                        presenceMeasureKind, 0, 1),
                set, keywords, cql, "null", literalKeyword, true, "Indeterminate literal");

        // ── Presence connectives: how criteria combine ──────────────────
        keyword(set.concept("Presence AND (IkeFoundation)").at(inception)
                .synonym("Presence AND")
                .definition("A connective operator that joins two presence values and requires both"
                        + " of them: the whole is Present only if both parts are Present, Absent if"
                        + " either part is Absent, and Indeterminate otherwise. Row for row, this"
                        + " is the table CQL specifies for and over true, false, and null, which is"
                        + " why CQL's and names it. It combines the criteria a query puts to one"
                        + " statement or one subject, before anything is sorted into groups;"
                        + " Statement set AND combines groups a filter has already sorted.")
                .isA(genericAnd)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Presence AND")),
                        presenceMeasureKind, presenceMeasureKind, binary),
                set, keywords, cql, "and", operatorKeyword, true, "Presence AND");

        keyword(set.concept("Presence OR (IkeFoundation)").at(inception)
                .synonym("Presence OR")
                .definition("A connective operator that joins two presence values and requires at"
                        + " least one of them: the whole is Present if either part is Present,"
                        + " Absent only if both parts are Absent, and Indeterminate otherwise. Row"
                        + " for row, this is the table CQL specifies for or. It combines criteria;"
                        + " Statement set OR combines groups a filter has already sorted.")
                .isA(genericOr)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Presence OR")),
                        presenceMeasureKind, presenceMeasureKind, binary),
                set, keywords, cql, "or", operatorKeyword, true, "Presence OR");

        keyword(set.concept("Presence NOT (IkeFoundation)").at(inception)
                .synonym("Presence NOT")
                .definition("A connective operator on one presence value that swaps Present and"
                        + " Absent and leaves Indeterminate unchanged, which is the table CQL"
                        + " specifies for not. Not a determination of absence, which is a stored"
                        + " value. Not a set difference, which is Generic set difference. And with no generic"
                        + " parent of its own, because EL++ has no negation at all.")
                .isA(IkeTerm.CONNECTIVE_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Presence NOT")),
                        presenceMeasureKind, presenceMeasureKind, unary),
                set, keywords, cql, "not", operatorKeyword, true, "Presence NOT");

        // ── Comparisons: the foundation's concrete-domain operators, recast on measures
        // Two measures on one scale in, a presence value out: Present when the bounds
        // decide it, Absent when they exclude it, Indeterminate when they overlap.
        keyword(set.concept("Greater than (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Greater than")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, ">", operatorKeyword, true, "Greater than");
        keyword(set.concept("Greater than or equal to (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Greater than or equal to")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, ">=", operatorKeyword, true, "Greater than or equal to");
        keyword(set.concept("Less than (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Less than")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "<", operatorKeyword, true, "Less than");
        keyword(set.concept("Less than or equal to (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Less than or equal to")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "<=", operatorKeyword, true, "Less than or equal to");
        keyword(keyword(set.concept("Equal to (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Equal to")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "=", operatorKeyword, true, "Equal to"),
                set, keywords, cql, "same as", operatorKeyword, false, "Equal to");

        // ── Measure relations: one family for presence, quantity, and time
        ConceptBuilder.ActiveScope within = set.concept("Measure within (IkeFoundation)").at(inception)
                .synonym("Measure within")
                .definition("An operator on two measures of the same scale that yields a presence"
                        + " value: whether the first measure is inside the second. Present when"
                        + " the whole of the first is inside the second, Absent when the two do"
                        + " not overlap at all, and Indeterminate when they partly overlap. Serves"
                        + " a result against its own normal range, a timing against a period, and"
                        + " CQL's included in, during, and between alike, because a timing is a"
                        + " measure. The result and the normal range are two cross-cutting"
                        + " measurements of one statement, and the relation can be decided only"
                        + " with that statement's own range.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure within")),
                        measureKind, presenceMeasureKind, binary);
        within = keyword(within, set, keywords, cql, "included in", operatorKeyword, true, "Measure within");
        within = keyword(within, set, keywords, cql, "during", operatorKeyword, false, "Measure within");
        keyword(within, set, keywords, cql, "between", operatorKeyword, false, "Measure within");

        ConceptBuilder.ActiveScope contains = set.concept("Measure contains (IkeFoundation)").at(inception)
                .synonym("Measure contains")
                .definition("An operator on two measures of the same scale that yields a presence"
                        + " value: whether the first measure encloses the second. Measure within"
                        + " with the operands swapped.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure contains")),
                        measureKind, presenceMeasureKind, binary);
        contains = keyword(contains, set, keywords, cql, "includes", operatorKeyword, true, "Measure contains");
        keyword(contains, set, keywords, cql, "contains", operatorKeyword, false, "Measure contains");

        keyword(set.concept("Measure overlaps (IkeFoundation)").at(inception)
                .synonym("Measure overlaps")
                .definition("An operator on two measures of the same scale that yields a presence"
                        + " value: whether the two share at least one point of the scale.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure overlaps")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "overlaps", operatorKeyword, true, "Measure overlaps");

        keyword(set.concept("Measure before (IkeFoundation)").at(inception)
                .synonym("Measure before")
                .definition("An operator on two measures of the same scale that yields a presence"
                        + " value: whether the first measure is entirely below the second."
                        + " Present when the upper bound of the first is below the lower bound of"
                        + " the second, Absent when the lower bound of the first is not below the"
                        + " upper bound of the second, and Indeterminate otherwise.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure before")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "before", operatorKeyword, true, "Measure before");

        keyword(set.concept("Measure after (IkeFoundation)").at(inception)
                .synonym("Measure after")
                .definition("An operator on two measures of the same scale that yields a presence"
                        + " value: whether the first measure is entirely above the second."
                        + " Measure before with the operands swapped.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure after")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "after", operatorKeyword, true, "Measure after");

        // ── The statement's measures: one result and its cross-cutting measurements
        set.concept("Statement measure (IkeFoundation)").at(inception)
                .synonym("Statement measure")
                .definition("A measure that an ANF statement carries and that a criterion can name."
                        + " A performance has one result measure, which is the assertion, and"
                        + " cross-cutting measurements that measure other dimensions of the"
                        + " statement: its timing and its normal range. A request has one requested"
                        + " result measure and its own cross-cutting measurements: its timing and"
                        + " its repetition. Every statement has a statement time measure. A second"
                        + " result is a second statement; a cross-cutting measurement is not a"
                        + " second result. Any of these can be recorded as a range rather than a"
                        + " point, so a comparison against any of them can be Indeterminate. Its"
                        + " members are Result measure, Timing measure, Statement time measure,"
                        + " Normal range measure, Requested result measure, Request timing measure,"
                        + " and Repetition measure with its five members. The health-risk flag is"
                        + " cross-cutting too, the laboratory's own summary kept as received; a"
                        + " query decides abnormal by comparing the result with the normal range as"
                        + " measures, and reads the flag only as what the laboratory said.")
                .isA(modelRoot);
        EntityProxy.Concept statementMeasure = set.conceptRef("Statement measure (IkeFoundation)");
        set.concept("Result measure (IkeFoundation)").at(inception)
                .synonym("Result measure")
                .definition("A statement measure: the statement's one result, what was determined,"
                        + " on the statement's measure semantic.")
                .isA(statementMeasure);
        set.concept("Timing measure (IkeFoundation)").at(inception)
                .synonym("Timing measure")
                .definition("A statement measure, cross-cutting to the result: when the"
                        + " determination occurred, on a date-time semantic.")
                .isA(statementMeasure);
        set.concept("Statement time measure (IkeFoundation)").at(inception)
                .synonym("Statement time measure")
                .definition("A statement measure, cross-cutting to the result: when the statement"
                        + " was made, on a date-time semantic.")
                .isA(statementMeasure);
        set.concept("Normal range measure (IkeFoundation)").at(inception)
                .synonym("Normal range measure")
                .definition("A statement measure, cross-cutting to the result: the reference range"
                        + " that framed this determination, on the result's own semantic. Instance"
                        + " data, tied to the act that produced the result: this laboratory's"
                        + " method, this instrument, this time of day. Stripped of those it means"
                        + " nothing, so it cannot stand alone and belongs on the performance beside"
                        + " them. A population or guideline range asserted independently of an act"
                        + " is not this; it is a standard, held elsewhere.")
                .isA(statementMeasure);
        set.concept("Requested result measure (IkeFoundation)").at(inception)
                .synonym("Requested result measure")
                .definition("A statement measure on a request: the result that is sought, on the"
                        + " semantic the result will have. A request has one requested result, as"
                        + " a performance has one result.")
                .isA(statementMeasure);
        set.concept("Request timing measure (IkeFoundation)").at(inception)
                .synonym("Request timing measure")
                .definition("A statement measure on a request, cross-cutting to the requested"
                        + " result: when the requested action should be carried out, on a"
                        + " date-time semantic.")
                .isA(statementMeasure);
        set.concept("Repetition measure (IkeFoundation)").at(inception)
                .synonym("Repetition measure")
                .definition("A statement measure on a request that describes an action requested"
                        + " for more than one occurrence: how often, for how long, and from when."
                        + " Its members are the five measure fields of a request's repetition:"
                        + " Period start measure, Period duration measure, Event separation"
                        + " measure, Event duration measure, and Event frequency measure.")
                .isA(statementMeasure);
        EntityProxy.Concept repetitionMeasure = set.conceptRef("Repetition measure (IkeFoundation)");
        set.concept("Period start measure (IkeFoundation)").at(inception)
                .synonym("Period start measure")
                .definition("A repetition measure: when the repeated action should begin, on a"
                        + " date-time semantic.")
                .isA(repetitionMeasure);
        set.concept("Period duration measure (IkeFoundation)").at(inception)
                .synonym("Period duration measure")
                .definition("A repetition measure: how long the repeated action should continue,"
                        + " on a time-unit semantic, such as seven to ten days.")
                .isA(repetitionMeasure);
        set.concept("Event separation measure (IkeFoundation)").at(inception)
                .synonym("Event separation measure")
                .definition("A repetition measure: the interval between one action and the next,"
                        + " on a time-unit semantic, such as every six hours.")
                .isA(repetitionMeasure);
        set.concept("Event duration measure (IkeFoundation)").at(inception)
                .synonym("Event duration measure")
                .definition("A repetition measure: how long each individual action should last,"
                        + " on a time-unit semantic, such as fifteen to twenty minutes.")
                .isA(repetitionMeasure);
        set.concept("Event frequency measure (IkeFoundation)").at(inception)
                .synonym("Event frequency measure")
                .definition("A repetition measure: how often the action should occur, on a"
                        + " frequency semantic, such as three times a day.")
                .isA(repetitionMeasure);

        // ── EL++ core constructs: denotations for the relation targets ──
        // Resumed declared identities. EL++ AND is the inherited And concept, renamed and
        // re-parented in place at foundation.Section41; EL++ has no surface syntax, so its
        // dialect carries the set's own rendering.
        EntityProxy.Concept elAnd = set.conceptRef(EL_AND_FQN);
        EntityProxy.Concept isA = set.conceptRef("Is-a");
        EntityProxy.Concept existentialRestriction = set.conceptRef("Existential restriction");
        keyword(set.concept(EL_AND_FQN).at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: EL++ AND")),
                        classKind, classKind, variadic),
                set, keywords, el, "AND", operatorKeyword, true, "EL++ AND");
        set.concept("Is-a").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Is-a")),
                        classKind, axiomKind, binary);
        set.concept("Existential restriction").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Existential restriction")),
                        classKind, classKind, unary);

        // ── Concept-set constructs: the topic layer; ECL binds here ─────
        keyword(set.concept("Descendant of (IkeFoundation)").at(inception)
                .synonym("Descendant of")
                .definition("A taxonomy operator that yields, for an anchor concept, every concept"
                        + " below it in the is-a hierarchy under the view, not including itself."
                        + " Definable from Is-a. The construct ECL's < names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Descendant of")),
                        conceptKind, conceptSetKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor("Construct relation: Descendant of definitionally extends Is-a")),
                        isA, definitionalExtension),
                set, keywords, ecl, "<", operatorKeyword, true, "Descendant of");
        EntityProxy.Concept descendantOf = set.conceptRef("Descendant of (IkeFoundation)");

        keyword(set.concept("Descendant or self of (IkeFoundation)").at(inception)
                .synonym("Descendant or self of")
                .definition("A taxonomy operator that yields, for an anchor concept, every concept"
                        + " below it in the is-a hierarchy under the view, itself included."
                        + " Definable from Is-a. The construct ECL's << names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Descendant or self of")),
                        conceptKind, conceptSetKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Descendant or self of definitionally extends Is-a")),
                        isA, definitionalExtension),
                set, keywords, ecl, "<<", operatorKeyword, true, "Descendant or self of");
        EntityProxy.Concept descendantOrSelfOf = set.conceptRef("Descendant or self of (IkeFoundation)");

        keyword(set.concept("Ancestor of (IkeFoundation)").at(inception)
                .synonym("Ancestor of")
                .definition("A taxonomy operator that yields, for an anchor concept, every concept"
                        + " above it in the is-a hierarchy under the view, not including itself."
                        + " Definable from Is-a. The construct ECL's > names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Ancestor of")),
                        conceptKind, conceptSetKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor("Construct relation: Ancestor of definitionally extends Is-a")),
                        isA, definitionalExtension),
                set, keywords, ecl, ">", operatorKeyword, true, "Ancestor of");

        keyword(set.concept("Ancestor or self of (IkeFoundation)").at(inception)
                .synonym("Ancestor or self of")
                .definition("A taxonomy operator that yields, for an anchor concept, every concept"
                        + " above it in the is-a hierarchy under the view, itself included."
                        + " Definable from Is-a. The construct ECL's >> names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Ancestor or self of")),
                        conceptKind, conceptSetKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Ancestor or self of definitionally extends Is-a")),
                        isA, definitionalExtension),
                set, keywords, ecl, ">>", operatorKeyword, true, "Ancestor or self of");

        keyword(set.concept("Concept set AND (IkeFoundation)").at(inception)
                .synonym("Concept set AND")
                .definition("A connective operator that joins two or more concept sets and requires"
                        + " every one of them: the result is the concepts that are in every operand"
                        + " set. When each operand set is the descendants of a class, the result is"
                        + " the descendants of the classes' intersection. That is a proven fact, so"
                        + " Concept set AND is definable from EL++ AND. The construct ECL's AND"
                        + " names.")
                .isA(genericAnd, IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Concept set AND")),
                        conceptSetKind, conceptSetKind, variadic)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Concept set AND definitionally extends EL++ AND")),
                        elAnd, definitionalExtension),
                set, keywords, ecl, "AND", operatorKeyword, true, "Concept set AND");

        keyword(set.concept("Concept set OR (IkeFoundation)").at(inception)
                .synonym("Concept set OR")
                .definition("A connective operator that joins two or more concept sets and requires"
                        + " at least one of them: the result is the concepts that are in any"
                        + " operand set. Definable from Is-a, but not the descendants of any class"
                        + " the core can build, because EL++ has no OR, so its core construct is"
                        + " Is-a itself. The construct ECL's OR names.")
                .isA(genericOr, IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Concept set OR")),
                        conceptSetKind, conceptSetKind, variadic)
                .semantic(relations,
                        PublicIds.of(set.uuidFor("Construct relation: Concept set OR definitionally extends Is-a")),
                        isA, definitionalExtension),
                set, keywords, ecl, "OR", operatorKeyword, true, "Concept set OR");

        keyword(set.concept("Concept set difference (IkeFoundation)").at(inception)
                .synonym("Concept set difference")
                .definition("A connective operator that takes two concept sets and keeps the"
                        + " concepts in the first that are not in the second. A difference of two"
                        + " finite computed sets, which is why it is not negation and never was."
                        + " Definable from Is-a. The construct ECL's MINUS names.")
                .isA(genericMinus, IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Concept set difference")),
                        conceptSetKind, conceptSetKind, binary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Concept set difference definitionally extends Is-a")),
                        isA, definitionalExtension),
                set, keywords, ecl, "MINUS", operatorKeyword, true, "Concept set difference");

        keyword(set.concept("Member of reference set (IkeFoundation)").at(inception)
                .synonym("Member of reference set")
                .definition("A taxonomy operator that yields, for a reference-set concept, the"
                        + " concepts its active membership semantics list: a fixed concept set,"
                        + " which is what a CQL value set is too. Not derived from is-a, so no"
                        + " relation to the core is claimed. The construct ECL's ^ names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Member of reference set")),
                        conceptKind, conceptSetKind, unary),
                set, keywords, ecl, "^", operatorKeyword, true, "Member of reference set");

        keyword(set.concept("Attribute refinement (IkeFoundation)").at(inception)
                .synonym("Attribute refinement")
                .definition("A taxonomy operator that keeps the members of a concept set whose"
                        + " definition carries a given attribute with a value in a given concept"
                        + " set. Those are the members below an existential restriction over that"
                        + " attribute, so this is definable from Existential restriction. The"
                        + " construct ECL's refinement colon names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Attribute refinement")),
                        conceptSetKind, conceptSetKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Attribute refinement definitionally extends Existential"
                                        + " restriction")),
                        existentialRestriction, definitionalExtension),
                set, keywords, ecl, ":", operatorKeyword, true, "Attribute refinement");

        keyword(set.concept("Concept set membership (IkeFoundation)").at(inception)
                .synonym("Concept set membership")
                .definition("A taxonomy operator that tells whether a concept is a member of a"
                        + " given concept set: Present or Absent, never Indeterminate, because the"
                        + " set is computed under the view and a concept is either in it or not."
                        + " Distinct from Member of reference set, which yields the set: ECL's ^"
                        + " names the set, CQL's in tests membership.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Concept set membership")),
                        conceptKind, presenceMeasureKind, unary),
                set, keywords, cql, "in", operatorKeyword, true, "Concept set membership");

        // ── Equivalences the set already contained without saying so ────
        set.concept("Descendant field constraint (IkeFoundation)").at(inception)
                .semantic(denotations,
                        PublicIds.of(set.uuidFor("Denotation: Descendant field constraint")),
                        conceptKind, conceptSetKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Descendant field constraint is logically equivalent"
                                        + " to Descendant of")),
                        descendantOf, logicalEquivalence);
        set.concept("Kind-of field constraint (IkeFoundation)").at(inception)
                .semantic(denotations,
                        PublicIds.of(set.uuidFor("Denotation: Kind-of field constraint")),
                        conceptKind, conceptSetKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Kind-of field constraint is logically equivalent to"
                                        + " Descendant or self of")),
                        descendantOrSelfOf, logicalEquivalence);

        // ── Statement operators: the query over ANF ─────────────────────
        set.concept("Statement operator (IkeFoundation)").at(inception)
                .synonym("Statement operator")
                .definition("An operator that works on sets of ANF statements: it selects them,"
                        + " narrows them, combines them, or answers from them. Each criterion a"
                        + " query puts to a statement yields a presence value, so a query's answer"
                        + " sorts its candidates into three groups: present, absent, and"
                        + " indeterminate. A statement operator picks a group by name or combines"
                        + " groups by set operations. The indeterminate group is something a query"
                        + " asks for, and it is never dropped unless the author drops it. The store"
                        + " speaks only for itself: no statement means no record here.")
                .isA(IkeTerm.MEANING);
        EntityProxy.Concept statementOperator = set.conceptRef("Statement operator (IkeFoundation)");

        set.concept("Topic constraint (IkeFoundation)").at(inception)
                .synonym("Topic constraint")
                .definition("A statement operator that keeps the statements whose topic is a member"
                        + " of a given concept set: the topic layer's result applied to statements."
                        + " A CQL retrieve with a value set is this, the value set naming the"
                        + " concept set.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Topic constraint")),
                        statementSetKind, statementSetKind, unary);

        set.concept("Circumstance constraint (IkeFoundation)").at(inception)
                .synonym("Circumstance constraint")
                .definition("A statement operator that keeps the statements whose circumstance has"
                        + " a given value in a concept-valued field: the status, which records what"
                        + " happened to the act, such as performed, not sought, or sought and not"
                        + " obtained; or the circumstance type, which is performance, request, or"
                        + " narrative. The same shape as a topic constraint, applied to the"
                        + " circumstance instead of the topic. This is how a query finds the"
                        + " statements whose act produced no result. Why it produced none, a"
                        + " refusal, a failed instrument, a decision not to perform, is not a field"
                        + " of the circumstance; it is an associated statement of its own, with the"
                        + " full expressive power of a statement.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Circumstance constraint")),
                        statementSetKind, statementSetKind, unary);

        keyword(set.concept("Statement filter (IkeFoundation)").at(inception)
                .synonym("Statement filter")
                .definition("A statement operator that keeps the statements whose answer to a"
                        + " criterion is in the group the author names: present, absent, or"
                        + " indeterminate. The criterion is a measure relation between one of the"
                        + " statement's measures and a target, or a derived criterion, and it names"
                        + " which statement measure it tests. Nothing is dropped unless a group is"
                        + " named. CQL's where is this filter fixed to the present group: it drops"
                        + " the null rows, and this filter makes that choice explicit.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Statement filter")),
                        statementSetKind, statementSetKind, unary),
                set, keywords, cql, "where", operatorKeyword, true, "Statement filter");

        keyword(set.concept("Statement set AND (IkeFoundation)").at(inception)
                .synonym("Statement set AND")
                .definition("A connective operator that joins two or more statement sets and"
                        + " requires every one of them: the result is the statements that are in"
                        + " every operand set. A set operation on groups a filter has already"
                        + " sorted, which is what CQL's intersect is on lists. Presence AND"
                        + " combines criteria; this combines results.")
                .isA(genericAnd, statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Statement set AND")),
                        statementSetKind, statementSetKind, variadic),
                set, keywords, cql, "intersect", operatorKeyword, true, "Statement set AND");

        keyword(set.concept("Statement set OR (IkeFoundation)").at(inception)
                .synonym("Statement set OR")
                .definition("A connective operator that joins two or more statement sets and"
                        + " requires at least one of them: the result is the statements that are in"
                        + " any operand set. A set operation on groups a filter has already sorted."
                        + " Presence OR combines criteria; this combines results. The construct"
                        + " CQL's union names.")
                .isA(genericOr, statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Statement set OR")),
                        statementSetKind, statementSetKind, variadic),
                set, keywords, cql, "union", operatorKeyword, true, "Statement set OR");

        keyword(set.concept("Statement set difference (IkeFoundation)").at(inception)
                .synonym("Statement set difference")
                .definition("A connective operator that takes two statement sets and keeps the"
                        + " statements in the first that are not in the second. A set operation on"
                        + " groups a filter has already sorted. Not negation: a subject with no"
                        + " statement on a topic has no record here, and a subject assessed and"
                        + " found clear has a statement whose value is Absent. The construct CQL's"
                        + " except names.")
                .isA(genericMinus, statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Statement set difference")),
                        statementSetKind, statementSetKind, binary),
                set, keywords, cql, "except", operatorKeyword, true, "Statement set difference");

        keyword(set.concept("Existence (IkeFoundation)").at(inception)
                .synonym("Existence")
                .definition("A statement operator that tells whether some statement in a set"
                        + " satisfies a criterion: Presence OR combined across every statement in"
                        + " the set, so Present when one satisfies it outright, Indeterminate when"
                        + " the best answer is Indeterminate, and Absent when the set is empty or"
                        + " none can. That Absent is a fact about the store, never about the"
                        + " subject. Having no statement of diabetes is not diabetes absent, and a"
                        + " derived determination needs evidence statements; with none there is no"
                        + " derived statement, not an absent one. CQL's exists reads an empty"
                        + " retrieve as false, treating the store as the world by default, and the"
                        + " binding records that.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Existence")),
                        statementSetKind, presenceMeasureKind, unary),
                set, keywords, cql, "exists", operatorKeyword, true, "Existence");

        set.concept("Subject projection (IkeFoundation)").at(inception)
                .synonym("Subject projection")
                .definition("A statement operator that yields the subjects of record of a statement"
                        + " set: what a query over ANF answers with. CQL has no keyword for it; its"
                        + " context is fixed to one subject at a time.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Subject projection")),
                        statementSetKind, subjectSetKind, unary);

        set.concept("Subject set difference (IkeFoundation)").at(inception)
                .synonym("Subject set difference")
                .definition("A connective operator that takes two subject sets and keeps the"
                        + " subjects in the first that are not in the second. How a query finds the"
                        + " subjects with no record on a topic: every subject, less the subjects of"
                        + " the statements on that topic. No record is all it means. The store"
                        + " speaks only for itself, and \"never assessed\" is a claim only a"
                        + " recorded not-sought statement can make.")
                .isA(genericMinus, statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Subject set difference")),
                        subjectSetKind, subjectSetKind, binary);
    }
}
