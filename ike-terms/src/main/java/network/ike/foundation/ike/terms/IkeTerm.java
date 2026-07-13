package network.ike.foundation.ike.terms;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.terms.EntityProxy;

import java.util.UUID;

/**
 * IKE-native references for every foundational concept/pattern this ledger's own
 * ingested content refers to — a single source of truth so the generated ledger
 * does not depend on {@code dev.ikm.tinkar.terms.TinkarTerm} (an upstream, IKE-external
 * binding) for identities this set already declares itself. Every constant here
 * names the SAME established identity (UUID preserved) that
 * {@code dev.ikm.tinkar.terms.TinkarTerm} names — declared, not derived, since these
 * are adopted identities, not new mints (IKE-Network/ike-issues#872).
 */
public final class IkeTerm {

    private IkeTerm() {
    }

    /** {@code Acceptable (SOLOR)} — same identity as {@code TinkarTerm.ACCEPTABLE}. */
    public static final EntityProxy.Concept ACCEPTABLE =
            EntityProxy.Concept.make("Acceptable (SOLOR)", PublicIds.of(UUID.fromString("12b9e103-060e-3256-9982-18c1191af60e")));

    /** {@code Action properties (SOLOR)} — same identity as {@code TinkarTerm.ACTION_PROPERTIES}. */
    public static final EntityProxy.Concept ACTION_PROPERTIES =
            EntityProxy.Concept.make("Action properties (SOLOR)", PublicIds.of(UUID.fromString("80ba281c-7d47-57cf-8100-82b69bce998b")));

    /** {@code Annotation type (SOLOR)} — same identity as {@code TinkarTerm.ANNOTATION_TYPE}. */
    public static final EntityProxy.Concept ANNOTATION_TYPE =
            EntityProxy.Concept.make("Annotation type (SOLOR)", PublicIds.of(UUID.fromString("3fe77951-58c9-51b3-8e7e-65edcf7ace0a")));

    /** {@code Author for version (SOLOR)} — same identity as {@code TinkarTerm.AUTHOR_FOR_VERSION}. */
    public static final EntityProxy.Concept AUTHOR_FOR_VERSION =
            EntityProxy.Concept.make("Author for version (SOLOR)", PublicIds.of(UUID.fromString("4eb9de0d-7486-5f18-a9b4-82e3432f4103")));

    /** {@code Axiom origin (SOLOR)} — same identity as {@code TinkarTerm.AXIOM_ORIGIN}. */
    public static final EntityProxy.Concept AXIOM_ORIGIN =
            EntityProxy.Concept.make("Axiom origin (SOLOR)", PublicIds.of(UUID.fromString("b868bd83-5cd4-5d84-9cf7-b08674fbc79b")));

    /** {@code Axiom Syntax (SOLOR)} — same identity as {@code TinkarTerm.AXIOM_SYNTAX}. */
    public static final EntityProxy.Concept AXIOM_SYNTAX =
            EntityProxy.Concept.make("Axiom Syntax (SOLOR)", PublicIds.of(UUID.fromString("8da1c508-c2a2-4899-b26d-87f8b98a7558")));

    /** {@code Chronicle properties (SOLOR)} — same identity as {@code TinkarTerm.CHRONICLE_PROPERTIES}. */
    public static final EntityProxy.Concept CHRONICLE_PROPERTIES =
            EntityProxy.Concept.make("Chronicle properties (SOLOR)", PublicIds.of(UUID.fromString("2ba2ef47-30af-57ec-9073-38693f020d7e")));

    /** {@code Comment (SOLOR)} — same identity as {@code TinkarTerm.COMMENT}. */
    public static final EntityProxy.Concept COMMENT =
            EntityProxy.Concept.make("Comment (SOLOR)", PublicIds.of(UUID.fromString("147832d4-b9b8-5062-8891-19f9c4e4760a")));

    /** {@code Component field (SOLOR)} — same identity as {@code TinkarTerm.COMPONENT_FIELD}. */
    public static final EntityProxy.Concept COMPONENT_FIELD =
            EntityProxy.Concept.make("Component field (SOLOR)", PublicIds.of(UUID.fromString("fb00d132-fcc3-5cbf-881d-4bcc4b4c91b3")));

    /** {@code Component Id set field (SOLOR)} — same identity as {@code TinkarTerm.COMPONENT_ID_SET_FIELD}. */
    public static final EntityProxy.Concept COMPONENT_ID_SET_FIELD =
            EntityProxy.Concept.make("Component Id set field (SOLOR)", PublicIds.of(UUID.fromString("e283af51-2e8f-44fa-9bf1-89a99a7c7631")));

    /** {@code Component type focus (SOLOR)} — same identity as {@code TinkarTerm.COMPONENT_TYPE_FOCUS}. */
    public static final EntityProxy.Concept COMPONENT_TYPE_FOCUS =
            EntityProxy.Concept.make("Component type focus (SOLOR)", PublicIds.of(UUID.fromString("f1f179d0-26af-5123-9b29-9fc6cd01dd29")));

    /** {@code Concept assemblage for logic coordinate (SOLOR)} — same identity as {@code TinkarTerm.CONCEPT_ASSEMBLAGE_FOR_LOGIC_COORDINATE}. */
    public static final EntityProxy.Concept CONCEPT_ASSEMBLAGE_FOR_LOGIC_COORDINATE =
            EntityProxy.Concept.make("Concept assemblage for logic coordinate (SOLOR)", PublicIds.of(UUID.fromString("16486419-5d1c-574f-bde6-21910ad66f44")));

    /** {@code Concept field (SOLOR)} — same identity as {@code TinkarTerm.CONCEPT_FIELD}. */
    public static final EntityProxy.Concept CONCEPT_FIELD =
            EntityProxy.Concept.make("Concept field (SOLOR)", PublicIds.of(UUID.fromString("ac8f1f54-c7c6-5fc7-b1a8-ebb04b918557")));

