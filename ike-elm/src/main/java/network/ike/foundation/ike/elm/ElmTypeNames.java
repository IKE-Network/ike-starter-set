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
package network.ike.foundation.ike.elm;

import dev.ikm.tinkar.terms.ConceptFacade;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;

import java.util.Optional;

/**
 * The two spellings of a System type: the qualified name ELM writes, in the braces form, and the
 * catalog's concept for it (IKE-Network/ike-issues#1113). A type of a data model has no concept
 * yet and stays a name.
 */
public final class ElmTypeNames {

    /** The namespace of ELM's System types. */
    public static final String SYSTEM_NAMESPACE = "urn:hl7-org:elm-types:r1";

    private ElmTypeNames() {
    }

    /**
     * The catalog's concept for a System type name.
     *
     * @param bracesName the name in the braces form, for example {@code {urn:hl7-org:elm-types:r1}Integer}
     * @param catalog    the catalog
     * @return the concept, or empty when the name is not a System type the catalog knows
     */
    public static Optional<dev.ikm.tinkar.terms.EntityProxy.Concept> systemType(String bracesName, ElmCatalog catalog) {
        String prefix = "{" + SYSTEM_NAMESPACE + "}";
        if (!bracesName.startsWith(prefix)) {
            return Optional.empty();
        }
        String local = bracesName.substring(prefix.length());
        try {
            return Optional.of(catalog.kind("System " + local).concept());
        } catch (IllegalArgumentException unknown) {
            return Optional.empty();
        }
    }

    /**
     * The braces name of a System type held as a concept.
     *
     * @param concept the concept
     * @param catalog the catalog
     * @return the name, or empty when the concept is not a System type of the catalog
     */
    public static Optional<String> name(ConceptFacade concept, ElmCatalog catalog) {
        Optional<NodeKind> kind = catalog.kindOf(concept.nid());
        if (kind.isEmpty() || !kind.get().name().startsWith("System ")) {
            return Optional.empty();
        }
        return Optional.of("{" + SYSTEM_NAMESPACE + "}" + kind.get().name().substring("System ".length()));
    }
}
