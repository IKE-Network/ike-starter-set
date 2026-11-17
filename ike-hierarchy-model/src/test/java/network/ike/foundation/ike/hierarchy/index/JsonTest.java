package network.ike.foundation.ike.hierarchy.index;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Verifies that the parser is strict.
 *
 * <p>These cases exist because the scheme this replaces used regular expressions, which do not
 * fail on malformed input — they return a plausible, wrong answer, and a chapter quietly goes
 * missing. Every rejection below is a document that a pattern match would have happily "parsed".
 */
class JsonTest {

    private static final JsonLimits LIMITS = JsonLimits.defaults();

    @Nested
    class Accepts {

        @Test
        void shouldDecodeEscapeSequencesInStrings() {
            assertThat(((Json.Str) Json.parse("\"a\\\"b\\nc\\u0041\"", LIMITS)).value())
                    .isEqualTo("a\"b\ncA");
        }

        @Test
        void shouldKeepNumbersAsTheirSourceLiteral() {
            assertThat(((Json.Num) Json.parse("250", LIMITS)).asInt()).isEqualTo(250);
            assertThat(((Json.Num) Json.parse("-3", LIMITS)).asInt()).isEqualTo(-3);
            assertThat(((Json.Num) Json.parse("0", LIMITS)).asInt()).isZero();
        }

        @Test
        void shouldPreserveMemberOrderSoOutputIsReproducible() {
            Json.Obj object = (Json.Obj) Json.parse("{\"b\":1,\"a\":2,\"c\":3}", LIMITS);
            assertThat(object.members().keySet().stream().toList()).containsExactly("b", "a", "c");
        }

        @Test
        void shouldHandleEmptyContainers() {
            assertThat(Json.parse("{}", LIMITS)).isInstanceOf(Json.Obj.class);
            assertThat(Json.parse("[]", LIMITS)).isInstanceOf(Json.Arr.class);
        }
    }

    @Nested
    class Rejects {

        private void reject(String document) {
            assertThatThrownBy(() -> Json.parse(document, LIMITS))
                    .as("should have rejected: %s", document)
                    .isInstanceOf(JsonException.class);
        }

        @Test
        void shouldRejectTrailingCommas() {
            reject("{\"a\":1,}");
            reject("[1,]");
        }

        @Test
        void shouldRejectUnquotedKeysAndSingleQuotes() {
            reject("{a:1}");
            reject("{'a':1}");
        }

        @Test
        void shouldRejectMalformedNumbers() {
            reject("01");
            reject("1.");
            reject(".5");
            reject("1e");
        }

        @Test
        void shouldRejectContentAfterTheDocument() {
            reject("{\"a\":1} trailing");
        }

        @Test
        void shouldRejectDuplicateMemberNames() {
            reject("{\"a\":1,\"a\":2}");
        }

        @Test
        void shouldRejectUnterminatedStrings() {
            reject("\"never closed");
        }

        @Test
        void shouldRejectNestingBeyondTheLimitRatherThanOverflowingTheStack() {
            reject("[".repeat(200) + "]".repeat(200));
        }

        @Test
        void shouldRejectADocumentLongerThanTheLimit() {
            JsonLimits tiny = new JsonLimits(8, 4);
            assertThatThrownBy(() -> Json.parse("{\"aaa\":1}", tiny))
                    .isInstanceOf(JsonException.class);
        }
    }
}
