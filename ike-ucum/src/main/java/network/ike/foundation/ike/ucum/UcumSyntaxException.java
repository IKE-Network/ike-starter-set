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

/**
 * A unit code the grammar cannot read, refused with its place: the code, the position of the
 * first character that could not be read, counted from zero, and what was expected there.
 */
public final class UcumSyntaxException extends RuntimeException {

    private final String code;
    private final int position;

    /**
     * Creates the refusal.
     *
     * @param code     the code as written
     * @param position where reading stopped, counted from zero
     * @param problem  what was expected there
     */
    public UcumSyntaxException(String code, int position, String problem) {
        super("'" + code + "' at " + position + ": " + problem);
        this.code = code;
        this.position = position;
    }

    /**
     * The code as written.
     *
     * @return the code
     */
    public String code() {
        return code;
    }

    /**
     * Where reading stopped, counted from zero.
     *
     * @return the position
     */
    public int position() {
        return position;
    }
}