    /** {@code Concept type (SOLOR)} — same identity as {@code TinkarTerm.CONCEPT_TYPE}. */
    public static final EntityProxy.Concept CONCEPT_TYPE =
            EntityProxy.Concept.make("Concept type (SOLOR)", PublicIds.of(UUID.fromString("106f3ba1-63b8-5596-8dbe-524fa2e89fc0")));

    /** {@code Concrete domain operator (SOLOR)} — same identity as {@code TinkarTerm.CONCRETE_DOMAIN_OPERATOR}. */
    public static final EntityProxy.Concept CONCRETE_DOMAIN_OPERATOR =
            EntityProxy.Concept.make("Concrete domain operator (SOLOR)", PublicIds.of(UUID.fromString("843b0b55-8785-5544-93f6-581da9cf1ff3")));

    /** {@code Connective operator (SOLOR)} — same identity as {@code TinkarTerm.CONNECTIVE_OPERATOR}. */
    public static final EntityProxy.Concept CONNECTIVE_OPERATOR =
            EntityProxy.Concept.make("Connective operator (SOLOR)", PublicIds.of(UUID.fromString("3fdcaadc-d972-58e9-84f1-b3a39903b076")));

    /** {@code Correlation properties (SOLOR)} — same identity as {@code TinkarTerm.CORRELATION_PROPERTIES}. */
    public static final EntityProxy.Concept CORRELATION_PROPERTIES =
            EntityProxy.Concept.make("Correlation properties (SOLOR)", PublicIds.of(UUID.fromString("8f682e00-3d9e-5506-bd19-b2169d6c8752")));

    /** {@code Definition description type (SOLOR)} — same identity as {@code TinkarTerm.DEFINITION_DESCRIPTION_TYPE}. */
    public static final EntityProxy.Concept DEFINITION_DESCRIPTION_TYPE =
            EntityProxy.Concept.make("Definition description type (SOLOR)", PublicIds.of(UUID.fromString("700546a3-09c7-3fc2-9eb9-53d318659a09")));

    /** {@code Description (SOLOR)} — same identity as {@code TinkarTerm.DESCRIPTION}. */
    public static final EntityProxy.Concept DESCRIPTION =
            EntityProxy.Concept.make("Description (SOLOR)", PublicIds.of(UUID.fromString("87118daf-d28c-55fb-8657-cd6bc8425600")));

    /** {@code Description acceptability (SOLOR)} — same identity as {@code TinkarTerm.DESCRIPTION_ACCEPTABILITY}. */
    public static final EntityProxy.Concept DESCRIPTION_ACCEPTABILITY =
            EntityProxy.Concept.make("Description acceptability (SOLOR)", PublicIds.of(UUID.fromString("96b61063-0d29-5aea-9652-3f5f328aadc3")));

    /** {@code Description case significance (SOLOR)} — same identity as {@code TinkarTerm.DESCRIPTION_CASE_SIGNIFICANCE}. */
    public static final EntityProxy.Concept DESCRIPTION_CASE_SIGNIFICANCE =
            EntityProxy.Concept.make("Description case significance (SOLOR)", PublicIds.of(UUID.fromString("c3dde9ea-b144-5f49-845a-20cc7d305250"), UUID.fromString("f30b0312-2c85-3e65-8609-2d89f8437d34")));

    /** {@code Description dialect pair (SOLOR)} — same identity as {@code TinkarTerm.DESCRIPTION_DIALECT_PAIR}. */
    public static final EntityProxy.Concept DESCRIPTION_DIALECT_PAIR =
            EntityProxy.Concept.make("Description dialect pair (SOLOR)", PublicIds.of(UUID.fromString("a27bbbf8-57b5-590c-8650-1247f6f963eb")));

    /** {@code Description-logic profile (SOLOR)} — same identity as {@code TinkarTerm.DESCRIPTION_LOGIC_PROFILE}. */
    public static final EntityProxy.Concept DESCRIPTION_LOGIC_PROFILE =
            EntityProxy.Concept.make("Description-logic profile (SOLOR)", PublicIds.of(UUID.fromString("14eadb10-fbd0-5999-af37-05728a8503af")));

    /** {@code Description not case sensitive (SOLOR)} — same identity as {@code TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE}. */
    public static final EntityProxy.Concept DESCRIPTION_NOT_CASE_SENSITIVE =
            EntityProxy.Concept.make("Description not case sensitive (SOLOR)", PublicIds.of(UUID.fromString("ecea41a2-f596-3d98-99d1-771b667e55b8")));

    /** {@code Description pattern} — same identity as {@code TinkarTerm.DESCRIPTION_PATTERN}. */
    public static final EntityProxy.Pattern DESCRIPTION_PATTERN =
            EntityProxy.Pattern.make("Description pattern", PublicIds.of(UUID.fromString("a4de0039-2625-5842-8a4c-d1ce6aebf021")));

    /** {@code Description semantic (SOLOR)} — same identity as {@code TinkarTerm.DESCRIPTION_SEMANTIC}. */
    public static final EntityProxy.Concept DESCRIPTION_SEMANTIC =
            EntityProxy.Concept.make("Description semantic (SOLOR)", PublicIds.of(UUID.fromString("81487d5f-6115-51e2-a3b3-93d783888eb8")));

    /** {@code Description type (SOLOR)} — same identity as {@code TinkarTerm.DESCRIPTION_TYPE}. */
    public static final EntityProxy.Concept DESCRIPTION_TYPE =
            EntityProxy.Concept.make("Description type (SOLOR)", PublicIds.of(UUID.fromString("ad0c19e8-2ccc-59c1-8b7e-c56c03aca8eb")));

    /** {@code Description version properties (SOLOR)} — same identity as {@code TinkarTerm.DESCRIPTION_VERSION_PROPERTIES}. */
    public static final EntityProxy.Concept DESCRIPTION_VERSION_PROPERTIES =
            EntityProxy.Concept.make("Description version properties (SOLOR)", PublicIds.of(UUID.fromString("732aad24-4add-59d6-bbc9-840a8b9dc754")));

