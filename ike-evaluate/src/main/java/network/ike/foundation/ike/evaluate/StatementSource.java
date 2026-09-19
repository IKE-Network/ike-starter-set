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

import java.util.List;

/**
 * Where evaluation gets its statements: for a subject under the view, the statements about that
 * subject; for the unfiltered context, every statement. The store-backed source is written
 * when the ANF pattern lands; the gates author their own.
 */
public interface StatementSource {

    /**
     * The statements whose subject of record is the subject.
     *
     * @param subject the subject
     * @return the statements
     */
    List<Statement> statementsOf(Subject subject);

    /**
     * Every statement the source holds.
     *
     * @return the statements
     */
    List<Statement> all();
}
