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
 * Declares how a knowledge base records what it is made of (IKE-Network/ike-issues#1304): the
 * source releases imported into it, and the assembly that composed them.
 *
 * <p><b>Source release.</b> Each source import writes one {@code Source release pattern} semantic,
 * referencing a module the import wrote, under a stamp of the source's own, so it travels inside
 * the source's delta into every assembly that loads it. There is one per importer: a later
 * release is a new version of the same semantic, and the stamp history says which release was
 * loaded.
 *
 * <p><b>Composition.</b> An assembly writes one {@code Knowledge base composition pattern}
 * semantic, referencing the pattern itself, before it exports: its inputs, the source releases the
 * store holds in the order they arrived, and the classifier. Each assembly is a new version of it.
 *
 * <p><b>The fully qualified names are frozen.</b> The knowledge provider ({@code
 * KnowledgeBaseComposition}) names both patterns by their derived identities,
 * {@code T5(d890e06f…, "<name> (IkeFoundation)")}, and writes their fields in the order declared
 * here; renaming a pattern or reordering its fields breaks every knowledge base already built.
 */
final class SourceReleaseModelSet {

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    /** The source release pattern's birth name; its identity derives from it. */
    static final String SOURCE_RELEASE_PATTERN = "Source release pattern (IkeFoundation)";

    /** The composition pattern's birth name; its identity derives from it. */
    static final String COMPOSITION_PATTERN = "Knowledge base composition pattern (IkeFoundation)";

    private SourceReleaseModelSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        set.concept(fqn("Knowledge base provenance model")).at(inception)
                .synonym("Knowledge base provenance model")
                .definition("The apparatus a knowledge base uses to record what it is made of: the"
                        + " source releases imported into it and the assembly that composed them.")
                .isA(IKE_BASE_MODEL_CONCEPT);
        concept(set, inception, "Knowledge base provenance", "Knowledge base provenance model",
                "Recording what a knowledge base is made of, inside the knowledge base, so a store can"
                        + " say which releases it holds and how it was assembled: the purpose of the"
                        + " source release and composition patterns and their fields.");

        // ── Source release ───────────────────────────────────────────────────
        concept(set, inception, "Source release", "Knowledge base provenance model",
                "One release of a knowledge source as imported into a knowledge base: its name and"
                        + " date, the artifact it came from, the importer, and what the import wrote."
                        + " Recorded once per importer under a stamp of the source's own, so the record"
                        + " travels with the source's content; a later release is a new version of the"
                        + " same record.");
        concept(set, inception, "Release name", "Knowledge base provenance model",
                "The source's own name for the release, as its importer reports it: an edition, a"
                        + " version, a release date.");
        concept(set, inception, "Release date", "Knowledge base provenance model",
                "When the release took effect in the knowledge base: the latest time among the stamps"
                        + " its import wrote.");
        concept(set, inception, "Release artifact", "Knowledge base provenance model",
                "The artifact the release was imported from: its Maven coordinate when it was resolved"
                        + " from a repository, otherwise its file name.");
        concept(set, inception, "Origin checksum", "Knowledge base provenance model",
                "The SHA-256 of the artifact as imported, written sha256:<hex>; for a directory, of its"
                        + " files in path order, each relative path followed by its content.");
        concept(set, inception, "Importer", "Knowledge base provenance model",
                "The importer that read the release, with its version: the implementation version of"
                        + " its jar, otherwise the jar's file name.");
        concept(set, inception, "Modules written", "Knowledge base provenance model",
                "The modules of the stamps the import wrote.");
        concept(set, inception, "Base releases", "Knowledge base provenance model",
                "The source release records the knowledge base already held when this release was"
                        + " imported: the releases it was layered on.");

        // ── Composition ──────────────────────────────────────────────────────
        concept(set, inception, "Knowledge base composition", "Knowledge base provenance model",
                "How a knowledge base was assembled: its inputs in load order with their checksums,"
                        + " the source releases it holds in the order they arrived, and the classifier"
                        + " that reasoned over them. Each assembly writes a new version.");
        concept(set, inception, "Assembly inputs", "Knowledge base provenance model",
                "The assembly's inputs in load order, one per line: the input's role, its artifact,"
                        + " and its SHA-256 checksum.");
        concept(set, inception, "Source releases", "Knowledge base provenance model",
                "The source release records the knowledge base holds, in the order they arrived.");
        // Not "Classifier": that is the regular name of Classifier for logic coordinate.
        concept(set, inception, "Assembly classifier", "Knowledge base provenance model",
                "The classifier that reasoned over the assembled content, by name; empty when the"
                        + " assembly did not classify.");
        concept(set, inception, "Assembled", "Knowledge base provenance model",
                "When the assembly ran.");

        // ── Patterns ─────────────────────────────────────────────────────────
        ConceptFacade provenance = set.conceptRef(fqn("Knowledge base provenance"));
        set.pattern(SOURCE_RELEASE_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Source release")))
                .purpose(provenance)
                .field(set.conceptRef(fqn("Release name")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Release date")), provenance, KernelConcept.INSTANT_LITERAL)
                .field(set.conceptRef(fqn("Release artifact")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Origin checksum")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Importer")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Modules written")), provenance, KernelConcept.COMPONENT_ID_SET_FIELD)
                .field(set.conceptRef(fqn("Base releases")), provenance, KernelConcept.COMPONENT_ID_SET_FIELD)
                .synonym("Source release pattern")
                .definition("A source release imported into the knowledge base, referencing a module"
                        + " the import wrote: the release's name and date, the artifact and its"
                        + " checksum, the importer, the modules written, and the source releases it"
                        + " was layered on. Written under the source's own stamp, one per importer.");

        set.pattern(COMPOSITION_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Knowledge base composition")))
                .purpose(provenance)
                .field(set.conceptRef(fqn("Assembly inputs")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Source releases")), provenance, KernelConcept.COMPONENT_ID_LIST_FIELD)
                .field(set.conceptRef(fqn("Assembly classifier")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Assembled")), provenance, KernelConcept.INSTANT_LITERAL)
                .synonym("Knowledge base composition pattern")
                .definition("How the knowledge base was assembled, referencing this pattern: the"
                        + " inputs with their checksums, the source releases in the order they"
                        + " arrived, the classifier, and when it ran. One record per knowledge base;"
                        + " each assembly is a new version.");
    }

    private static String fqn(String name) {
        return name + " (IkeFoundation)";
    }

    private static void concept(KnowledgeSet set, ActiveStamp stamp, String name, String parent, String definition) {
        set.concept(fqn(name)).at(stamp)
                .synonym(name)
                .definition(definition)
                .isA(set.conceptRef(fqn(parent)));
    }
}
