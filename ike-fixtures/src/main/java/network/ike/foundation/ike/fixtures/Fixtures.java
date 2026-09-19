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
package network.ike.foundation.ike.fixtures;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Lists and opens the fixtures this module carries, whether it runs from a directory of
 * classes or from its jar: the ELM corpus under {@code elm-fixtures}, the model information
 * files under {@code model-fixtures}, and the translated CQL test suite under {@code cql-tests}.
 */
public final class Fixtures {

    private Fixtures() {
    }

    /**
     * Opens a fixture by its resource name.
     *
     * @param name the name, for example {@code model-fixtures/qdm-modelinfo-5.4.xml}
     * @return the fixture's content
     * @throws IOException if there is no such fixture
     */
    public static InputStream open(String name) throws IOException {
        InputStream in = Fixtures.class.getResourceAsStream("/" + name);
        if (in == null) {
            throw new IOException("no fixture is bundled as " + name);
        }
        return in;
    }

    /**
     * Lists the fixtures under a directory whose names an accepting rule admits, sorted.
     *
     * @param directory the directory, for example {@code elm-fixtures}
     * @param accept    which names to list, by the full resource name
     * @return the resource names, sorted
     * @throws IOException if the module's location cannot be read
     */
    public static List<String> list(String directory, Predicate<String> accept) throws IOException {
        List<String> names = new ArrayList<>();
        URI location;
        try {
            location = Fixtures.class.getProtectionDomain().getCodeSource().getLocation().toURI();
        } catch (URISyntaxException e) {
            throw new IOException("the fixtures module's location is not a uri", e);
        }
        Path root = Path.of(location);
        if (Files.isDirectory(root)) {
            collect(root, directory, accept, names);
        } else {
            try (FileSystem jar = FileSystems.newFileSystem(root)) {
                collect(jar.getPath("/"), directory, accept, names);
            }
        }
        names.sort(String::compareTo);
        return names;
    }

    private static void collect(Path root, String directory, Predicate<String> accept, List<String> names)
            throws IOException {
        Path start = root.resolve(directory);
        if (!Files.isDirectory(start)) {
            return;
        }
        try (Stream<Path> walk = Files.walk(start)) {
            walk.filter(Files::isRegularFile).forEach(path -> {
                String name = root.relativize(path).toString().replace('\\', '/');
                if (accept.test(name)) {
                    names.add(name);
                }
            });
        }
    }
}
