/*
 * Copyright © 2026 IKE Network (support@ike.network)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package network.ike.foundation.ike.terms;

import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.language.calculator.LanguageCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The static identity audit (IKE-Network/ike-issues#909): the enduring interop guarantee
 * that consumers holding the Tinkar starter data can merge this set's changeset without
 * duplication — every baseline component's identity survives in the ledger, and every
 * deliberate divergence from the baseline is registered here, in the one durable
 * divergence record.
 * <p>
 * The guarantee is carried by a frozen fixture,
 * {@code src/test/resources/baseline-identity-audit.tsv} — the baseline artifact's
 * publicId → FQN / isA-parent map, generated once by
 * {@link BaselineIdentityFixtureGeneratorIT} — compared against the LEDGER's own
 * declarations ({@code Ike.SET.declarations()}) and the ledger-only replay store. The
 * baseline protobuf artifact itself is never loaded here: it was a one-time input whose
 * value is captured (KEC ruling, 2026-07-19), and it retires to archival provenance.
 * Regenerate the fixture only if the pinned baseline artifact coordinates ever change —
 * see the generator's javadoc for the exact command.
 * <p>
 * One store lifecycle for the whole class (one {@code PrimitiveData} lifecycle per
 * forked JVM): the ledger is replayed once in {@link #replayLedger()} — the same
 * ledger-only construction {@link LedgerReplayTest} uses — solely so FQNs and isA
 * parents can be resolved for comparison; no baseline store, no layering.
 */
class BaselineIdentityAuditIT {

    /**
     * UUIDs of pre-existing components whose declared fully qualified name deliberately
     * diverges from the baseline artifact — each written in place at its section
     * declaration under the inception flatten (IKE-Network/ike-issues#894) — mapped to
     * the expected FQN text. {@link #everyBaselineFqnIsPreservedOrRegisteredAsRenamed()}
     * asserts the ledger renders this text for exactly these identities, instead of the
     * frozen baseline text every other component is held to; {@link ConsumerMergeIT}
     * applies the same exemption to its merged-store drift check. This registry is the
     * durable record of the baseline divergence.
     */
    static final Map<UUID, String> DELIBERATELY_RENAMED_FQNS = Map.ofEntries(
            // foundation.Section3/13/18: retiring "assemblage" from this set's own
            // terminology (IKE-Network/ike-issues#880).
            Map.entry(UUID.fromString("16486419-5d1c-574f-bde6-21910ad66f44"), "Concept pattern for logic coordinate"),
            Map.entry(UUID.fromString("cfd2a47e-8169-5e71-9122-d5b73efd990a"), "Stated pattern for logic coordinate"),
            Map.entry(UUID.fromString("9ecf4d76-4346-5e5d-8316-bdff48a5c154"), "Inferred pattern for logic coordinate"),
            Map.entry(UUID.fromString("c060ffbf-e95f-5960-b296-8a3255c820ac"),
                    "Dialect pattern preference list for language coordinate"),
            // foundation.Section19: dropping misleading "display field" wording from the
            // five ConceptToDataType-confirmed concepts (#880 follow-up).
            Map.entry(UUID.fromString("a46aaf11-b37a-32d6-abdc-707f084ec8f5"), "String data type"),
            Map.entry(UUID.fromString("fb00d132-fcc3-5cbf-881d-4bcc4b4c91b3"), "Component data type"),
            Map.entry(UUID.fromString("ac8f1f54-c7c6-5fc7-b1a8-ebb04b918557"), "Concept data type"),
            Map.entry(UUID.fromString("32f64fc6-5371-11eb-ae93-0242ac130002"), "DiTree data type"),
            Map.entry(UUID.fromString("6efe7087-3e3c-5b45-8109-90d7652b1506"), "Float data type"),
            // foundation.Section19: the seven more "display field" FQNs the Data Type
            // Defaults Pattern's field declarations anchor by UUID (IKE-Network/ike-issues#885).
            Map.entry(UUID.fromString("d6b9e2cc-31c6-5e80-91b7-7537690aae32"), "Boolean data type"),
            Map.entry(UUID.fromString("ff59c300-9c4e-5e77-a35d-6a133eb3440f"), "Integer data type"),
            Map.entry(UUID.fromString("b413fe94-4ada-4aee-96f9-22be19699d40"), "Decimal data type"),
            Map.entry(UUID.fromString("dbdd8df2-aec3-596b-88fc-7b83b5594a45"), "Byte array data type"),
            Map.entry(UUID.fromString("b168ad04-f814-5036-b886-fd4913de88c8"), "Array data type"),
            Map.entry(UUID.fromString("60113dfe-2bad-11eb-adc1-0242ac120002"), "DiGraph data type"),
            Map.entry(UUID.fromString("9c3dfc88-51e4-5e51-a59a-88dd580162b7"), "Semantic data type"),
            // The Component Id pair (KEC-decided): "display list"/"display set" FQNs evaded
            // the textual "display field" rule on grammar, not merit (IKE-Network/ike-issues#885).
            Map.entry(UUID.fromString("e553d3f1-63e1-4292-a3a9-af646fe44292"), "Component Id list data type"),
            Map.entry(UUID.fromString("e283af51-2e8f-44fa-9bf1-89a99a7c7631"), "Component Id set data type"),
            // foundation.Section71: the "Sementic version field pattern" FQN typo fix
            // (IKE-Network/ike-issues#892). A pattern — the fixture covers patterns too,
            // so this entry now gates the rename directly.
            Map.entry(UUID.fromString("82f93e84-cee1-44bc-bb6d-4cc2a722048b"), "Semantic version field pattern"),
            // #922 name-fidelity sweep: EL++ expressions are DiTree-carried (B1, KEC's pick);
            // "nid" is raw-int language that never belongs in a name (C3); a constant-case
            // string is not an FQN (C4).
            Map.entry(UUID.fromString("ee04d7db-3407-568f-9b93-7b1f9f5bb0fc"), "EL++ ditree"),
            Map.entry(UUID.fromString("cd56cceb-8507-5ae5-a928-16079fe6f832"), "Language for description"),
            Map.entry(UUID.fromString("a9ba4749-c11f-5f35-a991-21796fb89ddc"), "Referenced component for semantic"),
            Map.entry(UUID.fromString("845274b5-9644-3799-94c6-e0ea37e7d1a4"), "Universally unique identifier"),
            // #923: the baseline FQN was literally "KOMET user list (SOLOR" — missing its
            // closing paren; renamed plain, dropping the qualifier like prior renames.
            Map.entry(UUID.fromString("5e77558d-97d0-52b6-adf0-d54beb97b3a6"), "KOMET user list")
    );

