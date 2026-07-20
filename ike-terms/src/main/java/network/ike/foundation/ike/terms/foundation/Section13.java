package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Language coordinate properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section13 {

    private Section13() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Language coordinate properties (SOLOR)", PublicIds.of("ea1a52f7-0305-5487-8766-e846330f167a")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("0a5fc215-4e5e-4201-a7a5-99cddd60a08d"), IkeTerm.ENGLISH_LANGUAGE, "Language coordinate properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("729cb02a-24fe-419d-994f-0b1f5f7c50da"), IkeTerm.ENGLISH_LANGUAGE, "Language coordinate properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("92c2cfd0-a05e-4c05-9be5-119334d94dc9"), IkeTerm.ENGLISH_LANGUAGE, "Spatial representation of language, attributes or language coordinates, programming language metadata?", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("302223eb-ef3f-4808-a8f6-d586496e639e"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ea1a52f7-0305-5487-8766-e846330f167a")
                .statedAxioms(PublicIds.of("c3261397-10af-5f97-8725-85911b6fbc81"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("46c1bcec-0e5a-445a-b0d8-1dd6bb608325"))
                .semanticOn(PublicIds.of("0a5fc215-4e5e-4201-a7a5-99cddd60a08d"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d815a323-bf5c-4a26-bc24-eba50bb0ccad"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("729cb02a-24fe-419d-994f-0b1f5f7c50da"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("46293787-505a-4a94-96f6-45e0e7ab0589"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("92c2cfd0-a05e-4c05-9be5-119334d94dc9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f6e6a543-736e-4c84-9cb4-3a55791a31c1"), IkeTerm.PREFERRED)
                ;

        set.concept("Language coordinate name (SOLOR)", PublicIds.of("42dff20f-5ed2-559a-91ad-91d44a573c63")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a024b465-af14-4908-93d3-d2bc71ea18bd"), IkeTerm.ENGLISH_LANGUAGE, "Language coordinate name (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b056834e-79af-4aec-bc01-0401feb12f94"), IkeTerm.ENGLISH_LANGUAGE, "Language coordinate name", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2c8958d4-6d4d-49b8-a542-28a3943c3455"), IkeTerm.ENGLISH_LANGUAGE, "Language coordinate name", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("214d74a7-b80b-4616-9c06-9cd40ed7d831"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "42dff20f-5ed2-559a-91ad-91d44a573c63")
                .statedAxioms(PublicIds.of("cca164f4-4786-5f44-a18f-3e64c45b4113"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE_COORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("e4ad43c1-bc12-4cdc-a110-76dc25f1f3ed"))
                .semanticOn(PublicIds.of("a024b465-af14-4908-93d3-d2bc71ea18bd"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("58323e28-74c3-462a-9a4f-1ef975bf6d23"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("b056834e-79af-4aec-bc01-0401feb12f94"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("0cb5ebe1-ab7c-4bf7-924a-fcdd308c2e24"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2c8958d4-6d4d-49b8-a542-28a3943c3455"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3b5e97a4-dea0-4427-a875-4b2eb09ac5ea"), IkeTerm.PREFERRED)
                ;

        // Declared FQN and definition diverge from the baseline artifact (was "Dialect assemblage preference list for language coordinate (SOLOR)"):
        // "assemblage" retired from this set's own terminology, flattened in place
        // (IKE-Network/ike-issues#880, #894; registered in DELIBERATELY_RENAMED_FQNS).
        set.concept("Dialect pattern preference list for language coordinate", PublicIds.of("c060ffbf-e95f-5960-b296-8a3255c820ac")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fc463462-1f62-40b2-abdb-269863ce2e64"), IkeTerm.ENGLISH_LANGUAGE, "Dialect pattern preference list for language coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6b6e13f7-9e69-4b3e-8c95-be9eb46373fd"), IkeTerm.ENGLISH_LANGUAGE, "Dialect order", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("96271b7b-9813-42b5-a119-236dffe2d399"), IkeTerm.ENGLISH_LANGUAGE, "The preference order among dialect patterns a Language Coordinate consults when resolving a description's acceptability.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("32f9eb2a-d502-41d1-8f8b-ce3ce5e7f339"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c060ffbf-e95f-5960-b296-8a3255c820ac")
                .statedAxioms(PublicIds.of("ee62a785-34d2-562c-9390-22f73b382e76"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.LANGUAGE_COORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("675577ff-1f41-4121-9016-6d281ae6cf56"))
                .semanticOn(PublicIds.of("fc463462-1f62-40b2-abdb-269863ce2e64"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b686b6c4-600b-4377-b1fe-400c95759425"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6b6e13f7-9e69-4b3e-8c95-be9eb46373fd"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e0b4d6fe-ff87-497d-91c5-600ccf59ae2d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("96271b7b-9813-42b5-a119-236dffe2d399"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("072e2199-07c0-4687-ab50-7393e6761e54"), IkeTerm.PREFERRED)
                ;

    }
}
