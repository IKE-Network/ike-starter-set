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
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The binding classes committed outside the set are the classes this set generates: the kernel
 * tinkar-core commits ({@code dev.ikm.tinkar.terms.KernelTerm}) and Komet's terms, which Komet's
 * {@code komet-terms} module commits ({@code dev.ikm.komet.terms.KometTerm}). Neither repository
 * can depend on the set it builds or feeds, so each commits the generated class; this test is
 * what keeps them from drifting (see {@link CommittedBindingsDrift}).
 * <p>
 * Every run writes the classes the set generates to {@code target/kernel} and
 * {@code target/komet}; when a committed class differs, copying the generated file over it is
 * the regeneration.
 */
class CommittedBindingsDriftTest {

    private static KnowledgeSet set;

    @BeforeAll
    static void compose() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-kernel").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        set = new IkeSource().compose();
    }

    @AfterAll
    static void stop() {
        PrimitiveData.stop();
    }

    @Test
    @DisplayName("The kernel tinkar-core commits is the kernel the set generates")
    void committedKernelMatchesTheSet() throws Exception {
        Path generated = CommittedBindingsDrift.generate(set, Ike.KERNEL, "kernel");
        Map<String, KnowledgeSet.Declaration> expected = CommittedBindingsDrift.expected(set, Ike.KERNEL);
        assertTrue(expected.size() > 100, "the kernel binds the components tinkar-core names");
        assertCommitted("dev.ikm.tinkar.terms.KernelTerm", expected, generated,
                "tinkar-core/terms/src/main/java/dev/ikm/tinkar/terms/KernelTerm.java");
    }

    @Test
    @DisplayName("The KometTerm Komet commits is the KometTerm the set generates")
    void committedKometTermMatchesTheSet() throws Exception {
        Path generated = CommittedBindingsDrift.generate(set, Ike.KOMET, "komet");
        Map<String, KnowledgeSet.Declaration> expected = CommittedBindingsDrift.expected(set, Ike.KOMET);
        assertTrue(expected.size() > 50, "KometTerm binds the components Komet names");
        assertCommitted("dev.ikm.komet.terms.KometTerm", expected, generated,
                "komet/komet-terms/src/main/java/dev/ikm/komet/terms/KometTerm.java");
    }

    private static void assertCommitted(String className, Map<String, KnowledgeSet.Declaration> expected,
                                        Path generated, String committedAt) throws Exception {
        String regenerate = "regenerate by copying " + generated + " to " + committedAt;
        Class<?> committed;
        try {
            committed = Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("nothing commits " + className + "; " + regenerate);
            return;
        }
        List<String> drift = CommittedBindingsDrift.drift(expected, committed);
        assertEquals(List.of(), drift, "the committed " + className + " has drifted from the set; " + regenerate);
    }
}
