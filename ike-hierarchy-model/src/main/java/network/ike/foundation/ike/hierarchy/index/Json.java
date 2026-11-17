package network.ike.foundation.ike.hierarchy.index;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A minimal, strict JSON tree, and the parser that produces one.
 *
 * <p>This exists to replace regular-expression "parsing" of JSON. A pattern such as
 * {@code "id"\s*:\s*"([^"]*)"} does not read JSON; it finds something that looks like a field
 * anywhere in the text, including inside a string value, inside a nested object that happens to
 * use the same key, or inside a comment. The scheme it replaced also located the end of the
 * {@code sections} array with {@code lastIndexOf(']')}, which silently truncates the moment any
 * array follows it. Failures of that kind do not throw: they produce a plausible, wrong answer,
 * and a chapter quietly goes missing.
 *
 * <p>The grammar accepted here is RFC 8259 with no extensions — no comments, no trailing commas,
 * no unquoted keys, no single-quoted strings. Anything else is a parse error naming the offset,
 * because the index is machine-generated and a deviation means something is wrong upstream.
 *
 * <p>Numbers are kept as their source literal rather than converted to {@code double}. Every
 * number in this index is a small integer, and a literal keeps the written form byte-identical to
 * the read form, which is what lets two builds of the same tree be compared directly.
 */
public sealed interface Json {

    /**
     * A JSON object, preserving the order its members were written in.
     *
     * @param members the object's members, in document order
     */
    record Obj(Map<String, Json> members) implements Json {
        /**
         * Copies the member map defensively while preserving order.
         *
         * @throws IllegalArgumentException if the map is null
         */
        public Obj {
            if (members == null) {
                throw new IllegalArgumentException("A JSON object requires a member map");
            }
            members = java.util.Collections.unmodifiableMap(new LinkedHashMap<>(members));
        }

        /**
         * Looks up a member.
         *
         * @param name the member name
         * @return the member's value, or empty when absent
         */
        public Optional<Json> get(String name) {
            return Optional.ofNullable(members.get(name));
        }

        /**
         * Reads a required string member.
         *
         * @param name the member name
         * @return the string value
         * @throws JsonException if the member is absent or is not a string
         */
        public String requireString(String name) {
            Json value = members.get(name);
            if (value instanceof Str str) {
                return str.value();
            }
            throw new JsonException("expected a string member '" + name + "'");
        }

        /**
         * Reads an optional string member.
         *
         * @param name the member name
         * @return the string value, or empty when the member is absent or null
         */
        public Optional<String> optionalString(String name) {
            Json value = members.get(name);
            return value instanceof Str str ? Optional.of(str.value()) : Optional.empty();
        }

        /**
         * Reads a required integer member.
         *
         * @param name the member name
         * @return the integer value
         * @throws JsonException if the member is absent, not a number, or not an integer
         */
        public int requireInt(String name) {
            Json value = members.get(name);
            if (value instanceof Num num) {
                return num.asInt();
            }
            throw new JsonException("expected a numeric member '" + name + "'");
        }

        /**
         * Reads a boolean member, defaulting when absent.
         *
         * @param name         the member name
         * @param defaultValue the value to use when the member is absent
         * @return the boolean value
         */
        public boolean booleanOr(String name, boolean defaultValue) {
            Json value = members.get(name);
            return value instanceof Bool bool ? bool.value() : defaultValue;
        }

        /**
         * Reads a required array member.
         *
         * @param name the member name
         * @return the array's elements
         * @throws JsonException if the member is absent or is not an array
         */
        public List<Json> requireArray(String name) {
            Json value = members.get(name);
            if (value instanceof Arr arr) {
                return arr.elements();
            }
            throw new JsonException("expected an array member '" + name + "'");
        }

        /**
         * Reads this value as an object.
         *
         * @param value any JSON value
         * @return the value as an object
         * @throws JsonException if the value is not an object
         */
        public static Obj require(Json value) {
            if (value instanceof Obj obj) {
                return obj;
            }
            throw new JsonException("expected an object");
        }
    }

    /**
     * A JSON array.
     *
     * @param elements the array's elements, in order
     */
    record Arr(List<Json> elements) implements Json {
        /**
         * Copies the element list defensively.
         *
         * @throws IllegalArgumentException if the list is null
         */
        public Arr {
            if (elements == null) {
                throw new IllegalArgumentException("A JSON array requires an element list");
            }
            elements = List.copyOf(elements);
        }
    }

    /**
     * A JSON string.
     *
     * @param value the decoded string value
     */
    record Str(String value) implements Json {
        /**
         * Rejects a null value.
         *
         * @throws IllegalArgumentException if the value is null
         */
        public Str {
            if (value == null) {
                throw new IllegalArgumentException("A JSON string requires a value");
            }
        }
    }

    /**
     * A JSON number, retained as its source literal.
     *
     * @param literal the number exactly as it appeared in the source
     */
    record Num(String literal) implements Json {
        /**
         * Rejects a blank literal.
         *
         * @throws IllegalArgumentException if the literal is null or blank
         */
        public Num {
            if (literal == null || literal.isBlank()) {
                throw new IllegalArgumentException("A JSON number requires a literal");
            }
        }

        /**
         * Interprets the literal as an {@code int}.
         *
         * @return the integer value
         * @throws JsonException if the literal is not an integer in {@code int} range
         */
        public int asInt() {
            try {
                return Integer.parseInt(literal);
            } catch (NumberFormatException e) {
                throw new JsonException("number '" + literal + "' is not a 32-bit integer");
            }
        }

        /**
         * Creates a number from an {@code int}.
         *
         * @param value the value
         * @return the JSON number
         */
        public static Num of(int value) {
            return new Num(Integer.toString(value));
        }
    }

    /**
     * A JSON boolean.
     *
     * @param value the boolean value
     */
    record Bool(boolean value) implements Json {
    }

    /** JSON null. */
    record Nul() implements Json {
    }

    /**
     * Parses JSON text under the supplied limits.
     *
     * @param text   the JSON document
     * @param limits the bounds the parse will respect
     * @return the parsed tree
     * @throws JsonException if the text is not well-formed JSON or exceeds a limit
     */
    static Json parse(String text, JsonLimits limits) {
        return new JsonParser(text, limits).parseDocument();
    }

    /**
     * Renders this value as indented JSON text with a trailing newline.
     *
     * @return the rendered document
     */
    default String render() {
        StringBuilder builder = new StringBuilder();
        JsonWriter.write(this, builder, 0);
        builder.append('\n');
        return builder.toString();
    }
}
