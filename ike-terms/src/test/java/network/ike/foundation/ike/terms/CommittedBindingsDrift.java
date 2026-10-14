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
import dev.ikm.tinkar.terms.EntityFacade;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * A binding class generated from the set and committed where it is used, compared with the
 * enums the set generates now: for each kind, the same constants, each with the set's identity
 * and fully qualified name, and nothing the set lacks. The committing repository cannot depend
 * on the set (the set is built with it), so a committed enum can drift; the tests that use this
 * are what keep it from drifting.
 */
final class CommittedBindingsDrift {

    private CommittedBindingsDrift() {
    }

    /**
     * Writes the enums the set generates for a binding class, below {@code target/<directory>}.
     *
     * @param set          the composed set
     * @param bindingClass the binding class, with a package of its own
     * @param directory    the directory below {@code target}
     * @return the written files, absolute
     * @throws IOException if a file cannot be written
     */
    static List<Path> generate(KnowledgeSet set, BindingClass bindingClass, String directory) throws IOException {
        return BindingsWriter.writeBindingClass(set, bindingClass, Path.of("target", directory)).stream()
                .map(Path::toAbsolutePath).toList();
    }

    /**
     * The constants the set binds in a binding class, of one kind of component, by name.
     *
     * @param set          the composed set
     * @param bindingClass the binding class
     * @param kind         the kind of component
     * @return the declarations by constant name
     */
    static Map<String, KnowledgeSet.Declaration> expected(KnowledgeSet set, BindingClass bindingClass,
                                                          KnowledgeSet.Declaration.Kind kind) {
        Map<String, KnowledgeSet.Declaration> expected = new TreeMap<>();
        for (KnowledgeSet.Declaration declaration : set.declarations()) {
            String constant = declaration.bindings().get(bindingClass);
            if (constant != null && declaration.kind() == kind) {
                expected.put(constant, declaration);
            }
        }
        return expected;
    }

    /**
     * Where a committed enum differs from what the set binds.
     *
     * @param expected  the set's declarations by constant name, of the enum's kind
     * @param committed the committed enum
     * @return one line per difference; empty when none
     */
    static List<String> drift(Map<String, KnowledgeSet.Declaration> expected, Class<?> committed) {
        Map<String, EntityFacade> constants = new TreeMap<>();
        for (Object constant : committed.getEnumConstants()) {
            constants.put(((Enum<?>) constant).name(), (EntityFacade) constant);
        }
        List<String> drift = new ArrayList<>();
        for (String constant : expected.keySet()) {
            if (!constants.containsKey(constant)) {
                drift.add(constant + ": in the set's bindings, not committed");
            }
        }
        for (Map.Entry<String, EntityFacade> entry : constants.entrySet()) {
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
