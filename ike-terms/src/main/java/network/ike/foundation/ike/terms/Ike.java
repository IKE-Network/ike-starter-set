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

import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.DefaultsTemplateTerm;
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * Ledger-internal handles for the IkeFoundation knowledge set: the session root and the
 * reference handles the sections cite. Handles are conveniences over derived
 * identities — never identity sources. Consumers use the generated bindings class
 * (network.ike.foundation.ike.bindings.IkeTerms), not this one.
 */
public final class Ike {

    private Ike() {
    }

    /**
     * The knowledge set — its UUID is the permanent type-5 namespace from which
     * every identity in the set derives. Never change it.
     */
    public static final KnowledgeSet SET = KnowledgeSet.of("d890e06f-ec35-429a-b541-d0ead19695e2");

    /** The set's module concept — the export dimension for this knowledge. */
    public static final EntityProxy.Concept MODULE =
            SET.conceptRef("IkeFoundation module (IkeFoundation)");

    /** The set's root concept. */
    public static final EntityProxy.Concept ROOT =
            SET.conceptRef("IkeFoundation root (IkeFoundation)");

    /**
     * Community authorship: the IKE Network itself, attributed as author for
     * content synthesized by tooling on the Network's behalf (starter-set
     * ingest, IKE-Network/ike-issues#872) rather than by an individual editor
     * or an ingested upstream source. Resolves the curator-identity TODO this
     * scaffold generates by default.
     */
    public static final EntityProxy.Concept IKE_COMMUNITY =
            SET.conceptRef("IKE Community (IkeFoundation)");

    /**
     * The pre-release set's ONE declared inception stamp (IKE-Network/ike-issues#894):
     * every version this ledger writes outside the Defaults and templates module carries
     * it. The time is the platform's named inception instant,
     * {@link PrimitiveData#INCEPTION_EPOCH} — a sentinel that renders as the word
     * "Inception" on every surface, timezone-proof — per KEC's ruling (2026-07-18): the
     * set has not been released, so all of it is still at inception. Declaring the pair
     * here, once, is what makes "one set of inception stamps" compiler-visible; a third
     * IKE stamp cannot appear without editing this class, and the fidelity stamp-pair
     * gate would refuse it. The path dimension is the Primordial path — the root
     * all other paths fork from, where releases of this knowledge land, beginning
     * with the inception release; after 1.0, editing moves to the Development path
     * and never returns here at inception (IKE-Network/ike-issues#910).
     */
    public static final ActiveStamp INCEPTION = Stamp.active(PrimitiveData.INCEPTION_EPOCH,
            IKE_COMMUNITY, MODULE, IkeTerm.PRIMORDIAL_PATH);

    /**
     * The inception stamp's Defaults-and-templates-module counterpart, at the same
     * declared time: the module dimension alone separates support content (the Data Type
     * Defaults tuple, the worked Preferred Reviewer default) from the foundation
     * terminology — see the live-and-die invariant on
     * {@link DefaultsTemplateTerm#DEFAULTS_AND_TEMPLATES_MODULE}.
     */
    public static final ActiveStamp DEFAULTS_INCEPTION = Stamp.active(PrimitiveData.INCEPTION_EPOCH,
            IKE_COMMUNITY, DefaultsTemplateTerm.DEFAULTS_AND_TEMPLATES_MODULE,
            IkeTerm.PRIMORDIAL_PATH);
}
