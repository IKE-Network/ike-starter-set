# Model information files

The files beside this notice are the CQL translator's model information, taken unchanged
from https://github.com/cqframework/clinical_quality_language at tag v5.3.0, under the
Apache License 2.0 (the text is in LICENSE beside them). HL7's ELM is the Expression Logical
Model of the Clinical Quality Language specification, and not Elm, the programming language
for browser user interfaces.

| File | Path in the repository at v5.3.0 |
|---|---|
| modelinfo.xsd | schemas/model/modelinfo.xsd |
| system-modelinfo.xml | cql/src/commonMain/resources/org/hl7/elm/r1/system-modelinfo.xml |
| qdm-modelinfo-5.6.xml | qdm/src/main/resources/gov/healthit/qdm/qdm-modelinfo-5.6.xml |
| quick-modelinfo.xml | quick/src/main/resources/org/hl7/fhir/quick-modelinfo.xml |
| fhir-modelinfo-4.0.1.xml | quick/src/main/resources/org/hl7/fhir/fhir-modelinfo-4.0.1.xml |
| qicore-modelinfo-4.1.1.xml | quick/src/main/resources/org/hl7/fhir/qicore-modelinfo-4.1.1.xml |
| uscore-modelinfo-3.1.1.xml | quick/src/main/resources/org/hl7/fhir/uscore-modelinfo-3.1.1.xml |

Nothing in them is reworded. An importer reads them into the store when a knowledge base is
assembled (IKE-Network/ike-issues#1115); what IKE adds, the resolution of names to concepts,
is marked as IKE's in the store, never written into these files.

SHA-256 of each file as taken:

- modelinfo.xsd: fc714bc30adbb6f5490da9ab466ae2a4956534da67878ef445080b651c9274d1
- system-modelinfo.xml: 358032d73c989739a09b6c3e06504a2d977c340014c87c60d2dd081ba2ae7d6a
- qdm-modelinfo-5.6.xml: aaa4e6459f5da10beac8ac015e4eec13ec46897763ef3af79a2e5a8685cd16a0
- quick-modelinfo.xml: c2c472674f8c68feaf8a927e2dc7de9538d6d3d2e19c65d556a22784c3f91543
- fhir-modelinfo-4.0.1.xml: 16fa8119e074ebfb6a301b58af72417c2360dca899e89f6e3bd1d9a0e4789722
- qicore-modelinfo-4.1.1.xml: 0babf71ad74b6ea7ce74ab75939d302929da4e2fe060bc93e909550814267563
- uscore-modelinfo-3.1.1.xml: e44a942ae49fadd4a98d5b2d42cf4bc7b4639f10edee0d210441374357087930
