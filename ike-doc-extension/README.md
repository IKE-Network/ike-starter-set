# Ike Doc Extension

The AsciidoctorJ side of the decentralized live hierarchy. It resolves two include targets from the
index written by `ike-hierarchy-maven-plugin`:

```asciidoc
include::hierarchy:ike-guide[]   // every chapter placed beneath the ike-guide root, in order
include::chapter:cql[]           // one named chapter, wherever in the project it lives
```

Heading depth is not passed in and not guessed. Each chapter's depth was computed when the
hierarchy was validated, so a chapter emits `leveloffset=+depth` and lands at exactly the level its
place in the tree implies. An optional `leveloffset` on the directive shifts a whole subtree:
`include::hierarchy:ike-guide[leveloffset=+1]`.

## Configuration

Two document attributes, set by the module that renders the guide:

```xml
<attributes>
    <ike-hierarchy-index>${project.build.directory}/ike-hierarchy-index.json</ike-hierarchy-index>
    <ike-hierarchy-base>${session.rootDirectory}</ike-hierarchy-base>
</attributes>
```

`ike-hierarchy-base` is the trust root. Every path in the index is relative — to a scan root, and
each root to the project base — and the base comes from Maven rather than from the index, so a
stale or hand-edited index still cannot name a file outside the project.

The extension registers itself through the service loader (`META-INF/services`), so it is active
for every backend. Per `IKE-JAVA.md`, only postprocessors and tree processors need per-execution
registration in the POM.

## What it deliberately does not do

This module replaces two earlier extensions — a `chapter:` processor that expanded directories by
listing them, and a `federated:` processor that discovered `manifest.json` files on the classpath
and the filesystem. Both did discovery at render time. This one does none:

- **No directory walking.** Discovery happened once, in the Maven goal, and the answer was
  validated and written down.
- **No filesystem fallback.** The processor it supersedes, on failing to resolve a target, tried the
  path against the filesystem root and read whatever it found — which made
  `include::chapter:../../../../etc/passwd[]` a working directive. Here an unknown identifier
  produces a visible warning and nothing else.
- **No hand-written JSON or YAML parsing.** The index is read by a strict parser in
  `ike-hierarchy-model`.

The practical consequence is that two builds of the same tree produce the same document, and a
chapter cannot appear or vanish depending on what happens to be on disk at render time.

## Troubleshooting

A `WARNING: ike-hierarchy: ...` in the rendered output names the problem. The common ones:

| Warning mentions                         | Cause                                                          |
|------------------------------------------|----------------------------------------------------------------|
| the document attributes are not set       | `ike-hierarchy-index` / `ike-hierarchy-base` missing from the POM |
| the index was not found inside the project| `ike-hierarchy:index` has not run, or is bound after rendering  |
| no chapters are placed beneath '...'      | Nothing declares `:chapter-parent:` pointing at that root       |
| its file could not be read                | The index is stale — re-run the build                           |
