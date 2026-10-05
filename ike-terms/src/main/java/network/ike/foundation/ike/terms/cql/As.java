package network.ike.foundation.ike.terms.cql;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import network.ike.foundation.ike.terms.IkeTerm;
import java.util.UUID;

/**
 * The "as" section — the CQL keyword {@code as} as a concept, filed under Type operator
 * keywords (CQL). See {@link CqlSet} for what every section here holds in common.
 *
 * <p>Content is the keyword's own dictionary entry ({@code cql/keyword-dictionary.adoc},
 * {@code [[term-as]]}).
 */
final class As {

    private As() {
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
        UUID conceptUUID = set.uuidFor("as (CQL)");
        UUID fullyQualifiedNameUUID = set.uuidFor("as (CQL) fully qualified name description");
        UUID regularNameUUID = set.uuidFor("as (CQL) regular name description");
        UUID definitionUUID = set.uuidFor("as (CQL) definition description");

        set.concept("as (CQL)", PublicIds.of(conceptUUID)).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedNameUUID), IkeTerm.ENGLISH_LANGUAGE, "as (CQL)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(regularNameUUID), IkeTerm.ENGLISH_LANGUAGE, "as", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(definitionUUID), IkeTerm.ENGLISH_LANGUAGE,
                        "Casts a value to a specified type at compile time (null at run time if the value"
                        + " isn’t that type); also declares a parameter’s or argument’s type.\nExample:"
                        + " define function \"GetQuantity\"(obs Observation): obs.value as Quantity",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("as (CQL) UUID identifier")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, conceptUUID.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("as (CQL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Type operator keywords (CQL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedNameUUID), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("as (CQL) fully qualified name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularNameUUID), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("as (CQL) regular name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definitionUUID), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("as (CQL) definition US dialect")), IkeTerm.PREFERRED)  // dialect pref
                ;

    }
}
