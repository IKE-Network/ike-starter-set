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

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.entity.builder.BindingsWriter;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The kernel tinkar-core commits ({@code dev.ikm.tinkar.terms.KernelTerm}) is the kernel this
 * set generates: the same constants, each with the set's identity and fully qualified name, and
 * nothing the set lacks. tinkar-core cannot depend on the set it builds, so it commits the
 * generated class; this test is what keeps the two from drifting.
 * <p>
 * Every run writes the class the set generates to {@code target/kernel}; when the committed
 * class differs, copying that file into tinkar-core's {@code terms} module is the regeneration.
 */
class KernelDriftTest {

    private static final String KERNEL_CLASS = "dev.ikm.tinkar.terms.KernelTerm";
    private static final String COMMITTED_AT = "tinkar-core/terms/src/main/java/dev/ikm/tinkar/terms/KernelTerm.java";

    private static KnowledgeSet set;
    private static Path generated;

    @BeforeAll
    static void compose() throws Exception {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-kernel").toFile());
        PrimitiveData.selectControllerByName("Load Ephemeral Store");
        PrimitiveData.start();
        set = new IkeSource().compose();
        generated = BindingsWriter.writeBindingClass(set, Ike.KERNEL, Path.of("target", "kernel")).toAbsolutePath();
    }

    @AfterAll
    static void stop() {
        PrimitiveData.stop();
    }

    @Test
    @DisplayName("The kernel tinkar-core commits is the kernel the set generates")
    void committedKernelMatchesTheSet() throws Exception {
        Map<String, KnowledgeSet.Declaration> expected = new TreeMap<>();
        for (KnowledgeSet.Declaration declaration : set.declarations()) {
            String constant = declaration.bindings().get(Ike.KERNEL);
            if (constant != null) {
                expected.put(constant, declaration);
            }
        }
        assertTrue(expected.size() > 100, "the kernel binds the components tinkar-core names");

        Class<?> kernel;
        try {
            kernel = Class.forName(KERNEL_CLASS);
        } catch (ClassNotFoundException e) {
            fail("tinkar-core has no " + KERNEL_CLASS + "; " + regenerate());
            return;
        }
        Map<String, EntityProxy> committed = new TreeMap<>();
        for (Field field : kernel.getFields()) {
            if (Modifier.isStatic(field.getModifiers()) && EntityProxy.class.isAssignableFrom(field.getType())) {
                committed.put(field.getName(), (EntityProxy) field.get(null));
            }
        }

        List<String> drift = new ArrayList<>();
        for (String constant : expected.keySet()) {
            if (!committed.containsKey(constant)) {
                drift.add(constant + ": in the set's kernel, not committed");
            }
        }
        for (Map.Entry<String, EntityProxy> entry : committed.entrySet()) {
            KnowledgeSet.Declaration declaration = expected.get(entry.getKey());
            if (declaration == null) {
                drift.add(entry.getKey() + ": committed, not in the set's kernel");
                continue;
            }
            PublicId committedId = entry.getValue().publicId();
            // Every UUID, as a set: public ids match on any UUID, in any order, and a binding must
            // lose none (tinkar-core's KernelTermIdentityTest holds the kernel to TinkarTerm likewise).
            if (!java.util.Set.of(declaration.publicId().asUuidArray()).equals(java.util.Set.of(committedId.asUuidArray()))) {
                drift.add(entry.getKey() + ": committed as " + committedId.idString()
                        + ", the set has " + declaration.publicId().idString());
            }
            if (!declaration.birthFqn().equals(entry.getValue().description())) {
                drift.add(entry.getKey() + ": committed as \"" + entry.getValue().description()
                        + "\", the set names it \"" + declaration.birthFqn() + "\"");
            }
        }
        assertEquals(List.of(), drift, "the committed kernel has drifted from the set; " + regenerate());
    }

    private static String regenerate() {
        return "regenerate by copying " + generated + " to " + COMMITTED_AT;
    }
}
