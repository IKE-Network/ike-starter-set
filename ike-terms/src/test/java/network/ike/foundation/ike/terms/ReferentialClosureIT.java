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

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The referential-integrity closure gate at its build home
 * (IKE-Network/ike-issues#937): the IkeFoundation ledger replays into a <em>bare</em>
 * ephemeral store — nothing loaded but this set's own declarations — with closure
 * enforcement on ({@code knowledgeSet.enforceClosure}), so any reference that does not
 * resolve within the set's own declarations fails {@code mvn verify}, naming the
 * offending component and the absent target's public id. This is the invariant a
 * self-contained starter set must hold: the standalone artifact is exactly this store,
 * and a dangling reference here is a dangling reference in every consumer.
 * <p>
 * The concrete defect this gate retires shipped silently before it existed: 37 prose
 * semantics attached to the then-undeclared "Prose element pattern (RichSurfaceTerms)"
 * (now declared by {@link ProseElementSet}), tolerated by the ephemeral store and
 * caught only by a downstream export-count mismatch (IKE-Network/ike-issues#933).
 * <p>
 * One store lifecycle per JVM; failsafe forks one JVM per class (ike-parent), so the
 * enforcement property set here never leaks into {@link FoundationFidelityIT}, whose
 * baseline-seeded store legitimately carries upstream artifacts' own defects and runs
 * with detection only.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReferentialClosureIT {

    /** The property {@code KnowledgeSet.write()} consults for closure fatality. */
    private static final String ENFORCE_CLOSURE_PROPERTY = "knowledgeSet.enforceClosure";

    private static KnowledgeSet set;

    @BeforeAll
    static void composeOnEnforcedBareStore() throws Exception {
        System.setProperty(ENFORCE_CLOSURE_PROPERTY, "true");
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT,
                Files.createTempDirectory("ike-closure").toFile());
        PrimitiveData.selectControllerByName("Load Memory-Only 64-bit Store");
        PrimitiveData.start();
        set = new IkeSource().compose();
    }

    @AfterAll
    static void stop() {
        System.clearProperty(ENFORCE_CLOSURE_PROPERTY);
        PrimitiveData.stop();
    }

    @Test
    @Order(1)
    @DisplayName("The set is closed: every reference resolves within its own declarations")
    void closureHoldsStandalone() {
        assertDoesNotThrow(set::write,
                "The standalone ledger must satisfy referential closure — every semantic,"
                        + " pattern, stamp, field, and axiom reference resolves to a declared"
                        + " component (IKE-Network/ike-issues#937)");
    }

    @Test
    @Order(2)
    @DisplayName("The gate is live: one undeclared reference fails the write, naming the target")
    void undeclaredReferenceFailsNamingTheTarget() {
        // A minimal probe session in the same store: its concept, stamp, and description
        // apparatus all resolve against the already-written foundation — the ONLY
        // dangling reference is the never-declared pattern, which also proves the
        // foundation content above contributed zero.
        KnowledgeSet probe = KnowledgeSet.of("d4c1f8a2-6e73-5b09-9a35-1c8e2f7b6d40");
        probe.concept("Closure probe concept (ClosureProbe)").at(Ike.INCEPTION)
                .semantic(probe.patternRef("Never declared pattern (ClosureProbe)"),
                        PublicIds.of(probe.uuidFor("Closure probe semantic")),
                        "probe prose");

        IllegalStateException violation = assertThrows(IllegalStateException.class, probe::write);
        assertTrue(violation.getMessage().contains("1 dangling"), violation.getMessage());
        assertTrue(violation.getMessage().contains(
                        probe.uuidFor("Never declared pattern (ClosureProbe)").toString()),
                violation.getMessage());
    }
}
