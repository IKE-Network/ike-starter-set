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

import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.FieldDefinitionForEntity;
import dev.ikm.tinkar.entity.PatternEntityVersion;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Writes a family of IKE's own patterns as model information (IKE-Network/ike-issues#1115),
 * so that a library can be written against IKE's own knowledge. A pattern that carries the
 * class mark for the model becomes a class whose identifier is the pattern's identity, so an
 * import resolves it back to the pattern rather than making a concept; each field becomes an
 * element whose type follows from the field's data type, a string to System's String, a
 * boolean to Boolean, an integer to Integer, a decimal to Decimal, a concept to Code, a list
 * of components to a list of Any, and anything else to Any; the mark says whether the class is
 * retrievable and which field carries its code. The file requires the System model.
 */
public final class ModelInfoGenerator {

    private record Mark(int patternNid, boolean retrievable, int codeFieldNid) {
    }

    private final StampCalculator calculator;

    /**
     * Creates a generator over a view.
     *
     * @param calculator the view that decides which versions count
     */
    public ModelInfoGenerator(StampCalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Writes the model information of a model of IKE's own.
     *
     * @param modelName the model's name, the one the marks name
     * @param version   the version to write
     * @param url       the url a library will qualify the model's types by
     * @return the file's text
     */
    public String write(String modelName, String version, String url) {
        List<Mark> marks = new ArrayList<>();
        EntityService.get().forEachSemanticOfPattern(IkeTerms.MODEL_CLASS_MARK_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isPresent() && modelName.equals(latest.get().fieldValues().get(0))) {
                marks.add(new Mark(semantic.referencedComponentNid(), (Boolean) latest.get().fieldValues().get(1),
                        ((EntityFacade) latest.get().fieldValues().get(2)).nid()));
            }
        });
        marks.sort(Comparator.comparing(mark -> className(mark.patternNid())));

        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<modelInfo xmlns=\"").append(ModelInfoFile.NAMESPACE).append("\"")
                .append(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"")
                .append(" name=\"").append(escape(modelName)).append("\"");
        if (!version.isEmpty()) {
            xml.append(" version=\"").append(escape(version)).append("\"");
        }
        xml.append(" url=\"").append(escape(url)).append("\"")
                .append(" targetQualifier=\"").append(escape(modelName.toLowerCase())).append("\">\n");
        xml.append("   <requiredModelInfo name=\"System\" version=\"1.0.0\"/>\n");
        for (Mark mark : marks) {
            String name = className(mark.patternNid());
            UUID uuid = EntityService.get().getEntity(mark.patternNid()).orElseThrow().publicId().asUuidArray()[0];
            Latest<PatternEntityVersion> pattern = calculator.latest(mark.patternNid());
            String codePath = "";
            List<FieldDefinitionForEntity> fields = new ArrayList<>();
            if (pattern.isPresent()) {
                for (FieldDefinitionForEntity field : pattern.get().fieldDefinitions()) {
                    fields.add(field);
                    if (field.meaningNid() == mark.codeFieldNid()) {
                        codePath = elementName(field);
                    }
                }
            }
            xml.append("   <typeInfo xsi:type=\"ClassInfo\" namespace=\"").append(escape(modelName)).append("\"")
                    .append(" name=\"").append(escape(name)).append("\"")
                    .append(" identifier=\"urn:uuid:").append(uuid).append("\"")
                    .append(" label=\"").append(escape(name)).append("\"")
                    .append(" retrievable=\"").append(mark.retrievable()).append("\"");
            if (!codePath.isEmpty()) {
                xml.append(" primaryCodePath=\"").append(escape(codePath)).append("\"");
            }
            xml.append(">\n");
            for (FieldDefinitionForEntity field : fields) {
                String type = typeFor(field.dataTypeNid());
                xml.append("      <element name=\"").append(escape(elementName(field))).append("\"");
                if (type.startsWith("List<")) {
                    xml.append(">\n         <elementTypeSpecifier xsi:type=\"ListTypeSpecifier\" elementType=\"")
                            .append(escape(type.substring(5, type.length() - 1))).append("\"/>\n      </element>\n");
                } else {
                    xml.append(" elementType=\"").append(escape(type)).append("\"/>\n");
                }
            }
            xml.append("   </typeInfo>\n");
        }
        xml.append("</modelInfo>\n");
        return xml.toString();
    }

    /**
     * The class name of a pattern: its regular name, or its fully qualified name without the
     * namespace, without a trailing word Pattern.
     *
     * @param patternNid the pattern
     * @return the name
     */
    String className(int patternNid) {
        String name = ModelConcepts.regularName(patternNid, calculator)
                .or(() -> ModelConcepts.fullyQualifiedName(patternNid, calculator).map(ModelInfoGenerator::withoutNamespace))
                .orElse("Pattern " + patternNid);
        return name.endsWith(" Pattern") ? name.substring(0, name.length() - " Pattern".length()) : name;
    }

    private String elementName(FieldDefinitionForEntity field) {
        return ModelConcepts.regularName(field.meaningNid(), calculator)
                .or(() -> ModelConcepts.fullyQualifiedName(field.meaningNid(), calculator).map(ModelInfoGenerator::withoutNamespace))
                .orElse("field " + field.meaningNid());
    }

    private static String withoutNamespace(String fullyQualified) {
        int open = fullyQualified.lastIndexOf(" (");
        return open > 0 ? fullyQualified.substring(0, open) : fullyQualified;
    }

    /**
     * The System type a field's data type is written as.
     *
     * @param dataTypeNid the field's data type
     * @return the type in the model information's syntax
     */
    static String typeFor(int dataTypeNid) {
        if (dataTypeNid == TinkarTerm.STRING.nid() || dataTypeNid == TinkarTerm.STRING_FIELD.nid()) {
            return "System.String";
        }
        if (dataTypeNid == TinkarTerm.BOOLEAN_FIELD.nid()) {
            return "System.Boolean";
        }
        if (dataTypeNid == TinkarTerm.INTEGER_FIELD.nid()) {
            return "System.Integer";
        }
        if (dataTypeNid == TinkarTerm.LONG.nid() || dataTypeNid == TinkarTerm.LONG_FIELD.nid()) {
            return "System.Long";
        }
        if (dataTypeNid == TinkarTerm.DECIMAL_FIELD.nid() || dataTypeNid == TinkarTerm.FLOAT_FIELD.nid()
                || dataTypeNid == TinkarTerm.DOUBLE_FIELD.nid()) {
            return "System.Decimal";
        }
        if (dataTypeNid == TinkarTerm.CONCEPT_FIELD.nid()) {
            return "System.Code";
        }
        if (dataTypeNid == TinkarTerm.COMPONENT_ID_LIST_FIELD.nid() || dataTypeNid == TinkarTerm.COMPONENT_ID_SET_FIELD.nid()) {
            return "List<System.Any>";
        }
        return "System.Any";
    }

    private static String escape(String text) {
        StringBuilder escaped = new StringBuilder(text.length());
        for (char c : text.toCharArray()) {
            switch (c) {
                case '<' -> escaped.append("&lt;");
                case '>' -> escaped.append("&gt;");
                case '&' -> escaped.append("&amp;");
                case '"' -> escaped.append("&quot;");
                default -> escaped.append(c);
            }
        }
        return escaped.toString();
    }

    /**
     * Whether a pattern carries a mark for a model.
     *
     * @param patternNid the pattern
     * @param modelName  the model
     * @return true when marked
     */
    public boolean isMarked(int patternNid, String modelName) {
        boolean[] marked = {false};
        EntityService.get().forEachSemanticForComponentOfPattern(patternNid, IkeTerms.MODEL_CLASS_MARK_PATTERN.nid(),
                semantic -> {
                    Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
                    if (latest.isPresent() && modelName.equals(latest.get().fieldValues().get(0))) {
                        marked[0] = true;
                    }
                });
        return marked[0];
    }

    /**
     * The regular name of a component on this generator's view, for gates that compare an
     * element with its field.
     *
     * @param nid the component
     * @return the name, or empty
     */
    public Optional<String> nameOf(int nid) {
        return ModelConcepts.regularName(nid, calculator);
    }
}
