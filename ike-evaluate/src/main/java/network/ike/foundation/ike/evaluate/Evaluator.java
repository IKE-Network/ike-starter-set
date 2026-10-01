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

import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import network.ike.foundation.ike.elm.ElmCatalog;
import network.ike.foundation.ike.model.ModelTypes;
import network.ike.foundation.ike.ucum.UcumUnits;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Evaluation over statement sets: a stored library's definitions run for a subject, or for
 * every subject, against the statements a source answers, each node kind dispatched through
 * the relation that admits it. What no relation admits is refused, naming the definition, the
 * position, and the kind; a report carries each definition's value or refusal.
 */
public final class Evaluator {

    private final StampCalculator calculator;
    private final ElmCatalog catalog;
    private final Admissions admissions;
    private final Operators operators = new Operators();
    private final ModelTypes types;
    private final Bridges bridges;
    private final Units units;
    private final StatementSource statements;
    private final ConceptSetSource conceptSets;
    private Instant now = Instant.now();

    private final Map<String, Library> libraries = new HashMap<>();
    private final Map<String, Value> memo = new HashMap<>();
    private final Map<String, Refused> refusals = new HashMap<>();
    private final Set<String> inProgress = new HashSet<>();

    private Evaluator(StampCalculator calculator, StatementSource statements, ConceptSetSource conceptSets) {
        this.calculator = calculator;
        this.catalog = ElmCatalog.load(calculator);
        this.admissions = Admissions.load(calculator, catalog);
        this.types = ModelTypes.load(calculator);
        this.bridges = new Bridges(calculator, types);
        this.units = new Units(UcumUnits.load(calculator));
        this.statements = statements;
        this.conceptSets = conceptSets;
    }

    /**
     * Loads an evaluator over a view: the catalog, the relations that admit node kinds, the
     * models and their bridges, and the units.
     *
     * @param calculator  the view
     * @param statements  the source of statements
     * @param conceptSets the source of concept sets, by value set identifier
     * @return the evaluator
     */
    public static Evaluator load(StampCalculator calculator, StatementSource statements, ConceptSetSource conceptSets) {
        return new Evaluator(calculator, statements, conceptSets);
    }

    /**
     * Fixes the moment ages are calculated against.
     *
     * @param moment the moment that counts as now
     * @return this evaluator
     */
    public Evaluator now(Instant moment) {
        this.now = moment;
        return this;
    }

    /**
     * Evaluates every expression definition of a library.
     *
     * @param libraryId  the library's id
     * @param subject    the subject for Patient context, empty for the unfiltered context alone
     * @param parameters the parameters supplied, by name
     * @return the report: each definition's value or refusal
     * @throws IllegalArgumentException when the store holds no such library
     */
    public Report evaluate(String libraryId, Optional<Subject> subject, Map<String, Value> parameters) {
        libraries.clear();
        memo.clear();
        refusals.clear();
        inProgress.clear();
        Library library = library(libraryId).orElseThrow(() ->
                new IllegalArgumentException("the store holds no library " + libraryId));
        Map<String, Outcome> outcomes = new LinkedHashMap<>();
        Context root = new Context(this, library, subject, Environment.EMPTY, Map.copyOf(parameters), libraryId);
        for (Library.Definition definition : library.definitions("ExpressionDef").values()) {
            try {
                outcomes.put(definition.name(), new Outcome.Yielded(definitionValue(library, definition.name(), root)));
            } catch (Refused refused) {
                outcomes.put(definition.name(), new Outcome.Refused(refused.refusal()));
            }
        }
        return new Report(libraryId, subject, outcomes);
    }

    /**
     * The relations that admit node kinds, as loaded.
     *
     * @return the admissions
     */
    public Admissions admissions() {
        return admissions;
    }

    /**
     * How many node kinds the evaluator reads.
     *
     * @return the count of registered readings
     */
    public int readings() {
        return operators.size();
    }

    // ── Package seams ──

    StampCalculator calculator() {
        return calculator;
    }

    ElmCatalog catalog() {
        return catalog;
    }

    ModelTypes types() {
        return types;
    }

    Bridges bridges() {
        return bridges;
    }

    Units units() {
        return units;
    }

    StatementSource statements() {
        return statements;
    }

    ConceptSetSource conceptSets() {
        return conceptSets;
    }

    Instant now() {
        return now;
    }

    Optional<Library> library(String libraryId) {
        Library cached = libraries.get(libraryId);
        if (cached != null) {
            return Optional.of(cached);
        }
        Optional<Library> loaded = Library.load(libraryId, calculator, catalog);
        loaded.ifPresent(library -> libraries.put(libraryId, library));
        return loaded;
    }

