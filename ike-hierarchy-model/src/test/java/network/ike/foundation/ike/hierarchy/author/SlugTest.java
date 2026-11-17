package network.ike.foundation.ike.hierarchy.author;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.Test;

import network.ike.foundation.ike.hierarchy.model.ChapterId;

/** Verifies identifier derivation from headings and file names. */
class SlugTest {

    @Test
    void shouldDeriveAKebabCaseIdentifierFromATitle() {
        assertThat(Slug.from("Getting Started with CQL")).contains(new ChapterId("getting-started-with-cql"));
        assertThat(Slug.from("Section #1: Overview & Rules!")).contains(new ChapterId("section-1-overview-rules"));
        assertThat(Slug.from("  EL++ Concepts  ")).contains(new ChapterId("el-concepts"));
    }

    @Test
    void shouldStripAccentsRatherThanDroppingTheLetters() {
        assertThat(Slug.from("Coördinates")).contains(new ChapterId("coordinates"));
    }

    @Test
    void shouldReturnEmptyWhenNothingUsableRemains() {
        assertThat(Slug.from("!!!")).isEmpty();
        assertThat(Slug.from("   ")).isEmpty();
        assertThat(Slug.from(null)).isEmpty();
    }

    @Test
    void shouldTruncateRatherThanProduceAnOverlongIdentifier() {
        assertThat(Slug.from("word ".repeat(60))).isPresent();
    }

    @Test
    void shouldAvoidCollidingWithIdentifiersAlreadyTaken() {
        Set<ChapterId> taken = Set.of(new ChapterId("overview"), new ChapterId("overview-2"));

        assertThat(Slug.unique("Overview", taken)).contains(new ChapterId("overview-3"));
    }

    @Test
    void shouldReturnTheBaseIdentifierWhenItIsFree() {
        assertThat(Slug.unique("Overview", Set.of())).contains(new ChapterId("overview"));
    }
}
