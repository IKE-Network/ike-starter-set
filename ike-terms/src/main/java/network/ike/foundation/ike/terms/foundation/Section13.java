package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.terms.KernelTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import java.time.Instant;
import java.util.UUID;

/** The "Language coordinate properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section13 {

    private Section13() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Language coordinate properties (SOLOR)", PublicIds.of(UUID.fromString("ea1a52f7-0305-5487-8766-e846330f167a"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("0a5fc215-4e5e-4201-a7a5-99cddd60a08d")), KernelTerm.ENGLISH_LANGUAGE, "Language coordinate properties (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("729cb02a-24fe-419d-994f-0b1f5f7c50da")), KernelTerm.ENGLISH_LANGUAGE, "Language coordinate properties", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("92c2cfd0-a05e-4c05-9be5-119334d94dc9")), KernelTerm.ENGLISH_LANGUAGE, "The dimensions of the language coordinate — how a view chooses description text: language, description-type preference order, dialect preference order, and module preference. A model concept grouping those dimensions, and part of the view coordinate model — stated logically as a Part of restriction.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("302223eb-ef3f-4808-a8f6-d586496e639e")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "ea1a52f7-0305-5487-8766-e846330f167a")
                .statedAxioms(PublicIds.of(UUID.fromString("c3261397-10af-5f97-8725-85911b6fbc81")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)")), leb.SomeRole(EntityProxy.Concept.make("Part of (SOLOR)", PublicIds.of("b4c3f6f9-6937-30fd-8412-d0c77f8a7f73")), leb.ConceptAxiom(set.conceptRef("View coordinate model (IkeFoundation)"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("46c1bcec-0e5a-445a-b0d8-1dd6bb608325")))
                .semanticOn(PublicIds.of(UUID.fromString("0a5fc215-4e5e-4201-a7a5-99cddd60a08d")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("d815a323-bf5c-4a26-bc24-eba50bb0ccad")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("729cb02a-24fe-419d-994f-0b1f5f7c50da")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("46293787-505a-4a94-96f6-45e0e7ab0589")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("92c2cfd0-a05e-4c05-9be5-119334d94dc9")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("f6e6a543-736e-4c84-9cb4-3a55791a31c1")), KernelTerm.PREFERRED)
                ;

        set.concept("Language coordinate name (SOLOR)", PublicIds.of(UUID.fromString("42dff20f-5ed2-559a-91ad-91d44a573c63"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("a024b465-af14-4908-93d3-d2bc71ea18bd")), KernelTerm.ENGLISH_LANGUAGE, "Language coordinate name (SOLOR)", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("b056834e-79af-4aec-bc01-0401feb12f94")), KernelTerm.ENGLISH_LANGUAGE, "Language coordinate name", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("2c8958d4-6d4d-49b8-a542-28a3943c3455")), KernelTerm.ENGLISH_LANGUAGE, "Language coordinate name", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("214d74a7-b80b-4616-9c06-9cd40ed7d831")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "42dff20f-5ed2-559a-91ad-91d44a573c63")
                .statedAxioms(PublicIds.of(UUID.fromString("cca164f4-4786-5f44-a18f-3e64c45b4113")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Language coordinate properties (SOLOR)", PublicIds.of("ea1a52f7-0305-5487-8766-e846330f167a"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("e4ad43c1-bc12-4cdc-a110-76dc25f1f3ed")))
                .semanticOn(PublicIds.of(UUID.fromString("a024b465-af14-4908-93d3-d2bc71ea18bd")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("58323e28-74c3-462a-9a4f-1ef975bf6d23")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("b056834e-79af-4aec-bc01-0401feb12f94")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("0cb5ebe1-ab7c-4bf7-924a-fcdd308c2e24")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("2c8958d4-6d4d-49b8-a542-28a3943c3455")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("3b5e97a4-dea0-4427-a875-4b2eb09ac5ea")), KernelTerm.PREFERRED)
                ;

        // Declared FQN and definition diverge from the baseline artifact (was "Dialect assemblage preference list for language coordinate (SOLOR)"):
        // "assemblage" retired from this set's own terminology, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Dialect pattern preference list for language coordinate", PublicIds.of(UUID.fromString("c060ffbf-e95f-5960-b296-8a3255c820ac"))).at(inception)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("fc463462-1f62-40b2-abdb-269863ce2e64")), KernelTerm.ENGLISH_LANGUAGE, "Dialect pattern preference list for language coordinate", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("6b6e13f7-9e69-4b3e-8c95-be9eb46373fd")), KernelTerm.ENGLISH_LANGUAGE, "Dialect order", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(KernelTerm.DESCRIPTION_PATTERN, PublicIds.of(UUID.fromString("96271b7b-9813-42b5-a119-236dffe2d399")), KernelTerm.ENGLISH_LANGUAGE, "The preference order among dialect patterns a Language Coordinate consults when resolving a description's acceptability.", KernelTerm.DESCRIPTION_NOT_CASE_SENSITIVE, KernelTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(KernelTerm.IDENTIFIER_PATTERN, PublicIds.of(UUID.fromString("32f9eb2a-d502-41d1-8f8b-ce3ce5e7f339")), EntityProxy.Concept.make("Universally Unique Identifier (SOLOR)", PublicIds.of("845274b5-9644-3799-94c6-e0ea37e7d1a4")), "c060ffbf-e95f-5960-b296-8a3255c820ac")
                .statedAxioms(PublicIds.of(UUID.fromString("ee62a785-34d2-562c-9390-22f73b382e76")), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(EntityProxy.Concept.make("Language coordinate properties (SOLOR)", PublicIds.of("ea1a52f7-0305-5487-8766-e846330f167a"))))))
                .semantic(KernelTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of(UUID.fromString("675577ff-1f41-4121-9016-6d281ae6cf56")))
                .semanticOn(PublicIds.of(UUID.fromString("fc463462-1f62-40b2-abdb-269863ce2e64")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("b686b6c4-600b-4377-b1fe-400c95759425")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("6b6e13f7-9e69-4b3e-8c95-be9eb46373fd")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("e0b4d6fe-ff87-497d-91c5-600ccf59ae2d")), KernelTerm.PREFERRED)
                .semanticOn(PublicIds.of(UUID.fromString("96271b7b-9813-42b5-a119-236dffe2d399")), KernelTerm.US_DIALECT_PATTERN, PublicIds.of(UUID.fromString("072e2199-07c0-4687-ab50-7393e6761e54")), KernelTerm.PREFERRED)
                ;

    }
}
