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
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.GraphFieldValue;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

/**
 * The Data Type Defaults Pattern (IKE-Network/ike-issues#885): one pattern with sixteen
 * fields, one per data type {@code ConceptToDataType} ({@code dev.ikm.tinkar.terms},
 * tinkar-core) recognizes, declared in that class's own convert order — String,
 * Component, ComponentIdSet, ComponentIdList, DiTree, DiGraph, Concept, Semantic,
 * Integer, Float, Boolean, ByteArray, Array, Instant, Long, Decimal. Each field's
 * {@code dataType} is the concept {@code ConceptToDataType} actually recognizes for that
 * type, verified by UUID against its {@code TinkarTerm} references and bound through
 * {@link IkeTerm}'s declared identities. The pattern's single semantic is its own default value semantic
 * ({@link DefaultsAndTemplatesSet}'s apparatus, extended here in a sibling file composed
 * immediately after it — the apparatus file mints the category; this file is its first
 * full-breadth consumer): referenced component {@code Default value concept}, computed
 * {@code singleSemanticUuid} identity, every version in the Defaults and templates
 * module. Replaying that one semantic writes and reads every field data type the store
 * supports — the ledger's serialization smoke test.
 * <p>
 * <b>The loud-defaults principle (KEC-decided)</b>: never Java's silent zero-values. A
 * default works as an initial value but must read as obviously needing revision —
 * {@code "UNINITIALIZED"}, not {@code ""}; a planted repdigit, not {@code 0}. Types
 * whose value space offers a true non-value use it (Float's {@code NaN}, Instant's
 * pre-inception instant — a non-value cannot be mistaken for data at all, and {@code NaN}
 * propagates through arithmetic); numeric types without one use the stretched-sevens
 * sentinel ({@code 777777777}, {@code 777777777777777777},
 * {@code 777777777.777} — repdigit signatures that read as deliberately planted, where
 * {@code MIN_VALUE} would read as an overflow bug); Boolean's {@code false} is a flagged
 * compromise, stated in its meaning concept's definition. The DiGraph default is a
 * deliberate two-vertex simple cycle: a cycle can never be a tree, so the value proves
 * the field truly carries a graph.
 * <p>
 * <b>The datatype-concept renames</b> the anchored {@code DisplayFields}-family
 * concepts carry ("&lt;Type&gt; data type" in place of the misleading "display field"
 * wording) live at their section declarations ({@code foundation.Section19}, registered
 * in {@code DELIBERATELY_RENAMED_FQNS}) under the inception flatten
 * (IKE-Network/ike-issues#894). Every ConceptToDataType-anchored datatype concept is
 * named "... data type"; deliberately untouched are only the unanchored
 * {@code Double}/{@code Image}/{@code UUID display field} and
 * {@code Logical expression display field}, which {@code ConceptToDataType} does not
 * recognize.
 */
final class DataTypeDefaultsSet {

    private DataTypeDefaultsSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // The one declared inception stamp of the pre-release set
        // (IKE-Network/ike-issues#894): apparatus concepts are foundation terminology,
        // so they stamp in the foundation module.
        ActiveStamp apparatus = Ike.INCEPTION;

