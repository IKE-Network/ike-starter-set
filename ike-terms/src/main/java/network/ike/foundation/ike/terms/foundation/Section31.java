package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Version properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section31 {

    private Section31() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Version Properties (SOLOR)", PublicIds.of("93f844df-38e5-5167-ba94-2c948b8bd07c")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5f40e275-bd89-4471-9bfc-ccae8105cdca"), IkeTerm.ENGLISH_LANGUAGE, "Version Properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("91e3d35c-1ce6-4ec9-b77e-3bbba94926b1"), IkeTerm.ENGLISH_LANGUAGE, "Version properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("834597b6-cc91-4b1a-af82-f5f210d92959"), IkeTerm.ENGLISH_LANGUAGE, "What a STAMP pattern semantic means: the five-dimension provenance tuple of a version — status, time, author, module, and path together, as one value; the properties every version carries, rather than any single dimension alone.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("59643315-47c2-4273-9cb1-da0d8819ea3f"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "93f844df-38e5-5167-ba94-2c948b8bd07c")
                .statedAxioms(PublicIds.of("d95584e0-8382-5536-959b-55dd12b05d45"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Chronicle and version model (IkeFoundation)")), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("ed709dcf-45d1-4c13-8ee9-7e1f328e5329"))
                .semanticOn(PublicIds.of("5f40e275-bd89-4471-9bfc-ccae8105cdca"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4f605807-8ce9-4f33-aaa4-85cedce8a8c2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("91e3d35c-1ce6-4ec9-b77e-3bbba94926b1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b64e0500-e8e3-467a-857f-f14f38543552"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("834597b6-cc91-4b1a-af82-f5f210d92959"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("50d7f5f4-6349-4131-8e14-c077a54e5b88"), IkeTerm.PREFERRED)
                ;

        set.concept("Author for version (SOLOR)", PublicIds.of("4eb9de0d-7486-5f18-a9b4-82e3432f4103")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2d2e9992-73c7-4fe2-8f53-7537018bf63f"), IkeTerm.ENGLISH_LANGUAGE, "Author for version (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("af02e5f8-d147-41c3-91aa-80577c5c3222"), IkeTerm.ENGLISH_LANGUAGE, "Author", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b8e7830e-8cb0-4fef-891f-f88487a3fd45"), IkeTerm.ENGLISH_LANGUAGE, "Individual or entity who made a specific set of changes or modifications to a codebase/terminology resulting in the creation of a new version or revision", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("7ec4208c-fe87-4b36-bec1-d793039c95fa"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "4eb9de0d-7486-5f18-a9b4-82e3432f4103")
                .statedAxioms(PublicIds.of("65a484d3-31c0-5451-892f-9b00ad3f98c7"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.VERSION_PROPERTIES), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("2a8e5afa-db59-4eb4-b348-4d63f65c22f2"))
                .semanticOn(PublicIds.of("2d2e9992-73c7-4fe2-8f53-7537018bf63f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7fe4fb60-c0da-49c0-9c2e-6721ab9f0650"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("af02e5f8-d147-41c3-91aa-80577c5c3222"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("9fd6629d-d619-42e7-8201-996ce7356e91"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b8e7830e-8cb0-4fef-891f-f88487a3fd45"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("17ac98f6-ac16-4f87-ac3c-82b413e178a7"), IkeTerm.PREFERRED)
                ;

        set.concept("Status for version (SOLOR)", PublicIds.of("0608e233-d79d-5076-985b-9b1ea4e14b4c")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a758dbf2-0acb-4ff9-9145-bd4600637665"), IkeTerm.ENGLISH_LANGUAGE, "Status for version (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f39f39f2-b296-4891-955e-c8d63f1bfd99"), IkeTerm.ENGLISH_LANGUAGE, "Status for version", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a7e2fdce-fc02-4757-86b3-5b0f07c848ce"), IkeTerm.ENGLISH_LANGUAGE, "Version status?", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("ff45b2e7-2101-4af0-90f3-188503df56ec"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "0608e233-d79d-5076-985b-9b1ea4e14b4c")
                .statedAxioms(PublicIds.of("98b7920b-17b3-54f4-b66b-e61f05dd2ed2"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.VERSION_PROPERTIES), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5d0e5ea2-09b5-4e55-8963-9beef99cba52"))
                .semanticOn(PublicIds.of("a758dbf2-0acb-4ff9-9145-bd4600637665"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1450aaf4-70e7-4a44-99a7-bafffefad8f9"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f39f39f2-b296-4891-955e-c8d63f1bfd99"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c38c29e0-e3f1-4fb8-8b7c-4efcddaa8931"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a7e2fdce-fc02-4757-86b3-5b0f07c848ce"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("292f6ea0-548e-4d91-94a5-85dd7f050bd4"), IkeTerm.PREFERRED)
                ;

        set.concept("Path for version", PublicIds.of("ad3dd2dd-ddb0-584c-bea4-c6d9b91d461f")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a1e93a23-c1a4-42fe-ac2c-70c1432395eb"), IkeTerm.ENGLISH_LANGUAGE, "Path for version", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6e85970f-5550-4f3b-b17b-e88ba05ce3f2"), IkeTerm.ENGLISH_LANGUAGE, "Path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ac05c943-0344-4f6b-9408-1b0938013b38"), IkeTerm.ENGLISH_LANGUAGE, "Version path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("32d2495b-6976-407f-896b-a0b7f3969190"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ad3dd2dd-ddb0-584c-bea4-c6d9b91d461f")
                .statedAxioms(PublicIds.of("2fdff6d2-43d5-58ca-b9b4-e5f1fad67007"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.VERSION_PROPERTIES), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5d2cb438-1493-4d58-a09b-72895d33f932"))
                .semanticOn(PublicIds.of("a1e93a23-c1a4-42fe-ac2c-70c1432395eb"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bc7559da-c972-414b-97e2-5d54d9d15d5c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6e85970f-5550-4f3b-b17b-e88ba05ce3f2"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("17b9c14e-c46c-4cd4-9e0d-4152e11c6e7a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ac05c943-0344-4f6b-9408-1b0938013b38"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("95a13369-2877-449b-b9c4-5a3f6725f255"), IkeTerm.PREFERRED)
                ;

        set.concept("Module for version (SOLOR)", PublicIds.of("67cd64f1-96d7-5110-b847-556c055ac063")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8a39c4d0-be6a-47cc-9fcd-756715f689c7"), IkeTerm.ENGLISH_LANGUAGE, "Module for version (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2c88392f-ad5c-4bd9-990e-9fdfbe98ee45"), IkeTerm.ENGLISH_LANGUAGE, "Module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("29e0c4cf-04bf-4b27-a875-0d9ab04fabba"), IkeTerm.ENGLISH_LANGUAGE, "Module Version", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("23a475be-c964-48c9-a4a3-b797560114f7"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "67cd64f1-96d7-5110-b847-556c055ac063")
                .statedAxioms(PublicIds.of("88cdc29c-8629-57b6-b125-c2cec0a1df61"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.VERSION_PROPERTIES), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("ae650e6b-4b0f-4f6d-94de-730b5f8f473b"))
                .semanticOn(PublicIds.of("8a39c4d0-be6a-47cc-9fcd-756715f689c7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7cda3f88-520f-490b-99e7-784fdddb98f8"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2c88392f-ad5c-4bd9-990e-9fdfbe98ee45"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b431c0cd-9482-49cd-8f35-76676497802e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("29e0c4cf-04bf-4b27-a875-0d9ab04fabba"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("619b6935-e27c-460f-a726-0f1f97df853e"), IkeTerm.PREFERRED)
                ;

        set.concept("Time for version (SOLOR)", PublicIds.of("a9b0dfb2-f463-5dae-8ba8-7f2e8385571b")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("84e7a3f5-9ca6-4e71-8ced-d0bdf2e6b56f"), IkeTerm.ENGLISH_LANGUAGE, "Time for version (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3be4b33b-daca-4029-88e0-b3cbd30d99ce"), IkeTerm.ENGLISH_LANGUAGE, "Time for version", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c7d65416-1aef-4748-b783-c8a58b4a1b2f"), IkeTerm.ENGLISH_LANGUAGE, "Version time", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("c8191310-dbae-4cf0-a60a-b1630723603e"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a9b0dfb2-f463-5dae-8ba8-7f2e8385571b")
                .statedAxioms(PublicIds.of("5531ab29-6f3f-5507-b7e9-9d68549701ca"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.VERSION_PROPERTIES), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("9382595b-15d5-4398-812a-d0976d85e1cf"))
                .semanticOn(PublicIds.of("84e7a3f5-9ca6-4e71-8ced-d0bdf2e6b56f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("05f6b6a0-a3c6-4d46-9ef6-b2d7aaef17dc"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("3be4b33b-daca-4029-88e0-b3cbd30d99ce"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0f3d1a83-6818-4553-8d36-a1c530131eb2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c7d65416-1aef-4748-b783-c8a58b4a1b2f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2dab06bd-88d1-4f8b-a430-28b5c9cb2af6"), IkeTerm.PREFERRED)
                ;

        set.concept("Description version properties (SOLOR)", PublicIds.of("732aad24-4add-59d6-bbc9-840a8b9dc754")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("62b2f919-1e73-4a58-bab4-7f536519cfec"), IkeTerm.ENGLISH_LANGUAGE, "Description version properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5fbe7e0d-7158-48be-bd41-55e178daa1b5"), IkeTerm.ENGLISH_LANGUAGE, "Description version properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("795d3cca-5f94-4fb1-a7bb-b03995617eef"), IkeTerm.ENGLISH_LANGUAGE, "Combination of terms that might be used in a specific context or domain", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("a993615c-1c97-4409-a5bc-1ecc7371d013"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "732aad24-4add-59d6-bbc9-840a8b9dc754")
                .statedAxioms(PublicIds.of("73d00d25-77f3-5ef1-9531-650fa903b15c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.VERSION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("016dfcb8-0293-47f2-ad75-42661f72f64e"))
                .semanticOn(PublicIds.of("62b2f919-1e73-4a58-bab4-7f536519cfec"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4e10eb69-836c-4eb8-80ee-f4e9e8eceb9e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("5fbe7e0d-7158-48be-bd41-55e178daa1b5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e010afb0-ac8b-4bb1-9c3f-2a6f3f1d8cc9"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("795d3cca-5f94-4fb1-a7bb-b03995617eef"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e7b4b739-b398-49b9-a050-2caff5cedee4"), IkeTerm.PREFERRED)
                ;

        set.concept("Description type for description (SOLOR)", PublicIds.of("a00c5ad7-5b8a-5592-a28c-64057dd3caab")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3168d07d-228f-4853-be56-8d6ceddcbcc1"), IkeTerm.ENGLISH_LANGUAGE, "Description type for description (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f9800423-63f7-488f-8e94-b282a56ac0b4"), IkeTerm.ENGLISH_LANGUAGE, "Description type", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("25a94665-5a99-40ae-9b3a-5dcd56f60c7e"), IkeTerm.ENGLISH_LANGUAGE, "Linking for each description -> what type it is", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("30aadd8f-47cf-41ea-8316-e8aeb1357ca2"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a00c5ad7-5b8a-5592-a28c-64057dd3caab")
                .statedAxioms(PublicIds.of("adea6891-6b7c-59d5-9921-3dfc22731c42"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_VERSION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("19123285-8bd7-4bbc-a5f8-4f709904ca4b"))
                .semanticOn(PublicIds.of("3168d07d-228f-4853-be56-8d6ceddcbcc1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("9a718015-9eb5-4b2a-b830-e70aebce4293"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f9800423-63f7-488f-8e94-b282a56ac0b4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("346c3288-0251-4db6-99dc-a44dd082ebb3"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("25a94665-5a99-40ae-9b3a-5dcd56f60c7e"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fa29b5fd-0a93-45ba-841d-acdf41f5396a"), IkeTerm.PREFERRED)
                ;

        set.concept("Description dialect pair (SOLOR)", PublicIds.of("a27bbbf8-57b5-590c-8650-1247f6f963eb")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ccb9cb92-bbf5-408f-9897-197dbaefbb76"), IkeTerm.ENGLISH_LANGUAGE, "Description dialect pair (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7816c418-7db8-4e08-9737-f0d21b6ab6f3"), IkeTerm.ENGLISH_LANGUAGE, "Description dialect pair", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bb2f8d1e-1897-4474-aff1-9e3b196fedf1"), IkeTerm.ENGLISH_LANGUAGE, "Description dialect pair - linking together dialects with language descriptions", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("981177f9-aac8-4c65-9faf-c4c2720f2091"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a27bbbf8-57b5-590c-8650-1247f6f963eb")
                .statedAxioms(PublicIds.of("fe45b3fd-ade8-5b03-ab56-51d580c30a8a"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_VERSION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("f6ab5ed2-3c9b-44ce-a6be-63404a320725"))
                .semanticOn(PublicIds.of("ccb9cb92-bbf5-408f-9897-197dbaefbb76"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4de2b7e9-4601-4c19-9359-d12239b1954a"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("7816c418-7db8-4e08-9737-f0d21b6ab6f3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f70f885f-8c60-423c-a0a3-8777e92f56ae"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("bb2f8d1e-1897-4474-aff1-9e3b196fedf1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f0845db5-1484-46c9-8f83-0006c27c074a"), IkeTerm.PREFERRED)
                ;

        set.concept("Dialect for dialect/description pair (SOLOR)", PublicIds.of("850bc47d-5235-5bce-99f4-c41f8a163d69")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3aee674d-5166-441c-b12a-94e7a5aa2afa"), IkeTerm.ENGLISH_LANGUAGE, "Dialect for dialect/description pair (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5a3f2401-5fae-4888-84a3-59b7c49d8b78"), IkeTerm.ENGLISH_LANGUAGE, "Dialect for dialect/description pair", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("df8f266f-8448-43c7-b207-db1803058f54"), IkeTerm.ENGLISH_LANGUAGE, "Specific dialect", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("7a102829-74ba-42d9-bfbf-bb7efad513c8"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "850bc47d-5235-5bce-99f4-c41f8a163d69")
                .statedAxioms(PublicIds.of("903c8d64-32c5-5c53-92b2-38ab53286e20"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_DIALECT_PAIR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("e701f3db-f1b0-4dd0-830c-7663322be406"))
                .semanticOn(PublicIds.of("3aee674d-5166-441c-b12a-94e7a5aa2afa"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("31a7f3ff-e3ba-419e-8e9a-58bf9c92914e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("5a3f2401-5fae-4888-84a3-59b7c49d8b78"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4dc512e2-0e3a-4d8c-ba06-18edf91885fa"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("df8f266f-8448-43c7-b207-db1803058f54"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4a807910-b710-4ccc-aded-c00fe6759bb1"), IkeTerm.PREFERRED)
                ;

        set.concept("Description for dialect/description pair (SOLOR)", PublicIds.of("1137767a-ad8b-5bc5-9842-a1f9b09d1ecc")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("744f788c-b6a0-4c86-9b22-95243f88b463"), IkeTerm.ENGLISH_LANGUAGE, "Description for dialect/description pair (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b628dfba-ccbe-45ca-ba7a-ca5988237059"), IkeTerm.ENGLISH_LANGUAGE, "Description for dialect/description pair", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("28126a01-91fa-425c-a405-9b3d1a6321aa"), IkeTerm.ENGLISH_LANGUAGE, "Linking together dialects with language descriptions", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("8341ffea-1f9d-4d37-88a7-cfb77546ba61"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1137767a-ad8b-5bc5-9842-a1f9b09d1ecc")
                .statedAxioms(PublicIds.of("30fcf28c-0c5a-5eb7-a828-056ae7fa0e27"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_DIALECT_PAIR))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("004591de-68ac-4c99-ab1c-49852b3e27b1"))
                .semanticOn(PublicIds.of("744f788c-b6a0-4c86-9b22-95243f88b463"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0d6d5283-5bd0-41da-9b6b-b8de2546d9ca"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b628dfba-ccbe-45ca-ba7a-ca5988237059"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("dd1bbdee-c8df-4734-83a9-ff2d354ff946"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("28126a01-91fa-425c-a405-9b3d1a6321aa"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5ca2a614-63c2-484e-9e9d-d0258e0bb3a0"), IkeTerm.PREFERRED)
                ;

        set.concept("Case significance concept nid for description (SOLOR)", PublicIds.of("57271621-3f3c-58dd-8148-2674bc11b7e5")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bf140c7b-c83e-45aa-bc52-a538ef35ffc2"), IkeTerm.ENGLISH_LANGUAGE, "Case significance concept nid for description (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bc31bd56-290c-4c7b-b528-b3674f2b29d8"), IkeTerm.ENGLISH_LANGUAGE, "Case significance", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a19b7be5-3be7-4f2f-ad35-aaedd630aace"), IkeTerm.ENGLISH_LANGUAGE, "A field label which captures the case significance for a given concept description", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("ec615e67-a741-4769-83f2-fb86bd73b294"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "57271621-3f3c-58dd-8148-2674bc11b7e5")
                .statedAxioms(PublicIds.of("cb184da5-d29a-5835-87dc-e459878058bc"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_VERSION_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("7f111be4-19d8-4249-920a-b43572475cbd"))
                .semanticOn(PublicIds.of("bf140c7b-c83e-45aa-bc52-a538ef35ffc2"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5ca9ccb6-053c-49c3-8ff1-c59e205c2ba5"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("bc31bd56-290c-4c7b-b528-b3674f2b29d8"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("abdf4288-b96b-4d60-90b2-e2f54e64fb83"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a19b7be5-3be7-4f2f-ad35-aaedd630aace"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5baf333c-fa6a-4512-acc0-93ce96c0b954"), IkeTerm.PREFERRED)
                ;

        set.concept("Language for description", PublicIds.of("cd56cceb-8507-5ae5-a928-16079fe6f832")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("343a0310-ed60-4031-902a-3d4cbb1e194d"), IkeTerm.ENGLISH_LANGUAGE, "Language for description", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("372e4ea1-62ed-4e33-80e4-9d42a3fcfc9f"), IkeTerm.ENGLISH_LANGUAGE, "Language for description", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("962b4b5b-d2a8-4c19-8020-1cd9180bd047"), IkeTerm.ENGLISH_LANGUAGE, "Captures the language code for a description", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("331b25c6-6e54-4f69-802a-e02c82250e91"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "cd56cceb-8507-5ae5-a928-16079fe6f832")
                .statedAxioms(PublicIds.of("98299aab-3ef8-5b53-9423-0973993d0503"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.DESCRIPTION_VERSION_PROPERTIES), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("04109a62-e312-462b-8b92-1af016fec190"))
                .semanticOn(PublicIds.of("343a0310-ed60-4031-902a-3d4cbb1e194d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("16518eb3-1e8c-4673-9add-3590d5de9956"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("372e4ea1-62ed-4e33-80e4-9d42a3fcfc9f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ae2ddaa3-d30f-46bc-abbc-502654f2ffdf"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("962b4b5b-d2a8-4c19-8020-1cd9180bd047"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("97bc40aa-7f97-4d03-84e9-a845a5905300"), IkeTerm.PREFERRED)
                ;

    }
}
