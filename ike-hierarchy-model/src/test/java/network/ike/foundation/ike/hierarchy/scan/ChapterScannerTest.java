package network.ike.foundation.ike.hierarchy.scan;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import network.ike.foundation.ike.hierarchy.model.Chapter;
import network.ike.foundation.ike.hierarchy.model.Violation;

/**
 * Verifies discovery: what counts as a chapter, where the scanner will and will not look, and what
 * it refuses to read.
 */
class ChapterScannerTest {

    @TempDir
    Path temp;

    private void write(String relativePath, String content) throws IOException {
        Path file = temp.resolve(relativePath);
        Files.createDirectories(file.getParent());
        Files.writeString(file, content);
    }

    private ScanOutcome scan() {
        return ChapterScanner.scan(List.of(new ScanRoot("docs", temp)), ScanLimits.defaults());
    }

    @Test
    void shouldFindAChapterAnywhereBeneathTheRoot() throws IOException {
        write("a/very/deeply/nested/place/chapter.adoc",
                ":chapter-id: buried\n:chapter-parent: guide\n\n= Buried\n");

        ScanOutcome outcome = scan();

        assertThat(outcome.chapters()).hasSize(1);
        assertThat(outcome.chapters().get(0).relativePath())
                .isEqualTo("a/very/deeply/nested/place/chapter.adoc");
        assertThat(outcome.violations()).isEmpty();
    }

    @Test
    void shouldIgnoreAsciiDocFilesThatDeclareNoChapter() throws IOException {
        write("fragment.adoc", "= Just a fragment\n\nIncluded by hand.\n");
        write("README.md", ":chapter-id: not-asciidoc\n");

        assertThat(scan().chapters()).isEmpty();
    }

    @Test
    void shouldNotDescendIntoBuildOutput() throws IOException {
        write("chapter.adoc", ":chapter-id: real\n:chapter-parent: guide\n");
        write("target/classes/chapter.adoc", ":chapter-id: copied\n:chapter-parent: guide\n");
        write("node_modules/thing/chapter.adoc", ":chapter-id: vendored\n:chapter-parent: guide\n");

        assertThat(scan().chapters()).extracting(chapter -> chapter.id().value())
                .containsExactly("real");
    }

    @Test
    void shouldOrderResultsDeterministicallyRatherThanByFilesystemOrder() throws IOException {
        write("z.adoc", ":chapter-id: zulu\n:chapter-parent: guide\n");
        write("a.adoc", ":chapter-id: alpha\n:chapter-parent: guide\n");
        write("m.adoc", ":chapter-id: mike\n:chapter-parent: guide\n");

        assertThat(scan().chapters()).extracting(Chapter::relativePath)
                .containsExactly("a.adoc", "m.adoc", "z.adoc");
    }

    @Test
    void shouldReportAMalformedChapterRatherThanSkippingIt() throws IOException {
        write("broken.adoc", ":chapter-id: Not Valid\n");

        ScanOutcome outcome = scan();

        assertThat(outcome.chapters()).isEmpty();
        assertThat(outcome.violations()).hasOnlyElementsOfType(Violation.MalformedHeader.class);
    }

    @Test
    void shouldRefuseAndReportAFileReachedThroughAnEscapingSymbolicLink() throws IOException {
        Path outside = temp.getParent().resolve("outside-" + temp.getFileName() + ".adoc");
        Files.writeString(outside, ":chapter-id: secret\n:chapter-parent: guide\n");
        try {
            Files.createSymbolicLink(temp.resolve("innocent.adoc"), outside);
        } catch (UnsupportedOperationException | IOException unsupported) {
            return; // Symbolic links are unavailable on this filesystem.
        }

        ScanOutcome outcome = scan();

        assertThat(outcome.chapters()).isEmpty();
        assertThat(outcome.violations()).hasOnlyElementsOfType(Violation.EscapesRoot.class);
        Files.deleteIfExists(outside);
    }

    @Test
    void shouldReportRatherThanSilentlyTruncateWhenTheFileCapIsReached() throws IOException {
        for (int i = 0; i < 5; i++) {
            write("chapter-" + i + ".adoc", ":chapter-id: c" + i + "\n:chapter-parent: guide\n");
        }
        ScanLimits tight = new ScanLimits(2, 1024 * 1024, 200, 500, 8, java.util.Set.of());

        ScanOutcome outcome = ChapterScanner.scan(List.of(new ScanRoot("docs", temp)), tight);

        assertThat(outcome.violations()).hasOnlyElementsOfType(Violation.ScanLimitExceeded.class);
    }

    @Test
    void shouldRecordWhichRootAChapterCameFromSoPathsCanBeReanchored() throws IOException {
        write("one/chapter.adoc", ":chapter-id: first\n:chapter-parent: guide\n");
        write("two/chapter.adoc", ":chapter-id: second\n:chapter-parent: guide\n");

        ScanOutcome outcome = ChapterScanner.scan(List.of(
                new ScanRoot("one", temp.resolve("one")),
                new ScanRoot("two", temp.resolve("two"))), ScanLimits.defaults());

        assertThat(outcome.chapters()).extracting(Chapter::rootId).containsExactly("one", "two");
        assertThat(outcome.chapters()).extracting(Chapter::relativePath)
                .containsExactly("chapter.adoc", "chapter.adoc");
    }

    @Test
    void shouldSkipARootThatDoesNotExistRatherThanFailing() {
        ScanOutcome outcome = ChapterScanner.scan(
                List.of(new ScanRoot("missing", temp.resolve("nowhere"))), ScanLimits.defaults());

        assertThat(outcome.chapters()).isEmpty();
        assertThat(outcome.violations()).isEmpty();
    }
}
