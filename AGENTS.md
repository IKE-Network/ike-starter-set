# Project agent memory

This file is the project's committed home for project-intrinsic agent knowledge: build, test, release, architecture, and sharp-edge notes that should travel with the code.

- Add durable project-specific notes here as they are discovered through real work.

## Decentralized doc hierarchy (`ike-hierarchy-maven-plugin`)

Guide chapters (`ike-doc/src/docs/asciidoc/`) self-assemble via `:chapter-id:`/`:chapter-parent:`/
`:chapter-order:` headers rather than manual `include::` lists — see
`ike-hierarchy-maven-plugin/README.md`. `include::hierarchy:<id>[]` (implemented in
`ike-doc-extension`'s `HierarchyIncludeProcessor`) pulls in a chapter's **entire descendant
subtree transitively**, not just its direct children — `HierarchyIndex.descendantsOf` walks every
depth below the target until it hits a sibling or shallower node.

**Consequence:** only the topmost assembly root (e.g. `ike-guide.adoc`) should ever call
`include::hierarchy:<self>[]`. An intermediate chapter that itself has children (e.g. `cql.adoc`,
parent of the 8 CQL sub-chapters) must **not** also call `include::hierarchy:<its-own-id>[]` —
the root's own call already reaches those grandchildren directly, so the intermediate chapter
doing it too renders every descendant a second time. An intermediate chapter with children should
contain only its header and title; any of its own prose has to live in one of its children (e.g.
at the end of the last-ordered child) since it will render *before* the children's content, not
interleaved with it.

Every chapter fragment (any depth) must open with `= Title` (single `=`), never `==`/`===`, per
`.claude/standards/IKE-ASCIIDOC-FRAGMENT.md` — the assembly's computed `leveloffset` supplies the
real depth. A fragment's *internal* subheadings keep whatever depth they had relative to its own
`= Title`.

There's no Maven execution bound to `generate-resources` for `asciidoctor-maven-plugin` itself in
`ike-doc/pom.xml` (only the `ike-hierarchy-maven-plugin:index` goal is bound there) — asciidoctor
conversion runs off that plugin's own default phase binding when invoked, not an explicit
`<execution>`. To index only (no full render, no need for `ike-changeset`/koncepts.yml or
JDK 25): `mvn -pl ike-doc network.ike.foundation:ike-hierarchy-maven-plugin:index` (or `:validate`
for a dry run). The reactor requires JDK 25+ (`JAVA_HOME` to a 25+ JDK) and network access for
some unrelated modules (`ike-terms` → external `ike-knowledge-provider`/`tinkar` artifacts) that
isn't needed just to build/validate the doc hierarchy.

To actually *render* the real guide without that full build, run `ike-doc-extension`'s
`HierarchyRenderTest`: its `renderIkeGuideIfIndexExists`/`renderCqlDictionaryIfPresent` tests
convert the real `ike-guide.adoc`/`cql-dictionary.adoc` into `ike-doc/target/generated-docs/`
whenever `ike-doc/target/ike-hierarchy-index.json` exists (run the `index` goal first, else they
silently no-op). Diffing that HTML across a change is the way to prove a doc edit is render-neutral.
A chapter's location on disk carries no meaning (see the plugin README) — a pure `git mv` of a
chapter file changes only its `path` in the index.

## Maintaining this file

Keep this file for knowledge useful to almost every future agent session in this project.
Do not repeat what the codebase already shows; point to the authoritative file or command instead.
Prefer rewriting or pruning existing entries over appending new ones.
When updating this file, preserve this bar for all agents and keep entries concise.
