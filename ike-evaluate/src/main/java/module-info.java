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
 * Evaluation over statement sets: a stored library's trees run against statements under a
 * view, each node kind taken to the construct a checked relation admits, yielding values of
 * IKE's own kinds and refusing what no relation admits (IKE-Network/ike-issues#1116).
 */
module network.ike.foundation.ike.evaluate {
    requires transitive dev.ikm.tinkar.entity;
    requires dev.ikm.tinkar.common;
    requires dev.ikm.tinkar.terms;
    requires org.eclipse.collections.api;
    requires network.ike.foundation.ike.bindings;
    requires network.ike.foundation.ike.writer;
    requires network.ike.foundation.ike.ucum;
    requires network.ike.foundation.ike.model;
    requires network.ike.foundation.ike.elm;

    exports network.ike.foundation.ike.evaluate;
}
