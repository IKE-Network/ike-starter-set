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
import dev.ikm.tinkar.entity.builder.Stamp;
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
 * type, verified by UUID against its {@code TinkarTerm} references (the
 * {@link DataTypeTerminologySet} discipline) and bound through {@link IkeTerm}'s
 * declared identities. The pattern's single semantic is its own default value semantic
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
 * premundane instant — a non-value cannot be mistaken for data at all, and {@code NaN}
 * propagates through arithmetic); numeric types without one use the stretched-sevens
 * sentinel ({@code 777777777}, {@code 777777777777777777},
 * {@code 777777777.777} — repdigit signatures that read as deliberately planted, where
 * {@code MIN_VALUE} would read as an overflow bug); Boolean's {@code false} is a flagged
 * compromise, stated in its meaning concept's definition. The DiGraph default is a
 * deliberate two-vertex simple cycle: a cycle can never be a tree, so the value proves
 * the field truly carries a graph.
 * <p>
 * <b>Renames riding along</b>: the pattern's field declarations anchor, by UUID, seven
 * more of the {@code DisplayFields}-family concepts whose fully qualified names still
 * carried "display field" wording — Boolean, Integer, Decimal, Byte array, Array,
 * DiGraph, and Semantic ("Semantic display field type"). Each is revised to
 * "&lt;Type&gt; data type" by declared-identity revision of its established FQN
 * description, mirroring {@link DataTypeTerminologySet}; DiGraph's definition also
 * carried the "display field" framing and is revised alongside its FQN. The
 * {@code Component Id display list}/{@code display set} pair — whose FQNs evaded the
 * textual "display field" rule on grammar, not merit — is renamed by KEC decision to
 * {@code Component Id list data type}/{@code Component Id set data type}, with their
 * concept-vs-component definition defect corrected (the types hold component ids, not
 * concept ids; a set is not a "list"). End state: every anchored datatype concept is
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
        // Later than every other authoring pass in this project (2026-07-12/-13/-15/-16/
        // -17/-18/-19/-20): a fresh apparatus stamp composed after DefaultsAndTemplatesSet,
        // so the session keeps reading time-major and this file's scopes on shared
        // components (the Section19 data-type concepts, Default value concept) follow
        // every earlier scope chronologically.
        ActiveStamp apparatus = Stamp.active("2026-07-21T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        // ── Renames riding along (declared-identity revisions) ──────────
        // Each concept is UUID-confirmed against ConceptToDataType before renaming:
        // the birth FQN resumed below belongs to the same identity the pattern's field
        // declaration anchors through IkeTerm.

        // d6b9e2cc-31c6-5e80-91b7-7537690aae32 = TinkarTerm.BOOLEAN_FIELD → FieldDataType.BOOLEAN
        set.concept("Boolean display field (SOLOR)").at(apparatus)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("3344f24a-e9fd-48cd-a709-b2ea2def893e")),
                        IkeTerm.ENGLISH_LANGUAGE, "Boolean data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

        // ff59c300-9c4e-5e77-a35d-6a133eb3440f = TinkarTerm.INTEGER_FIELD → FieldDataType.INTEGER
        set.concept("Integer display Field").at(apparatus)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("a28c2f47-376b-4b28-a0d7-e8036989072c")),
                        IkeTerm.ENGLISH_LANGUAGE, "Integer data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

        // b413fe94-4ada-4aee-96f9-22be19699d40 = TinkarTerm.DECIMAL_FIELD → FieldDataType.DECIMAL
        set.concept("Decimal display field").at(apparatus)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("0d3129bb-6402-468b-806e-7e2f376b3855")),
                        IkeTerm.ENGLISH_LANGUAGE, "Decimal data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

        // dbdd8df2-aec3-596b-88fc-7b83b5594a45 = TinkarTerm.BYTE_ARRAY_FIELD → FieldDataType.BYTE_ARRAY
        set.concept("Byte array display field (SOLOR)").at(apparatus)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("36f3d937-c58b-425c-bb05-302bb3770734")),
                        IkeTerm.ENGLISH_LANGUAGE, "Byte array data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

        // b168ad04-f814-5036-b886-fd4913de88c8 = TinkarTerm.ARRAY_FIELD → FieldDataType.OBJECT_ARRAY
        set.concept("Array display field (Solor)").at(apparatus)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("a4cae3de-908d-47cd-9d3a-754c88dd2c96")),
                        IkeTerm.ENGLISH_LANGUAGE, "Array data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

        // 60113dfe-2bad-11eb-adc1-0242ac120002 = TinkarTerm.DIGRAPH_FIELD → FieldDataType.DIGRAPH.
        // Its definition also carried the "display field" framing, revised here alongside
        // the FQN so the definition doesn't contradict the new name (the DataTypeTerminologySet
        // move for Component and DiTree).
        set.concept("DiGraph display field").at(apparatus)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("ffa4ed98-142d-49dc-a0ad-2bb72397527c")),
                        IkeTerm.ENGLISH_LANGUAGE, "DiGraph data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("242ac229-b3f9-4562-a320-87fa74b77638")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "A field that holds a directed graph whose edges are ordered pairs of"
                                + " vertices. Each edge can be followed from one vertex to another"
                                + " vertex.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        // 9c3dfc88-51e4-5e51-a59a-88dd580162b7 = TinkarTerm.SEMANTIC_FIELD_TYPE → FieldDataType.SEMANTIC
        set.concept("Semantic display field type (SOLOR)").at(apparatus)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("59a6ae3f-6b53-4926-8b0b-fd49dae999d5")),
                        IkeTerm.ENGLISH_LANGUAGE, "Semantic data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

        // ── The Component Id pair (KEC-decided follow-up to the seven above) ────
        // Their FQNs say "display list"/"display set" rather than "display field", so
        // the textual rename rule missed them — same display-era framing, different
        // grammar. Both are the real code-recognized identities
        // (TinkarTerm.COMPONENT_ID_LIST_FIELD / COMPONENT_ID_SET_FIELD →
        // FieldDataType.COMPONENT_ID_LIST / COMPONENT_ID_SET), and both definitions
        // carried the concept-vs-component defect the original audit corrected on
        // "Component display field" (the types hold component ids, not concept ids —
        // and a set is not a "list"). After these, every anchored datatype concept is
        // named "... data type"; only the four genuinely unanchored display-era names
        // remain (Double/Image/UUID/Logical expression).

        // e553d3f1-63e1-4292-a3a9-af646fe44292 = TinkarTerm.COMPONENT_ID_LIST_FIELD → FieldDataType.COMPONENT_ID_LIST
        set.concept("Component Id display list").at(apparatus)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("02047230-d771-4a21-b17c-19d94ddb2fc8")),
                        IkeTerm.ENGLISH_LANGUAGE, "Component Id list data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("e8c9285f-a7e1-4d30-9f19-92e9cedf3719")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "An ordered list of component ids.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        // e283af51-2e8f-44fa-9bf1-89a99a7c7631 = TinkarTerm.COMPONENT_ID_SET_FIELD → FieldDataType.COMPONENT_ID_SET
        set.concept("Component Id display set").at(apparatus)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("9335dd4d-c3d9-4d1e-b17b-3edc6f2e3151")),
                        IkeTerm.ENGLISH_LANGUAGE, "Component Id set data type",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN,
                        PublicIds.of(UUID.fromString("9ab0315d-c338-4a40-86f9-9df320c51feb")),
                        IkeTerm.ENGLISH_LANGUAGE,
                        "An unordered set of component ids.",
                        IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE);

        // ── The sixteen field meaning concepts ──────────────────────────
        set.concept("String default (IkeFoundation)").at(apparatus)
                .synonym("String default")
                .definition("The String field's loud default: the literal \"UNINITIALIZED\" —"
                        + " a value that works as an initial value but reads as obviously"
                        + " needing revision, never Java's silent empty string.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Component default (IkeFoundation)").at(apparatus)
                .synonym("Component default")
                .definition("The Component field's loud default: Uninitialized Component"
                        + " (SOLOR), the base set's own loud placeholder for a component not"
                        + " yet chosen. Not Blank Concept — Blank means a deliberate"
                        + " not-applicable, while Uninitialized means a value still owed.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("ComponentIdSet default (IkeFoundation)").at(apparatus)
                .synonym("ComponentIdSet default")
                .definition("The ComponentIdSet field's loud default: the singleton set"
                        + " holding Uninitialized Component — present and non-empty (an empty"
                        + " set would be a silent zero-value), its one member itself the loud"
                        + " placeholder.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("ComponentIdList default (IkeFoundation)").at(apparatus)
                .synonym("ComponentIdList default")
                .definition("The ComponentIdList field's loud default: the singleton list"
                        + " holding Uninitialized Component — present and non-empty (an empty"
                        + " list would be a silent zero-value), its one entry itself the loud"
                        + " placeholder.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("DiTree default (IkeFoundation)").at(apparatus)
                .synonym("DiTree default")
                .definition("The DiTree field's loud default: a single-vertex tree whose"
                        + " vertex meaning is Uninitialized Component — the smallest"
                        + " well-formed tree, carrying the loud placeholder at its root.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("DiGraph default (IkeFoundation)").at(apparatus)
                .synonym("DiGraph default")
                .definition("The DiGraph field's loud default: a simple cycle — two"
                        + " vertices, both Uninitialized Component, with edges in both"
                        + " directions. The cycle is deliberate: a cycle can never be a tree,"
                        + " so the value proves the field truly holds a graph and not a tree.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Concept default (IkeFoundation)").at(apparatus)
                .synonym("Concept default")
                .definition("The Concept field's loud default: Uninitialized Component"
                        + " (SOLOR) — the loud placeholder for a concept not yet chosen,"
                        + " obviously needing revision wherever it appears.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Semantic default (IkeFoundation)").at(apparatus)
                .synonym("Semantic default")
                .definition("The Semantic field's loud default: the fully qualified name"
                        + " description semantic of Uninitialized Component — a real,"
                        + " resolvable semantic whose subject is itself the loud placeholder,"
                        + " so the reference is valid yet plainly unrevised.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Integer default (IkeFoundation)").at(apparatus)
                .synonym("Integer default")
                .definition("The Integer field's loud default: the stretched-sevens sentinel"
                        + " 777777777 (nine sevens) — a repdigit signature that reads as"
                        + " deliberately planted and cannot plausibly occur as natural data,"
                        + " where Integer.MIN_VALUE would read as an overflow bug. Never"
                        + " Java's silent zero.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Float default (IkeFoundation)").at(apparatus)
                .synonym("Float default")
                .definition("The Float field's loud default: NaN, the type's native"
                        + " non-value — chosen over a stretched-sevens sentinel because a"
                        + " true non-value is louder still: it cannot be mistaken for data at"
                        + " all, and it propagates through arithmetic, so any computation"
                        + " over an unrevised default stays loudly not-a-number.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Boolean default (IkeFoundation)").at(apparatus)
                .synonym("Boolean default")
                .definition("The Boolean field's default: false — a flagged compromise. A"
                        + " two-valued type has no loud member, so no Boolean default can"
                        + " announce itself as unrevised; false is offered as the initial"
                        + " value with that limitation stated rather than hidden.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("ByteArray default (IkeFoundation)").at(apparatus)
                .synonym("ByteArray default")
                .definition("The ByteArray field's loud default: the UTF-8 bytes of"
                        + " \"UNINITIALIZED\" — the loud String default carried in byte form,"
                        + " never a silent empty array.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Array default (IkeFoundation)").at(apparatus)
                .synonym("Array default")
                .definition("The Array field's loud default: an array of exactly one"
                        + " element, the String \"UNINITIALIZED\" — present and non-empty (an"
                        + " empty array would be a silent zero-value), its single element the"
                        + " loud String default.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Instant default (IkeFoundation)").at(apparatus)
                .synonym("Instant default")
                .definition("The Instant field's loud default: the premundane instant, the"
                        + " time type's native non-value — the platform's own before-all-"
                        + "recorded-time marker, chosen over a sentinel date because a true"
                        + " non-value cannot be mistaken for a real timestamp.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Long default (IkeFoundation)").at(apparatus)
                .synonym("Long default")
                .definition("The Long field's loud default: the stretched-sevens sentinel"
                        + " 777777777777777777 (eighteen sevens) — a repdigit signature that"
                        + " reads as deliberately planted and cannot plausibly occur as"
                        + " natural data, where Long.MIN_VALUE would read as an overflow bug"
                        + " (and sits one away from the platform's premundane time sentinel)."
                        + " Never Java's silent zero.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Decimal default (IkeFoundation)").at(apparatus)
                .synonym("Decimal default")
                .definition("The Decimal field's loud default: the stretched-sevens sentinel"
                        + " 777777777.777 — nine sevens, a decimal point, three more sevens."
                        + " The decimal point placement deliberately demonstrates the type's"
                        + " distinguishing property (a scaled decimal, not an integer) — the"
                        + " same move as the DiGraph cycle proving graph-ness. Never Java's"
                        + " silent zero.")
                .isA(IkeTerm.MODEL_CONCEPT);

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
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Defaulted Data Types (IkeFoundation)").at(apparatus)
                .synonym("Defaulted Data Types")
                .definition("What a Data Type Defaults Pattern semantic means: the sixteen"
                        + " data types ConceptToDataType recognizes for pattern fields, each"
                        + " exemplified by one field carrying that type's loud default.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Data Type Default Provision (IkeFoundation)").at(apparatus)
                .synonym("Data Type Default Provision")
                .definition("Why a Data Type Defaults Pattern semantic exists: to provide,"
                        + " in one semantic, a loud default value for every data type a"
                        + " pattern field can declare — and, replayed, to exercise every"
                        + " field serialization path the store supports end to end.")
                .isA(IkeTerm.MODEL_CONCEPT);

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
                .field(set.conceptRef("Decimal default (IkeFoundation)"), exemplar, IkeTerm.DECIMAL_FIELD);

        // ── The default value semantic (Defaults and templates module) ──
        // Instance content stamps in the defaults module — the module IS the category
        // boundary. The later time keeps this ledger's scopes on Default value concept
        // chronological (apparatus 07-20, worked example 07-20T12, this 07-21T12).
        ActiveStamp defaults = Stamp.active("2026-07-21T12:00:00Z", Ike.IKE_COMMUNITY,
                set.conceptRef("Defaults and templates module (IkeFoundation)"),
                IkeTerm.DEVELOPMENT_PATH);

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
                PublicIds.of(UUID.fromString("f600187f-94a9-4baf-8b44-46baba8d928a")));

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
                        // Instant — the premundane instant, the time type's non-value
                        PrimitiveData.PREMUNDANE_INSTANT,
                        // Long — stretched sevens (eighteen)
                        777_777_777_777_777_777L,
                        // Decimal — stretched sevens with the demonstrative decimal point
                        new BigDecimal("777777777.777"));
    }
}
