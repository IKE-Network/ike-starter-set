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
package network.ike.foundation.ike.elm;

import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import network.ike.foundation.ike.fixtures.Fixtures;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Every fixture the translator wrote comes back out of the store as it went in, in both forms:
 * import, export, write as JSON and as XML, read each back, and compare the canonical text with
 * the original's. Everything except the translator's annotations must agree.
 */
class ElmRoundTripIT {

    private static ElmCatalog catalog;
    private static StampCalculator calculator;
    private static ElmImporter importer;

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        catalog = Store.catalog();
        importer = new ElmImporter(catalog, calculator);
    }

    static List<String> fixtures() throws IOException {
        return Fixtures.list("elm-fixtures", name -> name.endsWith(".json") || name.endsWith(".xml"));
    }

    static ElmDocument read(String fixture, ElmCatalog catalog) throws IOException {
        try (InputStream in = Fixtures.open(fixture)) {
            return fixture.endsWith(".json") ? new ElmJsonReader(catalog).read(in) : new ElmXmlReader(catalog).read(in);
        }
    }

    @Test
    void everyFixtureRoundTripsInBothForms() throws IOException {
        List<String> fixtures = fixtures();
        assertEquals(21, fixtures.size(), "the corpus: 21 libraries");
        List<String> failures = new ArrayList<>();
        for (String fixture : fixtures) {
            ElmDocument original = read(fixture, catalog);
            String expected = ElmCanonical.text(original);
            ElmImporter.Report report = importer.importDocument(original, Store.nextStamp());
            ElmDocument exported = new ElmExporter(catalog, calculator).export(report.libraryId());

            String json = new ElmJsonWriter(catalog).write(exported);
            ElmDocument fromJson = new ElmJsonReader(catalog).read(
                    new java.io.ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)));
            String xml = new ElmXmlWriter(catalog).write(exported);
            ElmDocument fromXml = new ElmXmlReader(catalog).read(
                    new java.io.ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));

            String viaJson = ElmCanonical.text(fromJson);
            String viaXml = ElmCanonical.text(fromXml);
            if (!expected.equals(viaJson)) {
                failures.add(fixture.substring(fixture.lastIndexOf('/') + 1) + " via JSON differs at " + firstDifference(expected, viaJson));
            }
            if (!expected.equals(viaXml)) {
                failures.add(fixture.substring(fixture.lastIndexOf('/') + 1) + " via XML differs at " + firstDifference(expected, viaXml));
            }
        }
        assertTrue(failures.isEmpty(), String.join("\n", failures));
    }

    @Test
    void everyStoredTreeConformsOnTheWayBackOut() throws IOException {
        for (String fixture : fixtures()) {
            ElmImporter.Report report = importer.importDocument(read(fixture, catalog), Store.nextStamp());
            ElmDocument exported = new ElmExporter(catalog, calculator).export(report.libraryId());
            assertFalse(exported.definitions().isEmpty() && !report.libraryId().startsWith("BaseLibraryElm"),
                    report.libraryId() + " exported no definitions");
        }
    }

    static String firstDifference(String a, String b) {
        int limit = Math.min(a.length(), b.length());
        for (int i = 0; i < limit; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                int from = Math.max(0, i - 60);
                return "index " + i + ":\n  expected …" + a.substring(from, Math.min(a.length(), i + 120))
                        + "\n  actual   …" + b.substring(from, Math.min(b.length(), i + 120));
            }
        }
        return "length " + a.length() + " vs " + b.length();
    }
}
