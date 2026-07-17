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
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;

import java.util.UUID;

/**
 * Drops the misleading "display field" wording from the five {@code DisplayFields}-family
 * concepts confirmed, by identity, to be what {@code ConceptToDataType}
 * ({@code dev.ikm.tinkar.terms}, tinkar-core) actually recognizes as a field's real data
 * type — and what every one of this starter set's own 32 patterns' real field declarations
 * actually draws its {@code dataType} tag from (IKE-Network/ike-issues#880 follow-up).
 * <p>
 * "String display field" reads as a UI-rendering construct (KEC), but its identity is
 * {@code TinkarTerm.STRING} — the literal {@code FieldDataType.STRING} — with no separate
 * "how does this render" concept sitting behind it. Confirmed by UUID cross-reference against
 * {@code ConceptToDataType.convert()}'s exact 15-concept recognized set, not by name:
 * {@code String display field} = {@code TinkarTerm.STRING}, {@code Component display field} =
 * {@code COMPONENT_FIELD}, {@code Concept display field (SOLOR)} = {@code CONCEPT_FIELD},
 * {@code DiTree display field} = {@code DITREE_FIELD}, {@code Float display field} =
 * {@code FLOAT_FIELD}. Two of the five ({@code Component}, {@code DiTree}) also carried
 * "display field" language in their own definition text, revised here alongside the FQN so
 * the definition doesn't contradict the new name; the other three's definitions already
 * described the data type itself without that framing, so they are left untouched.
 * <p>
 * Deliberately not touched: the remaining {@code DisplayFields} members
 * ({@code Boolean}/{@code Integer}/{@code Decimal}/{@code Double}/{@code ByteArray}/
 * {@code Image}/{@code UUID display field}, {@code ComponentIdDisplayList}/
 * {@code ComponentIdDisplaySet}, {@code DiGraphDisplayField}, {@code LogicalExpressionDisplayField},
 * {@code SemanticDisplayFieldType}) — this pass only renames identities independently
 * confirmed against real field usage in this starter set; the rest keep their current names
 * until each is checked the same way. Also not touched: {@code Dynamic column data types}
 * and its own children, a separate, disjoint family now reparented under {@code Legacy} by
 * {@link LegacyTerminologySet} — never what a pattern's own field declaration draws from,
 * regardless of the confusingly similar names.
 */
final class DataTypeTerminologySet {

    private DataTypeTerminologySet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // Later than every other authoring pass in this project (2026-07-12/-13/-15/-16/-17/-18):
        // this file revises already-adopted concepts' own descriptions, so it must follow
        // every scope that already touches them.
        ActiveStamp dataType = Stamp.active("2026-07-19T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        set.concept("String display field").at(dataType)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("26bed67f-21b7-4623-a6b9-246afe790e95")),
                        IkeTerm.ENGLISH_LANGUAGE, "String data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

        set.concept("Component display field").at(dataType)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("09cf7374-aa84-4ea9-91cc-793182cca0da")),
                        IkeTerm.ENGLISH_LANGUAGE, "Component data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("3ed2ec1f-e5a4-42d0-916e-f7f555f58204")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "A field that identifies any component -- concept, semantic, pattern, or"
                                + " STAMP -- by reference, not restricted to concepts.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Concept display field (SOLOR)").at(dataType)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("ff9a1615-8006-4168-8417-921f0fe5ee15")),
                        IkeTerm.ENGLISH_LANGUAGE, "Concept data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

        set.concept("DiTree display field").at(dataType)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("42547119-239c-4901-82d9-e49c6e2734fb")),
                        IkeTerm.ENGLISH_LANGUAGE, "DiTree data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("2eca023f-90a9-4aaf-a835-b19d8ea1c8a7")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "A field that holds a directed tree graph obtained from an undirected"
                                + " tree by replacing each undirected edge with two directed edges"
                                + " of opposite direction.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        set.concept("Float display field").at(dataType)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("176c19e5-cd96-4a35-9d69-b2cfdaa95bb4")),
                        IkeTerm.ENGLISH_LANGUAGE, "Float data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);
    }
}
