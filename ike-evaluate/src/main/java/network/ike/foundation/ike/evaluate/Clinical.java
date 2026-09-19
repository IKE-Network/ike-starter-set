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

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.terms.EntityProxy;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.model.ModelTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The clinical kinds: a retrieve read through the bridge on its class as a filter over the
 * statements the source answers, a value set reference read through the concept set source,
 * and membership of a code in a value set.
 */
final class Clinical {

    private Clinical() {
    }

    static void register(Operators registry) {
        registry.put("Retrieve", Clinical::retrieve);
        registry.put("ValueSetRef", Clinical::valueSet);
        registry.put("InValueSet", (node, context) -> {
            Value code = Operators.operand(node, "code", context);
            Value set = node.has("valueset") ? Operators.operand(node, "valueset", context)
                    : Operators.operand(node, "valuesetExpression", context);
            if (code.isMissing() || set.isMissing()) {
                return Presence.INDETERMINATE;
            }
            if (!(set instanceof ConceptSetValue members)) {
                throw context.refuse("membership is asked in a " + set.kind() + ", and a concept set was needed");
            }
            return Presence.of(inSet(code, members.members(), context));
        });
    }

    private static Value valueSet(TreeNode node, Context context) {
        String name = node.text("name").orElseThrow(() -> context.refuse("a value set reference has no name"));
        Library library = context.evaluator().libraryNamed(context.library(), node.text("libraryName").orElse(""), context);
        Optional<Library.Definition> definition = library.definition("ValueSetDef", name);
        if (definition.isEmpty()) {
            throw context.refuse("no value set " + name + " is defined in " + library.id());
        }
        String id = definition.get().root().text("id").orElse("");
        Optional<Set<Integer>> members = context.evaluator().conceptSets().members(id);
        if (members.isEmpty()) {
            throw context.refuse("the value set " + name + " (" + id + ") is not in the concept set source");
        }
        return new ConceptSetValue(name, members.get());
    }

    private static boolean inSet(Value code, Set<Integer> members, Context context) {
        if (code instanceof ConceptValue concept) {
            return concept.nid().isPresent() && members.contains(concept.nid().get());
        }
        if (code instanceof ListValue codes) {
            return codes.values().stream().anyMatch(item -> !item.isMissing() && inSet(item, members, context));
        }
        if (code instanceof ConceptSetValue set) {
            return set.members().stream().anyMatch(members::contains);
        }
        throw context.refuse("membership in a concept set is asked of a " + code.kind());
    }

