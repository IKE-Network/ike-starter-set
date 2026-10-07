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
 * Komet's terms: the components Komet and its plugins name in their own code beyond the
 * kernel, bound in {@link Ike#KOMET} ({@code dev.ikm.komet.terms.KometTerm}) under the names
 * Komet already gave them, with misspellings fixed ({@code PATH_OPTIONS_FOR_EDIT_COORDINATE},
 * {@code PROMOTION_PATH_FOR_EDIT_COORDINATE}). Several are bound in the set's own classes too,
 * under the set's names ({@code IMAGE_FIELD} is {@code IMAGE_DISPLAY_FIELD} there): a component
 * may have a binding in each context that names it. Generated from the set and committed into
 * Komet's {@code komet-terms} module; {@code CommittedBindingsDriftTest} holds the committed
 * class to this list.
 * <p>
 * The members are the {@code KometTerm} constants Komet had (2026-10-05), less
 * {@code CURRENT_ACTIVITY}, which nothing named, and the constants that main code in Komet
 * and its plugins used beyond the kernel, each one a component of the set.
 * Komet's window, pane and preference settings are not here: they name JavaFX properties,
 * nothing reaches a store, and they stay in Komet's hand-written {@code KometSettingTerm}.
 */
final class KometBindings {

    private KometBindings() {
    }

    static void compose(KnowledgeSet set) {
        bind(set, "12b9e103-060e-3256-9982-18c1191af60e", "ACCEPTABLE");
        bind(set, "23f69f6f-a502-5876-a835-2b1b4d5ce91e", "ALLOWED_STATES_FOR_STAMP_COORDINATE");
        bind(set, "927da7ac-3403-5ccc-b07b-88f60cc3a5f8", "ANY_COMPONENT");
        bind(set, "337e93ba-531b-59a4-8153-57dca00e58d2", "AUTHOR_FOR_EDIT_COORDINATE");
        bind(set, "9c6fbddd-58bd-5881-b926-c813bbff849b", "AXIOM_FOCUS");
        bind(set, "cd23d88d-2fcd-4007-8829-97e37bf336aa", "BLANK_CONCEPT");
        bind(set, "4b90e89d-2a0e-5ca3-8ae5-7498d148a9d2", "CLASSIFIER_FOR_LOGIC_COORDINATE");
        bind(set, "16486419-5d1c-574f-bde6-21910ad66f44", "CONCEPT_ASSEMBLAGE_FOR_LOGIC_COORDINATE");
        bind(set, "081273cd-92dd-593c-9d9b-63d33838e70b", "CONCEPT_CONSTRAINTS");
        bind(set, "dca9854d-9e4c-5e8a-8b30-6c1af6901bb8", "CONCEPT_FOCUS");
        bind(set, "e83d322c-e275-5392-a5db-1de5fe98acb5", "DEFAULT_MODULE_FOR_EDIT_COORDINATE");
        bind(set, "6edf734d-7f57-5430-9164-6ee0824fd94b", "DESCRIPTION_FOCUS");
        bind(set, "aef80e34-b2dd-5dca-a989-3e0ee2699be3", "DESCRIPTION_LOGIC_PROFILE_FOR_LOGIC_COORDINATE");
        bind(set, "44c7eab6-fdb8-5427-9d7a-52ab63f7a6f9", "DESCRIPTION_TYPE_PREFERENCE_LIST_FOR_LANGUAGE_COORDINATE");
        bind(set, "349cfd1d-10fd-5f8d-a0a5-d5ef0932b4da", "DESTINATION_MODULE_FOR_EDIT_COORDINATE");
        bind(set, "529a7069-bd33-59e6-b2ce-537fa874360a", "DEVELOPMENT_MODULE");
        bind(set, "c060ffbf-e95f-5960-b296-8a3255c820ac", "DIALECT_ASSEMBLAGE_PREFERENCE_LIST_FOR_LANGUAGE_COORDINATE");
        bind(set, "1cdacc80-0dea-580f-a77b-8a6b273eb673", "DIGRAPH_FOR_LOGIC_COORDINATE");
        bind(set, "4e627b9c-cecb-5563-82fc-cb0ee25113b1", "DISPLAY_FIELDS");
        bind(set, "85ff6e8f-9151-5428-a5f0-e07844b69260", "DOUBLE_FIELD");
        bind(set, "61da7e50-f606-5ba0-a0df-83fd524951e7", "DYNAMIC_COLUMN_DATA_TYPES");
        bind(set, "0d94ceeb-e24f-5f1a-84b2-1ac35f671db5", "DYNAMIC_REFERENCED_COMPONENT_RESTRICTION");
        bind(set, "fb591801-7b37-525d-980d-98a1c63ceee0", "FLOAT");
        bind(set, "eb9a5e42-3cba-356d-b623-3ed472e20b30", "GB_ENGLISH_DIALECT");
        bind(set, "65af466b-360c-58b2-8b7d-2854150029a8", "GREATER_THAN");
        bind(set, "c1baba19-e918-5d2c-8fa4-b0ad93e03186", "GREATER_THAN_OR_EQUAL_TO");
        bind(set, "cd9ea037-0af9-586b-9369-7bc044cdb8f7", "IMAGE_FIELD");
        bind(set, "9ecf4d76-4346-5e5d-8316-bdff48a5c154", "INFERRED_ASSEMBLAGE_FOR_LOGIC_COORDINATE");
        bind(set, "a2d37d2d-ac49-589f-ba36-ac9b8808b00b", "INTRINSIC_ROLE");
        bind(set, "46bccdc4-8fb6-11db-b606-0800200c9a66", "IS_A");
        bind(set, "34a6dae3-e5e9-50db-a9ee-69c1067911d8", "KOMET_MODULE");
        bind(set, "42dff20f-5ed2-559a-91ad-91d44a573c63", "LANGUAGE_COORDINATE_NAME");
        bind(set, "b0ad4d77-e1bc-5fd1-922e-5fad675e9bfd", "LANGUAGE_SPECIFICATION_FOR_LANGUAGE_COORDINATE");
        bind(set, "6f96e8cf-5568-5e49-8a90-aa6c65125ee9", "LESS_THAN");
        bind(set, "6dfacbd5-8344-5794-9fda-bec95b2aa6c9", "LESS_THAN_OR_EQUAL_TO");
        bind(set, "7dccd042-b0b8-5cec-a1bc-6de676b92f4b", "LOGICAL_DEFINITION");
        bind(set, "c16eb414-8840-54f8-9bd2-e2f1ab37e19d", "LOGICAL_EXPRESSION_FIELD");
        bind(set, "a06158ff-e08a-5d7d-bcfa-6cbfdb138910", "MEANING");
        bind(set, "4fa29287-a80e-5f83-abab-4b587973e7b7", "MEMBERSHIP_SEMANTIC");
        bind(set, "40d1c869-b509-32f8-b735-836eac577a67", "MODULE");
        bind(set, "bf69c4f1-95c9-5956-a10a-d3ba9276c019", "MODULES_FOR_STAMP_COORDINATE");
        bind(set, "3fe047f0-33b0-5254-91c2-43e65f90d30b", "MODULE_EXCLUSION_SET_FOR_STAMP_COORDINATE");
        bind(set, "67cd64f1-96d7-5110-b847-556c055ac063", "MODULE_FOR_VERSION");
        bind(set, "19305aff-95d9-55d9-b015-825cc68eadc7", "MODULE_OPTIONS_FOR_EDIT_COORDINATE");
        bind(set, "f36e7ca6-34a2-58b5-8b25-736457515f9c", "MODULE_PREFERENCE_LIST_FOR_LANGUAGE_COORDINATE");
        bind(set, "ddeda759-e89c-5186-aa40-d63070756ab4", "MODULE_PREFERENCE_ORDER_FOR_STAMP_COORDINATE");
        bind(set, "fc965c5d-ad17-555e-bcb5-b78fd45c8c5f", "NAVIGATION_CONCEPT_SET");
        bind(set, "d4cc29ae-c0c1-563a-985d-5165a768dd44", "NOT_APPLICABLE");
        bind(set, "b4c3f6f9-6937-30fd-8412-d0c77f8a7f73", "PART_OF");
        bind(set, "4459d8cf-5a6f-3952-9458-6d64324b27b7", "PATH");
        bind(set, "748e073c-fea7-58dd-8aa3-f18fdd82ddfc", "PATH_FOR_PATH_COORDINATE");
        bind(set, "ad3dd2dd-ddb0-584c-bea4-c6d9b91d461f", "PATH_FOR_VERSION");
        bind(set, "2110c10c-9174-55aa-8ffe-91650c77d0b3", "PATH_OPTIONS_FOR_EDIT_COORDINATE");
        bind(set, "f33e1668-34dd-53dd-8728-31b29934b482", "PATH_ORIGINS_FOR_STAMP_PATH");
        bind(set, "31173582-a49d-51c6-813f-f42d0976aaea", "POSITION_ON_PATH");
        bind(set, "db124d3b-c1bb-530e-8fd4-577f570355be", "PROMOTION_PATH_FOR_EDIT_COORDINATE");
        bind(set, "e0de0d09-6e27-5738-bc8f-0fc94bb115fc", "PROPERTY_PATTERN_IMPLICATION");
        bind(set, "c3dffc48-6493-54df-a2f0-14be8ba03091", "PURPOSE");
        bind(set, "862cc189-bbcb-51a0-89a4-16e1854be247", "ROOT_FOR_LOGIC_COORDINATE");
        bind(set, "cfd2a47e-8169-5e71-9122-d5b73efd990a", "STATED_ASSEMBLAGE_FOR_LOGIC_COORDINATE");
        bind(set, "614017af-9903-53d9-aab4-15fd02193dce", "STATED_NAVIGATION");
        bind(set, "0608e233-d79d-5076-985b-9b1ea4e14b4c", "STATUS_FOR_VERSION");
        bind(set, "10b873e2-8247-5ab5-9dec-4edef37fc219", "STATUS_VALUE");
        bind(set, "845274b5-9644-3799-94c6-e0ea37e7d1a4", "UNIVERSALLY_UNIQUE_IDENTIFIER");
        bind(set, "4be7118f-e6ab-5dc7-bcba-b2cc8b028492", "UNMODELED_ROLE_CONCEPT");
        bind(set, "bca0a686-3516-3daf-8fcf-fe396d13cfad", "US_ENGLISH_DIALECT");
        bind(set, "dea8cb0f-9bb5-56bb-af27-a14943cb24ba", "UUID_FIELD");
        bind(set, "3e56c6b6-5371-11eb-ae93-0242ac130002", "VERTEX_FIELD");
        bind(set, "e973f077-a99d-59e6-b7bd-804e87e0e639", "VERTEX_SORT");
        bind(set, "347cd3f2-8130-5032-8960-091e194e9afe", "VERTEX_STATE_SET");
    }

    private static void bind(KnowledgeSet set, String uuid, String constant) {
        set.bind(PublicIds.of(UUID.fromString(uuid)), Ike.KOMET, constant);
    }
}
