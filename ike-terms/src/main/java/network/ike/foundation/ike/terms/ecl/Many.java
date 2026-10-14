package network.ike.foundation.ike.terms.ecl;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelTerm;
import java.util.UUID;

/**
 * The "many" section — the ECL keyword {@code many} as a concept, filed under
 * ECL logic and refinement keyword family (ECL). See {@link EclSet} for what every section here holds in common.
 */
final class Many {

    private Many() {
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
        UUID conceptUUID = set.uuidFor("many ECL keyword (ECL)");
        UUID fullyQualifiedNameUUID = set.uuidFor("many ECL keyword (ECL) fully qualified name description");
        UUID regularNameUUID = set.uuidFor("many ECL keyword (ECL) regular name description");
        UUID definitionUUID = set.uuidFor("many ECL keyword (ECL) definition description");

        set.concept("many ECL keyword (ECL)", PublicIds.of(conceptUUID)).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(fullyQualifiedNameUUID), KernelTerm.ENGLISH_LANGUAGE, "many ECL keyword (ECL)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)  // FQN
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(regularNameUUID), KernelTerm.ENGLISH_LANGUAGE, "many", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)  // regular name
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(definitionUUID), KernelTerm.ENGLISH_LANGUAGE,
                        "An unbounded maximum cardinality (brief syntax *).\nExample: < 404684003 |Clinical "
                        + "finding|: [1 to many] 363698007 |Finding site| = < 91723000 |Anatomical structure|",
                        KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)  // definition
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(set.uuidFor("many ECL keyword (ECL) UUID identifier")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), conceptUUID.toString())  // UUID identifier
                .statedAxioms(PublicIds.of(set.uuidFor("many ECL keyword (ECL) stated axioms")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("ECL logic and refinement keyword family (ECL)")))))
                .semanticOn(PublicIds.of(fullyQualifiedNameUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("many ECL keyword (ECL) fully qualified name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(regularNameUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("many ECL keyword (ECL) regular name US dialect")), KernelTerm.PREFERRED)  // dialect pref
                .semanticOn(PublicIds.of(definitionUUID), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(set.uuidFor("many ECL keyword (ECL) definition US dialect")), KernelTerm.PREFERRED)  // dialect pref
                ;

    }
}
