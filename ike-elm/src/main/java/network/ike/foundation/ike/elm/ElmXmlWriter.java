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
import network.ike.foundation.ike.elm.ElmCatalog.KindValue;
import network.ike.foundation.ike.elm.ElmCatalog.NodeKind;
import network.ike.foundation.ike.elm.ElmCatalog.PositionRule;
import network.ike.foundation.ike.elm.ElmCatalog.PrimitiveValue;
import network.ike.foundation.ike.elm.ElmDocument.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Writes a document in ELM's XML form, as the translator does: a node is an element, its
 * {@code xsi:type} written when the position it fills allows more than one kind, plain values
 * as attributes, held nodes as child elements, and qualified type names re-prefixed from the
 * braces form with the namespaces the document declares.
 */
public final class ElmXmlWriter {

    /** ELM's own namespace. */
    public static final String ELM = "urn:hl7-org:elm:r1";
    /** The namespace of ELM's System types. */
    public static final String SYSTEM = "urn:hl7-org:elm-types:r1";

    private final ElmCatalog catalog;

    /**
     * Creates a writer over a catalog.
     *
     * @param catalog the catalog
     */
    public ElmXmlWriter(ElmCatalog catalog) {
        this.catalog = catalog;
    }

    /**
     * Writes a document.
     *
     * @param document the document
     * @return the XML text
     */
    public String write(ElmDocument document) {
        Document dom;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            dom = factory.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("The XML builder cannot be created", e);
        }
        Map<String, String> prefixes = new LinkedHashMap<>();
        prefixes.put(SYSTEM, "t");
        Element root = dom.createElementNS(ELM, "library");
        dom.appendChild(root);
        fill(dom, root, document.library(), catalog.kind("Library"), prefixes);
        root.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
        for (Map.Entry<String, String> prefix : prefixes.entrySet()) {
            root.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:" + prefix.getValue(), prefix.getKey());
        }
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StringWriter out = new StringWriter();
            transformer.transform(new DOMSource(dom), new StreamResult(out));
            return out.toString();
        } catch (TransformerException e) {
            throw new IllegalStateException("The document cannot be written as XML", e);
        }
    }

    private void fill(Document dom, Element element, Node node, NodeKind kind, Map<String, String> prefixes) {
        for (Map.Entry<String, List<Object>> member : node.members().entrySet()) {
            PositionRule rule = kind.position(member.getKey()).orElseThrow();
            for (Object value : member.getValue()) {
                if (rule.form() == Form.PROPERTY) {
                    String text = ElmCanonical.plainText(value);
                    if (rule.valueType() instanceof PrimitiveValue primitive && primitive.name().equals("QName")) {
                        text = prefixed(text, prefixes);
                    }
                    element.setAttribute(member.getKey(), text);
                    continue;
                }
                if (value instanceof Node child) {
                    Element childElement = dom.createElementNS(ELM, member.getKey());
                    NodeKind childKind = catalog.kind(child.kind());
                    boolean declared = rule.valueType() instanceof KindValue kindValue
                            && kindValue.kind().name().equals(childKind.name());
                    if (!declared) {
                        childElement.setAttributeNS(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "xsi:type", child.kind());
                    }
                    element.appendChild(childElement);
                    fill(dom, childElement, child, childKind, prefixes);
                }
            }
        }
    }

    private static String prefixed(String braces, Map<String, String> prefixes) {
        if (!braces.startsWith("{")) {
            return braces;
        }
        int close = braces.indexOf('}');
        String namespace = braces.substring(1, close);
        String local = braces.substring(close + 1);
        String prefix = prefixes.get(namespace);
        if (prefix == null) {
            prefix = "ns" + (prefixes.size() + 1);
            prefixes.put(namespace, prefix);
        }
        return prefix + ":" + local;
    }
}