    /** The library a reference's library name stands for: the same library when the name is empty. */
    Library libraryNamed(Library from, String localName, Context context) {
        if (localName.isEmpty()) {
            return from;
        }
        String id = from.includedLibraryId(localName).orElseThrow(() ->
                context.refuse("the library includes nothing as " + localName));
        return library(id).orElseThrow(() -> context.refuse("the included library " + id + " is not in the store"));
    }

    /** Refuses a node whose kind no relation admits. */
    void admit(TreeNode node, Context context) {
        if (admissions.of(node.kindNid()).isEmpty()) {
            throw context.refuse("the node kind " + node.kindName() + " has no relation to a construct");
        }
    }

    /** Evaluates one node: admitted by a relation, then read by its kind's operator. */
    Value eval(TreeNode node, Context context) {
        admit(node, context);
        Operators.Operator operator = operators.of(node.kindName()).orElseThrow(() ->
                context.refuse("the node kind " + node.kindName() + " is admitted and not yet read"));
        return operator.apply(node, context);
    }

    /** The value of an expression definition, evaluated once per subject and remembered. */
    Value definitionValue(Library library, String name, Context caller) {
        String key = library.id() + "|" + name + "|" + caller.subject().map(subject -> subject.id().toString()).orElse("");
        Value remembered = memo.get(key);
        if (remembered != null) {
            return remembered;
        }
        Refused earlier = refusals.get(key);
        if (earlier != null) {
            throw earlier;
        }
        Library.Definition definition = library.definition("ExpressionDef", name).orElseThrow(() ->
                caller.refuse("the library " + library.id() + " defines no " + name));
        if (!inProgress.add(key)) {
            throw caller.refuse("the definition " + name + " refers to itself");
        }
        try {
            Context context = caller.in(library, name);
            String declared = definition.root().text("context").orElse("Unfiltered");
            if (declared.equals("Patient")) {
                if (context.subject().isEmpty()) {
                    throw context.refuse("the definition is in Patient context, and no subject was given");
                }
            } else if (!declared.equals("Unfiltered")) {
                throw context.refuse("the context " + declared + " is not one the evaluator runs");
            }
            TreeNode expression = definition.root().held("expression").orElseThrow(() ->
                    context.refuse("the definition holds no expression"));
            Value value = eval(expression, context.at("expression"));
            memo.put(key, value);
            return value;
        } catch (Refused refused) {
            refusals.put(key, refused);
            throw refused;
        } finally {
            inProgress.remove(key);
        }
    }

    /** A parameter's value: as supplied, else its default, else missing. */
    Value parameterValue(Library library, String name, Context caller) {
        Value supplied = caller.parameters().get(name);
        if (supplied != null) {
            return supplied;
        }
        Optional<Library.Definition> definition = library.definition("ParameterDef", name);
        if (definition.isEmpty()) {
            throw caller.refuse("the library " + library.id() + " declares no parameter " + name);
        }
        Optional<TreeNode> fallback = definition.get().root().held("default");
        if (fallback.isEmpty()) {
            return Missing.ANY;
        }
        Context context = caller.in(library, "parameter " + name);
        return eval(fallback.get(), context.at("default"));
    }

    /** The class a retrieve's data type names, through the library's using declarations. */
    int classFor(String dataType, Context context) {
        int close = dataType.indexOf('}');
        if (!dataType.startsWith("{") || close < 0) {
            throw context.refuse("the data type " + dataType + " is not written as {url}name");
        }
        String url = dataType.substring(1, close);
        String local = dataType.substring(close + 1);
        String[] using = context.library().usingFor(url).orElseThrow(() ->
                context.refuse("the library declares no using for " + url));
        List<ModelTypes.Model> candidates = types.modelsAt(url);
        Optional<ModelTypes.Model> model;
        if (!using[1].isEmpty()) {
            model = candidates.stream().filter(candidate -> candidate.version().equals(using[1])).findFirst();
        } else if (candidates.size() == 1) {
            model = Optional.of(candidates.get(0));
        } else {
            throw context.refuse("the using of " + using[0] + " names no version, and the store holds " + candidates.size()
                    + " versions of the model at " + url);
        }
        ModelTypes.Model found = model.orElseThrow(() ->
                context.refuse("the store holds no model " + using[0] + " version " + using[1] + " at " + url));
        return types.classOf(found, local).orElseThrow(() ->
                context.refuse("the model " + found.name() + " " + found.version() + " has no class " + local)).nid();
    }
}
