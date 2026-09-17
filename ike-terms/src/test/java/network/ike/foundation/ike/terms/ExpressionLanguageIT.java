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

import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.language.calculator.LanguageCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.generator.AxiomDecompiler;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The query-operator gate (IKE-Network/ike-issues#1089). Every keyword binding, denotation,
 * literal, relation, and dialect-scoped name in the set is read back from the written store
 * and the obligations decidable here are run: the well-typedness rules, the overload rule
 * (one keyword naming two constructs in one logic only when their operand kinds differ),
 * the per-logic rosters, the naming discipline (a generic's instances are named by layer
 * qualifier plus the shared word, US English preferred name qualified, the bare keyword
 * only in the logic's own dialect), the generics' exact children, and the finite obligation
 * that admits CQL's Boolean keywords by identity — CQL's specified three-valued tables
 * reproduced by bounds arithmetic on the presence literals' bounds, read from the set.
 * Concept-set obligations run over the reasoner conformance kit
 * (IKE-Network/ike-issues#1092).
 */
class ExpressionLanguageIT {

    private static KnowledgeSet set;
    private static StampCalculator calculator;
    private static LanguageCalculator fqnCalculator;

    private static int keywordPatternNid;
    private static int denotationPatternNid;
    private static int literalPatternNid;
    private static int relationPatternNid;

    private static int operatorKeywordNid;
    private static int typeKeywordNid;
    private static int literalKeywordNid;
    private static int functionNameNid;
    private static int unitKeywordNid;
    private static int conservativeExtensionNid;
    private static int logicalEquivalenceNid;
    private static int definitionalExtensionNid;
    private static int operandKindRootNid;
    private static int presenceMeasureKindNid;

    private static int cqlNid;
    private static int eclNid;
    private static int elNid;
    private static int genericAndNid;
    private static int genericOrNid;

    /** Operator nid → (operand kind, result kind, arity) nids. */
    private static final Map<Integer, int[]> DENOTATIONS = new HashMap<>();
    /** Literal nid → (result kind nid, lower bound, upper bound). */
    private static final Map<Integer, int[]> LITERALS = new HashMap<>();
    /** Extending construct nid → (core construct nid, relation nid). */
    private static final Map<Integer, int[]> RELATIONS = new HashMap<>();
    /** Logic nid → keyword text → nids of what the keyword names (usually one). */
    private static final Map<Integer, Map<String, List<Integer>>> KEYWORDS = new HashMap<>();
    /** Logic nid → keyword text → lexical role nid. */
    private static final Map<Integer, Map<String, Integer>> ROLES = new HashMap<>();
    /** Logic nid → its dialect pattern. */
    private static final Map<Integer, EntityProxy.Pattern> DIALECTS = new HashMap<>();
    /** The eight operand kinds beneath the root. */
    private static final Set<Integer> KINDS = new HashSet<>();
    /** Generic nid → nids of the concepts whose latest stated parents include it. */
    private static final Map<Integer, Set<Integer>> CHILDREN = new HashMap<>();
    /** Operand kind nid → the layer qualifier its instances' names begin with. */
    private static final Map<Integer, String> QUALIFIERS = new HashMap<>();

    @BeforeAll
    static void composeWriteAndRead() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT,
                Files.createTempDirectory("ike-expression-language").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        set = new IkeSource().compose();
        set.write();
        calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
        fqnCalculator = Calculators.Language.UsEnglishFullyQualifiedName(calculator.stampCoordinate());

        keywordPatternNid = set.patternRef(ExpressionLanguageSet.KEYWORD_PATTERN_FQN).nid();
        denotationPatternNid = set.patternRef(ExpressionLanguageSet.DENOTATION_PATTERN_FQN).nid();
        literalPatternNid = set.patternRef(ExpressionLanguageSet.LITERAL_PATTERN_FQN).nid();
        relationPatternNid = set.patternRef(ExpressionLanguageSet.RELATION_PATTERN_FQN).nid();

        operatorKeywordNid = nid("Operator keyword (IkeFoundation)");
        typeKeywordNid = nid("Type keyword (IkeFoundation)");
        literalKeywordNid = nid("Literal keyword (IkeFoundation)");
        functionNameNid = nid("Function name (IkeFoundation)");
        unitKeywordNid = nid("Unit keyword (IkeFoundation)");
        conservativeExtensionNid = nid("Conservative extension (IkeFoundation)");
        logicalEquivalenceNid = nid("Logical equivalence (IkeFoundation)");
        definitionalExtensionNid = nid("Definitional extension (IkeFoundation)");
        operandKindRootNid = nid("Operand kind (IkeFoundation)");
        presenceMeasureKindNid = nid("Presence measure kind (IkeFoundation)");
        for (String kind : List.of("Class", "Axiom", "Concept", "Concept set", "Measure",
                "Presence measure", "Statement", "Measure list", "Set", "Statement set", "Subject set")) {
            KINDS.add(nid(kind + " kind (IkeFoundation)"));
        }
        QUALIFIERS.put(nid("Class kind (IkeFoundation)"), "EL++ ");
        QUALIFIERS.put(nid("Concept set kind (IkeFoundation)"), "Concept set ");
        QUALIFIERS.put(nid("Statement set kind (IkeFoundation)"), "Statement set ");
        QUALIFIERS.put(presenceMeasureKindNid, "Presence ");
        QUALIFIERS.put(nid("Subject set kind (IkeFoundation)"), "Subject set ");
        QUALIFIERS.put(nid("Set kind (IkeFoundation)"), "Set ");
        QUALIFIERS.put(operandKindRootNid, "Generic ");

        cqlNid = nid("Clinical Quality Language (IkeFoundation)");
        eclNid = nid("SNOMED CT Expression Constraint Language (IkeFoundation)");
        elNid = nid("EL++ (IkeFoundation)");
        DIALECTS.put(cqlNid, set.patternRef(ExpressionLanguageSet.CQL_DIALECT_PATTERN_FQN));
        DIALECTS.put(eclNid, set.patternRef(ExpressionLanguageSet.ECL_DIALECT_PATTERN_FQN));
        DIALECTS.put(elNid, set.patternRef(ExpressionLanguageSet.EL_DIALECT_PATTERN_FQN));
        genericAndNid = nid(ExpressionLanguageSet.GENERIC_AND_FQN);
        genericOrNid = nid(ExpressionLanguageSet.GENERIC_OR_FQN);

        EntityService.get().forEachSemanticOfPattern(denotationPatternNid, semantic -> {
            ImmutableList<Object> fields = latestFields(semantic.nid());
            DENOTATIONS.put(semantic.referencedComponentNid(),
                    new int[] {nidOf(fields.get(0)), nidOf(fields.get(1)), nidOf(fields.get(2))});
        });
        EntityService.get().forEachSemanticOfPattern(literalPatternNid, semantic -> {
            ImmutableList<Object> fields = latestFields(semantic.nid());
            LITERALS.put(semantic.referencedComponentNid(),
                    new int[] {nidOf(fields.get(0)), (Integer) fields.get(1), (Integer) fields.get(2)});
        });
        EntityService.get().forEachSemanticOfPattern(relationPatternNid, semantic -> {
            ImmutableList<Object> fields = latestFields(semantic.nid());
            RELATIONS.put(semantic.referencedComponentNid(),
                    new int[] {nidOf(fields.get(0)), nidOf(fields.get(1))});
        });
        EntityService.get().forEachSemanticOfPattern(keywordPatternNid, semantic -> {
            ImmutableList<Object> fields = latestFields(semantic.nid());
            int language = nidOf(fields.get(0));
            String keyword = (String) fields.get(1);
            int role = nidOf(fields.get(2));
            KEYWORDS.computeIfAbsent(language, ignored -> new HashMap<>())
                    .computeIfAbsent(keyword, ignored -> new ArrayList<>())
                    .add(semantic.referencedComponentNid());
            Integer previousRole = ROLES.computeIfAbsent(language, ignored -> new HashMap<>())
                    .put(keyword, role);
            assertTrue(previousRole == null || previousRole == role,
                    "Keyword '" + keyword + "' bound with two lexical roles in " + fqn(language));
        });
        Set<Integer> generics = Set.of(genericAndNid, genericOrNid);
        EntityService.get().forEachConceptEntity(concept -> {
            for (int parent : latestIsAParents(concept.nid())) {
                if (generics.contains(parent)) {
                    CHILDREN.computeIfAbsent(parent, ignored -> new HashSet<>()).add(concept.nid());
                }
            }
        });
    }

    @AfterAll
    static void stop() {
        PrimitiveData.stop();
    }

    private static int nid(String fqn) {
        return set.conceptRef(fqn).nid();
    }

    private static int nidOf(Object fieldValue) {
        assertTrue(fieldValue instanceof EntityFacade,
                "Expected a component field value, got " + fieldValue);
        return ((EntityFacade) fieldValue).nid();
    }

    private static ImmutableList<Object> latestFields(int semanticNid) {
        Latest<SemanticEntityVersion> latest = calculator.latest(semanticNid);
        assertTrue(latest.isPresent(), "No latest active version for semantic " + semanticNid);
        return latest.get().fieldValues();
    }

    private static String fqn(int nid) {
        return fqnCalculator.getFullyQualifiedNameText(EntityProxy.Concept.make(nid))
                .orElse(PrimitiveData.text(nid));
    }

    private static String withoutTag(String fullyQualifiedName) {
        return fullyQualifiedName.replaceAll("\\s*\\([^()]*\\)\\s*$", "");
    }

    private static int only(int language, String keyword) {
        List<Integer> named = KEYWORDS.get(language).get(keyword);
        assertNotNull(named, "No binding for '" + keyword + "' in " + fqn(language));
        assertEquals(1, named.size(), "'" + keyword + "' names more than one thing in " + fqn(language));
        return named.get(0);
    }

    private static Set<Integer> latestIsAParents(int componentNid) {
        Set<Integer> parents = new HashSet<>();
        calculator.forEachSemanticVersionForComponentOfPattern(
                EntityProxy.Concept.make(componentNid),
                TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN,
                (semanticVersion, entityVersion, patternVersion) -> {
                    DiTreeEntity tree = (DiTreeEntity) semanticVersion.fieldValues().get(0);
                    AxiomDecompiler.Result result = AxiomDecompiler.decompile(tree);
                    if (result.simpleIsA()) {
                        result.parents().forEach(parent -> parents.add(parent.nid()));
                    }
                });
        return parents;
    }

    /** A regular-name description of a concept: its nid and its text. */
    private record Name(int descriptionNid, String text) {
    }

    private static List<Name> regularNamesOf(int conceptNid) {
        List<Name> names = new ArrayList<>();
        calculator.forEachSemanticVersionForComponentOfPattern(
                EntityProxy.Concept.make(conceptNid), TinkarTerm.DESCRIPTION_PATTERN,
                (semanticVersion, entityVersion, patternVersion) -> {
                    ImmutableList<Object> fields = semanticVersion.fieldValues();
                    if (nidOf(fields.get(3)) == IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE.nid()) {
                        names.add(new Name(semanticVersion.nid(), (String) fields.get(1)));
                    }
                });
        return names;
    }

    private static Set<Integer> acceptabilitiesOf(int descriptionNid, EntityProxy.Pattern dialectPattern) {
        Set<Integer> acceptabilities = new HashSet<>();
        calculator.forEachSemanticVersionForComponentOfPattern(
                EntityProxy.Semantic.make(descriptionNid), dialectPattern,
                (semanticVersion, entityVersion, patternVersion) ->
                        acceptabilities.add(nidOf(semanticVersion.fieldValues().get(0))));
        return acceptabilities;
    }

    // ── Well-typedness ──────────────────────────────────────────────────

    @Test
    @DisplayName("Every relation's two constructs carry a denotation and claim one of the three relations")
    void everyRelationIsTypedAndAdmitted() {
        assertFalse(RELATIONS.isEmpty(), "The set declares relation assertions");
        Set<Integer> admitted = Set.of(conservativeExtensionNid, logicalEquivalenceNid, definitionalExtensionNid);
        for (Map.Entry<Integer, int[]> relation : RELATIONS.entrySet()) {
            int extending = relation.getKey();
            int core = relation.getValue()[0];
            assertNotNull(DENOTATIONS.get(extending), "Untyped extending construct: " + fqn(extending));
            assertNotNull(DENOTATIONS.get(core), "Untyped core construct: " + fqn(core));
            assertTrue(admitted.contains(relation.getValue()[1]),
                    fqn(extending) + " claims an unadmitted relation " + fqn(relation.getValue()[1]));
        }
    }

    @Test
    @DisplayName("A logical equivalence agrees with its core in operand kind, result kind, and arity")
    void logicalEquivalencesAgreeInAllDimensions() {
        List<String> checked = new ArrayList<>();
        for (Map.Entry<Integer, int[]> relation : RELATIONS.entrySet()) {
            if (relation.getValue()[1] != logicalEquivalenceNid) {
                continue;
            }
            int[] extending = DENOTATIONS.get(relation.getKey());
            int[] core = DENOTATIONS.get(relation.getValue()[0]);
            String claim = fqn(relation.getKey()) + " is logically equivalent to " + fqn(relation.getValue()[0]);
            for (int dimension = 0; dimension < 3; dimension++) {
                assertEquals(core[dimension], extending[dimension],
                        "Denotation dimension " + dimension + " differs: " + claim);
            }
            checked.add(claim);
        }
        assertFalse(checked.isEmpty(), "The set declares logical equivalences");
    }

    @Test
    @DisplayName("A conservative extension agrees with its core in operand kind, result kind, and arity")
    void conservativeExtensionsAgreeInKindsAndArity() {
        for (Map.Entry<Integer, int[]> relation : RELATIONS.entrySet()) {
            if (relation.getValue()[1] != conservativeExtensionNid) {
                continue;
            }
            int[] extending = DENOTATIONS.get(relation.getKey());
            int[] core = DENOTATIONS.get(relation.getValue()[0]);
            String claim = fqn(relation.getKey()) + " conservatively extends " + fqn(relation.getValue()[0]);
            for (int dimension = 0; dimension < 3; dimension++) {
                assertEquals(core[dimension], extending[dimension],
                        "Denotation dimension " + dimension + " differs: " + claim);
            }
        }
    }

    // ── Bindings ────────────────────────────────────────────────────────

    @Test
    @DisplayName("A binding names what its lexical role says: an operator or function with a denotation, a kind, a literal with bounds, or a unit of time")
    void bindingsNameWhatTheirRoleSays() {
        int bindings = 0;
        int unitOfTime = nid("Unit of time (IkeFoundation)");
        for (Map.Entry<Integer, Map<String, List<Integer>>> logic : KEYWORDS.entrySet()) {
            for (Map.Entry<String, List<Integer>> keyword : logic.getValue().entrySet()) {
                int role = ROLES.get(logic.getKey()).get(keyword.getKey());
                for (int named : keyword.getValue()) {
                    String where = "'" + keyword.getKey() + "' in " + fqn(logic.getKey());
                    if (role == operatorKeywordNid || role == functionNameNid) {
                        assertNotNull(DENOTATIONS.get(named), where + " names an untyped operator " + fqn(named));
                    } else if (role == typeKeywordNid) {
                        assertTrue(KINDS.contains(named), where + " names " + fqn(named) + ", not a kind");
                    } else if (role == literalKeywordNid) {
                        assertNotNull(LITERALS.get(named), where + " names " + fqn(named) + ", not a literal");
                    } else if (role == unitKeywordNid) {
                        assertTrue(latestIsAParents(named).contains(unitOfTime),
                                where + " names " + fqn(named) + ", not a unit of time");
                    } else {
                        throw new AssertionError(where + " has unexpected lexical role " + fqn(role));
                    }
                    bindings++;
                }
            }
        }
        assertTrue(bindings > 0, "The set declares keyword bindings");
    }

    @Test
    @DisplayName("One keyword names two constructs in one logic only when their operand kinds differ")
    void overloadsAreDistinguishedByKind() {
        for (Map.Entry<Integer, Map<String, List<Integer>>> logic : KEYWORDS.entrySet()) {
            for (Map.Entry<String, List<Integer>> keyword : logic.getValue().entrySet()) {
                List<Integer> named = keyword.getValue();
                if (named.size() < 2) {
                    continue;
                }
                Set<Integer> operandKinds = new HashSet<>();
                for (int construct : named) {
                    int[] denotation = DENOTATIONS.get(construct);
                    assertNotNull(denotation, "Overloaded keyword names an untyped construct " + fqn(construct));
                    operandKinds.add(denotation[0]);
                }
                assertEquals(named.size(), operandKinds.size(),
                        "'" + keyword.getKey() + "' in " + fqn(logic.getKey())
                                + " names constructs that share an operand kind — an ambiguity, not an overload");
            }
        }
    }

    @Test
    @DisplayName("Each logic's allowed constructs are exactly its keyword bindings")
    void logicRostersAreExactlyTheBindings() {
        assertEquals(Set.of(
                        "and", "or", "not", "exists", "in", "intersect", "union", "except", "where",
                        "<", "<=", ">", ">=", "=", "same as", "between", "during", "included in", "includes",
                        "contains", "overlaps", "before", "after",
                        "+", "-", "*", "/", "start of", "end of", "width of", "duration between", "duration of",
                        "Count", "Sum", "Min", "Max", "Avg", "Median",
                        "on or before", "before or on", "on or after", "after or on", "within",
                        "difference between", "date from",
                        "millisecond", "milliseconds", "second", "seconds", "minute", "minutes",
                        "hour", "hours", "day", "days", "week", "weeks", "month", "months",
                        "year", "years",
                        "collapse", "expand",
                        "Boolean", "Integer", "Decimal", "Quantity", "Interval", "Date", "DateTime", "Time",
                        "Code", "Concept",
                        "true", "false", "null"),
                KEYWORDS.get(cqlNid).keySet(), "CQL roster");
        assertEquals(Set.of("<", "<<", ">", ">>", "AND", "OR", "MINUS", "^", ":"),
                KEYWORDS.get(eclNid).keySet(), "ECL roster");
        assertEquals(Set.of("AND"), KEYWORDS.get(elNid).keySet(),
                "EL++ has no surface syntax; its one keyword is the set's own rendering of its conjunction");
        assertEquals(3, KEYWORDS.size(), "CQL, ECL, and EL++ are the only logics with bindings");
    }

    @Test
    @DisplayName("Every keyword binding gives its construct a dialect-scoped name spelled as the logic spells it, one preferred per construct")
    void dialectNamesMatchBindings() {
        int checked = 0;
        for (Map.Entry<Integer, Map<String, List<Integer>>> logic : KEYWORDS.entrySet()) {
            EntityProxy.Pattern dialect = DIALECTS.get(logic.getKey());
            assertNotNull(dialect, "No dialect pattern for " + fqn(logic.getKey()));
            Map<Integer, Integer> preferredPerConstruct = new HashMap<>();
            for (Map.Entry<String, List<Integer>> keyword : logic.getValue().entrySet()) {
                for (int named : keyword.getValue()) {
                    boolean found = false;
                    for (Name name : regularNamesOf(named)) {
                        if (!name.text().equals(keyword.getKey())) {
                            continue;
                        }
                        Set<Integer> acceptabilities = acceptabilitiesOf(name.descriptionNid(), dialect);
                        if (acceptabilities.contains(IkeTerm.PREFERRED.nid())) {
                            preferredPerConstruct.merge(named, 1, Integer::sum);
                            found = true;
                        } else if (acceptabilities.contains(IkeTerm.ACCEPTABLE.nid())) {
                            found = true;
                        }
                    }
                    assertTrue(found, "'" + keyword.getKey() + "' in " + fqn(logic.getKey())
                            + " has no " + withoutTag(fqn(logic.getKey())) + "-dialect name on " + fqn(named));
                    checked++;
                }
            }
            for (Map.Entry<Integer, Integer> preferred : preferredPerConstruct.entrySet()) {
                assertEquals(1, preferred.getValue(), fqn(preferred.getKey()) + " has more than one preferred name in "
                        + fqn(logic.getKey()));
            }
        }
        assertTrue(checked > 0);
    }

    // ── One AND, three places ────────────────────────────────────────────

    @Test
    @DisplayName("The generics' children are exactly the layer instances, and every keyword binds to an instance")
    void genericsHaveExactlyTheLayerInstances() {
        int elAnd = nid(ExpressionLanguageSet.EL_AND_FQN);
        int setAnd = nid("Set AND (IkeFoundation)");
        int presenceAnd = nid("Presence AND (IkeFoundation)");
        assertEquals(Set.of(elAnd, setAnd, presenceAnd), CHILDREN.get(genericAndNid),
                "Generic AND has exactly three instances");
        assertEquals(Set.of(nid("Set OR (IkeFoundation)"), nid("Presence OR (IkeFoundation)")), CHILDREN.get(genericOrNid),
                "Generic OR has exactly two instances — EL++ has no OR");

        assertEquals(presenceAnd, only(cqlNid, "and"));
        assertEquals(setAnd, only(eclNid, "AND"));
        assertEquals(setAnd, only(cqlNid, "intersect"));
        assertEquals(elAnd, only(elNid, "AND"));
        for (Map<String, List<Integer>> roster : KEYWORDS.values()) {
            for (List<Integer> named : roster.values()) {
                for (int construct : named) {
                    assertTrue(construct != genericAndNid && construct != genericOrNid,
                            "A keyword binds to a generic: " + fqn(construct));
                }
            }
        }
    }

    @Test
    @DisplayName("Naming discipline: an instance is its layer qualifier plus the generic's word, a word shared at the seam written once, and its US English preferred name is that qualified name")
    void namingDisciplineHolds() {
        int checked = 0;
        for (Map.Entry<Integer, Set<Integer>> generic : CHILDREN.entrySet()) {
            String word = withoutTag(fqn(generic.getKey())).replaceFirst("^Generic ", "");
            for (int instance : generic.getValue()) {
                int[] denotation = DENOTATIONS.get(instance);
                assertNotNull(denotation, "Untyped instance " + fqn(instance));
                String qualifier = QUALIFIERS.get(denotation[0]);
                assertNotNull(qualifier, "No layer qualifier for operand kind " + fqn(denotation[0]));
                String expected = qualifiedName(qualifier, word);
                assertEquals(expected, withoutTag(fqn(instance)), "Fully qualified name of an instance");
                boolean preferredIsQualified = false;
                for (Name name : regularNamesOf(instance)) {
                    if (name.text().equals(expected)
                            && acceptabilitiesOf(name.descriptionNid(), IkeTerm.US_DIALECT_PATTERN)
                                    .contains(IkeTerm.PREFERRED.nid())) {
                        preferredIsQualified = true;
                    }
                }
                assertTrue(preferredIsQualified, "US English preferred name of " + fqn(instance) + " is not " + expected);
                checked++;
            }
        }
        assertEquals(5, checked, "Three AND and two OR instances checked");
    }

    /**
     * The layer qualifier followed by the generic's word, with a word the two share at
     * the seam written once: "Concept set " and "set difference" give "Concept set
     * difference", while "EL++ " and "AND" give "EL++ AND".
     */
    private static String qualifiedName(String qualifier, String word) {
        int space = word.indexOf(' ');
        String firstWord = space < 0 ? word : word.substring(0, space);
        String trimmedQualifier = qualifier.trim();
        if (trimmedQualifier.equals(firstWord) || trimmedQualifier.endsWith(" " + firstWord)) {
            return qualifier + word.substring(firstWord.length()).trim();
        }
        return qualifier + word;
    }

    // ── Measure operators: a measure in, a measure out ────────────────────

    @Test
    @DisplayName("Every measure operator takes measures and yields a measure, and CQL's arithmetic and bound keywords name them")
    void measureOperatorsTakeAndYieldMeasures() {
        int measureKind = nid("Measure kind (IkeFoundation)");
        int measureOperator = nid("Measure operator (IkeFoundation)");
        Map<String, String> arities = Map.of(
                "Measure addition", "Variadic", "Measure subtraction", "Binary",
                "Measure multiplication", "Variadic", "Measure division", "Binary",
                "Measure lower bound", "Unary", "Measure upper bound", "Unary", "Measure width", "Unary");
        for (Map.Entry<String, String> operator : arities.entrySet()) {
            int operatorNid = nid(operator.getKey() + " (IkeFoundation)");
            int[] denotation = DENOTATIONS.get(operatorNid);
            assertNotNull(denotation, "Untyped " + operator.getKey());
            assertEquals(measureKind, denotation[0], operator.getKey() + " takes measures");
            assertEquals(measureKind, denotation[1], operator.getKey() + " yields a measure");
            assertEquals(nid(operator.getValue() + " (IkeFoundation)"), denotation[2], operator.getKey() + " arity");
            assertTrue(latestIsAParents(operatorNid).contains(measureOperator),
                    operator.getKey() + " is a measure operator");
        }
        assertEquals(nid("Measure addition (IkeFoundation)"), only(cqlNid, "+"));
        assertEquals(nid("Measure subtraction (IkeFoundation)"), only(cqlNid, "-"));
        assertEquals(nid("Measure subtraction (IkeFoundation)"), only(cqlNid, "duration between"));
        assertEquals(nid("Measure multiplication (IkeFoundation)"), only(cqlNid, "*"));
        assertEquals(nid("Measure division (IkeFoundation)"), only(cqlNid, "/"));
        assertEquals(nid("Measure lower bound (IkeFoundation)"), only(cqlNid, "start of"));
        assertEquals(nid("Measure upper bound (IkeFoundation)"), only(cqlNid, "end of"));
        assertEquals(nid("Measure width (IkeFoundation)"), only(cqlNid, "width of"));
        assertEquals(nid("Measure width (IkeFoundation)"), only(cqlNid, "duration of"));
    }

    @Test
    @DisplayName("Aggregates take a measure list and yield a measure, the projection produces the list, the selections keep statements, and CQL's function names bind to the aggregates")
    void aggregatesProjectionAndSelectionsAreTyped() {
        int measureKind = nid("Measure kind (IkeFoundation)");
        int measureListKind = nid("Measure list kind (IkeFoundation)");
        int statementSetKind = nid("Statement set kind (IkeFoundation)");
        int unary = nid("Unary (IkeFoundation)");
        int measureAggregate = nid("Measure aggregate (IkeFoundation)");
        int statementOperator = nid("Statement operator (IkeFoundation)");
        assertTrue(KINDS.contains(measureListKind), "Measure list is an operand kind");
        assertTrue(latestIsAParents(measureAggregate).contains(nid("Measure operator (IkeFoundation)")),
                "Measure aggregate is a measure operator");
        Map<String, String> functions = Map.of(
                "Measure count", "Count", "Measure sum", "Sum", "Measure least", "Min",
                "Measure greatest", "Max", "Measure mean", "Avg", "Measure median", "Median");
        for (Map.Entry<String, String> aggregate : functions.entrySet()) {
            int aggregateNid = nid(aggregate.getKey() + " (IkeFoundation)");
            int[] denotation = DENOTATIONS.get(aggregateNid);
            assertNotNull(denotation, "Untyped " + aggregate.getKey());
            assertEquals(measureListKind, denotation[0], aggregate.getKey() + " takes a measure list");
            assertEquals(measureKind, denotation[1], aggregate.getKey() + " yields a measure");
            assertEquals(unary, denotation[2], aggregate.getKey() + " is unary");
            assertTrue(latestIsAParents(aggregateNid).contains(measureAggregate), aggregate.getKey() + " is an aggregate");
            assertEquals(aggregateNid, only(cqlNid, aggregate.getValue()));
            assertEquals(functionNameNid, ROLES.get(cqlNid).get(aggregate.getValue()),
                    aggregate.getValue() + " binds as a function name");
        }
        int[] projection = DENOTATIONS.get(nid("Measure projection (IkeFoundation)"));
        assertNotNull(projection, "Untyped Measure projection");
        assertEquals(statementSetKind, projection[0], "Measure projection takes a statement set");
        assertEquals(measureListKind, projection[1], "Measure projection yields a measure list");
        for (String selection : List.of("Least selection", "Greatest selection", "Measure projection")) {
            int selectionNid = nid(selection + " (IkeFoundation)");
            assertTrue(latestIsAParents(selectionNid).contains(statementOperator), selection + " is a statement operator");
        }
        for (String selection : List.of("Least selection", "Greatest selection")) {
            int[] denotation = DENOTATIONS.get(nid(selection + " (IkeFoundation)"));
            assertNotNull(denotation, "Untyped " + selection);
            assertEquals(statementSetKind, denotation[0], selection + " takes a statement set");
            assertEquals(statementSetKind, denotation[1], selection + " yields a statement set");
        }
    }

    // ── Timing relations: the reading rule, the equivalences, the whole unit ──

    @Test
    @DisplayName("The timing bindings name the inclusive comparisons and Measure within, in names two constructs of different kinds, Measure whole unit is a measure operator, and before and after claim their equivalences")
    void timingBindingsEquivalencesAndWholeUnit() {
        int lessThanOrEqual = nid("Less than or equal to (SOLOR)");
        int greaterThanOrEqual = nid("Greater than or equal to (SOLOR)");
        int within = nid("Measure within (IkeFoundation)");
        assertEquals(lessThanOrEqual, only(cqlNid, "on or before"));
        assertEquals(lessThanOrEqual, only(cqlNid, "before or on"));
        assertEquals(greaterThanOrEqual, only(cqlNid, "on or after"));
        assertEquals(greaterThanOrEqual, only(cqlNid, "after or on"));
        assertEquals(within, only(cqlNid, "within"));
        assertEquals(nid("Measure subtraction (IkeFoundation)"), only(cqlNid, "difference between"));
        List<Integer> in = KEYWORDS.get(cqlNid).get("in");
        assertNotNull(in, "CQL's in is bound");
        assertEquals(Set.of(nid("Concept set membership (IkeFoundation)"), within), new HashSet<>(in),
                "CQL's in names concept set membership and Measure within, one keyword on two kinds");
        int wholeUnit = nid("Measure whole unit (IkeFoundation)");
        int measureKind = nid("Measure kind (IkeFoundation)");
        int[] denotation = DENOTATIONS.get(wholeUnit);
        assertNotNull(denotation, "Untyped Measure whole unit");
        assertEquals(measureKind, denotation[0], "Measure whole unit takes a measure");
        assertEquals(measureKind, denotation[1], "Measure whole unit yields a measure");
        assertEquals(nid("Unary (IkeFoundation)"), denotation[2], "Measure whole unit is unary");
        assertTrue(latestIsAParents(wholeUnit).contains(nid("Measure operator (IkeFoundation)")),
                "Measure whole unit is a measure operator");
        assertEquals(wholeUnit, only(cqlNid, "date from"));
        int[] before = RELATIONS.get(nid("Measure before (IkeFoundation)"));
        assertNotNull(before, "Measure before claims a relation");
        assertEquals(nid("Less than (SOLOR)"), before[0], "Measure before relates to Less than");
        assertEquals(logicalEquivalenceNid, before[1], "Measure before claims logical equivalence");
        int[] after = RELATIONS.get(nid("Measure after (IkeFoundation)"));
        assertNotNull(after, "Measure after claims a relation");
        assertEquals(nid("Greater than (SOLOR)"), after[0], "Measure after relates to Greater than");
        assertEquals(logicalEquivalenceNid, after[1], "Measure after claims logical equivalence");
    }

    @Test
    @DisplayName("Obligation: Measure before decides as Less than and Measure after as Greater than on every ordering of the four ends with every combination of included and excluded ends")
    void beforeIsLessThanOnEveryEndOrdering() {
        int tried = 0;
        for (int lowerA = 0; lowerA <= 3; lowerA++) {
            for (int upperA = lowerA; upperA <= 3; upperA++) {
                for (int lowerB = 0; lowerB <= 3; lowerB++) {
                    for (int upperB = lowerB; upperB <= 3; upperB++) {
                        for (int inclusivity = 0; inclusivity < 16; inclusivity++) {
                            boolean includeLowerA = (inclusivity & 1) != 0;
                            boolean includeUpperA = (inclusivity & 2) != 0;
                            boolean includeLowerB = (inclusivity & 4) != 0;
                            boolean includeUpperB = (inclusivity & 8) != 0;
                            List<Double> valuesA = valuesAllowed(lowerA, upperA, includeLowerA, includeUpperA);
                            List<Double> valuesB = valuesAllowed(lowerB, upperB, includeLowerB, includeUpperB);
                            if (valuesA.isEmpty() || valuesB.isEmpty()) {
                                continue;
                            }
                            String where = " for " + lowerA + ".." + upperA + " and " + lowerB + ".." + upperB
                                    + " with inclusivity " + inclusivity;
                            assertEquals(quantifiedLessThan(valuesA, valuesB),
                                    boundsBefore(lowerA, upperA, includeUpperA, lowerB, upperB, includeLowerB),
                                    "Measure before differs from Less than" + where);
                            assertEquals(quantifiedLessThan(valuesB, valuesA),
                                    boundsBefore(lowerB, upperB, includeUpperB, lowerA, upperA, includeLowerA),
                                    "Measure after differs from Greater than" + where);
                            tried++;
                        }
                    }
                }
            }
        }
        assertTrue(tried > 500, "Every ordering was tried: " + tried);
    }

    /**
     * The values a range allows, at quarter-unit steps, honouring the inclusivity of each end.
     * Quarter steps leave every open unit interval three interior points, so a mixed answer
     * is always visible; half steps left one, and (0, 1) against (0, 1) looked decided.
     */
    private static List<Double> valuesAllowed(int lower, int upper, boolean includeLower, boolean includeUpper) {
        List<Double> values = new ArrayList<>();
        for (double value = lower; value <= upper; value += 0.25) {
            if (value == lower && !includeLower) {
                continue;
            }
            if (value == upper && !includeUpper) {
                continue;
            }
            values.add(value);
        }
        return values;
    }

    /** Less than as the reading rule states it: yes for every pair, no for every pair, or mixed. */
    private static String quantifiedLessThan(List<Double> valuesA, List<Double> valuesB) {
        boolean all = true;
        boolean none = true;
        for (double a : valuesA) {
            for (double b : valuesB) {
                if (a < b) {
                    none = false;
                } else {
                    all = false;
                }
            }
        }
        return all ? "Present" : none ? "Absent" : "Indeterminate";
    }

    /** Measure before as its definition states it, with the inclusivity of the touching ends. */
    private static String boundsBefore(int lowerA, int upperA, boolean includeUpperA,
                                       int lowerB, int upperB, boolean includeLowerB) {
        boolean present = upperA < lowerB || (upperA == lowerB && !(includeUpperA && includeLowerB));
        boolean absent = lowerA >= upperB;
        return present ? "Present" : absent ? "Absent" : "Indeterminate";
    }

    // ── Time: units, scales, the calendar, and the readings ─────────────

    @Test
    @DisplayName("Each unit keyword, singular and plural, names one unit of time; the scales, the calendar, the readings, and the zones have their parents")
    void unitsScalesCalendarAndReadings() {
        int unitOfTime = nid("Unit of time (IkeFoundation)");
        Map<String, String> plurals = Map.of("millisecond", "milliseconds", "second", "seconds",
                "minute", "minutes", "hour", "hours", "day", "days", "week", "weeks",
                "month", "months", "year", "years");
        for (Map.Entry<String, String> unit : plurals.entrySet()) {
            String name = Character.toUpperCase(unit.getKey().charAt(0)) + unit.getKey().substring(1);
            int unitNid = nid(name + " (IkeFoundation)");
            assertEquals(unitNid, only(cqlNid, unit.getKey()), unit.getKey() + " names " + name);
            assertEquals(unitNid, only(cqlNid, unit.getValue()), unit.getValue() + " names " + name);
            assertEquals(unitKeywordNid, ROLES.get(cqlNid).get(unit.getKey()), unit.getKey() + " is a unit keyword");
            assertEquals(unitKeywordNid, ROLES.get(cqlNid).get(unit.getValue()), unit.getValue() + " is a unit keyword");
            assertTrue(latestIsAParents(unitNid).contains(unitOfTime), name + " is a unit of time");
        }
        int timeScale = nid("Time scale (IkeFoundation)");
        for (String scale : List.of("Unix epoch milliseconds", "Unix epoch seconds", "Gregorian calendar date")) {
            assertTrue(latestIsAParents(nid(scale + " (IkeFoundation)")).contains(timeScale), scale + " is a time scale");
        }
        int timeReading = nid("Time reading (IkeFoundation)");
        for (String reading : List.of("Instant", "Period")) {
            assertTrue(latestIsAParents(nid(reading + " (IkeFoundation)")).contains(timeReading), reading + " is a time reading");
        }
        assertTrue(latestIsAParents(nid("Gregorian calendar (IkeFoundation)"))
                .contains(nid("Expression language model (IkeFoundation)")),
                "The Gregorian calendar is a concept of the set, under the model root");
        assertTrue(latestIsAParents(nid("Time zone (IkeFoundation)"))
                .contains(nid("Expression language model (IkeFoundation)")),
                "Time zone is a concept of the set, under the model root");
        assertTrue(latestIsAParents(nid("UTC offset (IkeFoundation)")).contains(nid("Time zone (IkeFoundation)")),
                "UTC offset is a time zone whose offset never changes");
    }

    // ── Days covered: the list operators and the two spans ───────────────

    @Test
    @DisplayName("Merge and split take a measure list and yield one, the two spans take two measures and yield a period, and collapse and expand name the list operators")
    void daysCoveredOperatorsAreTyped() {
        int measureKind = nid("Measure kind (IkeFoundation)");
        int measureListKind = nid("Measure list kind (IkeFoundation)");
        int unary = nid("Unary (IkeFoundation)");
        int binary = nid("Binary (IkeFoundation)");
        int measureListOperator = nid("Measure list operator (IkeFoundation)");
        int measureOperator = nid("Measure operator (IkeFoundation)");
        for (String operator : List.of("Measure list merge", "Measure list split")) {
            int operatorNid = nid(operator + " (IkeFoundation)");
            int[] denotation = DENOTATIONS.get(operatorNid);
            assertNotNull(denotation, "Untyped " + operator);
            assertEquals(measureListKind, denotation[0], operator + " takes a measure list");
            assertEquals(measureListKind, denotation[1], operator + " yields a measure list");
            assertEquals(unary, denotation[2], operator + " is unary");
            assertTrue(latestIsAParents(operatorNid).contains(measureListOperator), operator + " is a measure list operator");
        }
        for (String span : List.of("Measure outer span", "Measure inner span")) {
            int spanNid = nid(span + " (IkeFoundation)");
            int[] denotation = DENOTATIONS.get(spanNid);
            assertNotNull(denotation, "Untyped " + span);
            assertEquals(measureKind, denotation[0], span + " takes measures");
            assertEquals(measureKind, denotation[1], span + " yields a measure");
            assertEquals(binary, denotation[2], span + " is binary");
            assertTrue(latestIsAParents(spanNid).contains(measureOperator), span + " is a measure operator");
        }
        assertEquals(nid("Measure list merge (IkeFoundation)"), only(cqlNid, "collapse"));
        assertEquals(nid("Measure list split (IkeFoundation)"), only(cqlNid, "expand"));
    }

    // ── Obligation: CQL's Boolean semantics are bounds arithmetic ───────

    /** A presence measure as bounds. */
    private record Bounds(int lower, int upper) {
    }

    private static Bounds boundsOf(int literalNid) {
        int[] literal = LITERALS.get(literalNid);
        assertNotNull(literal, "No literal denotation for " + fqn(literalNid));
        assertEquals(presenceMeasureKindNid, literal[0], fqn(literalNid) + " is not a presence literal");
        return new Bounds(literal[1], literal[2]);
    }

    private static Bounds presenceAnd(Bounds a, Bounds b) {
        return new Bounds(Math.min(a.lower(), b.lower()), Math.min(a.upper(), b.upper()));
    }

    private static Bounds presenceOr(Bounds a, Bounds b) {
        return new Bounds(Math.max(a.lower(), b.lower()), Math.max(a.upper(), b.upper()));
    }

    private static Bounds presenceNot(Bounds a) {
        return new Bounds(1 - a.upper(), 1 - a.lower());
    }

    /**
     * CQL's specified three-valued tables, as the external reference: null propagates
     * unless the other operand decides the result. Encoded here from the specification,
     * independently of the bounds definitions above.
     */
    private static String cqlAnd(String a, String b) {
        if ("false".equals(a) || "false".equals(b)) {
            return "false";
        }
        if ("true".equals(a) && "true".equals(b)) {
            return "true";
        }
        return "null";
    }

    private static String cqlOr(String a, String b) {
        if ("true".equals(a) || "true".equals(b)) {
            return "true";
        }
        if ("false".equals(a) && "false".equals(b)) {
            return "false";
        }
        return "null";
    }

    private static String cqlNot(String a) {
        return switch (a) {
            case "true" -> "false";
            case "false" -> "true";
            default -> "null";
        };
    }

    @Test
    @DisplayName("CQL's Boolean tables are bounds arithmetic on the presence literals the set declares")
    void cqlBooleanSemanticsAreBoundsArithmetic() {
        List<String> literals = List.of("true", "false", "null");
        Map<String, Bounds> bounds = new HashMap<>();
        for (String literal : literals) {
            bounds.put(literal, boundsOf(only(cqlNid, literal)));
        }
        assertEquals(new Bounds(1, 1), bounds.get("true"));
        assertEquals(new Bounds(0, 0), bounds.get("false"));
        assertEquals(new Bounds(0, 1), bounds.get("null"));

        assertEquals(nid("Presence AND (IkeFoundation)"), only(cqlNid, "and"));
        assertEquals(nid("Presence OR (IkeFoundation)"), only(cqlNid, "or"));
        assertEquals(nid("Presence NOT (IkeFoundation)"), only(cqlNid, "not"));

        int rows = 0;
        for (String a : literals) {
            for (String b : literals) {
                assertEquals(bounds.get(cqlAnd(a, b)), presenceAnd(bounds.get(a), bounds.get(b)),
                        "and(" + a + ", " + b + ")");
                assertEquals(bounds.get(cqlOr(a, b)), presenceOr(bounds.get(a), bounds.get(b)),
                        "or(" + a + ", " + b + ")");
                rows++;
            }
            assertEquals(bounds.get(cqlNot(a)), presenceNot(bounds.get(a)), "not(" + a + ")");
        }
        assertEquals(9, rows, "The obligation is nine rows per binary connective");
    }
}
