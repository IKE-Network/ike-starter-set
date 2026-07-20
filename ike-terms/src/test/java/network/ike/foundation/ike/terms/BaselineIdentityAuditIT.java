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
            Map.entry(UUID.fromString("82f93e84-cee1-44bc-bb6d-4cc2a722048b"), "Semantic version field pattern")
    );

    /**
     * UUID of the one pre-existing concept whose declared stated parent deliberately
     * diverges from the baseline artifact — {@code Dynamic column data types (SOLOR)},
     * filed under the new {@code Legacy} branch as a deprecation signal at its section
     * declaration ({@code foundation.Section41}, IKE-Network/ike-issues#880 follow-up,
     * #894) — mapped to its expected isA parent's own UUID.
     * {@link #everyBaselineIsAParentageIsPreservedOrRegisteredAsReparented()} asserts
     * this single new parent for exactly this identity, instead of the frozen baseline
     * parentage every other component is held to; {@link ConsumerMergeIT} applies the
     * same exemption to its merged-store drift check.
     */
    static final Map<UUID, UUID> DELIBERATELY_REPARENTED_ISA = Map.of(
            UUID.fromString("61da7e50-f606-5ba0-a0df-83fd524951e7"), // Dynamic column data types (SOLOR)
            UUID.fromString("e06c87d2-0831-5548-b5c1-24dc0501a7de")  // Legacy (IkeFoundation)
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
            List<Set<UUID>> actual = new ArrayList<>();
            for (int parentNid : StoreInspection.latestIsAParents(calculator, nidOf(row))) {
                actual.add(Set.of(PrimitiveData.publicId(parentNid).asUuidArray()));
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
