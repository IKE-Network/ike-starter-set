package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "ImmutableCoordinate properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section3 {

    private Section3() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("ImmutableCoordinate Properties (SOLOR)", PublicIds.of("ab41a788-8a83-5452-8dc0-2d8375e0bfe6")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("62231913-b106-434a-a158-fba8e420d79c"), IkeTerm.ENGLISH_LANGUAGE, "ImmutableCoordinate Properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d98d0918-6a09-49d5-9189-1f7c049e8b20"), IkeTerm.ENGLISH_LANGUAGE, "ImmutableCoordinate properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fc46591a-e6a9-4d60-9968-353311f0e5f9"), IkeTerm.ENGLISH_LANGUAGE, "A set of values or data representing a point in space that one established cannot be changed?", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("81e3fd1f-2aef-435c-8725-7b3c4c01ba97"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ab41a788-8a83-5452-8dc0-2d8375e0bfe6")
                .statedAxioms(PublicIds.of("f94bf621-829c-5b10-987e-0fc45d2eccba"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("64171dfa-d826-4f0a-823e-450768f32c36"))
                .semanticOn(PublicIds.of("62231913-b106-434a-a158-fba8e420d79c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("500b1360-6aff-4b91-bcce-5451b1d44566"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d98d0918-6a09-49d5-9189-1f7c049e8b20"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("01ec688e-f981-4fc9-9dbf-8230955a20f6"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("fc46591a-e6a9-4d60-9968-353311f0e5f9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cdc261fe-fa59-4b3e-814c-2245f3454a7b"), IkeTerm.PREFERRED)
                ;

        set.concept("Modules for stamp coordinate (SOLOR)", PublicIds.of("bf69c4f1-95c9-5956-a10a-d3ba9276c019")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("41ef56d7-02d3-4392-8382-f4a4ba650a3d"), IkeTerm.ENGLISH_LANGUAGE, "Modules for stamp coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7f2ec23a-ac6f-4c2d-81dd-082e49f44b6d"), IkeTerm.ENGLISH_LANGUAGE, "Modules", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("19d1fa35-3e6b-4a0b-a030-3668df021b01"), IkeTerm.ENGLISH_LANGUAGE, "Stamp coordinate modules", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("2fc7ba7b-2b44-4e27-aebe-58bc3fd4d0e5"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "bf69c4f1-95c9-5956-a10a-d3ba9276c019")
                .statedAxioms(PublicIds.of("8825738d-ea53-537a-aee4-8f2996697e4f"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("b11cfea1-5bbd-432a-85c9-c897f3129592"))
                .semanticOn(PublicIds.of("41ef56d7-02d3-4392-8382-f4a4ba650a3d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("2657e578-d4f2-4ff2-be03-2b825df0a3c2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("7f2ec23a-ac6f-4c2d-81dd-082e49f44b6d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ce75e5f5-36ba-4745-b9c1-fecefd88a654"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("19d1fa35-3e6b-4a0b-a030-3668df021b01"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("73ec4c31-1b62-4610-8eb5-99f45c328b9c"), IkeTerm.PREFERRED)
                ;

        set.concept("Language specification for language coordinate (SOLOR)", PublicIds.of("b0ad4d77-e1bc-5fd1-922e-5fad675e9bfd")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d10f90e8-f0dc-4c37-ac88-936152dab722"), IkeTerm.ENGLISH_LANGUAGE, "Language specification for language coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e0ae6ec5-60fd-4a35-9846-cf1a86c3c90d"), IkeTerm.ENGLISH_LANGUAGE, "Language", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("de33982e-2e19-4a39-aeac-d8358efd947b"), IkeTerm.ENGLISH_LANGUAGE, "Language specification for language coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("3f26b616-be17-4b8b-824f-ed782e4d4533"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "b0ad4d77-e1bc-5fd1-922e-5fad675e9bfd")
                .statedAxioms(PublicIds.of("ea5db74e-9402-506a-9a13-3d6207fb59fa"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("656566df-b23d-47c1-94d1-8634e7705972"))
                .semanticOn(PublicIds.of("d10f90e8-f0dc-4c37-ac88-936152dab722"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a5a7db7c-ee78-474b-b132-07262332d8e2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("e0ae6ec5-60fd-4a35-9846-cf1a86c3c90d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ded786f6-80ba-44b0-a7c1-f73a2c56bdb6"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("de33982e-2e19-4a39-aeac-d8358efd947b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("49eadb90-d65d-4cbf-bbbc-5db93b8d28a1"), IkeTerm.PREFERRED)
                ;

        set.concept("Module preference order for stamp coordinate (SOLOR)", PublicIds.of("ddeda759-e89c-5186-aa40-d63070756ab4")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a537ebc6-1ada-4b62-b4f6-276da7eced2c"), IkeTerm.ENGLISH_LANGUAGE, "Module preference order for stamp coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0aa958f9-665b-4046-b8ce-12307c75cb7a"), IkeTerm.ENGLISH_LANGUAGE, "Module order", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c854d995-8099-40a8-899c-7fe91193de04"), IkeTerm.ENGLISH_LANGUAGE, "Module preference order for stamp coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("a1a3b746-1761-4f6e-b968-d5d9fa09bd49"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ddeda759-e89c-5186-aa40-d63070756ab4")
                .statedAxioms(PublicIds.of("4dd2d598-8411-5213-aaf8-5d4e68547f55"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("9ad82f88-73c7-4788-85c2-51a8b1a7d7b5"))
                .semanticOn(PublicIds.of("a537ebc6-1ada-4b62-b4f6-276da7eced2c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7d7d09eb-d327-4f81-bc27-0ce991b71650"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0aa958f9-665b-4046-b8ce-12307c75cb7a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("07f093b0-8eca-4df1-9996-96701cdbd154"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c854d995-8099-40a8-899c-7fe91193de04"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c1ded4a9-8c81-43d9-950f-6050206386cc"), IkeTerm.PREFERRED)
                ;

        set.concept("Module preference list for language coordinate (SOLOR)", PublicIds.of("f36e7ca6-34a2-58b5-8b25-736457515f9c")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fd998a9f-5e89-40b1-8440-089d527f5996"), IkeTerm.ENGLISH_LANGUAGE, "Module preference list for language coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("207383b7-5761-4802-bf6c-d4aac16a7604"), IkeTerm.ENGLISH_LANGUAGE, "Module nids", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f6203935-93ee-4094-a80f-39e04e1a5816"), IkeTerm.ENGLISH_LANGUAGE, "Module preference list for language coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("e54d3b6e-d618-4ad2-b66c-845c2608def6"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f36e7ca6-34a2-58b5-8b25-736457515f9c")
                .statedAxioms(PublicIds.of("ac944da6-6a9f-56f4-aaa4-6df79de17560"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("6c7eb539-b89a-4c2b-b860-b9ed311b5d9a"))
                .semanticOn(PublicIds.of("fd998a9f-5e89-40b1-8440-089d527f5996"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3af1026d-d085-4070-9303-6a9edb7065e0"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("207383b7-5761-4802-bf6c-d4aac16a7604"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f99998ba-2b0d-4239-a23d-98ef83192364"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f6203935-93ee-4094-a80f-39e04e1a5816"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("87ee12bc-ce6a-4060-adce-55d1b3710651"), IkeTerm.PREFERRED)
                ;

        set.concept("Author for edit coordinate (SOLOR)", PublicIds.of("337e93ba-531b-59a4-8153-57dca00e58d2")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9cc5a176-c49e-4a26-9487-c036d359b178"), IkeTerm.ENGLISH_LANGUAGE, "Author for edit coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("04802f9f-13af-4a42-84e6-40ed64dd7f0b"), IkeTerm.ENGLISH_LANGUAGE, "Author", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d0400d9e-2e21-4a1a-867f-9dfe79053e56"), IkeTerm.ENGLISH_LANGUAGE, "Individual or entity who made a particular edit or revision in a document (authoring a specific location or point in the codebase where an edit was made)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("a53ef882-7241-43ac-b315-54f0fc4f8700"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "337e93ba-531b-59a4-8153-57dca00e58d2")
                .statedAxioms(PublicIds.of("01e39a90-05fb-548f-8d30-182c0c630d7a"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8d10f93e-8882-4d7d-8e72-3c114df04d72"))
                .semanticOn(PublicIds.of("9cc5a176-c49e-4a26-9487-c036d359b178"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e09ca7ff-4567-4756-8511-76c34791d845"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("04802f9f-13af-4a42-84e6-40ed64dd7f0b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0532e7ee-491c-4bba-989a-9f1cb8aafa8c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d0400d9e-2e21-4a1a-867f-9dfe79053e56"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e889da12-1d80-4f87-a77e-09f8dc3eb07b"), IkeTerm.PREFERRED)
                ;

        set.concept("Description logic profile for logic coordinate (SOLOR)", PublicIds.of("aef80e34-b2dd-5dca-a989-3e0ee2699be3")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a4cf84e3-9ef9-4313-9b28-e9151e201cd4"), IkeTerm.ENGLISH_LANGUAGE, "Description logic profile for logic coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6cd63bfc-dc6a-4f23-b117-1478f6b48273"), IkeTerm.ENGLISH_LANGUAGE, "Logic profile", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2f7cc64f-81f8-4626-a93f-0157c258b3c0"), IkeTerm.ENGLISH_LANGUAGE, "Description logic profile for logic coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("393b623f-42d5-4ed3-bed0-8220f4aacf26"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "aef80e34-b2dd-5dca-a989-3e0ee2699be3")
                .statedAxioms(PublicIds.of("aed33c92-ded1-506b-9a40-6c93fcc83ce4"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("82a9347c-3e87-486f-b200-3acf48ff5489"))
                .semanticOn(PublicIds.of("a4cf84e3-9ef9-4313-9b28-e9151e201cd4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("04c01c1a-adae-4b95-9998-b4157313112d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6cd63bfc-dc6a-4f23-b117-1478f6b48273"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("59e7fd6b-f056-4989-8e5b-82ab87e7b58c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2f7cc64f-81f8-4626-a93f-0157c258b3c0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1bd793a2-ce4b-4f93-b7f2-f2ea5282d8b7"), IkeTerm.PREFERRED)
                ;

        // Declared FQN and definition diverge from the baseline artifact (was "Stated assemblage for logic coordinate (SOLOR)"):
        // "assemblage" retired from this set's own terminology, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Stated pattern for logic coordinate", PublicIds.of("cfd2a47e-8169-5e71-9122-d5b73efd990a")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2d2997f8-8dc5-4767-ad82-e94ce091582b"), IkeTerm.ENGLISH_LANGUAGE, "Stated pattern for logic coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a6d8c1a3-1bb6-4534-ab22-588f0477c1c1"), IkeTerm.ENGLISH_LANGUAGE, "Stated assemblage", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2dfed1d4-9003-489f-9072-7bfc29f54637"), IkeTerm.ENGLISH_LANGUAGE, "The pattern an author's own stated axioms are recorded under, for a Logic Coordinate.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("ca385e6b-5456-4747-b46b-7810b4b3930d"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "cfd2a47e-8169-5e71-9122-d5b73efd990a")
                .statedAxioms(PublicIds.of("a1aba842-f8a7-54e6-bd8f-57627f3e11dd"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8ceb95eb-b620-4ec3-82b9-d6942d8f758a"))
                .semanticOn(PublicIds.of("2d2997f8-8dc5-4767-ad82-e94ce091582b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6d87f98d-3819-406e-9601-c945e1843fb2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a6d8c1a3-1bb6-4534-ab22-588f0477c1c1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1fced66a-5c11-4369-9408-80994bfdd139"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2dfed1d4-9003-489f-9072-7bfc29f54637"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b8ba5738-c575-4e56-98f1-c65a209d29b4"), IkeTerm.PREFERRED)
                ;

        set.concept("Path options for edit coordinate (SOLOR)", PublicIds.of("2110c10c-9174-55aa-8ffe-91650c77d0b3")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3b905b57-9ed4-452a-b287-bf325ada0811"), IkeTerm.ENGLISH_LANGUAGE, "Path options for edit coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d29107ea-411a-46ce-868d-35f78f47825b"), IkeTerm.ENGLISH_LANGUAGE, "Path options", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a8f3145c-b6c2-4924-96a2-b5bce7a1a03c"), IkeTerm.ENGLISH_LANGUAGE, "Path options for edit coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("a89711aa-8945-4e24-aefe-ac7a1240dc96"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "2110c10c-9174-55aa-8ffe-91650c77d0b3")
                .statedAxioms(PublicIds.of("8165991f-fde9-5685-81e9-437c004c4074"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("e1bf9890-4d8a-49e4-b698-053cebe34469"))
                .semanticOn(PublicIds.of("3b905b57-9ed4-452a-b287-bf325ada0811"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("42979b5f-eb1b-4f41-99f3-1bb0fe12bea1"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d29107ea-411a-46ce-868d-35f78f47825b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f8f41a59-0b77-4918-93f6-1ad0c4f3df24"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a8f3145c-b6c2-4924-96a2-b5bce7a1a03c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4d664d68-c7b9-455e-b196-153877b225b6"), IkeTerm.PREFERRED)
                ;

        set.concept("Classifier for logic coordinate (SOLOR)", PublicIds.of("4b90e89d-2a0e-5ca3-8ae5-7498d148a9d2")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d8c962de-04c3-4a98-988c-7df981bd37d2"), IkeTerm.ENGLISH_LANGUAGE, "Classifier for logic coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4d9cd7c7-d7a9-44f3-a721-859bc72ce51e"), IkeTerm.ENGLISH_LANGUAGE, "Classifier", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("20b76fdc-4641-4ced-bea9-1eb861e9ab38"), IkeTerm.ENGLISH_LANGUAGE, "Classifier for logic coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("99552e8d-0293-4e50-80be-a5036dc826ca"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "4b90e89d-2a0e-5ca3-8ae5-7498d148a9d2")
                .statedAxioms(PublicIds.of("27b81521-4e27-50fd-bea9-7a3b0c1183b3"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("c164059e-ac31-4e28-ae3a-f2fc79d8401a"))
                .semanticOn(PublicIds.of("d8c962de-04c3-4a98-988c-7df981bd37d2"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("161a4746-4506-47ee-927e-ece4fb4890ce"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("4d9cd7c7-d7a9-44f3-a721-859bc72ce51e"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("380028db-a744-4654-a99e-469e4180be72"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("20b76fdc-4641-4ced-bea9-1eb861e9ab38"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e07d2f98-2ef4-4f77-b115-55b2123444d8"), IkeTerm.PREFERRED)
                ;

        set.concept("Allowed states for stamp coordinate (SOLOR)", PublicIds.of("23f69f6f-a502-5876-a835-2b1b4d5ce91e")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b83597eb-1f70-4090-a146-8a915cc2fc4a"), IkeTerm.ENGLISH_LANGUAGE, "Allowed states for stamp coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("73aa4551-82e1-4ec3-8cf9-e2ea22df3ac7"), IkeTerm.ENGLISH_LANGUAGE, "Allowed states", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e3b21dcd-27da-492c-9710-24916dfff9b1"), IkeTerm.ENGLISH_LANGUAGE, "Predefined list of values for STAMP coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("0f4b2ca7-13ca-489c-a30b-419c53c5bc0d"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "23f69f6f-a502-5876-a835-2b1b4d5ce91e")
                .statedAxioms(PublicIds.of("6cff80f0-586f-54c3-ac80-34a3efc592c2"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("2960768f-382e-4d9d-9419-43c8891330a8"))
                .semanticOn(PublicIds.of("b83597eb-1f70-4090-a146-8a915cc2fc4a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("70a09dab-0bb3-49c6-b26d-b6d3c0db5f6f"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("73aa4551-82e1-4ec3-8cf9-e2ea22df3ac7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cfe363e2-e46f-4852-b0af-e34d81045724"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("e3b21dcd-27da-492c-9710-24916dfff9b1"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0eb9e7e1-da1a-4786-8d6a-7a65de175d49"), IkeTerm.PREFERRED)
                ;

        set.concept("Default module for edit coordinate (SOLOR)", PublicIds.of("e83d322c-e275-5392-a5db-1de5fe98acb5")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("75fe4bcd-0703-4f7c-8d52-838087fa7e6f"), IkeTerm.ENGLISH_LANGUAGE, "Default module for edit coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6f105590-31b1-4217-8aae-1e59786816b3"), IkeTerm.ENGLISH_LANGUAGE, "Default module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("c0a9a6ad-0d1f-4c6c-89c2-d79db1e02c13"), IkeTerm.ENGLISH_LANGUAGE, "A value for coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("dbf330b6-4792-403e-81c5-28f50b4b49b5"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "e83d322c-e275-5392-a5db-1de5fe98acb5")
                .statedAxioms(PublicIds.of("2af9a0de-370d-5915-b4bd-697c29b3e129"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("6b7e9576-2c96-4ead-911b-cf16a5326d50"))
                .semanticOn(PublicIds.of("75fe4bcd-0703-4f7c-8d52-838087fa7e6f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1e2e22d0-b415-4072-a742-e3511227b4ee"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6f105590-31b1-4217-8aae-1e59786816b3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fc01dc2f-06b0-41e6-b8bd-694eaa243fed"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("c0a9a6ad-0d1f-4c6c-89c2-d79db1e02c13"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c90cfd6b-7e4d-4bf6-a1d0-3fc95bbc1fb5"), IkeTerm.PREFERRED)
                ;

        set.concept("Vertex state set (SOLOR)", PublicIds.of("347cd3f2-8130-5032-8960-091e194e9afe")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2dbad459-c4ba-4b72-bfad-18438d35344a"), IkeTerm.ENGLISH_LANGUAGE, "Vertex state set (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("da44c9cf-8a55-4ba9-9d80-3c2287b30783"), IkeTerm.ENGLISH_LANGUAGE, "Vertex states", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("90766a0c-0973-48a3-bbc4-2f3a1ff90cff"), IkeTerm.ENGLISH_LANGUAGE, "Vertex states", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("f2073062-9720-4366-b904-53e5834d6649"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "347cd3f2-8130-5032-8960-091e194e9afe")
                .statedAxioms(PublicIds.of("de9f0ff0-6e9e-58bc-81fa-ebf5ecb324da"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("7576dcbb-0f25-44d4-9ea9-cf1e1f2b4cad"))
                .semanticOn(PublicIds.of("2dbad459-c4ba-4b72-bfad-18438d35344a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3cd584bb-3d3d-4df8-bc3d-520e113f4a5d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("da44c9cf-8a55-4ba9-9d80-3c2287b30783"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a9f48942-7525-422a-8fb0-441cb05abfd7"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("90766a0c-0973-48a3-bbc4-2f3a1ff90cff"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ad7ddba1-666c-4c41-8d82-7480aae08cdd"), IkeTerm.PREFERRED)
                ;

        set.concept("Vertex sort (SOLOR)", PublicIds.of("e973f077-a99d-59e6-b7bd-804e87e0e639")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("024fee7c-5163-4db6-a472-dc28efb25e7a"), IkeTerm.ENGLISH_LANGUAGE, "Vertex sort (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("660dcf78-9a6a-4764-9ebd-058815d94a7d"), IkeTerm.ENGLISH_LANGUAGE, "Sort", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b107a6fa-e0aa-41e7-bdf0-6a8f98174e55"), IkeTerm.ENGLISH_LANGUAGE, "Vertex sort", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("6aeabad1-8147-45df-b387-d2cd793c77fc"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "e973f077-a99d-59e6-b7bd-804e87e0e639")
                .statedAxioms(PublicIds.of("96b4872b-9ecd-55a7-a175-a9d2d9c2589d"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("431d2dca-c559-4c10-881e-577fd610ed56"))
                .semanticOn(PublicIds.of("024fee7c-5163-4db6-a472-dc28efb25e7a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("052eb66f-696b-4f3c-8ec1-f5887bd97635"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("660dcf78-9a6a-4764-9ebd-058815d94a7d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0499e8ec-dc84-42d9-be31-f1b2c447f7c2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b107a6fa-e0aa-41e7-bdf0-6a8f98174e55"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("fbb970c3-1310-4778-9563-c2fb8ca4eec1"), IkeTerm.PREFERRED)
                ;

        set.concept("Module preference list for stamp coordinate (SOLOR)", PublicIds.of("f56ef2df-6758-5271-a587-317a4fed6c2e")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d1d00859-07f4-4c6a-8aba-abb94314c570"), IkeTerm.ENGLISH_LANGUAGE, "Module preference list for stamp coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("211f3eef-44fb-43ca-bd8a-4a2d8b274831"), IkeTerm.ENGLISH_LANGUAGE, "Module Preference list", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("985701b3-c38c-485c-a1bd-fc234a47b419"), IkeTerm.ENGLISH_LANGUAGE, "Module preference list for stamp coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("5a69f4b1-469d-4355-8691-7dbeeb1ebf1c"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f56ef2df-6758-5271-a587-317a4fed6c2e")
                .statedAxioms(PublicIds.of("73f500de-8c29-521d-8d4f-0554e37c2dbd"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d9dfc64e-4181-474b-9532-d3668de39980"))
                .semanticOn(PublicIds.of("d1d00859-07f4-4c6a-8aba-abb94314c570"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e26794c5-75b0-45da-b155-aa865229f6a4"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("211f3eef-44fb-43ca-bd8a-4a2d8b274831"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("936fab80-e69a-48ea-b639-5fd0ecb8a377"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("985701b3-c38c-485c-a1bd-fc234a47b419"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7a937ef1-0db2-40f4-9fc5-bb573493a284"), IkeTerm.PREFERRED)
                ;

        set.concept("Module options for edit coordinate (SOLOR)", PublicIds.of("19305aff-95d9-55d9-b015-825cc68eadc7")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ff405627-90ac-4064-a2c3-3429b0785059"), IkeTerm.ENGLISH_LANGUAGE, "Module options for edit coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f0fdf84a-902c-4020-a78f-605582c1a320"), IkeTerm.ENGLISH_LANGUAGE, "Module options", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("726a193a-05dc-4a50-9ef5-93cf5aed7834"), IkeTerm.ENGLISH_LANGUAGE, "Coordinate edit options for Module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("fc192095-d981-4f5d-83a8-b75271101284"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "19305aff-95d9-55d9-b015-825cc68eadc7")
                .statedAxioms(PublicIds.of("cf3f9f92-d5d6-52ac-a6cf-0e1135f29505"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("fd6c6784-409a-4f8d-9a5a-919dcc072276"))
                .semanticOn(PublicIds.of("ff405627-90ac-4064-a2c3-3429b0785059"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bd279617-64f9-4c2e-9754-bf39391bdbcf"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f0fdf84a-902c-4020-a78f-605582c1a320"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("603631dc-25a8-4ae1-92c9-4527e47713ba"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("726a193a-05dc-4a50-9ef5-93cf5aed7834"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ed8ec6ba-db0e-4f7e-b4e1-4f09e77ccd1d"), IkeTerm.PREFERRED)
                ;

        set.concept("Root for logic coordinate (SOLOR)", PublicIds.of("862cc189-bbcb-51a0-89a4-16e1854be247")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e30afb50-16ce-43a9-855d-e89a17365809"), IkeTerm.ENGLISH_LANGUAGE, "Root for logic coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5c7d04f6-3d71-4301-80ee-fe15794f38dc"), IkeTerm.ENGLISH_LANGUAGE, "Root", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("13ae278e-7d3c-4fd0-89d1-6d0b8b2b3275"), IkeTerm.ENGLISH_LANGUAGE, "Logic coordinate root", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("36dbc155-fcd1-4542-b754-53ae26ff9477"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "862cc189-bbcb-51a0-89a4-16e1854be247")
                .statedAxioms(PublicIds.of("d7ed5b92-3b60-55dc-bd8e-3f57807502f9"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("72f5fe84-5092-4ee2-9c48-7b12fd53a8b6"))
                .semanticOn(PublicIds.of("e30afb50-16ce-43a9-855d-e89a17365809"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("45079125-3d4f-4ae4-9ce3-abfbead31d51"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("5c7d04f6-3d71-4301-80ee-fe15794f38dc"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("cae6f1bb-66e2-4331-9523-d4193bac5953"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("13ae278e-7d3c-4fd0-89d1-6d0b8b2b3275"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("307ef920-b794-486a-8ceb-c991e3eee33f"), IkeTerm.PREFERRED)
                ;

        set.concept("Module exclusion set for stamp coordinate (SOLOR)", PublicIds.of("3fe047f0-33b0-5254-91c2-43e65f90d30b")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4eb72bc8-7ed4-4e1f-bfdd-3481cef5afb6"), IkeTerm.ENGLISH_LANGUAGE, "Module exclusion set for stamp coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0ca2ac60-8fd2-48aa-8b6d-1bd160cade3d"), IkeTerm.ENGLISH_LANGUAGE, "Module exclusions", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0a9d9d25-9eab-47dc-9579-d872a52280d7"), IkeTerm.ENGLISH_LANGUAGE, "Module exclusion set for stamp coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("790be0b9-0b50-4aa3-9324-f9e9c24345ae"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "3fe047f0-33b0-5254-91c2-43e65f90d30b")
                .statedAxioms(PublicIds.of("5cff2636-0d42-5b8c-abfc-a54a628327aa"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("c221c046-24c2-4b16-b806-bdc009f46bfd"))
                .semanticOn(PublicIds.of("4eb72bc8-7ed4-4e1f-bfdd-3481cef5afb6"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("bd899480-ea2d-4915-8f60-30ff62209d19"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0ca2ac60-8fd2-48aa-8b6d-1bd160cade3d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("35d043a2-ee96-4116-baed-fe0adb47d1c4"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("0a9d9d25-9eab-47dc-9579-d872a52280d7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("54ced15e-85ac-4d5e-811b-e266d038a858"), IkeTerm.PREFERRED)
                ;

        set.concept("Language nid for language coordinate (SOLOR)", PublicIds.of("38e0c7b8-1e33-56a2-9eb2-ee20c4960684")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("df03abfd-5edf-444e-91da-ef787810b511"), IkeTerm.ENGLISH_LANGUAGE, "Language nid for language coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a3ddfdee-1c60-452f-8ba1-96c66e20ee25"), IkeTerm.ENGLISH_LANGUAGE, "Language nid", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8cc3a5dc-d146-4257-a80c-c38befffb33c"), IkeTerm.ENGLISH_LANGUAGE, "Language nid for language coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("d163c6f0-033c-4557-b915-c96af2271d17"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "38e0c7b8-1e33-56a2-9eb2-ee20c4960684")
                .statedAxioms(PublicIds.of("79ecece5-be1f-556c-a607-d0d8c57b7fec"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("3b6527e5-f1d1-48eb-af60-251ebfd6122a"))
                .semanticOn(PublicIds.of("df03abfd-5edf-444e-91da-ef787810b511"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("9adf7119-f97b-4169-9b3e-9c2c44003349"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a3ddfdee-1c60-452f-8ba1-96c66e20ee25"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0568eb96-afae-4d54-ac8b-11100f8d624d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("8cc3a5dc-d146-4257-a80c-c38befffb33c"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a27bf729-4eeb-4eba-9a03-8f35b65e059d"), IkeTerm.PREFERRED)
                ;

        set.concept("Path for path coordinate (SOLOR)", PublicIds.of("748e073c-fea7-58dd-8aa3-f18fdd82ddfc")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2e8ca061-038c-44a6-9ae8-74c2a62554ff"), IkeTerm.ENGLISH_LANGUAGE, "Path for path coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f99c4cbf-15b8-442e-a1a8-2827f1388467"), IkeTerm.ENGLISH_LANGUAGE, "Path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b14b535b-4f4f-4963-beba-5ee8e8df8e2d"), IkeTerm.ENGLISH_LANGUAGE, "Path for path coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("ce0e2167-a83c-4b2d-853b-59d791da50d8"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "748e073c-fea7-58dd-8aa3-f18fdd82ddfc")
                .statedAxioms(PublicIds.of("e7929851-86c6-5d97-b4c7-01f6a45ebff8"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("4b2b40f4-408e-40dd-b962-0030b8757c67"))
                .semanticOn(PublicIds.of("2e8ca061-038c-44a6-9ae8-74c2a62554ff"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("47243eb5-32ce-4aa1-8cba-b713d6937117"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f99c4cbf-15b8-442e-a1a8-2827f1388467"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b0a038be-bfdb-40dd-9a96-abbd510e223e"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b14b535b-4f4f-4963-beba-5ee8e8df8e2d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("91eb90cc-742a-4d0a-b999-e48ebea9ad44"), IkeTerm.PREFERRED)
                ;

        set.concept("Digraph for logic coordinate (SOLOR)", PublicIds.of("1cdacc80-0dea-580f-a77b-8a6b273eb673")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e77d95b2-d3bc-4f42-a08a-6e348b3a42ea"), IkeTerm.ENGLISH_LANGUAGE, "Digraph for logic coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("300f292d-2600-4b3c-9fda-40e8e9319002"), IkeTerm.ENGLISH_LANGUAGE, "Digraph", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7f260c9e-bc77-4124-943a-f96f983e8018"), IkeTerm.ENGLISH_LANGUAGE, "A value which describes a immutable coordinate property", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("89a0b297-8d7a-4683-b5b9-806e02ad88b2"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "1cdacc80-0dea-580f-a77b-8a6b273eb673")
                .statedAxioms(PublicIds.of("4802ce62-487c-56c5-b241-040a099548a3"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("565502cd-c894-4280-8154-dda09a94c5e3"))
                .semanticOn(PublicIds.of("e77d95b2-d3bc-4f42-a08a-6e348b3a42ea"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("34c16f28-a5fd-4306-b102-13603607a951"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("300f292d-2600-4b3c-9fda-40e8e9319002"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("99d15d75-1d68-4d6d-b7a1-23a35870c767"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("7f260c9e-bc77-4124-943a-f96f983e8018"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("dc1516c5-261b-4f46-b540-4107515b3833"), IkeTerm.PREFERRED)
                ;

        set.concept("Author for stamp coordinate (SOLOR)", PublicIds.of("4fda23b8-b016-5d2a-97d5-7ff779d60701")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2df21965-17d5-4ca2-9427-0bbd97f89f82"), IkeTerm.ENGLISH_LANGUAGE, "Author for stamp coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9b9a9b90-57cf-4526-af58-a05f6e4a2cd7"), IkeTerm.ENGLISH_LANGUAGE, "Authors", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6e69413c-5e65-4a74-ba81-ad89ab68281a"), IkeTerm.ENGLISH_LANGUAGE, "In individual or an entity responsible for defining or updating the values associated with the STAMP coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("5737ef8d-3e98-459f-836c-7fdfe505fb49"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "4fda23b8-b016-5d2a-97d5-7ff779d60701")
                .statedAxioms(PublicIds.of("7a8c27a7-42ac-52aa-8d5b-322ca0278d05"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("1feca24c-80ae-460a-855a-3730db4b1eb8"))
                .semanticOn(PublicIds.of("2df21965-17d5-4ca2-9427-0bbd97f89f82"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("079155dc-d28b-40b0-906e-89467ecac2be"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9b9a9b90-57cf-4526-af58-a05f6e4a2cd7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("162d18b4-91d7-47c6-a3e8-6bb86a26f5f3"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6e69413c-5e65-4a74-ba81-ad89ab68281a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("30c93d88-eb9f-48ac-bacc-92651832996f"), IkeTerm.PREFERRED)
                ;

        // Declared FQN and definition diverge from the baseline artifact (was "Inferred assemblage for logic coordinate (SOLOR)"):
        // "assemblage" retired from this set's own terminology, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Inferred pattern for logic coordinate", PublicIds.of("9ecf4d76-4346-5e5d-8316-bdff48a5c154")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4e5c376b-4a0c-44f1-abf1-27756e4c3b91"), IkeTerm.ENGLISH_LANGUAGE, "Inferred pattern for logic coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5c54a52b-f269-4f60-90fc-540dd5e957f3"), IkeTerm.ENGLISH_LANGUAGE, "Inferred assemblage", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("24282ba0-9334-4d1c-91cf-99ac3e7403ec"), IkeTerm.ENGLISH_LANGUAGE, "The pattern the classifier's derived axioms are written to, for a Logic Coordinate.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("065628f2-9128-44a2-a6f2-28e832a07fb3"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "9ecf4d76-4346-5e5d-8316-bdff48a5c154")
                .statedAxioms(PublicIds.of("671f5796-d60e-5d7c-8c06-a5ea322fb93d"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("b46b536b-d462-436b-9039-4395ff558fe8"))
                .semanticOn(PublicIds.of("4e5c376b-4a0c-44f1-abf1-27756e4c3b91"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("71ce2d1a-8ea8-489f-8e72-0828e7c1f58b"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("5c54a52b-f269-4f60-90fc-540dd5e957f3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d493f75f-985d-46ae-87ec-ea1e9d4f3dfa"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("24282ba0-9334-4d1c-91cf-99ac3e7403ec"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a4e20c4f-54b6-4d99-9d8f-fb83d227e112"), IkeTerm.PREFERRED)
                ;

        set.concept("Description type preference list for language coordinate (SOLOR)", PublicIds.of("44c7eab6-fdb8-5427-9d7a-52ab63f7a6f9")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("131179b4-ce69-4669-962a-68475308b610"), IkeTerm.ENGLISH_LANGUAGE, "Description type preference list for language coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5e053b4a-40fb-4344-a7b7-af648d1961a0"), IkeTerm.ENGLISH_LANGUAGE, "Type order", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a3c1c82c-d690-4cdf-947d-c81971023109"), IkeTerm.ENGLISH_LANGUAGE, "Description type preference list for language coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("e6df80ec-9223-4caa-8565-10f9d183bd51"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "44c7eab6-fdb8-5427-9d7a-52ab63f7a6f9")
                .statedAxioms(PublicIds.of("f1e8e1b6-17fe-558d-a819-47489165d2c4"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("2da05ba7-8cc5-4d6c-89c6-0f34484c5b16"))
                .semanticOn(PublicIds.of("131179b4-ce69-4669-962a-68475308b610"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f26e845f-e8be-464b-b7d7-ae8415dff7cb"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("5e053b4a-40fb-4344-a7b7-af648d1961a0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("9beb6fd8-22ab-4f4c-aa21-687279e65fb5"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a3c1c82c-d690-4cdf-947d-c81971023109"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("52f925d9-ad8c-4888-8d99-d131682f4cb2"), IkeTerm.PREFERRED)
                ;

        set.concept("Position on path (SOLOR)", PublicIds.of("31173582-a49d-51c6-813f-f42d0976aaea")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3f55aeb1-3601-409b-a980-bbdde4c5806b"), IkeTerm.ENGLISH_LANGUAGE, "Position on path (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e521e521-57d8-4c4a-9628-c6bd2882aaa0"), IkeTerm.ENGLISH_LANGUAGE, "Position on path (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("430aaf8f-bc98-4e15-882c-459a20d3f232"), IkeTerm.ENGLISH_LANGUAGE, "Position on path (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("5c37ec04-e8c7-4118-886b-360a8a5d9f54"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "31173582-a49d-51c6-813f-f42d0976aaea")
                .statedAxioms(PublicIds.of("6ac7f61b-14e4-5e62-806d-a18467884e72"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("3b7048fa-d9a5-42ad-9a0f-b2869eee9a7a"))
                .semanticOn(PublicIds.of("3f55aeb1-3601-409b-a980-bbdde4c5806b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a09b31d1-cb8f-4f7c-b5bc-b0105732d860"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("e521e521-57d8-4c4a-9628-c6bd2882aaa0"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("192eea9e-3d84-495c-b867-de10fa07cee2"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("430aaf8f-bc98-4e15-882c-459a20d3f232"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("627cc7aa-5f22-47e0-9144-1bebaf958cff"), IkeTerm.PREFERRED)
                ;

        set.concept("Path origins for stamp path (SOLOR)", PublicIds.of("f33e1668-34dd-53dd-8728-31b29934b482")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("27cee99d-4bfb-4a3d-ad9b-3c6cfe9b34cd"), IkeTerm.ENGLISH_LANGUAGE, "Path origins for stamp path (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a3113185-3eae-4433-853f-364a51ea2db5"), IkeTerm.ENGLISH_LANGUAGE, "Path origins", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("af7153cc-fac6-46b1-80a0-6ddfe828855f"), IkeTerm.ENGLISH_LANGUAGE, "Path origins for stamp path", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("21efb251-1c04-4d93-8260-827cf52a726a"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f33e1668-34dd-53dd-8728-31b29934b482")
                .statedAxioms(PublicIds.of("c77b2116-6951-5b77-a7a6-a878f8ea64a5"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("c8ef4f07-b0d7-4691-beec-6c965bfe8559"))
                .semanticOn(PublicIds.of("27cee99d-4bfb-4a3d-ad9b-3c6cfe9b34cd"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ae71cdcf-78a7-4ee7-82ce-86a86150f467"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a3113185-3eae-4433-853f-364a51ea2db5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ef4a6312-a547-404f-9433-d01dc1cbe08d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("af7153cc-fac6-46b1-80a0-6ddfe828855f"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("18350e3f-36aa-4416-83ad-f9f7b0dd0c47"), IkeTerm.PREFERRED)
                ;

        set.concept("Destination module for edit coordinate (SOLOR)", PublicIds.of("349cfd1d-10fd-5f8d-a0a5-d5ef0932b4da")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("de03bd8f-fd18-4d1e-8ae1-a9535e02fcbe"), IkeTerm.ENGLISH_LANGUAGE, "Destination module for edit coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("45c7f549-f4bd-4f22-b537-9f6028cd0407"), IkeTerm.ENGLISH_LANGUAGE, "Destination module", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("4f31cf3d-b20a-4a0d-9d53-38181dd8aa9a"), IkeTerm.ENGLISH_LANGUAGE, "Destination module for edit coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("a0f6ec6a-4170-47b4-a519-1a9211810ef6"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "349cfd1d-10fd-5f8d-a0a5-d5ef0932b4da")
                .statedAxioms(PublicIds.of("aecfea67-633a-52f6-bf72-f94cabfb7d75"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.IMMUTABLECOORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("9527cf49-cf18-4335-b988-7b87dff9ce85"))
                .semanticOn(PublicIds.of("de03bd8f-fd18-4d1e-8ae1-a9535e02fcbe"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("daff9820-2ae3-4078-968e-a31d0feb5eec"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("45c7f549-f4bd-4f22-b537-9f6028cd0407"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3050b011-33cf-4690-90e5-3c7dfe90de64"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("4f31cf3d-b20a-4a0d-9d53-38181dd8aa9a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("8b7d7e53-49f0-4ad2-aaa7-1d5134c15d24"), IkeTerm.PREFERRED)
                ;

    }
}
