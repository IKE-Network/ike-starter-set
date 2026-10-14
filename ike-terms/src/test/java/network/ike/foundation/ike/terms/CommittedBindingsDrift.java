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
import dev.ikm.tinkar.entity.builder.BindingClass;
import dev.ikm.tinkar.entity.builder.BindingsWriter;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * A binding class generated from the set and committed where it is used, compared with the
 * class the set generates now: the same constants, each with the set's identity and fully
 * qualified name, and nothing the set lacks. The committing repository cannot depend on the set
 * (the set is built with it), so a committed class can drift; the tests that use this are what
 * keep it from drifting.
 */
final class CommittedBindingsDrift {

    private CommittedBindingsDrift() {
    }

    /**
     * Writes the class the set generates for a binding class, below {@code target/<directory>}.
     *
     * @param set          the composed set
     * @param bindingClass the binding class, with a package of its own
     * @param directory    the directory below {@code target}
     * @return the absolute path of the generated source
     * @throws IOException if the file cannot be written
     */
    static Path generate(KnowledgeSet set, BindingClass bindingClass, String directory) throws IOException {
        return BindingsWriter.writeBindingClass(set, bindingClass, Path.of("target", directory)).toAbsolutePath();
    }

    /**
     * The set's bindings in a binding class, by constant.
     *
     * @param set          the composed set
     * @param bindingClass the binding class
     * @return each constant's declaration
     */
    static Map<String, KnowledgeSet.Declaration> expected(KnowledgeSet set, BindingClass bindingClass) {
        Map<String, KnowledgeSet.Declaration> expected = new TreeMap<>();
        for (KnowledgeSet.Declaration declaration : set.declarations()) {
            String constant = declaration.bindings().get(bindingClass);
            if (constant != null) {
                expected.put(constant, declaration);
            }
        }
        return expected;
    }

    /**
     * How the committed class differs from the set's bindings: constants one has and the other
     * lacks, and constants whose UUIDs or fully qualified name differ.
     *
     * @param expected  the set's bindings, by constant
     * @param committed the committed class
     * @return one line per difference; empty when there is none
     * @throws IllegalAccessException if a constant cannot be read
     */
    static List<String> drift(Map<String, KnowledgeSet.Declaration> expected, Class<?> committed)
            throws IllegalAccessException {
        Map<String, EntityProxy> constants = new TreeMap<>();
        for (Field field : committed.getFields()) {
            if (Modifier.isStatic(field.getModifiers()) && EntityProxy.class.isAssignableFrom(field.getType())) {
                constants.put(field.getName(), (EntityProxy) field.get(null));
            }
        }
        List<String> drift = new ArrayList<>();
        for (String constant : expected.keySet()) {
            if (!constants.containsKey(constant)) {
                drift.add(constant + ": in the set's bindings, not committed");
            }
        }
        for (Map.Entry<String, EntityProxy> entry : constants.entrySet()) {
            KnowledgeSet.Declaration declaration = expected.get(entry.getKey());
            if (declaration == null) {
                drift.add(entry.getKey() + ": committed, not in the set's bindings");
                continue;
            }
            PublicId committedId = entry.getValue().publicId();
            // Every UUID, as a set: public ids match on any UUID, in any order, and a binding must
            // lose none.
            if (!Set.of(declaration.publicId().asUuidArray()).equals(Set.of(committedId.asUuidArray()))) {
                drift.add(entry.getKey() + ": committed as " + committedId.idString()
                        + ", the set has " + declaration.publicId().idString());
            }
            if (!declaration.birthFqn().equals(entry.getValue().description())) {
                drift.add(entry.getKey() + ": committed as \"" + entry.getValue().description()
                        + "\", the set names it \"" + declaration.birthFqn() + "\"");
            }
        }
        return drift;
    }
}
