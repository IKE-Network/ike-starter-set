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
import dev.ikm.tinkar.terms.KernelPattern;

import java.time.Instant;

/**
 * Declares how a knowledge base registers what it is made of (IKE-Network/ike-issues#1304): the
 * releases imported into it, the assemblies that composed it, and the exports taken from it.
 *
 * <p><b>Who and where.</b> Every registration is written by the {@code IKE Registrar}, in the
 * {@code IKE Registry module}, on the {@code IKE Registry path}, whatever tool writes it, so the
 * accounting is in one place. Registrations are bookkeeping about the knowledge base, not knowledge:
 * content views leave them out, and a registration carried in an export keeps its stamp wherever it
 * is loaded.
 *
 * <p><b>Release registration.</b> Each source import writes one, identified by the importer's name,
 * the options that change what it writes, and the release's SHA-256, so importing the same release
 * the same way again writes nothing new. It is stamped at the publisher's release date.
 *
 * <p><b>Assembly registration.</b> Each assembly writes one, identified by the ordered checksums of
 * its inputs, stamped when it ran: rebuilding from the same inputs is a new version, different inputs
 * a new registration.
 *
 * <p><b>Export registration.</b> Each export writes one, identified by the checksum of what it
 * wrote, stamped when it ran.
 *
 * <p><b>Superseded.</b> The {@code Source release pattern} and {@code Knowledge base composition
 * pattern} this set declared first were carried by checkpoints, so their names are frozen; nothing
 * writes them any more.
 *
 * <p><b>The fully qualified names are frozen</b> once a checkpoint carries them: tinkar-core's
 * registry names the Registrar, the module, the path and the patterns through the kernel bindings,
 * and writes the fields in the order declared here.
 */
final class SourceReleaseModelSet {

    private static final EntityProxy.Concept IKE_BASE_MODEL_CONCEPT =
            EntityProxy.Concept.make("IKE base model concept", PublicIds.of("bc59d656-83d3-47d8-9507-0e656ea95463"));

    /** The source release pattern's birth name; its identity derives from it. */
    static final String SOURCE_RELEASE_PATTERN = "Source release pattern (IkeFoundation)";

    /** The composition pattern's birth name; its identity derives from it. */
    static final String COMPOSITION_PATTERN = "Knowledge base composition pattern (IkeFoundation)";

    /** The release registration pattern's birth name; its identity derives from it. */
    static final String RELEASE_REGISTRATION_PATTERN = "Release registration pattern (IkeFoundation)";

    /** The assembly registration pattern's birth name; its identity derives from it. */
    static final String ASSEMBLY_REGISTRATION_PATTERN = "Assembly registration pattern (IkeFoundation)";

    /** The export registration pattern's birth name; its identity derives from it. */
    static final String EXPORT_REGISTRATION_PATTERN = "Export registration pattern (IkeFoundation)";

    /** The Registrar's birth name. */
    static final String REGISTRAR = "IKE Registrar (IkeFoundation)";

    /** The Registry module's birth name. */
    static final String REGISTRY_MODULE = "IKE Registry module (IkeFoundation)";

    /** The Registry path's birth name. */
    static final String REGISTRY_PATH = "IKE Registry path (IkeFoundation)";

    private static final EntityProxy.Concept MODULE_SOLOR =
            EntityProxy.Concept.make("Module (SOLOR)", PublicIds.of("40d1c869-b509-32f8-b735-836eac577a67"));

    private static final EntityProxy.Concept PATH_SOLOR =
            EntityProxy.Concept.make("Path (SOLOR)", PublicIds.of("4459d8cf-5a6f-3952-9458-6d64324b27b7"));

