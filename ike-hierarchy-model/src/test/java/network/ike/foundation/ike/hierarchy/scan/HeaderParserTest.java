package network.ike.foundation.ike.hierarchy.scan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import network.ike.foundation.ike.hierarchy.model.ChapterHeader;
import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.ChapterStatus;

/** Verifies how a file declares itself a chapter, and how it fails to. */
class HeaderParserTest {

    private static final ScanLimits LIMITS = ScanLimits.defaults();

    private static ChapterHeader parsed(List<String> lines) {
        HeaderParseResult result = HeaderParser.parse(lines, LIMITS);
        assertThat(result).isInstanceOf(HeaderParseResult.Parsed.class);
        return ((HeaderParseResult.Parsed) result).header();
    }

    @Test
    void shouldReadACompleteDeclaration() {
        ChapterHeader header = parsed(List.of(
                ":chapter-id: cql",
                ":chapter-title: CQL in Komet",
                ":chapter-parent: ike-guide",
                ":chapter-order: 250",
                ":chapter-status: draft",
                "",
                "= Something Else"));

        assertThat(header.id()).isEqualTo(new ChapterId("cql"));
        assertThat(header.title()).contains("CQL in Komet");
        assertThat(header.parent()).contains(new ChapterId("ike-guide"));
        assertThat(header.order()).isEqualTo(250);
        assertThat(header.status()).isEqualTo(ChapterStatus.DRAFT);
        assertThat(header.root()).isFalse();
    }

    @Test
    void shouldFallBackToTheFilesOwnHeadingForTheTitle() {
        ChapterHeader header = parsed(List.of(
                ":chapter-id: cql", ":chapter-parent: ike-guide", "", "= CQL in Komet"));

        assertThat(header.title()).contains("CQL in Komet");
    }

    @Test
    void shouldApplyDefaultsForOrderAndStatus() {
        ChapterHeader header = parsed(List.of(":chapter-id: cql", ":chapter-parent: ike-guide"));

        assertThat(header.order()).isEqualTo(ChapterHeader.DEFAULT_ORDER);
        assertThat(header.status()).isEqualTo(ChapterStatus.DEFAULT);
    }

    @Test
    void shouldReadAValuelessRootMarker() {
        ChapterHeader header = parsed(List.of(":chapter-id: ike-guide", ":chapter-root:"));

        assertThat(header.root()).isTrue();
        assertThat(header.parent()).isEmpty();
    }

    @Test
    void shouldTreatAFileWithNoIdentifierAsNotAChapter() {
        HeaderParseResult result = HeaderParser.parse(
                List.of("= An Ordinary Fragment", "", "Prose."), LIMITS);

        assertThat(result).isInstanceOf(HeaderParseResult.NotAChapter.class);
    }

    @Test
    void shouldIgnoreOtherDocumentAttributes() {
        ChapterHeader header = parsed(List.of(
                ":toc: left", ":sectnums:", ":chapter-id: cql", ":chapter-parent: ike-guide"));

        assertThat(header.id()).isEqualTo(new ChapterId("cql"));
    }

    @Test
    void shouldToleratePrecedingCommentsAndBlankLines() {
        ChapterHeader header = parsed(List.of(
                "// A note for the author", "", ":chapter-id: cql", ":chapter-parent: ike-guide"));

        assertThat(header.id()).isEqualTo(new ChapterId("cql"));
    }

    @Test
    void shouldNotReadAttributesOutOfTheDocumentBody() {
        HeaderParseResult result = HeaderParser.parse(List.of(
                "= Ordinary Document", "", "Prose that stops the header.",
                "", ":chapter-id: sneaky"), LIMITS);

        assertThat(result).isInstanceOf(HeaderParseResult.NotAChapter.class);
    }

    @Test
    void shouldNotReadAttributesOutOfAListingBlock() {
        HeaderParseResult result = HeaderParser.parse(List.of(
                "----", ":chapter-id: sneaky", "----"), LIMITS);

        assertThat(result).isInstanceOf(HeaderParseResult.NotAChapter.class);
    }

    @Test
    void shouldReportAMalformedDeclarationRatherThanIgnoringIt() {
        // The distinction that matters: this file meant to be a chapter, so it must fail the
        // build rather than quietly not appearing in the guide.
        assertThat(HeaderParser.parse(List.of(":chapter-id: Not Valid"), LIMITS))
                .isInstanceOf(HeaderParseResult.Malformed.class);
        assertThat(HeaderParser.parse(
                List.of(":chapter-id: ok", ":chapter-order: soon"), LIMITS))
                .isInstanceOf(HeaderParseResult.Malformed.class);
        assertThat(HeaderParser.parse(
                List.of(":chapter-id: ok", ":chapter-status: nearly"), LIMITS))
                .isInstanceOf(HeaderParseResult.Malformed.class);
        assertThat(HeaderParser.parse(
                List.of(":chapter-id: ok", ":chapter-parent: Not Valid"), LIMITS))
                .isInstanceOf(HeaderParseResult.Malformed.class);
    }

    @Test
    void shouldRejectAChapterThatIsBothARootAndPlaced() {
        assertThat(HeaderParser.parse(
                List.of(":chapter-id: ok", ":chapter-root:", ":chapter-parent: guide"), LIMITS))
                .isInstanceOf(HeaderParseResult.Malformed.class);
    }

    @Test
    void shouldRejectAValueLongerThanTheBound() {
        assertThat(HeaderParser.parse(
                List.of(":chapter-id: ok", ":chapter-title: " + "x".repeat(1000)), LIMITS))
                .isInstanceOf(HeaderParseResult.Malformed.class);
    }

    @Test
    void shouldNotReadPastTheHeaderLineBound() {
        ScanLimits tight = new ScanLimits(10, 1024, 3, 100, 4, java.util.Set.of());
        List<String> lines = List.of("", "", "", ":chapter-id: too-late");

        assertThat(HeaderParser.parse(lines, tight))
                .isInstanceOf(HeaderParseResult.NotAChapter.class);
    }

    @Test
    void shouldStripAByteOrderMarkSoTheFirstAttributeStillMatches() {
        ChapterHeader header = parsed(List.of("\uFEFF:chapter-id: cql", ":chapter-parent: guide"));

        assertThat(header.id()).isEqualTo(new ChapterId("cql"));
        assertThat(Optional.of(header.status())).contains(ChapterStatus.PUBLISHED);
    }
}
