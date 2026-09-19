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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The aliases in scope while a query evaluates: each alias bound to the value it stands for at
 * this pass, in a chain, so that a nested query sees its enclosing aliases.
 */
final class Environment {

    static final Environment EMPTY = new Environment(null, Map.of());

    private final Environment parent;
    private final Map<String, Value> bound;

    private Environment(Environment parent, Map<String, Value> bound) {
        this.parent = parent;
        this.bound = bound;
    }

    Environment with(String alias, Value value) {
        Map<String, Value> next = new HashMap<>();
        next.put(alias, value);
        return new Environment(this, next);
    }

    Optional<Value> lookup(String alias) {
        Environment scope = this;
        while (scope != null) {
            if (scope.bound.containsKey(alias)) {
                return Optional.of(scope.bound.get(alias));
            }
            scope = scope.parent;
        }
        return Optional.empty();
    }
}
