package network.ike.foundation.ike.hierarchy.author;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import network.ike.foundation.ike.hierarchy.model.ChapterHeader;
import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.model.ChapterStatus;
import network.ike.foundation.ike.hierarchy.scan.HeaderParseResult;
import network.ike.foundation.ike.hierarchy.scan.HeaderParser;
import network.ike.foundation.ike.hierarchy.scan.ScanLimits;

/**
 * Verifies the one command's only side effect: a few attribute lines at the top of a file the
 * author already owns.
 */
class HeaderStamperTest {

    private static ChapterHeader placed(String id, String parent, int order) {
        return new ChapterHeader(new ChapterId(id), Optional.empty(),
                Optional.of(new ChapterId(parent)), order, ChapterStatus.PUBLISHED, false);
    }

    @Test
    void shouldAddADeclarationToAFileThatHasNone() {
        StampOutcome outcome = HeaderStamper.stamp(
                List.of("= My Draft", "", "Prose."), placed("my-draft", "ike-guide", 250));

        assertThat(outcome.changed()).isTrue();
        assertThat(outcome.lines()).contains(
                ":chapter-id: my-draft", ":chapter-parent: ike-guide", ":chapter-order: 250");
        assertThat(outcome.lines()).contains("= My Draft", "Prose.");
    }

    @Test
    void shouldLeaveAFileUntouchedWhenItAlreadyDeclaresThatPlacement() {
        ChapterHeader header = placed("my-draft", "ike-guide", 250);
        List<String> once = HeaderStamper.stamp(List.of("= My Draft", "", "Prose."), header).lines();

        StampOutcome twice = HeaderStamper.stamp(once, header);

        assertThat(twice.changed()).isFalse();
        assertThat(twice.lines()).isEqualTo(once);
    }

    @Test
    void shouldRewriteRatherThanAccumulateWhenAChapterMoves() {
        List<String> registered = HeaderStamper.stamp(
                List.of("= My Draft"), placed("my-draft", "ike-guide", 250)).lines();

        StampOutcome moved = HeaderStamper.stamp(registered, placed("my-draft", "appendix", 400));

        assertThat(moved.lines()).contains(":chapter-parent: appendix", ":chapter-order: 400");
        assertThat(moved.lines()).doesNotContain(":chapter-parent: ike-guide", ":chapter-order: 250");
        assertThat(moved.notes()).isNotEmpty();
    }

    @Test
    void shouldDropThePlacementAttributesWhenAFileBecomesARoot() {
        List<String> placed = HeaderStamper.stamp(
                List.of("= Guide"), placed("guide", "book", 100)).lines();

        StampOutcome asRoot = HeaderStamper.stamp(placed, ChapterHeader.root(new ChapterId("guide")));

        assertThat(asRoot.lines()).contains(":chapter-root:");
        assertThat(asRoot.lines()).noneMatch(line -> line.startsWith(":chapter-parent:"));
        assertThat(asRoot.lines()).noneMatch(line -> line.startsWith(":chapter-order:"));
    }

    @Test
    void shouldPreserveOtherDocumentAttributes() {
        StampOutcome outcome = HeaderStamper.stamp(
                List.of("= Guide", ":toc: left", ":sectnums:", "", "Prose."),
                placed("guide", "book", 100));

        assertThat(outcome.lines()).contains(":toc: left", ":sectnums:");
    }

    @Test
    void shouldNotRewriteAnAttributeLookingLineInsideAListingBlock() {
        StampOutcome outcome = HeaderStamper.stamp(
                List.of("= Doc", "", "----", ":chapter-id: not-real", "----"),
                placed("real", "ike-guide", 1));

        assertThat(outcome.lines()).contains(":chapter-id: not-real", ":chapter-id: real");
    }

    @Test
    void shouldProduceADeclarationTheParserReadsBack() {
        ChapterHeader header = placed("my-draft", "ike-guide", 250);
        List<String> lines = HeaderStamper.stamp(List.of("= My Draft"), header).lines();

        HeaderParseResult result = HeaderParser.parse(lines, ScanLimits.defaults());

        assertThat(result).isInstanceOf(HeaderParseResult.Parsed.class);
        ChapterHeader readBack = ((HeaderParseResult.Parsed) result).header();
        assertThat(readBack.id()).isEqualTo(header.id());
        assertThat(readBack.parent()).isEqualTo(header.parent());
        assertThat(readBack.order()).isEqualTo(header.order());
        // No title was written, so it comes from the heading: one place to change it.
        assertThat(readBack.title()).contains("My Draft");
    }

    @Test
    void shouldSeparateTheDeclarationFromTheBodyWithExactlyOneBlankLine() {
        List<String> once = HeaderStamper.stamp(
                List.of("= Draft"), placed("draft", "guide", 1)).lines();
        List<String> twice = HeaderStamper.stamp(once, placed("draft", "guide", 1)).lines();

        assertThat(twice).isEqualTo(once);
    }
}
