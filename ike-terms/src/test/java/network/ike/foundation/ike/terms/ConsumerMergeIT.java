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
import dev.ikm.tinkar.common.service.EntityCountSummary;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.common.id.IntIds;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.language.calculator.LanguageCalculator;
import dev.ikm.tinkar.coordinate.stamp.StampCoordinateRecord;
import dev.ikm.tinkar.coordinate.stamp.StampPositionRecord;
import dev.ikm.tinkar.coordinate.stamp.StateSet;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculatorWithCache;
import dev.ikm.tinkar.terms.TinkarTerm;
import dev.ikm.tinkar.entity.EntityHandle;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.aggregator.TemporalEntityAggregator;
import dev.ikm.tinkar.entity.export.ExportEntitiesToProtobufFile;
import dev.ikm.tinkar.entity.load.LoadEntitiesFromProtobufFile;
import dev.ikm.tinkar.terms.EntityProxy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Models the in-the-field merge (IKE-Network/ike-issues#909): a consumer store already
 * holding the Tinkar starter-data baseline artifact loads this set's changeset — the
 * baseline protobuf is loaded first, then the committed {@link IkeSource} replays on
 * top, exactly the layering a consumer's store performs. The gates here verify the merge
 * EXPERIENCE: identity-exact merging (no unexpected new components), exactly one new
 * version per pre-existing chronology, no drift in what the merged store renders for
 * FQNs and isA parentage beyond the registered divergences, no adoption of the
 * deliberately-not-adopted upstream seeds, and a reconciling export. It is also the
 * honest home of the IKE-Network/ike-issues#875 accounting: components whose baseline
 * axiom history is ambiguous answer "latest" differently under layered resolution, and
 * only a layered store can observe that.
 * <p>
 * This class is NOT a content gate — {@link LedgerGatesIT} holds the ledger's own
 * content, ledger-only and baseline-free, and {@link BaselineIdentityAuditIT} carries
 * the enduring identity-compatibility guarantee against a frozen fixture. Run this
 * suite at release-gate cadence, when the consumer merge experience is the question.
 * Descends from the retired {@code FoundationFidelityIT} round-trip scaffold
 * (IKE-Network/ike-issues#872): the Tinkar starter data was a one-time input whose
 * transcription audit is complete (KEC ruling, 2026-07-19), so the fidelity framing
 * retired; the merge framing remains. The scaffold's replay-introduced-stamp diff
 * retired with it, subsumed by {@link LedgerGatesIT}'s stronger whole-inventory
 * stamp-pair gate: replay writes only what the ledger carries, so a ledger store whose
 * entire stamp set is the inception pair cannot introduce any other stamp here
 * (IKE-Network/ike-issues#894).
 * <p>
 * One store lifecycle for the whole class (a second {@code PrimitiveData} lifecycle
 * cannot start once the first stops within a JVM): the baseline is loaded and
 * snapshotted once in {@link #loadAndSnapshot()}, then every {@code @Test} method
 * inspects that same already-replayed store.
 */
class ConsumerMergeIT {

    private static StampCalculator calculator;
    private static LanguageCalculator languageCalculator;
    private static final Map<Integer, String> FQN_BEFORE = new HashMap<>();
    private static final Map<Integer, Set<Integer>> IS_A_PARENTS_BEFORE = new HashMap<>();
    private static final Map<Integer, Integer> VERSION_COUNT_BEFORE = new HashMap<>();
    private static int conceptsBefore;
    private static int patternsBefore;

    /** New concepts the identity-exact ingest itself mints: the module, the root, IKE Community. */
    static final int INGEST_BOOTSTRAP_CONCEPTS = 3;
    /**
     * New concepts {@code ConstraintPatternSet} (30 — see below),
     * {@code PatternShapeRefinementSet} (2 for Comment pattern + 23 for the
     * remaining 16 revised patterns + 7 for the IKE-Network/ike-issues#891
     * Model-Feature pointer fixes = 32 — the #891 fixes mint Originated Module,
     * Origin Module Set, Originated Path, Branch Source, Branch Point, Identified
     * Component, Axiomatized Component, and Axiom Expression (+8) while Origin
     * Subject — whose definition misdescribed the origin-path field as naming the
     * record's subject — is never created (−1)), {@code AssemblageTerminologySet} (1 — Set
     * membership), and {@code LegacyTerminologySet} (1 — Legacy) deliberately author, all
     * IKE-Network/ike-issues#880 (meaning/purpose rigor across the pattern-shape audit,
     * retiring "assemblage" from this set's own terminology, then flagging dormant/
     * superseded content as Legacy); plus {@code DefaultsAndTemplatesSet} (3 — Default
     * value concept, Template concept, Defaults and templates module,
     * IKE-Network/ike-issues#885); plus {@code DataTypeDefaultsSet} (19 — sixteen field
     * meaning concepts, one shared field purpose, and the Data Type Defaults Pattern's
     * own meaning and purpose, IKE-Network/ike-issues#885).
     * <p>
     * {@code ConstraintPatternSet}'s 30 was 29 before the IKE-Network/ike-issues#890
     * one-pattern-per-parameter-shape refactor: under the pre-bronze never-created
     * doctrine, the "Field constraint kind" umbrella is replaced by "Taxonomy field
     * constraint kind" (count-neutral rename-as-new-identity), the "Value-set field
     * constraint" kind concept and the "Concept field constraint" mechanism concept are
     * never created (−2 — value-set membership is now a pattern shape, not a kind, and
     * the mechanism concept's narrative moved to Constrained Pattern), and the member
     * match relation seam mints "Member match relation", "Equal match relation", and the
     * "Match Rule" field purpose (+3).
     * <p>
     * Plus {@code ModelOrganizationSet} (21: 20 from IKE-Network/ike-issues#915, plus
     * the View coordinate model organizer the IKE-Network/ike-issues#918 root
     * refinement mints when Object Properties dissolves — the
     * taxonomy-organization revision): the root-level STAMP dimensions organizer, the
     * nine Model-concept subsystem organizers (Chronicle and version, Description,
     * Identifier, Provenance, Logical expression, Graph, Constraint, Defaults and
     * templates, Editorial), the four sealed-LogicalAxiom mirror parents (Logical
     * axiom, Atom, Typed atom, Logical set — Feature needs no minting: the code's own
     * Feature meaning is the historic concept, reorganized under Typed atom), and the
     * six graph-representation concepts (Graph, Tree, Vertex, Edge, Vertex meaning,
     * Vertex property).
     * <p>
     * {@link LedgerGatesIT#LEDGER_CONCEPTS} pins the same content absolutely — grow the
     * two in the same change.
     */
    static final int AUTHORED_CONTENT_CONCEPTS = 107;
    /**
     * New patterns {@code ConstraintPatternSet} (4, IKE-Network/ike-issues#880 as
     * refactored by IKE-Network/ike-issues#890 — the never-created Concept Field
     * Constraint Pattern's union-by-sentinel shape is split into the Taxonomy Field
     * Constraint Pattern and the Value-set Field Constraint Pattern, one per parameter
     * shape, alongside the Starter Set Author Roster and Preferred Reviewer worked
     * examples), {@code AssemblageTerminologySet} (1 — Solor Concepts Pattern, the
     * IKE-native replacement for the dormant SOLORConceptAssemblage), and
     * {@code DataTypeDefaultsSet} (1 — Data Type Defaults Pattern,
     * IKE-Network/ike-issues#885) deliberately author.
     * {@link LedgerGatesIT#LEDGER_PATTERNS} pins the same content absolutely.
     */
    static final int AUTHORED_CONTENT_PATTERNS = 6;

    /**
     * Components whose stated-axiom semantic's own historical versions resolve to more
     * than one distinct (simpleIsA, parents) shape — detected directly from the raw
     * version history (bypassing calculator "latest" resolution), before replay.
     * Excluded from {@link #isAParentsUnchanged()}: for exactly these components,
     * {@code Calculators.Stamp.DevelopmentLatestActiveOnly()}'s "latest" resolution is
     * observed to answer differently before vs. after replay, even though replay adds
     * no new version to their axiom semantic (confirmed empirically — same version
     * count before and after). Stamp-census facts (probed IKE-Network/ike-issues#911):
     * the baseline's stamps are mixed-path — Primordial path AND Development path,
     * every time in July–August 2025, all before {@code PrimitiveData.INCEPTION_EPOCH}
     * — so layered "latest" for a component whose own history spans more than one
     * shape is genuinely coordinate-sensitive. This is a calculator/path-coordinate
     * characteristic, not a defect in the #869 generator — nothing was silently
     * generated wrong (no manifest note was dropped for these components; their axiom
     * semantics gained no new version). Logged, not silently dropped; tracked as
     * IKE-Network/ike-issues#875 for deeper investigation rather than fixed here. The
     * same components carry the {@code ambiguous-history} flag in
     * {@link BaselineIdentityAuditIT}'s frozen fixture.
     */
    private static final Set<Integer> HISTORICALLY_AMBIGUOUS_AXIOM_NIDS = new HashSet<>();

    /**
     * {@link BaselineIdentityAuditIT#DELIBERATELY_RENAMED_FQNS} — the durable divergence
     * record — resolved to this store's nids in {@link #loadAndSnapshot()}.
     * {@link #fqnTextUnchanged()} asserts the registered text for exactly these nids,
     * instead of the pre-replay snapshot every other component is held to.
     */
    private static final Map<Integer, String> DELIBERATELY_RENAMED_FQNS_BY_NID = new HashMap<>();

    /**
     * The renamed components whose rename the merged store's <em>Development</em> view
     * does NOT show — pinned exactly, so a change in either direction fails loudly.
     * <p>
     * Since the ledger stamps on the Primordial path at inception
     * (IKE-Network/ike-issues#910), a rename reaches a Development view only through
     * Development's path origin (Primordial at Latest, IKE-Network/ike-issues#911).
     * Path semantics make anything committed <em>on</em> a path shadow what the path
     * inherits from its origin, regardless of time — the same way a branch's own
     * commits override upstream. The baseline's FQN versions for exactly these 14
     * components (the "display field" → "data type" family) were committed on the
     * Development path in August 2025 (see the stamp census in
     * {@link #HISTORICALLY_AMBIGUOUS_AXIOM_NIDS}), so a consumer's Development view
     * keeps the baseline label for them; every other rename's baseline version sits on
     * Primordial and resolves to the new text. No reparent is shadowed — all reparented
     * axiom semantics' baseline versions are on Primordial.
     * {@link #renamedFqnsResolveOnTheInceptionReleaseView()} proves all 14 renames ARE
     * the resolved content of the inception release itself (a Primordial-positioned
     * view). Consumer guidance for the release model: IKE-Network/ike-issues#912.
     */
    private static final Set<UUID> DEV_VIEW_SHADOWED_RENAME_UUIDS = Set.of(
            UUID.fromString("d6b9e2cc-31c6-5e80-91b7-7537690aae32"),  // Boolean data type
            UUID.fromString("dbdd8df2-aec3-596b-88fc-7b83b5594a45"),  // Byte array data type
            UUID.fromString("fb00d132-fcc3-5cbf-881d-4bcc4b4c91b3"),  // Component data type
            UUID.fromString("e553d3f1-63e1-4292-a3a9-af646fe44292"),  // Component Id list data type
            UUID.fromString("e283af51-2e8f-44fa-9bf1-89a99a7c7631"),  // Component Id set data type
            UUID.fromString("ac8f1f54-c7c6-5fc7-b1a8-ebb04b918557"),  // Concept data type
            UUID.fromString("b413fe94-4ada-4aee-96f9-22be19699d40"),  // Decimal data type
            UUID.fromString("60113dfe-2bad-11eb-adc1-0242ac120002"),  // DiGraph data type
            UUID.fromString("32f64fc6-5371-11eb-ae93-0242ac130002"),  // DiTree data type
            UUID.fromString("6efe7087-3e3c-5b45-8109-90d7652b1506"),  // Float data type
            UUID.fromString("ff59c300-9c4e-5e77-a35d-6a133eb3440f"),  // Integer data type
            UUID.fromString("9c3dfc88-51e4-5e51-a59a-88dd580162b7"),  // Semantic data type
            UUID.fromString("a46aaf11-b37a-32d6-abdc-707f084ec8f5"),  // String data type
            UUID.fromString("b168ad04-f814-5036-b886-fd4913de88c8")); // Array data type

    /** {@link #DEV_VIEW_SHADOWED_RENAME_UUIDS} resolved to nids in {@link #loadAndSnapshot()}. */
    private static final Set<Integer> DEV_VIEW_SHADOWED_RENAME_NIDS = new HashSet<>();

    /**
     * {@link BaselineIdentityAuditIT#DELIBERATELY_REPARENTED_ISA} — the durable
     * divergence record — resolved to this store's nids in {@link #loadAndSnapshot()}.
     * {@link #isAParentsUnchanged()} asserts the registered parent for exactly these
     * nids, instead of the pre-replay snapshot every other component is held to.
     */
    private static final Map<Integer, Integer> DELIBERATELY_REPARENTED_ISA_BY_NID = new HashMap<>();

    /**
     * Pre-replay version counts of the
     * {@link BaselineIdentityAuditIT#DELIBERATELY_NOT_ADOPTED_SEMANTIC_UUIDS} seeds.
     * This class loads the baseline into the same store the ledger then replays into,
     * so the seeds are necessarily <em>present</em> here (empirically confirmed: the
     * baseline itself carries them); what the ingest controls is adoption — the replay
     * must add no version, no IKE provenance, on top of the untouched baseline
     * chronologies. The version-count assertions cover concepts and patterns only, so
     * this semantic-level deviation gets its own assertion:
     * {@link #notAdoptedSeedSemanticsAreNeverAuthored()}, against the pre-replay counts
     * snapshotted here. ({@link LedgerGatesIT} holds the ledger-only side: the seeds are
     * entirely absent from a store built from the ledger alone.)
     */
    private static final Map<UUID, Integer> NOT_ADOPTED_SEED_VERSIONS_BEFORE = new HashMap<>();

    @BeforeAll
    static void loadAndSnapshot() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-merge").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        File baseline = Path.of("target", "data", "tinkar-starter-data-unreasoned-pb.zip").toFile();
        new LoadEntitiesFromProtobufFile(baseline).compute();

        for (Map.Entry<UUID, String> entry : BaselineIdentityAuditIT.DELIBERATELY_RENAMED_FQNS.entrySet()) {
            DELIBERATELY_RENAMED_FQNS_BY_NID.put(PrimitiveData.nid(entry.getKey()), entry.getValue());
        }
        for (UUID uuid : DEV_VIEW_SHADOWED_RENAME_UUIDS) {
            DEV_VIEW_SHADOWED_RENAME_NIDS.add(PrimitiveData.nid(uuid));
        }
        for (Map.Entry<UUID, UUID> entry : BaselineIdentityAuditIT.DELIBERATELY_REPARENTED_ISA.entrySet()) {
            DELIBERATELY_REPARENTED_ISA_BY_NID.put(
                    PrimitiveData.nid(entry.getKey()), PrimitiveData.nid(entry.getValue()));
        }
        for (UUID uuid : BaselineIdentityAuditIT.DELIBERATELY_NOT_ADOPTED_SEMANTIC_UUIDS) {
            // expectSemantic doubles as a baseline-presence check: the seeds must come
            // from the upstream baseline, and only from there (IKE-Network/ike-issues#887).
            NOT_ADOPTED_SEED_VERSIONS_BEFORE.put(uuid,
                    EntityHandle.get(PrimitiveData.nid(uuid)).expectSemantic().versions().size());
        }

        calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
        languageCalculator = Calculators.Language.UsEnglishFullyQualifiedName(calculator.stampCoordinate());

        int[] conceptCount = {0};
        EntityService.get().forEachConceptEntity(concept -> {
            conceptCount[0]++;
            int nid = concept.nid();
            languageCalculator.getFullyQualifiedNameText(EntityProxy.Concept.make(nid))
                    .ifPresent(fqn -> FQN_BEFORE.put(nid, fqn));
            IS_A_PARENTS_BEFORE.put(nid, StoreInspection.latestIsAParents(calculator, nid));
            VERSION_COUNT_BEFORE.put(nid, EntityHandle.get(nid).expectConcept().versions().size());
            if (StoreInspection.hasAmbiguousAxiomHistory(nid)) {
                HISTORICALLY_AMBIGUOUS_AXIOM_NIDS.add(nid);
            }
        });
        conceptsBefore = conceptCount[0];

        int[] patternCount = {0};
        EntityService.get().forEachPatternEntity(pattern -> {
            patternCount[0]++;
            VERSION_COUNT_BEFORE.put(pattern.nid(),
                    EntityHandle.get(pattern.nid()).expectPattern().versions().size());
        });
        patternsBefore = patternCount[0];

        if (!HISTORICALLY_AMBIGUOUS_AXIOM_NIDS.isEmpty()) {
            System.out.println("ConsumerMergeIT: " + HISTORICALLY_AMBIGUOUS_AXIOM_NIDS.size()
                    + " component(s) excluded from isAParentsUnchanged (ambiguous axiom history, see"
                    + " HISTORICALLY_AMBIGUOUS_AXIOM_NIDS javadoc): "
                    + HISTORICALLY_AMBIGUOUS_AXIOM_NIDS.stream().map(FQN_BEFORE::get).toList());
        }

        // The real, compiled, committed source — not a temp-dir stand-in.
        new IkeSource().compose().write();
    }

    @AfterAll
    static void stop() {
        PrimitiveData.stop();
    }

    @Test
    @DisplayName("Every pre-existing component's FQN text is unchanged after replay"
            + " — except DELIBERATELY_RENAMED_FQNS, which get their new, expected text"
            + " (unless DEV_VIEW_SHADOWED_RENAME_UUIDS pins them as path-shadowed on this view)")
    void fqnTextUnchanged() {
        for (Map.Entry<Integer, String> entry : FQN_BEFORE.entrySet()) {
            int nid = entry.getKey();
            String fqnAfter = languageCalculator.getFullyQualifiedNameText(EntityProxy.Concept.make(nid))
                    .orElseThrow(() -> new AssertionError("FQN disappeared for nid " + nid));
            String expected = DEV_VIEW_SHADOWED_RENAME_NIDS.contains(nid)
                    ? entry.getValue()  // the baseline's own Development-path version shadows the rename
                    : DELIBERATELY_RENAMED_FQNS_BY_NID.getOrDefault(nid, entry.getValue());
            assertEquals(expected, fqnAfter, "FQN drifted for nid " + nid);
        }
    }

    @Test
    @DisplayName("Every deliberate rename — including the 14 Development-view-shadowed ones — is the"
            + " resolved content of the inception release view (Primordial at Latest,"
            + " IKE-Network/ike-issues#910)")
    void renamedFqnsResolveOnTheInceptionReleaseView() {
        StampCalculator inceptionRelease = StampCalculatorWithCache.getCalculator(
                StampCoordinateRecord.make(StateSet.ACTIVE,
                        StampPositionRecord.make(Long.MAX_VALUE, TinkarTerm.PRIMORDIAL_PATH),
                        IntIds.set.empty()));
        LanguageCalculator releaseLanguage =
                Calculators.Language.UsEnglishFullyQualifiedName(inceptionRelease.stampCoordinate());
        for (Map.Entry<Integer, String> entry : DELIBERATELY_RENAMED_FQNS_BY_NID.entrySet()) {
            assertEquals(entry.getValue(),
                    releaseLanguage.getFullyQualifiedNameText(EntityProxy.Concept.make(entry.getKey()))
                            .orElseThrow(() -> new AssertionError(
                                    "FQN unresolvable on the release view for nid " + entry.getKey())),
                    "rename not resolved on the inception release view for nid " + entry.getKey());
        }
    }

    @Test
    @DisplayName("Every pre-existing component's latest isA parent set is unchanged after replay"
            + " (except components with ambiguous axiom history, see HISTORICALLY_AMBIGUOUS_AXIOM_NIDS,"
            + " and DELIBERATELY_REPARENTED_ISA, which get their new, expected parent)")
    void isAParentsUnchanged() {
        for (Map.Entry<Integer, Set<Integer>> entry : IS_A_PARENTS_BEFORE.entrySet()) {
            int nid = entry.getKey();
            if (HISTORICALLY_AMBIGUOUS_AXIOM_NIDS.contains(nid)) {
                continue;
            }
            Integer newParentNid = DELIBERATELY_REPARENTED_ISA_BY_NID.get(nid);
            Set<Integer> expected = newParentNid != null ? Set.of(newParentNid) : entry.getValue();
            // Role umbrellas are a derivable divergence class, subtracted before the
            // drift comparison — same exemption as the static audit
            // (IKE-Network/ike-issues#918); LedgerGatesIT's derivability gate holds them
            // to the pattern declarations.
            // (spared when the umbrella is itself the expected parent — the umbrellas'
            // own inherited vocabulary children)
            Set<Integer> actual = new HashSet<>(StoreInspection.latestIsAParents(calculator, nid));
            int meaningNid = PrimitiveData.nid(BaselineIdentityAuditIT.MEANING_UMBRELLA);
            int purposeNid = PrimitiveData.nid(BaselineIdentityAuditIT.PURPOSE_UMBRELLA);
            if (!expected.contains(meaningNid)) {
                actual.remove(meaningNid);
            }
            if (!expected.contains(purposeNid)) {
                actual.remove(purposeNid);
            }
            assertEquals(expected, actual, "isA parents drifted for nid " + nid);
        }
    }

    @Test
    @DisplayName("Every pre-existing component gains exactly one (inception) version — a true merge,"
            + " no exceptions: pre-release, the ledger carries no revision layering"
            + " (IKE-Network/ike-issues#894)")
    void versionCountIncreasesByExactlyOne() {
        for (Map.Entry<Integer, Integer> entry : VERSION_COUNT_BEFORE.entrySet()) {
            int nid = entry.getKey();
            boolean isPattern = EntityHandle.get(nid).isPattern();
            int versionsAfter = isPattern
                    ? EntityHandle.get(nid).expectPattern().versions().size()
                    : EntityHandle.get(nid).expectConcept().versions().size();
            assertEquals(entry.getValue() + 1, versionsAfter,
                    "version count did not increase by exactly one for nid " + nid);
        }
    }

    @Test
    @DisplayName("Identity-exact ingest mints exactly the 3 hand-authored concepts (module, root, IKE Community), zero new patterns")
    void noUnexpectedNewComponents() {
        int[] conceptsAfter = {0};
        EntityService.get().forEachConceptEntity(concept -> conceptsAfter[0]++);
        int[] patternsAfter = {0};
        EntityService.get().forEachPatternEntity(pattern -> patternsAfter[0]++);
        assertEquals(conceptsBefore + INGEST_BOOTSTRAP_CONCEPTS + AUTHORED_CONTENT_CONCEPTS, conceptsAfter[0],
                "expected exactly " + INGEST_BOOTSTRAP_CONCEPTS + " identity-exact-ingest concepts (module,"
                        + " root, IKE Community) plus " + AUTHORED_CONTENT_CONCEPTS + " deliberately-authored"
                        + " new concepts (see AUTHORED_CONTENT_CONCEPTS,"
                        + " IKE-Network/ike-issues#880 and #885) — no other minting");
        assertEquals(patternsBefore + AUTHORED_CONTENT_PATTERNS, patternsAfter[0],
                "identity-exact ingest mints no new patterns; the authoring passes deliberately mint "
                        + AUTHORED_CONTENT_PATTERNS + " (Taxonomy Field Constraint Pattern, Value-set Field"
                        + " Constraint Pattern, Starter Set Author Roster Pattern, Preferred Reviewer"
                        + " Pattern, Solor Concepts Pattern, Data Type Defaults Pattern)");
    }

    @Test
    @DisplayName("Export completes and accounts for every concept in the post-replay store")
    void exportReconciles() throws Exception {
        Path outFile = Files.createTempFile("ike-merge-export", ".zip");
        EntityCountSummary summary = new ExportEntitiesToProtobufFile(outFile.toFile(),
                new TemporalEntityAggregator(0L, Long.MAX_VALUE)).compute();
        int[] conceptsAfter = {0};
        EntityService.get().forEachConceptEntity(concept -> conceptsAfter[0]++);
        assertTrue(summary.conceptCount() > 0, "export produced no concepts");
        assertEquals(conceptsAfter[0], summary.conceptCount(),
                "export's concept count must reconcile with the post-replay store");
    }

    @Test
    @DisplayName("The three upstream placeholder seeds on Default Data Concept are never adopted"
            + " — replay adds no version to the untouched baseline chronologies"
            + " (IKE-Network/ike-issues#887)")
    void notAdoptedSeedSemanticsAreNeverAuthored() {
        for (Map.Entry<UUID, Integer> entry : NOT_ADOPTED_SEED_VERSIONS_BEFORE.entrySet()) {
            assertEquals(entry.getValue(),
                    EntityHandle.get(PrimitiveData.nid(entry.getKey())).expectSemantic().versions().size(),
                    "upstream placeholder seed semantic " + entry.getKey() + " gained a version"
                            + " from replay — the ingest must not adopt it (IKE-Network/ike-issues#887)");
        }
    }
}
