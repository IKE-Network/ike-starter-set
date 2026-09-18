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

import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.language.calculator.LanguageCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.builder.generator.AxiomDecompiler;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * The ELM node catalog read back from the store: every node kind, its base, and its positions
 * with what each holds, how many, and in which form (IKE-Network/ike-issues#1110). The catalog is
 * knowledge, generated into the starter set from HL7's ELM schemas by {@code ike:schema-import};
 * this class reads it, never restates it, so the builder and the checker are driven by data.
 */
public final class ElmCatalog {

    /** How our vertex holds a position: as a property, or as an edge to a vertex below. */
    public enum Form {
        /** A plain value, kept as a property on the vertex, keyed by the position. */
        PROPERTY,
        /** Another node, kept as an edge named by an argument vertex whose meaning is the position. */
        EDGE
    }

    /** What a position may hold. */
    public sealed interface ValueType permits KindValue, PrimitiveValue, EnumerationValue, ExternalValue {
        /**
         * The catalog concept for this value type.
         *
         * @return the concept
         */
        EntityProxy.Concept concept();
    }

    /**
     * A node kind of the catalog: the position holds a node of this kind or of a kind that
     * extends it.
     *
     * @param kind the node kind
     */
    public record KindValue(NodeKind kind) implements ValueType {
        @Override
        public EntityProxy.Concept concept() {
            return kind.concept();
        }
    }

    /**
     * A primitive the schema language supplies, such as string or boolean.
     *
     * @param name    the primitive's local name, for example {@code string}
     * @param concept the catalog concept
     */
    public record PrimitiveValue(String name, EntityProxy.Concept concept) implements ValueType {
    }

    /**
     * An enumeration of the catalog: the position holds one of its value concepts.
     *
     * @param concept   the enumeration concept
     * @param valueNids the nids of its value concepts
     */
    public record EnumerationValue(EntityProxy.Concept concept, Set<Integer> valueNids) implements ValueType {
    }

    /**
     * A type of another schema the catalog names but does not describe.
     *
     * @param concept the catalog concept
     */
    public record ExternalValue(EntityProxy.Concept concept) implements ValueType {
    }

    /**
     * One position of one node kind: what it holds, how many times, and in which form.
     *
     * @param name      the position's name as the schema writes it, for example {@code operand}
     * @param position  the position concept
     * @param valueType what the position holds
     * @param minimum   the fewest values allowed
     * @param maximum   the most values allowed, or {@code -1} for no limit
     * @param form      whether our vertex holds it as a property or as an edge
     */
    public record PositionRule(String name, EntityProxy.Concept position, ValueType valueType,
                               int minimum, int maximum, Form form) {

        /**
         * Whether this position takes exactly two or three values, which the tree names as the
         * roles first, second, and third instead of ordering.
         *
         * @return true for a two- or three-operand position
         */
        public boolean isRoles() {
            return form == Form.EDGE && minimum == maximum && (maximum == 2 || maximum == 3);
        }

        /**
         * Whether this position is a true list, which leaves the tree as an ordered list semantic.
         *
         * @return true when the schema sets no limit or allows more than three values
         */
        public boolean isList() {
            return form == Form.EDGE && (maximum == -1 || maximum > 3);
        }
    }

    /**
     * A node kind of the catalog. Kinds refer to one another through their positions, so a
     * kind is created first and its positions are filled once every kind exists.
     */
    public static final class NodeKind {
        private final String name;
        private final EntityProxy.Concept concept;
        private final Optional<NodeKind> base;
        private List<PositionRule> ownPositions = List.of();

        NodeKind(String name, EntityProxy.Concept concept, Optional<NodeKind> base) {
            this.name = name;
            this.concept = concept;
            this.base = base;
        }

        void ownPositions(List<PositionRule> positions) {
            this.ownPositions = List.copyOf(positions);
        }

        /**
         * The kind's name as the schema writes it, for example {@code Exists}.
         *
         * @return the name
         */
        public String name() {
            return name;
        }

        /**
         * The catalog concept.
         *
         * @return the concept
         */
        public EntityProxy.Concept concept() {
            return concept;
        }

        /**
         * The kind this one extends.
         *
         * @return the base, empty for a root kind
         */
        public Optional<NodeKind> base() {
            return base;
        }

        /**
         * The positions the schema declares on this kind itself.
         *
         * @return the own positions
         */
        public List<PositionRule> ownPositions() {
            return ownPositions;
        }

        /**
         * Every position this kind may hold: its own and those inherited from its bases.
         *
         * @return the positions, base positions first
         */
        public List<PositionRule> positions() {
            List<PositionRule> all = new ArrayList<>();
            base.ifPresent(b -> all.addAll(b.positions()));
            all.addAll(ownPositions);
            return all;
        }

        /**
         * The position of a name this kind may hold, own or inherited.
         *
         * @param positionName the name as the schema writes it
         * @return the rule, or empty when no such position exists on this kind
         */
        public Optional<PositionRule> position(String positionName) {
            for (PositionRule rule : positions()) {
                if (rule.name().equals(positionName)) {
                    return Optional.of(rule);
                }
            }
            return Optional.empty();
        }

        /**
         * Whether this kind is the given kind or extends it.
         *
         * @param other the kind to test against
         * @return true when this kind is {@code other} or descends from it
         */
        public boolean isKindOf(NodeKind other) {
            if (concept.nid() == other.concept().nid()) {
                return true;
            }
            return base.map(b -> b.isKindOf(other)).orElse(false);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private final Map<String, NodeKind> kindsByName;
    private final Map<Integer, NodeKind> kindsByNid;
    private final Map<Integer, String> positionNamesByNid;
    private final Map<Integer, EnumerationValue> enumerationsByNid;

    private ElmCatalog(Map<String, NodeKind> kindsByName, Map<Integer, NodeKind> kindsByNid,
                       Map<Integer, String> positionNamesByNid, Map<Integer, EnumerationValue> enumerationsByNid) {
        this.kindsByName = Collections.unmodifiableMap(kindsByName);
        this.kindsByNid = Collections.unmodifiableMap(kindsByNid);
        this.positionNamesByNid = Collections.unmodifiableMap(positionNamesByNid);
        this.enumerationsByNid = Collections.unmodifiableMap(enumerationsByNid);
    }

    /**
     * The node kind of a name.
     *
     * @param name the kind's name as the schema writes it, for example {@code Retrieve}; a type
     *             of the System namespace is written {@code System Quantity}
     * @return the kind
     * @throws IllegalArgumentException if the catalog has no such kind
     */
    public NodeKind kind(String name) {
        NodeKind kind = kindsByName.get(name);
        if (kind == null) {
            throw new IllegalArgumentException("The ELM node catalog has no node kind named " + name);
        }
        return kind;
    }

    /**
     * The node kind whose concept has the given nid, if any.
     *
     * @param nid a concept nid
     * @return the kind, or empty when the nid is not a node kind
     */
    public Optional<NodeKind> kindOf(int nid) {
        return Optional.ofNullable(kindsByNid.get(nid));
    }

    /**
     * The name of a position concept, if the nid is one.
     *
     * @param nid a concept nid
     * @return the position's name, or empty
     */
    public Optional<String> positionName(int nid) {
        return Optional.ofNullable(positionNamesByNid.get(nid));
    }

    /**
     * The enumeration whose concept has the given nid, if any.
     *
     * @param nid a concept nid
     * @return the enumeration, or empty
     */
    public Optional<EnumerationValue> enumerationOf(int nid) {
        return Optional.ofNullable(enumerationsByNid.get(nid));
    }

    /**
     * The number of node kinds.
     *
     * @return the count
     */
    public int kindCount() {
        return kindsByName.size();
    }

    /**
     * Reads the catalog from the store under the given view.
     *
     * @param calculator the stamp calculator that decides which versions count
     * @return the catalog
     */
    public static ElmCatalog load(StampCalculator calculator) {
        LanguageCalculator names = Calculators.Language.UsEnglishFullyQualifiedName(calculator.stampCoordinate());
        int rootNid = IkeTerms.ELM_NODE_CATALOG.nid();
        int propertyFormNid = IkeTerms.ELM_PROPERTY_FORM.nid();

        // Stated parents of every concept in the catalog family, found by walking down from the root.
        Map<Integer, Set<Integer>> children = new HashMap<>();
        Map<Integer, Set<Integer>> parents = new HashMap<>();
        collectFamily(calculator, rootNid, children, parents, new HashSet<>());

        // The raw position records, by the node kind they are about.
        Map<Integer, List<Object[]>> rawByKind = new HashMap<>();
        EntityService.get().forEachSemanticOfPattern(IkeTerms.ELM_TYPE_POSITION_PATTERN.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isPresent()) {
                rawByKind.computeIfAbsent(semantic.referencedComponentNid(), k -> new ArrayList<>())
                        .add(latest.get().fieldValues().toArray());
            }
        });

        // Kinds: every concept under a root-level kind, where a root-level kind is a child of the
        // root that has position records itself or somewhere below it.
        Set<Integer> kindNids = new HashSet<>();
        for (int child : children.getOrDefault(rootNid, Set.of())) {
            if (child == IkeTerms.ELM_POSITION.nid() || child == IkeTerms.ELM_PRIMITIVE.nid()
                    || child == IkeTerms.ELM_EXTERNAL_TYPE.nid()) {
                continue;
            }
            Set<Integer> below = new HashSet<>();
            descendants(child, children, below);
            below.add(child);
            boolean anyPositions = false;
            for (int nid : below) {
                if (rawByKind.containsKey(nid)) {
                    anyPositions = true;
                    break;
                }
            }
            if (anyPositions) {
                kindNids.addAll(below);
            }
        }

        Map<Integer, NodeKind> kindsByNid = new HashMap<>();
        Map<String, NodeKind> kindsByName = new LinkedHashMap<>();
        for (int kindNid : kindNids) {
            shell(kindNid, names, parents, kindNids, kindsByNid, kindsByName);
        }
        Map<Integer, String> positionNames = new HashMap<>();
        Map<Integer, EnumerationValue> enumerations = new HashMap<>();
        for (NodeKind kind : kindsByNid.values()) {
            List<PositionRule> own = new ArrayList<>();
            for (Object[] raw : rawByKind.getOrDefault(kind.concept().nid(), List.of())) {
                EntityProxy.Concept position = (EntityProxy.Concept) raw[0];
                EntityProxy.Concept valueTypeConcept = (EntityProxy.Concept) raw[1];
                int minimum = (Integer) raw[2];
                int maximum = (Integer) raw[3];
                EntityProxy.Concept form = (EntityProxy.Concept) raw[5];
                String positionName = positionNames.computeIfAbsent(position.nid(),
                        nid -> positionNameOf(names, position));
                ValueType valueType = valueTypeOf(valueTypeConcept, names, parents, children, kindsByNid, enumerations);
                own.add(new PositionRule(positionName, position, valueType, minimum, maximum,
                        form.nid() == propertyFormNid ? Form.PROPERTY : Form.EDGE));
            }
            kind.ownPositions(own);
        }
        return new ElmCatalog(kindsByName, kindsByNid, positionNames, enumerations);
    }

    private static NodeKind shell(int kindNid, LanguageCalculator names, Map<Integer, Set<Integer>> parents,
                                  Set<Integer> kindNids, Map<Integer, NodeKind> kindsByNid,
                                  Map<String, NodeKind> kindsByName) {
        NodeKind built = kindsByNid.get(kindNid);
        if (built != null) {
            return built;
        }
        Optional<NodeKind> base = Optional.empty();
        for (int parent : parents.getOrDefault(kindNid, Set.of())) {
            if (kindNids.contains(parent)) {
                base = Optional.of(shell(parent, names, parents, kindNids, kindsByNid, kindsByName));
            }
        }
        EntityProxy.Concept concept = EntityProxy.Concept.make(kindNid);
        NodeKind kind = new NodeKind(kindNameOf(names, concept), concept, base);
        kindsByNid.put(kindNid, kind);
        kindsByName.put(kind.name(), kind);
        return kind;
    }

    private static ValueType valueTypeOf(EntityProxy.Concept concept, LanguageCalculator names,
                                         Map<Integer, Set<Integer>> parents, Map<Integer, Set<Integer>> children,
                                         Map<Integer, NodeKind> kindsByNid, Map<Integer, EnumerationValue> enumerations) {
        int nid = concept.nid();
        NodeKind kind = kindsByNid.get(nid);
        if (kind != null) {
            return new KindValue(kind);
        }
        Set<Integer> conceptParents = parents.getOrDefault(nid, Set.of());
        if (conceptParents.contains(IkeTerms.ELM_PRIMITIVE.nid())) {
            String label = labelOf(names, concept);
            return new PrimitiveValue(stripTag(label).substring("ELM primitive ".length()), concept);
        }
        if (conceptParents.contains(IkeTerms.ELM_EXTERNAL_TYPE.nid())) {
            return new ExternalValue(concept);
        }
        EnumerationValue enumeration = enumerations.get(nid);
        if (enumeration == null) {
            enumeration = new EnumerationValue(concept, Set.copyOf(children.getOrDefault(nid, Set.of())));
            enumerations.put(nid, enumeration);
        }
        return enumeration;
    }

    private static void collectFamily(StampCalculator calculator, int nid, Map<Integer, Set<Integer>> children,
                                      Map<Integer, Set<Integer>> parents, Set<Integer> visited) {
        if (!visited.add(nid)) {
            return;
        }
        // Children are found through their own stated parents: every concept whose stated
        // definition names this one. The store answers that through the stated-axiom
        // semantics of each candidate, so the walk reads each candidate's parents once.
        for (int child : statedChildren(calculator, nid)) {
            children.computeIfAbsent(nid, k -> new HashSet<>()).add(child);
            parents.computeIfAbsent(child, k -> new HashSet<>()).add(nid);
            collectFamily(calculator, child, children, parents, visited);
        }
    }

    private static Set<Integer> statedChildren(StampCalculator calculator, int parentNid) {
        // A parent is named inside its children's stated-axiom trees, which the store indexes
        // by the child, not the parent, so children come from one scan of the concepts.
        return FamilyScan.conceptsNamingAsParent(calculator, parentNid);
    }

    private static void descendants(int nid, Map<Integer, Set<Integer>> children, Set<Integer> into) {
        for (int child : children.getOrDefault(nid, Set.of())) {
            if (into.add(child)) {
                descendants(child, children, into);
            }
        }
    }

    private static String labelOf(LanguageCalculator names, EntityProxy.Concept concept) {
        return names.getFullyQualifiedNameText(concept)
                .orElseThrow(() -> new IllegalStateException("No fully qualified name for " + concept.nid()));
    }

    private static String kindNameOf(LanguageCalculator names, EntityProxy.Concept concept) {
        String label = labelOf(names, concept);
        return stripTag(label).substring("ELM ".length());
    }

    private static String positionNameOf(LanguageCalculator names, EntityProxy.Concept concept) {
        String label = stripTag(labelOf(names, concept)).substring("ELM ".length());
        int comma = label.indexOf(", ");
        if (comma >= 0) {
            label = label.substring(0, comma);
        }
        if (label.endsWith(" position")) {
            label = label.substring(0, label.length() - " position".length());
        }
        return label;
    }

    private static String stripTag(String label) {
        int tag = label.lastIndexOf(" (");
        return tag >= 0 ? label.substring(0, tag) : label;
    }

    /**
     * Finds the concepts whose latest stated definition names a given parent. The store indexes
     * stated axioms by the child, so this scans the concepts once and keeps what it learns.
     */
    static final class FamilyScan {

        private static Map<Integer, Set<Integer>> childrenByParent;
        private static StampCalculator scannedWith;

        private FamilyScan() {
        }

        static synchronized Set<Integer> conceptsNamingAsParent(StampCalculator calculator, int parentNid) {
            if (childrenByParent == null || scannedWith != calculator) {
                Map<Integer, Set<Integer>> map = new HashMap<>();
                EntityService.get().forEachConceptEntity(concept -> {
                    for (int parent : statedParents(calculator, concept.nid())) {
                        map.computeIfAbsent(parent, k -> new HashSet<>()).add(concept.nid());
                    }
                });
                childrenByParent = map;
                scannedWith = calculator;
            }
            return childrenByParent.getOrDefault(parentNid, Set.of());
        }

        private static Set<Integer> statedParents(StampCalculator calculator, int conceptNid) {
            Set<Integer> parents = new HashSet<>();
            calculator.forEachSemanticVersionForComponentOfPattern(EntityProxy.Concept.make(conceptNid),
                    TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN,
                    (semanticVersion, entityVersion, patternVersion) -> {
                        DiTreeEntity tree = (DiTreeEntity) semanticVersion.fieldValues().get(0);
                        AxiomDecompiler.Result result = AxiomDecompiler.decompile(tree);
                        if (result.simpleIsA()) {
                            result.parents().forEach(parent -> parents.add(parent.nid()));
                        }
                    });
            return parents;
        }
    }
}
