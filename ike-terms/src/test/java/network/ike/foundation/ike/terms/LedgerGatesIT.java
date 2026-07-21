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
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.constraint.MemberMatchEvaluator;
import dev.ikm.tinkar.entity.graph.DiGraphEntity;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The default content-gate suite for the IkeFoundation ledger
 * (IKE-Network/ike-issues#909): every gate here interrogates OUR authored content, in
 * absolute terms, against an ephemeral ledger-only store — the {@link IkeSource} replayed
 * into a fresh store exactly the way {@link LedgerReplayTest} and every product store
 * (the extraction, ike-kb, the release changeset) is built. No baseline artifact is
 * loaded: the Tinkar starter data was a one-time input whose value is captured in the
 * ledger (KEC ruling, 2026-07-19), so these gates are free of every layered-store
 * resolution quirk (the IKE-Network/ike-issues#875 class) and answer faster than the
 * retired {@code FoundationFidelityIT} replay scaffold they descend from.
 * <p>
 * The other two purposes that scaffold served now live in cleanly-split homes:
 * {@link BaselineIdentityAuditIT} carries the enduring interop guarantee (identity
 * compatibility with the installed base, against a frozen fixture), and
 * {@link ConsumerMergeIT} models the in-the-field merge a consumer performs
 * (release-gate cadence).
 * <p>
 * One store lifecycle for the whole class (a second {@code PrimitiveData} lifecycle
 * cannot start once the first stops within a JVM; surefire/failsafe fork one JVM per
 * class): the ledger is replayed once in {@link #replayLedger()}, then every
 * {@code @Test} method inspects that same store.
 */
class LedgerGatesIT {

    private static StampCalculator calculator;
    private static LanguageCalculator languageCalculator;

    /**
     * The absolute concept count of the ledger-only store — the
     * IKE-Network/ike-issues#909 reframing of the retired baseline-relative arithmetic
     * ({@code conceptsBefore + INGEST_BOOTSTRAP_CONCEPTS + AUTHORED_CONTENT_CONCEPTS}):
     * 379 concepts transcribed from the one-time starter-data input, plus the 3
     * identity-exact-ingest bootstrap concepts (the module, the root, IKE Community,
     * IKE-Network/ike-issues#872), plus the 86 deliberately-authored new concepts whose
     * composition {@link ConsumerMergeIT#AUTHORED_CONTENT_CONCEPTS} itemizes
     * set-by-set (IKE-Network/ike-issues#880, #885, #890, #891), plus the 21
     * taxonomy-organization structural concepts (20 from IKE-Network/ike-issues#915,
     * View coordinate model from the #918 root refinement) {@code ModelOrganizationSet} mints
     * (IKE-Network/ike-issues#915). Grow this number only
     * in the same change that authors new concepts — the gate refuses accidental
     * minting and accidental loss alike.
     */
    private static final int LEDGER_CONCEPTS = 489;

    /**
     * The absolute pattern count of the ledger-only store: 28 patterns transcribed from
     * the one-time starter-data input plus the 6 deliberately-authored new patterns
     * {@link ConsumerMergeIT#AUTHORED_CONTENT_PATTERNS} itemizes (Taxonomy Field
     * Constraint Pattern, Value-set Field Constraint Pattern, Starter Set Author Roster
     * Pattern, Preferred Reviewer Pattern, Solor Concepts Pattern, Data Type Defaults
     * Pattern — IKE-Network/ike-issues#880, #885, #890).
     */
    private static final int LEDGER_PATTERNS = 34;

    @BeforeAll
    static void replayLedger() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT,
                Files.createTempDirectory("ike-ledger-gates").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        // The real, compiled, committed source — not a temp-dir stand-in.
        new IkeSource().compose().write();
        calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
        languageCalculator = Calculators.Language.UsEnglishFullyQualifiedName(calculator.stampCoordinate());
    }

    @AfterAll
    static void stop() {
        PrimitiveData.stop();
    }

    @Test
    @DisplayName("The store holds exactly the declared ledger: chronology counts equal declaration"
            + " counts, at the pinned absolute numbers (IKE-Network/ike-issues#909)")
    void storeHoldsExactlyTheDeclaredLedger() {
        long declaredConcepts = Ike.SET.declarations().stream()
                .filter(declaration -> declaration.kind() == KnowledgeSet.Declaration.Kind.CONCEPT)
                .count();
        long declaredPatterns = Ike.SET.declarations().stream()
                .filter(declaration -> declaration.kind() == KnowledgeSet.Declaration.Kind.PATTERN)
                .count();
        int[] conceptChronologies = {0};
        EntityService.get().forEachConceptEntity(concept -> conceptChronologies[0]++);
        int[] patternChronologies = {0};
        EntityService.get().forEachPatternEntity(pattern -> patternChronologies[0]++);

        assertEquals(declaredConcepts, conceptChronologies[0],
                "every declared concept writes exactly one chronology and nothing else may mint"
                        + " one — a mismatch means the replay minted or lost a concept");
        assertEquals(declaredPatterns, patternChronologies[0],
                "every declared pattern writes exactly one chronology and nothing else may mint"
                        + " one — a mismatch means the replay minted or lost a pattern");
        assertEquals(LEDGER_CONCEPTS, declaredConcepts,
                "the ledger declares exactly " + LEDGER_CONCEPTS + " concepts (379 transcribed"
                        + " + 3 ingest bootstrap + 86 authored — see LEDGER_CONCEPTS); grow the pin"
                        + " only in the same change that deliberately authors new concepts");
        assertEquals(LEDGER_PATTERNS, declaredPatterns,
                "the ledger declares exactly " + LEDGER_PATTERNS + " patterns (28 transcribed"
                        + " + 6 authored — see LEDGER_PATTERNS); grow the pin only in the same"
                        + " change that deliberately authors new patterns");
    }

    @Test
    @DisplayName("The store's entire stamp set is exactly the inception pair: the foundation-module"
            + " stamp and its Defaults-module counterpart, both at the platform's named inception"
            + " instant (IKE-Network/ike-issues#894, reframed ledger-only by #909)")
    void storeStampSetIsExactlyTheInceptionPair() {
        assertEquals(PrimitiveData.INCEPTION_EPOCH, Ike.INCEPTION.time(),
                "the pair's declared time is the platform's named inception instant, which"
                        + " renders as the word \"Inception\" on every surface (KEC ruling,"
                        + " IKE-Network/ike-issues#894)");
        assertEquals(UUID.fromString("770cba9b-6970-5a98-8049-e82383905086"),
                Ike.INCEPTION.publicId().asUuidArray()[0],
                "the foundation inception tuple must derive the stamp identity the guide's"
                        + " badge-anatomy figure features — the tuple is part of the published"
                        + " knowledge-state");

        Set<Integer> inceptionPair = Set.of(PrimitiveData.nid(Ike.INCEPTION.publicId()),
                PrimitiveData.nid(Ike.DEFAULTS_INCEPTION.publicId()));
        // Stronger than the retired replay-introduced-versus-baseline difference: in a
        // ledger-only store there is no "before", so the WHOLE stamp inventory must be
        // the pair — any other stamp entity means a working-day or revision layer
        // survived the flatten, or a third stamp appeared without editing Ike. One
        // platform sentinel is exempt: StampRecord.nonExistentStamp()
        // (PrimitiveData.NONEXISTENT_STAMP_UUID — Primordial · Pre-inception · Author ·
        // Uninitialized · Uninitialized), which the entity write machinery mints to mark
        // "not yet created at any visible point in history". It is bookkeeping, not
        // provenance; the footprint assertion below proves it carries no content version.
        Set<Integer> allStampNids = new HashSet<>();
        PrimitiveData.get().forEachStampNid(allStampNids::add);
        allStampNids.remove(PrimitiveData.nid(PrimitiveData.NONEXISTENT_STAMP_UUID));
        assertEquals(inceptionPair, allStampNids,
                "the ledger store's entire stamp inventory (platform non-existent-stamp sentinel"
                        + " aside) must be exactly the two declared inception stamps"
                        + " (IKE-Network/ike-issues#894)");
        assertEquals(inceptionPair, StoreInspection.versionStampNids(),
                "every concept, pattern, and semantic version must carry one of the two declared"
                        + " inception stamps — nothing, not even the platform sentinel, may stamp"
                        + " content otherwise (IKE-Network/ike-issues#894)");
    }

    @Test
    @DisplayName("The three upstream placeholder seeds on Default Data Concept are absent from the"
            + " ledger — never referenced, never authored (IKE-Network/ike-issues#887, reframed"
            + " ledger-only by #909)")
    void notAdoptedSeedsAreAbsentFromTheLedger() {
        for (UUID uuid : BaselineIdentityAuditIT.DELIBERATELY_NOT_ADOPTED_SEMANTIC_UUIDS) {
            assertFalse(PrimitiveData.get().hasUuid(uuid),
                    "upstream placeholder seed semantic " + uuid + " is known to the ledger store"
                            + " — the ledger must neither author nor reference it"
                            + " (IKE-Network/ike-issues#887); only a consumer's baseline artifact"
                            + " may carry it (see ConsumerMergeIT)");
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
     * @return the attachment concept's nid in the ledger store
     */
    private static int defaultValueConceptNid() {
        return PrimitiveData.nid(Ike.SET.uuidFor("Default value concept (IkeFoundation)"));
    }

    /**
     * Resolves the nid of {@code Defaults and templates module (IkeFoundation)} — the
     * module every defaults/template chronology lives and dies in
     * (IKE-Network/ike-issues#885).
     *
     * @return the module concept's nid in the ledger store
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
     * @return the attachment concepts' nids in the ledger store
     */
    private static Set<Integer> attachmentConceptNids() {
        Set<Integer> attachments = new HashSet<>();
        attachments.add(defaultValueConceptNid());
        int templateConceptNid = PrimitiveData.nid(Ike.SET.uuidFor("Template concept (IkeFoundation)"));
        EntityService.get().forEachConceptEntity(concept -> {
            if (StoreInspection.latestIsAParents(calculator, concept.nid()).contains(templateConceptNid)) {
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
        assertEquals(PrimitiveData.PRE_INCEPTION_INSTANT, values.get(13),
                "Instant default is the pre-inception instant");
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
            if (StoreInspection.latestIsAParents(calculator, concept.nid()).contains(parentNid)) {
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
                    .map(LedgerGatesIT::normalized).orElse("");
            String regularName = languageCalculator.getRegularDescriptionText(nid)
                    .map(LedgerGatesIT::normalized).orElse("");
            boolean hasRealDefinition = false;
            for (SemanticEntityVersion definitionVersion : languageCalculator
                    .getDescriptionsForComponentOfType(nid, TinkarTerm.DEFINITION_DESCRIPTION_TYPE.nid())) {
                String definition = languageCalculator.getTextFromSemanticVersion(definitionVersion)
                        .map(LedgerGatesIT::normalized).orElse("");
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

    @Test
    @DisplayName("Role dual-parents derive from pattern declarations: every concept a pattern's"
            + " latest version uses as meaning/purpose carries that role umbrella as a parent, and"
            + " no dual-parented concept asserts a role umbrella the declarations don't back"
            + " (IKE-Network/ike-issues#918)")
    void roleParentsDeriveFromPatternDeclarations() {
        int meaningNid = PrimitiveData.nid(BaselineIdentityAuditIT.MEANING_UMBRELLA);
        int purposeNid = PrimitiveData.nid(BaselineIdentityAuditIT.PURPOSE_UMBRELLA);
        java.util.Set<Integer> derivedMeanings = new java.util.HashSet<>();
        java.util.Set<Integer> derivedPurposes = new java.util.HashSet<>();
        EntityService.get().forEachPatternEntity(pattern -> {
            PatternEntityVersion version =
                    calculator.latestPatternEntityVersion(pattern.nid()).get();
            derivedMeanings.add(version.semanticMeaningNid());
            derivedPurposes.add(version.semanticPurposeNid());
            for (FieldDefinitionForEntity field : version.fieldDefinitions()) {
                derivedMeanings.add(field.meaningNid());
                derivedPurposes.add(field.purposeNid());
            }
        });
        // Positive direction, in full: every in-use role concept asserts its umbrella.
        for (int nid : derivedMeanings) {
            assertTrue(StoreInspection.latestIsAParents(calculator, nid).contains(meaningNid),
                    "in-use meaning concept lacks the Meaning role parent: "
                            + PrimitiveData.text(nid));
        }
        for (int nid : derivedPurposes) {
            assertTrue(StoreInspection.latestIsAParents(calculator, nid).contains(purposeNid),
                    "in-use purpose concept lacks the Purpose role parent: "
                            + PrimitiveData.text(nid));
        }
        // Reverse direction, over dual-parented concepts: a role umbrella asserted
        // alongside any other parent must be backed by an actual declaration. The
        // umbrellas' inherited single-parent vocabulary children (Literal value, Query
        // clauses, ...) are legacy filing, not role assertions, and stay exempt — their
        // rehoming is tracked follow-up, not silent tolerance.
        EntityService.get().forEachConceptEntity(concept -> {
            java.util.Set<Integer> parents = StoreInspection.latestIsAParents(calculator, concept.nid());
            if (parents.size() < 2) {
                return;
            }
            if (parents.contains(meaningNid)) {
                assertTrue(derivedMeanings.contains(concept.nid()),
                        "stale Meaning role parent — no pattern declaration backs it: "
                                + PrimitiveData.text(concept.nid()));
            }
            if (parents.contains(purposeNid)) {
                assertTrue(derivedPurposes.contains(concept.nid()),
                        "stale Purpose role parent — no pattern declaration backs it: "
                                + PrimitiveData.text(concept.nid()));
            }
        });
    }

    /**
     * The IKE-Network/ike-issues#922 name-fidelity lock: every concept carries at least
     * one definition, and no definition merely echoes the concept's own labels. The
     * sweep paid down the whole debt (84 echo rewrites, 27 first definitions); these
     * gates keep it paid — the set-wide generalization of the meaning/purpose-only
     * definition gate from IKE-Network/ike-issues#892.
     */
    @Test
    @DisplayName("Every concept has a definition, and no definition echoes its labels"
            + " (IKE-Network/ike-issues#922)")
    void everyConceptHasANonEchoDefinition() {
        int defType = TinkarTerm.DEFINITION_DESCRIPTION_TYPE.nid();
        int fqnType = TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE.nid();
        int regType = TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE.nid();
        java.util.List<String> missing = new java.util.ArrayList<>();
        java.util.List<String> echoes = new java.util.ArrayList<>();
        java.util.List<String> questions = new java.util.ArrayList<>();
        java.util.List<String> stubs = new java.util.ArrayList<>();
        EntityService.get().forEachConceptEntity(concept -> {
            java.util.List<String> labels = new java.util.ArrayList<>();
            java.util.List<String> definitions = new java.util.ArrayList<>();
            EntityService.get().forEachSemanticForComponentOfPattern(concept.nid(),
                    TinkarTerm.DESCRIPTION_PATTERN.nid(), semantic ->
                calculator.latest(semantic).ifPresent(version -> {
                    SemanticEntityVersion semanticVersion = (SemanticEntityVersion) version;
                    String text = (String) semanticVersion.fieldValues().get(1);
                    int type = ((EntityFacade) semanticVersion.fieldValues().get(3)).nid();
                    if (type == defType) {
                        definitions.add(text);
                    } else if (type == fqnType || type == regType) {
                        labels.add(text);
                    }
                }));
            if (definitions.isEmpty()) {
                missing.add(PrimitiveData.text(concept.nid()));
                return;
            }
            for (String definition : definitions) {
                String normalizedDefinition = normalizeLabel(definition);
                if (normalizedDefinition.isEmpty()
                        || labels.stream().anyMatch(label -> normalizeLabel(label).equals(normalizedDefinition))) {
                    echoes.add(PrimitiveData.text(concept.nid()) + " := \"" + definition + "\"");
                    continue;
                }
                // A definition must DEFINE (IKE-Network/ike-issues#926). Two further
                // failures the echo test alone lets through, both found in inherited
                // baseline text: authoring uncertainty committed as knowledge, and
                // stubs that restate the label in fewer words than the label itself.
                if (definition.trim().endsWith("?")) {
                    questions.add(PrimitiveData.text(concept.nid()) + " := \"" + definition + "\"");
                    continue;
                }
                java.util.Set<String> definitionWords = substantiveWords(normalizedDefinition);
                java.util.Set<String> labelWords = new java.util.HashSet<>();
                labels.forEach(label -> labelWords.addAll(substantiveWords(normalizeLabel(label))));
                java.util.Set<String> novelWords = new java.util.HashSet<>(definitionWords);
                novelWords.removeAll(labelWords);
                if (definitionWords.size() < MINIMUM_SUBSTANTIVE_WORDS || novelWords.isEmpty()) {
                    stubs.add(PrimitiveData.text(concept.nid()) + " := \"" + definition + "\"");
                }
            }
        });
        assertEquals(java.util.List.of(), missing,
                "concepts without any definition — every concept must say what it is");
        assertEquals(java.util.List.of(), echoes,
                "definitions that echo the concept's own labels say nothing — write a real one");
        assertEquals(java.util.List.of(), questions,
                "a definition ending in '?' is authoring uncertainty, not knowledge — settle it or leave"
                        + " the concept undefined and file the question");
        assertEquals(java.util.List.of(), stubs,
                "definitions carrying fewer than " + MINIMUM_SUBSTANTIVE_WORDS + " substantive words beyond"
                        + " the concept's own labels restate the name instead of defining it");
    }

    /**
     * The substance floor: how many content words a definition must carry, on top of
     * carrying at least one word its labels do not. Four is the empirical floor the
     * IKE-Network/ike-issues#926 wave settled on — enough to reject "Data type",
     * "Version time", and "Operator", low enough to admit terse but genuine definitions
     * like "The field holding an interval's lower bound value".
     */
    private static final int MINIMUM_SUBSTANTIVE_WORDS = 4;

    /** Content words of normalized text, with the grammatical filler dropped. */
    private static java.util.Set<String> substantiveWords(String normalizedText) {
        java.util.Set<String> filler = java.util.Set.of(
                "the", "a", "an", "of", "for", "to", "in", "on", "and", "or", "is", "are", "be",
                "by", "with", "that", "this", "it", "as", "at", "from", "its", "their", "which",
                "what", "when", "how", "not", "no", "any", "each", "every", "one", "some", "such",
                "other", "than", "then", "there", "these", "those", "concept", "used", "value");
        java.util.Set<String> words = new java.util.HashSet<>();
        for (String word : normalizedText.split(" ")) {
            if (word.length() > 2 && !filler.contains(word)) {
                words.add(word);
            }
        }
        return words;
    }

    /** Case-, punctuation-, and qualifier-insensitive label normalization for the echo gate. */
    private static String normalizeLabel(String text) {
        String withoutQualifier = text.replaceAll(
                "\\s*\\((SOLOR|Solor|IkeFoundation|IKE|User|Language|foundation metadata concept)\\)\\s*$", "");
        return withoutQualifier.toLowerCase().replaceAll("[^a-z0-9]+", " ").trim();
    }
}
