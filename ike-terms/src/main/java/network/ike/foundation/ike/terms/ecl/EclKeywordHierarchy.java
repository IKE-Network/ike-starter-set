package network.ike.foundation.ike.terms.ecl;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import network.ike.foundation.ike.terms.IkeTerm;
import java.util.List;
import java.util.UUID;

/**
 * The ECL keyword hierarchy: the ECL keyword root, filed under Legacy (IkeFoundation), and the
 * 4 families and 5 categories every keyword section is filed under, as the ECL 2.3 grammar
 * groups its keywords (constraint operators, logic and refinement, filters, history).
 *
 * <p>Each category is a concept of the same shape as a keyword section, with every identity
 * derived from its fully qualified name through {@code set.uuidFor(key)}. The fully qualified
 * names start with "ECL" so no bindings constant collides with a CQL category's.
 */
final class EclKeywordHierarchy {

    private EclKeywordHierarchy() {
    }

    /** One category concept: its fully qualified name, regular name, parent, and definition. */
    private record Category(String fullyQualifiedName, String regularName, String parent, String definition) {
    }

    /** The root first, then the families, then each family's categories. */
    private static final List<Category> CATEGORIES = List.of(
            new Category("ECL keyword (ECL)", "ECL keyword", "Legacy (IkeFoundation)",
                    "A word or symbol the SNOMED CT Expression Constraint Language (ECL 2.3) parser "
                    + "recognizes, as listed in the brief and long syntax ABNF. Grouped by the families and"
                    + " categories below. Every textual ECL keyword is case insensitive."),
            new Category("ECL constraint operators keyword family (ECL)", "Constraint Operators", "ECL keyword (ECL)",
                    "This family selects concepts by their position in the SNOMED CT hierarchy or by "
                    + "reference set membership. Each keyword has a symbol (brief syntax) and a word (long "
                    + "syntax) form."),
            new Category("ECL logic and refinement keyword family (ECL)", "Logic & Refinement", "ECL keyword (ECL)",
                    "This family combines expression constraints and refines them by attribute: the "
                    + "boolean connectives and the modifiers of an attribute or attribute group."),
            new Category("ECL filters keyword family (ECL)", "Filters", "ECL keyword (ECL)",
                    "This family covers the {{ }} filter constraints that narrow a result by description,"
                    + " concept or reference set member properties, and the fixed tokens those filters "
                    + "compare against."),
            new Category("ECL history keyword family (ECL)", "History", "ECL keyword (ECL)",
                    "The history supplement keyword and its profiles, which add inactive concepts to a "
                    + "result through historical associations, the profile choosing how many associations "
                    + "to follow."),
            new Category("ECL hierarchy operator keywords (ECL)", "Hierarchy Operator", "ECL constraint operators keyword family (ECL)",
                    "Selects descendants, ancestors, children, parents, or the top or bottom of a set."),
            new Category("ECL reference set operator keywords (ECL)", "Reference Set Operator", "ECL constraint operators keyword family (ECL)",
                    "Selects reference set members, or the reference sets containing given concepts."),
            new Category("ECL description filter keywords (ECL)", "Description Filter", "ECL filters keyword family (ECL)",
                    "Filters on a concept's descriptions (term, language, type, dialect, identifier), "
                    + "with the term search types and the description type and acceptability tokens they "
                    + "compare against."),
            new Category("ECL concept filter keywords (ECL)", "Concept Filter", "ECL filters keyword family (ECL)",
                    "Filters on a concept's own definition status, with the definition status tokens."),
            new Category("ECL component filter keywords (ECL)", "Component Filter", "ECL filters keyword family (ECL)",
                    "Keywords shared by description, concept and member filters: the filter type letters "
                    + "(D, C, M), module, effective time, and active with its boolean values."));

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

        UUID concept = set.uuidFor(fqn);
        UUID fullyQualifiedName = set.uuidFor(fqn + " fully qualified name description");
        UUID regularName = set.uuidFor(fqn + " regular name description");
        UUID definition = set.uuidFor(fqn + " definition description");

        set.concept(fqn, PublicIds.of(concept)).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedName), IkeTerm.ENGLISH_LANGUAGE, fqn, IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(regularName), IkeTerm.ENGLISH_LANGUAGE, category.regularName(), IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(definition), IkeTerm.ENGLISH_LANGUAGE, category.definition(), IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor(fqn + " UUID identifier")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, concept.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor(fqn + " stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef(category.parent())))))
                .semanticOn(PublicIds.of(fullyQualifiedName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor(fqn + " fully qualified name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor(fqn + " regular name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definition), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor(fqn + " definition US dialect")), IkeTerm.PREFERRED)  // dialect pref
                ;
    }
}
