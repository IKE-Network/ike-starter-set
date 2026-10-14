package network.ike.foundation.ike.terms.cql;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelTerm;
import java.util.UUID;

/**
 * The "define" section — the CQL keyword {@code define} as a concept, filed under Declaration
 * keywords (CQL). See {@link CqlSet} for what every section here holds in common.
 *
 * <p>Content is the keyword's own dictionary entry ({@code cql/keyword-dictionary.adoc},
 * {@code [[term-define]]}).
 */
final class Define {

    private Define() {
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
        UUID conceptUUID = set.uuidFor("define (CQL)");
        UUID fullyQualifiedNameUUID = set.uuidFor("define (CQL) fully qualified name description");
        UUID regularNameUUID = set.uuidFor("define (CQL) regular name description");
        UUID definitionUUID = set.uuidFor("define (CQL) definition description");

        set.concept("define (CQL)", PublicIds.of(conceptUUID)).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedNameUUID), KernelTerm.ENGLISH_LANGUAGE, "define (CQL)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(regularNameUUID), KernelTerm.ENGLISH_LANGUAGE, "define", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(definitionUUID), KernelTerm.ENGLISH_LANGUAGE,
                        "Introduces a named expression — the basic unit of logic in a CQL"
                        + " library.\nExample: define \"InInitialPopulation\": exists"
                        + " \"QualifyingEncounters\"",
                        KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("define (CQL) UUID identifier")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), conceptUUID.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("define (CQL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Declaration keywords (CQL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedNameUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("define (CQL) fully qualified name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularNameUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("define (CQL) regular name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definitionUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("define (CQL) definition US dialect")), KernelTerm.PREFERRED)  // dialect pref
                ;

    }
}
