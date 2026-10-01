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

import network.ike.foundation.ike.ucum.UcumTerm.Factor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * UCUM's grammar for unit codes, as the specification gives it: a term is components joined by
 * a period for a product or a solidus for a quotient, and may open with a solidus; a component
 * is a unit with an optional exponent, a number, a parenthesized term, or an annotation in
 * braces; a unit is an atom, or a prefix on a metric atom. Reading is by the longest code that
 * matches, an atom before a prefix on an atom when both are as long, so that {@code cd} is the
 * candela and not a centi-day. A code the grammar cannot read is refused with its place.
 */
public final class UcumGrammar {

    private record Match(String prefix, String atom) {
        int length() {
            return prefix.length() + atom.length();
        }
    }

    private final String code;
    private final UcumSymbols symbols;
    private int position;
    private BigDecimal number = BigDecimal.ONE;
    private final List<Factor> factors = new ArrayList<>();
    private final List<String> annotations = new ArrayList<>();

    private UcumGrammar(String code, UcumSymbols symbols) {
        this.code = code;
        this.symbols = symbols;
    }

    /**
     * Reads a unit code.
     *
     * @param code    the code as written
     * @param symbols the atoms and prefixes it may use
     * @return the term
     * @throws UcumSyntaxException if the code cannot be read; the place is named
     */
    public static UcumTerm parse(String code, UcumSymbols symbols) {
        if (code == null || code.isEmpty()) {
            throw new UcumSyntaxException(code == null ? "" : code, 0, "the code is empty");
        }
        UcumGrammar grammar = new UcumGrammar(code, symbols);
        grammar.main();
        return UcumTerm.of(code, grammar.number, grammar.factors, grammar.annotations);
    }

    private void main() {
        int sign = 1;
        if (peek() == '/') {
            position++;
            sign = -1;
        }
        term(sign);
        if (position < code.length()) {
            fail(peek() == ')' ? "a closing parenthesis with no opening one"
                    : "expected a period or a solidus between components");
        }
    }

    private void term(int sign) {
        component(sign);
        while (position < code.length()) {
            char next = peek();
            if (next == '.') {
                position++;
                component(sign);
            } else if (next == '/') {
                position++;
                component(-sign);
            } else {
                return;
            }
        }
    }

    private void component(int sign) {
        if (position >= code.length()) {
            fail("expected a unit, a number, or an annotation");
        }
        char next = peek();
        if (next == '(') {
            position++;
            term(sign);
            if (position >= code.length() || peek() != ')') {
                fail("expected a closing parenthesis");
            }
            position++;
            annotation();
            return;
        }
        if (next == '{') {
            annotation();
            return;
        }
        Match match = longestSymbol();
        int digits = digitsAt(position);
        if (match != null && match.length() >= digits) {
            position += match.length();
            int exponent = exponent();
            factors.add(new Factor(match.prefix(), match.atom(), exponent * sign));
            annotation();
            return;
        }
        if (digits > 0) {
            BigDecimal value = new BigDecimal(code.substring(position, position + digits));
            position += digits;
            number = sign > 0 ? number.multiply(value, UcumReduction.PRECISION)
                    : number.divide(value, UcumReduction.PRECISION);
            annotation();
            return;
        }
        Match nonMetric = prefixedNonMetric();
        if (nonMetric != null) {
            fail(nonMetric.atom() + " is not metric and takes no prefix");
        }
        fail("expected a unit, a number, or an annotation");
    }

    private Match longestSymbol() {
        Match best = null;
        for (String atom : symbols.atomCodes()) {
            if (code.startsWith(atom, position) && (best == null || atom.length() > best.length())) {
                best = new Match("", atom);
            }
        }
        for (String prefix : symbols.prefixCodes()) {
            if (!code.startsWith(prefix, position)) {
                continue;
            }
            for (String atom : symbols.atomCodes()) {
                if (code.startsWith(atom, position + prefix.length()) && symbols.metric(atom)
                        && (best == null || prefix.length() + atom.length() > best.length())) {
                    best = new Match(prefix, atom);
                }
            }
        }
        return best;
    }

    private Match prefixedNonMetric() {
        for (String prefix : symbols.prefixCodes()) {
            if (!code.startsWith(prefix, position)) {
                continue;
            }
            for (String atom : symbols.atomCodes()) {
                if (code.startsWith(atom, position + prefix.length()) && !symbols.metric(atom)) {
                    return new Match(prefix, atom);
                }
            }
        }
        return null;
    }

    private int exponent() {
        int start = position;
        int cursor = position;
        if (cursor < code.length() && (code.charAt(cursor) == '+' || code.charAt(cursor) == '-')) {
            cursor++;
        }
        int digits = digitsAt(cursor);
        if (digits == 0) {
            if (cursor > start) {
                position = cursor;
                fail("expected digits after the sign of an exponent");
            }
            return 1;
        }
        position = cursor + digits;
        return Integer.parseInt(code.substring(start, position));
    }

    private void annotation() {
        if (position >= code.length() || peek() != '{') {
            return;
        }
        int close = code.indexOf('}', position);
        if (close < 0) {
            fail("the annotation is not closed");
        }
        annotations.add(code.substring(position + 1, close));
        position = close + 1;
    }

    private int digitsAt(int from) {
        int cursor = from;
        while (cursor < code.length() && Character.isDigit(code.charAt(cursor))) {
            cursor++;
        }
        return cursor - from;
    }

    private char peek() {
        return code.charAt(position);
    }

    private void fail(String problem) {
        throw new UcumSyntaxException(code, position, problem);
    }
}
