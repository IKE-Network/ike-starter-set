package network.ike.foundation.ike.terms.ecl;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelTerm;
import java.util.UUID;

/**
 * The "wild" section — the ECL keyword {@code wild} as a concept, filed under
 * ECL description filter keywords (ECL). See {@link EclSet} for what every section here holds in common.
 */
final class Wild {

    private Wild() {
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
        UUID concept = set.uuidFor("wild ECL keyword (ECL)");
        UUID fullyQualifiedName = set.uuidFor("wild ECL keyword (ECL) fully qualified name description");
        UUID regularName = set.uuidFor("wild ECL keyword (ECL) regular name description");
        UUID definition = set.uuidFor("wild ECL keyword (ECL) definition description");

        set.concept("wild ECL keyword (ECL)", PublicIds.of(concept)).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedName), KernelTerm.ENGLISH_LANGUAGE, "wild ECL keyword (ECL)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(regularName), KernelTerm.ENGLISH_LANGUAGE, "wild", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(definition), KernelTerm.ENGLISH_LANGUAGE,
                        "Term search type: the whole term must match a pattern in which * stands for any "
                        + "characters.\nExample: < 64572001 |Disease| {{ term = wild:\"cardi*opathy\" }}",
                        KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("wild ECL keyword (ECL) UUID identifier")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), concept.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("wild ECL keyword (ECL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("ECL description filter keywords (ECL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedName), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("wild ECL keyword (ECL) fully qualified name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularName), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("wild ECL keyword (ECL) regular name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definition), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("wild ECL keyword (ECL) definition US dialect")), KernelTerm.PREFERRED)  // dialect pref
                ;

    }
}
