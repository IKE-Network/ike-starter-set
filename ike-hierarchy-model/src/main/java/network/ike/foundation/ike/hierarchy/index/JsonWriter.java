package network.ike.foundation.ike.hierarchy.index;

import java.util.Map;

/**
 * Renders a {@link Json} tree as indented text.
 *
 * <p>Output is deterministic: member order is the order of the tree's own {@code LinkedHashMap},
 * indentation is two spaces per level, and numbers are written as the literal they were built
 * from. Two builds over the same chapter tree therefore produce byte-identical index files, which
 * is what makes the index safe to commit, diff, and cache.
 */
final class JsonWriter {

    private JsonWriter() {
    }

    /**
     * Appends a value's rendering at the given indent level.
     *
     * @param value   the value to render
     * @param out     the buffer to append to
     * @param indent  the current indent level, in units of two spaces
     */
    static void write(Json value, StringBuilder out, int indent) {
        switch (value) {
            case Json.Obj obj -> writeObject(obj, out, indent);
            case Json.Arr arr -> writeArray(arr, out, indent);
            case Json.Str str -> writeString(str.value(), out);
            case Json.Num num -> out.append(num.literal());
            case Json.Bool bool -> out.append(bool.value());
            case Json.Nul ignored -> out.append("null");
        }
    }

    private static void writeObject(Json.Obj obj, StringBuilder out, int indent) {
        if (obj.members().isEmpty()) {
            out.append("{}");
            return;
        }
        out.append("{\n");
        int i = 0;
        for (Map.Entry<String, Json> member : obj.members().entrySet()) {
            indent(out, indent + 1);
            writeString(member.getKey(), out);
            out.append(": ");
            write(member.getValue(), out, indent + 1);
            if (++i < obj.members().size()) {
                out.append(',');
            }
            out.append('\n');
        }
        indent(out, indent);
        out.append('}');
    }

    private static void writeArray(Json.Arr arr, StringBuilder out, int indent) {
        if (arr.elements().isEmpty()) {
            out.append("[]");
            return;
        }
        out.append("[\n");
        for (int i = 0; i < arr.elements().size(); i++) {
            indent(out, indent + 1);
            write(arr.elements().get(i), out, indent + 1);
            if (i + 1 < arr.elements().size()) {
                out.append(',');
            }
            out.append('\n');
        }
        indent(out, indent);
        out.append(']');
    }

    private static void writeString(String value, StringBuilder out) {
        out.append('"');
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            switch (c) {
                case '"' -> out.append("\\\"");
                case '\\' -> out.append("\\\\");
                case '\b' -> out.append("\\b");
                case '\f' -> out.append("\\f");
                case '\n' -> out.append("\\n");
                case '\r' -> out.append("\\r");
                case '\t' -> out.append("\\t");
                default -> {
                    if (c < 0x20) {
                        out.append(String.format("\\u%04x", (int) c));
                    } else {
                        out.append(c);
                    }
                }
            }
        }
        out.append('"');
    }

    private static void indent(StringBuilder out, int level) {
        out.append("  ".repeat(Math.max(0, level)));
    }
}