    /** {@code Development path (SOLOR)} — same identity as {@code TinkarTerm.DEVELOPMENT_PATH}. */
    public static final EntityProxy.Concept DEVELOPMENT_PATH =
            EntityProxy.Concept.make("Development path (SOLOR)", PublicIds.of(UUID.fromString("1f200ca6-960e-11e5-8994-feff819cdc9f")));

    /** {@code Dialect assemblage (SOLOR)} — same identity as {@code TinkarTerm.DIALECT_ASSEMBLAGE}. */
    public static final EntityProxy.Concept DIALECT_ASSEMBLAGE =
            EntityProxy.Concept.make("Dialect assemblage (SOLOR)", PublicIds.of(UUID.fromString("b9c34574-c9ac-503b-aa24-456a0ec949a2")));

    /** {@code Directed graph (SOLOR)} — same identity as {@code TinkarTerm.DIRECTED_GRAPH}. */
    public static final EntityProxy.Concept DIRECTED_GRAPH =
            EntityProxy.Concept.make("Directed graph (SOLOR)", PublicIds.of(UUID.fromString("47a787a7-bdce-528d-bfcc-fde1add8d599")));

    /** {@code Display Fields (SOLOR)} — same identity as {@code TinkarTerm.DISPLAY_FIELDS}. */
    public static final EntityProxy.Concept DISPLAY_FIELDS =
            EntityProxy.Concept.make("Display Fields (SOLOR)", PublicIds.of(UUID.fromString("4e627b9c-cecb-5563-82fc-cb0ee25113b1")));

    /** {@code DiTree field (SOLOR)} — same identity as {@code TinkarTerm.DITREE_FIELD}. */
    public static final EntityProxy.Concept DITREE_FIELD =
            EntityProxy.Concept.make("DiTree field (SOLOR)", PublicIds.of(UUID.fromString("32f64fc6-5371-11eb-ae93-0242ac130002")));

    /** {@code Dynamic column data types (SOLOR)} — same identity as {@code TinkarTerm.DYNAMIC_COLUMN_DATA_TYPES}. */
    public static final EntityProxy.Concept DYNAMIC_COLUMN_DATA_TYPES =
            EntityProxy.Concept.make("Dynamic column data types (SOLOR)", PublicIds.of(UUID.fromString("61da7e50-f606-5ba0-a0df-83fd524951e7")));

    /** {@code EL++ Inferred terminological axioms (SOLOR)} — same identity as {@code TinkarTerm.EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS}. */
    public static final EntityProxy.Concept EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS =
            EntityProxy.Concept.make("EL++ Inferred terminological axioms (SOLOR)", PublicIds.of(UUID.fromString("b6d3be7d-1d7f-5c44-a425-5357f878c212")));

    /** {@code EL++ Stated terminological axioms (SOLOR)} — same identity as {@code TinkarTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS}. */
    public static final EntityProxy.Concept EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS =
            EntityProxy.Concept.make("EL++ Stated terminological axioms (SOLOR)", PublicIds.of(UUID.fromString("1412bd09-eb0c-5107-9756-10c1c417d385")));

    /** {@code EL++ terminological axioms (SOLOR)} — same identity as {@code TinkarTerm.EL_PLUS_PLUS_TERMINOLOGICAL_AXIOMS}. */
    public static final EntityProxy.Concept EL_PLUS_PLUS_TERMINOLOGICAL_AXIOMS =
            EntityProxy.Concept.make("EL++ terminological axioms (SOLOR)", PublicIds.of(UUID.fromString("b3ec50c4-e8cf-4720-b192-31374705f3b7")));

    /** {@code English dialect assemblage (SOLOR)} — same identity as {@code TinkarTerm.ENGLISH_DIALECT_ASSEMBLAGE}. */
    public static final EntityProxy.Concept ENGLISH_DIALECT_ASSEMBLAGE =
            EntityProxy.Concept.make("English dialect assemblage (SOLOR)", PublicIds.of(UUID.fromString("c0836284-f631-3c86-8cfc-56a67814efab")));

    /** {@code English language (SOLOR)} — same identity as {@code TinkarTerm.ENGLISH_LANGUAGE}. */
    public static final EntityProxy.Concept ENGLISH_LANGUAGE =
            EntityProxy.Concept.make("English language (SOLOR)", PublicIds.of(UUID.fromString("02018e5a-46ba-5297-92f1-6931b9f98a12"), UUID.fromString("06d905ea-c647-3af9-bfe5-2514e135b558"), UUID.fromString("45021920-9567-11e5-8994-feff819cdc9f")));

    /** {@code Example UCUM Units} — same identity as {@code TinkarTerm.EXAMPLE_UCUM_UNITS}. */
    public static final EntityProxy.Concept EXAMPLE_UCUM_UNITS =
            EntityProxy.Concept.make("Example UCUM Units", PublicIds.of(UUID.fromString("80cd4978-314d-46e3-bc13-9980280ae955")));

    /** {@code Express axiom syntax (SOLOR)} — same identity as {@code TinkarTerm.EXPRESS_AXIOM_SYNTAX}. */
    public static final EntityProxy.Concept EXPRESS_AXIOM_SYNTAX =
            EntityProxy.Concept.make("Express axiom syntax (SOLOR)", PublicIds.of(UUID.fromString("db55557c-e9ee-4504-aae3-df695b6d6c57")));

    /** {@code Field substitution (SOLOR)} — same identity as {@code TinkarTerm.FIELD_SUBSTITUTION}. */
    public static final EntityProxy.Concept FIELD_SUBSTITUTION =
            EntityProxy.Concept.make("Field substitution (SOLOR)", PublicIds.of(UUID.fromString("8fdce1aa-ca82-5abc-8cfa-230c14688abc")));

    /** {@code Float field (SOLOR)} — same identity as {@code TinkarTerm.FLOAT_FIELD}. */
    public static final EntityProxy.Concept FLOAT_FIELD =
            EntityProxy.Concept.make("Float field (SOLOR)", PublicIds.of(UUID.fromString("6efe7087-3e3c-5b45-8109-90d7652b1506")));

