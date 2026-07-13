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
 * The IkeFoundation ledger: the append-only, replayable source of the Ike
 * starter set.
 */
module network.ike.foundation.ike.terms {
    requires transitive dev.ikm.tinkar.entity;

    exports network.ike.foundation.ike.terms;

    provides dev.ikm.tinkar.entity.builder.KnowledgeSetSource
            with network.ike.foundation.ike.terms.IkeSource;
}
