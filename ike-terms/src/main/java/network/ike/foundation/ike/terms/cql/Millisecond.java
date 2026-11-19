package network.ike.foundation.ike.terms.cql;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import network.ike.foundation.ike.terms.IkeTerm;
import java.util.UUID;

/**
 * The "millisecond" section — the CQL keyword {@code millisecond} as a concept, filed under
 * Time-precision unit keywords (CQL). See {@link CqlSet} for what every section here holds in
 * common.
 *
 * <p>Content is the keyword's own dictionary entry ({@code cql/keyword-dictionary.adoc},
 * {@code [[term-millisecond]]}).
 */
final class Millisecond {

    private Millisecond() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        // Derived identities (type-5, from the set's namespace). The description ids are named
        // here because the dialect semantics below attach to those descriptions by identity.
        UUID concept = set.uuidFor("millisecond (CQL)");
        UUID fullyQualifiedName = set.uuidFor("millisecond (CQL) fully qualified name description");
        UUID regularName = set.uuidFor("millisecond (CQL) regular name description");
        UUID definition = set.uuidFor("millisecond (CQL) definition description");

        set.concept("millisecond (CQL)", PublicIds.of(concept)).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedName), IkeTerm.ENGLISH_LANGUAGE, "millisecond (CQL)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(regularName), IkeTerm.ENGLISH_LANGUAGE, "millisecond", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(definition), IkeTerm.ENGLISH_LANGUAGE,
                        "Singular calendar-duration unit of one millisecond — the finest date/time"
                        + " precision.\nExample: \"Timestamp\" + 1 millisecond",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("millisecond (CQL) UUID identifier")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, concept.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("millisecond (CQL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Time-precision unit keywords (CQL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("millisecond (CQL) fully qualified name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("millisecond (CQL) regular name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definition), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("millisecond (CQL) definition US dialect")), IkeTerm.PREFERRED)  // dialect pref
                ;

    }
}
