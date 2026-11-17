package network.ike.foundation.ike.hierarchy.index;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import network.ike.foundation.ike.hierarchy.model.Chapter;
import network.ike.foundation.ike.hierarchy.model.ChapterHeader;
import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.ChapterStatus;
import network.ike.foundation.ike.hierarchy.model.Hierarchy;
import network.ike.foundation.ike.hierarchy.model.HierarchyResult;
import network.ike.foundation.ike.hierarchy.model.HierarchyValidator;

/** Verifies that an index survives a write and a read unchanged, and that a bad one is refused. */
class IndexCodecTest {

    private static Hierarchy sampleHierarchy() {
        List<Chapter> chapters = List.of(
                new Chapter(ChapterHeader.root(new ChapterId("guide")), "guide.adoc", "docs"),
                new Chapter(new ChapterHeader(new ChapterId("cql"), Optional.of("CQL in Komet"),
                        Optional.of(new ChapterId("guide")), 250, ChapterStatus.PUBLISHED, false),
                        "cql/overview.adoc", "docs"),
                new Chapter(new ChapterHeader(new ChapterId("keywords"), Optional.of("Keywords"),
                        Optional.of(new ChapterId("cql")), 10, ChapterStatus.DRAFT, false),
                        "cql/keywords.adoc", "docs"));

        HierarchyResult result = HierarchyValidator.validate(chapters);
        return ((HierarchyResult.Valid) result).hierarchy();
    }

    private static HierarchyIndex sampleIndex() {
        return HierarchyIndex.from(sampleHierarchy(),
                List.of(new IndexedRoot("docs", "ike-doc/src/docs/asciidoc")), 5);
    }

    private static final String ROOT = "{\"id\": \"docs\", \"path\": \"docs\"}";

    private static final String CHAPTER = "{\"id\": \"a\", \"title\": \"A\", \"parent\": null,"
            + " \"order\": 1, \"status\": \"draft\", \"root\": true, \"depth\": 0,"
            + " \"rootId\": \"docs\", \"path\": \"a.adoc\"}";

    /**
     * Assembles an index document from raw root and chapter fragments.
     *
     * @param roots    the contents of the roots array
     * @param chapters the contents of the chapters array
     * @return a complete index document
     */
    private static String index(String roots, String chapters) {
        return "{\"schema\": \"ike-hierarchy-index/1\", \"maxDepth\": 5, \"roots\": ["
                + roots + "], \"chapters\": [" + chapters + "]}";
    }

    /**
     * Produces a chapter fragment with one field replaced.
     *
     * @param from the exact text to replace
     * @param to   its replacement
     * @return the altered chapter fragment
     */
    private static String chapter(String from, String to) {
        return CHAPTER.replace(from, to);
    }

    @Test
    void shouldSurviveARoundTripUnchanged() {
        HierarchyIndex index = sampleIndex();

        assertThat(IndexCodec.read(IndexCodec.write(index))).isEqualTo(index);
    }

    @Test
    void shouldRenderTheSameBytesForTheSameHierarchy() {
        String first = IndexCodec.write(sampleIndex());
        String second = IndexCodec.write(sampleIndex());

        assertThat(first).isEqualTo(second);
    }

    @Test
    void shouldPreserveDocumentOrderAndDepth() {
        HierarchyIndex index = sampleIndex();

        assertThat(index.chapters()).extracting(entry -> entry.id().value())
                .containsExactly("guide", "cql", "keywords");
        assertThat(index.chapters()).extracting(IndexedChapter::depth).containsExactly(0, 1, 2);
    }

    @Test
    void shouldAnswerSubtreeQueriesWithoutRebuildingATree() {
        HierarchyIndex index = sampleIndex();

        assertThat(index.descendantsOf(new ChapterId("guide")))
                .extracting(entry -> entry.id().value()).containsExactly("cql", "keywords");
        assertThat(index.descendantsOf(new ChapterId("cql")))
                .extracting(entry -> entry.id().value()).containsExactly("keywords");
        assertThat(index.descendantsOf(new ChapterId("keywords"))).isEmpty();
        assertThat(index.descendantsOf(new ChapterId("unknown"))).isEmpty();
    }