    /** {@code Fully qualified name description type (SOLOR)} — same identity as {@code TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE}. */
    public static final EntityProxy.Concept FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE =
            EntityProxy.Concept.make("Fully qualified name description type (SOLOR)", PublicIds.of(UUID.fromString("00791270-77c9-32b6-b34f-d932569bd2bf"), UUID.fromString("5e1fe940-8faf-11db-b606-0800200c9a66")));

    /** {@code GB English dialect} — same identity as {@code TinkarTerm.GB_DIALECT_PATTERN}. */
    public static final EntityProxy.Pattern GB_DIALECT_PATTERN =
            EntityProxy.Pattern.make("GB English dialect", PublicIds.of(UUID.fromString("561f817a-130e-5e56-984d-910e9991558c")));

    /** {@code GB English dialect (SOLOR)} — same identity as {@code TinkarTerm.GB_ENGLISH_DIALECT}. */
    public static final EntityProxy.Concept GB_ENGLISH_DIALECT =
            EntityProxy.Concept.make("GB English dialect (SOLOR)", PublicIds.of(UUID.fromString("eb9a5e42-3cba-356d-b623-3ed472e20b30")));

    /** {@code Grouping (SOLOR)} — same identity as {@code TinkarTerm.GROUPING}. */
    public static final EntityProxy.Concept GROUPING =
            EntityProxy.Concept.make("Grouping (SOLOR)", PublicIds.of(UUID.fromString("8d76ead7-6c75-5d25-84d4-ca76d928f8a6")));

    /** {@code Identifier Pattern} — same identity as {@code TinkarTerm.IDENTIFIER_PATTERN}. */
    public static final EntityProxy.Pattern IDENTIFIER_PATTERN =
            EntityProxy.Pattern.make("Identifier Pattern", PublicIds.of(UUID.fromString("5d60e14b-c410-5172-9559-3c4253278ae2")));

    /** {@code Identifier source (SOLOR)} — same identity as {@code TinkarTerm.IDENTIFIER_SOURCE}. */
    public static final EntityProxy.Concept IDENTIFIER_SOURCE =
            EntityProxy.Concept.make("Identifier source (SOLOR)", PublicIds.of(UUID.fromString("5a87935c-d654-548f-82a2-0c06e3801162")));

    /** {@code Identifier Value} — same identity as {@code TinkarTerm.IDENTIFIER_VALUE}. */
    public static final EntityProxy.Concept IDENTIFIER_VALUE =
            EntityProxy.Concept.make("Identifier Value", PublicIds.of(UUID.fromString("b32dd26b-c3fc-487e-987e-16ace71a0d0f")));

    /** {@code ImmutableCoordinate properties (SOLOR)} — same identity as {@code TinkarTerm.IMMUTABLECOORDINATE_PROPERTIES}. */
    public static final EntityProxy.Concept IMMUTABLECOORDINATE_PROPERTIES =
            EntityProxy.Concept.make("ImmutableCoordinate properties (SOLOR)", PublicIds.of(UUID.fromString("ab41a788-8a83-5452-8dc0-2d8375e0bfe6")));

    /** {@code Inferred Definition} — same identity as {@code TinkarTerm.INFERRED_DEFINITION}. */
    public static final EntityProxy.Concept INFERRED_DEFINITION =
            EntityProxy.Concept.make("Inferred Definition", PublicIds.of(UUID.fromString("b1abf4dc-9838-4b46-ac55-10c4f92ba10b")));

    /** {@code Instant literal (SOLOR)} — same identity as {@code TinkarTerm.INSTANT_LITERAL}. */
    public static final EntityProxy.Concept INSTANT_LITERAL =
            EntityProxy.Concept.make("Instant literal (SOLOR)", PublicIds.of(UUID.fromString("1fbf42e2-42b7-591f-b7fd-ba5de659529e")));

    /** {@code Is-a (SOLOR)} — same identity as {@code TinkarTerm.IS_A}. */
    public static final EntityProxy.Concept IS_A =
            EntityProxy.Concept.make("Is-a (SOLOR)", PublicIds.of(UUID.fromString("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25"), UUID.fromString("46bccdc4-8fb6-11db-b606-0800200c9a66")));

    /** {@code Komet base model component pattern} — same identity as {@code TinkarTerm.KOMET_BASE_MODEL_COMPONENT_PATTERN}. */
    public static final EntityProxy.Pattern KOMET_BASE_MODEL_COMPONENT_PATTERN =
            EntityProxy.Pattern.make("Komet base model component pattern", PublicIds.of(UUID.fromString("bbbbf1fe-00f0-55e0-a19c-6300dbaab9b2")));

    /** {@code Korean dialect (SOLOR)} — same identity as {@code TinkarTerm.KOREAN_DIALECT}. */
    public static final EntityProxy.Concept KOREAN_DIALECT =
            EntityProxy.Concept.make("Korean dialect (SOLOR)", PublicIds.of(UUID.fromString("6fb2eb9c-fb9e-5959-802c-fb17bcba3079")));

    /** {@code Language (SOLOR)} — same identity as {@code TinkarTerm.LANGUAGE}. */
    public static final EntityProxy.Concept LANGUAGE =
            EntityProxy.Concept.make("Language (SOLOR)", PublicIds.of(UUID.fromString("f56fa231-10f9-5e7f-a86d-a1d61b5b56e3")));

    /** {@code Language concept nid for description (SOLOR)} — same identity as {@code TinkarTerm.LANGUAGE_CONCEPT_NID_FOR_DESCRIPTION}. */
    public static final EntityProxy.Concept LANGUAGE_CONCEPT_NID_FOR_DESCRIPTION =
            EntityProxy.Concept.make("Language concept nid for description (SOLOR)", PublicIds.of(UUID.fromString("cd56cceb-8507-5ae5-a928-16079fe6f832")));

