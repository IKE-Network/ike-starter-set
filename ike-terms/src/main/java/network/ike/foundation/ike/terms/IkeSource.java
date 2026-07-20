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
 * <p>
 * The whole pre-release set is authored at the one declared inception time,
 * the platform's named inception instant ({@code PrimitiveData.INCEPTION_EPOCH},
 * rendered as the word "Inception"), under exactly two stamps — the foundation-module
 * inception stamp and its Defaults-and-templates-module counterpart
 * (IKE-Network/ike-issues#894). No chronology carries more than one version, so
 * composition order below is constrained only by the declaration-before-reference rule
 * for declared-identity components; derived-identity references ({@code conceptRef})
 * are order-free.
 */
public final class IkeSource implements KnowledgeSetSource {

    /** Creates the source (ServiceLoader requirement). */
    public IkeSource() {
    }

    @Override
    public KnowledgeSet compose() {
        // The ingested foundation composes first: with every scope at the one inception
        // time, "earliest authored" ties resolve by composition order, and the
        // deterministically chosen live examples (KonceptExtractor) must stay the
        // baseline's own first content (Uninitialized Component), not this set's
        // bootstrap concepts.
        FoundationSet.compose(Ike.SET);
        ConceptSet.compose(Ike.SET);
        // ConstraintPatternSet mints the field constraint apparatus (the Taxonomy and
        // Value-set Field Constraint Patterns, IKE-Network/ike-issues#890); its worked
        // examples attach to declared-identity components the foundation sections open,
        // so it composes after FoundationSet.
        ConstraintPatternSet.compose(Ike.SET);
        NarrativeContentSet.compose(Ike.SET);
        // PatternShapeRefinementSet mints the meaning/purpose concepts the corrected
        // section pattern shapes reference by derived identity (IKE-Network/ike-issues#880,
        // #891, #894).
        PatternShapeRefinementSet.compose(Ike.SET);
        // AssemblageTerminologySet mints Set membership and the Solor Concepts Pattern —
        // the modern membership-pattern terminology (IKE-Network/ike-issues#880).
        AssemblageTerminologySet.compose(Ike.SET);
        // LegacyTerminologySet mints the Legacy branch the Section41 reparent targets by
        // derived identity (IKE-Network/ike-issues#880 follow-up).
        LegacyTerminologySet.compose(Ike.SET);
        // DefaultsAndTemplatesSet mints the defaults/templates apparatus and its module
        // (IKE-Network/ike-issues#885); the module concept must be declared before
        // DataTypeDefaultsSet stamps content in it.
        DefaultsAndTemplatesSet.compose(Ike.SET);
        // DataTypeDefaultsSet mints the Data Type Defaults Pattern — the apparatus's
        // first full-breadth consumer: sixteen fields, one loud default per
        // ConceptToDataType-recognized data type (IKE-Network/ike-issues#885).
        DataTypeDefaultsSet.compose(Ike.SET);
        // DefinitionCompletionSet authors the 25 first definitions of the base-model
        // chronicle/version field concepts (IKE-Network/ike-issues#892).
        DefinitionCompletionSet.compose(Ike.SET);
        // ModelOrganizationSet mints the taxonomy-organization structural concepts —
        // STAMP dimensions, the nine Model-concept subsystem organizers, the sealed
        // LogicalAxiom mirror parents, and the graph-representation concepts — that the
        // reorganized isA edits across the other sets target by derived identity
        // (IKE-Network/ike-issues#915).
        ModelOrganizationSet.compose(Ike.SET);
        // TODO: the rest of the IKE carriers section (new (IKE)-tagged content) lands
        // separately when the wave-2 coordination concludes (IKE-Network/ike-issues#867).
        return Ike.SET;
    }
}
