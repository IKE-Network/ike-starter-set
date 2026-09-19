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

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.terms.EntityFacade;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.writer.StoreWriter;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The import gate (IKE-Network/ike-issues#1114): the file's counts become concepts with every
 * field verbatim under their properties, found by name and symbol in the UCUM dialect; the
 * four identities are admitted and the calendar units say what they are not; importing again
 * writes nothing; and a composed unit is one concept however it is spelled.
 */
class UcumImporterIT {

    private static StampCalculator calculator;
    private static UcumEssence essence;
    private static UcumImporter.Report report;

    private record Description(int nid, String text, int typeNid) {
    }

    @BeforeAll
    static void boot() throws Exception {
        calculator = Store.boot();
        essence = UcumEssence.read();
        report = new UcumImporter(calculator).importEssence(essence, Store.nextStamp());
    }

    private static int nid(PublicId id) {
        return PrimitiveData.nid(id);
    }

    private static List<ImmutableList<Object>> semanticsAbout(int componentNid, EntityProxy.Pattern pattern) {
        List<ImmutableList<Object>> fields = new ArrayList<>();
        EntityService.get().forEachSemanticForComponentOfPattern(componentNid, pattern.nid(), semantic -> {
            Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
            if (latest.isPresent()) {
                fields.add(latest.get().fieldValues());
            }
        });
        return fields;
    }

    private static ImmutableList<Object> record(PublicId concept, EntityProxy.Pattern pattern) {
        List<ImmutableList<Object>> records = semanticsAbout(nid(concept), pattern);
        assertEquals(1, records.size(), concept + " has one record");
        return records.get(0);
    }

    private static Set<Integer> statedParents(PublicId concept) {
        Set<Integer> parents = new HashSet<>();
        for (ImmutableList<Object> fields : semanticsAbout(nid(concept), TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN)) {
            DiTreeEntity tree = (DiTreeEntity) fields.get(0);
            collectReferences(tree, tree.root(), parents);
        }
        return parents;
    }

    private static void collectReferences(DiTreeEntity tree, EntityVertex vertex, Set<Integer> found) {
        for (Object value : vertex.properties().values()) {
            if (value instanceof EntityFacade facade) {
                found.add(facade.nid());
            }
        }
        for (int child : tree.successors(vertex.vertexIndex()).toArray()) {
            collectReferences(tree, tree.vertex(child), found);
        }
    }

    private static List<Description> descriptions(int componentNid) {
        List<Description> found = new ArrayList<>();
        EntityService.get().forEachSemanticForComponentOfPattern(componentNid, TinkarTerm.DESCRIPTION_PATTERN.nid(),
                semantic -> {
                    Latest<SemanticEntityVersion> latest = calculator.latest(semantic.nid());
                    if (latest.isPresent()) {
                        ImmutableList<Object> fields = latest.get().fieldValues();
                        found.add(new Description(semantic.nid(), (String) fields.get(1),
                                ((EntityFacade) fields.get(3)).nid()));
                    }
                });
        return found;
    }

    private static boolean readInUcumDialect(int descriptionNid) {
        return !semanticsAbout(descriptionNid, IkeTerms.UCUM_DIALECT_PATTERN).isEmpty();
    }

    private static boolean hasDescription(int componentNid, EntityProxy.Concept type, String text, boolean inUcumDialect) {
        for (Description description : descriptions(componentNid)) {
            if (description.typeNid() == type.nid() && description.text().equals(text)
                    && (!inUcumDialect || readInUcumDialect(description.nid()))) {
                return true;
            }
        }
        return false;
    }

    @Test
    @DisplayName("The import yields 101 properties, 7 base units, 305 units, 24 prefixes, the millisecond, and 4 relations")
    void theCountsAreTheFiles() {
        assertEquals(101, report.properties());
        assertEquals(7, report.baseUnits());
        assertEquals(305, report.units());
        assertEquals(24, report.prefixes());
        assertEquals(1, report.composedUnits());
        assertEquals(4, report.relations());
        assertTrue(report.counts().written() > 0);
        assertEquals(0, report.counts().versioned());
    }

    @Test
    @DisplayName("Every unit and prefix is in the store with its fields verbatim, under its property, IKE's reduction beside them")
    void everyUnitIsInTheStoreVerbatim() {
        for (UcumEssence.BaseUnit base : essence.baseUnits()) {
            PublicId id = UcumIdentity.unit(base.code());
            ImmutableList<Object> fields = record(id, IkeTerms.UCUM_UNIT_PATTERN);
            assertEquals(base.code(), fields.get(0));
            assertEquals(base.caseInsensitiveCode(), fields.get(1));
            assertEquals(base.printSymbol(), fields.get(2));
            assertEquals("", fields.get(3), "a base unit has no class");
            assertEquals(true, fields.get(4), "a base unit is metric");
            assertEquals(false, fields.get(5));
            assertEquals(false, fields.get(6));
            assertEquals("", fields.get(7));
            assertEquals("", fields.get(8));
            assertEquals(base.dimension(), fields.get(9));
            assertEquals(0, BigDecimal.ONE.compareTo((BigDecimal) fields.get(10)));
            assertTrue(statedParents(id).contains(nid(UcumIdentity.property(base.property()))),
                    base.code() + " hangs under " + base.property());
        }
        for (UcumEssence.Unit unit : essence.units()) {
            PublicId id = UcumIdentity.unit(unit.code());
            ImmutableList<Object> fields = record(id, IkeTerms.UCUM_UNIT_PATTERN);
            assertEquals(unit.code(), fields.get(0));
            assertEquals(unit.caseInsensitiveCode(), fields.get(1));
            assertEquals(unit.printSymbol(), fields.get(2));
            assertEquals(unit.unitClass(), fields.get(3));
            assertEquals(unit.metric(), fields.get(4));
            assertEquals(unit.special(), fields.get(5));
            assertEquals(unit.arbitrary(), fields.get(6));
            assertEquals(unit.definitionNumber(), fields.get(7));
            assertEquals(unit.definitionUnit(), fields.get(8));
            UcumReduction reduction = essence.reduction(unit.code());
            assertEquals(reduction.dimension(), fields.get(9), unit.code() + " dimension");
            assertEquals(0, reduction.magnitude().compareTo((BigDecimal) fields.get(10)), unit.code() + " magnitude");
            assertTrue(statedParents(id).contains(nid(UcumIdentity.property(unit.property()))),
                    unit.code() + " hangs under " + unit.property());
        }
        for (String property : essence.properties()) {
            assertTrue(statedParents(UcumIdentity.property(property)).contains(IkeTerms.UCUM_PROPERTY.nid()),
                    property + " hangs under the UCUM property parent");
        }
        for (UcumEssence.Prefix prefix : essence.prefixes()) {
            PublicId id = UcumIdentity.prefix(prefix.code());
            ImmutableList<Object> fields = record(id, IkeTerms.UCUM_PREFIX_PATTERN);
            assertEquals(prefix.code(), fields.get(0));
            assertEquals(prefix.caseInsensitiveCode(), fields.get(1));
            assertEquals(prefix.printSymbol(), fields.get(2));
            assertEquals(0, prefix.factor().compareTo((BigDecimal) fields.get(3)));
            assertTrue(statedParents(id).contains(IkeTerms.UCUM_PREFIX.nid()), prefix.code() + " hangs under the prefix parent");
        }
    }

    @Test
    @DisplayName("A unit is found by each of its names and by its print symbol, read in the UCUM dialect")
    void aUnitIsFoundByItsNamesAndSymbol() {
        for (UcumEssence.Unit unit : essence.units()) {
            int nid = nid(UcumIdentity.unit(unit.code()));
            for (String name : unit.names()) {
                assertTrue(hasDescription(nid, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, name, true),
                        unit.code() + " is found by " + name);
            }
            if (!unit.printSymbol().isEmpty()) {
                assertTrue(hasDescription(nid, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, unit.printSymbol(), true),
                        unit.code() + " is found by its symbol " + unit.printSymbol());
            }
            assertTrue(hasDescription(nid, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE,
                    unit.names().get(0) + ", " + unit.code() + " (UCUM)", false), unit.code() + " fully qualified");
        }
        assertTrue(hasDescription(nid(UcumIdentity.unit("min")), TinkarTerm.DEFINITION_DESCRIPTION_TYPE, "60 s", false),
                "the definition as UCUM writes it");
        assertTrue(hasDescription(nid(UcumIdentity.unit("Cel")), TinkarTerm.DEFINITION_DESCRIPTION_TYPE, "1 cel(1 K)", false),
                "a special unit's definition names its function");
        assertTrue(descriptions(nid(UcumIdentity.unit("m"))).stream()
                .noneMatch(d -> d.typeNid() == TinkarTerm.DEFINITION_DESCRIPTION_TYPE.nid()), "a base unit has no definition");
        int time = nid(UcumIdentity.property("time"));
        assertTrue(hasDescription(time, TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE, "time (UCUM property)", false));
        assertTrue(hasDescription(time, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, "time", true));
        int kilo = nid(UcumIdentity.prefix("k"));
        assertTrue(hasDescription(kilo, TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, "kilo", true));
        assertTrue(hasDescription(kilo, TinkarTerm.DEFINITION_DESCRIPTION_TYPE, "1e3", false));
    }

    @Test
    @DisplayName("The four identities are admitted, and the four calendar units say which UCUM unit they are not")
    void theFourIdentitiesAndTheCalendarSentences() {
        assertIdentity(UcumIdentity.unit("s"), IkeTerms.SECOND);
        assertIdentity(UcumIdentity.unit("min"), IkeTerms.MINUTE);
        assertIdentity(UcumIdentity.unit("h"), IkeTerms.HOUR);
        assertIdentity(UcumIdentity.composedUnit("ms"), IkeTerms.MILLISECOND);
        ImmutableList<Object> millisecond = record(UcumIdentity.composedUnit("ms"), IkeTerms.UCUM_COMPOSED_UNIT_PATTERN);
        assertEquals("ms", millisecond.get(0));
        assertEquals("T", millisecond.get(1));
        assertEquals(0, new BigDecimal("0.001").compareTo((BigDecimal) millisecond.get(2)));
        assertEquals(false, millisecond.get(3));
        assertEquals(false, millisecond.get(4));
        assertTrue(statedParents(UcumIdentity.composedUnit("ms")).contains(IkeTerms.UCUM_COMPOSED_UNIT.nid()));
        for (Map.Entry<EntityProxy.Concept, String> calendar : Map.of(IkeTerms.DAY, "UCUM's d,", IkeTerms.WEEK, "UCUM's wk",
                IkeTerms.MONTH, "UCUM's mo", IkeTerms.YEAR, "UCUM's a").entrySet()) {
            assertTrue(descriptions(calendar.getKey().nid()).stream().anyMatch(d ->
                            d.typeNid() == TinkarTerm.DEFINITION_DESCRIPTION_TYPE.nid() && d.text().contains(calendar.getValue())),
                    calendar.getKey().description() + " says it is not " + calendar.getValue());
        }
        for (EntityProxy.Concept ours : List.of(IkeTerms.DAY, IkeTerms.WEEK, IkeTerms.MONTH, IkeTerms.YEAR)) {
            assertTrue(descriptions(ours.nid()).stream().noneMatch(d -> d.text().contains("(UCUM)")),
                    ours.description() + " claims no UCUM identity");
        }
    }

    private static void assertIdentity(PublicId unit, EntityProxy.Concept ours) {
        List<ImmutableList<Object>> relations = semanticsAbout(nid(unit), IkeTerms.CONSTRUCT_RELATION_PATTERN);
        assertEquals(1, relations.size(), unit + " relates once");
        assertEquals(ours.nid(), ((EntityFacade) relations.get(0).get(0)).nid(), "the target is ours");
        assertEquals(IkeTerms.IDENTITY.nid(), ((EntityFacade) relations.get(0).get(1)).nid(), "the kind is identity");
    }

    @Test
    @DisplayName("Importing the file again writes nothing new")
    void importingAgainWritesNothingNew() {
        UcumImporter.Report again = new UcumImporter(calculator).importEssence(essence, Store.nextStamp());
        assertEquals(0, again.counts().written());
        assertEquals(0, again.counts().versioned());
        assertTrue(again.counts().unchanged() > 0);
    }

    @Test
    @DisplayName("A composed unit is one concept however it is spelled, made once; an atom is its own concept")
    void aComposedUnitIsOneConceptHoweverSpelled() {
        UcumUnits units = UcumUnits.load(calculator);
        assertFalse(units.isEmpty());
        assertEquals(312, units.atomCodes().size());
        assertEquals(24, units.prefixCodes().size());
        UcumTerm slash = units.parse("mg/dL");
        UcumTerm power = units.parse("mg.dL-1");
        assertEquals(slash.canonicalCode(), power.canonicalCode());
        StoreWriter writer = new StoreWriter(calculator, Store.nextStamp());
        PublicId first = units.write(slash, writer);
        int written = writer.counts().written();
        assertTrue(written > 0, "the first spelling makes the concept");
        PublicId second = units.write(power, writer);
        assertEquals(nid(first), nid(second), "one concept");
        assertEquals(nid(UcumIdentity.composedUnit("mg.dL-1")), nid(first));
        assertEquals(written, writer.counts().written(), "the second spelling writes nothing new");
        ImmutableList<Object> record = record(first, IkeTerms.UCUM_COMPOSED_UNIT_PATTERN);
        assertEquals("mg.dL-1", record.get(0));
        assertEquals("L-3.M", record.get(1));
        assertEquals(0, new BigDecimal("10").compareTo((BigDecimal) record.get(2)), "ten grams per cubic meter");
        assertEquals(false, record.get(3));
        assertEquals(false, record.get(4));
        assertTrue(statedParents(first).contains(IkeTerms.UCUM_COMPOSED_UNIT.nid()));
        assertTrue(hasDescription(nid(first), TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, "mg.dL-1", true));
        assertEquals(nid(UcumIdentity.unit("m")), nid(units.write(units.parse("m{tissue}"), writer)), "an annotated atom is the atom");
        assertEquals(nid(UcumIdentity.unit("cd")), nid(units.identity(units.parse("cd"))));
        assertThrows(UcumSyntaxException.class, () -> units.parse("xyz"));
        assertEquals(0, essence.reduction("Pa").magnitude().compareTo(units.reduction("Pa").magnitude()),
                "the store says what the file says");
        assertTrue(units.parse("Cel/min").reduce(units).special(), "a special factor flags the composed unit");
    }
}
