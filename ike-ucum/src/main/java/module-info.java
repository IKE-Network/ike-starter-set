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
 * The Unified Code for Units of Measure as knowledge: the unmodified UCUM file, its importer,
 * the grammar that composes units on demand, and the reduction to base dimensions.
 */
module network.ike.foundation.ike.ucum {
    requires transitive dev.ikm.tinkar.entity;
    requires dev.ikm.tinkar.common;
    requires dev.ikm.tinkar.terms;
    requires org.eclipse.collections.api;
    requires java.xml;
    requires network.ike.foundation.ike.bindings;
    requires network.ike.foundation.ike.writer;

    exports network.ike.foundation.ike.ucum;
}
