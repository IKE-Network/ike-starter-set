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

import java.util.List;

/**
 * A document cannot be imported: a name it uses cannot be resolved, a member is not one its
 * kind allows, or a library it includes is not in the store. The message lists every problem
 * found, in plain words, one per line, and nothing has been written.
 */
public final class ElmImportException extends RuntimeException {

    /**
     * Creates the exception with the problems found.
     *
     * @param problems the problems, one per line in the message
     */
    public ElmImportException(List<String> problems) {
        super(String.join("\n", problems));
    }
}
