package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;

/** The "Path coordinate properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section27 {

    private Section27() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Path coordinate properties (SOLOR)", PublicIds.of("ec41e427-f009-5e45-a643-6dc658d63d83")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d3735b57-99c4-48bc-a31d-8ec8b906cd7b"), IkeTerm.ENGLISH_LANGUAGE, "Path coordinate properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("6a04739d-7b32-449b-84a9-fc152f1cbade"), IkeTerm.ENGLISH_LANGUAGE, "Path coordinate properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("df88b64c-e9a5-4dd3-b2df-eeac997e84d3"), IkeTerm.ENGLISH_LANGUAGE, "Character or attribute of coordinates referring to a series of connected points, that form a shape or trajectory", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("85a9bfe2-98fa-4c27-8e5d-ddd2d8762cd8"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "ec41e427-f009-5e45-a643-6dc658d63d83")
                .statedAxioms(PublicIds.of("ab05dab4-dcc4-54a8-8119-2742d22979d8"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.OBJECT_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("e5efe32a-81ed-4cf5-9644-8bea2b17e079"))
                .semanticOn(PublicIds.of("d3735b57-99c4-48bc-a31d-8ec8b906cd7b"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b7410d9b-2219-4f43-b5d4-3cefa5164490"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("6a04739d-7b32-449b-84a9-fc152f1cbade"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("74625458-94b9-4a0e-828b-9c3592024c6d"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("df88b64c-e9a5-4dd3-b2df-eeac997e84d3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("7bebe022-f48d-4c80-9559-b67afc3ad381"), IkeTerm.PREFERRED)
                ;

        set.concept("Path coordinate name (SOLOR)", PublicIds.of("a293a9a0-eb1e-5418-83c7-bec376b62245")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("b9be8faf-64ab-424f-9ec9-045c494c871e"), IkeTerm.ENGLISH_LANGUAGE, "Path coordinate name (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("30dffcd7-96cd-4292-9466-babed1404a75"), IkeTerm.ENGLISH_LANGUAGE, "Path coordinate name", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("bee1dc71-703e-4974-b52c-5edd942e5129"), IkeTerm.ENGLISH_LANGUAGE, "Path coordinate name", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("b4ed2349-4f48-485f-82cf-b1f097f1b7f7"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "a293a9a0-eb1e-5418-83c7-bec376b62245")
                .statedAxioms(PublicIds.of("d99992dd-5910-5904-be2d-d68266d323bd"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PATH_COORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("77bd1c53-216d-43f5-8999-7cbce30d3d94"))
                .semanticOn(PublicIds.of("b9be8faf-64ab-424f-9ec9-045c494c871e"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("5922fc9e-d1f8-4824-b811-48ea82638ff1"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("30dffcd7-96cd-4292-9466-babed1404a75"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("ab8f4e2c-4fe7-470e-8f19-232f8edf3f18"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("bee1dc71-703e-4974-b52c-5edd942e5129"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f4b65d75-637f-4b4e-bd5c-a3a945584f19"), IkeTerm.PREFERRED)
                ;

        set.concept("Path origins (SOLOR)", PublicIds.of("6e6a112e-7d8c-53c7-aaf1-c46e2d69743c")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8198f0c0-c544-4b2d-bc3c-03561b082680"), IkeTerm.ENGLISH_LANGUAGE, "Path origins (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("81065d85-7058-4cdc-b545-3629317918df"), IkeTerm.ENGLISH_LANGUAGE, "Path origins", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                // Definition text diverges from the baseline artifact: label echo replaced in place (IKE-Network/ike-issues#892, #894).
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8218d3af-ef97-4717-8f68-2bc3ed36c335"), IkeTerm.ENGLISH_LANGUAGE, "A path's own origin record — the path-coordinate property saying where a path branched from. As the Path origins pattern's second field meaning it names the origin instant that record fixes: the branch point up to which the origin path's versions are visible.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("b7f3e045-e847-48c2-b95a-dc563e6d6523"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "6e6a112e-7d8c-53c7-aaf1-c46e2d69743c")
                .statedAxioms(PublicIds.of("623faf95-7376-54d2-92e3-3ead825748eb"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PATH_COORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("7f48d9d0-53ee-481e-944e-0033c193e212"))
                .semanticOn(PublicIds.of("8198f0c0-c544-4b2d-bc3c-03561b082680"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("c3bf143b-564d-4e1b-86aa-a128df2739e0"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("81065d85-7058-4cdc-b545-3629317918df"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("f9be5cfa-8489-4f97-a63e-7c87294239ce"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("8218d3af-ef97-4717-8f68-2bc3ed36c335"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e298ba26-5a83-456e-9930-fe99bc712c86"), IkeTerm.PREFERRED)
                ;

        set.concept("Promotion Path for Edit Coordinate (SOLOR)", PublicIds.of("db124d3b-c1bb-530e-8fd4-577f570355be")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3b7a20b5-fbc8-4e9d-b96e-32e601cef195"), IkeTerm.ENGLISH_LANGUAGE, "Promotion Path for Edit Coordinate (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("a1499e3c-0160-4687-b11d-babbdf321733"), IkeTerm.ENGLISH_LANGUAGE, "Promotion Path for Edit Coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("700a0174-51a0-461f-a357-2d87171ce877"), IkeTerm.ENGLISH_LANGUAGE, "Promotion Path for Edit Coordinate", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("1b6f1823-d229-4e4d-b8c4-ce3ee75264a7"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "db124d3b-c1bb-530e-8fd4-577f570355be")
                .statedAxioms(PublicIds.of("9d4392be-075f-580b-a93d-7ec8d2cef73c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.PATH_COORDINATE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("5531a302-979e-4450-a893-cc22a5ef075a"))
                .semanticOn(PublicIds.of("3b7a20b5-fbc8-4e9d-b96e-32e601cef195"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("85be8472-3d70-43e4-aa34-3a82119cf00c"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("a1499e3c-0160-4687-b11d-babbdf321733"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("feb17f17-c26d-410a-a806-b34a3ad961af"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("700a0174-51a0-461f-a357-2d87171ce877"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("71100371-a40c-4776-9394-e8431aa934b0"), IkeTerm.PREFERRED)
                ;

    }
}
