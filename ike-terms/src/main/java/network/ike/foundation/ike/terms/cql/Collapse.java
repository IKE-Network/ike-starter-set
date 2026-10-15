package network.ike.foundation.ike.terms.cql;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelTerm;
import java.util.UUID;

/**
 * The "collapse" section — the CQL keyword {@code collapse} as a concept, filed under List and
 * interval operator keywords (CQL). See {@link CqlSet} for what every section here holds in
 * common.
 *
 * <p>Content is the keyword's own dictionary entry ({@code cql/keyword-dictionary.adoc},
 * {@code [[term-collapse]]}).
 */
final class Collapse {

    private Collapse() {
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
        UUID conceptUUID = set.uuidFor("collapse (CQL)");
        UUID fullyQualifiedNameUUID = set.uuidFor("collapse (CQL) fully qualified name description");
        UUID regularNameUUID = set.uuidFor("collapse (CQL) regular name description");
        UUID definitionUUID = set.uuidFor("collapse (CQL) definition description");

        set.concept("collapse (CQL)", PublicIds.of(conceptUUID)).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedNameUUID), KernelTerm.ENGLISH_LANGUAGE, "collapse (CQL)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(regularNameUUID), KernelTerm.ENGLISH_LANGUAGE, "collapse", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(definitionUUID), KernelTerm.ENGLISH_LANGUAGE,
                        "Merges a list of overlapping or adjacent intervals into the smallest possible"
                        + " set of disjoint intervals.\nExample: collapse \"OverlappingEncounterPeriods\"",
                        KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("collapse (CQL) UUID identifier")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), conceptUUID.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("collapse (CQL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("List and interval operator keywords (CQL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedNameUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("collapse (CQL) fully qualified name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularNameUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("collapse (CQL) regular name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definitionUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("collapse (CQL) definition US dialect")), KernelTerm.PREFERRED)  // dialect pref
                ;

    }
}
