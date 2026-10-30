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
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.ConceptFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.KernelConcept;

/**
 * Declares annotation (IKE-Network/ike-issues#1300; ike-lab-documents topics
 * {@code dev-stamp-annotation} and {@code dev-annotation-trailer}): affirmation, refutation and
 * free comment as one act — a statement beside content that changes nothing about how the
 * content is versioned — whose kind is a concept rather than a keyword.
 *
 * <p><b>The kind hierarchy.</b> {@code Annotation kind} is the root; {@code Uncategorized
 * comment} is the default, and how Comment pattern semantics read; {@code Judgment} is a stance
 * on the content, with {@code Affirmation} and {@code Refutation} beneath it; {@code Retraction}
 * withdraws an earlier annotation and is no stance. A new kind is a new concept here: no trailer
 * grammar or walker changes.
 *
 * <p><b>The fully qualified names are frozen.</b> Every concept takes the set's derived identity,
 * {@code T5(d890e06f…, "<name> (IkeFoundation)")}, and git commit messages carry the kind
 * identities as {@code k:uuid=…[label]} references that can never be rewritten. Rename a
 * synonym freely; never an FQN. {@code Affirmation} keeps the identity the git-provenance family
 * gave it before annotation existed, so references written then still resolve.
 *
 * <p><b>The Annotation pattern.</b> Its referenced component is whatever is annotated — a
 * concept, a description, any semantic, another annotation (a reply), a document, or a STAMP
 * (a whole change set). The fields name one exact version and what the annotator says of it:
 * the kind, the STAMP of the version the annotator saw, the elements within the referenced
 * component the annotation covers (a document's lines; empty for the whole component), and the
 * text. The annotation's own STAMP records who and when.
 */
final class AnnotationModelSet {

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));
    private static final EntityProxy.Concept MODULE_SOLOR =
            EntityProxy.Concept.make("Module (SOLOR)", PublicIds.of("40d1c869-b509-32f8-b735-836eac577a67"));
    private static final EntityProxy.Concept COMMENT_SOLOR =
            EntityProxy.Concept.make("Comment (SOLOR)", PublicIds.of("147832d4-b9b8-5062-8891-19f9c4e4760a"));

    private AnnotationModelSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        set.concept(fqn("Annotation model")).at(inception)
                .synonym("Annotation model")
                .definition("The apparatus that records what a person says about content without"
                        + " touching it: the annotation, its kinds, the pattern that carries it, and"
                        + " the module annotations are written to.")
                .isA(IKE_BASE_MODEL_CONCEPT);
        concept(set, inception, "Annotation", "Annotation model",
                "A statement about one version of a component — an affirmation, a refutation, or a"
                        + " comment — recorded beside it, so the content keeps its own authorship"
                        + " and the annotator's stance carries theirs.");

        // ── The kinds ────────────────────────────────────────────────────────
        concept(set, inception, "Annotation kind", "Annotation model",
                "What an annotation says about the content it references. The kinds form a"
                        + " controlled hierarchy; a new kind is a new concept, never a new keyword.");
        concept(set, inception, "Uncategorized comment", "Annotation kind",
                "Free commentary with no stance on the content: the default kind, and how a"
                        + " Comment pattern semantic reads.");
        concept(set, inception, "Judgment", "Annotation kind",
                "A stance on the referenced version. A later judgment by the same annotator on the"
                        + " same content supersedes an earlier one.");
        concept(set, inception, "Affirmation", "Judgment",
                "The annotator has reviewed the version and stands behind it. An affirmation is the"
                        + " person's own act; nothing records one on their behalf. In git it is an"
                        + " Annotation: trailer on an empty commit, preferably signed.");
        concept(set, inception, "Refutation", "Judgment",
                "The annotator has reviewed the version and disputes it, with the reason as the"
                        + " annotation text. A refutation is an opinion, not a retirement: inactivating"
                        + " the content is a separate edit by whoever is accountable for it.");
        concept(set, inception, "Retraction", "Annotation kind",
                "The annotator withdraws an earlier annotation of theirs: in git, an Annotation: trailer"
                        + " naming the annotation commit, which takes every annotation that commit recorded"
                        + " out of force, with the reason as the text. Not a judgment: it takes back nothing"
                        + " but its target, so a stance the target had superseded does not come back, and"
                        + " later annotations stand. In the graph the retracted annotation gets an inactive"
                        + " version under the retraction's STAMP.");

        // ── The pattern's purpose and fields ─────────────────────────────────
        concept(set, inception, "Reviewed provenance", "Annotation model",
                "Recording who reviewed which version of what, and their stance: the purpose of the"
                        + " Annotation pattern and its fields.");
        concept(set, inception, "Reviewed version", "Annotation model",
                "The STAMP of the version the annotator saw; with the referenced component it names"
                        + " one exact, immutable version. When the referenced component is itself a"
                        + " STAMP, that STAMP. An annotation whose reviewed version is no longer the"
                        + " latest is about a superseded version.");
        concept(set, inception, "Annotated elements", "Annotation model",
                "The elements within the referenced component an annotation covers, in order —"
                        + " a document's lines — or none, for the whole component.");
        set.concept(fqn("Review module")).at(inception)
                .synonym("Review module")
                .definition("The module annotations made in a knowledge base are written to, so a"
                        + " module coordinate decides whether review metadata travels with a release."
                        + " Annotations materialized from git stamp under the repository's own module.")
                .isA(MODULE_SOLOR, set.conceptRef(fqn("Annotation model")));

        ConceptFacade purpose = set.conceptRef(fqn("Reviewed provenance"));
        set.pattern(fqn("Annotation pattern")).at(inception)
                .meaning(set.conceptRef(fqn("Annotation")))
                .purpose(purpose)
                .field(set.conceptRef(fqn("Annotation kind")), purpose, KernelConcept.CONCEPT_FIELD)
                .field(set.conceptRef(fqn("Reviewed version")), purpose, KernelConcept.COMPONENT_FIELD)
                .field(set.conceptRef(fqn("Annotated elements")), purpose, KernelConcept.COMPONENT_ID_LIST_FIELD)
                .field(COMMENT_SOLOR, purpose, KernelConcept.STRING)
                .synonym("Annotation pattern")
                .definition("An annotation of the referenced component: its kind, the reviewed"
                        + " version's STAMP, the elements it covers (empty for the whole component),"
                        + " and its text (empty when there is none).");
    }

    static String fqn(String name) {
        return name + " (IkeFoundation)";
    }

    private static void concept(KnowledgeSet set, ActiveStamp stamp, String name, String parent, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(fqn(parent)));
    }
}
