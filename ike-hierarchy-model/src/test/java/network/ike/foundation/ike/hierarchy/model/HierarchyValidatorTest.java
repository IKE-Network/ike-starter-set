package network.ike.foundation.ike.hierarchy.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Verifies the rules that decide whether a set of chapters forms a usable book.
 *
 * <p>These are the rules a broken build depends on catching, so each defect gets its own case: a
 * chapter that cannot be placed must fail loudly rather than disappear from the guide.
 */
class HierarchyValidatorTest {

    private static ChapterHeader placed(String id, String parent, int order) {
        return new ChapterHeader(new ChapterId(id), Optional.empty(),
                Optional.of(new ChapterId(parent)), order, ChapterStatus.PUBLISHED, false);
    }

    private static Chapter chapter(ChapterHeader header, String path) {
        return new Chapter(header, path, "docs");
    }

    private static Chapter root(String id) {
        return chapter(ChapterHeader.root(new ChapterId(id)), id + ".adoc");
    }

    private static List<String> idsInOrder(HierarchyResult result) {
        return ((HierarchyResult.Valid) result).hierarchy().inDocumentOrder()
                .stream().map(node -> node.id().value()).toList();
    }

    @Nested
    class WhenTheHierarchyIsWellFormed {

        @Test
        void shouldPlaceChaptersInDeclaredOrderBeneathTheirParents() {
            HierarchyResult result = HierarchyValidator.validate(List.of(
                    root("guide"),
                    chapter(placed("second", "guide", 200), "b.adoc"),
                    chapter(placed("first", "guide", 100), "a.adoc"),
                    chapter(placed("nested", "first", 10), "c.adoc")));

            assertThat(result).isInstanceOf(HierarchyResult.Valid.class);
            assertThat(idsInOrder(result)).containsExactly("guide", "first", "nested", "second");
        }

        @Test
        void shouldRecordDepthSoRenderingNeedNotRederiveIt() {
            HierarchyResult result = HierarchyValidator.validate(List.of(
                    root("guide"),
                    chapter(placed("child", "guide", 1), "a.adoc"),
                    chapter(placed("grandchild", "child", 1), "b.adoc")));

            Hierarchy hierarchy = ((HierarchyResult.Valid) result).hierarchy();
            assertThat(hierarchy.node(new ChapterId("guide")).orElseThrow().depth()).isEqualTo(0);
            assertThat(hierarchy.node(new ChapterId("child")).orElseThrow().depth()).isEqualTo(1);
            assertThat(hierarchy.node(new ChapterId("grandchild")).orElseThrow().depth()).isEqualTo(2);
        }

        @Test
        void shouldBreakOrderTiesOnIdentifierSoBuildsAreReproducible() {
            HierarchyResult result = HierarchyValidator.validate(List.of(
                    root("guide"),
                    chapter(placed("zebra", "guide", 500), "z.adoc"),
                    chapter(placed("apple", "guide", 500), "a.adoc")));

            assertThat(idsInOrder(result)).containsExactly("guide", "apple", "zebra");
        }

        @Test
        void shouldSupportSeveralIndependentRoots() {
            HierarchyResult result = HierarchyValidator.validate(List.of(
                    root("guide"), root("appendix"),
                    chapter(placed("intro", "guide", 1), "i.adoc"),
                    chapter(placed("tables", "appendix", 1), "t.adoc")));

            assertThat(idsInOrder(result)).containsExactly("appendix", "tables", "guide", "intro");
        }

        @Test
        void shouldAcceptAnEmptyProject() {
            HierarchyResult result = HierarchyValidator.validate(List.of());
            assertThat(result).isInstanceOf(HierarchyResult.Valid.class);
            assertThat(((HierarchyResult.Valid) result).hierarchy().roots()).isEmpty();
        }
    }

    @Nested
    class WhenTheHierarchyIsBroken {

        @Test
        void shouldRejectTwoFilesClaimingOneIdentifier() {
            HierarchyResult result = HierarchyValidator.validate(List.of(
                    root("guide"),
                    chapter(placed("same", "guide", 1), "first.adoc"),
                    chapter(placed("same", "guide", 2), "second.adoc")));

            assertThat(result.violations()).hasOnlyElementsOfType(Violation.DuplicateId.class);
            assertThat(result.report()).contains("first.adoc").contains("second.adoc");
        }

        @Test
        void shouldRejectAParentThatNoFileDeclares() {
            HierarchyResult result = HierarchyValidator.validate(List.of(
                    root("guide"), chapter(placed("lost", "missing", 1), "lost.adoc")));

            assertThat(result.violations()).hasOnlyElementsOfType(Violation.DanglingParent.class);
            assertThat(result.report()).contains("missing");
        }

        @Test
        void shouldRejectAChapterWithNeitherAParentNorARootMarker() {
            Chapter orphan = chapter(new ChapterHeader(new ChapterId("free"), Optional.empty(),
                    Optional.empty(), 1, ChapterStatus.PUBLISHED, false), "free.adoc");

            HierarchyResult result = HierarchyValidator.validate(List.of(root("guide"), orphan));
            assertThat(result.violations()).hasOnlyElementsOfType(Violation.Orphan.class);
        }

        @Test
        void shouldReportACycleOnceHoweverManyChaptersLeadIntoIt() {
            HierarchyResult result = HierarchyValidator.validate(List.of(
                    root("guide"),
                    chapter(placed("x", "y", 1), "x.adoc"),
                    chapter(placed("y", "z", 1), "y.adoc"),
                    chapter(placed("z", "x", 1), "z.adoc"),
                    chapter(placed("into", "x", 1), "into.adoc")));

            List<Violation> cycles = result.violations().stream()
                    .filter(violation -> violation instanceof Violation.Cycle).toList();
            assertThat(cycles).hasSize(1);
        }

        @Test
        void shouldRejectNestingDeeperThanAsciiDocCanRender() {
            List<Chapter> chapters = new ArrayList<>();
            chapters.add(root("guide"));
            String parent = "guide";
            for (int level = 1; level <= 7; level++) {
                chapters.add(chapter(placed("level-" + level, parent, 1), "l" + level + ".adoc"));
                parent = "level-" + level;
            }

            HierarchyResult result = HierarchyValidator.validate(chapters, 5);
            assertThat(result.violations().stream()
                    .anyMatch(violation -> violation instanceof Violation.DepthExceeded)).isTrue();
        }

        @Test
        void shouldOfferNoHierarchyAtAllWhenAnythingIsWrong() {
            HierarchyResult result = HierarchyValidator.validate(List.of(
                    root("guide"),
                    chapter(placed("fine", "guide", 1), "fine.adoc"),
                    chapter(placed("broken", "missing", 1), "broken.adoc")));

            assertThat(result).isInstanceOf(HierarchyResult.Invalid.class);
        }

        @Test
        void shouldReportEveryDefectRatherThanStoppingAtTheFirst() {
            HierarchyResult result = HierarchyValidator.validate(List.of(
                    root("guide"),
                    chapter(placed("a", "nowhere", 1), "a.adoc"),
                    chapter(placed("b", "elsewhere", 1), "b.adoc"),
                    chapter(placed("c", "nohow", 1), "c.adoc")));

            assertThat(result.violations()).hasSize(3);
        }
    }
}
