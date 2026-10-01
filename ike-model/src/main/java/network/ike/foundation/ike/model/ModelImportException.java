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
package network.ike.foundation.ike.model;

import java.util.List;

/**
 * A model information file that cannot be imported, refused with its place: which file, which
 * class or element, and what was missing or could not be resolved. Nothing has been written.
 */
public final class ModelImportException extends RuntimeException {

    private final List<String> problems;

    /**
     * Creates the refusal.
     *
     * @param problems the problems, one per line in the message
     */
    public ModelImportException(List<String> problems) {
        super(String.join("\n", problems));
        this.problems = List.copyOf(problems);
    }

    /**
     * The problems found.
     *
     * @return the problems, in the order found
     */
    public List<String> problems() {
        return problems;
    }
}
