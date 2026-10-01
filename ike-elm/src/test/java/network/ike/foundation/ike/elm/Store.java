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

import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import network.ike.foundation.ike.fixtures.Fixtures;
import network.ike.foundation.ike.model.ModelImporter;
import network.ike.foundation.ike.model.ModelInfoFile;
import network.ike.foundation.ike.terms.IkeSource;
import network.ike.foundation.ike.ucum.UcumEssence;
import network.ike.foundation.ike.ucum.UcumImporter;

import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

/**
 * One ephemeral store with the ledger composed into it, the UCUM units imported, and the models
 * the corpus names imported, shared by the gates of this module: the same boot the ledger's own
 * gates use.
 */
final class Store {

    private static boolean started;
    private static long lastTime = System.currentTimeMillis();
    private static StampCalculator calculator;
    private static ElmCatalog catalog;

    private Store() {
    }

    /**
     * Boots the store once and composes the ledger into it.
     *
     * @return the stamp calculator for the development path, latest active versions
     * @throws Exception if the store cannot start
     */
    static synchronized StampCalculator boot() throws Exception {
        if (!started) {
            CachingService.clearAll();
            ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-elm").toFile());
            PrimitiveData.selectControllerByName("Load Ephemeral Store");
            PrimitiveData.start();
            new IkeSource().compose().write();
            calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
            // The units, imported the way a knowledge base assembly imports them, so that a
            // library's quantities can name them.
            new UcumImporter(calculator).importEssence(UcumEssence.read(), nextStamp());
            // The models the corpus was written against: System, QUICK, FHIR 4.0.1 for the one
            // library that carries result types, and, kept beside the corpus as fixtures, the two
            // QDM versions and FHIR 3.0.0 (IKE-Network/ike-issues#1115).
            ModelImporter models = new ModelImporter(calculator);
            models.importModel(ModelInfoFile.readShipped("system-modelinfo.xml"), nextStamp());
            models.importModel(ModelInfoFile.readShipped("quick-modelinfo.xml"), nextStamp());
            models.importModel(ModelInfoFile.readShipped("fhir-modelinfo-4.0.1.xml"), nextStamp());
            for (String fixture : List.of("qdm-modelinfo-5.4.xml", "qdm-modelinfo-5.5.xml", "fhir-modelinfo-3.0.0.xml")) {
                try (InputStream in = Fixtures.open("model-fixtures/" + fixture)) {
                    models.importModel(ModelInfoFile.read(in), nextStamp());
                }
            }
            started = true;
        }
        return calculator;
    }

    /**
     * A fresh active stamp, later than every stamp given before, on the inception stamp's author,
     * module, and path. The store keeps one version per stamp, so each import that should leave
     * its own mark takes one of these.
     *
     * @return the stamp
     */
    static synchronized dev.ikm.tinkar.entity.builder.Stamp nextStamp() {
        lastTime = Math.max(lastTime + 1, System.currentTimeMillis());
        return new dev.ikm.tinkar.entity.builder.ActiveStamp(lastTime, network.ike.foundation.ike.terms.Ike.INCEPTION.author(),
                network.ike.foundation.ike.terms.Ike.INCEPTION.module(), network.ike.foundation.ike.terms.Ike.INCEPTION.path());
    }

    /**
     * The catalog read from the booted store, read once.
     *
     * @return the catalog
     * @throws Exception if the store cannot start
     */
    static synchronized ElmCatalog catalog() throws Exception {
        StampCalculator stamps = boot();
        if (catalog == null) {
            catalog = ElmCatalog.load(stamps);
        }
        return catalog;
    }
}
