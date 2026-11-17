# Ike Hierarchy Maven Plugin

A decentralized live hierarchy control system for AsciiDoc guides.

A chapter is any `.adoc` file, anywhere in the project, that declares its own identity and where it
belongs. Nothing else knows it exists. Moving a chapter is `git mv`; adding one is a single command;
the guide file itself is never edited.

## The one command

```bash
mvn ike-hierarchy:add-chapter -Dfile=ike-doc/src/docs/asciidoc/my-draft.adoc -Dparent=ike-guide -Dorder=250
```

That adds four lines to the top of `my-draft.adoc` and nothing else happens anywhere:

```asciidoc
:chapter-id: my-draft
:chapter-parent: ike-guide
:chapter-order: 250
:chapter-status: published
```

The file is not moved, renamed, split, or copied, and `ike-guide.adoc` is not touched. Build, and
the chapter is in the book at the right depth and in the right position.

Re-running the same command changes nothing. Re-running it with a different `-Dparent` or `-Dorder`
moves the chapter rather than adding a second declaration.

## The chapter header

| Attribute          | Required | Meaning                                                            |
|--------------------|----------|--------------------------------------------------------------------|
| `:chapter-id:`     | yes      | Stable identity. Lowercase kebab-case. This is what makes the file a chapter. |
| `:chapter-parent:` | yes¹     | The id this chapter hangs beneath.                                  |
| `:chapter-order:`  | no       | Sort key among siblings. Default 500; ties break on id.             |
| `:chapter-title:`  | no       | Display title. Defaults to the file's own `= Heading`.              |
| `:chapter-status:` | no       | `draft`, `proposed`, `review`, `published` (default), `deprecated`. |
| `:chapter-root:`   | no       | Valueless. Marks this file an assembly root instead of a chapter.   |

¹ Unless `:chapter-root:` is set. A file with neither fails the build rather than disappearing.

Everything else follows `IKE-ASCIIDOC-FRAGMENT.md`: a chapter file starts at `= Title` and the
assembly supplies the depth.

## The guide

An assembly root declares itself and pulls in everything placed beneath it:

```asciidoc
:chapter-id: ike-guide
:chapter-root:

= Ike Starter Set
:toc: left

include::hierarchy:ike-guide[]
```

`include::chapter:cql[]` pulls in one named chapter wherever it lives.

## Goals

| Goal                        | What it does                                                            |
|-----------------------------|-------------------------------------------------------------------------|
| `ike-hierarchy:add-chapter` | Registers a file as a chapter, in place. Idempotent.                    |
| `ike-hierarchy:index`       | Scans, validates, writes the index. Bind ahead of rendering.            |
| `ike-hierarchy:validate`    | The same checks with no write — for CI, or after moving files around.   |
| `ike-hierarchy:decompose`   | Splits a guide with inline chapters into chapter files. Dry run by default. |

### Migrating an existing guide

```bash
mvn ike-hierarchy:decompose -Dfile=ike-doc/src/docs/asciidoc/ike-guide.adoc              # show the plan
mvn ike-hierarchy:decompose -Dfile=ike-doc/src/docs/asciidoc/ike-guide.adoc -Dwrite=true # apply it
```

The dry run lists every chapter it would create and the id it would assign. Applying writes the
chapter files first and rewrites the guide last, so an interrupted run never loses content, and it
refuses to overwrite a file that already exists.

## Wiring it into a documentation module

```xml
<plugin>
    <groupId>network.ike.foundation</groupId>
    <artifactId>ike-hierarchy-maven-plugin</artifactId>
    <version>${project.version}</version>
    <executions>
        <execution>
            <id>hierarchy-index</id>
            <phase>generate-resources</phase>
            <goals><goal>index</goal></goals>
        </execution>
    </executions>
</plugin>
```

Bind it ahead of whatever renders the documentation. Then tell the Asciidoctor extension where the
index and the project base are:

```xml
<attributes>
    <ike-hierarchy-index>${project.build.directory}/ike-hierarchy-index.json</ike-hierarchy-index>
    <ike-hierarchy-base>${session.rootDirectory}</ike-hierarchy-base>
</attributes>
```

## Configuration

| Property                      | Default            | Meaning                                              |
|-------------------------------|--------------------|------------------------------------------------------|
| `ike-hierarchy.roots`         | the reactor root   | Comma-separated directories to scan.                 |
| `ike-hierarchy.maxDepth`      | `5`                | Deepest nesting below a root. AsciiDoc caps at 6.     |
| `ike-hierarchy.maxFiles`      | `5000`             | Most files a scan will examine.                       |
| `ike-hierarchy.maxFileBytes`  | `8388608`          | Largest file whose header is read.                    |
| `ike-hierarchy.exclude`       | see below          | Directory names never descended into.                 |
| `ike-hierarchy.skip`          | `false`            | Skip the `index` goal.                                |

Excluded by default: `target`, `build`, `out`, `.git`, `.idea`, `.mvn`, `node_modules`, `.gradle`,
`.settings`.

## What fails the build

Any of these, reported all at once with the file that caused each:

- Two files claiming the same `:chapter-id:`.
- A `:chapter-parent:` no file declares.
- A cycle in the parent pointers.
- A chapter with neither a parent nor `:chapter-root:`.
- Nesting deeper than `maxDepth`.
- A malformed header — a chapter that meant to be one and got it wrong.
- A file that resolves outside the project, including through a symbolic link.

A chapter that cannot be placed does not quietly vanish from the book.

## Security notes

- **Containment.** Every path resolves through `SafePath`, which uses real-path resolution — not
  string normalisation — so a symbolic link out of the tree is caught rather than followed. There is
  no absolute-path fallback: an unresolvable target produces a warning, never a read from elsewhere.
- **The index cannot name a file outside the project.** It records paths relative to a root, and
  roots relative to the project base, and the base comes from Maven, not from the index. A stale or
  hand-edited index still cannot escape, and every path is re-checked at render time.
- **Strict JSON.** The index is parsed by a real parser that rejects trailing commas, unquoted keys,
  duplicate members, and anything after the document, with depth and length limits. Pattern-matching
  a JSON-shaped string does not fail on malformed input; it returns a plausible wrong answer.
- **Bounded scanning.** File count, file size, header length, attribute length, and directory depth
  are all capped, and reaching a cap is reported rather than silently truncating the scan.
- **Atomic writes.** Files are written to a temporary file in the same directory and moved into
  place, so an interrupted run never leaves a half-written chapter.
