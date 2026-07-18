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

import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.KnowledgeSetSource;
import network.ike.foundation.ike.terms.foundation.FoundationSet;

/**
 * The IkeFoundation ledger's composition entry: build tooling discovers this source,
 * composes the sections, and replays the session.
 */
public final class IkeSource implements KnowledgeSetSource {

    /** Creates the source (ServiceLoader requirement). */
    public IkeSource() {
    }

    @Override
    public KnowledgeSet compose() {
        ConceptSet.compose(Ike.SET);
        FoundationSet.compose(Ike.SET);
        // ConstraintPatternSet mints Concept Field Constraint Pattern, which
        // NarrativeContentSet's Semantic Field Model chapter writes about — the pattern
        // must exist before its own narrative resumes it (ledger scopes are chronological
        // across the whole session, not independently per source file).
        ConstraintPatternSet.compose(Ike.SET);
        NarrativeContentSet.compose(Ike.SET);
        // PatternShapeRefinementSet revises already-adopted patterns' own meaning/purpose
        // (a new PatternVersion layered on top) -- it must run last, after every other
        // scope that touches the patterns it revises.
        PatternShapeRefinementSet.compose(Ike.SET);
        // AssemblageTerminologySet retires "assemblage" from this set's own vocabulary --
        // it must run last, after every other scope that touches the concepts/patterns
        // it revises.
        AssemblageTerminologySet.compose(Ike.SET);
        // LegacyTerminologySet reparents dormant/superseded content under a new Legacy
        // branch -- it must run last of all, after every other scope that touches the
        // concepts it reparents.
        LegacyTerminologySet.compose(Ike.SET);
        // DataTypeTerminologySet drops misleading "display field" wording from the
        // confirmed real-data-type concepts -- it must run last of all, after every other
        // scope that touches the concepts it revises.
        DataTypeTerminologySet.compose(Ike.SET);
        // DefaultsAndTemplatesSet mints the defaults/templates apparatus and its module
        // (IKE-Network/ike-issues#885) -- fresh content under the latest declared stamps,
        // composed after every revision pass so the session stays time-major.
        DefaultsAndTemplatesSet.compose(Ike.SET);
        // TODO: the rest of the IKE carriers section (new (IKE)-tagged content) lands
        // separately when the wave-2 coordination concludes (IKE-Network/ike-issues#867).
        return Ike.SET;
    }
}
