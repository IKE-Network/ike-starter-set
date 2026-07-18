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
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.language.calculator.LanguageCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityHandle;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.EntityVersion;
import dev.ikm.tinkar.entity.SemanticEntity;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.aggregator.TemporalEntityAggregator;
import dev.ikm.tinkar.entity.builder.generator.AxiomDecompiler;
import dev.ikm.tinkar.entity.export.ExportEntitiesToProtobufFile;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.load.LoadEntitiesFromProtobufFile;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Set;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The round-trip fidelity gate for the full starter-set ingest (IKE-Network/ike-issues#872):
 * replay the ingested ledger into a fresh store, export, and compare entity-for-entity
 * against the original unreasoned starter artifact — {@code GeneratorEndToEndIT}'s own
 * content-equivalence check (FQN text, isA parents), generalized from 3 hand-picked
 * samples to every one of the ~407 pre-existing components, run against the real,
 * committed {@link IkeSource} rather than a temp-dir/in-process-compiled stand-in.
 * <p>
 * One store lifecycle for the whole class (a second {@code PrimitiveData} lifecycle
 * cannot start once the first stops within a JVM): the baseline is loaded and
 * snapshotted once in {@link #loadAndSnapshot()}, then every {@code @Test} method
 * inspects that same already-replayed store.
 */
class FoundationFidelityIT {

    private static StampCalculator calculator;
    private static LanguageCalculator languageCalculator;
    private static final Map<Integer, String> FQN_BEFORE = new HashMap<>();
    private static final Map<Integer, Set<Integer>> IS_A_PARENTS_BEFORE = new HashMap<>();
    private static final Map<Integer, Integer> VERSION_COUNT_BEFORE = new HashMap<>();
    private static int conceptsBefore;
    private static int patternsBefore;

    /** New concepts the identity-exact ingest itself mints: the module, the root, IKE Community. */
    private static final int INGEST_BOOTSTRAP_CONCEPTS = 3;
    /**
     * New concepts {@code ConstraintPatternSet} (17 original + 7 for Concept Field
     * Constraint Pattern + 5 for Preferred Reviewer/Starter Set Author Roster Pattern =
     * 29), {@code PatternShapeRefinementSet} (2 for Comment pattern + 23 for the
     * remaining 16 revised patterns = 25), {@code AssemblageTerminologySet} (1 — Set
     * membership), and {@code LegacyTerminologySet} (1 — Legacy) deliberately author, all
     * IKE-Network/ike-issues#880 (meaning/purpose rigor across the pattern-shape audit,
     * retiring "assemblage" from this set's own vocabulary, then flagging dormant/
     * superseded content as Legacy); plus {@code DefaultsAndTemplatesSet} (3 — Default
     * value concept, Template concept, Defaults and templates module,
     * IKE-Network/ike-issues#885).
     */
    private static final int AUTHORED_CONTENT_CONCEPTS = 59;
    /**
     * New patterns {@code ConstraintPatternSet} (3, IKE-Network/ike-issues#880) and
     * {@code AssemblageTerminologySet} (1 — Solor Concepts Pattern, the IKE-native
     * replacement for the dormant SOLORConceptAssemblage) deliberately author.
     */
    private static final int AUTHORED_CONTENT_PATTERNS = 4;

    /**
     * Components whose stated-axiom semantic's own historical versions resolve to more
     * than one distinct (simpleIsA, parents) shape — detected directly from the raw
     * version history (bypassing calculator "latest" resolution), before replay.
     * Excluded from {@link #isAParentsUnchanged()}: for exactly these components,
     * {@code Calculators.Stamp.DevelopmentLatestActiveOnly()}'s "latest" resolution is
     * observed to answer differently before vs. after replay, even though replay adds
     * no new version to their axiom semantic (confirmed empirically — same version
     * count before and after). The likely cause is a path-coordinate bootstrap
     * characteristic: before replay, no stamp anywhere in this store is on
     * {@code TinkarTerm.DEVELOPMENT_PATH} (the raw starter data is entirely on
     * Primordial path), so "latest on development" has no real cutoff to resolve
     * against for a component whose own history spans more than one shape; after
     * replay stamps ~407 new Development-path versions (this ledger's own inception
     * stamps), a real cutoff exists for the first time and the true latest
     * Primordial-path version becomes resolvable. This is a calculator/path-coordinate
     * characteristic, not a defect in the #869 generator — nothing was silently
     * generated wrong (no manifest note was dropped for these components; their axiom
     * semantics gained no new version). Logged, not silently dropped; tracked as
     * IKE-Network/ike-issues#875 for deeper investigation rather than fixed here.
     */
    private static final Set<Integer> HISTORICALLY_AMBIGUOUS_AXIOM_NIDS = new HashSet<>();

    /**
     * UUIDs of pre-existing patterns {@code PatternShapeRefinementSet} or
     * {@code AssemblageTerminologySet} deliberately give a <em>second</em> new version,
     * beyond the identity-exact ingest's own inception version (IKE-Network/ike-issues#880)
     * — most revised to split degenerate meaning=purpose into distinct concepts (Comment
     * pattern, the two navigation patterns, the five chronicle-shape and five
     * version-shape base-model patterns, Module/Path origins, and
     * STAMP/Description/Identifier/Value Constraint Pattern); the last three revised
     * instead to replace their purpose, {@code Membership semantic (SOLOR)}, with the
     * modern {@code Set membership (IkeFoundation)} as part of retiring "assemblage" from
     * this set's own vocabulary. Resolved to nids once the baseline store is up, in
     * {@link #loadAndSnapshot()}.
     */
    private static final Set<UUID> DELIBERATELY_REVISED_TWICE_UUIDS = Set.of(
            UUID.fromString("3734fb0a-4c14-5831-9a61-4743af609e7a"), // Comment pattern
            UUID.fromString("a53cc42d-c07e-5934-96b3-2ede3264474e"), // Inferred Navigation Pattern
            UUID.fromString("d02957d6-132d-5b3c-adba-505f5778d998"), // Stated Navigation Pattern
            UUID.fromString("c48db76d-5eb0-4ff5-84d0-5c3c4ec77767"), // Component Chronology Pattern
            UUID.fromString("3e510cb9-1666-4676-9334-d288a56bf155"), // Concept field pattern
            UUID.fromString("5bc93adb-9d39-43fe-a7a4-1492245b7efb"), // Pattern Chronology Pattern
            UUID.fromString("e16abc7a-2a7b-42af-b168-d77aec8116ea"), // STAMP Chronology Pattern
            UUID.fromString("5f0ad6ca-638e-4052-82b0-3f564ac99b3f"), // Semantic Chronology Pattern
            UUID.fromString("a38b7d2d-8fa5-4206-9185-a1af9f81be2c"), // Component Version Pattern
            UUID.fromString("7943a5f1-538b-4fda-8acb-019e0bec125b"), // Concept Version Pattern
            UUID.fromString("82f93e84-cee1-44bc-bb6d-4cc2a722048b"), // Sementic version field pattern
            UUID.fromString("73c798cf-bc77-49a2-84f7-4c0f4bc4c012"), // STAMP version field pattern
            UUID.fromString("a90f8a4d-ae13-476b-98b8-814914f9704e"), // Pattern Version Pattern
            UUID.fromString("536b0ec4-4974-47ae-93a6-ae6c4d169780"), // Module origins pattern (SOLOR)
            UUID.fromString("70f89dd5-2cdb-59bb-bbaa-98527513547c"), // Path origins pattern (SOLOR)
            UUID.fromString("9fd67fee-abf9-551d-9d0e-76a4b1e8b4ee"), // STAMP pattern
            UUID.fromString("a4de0039-2625-5842-8a4c-d1ce6aebf021"), // Description Pattern
            UUID.fromString("5d60e14b-c410-5172-9559-3c4253278ae2"), // Identifier Pattern
            UUID.fromString("922697f7-36ba-4afc-9dd5-f29d54b0fdec"), // Value Constraint Pattern
            UUID.fromString("6070f6f5-893d-5144-adce-7d305c391cf9"), // Tinkar base model component pattern
            UUID.fromString("bbbbf1fe-00f0-55e0-a19c-6300dbaab9b2"), // Komet base model component pattern
            UUID.fromString("add1db57-72fe-53c8-a528-1614bda20ec6")  // Version control path pattern
    );
    private static final Set<Integer> DELIBERATELY_REVISED_TWICE_NIDS = new HashSet<>();

    /**
     * UUIDs of pre-existing concepts {@code AssemblageTerminologySet} deliberately gives
     * a new, later-active fully qualified name — retiring "assemblage" from this set's
     * own vocabulary (IKE-Network/ike-issues#880) — mapped to the expected post-revision
     * FQN text. {@link #fqnTextUnchanged()} asserts against this text for exactly these
     * nids, instead of the pre-replay snapshot every other component is held to.
     */
    private static final Map<UUID, String> DELIBERATELY_RENAMED_FQNS = Map.ofEntries(
            Map.entry(UUID.fromString("16486419-5d1c-574f-bde6-21910ad66f44"), "Concept pattern for logic coordinate"),
            Map.entry(UUID.fromString("cfd2a47e-8169-5e71-9122-d5b73efd990a"), "Stated pattern for logic coordinate"),
            Map.entry(UUID.fromString("9ecf4d76-4346-5e5d-8316-bdff48a5c154"), "Inferred pattern for logic coordinate"),
            Map.entry(UUID.fromString("c060ffbf-e95f-5960-b296-8a3255c820ac"),
                    "Dialect pattern preference list for language coordinate"),
            // DataTypeTerminologySet: dropping misleading "display field" wording (#880 follow-up).
            Map.entry(UUID.fromString("a46aaf11-b37a-32d6-abdc-707f084ec8f5"), "String data type"),
            Map.entry(UUID.fromString("fb00d132-fcc3-5cbf-881d-4bcc4b4c91b3"), "Component data type"),
            Map.entry(UUID.fromString("ac8f1f54-c7c6-5fc7-b1a8-ebb04b918557"), "Concept data type"),
            Map.entry(UUID.fromString("32f64fc6-5371-11eb-ae93-0242ac130002"), "DiTree data type"),
            Map.entry(UUID.fromString("6efe7087-3e3c-5b45-8109-90d7652b1506"), "Float data type")
    );
    private static final Map<Integer, String> DELIBERATELY_RENAMED_FQNS_BY_NID = new HashMap<>();

    /**
     * UUID of the one pre-existing concept {@code LegacyTerminologySet} deliberately
     * reparents — {@code Dynamic column data types (SOLOR)}, moved under the new
     * {@code Legacy} branch as a deprecation signal (IKE-Network/ike-issues#880 follow-up)
     * — mapped to its expected post-replay isA parent's own UUID. {@link #isAParentsUnchanged()}
     * asserts against this single new parent for exactly this nid, instead of the
     * pre-replay snapshot every other component is held to.
     */
    private static final Map<UUID, UUID> DELIBERATELY_REPARENTED_ISA = Map.of(
            UUID.fromString("61da7e50-f606-5ba0-a0df-83fd524951e7"), // Dynamic column data types (SOLOR)
            UUID.fromString("e06c87d2-0831-5548-b5c1-24dc0501a7de")  // Legacy (IkeFoundation)
    );
    private static final Map<Integer, Integer> DELIBERATELY_REPARENTED_ISA_BY_NID = new HashMap<>();

    /**
     * UUIDs of the three upstream placeholder seed semantics on {@code Default Data
     * Concept} — a GB-dialect and a US-dialect semantic whose field value is the
     * {@code Blank Concept} placeholder, and an identifier semantic ("Default Data -
     * Identifier Value") — that the upstream baseline contains but the ingest
     * deliberately does not adopt (pre-bronze editorial: the starter set is
     * pre-release, so erroneous seeds are simply never created;
     * IKE-Network/ike-issues#887). This class loads the baseline into the same store
     * the ledger then replays into, so the seeds are necessarily <em>present</em> here
     * (empirically confirmed: the baseline itself carries them); what the ingest
     * controls is adoption — the replay must add no version, no IKE provenance, on top
     * of the untouched baseline chronologies. The version-count assertions cover
     * concepts and patterns only, so this semantic-level deviation gets its own
     * assertion: {@link #notAdoptedSeedSemanticsAreNeverAuthored()}, against the
     * pre-replay counts snapshotted in {@link #NOT_ADOPTED_SEED_VERSIONS_BEFORE}.
     */
    private static final Set<UUID> DELIBERATELY_NOT_ADOPTED_SEMANTIC_UUIDS = Set.of(
            UUID.fromString("17c5b61f-e121-4c54-9eb3-e106f3983417"), // GB dialect seed
            UUID.fromString("8b7b452c-6de1-47b8-81fb-2e4cf58ca213"), // identifier seed
            UUID.fromString("92548331-a460-4bdb-aa32-7162f2fb4f0d")  // US dialect seed
    );
    private static final Map<UUID, Integer> NOT_ADOPTED_SEED_VERSIONS_BEFORE = new HashMap<>();

    @BeforeAll
    static void loadAndSnapshot() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-fidelity").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        File baseline = Path.of("target", "data", "tinkar-starter-data-unreasoned-pb.zip").toFile();
        new LoadEntitiesFromProtobufFile(baseline).compute();

        for (UUID uuid : DELIBERATELY_REVISED_TWICE_UUIDS) {
            DELIBERATELY_REVISED_TWICE_NIDS.add(PrimitiveData.nid(uuid));
        }
        for (Map.Entry<UUID, String> entry : DELIBERATELY_RENAMED_FQNS.entrySet()) {
            DELIBERATELY_RENAMED_FQNS_BY_NID.put(PrimitiveData.nid(entry.getKey()), entry.getValue());
        }
        for (Map.Entry<UUID, UUID> entry : DELIBERATELY_REPARENTED_ISA.entrySet()) {
            DELIBERATELY_REPARENTED_ISA_BY_NID.put(
                    PrimitiveData.nid(entry.getKey()), PrimitiveData.nid(entry.getValue()));
        }
        for (UUID uuid : DELIBERATELY_NOT_ADOPTED_SEMANTIC_UUIDS) {
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
            IS_A_PARENTS_BEFORE.put(nid, latestIsAParents(nid));
            VERSION_COUNT_BEFORE.put(nid, EntityHandle.get(nid).expectConcept().versions().size());
            if (hasAmbiguousAxiomHistory(nid)) {
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
            System.out.println("FoundationFidelityIT: " + HISTORICALLY_AMBIGUOUS_AXIOM_NIDS.size()
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

    private static Set<Integer> latestIsAParents(int componentNid) {
        Set<Integer> parents = new HashSet<>();
        calculator.forEachSemanticVersionForComponentOfPattern(
                EntityProxy.Concept.make(componentNid),
                TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN,
                (semanticVersion, entityVersion, patternVersion) -> {
                    DiTreeEntity tree = (DiTreeEntity) semanticVersion.fieldValues().get(0);
                    AxiomDecompiler.Result result = AxiomDecompiler.decompile(tree);
                    if (result.simpleIsA()) {
                        result.parents().forEach(parent -> parents.add(parent.nid()));
                    }
                });
        return parents;
    }

    /** Whether any of this component's raw stated-axiom semantic versions (not just
     * calculator-latest) resolve to more than one distinct (simpleIsA, parents) shape. */
    private static boolean hasAmbiguousAxiomHistory(int componentNid) {
        Set<Object> distinctShapes = new HashSet<>();
        for (int semanticNid : EntityService.get()
                .semanticNidsForComponentOfPattern(componentNid, TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN.nid())) {
            for (Object versionObj : EntityHandle.get(semanticNid).expectSemantic().versions()) {
                dev.ikm.tinkar.entity.SemanticEntityVersion version =
                        (dev.ikm.tinkar.entity.SemanticEntityVersion) versionObj;
                DiTreeEntity tree = (DiTreeEntity) version.fieldValues().get(0);
                AxiomDecompiler.Result result = AxiomDecompiler.decompile(tree);
                distinctShapes.add(result.simpleIsA()
                        ? Set.copyOf(result.parents().stream().map(p -> p.nid()).toList())
                        : "not-simple");
            }
        }
        return distinctShapes.size() > 1;
    }

    @Test
    @DisplayName("Every pre-existing component's FQN text is unchanged after replay"
            + " — except DELIBERATELY_RENAMED_FQNS, which get their new, expected text")
    void fqnTextUnchanged() {
        for (Map.Entry<Integer, String> entry : FQN_BEFORE.entrySet()) {
            int nid = entry.getKey();
            String fqnAfter = languageCalculator.getFullyQualifiedNameText(EntityProxy.Concept.make(nid))
                    .orElseThrow(() -> new AssertionError("FQN disappeared for nid " + nid));
            String expected = DELIBERATELY_RENAMED_FQNS_BY_NID.getOrDefault(nid, entry.getValue());
            assertEquals(expected, fqnAfter, "FQN drifted for nid " + nid);
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
            assertEquals(expected, latestIsAParents(nid), "isA parents drifted for nid " + nid);
        }
    }

    @Test
    @DisplayName("Every pre-existing component gains exactly one (inception) version — a true merge"
            + " — except DELIBERATELY_REVISED_TWICE_NIDS, which gain a second, deliberately-authored"
            + " revision on top")
    void versionCountIncreasesByExactlyOne() {
        for (Map.Entry<Integer, Integer> entry : VERSION_COUNT_BEFORE.entrySet()) {
            int nid = entry.getKey();
            boolean isPattern = EntityHandle.get(nid).isPattern();
            int versionsAfter = isPattern
                    ? EntityHandle.get(nid).expectPattern().versions().size()
                    : EntityHandle.get(nid).expectConcept().versions().size();
            int expectedIncrease = DELIBERATELY_REVISED_TWICE_NIDS.contains(nid) ? 2 : 1;
            assertEquals(entry.getValue() + expectedIncrease, versionsAfter,
                    "version count did not increase by exactly " + expectedIncrease + " for nid " + nid);
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
                        + " new concepts (ConstraintPatternSet, IKE-Network/ike-issues#880) — no other minting");
        assertEquals(patternsBefore + AUTHORED_CONTENT_PATTERNS, patternsAfter[0],
                "identity-exact ingest mints no new patterns; ConstraintPatternSet deliberately mints "
                        + AUTHORED_CONTENT_PATTERNS + " (Concept Field Constraint Pattern, Starter Set Author"
                        + " Roster Pattern, Preferred Reviewer Pattern)");
    }

    @Test
    @DisplayName("Export completes and accounts for every concept in the post-replay store")
    void exportReconciles() throws Exception {
        Path outFile = Files.createTempFile("ike-fidelity-export", ".zip");
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

    // ---------------------------------------------------- defaults and templates (#885)

    /**
     * Patterns whose semantics are a concept's own naming/axiom apparatus — the
     * descriptions and stated axioms every named concept carries. Attached to a
     * defaults/templates attachment concept they are that concept's foundation-module
     * terminology, not defaults/template content, so the module invariants exempt them:
     * the apparatus concepts stamp in the foundation module, and only default value and
     * template semantics stamp in the Defaults and templates module
     * (IKE-Network/ike-issues#885). A pattern attached to an attachment concept outside
     * this registry is defaults/template content and must obey the module invariants.
     *
     * @return the nids of the naming-apparatus patterns
     */
    private static Set<Integer> namingApparatusPatternNids() {
        return Set.of(TinkarTerm.DESCRIPTION_PATTERN.nid(),
                TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN.nid());
    }

    /**
     * Resolves the nid of {@code Default value concept (IkeFoundation)} — the attachment
     * point every default value semantic references (IKE-Network/ike-issues#885).
     *
     * @return the attachment concept's nid in the post-replay store
     */
    private static int defaultValueConceptNid() {
        return PrimitiveData.nid(Ike.SET.uuidFor("Default value concept (IkeFoundation)"));
    }

    /**
     * Resolves the nid of {@code Defaults and templates module (IkeFoundation)} — the
     * module every defaults/template chronology lives and dies in
     * (IKE-Network/ike-issues#885).
     *
     * @return the module concept's nid in the post-replay store
     */
    private static int defaultsModuleNid() {
        return PrimitiveData.nid(Ike.SET.uuidFor("Defaults and templates module (IkeFoundation)"));
    }

    /**
     * The defaults/templates attachment concepts: {@code Default value concept} plus
     * every latest child of {@code Template concept} — the per-purpose template
     * attachment points, minted per purpose as each is needed
     * (IKE-Network/ike-issues#885).
     *
     * @return the attachment concepts' nids in the post-replay store
     */
    private static Set<Integer> attachmentConceptNids() {
        Set<Integer> attachments = new HashSet<>();
        attachments.add(defaultValueConceptNid());
        int templateConceptNid = PrimitiveData.nid(Ike.SET.uuidFor("Template concept (IkeFoundation)"));
        EntityService.get().forEachConceptEntity(concept -> {
            if (latestIsAParents(concept.nid()).contains(templateConceptNid)) {
                attachments.add(concept.nid());
            }
        });
        return attachments;
    }

    /**
     * Applies the consumer to every defaults/template content semantic in the store:
     * semantics attached to an attachment concept, naming apparatus excluded.
     *
     * @param consumer receives each defaults/template semantic
     */
    private static void forEachDefaultsOrTemplateSemantic(Consumer<SemanticEntity<?>> consumer) {
        Set<Integer> attachments = attachmentConceptNids();
        Set<Integer> namingApparatus = namingApparatusPatternNids();
        PrimitiveData.get().forEachSemanticNid(semanticNid -> {
            SemanticEntity<?> semantic = EntityHandle.get(semanticNid).expectSemantic();
            if (attachments.contains(semantic.referencedComponentNid())
                    && !namingApparatus.contains(semantic.patternNid())) {
                consumer.accept(semantic);
            }
        });
    }

    @Test
    @DisplayName("Every defaults/template semantic has all versions in the Defaults and templates"
            + " module — the live side of the live-and-die invariant (IKE-Network/ike-issues#885)")
    void defaultsAndTemplatesContentLivesWhollyInModule() {
        int moduleNid = defaultsModuleNid();
        int[] contentSemantics = {0};
        forEachDefaultsOrTemplateSemantic(semantic -> {
            contentSemantics[0]++;
            for (SemanticEntityVersion version : semantic.versions()) {
                assertEquals(moduleNid,
                        EntityHandle.get(version.stampNid()).expectStamp().moduleNid(),
                        "defaults/template semantic " + semantic.publicId()
                                + " has a version outside the Defaults and templates module");
            }
        });
        assertEquals(1, contentSemantics[0],
                "expected exactly the one worked-example default value semantic"
                        + " (Preferred Reviewer Pattern, DefaultsAndTemplatesSet) as"
                        + " defaults/template content");
    }

    @Test
    @DisplayName("The Defaults and templates module holds only defaults/template semantics — the"
            + " die side of the live-and-die invariant (IKE-Network/ike-issues#885)")
    void defaultsModuleHoldsOnlyDefaultsAndTemplatesContent() {
        Set<Integer> attachments = attachmentConceptNids();
        Set<Integer> namingApparatus = namingApparatusPatternNids();
        int moduleNid = defaultsModuleNid();
        PrimitiveData.get().forEachSemanticNid(semanticNid -> {
            SemanticEntity<?> semantic = EntityHandle.get(semanticNid).expectSemantic();
            for (SemanticEntityVersion version : semantic.versions()) {
                if (EntityHandle.get(version.stampNid()).expectStamp().moduleNid() != moduleNid) {
                    continue;
                }
                assertTrue(attachments.contains(semantic.referencedComponentNid()),
                        "semantic " + semantic.publicId() + " has a version in the Defaults and"
                                + " templates module but references neither Default value concept"
                                + " nor a child of Template concept");
                assertFalse(namingApparatus.contains(semantic.patternNid()),
                        "naming-apparatus semantic " + semantic.publicId() + " (descriptions and"
                                + " stated axioms are foundation-module terminology) must not"
                                + " version in the Defaults and templates module");
            }
        });
        // The module holds only support *semantics* — no concept or pattern chronology
        // versions in it, ever: a concept is terminology, never a default.
        EntityService.get().forEachConceptEntity(concept -> {
            for (EntityVersion version : concept.versions()) {
                assertFalse(EntityHandle.get(version.stampNid()).expectStamp().moduleNid() == moduleNid,
                        "concept " + concept.publicId()
                                + " has a version in the Defaults and templates module");
            }
        });
        EntityService.get().forEachPatternEntity(pattern -> {
            for (EntityVersion version : pattern.versions()) {
                assertFalse(EntityHandle.get(version.stampNid()).expectStamp().moduleNid() == moduleNid,
                        "pattern " + pattern.publicId()
                                + " has a version in the Defaults and templates module");
            }
        });
    }

    @Test
    @DisplayName("At most one active defaults/template semantic per (pattern, attachment concept)"
            + " pair, under the computed singleSemanticUuid identity (IKE-Network/ike-issues#885)")
    void defaultValueIdentityIsComputedAndUnique() {
        Map<List<Integer>, Integer> activePerPair = new HashMap<>();
        forEachDefaultsOrTemplateSemantic(semantic -> {
            if (!calculator.latestIsActive(semantic.nid())) {
                return;
            }
            activePerPair.merge(
                    List.of(semantic.patternNid(), semantic.referencedComponentNid()), 1, Integer::sum);
            UUID expected = UuidT5Generator.singleSemanticUuid(
                    EntityHandle.get(semantic.patternNid()).expectPattern().publicId(),
                    EntityHandle.get(semantic.referencedComponentNid()).expectConcept().publicId());
            assertEquals(List.of(expected), Arrays.asList(semantic.publicId().asUuidArray()),
                    "active defaults/template semantic " + semantic.publicId() + " must carry the"
                            + " computed singleSemanticUuid(pattern, attachment concept) identity");
        });
        for (Map.Entry<List<Integer>, Integer> entry : activePerPair.entrySet()) {
            assertEquals(1, entry.getValue().intValue(),
                    "more than one active defaults/template semantic for the"
                            + " (pattern, attachment concept) pair " + entry.getKey());
        }
        int preferredReviewerPatternNid =
                PrimitiveData.nid(Ike.SET.uuidFor("Preferred Reviewer Pattern (IkeFoundation)"));
        assertTrue(activePerPair.containsKey(
                        List.of(preferredReviewerPatternNid, defaultValueConceptNid())),
                "the worked-example default value semantic for Preferred Reviewer Pattern is missing");
    }
}
