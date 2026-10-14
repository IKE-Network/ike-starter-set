# The CQL test suite as ELM fixtures

The files under `elm/` are the Clinical Quality Language test suite, translated once to
ELM. HL7's ELM is the Expression Logical Model of the Clinical Quality Language
specification, and not Elm, the programming language for browser user interfaces.

- **Source.** https://github.com/cqframework/cql-tests, `tests/cql/*.xml`, at commit
  `f591d9ee8daa09f31a57c9a0b728e1e00b70285e` (2026-09-19), under the Apache License 2.0.
  Sixteen files, 1,830 tests, each a CQL expression with its expected result.
- **What was made of them.** `suite-to-cql.py` writes one CQL library per file under
  `cql/`: each test becomes two definitions, its expression and, as `<name>_expected`, its
  expected result, so that the gate evaluates both and compares the values. `manifest.json`
  lists every test with its file, group, expression, expected result, and, where the suite
  marks it, `invalid` (40 tests that must not translate), or `untranslated` (11 tests the
  pinned translator refuses, with the translator's own words: one uses the `timezone`
  keyword of CQL 1.3, ten call `Slice`, which is not a CQL operator).
- **The translation.** The translator project's Java line, `info.cqframework:cql-to-elm-cli`
  3.29.0, with its dependencies resolved by Maven from this scratch POM:

  ```xml
  <project xmlns="http://maven.apache.org/POM/4.0.0">
    <modelVersion>4.0.0</modelVersion>
    <groupId>scratch</groupId><artifactId>translator-run</artifactId><version>1</version>
    <dependencies>
      <dependency><groupId>info.cqframework</groupId><artifactId>cql-to-elm-cli</artifactId><version>3.29.0</version></dependency>
    </dependencies>
  </project>
  ```

  and run as:

  ```bash
  python3 suite-to-cql.py <cql-tests checkout>/tests/cql cql
  mvn -q dependency:build-classpath -Dmdep.outputFile=cp.txt
  java -cp "$(cat cp.txt)" org.cqframework.cql.cql2elm.cli.Main --input cql --output elm --format JSON
  ```

  The translator is a tool run once; it is not a dependency of any build. Its output is
  kept as written, annotations included; the library importer sets annotations aside.
- **Why they are here.** They are the oracle of the evaluation gate
  (IKE-Network/ike-issues#1116): for each family, the gate counts the tests whose value
  equals the expected result's by IKE's own equality, the tests refused because a node kind
  has no checked relation yet, and the tests recorded under a relation that admits a
  reading different from the suite's.
