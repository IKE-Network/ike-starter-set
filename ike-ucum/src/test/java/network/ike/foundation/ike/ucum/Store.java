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
package network.ike.foundation.ike.ucum;

import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.Stamp;
import network.ike.foundation.ike.terms.Ike;
import network.ike.foundation.ike.terms.IkeSource;

import java.nio.file.Files;

/**
 * One ephemeral store with the ledger composed into it, shared by the gates of this module:
 * the same boot the ledger's own gates use.
 */
final class Store {

    private static boolean started;
    private static long lastTime = System.currentTimeMillis();
    private static StampCalculator calculator;

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
            ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, Files.createTempDirectory("ike-ucum").toFile());
            PrimitiveData.selectControllerByName("Load Ephemeral Store");
            PrimitiveData.start();
            new IkeSource().compose().write();
            calculator = Calculators.Stamp.DevelopmentLatestActiveOnly();
            started = true;
        }
        return calculator;
    }

    /**
     * A fresh active stamp, later than every stamp given before, on the inception stamp's author,
     * module, and path.
     *
     * @return the stamp
     */
    static synchronized Stamp nextStamp() {
        lastTime = Math.max(lastTime + 1, System.currentTimeMillis());
        return new ActiveStamp(lastTime, Ike.INCEPTION.author(), Ike.INCEPTION.module(), Ike.INCEPTION.path());
    }
}
