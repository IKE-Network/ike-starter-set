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

/**
 * A tuple: named parts, each a value of its own kind, in the order written.
 *
 * @param parts the parts by name
 */
public record TupleValue(Map<String, Value> parts) implements Value {

    /**
     * Keeps the parts immutable and in order.
     *
     * @param parts the parts
     */
    public TupleValue {
        parts = new LinkedHashMap<>(parts);
    }

    /**
     * The kind of this value.
     *
     * @return the kind
     */
    @Override
    public Kind kind() {
        return Kind.TUPLE;
    }
}
