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

import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.Stamp;
import network.ike.foundation.ike.elm.ElmCatalog;
import network.ike.foundation.ike.elm.ElmDocument;
import network.ike.foundation.ike.elm.ElmImporter;
import network.ike.foundation.ike.elm.ElmJsonReader;
import network.ike.foundation.ike.fixtures.Fixtures;
import network.ike.foundation.ike.model.ModelImporter;
import network.ike.foundation.ike.model.ModelInfoFile;
import network.ike.foundation.ike.terms.Ike;
import network.ike.foundation.ike.terms.IkeSource;
import network.ike.foundation.ike.ucum.UcumEssence;
import network.ike.foundation.ike.ucum.UcumImporter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 * One ephemeral store for the gates: the ledger, the units, the models the corpus and the
 * suite were written against with their bridges, then the corpus and the suite's libraries.
 */
final class Store {

    private static boolean started;
    private static long lastTime = System.currentTimeMillis();
    private static StampCalculator calculator;
    private static ElmCatalog catalog;
    private static List<String> corpus;
    private static final List<String> corpusIds = new java.util.ArrayList<>();
    private static List<String> suite;

    private Store() {
    }

    /**
     * Boots the store once.
     *
     * @return the stamp calculator for the development path, latest active versions
     * @throws Exception if the store cannot start
     */
    static synchronized StampCalculator boot() throws Exception {
        if (!started) {
            CachingService.clearAll();
            ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-evaluate").toFile());
            PrimitiveData.selectControllerByName("Load Ephemeral Store");
            PrimitiveData.start();
            new IkeSource().compose().write();
            calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
            new UcumImporter(calculator).importEssence(UcumEssence.read(), nextStamp());
            ModelImporter models = new ModelImporter(calculator);
            models.importModel(ModelInfoFile.readShipped("system-modelinfo.xml"), nextStamp());
            models.importModel(ModelInfoFile.readShipped("quick-modelinfo.xml"), nextStamp());
            models.importModel(ModelInfoFile.readShipped("fhir-modelinfo-4.0.1.xml"), nextStamp());
            for (String fixture : List.of("qdm-modelinfo-5.4.xml", "qdm-modelinfo-5.5.xml", "fhir-modelinfo-3.0.0.xml")) {
                try (InputStream in = Fixtures.open("model-fixtures/" + fixture)) {
                    models.importModel(ModelInfoFile.read(in), nextStamp());
                }
            }
            catalog = ElmCatalog.load(calculator);
            Authored.write(calculator, nextStamp());
            ElmImporter importer = new ElmImporter(catalog, calculator);
            corpus = Fixtures.list("elm-fixtures", name -> name.endsWith(".json") || name.endsWith(".xml"));
            for (String fixture : corpus) {
                String id = importer.importDocument(read(fixture), nextStamp()).libraryId();
                if (!corpusIds.contains(id)) {
                    corpusIds.add(id);
                }
            }
            suite = Fixtures.list("cql-tests/elm", name -> name.endsWith(".json"));
            for (String fixture : suite) {
                importer.importDocument(read(fixture), nextStamp());
            }
            started = true;
        }
        return calculator;
    }

    /** A fresh active stamp, later than every stamp given before. */
    static synchronized Stamp nextStamp() {
        lastTime = Math.max(lastTime + 1, System.currentTimeMillis());
        return new ActiveStamp(lastTime, Ike.INCEPTION.author(), Ike.INCEPTION.module(), Ike.INCEPTION.path());
    }

    static synchronized ElmCatalog catalog() throws Exception {
        boot();
        return catalog;
    }

    /** The corpus fixtures imported, by name. */
    static synchronized List<String> corpus() throws Exception {
        boot();
        return corpus;
    }

    /** The corpus libraries' ids, each once, in import order. */
    static synchronized List<String> corpusIds() throws Exception {
        boot();
        return corpusIds;
    }

    /** The suite libraries imported, by fixture name. */
    static synchronized List<String> suite() throws Exception {
        boot();
        return suite;
    }

    static ElmDocument read(String fixture) throws IOException {
        try (InputStream in = Fixtures.open(fixture)) {
            return fixture.endsWith(".json") ? new ElmJsonReader(catalog).read(in)
                    : new network.ike.foundation.ike.elm.ElmXmlReader(catalog).read(in);
        }
    }

    /** Imports a library written as ELM JSON text. */
    static synchronized ElmImporter.Report importJson(String text) throws Exception {
        boot();
        ElmDocument document = new ElmJsonReader(catalog).read(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)));
        return new ElmImporter(catalog, calculator).importDocument(document, nextStamp());
    }
}
