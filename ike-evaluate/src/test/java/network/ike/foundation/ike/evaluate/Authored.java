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
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.builder.Stamp;
import dev.ikm.tinkar.terms.TinkarTerm;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.writer.StoreWriter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * The statements, subjects, and concept sets the gates evaluate against: a real statement
 * source over statements authored here, until the store-backed source lands with the ANF
 * pattern. Two subjects, a child and an adult; the child's pharyngitis, the office visit that
 * found it, the prescription written at that visit and one written before, and the strep test
 * that was run; the adult's own pharyngitis.
 */
final class Authored {

    private static final UUID NAMESPACE = UUID.fromString("7c1e5b2a-9d3f-5a6e-8b40-1c2d3e4f5a6b");

    static final PublicId CHILD = id("subject child");
    static final PublicId ADULT = id("subject adult");

    /** The topics, written into the store once. */
    static final PublicId PHARYNGITIS = id("concept acute pharyngitis");
    static final PublicId TONSILLITIS = id("concept acute tonsillitis");
    static final PublicId OFFICE_VISIT = id("concept office visit");
    static final PublicId WELLNESS_VISIT = id("concept annual wellness visit");
    static final PublicId AMOXICILLIN = id("concept amoxicillin");
    static final PublicId STREP_TEST = id("concept group A streptococcus test");

    /** The value set identifiers the corpus names, each to its authored members. */
    static final String ACUTE_PHARYNGITIS = "2.16.840.1.113883.3.464.1003.102.12.1011";
    static final String ACUTE_TONSILLITIS = "2.16.840.1.113883.3.464.1003.102.12.1012";
    static final String AMBULATORY_VISIT = "2.16.840.1.113883.3.464.1003.101.12.1061";
    static final String ANTIBIOTICS = "2.16.840.1.113883.3.464.1003.196.12.1001";
    static final String STREP_TESTS = "2.16.840.1.113883.3.464.1003.198.12.1012";
    static final String QDM_OFFICE_VISIT = "urn:oid:2.16.840.1.113883.3.464.1003.101.12.1001";
    static final String QDM_WELLNESS_VISIT = "urn:oid:2.16.840.1.113883.3.526.3.1240";
    static final String QDM_HOME_HEALTH = "urn:oid:2.16.840.1.113883.3.464.1003.101.12.1016";
    static final String QDM_PREVENTIVE_ESTABLISHED = "urn:oid:2.16.840.1.113883.3.464.1003.101.12.1025";
    static final String QDM_PREVENTIVE_INITIAL = "urn:oid:2.16.840.1.113883.3.464.1003.101.12.1023";

    private static final Map<PublicId, Integer> NIDS = new HashMap<>();

    private Authored() {
    }

    static PublicId id(String name) {
        return PublicIds.of(UuidT5Generator.get(NAMESPACE, name));
    }

    /** Writes the topics as concepts, named. */
    static synchronized void write(StampCalculator calculator, Stamp stamp) {
        if (!NIDS.isEmpty()) {
            return;
        }
        StoreWriter writer = new StoreWriter(calculator, stamp);
        Map<PublicId, String> names = Map.of(PHARYNGITIS, "Acute pharyngitis", TONSILLITIS, "Acute tonsillitis",
                OFFICE_VISIT, "Office visit", WELLNESS_VISIT, "Annual wellness visit", AMOXICILLIN, "Amoxicillin",
                STREP_TEST, "Group A streptococcus test");
        for (Map.Entry<PublicId, String> entry : names.entrySet()) {
            int nid = writer.concept(entry.getKey());
            writer.describe(nid, UuidT5Generator.get(NAMESPACE, entry.getValue() + " name"), entry.getValue(),
                    TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE, TinkarTerm.PREFERRED);
            NIDS.put(entry.getKey(), nid);
        }
    }

    static int nid(PublicId concept) {
        Integer nid = NIDS.get(concept);
        if (nid == null) {
            throw new IllegalStateException("the topics are not written yet");
        }
        return nid;
    }

    /** The child: born 2005-06-15, seven at the start of 2013. */
    static Subject child() {
        return new Subject(CHILD, Optional.of(Instants.date(2005, Optional.of(6), Optional.of(15))));
    }

    /** The adult: born 1980-02-01. */
    static Subject adult() {
        return new Subject(ADULT, Optional.of(Instants.date(1980, Optional.of(2), Optional.of(1))));
    }

    /** An instant written to the minute, in UTC. */
    static Measure at(int year, int month, int day, int hour, int minute) {
        return Instants.dateTime(year, Optional.of(month), Optional.of(day), Optional.of(hour), Optional.of(minute),
                Optional.empty(), Optional.empty(), Optional.empty());
    }

    /** A day, written as a date. */
    static Measure day(int year, int month, int day) {
        return Instants.date(year, Optional.of(month), Optional.of(day));
    }

    /** The extent from one written value to another, both ends included. */
    static Measure through(Measure from, Measure to) {
        return Measure.extent(from.lower(), to.upper(), true, true, from.semantic(), from.resolution());
    }

