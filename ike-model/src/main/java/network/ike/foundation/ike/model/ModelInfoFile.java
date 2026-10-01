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

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A model information file as the CQL translator writes it, read as it is: the model's own
 * facts, the models it requires, its classes with their elements, its contexts, and its
 * conversions, every attribute verbatim. A file is read by the schema's shape and may be validated
 * against the schema first; the translator's own files are not, since they carry bindings without
 * the value set the schema requires. Nothing is reworded; the one thing the reader adds is a qualified
 * name for every type, the model's name and the class's name joined by a period, where a file
 * writes the two apart.
 *
 * <p>The files bundled beside this class are the translator project's, under the Apache
 * License 2.0; see the notice beside them (IKE-Network/ike-issues#1115).
 */
public final class ModelInfoFile {

    /** The schema's namespace. */
    public static final String NAMESPACE = "urn:hl7-org:elm-modelinfo:r1";

    /** Where the files are bundled. */
    public static final String DIRECTORY = "/modelinfo/";

    /** The bundled schema every file is validated against. */
    public static final String SCHEMA = DIRECTORY + "modelinfo.xsd";

    /** The files the starter set ships, in the order a knowledge base imports them. */
    public static final List<String> SHIPPED = List.of("system-modelinfo.xml", "qdm-modelinfo-5.6.xml",
            "quick-modelinfo.xml", "fhir-modelinfo-4.0.1.xml", "qicore-modelinfo-4.1.1.xml", "uscore-modelinfo-3.1.1.xml");

    /** The forms a type specifier takes in a shipped file. */
    public enum Form {
        /** One class, named. */
        NAMED,
        /** A list of a type. */
        LIST,
        /** An interval over a point type. */
        INTERVAL,
        /** A choice among types. */
        CHOICE
    }

    /**
     * A type as the file gives it, in one of its four forms.
     *
     * @param form    the form
     * @param name    the qualified name, for a named type; empty otherwise
     * @param inner   the item type of a list or the point type of an interval; null otherwise
     * @param choices the alternatives of a choice, in the file's order; empty otherwise
     */
    public record TypeSpecifier(Form form, String name, TypeSpecifier inner, List<TypeSpecifier> choices) {

        /**
         * Keeps the alternatives immutable.
         *
         * @param form    the form
         * @param name    the qualified name
         * @param inner   the inner type
         * @param choices the alternatives
         */
        public TypeSpecifier {
            choices = List.copyOf(choices);
        }

        static TypeSpecifier named(String qualifiedName) {
            return new TypeSpecifier(Form.NAMED, qualifiedName, null, List.of());
        }

        static TypeSpecifier list(TypeSpecifier item) {
            return new TypeSpecifier(Form.LIST, "", item, List.of());
        }

        static TypeSpecifier interval(TypeSpecifier point) {
            return new TypeSpecifier(Form.INTERVAL, "", point, List.of());
        }

        static TypeSpecifier choice(List<TypeSpecifier> alternatives) {
            return new TypeSpecifier(Form.CHOICE, "", null, alternatives);
        }

        /**
         * Whether the type names exactly one class.
         *
         * @return true for a named type
         */
        public boolean isNamed() {
            return form == Form.NAMED;
        }

        /**
         * The type in CQL's own syntax: the name, {@code List<...>}, {@code Interval<...>}, or
         * {@code Choice<..., ...>}.
         *
         * @return the text
         */
        public String text() {
            switch (form) {
                case NAMED:
                    return name;
                case LIST:
                    return "List<" + inner.text() + ">";
                case INTERVAL:
                    return "Interval<" + inner.text() + ">";
                default:
                    StringBuilder text = new StringBuilder("Choice<");
                    for (int i = 0; i < choices.size(); i++) {
                        if (i > 0) {
                            text.append(", ");
                        }
                        text.append(choices.get(i).text());
                    }
                    return text.append('>').toString();
            }
        }
    }

    /**
     * One element of a class, every attribute as written.
     *
     * @param name            the element's name
     * @param typeAsWritten   the type as the file writes it, or the nested specifier in CQL's syntax
     * @param type            the type, read
     * @param minimum         the least number of values, as written, empty when none
     * @param maximum         the most, as written, empty when none
     * @param prohibited      whether prohibited
     * @param mustSupport     whether an implementation must support it
     * @param oneBased        whether a list is counted from one
     * @param target          the element of another model it stands on, as written
     * @param label           the label
     * @param description     the short description
     * @param definition      the definition
     * @param comment         the comment
     * @param bindingName     the value set binding's name
     * @param bindingStrength the binding's strength
     * @param bindingValueSet the value set the binding names
     */
    public record Element(String name, String typeAsWritten, TypeSpecifier type, String minimum, String maximum,
                          boolean prohibited, boolean mustSupport, boolean oneBased, String target, String label,
                          String description, String definition, String comment, String bindingName,
                          String bindingStrength, String bindingValueSet) {
    }

    /**
     * How a class reaches a context.
     *
     * @param context    the context's name
     * @param keyElement the element by which the class reaches it
     * @param toTarget   whether the file declares the relationship on the target model
     */
    public record Relationship(String context, String keyElement, boolean toTarget) {
    }

    /**
     * One class as the file writes it.
     *
     * @param kind                the kind of type, as written: ClassInfo, ProfileInfo, or SimpleTypeInfo
     * @param namespace           the namespace, as written, empty when none
     * @param name                the name, as written
     * @param qualifiedName       the name qualified by the model
     * @param identifier          the profile identifier
     * @param label               the label
     * @param baseType            the base class, qualified, empty when none
     * @param retrievable         whether a library may retrieve it
     * @param primaryCodePath     the element carrying the code
     * @param primaryValueSetPath the element carrying the value set
     * @param target              the class of another model it stands on
     * @param description         the short description
     * @param definition          the definition
     * @param comment             the comment
     * @param elements            its elements, in the file's order
     * @param relationships       how it reaches contexts
     * @param searches            how many search parameters the file gives it, set aside
     */
    public record ClassInfo(String kind, String namespace, String name, String qualifiedName, String identifier,
                            String label, String baseType, boolean retrievable, String primaryCodePath,
                            String primaryValueSetPath, String target, String description, String definition,
                            String comment, List<Element> elements, List<Relationship> relationships, int searches) {

        /**
         * Keeps the lists immutable.
         *
         * @param kind                the kind
         * @param namespace           the namespace
         * @param name                the name
         * @param qualifiedName       the qualified name
         * @param identifier          the identifier
         * @param label               the label
         * @param baseType            the base class
         * @param retrievable         whether retrievable
         * @param primaryCodePath     the code path
         * @param primaryValueSetPath the value set path
         * @param target              the target
         * @param description         the description
         * @param definition          the definition
         * @param comment             the comment
         * @param elements            the elements
         * @param relationships       the relationships
         * @param searches            the search parameters set aside
         */
        public ClassInfo {
            elements = List.copyOf(elements);
            relationships = List.copyOf(relationships);
        }

        /**
         * The name without the model's qualifier, as a library writes it after the model's url.
         *
         * @param modelName the model's name
         * @return the local name
         */
        public String localName(String modelName) {
            return qualifiedName.startsWith(modelName + ".") ? qualifiedName.substring(modelName.length() + 1)
                    : qualifiedName;
        }
    }

    /**
     * A context a library may run in.
     *
     * @param name             the context's name
     * @param type             the class that is the context, qualified
     * @param keyElement       the element that keys it
     * @param birthDateElement the element carrying its birth date, empty when none
     */
    public record Context(String name, String type, String keyElement, String birthDateElement) {
    }

    /**
     * A conversion between two types.
     *
     * @param fromType     the type converted from, as written
     * @param toType       the type converted to, as written
     * @param functionName the function, as written
     */
    public record Conversion(String fromType, String toType, String functionName) {
    }

    /**
     * A model this model requires.
     *
     * @param name    the required model's name
     * @param version its version, as written
     */
    public record Requirement(String name, String version) {
    }

    private final String name;
    private final String version;
    private final String url;
    private final String targetUrl;
    private final String targetVersion;
    private final String targetQualifier;
    private final String patientClassName;
    private final String patientClassIdentifier;
    private final String patientBirthDatePropertyName;
    private final String defaultContext;
    private final Optional<Boolean> caseSensitive;
    private final Optional<Boolean> strictRetrieveTyping;
    private final String schemaLocation;
    private final List<Requirement> requirements;
    private final List<ClassInfo> classes;
    private final List<Context> contexts;
    private final List<Conversion> conversions;

    private ModelInfoFile(org.w3c.dom.Element root, List<Requirement> requirements, List<ClassInfo> classes, List<Context> contexts,
                          List<Conversion> conversions) {
        this.name = root.getAttribute("name");
        this.version = root.getAttribute("version");
        this.url = root.getAttribute("url");
        this.targetUrl = root.getAttribute("targetUrl");
        this.targetVersion = root.getAttribute("targetVersion");
        this.targetQualifier = root.getAttribute("targetQualifier");
        this.patientClassName = root.getAttribute("patientClassName");
        this.patientClassIdentifier = root.getAttribute("patientClassIdentifier");
        this.patientBirthDatePropertyName = root.getAttribute("patientBirthDatePropertyName");
        this.defaultContext = root.getAttribute("defaultContext");
        this.caseSensitive = flag(root, "caseSensitive");
        this.strictRetrieveTyping = flag(root, "strictRetrieveTyping");
        this.schemaLocation = root.getAttribute("schemaLocation");
        this.requirements = List.copyOf(requirements);
        this.classes = List.copyOf(classes);
        this.contexts = List.copyOf(contexts);
        this.conversions = List.copyOf(conversions);
    }

    /**
     * Reads one of the bundled files.
     *
     * @param fileName the file's name, one of {@link #SHIPPED}
     * @return the file, read
     * @throws IOException if the file is not bundled, not well formed, or not valid against the schema
     */
    public static ModelInfoFile readShipped(String fileName) throws IOException {
        try (InputStream in = ModelInfoFile.class.getResourceAsStream(DIRECTORY + fileName)) {
            if (in == null) {
                throw new IOException("no model information file is bundled as " + fileName);
            }
            return read(in);
        }
    }

    /**
     * Reads a model information file after validating it against the schema.
     *
     * @param in the file
     * @return the file, read
     * @throws IOException          if the file is not well formed or not valid against the schema
     * @throws ModelImportException if the file declares a kind of type this reader does not read
     */
    public static ModelInfoFile readValidated(InputStream in) throws IOException {
        byte[] bytes = in.readAllBytes();
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            try (InputStream schemaStream = ModelInfoFile.class.getResourceAsStream(SCHEMA)) {
                if (schemaStream == null) {
                    throw new IOException("the model information schema is not bundled at " + SCHEMA);
                }
                Schema schema = schemaFactory.newSchema(new StreamSource(schemaStream));
                schema.newValidator().validate(new StreamSource(new ByteArrayInputStream(bytes)));
            }
        } catch (SAXException e) {
            throw new IOException("the model information file is not valid: " + e.getMessage(), e);
        }
        return read(new ByteArrayInputStream(bytes));
    }

    /**
     * Reads a model information file by the schema's shape, without validating it.
     *
     * @param in the file
     * @return the file, read
     * @throws IOException          if the file is not well formed
     * @throws ModelImportException if the file declares a kind of type this reader does not read
     */
    public static ModelInfoFile read(InputStream in) throws IOException {
        byte[] bytes = in.readAllBytes();
        Document document;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            document = factory.newDocumentBuilder().parse(new ByteArrayInputStream(bytes));
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException("the model information file is not well formed: " + e.getMessage(), e);
        }
        org.w3c.dom.Element root = document.getDocumentElement();
        String modelName = root.getAttribute("name");
        List<Requirement> requirements = new ArrayList<>();
        List<ClassInfo> classes = new ArrayList<>();
        List<Context> contexts = new ArrayList<>();
        List<Conversion> conversions = new ArrayList<>();
        List<String> problems = new ArrayList<>();
        int index = 0;
        for (org.w3c.dom.Element child : children(root)) {
            index++;
            switch (child.getLocalName()) {
                case "requiredModelInfo" -> requirements.add(new Requirement(child.getAttribute("name"),
                        child.getAttribute("version")));
                case "typeInfo" -> classes.add(readClass(child, modelName, index, problems));
                case "conversionInfo" -> conversions.add(new Conversion(
                        typeText(child, "fromType", "fromTypeSpecifier", modelName),
                        typeText(child, "toType", "toTypeSpecifier", modelName),
                        child.getAttribute("functionName")));
                case "contextInfo" -> contexts.add(new Context(child.getAttribute("name"),
                        child(child, "contextType").map(type -> specifier(type, modelName, problems).text()).orElse(""),
                        child.getAttribute("keyElement"), child.getAttribute("birthDateElement")));
                default -> {
                }
            }
        }
        if (!problems.isEmpty()) {
            throw new ModelImportException(problems);
        }
        return new ModelInfoFile(root, requirements, classes, contexts, conversions);
    }

    private static ClassInfo readClass(org.w3c.dom.Element type, String modelName, int index, List<String> problems) {
        String kind = localPart(type.getAttributeNS(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "type"));
        if (!kind.equals("ClassInfo") && !kind.equals("ProfileInfo") && !kind.equals("SimpleTypeInfo")) {
            problems.add(modelName + ": type " + index + " is a " + kind + ", a kind of type this importer does not read");
        }
        String namespace = type.getAttribute("namespace");
        String name = type.getAttribute("name");
        String qualified = qualify(namespace.isEmpty() ? modelName : namespace, name);
        String baseType = type.getAttribute("baseType");
        if (baseType.isEmpty()) {
            baseType = child(type, "baseTypeSpecifier").map(base -> specifier(base, modelName, problems).text()).orElse("");
        } else {
            baseType = qualify(modelName, baseType);
        }
        List<Element> elements = new ArrayList<>();
        List<Relationship> relationships = new ArrayList<>();
        int searches = 0;
        for (org.w3c.dom.Element child : children(type)) {
            switch (child.getLocalName()) {
                case "element" -> elements.add(readElement(child, modelName, qualified, problems));
                case "contextRelationship" -> relationships.add(new Relationship(child.getAttribute("context"),
                        child.getAttribute("relatedKeyElement"), false));
                case "targetContextRelationship" -> relationships.add(new Relationship(child.getAttribute("context"),
                        child.getAttribute("relatedKeyElement"), true));
                case "search" -> searches++;
                default -> {
                }
            }
        }
        return new ClassInfo(kind, namespace, name, qualified, type.getAttribute("identifier"),
                type.getAttribute("label"), baseType, type.getAttribute("retrievable").equals("true"),
                type.getAttribute("primaryCodePath"), type.getAttribute("primaryValueSetPath"),
                qualifyIfPresent(modelName, type.getAttribute("target")), type.getAttribute("description"),
                type.getAttribute("definition"), type.getAttribute("comment"), elements, relationships, searches);
    }

    private static Element readElement(org.w3c.dom.Element element, String modelName, String className, List<String> problems) {
        String written = element.getAttribute("elementType");
        if (written.isEmpty()) {
            written = element.getAttribute("type");
        }
        TypeSpecifier type;
        Optional<org.w3c.dom.Element> nested = child(element, "elementTypeSpecifier").or(() -> child(element, "typeSpecifier"));
        if (!written.isEmpty()) {
            type = parseTypeText(written, modelName);
        } else if (nested.isPresent()) {
            type = specifier(nested.get(), modelName, problems);
            written = type.text();
        } else {
            // One element of a shipped file, QI-Core's ServiceRequest.appropriatenessScore, has no
            // type at all; it is kept as written, typeless, and the importer counts it.
            type = TypeSpecifier.named("");
        }
        Optional<org.w3c.dom.Element> binding = child(element, "binding");
        return new Element(element.getAttribute("name"), written, type, element.getAttribute("min"),
                element.getAttribute("max"), element.getAttribute("prohibited").equals("true"),
                element.getAttribute("mustSupport").equals("true"), element.getAttribute("oneBased").equals("true"),
                element.getAttribute("target"), element.getAttribute("label"), element.getAttribute("description"),
                element.getAttribute("definition"), element.getAttribute("comment"),
                binding.map(b -> b.getAttribute("name")).orElse(""), binding.map(b -> b.getAttribute("strength")).orElse(""),
                binding.map(b -> b.getAttribute("valueSet")).orElse(""));
    }

    private static TypeSpecifier specifier(org.w3c.dom.Element element, String modelName, List<String> problems) {
        String kind = localPart(element.getAttributeNS(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "type"));
        switch (kind) {
            case "NamedTypeSpecifier", "": {
                String model = element.getAttribute("namespace");
                if (model.isEmpty()) {
                    model = element.getAttribute("modelName");
                }
                return TypeSpecifier.named(qualify(model.isEmpty() ? modelName : model, element.getAttribute("name")));
            }
            case "ListTypeSpecifier": {
                String item = element.getAttribute("elementType");
                if (!item.isEmpty()) {
                    return TypeSpecifier.list(parseTypeText(item, modelName));
                }
                return TypeSpecifier.list(child(element, "elementTypeSpecifier")
                        .map(inner -> specifier(inner, modelName, problems))
                        .orElseGet(() -> TypeSpecifier.named("")));
            }
            case "IntervalTypeSpecifier": {
                String point = element.getAttribute("pointType");
                if (!point.isEmpty()) {
                    return TypeSpecifier.interval(parseTypeText(point, modelName));
                }
                return TypeSpecifier.interval(child(element, "pointTypeSpecifier")
                        .map(inner -> specifier(inner, modelName, problems))
                        .orElseGet(() -> TypeSpecifier.named("")));
            }
            case "ChoiceTypeSpecifier": {
                List<TypeSpecifier> alternatives = new ArrayList<>();
                for (org.w3c.dom.Element choice : children(element)) {
                    if (choice.getLocalName().equals("choice") || choice.getLocalName().equals("type")) {
                        alternatives.add(specifier(choice, modelName, problems));
                    }
                }
                return TypeSpecifier.choice(alternatives);
            }
            default:
                problems.add(modelName + ": a type specifier is a " + kind + ", a form this importer does not read");
                return TypeSpecifier.named("");
        }
    }

    /**
     * Reads a type written as text: a qualified name, or the older grammar {@code list<...>} and
     * {@code interval<...>}, in either case of the first letter.
     *
     * @param text      the text
     * @param modelName the model whose name qualifies an unqualified name
     * @return the type
     */
    static TypeSpecifier parseTypeText(String text, String modelName) {
        String trimmed = text.trim();
        String lower = trimmed.toLowerCase();
        if (lower.startsWith("list<") && trimmed.endsWith(">")) {
            return TypeSpecifier.list(parseTypeText(trimmed.substring(5, trimmed.length() - 1), modelName));
        }
        if (lower.startsWith("interval<") && trimmed.endsWith(">")) {
            return TypeSpecifier.interval(parseTypeText(trimmed.substring(9, trimmed.length() - 1), modelName));
        }
        return TypeSpecifier.named(qualify(modelName, trimmed));
    }

    private static String typeText(org.w3c.dom.Element parent, String attribute, String childName, String modelName) {
        String text = parent.getAttribute(attribute);
        if (!text.isEmpty()) {
            return parseTypeText(text, modelName).text();
        }
        return child(parent, childName).map(child -> specifier(child, modelName, new ArrayList<>()).text()).orElse("");
    }

    /**
     * Qualifies a name by a model: a name that carries a model already stays as written.
     *
     * @param model the model's name
     * @param name  the name as written
     * @return the qualified name
     */
    static String qualify(String model, String name) {
        if (name.isEmpty() || model.isEmpty() || name.startsWith(model + ".")) {
            return name;
        }
        int dot = name.indexOf('.');
        if (dot > 0 && isModelPrefix(name.substring(0, dot))) {
            return name;
        }
        return model + "." + name;
    }

    private static boolean isModelPrefix(String prefix) {
        // The models a shipped file names before a period: the shipped models, System, and the
        // XML Schema types. A name whose first part is none of these belongs to the file's own
        // model, as FHIR's nested classes, Bundle.Entry, do.
        return prefix.equals("System") || prefix.equals("FHIR") || prefix.equals("QDM") || prefix.equals("QUICK")
                || prefix.equals("QICore") || prefix.equals("USCore") || prefix.equals("xs");
    }

    private static String qualifyIfPresent(String model, String name) {
        return name.isEmpty() ? "" : qualify(model, name);
    }

    private static Optional<Boolean> flag(org.w3c.dom.Element element, String attribute) {
        String value = element.getAttribute(attribute);
        return value.isEmpty() ? Optional.empty() : Optional.of(value.equals("true"));
    }

    private static String localPart(String qualified) {
        int colon = qualified.indexOf(':');
        return colon < 0 ? qualified : qualified.substring(colon + 1);
    }

    private static List<org.w3c.dom.Element> children(org.w3c.dom.Element parent) {
        List<org.w3c.dom.Element> children = new ArrayList<>();
        NodeList nodes = parent.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i) instanceof org.w3c.dom.Element element) {
                children.add(element);
            }
        }
        return children;
    }

    private static Optional<org.w3c.dom.Element> child(org.w3c.dom.Element parent, String localName) {
        for (org.w3c.dom.Element child : children(parent)) {
            if (child.getLocalName().equals(localName)) {
                return Optional.of(child);
            }
        }
        return Optional.empty();
    }

    /**
     * The model's name.
     *
     * @return the name as written
     */
    public String name() {
        return name;
    }

    /**
     * The model's version.
     *
     * @return the version as written, empty when the file gives none
     */
    public String version() {
        return version;
    }

    /**
     * The url a library qualifies the model's types by.
     *
     * @return the url as written
     */
    public String url() {
        return url;
    }

    /**
     * The url of the model this model stands on.
     *
     * @return the url as written, empty when none
     */
    public String targetUrl() {
        return targetUrl;
    }

    /**
     * The version of the model this model stands on.
     *
     * @return the version as written, empty when none
     */
    public String targetVersion() {
        return targetVersion;
    }

    /**
     * The qualifier the file gives the model's types.
     *
     * @return the qualifier as written
     */
    public String targetQualifier() {
        return targetQualifier;
    }

    /**
     * The class the file names as the patient.
     *
     * @return the class as written
     */
    public String patientClassName() {
        return patientClassName;
    }

    /**
     * The identifier the file gives the patient class.
     *
     * @return the identifier as written
     */
    public String patientClassIdentifier() {
        return patientClassIdentifier;
    }

    /**
     * The element the file names as the patient's birth date.
     *
     * @return the element as written
     */
    public String patientBirthDatePropertyName() {
        return patientBirthDatePropertyName;
    }

    /**
     * The context a library runs in when it names none.
     *
     * @return the context as written
     */
    public String defaultContext() {
        return defaultContext;
    }

    /**
     * Whether the file marks names case sensitive.
     *
     * @return the flag, empty when the file says nothing
     */
    public Optional<Boolean> caseSensitive() {
        return caseSensitive;
    }

    /**
     * Whether the file marks retrieves as strictly typed.
     *
     * @return the flag, empty when the file says nothing
     */
    public Optional<Boolean> strictRetrieveTyping() {
        return strictRetrieveTyping;
    }

    /**
     * Where the file says the model's schema is.
     *
     * @return the location as written
     */
    public String schemaLocation() {
        return schemaLocation;
    }

    /**
     * The models this model requires.
     *
     * @return the requirements, in the file's order
     */
    public List<Requirement> requirements() {
        return requirements;
    }

    /**
     * The classes, in the file's order.
     *
     * @return the classes
     */
    public List<ClassInfo> classes() {
        return classes;
    }

    /**
     * The contexts, in the file's order.
     *
     * @return the contexts
     */
    public List<Context> contexts() {
        return contexts;
    }

    /**
     * The conversions, in the file's order.
     *
     * @return the conversions
     */
    public List<Conversion> conversions() {
        return conversions;
    }

    /**
     * A class by its qualified name.
     *
     * @param qualifiedName the name qualified by the model
     * @return the class, or empty
     */
    public Optional<ClassInfo> classNamed(String qualifiedName) {
        for (ClassInfo clazz : classes) {
            if (clazz.qualifiedName().equals(qualifiedName)) {
                return Optional.of(clazz);
            }
        }
        return Optional.empty();
    }

    /**
     * How many search parameters the file gives its classes, all set aside.
     *
     * @return the count
     */
    public int searchesSetAside() {
        int count = 0;
        for (ClassInfo clazz : classes) {
            count += clazz.searches();
        }
        return count;
    }
}
