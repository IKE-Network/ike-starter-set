---
date_published: 2026-07-02
date_modified: 2026-07-02
canonical_url: https://ike.network/ike-starter-set/ike-terms/dependencies.html
---

# Dependencies (SBOM)

Full transitive dependency graph for `ike-terms` 1-chronology-builder-SNAPSHOT, generated from [bom.json](bom.json)[1] (CycloneDX 1.6) at build time. Same SBOM source as the SPDX-grouped [licenses.html](licenses.html)[2] and the curated [built-with.html](built-with.html)[3] — three views of the same data.

## [#summary](#summary)Summary

| Total components | 25 |
| --- | --- |
| Distinct license expressions | 5 |

## [#components](#components)Components

Sorted by group, artifact, version. Click [bom.json](bom.json)[1] for the raw machine-readable form (Dependency-Track, Trivy, Snyk, GitHub dep-graph all ingest it directly).

| Group | Artifact | Version | License | Type |
| --- | --- | --- | --- | --- |
| `com.github.RoaringBitmap.RoaringBitmap` | `roaringbitmap` | `1.6.0` | `Apache-2.0` | library |
| `com.github.ben-manes.caffeine` | `caffeine` | `3.2.3` | `Apache-2.0` | library |
| `com.google.errorprone` | `error_prone_annotations` | `2.43.0` | `Apache-2.0` | library |
| `dev.ikm.jpms` | `activej-bytebuf` | `4.3-r10` | `Apache-2.0` | library |
| `dev.ikm.jpms` | `activej-common` | `4.3-r8` | `Apache-2.0` | library |
| `dev.ikm.jpms` | `apfloat` | `1.14.0-r1` | `Apache Software License 2.0` | library |
| `dev.ikm.jpms` | `jheaps` | `0.14-r16` | `Apache Software License 2.0` | library |
| `dev.ikm.jpms` | `protobuf-java` | `4.30.2-r3` | `Apache-2.0` | library |
| `dev.ikm.tinkar` | `collection` | `1.127.2-chronology-builder-SNAPSHOT` | `Apache-2.0` | library |
| `dev.ikm.tinkar` | `common` | `1.127.2-chronology-builder-SNAPSHOT` | `Apache-2.0` | library |
| `dev.ikm.tinkar` | `component` | `1.127.2-chronology-builder-SNAPSHOT` | `Apache-2.0` | library |
| `dev.ikm.tinkar` | `entity` | `1.127.2-chronology-builder-SNAPSHOT` | `Apache-2.0` | library |
| `dev.ikm.tinkar` | `terms` | `1.127.2-chronology-builder-SNAPSHOT` | `Apache-2.0` | library |
| `dev.ikm.tinkar` | `tinkar-schema` | `1.43.0-chronology-builder-SNAPSHOT` | `Apache-2.0` | library |
| `network.ike` | `ike-base-parent` | `15` | `Apache-2.0` | library |
| `network.ike.tooling` | `ike-build-standards` | `233` | `Apache-2.0` | library |
| `network.ike.tooling` | `ike-build-standards` | `233` | `Apache-2.0` | library |
| `network.ike.tooling` | `ike-build-standards` | `233` | `Apache-2.0` | library |
| `network.ike.tooling` | `ike-build-standards` | `233` | `Apache-2.0` | library |
| `network.ike.tooling` | `ike-build-standards` | `233` | `Apache-2.0` | library |
| `org.eclipse.collections` | `eclipse-collections` | `13.0.0` | `BSD-3-Clause OR EPL-1.0` | library |
| `org.eclipse.collections` | `eclipse-collections-api` | `13.0.0` | `BSD-3-Clause OR EPL-1.0` | library |
| `org.jgrapht` | `jgrapht-core` | `1.5.2` | `Eclipse Public License (EPL) 2.0 OR LGPL-2.1-only` | library |
| `org.jspecify` | `jspecify` | `1.0.0` | `Apache-2.0` | library |
| `org.slf4j` | `slf4j-api` | `2.0.17` | `MIT` | library |

## [#download](#download)Download

- [Software Bill of Materials (CycloneDX, JSON)](bom.json)[1] — raw machine-readable form. Includes purls, hashes, and dependency-graph edges that this page summarizes.
- [bom.xml](bom.xml)[4] — same content in XML.
- As a Maven artifact: pull `ike-terms:​1-chronology-builder-SNAPSHOT` with `<classifier>cyclonedx</classifier><type>json</type>` from Nexus / Maven Central.

## [#see-also](#see-also)See also

- [Licenses (SPDX)](licenses.html)[2] — same components grouped by license expression.
- [Built With](built-with.html)[3] — curated narrative + per-license summary.
- [ike-issues#341](https://github.com/IKE-Network/ike-issues/issues/341)[5] — the issue that introduced this page.