    /** The extent of one written value: what it spans. */
    static Measure during(Measure value) {
        return through(value, value);
    }

    /** The measurement period the corpus's parameter names: 2013, the end excluded. */
    static Measure measurementPeriod() {
        Measure start = Instants.dateTime(2013, Optional.of(1), Optional.of(1), Optional.of(0), Optional.of(0),
                Optional.of(0), Optional.of(0), Optional.empty());
        Measure end = Instants.dateTime(2014, Optional.of(1), Optional.of(1), Optional.of(0), Optional.of(0),
                Optional.of(0), Optional.of(0), Optional.empty());
        return Measure.extent(start.lower(), end.lower(), true, false, MeasureSemantic.EPOCH, start.resolution());
    }

    /** The statements: the child's episode and the adult's own. */
    static AuthoredStatements statements() {
        Subject child = child();
        Subject adult = adult();
        List<Statement> statements = new ArrayList<>();
        Measure onset = day(2013, 3, 1);
        Measure abatement = day(2013, 3, 10);
        statements.add(new Statement(id("statement child pharyngitis"), child, nid(PHARYNGITIS),
                IkeTerms.PERFORMANCE_CIRCUMSTANCE.nid(), Optional.empty(), through(onset, abatement), Optional.empty(),
                at(2013, 3, 1, 9, 0), List.of()));
        statements.add(new Statement(id("statement child office visit"), child, nid(OFFICE_VISIT),
                IkeTerms.PERFORMANCE_CIRCUMSTANCE.nid(), Optional.empty(), through(at(2013, 3, 2, 9, 0), at(2013, 3, 2, 10, 0)),
                Optional.empty(), at(2013, 3, 2, 9, 0), List.of()));
        statements.add(new Statement(id("statement child prescription"), child, nid(AMOXICILLIN),
                IkeTerms.REQUEST_CIRCUMSTANCE.nid(), Optional.empty(), during(at(2013, 3, 2, 10, 30)), Optional.empty(),
                at(2013, 3, 2, 10, 30), List.of()));
        statements.add(new Statement(id("statement child prior prescription"), child, nid(AMOXICILLIN),
                IkeTerms.REQUEST_CIRCUMSTANCE.nid(), Optional.empty(), during(at(2013, 2, 20, 10, 0)), Optional.empty(),
                at(2013, 2, 20, 10, 0), List.of()));
        statements.add(new Statement(id("statement child strep test"), child, nid(STREP_TEST),
                IkeTerms.PERFORMANCE_CIRCUMSTANCE.nid(), Optional.empty(), during(at(2013, 3, 2, 9, 30)),
                Optional.of(Measure.point(BigDecimal.ONE, MeasureSemantic.DIMENSIONLESS)), at(2013, 3, 2, 11, 0), List.of()));
        statements.add(new Statement(id("statement adult pharyngitis"), adult, nid(PHARYNGITIS),
                IkeTerms.PERFORMANCE_CIRCUMSTANCE.nid(), Optional.empty(), through(day(2013, 5, 1), day(2013, 5, 8)),
                Optional.empty(), at(2013, 5, 1, 8, 0), List.of()));
        return new AuthoredStatements(statements);
    }

    /** The concept sets the corpus names, by value set identifier. */
    static AuthoredConceptSets conceptSets() {
        Map<String, Set<Integer>> sets = new HashMap<>();
        sets.put(ACUTE_PHARYNGITIS, Set.of(nid(PHARYNGITIS)));
        sets.put(ACUTE_TONSILLITIS, Set.of(nid(TONSILLITIS)));
        sets.put(AMBULATORY_VISIT, Set.of(nid(OFFICE_VISIT)));
        sets.put(ANTIBIOTICS, Set.of(nid(AMOXICILLIN)));
        sets.put(STREP_TESTS, Set.of(nid(STREP_TEST)));
        sets.put(QDM_OFFICE_VISIT, Set.of(nid(OFFICE_VISIT)));
        sets.put(QDM_WELLNESS_VISIT, Set.of(nid(WELLNESS_VISIT)));
        sets.put(QDM_HOME_HEALTH, Set.of());
        sets.put(QDM_PREVENTIVE_ESTABLISHED, Set.of());
        sets.put(QDM_PREVENTIVE_INITIAL, Set.of());
        return new AuthoredConceptSets(sets);
    }

    /** A statement source over a list. */
    record AuthoredStatements(List<Statement> statements) implements StatementSource {
        @Override
        public List<Statement> statementsOf(Subject subject) {
            return statements.stream().filter(statement -> statement.subject().id().equals(subject.id())).toList();
        }

        @Override
        public List<Statement> all() {
            return statements;
        }
    }

    /** A concept set source over a map. */
    record AuthoredConceptSets(Map<String, Set<Integer>> sets) implements ConceptSetSource {
        @Override
        public Optional<Set<Integer>> members(String identifier) {
            return Optional.ofNullable(sets.get(identifier));
        }
    }
}