    @Test
    void shouldNotBeConfusedByPunctuationInsideStringValues() {
        // A title containing a bracket and a brace is exactly what defeats a pattern-matching
        // reader: it finds the wrong end of the array, or the wrong end of the string.
        String document = """
                { "schema": "ike-hierarchy-index/1", "maxDepth": 5,
                  "roots": [ { "id": "docs", "path": "docs" } ],
                  "chapters": [ { "id": "tricky", "title": "A ] } \\" title", "parent": null,
                                  "order": 1, "status": "draft", "root": true, "depth": 0,
                                  "rootId": "docs", "path": "t.adoc" } ] }
                """;

        HierarchyIndex index = IndexCodec.read(document);

        assertThat(index.chapters()).hasSize(1);
        assertThat(index.chapters().get(0).title()).isEqualTo("A ] } \" title");
    }

    @Test
    void shouldRefuseAnIndexWrittenByADifferentSchema() {
        assertThatThrownBy(() -> IndexCodec.read(
                "{\"schema\":\"something-else/2\",\"maxDepth\":5,\"roots\":[],\"chapters\":[]}"))
                .isInstanceOf(JsonException.class)
                .hasMessageContaining("ike-hierarchy:index");
    }

    @Test
    void shouldRefuseAnIndexWhoseChapterPathEscapesItsRoot() {
        String document = """
                { "schema": "ike-hierarchy-index/1", "maxDepth": 5,
                  "roots": [ { "id": "docs", "path": "docs" } ],
                  "chapters": [ { "id": "escape", "title": "Escape", "parent": null,
                                  "order": 1, "status": "draft", "root": true, "depth": 0,
                                  "rootId": "docs", "path": "../../../etc/passwd" } ] }
                """;

        assertThatThrownBy(() -> IndexCodec.read(document)).isInstanceOf(JsonException.class);
    }

    @Test
    void shouldReportEveryMalformedIndexAsAJsonException() {
        // Not a style preference. ResolvedIndex in the Asciidoctor extension catches IOException
        // and JsonException and nothing else, so any other exception type escaping this method
        // surfaces as an unhandled failure out of the include processor rather than a legible
        // warning in the build log. An earlier version leaked IllegalArgumentException from
        // IndexedRoot's constructor for exactly this reason.
        List<String> malformed = List.of(
                index("{\"id\": \"docs\", \"path\": \"/etc\"}", ""),
                index("{\"id\": \"docs\", \"path\": \"../../etc\"}", ""),
                index("{\"id\": \"\", \"path\": \"docs\"}", ""),
                index("{\"id\": \"docs\"}", ""),
                index("\"not-an-object\"", ""),
                index(ROOT, chapter("\"path\": \"a.adoc\"", "\"path\": \"/etc/passwd\"")),
                index(ROOT, chapter("\"path\": \"a.adoc\"", "\"path\": \"../../etc/passwd\"")),
                index(ROOT, chapter("\"id\": \"a\"", "\"id\": \"Not Valid\"")),
                index(ROOT, chapter("\"status\": \"draft\"", "\"status\": \"nearly\"")),
                index(ROOT, chapter("\"depth\": 0", "\"depth\": -1")),
                index(ROOT, chapter("\"order\": 1", "\"order\": 99999999999999")),
                index(ROOT, "42"));

        for (String document : malformed) {
            assertThatThrownBy(() -> IndexCodec.read(document))
                    .as("should have been refused as a JsonException: %s", document)
                    .isInstanceOf(JsonException.class);
        }
    }

    @Test
    void shouldStillAcceptAWellFormedIndex() {
        HierarchyIndex index = IndexCodec.read(index(ROOT, CHAPTER));

        assertThat(index.roots()).hasSize(1);
        assertThat(index.chapters()).hasSize(1);
    }

    @Test
    void shouldRefuseAnIndexWithAnAbsoluteRootPath() {
        String document = """
                { "schema": "ike-hierarchy-index/1", "maxDepth": 5,
                  "roots": [ { "id": "docs", "path": "/etc" } ], "chapters": [] }
                """;

        assertThatThrownBy(() -> IndexCodec.read(document)).isInstanceOf(JsonException.class);
    }
}
