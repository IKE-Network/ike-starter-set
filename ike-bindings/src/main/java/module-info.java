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

/**
 * The IKE starter set's generated bindings: the IkeConcept, IkePattern and IkeStamp enums.
 * A named module, so Komet's plugins can require it (Komet admits no automatic modules); the
 * enums' facades and identities come from tinkar's terms module, read transitively.
 */
module network.ike.foundation.ike.bindings {
    requires transitive dev.ikm.tinkar.terms;

    exports network.ike.foundation.ike.bindings;
}
