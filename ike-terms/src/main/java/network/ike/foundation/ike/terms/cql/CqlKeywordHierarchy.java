package network.ike.foundation.ike.terms.cql;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import network.ike.foundation.ike.terms.IkeTerm;
import java.util.List;
import java.util.UUID;

/**
 * The CQL keyword hierarchy: the CQL keyword root, filed under Legacy (IkeFoundation), and the
 * families and categories every keyword section is filed under, as the CQL keyword dictionary
 * chapters group them (Types & Literals, Declarations, Core Operators, Data & Timing Operators,
 * Query & Control Flow).
 *
 * <p>Each category is a concept of the same shape as a keyword section — fully qualified name,
 * regular name, definition, UUID identifier, stated parent, US dialect preferences — with every
 * identity derived from its fully qualified name through {@code set.uuidFor(key)}. The
 * fully qualified names end in "keywords" or "keyword family" so no category's bindings
 * constant collides with a keyword's.
 */
final class CqlKeywordHierarchy {

    private CqlKeywordHierarchy() {
    }

    /** One category concept: its fully qualified name, regular name, parent, and definition. */
    private record Category(String fullyQualifiedName, String regularName, String parent, String definition) {
    }

    /** The root first, then the five families, then each family's categories. */
    private static final List<Category> CATEGORIES = List.of(
            new Category("CQL keyword (CQL)", "CQL keyword", "Legacy (IkeFoundation)",
                    "A word the CQL parser recognizes to build language constructs, as listed in the CQL Developer's Guide. Grouped by the families and categories of the CQL keyword dictionary."),
            new Category("Types and literals keyword family (CQL)", "Types & Literals", "CQL keyword (CQL)",
                    "This family defines the foundational values CQL expressions operate on: built-in types (Code, Concept, Interval, List, Tuple) and fixed literals (true, false, null). These terms establish the basic data shapes and constants used throughout the language."),
            new Category("Declarations keyword family (CQL)", "Declarations", "CQL keyword (CQL)",
                    "This family contains the top-level library-building language: context, terminology, parameters, includes, and reusable definitions, plus modifiers for visibility, aliasing, defaults, fluent use, display labels, and versions. In practice, these keywords structure a CQL library and control how its logic is exposed and reused."),
            new Category("Core operators keyword family (CQL)", "Core Operators", "CQL keyword (CQL)",
                    "This family covers general-purpose expression logic: boolean composition, arithmetic operations, type checks/conversions, and core comparison (between). These terms are the primary tools for computing, combining, and evaluating conditions inside definitions and queries."),
            new Category("Data and timing operators keyword family (CQL)", "Data & Timing Operators", "CQL keyword (CQL)",
                    "This family provides most of CQL's clinical data-shaping and temporal logic, including list/interval operations, temporal relationships, precision units, and date/time extraction (difference, duration, parts of dates/times). It is central for measure logic that depends on membership, boundaries, overlap, ordering, and timing windows."),
            new Category("Query and control flow keyword family (CQL)", "Query & Control Flow", "CQL keyword (CQL)",
                    "This family governs query construction and branching behavior: source and join clauses, filters, projections, sorting/aggregation, and conditional forms (if/then/else, case/when). These keywords let authors traverse data, shape result sets, and choose outcomes based on evaluated conditions."),
            new Category("Type name keywords (CQL)", "Type Name", "Types and literals keyword family (CQL)",
                    "The five built-in data types CQL's operators work with."),
            new Category("Literal keywords (CQL)", "Literal", "Types and literals keyword family (CQL)",
                    "The three fixed values CQL expressions can carry directly."),
            new Category("Declaration keywords (CQL)", "Declaration", "Declarations keyword family (CQL)",
                    "The library-level statements that give a CQL file its shape."),
            new Category("Declaration modifier keywords (CQL)", "Declaration Modifier", "Declarations keyword family (CQL)",
                    "Modifiers that refine a declaration -- an alias, a default, a version."),
            new Category("Access modifier keywords (CQL)", "Access Modifier", "Declarations keyword family (CQL)",
                    "Controls whether a definition is visible outside its own library."),
            new Category("Logical operator keywords (CQL)", "Logical Operator", "Core operators keyword family (CQL)",
                    "Boolean connectives, evaluated with three-valued (true/false/null) logic."),
            new Category("Arithmetic operator keywords (CQL)", "Arithmetic Operator", "Core operators keyword family (CQL)",
                    "Numeric operators beyond the basic +, -, *, /."),
            new Category("Type operator keywords (CQL)", "Type Operator", "Core operators keyword family (CQL)",
                    "Casting and type-checking between CQL's types."),
            new Category("Comparison operator keywords (CQL)", "Comparison Operator", "Core operators keyword family (CQL)",
                    "General-purpose range comparison."),
            new Category("List and interval operator keywords (CQL)", "List/Interval Operator", "Data and timing operators keyword family (CQL)",
                    "Operators for combining, comparing, and inspecting lists and intervals."),
            new Category("Timing operator keywords (CQL)", "Timing Operator", "Data and timing operators keyword family (CQL)",
                    "Allen's-interval-algebra-style relationships between dates, times, and intervals."),
            new Category("Time-precision unit keywords (CQL)", "Time-Precision Unit", "Data and timing operators keyword family (CQL)",
                    "The calendar-duration units quantities and date arithmetic are expressed in."),
            new Category("Extraction operator keywords (CQL)", "Extraction Operator", "Data and timing operators keyword family (CQL)",
                    "Pulling a component (date, time, precision) out of a date/time value."),
            new Category("Query clause keywords (CQL)", "Query Clause", "Query and control flow keyword family (CQL)",
                    "The clauses that make up a CQL query: source, filter, relate, shape, sort."),
            new Category("Conditional expression keywords (CQL)", "Conditional Expression", "Query and control flow keyword family (CQL)",
                    "Branching logic -- choose a result based on a condition."),
            new Category("Sort modifier keywords (CQL)", "Sort Modifier", "Query and control flow keyword family (CQL)",
                    "Direction keywords for the sort clause."));

    /**
     * Composes the hierarchy's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        CATEGORIES.forEach(category -> compose(set, category));
    }

    private static void compose(KnowledgeSet set, Category category) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;
        String fqn = category.fullyQualifiedName();

        UUID conceptUUID = set.uuidFor(fqn);
        UUID fullyQualifiedNameUUID = set.uuidFor(fqn + " fully qualified name description");
        UUID regularNameUUID = set.uuidFor(fqn + " regular name description");
        UUID definitionUUID = set.uuidFor(fqn + " definition description");

        set.concept(fqn, PublicIds.of(conceptUUID)).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedNameUUID), IkeTerm.ENGLISH_LANGUAGE, fqn, IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(regularNameUUID), IkeTerm.ENGLISH_LANGUAGE, category.regularName(), IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(definitionUUID), IkeTerm.ENGLISH_LANGUAGE, category.definition(), IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor(fqn + " UUID identifier")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, conceptUUID.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor(fqn + " stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef(category.parent())))))
                .semanticOn(PublicIds.of(fullyQualifiedNameUUID), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor(fqn + " fully qualified name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularNameUUID), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor(fqn + " regular name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definitionUUID), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor(fqn + " definition US dialect")), IkeTerm.PREFERRED)  // dialect pref
                ;
    }
}