        // ── The sixteen field meaning concepts ──────────────────────────
        set.concept("String default (IkeFoundation)").at(apparatus)
                .synonym("String default")
                .definition("The String field's loud default: the literal \"UNINITIALIZED\" —"
                        + " a value that works as an initial value but reads as obviously"
                        + " needing revision, never Java's silent empty string.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Component default (IkeFoundation)").at(apparatus)
                .synonym("Component default")
                .definition("The Component field's loud default: Uninitialized Component"
                        + " (SOLOR), the base set's own loud placeholder for a component not"
                        + " yet chosen. Not Blank Concept — Blank means a deliberate"
                        + " not-applicable, while Uninitialized means a value still owed.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("ComponentIdSet default (IkeFoundation)").at(apparatus)
                .synonym("ComponentIdSet default")
                .definition("The ComponentIdSet field's loud default: the singleton set"
                        + " holding Uninitialized Component — present and non-empty (an empty"
                        + " set would be a silent zero-value), its one member itself the loud"
                        + " placeholder.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("ComponentIdList default (IkeFoundation)").at(apparatus)
                .synonym("ComponentIdList default")
                .definition("The ComponentIdList field's loud default: the singleton list"
                        + " holding Uninitialized Component — present and non-empty (an empty"
                        + " list would be a silent zero-value), its one entry itself the loud"
                        + " placeholder.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("DiTree default (IkeFoundation)").at(apparatus)
                .synonym("DiTree default")
                .definition("The DiTree field's loud default: a single-vertex tree whose"
                        + " vertex meaning is Uninitialized Component — the smallest"
                        + " well-formed tree, carrying the loud placeholder at its root.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("DiGraph default (IkeFoundation)").at(apparatus)
                .synonym("DiGraph default")
                .definition("The DiGraph field's loud default: a simple cycle — two"
                        + " vertices, both Uninitialized Component, with edges in both"
                        + " directions. The cycle is deliberate: a cycle can never be a tree,"
                        + " so the value proves the field truly holds a graph and not a tree.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Concept default (IkeFoundation)").at(apparatus)
                .synonym("Concept default")
                .definition("The Concept field's loud default: Uninitialized Component"
                        + " (SOLOR) — the loud placeholder for a concept not yet chosen,"
                        + " obviously needing revision wherever it appears.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Semantic default (IkeFoundation)").at(apparatus)
                .synonym("Semantic default")
                .definition("The Semantic field's loud default: the fully qualified name"
                        + " description semantic of Uninitialized Component — a real,"
                        + " resolvable semantic whose subject is itself the loud placeholder,"
                        + " so the reference is valid yet plainly unrevised.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Integer default (IkeFoundation)").at(apparatus)
                .synonym("Integer default")
                .definition("The Integer field's loud default: the stretched-sevens sentinel"
                        + " 777777777 (nine sevens) — a repdigit signature that reads as"
                        + " deliberately planted and cannot plausibly occur as natural data,"
                        + " where Integer.MIN_VALUE would read as an overflow bug. Never"
                        + " Java's silent zero.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Float default (IkeFoundation)").at(apparatus)
                .synonym("Float default")
                .definition("The Float field's loud default: NaN, the type's native"
                        + " non-value — chosen over a stretched-sevens sentinel because a"
                        + " true non-value is louder still: it cannot be mistaken for data at"
                        + " all, and it propagates through arithmetic, so any computation"
                        + " over an unrevised default stays loudly not-a-number.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Boolean default (IkeFoundation)").at(apparatus)
                .synonym("Boolean default")
                .definition("The Boolean field's default: false — a flagged compromise. A"
                        + " two-valued type has no loud member, so no Boolean default can"
                        + " announce itself as unrevised; false is offered as the initial"
                        + " value with that limitation stated rather than hidden.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("ByteArray default (IkeFoundation)").at(apparatus)
                .synonym("ByteArray default")
                .definition("The ByteArray field's loud default: the UTF-8 bytes of"
                        + " \"UNINITIALIZED\" — the loud String default carried in byte form,"
                        + " never a silent empty array.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Array default (IkeFoundation)").at(apparatus)
                .synonym("Array default")
                .definition("The Array field's loud default: an array of exactly one"
                        + " element, the String \"UNINITIALIZED\" — present and non-empty (an"
                        + " empty array would be a silent zero-value), its single element the"
                        + " loud String default.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Instant default (IkeFoundation)").at(apparatus)
                .synonym("Instant default")
                .definition("The Instant field's loud default: the pre-inception instant"
                        + " (historically 'premundane'), the time type's native non-value —"
                        + " the platform's own before-all-recorded-time marker, chosen over"
                        + " a sentinel date because a true non-value cannot be mistaken for"
                        + " a real timestamp.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Long default (IkeFoundation)").at(apparatus)
                .synonym("Long default")
                .definition("The Long field's loud default: the stretched-sevens sentinel"
                        + " 777777777777777777 (eighteen sevens) — a repdigit signature that"
                        + " reads as deliberately planted and cannot plausibly occur as"
                        + " natural data, where Long.MIN_VALUE would read as an overflow bug"
                        + " (and sits one away from the platform's pre-inception time sentinel)."
                        + " Never Java's silent zero.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Decimal default (IkeFoundation)").at(apparatus)
                .synonym("Decimal default")
                .definition("The Decimal field's loud default: the stretched-sevens sentinel"
                        + " 777777777.777 — nine sevens, a decimal point, three more sevens."
                        + " The decimal point placement deliberately demonstrates the type's"
                        + " distinguishing property (a scaled decimal, not an integer) — the"
                        + " same move as the DiGraph cycle proving graph-ness. Never Java's"
                        + " silent zero.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        // ── The shared field purpose, and the pattern's own meaning/purpose ──
        // ONE purpose for all sixteen fields: every field exists for the identical
        // reason — to carry its data type's loud default — so distinct per-field
        // purposes would be manufactured variety (the meaning/purpose rigor of
        // IKE-Network/ike-issues#880, applied in the other direction).
        set.concept("Data type default exemplar (IkeFoundation)").at(apparatus)
                .synonym("Data type default exemplar")
                .definition("Why every Data Type Defaults Pattern field value is recorded:"
                        + " to carry its data type's loud default — a value that works as an"
                        + " initial value but reads as obviously needing revision, never"
                        + " Java's silent zero-value. One purpose serves all sixteen fields"
                        + " because every field exists for this identical reason; distinct"
                        + " purposes would be manufactured variety.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Defaulted Data Types (IkeFoundation)").at(apparatus)
                .synonym("Defaulted Data Types")
                .definition("What a Data Type Defaults Pattern semantic means: the sixteen"
                        + " data types ConceptToDataType recognizes for pattern fields, each"
                        + " exemplified by one field carrying that type's loud default.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        set.concept("Data Type Default Provision (IkeFoundation)").at(apparatus)
                .synonym("Data Type Default Provision")
                .definition("Why a Data Type Defaults Pattern semantic exists: to provide,"
                        + " in one semantic, a loud default value for every data type a"
                        + " pattern field can declare — and, replayed, to exercise every"
                        + " field serialization path the store supports end to end.")
                .isA(set.conceptRef("Defaults and templates model (IkeFoundation)"));

        // ── The pattern: sixteen fields in ConceptToDataType's convert order ──
        // Each field's dataType is the identity ConceptToDataType compares against,
        // bound through IkeTerm's declared-identity constants (UUIDs restated verbatim
        // from TinkarTerm; see this file's javadoc).
        EntityProxy.Concept exemplar = set.conceptRef("Data type default exemplar (IkeFoundation)");
        set.pattern("Data Type Defaults Pattern (IkeFoundation)").at(apparatus)
                .meaning(set.conceptRef("Defaulted Data Types (IkeFoundation)"))
                .purpose(set.conceptRef("Data Type Default Provision (IkeFoundation)"))
                .field(set.conceptRef("String default (IkeFoundation)"), exemplar, IkeTerm.STRING)
                .field(set.conceptRef("Component default (IkeFoundation)"), exemplar, IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("ComponentIdSet default (IkeFoundation)"), exemplar,
                        IkeTerm.COMPONENT_ID_SET_FIELD)
                .field(set.conceptRef("ComponentIdList default (IkeFoundation)"), exemplar,
                        IkeTerm.COMPONENT_ID_LIST_FIELD)
                .field(set.conceptRef("DiTree default (IkeFoundation)"), exemplar, IkeTerm.DITREE_FIELD)
                .field(set.conceptRef("DiGraph default (IkeFoundation)"), exemplar, IkeTerm.DIGRAPH_FIELD)
                .field(set.conceptRef("Concept default (IkeFoundation)"), exemplar, IkeTerm.CONCEPT_FIELD)
                .field(set.conceptRef("Semantic default (IkeFoundation)"), exemplar, IkeTerm.SEMANTIC_FIELD_TYPE)
                .field(set.conceptRef("Integer default (IkeFoundation)"), exemplar, IkeTerm.INTEGER_FIELD)
                .field(set.conceptRef("Float default (IkeFoundation)"), exemplar, IkeTerm.FLOAT_FIELD)
                .field(set.conceptRef("Boolean default (IkeFoundation)"), exemplar, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("ByteArray default (IkeFoundation)"), exemplar, IkeTerm.BYTE_ARRAY_FIELD)
                .field(set.conceptRef("Array default (IkeFoundation)"), exemplar, IkeTerm.ARRAY_FIELD)
                .field(set.conceptRef("Instant default (IkeFoundation)"), exemplar, IkeTerm.INSTANT_LITERAL)
                .field(set.conceptRef("Long default (IkeFoundation)"), exemplar, IkeTerm.LONG)
                .field(set.conceptRef("Decimal default (IkeFoundation)"), exemplar, IkeTerm.DECIMAL_FIELD)
                // Curated narrative (IKE-Network/ike-issues#888): domain description OF
                // this pattern — foundation-module terminology like its descriptions,
                // never defaults/template content (the module's live-and-die invariant
                // holds; only the default value semantic below stamps in the module).
                .semantic(NarrativeContentSet.PROSE_ELEMENT_PATTERN,
                        PublicIds.of(set.uuidFor(
                                "Narrative: DataTypeDefaultsPattern (Default Values — Loud Defaults for"
                                        + " Every Data Type)")), """
                        k:DataTypeDefaultsPattern[] is the defaults apparatus applied at full breadth: one
                        pattern with sixteen fields, one per data type the platform's field-type resolver
                        (`ConceptToDataType`, tinkar-core) actually recognizes, declared in that resolver's
                        own order — String, Component, ComponentIdSet, ComponentIdList, DiTree, DiGraph,
                        Concept, Semantic, Integer, Float, Boolean, ByteArray, Array, Instant, Long,
                        Decimal. All sixteen fields share one purpose, k:DataTypeDefaultExemplar[]: every
                        field exists for the identical reason — to carry its data type's loud default — so
                        distinct per-field purposes would be manufactured variety.

                        The pattern's single semantic is its own default value semantic: referenced
                        component k:DefaultValueConcept[], computed identity, every version in
                        k:DefaultsAndTemplatesModule[]. Each field's value is its data type's loud default
                        — a value that works as an initial value but reads as obviously needing revision,
                        never Java's silent zero-values. Replaying that one semantic writes and reads every
                        field data type the store supports — the ledger's serialization smoke test.""");

        // ── The default value semantic (Defaults and templates module) ──
        // Instance content stamps in the defaults module — the module IS the category
        // boundary. The Defaults-module counterpart of the inception stamp: same
        // declared time, author, and path (IKE-Network/ike-issues#894).
        ActiveStamp defaults = Ike.DEFAULTS_INCEPTION;

        EntityProxy.Pattern dataTypeDefaultsPattern =
                set.patternRef("Data Type Defaults Pattern (IkeFoundation)");
        EntityProxy.Concept defaultValueConcept =
                set.conceptRef("Default value concept (IkeFoundation)");
        UUID defaultIdentity = UuidT5Generator.singleSemanticUuid(
                dataTypeDefaultsPattern.publicId(), defaultValueConcept.publicId());

        // The Semantic field references Uninitialized Component's own fully qualified
        // name description — its established identity, declared in foundation.Section1
        // (f600187f-94a9-4baf-8b44-46baba8d928a, verified there to be the FQN
        // description, not the "Uninitialized" synonym or the definition).
        EntityProxy.Semantic uninitializedFqnDescription = EntityProxy.Semantic.make(
                "Uninitialized Component (SOLOR) fully qualified name description",
                PublicIds.of("f600187f-94a9-4baf-8b44-46baba8d928a"));

        set.concept("Default value concept (IkeFoundation)").at(defaults)
                .semantic(dataTypeDefaultsPattern, PublicIds.of(defaultIdentity),
                        // String
                        "UNINITIALIZED",
                        // Component
                        IkeTerm.UNINITIALIZED_COMPONENT,
                        // ComponentIdSet — singleton set of the loud placeholder
                        PublicIds.set.of(IkeTerm.UNINITIALIZED_COMPONENT.publicId()),
                        // ComponentIdList — singleton list of the loud placeholder
                        PublicIds.list.of(IkeTerm.UNINITIALIZED_COMPONENT.publicId()),
                        // DiTree — the smallest well-formed tree, one Uninitialized vertex
                        new GraphFieldValue.Tree(
                                List.of(new GraphFieldValue.Vertex(
                                        set.uuidFor("Data Type Defaults Pattern DiTree default vertex"),
                                        IkeTerm.UNINITIALIZED_COMPONENT)),
                                0, List.of()),
                        // DiGraph — the deliberate simple cycle A → B, B → A; a pure
                        // cycle has no roots
                        new GraphFieldValue.Graph(
                                List.of(new GraphFieldValue.Vertex(
                                                set.uuidFor("Data Type Defaults Pattern DiGraph default vertex A"),
                                                IkeTerm.UNINITIALIZED_COMPONENT),
                                        new GraphFieldValue.Vertex(
                                                set.uuidFor("Data Type Defaults Pattern DiGraph default vertex B"),
                                                IkeTerm.UNINITIALIZED_COMPONENT)),
                                List.of(),
                                List.of(new GraphFieldValue.Edge(0, 1),
                                        new GraphFieldValue.Edge(1, 0))),
                        // Concept
                        IkeTerm.UNINITIALIZED_COMPONENT,
                        // Semantic — the FQN description OF Uninitialized Component
                        uninitializedFqnDescription,
                        // Integer — stretched sevens (nine)
                        777_777_777,
                        // Float — the native non-value
                        Float.NaN,
                        // Boolean — flagged compromise, see Boolean default's definition
                        Boolean.FALSE,
                        // ByteArray — the loud String default in byte form
                        "UNINITIALIZED".getBytes(StandardCharsets.UTF_8),
                        // Array — exactly one element, the loud String default
                        new Object[]{"UNINITIALIZED"},
                        // Instant — the pre-inception instant, the time type's non-value
                        PrimitiveData.PRE_INCEPTION_INSTANT,
                        // Long — stretched sevens (eighteen)
                        777_777_777_777_777_777L,
                        // Decimal — stretched sevens with the demonstrative decimal point
                        new BigDecimal("777777777.777"));
    }
}
