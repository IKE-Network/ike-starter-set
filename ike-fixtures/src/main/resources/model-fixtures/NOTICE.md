# Model information fixtures

The three files beside this notice are the CQL translator's model information for QDM 5.4,
QDM 5.5, and FHIR 3.0.0, taken unchanged from
https://github.com/cqframework/clinical_quality_language at tag v5.3.0 (paths
qdm/src/main/resources/gov/healthit/qdm/qdm-modelinfo-5.4.xml, qdm-modelinfo-5.5.xml, and
quick/src/main/resources/org/hl7/fhir/fhir-modelinfo-3.0.0.xml), under the Apache License
2.0. They serve only the round-trip gate: two libraries of the corpus were written against
these QDM versions and one against FHIR 3.0.0, and the gate imports them before the corpus so
that every type name resolves (IKE-Network/ike-issues#1115). They sit
apart from the corpus, which the gate reads as libraries. The models the starter set ships
are in ike-model.
