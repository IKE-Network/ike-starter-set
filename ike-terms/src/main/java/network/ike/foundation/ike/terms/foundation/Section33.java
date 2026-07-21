package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Value Range" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section33 {

    private Section33() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Reference Range (SOLOR)", PublicIds.of("87ce975b-309b-47f4-a6c6-4ae6df6649a1")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("fa0eb5ff-1244-42c4-a470-7f4f194056b8"), IkeTerm.ENGLISH_LANGUAGE, "Reference Range (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2ca16f39-2999-47b7-9b68-5eef352bc2f7"), IkeTerm.ENGLISH_LANGUAGE, "Value Range", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("149f56a8-d656-4176-929a-2b71fbdc118a"), IkeTerm.ENGLISH_LANGUAGE, "The range of values specific to a component", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("8184e0ce-343b-4c85-97f3-e24ca40926f9"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "87ce975b-309b-47f4-a6c6-4ae6df6649a1")
                .statedAxioms(PublicIds.of("d3c01223-8471-52b0-888e-c53d920e0675"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.TINKAR_MODEL_CONCEPT), leb.ConceptAxiom(IkeTerm.PURPOSE))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8de1e320-f168-417b-917e-10b576d3ff51"))
                .semanticOn(PublicIds.of("fa0eb5ff-1244-42c4-a470-7f4f194056b8"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("6d679ad1-1e54-4dd4-96c8-455010a2cc55"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2ca16f39-2999-47b7-9b68-5eef352bc2f7"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f1cf8d7a-77d4-47ef-9f6d-96200aa37cf8"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("149f56a8-d656-4176-929a-2b71fbdc118a"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("a3fc25a6-2f3e-4965-89fb-c079652c7180"), IkeTerm.PREFERRED)
                ;

        set.concept("Reference Range Minimum (SOLOR)", PublicIds.of("37c35a88-9e27-42ca-b626-186773c4b612")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("e704406f-6dae-420c-8ba6-04a534108a68"), IkeTerm.ENGLISH_LANGUAGE, "Reference Range Minimum (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6ca3179e-7930-44a2-ad65-39df871acfe5"), IkeTerm.ENGLISH_LANGUAGE, "Minimum Value; Min Value", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("9144070a-f05d-430a-b74f-c520511557c2"), IkeTerm.ENGLISH_LANGUAGE, "The lower bound of a reference range: the least value the range admits, paired with an operator saying whether the bound itself is included.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("e767a63e-72e0-4320-b12f-535505585068"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "37c35a88-9e27-42ca-b626-186773c4b612")
                .statedAxioms(PublicIds.of("1934f2ef-705e-5bc5-9617-dfdafdb22f54"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.REFERENCE_RANGE), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("1c711869-4e73-4c14-be33-e67dfc264226"))
                .semanticOn(PublicIds.of("e704406f-6dae-420c-8ba6-04a534108a68"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5e3d227a-28e2-4096-b443-a10fc8449c99"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6ca3179e-7930-44a2-ad65-39df871acfe5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("acc3eab9-84ba-4543-92eb-1549c837a039"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("9144070a-f05d-430a-b74f-c520511557c2"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d078d4b2-ef07-4699-8774-fe6f6cca87e0"), IkeTerm.PREFERRED)
                ;

        set.concept("Reference Range Maximum (SOLOR)", PublicIds.of("72d58983-b1e1-4ca9-833f-0e40c1defd39")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7a00bf1e-fc1b-41f0-8801-022116d9c918"), IkeTerm.ENGLISH_LANGUAGE, "Reference Range Maximum (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("ecf44545-d958-47fc-b4fe-38c6366a1242"), IkeTerm.ENGLISH_LANGUAGE, "Maximum Value; Max Value", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8b43571f-a594-411c-a26e-49b70daa04cc"), IkeTerm.ENGLISH_LANGUAGE, "The upper bound of a reference range: the greatest value the range admits, paired with an operator saying whether the bound itself is included.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("a44124ea-4c9b-4744-975e-1b3dc720c26f"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "72d58983-b1e1-4ca9-833f-0e40c1defd39")
                .statedAxioms(PublicIds.of("22861d9d-154d-5c34-b325-5b6babe9fda6"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.REFERENCE_RANGE), leb.ConceptAxiom(IkeTerm.MEANING))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("32fa2f6a-5c73-408c-83cb-eaf5fe47c868"))
                .semanticOn(PublicIds.of("7a00bf1e-fc1b-41f0-8801-022116d9c918"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c472588d-86ea-4311-9482-d2a62ac72c44"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("ecf44545-d958-47fc-b4fe-38c6366a1242"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("1a8f1f4a-a8fd-4eaf-8bac-fcc7f4201b28"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("8b43571f-a594-411c-a26e-49b70daa04cc"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("d56e0831-98c9-4eb4-9067-d425456dada1"), IkeTerm.PREFERRED)
                ;

    }
}
