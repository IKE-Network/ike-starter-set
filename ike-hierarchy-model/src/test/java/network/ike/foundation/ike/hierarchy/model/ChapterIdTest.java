package network.ike.foundation.ike.hierarchy.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

/** Verifies the identifier shape that every reference in the system relies on. */
class ChapterIdTest {

    @Test
    void shouldNormaliseCaseSoThatTwoSpellingsAreOneIdentity() {
        assertThat(new ChapterId("CQL").value()).isEqualTo("cql");
        assertThat(new ChapterId("  Getting-Started  ").value()).isEqualTo("getting-started");
    }

    @Test
    void shouldAcceptLowercaseKebabCase() {
        assertThat(ChapterId.parse("cql")).isPresent();
        assertThat(ChapterId.parse("getting-started-with-ike")).isPresent();
        assertThat(ChapterId.parse("section-2")).isPresent();
    }

    @Test
    void shouldRejectShapesThatWouldNotSurviveUseInAnIncludeTarget() {
        assertThat(ChapterId.parse("has space")).isEmpty();
        assertThat(ChapterId.parse("-leading")).isEmpty();
        assertThat(ChapterId.parse("trailing-")).isEmpty();
        assertThat(ChapterId.parse("double--hyphen")).isEmpty();
        assertThat(ChapterId.parse("under_score")).isEmpty();
        assertThat(ChapterId.parse("../escape")).isEmpty();
        assertThat(ChapterId.parse("")).isEmpty();
        assertThat(ChapterId.parse(null)).isEmpty();
    }

    @Test
    void shouldRejectAnIdentifierLongerThanTheBound() {
        assertThat(ChapterId.parse("a".repeat(ChapterId.MAX_LENGTH + 1))).isEmpty();
    }

    @Test
    void shouldThrowRatherThanReturnEmptyWhenConstructedDirectly() {
        assertThatThrownBy(() -> new ChapterId("Not Valid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("kebab-case");
    }
}