    /** {@code Language coordinate properties (SOLOR)} — same identity as {@code TinkarTerm.LANGUAGE_COORDINATE_PROPERTIES}. */
    public static final EntityProxy.Concept LANGUAGE_COORDINATE_PROPERTIES =
            EntityProxy.Concept.make("Language coordinate properties (SOLOR)", PublicIds.of(UUID.fromString("ea1a52f7-0305-5487-8766-e846330f167a")));

    /** {@code Literal value (SOLOR)} — same identity as {@code TinkarTerm.LITERAL_VALUE}. */
    public static final EntityProxy.Concept LITERAL_VALUE =
            EntityProxy.Concept.make("Literal value (SOLOR)", PublicIds.of(UUID.fromString("208a40a7-e615-5efa-9de0-2e2a5a8488b7")));

    /** {@code Logical Definition (SOLOR)} — same identity as {@code TinkarTerm.LOGICAL_DEFINITION}. */
    public static final EntityProxy.Concept LOGICAL_DEFINITION =
            EntityProxy.Concept.make("Logical Definition (SOLOR)", PublicIds.of(UUID.fromString("7dccd042-b0b8-5cec-a1bc-6de676b92f4b")));

    /** {@code Logic coordinate properties (SOLOR)} — same identity as {@code TinkarTerm.LOGIC_COORDINATE_PROPERTIES}. */
    public static final EntityProxy.Concept LOGIC_COORDINATE_PROPERTIES =
            EntityProxy.Concept.make("Logic coordinate properties (SOLOR)", PublicIds.of(UUID.fromString("1fa63819-5ac1-5938-95b1-47871a5f2b17")));

    /** {@code long (SOLOR)} — same identity as {@code TinkarTerm.LONG}. */
    public static final EntityProxy.Concept LONG =
            EntityProxy.Concept.make("long (SOLOR)", PublicIds.of(UUID.fromString("dea8cdf1-de75-5991-9791-79714e4a964d")));

    /** {@code Maximum Value Operator} — same identity as {@code TinkarTerm.MAXIMUM_VALUE_OPERATOR}. */
    public static final EntityProxy.Concept MAXIMUM_VALUE_OPERATOR =
            EntityProxy.Concept.make("Maximum Value Operator", PublicIds.of(UUID.fromString("7b8916ab-fd50-41df-8fc2-0b2a7a78be6d")));

    /** {@code Meaning (SOLOR)} — same identity as {@code TinkarTerm.MEANING}. */
    public static final EntityProxy.Concept MEANING =
            EntityProxy.Concept.make("Meaning (SOLOR)", PublicIds.of(UUID.fromString("a06158ff-e08a-5d7d-bcfa-6cbfdb138910")));

    /** {@code Membership semantic (SOLOR)} — same identity as {@code TinkarTerm.MEMBERSHIP_SEMANTIC}. */
    public static final EntityProxy.Concept MEMBERSHIP_SEMANTIC =
            EntityProxy.Concept.make("Membership semantic (SOLOR)", PublicIds.of(UUID.fromString("4fa29287-a80e-5f83-abab-4b587973e7b7")));

    /** {@code Minimum Value Operator} — same identity as {@code TinkarTerm.MINIMUM_VALUE_OPERATOR}. */
    public static final EntityProxy.Concept MINIMUM_VALUE_OPERATOR =
            EntityProxy.Concept.make("Minimum Value Operator", PublicIds.of(UUID.fromString("ded98e42-f74a-4432-9ae7-01b94dc2fdea")));

    /** {@code Model concept (SOLOR)} — same identity as {@code TinkarTerm.MODEL_CONCEPT}. */
    public static final EntityProxy.Concept MODEL_CONCEPT =
            EntityProxy.Concept.make("Model concept (SOLOR)", PublicIds.of(UUID.fromString("7bbd4210-381c-11e7-9598-0800200c9a66")));

    /** {@code Module (SOLOR)} — same identity as {@code TinkarTerm.MODULE}. */
    public static final EntityProxy.Concept MODULE =
            EntityProxy.Concept.make("Module (SOLOR)", PublicIds.of(UUID.fromString("40d1c869-b509-32f8-b735-836eac577a67")));

    /** {@code Module for version (SOLOR)} — same identity as {@code TinkarTerm.MODULE_FOR_VERSION}. */
    public static final EntityProxy.Concept MODULE_FOR_VERSION =
            EntityProxy.Concept.make("Module for version (SOLOR)", PublicIds.of(UUID.fromString("67cd64f1-96d7-5110-b847-556c055ac063")));

    /** {@code Module origins (SOLOR)} — same identity as {@code TinkarTerm.MODULE_ORIGINS}. */
    public static final EntityProxy.Concept MODULE_ORIGINS =
            EntityProxy.Concept.make("Module origins (SOLOR)", PublicIds.of(UUID.fromString("462862d4-5df9-426e-b785-a1264e24769f")));

    /** {@code Navigation (SOLOR)} — same identity as {@code TinkarTerm.NAVIGATION}. */
    public static final EntityProxy.Concept NAVIGATION =
            EntityProxy.Concept.make("Navigation (SOLOR)", PublicIds.of(UUID.fromString("4d9707d8-adf0-5b15-89fc-039e4ff6fec8")));

    /** {@code Object (SOLOR)} — same identity as {@code TinkarTerm.OBJECT}. */
    public static final EntityProxy.Concept OBJECT =
            EntityProxy.Concept.make("Object (SOLOR)", PublicIds.of(UUID.fromString("72765109-6b53-3814-9b05-34ebddd16592")));

    /** {@code Object properties (SOLOR)} — same identity as {@code TinkarTerm.OBJECT_PROPERTIES}. */
    public static final EntityProxy.Concept OBJECT_PROPERTIES =
            EntityProxy.Concept.make("Object properties (SOLOR)", PublicIds.of(UUID.fromString("3ef4311c-70c0-5149-9e06-53d745f85b15")));

    /** {@code Path (SOLOR)} — same identity as {@code TinkarTerm.PATH}. */
    public static final EntityProxy.Concept PATH =
            EntityProxy.Concept.make("Path (SOLOR)", PublicIds.of(UUID.fromString("4459d8cf-5a6f-3952-9458-6d64324b27b7")));