    private static Value retrieve(TreeNode node, Context context) {
        for (String filter : List.of("codeFilter", "dateFilter", "otherFilter", "include")) {
            if (!node.items(filter).isEmpty()) {
                throw context.refuse("the retrieve's " + filter + " is not read");
            }
        }
        Object dataType = node.property("dataType").orElseThrow(() -> context.refuse("the retrieve names no data type"));
        Evaluator evaluator = context.evaluator();
        int classNid = dataType instanceof EntityProxy.Concept concept ? concept.nid()
                : evaluator.classFor(String.valueOf(dataType), context);
        Bridges bridges = evaluator.bridges();
        if (bridges.isPatientClass(classNid)) {
            Subject subject = context.subject().orElseThrow(() ->
                    context.refuse("a retrieve of the patient class yields the subject, and the context is Unfiltered"));
            return new ListValue(List.of(new SubjectValue(subject, classNid)));
        }
        Bridges.Bridge bridge = bridges.bridgeOf(classNid).orElseThrow(() ->
                context.refuse("no bridge is authored on " + className(bridges.types(), classNid)));
        Optional<Value> codes = Operators.optionalOperand(node, "codes", context);
        Optional<String> codeProperty = node.text("codeProperty");
        if (codes.isPresent()) {
            String path = codeProperty.orElseThrow(() -> context.refuse("the retrieve filters by codes and names no code path"));
            int reading = readingOfPath(bridges, classNid, path, context);
            if (reading != IkeTerms.TOPIC_READING.nid()) {
                throw context.refuse("the code path " + path + " of " + className(bridges.types(), classNid) + " does not read the topic");
            }
        }
        Optional<Value> dateRange = Operators.optionalOperand(node, "dateRange", context);
        Optional<Integer> dateReading = Optional.empty();
        if (dateRange.isPresent()) {
            String path = node.text("dateProperty").orElseThrow(() ->
                    context.refuse("the retrieve filters by a date range and names no date path"));
            dateReading = Optional.of(readingOfPath(bridges, classNid, path, context));
        }
        List<Statement> statements = context.subject().isPresent()
                ? evaluator.statements().statementsOf(context.subject().get()) : evaluator.statements().all();
        List<Value> kept = new ArrayList<>();
        for (Statement statement : statements) {
            if (statement.circumstanceKindNid() != bridge.circumstanceKindNid()) {
                continue;
            }
            if (bridge.dispositionNid().isPresent()
                    && !statement.dispositionNid().equals(bridge.dispositionNid())) {
                continue;
            }
            if (codes.isPresent() && !topicMatches(statement, codes.get(), node.text("codeComparator").orElse("in"), context)) {
                continue;
            }
            if (dateRange.isPresent()) {
                Value when = References.statementReading(statement, dateReading.get(), context);
                if (Intervals.membership(when, dateRange.get(), Optional.empty(), context) != Presence.PRESENT) {
                    continue;
                }
            }
            kept.add(new StatementValue(statement, classNid));
        }
        return new ListValue(kept);
    }

    private static boolean topicMatches(Statement statement, Value codes, String comparator, Context context) {
        if (codes.isMissing()) {
            return false;
        }
        Set<Integer> members;
        if (codes instanceof ConceptSetValue set) {
            members = set.members();
        } else if (codes instanceof ConceptValue concept) {
            members = concept.nid().map(Set::of).orElse(Set.of());
        } else if (codes instanceof ListValue list) {
            members = new java.util.HashSet<>();
            for (Value item : list.values()) {
                if (item instanceof ConceptValue concept && concept.nid().isPresent()) {
                    members.add(concept.nid().get());
                }
            }
        } else {
            throw context.refuse("the retrieve's codes are a " + codes.kind());
        }
        if (!comparator.equals("in") && !comparator.equals("=") && !comparator.equals("~")) {
            throw context.refuse("the code comparator " + comparator + " is not read");
        }
        return members.contains(statement.topicNid());
    }

    /**
     * The reading at the end of a path on a class, walked element by element while each step
     * names one class; the reading is taken from the deepest element reached.
     */
    private static int readingOfPath(Bridges bridges, int classNid, String path, Context context) {
        ModelTypes types = bridges.types();
        String[] segments = path.split("\\.");
        int current = classNid;
        Optional<Integer> reading = Optional.empty();
        for (String segment : segments) {
            Optional<PublicId> element = types.element(current, segment);
            if (element.isEmpty()) {
                break;
            }
            reading = bridges.readingOf(current, segment);
            Optional<Integer> next = types.elementClass(element.get());
            if (next.isEmpty()) {
                break;
            }
            current = next.get();
        }
        return reading.orElseThrow(() -> context.refuse("the path " + path + " of " + className(types, classNid) + " has no reading"));
    }

    static String className(ModelTypes types, int classNid) {
        Optional<ModelTypes.ClassEntry> entry = types.classEntry(classNid);
        if (entry.isEmpty()) {
            return PrimitiveData.text(classNid);
        }
        Optional<ModelTypes.Model> model = types.modelOf(entry.get().modelNid());
        String local = model.map(found -> entry.get().localName(found.name())).orElse(entry.get().qualifiedName());
        return model.map(found -> local + " of " + found.name() + " " + found.version()).orElse(local);
    }

    static EntityProxy.Concept concept(int nid) {
        return EntityProxy.Concept.make(nid);
    }
}
