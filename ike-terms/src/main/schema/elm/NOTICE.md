# ELM schemas, the source of ElmNodeCatalogSet

The four XML Schema files in this directory are HL7's ELM, the Expression Logical
Model of the Clinical Quality Language specification (and not Elm, the programming
language for browser user interfaces), taken unchanged from
https://github.com/cqframework/clinical_quality_language at tag v5.3.0, path
schemas/elm/. They are licensed under the Apache License 2.0 by their authors.
cqlannotations.xsd, which carries source positions and narrative for tooling, is not
imported (IKE-Network/ike-issues#1104).

ElmNodeCatalogSet.java, the ELM node catalog in the ledger, is generated from these files by
ike:schema-import and is never edited by hand; to move to a new release, replace the
files, regenerate, and review the diff.

## Regenerating

From `ike-terms`, with the tooling release that carries `ike:schema-import` and its form
field (IKE-Network/ike-issues#1110), one line:

```bash
../../mvnw ike:schema-import -Dike.schemaImport.schemas=src/main/schema/elm/types.xsd,src/main/schema/elm/expression.xsd,src/main/schema/elm/clinicalexpression.xsd,src/main/schema/elm/library.xsd -Dike.schemaImport.packageName=network.ike.foundation.ike.terms -Dike.schemaImport.className=ElmNodeCatalogSet -Dike.schemaImport.tag=ELM -Dike.schemaImport.namespacePrefixes="urn:hl7-org:elm-types:r1=ELM System" -Dike.schemaImport.attribution="the ELM specification" -Dike.schemaImport.pin="cqframework/clinical_quality_language v5.3.0"
```

The goal normalizes every prefix to end with exactly one space, so the trailing space
inside the quotes does not matter.
