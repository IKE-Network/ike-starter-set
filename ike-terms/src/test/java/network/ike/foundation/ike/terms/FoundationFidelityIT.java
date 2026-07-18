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

import dev.ikm.tinkar.common.id.IntIdList;
import dev.ikm.tinkar.common.id.IntIdSet;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.EntityCountSummary;
import dev.ikm.tinkar.common.service.PluggableService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.language.calculator.LanguageCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityHandle;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.EntityVersion;
import dev.ikm.tinkar.entity.FieldDefinitionForEntity;
import dev.ikm.tinkar.entity.PatternEntityVersion;
import dev.ikm.tinkar.entity.SemanticEntity;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.aggregator.TemporalEntityAggregator;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.generator.AxiomDecompiler;
import dev.ikm.tinkar.entity.constraint.MemberMatchEvaluator;
import dev.ikm.tinkar.entity.export.ExportEntitiesToProtobufFile;
import dev.ikm.tinkar.entity.graph.DiGraphEntity;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.load.LoadEntitiesFromProtobufFile;
import dev.ikm.tinkar.terms.EntityFacade;
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
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.Set;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
     * retiring "assemblage" from this set's own vocabulary, then flagging dormant/
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
     */
    private static final int AUTHORED_CONTENT_CONCEPTS = 86;
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
     */
    private static final int AUTHORED_CONTENT_PATTERNS = 6;

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
            // Born "Sementic version field pattern"; the FQN typo is fixed by
            // DefinitionCompletionSet (IKE-Network/ike-issues#892).
            UUID.fromString("82f93e84-cee1-44bc-bb6d-4cc2a722048b"), // Semantic version field pattern
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
            UUID.fromString("add1db57-72fe-53c8-a528-1614bda20ec6"), // Version control path pattern
            // The last SOLOR baseline shape to get its refinement revision — the
            // IKE-Network/ike-issues#891 Model-Feature pointer fix (Axiomatized
            // Component meaning / Axiom Expression purpose).
            UUID.fromString("c0ca180b-aae2-5fa1-9ab7-4a24f2dfe16b")  // OWL Axiom Syntax Pattern
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
            Map.entry(UUID.fromString("6efe7087-3e3c-5b45-8109-90d7652b1506"), "Float data type"),
            // DataTypeDefaultsSet: the seven more "display field" FQNs the Data Type
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
            // DefinitionCompletionSet: the "Sementic version field pattern" FQN typo fix
            // (IKE-Network/ike-issues#892). A pattern, not a concept — fqnTextUnchanged's
            // snapshot covers concepts only, so this entry records the deliberate rename
            // for the registry's own completeness (and gates it, should pattern FQNs ever
            // join the snapshot).
            Map.entry(UUID.fromString("82f93e84-cee1-44bc-bb6d-4cc2a722048b"), "Semantic version field pattern")
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
     * descriptions and stated axioms every named concept carries, plus the curated
     * narrative prose the guide renders (IKE-Network/ike-issues#888). Attached to a
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
                TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN.nid(),
                // The Prose element pattern: DefaultsAndTemplatesSet authors a curated
                // narrative ABOUT Default value concept (a domain description of the
                // koncept, IKE-Network/ike-issues#888) — foundation-module terminology
                // exactly like its descriptions, never defaults/template content, so the
                // defaults-module content count below stays 2.
                NarrativeContentSet.PROSE_ELEMENT_PATTERN.nid());
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
        assertEquals(2, contentSemantics[0],
                "expected exactly two default value semantics as defaults/template content:"
                        + " the worked example (Preferred Reviewer Pattern,"
                        + " DefaultsAndTemplatesSet) and the sixteen-type loud-defaults tuple"
                        + " (Data Type Defaults Pattern, DataTypeDefaultsSet,"
                        + " IKE-Network/ike-issues#885)");
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
        int dataTypeDefaultsPatternNid =
                PrimitiveData.nid(Ike.SET.uuidFor("Data Type Defaults Pattern (IkeFoundation)"));
        assertTrue(activePerPair.containsKey(
                        List.of(dataTypeDefaultsPatternNid, defaultValueConceptNid())),
                "the sixteen-type default value semantic for Data Type Defaults Pattern is missing"
                        + " (IKE-Network/ike-issues#885)");
    }

    @Test
    @DisplayName("The Data Type Defaults tuple reads back with all sixteen decided loud defaults"
            + " — the store's byte round trip of every field data type (IKE-Network/ike-issues#885)")
    void dataTypeDefaultsTupleCarriesTheDecidedLoudDefaults() {
        UUID tupleUuid = UuidT5Generator.singleSemanticUuid(
                PublicIds.of(Ike.SET.uuidFor("Data Type Defaults Pattern (IkeFoundation)")),
                PublicIds.of(Ike.SET.uuidFor("Default value concept (IkeFoundation)")));
        SemanticEntity<?> tuple = EntityHandle.get(PrimitiveData.nid(tupleUuid)).expectSemantic();
        assertEquals(1, tuple.versions().size(), "the defaults tuple has exactly its one authored version");
        List<Object> values = tuple.versions().get(0).fieldValues().castToList();
        assertEquals(16, values.size(), "one field per ConceptToDataType-recognized data type");

        int uninitializedNid = PrimitiveData.nid(UUID.fromString("55f74246-0a25-57ac-9473-a788d08fb656"));
        assertEquals("UNINITIALIZED", values.get(0), "String default");
        assertEquals(uninitializedNid, ((EntityFacade) values.get(1)).nid(), "Component default");
        IntIdSet idSet = (IntIdSet) values.get(2);
        assertEquals(1, idSet.size(), "ComponentIdSet default is a singleton");
        assertTrue(idSet.contains(uninitializedNid), "ComponentIdSet default holds Uninitialized Component");
        IntIdList idList = (IntIdList) values.get(3);
        assertEquals(1, idList.size(), "ComponentIdList default is a singleton");
        assertEquals(uninitializedNid, idList.get(0), "ComponentIdList default holds Uninitialized Component");
        DiTreeEntity tree = (DiTreeEntity) values.get(4);
        assertEquals(1, tree.vertexMap().size(), "DiTree default is a single-vertex tree");
        assertEquals(uninitializedNid, tree.root().getMeaningNid(),
                "DiTree default's vertex means Uninitialized Component");
        DiGraphEntity<?> graph = (DiGraphEntity<?>) values.get(5);
        assertEquals(2, graph.vertexMap().size(), "DiGraph default has two vertices");
        assertEquals(0, graph.roots().size(), "DiGraph default is a pure cycle — no roots");
        assertEquals(uninitializedNid, graph.vertexMap().get(0).getMeaningNid(),
                "DiGraph default's first vertex means Uninitialized Component");
        assertEquals(uninitializedNid, graph.vertexMap().get(1).getMeaningNid(),
                "DiGraph default's second vertex means Uninitialized Component");
        assertEquals(1, graph.successorMap().get(0).getFirst(), "DiGraph default carries edge A → B");
        assertEquals(0, graph.successorMap().get(1).getFirst(), "DiGraph default carries edge B → A");
        assertEquals(uninitializedNid, ((EntityFacade) values.get(6)).nid(), "Concept default");
        assertEquals(PrimitiveData.nid(UUID.fromString("f600187f-94a9-4baf-8b44-46baba8d928a")),
                ((EntityFacade) values.get(7)).nid(),
                "Semantic default is Uninitialized Component's FQN description semantic");
        assertEquals(777_777_777, values.get(8), "Integer default is the nine-sevens sentinel");
        assertTrue(((Float) values.get(9)).isNaN(), "Float default is the native non-value NaN");
        assertEquals(Boolean.FALSE, values.get(10), "Boolean default is the flagged-compromise false");
        assertArrayEquals("UNINITIALIZED".getBytes(java.nio.charset.StandardCharsets.UTF_8),
                (byte[]) values.get(11), "ByteArray default is the loud String default in byte form");
        assertArrayEquals(new Object[]{"UNINITIALIZED"}, (Object[]) values.get(12),
                "Array default is the one-element loud array");
        assertEquals(PrimitiveData.PREMUNDANE_INSTANT, values.get(13),
                "Instant default is the premundane instant");
        assertEquals(777_777_777_777_777_777L, values.get(14),
                "Long default is the eighteen-sevens sentinel");
        assertEquals(new java.math.BigDecimal("777777777.777"), values.get(15),
                "Decimal default is the stretched-sevens decimal");
    }

    // ------------------------------------------------------------ field constraints (#890)

    @Test
    @DisplayName("Member match relation admission is a bijection: relation concepts (children of"
            + " Member match relation under the checking view) correspond one-to-one with the"
            + " service-loaded MemberMatchEvaluators (IKE-Network/ike-issues#890)")
    void memberMatchRelationsBijectServiceLoadedEvaluators() {
        int parentNid = PrimitiveData.nid(Ike.SET.uuidFor("Member match relation (IkeFoundation)"));
        Set<Integer> relationNids = new HashSet<>();
        EntityService.get().forEachConceptEntity(concept -> {
            if (latestIsAParents(concept.nid()).contains(parentNid)) {
                relationNids.add(concept.nid());
            }
        });

        Set<Integer> evaluatorRelationNids = new HashSet<>();
        for (MemberMatchEvaluator evaluator : PluggableService.load(MemberMatchEvaluator.class)) {
            assertTrue(evaluatorRelationNids.add(PrimitiveData.nid(evaluator.relation().publicId())),
                    "two service-loaded evaluators declare the same relation \""
                            + evaluator.relation().description() + "\" — dispatch would be ambiguous");
        }

        assertEquals(relationNids, evaluatorRelationNids,
                "the admission gate is a bijection: minting a relation concept without shipping its"
                        + " evaluator must fail, and shipping an evaluator without minting its relation"
                        + " must fail (IKE-Network/ike-issues#890)");
        // Today's admitted set is exactly Equal, on both sides. Grow this assertion
        // deliberately, in the same change that mints a new relation concept and ships
        // its evaluator — never separately.
        assertEquals(Set.of(PrimitiveData.nid(Ike.SET.uuidFor("Equal match relation (IkeFoundation)"))),
                relationNids, "exactly the Equal match relation is admitted today");
    }

    @Test
    @DisplayName("Every ledger-declared pattern's referenced-component meaning differs from every one"
            + " of its own field meanings — the Model-Feature pointer invariant"
            + " (IKE-Network/ike-issues#890)")
    void referencedComponentMeaningDiffersFromEveryFieldMeaning() {
        // Unconditional since IKE-Network/ike-issues#891: the four SOLOR-inherited
        // collisions (OWL Axiom Syntax, Identifier, Module origins, Path origins) were
        // fixed with distinct referenced-component meanings in PatternShapeRefinementSet,
        // and the exemption registry that pinned them is gone — no pattern may collide.
        Set<UUID> colliding = new HashSet<>();
        for (KnowledgeSet.Declaration declaration : Ike.SET.declarations()) {
            if (declaration.kind() != KnowledgeSet.Declaration.Kind.PATTERN) {
                continue;
            }
            int patternNid = PrimitiveData.nid(declaration.publicId());
            Latest<PatternEntityVersion> latest = calculator.latest(patternNid);
            if (!latest.isPresent()) {
                continue;
            }
            PatternEntityVersion version = latest.get();
            for (FieldDefinitionForEntity field : version.fieldDefinitions()) {
                if (field.meaningNid() == version.semanticMeaningNid()) {
                    colliding.add(declaration.publicId().asUuidArray()[0]);
                }
            }
        }
        assertEquals(Set.of(), colliding,
                "a pattern's referenced-component meaning must differ from every one of its own"
                        + " field meanings, so the Value-set field Model-Feature pointer — a field's"
                        + " meaning, or the referenced-component meaning for membership patterns — is"
                        + " unambiguous (IKE-Network/ike-issues#890, collisions fixed by"
                        + " IKE-Network/ike-issues#891)");
    }

    // ------------------------------------------------- meaning/purpose audit (#892)

    /**
     * Normalizes description text for the label-echo comparison: lowercase, alphanumeric
     * characters only — so "EL++ Stated terminological axioms" and "EL Stated
     * Terminological Axioms!" read as the same echo (IKE-Network/ike-issues#892).
     *
     * @param text the description text to normalize
     * @return the lowercase, alphanumeric-only form of {@code text}
     */
    private static String normalized(String text) {
        StringBuilder normalized = new StringBuilder(text.length());
        for (char c : text.toLowerCase(Locale.ROOT).toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                normalized.append(c);
            }
        }
        return normalized.toString();
    }

    @Test
    @DisplayName("Every ledger-declared pattern's latest version keeps meaning distinct from"
            + " purpose — for its referenced component and for every one of its fields"
            + " (IKE-Network/ike-issues#892)")
    void everyModelFeatureMeaningDiffersFromItsPurpose() {
        // Unconditional, no registry: the IKE-Network/ike-issues#880/#890/#891 passes
        // eliminated every meaning=purpose collapse, and this gate keeps them out.
        for (KnowledgeSet.Declaration declaration : Ike.SET.declarations()) {
            if (declaration.kind() != KnowledgeSet.Declaration.Kind.PATTERN) {
                continue;
            }
            int patternNid = PrimitiveData.nid(declaration.publicId());
            Latest<PatternEntityVersion> latest = calculator.latest(patternNid);
            if (!latest.isPresent()) {
                continue;
            }
            PatternEntityVersion version = latest.get();
            assertFalse(version.semanticMeaningNid() == version.semanticPurposeNid(),
                    "pattern " + declaration.publicId() + " collapses its referenced-component"
                            + " meaning and purpose into one concept — meaning names what kind of"
                            + " thing this is; purpose names why it is captured"
                            + " (IKE-Network/ike-issues#892)");
            for (FieldDefinitionForEntity field : version.fieldDefinitions()) {
                assertFalse(field.meaningNid() == field.purposeNid(),
                        "pattern " + declaration.publicId() + " field \"" + field.meaning().description()
                                + "\" collapses its meaning and purpose into one concept"
                                + " (IKE-Network/ike-issues#892)");
            }
        }
    }

    @Test
    @DisplayName("Every meaning and purpose concept any ledger-declared pattern's latest version"
            + " names carries an active definition whose normalized text differs from its FQN and"
            + " regular name — label echoes cannot return (IKE-Network/ike-issues#892)")
    void everyMeaningAndPurposeCarriesARealDefinition() {
        // Unconditional, no registry: DefinitionCompletionSet authored the 25 missing
        // definitions and revised the 9 label echoes; this gate keeps the inventory at
        // zero for both defect classes.
        Set<Integer> meaningAndPurposeNids = new HashSet<>();
        for (KnowledgeSet.Declaration declaration : Ike.SET.declarations()) {
            if (declaration.kind() != KnowledgeSet.Declaration.Kind.PATTERN) {
                continue;
            }
            Latest<PatternEntityVersion> latest = calculator.latest(PrimitiveData.nid(declaration.publicId()));
            if (!latest.isPresent()) {
                continue;
            }
            PatternEntityVersion version = latest.get();
            meaningAndPurposeNids.add(version.semanticMeaningNid());
            meaningAndPurposeNids.add(version.semanticPurposeNid());
            for (FieldDefinitionForEntity field : version.fieldDefinitions()) {
                meaningAndPurposeNids.add(field.meaningNid());
                meaningAndPurposeNids.add(field.purposeNid());
            }
        }
        for (int nid : meaningAndPurposeNids) {
            String label = languageCalculator.getFullyQualifiedNameText(nid)
                    .map(FoundationFidelityIT::normalized).orElse("");
            String regularName = languageCalculator.getRegularDescriptionText(nid)
                    .map(FoundationFidelityIT::normalized).orElse("");
            boolean hasRealDefinition = false;
            for (SemanticEntityVersion definitionVersion : languageCalculator
                    .getDescriptionsForComponentOfType(nid, TinkarTerm.DEFINITION_DESCRIPTION_TYPE.nid())) {
                String definition = languageCalculator.getTextFromSemanticVersion(definitionVersion)
                        .map(FoundationFidelityIT::normalized).orElse("");
                if (!definition.isEmpty() && !definition.equals(label) && !definition.equals(regularName)) {
                    hasRealDefinition = true;
                }
            }
            assertTrue(hasRealDefinition,
                    "meaning/purpose concept \"" + languageCalculator.getFullyQualifiedNameText(nid).orElse("nid " + nid)
                            + "\" carries no active definition description whose text says more than its"
                            + " own label — every meaning and purpose must carry a real definition"
                            + " (IKE-Network/ike-issues#892)");
        }
    }
}
