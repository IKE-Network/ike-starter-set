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
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.EntityProxy;

import java.util.UUID;

/**
 * The defaults-and-templates apparatus (IKE-Network/ike-issues#885): defaults and
 * templates are ordinary working-path content — complete semantics of the target
 * pattern — kept out of domain reads by two structural dimensions of the model itself,
 * not by any defaults-specific machinery. The <b>referenced component names the
 * category</b>: a default value semantic of a pattern attaches to {@code Default value
 * concept}; a template semantic of a pattern for a given purpose attaches to that
 * purpose's own child of {@code Template concept}. The <b>module is the category
 * boundary and the import/export packaging</b>: every version of a defaults or template
 * chronology lives in the {@code Defaults and templates module}, and that module holds
 * only such content — the bidirectional live-and-die invariant
 * {@code FoundationFidelityIT} enforces. Consumers scope affirmatively (member set
 * crossed with pattern); the attachment concepts never join domain member sets, so a
 * support declaration can never read as a domain assertion.
 * <p>
 * <b>Identity is computed, never queried</b>: a default value semantic's PublicId is
 * the stock {@link UuidT5Generator#singleSemanticUuid(dev.ikm.tinkar.common.id.PublicId,
 * dev.ikm.tinkar.common.id.PublicId) singleSemanticUuid(patternPublicId,
 * attachmentConceptPublicId)} — a consumer resolves "the default for this pattern" by
 * computing the UUID, and the derivation doubles as the uniqueness key: a second default
 * chronology for the same (pattern, attachment concept) pair cannot be minted without an
 * identity collision. Per-user preferences are per-path versions of this same
 * computed-identity chronology; migration between sandboxes is an identity-keyed
 * copy-forward.
 * <p>
 * Module boundary within this file: the three apparatus concepts minted here — the two
 * attachment points and the module concept itself — are foundation terminology
 * <em>about</em> defaults and templates, not defaults themselves, so they stamp in the
 * foundation module ({@link Ike#MODULE}); only instance content (the worked-example
 * default value semantic) stamps in the new module.
 * <p>
 * Deliberately out of scope here: StampCalculator accessors and the version-iteration
 * exclusion ({@code getDefault}/{@code getTemplate} — tinkar-core,
 * IKE-Network/ike-issues#886), and the seeded GB-dialect semantic's disposition
 * (IKE-Network/ike-issues#887). The sixteen-type exemplar this apparatus was designed
 * for lives in {@link DataTypeDefaultsSet}, composed immediately after this file.
 */
final class DefaultsAndTemplatesSet {

    private DefaultsAndTemplatesSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        // Later than every other authoring pass in this project (2026-07-12/-13/-15/
        // -16/-17/-18/-19): a fresh apparatus composed after every revision pass, so
        // the session keeps reading time-major and no earlier scope on a shared
        // component can follow one of these stamps.
        ActiveStamp apparatus = Stamp.active("2026-07-20T00:00:00Z",
                Ike.IKE_COMMUNITY, Ike.MODULE, IkeTerm.DEVELOPMENT_PATH);

        // ── Apparatus concepts (foundation module) ──────────────────────
        set.concept("Default value concept (IkeFoundation)").at(apparatus)
                .synonym("Default value concept")
                .definition("The attachment point for default values: a default value"
                        + " semantic of a pattern is a complete semantic of that pattern"
                        + " whose referenced component is this concept and whose fields"
                        + " carry the default values an editor offers for that pattern's"
                        + " fields. Attachment here is a support declaration only — never"
                        + " a domain assertion about this concept or any other component"
                        + " — and this concept never joins a domain member set.")
                .isA(IkeTerm.MODEL_CONCEPT);

        set.concept("Template concept (IkeFoundation)").at(apparatus)
                .synonym("Template concept")
                .definition("Parent of the per-purpose template attachment concepts:"
                        + " each child is minted for one template purpose, and a template"
                        + " semantic of a pattern for that purpose is a complete semantic"
                        + " of that pattern whose referenced component is that child —"
                        + " starting content offered when authoring new components. As"
                        + " with a default value semantic, attachment there is a support"
                        + " declaration, never a domain assertion, and no child joins a"
                        + " domain member set.")
                .isA(IkeTerm.MODEL_CONCEPT);

        // FQN and the "Defaults" preferred regular name are KEC-decided
        // (IKE-Network/ike-issues#885). Parentage mirrors ConceptSet's declaration of
        // "IkeFoundation module (IkeFoundation)": directly under Module (SOLOR).
        set.concept("Defaults and templates module (IkeFoundation)").at(apparatus)
                .synonym("Defaults")
                .definition("The module scoping every default value and template"
                        + " semantic. The boundary is bidirectional and live-and-die:"
                        + " every version of a defaults or template chronology lives in"
                        + " this module, and this module holds only defaults and template"
                        + " content — a violation in either direction is an error to be"
                        + " withdrawn, never adopted as precedent. As the export"
                        + " dimension, module crossed with path selects a user's"
                        + " preferences for exchange: include this module to carry"
                        + " defaults and templates alongside domain content, exclude it"
                        + " to leave them behind.")
                .isA(IkeTerm.MODULE);

        // ── Worked example: one default value semantic (new module) ─────
        // Instance content stamps in the new module — the module IS the category
        // boundary. Same author/path as the apparatus stamp; the later time keeps this
        // ledger's two scopes on Default value concept chronological (apparatus first,
        // content second).
        ActiveStamp defaults = Stamp.active("2026-07-20T12:00:00Z", Ike.IKE_COMMUNITY,
                set.conceptRef("Defaults and templates module (IkeFoundation)"),
                IkeTerm.DEVELOPMENT_PATH);

        EntityProxy.Pattern preferredReviewerPattern =
                set.patternRef("Preferred Reviewer Pattern (IkeFoundation)");
        EntityProxy.Concept defaultValueConcept =
                set.conceptRef("Default value concept (IkeFoundation)");
        UUID defaultIdentity = UuidT5Generator.singleSemanticUuid(
                preferredReviewerPattern.publicId(), defaultValueConcept.publicId());

        // Preferred Reviewer Pattern's single field (Preferred reviewer, a component
        // field) is value-set constrained to the Starter Set Author Roster Pattern
        // (ConstraintPatternSet); Gretel is that roster's first entry — a real,
        // constraint-satisfying default value, not a placeholder.
        set.concept("Default value concept (IkeFoundation)").at(defaults)
                .semantic(preferredReviewerPattern, PublicIds.of(defaultIdentity),
                        set.conceptRef("Gretel (User)"));
    }
}
