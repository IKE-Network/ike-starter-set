package network.ike.foundation.ike.terms.cql;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelTerm;
import java.util.UUID;

/**
 * The "singleton" section — the CQL keyword {@code singleton} as a concept, filed under List
 * and interval operator keywords (CQL). See {@link CqlSet} for what every section here holds
 * in common.
 *
 * <p>Content is the keyword's own dictionary entry ({@code cql/keyword-dictionary.adoc},
 * {@code [[term-singleton]]}).
 */
final class Singleton {

    private Singleton() {
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
        UUID conceptUUID = set.uuidFor("singleton (CQL)");
        UUID fullyQualifiedNameUUID = set.uuidFor("singleton (CQL) fully qualified name description");
        UUID regularNameUUID = set.uuidFor("singleton (CQL) regular name description");
        UUID definitionUUID = set.uuidFor("singleton (CQL) definition description");

        set.concept("singleton (CQL)", PublicIds.of(conceptUUID)).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedNameUUID), KernelTerm.ENGLISH_LANGUAGE, "singleton (CQL)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(regularNameUUID), KernelTerm.ENGLISH_LANGUAGE, "singleton", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(definitionUUID), KernelTerm.ENGLISH_LANGUAGE,
                        "Extracts the single element from a one-element list: ‘singleton from X’ — used"
                        + " for list-to-scalar demotion.\nExample: singleton from [\"Patient\"]",
                        KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("singleton (CQL) UUID identifier")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), conceptUUID.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("singleton (CQL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("List and interval operator keywords (CQL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedNameUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("singleton (CQL) fully qualified name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularNameUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("singleton (CQL) regular name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definitionUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("singleton (CQL) definition US dialect")), KernelTerm.PREFERRED)  // dialect pref
                ;

    }
}