    /**
     * The pre-existing concepts whose declared stated parent deliberately diverges from
     * the baseline artifact, each mapped to its expected new isA parent's UUID.
     * {@code Dynamic column data types (SOLOR)} filed under the {@code Legacy} branch
     * as a deprecation signal (IKE-Network/ike-issues#880 follow-up, #894); the rest
     * are the taxonomy-organization revision (IKE-Network/ike-issues#915): the four
     * STAMP dimension roots move from the taxonomy root to the STAMP dimensions
     * organizer, the EL++ axiom concepts reorganize under the sealed-LogicalAxiom
     * mirror parents (Logical axiom, Atom, Typed atom, Logical set — collapsing the
     * duplicated EL++ Stated/Inferred multi-parentage and the inverted Role group
     * subtree), Part of moves to the taxonomy-operator vocabulary it belongs to, and
     * the graph concepts (Directed graph, Navigation vertex) move under the new Graph
     * model section.
     * {@link #everyBaselineIsAParentageIsPreservedOrRegisteredAsReparented()} asserts
     * exactly the registered new parent for these identities, instead of the frozen
     * baseline parentage every other component is held to; {@link ConsumerMergeIT}
     * applies the same exemption to its merged-store drift check.
     */
    /** The Meaning role umbrella — see the derivable-divergence note in the parent audit. */
    static final UUID MEANING_UMBRELLA = UUID.fromString("a06158ff-e08a-5d7d-bcfa-6cbfdb138910");
    /** The Purpose role umbrella — see the derivable-divergence note in the parent audit. */
    static final UUID PURPOSE_UMBRELLA = UUID.fromString("c3dffc48-6493-54df-a2f0-14be8ba03091");

