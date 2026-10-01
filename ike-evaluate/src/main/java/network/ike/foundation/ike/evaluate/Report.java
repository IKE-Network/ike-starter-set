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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * What an evaluation yielded: for each definition, its value or its refusal, with the library,
 * the subject, and the view they were computed under. Nothing is recorded; a report can always
 * be asked for again.
 *
 * @param libraryId   the library
 * @param subject     the subject, empty for the unfiltered context
 * @param definitions the outcomes by definition name, in the library's order
 */
public record Report(String libraryId, Optional<Subject> subject, Map<String, Outcome> definitions) {

    /**
     * Keeps the outcomes immutable and in order.
     *
     * @param libraryId   the library
     * @param subject     the subject
     * @param definitions the outcomes
     */
    public Report {
        definitions = new LinkedHashMap<>(definitions);
    }

    /**
     * The value of a definition.
     *
     * @param name the definition's name
     * @return the value, or empty when the definition was refused or is not there
     */
    public Optional<Value> value(String name) {
        Outcome outcome = definitions.get(name);
        return outcome instanceof Outcome.Yielded yielded ? Optional.of(yielded.value()) : Optional.empty();
    }

    /**
     * The refusal of a definition.
     *
     * @param name the definition's name
     * @return the refusal, or empty when the definition yielded a value or is not there
     */
    public Optional<Refusal> refusal(String name) {
        Outcome outcome = definitions.get(name);
        return outcome instanceof Outcome.Refused refused ? Optional.of(refused.refusal()) : Optional.empty();
    }
}