    /** {@code Version control path pattern} — same identity as {@code TinkarTerm.PATHS_PATTERN}. */
    public static final EntityProxy.Pattern PATHS_PATTERN =
            EntityProxy.Pattern.make("Version control path pattern", PublicIds.of(UUID.fromString("add1db57-72fe-53c8-a528-1614bda20ec6")));

    /** {@code Path concept (SOLOR)} — same identity as {@code TinkarTerm.PATH_CONCEPT}. */
    public static final EntityProxy.Concept PATH_CONCEPT =
            EntityProxy.Concept.make("Path concept (SOLOR)", PublicIds.of(UUID.fromString("1b9d9f95-fc0a-55ac-b2e6-7c8b37660046")));

    /** {@code Path coordinate properties (SOLOR)} — same identity as {@code TinkarTerm.PATH_COORDINATE_PROPERTIES}. */
    public static final EntityProxy.Concept PATH_COORDINATE_PROPERTIES =
            EntityProxy.Concept.make("Path coordinate properties (SOLOR)", PublicIds.of(UUID.fromString("ec41e427-f009-5e45-a643-6dc658d63d83")));

    /** {@code Path for version (SOLOR)} — same identity as {@code TinkarTerm.PATH_FOR_VERSION}. */
    public static final EntityProxy.Concept PATH_FOR_VERSION =
            EntityProxy.Concept.make("Path for version (SOLOR)", PublicIds.of(UUID.fromString("ad3dd2dd-ddb0-584c-bea4-c6d9b91d461f")));

    /** {@code Path origins (SOLOR)} — same identity as {@code TinkarTerm.PATH_ORIGINS}. */
    public static final EntityProxy.Concept PATH_ORIGINS =
            EntityProxy.Concept.make("Path origins (SOLOR)", PublicIds.of(UUID.fromString("6e6a112e-7d8c-53c7-aaf1-c46e2d69743c")));

    /** {@code Version control path origin pattern} — same identity as {@code TinkarTerm.PATH_ORIGINS_PATTERN}. */
    public static final EntityProxy.Pattern PATH_ORIGINS_PATTERN =
            EntityProxy.Pattern.make("Version control path origin pattern", PublicIds.of(UUID.fromString("70f89dd5-2cdb-59bb-bbaa-98527513547c")));

    /** {@code Phenomenon (SOLOR)} — same identity as {@code TinkarTerm.PHENOMENON}. */
    public static final EntityProxy.Concept PHENOMENON =
            EntityProxy.Concept.make("Phenomenon (SOLOR)", PublicIds.of(UUID.fromString("c2e8bc47-3353-5e02-b0d1-2a5916efed4d")));

    /** {@code Preferred (SOLOR)} — same identity as {@code TinkarTerm.PREFERRED}. */
    public static final EntityProxy.Concept PREFERRED =
            EntityProxy.Concept.make("Preferred (SOLOR)", PublicIds.of(UUID.fromString("266f1bc3-3361-39f3-bffe-69db9daea56e")));

    /** {@code Primordial path (SOLOR)} — same identity as {@code TinkarTerm.PRIMORDIAL_PATH}. */
    public static final EntityProxy.Concept PRIMORDIAL_PATH =
            EntityProxy.Concept.make("Primordial path (SOLOR)", PublicIds.of(UUID.fromString("e95b6718-f824-5540-817b-8e79544eb97a")));

    /** {@code Purpose (SOLOR)} — same identity as {@code TinkarTerm.PURPOSE}. */
    public static final EntityProxy.Concept PURPOSE =
            EntityProxy.Concept.make("Purpose (SOLOR)", PublicIds.of(UUID.fromString("c3dffc48-6493-54df-a2f0-14be8ba03091")));

    /** {@code Query clauses (SOLOR)} — same identity as {@code TinkarTerm.QUERY_CLAUSES}. */
    public static final EntityProxy.Concept QUERY_CLAUSES =
            EntityProxy.Concept.make("Query clauses (SOLOR)", PublicIds.of(UUID.fromString("4905348c-ba1d-58ae-821f-52877d9acee3")));

    /** {@code Reference Range} — same identity as {@code TinkarTerm.REFERENCE_RANGE}. */
    public static final EntityProxy.Concept REFERENCE_RANGE =
            EntityProxy.Concept.make("Reference Range", PublicIds.of(UUID.fromString("87ce975b-309b-47f4-a6c6-4ae6df6649a1")));

    /** {@code Reference Range Maximum} — same identity as {@code TinkarTerm.REFERENCE_RANGE_MAXIMUM}. */
    public static final EntityProxy.Concept REFERENCE_RANGE_MAXIMUM =
            EntityProxy.Concept.make("Reference Range Maximum", PublicIds.of(UUID.fromString("72d58983-b1e1-4ca9-833f-0e40c1defd39")));

    /** {@code Reference Range Minimum} — same identity as {@code TinkarTerm.REFERENCE_RANGE_MINIMUM}. */
    public static final EntityProxy.Concept REFERENCE_RANGE_MINIMUM =
            EntityProxy.Concept.make("Reference Range Minimum", PublicIds.of(UUID.fromString("37c35a88-9e27-42ca-b626-186773c4b612")));

    /** {@code Regular name description type (SOLOR)} — same identity as {@code TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE}. */
    public static final EntityProxy.Concept REGULAR_NAME_DESCRIPTION_TYPE =
            EntityProxy.Concept.make("Regular name description type (SOLOR)", PublicIds.of(UUID.fromString("8bfba944-3965-3946-9bcb-1e80a5da63a2"), UUID.fromString("d6fad981-7df6-3388-94d8-238cc0465a79")));

    /** {@code Relationship destination (SOLOR)} — same identity as {@code TinkarTerm.RELATIONSHIP_DESTINATION}. */
    public static final EntityProxy.Concept RELATIONSHIP_DESTINATION =
            EntityProxy.Concept.make("Relationship destination (SOLOR)", PublicIds.of(UUID.fromString("a3dd69af-355c-54ce-ba13-2902a7ae9551")));