    static final Map<UUID, UUID> DELIBERATELY_REPARENTED_ISA = Map.ofEntries(
            // Dynamic column data types -> Legacy model concepts (#880; parent identity
            // re-derived by the #918 birth-FQN rename)
            Map.entry(UUID.fromString("61da7e50-f606-5ba0-a0df-83fd524951e7"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Author -> STAMP dimensions (#915)
            Map.entry(UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c"),
                    UUID.fromString("aea9ca27-3c50-522f-acda-ae881f954603")),
            // Status value -> STAMP dimensions (#915)
            Map.entry(UUID.fromString("10b873e2-8247-5ab5-9dec-4edef37fc219"),
                    UUID.fromString("aea9ca27-3c50-522f-acda-ae881f954603")),
            // Module -> STAMP dimensions (#915)
            Map.entry(UUID.fromString("40d1c869-b509-32f8-b735-836eac577a67"),
                    UUID.fromString("aea9ca27-3c50-522f-acda-ae881f954603")),
            // Path -> STAMP dimensions (#915)
            Map.entry(UUID.fromString("4459d8cf-5a6f-3952-9458-6d64324b27b7"),
                    UUID.fromString("aea9ca27-3c50-522f-acda-ae881f954603")),
            // Necessary set -> Logical set (#915)
            Map.entry(UUID.fromString("acaa2eba-8364-5493-b24c-b3884d34bb60"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // Inclusion set -> Logical set (#915)
            Map.entry(UUID.fromString("def77c09-e1eb-40f2-931a-e7cf2ce0e597"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // Sufficient set -> Logical set (#915)
            Map.entry(UUID.fromString("8aa48cfd-485b-5140-beb9-0d122f7812d9"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // Necessary but not sufficient concept definition -> Logical set (#915)
            Map.entry(UUID.fromString("e1a12059-3b01-3296-9532-d10e49d0afc3"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // Property set Axioms -> Logical set (#915)
            Map.entry(UUID.fromString("ca2fdefd-0481-41cb-8074-41a78f94034d"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // Interval property set -> Logical set (#915)
            Map.entry(UUID.fromString("9afc988a-3724-4754-8b74-651426472b19"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // Implication set -> Logical set (#915)
            Map.entry(UUID.fromString("ee467a5b-9292-4e0a-a165-3b1a359a8c98"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // Data Property Set Axioms -> Logical set (#915)
            Map.entry(UUID.fromString("1402d311-0b4b-4014-81d2-e715c6696346"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // Role group -> Role type (#915)
            Map.entry(UUID.fromString("a63f4bf2-a040-11e5-8994-feff819cdc9f"),
                    UUID.fromString("76320274-be2a-5ba0-b3e8-e6d2e383ee6a")),
            // Role -> Typed atom (#915)
            Map.entry(UUID.fromString("46ae9325-dd24-5008-8fda-80cf1f0977c7"),
                    UUID.fromString("62538a4c-cc26-514a-a3ef-a59c66c2bc42")),
            // Interval role -> Typed atom (#915)
            Map.entry(UUID.fromString("ed9d3506-65ad-48ea-bd01-95474fecdbc4"),
                    UUID.fromString("62538a4c-cc26-514a-a3ef-a59c66c2bc42")),
            // Property sequence implication -> Atom (#915)
            Map.entry(UUID.fromString("9a47a5db-42a6-49ee-9083-54bc305a9456"),
                    UUID.fromString("e9d6a6d4-b509-5852-9ef7-8b4d2e637461")),
            // Connective operator -> Atom (#915)
            Map.entry(UUID.fromString("3fdcaadc-d972-58e9-84f1-b3a39903b076"),
                    UUID.fromString("e9d6a6d4-b509-5852-9ef7-8b4d2e637461")),
            // Concept reference -> Atom (#915)
            Map.entry(UUID.fromString("e89148c7-4fe2-52f8-abb9-6a53605d20cb"),
                    UUID.fromString("e9d6a6d4-b509-5852-9ef7-8b4d2e637461")),
            // Disjoint with -> Atom (#915)
            Map.entry(UUID.fromString("f8433993-9a2d-5377-b564-80a45c7b7824"),
                    UUID.fromString("e9d6a6d4-b509-5852-9ef7-8b4d2e637461")),
            // Part of -> Taxonomy operator (#915)
            Map.entry(UUID.fromString("b4c3f6f9-6937-30fd-8412-d0c77f8a7f73"),
                    UUID.fromString("e9252365-7a43-57ea-bf94-3f23bab4ef99")),
            // Definition root -> Logical axiom (#915)
            Map.entry(UUID.fromString("e7271c01-6ed4-5240-963f-34d1f24153b0"),
                    UUID.fromString("9f622a2f-ed85-57a1-a1b0-c448127fb906")),
            // Navigation vertex -> Vertex (#915)
            Map.entry(UUID.fromString("c7f01834-34ca-5f8b-8f80-193fbeb12eae"),
                    UUID.fromString("2185c628-0fb7-588a-8c39-76be9da2fb95")),
            // Directed graph -> Graph (#915)
            Map.entry(UUID.fromString("47a787a7-bdce-528d-bfcc-fde1add8d599"),
                    UUID.fromString("da454dbd-ed6e-55cf-af5a-0d51b40d7640")),
            // Feature -> Typed atom (#915; the code's Feature axiom meaning,
            // LogicalAxiomSemantic.FEATURE, was baseline-misfiled under Description type)
            Map.entry(UUID.fromString("5e76a88e-794a-5fdd-8eb2-4a9e4b1386b6"),
                    UUID.fromString("62538a4c-cc26-514a-a3ef-a59c66c2bc42")),
            // Property set -> Logical set (#915; also baseline-misfiled under Description type)
            Map.entry(UUID.fromString("e273b5c0-c012-5e53-990c-aec5c2cb33a7"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // Data property set -> Logical set (#915)
            Map.entry(UUID.fromString("6b8ed642-de72-4aee-953d-42e5db92c0ab"),
                    UUID.fromString("70eb421f-2489-5b4f-8699-686487e4593b")),
            // EL++ ditree -> Tree (#922 B1)
            Map.entry(UUID.fromString("ee04d7db-3407-568f-9b93-7b1f9f5bb0fc"),
                    UUID.fromString("5a233bd9-2650-5217-bc3e-5d01a5ad50ce")),
            // Stated navigation -> Navigation (#922 B2; was misfiled under Description type)
            Map.entry(UUID.fromString("614017af-9903-53d9-aab4-15fd02193dce"),
                    UUID.fromString("4d9707d8-adf0-5b15-89fc-039e4ff6fec8")),
            // Inferred navigation -> Navigation (#922 B2)
            Map.entry(UUID.fromString("4bc6c333-7fc9-52f1-942d-f8decba19dc2"),
                    UUID.fromString("4d9707d8-adf0-5b15-89fc-039e4ff6fec8")),
            // Is-a stated navigation -> Legacy (#922 B2; zero code references, dormant twin)
            Map.entry(UUID.fromString("d555dde9-c97e-5480-819a-7472eda3dbfa"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Is-a inferred navigation -> Legacy (#922 B2)
            Map.entry(UUID.fromString("b620768f-1479-5afa-a027-5a9ae6caf0d5"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // SOLOR module -> Module (#922 B3; was misfiled under Description type)
            Map.entry(UUID.fromString("f680c868-f7e5-5d0e-91f2-615eca8f8fd2"),
                    UUID.fromString("40d1c869-b509-32f8-b735-836eac577a67")),
            // SnoRocket classifier -> Author (#922 B4; classifiers author inferred content)
            Map.entry(UUID.fromString("1f201fac-960e-11e5-8994-feff819cdc9f"),
                    UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c")),
            // Concept pattern for logic coordinate -> ImmutableCoordinate Properties (#922 B5)
            Map.entry(UUID.fromString("16486419-5d1c-574f-bde6-21910ad66f44"),
                    UUID.fromString("ab41a788-8a83-5452-8dc0-2d8375e0bfe6")),
            // Unmodeled role concept -> Legacy (#922 B6)
            Map.entry(UUID.fromString("4be7118f-e6ab-5dc7-bcba-b2cc8b028492"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Dynamic referenced component restriction -> Legacy (#922 B6)
            Map.entry(UUID.fromString("0d94ceeb-e24f-5f1a-84b2-1ac35f671db5"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Intrinsic role -> Legacy (#922 B6)
            Map.entry(UUID.fromString("a2d37d2d-ac49-589f-ba36-ac9b8808b00b"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Extended relationship type -> Legacy (#922 B6)
            Map.entry(UUID.fromString("d41d928f-8a97-55c1-aa6c-a289b413fbfd"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Property pattern implication -> Legacy (#922 B6; near-duplicate of the code's
            // Property sequence implication axiom meaning)
            Map.entry(UUID.fromString("e0de0d09-6e27-5738-bc8f-0fc94bb115fc"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Order for axiom attachments -> View coordinate model (#923; a display preference is not an author)
            Map.entry(UUID.fromString("abcb0946-20e1-5483-8469-3e8fa0ce20c4"),
                    UUID.fromString("f83c63a3-6d1d-55bf-a0ab-759079023592")),
            // Order for concept attachments -> View coordinate model (#923)
            Map.entry(UUID.fromString("6167efcb-50e8-534d-9827-fdd60b02ae00"),
                    UUID.fromString("f83c63a3-6d1d-55bf-a0ab-759079023592")),
            // Order for description attachments -> View coordinate model (#923)
            Map.entry(UUID.fromString("69ee3f13-e2ba-5a96-9b91-5eecfad8e587"),
                    UUID.fromString("f83c63a3-6d1d-55bf-a0ab-759079023592")),
            // Module for user -> View coordinate model (#923; a per-user edit default is not an author)
            Map.entry(UUID.fromString("c8fd4f1b-d842-5245-9a7d-a58dc0ac1c11"),
                    UUID.fromString("f83c63a3-6d1d-55bf-a0ab-759079023592")),
            // Path for user -> View coordinate model (#923)
            Map.entry(UUID.fromString("12131382-1535-5a77-928b-6eacad221ea2"),
                    UUID.fromString("f83c63a3-6d1d-55bf-a0ab-759079023592")),
            // KOMET user list -> Editorial model (#923; roster machinery is not an author)
            Map.entry(UUID.fromString("5e77558d-97d0-52b6-adf0-d54beb97b3a6"),
                    UUID.fromString("6dec60bc-67e5-5af7-8228-bb5161feffee")),
            // Starter Data Authoring -> Provenance model (#923; a process marker is not an author)
            Map.entry(UUID.fromString("070deb74-acc5-46bf-b9c6-eaee1b58ef52"),
                    UUID.fromString("a93e37fd-7333-5577-8cba-8cd4a0823612")),
            // Role operator -> Logical expression model (#925; an operator vocabulary is not a role type)
            Map.entry(UUID.fromString("f9860cb8-a7c7-5743-9d7c-ffc6e8a24a0f"),
                    UUID.fromString("048b509b-7446-5adb-a81b-245386981760")),
            // SOLOR overlay module -> Module (#925; the Description-type squatter #922 missed)
            Map.entry(UUID.fromString("9ecc154c-e490-5cf8-805d-d2865d62aef3"),
                    UUID.fromString("40d1c869-b509-32f8-b735-836eac577a67")),
            // Module origins -> Provenance model (#925; module lineage is not a logic-coordinate property)
            Map.entry(UUID.fromString("462862d4-5df9-426e-b785-a1264e24769f"),
                    UUID.fromString("a93e37fd-7333-5577-8cba-8cd4a0823612")),
            // Path origins -> Provenance model (#925; path lineage is version-control machinery, not coordinate configuration)
            Map.entry(UUID.fromString("6e6a112e-7d8c-53c7-aaf1-c46e2d69743c"),
                    UUID.fromString("a93e37fd-7333-5577-8cba-8cd4a0823612")),
            // Uninitialized Component -> Chronicle and version model (#918)
            Map.entry(UUID.fromString("55f74246-0a25-57ac-9473-a788d08fb656"),
                    UUID.fromString("863dfaec-a508-5c9f-a51f-d8691ab38e8b")),
            // Any component -> Chronicle and version model (#918)
            Map.entry(UUID.fromString("927da7ac-3403-5ccc-b07b-88f60cc3a5f8"),
                    UUID.fromString("863dfaec-a508-5c9f-a51f-d8691ab38e8b")),
            // NID -> Identifier model (#918)
            Map.entry(UUID.fromString("d1a17272-9785-51aa-8bde-cc556ab32ebb"),
                    UUID.fromString("ca825cab-4ea6-5ef2-824c-3ca40a98bf72")),
            // Has Active Ingredient -> Role type (#918; migrates to a SNOMED starter set when one exists)
            Map.entry(UUID.fromString("65bf3b7f-c854-36b5-81c3-4915461020a8"),
                    UUID.fromString("76320274-be2a-5ba0-b3e8-e6d2e383ee6a")),
            // Has Dose Form -> Role type (#918; same migration note)
            Map.entry(UUID.fromString("072e7737-e22e-36b5-89d2-4815f0529c63"),
                    UUID.fromString("76320274-be2a-5ba0-b3e8-e6d2e383ee6a")),
            // Laterality -> Role type (#918; same migration note)
            Map.entry(UUID.fromString("26ca4590-bbe5-327c-a40a-ba56dc86996b"),
                    UUID.fromString("76320274-be2a-5ba0-b3e8-e6d2e383ee6a")),
            // Sandbox component -> Legacy model concepts (#918)
            Map.entry(UUID.fromString("c93829b2-aa78-5a84-ac9a-c34307844166"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Sandbox module single-homes under Module (#918; drops the Sandbox component parent)
            Map.entry(UUID.fromString("c5daf0e9-30dc-5b3e-a521-d6e6e72c8a95"),
                    UUID.fromString("40d1c869-b509-32f8-b735-836eac577a67")),
            // Object -> Legacy model concepts (#918; grab bag dissolved)
            Map.entry(UUID.fromString("72765109-6b53-3814-9b05-34ebddd16592"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Object Properties -> Legacy model concepts (#918; grab bag dissolved)
            Map.entry(UUID.fromString("3ef4311c-70c0-5149-9e06-53d745f85b15"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Language coordinate properties -> View coordinate model (#918)
            Map.entry(UUID.fromString("ea1a52f7-0305-5487-8766-e846330f167a"),
                    UUID.fromString("f83c63a3-6d1d-55bf-a0ab-759079023592")),
            // Logic coordinate properties -> View coordinate model (#918)
            Map.entry(UUID.fromString("1fa63819-5ac1-5938-95b1-47871a5f2b17"),
                    UUID.fromString("f83c63a3-6d1d-55bf-a0ab-759079023592")),
            // Path coordinate properties -> View coordinate model (#918)
            Map.entry(UUID.fromString("ec41e427-f009-5e45-a643-6dc658d63d83"),
                    UUID.fromString("f83c63a3-6d1d-55bf-a0ab-759079023592")),
            // ImmutableCoordinate Properties -> View coordinate model (#918)
            Map.entry(UUID.fromString("ab41a788-8a83-5452-8dc0-2d8375e0bfe6"),
                    UUID.fromString("f83c63a3-6d1d-55bf-a0ab-759079023592")),
            // Chronicle properties -> Chronicle and version model (#918)
            Map.entry(UUID.fromString("2ba2ef47-30af-57ec-9073-38693f020d7e"),
                    UUID.fromString("863dfaec-a508-5c9f-a51f-d8691ab38e8b")),
            // Version Properties -> Chronicle and version model (#918)
            Map.entry(UUID.fromString("93f844df-38e5-5167-ba94-2c948b8bd07c"),
                    UUID.fromString("863dfaec-a508-5c9f-a51f-d8691ab38e8b")),
            // Semantic properties -> Chronicle and version model (#918)
            Map.entry(UUID.fromString("b717ae48-5488-5dda-a980-97855001cc99"),
                    UUID.fromString("863dfaec-a508-5c9f-a51f-d8691ab38e8b")),
            // Feature Type -> Logical expression model (#918)
            Map.entry(UUID.fromString("c9120d8b-1acc-5267-9f33-fa716abdb69d"),
                    UUID.fromString("048b509b-7446-5adb-a81b-245386981760")),
            // Reflexive Feature -> Logical expression model (#918)
            Map.entry(UUID.fromString("7e779e4a-61ed-5c4a-aacc-03cf524b7c73"),
                    UUID.fromString("048b509b-7446-5adb-a81b-245386981760")),
            // Transitive Feature -> Logical expression model (#918)
            Map.entry(UUID.fromString("53f866d0-fd61-5c85-a16c-150bd619a0ac"),
                    UUID.fromString("048b509b-7446-5adb-a81b-245386981760")),
            // Property Sequence -> Logical expression model (#918)
            Map.entry(UUID.fromString("d0d759fd-510f-475a-900e-b1439b4536e1"),
                    UUID.fromString("048b509b-7446-5adb-a81b-245386981760")),
            // Annotation property set -> Logical expression model (#918)
            Map.entry(UUID.fromString("cb9e33de-f82c-495d-89fa-69afecbcd47d"),
                    UUID.fromString("048b509b-7446-5adb-a81b-245386981760")),
            // Tree amalgam properties -> Legacy model concepts (#925; ISAAC relic family,
            // zero code references — the #918 Graph-model placement was a category error)
            Map.entry(UUID.fromString("d6151a47-4610-5a5c-abd0-42c82be9b633"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Action properties -> Legacy model concepts (#918; dormant ISAAC relic)
            Map.entry(UUID.fromString("80ba281c-7d47-57cf-8100-82b69bce998b"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Correlation properties -> Legacy model concepts (#918; dormant ISAAC relic)
            Map.entry(UUID.fromString("8f682e00-3d9e-5506-bd19-b2169d6c8752"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Annotation type -> Legacy model concepts (#918; pre-pattern-era classifier)
            Map.entry(UUID.fromString("3fe77951-58c9-51b3-8e7e-65edcf7ace0a"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Komet issue -> Legacy model concepts (#918; dormant)
            Map.entry(UUID.fromString("e1dd7bf2-224d-53a5-a5fb-7b25b05d17a6"),
                    UUID.fromString("7fd61405-6776-52e6-9e4e-3d21dfdf28ad")),
            // Comment -> Editorial model (#918; live as the Comment Pattern field meaning)
            Map.entry(UUID.fromString("147832d4-b9b8-5062-8891-19f9c4e4760a"),
                    UUID.fromString("6dec60bc-67e5-5af7-8228-bb5161feffee")),
            // Creative Commons BY license -> Provenance model (#918)
            Map.entry(UUID.fromString("3415a972-7850-57cd-aa86-a572ca1c2ceb"),
                    UUID.fromString("a93e37fd-7333-5577-8cba-8cd4a0823612")),
            // Meaning umbrella -> Model concept (#918)
            Map.entry(UUID.fromString("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"),
                    UUID.fromString("7bbd4210-381c-11e7-9598-0800200c9a66")),
            // Purpose umbrella -> Model concept (#918)
            Map.entry(UUID.fromString("c3dffc48-6493-54df-a2f0-14be8ba03091"),
                    UUID.fromString("7bbd4210-381c-11e7-9598-0800200c9a66"))
    );

    /**
     * UUIDs of the three upstream placeholder seed semantics on {@code Default Data
     * Concept} — a GB-dialect and a US-dialect semantic whose field value is the
     * {@code Blank Concept} placeholder, and an identifier semantic ("Default Data -
     * Identifier Value") — that the upstream baseline contains but the ledger
     * deliberately does not adopt (pre-bronze editorial: the starter set is pre-release,
     * so erroneous seeds are simply never created; IKE-Network/ike-issues#887). Part of
     * the divergence record this class keeps; the gates live where each store can answer:
     * {@link LedgerGatesIT} asserts the seeds are entirely absent from the ledger-only
     * store, and {@link ConsumerMergeIT} asserts the replay adds no version, no IKE
     * provenance, on top of a consumer's untouched baseline chronologies.
     */
    static final Set<UUID> DELIBERATELY_NOT_ADOPTED_SEMANTIC_UUIDS = Set.of(
            UUID.fromString("17c5b61f-e121-4c54-9eb3-e106f3983417"), // GB dialect seed
            UUID.fromString("8b7b452c-6de1-47b8-81fb-2e4cf58ca213"), // identifier seed
            UUID.fromString("92548331-a460-4bdb-aa32-7162f2fb4f0d")  // US dialect seed
    );

    /** The frozen fixture's classpath location. */
    static final String FIXTURE_RESOURCE = "/baseline-identity-audit.tsv";

    /** The fixture's concept row count — the baseline artifact's concept inventory. */
    private static final int BASELINE_CONCEPT_ROWS = 379;

    /** The fixture's pattern row count — the baseline artifact's pattern inventory. */
    private static final int BASELINE_PATTERN_ROWS = 28;

    /**
     * One frozen baseline component: its kind, identity UUIDs (canonical publicId
     * order), rendered FQN text (empty when the baseline rendered none), latest isA
     * parents (each parent as its own identity UUID set), and whether its raw axiom
     * history was ambiguous (more than one distinct shape — the
     * IKE-Network/ike-issues#875 class, exempt from parentage comparison).
     *
     * @param kind             concept or pattern
     * @param uuids            the component's publicId UUIDs, in canonical order
     * @param fqn              the rendered fully qualified name, or empty
     * @param parents          the latest simple-isA parents' identity UUID sets
     * @param ambiguousHistory whether the raw axiom history spans multiple shapes
     */
    private record FixtureRow(KnowledgeSet.Declaration.Kind kind, List<UUID> uuids, String fqn,
                              List<Set<UUID>> parents, boolean ambiguousHistory) {
    }

    private static StampCalculator calculator;
    private static LanguageCalculator languageCalculator;
    private static List<FixtureRow> fixture;
    private static Map<UUID, KnowledgeSet.Declaration> declarationsByUuid;

    @BeforeAll
    static void replayLedger() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT,
                Files.createTempDirectory("ike-identity-audit").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        // Ledger-only: the real, compiled, committed source — NO baseline artifact.
        new IkeSource().compose().write();
        calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
        languageCalculator = Calculators.Language.UsEnglishFullyQualifiedName(calculator.stampCoordinate());

        fixture = loadFixture();
        declarationsByUuid = new HashMap<>();
        for (KnowledgeSet.Declaration declaration : Ike.SET.declarations()) {
            for (UUID uuid : declaration.publicId().asUuidArray()) {
                declarationsByUuid.put(uuid, declaration);
            }
        }
    }

    @AfterAll
    static void stop() {
        PrimitiveData.stop();
    }

    /**
     * Reads and parses the frozen fixture from the test classpath.
     *
     * @return the fixture rows, in file order
     * @throws Exception if the resource is missing or malformed
     */
    private static List<FixtureRow> loadFixture() throws Exception {
        List<FixtureRow> rows = new ArrayList<>();
        InputStream stream = BaselineIdentityAuditIT.class.getResourceAsStream(FIXTURE_RESOURCE);
        assertNotNull(stream, "frozen fixture " + FIXTURE_RESOURCE + " is missing from the test"
                + " classpath — regenerate it with BaselineIdentityFixtureGeneratorIT");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank() || line.startsWith("#")) {
                    continue;
                }
                String[] fields = line.split("\t", -1);
                assertEquals(5, fields.length, "malformed fixture line: " + line);
                List<UUID> uuids = new ArrayList<>();
                for (String uuid : fields[1].split(",")) {
                    uuids.add(UUID.fromString(uuid));
                }
                List<Set<UUID>> parents = new ArrayList<>();
                if (!fields[3].isEmpty()) {
                    for (String parent : fields[3].split("\\|")) {
                        Set<UUID> parentUuids = new HashSet<>();
                        for (String uuid : parent.split(",")) {
                            parentUuids.add(UUID.fromString(uuid));
                        }
                        parents.add(parentUuids);
                    }
                }
                rows.add(new FixtureRow(KnowledgeSet.Declaration.Kind.valueOf(fields[0]),
                        uuids, fields[2], parents, "ambiguous-history".equals(fields[4])));
            }
        }
        return rows;
    }

    /**
     * The registry value whose key is any of the row's identity UUIDs, or {@code null}.
     *
     * @param <V>      the registry's value type
     * @param registry a divergence registry keyed by identity UUID
     * @param row      the fixture row to look up
     * @return the registered divergence for this row, or {@code null} when unregistered
     */
    private static <V> V registeredDivergence(Map<UUID, V> registry, FixtureRow row) {
        for (UUID uuid : row.uuids()) {
            V value = registry.get(uuid);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    @Test
    @DisplayName("The frozen fixture keeps its generated shape, and every registered divergence"
            + " points at a baseline component it can exempt")
    void fixtureKeepsItsFrozenShape() {
        long conceptRows = fixture.stream()
                .filter(row -> row.kind() == KnowledgeSet.Declaration.Kind.CONCEPT).count();
        long patternRows = fixture.stream()
                .filter(row -> row.kind() == KnowledgeSet.Declaration.Kind.PATTERN).count();
        assertEquals(BASELINE_CONCEPT_ROWS, conceptRows,
                "the fixture freezes the baseline artifact's concept inventory — it changes only"
                        + " when the pinned baseline artifact changes and the generator reruns");
        assertEquals(BASELINE_PATTERN_ROWS, patternRows,
                "the fixture freezes the baseline artifact's pattern inventory — it changes only"
                        + " when the pinned baseline artifact changes and the generator reruns");

        Set<UUID> fixtureUuids = new HashSet<>();
        for (FixtureRow row : fixture) {
            fixtureUuids.addAll(row.uuids());
        }
        for (UUID uuid : DELIBERATELY_RENAMED_FQNS.keySet()) {
            assertTrue(fixtureUuids.contains(uuid),
                    "DELIBERATELY_RENAMED_FQNS entry " + uuid + " matches no baseline component —"
                            + " the divergence record must describe real baseline identities");
        }
        for (UUID uuid : DELIBERATELY_REPARENTED_ISA.keySet()) {
            assertTrue(fixtureUuids.contains(uuid),
                    "DELIBERATELY_REPARENTED_ISA entry " + uuid + " matches no baseline component —"
                            + " the divergence record must describe real baseline identities");
        }
    }

    @Test
    @DisplayName("Every baseline component's identity survives in the ledger's declarations, kind"
            + " intact — a consumer's merge deduplicates on shared UUIDs, so nothing may be minted"
            + " anew and nothing may change kind (IKE-Network/ike-issues#909)")
    void everyBaselineIdentitySurvivesInTheLedger() {
        for (FixtureRow row : fixture) {
            KnowledgeSet.Declaration declaration = null;
            for (UUID uuid : row.uuids()) {
                declaration = declarationsByUuid.get(uuid);
                if (declaration != null) {
                    break;
                }
            }
            assertNotNull(declaration,
                    "baseline " + row.kind().name().toLowerCase() + " \"" + row.fqn() + "\" "
                            + row.uuids() + " has no ledger declaration sharing any of its UUIDs —"
                            + " a consumer's merge would duplicate it");
            assertEquals(row.kind(), declaration.kind(),
                    "baseline component \"" + row.fqn() + "\" " + row.uuids()
                            + " changed kind in the ledger");
        }
    }

    @Test
    @DisplayName("Every baseline component's FQN text is preserved by the ledger — except the"
            + " DELIBERATELY_RENAMED_FQNS registry, which gets its new, expected text")
    void everyBaselineFqnIsPreservedOrRegisteredAsRenamed() {
        for (FixtureRow row : fixture) {
            if (row.fqn().isEmpty()) {
                continue; // the baseline rendered no FQN for this component — nothing to preserve
            }
            String registered = registeredDivergence(DELIBERATELY_RENAMED_FQNS, row);
            String expected = registered != null ? registered : row.fqn();
            String actual = languageCalculator.getFullyQualifiedNameText(nidOf(row))
                    .orElseThrow(() -> new AssertionError(
                            "FQN disappeared in the ledger for baseline component " + row.uuids()));
            assertEquals(expected, actual, "FQN drifted for baseline component " + row.uuids()
                    + " — register a deliberate rename in DELIBERATELY_RENAMED_FQNS, never drift");
        }
    }

    @Test
    @DisplayName("Every baseline component's latest isA parentage is preserved by the ledger —"
            + " except ambiguous-history components (the IKE-Network/ike-issues#875 class, frozen"
            + " in the fixture) and the DELIBERATELY_REPARENTED_ISA registry")
    void everyBaselineIsAParentageIsPreservedOrRegisteredAsReparented() {
        for (FixtureRow row : fixture) {
            if (row.ambiguousHistory()) {
                continue;
            }
            UUID reparented = registeredDivergence(DELIBERATELY_REPARENTED_ISA, row);
            List<Set<UUID>> expected = reparented != null
                    ? List.of(Set.of(reparented))
                    : row.parents();
            // The Meaning/Purpose role umbrellas are a principled, DERIVABLE divergence
            // class, not per-row registry rows (IKE-Network/ike-issues#918): any concept a
            // ledger pattern's latest version declares as a meaning or purpose carries the
            // role umbrella as an additional parent, and LedgerGatesIT's derivability gate
            // holds that assertion to the pattern declarations in both directions. Here the
            // umbrella parents are simply not part of the baseline comparison.
            // (An umbrella that IS the expected baseline parent — the umbrellas' own
            // inherited vocabulary children — is compared normally, not subtracted.)
            List<Set<UUID>> actual = new ArrayList<>();
            for (int parentNid : StoreInspection.latestIsAParents(calculator, nidOf(row))) {
                Set<UUID> parent = Set.of(PrimitiveData.publicId(parentNid).asUuidArray());
                boolean isRoleUmbrella =
                        parent.contains(MEANING_UMBRELLA) || parent.contains(PURPOSE_UMBRELLA);
                boolean expectedHasIt = expected.stream().anyMatch(
                        expectedParent -> expectedParent.stream().anyMatch(parent::contains));
                if (isRoleUmbrella && !expectedHasIt) {
                    continue;
                }
                actual.add(parent);
            }
            assertEquals(expected.size(), actual.size(),
                    "isA parent count drifted for baseline component \"" + row.fqn() + "\" "
                            + row.uuids() + ": expected " + expected + " but the ledger answers "
                            + actual);
            for (Set<UUID> expectedParent : expected) {
                assertTrue(actual.stream().anyMatch(
                                actualParent -> expectedParent.stream().anyMatch(actualParent::contains)),
                        "isA parent " + expectedParent + " of baseline component \"" + row.fqn()
                                + "\" " + row.uuids() + " is missing from the ledger's parentage "
                                + actual + " — register a deliberate reparent in"
                                + " DELIBERATELY_REPARENTED_ISA, never drift");
            }
        }
    }

    /**
     * Resolves a fixture row's nid in the ledger store, through its ledger declaration —
     * never by minting: {@link #everyBaselineIdentitySurvivesInTheLedger()} guarantees
     * the declaration exists.
     *
     * @param row the fixture row to resolve
     * @return the nid of the row's component in the replayed ledger store
     */
    private static int nidOf(FixtureRow row) {
        for (UUID uuid : row.uuids()) {
            KnowledgeSet.Declaration declaration = declarationsByUuid.get(uuid);
            if (declaration != null) {
                return PrimitiveData.nid(declaration.publicId());
            }
        }
        throw new AssertionError("no ledger declaration for baseline component " + row.uuids());
    }
}
