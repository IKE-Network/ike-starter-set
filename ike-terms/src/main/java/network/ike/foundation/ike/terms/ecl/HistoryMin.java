package network.ike.foundation.ike.terms.ecl;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import network.ike.foundation.ike.terms.IkeTerm;
import java.util.UUID;

/**
 * The "history-min" section — the ECL keyword {@code history-min} as a concept, filed under
 * ECL history keyword family (ECL). See {@link EclSet} for what every section here holds in common.
 */
final class HistoryMin {

    private HistoryMin() {
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
        UUID concept = set.uuidFor("history-min ECL keyword (ECL)");
        UUID fullyQualifiedName = set.uuidFor("history-min ECL keyword (ECL) fully qualified name description");
        UUID regularName = set.uuidFor("history-min ECL keyword (ECL) regular name description");
        UUID definition = set.uuidFor("history-min ECL keyword (ECL) definition description");

        set.concept("history-min ECL keyword (ECL)", PublicIds.of(concept)).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedName), IkeTerm.ENGLISH_LANGUAGE, "history-min ECL keyword (ECL)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(regularName), IkeTerm.ENGLISH_LANGUAGE, "history-min", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(definition), IkeTerm.ENGLISH_LANGUAGE,
                        "History supplement profile that follows only the SAME AS historical "
                        + "association.\nExample: << 195967001 |Asthma| {{ + history-min }}",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("history-min ECL keyword (ECL) UUID identifier")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, concept.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("history-min ECL keyword (ECL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("ECL history keyword family (ECL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("history-min ECL keyword (ECL) fully qualified name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("history-min ECL keyword (ECL) regular name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definition), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("history-min ECL keyword (ECL) definition US dialect")), IkeTerm.PREFERRED)  // dialect pref
                ;

    }
}