    /** {@code Relationship origin (SOLOR)} — same identity as {@code TinkarTerm.RELATIONSHIP_ORIGIN}. */
    public static final EntityProxy.Concept RELATIONSHIP_ORIGIN =
            EntityProxy.Concept.make("Relationship origin (SOLOR)", PublicIds.of(UUID.fromString("ad22d43b-3ee7-550b-9660-a6e68af347c2")));

    /** {@code Role (SOLOR)} — same identity as {@code TinkarTerm.ROLE}. */
    public static final EntityProxy.Concept ROLE =
            EntityProxy.Concept.make("Role (SOLOR)", PublicIds.of(UUID.fromString("46ae9325-dd24-5008-8fda-80cf1f0977c7")));

    /** {@code Role group (SOLOR)} — same identity as {@code TinkarTerm.ROLE_GROUP}. */
    public static final EntityProxy.Concept ROLE_GROUP =
            EntityProxy.Concept.make("Role group (SOLOR)", PublicIds.of(UUID.fromString("a63f4bf2-a040-11e5-8994-feff819cdc9f"), UUID.fromString("f97abff6-a221-57a1-9cd6-e79e723bfe2a"), UUID.fromString("051fbfed-3c40-3130-8c09-889cb7b7b5b6")));

    /** {@code Role operator (SOLOR)} — same identity as {@code TinkarTerm.ROLE_OPERATOR}. */
    public static final EntityProxy.Concept ROLE_OPERATOR =
            EntityProxy.Concept.make("Role operator (SOLOR)", PublicIds.of(UUID.fromString("f9860cb8-a7c7-5743-9d7c-ffc6e8a24a0f")));

    /** {@code Role type (SOLOR)} — same identity as {@code TinkarTerm.ROLE_TYPE}. */
    public static final EntityProxy.Concept ROLE_TYPE =
            EntityProxy.Concept.make("Role type (SOLOR)", PublicIds.of(UUID.fromString("76320274-be2a-5ba0-b3e8-e6d2e383ee6a")));

    /** {@code Root vertex} — same identity as {@code TinkarTerm.ROOT_VERTEX}. */
    public static final EntityProxy.Concept ROOT_VERTEX =
            EntityProxy.Concept.make("Root vertex", PublicIds.of(UUID.fromString("7c21b6c5-cf11-5af9-893b-743f004c97f5")));

    /** {@code Sandbox component (SOLOR)} — same identity as {@code TinkarTerm.SANDBOX_COMPONENT}. */
    public static final EntityProxy.Concept SANDBOX_COMPONENT =
            EntityProxy.Concept.make("Sandbox component (SOLOR)", PublicIds.of(UUID.fromString("c93829b2-aa78-5a84-ac9a-c34307844166")));

    /** {@code Sandbox module (SOLOR)} — same identity as {@code TinkarTerm.SANDBOX_MODULE}. */
    public static final EntityProxy.Concept SANDBOX_MODULE =
            EntityProxy.Concept.make("Sandbox module (SOLOR)", PublicIds.of(UUID.fromString("c5daf0e9-30dc-5b3e-a521-d6e6e72c8a95")));

    /** {@code Sandbox path (SOLOR)} — same identity as {@code TinkarTerm.SANDBOX_PATH}. */
    public static final EntityProxy.Concept SANDBOX_PATH =
            EntityProxy.Concept.make("Sandbox path (SOLOR)", PublicIds.of(UUID.fromString("80710ea6-983c-5fa0-8908-e479f1f03ea9")));

    /** {@code Semantic properties (SOLOR)} — same identity as {@code TinkarTerm.SEMANTIC_PROPERTIES}. */
    public static final EntityProxy.Concept SEMANTIC_PROPERTIES =
            EntityProxy.Concept.make("Semantic properties (SOLOR)", PublicIds.of(UUID.fromString("b717ae48-5488-5dda-a980-97855001cc99")));

    /** {@code Semantic type (SOLOR)} — same identity as {@code TinkarTerm.SEMANTIC_TYPE}. */
    public static final EntityProxy.Concept SEMANTIC_TYPE =
            EntityProxy.Concept.make("Semantic type (SOLOR)", PublicIds.of(UUID.fromString("3daac6c4-78c5-5271-9c63-6e28f80e0c52")));

    /** {@code Starter Data Authoring (SOLOR)} — same identity as {@code TinkarTerm.STARTER_DATA_AUTHORING}. */
    public static final EntityProxy.Concept STARTER_DATA_AUTHORING =
            EntityProxy.Concept.make("Starter Data Authoring (SOLOR)", PublicIds.of(UUID.fromString("070deb74-acc5-46bf-b9c6-eaee1b58ef52")));

    /** {@code Stated Definition} — same identity as {@code TinkarTerm.STATED_DEFINITION}. */
    public static final EntityProxy.Concept STATED_DEFINITION =
            EntityProxy.Concept.make("Stated Definition", PublicIds.of(UUID.fromString("28608bd3-ac73-4fe8-a5f0-1efe0d6650a8")));

    /** {@code Status for version (SOLOR)} — same identity as {@code TinkarTerm.STATUS_FOR_VERSION}. */
    public static final EntityProxy.Concept STATUS_FOR_VERSION =
            EntityProxy.Concept.make("Status for version (SOLOR)", PublicIds.of(UUID.fromString("0608e233-d79d-5076-985b-9b1ea4e14b4c")));

    /** {@code Status value (SOLOR)} — same identity as {@code TinkarTerm.STATUS_VALUE}. */
    public static final EntityProxy.Concept STATUS_VALUE =
            EntityProxy.Concept.make("Status value (SOLOR)", PublicIds.of(UUID.fromString("10b873e2-8247-5ab5-9dec-4edef37fc219")));

