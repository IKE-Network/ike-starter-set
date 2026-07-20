package network.ike.foundation.ike.terms.foundation;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.terms.IkeTerm;
import java.time.Instant;
import java.util.UUID;

/** The "Chronicle properties" section — a taxonomy subtree of the retrofitted starter set (IKE-Network/ike-issues#869). */
final class Section20 {

    private Section20() {
    }

    static void compose(KnowledgeSet set) {
        ActiveStamp inception = network.ike.foundation.ike.terms.Ike.INCEPTION;

        set.concept("Chronicle properties (SOLOR)", PublicIds.of("2ba2ef47-30af-57ec-9073-38693f020d7e")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("36542471-fa26-4192-ad5d-77dfd54d5f61"), IkeTerm.ENGLISH_LANGUAGE, "Chronicle properties (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("cac89c42-0838-49d3-ad10-91b40781a283"), IkeTerm.ENGLISH_LANGUAGE, "Chronicle properties", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("8e92e807-c018-4d19-80b1-46b6ed26f061"), IkeTerm.ENGLISH_LANGUAGE, "Attributes or characteristic associated with a historical record or an account of events (metadata, timestamps)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("ca672944-0c11-4c40-a0a9-15898d0d9774"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "2ba2ef47-30af-57ec-9073-38693f020d7e")
                .statedAxioms(PublicIds.of("0fced50b-a581-5111-bbfc-cc1fcaf7f79f"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(set.conceptRef("Chronicle and version model (IkeFoundation)")))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("d222c85e-5f25-4fb3-898a-f01a36c859c2"))
                .semanticOn(PublicIds.of("36542471-fa26-4192-ad5d-77dfd54d5f61"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("59bdd138-e690-4de1-a698-33b4f23d3a29"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("cac89c42-0838-49d3-ad10-91b40781a283"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("aeab0677-f035-47a5-bf57-2d4335b4aa85"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("8e92e807-c018-4d19-80b1-46b6ed26f061"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3788aa23-56ac-4301-adfb-d77f11b8ce06"), IkeTerm.PREFERRED)
                ;

        set.concept("Version list for chronicle (SOLOR)", PublicIds.of("d6f27f80-8e20-58fe-8d69-66ad4644f969")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("75377a68-118e-4c6c-a2ec-e6e145e66975"), IkeTerm.ENGLISH_LANGUAGE, "Version list for chronicle (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("2fde5776-3c2c-4c2a-8267-e05d13c082d9"), IkeTerm.ENGLISH_LANGUAGE, "Versions", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("5459708c-1981-40e2-9a8d-83b007b77fe9"), IkeTerm.ENGLISH_LANGUAGE, "Chronicle version list", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("98d7bcda-5963-410e-b4bf-3e10430fb1b6"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "d6f27f80-8e20-58fe-8d69-66ad4644f969")
                .statedAxioms(PublicIds.of("e494535b-d132-56a4-8c4c-d8bbcad41ff9"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CHRONICLE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("2831227a-96bc-4b08-963c-d4100911b258"))
                .semanticOn(PublicIds.of("75377a68-118e-4c6c-a2ec-e6e145e66975"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("76fc8830-1d74-49a0-b8dd-7ab244fd4df5"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("2fde5776-3c2c-4c2a-8267-e05d13c082d9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("3ae29b6a-f945-45a6-b8b6-24709b822545"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("5459708c-1981-40e2-9a8d-83b007b77fe9"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("680def61-3119-4dfa-addd-734f529e8538"), IkeTerm.PREFERRED)
                ;

        set.concept("Primordial UUID for chronicle (SOLOR)", PublicIds.of("e0fcafbc-7191-5cdc-b14a-19d4d97f71bd")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("3a34bd7d-1b38-498d-a8b5-d04464e930a3"), IkeTerm.ENGLISH_LANGUAGE, "Primordial UUID for chronicle (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7d77eae6-597a-4847-ba8d-aa823565caf5"), IkeTerm.ENGLISH_LANGUAGE, "Primordial UUID", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d65c236c-0c1a-49f9-b711-7cbc26ef8ef4"), IkeTerm.ENGLISH_LANGUAGE, "The first universally unique identifier in a chronicle's public identity: the stable primary key among its identifiers.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("773bc3b9-7d73-4426-b44a-c915e987390d"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "e0fcafbc-7191-5cdc-b14a-19d4d97f71bd")
                .statedAxioms(PublicIds.of("9b98abf2-651b-5a69-8381-9871ae1b282c"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CHRONICLE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8ad5b478-f0b8-4db5-8117-78015093461c"))
                .semanticOn(PublicIds.of("3a34bd7d-1b38-498d-a8b5-d04464e930a3"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("b77567ab-eee7-41f2-828f-81f566895467"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("7d77eae6-597a-4847-ba8d-aa823565caf5"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4123f2ab-3b7e-4faf-a39f-60cf2a9694e6"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d65c236c-0c1a-49f9-b711-7cbc26ef8ef4"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("908965bb-8157-4788-80f5-ec2e06ca77a9"), IkeTerm.PREFERRED)
                ;

        set.concept("UUID list for component (SOLOR)", PublicIds.of("f8e3238e-7424-5a40-8649-a8d164382fec")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("85684fac-e4d6-4c05-8b2b-9c0068abf8be"), IkeTerm.ENGLISH_LANGUAGE, "UUID list for component (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("7a135cdf-5c9d-4d47-b7e9-47774ae53954"), IkeTerm.ENGLISH_LANGUAGE, "UUIDs", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("cd03b57c-ba73-459f-a36b-e566aeccfb02"), IkeTerm.ENGLISH_LANGUAGE, "The complete list of universally unique identifiers in a component's public identity; merging two components unions these lists.", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("a823203e-9289-4ae7-811c-b7d30e751382"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "f8e3238e-7424-5a40-8649-a8d164382fec")
                .statedAxioms(PublicIds.of("2f8a22f9-91d9-522e-8551-517ac981e615"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CHRONICLE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("48325224-e5d5-4189-a5b4-3855b51c97bf"))
                .semanticOn(PublicIds.of("85684fac-e4d6-4c05-8b2b-9c0068abf8be"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("e1669348-43da-41f2-ba69-a4f55f22ec22"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("7a135cdf-5c9d-4d47-b7e9-47774ae53954"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("02e0c348-fc57-4d19-b1b9-8674ade506ff"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("cd03b57c-ba73-459f-a36b-e566aeccfb02"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("4bf7882a-e8d9-4cfd-9fe8-c282f71eacc1"), IkeTerm.PREFERRED)
                ;

        set.concept("Semantic list for chronicle (SOLOR)", PublicIds.of("c809b2c0-9235-5f64-bbda-34210d91bdf8")).at(inception)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("64f2a1ae-1fcc-430f-8d86-c41e57bac779"), IkeTerm.ENGLISH_LANGUAGE, "Semantic list for chronicle (SOLOR)", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("f02544bf-c084-4953-8cb7-097f97691f93"), IkeTerm.ENGLISH_LANGUAGE, "Semantic list for chronicle", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.REGULAR_NAME_DESCRIPTION_TYPE)
                .semantic(IkeTerm.DESCRIPTION_PATTERN, PublicIds.of("d0cbb158-4d10-46f2-9aad-aab21766c895"), IkeTerm.ENGLISH_LANGUAGE, "Semantic list", IkeTerm.DESCRIPTION_NOT_CASE_SENSITIVE, IkeTerm.DEFINITION_DESCRIPTION_TYPE)
                .semantic(IkeTerm.IDENTIFIER_PATTERN, PublicIds.of("ca3f16dc-057b-4e07-98a8-8e782ae4fa73"), IkeTerm.UNIVERSALLY_UNIQUE_IDENTIFIER, "c809b2c0-9235-5f64-bbda-34210d91bdf8")
                .statedAxioms(PublicIds.of("83e6b7cc-f6d7-53db-9d17-a97b7587542a"), leb -> leb.NecessarySet(leb.And(leb.ConceptAxiom(IkeTerm.CHRONICLE_PROPERTIES))))
                .semantic(IkeTerm.TINKAR_BASE_MODEL_COMPONENT_PATTERN, PublicIds.of("8c7738b2-af73-4018-b139-4cb856cd8690"))
                .semanticOn(PublicIds.of("64f2a1ae-1fcc-430f-8d86-c41e57bac779"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("112f2249-c90a-4107-933d-9d6340eb5b92"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("f02544bf-c084-4953-8cb7-097f97691f93"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("9c69cd42-9497-4878-ba6b-2cc9cf176fd1"), IkeTerm.PREFERRED)
                .semanticOn(PublicIds.of("d0cbb158-4d10-46f2-9aad-aab21766c895"), IkeTerm.US_DIALECT_PATTERN, PublicIds.of("160f47b3-689e-4a69-8c9e-1a319a59131f"), IkeTerm.PREFERRED)
                ;

    }
}
