package network.ike.foundation.ike.terms.cql;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelTerm;
import java.util.UUID;

/**
 * The "xor" section — the CQL keyword {@code xor} as a concept, filed under Logical operator
 * keywords (CQL). See {@link CqlSet} for what every section here holds in common.
 *
 * <p>Content is the keyword's own dictionary entry ({@code cql/keyword-dictionary.adoc},
 * {@code [[term-xor]]}).
 */
final class Xor {

    private Xor() {
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
        UUID concept = set.uuidFor("xor (CQL)");
        UUID fullyQualifiedName = set.uuidFor("xor (CQL) fully qualified name description");
        UUID regularName = set.uuidFor("xor (CQL) regular name description");
        UUID definition = set.uuidFor("xor (CQL) definition description");

        set.concept("xor (CQL)", PublicIds.of(concept)).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedName), KernelTerm.ENGLISH_LANGUAGE, "xor (CQL)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(regularName), KernelTerm.ENGLISH_LANGUAGE, "xor", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(definition), KernelTerm.ENGLISH_LANGUAGE,
                        "Boolean exclusive-or — true only when exactly one operand is true.\nExample:"
                        + " \"IsInpatient\" xor \"IsOutpatient\"",
                        KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("xor (CQL) UUID identifier")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), concept.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("xor (CQL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Logical operator keywords (CQL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedName), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("xor (CQL) fully qualified name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularName), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("xor (CQL) regular name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definition), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("xor (CQL) definition US dialect")), KernelTerm.PREFERRED)  // dialect pref
                ;

    }
}
