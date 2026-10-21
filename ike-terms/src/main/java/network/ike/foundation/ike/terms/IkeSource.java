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
import dev.ikm.tinkar.entity.builder.Stamp;
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
        // The non-existent stamp: the stamp of a component's value before the component
        // existed, which the change chronology compares a first version against. Every store
        // needs it, and no version of the set uses it, so the set declares it outright
        // instead of the application writing it into each store at startup. Its dimensions
        // (Author for version, Uninitialized component) are foundation components, composed
        // just above.
        Ike.SET.stamp(Stamp.nonExistent());
        // The set's stamps, generated beside its bindings so code that authors under them
        // names them as it names the set's components.
        Ike.SET.bindStamp(Ike.INCEPTION, Ike.STAMPS, "INCEPTION");
        Ike.SET.bindStamp(Ike.DEFAULTS_INCEPTION, Ike.STAMPS, "DEFAULTS_INCEPTION");
        Ike.SET.bindStamp(Ike.ASCIIDOC_INCEPTION, Ike.STAMPS, "ASCIIDOC_INCEPTION");
        Ike.SET.bindStamp(Stamp.nonExistent(), Ike.STAMPS, "NON_EXISTENT");
        ConceptSet.compose(Ike.SET);
        // ProseElementSet declares the shared prose-element apparatus at its foundation
        // home (IKE-Network/ike-issues#937): the pattern the narrative sections attach
        // prose semantics to, with the role concepts its declaration references —
        // adopted RichSurfaceTerms identities, declared before the first referencing
        // section (ConstraintPatternSet's worked-example narratives) so the registry
        // answers the declared identity, never a premature derivation.
        ProseElementSet.compose(Ike.SET);
        // ConstraintPatternSet mints the field constraint apparatus (the Taxonomy and
        // Value-set Field Constraint Patterns, IKE-Network/ike-issues#890); its worked
        // examples attach to declared-identity components the foundation sections open,
        // so it composes after FoundationSet.
        ConstraintPatternSet.compose(Ike.SET);
        // ExpressionLanguageSet places external expression-language constructs (CQL,
        // ECL, OWL 2 EL) relative to the EL++ core by checked relations — keyword
        // bindings, denotations, equivalence/extension assertions
        // (IKE-Network/ike-issues#1089); it types the taxonomy field constraint kinds
        // ConstraintPatternSet declares, so it composes after it.
        ExpressionLanguageSet.compose(Ike.SET);
        // ElmNodeCatalogSet, the ELM node catalog, is generated from HL7's ELM schemas by
        // ike:schema-import (IKE-Network/ike-issues#1104); it hangs its family root under
        // the model concept and refers to nothing else, so it composes after the
        // expression-language section.
        ElmNodeCatalogSet.compose(Ike.SET);
        // ElmTreeSet is authored beside the catalog (IKE-Network/ike-issues#1110): the tree,
        // ordered list, and reference patterns and the three operand roles; it refers to the
        // catalog's root and position parent, so it composes after the catalog.
        ElmTreeSet.compose(Ike.SET);
        // ElmTypeSet relates the catalog's 23 System types to the concepts of the query model
        // (IKE-Network/ike-issues#1113); it refers to both, so it composes after both.
        ElmTypeSet.compose(Ike.SET);
        // UcumModelSet holds what is ours about UCUM (IKE-Network/ike-issues#1114): the parents,
        // the patterns, and the dialect; the units themselves are imported, never authored.
        UcumModelSet.compose(Ike.SET);
        // ModelInformationSet holds what is ours about model information (IKE-Network/ike-issues#1115):
        // the Data model parent, the record patterns, the mark, and the dialects; the models are imported.
        ModelInformationSet.compose(Ike.SET);
        // ElmNodeKindSet relates each admitted ELM node kind to the construct it means, the evaluator's
        // dispatch table (IKE-Network/ike-issues#1116); it refers to the catalog, the constructs, and the
        // model information section, so it composes after all three.
        ElmNodeKindSet.compose(Ike.SET);
        NarrativeContentSet.compose(Ike.SET);
        // PatternShapeRefinementSet mints the meaning/purpose concepts the corrected
        // section pattern shapes reference by derived identity (IKE-Network/ike-issues#880,
        // #891, #894).
        PatternShapeRefinementSet.compose(Ike.SET);
        // AssemblageTerminologySet mints Set membership and the Solor Concepts Pattern —
        // the modern membership-pattern terminology (IKE-Network/ike-issues#880).
        AssemblageTerminologySet.compose(Ike.SET);
        // LegacyTerminologySet mints the Legacy branch the Section41 reparent targets by
        // derived identity (IKE-Network/ike-issues#880 follow-up; the #950 sweep adds
        // eight more occupants, each reparented at its own section declaration).
        LegacyTerminologySet.compose(Ike.SET);
        // GraphModelSet mints the graph-structure family (Graph/Tree/Directed tree/EL++
        // ditree) the repaired Section66 "Directed graph" cites by derived identity
        // (IKE-Network/ike-issues#950).
        GraphModelSet.compose(Ike.SET);
        // ClassificationModelSet declares the inferred equivalence pattern beside the
        // navigation patterns, from the foundation's own concepts.
        ClassificationModelSet.compose(Ike.SET);
        // CoordinateModelSet mints the view-coordinate-model family roots the
        // redistributed coordinate-dimension sections cite by derived identity; Part of
        // is seated as a transitive role type at foundation.Section41
        // (IKE-Network/ike-issues#950).
        CoordinateModelSet.compose(Ike.SET);
        // StampModelSet mints the STAMP whole the five dimension families
        // (Status value, Time, Author, Module, Path) reference with Part of
        // restrictions (IKE-Network/ike-issues#952).
        StampModelSet.compose(Ike.SET);
        // AnnotationModelSet mints annotation — affirmation, refutation and comment as one act,
        // the kind a concept — and the Annotation pattern that carries it for any component
        // (IKE-Network/ike-issues#1300). Affirmation keeps the identity the git-provenance family
        // gave it.
        AnnotationModelSet.compose(Ike.SET);
        // ActionModelSet mints Komet's actions as concepts: the action branch, the Action
        // definition pattern naming each action's input and result patterns and its model
        // instructions, and activate and inactivate as the first (dev-komet-actions).
        ActionModelSet.compose(Ike.SET);
        // SourceReleaseModelSet mints how a knowledge base records what it is made of: the source
        // release each import writes and the composition each assembly writes, whose patterns the
        // knowledge provider names by derived identity (IKE-Network/ike-issues#1304).
        SourceReleaseModelSet.compose(Ike.SET);
        // ChangeTrackingModelSet extends that provenance model with the record each transaction
        // that writes uncommitted versions leaves, which tinkar-core's Transaction writes through
        // the kernel bindings (IKE-Network/ike-issues#1308).
        ChangeTrackingModelSet.compose(Ike.SET);
        // LicenseModelSet mints the License family: the set is dual-licensed CC BY +
        // Apache 2.0, in every POM and as concepts (IKE-Network/ike-issues#952).
        LicenseModelSet.compose(Ike.SET);
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
        // TODO: the rest of the IKE carriers section (new (IKE)-tagged content) lands
        // separately when the wave-2 coordination concludes (IKE-Network/ike-issues#867).
        // The kernel and Komet's terms bind components declared throughout the sections above,
        // so they compose last.
        // AsciiDocModelSet declares the AsciiDoc document model — the primitives a parse of
        // an IKE AsciiDoc document produces, in their own module — and the git-provenance
        // apparatus that stamps a document materialized from a repository
        // (IKE-Network/ike-issues#468). Its lines are prose elements, so it composes after
        // ProseElementSet.
        // DocumentStructureSet declares the block model a document and a conversation journal
        // share, and the journal's own concepts (IKE-Network/ike-issues#844); the AsciiDoc-only
        // elements are its children, so it composes first.
        DocumentStructureSet.compose(Ike.SET);
        AsciiDocModelSet.compose(Ike.SET);
        // DocumentVertexSet declares a document as semantic vertices (IKE-Network/ike-issues#1313):
        // the line meanings, the vertex property keys, the vertex data type and the template
        // pattern. Its block meanings are the elements the two sets above declare, so it composes
        // after both.
        DocumentVertexSet.compose(Ike.SET);
        // DocumentSegmentSet declares the text below the line as vertices (IKE-Network/ike-issues#1313):
        // sentences, inline elements and the keys they carry. It reuses the vertex property parent
        // and the inline references declared above, so it composes after them.
        DocumentSegmentSet.compose(Ike.SET);
        // InstanceDataSet declares the module parents that decide a pattern's kind, knowledge,
        // ephemeral or instance (IKE-Network/ike-issues#1313), and the document modules under them.
        InstanceDataSet.compose(Ike.SET);
        // AnfStatementSet declares an ANF statement as one tree in an ANF statement pattern
        // (IKE-Network/ike-issues#1312); its circumstance vertices reuse the circumstance
        // kinds ElmNodeKindSet declares, so it composes after that set.
        AnfStatementSet.compose(Ike.SET);
        KernelBindings.compose(Ike.SET);
        KometBindings.compose(Ike.SET);
        return Ike.SET;
    }
}
