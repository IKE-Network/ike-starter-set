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
package network.ike.foundation.ike.terms;

import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.entity.builder.PatternBuilder;
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * What is ours about model information (IKE-Network/ike-issues#1115): the parent the data
 * models hang under, the patterns that record what a model information file says of a model,
 * a class, an element, a context, a relationship, a conversion, and a required model, each
 * field's purpose saying whether it is the file's verbatim or IKE's resolution of it, the
 * mark by which one of IKE's own patterns is written into model information, and the dialects
 * in which each model's names and labels are read. The models themselves are imported
 * knowledge, read from the unmodified files when a knowledge base is assembled, never authored
 * here.
 */
final class ModelInformationSet {

    /** The family root, the parent of every imported model. */
    static final String ROOT_FQN = "Data model (IkeFoundation)";

    /** What a model information file says of the model itself. */
    static final String MODEL_PATTERN_FQN = "Data Model Record Pattern (IkeFoundation)";

    /** A model the model requires. */
    static final String REQUIREMENT_PATTERN_FQN = "Model Requirement Pattern (IkeFoundation)";

    /** What the file says of one class, and what IKE resolved of it. */
    static final String CLASS_PATTERN_FQN = "Model Class Pattern (IkeFoundation)";

    /** What the file says of one element of a class, and what IKE resolved of it. */
    static final String ELEMENT_PATTERN_FQN = "Model Element Pattern (IkeFoundation)";

    /** A context a library may run in, on the model. */
    static final String CONTEXT_PATTERN_FQN = "Model Context Pattern (IkeFoundation)";

    /** How a class reaches a context, on the class. */
    static final String RELATIONSHIP_PATTERN_FQN = "Model Context Relationship Pattern (IkeFoundation)";

    /** A conversion from one type to another, on the type converted from. */
    static final String CONVERSION_PATTERN_FQN = "Model Conversion Pattern (IkeFoundation)";

    /** The mark by which a pattern of IKE's is written into model information of IKE's own. */
    static final String MARK_PATTERN_FQN = "Model Class Mark Pattern (IkeFoundation)";

    /** The models whose names and labels are read in a dialect of their own. */
    static final String[] DIALECTS = {"FHIR", "QDM", "QUICK", "QI-Core", "US Core"};

    private ModelInformationSet() {
    }

    /**
     * The dialect pattern of a model.
     *
     * @param model the model's name as the dialects list writes it
     * @return the pattern's fully qualified name
     */
    static String dialectPatternFqn(String model) {
        return model + " Dialect Pattern (IkeFoundation)";
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;
        EntityProxy.Concept modelRoot = set.conceptRef("Expression language model (IkeFoundation)");

        set.concept(ROOT_FQN).at(inception)
                .synonym("Data model")
                .definition("A data model as the CQL translator describes it in model information: the classes"
                        + " a library can retrieve and walk, each with its elements and their types, the"
                        + " contexts a library can run in, and the conversions to other models. Each model at"
                        + " a version is a concept under this one and its classes hang under it, read from the"
                        + " translator project's unmodified model information files when a knowledge base is"
                        + " assembled; what IKE adds, the resolution of a name to a concept and the marks that"
                        + " write a pattern of IKE's own into model information, is marked as IKE's.")
                .isA(modelRoot);
        EntityProxy.Concept root = set.conceptRef(ROOT_FQN);

        // ── Purposes ──
        String[][] purposes = {
            {"Model information record", "Why a field is recorded: it is what the model information file says,"
                    + " kept verbatim."},
            {"Model resolution", "Why a field is recorded: it is what IKE resolved the file's text to, a concept,"
                    + " a semantic, or a tree of the catalog's type specifiers, and is IKE's, not the file's."},
            {"Model generation", "Why a field is recorded: it says how a pattern of IKE's own is written into"
                    + " model information, so that a library can be written against IKE's own knowledge."},
        };
        for (String[] purpose : purposes) {
            set.concept(purpose[0] + " (IkeFoundation)").at(inception)
                    .synonym(purpose[0])
                    .definition(purpose[1])
                    .isA(root);
        }
        EntityProxy.Concept record = set.conceptRef("Model information record (IkeFoundation)");
        EntityProxy.Concept resolution = set.conceptRef("Model resolution (IkeFoundation)");
        EntityProxy.Concept generation = set.conceptRef("Model generation (IkeFoundation)");

        // ── The dialects ──
        for (String model : DIALECTS) {
            set.concept(model + " dialect (IkeFoundation)").at(inception)
                    .synonym(model + " dialect")
                    .definition("The dialect in which a class's name and label are read as the " + model
                            + " model information writes them, so that a class is found by either, the way a"
                            + " unit is found by its name and its symbol.")
                    .isA(root);
            set.pattern(dialectPatternFqn(model)).at(inception)
                    .meaning(IkeTerm.DESCRIPTION_ACCEPTABILITY)
                    .purpose(IkeTerm.DESCRIPTION_SEMANTIC)
                    .field(set.conceptRef(model + " dialect (IkeFoundation)"), IkeTerm.DESCRIPTION_ACCEPTABILITY,
                            IkeTerm.COMPONENT_FIELD)
                    .definition("Records whether a description is preferred or acceptable in the " + model
                            + " dialect. One field: that description's acceptability for this dialect.");
        }

        // ── Field meanings ──
        String[][] fields = {
            {"Model name", "The name the model information gives the model, as written: FHIR, QDM, QUICK."},
            {"Model version", "The model's version as written, empty when the file gives none."},
            {"Model url", "The url the model's types are qualified by in a library, as written."},
            {"Model target url", "The url of the model a profile model stands on, as written, empty when none."},
            {"Model target version", "The version of the model a profile model stands on, as written."},
            {"Model target qualifier", "The qualifier the file gives the model's types, as written."},
            {"Model patient class", "The class the file names as the patient, as written."},
            {"Model patient class identifier", "The identifier the file gives the patient class, as written."},
            {"Model patient birth date property", "The element the file names as the patient's birth date, as written."},
            {"Model default context", "The context a library runs in when it names none, as written."},
            {"Model case sensitive", "Whether the file marks the model's names case sensitive."},
            {"Model strict retrieve typing", "Whether the file marks retrieves as strictly typed."},
            {"Model schema location", "Where the file says the model's schema is, as written."},
            {"Required model name", "The name of a model this model requires, as written."},
            {"Required model version", "The version of a model this model requires, as written."},
            {"Required model", "The required model's concept in the store, resolved by IKE."},
            {"Model class kind", "What kind of type the file declares, as written: a class, a profile, or a simple type."},
            {"Class namespace", "The namespace the file gives the class, as written."},
            {"Class name", "The class's name as written, qualified by its model."},
            {"Class identifier", "The profile identifier the file gives the class, as written."},
            {"Class label", "The label the file gives the class, as written, the name a QDM author writes."},
            {"Class base type", "The class the file says this one extends, as written."},
            {"Class base", "The base class as a concept, resolved by IKE and stated as the parent; the model's own"
                    + " concept when the class has no base or extends a System type, since nothing hangs under the"
                    + " catalog's types."},
            {"Class retrievable", "Whether the file says a library may retrieve the class."},
            {"Class primary code path", "The element the file names as carrying the class's code, as written."},
            {"Class primary code element", "The element record that path names, resolved by IKE."},
            {"Class primary value set path", "The element the file names as carrying the class's value set, as written."},
            {"Class target", "The class of another model this class stands on, as written, empty when none."},
            {"Class target type", "That class as a concept, resolved by IKE when its model is in the store."},
            {"Class description", "The short description the file gives the class, as written."},
            {"Class comment", "The comment the file gives the class, as written."},
            {"Class model", "The model the class belongs to, as a concept, resolved by IKE from the file the class came in."},
            {"Unresolved", "What a resolution field holds when the file's text resolves to nothing in the store: a class of a model that is not there, a path no element answers, a context the model does not declare."},
            {"Element name", "The element's name as written."},
            {"Element type", "The element's type as written, one class, a list, an interval, or a choice."},
            {"Element class", "The class the type names, as a concept, resolved by IKE when the type names exactly one."},
            {"Element type specifier", "The element's type as a tree of the catalog's type specifiers, named, list,"
                    + " interval, and choice, each named type resolved to its class, built by IKE."},
            {"Element minimum", "The least number of values the file allows, as written."},
            {"Element maximum", "The most values the file allows, as written."},
            {"Element prohibited", "Whether the file prohibits the element."},
            {"Element must support", "Whether the file marks the element as one an implementation must support."},
            {"Element one based", "Whether the file marks a list element as counted from one."},
            {"Element target", "The element of another model this element stands on, as written."},
            {"Element label", "The label the file gives the element, as written."},
            {"Element description", "The short description the file gives the element, as written."},
            {"Element definition", "The definition the file gives the element, as written."},
            {"Element comment", "The comment the file gives the element, as written."},
            {"Element binding name", "The name of the value set binding the file gives the element, as written."},
            {"Element binding strength", "The binding's strength, as written: required, extensible, preferred, example."},
            {"Element binding value set", "The value set the binding names, as written."},
            {"Context name", "The context's name as written: Patient, Encounter, Practitioner."},
            {"Context type", "The class that is the context, as written."},
            {"Context class", "That class as a concept, resolved by IKE."},
            {"Context key element", "The element that keys the context, as written."},
            {"Context birth date element", "The element that carries the context's birth date, as written."},
            {"Relationship context name", "The context a class reaches, as written."},
            {"Relationship context", "That context's record on the model, resolved by IKE."},
            {"Relationship key element", "The element by which the class reaches the context, as written."},
            {"Relationship to target", "Whether the file declares the relationship on the target model rather than this one."},
            {"Conversion from type", "The type a conversion converts from, as written."},
            {"Conversion to type", "The type a conversion converts to, as written."},
            {"Conversion target class", "The type converted to, as a concept, resolved by IKE."},
            {"Conversion function", "The function the file names for the conversion, as written."},
            {"Mark model name", "The name of the model of IKE's own that a pattern is written into."},
            {"Mark retrievable", "Whether a library may retrieve the pattern's semantics as a class."},
            {"Mark code field", "The field of the pattern that carries the class's code."},
        };
        for (String[] field : fields) {
            set.concept(field[0] + " (IkeFoundation)").at(inception)
                    .synonym(field[0])
                    .definition(field[1])
                    .isA(root);
        }

        // ── The model record ──
        PatternBuilder.ActiveScope model = set.pattern(MODEL_PATTERN_FQN).at(inception)
                .meaning(root)
                .purpose(record);
        for (String name : new String[] {"Model name", "Model version", "Model url", "Model target url",
                "Model target version", "Model target qualifier", "Model patient class",
                "Model patient class identifier", "Model patient birth date property", "Model default context"}) {
            model = model.field(set.conceptRef(name + " (IkeFoundation)"), record, IkeTerm.STRING);
        }
        model.field(set.conceptRef("Model case sensitive (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("Model strict retrieve typing (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("Model schema location (IkeFoundation)"), record, IkeTerm.STRING)
                .definition("What a model information file says of the model itself, kept verbatim: its name,"
                        + " version, and url, the model it stands on, its qualifier, its patient class and"
                        + " birth date element, its default context, and its flags.");

        set.pattern(REQUIREMENT_PATTERN_FQN).at(inception)
                .meaning(root)
                .purpose(record)
                .field(set.conceptRef("Required model name (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Required model version (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Required model (IkeFoundation)"), resolution, IkeTerm.CONCEPT_FIELD)
                .definition("A model this model requires, as the file writes it, and that model's concept in"
                        + " the store, which must be there before this model is imported.");

        // ── The class record ──
        set.pattern(CLASS_PATTERN_FQN).at(inception)
                .meaning(root)
                .purpose(record)
                .field(set.conceptRef("Model class kind (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class namespace (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class name (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class identifier (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class label (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class base type (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class base (IkeFoundation)"), resolution, IkeTerm.CONCEPT_FIELD)
                .field(set.conceptRef("Class retrievable (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("Class primary code path (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class primary code element (IkeFoundation)"), resolution, IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Class primary value set path (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class target (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class target type (IkeFoundation)"), resolution, IkeTerm.CONCEPT_FIELD)
                .field(set.conceptRef("Class description (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class comment (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Class model (IkeFoundation)"), resolution, IkeTerm.CONCEPT_FIELD)
                .definition("What a model information file says of one class, kept verbatim, and what IKE"
                        + " resolved of it: the kind, namespace, name, identifier, and label, the base type as"
                        + " written and as a concept, whether retrievable, the code path as written and as the"
                        + " element it names, the value set path, the target as written and as a concept, the"
                        + " description, the comment, and the model the class belongs to. The definition text is"
                        + " the concept's definition.");

        // ── The element record ──
        set.pattern(ELEMENT_PATTERN_FQN).at(inception)
                .meaning(root)
                .purpose(record)
                .field(set.conceptRef("Element name (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element type (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element class (IkeFoundation)"), resolution, IkeTerm.CONCEPT_FIELD)
                .field(set.conceptRef("Element type specifier (IkeFoundation)"), resolution, IkeTerm.DITREE_FIELD)
                .field(set.conceptRef("Element minimum (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element maximum (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element prohibited (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("Element must support (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("Element one based (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("Element target (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element label (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element description (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element definition (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element comment (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element binding name (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element binding strength (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Element binding value set (IkeFoundation)"), record, IkeTerm.STRING)
                .definition("What a model information file says of one element of a class, kept verbatim, and"
                        + " what IKE resolved of it: the name, the type as written, the class the type names"
                        + " when it names one, the type as a tree of the catalog's type specifiers, the bounds,"
                        + " the prohibited, must support, and one based flags, the target, the label, the"
                        + " description, the definition, the comment, and the binding's name, strength, and"
                        + " value set. One semantic per element, about its class.");

        // ── Contexts, relationships, conversions ──
        set.pattern(CONTEXT_PATTERN_FQN).at(inception)
                .meaning(root)
                .purpose(record)
                .field(set.conceptRef("Context name (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Context type (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Context class (IkeFoundation)"), resolution, IkeTerm.CONCEPT_FIELD)
                .field(set.conceptRef("Context key element (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Context birth date element (IkeFoundation)"), record, IkeTerm.STRING)
                .definition("A context a library may run in, as the file writes it on the model: its name, the"
                        + " class that is the context as written and as a concept, the element that keys it,"
                        + " and the element that carries its birth date. One semantic per context, about the"
                        + " model.");
        set.pattern(RELATIONSHIP_PATTERN_FQN).at(inception)
                .meaning(root)
                .purpose(record)
                .field(set.conceptRef("Relationship context name (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Relationship context (IkeFoundation)"), resolution, IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("Relationship key element (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Relationship to target (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .definition("How a class reaches a context, as the file writes it on the class: the context's"
                        + " name and its record, the element by which the class reaches it, and whether the"
                        + " file declares the relationship on the target model. One semantic per relationship,"
                        + " about the class.");
        set.pattern(CONVERSION_PATTERN_FQN).at(inception)
                .meaning(root)
                .purpose(record)
                .field(set.conceptRef("Conversion from type (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Conversion to type (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Conversion target class (IkeFoundation)"), resolution, IkeTerm.CONCEPT_FIELD)
                .field(set.conceptRef("Conversion function (IkeFoundation)"), record, IkeTerm.STRING)
                .definition("A conversion the file declares between two types, about the type converted from:"
                        + " the two types as written, the type converted to as a concept, and the function the"
                        + " file names, which the translator writes into a library as an explicit call.");

        // ── The mark ──
        set.pattern(MARK_PATTERN_FQN).at(inception)
                .meaning(root)
                .purpose(generation)
                .field(set.conceptRef("Mark model name (IkeFoundation)"), generation, IkeTerm.STRING)
                .field(set.conceptRef("Mark retrievable (IkeFoundation)"), generation, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("Mark code field (IkeFoundation)"), generation, IkeTerm.CONCEPT_FIELD)
                .definition("The mark on one of IKE's own patterns that writes it into model information as a"
                        + " class: the model the class belongs to, whether a library may retrieve it, and the"
                        + " field that carries its code. Every field of the pattern becomes an element whose"
                        + " type follows from the field's data type.");
    }
}
