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

import network.ike.foundation.ike.elm.ElmCatalog.Form;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmCatalog.PrimitiveValue;
import network.ike.foundation.ike.elm.ElmDocument.Node;
import network.ike.foundation.ike.elm.ElmDocument.NodeBuilder;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * Reads ELM in its XML form, as the translator writes it: a node is an element, its kind on
 * {@code xsi:type} when the position allows more than one kind, plain values as attributes and
 * held nodes as child elements. Qualified type names such as {@code t:String} become the braces
 * form using the namespaces the document declares. The catalog decides what each member is;
 * annotations are dropped; a member the kind does not have is refused with its place named.
 */
public final class ElmXmlReader {

    private static final String XSI = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;

    private final ElmCatalog catalog;
    private final DocumentBuilder builder;

    /**
     * Creates a reader over a catalog.
     *
     * @param catalog the catalog
     */
    public ElmXmlReader(ElmCatalog catalog) {
        this.catalog = catalog;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            this.builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("The XML parser cannot be configured securely", e);
        }
    }

    /**
     * Reads a library document.
     *
     * @param in the XML
     * @return the document
     * @throws IOException              if the XML cannot be read
     * @throws IllegalArgumentException if the document does not follow the catalog
     */
    public ElmDocument read(InputStream in) throws IOException {
        Document document;
        try {
            document = builder.parse(in);
        } catch (org.xml.sax.SAXException e) {
            throw new IOException("The document is not well-formed XML: " + e.getMessage(), e);
        }
        Element root = document.getDocumentElement();
        if (!"library".equals(root.getLocalName())) {
            throw new IllegalArgumentException("library: the document's root element is " + root.getLocalName()
                    + ", not library");
        }
        return new ElmDocument(node(root, catalog.kind("Library"), "library"));
    }

    private Node node(Element element, NodeKind kind, String path) {
        NodeBuilder builder = new NodeBuilder(kind.name());
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attribute = (Attr) attributes.item(i);
            String namespace = attribute.getNamespaceURI();
            if (XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(namespace) || XSI.equals(namespace)) {
                continue;
            }
            String member = attribute.getLocalName();
            PositionRule rule = ElmReading.rule(catalog, kind, member, path);
            if (rule.form() != Form.PROPERTY) {
                throw new IllegalArgumentException(path + ": " + member + " holds a node, not a plain value");
            }
            String text = attribute.getValue();
            if (rule.valueType() instanceof PrimitiveValue primitive && primitive.name().equals("QName")) {
                text = braces(element, text, path + "/@" + member);
            }
            builder.add(member, ElmReading.plain(rule, text, path + "/@" + member));
        }
        NodeList children = element.getChildNodes();
        int index = 0;
        for (int i = 0; i < children.getLength(); i++) {
            if (!(children.item(i) instanceof Element child)) {
                continue;
            }
            index++;
            String member = child.getLocalName();
            if (member.equals(ElmReading.ANNOTATION)) {
                continue;
            }
            String childPath = path + "/" + member + "[" + index + "]";
            PositionRule rule = ElmReading.rule(catalog, kind, member, path);
            Optional<String> declared = Optional.ofNullable(child.getAttributeNS(XSI, "type"))
                    .filter(type -> !type.isEmpty()).map(ElmXmlReader::local);
            Optional<NodeKind> held = ElmReading.heldKind(catalog, rule, declared, childPath);
            held.ifPresent(heldKind -> builder.add(member, node(child, heldKind, childPath)));
        }
        return builder.build();
    }

    private static String local(String qualified) {
        int colon = qualified.indexOf(':');
        return colon >= 0 ? qualified.substring(colon + 1) : qualified;
    }

    private static String braces(Element context, String qualified, String path) {
        int colon = qualified.indexOf(':');
        String prefix = colon >= 0 ? qualified.substring(0, colon) : null;
        String local = colon >= 0 ? qualified.substring(colon + 1) : qualified;
        String namespace = context.lookupNamespaceURI(prefix);
        if (namespace == null) {
            if (prefix == null) {
                return local;
            }
            throw new IllegalArgumentException(path + ": the prefix " + prefix + " in " + qualified
                    + " is not declared");
        }
        return "{" + namespace + "}" + local;
    }
}
