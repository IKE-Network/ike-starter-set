---
date_published: 2026-07-02
date_modified: 2026-07-02
canonical_url: https://ike.network/ike-starter-set/ike-kb/built-with.html
---

# Built With

Open-source software that `ike-kb` 1-chronology-builder-SNAPSHOT depends on, links against, ships within, or invokes at runtime.

Three layers of attribution ship with each release:

- [Software Bill of Materials (CycloneDX, JSON)](bom.json)[1] — full transitive dependency graph with SPDX-normalized licenses and artifact hashes. Ingestible by Dependency-Track, Trivy, Snyk, GitHub’s dependency graph.
- [Licenses (SPDX)](licenses.html)[2] — human-readable SPDX-grouped view of declared dependencies, generated from `bom.json` (#335).
- This page — curated companion covering what mechanical reports can’t see (Maven Site skin, external services, fonts inside artifacts, frontend assets in rendered HTML).

## [#mechanical-inventory](#mechanical-inventory)Mechanical inventory

Direct dependencies of this module, grouped by SPDX expression. Generated from `bom.json` at build time.

| SPDX Expression | Components |
| --- | --- |
| `Apache-2.0` | 50 |
| `Eclipse Public License (EPL) 2.0 OR LGPL-2.1-only` | 1 |
| `BSD-3-Clause OR EPL-1.0` | 2 |
| `Apache Software License 2.0` | 2 |
| `MIT` | 1 |
| **Total** | **56** |

For full per-component detail (group, artifact, version, hashes, transitive deps), see [bom.json](bom.json)[1] or [licenses.html](licenses.html)[2].

## [#related](#related)Related

- [site index](index.html)[3]
- [ike-issues#336](https://github.com/IKE-Network/ike-issues/issues/336)[4] — the issue that introduced this page (rename of the legacy "Third-Party Notices" to friendlier "Built With").
