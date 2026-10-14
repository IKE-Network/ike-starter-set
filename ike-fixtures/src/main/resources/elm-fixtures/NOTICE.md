# ELM fixtures, the round-trip corpus

The 21 files under this directory are ELM libraries as the CQL-to-ELM translator writes
them, in JSON and in XML, taken unchanged from
https://github.com/cqframework/clinical_quality_language at tag v5.3.0, keeping their
paths under that repository's test resources. They are licensed under the Apache License
2.0 by their authors. HL7's ELM is the Expression Logical Model of the Clinical Quality
Language specification, and not Elm, the programming language for browser user interfaces.

They are the corpus of the round-trip gate (IKE-Network/ike-issues#1112): each is imported,
exported in both forms, and compared with the original in canonical form, everything except
the translator's annotations. Four of them are CMS146 at the four signature levels, in both
forms; two are the same QDM library at two versions, in both forms; the rest are single
libraries from the translator's library-manager and deserialization tests. Several share a
library id with different content, which exercises versioning on re-import.

Two files beside them in the repository are not kept: `options.json`, a translator setting
and not a library, and `PropertyTest_ELM.xml`, written against an older ELM whose node kind
`ElementOf` the pinned schemas no longer declare, so no catalog of theirs can hold it.
