/*
 * Copyright © 2026 IKE Network (support@ike.network)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package network.ike.foundation.ike.evaluate;

import network.ike.foundation.ike.fixtures.Fixtures;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The suite's manifest: one entry per test of the CQL test suite, read from the JSON the
 * suite-to-cql script wrote, with the small reader that file needs.
 */
final class Manifest {

    /**
     * One test.
     *
     * @param file         the suite file, which is the library's id
     * @param group        the group within the file
     * @param name         the test's name, which is the definition's name
     * @param expression   the expression as written
     * @param expected     the expected result as written, null when the test expects an error
     * @param invalid      the suite's own invalid marking, null when valid
     * @param untranslated why the pinned translator could not translate it, null when it could
     */
    record Entry(String file, String group, String name, String expression, String expected, String invalid,
                 String untranslated) {
        boolean translated() {
            return invalid == null && untranslated == null;
        }
    }

    private Manifest() {
    }

    static List<Entry> read() throws IOException {
        String text;
        try (InputStream in = Fixtures.open("cql-tests/manifest.json")) {
            text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
        Object parsed = new Reader(text).value();
        List<Entry> entries = new ArrayList<>();
        for (Object item : (List<?>) parsed) {
            Map<?, ?> object = (Map<?, ?>) item;
            entries.add(new Entry((String) object.get("file"), (String) object.get("group"), (String) object.get("name"),
                    (String) object.get("expression"), (String) object.get("expected"), (String) object.get("invalid"),
                    (String) object.get("untranslated")));
        }
        return entries;
    }

    /** A reader for the JSON the manifest is written in: objects, arrays, strings, numbers, and the literals. */
    private static final class Reader {
        private final String text;
        private int at;

        Reader(String text) {
            this.text = text;
        }

        Object value() {
            skip();
            char c = text.charAt(at);
            if (c == '{') {
                return object();
            }
            if (c == '[') {
                return array();
            }
            if (c == '"') {
                return string();
            }
            if (text.startsWith("null", at)) {
                at += 4;
                return null;
            }
            if (text.startsWith("true", at)) {
                at += 4;
                return Boolean.TRUE;
            }
            if (text.startsWith("false", at)) {
                at += 5;
                return Boolean.FALSE;
            }
            int start = at;
            while (at < text.length() && "+-0123456789.eE".indexOf(text.charAt(at)) >= 0) {
                at++;
            }
            return text.substring(start, at);
        }

        private Map<String, Object> object() {
            Map<String, Object> object = new LinkedHashMap<>();
            at++;
            skip();
            if (text.charAt(at) == '}') {
                at++;
                return object;
            }
            while (true) {
                skip();
                String key = string();
                skip();
                at++;
                object.put(key, value());
                skip();
                char c = text.charAt(at++);
                if (c == '}') {
                    return object;
                }
            }
        }

        private List<Object> array() {
            List<Object> array = new ArrayList<>();
            at++;
            skip();
            if (text.charAt(at) == ']') {
                at++;
                return array;
            }
            while (true) {
                array.add(value());
                skip();
                char c = text.charAt(at++);
                if (c == ']') {
                    return array;
                }
            }
        }

        private String string() {
            StringBuilder builder = new StringBuilder();
            at++;
            while (true) {
                char c = text.charAt(at++);
                if (c == '"') {
                    return builder.toString();
                }
                if (c == '\\') {
                    char escaped = text.charAt(at++);
                    switch (escaped) {
                        case 'n' -> builder.append('\n');
                        case 't' -> builder.append('\t');
                        case 'r' -> builder.append('\r');
                        case 'b' -> builder.append('\b');
                        case 'f' -> builder.append('\f');
                        case 'u' -> {
                            builder.append((char) Integer.parseInt(text.substring(at, at + 4), 16));
                            at += 4;
                        }
                        default -> builder.append(escaped);
                    }
                } else {
                    builder.append(c);
                }
            }
        }

        private void skip() {
            while (at < text.length() && Character.isWhitespace(text.charAt(at))) {
                at++;
            }
        }
    }
}