    /** {@code String (SOLOR)} — same identity as {@code TinkarTerm.STRING}. */
    public static final EntityProxy.Concept STRING =
            EntityProxy.Concept.make("String (SOLOR)", PublicIds.of(UUID.fromString("a46aaf11-b37a-32d6-abdc-707f084ec8f5")));

    /** {@code Sufficient concept definition operator (SOLOR)} — same identity as {@code TinkarTerm.SUFFICIENT_CONCEPT_DEFINITION_OPERATOR}. */
    public static final EntityProxy.Concept SUFFICIENT_CONCEPT_DEFINITION_OPERATOR =
            EntityProxy.Concept.make("Sufficient concept definition operator (SOLOR)", PublicIds.of(UUID.fromString("dfa80f36-dbe6-5006-8509-c497a26ceab5")));

    /** {@code Taxonomy operator (SOLOR)} — same identity as {@code TinkarTerm.TAXONOMY_OPERATOR}. */
    public static final EntityProxy.Concept TAXONOMY_OPERATOR =
            EntityProxy.Concept.make("Taxonomy operator (SOLOR)", PublicIds.of(UUID.fromString("e9252365-7a43-57ea-bf94-3f23bab4ef99")));

    /** {@code Text comparison measure semantic (SOLOR)} — same identity as {@code TinkarTerm.TEXT_COMPARISON_MEASURE_SEMANTIC}. */
    public static final EntityProxy.Concept TEXT_COMPARISON_MEASURE_SEMANTIC =
            EntityProxy.Concept.make("Text comparison measure semantic (SOLOR)", PublicIds.of(UUID.fromString("b1531e68-4e7a-5194-b1f9-9aaace269372")));

    /** {@code Text for description (SOLOR)} — same identity as {@code TinkarTerm.TEXT_FOR_DESCRIPTION}. */
    public static final EntityProxy.Concept TEXT_FOR_DESCRIPTION =
            EntityProxy.Concept.make("Text for description (SOLOR)", PublicIds.of(UUID.fromString("8bdcbe5d-e92e-5c10-845e-b585e6061672")));

    /** {@code Time for version (SOLOR)} — same identity as {@code TinkarTerm.TIME_FOR_VERSION}. */
    public static final EntityProxy.Concept TIME_FOR_VERSION =
            EntityProxy.Concept.make("Time for version (SOLOR)", PublicIds.of(UUID.fromString("a9b0dfb2-f463-5dae-8ba8-7f2e8385571b")));

    /** {@code Tinkar base model component pattern} — same identity as {@code TinkarTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN}. */
    public static final EntityProxy.Pattern TINKAR_BASE_MODEL_COMPONENT_PATTERN =
            EntityProxy.Pattern.make("Tinkar base model component pattern", PublicIds.of(UUID.fromString("6070f6f5-893d-5144-adce-7d305c391cf9")));

    /** {@code Tinkar Model concept (SOLOR)} — same identity as {@code TinkarTerm.TINKAR_MODEL_CONCEPT}. */
    public static final EntityProxy.Concept TINKAR_MODEL_CONCEPT =
            EntityProxy.Concept.make("Tinkar Model concept (SOLOR)", PublicIds.of(UUID.fromString("bc59d656-83d3-47d8-9507-0e656ea95463")));

    /** {@code Tree amalgam properties (SOLOR)} — same identity as {@code TinkarTerm.TREE_AMALGAM_PROPERTIES}. */
    public static final EntityProxy.Concept TREE_AMALGAM_PROPERTIES =
            EntityProxy.Concept.make("Tree amalgam properties (SOLOR)", PublicIds.of(UUID.fromString("d6151a47-4610-5a5c-abd0-42c82be9b633")));

    /** {@code Universally Unique Identifier (SOLOR)} — same identity as {@code TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER}. */
    public static final EntityProxy.Concept UNIVERSALLY_UNIQUE_IDENTIFIER =
            EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of(UUID.fromString("845274b5-9644-3799-94c6-e0ea37e7d1a4")));

    /** {@code User (SOLOR)} — same identity as {@code TinkarTerm.USER}. */
    public static final EntityProxy.Concept USER =
            EntityProxy.Concept.make("User (SOLOR)", PublicIds.of(UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c")));

    /** {@code US Dialect pattern} — same identity as {@code TinkarTerm.US_DIALECT_PATTERN}. */
    public static final EntityProxy.Pattern US_DIALECT_PATTERN =
            EntityProxy.Pattern.make("US Dialect pattern", PublicIds.of(UUID.fromString("08f9112c-c041-56d3-b89b-63258f070074")));

    /** {@code US English dialect (SOLOR)} — same identity as {@code TinkarTerm.US_ENGLISH_DIALECT}. */
    public static final EntityProxy.Concept US_ENGLISH_DIALECT =
            EntityProxy.Concept.make("US English dialect (SOLOR)", PublicIds.of(UUID.fromString("bca0a686-3516-3daf-8fcf-fe396d13cfad")));

    /** {@code Value Constraint} — same identity as {@code TinkarTerm.VALUE_CONSTRAINT}. */
    public static final EntityProxy.Concept VALUE_CONSTRAINT =
            EntityProxy.Concept.make("Value Constraint", PublicIds.of(UUID.fromString("8c55fb86-92d8-42a9-ad70-1e23abbf7eec")));

    /** {@code Value Constraint Source} — same identity as {@code TinkarTerm.VALUE_CONSTRAINT_SOURCE}. */
    public static final EntityProxy.Concept VALUE_CONSTRAINT_SOURCE =
            EntityProxy.Concept.make("Value Constraint Source", PublicIds.of(UUID.fromString("09aa031a-6290-4ec9-a44c-23928a767da3")));

    /** {@code Version properties (SOLOR)} — same identity as {@code TinkarTerm.VERSION_PROPERTIES}. */
    public static final EntityProxy.Concept VERSION_PROPERTIES =
            EntityProxy.Concept.make("Version properties (SOLOR)", PublicIds.of(UUID.fromString("93f844df-38e5-5167-ba94-2c948b8bd07c")));

}
