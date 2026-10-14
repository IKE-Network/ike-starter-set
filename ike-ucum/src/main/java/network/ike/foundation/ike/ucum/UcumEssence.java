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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * The unmodified UCUM file, read as it is: its prefixes, its base units, and its defined units,
 * every code, name, symbol, property, class, and definition as the file writes them. Nothing is
 * reworded; the only change to a text is that the file's line breaks and indentation inside an
 * element are collapsed to single spaces. The file also answers the grammar's questions at
 * import time, and reduces each unit to the base units by following its definition.
 *
 * <p>The file is Regenstrief Institute's, under the UCUM license; see the notices beside it
 * (IKE-Network/ike-issues#1114).
 */
public final class UcumEssence implements UcumSymbols {

    /** Where the file is bundled. */
    public static final String RESOURCE = "/ucum/ucum-essence.xml";

    /**
     * One prefix as the file writes it.
     *
     * @param code                the case-sensitive code
     * @param caseInsensitiveCode the case-insensitive code
     * @param name                the name
     * @param printSymbol         the print symbol, empty when the file gives none
     * @param value               the factor as written
     */
    public record Prefix(String code, String caseInsensitiveCode, String name, String printSymbol, String value) {

        /**
         * The factor as a number.
         *
         * @return the factor
         */
        public BigDecimal factor() {
            return new BigDecimal(value);
        }
    }

    /**
     * One base unit as the file writes it.
     *
     * @param code                the case-sensitive code
     * @param caseInsensitiveCode the case-insensitive code
     * @param dimension           the dimension's letter
     * @param name                the name
     * @param printSymbol         the print symbol, empty when the file gives none
     * @param property            the property it measures
     */
    public record BaseUnit(String code, String caseInsensitiveCode, String dimension, String name, String printSymbol,
                           String property) {
    }

    /**
     * The function a special unit is defined by.
     *
     * @param name  the function's name
     * @param value the value as written
     * @param unit  the unit as written
     */
    public record Function(String name, String value, String unit) {
    }

    /**
     * One defined unit as the file writes it.
     *
     * @param code                the case-sensitive code
     * @param caseInsensitiveCode the case-insensitive code
     * @param metric              whether the file marks it metric
     * @param special             whether the file marks it special
     * @param arbitrary           whether the file marks it arbitrary
     * @param unitClass           the class the file files it under
     * @param names               its names, one or more, in the file's order
     * @param printSymbol         the print symbol, empty when the file gives none
     * @param property            the property it measures
     * @param definitionValue     the number in its definition as written, empty for a special unit
     * @param definitionUnit      the unit in its definition as written
     * @param function            the function, for a special unit
     */
    public record Unit(String code, String caseInsensitiveCode, boolean metric, boolean special, boolean arbitrary,
                       String unitClass, List<String> names, String printSymbol, String property,
                       String definitionValue, String definitionUnit, Optional<Function> function) {

        /**
         * Keeps the names immutable.
         *
         * @param code                the case-sensitive code
         * @param caseInsensitiveCode the case-insensitive code
         * @param metric              whether the file marks it metric
         * @param special             whether the file marks it special
         * @param arbitrary           whether the file marks it arbitrary
         * @param unitClass           the class the file files it under
         * @param names               its names
         * @param printSymbol         the print symbol
         * @param property            the property it measures
         * @param definitionValue     the number in its definition as written
         * @param definitionUnit      the unit in its definition as written
         * @param function            the function, for a special unit
         */
        public Unit {
            names = List.copyOf(names);
        }

        /**
         * The number in the definition: the value as written, or a special unit's function
         * value.
         *
         * @return the number as written
         */
        public String definitionNumber() {
            return function.map(Function::value).orElse(definitionValue);
        }
    }

    private final String version;
    private final String revisionDate;
    private final List<Prefix> prefixes;
    private final List<BaseUnit> baseUnits;
    private final List<Unit> units;
    private final List<String> properties;
    private final Map<String, Prefix> prefixByCode = new LinkedHashMap<>();
    private final Map<String, BaseUnit> baseByCode = new LinkedHashMap<>();
    private final Map<String, Unit> unitByCode = new LinkedHashMap<>();
    private final Set<String> atomCodes = new LinkedHashSet<>();
    private final Map<String, UcumReduction> reductions = new HashMap<>();
    private final Set<String> reducing = new HashSet<>();

    private UcumEssence(String version, String revisionDate, List<Prefix> prefixes, List<BaseUnit> baseUnits,
                        List<Unit> units) {
        this.version = version;
        this.revisionDate = revisionDate;
        this.prefixes = List.copyOf(prefixes);
        this.baseUnits = List.copyOf(baseUnits);
        this.units = List.copyOf(units);
        Set<String> found = new LinkedHashSet<>();
        for (Prefix prefix : prefixes) {
            prefixByCode.put(prefix.code(), prefix);
        }
        for (BaseUnit base : baseUnits) {
            baseByCode.put(base.code(), base);
            atomCodes.add(base.code());
            found.add(base.property());
        }
        for (Unit unit : units) {
            unitByCode.put(unit.code(), unit);
            atomCodes.add(unit.code());
            found.add(unit.property());
        }
        this.properties = List.copyOf(found);
    }

    /**
     * Reads the bundled file.
     *
     * @return the file's content
     * @throws IOException if the file cannot be read
     */
    public static UcumEssence read() throws IOException {
        try (InputStream in = UcumEssence.class.getResourceAsStream(RESOURCE)) {
            if (in == null) {
                throw new IOException("the UCUM file is not bundled at " + RESOURCE);
            }
            return read(in);
        }
    }

    /**
     * Reads a UCUM file.
     *
     * @param in the file
     * @return the file's content
     * @throws IOException if the file cannot be read or is not well formed
     */
    public static UcumEssence read(InputStream in) throws IOException {
        Document document;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            document = factory.newDocumentBuilder().parse(in);
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException("the UCUM file is not well formed: " + e.getMessage(), e);
        }
        Element root = document.getDocumentElement();
        List<Prefix> prefixes = new ArrayList<>();
        List<BaseUnit> baseUnits = new ArrayList<>();
        List<Unit> units = new ArrayList<>();
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (!(children.item(i) instanceof Element element)) {
                continue;
            }
            switch (element.getTagName()) {
                case "prefix" -> prefixes.add(new Prefix(element.getAttribute("Code"), element.getAttribute("CODE"),
                        text(element, "name"), text(element, "printSymbol"),
                        child(element, "value").map(value -> value.getAttribute("value")).orElse("")));
                case "base-unit" -> baseUnits.add(new BaseUnit(element.getAttribute("Code"),
                        element.getAttribute("CODE"), element.getAttribute("dim"), text(element, "name"),
                        text(element, "printSymbol"), text(element, "property")));
                case "unit" -> {
                    Optional<Element> value = child(element, "value");
                    Optional<Function> function = value.flatMap(v -> child(v, "function"))
                            .map(f -> new Function(f.getAttribute("name"), f.getAttribute("value"), f.getAttribute("Unit")));
                    units.add(new Unit(element.getAttribute("Code"), element.getAttribute("CODE"),
                            element.getAttribute("isMetric").equals("yes"),
                            element.getAttribute("isSpecial").equals("yes"),
                            element.getAttribute("isArbitrary").equals("yes"),
                            element.getAttribute("class"), texts(element, "name"), text(element, "printSymbol"),
                            text(element, "property"),
                            value.map(v -> v.getAttribute("value")).orElse(""),
                            value.map(v -> v.getAttribute("Unit")).orElse(""),
                            function));
                }
                default -> {
                }
            }
        }
        return new UcumEssence(root.getAttribute("version"), root.getAttribute("revision-date"), prefixes, baseUnits,
                units);
    }

    private static Optional<Element> child(Element parent, String tag) {
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i) instanceof Element element && element.getTagName().equals(tag)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    private static String text(Element parent, String tag) {
        return child(parent, tag).map(UcumEssence::collapsed).orElse("");
    }

    private static List<String> texts(Element parent, String tag) {
        List<String> texts = new ArrayList<>();
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i) instanceof Element element && element.getTagName().equals(tag)) {
                texts.add(collapsed(element));
            }
        }
        return texts;
    }

    /** The element's text with the file's line breaks and indentation collapsed to one space. */
    private static String collapsed(Node element) {
        return element.getTextContent().replaceAll("[ \\t\\n\\r]+", " ").trim();
    }

    /**
     * The file's version.
     *
     * @return the version as written
     */
    public String version() {
        return version;
    }

    /**
     * The file's revision date.
     *
     * @return the date as written
     */
    public String revisionDate() {
        return revisionDate;
    }

    /**
     * The prefixes, in the file's order.
     *
     * @return the prefixes
     */
    public List<Prefix> prefixes() {
        return prefixes;
    }

    /**
     * The base units, in the file's order.
     *
     * @return the base units
     */
    public List<BaseUnit> baseUnits() {
        return baseUnits;
    }

    /**
     * The defined units, in the file's order.
     *
     * @return the units
     */
    public List<Unit> units() {
        return units;
    }

    /**
     * The properties the units measure, each once, in order of first appearance.
     *
     * @return the properties
     */
    public List<String> properties() {
        return properties;
    }

    /**
     * A prefix by its case-sensitive code.
     *
     * @param code the code
     * @return the prefix, or empty
     */
    public Optional<Prefix> prefix(String code) {
        return Optional.ofNullable(prefixByCode.get(code));
    }

    /**
     * A base unit by its case-sensitive code.
     *
     * @param code the code
     * @return the base unit, or empty
     */
    public Optional<BaseUnit> baseUnit(String code) {
        return Optional.ofNullable(baseByCode.get(code));
    }

    /**
     * A defined unit by its case-sensitive code.
     *
     * @param code the code
     * @return the unit, or empty
     */
    public Optional<Unit> unit(String code) {
        return Optional.ofNullable(unitByCode.get(code));
    }

    @Override
    public Set<String> atomCodes() {
        return Collections.unmodifiableSet(atomCodes);
    }

    @Override
    public Set<String> prefixCodes() {
        return Collections.unmodifiableSet(prefixByCode.keySet());
    }

    @Override
    public boolean metric(String atomCode) {
        if (baseByCode.containsKey(atomCode)) {
            return true;
        }
        Unit unit = unitByCode.get(atomCode);
        return unit != null && unit.metric();
    }

    @Override
    public BigDecimal prefixFactor(String prefixCode) {
        Prefix prefix = prefixByCode.get(prefixCode);
        if (prefix == null) {
            throw new IllegalArgumentException("no UCUM prefix " + prefixCode);
        }
        return prefix.factor();
    }

    /**
     * Reduces an atom by following its definition down to the base units. A base unit is its
     * own dimension at magnitude one. A defined unit is its definition's number times the
     * reduction of its definition's unit. A special unit reduces through its function's value
     * and unit and is flagged special; an arbitrary unit is flagged arbitrary; the flags follow
     * into every unit defined in terms of a flagged one.
     *
     * @param atomCode the atom's code
     * @return its reduction
     * @throws IllegalArgumentException if no atom has that code
     * @throws IllegalStateException    if the file defines a unit in terms of itself
     */
    @Override
    public synchronized UcumReduction reduction(String atomCode) {
        UcumReduction known = reductions.get(atomCode);
        if (known != null) {
            return known;
        }
        BaseUnit base = baseByCode.get(atomCode);
        if (base != null) {
            UcumReduction reduction = UcumReduction.base(base.dimension());
            reductions.put(atomCode, reduction);
            return reduction;
        }
        Unit unit = unitByCode.get(atomCode);
        if (unit == null) {
            throw new IllegalArgumentException("no UCUM unit " + atomCode);
        }
        if (!reducing.add(atomCode)) {
            throw new IllegalStateException("UCUM defines " + atomCode + " in terms of itself");
        }
        try {
            UcumReduction reduction;
            if (unit.function().isPresent()) {
                Function function = unit.function().get();
                reduction = UcumGrammar.parse(function.unit(), this).reduce(this)
                        .scale(new BigDecimal(function.value())).flagged(true, false);
            } else {
                reduction = UcumGrammar.parse(unit.definitionUnit(), this).reduce(this)
                        .scale(new BigDecimal(unit.definitionValue()));
            }
            reduction = reduction.flagged(unit.special(), unit.arbitrary());
            reductions.put(atomCode, reduction);
            return reduction;
        } finally {
            reducing.remove(atomCode);
        }
    }
}
