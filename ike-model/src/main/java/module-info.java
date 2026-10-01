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
 * Model information as knowledge: the CQL translator's model information files read into the
 * store, each class a concept and each element a semantic, and IKE's own patterns written out
 * as model information (IKE-Network/ike-issues#1115).
 */
module network.ike.foundation.ike.model {
    requires transitive dev.ikm.tinkar.entity;
    requires dev.ikm.tinkar.common;
    requires dev.ikm.tinkar.terms;
    requires org.eclipse.collections.api;
    requires java.xml;
    requires network.ike.foundation.ike.bindings;
    requires network.ike.foundation.ike.writer;

    exports network.ike.foundation.ike.model;
}
