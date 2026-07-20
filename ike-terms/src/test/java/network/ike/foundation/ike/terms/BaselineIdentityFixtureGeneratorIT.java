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
import dev.ikm.tinkar.entity.Entity;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.load.LoadEntitiesFromProtobufFile;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The one-time generator for {@link BaselineIdentityAuditIT}'s frozen fixture
 * (IKE-Network/ike-issues#909). It loads ONLY the pinned baseline artifact — the
 * {@code tinkar-starter-data-unreasoned-pb.zip} the pom stages into
 * {@code target/data} — and dumps every concept and pattern chronology as one TSV row:
 * kind, publicId UUIDs, rendered FQN, latest isA parents, and an ambiguous-history flag
 * (the IKE-Network/ike-issues#875 class, whose "latest" answer is path-coordinate-
 * bootstrap-dependent and therefore exempt from parentage comparison). Rows are sorted
 * for a stable, reviewable diff.
 * <p>
 * Disabled by default: the fixture is committed at
 * {@code src/test/resources/baseline-identity-audit.tsv} and must never drift silently.
 * Rerun the generator ONLY if the pinned baseline artifact coordinates change
 * ({@code tinkar-starter-data.version} in this module's pom), then review and commit the
 * regenerated fixture:
 * <pre>
 *   mvn -o verify -Dit.test=BaselineIdentityFixtureGeneratorIT \
 *       -Dike.audit.fixture.generate=true
 * </pre>
 * One store lifecycle per forked JVM, as everywhere in this suite — which is exactly why
 * generation cannot share {@link BaselineIdentityAuditIT}'s JVM: the audit replays the
 * ledger, while this generator must observe the pristine baseline alone.
 */
@EnabledIfSystemProperty(named = "ike.audit.fixture.generate", matches = "true",
        disabledReason = "fixture generation is a deliberate, manually-invoked act — the frozen"
                + " fixture is the audit's authority and must never regenerate as a side effect")
class BaselineIdentityFixtureGeneratorIT {

    private static StampCalculator calculator;
    private static LanguageCalculator languageCalculator;

    @BeforeAll
    static void loadBaselineOnly() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT,
                Files.createTempDirectory("ike-fixture-generator").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        File baseline = Path.of("target", "data", "tinkar-starter-data-unreasoned-pb.zip").toFile();
        assertTrue(baseline.exists(), "baseline artifact not staged: " + baseline.getAbsolutePath());
        new LoadEntitiesFromProtobufFile(baseline).compute();
        calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
        languageCalculator = Calculators.Language.UsEnglishFullyQualifiedName(calculator.stampCoordinate());
    }

    @AfterAll
    static void stop() {
        PrimitiveData.stop();
    }

    @Test
    @DisplayName("Generate the frozen baseline identity fixture from the pristine baseline artifact")
    void generateFixture() throws Exception {
        TreeSet<String> rows = new TreeSet<>();
        EntityService.get().forEachConceptEntity(concept -> rows.add(row("CONCEPT", concept)));
        EntityService.get().forEachPatternEntity(pattern -> rows.add(row("PATTERN", pattern)));

        List<String> lines = new ArrayList<>();
        lines.add("# Frozen baseline identity fixture (IKE-Network/ike-issues#909) — DO NOT EDIT.");
        lines.add("# One row per baseline concept/pattern chronology of the pinned"
                + " tinkar-starter-data unreasoned-pb artifact.");
        lines.add("# Columns: kind <tab> publicId UUIDs (comma, canonical order) <tab> rendered FQN"
                + " (may be empty) <tab> latest isA parents (parents joined by '|', each parent's"
                + " UUIDs comma-joined, sorted) <tab> ambiguous-history flag ('-' or"
                + " 'ambiguous-history', the IKE-Network/ike-issues#875 class).");
        lines.add("# Regenerate ONLY when the pinned baseline artifact changes — see"
                + " BaselineIdentityFixtureGeneratorIT.");
        lines.addAll(rows);

        Path fixture = Path.of("src", "test", "resources", "baseline-identity-audit.tsv");
        Files.createDirectories(fixture.getParent());
        Files.write(fixture, (String.join("\n", lines) + "\n").getBytes(StandardCharsets.UTF_8));
        System.out.println("BaselineIdentityFixtureGeneratorIT: wrote " + rows.size()
                + " rows to " + fixture.toAbsolutePath());
    }

    /**
     * Renders one fixture row for a baseline chronology.
     *
     * @param kind   {@code "CONCEPT"} or {@code "PATTERN"}
     * @param entity the baseline chronology
     * @return the tab-separated fixture row
     */
    private static String row(String kind, Entity<?> entity) {
        String fqn = languageCalculator.getFullyQualifiedNameText(entity.nid()).orElse("");
        assertFalse(fqn.contains("\t") || fqn.contains("\n") || fqn.contains("|"),
                "FQN would break the fixture format: " + fqn);
        TreeSet<String> parents = new TreeSet<>();
        for (int parentNid : StoreInspection.latestIsAParents(calculator, entity.nid())) {
            parents.add(uuidList(PrimitiveData.publicId(parentNid).asUuidArray()));
        }
        return kind + "\t" + uuidList(entity.publicId().asUuidArray()) + "\t" + fqn + "\t"
                + String.join("|", parents) + "\t"
                + (StoreInspection.hasAmbiguousAxiomHistory(entity.nid()) ? "ambiguous-history" : "-");
    }

    /**
     * Joins UUIDs with commas, preserving the given (canonical publicId) order.
     *
     * @param uuids the UUIDs to join
     * @return the comma-joined form
     */
    private static String uuidList(UUID[] uuids) {
        StringJoiner joiner = new StringJoiner(",");
        for (UUID uuid : uuids) {
            joiner.add(uuid.toString());
        }
        return joiner.toString();
    }
}