    /** The origin time every path in the set takes: the whole of its origin path. */
    private static final Instant ORIGIN_LATEST = Instant.parse("+1000000000-12-31T23:59:59.999999999Z");

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
                "The date the publisher gave the release, as its importer reports it.");
        concept(set, inception, "Release artifact", "Knowledge base provenance model",
                "The artifact the release was imported from, as it was named: its Maven coordinate"
                        + " when it was resolved from a repository, otherwise its file name.");
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
                "The assembly's inputs in load order, one per line: the input's role, its artifact as"
                        + " named, its resolved version when it has one, and its SHA-256 checksum.");
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
                .definition("Superseded by the release registration pattern"
                        + " (IKE-Network/ike-issues#1304); nothing writes it.");

        set.pattern(COMPOSITION_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Knowledge base composition")))
                .purpose(provenance)
                .field(set.conceptRef(fqn("Assembly inputs")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Source releases")), provenance, KernelConcept.COMPONENT_ID_LIST_FIELD)
                .field(set.conceptRef(fqn("Assembly classifier")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Assembled")), provenance, KernelConcept.INSTANT_LITERAL)
                .synonym("Knowledge base composition pattern")
                .definition("Superseded by the assembly registration pattern"
                        + " (IKE-Network/ike-issues#1304); nothing writes it.");

        composeRegistry(set, inception, provenance);
    }

    /**
     * The Registrar, the Registry module and path, and the three registration patterns.
     */
    private static void composeRegistry(KnowledgeSet set, ActiveStamp inception, ConceptFacade provenance) {
        String model = "Knowledge base provenance model";

        // ── Who and where ────────────────────────────────────────────────────
        set.concept(REGISTRAR).at(inception)
                .synonym("IKE Registrar")
                .definition("The author of every registration: the IKE tooling that records what a"
                        + " knowledge base is made of whenever it imports, assembles or exports,"
                        + " in Komet, in a Maven goal, or anywhere else.")
                .isA(KernelConcept.USER);
        set.concept(REGISTRY_MODULE).at(inception)
                .synonym("IKE Registry module")
                .definition("The module registrations are written in: bookkeeping about what the"
                        + " knowledge base is made of, not knowledge. Content views leave it out.")
                .isA(MODULE_SOLOR, set.conceptRef(fqn(model)));
        set.concept(REGISTRY_PATH).at(inception)
                .synonym("IKE Registry path")
                .definition("The path every registration is written on, whatever path the content"
                        + " it describes is on, so the accounting of a knowledge base is in one place."
                        + " Nothing is promoted to or from it.")
                .isA(PATH_SOLOR)
                .semantic(KernelPattern.PATHS_PATTERN, PublicIds.of(set.uuidFor("IKE Registry path: path")))
                .semantic(KernelPattern.PATH_ORIGINS_PATTERN, PublicIds.of(set.uuidFor("IKE Registry path: origin")),
                        KernelConcept.PRIMORDIAL_PATH, ORIGIN_LATEST);

        // ── Registration fields ──────────────────────────────────────────────
        concept(set, inception, "Release registration", model,
                "The record of one release imported into a knowledge base: what was read, how it was"
                        + " read, and what the import wrote. Identified by the importer, the options that"
                        + " change what it writes, and the release's checksum, so importing the same"
                        + " release the same way again writes nothing new.");
        concept(set, inception, "Resolved version", model,
                "The version the artifact resolved to when it was named by a Maven coordinate: for a"
                        + " snapshot, its timestamped version. Empty for an artifact named by file.");
        concept(set, inception, "Importer options", model,
                "The importer's options that change what it writes, one name=value per line in name"
                        + " order; part of the registration's identity.");
        concept(set, inception, "Stamps written", model,
                "The stamps the import wrote versions under, whether they were new to the knowledge"
                        + " base or not. The components, modules and paths it wrote follow from them.");
        concept(set, inception, "Components written", model,
                "How many components the import created for the first time.");
        concept(set, inception, "Components versioned", model,
                "How many components the import gave a new version.");
        concept(set, inception, "Components unchanged", model,
                "How many components the import found the same and left untouched: what no stamp"
                        + " shows it looked at.");
        concept(set, inception, "Semantics retired", model,
                "How many semantics the import retired.");
        concept(set, inception, "Assembly registration", model,
                "The record of one assembly of a knowledge base: its inputs in load order, the release"
                        + " registrations in the order they arrived, and the classifier, stamped when it"
                        + " ran. Identified by the ordered checksums of its inputs.");
        concept(set, inception, "Release registrations", model,
                "The release registrations the knowledge base holds, in the order they arrived.");
        concept(set, inception, "Export registration", model,
                "The record of one export from a knowledge base: the file written, what it selected,"
                        + " and the checksum of what it wrote, stamped when it ran. Identified by that"
                        + " checksum.");
        concept(set, inception, "Export file", model,
                "The name of the file the export wrote.");
        concept(set, inception, "Export selection", model,
                "What the export selected: its time window, modules, or other filter, as text.");
        concept(set, inception, "Output checksum", model,
                "The SHA-256 of what the export wrote, written sha256:<hex>.");
        concept(set, inception, "Components exported", model,
                "How many components the export wrote.");

        // ── Registration patterns ────────────────────────────────────────────
        set.pattern(RELEASE_REGISTRATION_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Release registration")))
                .purpose(provenance)
                .field(set.conceptRef(fqn("Release name")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Release date")), provenance, KernelConcept.INSTANT_LITERAL)
                .field(set.conceptRef(fqn("Release artifact")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Resolved version")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Origin checksum")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Importer")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Importer options")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Stamps written")), provenance, KernelConcept.COMPONENT_ID_SET_FIELD)
                .field(set.conceptRef(fqn("Components written")), provenance, KernelConcept.LONG)
                .field(set.conceptRef(fqn("Components versioned")), provenance, KernelConcept.LONG)
                .field(set.conceptRef(fqn("Components unchanged")), provenance, KernelConcept.LONG)
                .field(set.conceptRef(fqn("Semantics retired")), provenance, KernelConcept.LONG)
                .field(set.conceptRef(fqn("Base releases")), provenance, KernelConcept.COMPONENT_ID_SET_FIELD)
                .synonym("Release registration pattern")
                .definition("A release imported into the knowledge base, referencing this pattern:"
                        + " the release's name and publisher date, the artifact as named, its resolved"
                        + " version and checksum, the importer and the options that change what it"
                        + " writes, the stamps it wrote under, its counts, and the release"
                        + " registrations it was layered on. Written by the IKE Registrar in the"
                        + " Registry module on the Registry path, stamped at the release date.");

        set.pattern(ASSEMBLY_REGISTRATION_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Assembly registration")))
                .purpose(provenance)
                .field(set.conceptRef(fqn("Assembly inputs")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Release registrations")), provenance, KernelConcept.COMPONENT_ID_LIST_FIELD)
                .field(set.conceptRef(fqn("Assembly classifier")), provenance, KernelConcept.STRING)
                .synonym("Assembly registration pattern")
                .definition("An assembly of the knowledge base, referencing this pattern: its inputs in"
                        + " load order, each with its role, artifact as named, resolved version and"
                        + " checksum; the release registrations in the order they arrived; and the"
                        + " classifier. Written by the IKE Registrar in the Registry module on the"
                        + " Registry path, stamped when the assembly ran.");

        set.pattern(EXPORT_REGISTRATION_PATTERN).at(inception)
                .meaning(set.conceptRef(fqn("Export registration")))
                .purpose(provenance)
                .field(set.conceptRef(fqn("Export file")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Export selection")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Output checksum")), provenance, KernelConcept.STRING)
                .field(set.conceptRef(fqn("Components exported")), provenance, KernelConcept.LONG)
                .synonym("Export registration pattern")
                .definition("An export from the knowledge base, referencing this pattern: the file"
                        + " written, what it selected, the checksum of what it wrote, and how many"
                        + " components it wrote. Written by the IKE Registrar in the Registry module on"
                        + " the Registry path, stamped when the export ran.");
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
