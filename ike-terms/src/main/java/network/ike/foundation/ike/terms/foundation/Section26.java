package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/**
 * The "Path" section — a taxonomy subtree of the retrofitted starter set
 * (IKE-Network/ike-issues#869). The origin graph is corrected from the inherited
 * starter data (IKE-Network/ike-issues#911): Primordial is the root (no origin);
 * Development originates from Primordial at Latest, so a Development view inherits
 * every release landed on Primordial; Sandbox forks off Development at Latest for
 * experimentation. Master's inherited Development-at-Latest origin stands until the
 * release model replaces inheritance with per-release promotion
 * (IKE-Network/ike-issues#912).
 */
final class Section26 {

    private Section26() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Path", PublicIds.of(UUID.fromString("4459d8cf-5a6f-3952-9458-6d64324b27b7"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("3641a4d4-d7b6-4248-a7b1-949e7f01b232")), IkeTerm.ENGLISH_LANGUAGE, "Path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("75c9f3bd-1fd8-4a8f-b156-b16f3f74470b")), IkeTerm.ENGLISH_LANGUAGE, "Path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("ff222609-b872-4d94-b6ac-ce102e4f9dbd")), IkeTerm.ENGLISH_LANGUAGE, "A set of assets under version control that can be managed distinctly from other assets. Paths “branch” from other paths when established, and can be “merged” with other paths as well.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("3e1f4ea2-801c-4986-8c7a-da95cd288dda")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "4459d8cf-5a6f-3952-9458-6d64324b27b7")
                .statedAxioms(PublicIds.of(UUID.fromString("ed735908-ada7-543b-b13d-3292d90fee62")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("STAMP dimensions (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("306fc544-16b1-4331-af1e-e8e2c835d56f")))
                .semanticOn(PublicIds.of(UUID.fromString("3641a4d4-d7b6-4248-a7b1-949e7f01b232")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("ecd6003e-8f55-47e0-986a-01a3daf2ceeb")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("75c9f3bd-1fd8-4a8f-b156-b16f3f74470b")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("8a6e1a54-4f39-4735-aa35-9ff80606cb7a")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("ff222609-b872-4d94-b6ac-ce102e4f9dbd")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("26c78714-db1d-4513-838f-3a28cc5f0c38")), IkeTerm.PREFERRED)
                ;

        set.concept("Master path", PublicIds.of(UUID.fromString("1f20134a-960e-11e5-8994-feff819cdc9f"), UUID.fromString("2faa9260-8fb2-11db-b606-0800200c9a66"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b6d5da66-493c-413d-8785-994e4b60e726")), IkeTerm.ENGLISH_LANGUAGE, "Master path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("150339e7-75af-4872-9c88-dbb78b7e1565")), IkeTerm.ENGLISH_LANGUAGE, "Master path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("e2eedff3-06a3-4469-a270-7f3e00b67e62")), IkeTerm.ENGLISH_LANGUAGE, "A default path for components", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("75b27dc0-582b-407e-b9a1-0d7e9d543696")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1f20134a-960e-11e5-8994-feff819cdc9f")
                .statedAxioms(PublicIds.of(UUID.fromString("8860bc79-e8ad-5963-9fe2-eb9305e32eae")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PATH))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e5f77409-fe87-4338-bb83-67ddd58765ae")))
                .semantic(IkeTerm.PATHS_PATTERN, PublicIds.of(UUID.fromString("50cbf2de-11bb-4c71-a5fc-aba9094e4772")))
                .semantic(IkeTerm.PATH_ORIGINS_PATTERN, PublicIds.of(UUID.fromString("0a57884c-6dc5-47e4-9676-9e613d35185d")), IkeTerm.DEVELOPMENT_PATH, Instant.parse("+1000000000-12-31T23:59:59.999999999Z"))
                .semanticOn(PublicIds.of(UUID.fromString("b6d5da66-493c-413d-8785-994e4b60e726")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("58df6d57-e235-4e93-ae8c-5743583e4dfc")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("150339e7-75af-4872-9c88-dbb78b7e1565")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("97df2bc8-c4ab-4590-af1f-c42978f883d7")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("e2eedff3-06a3-4469-a270-7f3e00b67e62")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("9f343cba-d27e-41d3-b750-90b4dcb20fb7")), IkeTerm.PREFERRED)
                ;

        set.concept("Development path", PublicIds.of(UUID.fromString("1f200ca6-960e-11e5-8994-feff819cdc9f"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("333ef58d-125a-42e5-bf65-2d03d6e4e855")), IkeTerm.ENGLISH_LANGUAGE, "Development path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fb302b4f-5636-477e-86c3-1ea2463ff2ae")), IkeTerm.ENGLISH_LANGUAGE, "Development path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("dc7be243-26af-4d7d-8f18-d0846e27d6b1")), IkeTerm.ENGLISH_LANGUAGE, "A path that specifies that the components are currently under development", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("bcbef6fd-aeb7-40bd-ba73-d8e67188b50f")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1f200ca6-960e-11e5-8994-feff819cdc9f")
                .statedAxioms(PublicIds.of(UUID.fromString("ba2e7ff0-4d2a-5f6b-a407-fcc0350cca09")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PATH))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("44af3e12-965c-4a2c-a24e-96938eee080c")))
                .semantic(IkeTerm.PATHS_PATTERN, PublicIds.of(UUID.fromString("7c99f30d-2bd5-408c-b7a8-bbb7e36ecb89")))
                .semantic(IkeTerm.PATH_ORIGINS_PATTERN, PublicIds.of(UUID.fromString("ca7413ed-07be-4180-bdcd-3b3e3d527cfa")), IkeTerm.PRIMORDIAL_PATH, Instant.parse("+1000000000-12-31T23:59:59.999999999Z"))
                .semanticOn(PublicIds.of(UUID.fromString("333ef58d-125a-42e5-bf65-2d03d6e4e855")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b9be3b80-134c-4f74-a212-6121e22104b7")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("fb302b4f-5636-477e-86c3-1ea2463ff2ae")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("7e171b0e-dfc5-4d5e-9ce5-c20a1422a0a1")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("dc7be243-26af-4d7d-8f18-d0846e27d6b1")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("59a8b2fa-0575-4d16-8564-fcc4300579c6")), IkeTerm.PREFERRED)
                ;

        set.concept("Primordial path", PublicIds.of(UUID.fromString("e95b6718-f824-5540-817b-8e79544eb97a"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("c0f148bf-180e-428c-ad9f-9e60c342db94")), IkeTerm.ENGLISH_LANGUAGE, "Primordial path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5ef4d507-d9fc-4d5a-9eff-4e6c715dba06")), IkeTerm.ENGLISH_LANGUAGE, "Primordial path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a72faca5-91ad-43bc-9d0f-900a831ae69a")), IkeTerm.ENGLISH_LANGUAGE, "The root of the path graph: the path from which every other path ultimately originates, and the one no path precedes. Released foundational knowledge lands here, beginning with a knowledge set's inception release, stamped at the Inception instant. Time on this path before inception is pre-inception (historically, premundane).", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("4e9c7067-9dad-4550-8063-ae853e9c5c58")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "e95b6718-f824-5540-817b-8e79544eb97a")
                .statedAxioms(PublicIds.of(UUID.fromString("d516f6dc-8f53-5f1d-b72b-2c0da0271ab2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PATH))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("158b91be-0c52-43e1-aeba-011780fe20f6")))
                .semantic(IkeTerm.PATHS_PATTERN, PublicIds.of(UUID.fromString("81958dfb-4aa6-4e0a-a28b-6da2ba8b76d7")))
                .semanticOn(PublicIds.of(UUID.fromString("c0f148bf-180e-428c-ad9f-9e60c342db94")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("4c0267db-d27d-4d0b-a2f6-546b533a0a5b")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("5ef4d507-d9fc-4d5a-9eff-4e6c715dba06")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f56890f0-1f22-43f0-a16e-f10925f6c0a0")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("a72faca5-91ad-43bc-9d0f-900a831ae69a")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d176719c-6755-42c9-92bf-6e2dad14941f")), IkeTerm.PREFERRED)
                ;

        set.concept("Sandbox path", PublicIds.of(UUID.fromString("80710ea6-983c-5fa0-8908-e479f1f03ea9"))).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("5bf59a7c-2427-4fa4-a7b5-b01157c18d9d")), IkeTerm.ENGLISH_LANGUAGE, "Sandbox path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("7cc385dc-fa1e-435b-88d5-4bc9e3249f92")), IkeTerm.ENGLISH_LANGUAGE, "Sandbox path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("610e9752-498b-4e10-acbd-49da77e51c82")), IkeTerm.ENGLISH_LANGUAGE, "A path for components under testing.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("f72de122-ad39-48db-9dee-44594a88b4d4")), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "80710ea6-983c-5fa0-8908-e479f1f03ea9")
                .statedAxioms(PublicIds.of(UUID.fromString("5537a301-3234-5275-8a07-1ab457695bc2")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PATH))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("bcd053e4-14d7-4519-a101-940a662a5b18")))
                .semantic(IkeTerm.PATHS_PATTERN, PublicIds.of(UUID.fromString("a7d7489b-3c83-4a7d-a832-d0594f7ee90b")))
                .semantic(IkeTerm.PATH_ORIGINS_PATTERN, PublicIds.of(UUID.fromString("fa3d2b4f-98e0-4578-8050-1a7432b4ae85")), IkeTerm.DEVELOPMENT_PATH, Instant.parse("+1000000000-12-31T23:59:59.999999999Z"))
                .semanticOn(PublicIds.of(UUID.fromString("5bf59a7c-2427-4fa4-a7b5-b01157c18d9d")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e41e940a-4695-4be7-bd8b-dbd8d5f6f6ee")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("7cc385dc-fa1e-435b-88d5-4bc9e3249f92")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("2550b6f3-3e09-4972-93f4-d68006164756")), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("610e9752-498b-4e10-acbd-49da77e51c82")), IkeTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e72b798a-c452-4117-b255-caed2c0f8965")), IkeTerm.PREFERRED)
                ;

    }
}
