package network.ike.foundation.ike.hierarchy.index;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A strict recursive-descent parser for the JSON subset defined by RFC 8259.
 *
 * <p>Package-private: callers reach it through {@link Json#parse}. It accepts no extensions —
 * no comments, no trailing commas, no unquoted keys — and reports the character offset of the
 * first thing it could not accept.
 */
final class JsonParser {

    private final String text;
    private final JsonLimits limits;
    private int position;
    private int depth;

    JsonParser(String text, JsonLimits limits) {
        if (text == null || limits == null) {
            throw new JsonException("JSON text and limits are both required");
        }
        if (text.length() > limits.maxLength()) {
            throw new JsonException("JSON document exceeds " + limits.maxLength() + " characters");
        }
        this.text = text;
        this.limits = limits;
    }

    /**
     * Parses a complete document and confirms nothing follows it.
     */
    Json parseDocument() {
        skipWhitespace();
        Json value = parseValue();
        skipWhitespace();
        if (position < text.length()) {
            throw error("unexpected trailing content");
        }
        return value;
    }

    private Json parseValue() {
        if (position >= text.length()) {
            throw error("unexpected end of document");
        }
        char c = text.charAt(position);
        return switch (c) {
            case '{' -> parseObject();
            case '[' -> parseArray();
            case '"' -> new Json.Str(parseString());
            case 't' -> parseKeyword("true", new Json.Bool(true));
            case 'f' -> parseKeyword("false", new Json.Bool(false));
            case 'n' -> parseKeyword("null", new Json.Nul());
            default -> parseNumber();
        };
    }

    private Json parseObject() {
        enter();
        expect('{');
        Map<String, Json> members = new LinkedHashMap<>();
        skipWhitespace();
        if (peek() == '}') {
            position++;
            leave();
            return new Json.Obj(members);
        }
        while (true) {
            skipWhitespace();
            if (peek() != '"') {
                throw error("expected a quoted member name");
            }
            String name = parseString();
            skipWhitespace();
            expect(':');
            skipWhitespace();
            if (members.put(name, parseValue()) != null) {
                throw error("duplicate member name '" + name + "'");
            }
            skipWhitespace();
            char next = peek();
            if (next == ',') {
                position++;
                continue;
            }
            if (next == '}') {
                position++;
                leave();
                return new Json.Obj(members);
            }
            throw error("expected ',' or '}'");
        }
    }

    private Json parseArray() {
        enter();
        expect('[');
        List<Json> elements = new ArrayList<>();
        skipWhitespace();
        if (peek() == ']') {
            position++;
            leave();
            return new Json.Arr(elements);
        }
        while (true) {
            skipWhitespace();
            elements.add(parseValue());
            skipWhitespace();
            char next = peek();
            if (next == ',') {
                position++;
                continue;
            }
            if (next == ']') {
                position++;
                leave();
                return new Json.Arr(elements);
            }
            throw error("expected ',' or ']'");
        }
    }

    private String parseString() {
        expect('"');
        StringBuilder builder = new StringBuilder();
        while (true) {
            if (position >= text.length()) {
                throw error("unterminated string");
            }
            char c = text.charAt(position++);
            if (c == '"') {
                return builder.toString();
            }
            if (c == '\\') {
                builder.append(parseEscape());
                continue;
            }
            if (c < 0x20) {
                throw error("unescaped control character in string");
            }
            builder.append(c);
        }
    }

    private char parseEscape() {
        if (position >= text.length()) {
            throw error("unterminated escape sequence");
        }
        char c = text.charAt(position++);
        return switch (c) {
            case '"' -> '"';
            case '\\' -> '\\';
            case '/' -> '/';
            case 'b' -> '\b';
            case 'f' -> '\f';
            case 'n' -> '\n';
            case 'r' -> '\r';
            case 't' -> '\t';
            case 'u' -> parseUnicodeEscape();
            default -> throw error("invalid escape '\\" + c + "'");
        };
    }

    private char parseUnicodeEscape() {
        if (position + 4 > text.length()) {
            throw error("truncated \\u escape");
        }
        String hex = text.substring(position, position + 4);
        position += 4;
        try {
            return (char) Integer.parseInt(hex, 16);
        } catch (NumberFormatException e) {
            throw error("invalid \\u escape '" + hex + "'");
        }
    }

    /**
     * Parses a number against the JSON grammar exactly: an optional minus, an integer part with no
     * leading zeros, an optional fraction, an optional exponent.
     */
    private Json parseNumber() {
        int start = position;
        if (peek() == '-') {
            position++;
        }
        int digitsStart = position;
        while (position < text.length() && isDigit(text.charAt(position))) {
            position++;
        }
        int digits = position - digitsStart;
        if (digits == 0) {
            throw error("expected a number");
        }
        if (digits > 1 && text.charAt(digitsStart) == '0') {
            throw error("number has a leading zero");
        }
        if (position < text.length() && text.charAt(position) == '.') {
            position++;
            int fractionStart = position;
            while (position < text.length() && isDigit(text.charAt(position))) {
                position++;
            }
            if (position == fractionStart) {
                throw error("number has an empty fraction");
            }
        }
        if (position < text.length() && (text.charAt(position) == 'e' || text.charAt(position) == 'E')) {
            position++;
            if (position < text.length() && (text.charAt(position) == '+' || text.charAt(position) == '-')) {
                position++;
            }
            int exponentStart = position;
            while (position < text.length() && isDigit(text.charAt(position))) {
                position++;
            }
            if (position == exponentStart) {
                throw error("number has an empty exponent");
            }
        }
        return new Json.Num(text.substring(start, position));
    }

    private Json parseKeyword(String keyword, Json value) {
        if (!text.startsWith(keyword, position)) {
            throw error("expected '" + keyword + "'");
        }
        position += keyword.length();
        return value;
    }

    private void enter() {
        if (++depth > limits.maxDepth()) {
            throw error("nesting exceeds " + limits.maxDepth() + " levels");
        }
    }

    private void leave() {
        depth--;
    }

    private void expect(char expected) {
        if (position >= text.length() || text.charAt(position) != expected) {
            throw error("expected '" + expected + "'");
        }
        position++;
    }

    private char peek() {
        if (position >= text.length()) {
            throw error("unexpected end of document");
        }
        return text.charAt(position);
    }

    private void skipWhitespace() {
        while (position < text.length()) {
            char c = text.charAt(position);
            if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
                position++;
            } else {
                return;
            }
        }
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private JsonException error(String detail) {
        return new JsonException("Malformed JSON at offset " + position + ": " + detail);
    }
}
