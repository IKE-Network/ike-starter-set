package network.ike.foundation.ike.terms.ecl;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import network.ike.foundation.ike.terms.IkeTerm;
import java.util.UUID;

/**
 * The "descendantOf" section — the ECL keyword {@code descendantOf} as a concept, filed under
 * ECL hierarchy operator keywords (ECL). See {@link EclSet} for what every section here holds in common.
 */
final class DescendantOf {

    private DescendantOf() {
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
        UUID concept = set.uuidFor("descendantOf ECL keyword (ECL)");
        UUID fullyQualifiedName = set.uuidFor("descendantOf ECL keyword (ECL) fully qualified name description");
        UUID regularName = set.uuidFor("descendantOf ECL keyword (ECL) regular name description");
        UUID definition = set.uuidFor("descendantOf ECL keyword (ECL) definition description");

        set.concept("descendantOf ECL keyword (ECL)", PublicIds.of(concept)).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedName), IkeTerm.ENGLISH_LANGUAGE, "descendantOf ECL keyword (ECL)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(regularName), IkeTerm.ENGLISH_LANGUAGE, "descendantOf", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(definition), IkeTerm.ENGLISH_LANGUAGE,
                        "Selects all descendants of the focus concept, excluding the concept itself (brief "
                        + "syntax <).\nExample: descendantOf 404684003 |Clinical finding|",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("descendantOf ECL keyword (ECL) UUID identifier")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, concept.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("descendantOf ECL keyword (ECL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("ECL hierarchy operator keywords (ECL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("descendantOf ECL keyword (ECL) fully qualified name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularName), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("descendantOf ECL keyword (ECL) regular name US dialect")), IkeTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definition), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("descendantOf ECL keyword (ECL) definition US dialect")), IkeTerm.PREFERRED)  // dialect pref
                ;

    }
}
