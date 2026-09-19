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

import java.util.Map;
import java.util.Optional;

/**
 * Everything one pass of evaluation runs in: the evaluator, the library, the subject if any,
 * the aliases in scope, the parameters supplied, and the place, for refusals.
 *
 * @param evaluator  the evaluator
 * @param library    the library the definition belongs to
 * @param subject    the subject, empty in the unfiltered context
 * @param environment the aliases in scope
 * @param parameters the parameters supplied by name
 * @param place      where evaluation stands, the definition and the positions walked
 */
record Context(Evaluator evaluator, Library library, Optional<Subject> subject, Environment environment,
               Map<String, Value> parameters, String place) {

    Context bind(String alias, Value value) {
        return new Context(evaluator, library, subject, environment.with(alias, value), parameters, place);
    }

    Context at(String position) {
        return new Context(evaluator, library, subject, environment, parameters, place + "/" + position);
    }

    Context in(Library other, String definition) {
        return new Context(evaluator, other, subject, Environment.EMPTY, parameters, other.id() + "/" + definition);
    }

    Refused refuse(String reason) {
        return new Refused(place, reason);
    }
}
