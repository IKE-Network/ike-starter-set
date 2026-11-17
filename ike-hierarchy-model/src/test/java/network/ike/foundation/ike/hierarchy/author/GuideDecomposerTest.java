package network.ike.foundation.ike.hierarchy.author;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import network.ike.foundation.ike.hierarchy.model.ChapterId;
import network.ike.foundation.ike.hierarchy.scan.HeaderParseResult;
import network.ike.foundation.ike.hierarchy.scan.HeaderParser;
import network.ike.foundation.ike.hierarchy.scan.ScanLimits;

/**
 * Verifies the migration of a guide whose chapters are written inline.
 *
 * <p>The listing-block cases carry the most weight. A documentation guide is full of AsciiDoc
 * shown as example markup, and splitting the document at one of those would silently cut a chapter
 * in half.
 */
class GuideDecomposerTest {

    private static final List<String> GUIDE = List.of(
            "= Ike Starter Set",
            ":toc: left",
            ":sectnums:",
            "",
            "Preamble prose that stays in the guide.",
            "",
            "[preface]",
            "== How to Read This Guide",
            "",
            "=== The Identicon",
            "",
            "Identicon prose.",
            "",
            "== Language Concepts",
            "",
            "Prose about language.",
            "",
            "[source,asciidoc]",
            "----",
            "== A heading shown as example markup",
            "----",
            "",
            "== Default Values",
            "",
            "Prose about defaults.");

    private static Decomposition decompose() {
        return GuideDecomposer.decompose(GUIDE, new ChapterId("ike-guide"), "chapters");
    }

    @Test
    void shouldCarveOneChapterPerTopLevelSection() {
        assertThat(decompose().chapters()).extracting(chapter -> chapter.header().id().value())
                .containsExactly("how-to-read-this-guide", "language-concepts", "default-values");
    }

    @Test
    void shouldSpaceSortKeysSoAChapterCanBeInsertedBetweenTwo() {
        assertThat(decompose().chapters()).extracting(chapter -> chapter.header().order())
                .containsExactly(100, 200, 300);
    }

    @Test
    void shouldPlaceChapterFilesInTheRequestedSubdirectory() {
        assertThat(decompose().chapters()).extracting(DecomposedChapter::relativePath)
                .containsExactly("chapters/how-to-read-this-guide.adoc",
                        "chapters/language-concepts.adoc",
                        "chapters/default-values.adoc");
    }

    @Test
    void shouldPromoteHeadingsSoEachChapterStartsAtLevelOne() {
        List<String> first = decompose().chapters().get(0).lines();

        assertThat(first).contains("= How to Read This Guide", "== The Identicon");
    }

    @Test
    void shouldCarryBlockAttributesAcrossWithTheHeadingTheyBelongTo() {
        List<String> first = decompose().chapters().get(0).lines();

        assertThat(first).contains("[preface]");
        assertThat(decompose().guideLines()).doesNotContain("[preface]");
    }

    @Test
    void shouldNotSplitAtAHeadingInsideAListingBlock() {
        Decomposition result = decompose();

        assertThat(result.chapters()).noneMatch(
                chapter -> chapter.header().displayTitle().contains("example markup"));
    }

    @Test
    void shouldNotPromoteAHeadingInsideAListingBlock() {
        List<String> languageChapter = decompose().chapters().get(1).lines();

        assertThat(languageChapter).contains("== A heading shown as example markup");
    }

    @Test
    void shouldLeaveTheGuideAsAHeaderAPreambleAndOneDirective() {
        List<String> guide = decompose().guideLines();

        assertThat(guide).contains(":chapter-id: ike-guide", ":chapter-root:");
        assertThat(guide).contains(":toc: left", "Preamble prose that stays in the guide.");
        assertThat(guide).contains("include::hierarchy:ike-guide[]");
        assertThat(guide).doesNotContain("== Language Concepts", "Prose about defaults.");
    }

    @Test
    void shouldProduceChapterFilesTheScannerWillRecognise() {
        for (DecomposedChapter chapter : decompose().chapters()) {
            HeaderParseResult result = HeaderParser.parse(chapter.lines(), ScanLimits.defaults());

            assertThat(result).isInstanceOf(HeaderParseResult.Parsed.class);
            assertThat(((HeaderParseResult.Parsed) result).header().parent())
                    .contains(new ChapterId("ike-guide"));
        }
    }

    @Test
    void shouldProduceAGuideTheScannerRecognisesAsARoot() {
        HeaderParseResult result =
                HeaderParser.parse(decompose().guideLines(), ScanLimits.defaults());

        assertThat(result).isInstanceOf(HeaderParseResult.Parsed.class);
        assertThat(((HeaderParseResult.Parsed) result).header().root()).isTrue();
    }

    @Test
    void shouldGiveCollidingTitlesDistinctIdentifiers() {
        List<String> guide = List.of("= Book", "", "== Overview", "One.", "", "== Overview", "Two.");

        Decomposition result = GuideDecomposer.decompose(guide, new ChapterId("book"), "");

        assertThat(result.chapters()).extracting(chapter -> chapter.header().id().value())
                .containsExactly("overview", "overview-2");
    }

    @Test
    void shouldPlaceChaptersBesideTheGuideWhenNoSubdirectoryIsGiven() {
        Decomposition result = GuideDecomposer.decompose(GUIDE, new ChapterId("ike-guide"), "");

        assertThat(result.chapters().get(0).relativePath()).isEqualTo("how-to-read-this-guide.adoc");
    }
}
