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
package network.ike.foundation.ike.model;

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;

import java.util.UUID;

/**
 * Where every imported model component gets its identity (IKE-Network/ike-issues#1115):
 * derived, never random. A model is identified by its name and its version, or its name alone
 * when the file gives none; a class by its model, its version, and its qualified name; an
 * element by its class and its name; a context by its model and its name; a relationship by
 * its class, its context, and the element it reaches the context by, since a class may reach
 * one context by several elements; a conversion by its two types and its function; and everything
 * hung on a component, its record and its descriptions, from the component's own identity.
 */
public final class ModelIdentity {

    /** The namespace every model information identity is derived under. */
    public static final UUID NAMESPACE = UUID.fromString("4d8b1e6a-7c2f-5a3e-9f10-2b6c8d4e1a75");

    private ModelIdentity() {
    }

    private static PublicId of(String seed) {
        return PublicIds.of(UuidT5Generator.get(NAMESPACE, seed));
    }

    private static String modelSeed(String name, String version) {
        return "Data model " + name + (version.isEmpty() ? "" : " " + version);
    }

    /**
     * The concept for a model at a version.
     *
     * @param name    the model's name as the file writes it
     * @param version the version as written, empty when the file gives none
     * @return the identity
     */
    public static PublicId model(String name, String version) {
        return of(modelSeed(name, version));
    }

    /**
     * The concept for a class of a model.
     *
     * @param name          the model's name
     * @param version       the model's version, empty when none
     * @param qualifiedName the class's name qualified by its model, for example {@code FHIR.Condition}
     * @return the identity
     */
    public static PublicId classOf(String name, String version, String qualifiedName) {
        return of(modelSeed(name, version) + " class " + qualifiedName);
    }

    /**
     * The record of an element, hung on its class.
     *
     * @param classId     the class
     * @param elementName the element's name
     * @return the identity
     */
    public static PublicId element(PublicId classId, String elementName) {
        return PublicIds.of(UuidT5Generator.get(classId.asUuidArray()[0], "element " + elementName));
    }

    /**
     * The record of a context, hung on its model.
     *
     * @param name        the model's name
     * @param version     the model's version, empty when none
     * @param contextName the context's name
     * @return the identity
     */
    public static PublicId context(String name, String version, String contextName) {
        return of(modelSeed(name, version) + " context " + contextName);
    }

    /**
     * The record of a relationship from a class to a context, hung on the class.
     *
     * @param classId     the class
     * @param contextName the context's name
     * @param keyElement  the element by which the class reaches the context
     * @param toTarget    whether the file declares it on the target model
     * @return the identity
     */
    public static PublicId relationship(PublicId classId, String contextName, String keyElement, boolean toTarget) {
        return PublicIds.of(UuidT5Generator.get(classId.asUuidArray()[0],
                (toTarget ? "target relationship " : "relationship ") + contextName + " by " + keyElement));
    }

    /**
     * The record of a conversion, hung on the type converted from.
     *
     * @param fromClassId  the type converted from
     * @param toType       the type converted to, as written
     * @param functionName the function, as written
     * @return the identity
     */
    public static PublicId conversion(PublicId fromClassId, String toType, String functionName) {
        return PublicIds.of(UuidT5Generator.get(fromClassId.asUuidArray()[0],
                "conversion to " + toType + " by " + functionName));
    }

    /**
     * The record of a requirement, hung on the model that requires.
     *
     * @param modelId         the requiring model
     * @param requiredName    the required model's name
     * @param requiredVersion the required model's version, as written
     * @return the identity
     */
    public static PublicId requirement(PublicId modelId, String requiredName, String requiredVersion) {
        return PublicIds.of(UuidT5Generator.get(modelId.asUuidArray()[0],
                "requires " + requiredName + " " + requiredVersion));
    }

    /**
     * The record semantic hung on a component: the model, class, or mark record.
     *
     * @param component the component
     * @return the identity
     */
    public static PublicId record(PublicId component) {
        return PublicIds.of(UuidT5Generator.get(component.asUuidArray()[0], "model information record"));
    }

    /**
     * A description or dialect semantic hung on a component, by its role.
     *
     * @param component the component
     * @param role      the role, for example {@code fqn}, {@code name}, {@code label}, or {@code definition}
     * @return the identity
     */
    public static UUID description(PublicId component, String role) {
        return UuidT5Generator.get(component.asUuidArray()[0], role);
    }

    /**
     * A vertex of an element's type specifier tree, by its path from the root.
     *
     * @param elementId the element record
     * @param path      the path of positions from the root
     * @return the vertex's identity
     */
    public static UUID vertex(PublicId elementId, String path) {
        return UuidT5Generator.get(elementId.asUuidArray()[0], "vertex " + path);
    }
}
