package network.ike.foundation.ike.terms.cql;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import network.ike.foundation.ike.terms.IkeTerm;
import java.util.UUID;

/**
 * The "implicit" section — the CQL keyword {@code implicit} as a concept, filed under
 * Declaration modifier keywords (CQL). See {@link CqlSet} for what every section here holds in
 * common.
 *
 * <p>Content is the keyword's own dictionary entry ({@code cql/keyword-dictionary.adoc},
 * {@code [[term-implicit]]}).
 */
final class Implicit {

    private Implicit() {
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
        UUID concept = set.uuidFor("implicit (CQL)");
        UUID fullyQualifiedName = set.uuidFor("implicit (CQL) fully qualified name description");
        UUID regularName = set.uuidFor("implicit (CQL) regular name description");
        UUID definition = set.uuidFor("implicit (CQL) definition description");

        set.concept("implicit (CQL)", PublicIds.of(concept)).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedName), IkeTerm.ENGLISH_LANGUAGE, "implicit (CQL)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(regularName), IkeTerm.ENGLISH_LANGUAGE, "implicit", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(definition), IkeTerm.ENGLISH_LANGUAGE,
                        "Marks a defined conversion as one CQL may apply automatically when resolving"
                        + " operators and functions (trial-use in CQL 2.0).\nExample: define implicit"
                        + " conversion from FHIR.Period to Interval<System.DateTime> using"
                        + " FHIRHelpers.ToInterval",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("implicit (CQL) UUID identifier")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, concept.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("implicit (CQL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Declaration modifier keywords (CQL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("implicit (CQL) fully qualified name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("implicit (CQL) regular name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definition), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("implicit (CQL) definition US dialect")), IkeTerm.PREFERRED)  // dialect pref
                ;

    }
}
