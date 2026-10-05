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
import dev.ikm.tinkar.entity.builder.KnowledgeSet;

import java.util.UUID;

/**
 * The kernel: the components tinkar-core and its stores name in their own code, bound in
 * {@link Ike#KERNEL} ({@code dev.ikm.tinkar.terms.KernelTerm}) under the names
 * {@code TinkarTerm} gave them, so moving a reference from one to the other changes no name
 * and no identity. Generated from the set and committed into tinkar-core, which the set is
 * built with and so cannot depend on; {@code CommittedBindingsDriftTest} holds the committed
 * class to this list.
 * <p>
 * The members are the {@code TinkarTerm} constants that main code in tinkar-core, rocks-kb
 * and ike-knowledge-provider used when the kernel was cut (2026-10-04), and those that
 * tinkar-service and tinkar-composer use (2026-10-05), each one a component of the set. The
 * list shrinks as defaults move into the data.
 */
final class KernelBindings {

    private KernelBindings() {
    }

    static void compose(KnowledgeSet set) {
        bind(set, "09f12001-0e4f-51e2-9852-44862a4a0db4", "ACTIVE_STATE");
        bind(set, "fa113d51-07d2-587c-8930-0bce207d506d", "AND");
        bind(set, "f8f936d4-3ac7-5629-9f65-9452608056a1", "ANONYMOUS_CONCEPT");
        bind(set, "b168ad04-f814-5036-b886-fd4913de88c8", "ARRAY_FIELD");
        bind(set, "4eb9de0d-7486-5f18-a9b4-82e3432f4103", "AUTHOR_FOR_VERSION");
        bind(set, "8da1c508-c2a2-4899-b26d-87f8b98a7558", "AXIOM_SYNTAX");
        bind(set, "d6b9e2cc-31c6-5e80-91b7-7537690aae32", "BOOLEAN_FIELD");
        bind(set, "dbdd8df2-aec3-596b-88fc-7b83b5594a45", "BYTE_ARRAY_FIELD");
        bind(set, "b42c1948-7645-5da8-a888-de6ec020ab98", "CANCELED_STATE");
        bind(set, "ba2efe6b-fe56-3d91-ae0f-3b389628f74c", "CHINESE_LANGUAGE");
        bind(set, "3734fb0a-4c14-5831-9a61-4743af609e7a", "COMMENT_PATTERN");
        bind(set, "fb00d132-fcc3-5cbf-881d-4bcc4b4c91b3", "COMPONENT_FIELD");
        bind(set, "e553d3f1-63e1-4292-a3a9-af646fe44292", "COMPONENT_ID_LIST_FIELD");
        bind(set, "e283af51-2e8f-44fa-9bf1-89a99a7c7631", "COMPONENT_ID_SET_FIELD");
        bind(set, "ac8f1f54-c7c6-5fc7-b1a8-ebb04b918557", "CONCEPT_FIELD");
        bind(set, "e89148c7-4fe2-52f8-abb9-6a53605d20cb", "CONCEPT_REFERENCE");
        bind(set, "843b0b55-8785-5544-93f6-581da9cf1ff3", "CONCRETE_DOMAIN_OPERATOR");
        bind(set, "33aa2d26-0541-557c-b796-904cbf245101", "CZECH_LANGUAGE");
        bind(set, "7e462e33-6d94-38ae-a044-492a857a6853", "DANISH_LANGUAGE");
        bind(set, "6b8ed642-de72-4aee-953d-42e5db92c0ab", "DATA_PROPERTY_SET");
        bind(set, "b413fe94-4ada-4aee-96f9-22be19699d40", "DECIMAL_FIELD");
        bind(set, "700546a3-09c7-3fc2-9eb9-53d318659a09", "DEFINITION_DESCRIPTION_TYPE");
        bind(set, "e7271c01-6ed4-5240-963f-34d1f24153b0", "DEFINITION_ROOT");
        bind(set, "96b61063-0d29-5aea-9652-3f5f328aadc3", "DESCRIPTION_ACCEPTABILITY");
        bind(set, "0def37bc-7e1b-384b-a6a3-3e3ceee9c52e", "DESCRIPTION_CASE_SENSITIVE");
        bind(set, "c3dde9ea-b144-5f49-845a-20cc7d305250", "DESCRIPTION_CASE_SIGNIFICANCE");
        bind(set, "17915e0d-ed38-3488-a35c-cda966db306a", "DESCRIPTION_INITIAL_CHARACTER_CASE_SENSITIVE");
        bind(set, "ecea41a2-f596-3d98-99d1-771b667e55b8", "DESCRIPTION_NOT_CASE_SENSITIVE");
        bind(set, "a4de0039-2625-5842-8a4c-d1ce6aebf021", "DESCRIPTION_PATTERN");
        bind(set, "ad0c19e8-2ccc-59c1-8b7e-c56c03aca8eb", "DESCRIPTION_TYPE");
        bind(set, "1f200ca6-960e-11e5-8994-feff819cdc9f", "DEVELOPMENT_PATH");
        bind(set, "60113dfe-2bad-11eb-adc1-0242ac120002", "DIGRAPH_FIELD");
        bind(set, "f8433993-9a2d-5377-b564-80a45c7b7824", "DISJOINT_WITH");
        bind(set, "32f64fc6-5371-11eb-ae93-0242ac130002", "DITREE_FIELD");
        bind(set, "674ad858-0224-3f90-bcf0-bc4cab753d2d", "DUTCH_LANGUAGE");
        bind(set, "9f011812-15c9-5b1b-85f8-bb262bc1b2a2", "EL_PLUS_PLUS_INFERRED_AXIOMS_PATTERN");
        bind(set, "b6d3be7d-1d7f-5c44-a425-5357f878c212", "EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS");
        bind(set, "1f201e12-960e-11e5-8994-feff819cdc9f", "EL_PLUS_PLUS_PROFILE");
        bind(set, "e813eb92-7d07-5035-8d43-e81249f5b36e", "EL_PLUS_PLUS_STATED_AXIOMS_PATTERN");
        bind(set, "1412bd09-eb0c-5107-9756-10c1c417d385", "EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS");
        bind(set, "06d905ea-c647-3af9-bfe5-2514e135b558", "ENGLISH_LANGUAGE");
        bind(set, "5c9b5844-1434-5111-83d5-cb7cb0be12d9", "EQUAL_TO");
        bind(set, "91e9080f-78f6-5d23-891d-f5b6e77995c8", "EXISTENTIAL_RESTRICTION");
        bind(set, "5e76a88e-794a-5fdd-8eb2-4a9e4b1386b6", "FEATURE");
        bind(set, "c9120d8b-1acc-5267-9f33-fa716abdb69d", "FEATURE_TYPE");
        bind(set, "6efe7087-3e3c-5b45-8109-90d7652b1506", "FLOAT_FIELD");
        bind(set, "8b23e636-a0bd-30fb-b8e2-1f77eaa3a87e", "FRENCH_LANGUAGE");
        bind(set, "00791270-77c9-32b6-b34f-d932569bd2bf", "FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE");
        bind(set, "561f817a-130e-5e56-984d-910e9991558c", "GB_DIALECT_PATTERN");
        bind(set, "5f144b18-76a8-5c7e-8480-55a5030d707f", "GERMAN_LANGUAGE");
        bind(set, "5d60e14b-c410-5172-9559-3c4253278ae2", "IDENTIFIER_PATTERN");
        bind(set, "5a87935c-d654-548f-82a2-0c06e3801162", "IDENTIFIER_SOURCE");
        bind(set, "b32dd26b-c3fc-487e-987e-16ace71a0d0f", "IDENTIFIER_VALUE");
        bind(set, "03004053-c23e-5206-8514-fb551dd328f4", "INACTIVE_STATE");
        bind(set, "def77c09-e1eb-40f2-931a-e7cf2ce0e597", "INCLUSION_SET");
        bind(set, "4bc6c333-7fc9-52f1-942d-f8decba19dc2", "INFERRED_NAVIGATION");
        bind(set, "a53cc42d-c07e-5934-96b3-2ede3264474e", "INFERRED_NAVIGATION_PATTERN");
        bind(set, "1290e6ba-48d0-31d2-8d62-e133373c63f5", "INFERRED_PREMISE_TYPE");
        bind(set, "1fbf42e2-42b7-591f-b7fd-ba5de659529e", "INSTANT_LITERAL");
        bind(set, "ff59c300-9c4e-5e77-a35d-6a133eb3440f", "INTEGER_FIELD");
        bind(set, "52b3e38a-fccb-4779-aa61-4e87abd56419", "INTERVAL_LOWER_BOUND");
        bind(set, "9afc988a-3724-4754-8b74-651426472b19", "INTERVAL_PROPERTY_SET");
        bind(set, "ed9d3506-65ad-48ea-bd01-95474fecdbc4", "INTERVAL_ROLE");
        bind(set, "6fa58611-af37-402e-a0c2-6ee1d6068651", "INTERVAL_ROLE_TYPE");
        bind(set, "6565f774-ff6c-4882-832f-31ddc462adf7", "INTERVAL_UPPER_BOUND");
        bind(set, "58e82fc4-1492-5cf8-8997-43800360bbd6", "IRISH_LANGUAGE");
        bind(set, "bdd59458-381a-5818-8577-60525f11ac6c", "ITALIAN_LANGUAGE");
        bind(set, "bbbbf1fe-00f0-55e0-a19c-6300dbaab9b2", "KOMET_BASE_MODEL_COMPONENT_PATTERN");
        bind(set, "61c1a544-2acf-58cd-8cc0-9ac581d4227e", "KOMET_USER");
        bind(set, "f56fa231-10f9-5e7f-a86d-a1d61b5b56e3", "LANGUAGE");
        bind(set, "cd56cceb-8507-5ae5-a928-16079fe6f832", "LANGUAGE_CONCEPT_NID_FOR_DESCRIPTION");
        bind(set, "208a40a7-e615-5efa-9de0-2e2a5a8488b7", "LITERAL_VALUE");
        bind(set, "dea8cdf1-de75-5991-9791-79714e4a964d", "LONG");
        bind(set, "a0096ba1-0718-4c03-ad8f-8143c44091e7", "LOWER_BOUND_OPEN");
        bind(set, "1f20134a-960e-11e5-8994-feff819cdc9f", "MASTER_PATH");
        bind(set, "536b0ec4-4974-47ae-93a6-ae6c4d169780", "MODULE_ORIGINS_PATTERN");
        bind(set, "c7f01834-34ca-5f8b-8f80-193fbeb12eae", "NAVIGATION_VERTEX");
        bind(set, "acaa2eba-8364-5493-b24c-b3884d34bb60", "NECESSARY_SET");
        bind(set, "2c940bcf-22a8-5fc9-b232-580021e758ed", "OR");
        bind(set, "c0ca180b-aae2-5fa1-9ab7-4a24f2dfe16b", "OWL_AXIOM_SYNTAX_PATTERN");
        bind(set, "add1db57-72fe-53c8-a528-1614bda20ec6", "PATHS_PATTERN");
        bind(set, "70f89dd5-2cdb-59bb-bbaa-98527513547c", "PATH_ORIGINS_PATTERN");
        bind(set, "c2e8bc47-3353-5e02-b0d1-2a5916efed4d", "PHENOMENON");
        bind(set, "266f1bc3-3361-39f3-bffe-69db9daea56e", "PREFERRED");
        bind(set, "c2012321-3903-532e-8a5f-b13e4ca46e86", "PRIMORDIAL_MODULE");
        bind(set, "e95b6718-f824-5540-817b-8e79544eb97a", "PRIMORDIAL_PATH");
        bind(set, "b17bde5d-98ed-5416-97cf-2d837d75159d", "PRIMORDIAL_STATE");
        bind(set, "d0d759fd-510f-475a-900e-b1439b4536e1", "PROPERTY_SEQUENCE");
        bind(set, "9a47a5db-42a6-49ee-9083-54bc305a9456", "PROPERTY_SEQUENCE_IMPLICATION");
        bind(set, "e273b5c0-c012-5e53-990c-aec5c2cb33a7", "PROPERTY_SET");
        bind(set, "7e779e4a-61ed-5c4a-aacc-03cf524b7c73", "REFLEXIVE_PROPERTY");
        bind(set, "8bfba944-3965-3946-9bcb-1e80a5da63a2", "REGULAR_NAME_DESCRIPTION_TYPE");
        bind(set, "a3dd69af-355c-54ce-ba13-2902a7ae9551", "RELATIONSHIP_DESTINATION");
        bind(set, "ad22d43b-3ee7-550b-9660-a6e68af347c2", "RELATIONSHIP_ORIGIN");
        bind(set, "46ae9325-dd24-5008-8fda-80cf1f0977c7", "ROLE");
        bind(set, "a63f4bf2-a040-11e5-8994-feff819cdc9f", "ROLE_GROUP");
        bind(set, "f9860cb8-a7c7-5743-9d7c-ffc6e8a24a0f", "ROLE_OPERATOR");
        bind(set, "76320274-be2a-5ba0-b3e8-e6d2e383ee6a", "ROLE_TYPE");
        bind(set, "7c21b6c5-cf11-5af9-893b-743f004c97f5", "ROOT_VERTEX");
        bind(set, "80710ea6-983c-5fa0-8908-e479f1f03ea9", "SANDBOX_PATH");
        bind(set, "0418a591-f75b-39ad-be2c-3ab849326da9", "SCTID");
        bind(set, "9c3dfc88-51e4-5e51-a59a-88dd580162b7", "SEMANTIC_FIELD_TYPE");
        bind(set, "1f201fac-960e-11e5-8994-feff819cdc9f", "SNOROCKET_CLASSIFIER");
        bind(set, "d39b3ecd-9a80-5009-a8ac-0b947f95ca7c", "SOLOR_CONCEPT_ASSEMBLAGE");
        bind(set, "f680c868-f7e5-5d0e-91f2-615eca8f8fd2", "SOLOR_MODULE");
        bind(set, "9ecc154c-e490-5cf8-805d-d2865d62aef3", "SOLOR_OVERLAY_MODULE");
        bind(set, "0fcf44fb-d0a7-3a67-bc9f-eb3065ed3c8e", "SPANISH_LANGUAGE");
        bind(set, "d02957d6-132d-5b3c-adba-505f5778d998", "STATED_NAVIGATION_PATTERN");
        bind(set, "3b0dbd3b-2e53-3a30-8576-6c7fa7773060", "STATED_PREMISE_TYPE");
        bind(set, "a46aaf11-b37a-32d6-abdc-707f084ec8f5", "STRING");
        bind(set, "8aa48cfd-485b-5140-beb9-0d122f7812d9", "SUFFICIENT_SET");
        bind(set, "8bdcbe5d-e92e-5c10-845e-b585e6061672", "TEXT_FOR_DESCRIPTION");
        bind(set, "a9b0dfb2-f463-5dae-8ba8-7f2e8385571b", "TIME_FOR_VERSION");
        bind(set, "6070f6f5-893d-5144-adce-7d305c391cf9", "TINKAR_BASE_MODEL_COMPONENT_PATTERN");
        bind(set, "53f866d0-fd61-5c85-a16c-150bd619a0ac", "TRANSITIVE_PROPERTY");
        bind(set, "55f74246-0a25-57ac-9473-a788d08fb656", "UNINITIALIZED_COMPONENT");
        bind(set, "40afdda5-89d6-4b80-8181-1ddd6eb92dc8", "UNIT_OF_MEASURE");
        bind(set, "fc18c082-c6ad-52d2-b568-cc9568ace6c9", "UNIVERSAL_RESTRICTION");
        bind(set, "c20b3b1e-112f-4cb2-b901-4046db844629", "UPPER_BOUND_OPEN");
        bind(set, "f7495b58-6630-3499-a44e-2052b5fcf06c", "USER");
        bind(set, "08f9112c-c041-56d3-b89b-63258f070074", "US_DIALECT_PATTERN");
        bind(set, "35fd4750-6e43-5fa3-ba7f-f2ad376052bc", "WITHDRAWN_STATE");
    }

    private static void bind(KnowledgeSet set, String uuid, String constant) {
        set.bind(PublicIds.of(UUID.fromString(uuid)), Ike.KERNEL, constant);
    }
}
