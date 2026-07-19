package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Tree amalgam properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section47 {

    private Section47() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Tree amalgam properties (SOLOR)", PublicIds.of(UUID.fromString("d6151a47-4610-5a5c-abd0-42c82be9b633"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("bd734afa-e892-4e80-83eb-871e8dc3007b")), IkeTerm.ENGLISH_LANGUAGE, "Tree amalgam properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2db53a64-94af-4249-b34e-d384e50c8a69")), IkeTerm.ENGLISH_LANGUAGE, "Tree amalgam properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3d975372-6d96-4665-92e7-0abbda229104")), IkeTerm.ENGLISH_LANGUAGE, "Data structure that consists of nodes connected by edges (a mixture or blend of different elements)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("641939e5-9e62-462c-aea0-2b5ded2feada")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "d6151a47-4610-5a5c-abd0-42c82be9b633")
                .statedAxioms(PublicIds.of(UUID.fromString("3114faa0-2e1b-572b-83b3-d02ce25d6000")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("5c8aab7d-b5b7-443c-97a5-c4b802a20a3b")))
                .semanticOn(PublicIds.of(UUID.fromString("bd734afa-e892-4e80-83eb-871e8dc3007b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("47099522-a380-485a-ab58-824352f43df3")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2db53a64-94af-4249-b34e-d384e50c8a69")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3c733170-0ba5-47af-a0df-89385a29dad6")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("3d975372-6d96-4665-92e7-0abbda229104")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4b0efb1c-6225-465c-981a-953c2e76585e")), IkeTerm.PREFERRED)
                ;

        set.concept("Inverse tree list (SOLOR)", PublicIds.of(UUID.fromString("45167fb6-e01d-53a8-8be3-768aae18729d"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("53b3d51a-7cbc-47d7-82db-0157695b5642")), IkeTerm.ENGLISH_LANGUAGE, "Inverse tree list (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("da3a1aa0-0bf7-4e78-952d-6e31c7663929")), IkeTerm.ENGLISH_LANGUAGE, "Inverse tree list", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("4d139629-3de6-496e-9dbe-6cf8d2fa9300")), IkeTerm.ENGLISH_LANGUAGE, "Inverse tree list", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("c577dc08-684f-4bb3-a35b-e99095fe8e5f")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "45167fb6-e01d-53a8-8be3-768aae18729d")
                .statedAxioms(PublicIds.of(UUID.fromString("94447fb7-baa3-51fd-a495-1d05ae3b0583")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TREE_AMALGAM_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("406ad4b1-4a0d-437c-9162-4a7d4337810f")))
                .semanticOn(PublicIds.of(UUID.fromString("53b3d51a-7cbc-47d7-82db-0157695b5642")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e493b15d-8ee6-4b72-9578-617b964b20d0")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("da3a1aa0-0bf7-4e78-952d-6e31c7663929")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ebbcfe9c-cbd5-430b-bfa6-6846daad02bc")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("4d139629-3de6-496e-9dbe-6cf8d2fa9300")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3aba843f-3590-4f3f-a502-e8dfd0f066e7")), IkeTerm.PREFERRED)
                ;

        set.concept("Tree list (SOLOR)", PublicIds.of(UUID.fromString("c11dd7a1-0ba1-5378-81d6-3efdba1e074b"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7d1475f7-3ad3-4bb3-886a-873600c56afe")), IkeTerm.ENGLISH_LANGUAGE, "Tree list (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("d5a0fdbd-2592-47e1-afe2-4cabafbac239")), IkeTerm.ENGLISH_LANGUAGE, "Tree list", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2101fa61-d6c9-4bb8-a3e6-45385234da64")), IkeTerm.ENGLISH_LANGUAGE, "List - Tree", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4a72b49a-a39f-4b2c-8249-35c01df67475")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c11dd7a1-0ba1-5378-81d6-3efdba1e074b")
                .statedAxioms(PublicIds.of(UUID.fromString("61ad6a00-8451-5db4-8eed-5a3d7ce4ebd3")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TREE_AMALGAM_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("c29830b9-9f6c-4e11-9a1e-21fa3632f91f")))
                .semanticOn(PublicIds.of(UUID.fromString("7d1475f7-3ad3-4bb3-886a-873600c56afe")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3851a5f0-f633-4db0-9ea4-9c2042e82f29")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("d5a0fdbd-2592-47e1-afe2-4cabafbac239")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0caac04b-8102-4fdb-ab63-4d0aa409e269")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2101fa61-d6c9-4bb8-a3e6-45385234da64")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2e80d84e-8549-4e2b-832d-32fce127b55b")), IkeTerm.PREFERRED)
                ;

    }
}
