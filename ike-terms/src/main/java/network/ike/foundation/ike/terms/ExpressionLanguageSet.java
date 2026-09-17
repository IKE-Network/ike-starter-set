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
 * <b>One AND, three places it is used.</b> AND means every operand is required, not just
 * some of them, so the result is only what is all of the operands at once, and adding an
 * operand can only narrow the result, never widen it. In the EL++ layer the operands are
 * classes; in the set layer, sets of concepts, statements, or subjects, one operation
 * whatever the members; in the presence layer, presence
 * values, where the whole is Present only if every part is Present, Absent if any part is
 * Absent, and Indeterminate otherwise. The set says exactly that: a {@code Generic AND}
 * with no keyword in any logic, and three instances beneath it by is-a, {@code EL++ AND}
 * (the inherited And concept, keeping its identity), {@code Set AND}, and
 * {@code Presence AND}. Every keyword binds to an instance,
 * never to the parent, because two things are the same construct only when they work on
 * the same kind of thing. OR is the same shape, with the inherited Or concept as the
 * {@code Generic OR} itself, since EL++ has no OR and there is no class instance. NOT gets
 * no generic: EL++ has none, sets have {@code Set difference}, and
 * {@code Presence NOT} swaps a presence value, which is a different thing.
 * <p>
 * <b>Naming discipline.</b> A fully qualified name is the layer qualifier plus the
 * shared word: Generic, EL++, Concept set, Statement set, Presence, Subject set. The US
 * English preferred name is the qualified name. Each logic is a dialect of English (CQL
 * dialect, ECL dialect, EL++ dialect), and in its own dialect the construct a logic names
 * reads as the bare keyword, spelled as that logic spells it, while everything the logic
 * does not name falls back to the qualified name. No view ever shows three things called
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

                        There is one idea of AND and three places it is used. AND means every operand is
                        required, not just some of them, so the result is only what is all of the
                        operands at once, and adding an operand can only narrow the result, never
                        widen it. k:GenericAND[] holds the idea and no keyword. k:ELAND[],
                        k:SetAND[], and k:PresenceAND[] are its instances, one for each kind of
                        thing an operator works on, and every keyword binds to an
                        instance. Two things are the same construct only when they work on the same kind
                        of thing. NOT gets no generic, because EL++ has none, sets have
                        k:SetDifference[], and k:PresenceNOT[] swaps a presence value. That is the check
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
                        + " date as a measure on a date-time measure semantic. Once \"null\" is read as"
                        + " Indeterminate, CQL's three-valued \"and\", \"or\", and \"not\" are the"
                        + " presence connectives, and CQL's own tables follow from them row for"
                        + " row.")
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
                        + " of its members: Operator keyword, Type keyword, Unit keyword, Literal"
                        + " keyword, Function name, and Declaration keyword.")
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
        EntityProxy.Concept unitKeyword = set.conceptRef("Unit keyword (IkeFoundation)");

        set.concept("Literal keyword (IkeFoundation)").at(inception)
                .synonym("Literal keyword")
                .definition("A lexical role: the keyword is itself a fixed value of the logic, so"
                        + " the binding names the literal that carries that value's bounds.")
                .isA(lexicalRole);
        EntityProxy.Concept literalKeyword = set.conceptRef("Literal keyword (IkeFoundation)");

        set.concept("Function name (IkeFoundation)").at(inception)
                .synonym("Function name")
                .definition("A lexical role: the name of a function a logic calls with its"
                        + " arguments in parentheses, as CQL calls Count, Sum, Min, Max, Avg, and"
                        + " Median, rather than a keyword written before or between its operands."
                        + " The binding is the same as an operator keyword's; only the spelling on"
                        + " the page differs.")
                .isA(lexicalRole);
        EntityProxy.Concept functionName = set.conceptRef("Function name (IkeFoundation)");

        set.concept("Declaration keyword (IkeFoundation)").at(inception)
                .synonym("Declaration keyword")
                .definition("A lexical role: in a CQL library a value set, a code, or a concept is"
                        + " declared once by name and used many times, and the keyword that"
                        + " declares it introduces a thing rather than an operation. The binding"
                        + " records what that thing is in this model: a value set is a reference"
                        + " set under the view, a code names a concept, and a concept declared from"
                        + " several equivalent codes is one concept with identifiers in several"
                        + " code systems.")
                .isA(lexicalRole);
        EntityProxy.Concept declarationKeyword = set.conceptRef("Declaration keyword (IkeFoundation)");

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
                        + " The check is agreement on every input the core covers. One construct"
                        + " claims it: Closed-world existence, which agrees with"
                        + " Existence on every set that holds a statement and adds an answer,"
                        + " Absent, for the empty set. The three-valued connectives that would have"
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
                        + " measure kind beneath it, Measure list kind, Statement kind, and Set"
                        + " kind with Concept set"
                        + " kind, Statement set kind, and Subject set kind beneath it.")
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

        set.concept("Set kind (IkeFoundation)").at(inception)
                .synonym("Set kind")
                .definition("An operand kind: a set of things of one kind, concepts, statements, or"
                        + " subjects. The set operations work on any of them the same way; the kind"
                        + " of the members rides on the operands. Its members are Concept set kind,"
                        + " Statement set kind, and Subject set kind.")
                .isA(operandKind);
        EntityProxy.Concept setKind = set.conceptRef("Set kind (IkeFoundation)");
        set.concept("Concept set kind (IkeFoundation)").at(inception)
                .synonym("Concept set kind")
                .definition("An operand kind: a finite set of concepts computed under a view, which"
                        + " is what the ECL operators and the taxonomy field constraint kinds"
                        + " yield, and what a topic constraint selects statements by. The topic"
                        + " layer.")
                .isA(setKind);
        EntityProxy.Concept conceptSetKind = set.conceptRef("Concept set kind (IkeFoundation)");

        set.concept("Measure kind (IkeFoundation)").at(inception)
                .synonym("Measure kind")
                .definition("An operand kind: an ANF measure, a lower and an upper bound, the"
                        + " inclusivity of each, a resolution, and the measure semantic that is its"
                        + " frame of reference. Every value in a query over ANF is one: a result, a"
                        + " timing, a normal range, a CQL Quantity, Interval, Decimal, or DateTime."
                        + " A range means one of two things. A measure whose measure semantic is a period"
                        + " on the calendar, a hospital stay, has bounds where it began and ended."
                        + " A measure whose measure semantic is an instant on the calendar, an onset, or"
                        + " any quantity, has bounds where the value could be. Every relation on"
                        + " measures is decided the same way: Present when the answer is yes for"
                        + " every value the ranges allow, Absent when it is no for every one, and"
                        + " Indeterminate when it is yes for some and no for others. A relation"
                        + " between two periods is therefore decided outright, and it is"
                        + " Indeterminate only when an end known to a coarse resolution, a"
                        + " discharge known to the day, straddles the other's boundary. Two"
                        + " measures can be compared when both are on one scale, as an instant and"
                        + " a period on the calendar are; Measure conversion puts two on one scale"
                        + " when the knowledge layer has a rule between their measure semantics."
                        + " The measure semantic of a measure operator's result must be a concept"
                        + " the knowledge layer already defines.")
                .isA(operandKind);
        EntityProxy.Concept measureKind = set.conceptRef("Measure kind (IkeFoundation)");

        set.concept("Presence measure kind (IkeFoundation)").at(inception)
                .synonym("Presence measure kind")
                .definition("A measure kind: a measure on the Presence semantic, whose value is one"
                        + " of three. Present: the determination found the topic present. Absent:"
                        + " it found the topic absent. Indeterminate: it could not tell. It is what"
                        + " a determination records, what a comparison, a criterion, or a derived"
                        + " criterion yields, and what a CQL Boolean is represented as: \"true\" is"
                        + " Present, \"false\" is Absent, and \"null\" is Indeterminate when it"
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
                .isA(setKind);
        set.concept("Statement kind (IkeFoundation)").at(inception)
                .synonym("Statement kind")
                .definition("An operand kind: one ANF statement, which is what a criterion tests.")
                .isA(operandKind);
        EntityProxy.Concept statementSetKind = set.conceptRef("Statement set kind (IkeFoundation)");
        EntityProxy.Concept statementKind = set.conceptRef("Statement kind (IkeFoundation)");

        set.concept("Subject set kind (IkeFoundation)").at(inception)
                .synonym("Subject set kind")
                .definition("An operand kind: a set of subjects of record, which is what a query"
                        + " over ANF ultimately answers with, the subjects for which a statement"
                        + " set is not empty.")
                .isA(setKind);
        EntityProxy.Concept subjectSetKind = set.conceptRef("Subject set kind (IkeFoundation)");

        set.concept("Measure list kind (IkeFoundation)").at(inception)
                .synonym("Measure list kind")
                .definition("An operand kind: a list of measures on one measure semantic, one entry per"
                        + " statement, in which the same value appears as many times as statements"
                        + " recorded it. It is what a Measure projection produces and what a measure"
                        + " aggregate takes, and it is a list rather than a set because a sum or a"
                        + " mean must count every statement.")
                .isA(operandKind);
        EntityProxy.Concept measureListKind = set.conceptRef("Measure list kind (IkeFoundation)");

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
                        + " CQL's \"true\", \"false\", and \"null\" become Present, Absent, and"
                        + " Indeterminate as data the gate can check.")
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
                        k:CQLDialect[] the presence AND reads as `and`, and the two other ANDs keep
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
                        determinations, and criteria, k:StatementKind[] for what a criterion tests,
                        k:StatementSetKind[] and k:SubjectSetKind[] for what
                        a query narrows and answers with. There is no truth-value kind, and a generic
                        operator is typed at the root, meaning any kind.

                        That is what settles the question spelling hides. k:ELAND[] is class
                        intersection, class in and class out. k:PresenceAND[] is presence value in and
                        out, the `and` of criteria: Present only if every part is Present, Absent if any
                        part is Absent, and Indeterminate otherwise. k:SetAND[] is set in and set out,
                        whatever the members, and definable from class intersection when the sets are
                        descendant sets. Three instances, one generic, one word, and the kinds say
                        which is which.""");

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
                        sought, or sought and not obtained, is the disposition of the act on the circumstance,
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
                        agreement on everything the core covers plus more coverage;
                        k:ExistenceWithNoRecordAsAbsent[] claims it, agreeing with k:Existence[] on
                        every set that holds a statement and adding Absent for the empty set, which
                        is the closed-world default made into data. There is no value for "unrelated". A construct with no relation
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
                        + " things that belong to every operand class at once, Set AND keeps the"
                        + " members found in every operand set, whatever kind of thing they are,"
                        + " and Presence AND is Present only when every operand is Present.")
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
        conceptScope = keyword(conceptScope, set, keywords, cql, "Concept", typeKeyword, false, "Concept kind");
        conceptScope = keyword(conceptScope, set, keywords, cql, "code", declarationKeyword, false, "Concept kind");
        keyword(conceptScope, set, keywords, cql, "concept", declarationKeyword, false, "Concept kind");

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
                        + " sought and not obtained, is recorded as the disposition of the act. The"
                        + " reason is an associated statement. A subject with no statement at all"
                        + " simply has no record here.")
                .isA(modelRoot);
        EntityProxy.Concept indeterminateResult = set.conceptRef("Indeterminate result (IkeFoundation)");

        // ── Presence literals: the middle as a value ────────────────────
        keyword(set.concept("Present literal (IkeFoundation)").at(inception)
                .synonym("Present literal")
                .definition("One of the three presence values: the determination found the topic"
                        + " present. The value CQL's \"true\" names.")
                .isA(IkeTerm.LITERAL_VALUE)
                .semantic(literals, PublicIds.of(set.uuidFor("Literal denotation: Present literal")),
                        presenceMeasureKind, 1, 1),
                set, keywords, cql, "true", literalKeyword, true, "Present literal");

        keyword(set.concept("Absent literal (IkeFoundation)").at(inception)
                .synonym("Absent literal")
                .definition("One of the three presence values: the determination found the topic"
                        + " absent. Absent is a finding, not a gap: a subject with no statement on"
                        + " the topic has no record, not an Absent. The value CQL's \"false\""
                        + " names.")
                .isA(IkeTerm.LITERAL_VALUE)
                .semantic(literals, PublicIds.of(set.uuidFor("Literal denotation: Absent literal")),
                        presenceMeasureKind, 0, 0),
                set, keywords, cql, "false", literalKeyword, true, "Absent literal");

        keyword(set.concept("Indeterminate literal (IkeFoundation)").at(inception)
                .synonym("Indeterminate literal")
                .definition("An indeterminate result on the presence frame of reference, and one of"
                        + " the three presence values: the determination could not tell whether the"
                        + " topic was present or absent. It arises in two ways. A determination may"
                        + " report it directly, as with a test read in its equivocal zone. Or it"
                        + " may come from comparing a recorded range with a threshold or a date"
                        + " inside that range: an HbA1c recorded between 8.5 and 9.5 against a"
                        + " threshold of 9, or a determination dated to sometime in March against"
                        + " the 15th. Any measure a statement carries can be recorded as a range,"
                        + " so any of them can produce it, and the answer carries the measure that"
                        + " produced it, so the reader can see why. It is the one presence value"
                        + " that NOT leaves unchanged, and it is what CQL's \"null\" becomes when"
                        + " \"null\" stands for a determination that was performed and did not"
                        + " resolve.")
                .isA(IkeTerm.LITERAL_VALUE, indeterminateResult)
                .semantic(literals, PublicIds.of(set.uuidFor("Literal denotation: Indeterminate literal")),
                        presenceMeasureKind, 0, 1),
                set, keywords, cql, "null", literalKeyword, true, "Indeterminate literal");

        // ── Presence connectives: how criteria combine ──────────────────
        keyword(set.concept("Presence AND (IkeFoundation)").at(inception)
                .synonym("Presence AND")
                .definition("A connective operator that joins two or more presence values into one,"
                        + " in any order; every one of them is required. The result is Present if"
                        + " every operand is Present, Absent if any operand is Absent, and"
                        + " Indeterminate otherwise. This is exactly how CQL's \"and\" behaves over"
                        + " \"true\", \"false\", and \"null\", which is why CQL's \"and\" names it."
                        + " It combines criteria; Set AND combines the sets a filter has produced.")
                .isA(genericAnd)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Presence AND")),
                        presenceMeasureKind, presenceMeasureKind, variadic),
                set, keywords, cql, "and", operatorKeyword, true, "Presence AND");

        keyword(set.concept("Presence OR (IkeFoundation)").at(inception)
                .synonym("Presence OR")
                .definition("A connective operator that joins two or more presence values into one,"
                        + " in any order; any one of them is enough. The result is Present if any"
                        + " operand is Present, Absent if every operand is Absent, and"
                        + " Indeterminate otherwise. This is exactly how CQL's \"or\" behaves over"
                        + " \"true\", \"false\", and \"null\", which is why CQL's \"or\" names it."
                        + " It combines criteria; Set OR combines the sets a filter has produced.")
                .isA(genericOr)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Presence OR")),
                        presenceMeasureKind, presenceMeasureKind, variadic),
                set, keywords, cql, "or", operatorKeyword, true, "Presence OR");

        keyword(set.concept("Presence NOT (IkeFoundation)").at(inception)
                .synonym("Presence NOT")
                .definition("A connective operator on one presence value that turns Present into"
                        + " Absent and Absent into Present, and leaves Indeterminate as it is,"
                        + " because the opposite of could not tell is still could not tell. This is"
                        + " exactly how CQL's \"not\" behaves over \"true\", \"false\", and"
                        + " \"null\", which is why CQL's \"not\" names it. NOT belongs to the"
                        + " query, not to the record: a determination that found the topic absent"
                        + " is stored as Absent, never as NOT Present. It is not a subtraction of"
                        + " one set from another, which is Set difference, and it has no generic"
                        + " parent, because EL++ has no NOT.")
                .isA(IkeTerm.CONNECTIVE_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Presence NOT")),
                        presenceMeasureKind, presenceMeasureKind, unary),
                set, keywords, cql, "not", operatorKeyword, true, "Presence NOT");

        EntityProxy.Concept presenceAnd = set.conceptRef("Presence AND (IkeFoundation)");
        EntityProxy.Concept presenceOr = set.conceptRef("Presence OR (IkeFoundation)");
        keyword(set.concept("Presence implication (IkeFoundation)").at(inception)
                .synonym("Presence implication")
                .definition("A connective operator on two presence values: Present when the first"
                        + " is Absent or the second is Present, Absent when the first is Present"
                        + " and the second is Absent, and Indeterminate otherwise. It is Presence"
                        + " NOT of the first joined by Presence OR with the second, so it is"
                        + " definable from Presence OR. CQL's \"implies\" is this, and its"
                        + " nine-row table follows from the bounds.")
                .isA(IkeTerm.CONNECTIVE_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Presence implication")),
                        presenceMeasureKind, presenceMeasureKind, binary)
                .semantic(relations, PublicIds.of(set.uuidFor(
                                "Construct relation: Presence implication definitionally extends Presence OR")),
                        presenceOr, definitionalExtension),
                set, keywords, cql, "implies", operatorKeyword, true, "Presence implication");

        keyword(set.concept("Presence exclusive OR (IkeFoundation)").at(inception)
                .synonym("Presence exclusive OR")
                .definition("A connective operator on two presence values: Present when one is"
                        + " Present and the other Absent, Absent when both are Present or both are"
                        + " Absent, and Indeterminate when either is Indeterminate. It is Presence"
                        + " OR of the two joined by Presence AND with Presence NOT of their"
                        + " Presence AND, so it is definable from Presence AND. CQL's \"xor\" is"
                        + " this, and its nine-row table follows from the bounds.")
                .isA(IkeTerm.CONNECTIVE_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Presence exclusive OR")),
                        presenceMeasureKind, presenceMeasureKind, binary)
                .semantic(relations, PublicIds.of(set.uuidFor(
                                "Construct relation: Presence exclusive OR definitionally extends Presence AND")),
                        presenceAnd, definitionalExtension),
                set, keywords, cql, "xor", operatorKeyword, true, "Presence exclusive OR");

        keyword(keyword(set.concept("Conditional (IkeFoundation)").at(inception)
                .synonym("Conditional")
                .definition("An if-then-else: a value chosen by a condition, with any number of"
                        + " further conditions and a fallback, every branch of one kind. An"
                        + " if-then-else needs a yes or a no, and in this model a comparison can"
                        + " also come out Indeterminate, so each condition is a comparison on the"
                        + " presence semantic that names which outcomes take its branch, Present"
                        + " alone or Present and Indeterminate together, and is therefore always"
                        + " decided. A bare comparison that could come out Indeterminate is not"
                        + " accepted, for the reason a filter does not accept one. An author who"
                        + " wants the middle in a branch of its own adds a condition for"
                        + " Indeterminate alone and gives that branch what fits: for measures, the"
                        + " widest range the two branches allow; for concepts, both, as"
                        + " candidates. CQL's \"if\" and \"case\" are this with Present fixed as"
                        + " the outcome that takes the branch and never written down, so an"
                        + " Indeterminate condition goes to the else branch, and the binding"
                        + " records that as data.")
                .isA(modelRoot)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Conditional")),
                        operandKind, operandKind, variadic),
                set, keywords, cql, "if", operatorKeyword, true, "Conditional"),
                set, keywords, cql, "case", operatorKeyword, false, "Conditional");

        // ── Comparisons: the foundation's concrete-domain operators, recast on measures
        // Two measures on one scale in, a presence value out: Present when the bounds
        // decide it, Absent when they exclude it, Indeterminate when they overlap.
        keyword(keyword(set.concept("Greater than (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Greater than")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, ">", operatorKeyword, true, "Greater than"),
                set, keywords, ecl, ">", operatorKeyword, true, "Greater than");
        keyword(keyword(keyword(keyword(set.concept("Greater than or equal to (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Greater than or equal to")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, ">=", operatorKeyword, true, "Greater than or equal to"),
                set, keywords, cql, "on or after", operatorKeyword, false, "Greater than or equal to"),
                set, keywords, cql, "after or on", operatorKeyword, false, "Greater than or equal to"),
                set, keywords, ecl, ">=", operatorKeyword, true, "Greater than or equal to");
        keyword(keyword(set.concept("Less than (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Less than")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "<", operatorKeyword, true, "Less than"),
                set, keywords, ecl, "<", operatorKeyword, true, "Less than");
        keyword(keyword(keyword(keyword(set.concept("Less than or equal to (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Less than or equal to")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "<=", operatorKeyword, true, "Less than or equal to"),
                set, keywords, cql, "on or before", operatorKeyword, false, "Less than or equal to"),
                set, keywords, cql, "before or on", operatorKeyword, false, "Less than or equal to"),
                set, keywords, ecl, "<=", operatorKeyword, true, "Less than or equal to");
        keyword(keyword(keyword(keyword(keyword(keyword(set.concept("Equal to (SOLOR)").at(inception)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Equal to")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "=", operatorKeyword, true, "Equal to"),
                set, keywords, cql, "same as", operatorKeyword, false, "Equal to"),
                set, keywords, ecl, "=", operatorKeyword, true, "Equal to"),
                set, keywords, cql, "is null", operatorKeyword, false, "Equal to"),
                set, keywords, cql, "is true", operatorKeyword, false, "Equal to"),
                set, keywords, cql, "is false", operatorKeyword, false, "Equal to");

        // ── Measure relations: one family for presence, quantity, and time
        EntityProxy.Concept lessThan = set.conceptRef("Less than (SOLOR)");
        EntityProxy.Concept greaterThan = set.conceptRef("Greater than (SOLOR)");
        ConceptBuilder.ActiveScope within = set.concept("Measure within (IkeFoundation)").at(inception)
                .synonym("Measure within")
                .definition("An operator on two measures on one scale that yields a presence value:"
                        + " whether the first is inside the second. Present when every value the"
                        + " first allows is inside the second, Absent when none is, and"
                        + " Indeterminate when some are and some are not. A stay that ran past the"
                        + " end of a period is Absent. An onset recorded as March 2024, against a"
                        + " period that ends in the middle of March, is Indeterminate. A result is"
                        + " inside its own normal range when the whole range of the result is"
                        + " inside. It serves CQL's \"included in\", \"during\", \"between\", \"in\","
                        + " and \"within\" alike, because a timing is a measure; \"within 7 days of\""
                        + " an admission is this relation against the admission widened by 7 days"
                        + " each way, which Measure addition of minus 7 to plus 7 days produces."
                        + " The result and the normal range are two cross-cutting measurements of"
                        + " one statement, and that relation can be decided only with the"
                        + " statement's own range.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure within")),
                        measureKind, presenceMeasureKind, binary);
        within = keyword(within, set, keywords, cql, "included in", operatorKeyword, true, "Measure within");
        within = keyword(within, set, keywords, cql, "during", operatorKeyword, false, "Measure within");
        within = keyword(within, set, keywords, cql, "between", operatorKeyword, false, "Measure within");
        within = keyword(within, set, keywords, cql, "in", operatorKeyword, false, "Measure within");
        keyword(within, set, keywords, cql, "within", operatorKeyword, false, "Measure within");

        ConceptBuilder.ActiveScope contains = set.concept("Measure contains (IkeFoundation)").at(inception)
                .synonym("Measure contains")
                .definition("An operator on two measures on one scale that yields a presence value:"
                        + " whether the first encloses the second. Measure within with the"
                        + " operands swapped.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure contains")),
                        measureKind, presenceMeasureKind, binary);
        contains = keyword(contains, set, keywords, cql, "includes", operatorKeyword, true, "Measure contains");
        keyword(contains, set, keywords, cql, "contains", operatorKeyword, false, "Measure contains");

        keyword(set.concept("Measure overlaps (IkeFoundation)").at(inception)
                .synonym("Measure overlaps")
                .definition("An operator on two measures on one scale that yields a presence value:"
                        + " whether the two share any of the scale. Two stays that shared a day are"
                        + " Present, and two that did not are Absent; a stay whose discharge is"
                        + " known only to the day, against a period that begins in the middle of"
                        + " that day, is Indeterminate. For a moment against a period the question"
                        + " becomes whether the moment is inside the period, which is Measure"
                        + " within.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure overlaps")),
                        measureKind, presenceMeasureKind, binary),
                set, keywords, cql, "overlaps", operatorKeyword, true, "Measure overlaps");

        keyword(set.concept("Measure before (IkeFoundation)").at(inception)
                .synonym("Measure before")
                .definition("An operator on two measures on one scale that yields a presence value:"
                        + " whether the first is entirely earlier, or lower, than the second. For"
                        + " two periods, Present when the first ended before the second began, and"
                        + " Absent otherwise. For a value known to a range, Present when the upper"
                        + " bound of the first is below the lower bound of the second, Absent when"
                        + " the lower bound of the first is not below the upper bound of the"
                        + " second, and Indeterminate otherwise: an onset known only to a month is"
                        + " before a date when every day of that month is earlier. It decides the"
                        + " same way as Less than on every pair of measures, and the set asserts"
                        + " that equivalence. CQL's \"before\"; \"on or before\" and \"before or on\""
                        + " are Less than or equal to.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure before")),
                        measureKind, presenceMeasureKind, binary)
                .semantic(relations, PublicIds.of(set.uuidFor(
                                "Construct relation: Measure before is logically equivalent to Less than")),
                        lessThan, logicalEquivalence),
                set, keywords, cql, "before", operatorKeyword, true, "Measure before");

        keyword(set.concept("Measure after (IkeFoundation)").at(inception)
                .synonym("Measure after")
                .definition("An operator on two measures on one scale that yields a presence value:"
                        + " whether the first is entirely later, or higher, than the second."
                        + " Measure before with the operands swapped, and Greater than by the same"
                        + " equivalence. CQL's \"after\"; \"on or after\" and \"after or on\" are"
                        + " Greater than or equal to, and \"30 days or more after\" a discharge is"
                        + " Greater than or equal to against the discharge plus 30 days.")
                .isA(IkeTerm.CONCRETE_DOMAIN_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure after")),
                        measureKind, presenceMeasureKind, binary)
                .semantic(relations, PublicIds.of(set.uuidFor(
                                "Construct relation: Measure after is logically equivalent to Greater than")),
                        greaterThan, logicalEquivalence),
                set, keywords, cql, "after", operatorKeyword, true, "Measure after");

        // ── Measure operators: a measure in, a measure out, on the whole range ──
        set.concept("Measure operator (IkeFoundation)").at(inception)
                .synonym("Measure operator")
                .definition("An operator that produces a measure from one or more measures. A"
                        + " measure is a range with a lower and an upper bound on a measure"
                        + " semantic, so a measure operator works on the whole range, never on one"
                        + " number picked from inside it, and it never guesses how likely any value"
                        + " inside the range is. A single value is a measure whose two bounds are"
                        + " equal. The measure semantic of the result is the concept the knowledge layer"
                        + " defines for that operation on the operands' measure semantics: millimoles per"
                        + " liter less millimoles per liter is millimoles per liter, one date less"
                        + " another is a length of time, and milligrams per deciliter times"
                        + " deciliters is milligrams, each because a concept in the knowledge layer"
                        + " defines that combination, and where none does the operation is refused."
                        + " The result's"
                        + " resolution is the coarsest among the operands. A comparison or a measure"
                        + " relation answers a question about measures with Present, Absent, or"
                        + " Indeterminate; a measure operator produces a value on a scale. Presence"
                        + " has no arithmetic, because its measure semantic defines none, so the"
                        + " connectives"
                        + " are the only operations on presence values. Its members are Measure"
                        + " addition, Measure subtraction, Measure multiplication, Measure division,"
                        + " Measure lower bound, Measure upper bound, Measure width, Measure whole"
                        + " unit, Measure outer span, Measure inner span, Measure conversion, and"
                        + " Measure aggregate, which works over a list of measures.")
                .isA(modelRoot);
        EntityProxy.Concept measureOperator = set.conceptRef("Measure operator (IkeFoundation)");

        keyword(set.concept("Measure addition (IkeFoundation)").at(inception)
                .synonym("Measure addition")
                .definition("A measure operator that adds two or more measures, in any order. The"
                        + " lower bound of the result is the lower bounds added together, and the"
                        + " upper bound is the upper bounds added together. An end of the result is"
                        + " included only when every end that produced it is included. An operand"
                        + " that is Indeterminate contributes its whole frame, so the sum still says"
                        + " at least how much: a total daily dose with one dose Indeterminate is at"
                        + " least the sum of the known doses. The sum is Indeterminate only when its"
                        + " own bounds cover its whole frame. CQL's \"+\" is this addition; CQL adds"
                        + " single values, and there the two agree.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure addition")),
                        measureKind, measureKind, variadic),
                set, keywords, cql, "+", operatorKeyword, true, "Measure addition");

        keyword(keyword(keyword(set.concept("Measure subtraction (IkeFoundation)").at(inception)
                .synonym("Measure subtraction")
                .definition("A measure operator that takes the second of two measures away from the"
                        + " first. The lower bound of the result is the first's lower bound less the"
                        + " second's upper bound, and the upper bound is the first's upper bound"
                        + " less the second's lower bound: the smallest and the largest difference"
                        + " the two ranges allow. An HbA1c recorded as 8.5 to 9.5, less a threshold"
                        + " of 9, is minus 0.5 to plus 0.5, so a query can say at most half a point"
                        + " above and possibly not above at all, which is all the record supports."
                        + " A date is a measure on the calendar, so one date less another is a"
                        + " length of time in the unit the query names. CQL's \"-\" is this"
                        + " subtraction, and CQL's \"duration in days between\" two dates is this"
                        + " subtraction read in whole days, as it is for any unit of fixed length;"
                        + " a duration in months or years depends on the calendar and is not this"
                        + " subtraction. CQL's \"difference in days between\" two dates is this"
                        + " subtraction of the starts of their whole days, which is why it counts"
                        + " the day boundaries crossed.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure subtraction")),
                        measureKind, measureKind, binary),
                set, keywords, cql, "-", operatorKeyword, true, "Measure subtraction"),
                set, keywords, cql, "duration between", operatorKeyword, false, "Measure subtraction"),
                set, keywords, cql, "difference between", operatorKeyword, false, "Measure subtraction");

        keyword(set.concept("Measure multiplication (IkeFoundation)").at(inception)
                .synonym("Measure multiplication")
                .definition("A measure operator that multiplies two or more measures, in any order."
                        + " The bounds of the result are the smallest and the largest product that"
                        + " can be made from one bound of each operand. An operand that is"
                        + " Indeterminate contributes its whole frame, and the product is"
                        + " Indeterminate only when its own bounds cover its whole frame. CQL's"
                        + " \"*\" is this multiplication.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure multiplication")),
                        measureKind, measureKind, variadic),
                set, keywords, cql, "*", operatorKeyword, true, "Measure multiplication");

        keyword(set.concept("Measure division (IkeFoundation)").at(inception)
                .synonym("Measure division")
                .definition("A measure operator that divides the first of two measures by the"
                        + " second. The bounds of the result are the smallest and the largest"
                        + " quotient that can be made from one bound of each operand. Dividing by a"
                        + " measure whose range includes zero gives Indeterminate, since the"
                        + " quotient could then be any value at all. CQL's \"/\" is this division.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure division")),
                        measureKind, measureKind, binary),
                set, keywords, cql, "/", operatorKeyword, true, "Measure division");

        keyword(set.concept("Measure lower bound (IkeFoundation)").at(inception)
                .synonym("Measure lower bound")
                .definition("A measure operator that gives the lowest value inside a measure as a"
                        + " single value on the same measure semantic: the lower bound when it is included,"
                        + " and otherwise the first value above it at the measure's resolution."
                        + " CQL's \"start of\" an interval is this.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure lower bound")),
                        measureKind, measureKind, unary),
                set, keywords, cql, "start of", operatorKeyword, true, "Measure lower bound");

        keyword(set.concept("Measure upper bound (IkeFoundation)").at(inception)
                .synonym("Measure upper bound")
                .definition("A measure operator that gives the highest value inside a measure as a"
                        + " single value on the same measure semantic: the upper bound when it is included,"
                        + " and otherwise the first value below it at the measure's resolution."
                        + " CQL's \"end of\" an interval is this.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure upper bound")),
                        measureKind, measureKind, unary),
                set, keywords, cql, "end of", operatorKeyword, true, "Measure upper bound");

        keyword(keyword(set.concept("Measure width (IkeFoundation)").at(inception)
                .synonym("Measure width")
                .definition("A measure operator that gives how wide a measure's range is, the upper"
                        + " bound less the lower bound, as a single value on the measure semantic the"
                        + " knowledge layer defines for a difference on that scale: for a range of"
                        + " dates, a length of time. It is how a query asks how uncertain a result"
                        + " is. CQL's \"width of\" an interval is this, and CQL's \"duration in days"
                        + " of\" an interval is this read in whole days.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure width")),
                        measureKind, measureKind, unary),
                set, keywords, cql, "width of", operatorKeyword, true, "Measure width"),
                set, keywords, cql, "duration of", operatorKeyword, false, "Measure width");

        keyword(set.concept("Measure whole unit (IkeFoundation)").at(inception)
                .synonym("Measure whole unit")
                .definition("A measure operator that gives the whole unit of a named size that a"
                        + " measure occupies: the day of a timestamp is the whole day, from midnight"
                        + " to midnight, the month of a date is the whole month, and a range that"
                        + " touches two days becomes those two whole days. It is not division into"
                        + " equal buckets counted from zero: a day, a month, and a year are units of"
                        + " the calendar, defined in the knowledge layer, and a month varies in"
                        + " length. Every precision-based comparison uses it: CQL's \"same day as\""
                        + " is Equal to on the whole days, \"before day of\" is Measure before on"
                        + " them, and \"date from\" a timestamp is the whole day, the one keyword"
                        + " bound to this operator. The whole day of a timestamp depends on the"
                        + " zone: it takes the timing's own zone when it has one and the query's"
                        + " zone otherwise.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure whole unit")),
                        measureKind, measureKind, unary),
                set, keywords, cql, "date from", operatorKeyword, true, "Measure whole unit");

        set.concept("Measure outer span (IkeFoundation)").at(inception)
                .synonym("Measure outer span")
                .definition("A measure operator that takes two measures on one scale and gives the"
                        + " period from the earliest value the first allows to the latest value"
                        + " the second allows. For a dispense date and that date plus its days"
                        + " supply, it is everything that might have been covered. When both are"
                        + " single values it is the period from the first to the second, which is"
                        + " what CQL's Interval constructor builds. ANF's period has two bounds and"
                        + " cannot hold an end that is itself a range, so the outer span and the"
                        + " inner span together are what an uncertain end becomes.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure outer span")),
                        measureKind, measureKind, binary);

        set.concept("Measure inner span (IkeFoundation)").at(inception)
                .synonym("Measure inner span")
                .definition("A measure operator that takes two measures on one scale and gives the"
                        + " period from the latest value the first allows to the earliest value"
                        + " the second allows: what was certainly covered, and nothing at all when"
                        + " those two cross. When both are single values it is the same period as"
                        + " the outer span. Counting days over inner spans gives at least how many"
                        + " were covered, and over outer spans at most.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure inner span")),
                        measureKind, measureKind, binary);

        keyword(set.concept("Measure conversion (IkeFoundation)").at(inception)
                .synonym("Measure conversion")
                .definition("A measure operator that converts a measure from one unit to another:"
                        + " a weight recorded in grams given in kilograms, a glucose in milligrams"
                        + " per decilitre given in millimoles per litre. The result is a new"
                        + " measure whose measure semantic is the target unit, a value inside the"
                        + " query as a sum or a difference is; nothing is written, and the"
                        + " statement's recorded measure is unchanged. It needs a rule between the"
                        + " two units that the knowledge layer defines, the way a unit with a"
                        + " measurement basis is defined. Where the rule is a fixed factor and"
                        + " offset, grams to kilograms, milliseconds to seconds, Fahrenheit to"
                        + " Celsius, milligrams per decilitre to millimoles per litre for a named"
                        + " substance by its molar mass, the bounds and the resolution are scaled"
                        + " exactly and nothing is lost. Where the rule carries a width of its"
                        + " own, the HbA1c master equation between the percentage and the"
                        + " millimoles-per-mole scale, the result widens by that width. Where the"
                        + " knowledge layer has no rule, the conversion is refused. It is Measure"
                        + " multiplication by the factor and Measure addition of the offset, so it"
                        + " is definable from Measure multiplication. CQL's \"convert ... to\" is"
                        + " this; \"as\" and \"cast\" change a value's type, and kinds here are"
                        + " fixed before a query runs, so they are not bound.")
                .isA(measureOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure conversion")),
                        measureKind, measureKind, unary)
                .semantic(relations, PublicIds.of(set.uuidFor(
                                "Construct relation: Measure conversion definitionally extends Measure multiplication")),
                        set.conceptRef("Measure multiplication (IkeFoundation)"), definitionalExtension),
                set, keywords, cql, "convert", operatorKeyword, true, "Measure conversion");

        set.concept("Measure aggregate (IkeFoundation)").at(inception)
                .synonym("Measure aggregate")
                .definition("A measure operator that produces one measure from a list of measures."
                        + " Every member counts unless the aggregate is set to count only the"
                        + " members that arrived at a value, those that are not Indeterminate, the"
                        + " way a filter's criteria say which outcomes count. Each member of this"
                        + " family is exact on ranges for one reason: none of them can go down when"
                        + " a member goes up, so the aggregate of all the low ends and the"
                        + " aggregate of all the high ends are the ends of the true range, and"
                        + " count is exact outright. CQL's aggregate functions skip null, so each"
                        + " binds with the choice fixed to members with a value and never written"
                        + " down. Its members are Measure count, Measure sum, Measure least,"
                        + " Measure greatest, Measure mean, Measure median, Measure all present,"
                        + " Measure any present, Closed-world all present, and Closed-world any"
                        + " present.")
                .isA(measureOperator);
        EntityProxy.Concept measureAggregate = set.conceptRef("Measure aggregate (IkeFoundation)");

        keyword(set.concept("Measure count (IkeFoundation)").at(inception)
                .synonym("Measure count")
                .definition("A measure aggregate that gives how many members count, as a single"
                        + " value whose measure semantic is a count of statements. Set to count only"
                        + " members with a value, it gives how many statements arrived at one."
                        + " CQL's Count is this with that choice fixed.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure count")),
                        measureListKind, measureKind, unary),
                set, keywords, cql, "Count", functionName, true, "Measure count");

        keyword(set.concept("Measure sum (IkeFoundation)").at(inception)
                .synonym("Measure sum")
                .definition("A measure aggregate that adds every member that counts, Measure"
                        + " addition across the list: the low ends added together to the high ends"
                        + " added together, on the members' measure semantic. A total daily dose with one"
                        + " dose Indeterminate is at least the sum of the known doses. CQL's Sum is"
                        + " this with members with a value fixed.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure sum")),
                        measureListKind, measureKind, unary),
                set, keywords, cql, "Sum", functionName, true, "Measure sum");

        keyword(set.concept("Measure least (IkeFoundation)").at(inception)
                .synonym("Measure least")
                .definition("A measure aggregate that gives the least value among the members that"
                        + " count: from the lowest of the low ends to the lowest of the high ends."
                        + " HbA1c results of 7.0 to 8.0 and exactly 7.5 have a least result between"
                        + " 7.0 and 7.5. An Indeterminate member that counts puts the low end at"
                        + " the bottom of the frame. CQL's Min is this with members with a value"
                        + " fixed.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure least")),
                        measureListKind, measureKind, unary),
                set, keywords, cql, "Min", functionName, true, "Measure least");

        keyword(set.concept("Measure greatest (IkeFoundation)").at(inception)
                .synonym("Measure greatest")
                .definition("A measure aggregate that gives the greatest value among the members"
                        + " that count: from the highest of the low ends to the highest of the high"
                        + " ends. The same results have a greatest result between 7.5 and 8.0. An"
                        + " Indeterminate member that counts puts the high end at the top of the"
                        + " frame. CQL's Max is this with members with a value fixed.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure greatest")),
                        measureListKind, measureKind, unary),
                set, keywords, cql, "Max", functionName, true, "Measure greatest");

        keyword(set.concept("Measure mean (IkeFoundation)").at(inception)
                .synonym("Measure mean")
                .definition("A measure aggregate that gives the mean of the members that count:"
                        + " from the mean of the low ends to the mean of the high ends. An"
                        + " Indeterminate member widens the mean by its share of the frame, a third"
                        + " of it among three. CQL's Avg is this with members with a value fixed.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure mean")),
                        measureListKind, measureKind, unary),
                set, keywords, cql, "Avg", functionName, true, "Measure mean");

        keyword(set.concept("Measure median (IkeFoundation)").at(inception)
                .synonym("Measure median")
                .definition("A measure aggregate that gives the median of the members that count:"
                        + " from the median of the low ends to the median of the high ends. CQL's"
                        + " Median is this with members with a value fixed.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure median")),
                        measureListKind, measureKind, unary),
                set, keywords, cql, "Median", functionName, true, "Measure median");

        set.concept("Measure all present (IkeFoundation)").at(inception)
                .synonym("Measure all present")
                .definition("A measure aggregate over presence values, Presence AND across a list:"
                        + " Present when every member that counts is Present, Absent when any"
                        + " member is Absent, and Indeterminate otherwise; with no member it comes"
                        + " out with nothing, as Existence does on an empty set. The list is the"
                        + " outcomes of one determination across many statements, every screening"
                        + " question in a set answered yes. It takes the aggregate's choice of"
                        + " which members count, every member or only those with a value.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure all present")),
                        measureListKind, presenceMeasureKind, unary);
        EntityProxy.Concept measureAllPresent = set.conceptRef("Measure all present (IkeFoundation)");

        set.concept("Measure any present (IkeFoundation)").at(inception)
                .synonym("Measure any present")
                .definition("A measure aggregate over presence values, Presence OR across a list:"
                        + " Present when any member that counts is Present, Absent when every"
                        + " member is Absent, and Indeterminate otherwise; with no member it comes"
                        + " out with nothing. Existence is Presence OR of a criterion across a set"
                        + " of statements, and this is Presence OR across a list of measures, one"
                        + " idea at two kinds, the way one AND has three places. It takes the"
                        + " aggregate's choice of which members count.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure any present")),
                        measureListKind, presenceMeasureKind, unary);
        EntityProxy.Concept measureAnyPresent = set.conceptRef("Measure any present (IkeFoundation)");

        keyword(set.concept("Closed-world all present (IkeFoundation)").at(inception)
                .synonym("Closed-world all present")
                .definition("Measure all present read as if the store held the whole world: with no"
                        + " member it comes out Present instead of nothing, since nothing was found"
                        + " Absent. It agrees with Measure all present wherever that has an answer"
                        + " and differs only on the empty list, which makes it a conservative"
                        + " extension. CQL's AllTrue is this with the choice of members fixed to"
                        + " those with a value, which is how CQL skips null.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Closed-world all present")),
                        measureListKind, presenceMeasureKind, unary)
                .semantic(relations, PublicIds.of(set.uuidFor(
                                "Construct relation: Closed-world all present conservatively extends Measure all present")),
                        measureAllPresent, set.conceptRef("Conservative extension (IkeFoundation)")),
                set, keywords, cql, "AllTrue", functionName, true, "Closed-world all present");

        keyword(set.concept("Closed-world any present (IkeFoundation)").at(inception)
                .synonym("Closed-world any present")
                .definition("Measure any present read as if the store held the whole world: with no"
                        + " member it comes out Absent instead of nothing, since nothing was found"
                        + " Present. It agrees with Measure any present wherever that has an answer"
                        + " and differs only on the empty list, which makes it a conservative"
                        + " extension. CQL's AnyTrue is this with the choice of members fixed to"
                        + " those with a value.")
                .isA(measureAggregate)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Closed-world any present")),
                        measureListKind, presenceMeasureKind, unary)
                .semantic(relations, PublicIds.of(set.uuidFor(
                                "Construct relation: Closed-world any present conservatively extends Measure any present")),
                        measureAnyPresent, set.conceptRef("Conservative extension (IkeFoundation)")),
                set, keywords, cql, "AnyTrue", functionName, true, "Closed-world any present");

        // ── Measure list operators: a list of measures in, a list of measures out ──
        set.concept("Measure list operator (IkeFoundation)").at(inception)
                .synonym("Measure list operator")
                .definition("An operator that produces a list of measures from a list of measures,"
                        + " the measures of a set of statements gathered by a Measure projection. A"
                        + " measure aggregate produces one measure from such a list; a measure list"
                        + " operator produces another list, which an aggregate can then count or"
                        + " sum. Its members are Measure list merge and Measure list split.")
                .isA(modelRoot);
        EntityProxy.Concept measureListOperator = set.conceptRef("Measure list operator (IkeFoundation)");

        keyword(set.concept("Measure list merge (IkeFoundation)").at(inception)
                .synonym("Measure list merge")
                .definition("A measure list operator that takes a list of periods and returns the"
                        + " fewest periods that cover the same time. Two periods that overlap or"
                        + " touch, with no gap at their resolution, become one; a period apart from"
                        + " the rest stays as it is. Two dispenses whose periods overlap are one"
                        + " stretch of coverage, and the total time covered is the sum of the"
                        + " widths of the merged list. An end known only to the day stays known"
                        + " only to the day. CQL's \"collapse\" is this merge.")
                .isA(measureListOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure list merge")),
                        measureListKind, measureListKind, unary),
                set, keywords, cql, "collapse", operatorKeyword, true, "Measure list merge");

        keyword(set.concept("Measure list split (IkeFoundation)").at(inception)
                .synonym("Measure list split")
                .definition("A measure list operator that takes a list of periods and a unit of"
                        + " time and returns one measure for each whole unit that any period"
                        + " touches, in order, each a whole unit of that size. It is Measure whole"
                        + " unit applied to every period in the list, and it is how a query counts"
                        + " days: the days covered by medication are the split of the merged"
                        + " dispense periods, and their number is Measure count. CQL's \"expand\""
                        + " is this split, and CQL's \"per\" names the unit.")
                .isA(measureListOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure list split")),
                        measureListKind, measureListKind, unary),
                set, keywords, cql, "expand", operatorKeyword, true, "Measure list split");

        // ── Time: lengths, positions, the calendar, and the two readings ──────
        set.concept("Unit of time (IkeFoundation)").at(inception)
                .synonym("Unit of time")
                .definition("A measure semantic for a length of time. A measure on it is a duration,"
                        + " three days or two hours, and one concept serves three uses: the unit a"
                        + " duration is read in, the size Measure whole unit takes, and the"
                        + " resolution of a timing, a date known to the day. Millisecond, second,"
                        + " minute, and hour are fixed lengths. Day, week, month, and year are units"
                        + " of the Gregorian calendar, defined in the knowledge layer, and their"
                        + " length in hours varies: a month has 28 to 31 days, and a clock change"
                        + " makes a day 23 or 25 hours. A week is seven calendar days. ANF's"
                        + " resolution is a number, so a resolution finer than a millisecond can be"
                        + " recorded; CQL stops at the millisecond. Its members are Millisecond,"
                        + " Second, Minute, Hour, Day, Week, Month, and Year, and CQL's unit"
                        + " keywords name them, the singular and the plural on one concept.")
                .isA(modelRoot);
        EntityProxy.Concept unitOfTime = set.conceptRef("Unit of time (IkeFoundation)");

        keyword(keyword(set.concept("Millisecond (IkeFoundation)").at(inception)
                .synonym("Millisecond")
                .definition("A unit of time of fixed length, one thousandth of a second, and the"
                        + " finest precision CQL records. CQL's \"millisecond\" and"
                        + " \"milliseconds\".")
                .isA(unitOfTime),
                set, keywords, cql, "millisecond", unitKeyword, true, "Millisecond"),
                set, keywords, cql, "milliseconds", unitKeyword, false, "Millisecond");

        keyword(keyword(set.concept("Second (IkeFoundation)").at(inception)
                .synonym("Second")
                .definition("A unit of time of fixed length, sixty to the minute. CQL's \"second\""
                        + " and \"seconds\".")
                .isA(unitOfTime),
                set, keywords, cql, "second", unitKeyword, true, "Second"),
                set, keywords, cql, "seconds", unitKeyword, false, "Second");

        keyword(keyword(set.concept("Minute (IkeFoundation)").at(inception)
                .synonym("Minute")
                .definition("A unit of time of fixed length, sixty seconds. CQL's \"minute\" and"
                        + " \"minutes\".")
                .isA(unitOfTime),
                set, keywords, cql, "minute", unitKeyword, true, "Minute"),
                set, keywords, cql, "minutes", unitKeyword, false, "Minute");

        keyword(keyword(set.concept("Hour (IkeFoundation)").at(inception)
                .synonym("Hour")
                .definition("A unit of time of fixed length, sixty minutes. CQL's \"hour\" and"
                        + " \"hours\".")
                .isA(unitOfTime),
                set, keywords, cql, "hour", unitKeyword, true, "Hour"),
                set, keywords, cql, "hours", unitKeyword, false, "Hour");

        keyword(keyword(set.concept("Day (IkeFoundation)").at(inception)
                .synonym("Day")
                .definition("A unit of the Gregorian calendar, midnight to midnight in a time zone,"
                        + " twenty-four hours except where a clock change makes it twenty-three or"
                        + " twenty-five. It is the size of the whole day a timestamp occupies and"
                        + " the resolution of a date known to the day. CQL's \"day\" and \"days\".")
                .isA(unitOfTime),
                set, keywords, cql, "day", unitKeyword, true, "Day"),
                set, keywords, cql, "days", unitKeyword, false, "Day");

        keyword(keyword(set.concept("Week (IkeFoundation)").at(inception)
                .synonym("Week")
                .definition("A unit of the Gregorian calendar, seven calendar days. CQL's \"week\""
                        + " and \"weeks\".")
                .isA(unitOfTime),
                set, keywords, cql, "week", unitKeyword, true, "Week"),
                set, keywords, cql, "weeks", unitKeyword, false, "Week");

        keyword(keyword(set.concept("Month (IkeFoundation)").at(inception)
                .synonym("Month")
                .definition("A unit of the Gregorian calendar, twenty-eight to thirty-one days, so a"
                        + " duration in months depends on where in the calendar it starts. CQL's"
                        + " \"month\" and \"months\".")
                .isA(unitOfTime),
                set, keywords, cql, "month", unitKeyword, true, "Month"),
                set, keywords, cql, "months", unitKeyword, false, "Month");

        keyword(keyword(set.concept("Year (IkeFoundation)").at(inception)
                .synonym("Year")
                .definition("A unit of the Gregorian calendar, twelve months, 365 or 366 days. CQL's"
                        + " \"year\" and \"years\".")
                .isA(unitOfTime),
                set, keywords, cql, "year", unitKeyword, true, "Year"),
                set, keywords, cql, "years", unitKeyword, false, "Year");

        set.concept("Time scale (IkeFoundation)").at(inception)
                .synonym("Time scale")
                .definition("A measure semantic for a position in time, counted from an origin in a"
                        + " unit, so that a timing's bounds are two numbers on it. A timing recorded"
                        + " with a time zone is a measure on an epoch scale; a bare date is a"
                        + " measure on the calendar date scale, and the Gregorian calendar, given a"
                        + " zone, places it on the epoch scale as a whole day. Two measures on"
                        + " scales with one origin, milliseconds and seconds since the epoch, can"
                        + " be compared, and converting between them is exact. Its members are"
                        + " Unix epoch milliseconds, Unix epoch seconds, and Gregorian calendar"
                        + " date.")
                .isA(modelRoot);
        EntityProxy.Concept timeScale = set.conceptRef("Time scale (IkeFoundation)");

        set.concept("Unix epoch milliseconds (IkeFoundation)").at(inception)
                .synonym("Unix epoch milliseconds")
                .definition("A time scale: milliseconds counted from 1970-01-01T00:00:00 UTC, the"
                        + " origin of Unix time. It is what a database timestamp records, and what"
                        + " Java's Instant records in seconds and nanoseconds from the same origin."
                        + " A timestamp's resolution on it is a unit of time: a millisecond for a"
                        + " machine clock, a minute for a nurse's note.")
                .isA(timeScale);

        set.concept("Unix epoch seconds (IkeFoundation)").at(inception)
                .synonym("Unix epoch seconds")
                .definition("A time scale: seconds counted from 1970-01-01T00:00:00 UTC, Unix time."
                        + " It is the millisecond scale read a thousand times coarser, on the same"
                        + " origin, so a measure on either can be compared with a measure on the"
                        + " other exactly.")
                .isA(timeScale);

        set.concept("Gregorian calendar date (IkeFoundation)").at(inception)
                .synonym("Gregorian calendar date")
                .definition("A time scale: civil dates counted in days from 1970-01-01, with no time"
                        + " zone, what Java's LocalDate records. A date known to the day is a"
                        + " single value on it. It becomes a range on an epoch scale only when a"
                        + " time zone places its whole day, midnight to midnight in that zone.")
                .isA(timeScale);

        set.concept("Gregorian calendar (IkeFoundation)").at(inception)
                .synonym("Gregorian calendar")
                .definition("The calendar in civil use, which defines day, week, month, and year as"
                        + " stretches of the time scale: a day runs from midnight to midnight in a"
                        + " time zone, a week is seven days, a month has 28 to 31 days, and a year"
                        + " has 365 or 366. Measure whole unit takes its units as sizes, and it is"
                        + " what places a Gregorian calendar date on an epoch scale, given a zone."
                        + " It takes the timing's own zone when it has one and the query's zone"
                        + " otherwise.")
                .isA(modelRoot);

        set.concept("Time reading (IkeFoundation)").at(inception)
                .synonym("Time reading")
                .definition("Whether a timing's bounds are where a moment could be or where a stretch"
                        + " of time began and ended. A timing's measure semantic is a concept the"
                        + " knowledge layer defines as a reading on a time scale, in a time zone"
                        + " when the record carries one, an encounter's timing being a period in"
                        + " Unix epoch milliseconds read in Europe/Paris, the way a unit with a"
                        + " measurement basis is defined; this set holds the readings, the scales,"
                        + " and the zones, not the combinations. Its members are Instant and"
                        + " Period.")
                .isA(modelRoot);
        EntityProxy.Concept timeReading = set.conceptRef("Time reading (IkeFoundation)");

        set.concept("Instant (IkeFoundation)").at(inception)
                .synonym("Instant")
                .definition("A time reading: a position in time with no extent, an onset or a blood"
                        + " draw, whose bounds are where the moment could be. A relation on it can"
                        + " come out Indeterminate when the range straddles what it is compared"
                        + " with.")
                .isA(timeReading);

        set.concept("Period (IkeFoundation)").at(inception)
                .synonym("Period")
                .definition("A time reading: a stretch of time with a beginning and an end, a"
                        + " hospital stay, whose bounds are where it began and ended. A relation"
                        + " between two periods is decided outright, and it is Indeterminate only"
                        + " when an end known to a coarse resolution straddles the other's"
                        + " boundary.")
                .isA(timeReading);

        set.concept("Time zone (IkeFoundation)").at(inception)
                .synonym("Time zone")
                .definition("A region's rule for reading the clock: the offset from UTC at any"
                        + " instant, including the seasonal changes where daylight saving is used,"
                        + " named as in the IANA database, Europe/Paris, what Java's ZoneId records."
                        + " A timing on an epoch scale is the same instant everywhere, so a zone"
                        + " changes nothing about the instant and everything about the clock: a"
                        + " draw at 23:30 UTC is a night draw in London and an early-morning one in"
                        + " Paris. When a record carries the zone it was written in, that zone is"
                        + " the third part of the timing's measure semantic, beside the reading and the"
                        + " scale; without one, a query reads the calendar in the zone it names."
                        + " Measure whole unit and the Gregorian calendar take the timing's own"
                        + " zone when it has one and the query's otherwise. Its member is UTC"
                        + " offset.")
                .isA(modelRoot);
        EntityProxy.Concept timeZone = set.conceptRef("Time zone (IkeFoundation)");

        set.concept("UTC offset (IkeFoundation)").at(inception)
                .synonym("UTC offset")
                .definition("A time zone whose offset never changes: the difference between a clock"
                        + " and UTC, plus one hour or minus five, what a timestamp is written with"
                        + " and what Java's ZoneOffset records, itself a ZoneId. It places the"
                        + " edges of a day exactly, but it cannot say which region the record came"
                        + " from, since several regions share an offset and a region's offset"
                        + " changes with the season.")
                .isA(timeZone);

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
                        + " determination occurred, on a date-time measure semantic.")
                .isA(statementMeasure);
        set.concept("Statement time measure (IkeFoundation)").at(inception)
                .synonym("Statement time measure")
                .definition("A statement measure, cross-cutting to the result: when the statement"
                        + " was made, on a date-time measure semantic.")
                .isA(statementMeasure);
        set.concept("Normal range measure (IkeFoundation)").at(inception)
                .synonym("Normal range measure")
                .definition("A statement measure, cross-cutting to the result: the reference range"
                        + " that framed this determination, on the result's own measure semantic. Instance"
                        + " data, tied to the act that produced the result: this laboratory's"
                        + " method, this instrument, this time of day. Stripped of those it means"
                        + " nothing, so it cannot stand alone and belongs on the performance beside"
                        + " them. A population or guideline range asserted independently of an act"
                        + " is not this; it is a standard, held elsewhere.")
                .isA(statementMeasure);
        set.concept("Requested result measure (IkeFoundation)").at(inception)
                .synonym("Requested result measure")
                .definition("A statement measure on a request: the result that is sought, on the"
                        + " measure semantic the result will have. A request has one requested result, as"
                        + " a performance has one result.")
                .isA(statementMeasure);
        set.concept("Request timing measure (IkeFoundation)").at(inception)
                .synonym("Request timing measure")
                .definition("A statement measure on a request, cross-cutting to the requested"
                        + " result: when the requested action should be carried out, on a"
                        + " date-time measure semantic.")
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
                        + " date-time measure semantic.")
                .isA(repetitionMeasure);
        set.concept("Period duration measure (IkeFoundation)").at(inception)
                .synonym("Period duration measure")
                .definition("A repetition measure: how long the repeated action should continue,"
                        + " on a time-unit measure semantic, such as seven to ten days.")
                .isA(repetitionMeasure);
        set.concept("Event separation measure (IkeFoundation)").at(inception)
                .synonym("Event separation measure")
                .definition("A repetition measure: the interval between one action and the next,"
                        + " on a time-unit measure semantic, such as every six hours.")
                .isA(repetitionMeasure);
        set.concept("Event duration measure (IkeFoundation)").at(inception)
                .synonym("Event duration measure")
                .definition("A repetition measure: how long each individual action should last,"
                        + " on a time-unit measure semantic, such as fifteen to twenty minutes.")
                .isA(repetitionMeasure);
        set.concept("Event frequency measure (IkeFoundation)").at(inception)
                .synonym("Event frequency measure")
                .definition("A repetition measure: how often the action should occur, on a"
                        + " frequency measure semantic, such as three times a day.")
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
                        + " Definable from Is-a. The construct ECL's \"<\" names.")
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
                        + " Definable from Is-a. The construct ECL's \"<<\" names.")
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
                        + " Definable from Is-a. The construct ECL's \">\" names.")
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
                        + " Definable from Is-a. The construct ECL's \">>\" names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Ancestor or self of")),
                        conceptKind, conceptSetKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Ancestor or self of definitionally extends Is-a")),
                        isA, definitionalExtension),
                set, keywords, ecl, ">>", operatorKeyword, true, "Ancestor or self of");

        // ── Set operations: one construct each, whatever the members ────
        keyword(keyword(set.concept("Set AND (IkeFoundation)").at(inception)
                .synonym("Set AND")
                .definition("A connective operator that joins two or more sets of one kind into"
                        + " one set of that kind and requires every one of them: the result is"
                        + " the members that are in every operand set. It is the same operation"
                        + " whatever the members are, concepts, statements, or subjects; the kind"
                        + " of the members rides on the operands. When each operand set is the"
                        + " descendants of a class, the result is the descendants of the classes'"
                        + " intersection, a proven fact, so Set AND is definable from EL++ AND."
                        + " The construct ECL's \"AND\" names on concept sets and CQL's"
                        + " \"intersect\" names on lists of statements: one operation, two"
                        + " spellings.")
                .isA(genericAnd)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Set AND")),
                        setKind, setKind, variadic)
                .semantic(relations,
                        PublicIds.of(set.uuidFor("Construct relation: Set AND definitionally extends EL++ AND")),
                        elAnd, definitionalExtension),
                set, keywords, ecl, "AND", operatorKeyword, true, "Set AND"),
                set, keywords, cql, "intersect", operatorKeyword, true, "Set AND");

        keyword(keyword(set.concept("Set OR (IkeFoundation)").at(inception)
                .synonym("Set OR")
                .definition("A connective operator that joins two or more sets of one kind into"
                        + " one set of that kind and requires at least one of them: the result is"
                        + " the members that are in any operand set. It is the same operation"
                        + " whatever the members are, concepts, statements, or subjects. The"
                        + " construct ECL's \"OR\" names on concept sets and CQL's \"union\""
                        + " names on lists of statements: one operation, two spellings.")
                .isA(genericOr)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Set OR")),
                        setKind, setKind, variadic),
                set, keywords, ecl, "OR", operatorKeyword, true, "Set OR"),
                set, keywords, cql, "union", operatorKeyword, true, "Set OR");

        keyword(keyword(keyword(set.concept("Set difference (IkeFoundation)").at(inception)
                .synonym("Set difference")
                .definition("A connective operator that takes two sets of one kind and produces a"
                        + " set of that kind. Set difference means take the first operand and"
                        + " leave out whatever is also the second; here the order of the operands"
                        + " matters. It is the same operation whatever the members are, concepts,"
                        + " statements, or subjects, and it has no generic parent because nothing"
                        + " else subtracts: EL++ has no negation, and Presence NOT swaps a presence"
                        + " value, which is a different thing. On subject sets it finds the"
                        + " subjects with no record on a topic: a population, every subject of"
                        + " record in the store or a cohort already selected, less the subjects of"
                        + " the statements on that topic. On statement sets it finds the"
                        + " statements with no recorded reason, the statements minus those whose"
                        + " association comes out Present. No record is all either means. The"
                        + " store speaks only for itself, and \"never assessed\" is a claim only a"
                        + " recorded statement can make, one whose act's disposition is not sought."
                        + " Not negation: a subject assessed and found clear has a statement whose"
                        + " value is Absent, and a subject with no statement has no record. The"
                        + " construct ECL's \"MINUS\" names on concept sets and CQL's \"except\""
                        + " names on lists of statements: one operation, two spellings.")
                .isA(IkeTerm.CONNECTIVE_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Set difference")),
                        setKind, setKind, binary),
                set, keywords, ecl, "MINUS", operatorKeyword, true, "Set difference"),
                set, keywords, cql, "except", operatorKeyword, true, "Set difference"),
                set, keywords, cql, "without", operatorKeyword, false, "Set difference");

        keyword(keyword(set.concept("Member of reference set (IkeFoundation)").at(inception)
                .synonym("Member of reference set")
                .definition("A taxonomy operator that yields, for a reference-set concept, the"
                        + " concepts its active membership semantics list: a fixed concept set,"
                        + " which is what a CQL value set is too. Not derived from is-a, so no"
                        + " relation to the core is claimed. The construct ECL's \"^\" names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Member of reference set")),
                        conceptKind, conceptSetKind, unary),
                set, keywords, ecl, "^", operatorKeyword, true, "Member of reference set"),
                set, keywords, cql, "valueset", declarationKeyword, true, "Member of reference set");

        keyword(set.concept("Attribute refinement (IkeFoundation)").at(inception)
                .synonym("Attribute refinement")
                .definition("A taxonomy operator that keeps the members of a concept set whose"
                        + " definition carries a given attribute with a value in a given concept"
                        + " set. Those are the members below an existential restriction over that"
                        + " attribute, so this is definable from Existential restriction. The"
                        + " construct ECL's \":\" names.")
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
                        + " Distinct from Member of reference set, which yields the set: ECL's"
                        + " \"^\" names the set, CQL's \"in\" tests membership.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Concept set membership")),
                        conceptKind, presenceMeasureKind, unary),
                set, keywords, cql, "in", operatorKeyword, true, "Concept set membership");

        // ── ECL's remainder: groups, counts, a step along an attribute, and history ──
        keyword(set.concept("Attribute group refinement (IkeFoundation)").at(inception)
                .synonym("Attribute group refinement")
                .definition("A taxonomy operator that keeps the members of a concept set that have"
                        + " one attribute group carrying all the given attributes, each with a"
                        + " value in a given concept set: a disorder whose finding site is the"
                        + " lung and whose morphology is a tumour in the same group, not a tumour"
                        + " somewhere and a lung finding elsewhere. A group is an existential"
                        + " restriction over the grouping attribute with a conjunction inside, so"
                        + " this is definable from Existential restriction. The construct ECL's"
                        + " \"{ }\" names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Attribute group refinement")),
                        conceptSetKind, conceptSetKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Attribute group refinement definitionally extends"
                                        + " Existential restriction")),
                        existentialRestriction, definitionalExtension),
                set, keywords, ecl, "{ }", operatorKeyword, true, "Attribute group refinement");

        keyword(set.concept("Attribute count refinement (IkeFoundation)").at(inception)
                .synonym("Attribute count refinement")
                .definition("A taxonomy operator that keeps the members of a concept set whose"
                        + " definition has a given number of attributes of a type, from none to"
                        + " any, each with a value in a given concept set. None at all is how ECL"
                        + " asks for concepts without an attribute, a fracture with no laterality"
                        + " recorded. It counts the attributes in the definition under the view,"
                        + " which EL++ cannot express, so it is distinct and no relation to the"
                        + " core is claimed. The construct ECL's \"[ ]\" names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Attribute count refinement")),
                        conceptSetKind, conceptSetKind, unary),
                set, keywords, ecl, "[ ]", operatorKeyword, true, "Attribute count refinement");

        keyword(set.concept("Attribute value projection (IkeFoundation)").at(inception)
                .synonym("Attribute value projection")
                .definition("A taxonomy operator that takes a concept set and an attribute and"
                        + " yields the values of that attribute across the members: the finding"
                        + " sites of fractures. It is a step along an attribute at the topic"
                        + " layer, as Association constraint is a step along an association at"
                        + " the statement layer, computed over the definitions under the view,"
                        + " and distinct. ECL's reverse flag \"R\" is this projection with Set"
                        + " AND and carries no binding. The construct ECL's \".\" names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Attribute value projection")),
                        conceptSetKind, conceptSetKind, unary),
                set, keywords, ecl, ".", operatorKeyword, true, "Attribute value projection");

        ConceptBuilder.ActiveScope history = set.concept("Concept set history extension (IkeFoundation)").at(inception)
                .synonym("Concept set history extension")
                .definition("A taxonomy operator that adds to a concept set the inactive concepts"
                        + " whose historical associations reach a member, so that records coded"
                        + " with a concept since retired are found: a statement is immutable and"
                        + " keeps the concept it was coded with, and a concept set under today's"
                        + " view alone would miss it. ECL's three profiles, minimum, moderate, and"
                        + " maximum, decide which association types count, and each binds as a"
                        + " spelling with the profile fixed; \"+HISTORY\" alone is the moderate"
                        + " profile. It reads association data, not definitions, so it is"
                        + " distinct.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Concept set history extension")),
                        conceptSetKind, conceptSetKind, unary);
        history = keyword(history, set, keywords, ecl, "+HISTORY", operatorKeyword, true, "Concept set history extension");
        history = keyword(history, set, keywords, ecl, "+HISTORY-MIN", operatorKeyword, false, "Concept set history extension");
        history = keyword(history, set, keywords, ecl, "+HISTORY-MOD", operatorKeyword, false, "Concept set history extension");
        keyword(history, set, keywords, ecl, "+HISTORY-MAX", operatorKeyword, false, "Concept set history extension");

        keyword(set.concept("Member field constraint (IkeFoundation)").at(inception)
                .synonym("Member field constraint")
                .definition("A taxonomy operator that takes a reference set and yields the concepts"
                        + " of the members whose named field holds a value in a given concept set;"
                        + " the field may be the member itself. A reference set that pairs SNOMED"
                        + " concepts with ICD-10 codes carries the code on each member, so an"
                        + " ICD-10 code list becomes a SNOMED concept set: the members whose code"
                        + " is in the list, then their concepts. It reads membership data under"
                        + " the view, not definitions, so it is distinct and no relation to the"
                        + " core is claimed. The construct ECL's \"{{ M }}\" names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Member field constraint")),
                        conceptKind, conceptSetKind, unary),
                set, keywords, ecl, "{{ M }}", operatorKeyword, true, "Member field constraint");

        keyword(set.concept("Member field projection (IkeFoundation)").at(inception)
                .synonym("Member field projection")
                .definition("A taxonomy operator that takes a reference set and a field of its"
                        + " membership pattern and yields the values of that field across the"
                        + " active members, as a concept set: the ICD-10 codes of a cohort's SNOMED"
                        + " concepts, once a Member field constraint has kept the members that"
                        + " name them. A code is a concept in the knowledge layer, not text, which"
                        + " is what lets the two run in either direction. A field that holds"
                        + " numbers or text has no query kind here, so projecting it is refused."
                        + " It reads membership data under the view, so it is distinct. The"
                        + " construct ECL's \"^ [ ]\" names.")
                .isA(IkeTerm.TAXONOMY_OPERATOR)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Member field projection")),
                        conceptKind, conceptSetKind, unary),
                set, keywords, ecl, "^ [ ]", operatorKeyword, true, "Member field projection");

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
                .definition("An operator that works on sets of ANF statements. A filter keeps the"
                        + " statements that meet its criteria, Existence folds a criterion across a"
                        + " set into one presence value, the set operations combine sets, the"
                        + " projections turn statements into subjects or into a list of their"
                        + " measures, and the selections keep the statements that could hold the"
                        + " least or the greatest of a measure. The indeterminate"
                        + " middle is never dropped by default: a filter's criteria say which"
                        + " outcomes count. The store speaks only for itself: no statement means no"
                        + " record here.")
                .isA(IkeTerm.MEANING);
        EntityProxy.Concept statementOperator = set.conceptRef("Statement operator (IkeFoundation)");

        set.concept("Criterion (IkeFoundation)").at(inception)
                .synonym("Criterion")
                .definition("A test applied to one statement. A concept test is met or not met"
                        + " outright. A measure comparison comes out Present, Absent, or"
                        + " Indeterminate, and becomes met or not met through a further comparison"
                        + " on presence that says which outcomes count. Its members are Topic"
                        + " constraint, Circumstance constraint, Measure comparison, Association"
                        + " constraint, and Correlation constraint, and criteria combine with AND,"
                        + " OR, and NOT.")
                .isA(modelRoot);
        EntityProxy.Concept criterion = set.conceptRef("Criterion (IkeFoundation)");

        set.concept("Topic constraint (IkeFoundation)").at(inception)
                .synonym("Topic constraint")
                .definition("A criterion that tests the statement's topic for membership in a"
                        + " concept set, named as a concept and its kinds, one concept exactly, an"
                        + " ECL expression, or a reference set, and computed under the view before"
                        + " the test runs. A concept is either in the set or not, so it is met or"
                        + " not met outright. A CQL retrieve with a value set is this, the value"
                        + " set naming the concept set.")
                .isA(criterion)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Topic constraint")),
                        statementKind, presenceMeasureKind, unary);

        set.concept("Circumstance constraint (IkeFoundation)").at(inception)
                .synonym("Circumstance constraint")
                .definition("A criterion that tests one or more fields of the circumstance that"
                        + " hold a concept, the act's disposition, what became of it, the type, the method,"
                        + " the body site,"
                        + " the health risk, a request's priority, each for membership in a concept"
                        + " set named the same way as a topic constraint's. It is met or not met"
                        + " outright. This is how a query finds the statements whose act produced"
                        + " no result. Why it produced none, a refusal, a failed instrument, a"
                        + " decision not to perform, is not a field of the circumstance; it is an"
                        + " associated statement of its own, with everything a statement can say.")
                .isA(criterion)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Circumstance constraint")),
                        statementKind, presenceMeasureKind, unary);

        set.concept("Measure comparison (IkeFoundation)").at(inception)
                .synonym("Measure comparison")
                .definition("A criterion that compares a measure with an interval on a measure"
                        + " semantic: one of the statement's measures, the result, the timing, the"
                        + " normal range, or a request's, with a threshold in millimoles per liter"
                        + " or a date on the calendar; or a presence value, stored or produced by"
                        + " another comparison, with the presence values that count. A comparison"
                        + " that tests bounds exactly is met or not met outright, and every"
                        + " comparison on the presence semantic is of that kind, which is how a"
                        + " query asks for statements found present, found absent, could not tell,"
                        + " or any combination: Present and Indeterminate together is everyone not"
                        + " ruled out, the trial's candidate list; Absent and Indeterminate is"
                        + " everyone not confirmed; Indeterminate alone is the retest list. A"
                        + " comparison against a recorded range that straddles what it is compared"
                        + " with comes out Indeterminate, and it becomes met-or-not through a"
                        + " further comparison on presence. The measure semantic can be tested as"
                        + " a concept as well, for membership in a concept set, so that a"
                        + " comparison applies only to results in a kind of unit, and any measure semantic"
                        + " with the whole frame is \"has a result at all\".")
                .isA(criterion)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure comparison")),
                        statementKind, presenceMeasureKind, unary);

        set.concept("Association constraint (IkeFoundation)").at(inception)
                .synonym("Association constraint")
                .definition("A criterion that follows the statement's associations to the"
                        + " statements at their other end and tests those. It names the association"
                        + " types to follow, as a concept set, the direction, from this statement"
                        + " or to it, and the criteria the associated statements must meet, which"
                        + " may themselves include association constraints, so a criterion can"
                        + " follow a path of any length. It comes out Present if any associated"
                        + " statement of that type meets the criteria outright, Absent if such"
                        + " statements exist and every one comes out Absent, and Indeterminate"
                        + " otherwise; with no associated statement of that type it comes out with"
                        + " nothing, which is no record and not a value. It becomes met or not met"
                        + " through a comparison on presence, like any measure comparison. Presence"
                        + " NOT swaps Present and Absent and leaves Indeterminate, and never turns"
                        + " no record into a finding; the statements with no recorded reason are"
                        + " found by Set difference, the statements minus those whose association"
                        + " comes out Present. It is the topic layer's attribute refinement carried"
                        + " to the statement layer: refinement follows an attribute to a value and"
                        + " tests membership, this follows an association to a statement and tests"
                        + " criteria. This is how a query reaches the reason an act produced no"
                        + " result, the refusal or the failed instrument recorded as an associated"
                        + " statement, from the statement it explains.")
                .isA(criterion)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Association constraint")),
                        statementKind, presenceMeasureKind, unary);

        keyword(set.concept("Correlation constraint (IkeFoundation)").at(inception)
                .synonym("Correlation constraint")
                .definition("A criterion that tests a statement against a set of other statements"
                        + " of the same subject: does any statement in that set relate to this one"
                        + " in a given way, for example a condition whose onset was within the"
                        + " period of this encounter. It comes out Present when some statement in"
                        + " the set relates to this one outright, Absent when the set has"
                        + " statements and none of them does, and Indeterminate otherwise; when"
                        + " the set has no statement at all it comes out with nothing, which is no"
                        + " record and not a value, as an Association constraint does. The two"
                        + " differ in where the link comes from: an Association constraint follows"
                        + " a link the record holds, and a Correlation constraint computes the"
                        + " link from the two statements' measures and fields. It becomes met or"
                        + " not met through a comparison on presence, like any measure comparison."
                        + " CQL's \"with ... such that\" is Statement filter with this criterion"
                        + " fixed to Present and never written down, and the binding records that"
                        + " as data. CQL's \"without\" is Set difference, the first set less the"
                        + " statements whose correlation comes out Present, which keeps the same"
                        + " statements CQL keeps, since a null condition is not a match there"
                        + " either.")
                .isA(criterion)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Correlation constraint")),
                        statementKind, presenceMeasureKind, unary),
                set, keywords, cql, "with", operatorKeyword, true, "Correlation constraint");

        keyword(set.concept("Statement filter (IkeFoundation)").at(inception)
                .synonym("Statement filter")
                .definition("A filter that takes a set of statements and returns those that meet"
                        + " its criteria. Each statement is tested against the criteria, which"
                        + " combine with AND, OR, and NOT. A criterion is a topic constraint, a"
                        + " circumstance constraint, a measure comparison, or an association"
                        + " constraint, and every measure comparison names a measure semantic and"
                        + " an interval: a statement about serum sodium, whose act was performed,"
                        + " whose result below 0.001 millimoles per liter is Present or"
                        + " Indeterminate. Every criterion must be met or not met for every"
                        + " statement. A measure comparison that can come out Indeterminate becomes"
                        + " one through a further comparison on presence, and a bare one is not"
                        + " accepted, because its middle would be dropped without anyone saying"
                        + " so. CQL's \"where\" is this filter with that last comparison fixed to"
                        + " Present and never written down: it returns the rows where the condition"
                        + " is true and drops the \"null\" rows without saying so. A CQL retrieve"
                        + " is this filter with a topic constraint as its only criterion.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Statement filter")),
                        statementSetKind, statementSetKind, unary),
                set, keywords, cql, "where", operatorKeyword, true, "Statement filter");

        set.concept("Existence (IkeFoundation)").at(inception)
                .synonym("Existence")
                .definition("An operator that takes a set of statements and a criterion and returns"
                        + " one presence value for the set as a whole: Present if the criterion's"
                        + " result is Present for any statement in the set, Absent if it is Absent"
                        + " for every statement, and Indeterminate otherwise. It is Presence OR"
                        + " across the statements. On an empty set it returns nothing, because a"
                        + " presence value is a finding and an empty set holds none: a subject with"
                        + " no statement of diabetes has no record, not diabetes absent, and the"
                        + " subjects with no record are found with Set difference on a population."
                        + " CQL's \"exists\" is not this construct but Existence with no record as"
                        + " absent, which returns Absent on an empty set.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Existence")),
                        statementSetKind, presenceMeasureKind, unary);
        EntityProxy.Concept existence = set.conceptRef("Existence (IkeFoundation)");

        keyword(set.concept("Closed-world existence (IkeFoundation)").at(inception)
                .synonym("Closed-world existence")
                .definition("Existence read as if the store held the whole world: on an empty set"
                        + " it comes out Absent instead of nothing, so no record counts as absent."
                        + " It agrees with Existence on every set that holds at least one"
                        + " statement and differs only on the empty set, which makes it a"
                        + " conservative extension of Existence. The construct CQL's \"exists\""
                        + " names, and the reason a CQL \"not exists\" reads no record as found"
                        + " absent.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Closed-world existence")),
                        statementSetKind, presenceMeasureKind, unary)
                .semantic(relations,
                        PublicIds.of(set.uuidFor(
                                "Construct relation: Closed-world existence conservatively extends Existence")),
                        existence, set.conceptRef("Conservative extension (IkeFoundation)")),
                set, keywords, cql, "exists", operatorKeyword, true, "Closed-world existence");

        set.concept("Subject projection (IkeFoundation)").at(inception)
                .synonym("Subject projection")
                .definition("An operator that takes a set of statements and returns the subjects"
                        + " those statements are records of, the subject of record and not the"
                        + " subject of information: a family-history statement is about a relative"
                        + " but is a record of the patient. It is what a query over ANF answers"
                        + " with. CQL has no keyword for it, because a CQL query runs one subject"
                        + " at a time.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Subject projection")),
                        statementSetKind, subjectSetKind, unary);

        set.concept("Measure projection (IkeFoundation)").at(inception)
                .synonym("Measure projection")
                .definition("A statement operator that takes a set of statements and the name of"
                        + " one statement measure, the result, the timing, the normal range, or a"
                        + " request's, and returns the list of that measure from each statement"
                        + " that carries it, one entry per statement. The entries must share one"
                        + " measure semantic: a list that would mix HbA1c in percent with HbA1c in"
                        + " millimoles per mole is refused, because measures on different measure"
                        + " semantics cannot be added or compared; Measure conversion puts them on"
                        + " one measure semantic first, when the knowledge layer has a rule. It is"
                        + " the parallel of Subject projection, which turns statements into"
                        + " subjects.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Measure projection")),
                        statementSetKind, measureListKind, unary);

        set.concept("Least selection (IkeFoundation)").at(inception)
                .synonym("Least selection")
                .definition("A statement operator that takes a set of statements and the name of"
                        + " one statement measure and returns the statements that could hold the"
                        + " least value of it: those whose low end is not above the lowest of the"
                        + " high ends. When the ranges overlap, more than one statement qualifies"
                        + " and the result is a candidate list, the same treatment presence gives"
                        + " a comparison it cannot decide; when the record decides it, exactly"
                        + " one. It is how a query asks for the lowest result and when it was"
                        + " recorded, which the least value alone cannot say.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Least selection")),
                        statementSetKind, statementSetKind, unary);

        set.concept("Greatest selection (IkeFoundation)").at(inception)
                .synonym("Greatest selection")
                .definition("A statement operator that takes a set of statements and the name of"
                        + " one statement measure and returns the statements that could hold the"
                        + " greatest value of it: those whose high end is not below the highest of"
                        + " the low ends. Least selection with the ends swapped.")
                .isA(statementOperator)
                .semantic(denotations, PublicIds.of(set.uuidFor("Denotation: Greatest selection")),
                        statementSetKind, statementSetKind, unary);

    }
}
