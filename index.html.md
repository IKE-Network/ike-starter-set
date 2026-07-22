---
date_published: 2026-07-21
date_modified: 2026-07-21
canonical_url: https://ike.network/ike-starter-set/index.html
---

# IKE Starter Set

`ike-starter-set` is the IKE Network’s foundational content set — the concepts, patterns, and axioms an IKE knowledge graph starts from.

Its source is an **append-only version ledger**: content is authored as declared stamps with edits recorded under each. Building the project replays that ledger into a store; the released artifact is a **change set**. A starter set is exactly that change set applied to an empty base.

## [#reading-the-set](#reading-the-set)Reading the Set

The guide is generated from the same loaded store that produces the change set, so glossary and artifact never drift apart.

- [Guide — HTML](ike-guide.html)[1] — self-contained single file
- [Guide — PDF](ike-guide.pdf)[2] — print/download

## [#modules](#modules)Modules

The reactor is organized as one module per **projection** of the ledger. The ledger is authored once; each projection renders it for a different consumer.

| Module | Role |
| --- | --- |
| `ike-terms` | The ledger itself — declared stamps inline, edits under each, authored with the chronology builders. Replay is verified over an in-memory store. |
| `ike-bindings` | Generated Java bindings — resolved UUID literals with definitions as javadoc, autocompletable in any IDE. Depends only on the terms surface, so consumers stay light. |
| `ike-changeset` | The released form — `ike:knowledge-export` replays the ledger and attaches the protobuf change set (classifier `changeset`), plus the `koncepts.yml` the guide renders from. |
| `ike-doc` | This documentation — the guide and its Koncept glossary. |
| `ike-kb` | The full-cycle knowledge base — the change set assembled and classified by `ike:kb-assemble`, installed into a data-source directory for verification in Komet. |

## [#identity-and-time](#identity-and-time)Identity and Time

Identity is derived, not assigned: a component’s public id is a UUIDv5 over the set’s namespace and the concept’s fully-qualified name at birth. A name is never reused within a namespace, so the same authored name always denotes the same component.

Pre-release, every stamp carries the shared **inception epoch** rather than wall-clock time, so the set is reproducible byte-for-byte across rebuilds. At first release those stamps freeze, and calendar time applies from then on.

## [#consuming-the-set](#consuming-the-set)Consuming the Set

The change set is published to the IKE Maven repository and attached to each checkpoint on GitHub. Consumers resolve it as an ordinary Maven artifact:

```
<dependency>
    <groupId>network.ike.foundation</groupId>
    <artifactId>ike-changeset</artifactId>
    <classifier>changeset</classifier>
    <type>zip</type>
</dependency>
```

For compiler-visible references to individual concepts, depend on `ike-bindings` instead and use the generated constants.

## [#status](#status)Status

The set is pre-release and evolves on a feature branch; each checkpoint publishes a change set, this site, and a GitHub pre-release. Until the first release, treat the content as provisional — the shape is settled, the inventory is still growing.
