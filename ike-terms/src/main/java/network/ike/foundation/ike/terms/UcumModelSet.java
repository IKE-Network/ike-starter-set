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
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * What is ours about the Unified Code for Units of Measure (IKE-Network/ike-issues#1114): the
 * parents its properties, prefixes, and composed units hang under, the patterns that record
 * what UCUM says of a unit and what IKE computes from it, and the dialect its names and symbols
 * are read in. The units themselves are imported knowledge, read from the unmodified UCUM file
 * when a knowledge base is assembled, never authored here.
 */
final class UcumModelSet {

    /** The family root. */
    static final String ROOT_FQN = "Unified Code for Units of Measure (IkeFoundation)";

    /** The parent of the imported properties, each the parent of its units. */
    static final String PROPERTY_FQN = "UCUM property (IkeFoundation)";

    /** The parent of the imported prefixes. */
    static final String PREFIX_FQN = "UCUM prefix (IkeFoundation)";

    /** The parent of the units composed on demand. */
    static final String COMPOSED_UNIT_FQN = "UCUM composed unit (IkeFoundation)";

    /** What UCUM says of a unit, kept verbatim, and what IKE computes from it. */
    static final String UNIT_PATTERN_FQN = "UCUM Unit Pattern (IkeFoundation)";

    /** What UCUM says of a prefix, kept verbatim. */
    static final String PREFIX_PATTERN_FQN = "UCUM Prefix Pattern (IkeFoundation)";

    /** A unit composed from UCUM's grammar: its canonical code and its reduction. */
    static final String COMPOSED_UNIT_PATTERN_FQN = "UCUM Composed Unit Pattern (IkeFoundation)";

    /** Whether a description is preferred or acceptable in the UCUM dialect. */
    static final String DIALECT_PATTERN_FQN = "UCUM Dialect Pattern (IkeFoundation)";

    private UcumModelSet() {
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
                .synonym("UCUM")
                .definition("The Unified Code for Units of Measure as knowledge: its properties, its"
                        + " units, its prefixes, and the units composed from them, read from the"
                        + " unmodified UCUM file when a knowledge base is assembled, every code, name,"
                        + " symbol, and definition UCUM's own. What hangs here that IKE adds is marked"
                        + " as IKE's: the identities, the patterns, and the dimensions and magnitudes"
                        + " computed from UCUM's definitions.")
                .isA(modelRoot);
        EntityProxy.Concept root = set.conceptRef(ROOT_FQN);

        set.concept(PROPERTY_FQN).at(inception)
                .synonym("UCUM property")
                .definition("What a unit measures, in UCUM's word for it: length, mass, time, pressure."
                        + " Each imported property is a concept under this one, and each unit hangs"
                        + " under its property, so a unit's place says what it measures.")
                .isA(root);
        set.concept(PREFIX_FQN).at(inception)
                .synonym("UCUM prefix")
                .definition("A multiplier a metric unit may carry, kilo through yocto: a concept for"
                        + " each of UCUM's prefixes, with its code, name, symbol, and factor.")
                .isA(root);
        set.concept(COMPOSED_UNIT_FQN).at(inception)
                .synonym("UCUM composed unit")
                .definition("A unit built by UCUM's grammar from prefixes, units, powers, products, and"
                        + " quotients, such as mg/dL or kg.m/s2, made when it is first met and never"
                        + " listed in advance. It is identified by its canonical content, so one unit"
                        + " spelled two ways is one concept, and the spelling a library used stays on"
                        + " its tree.")
                .isA(root);

        // ── The dialect ──
        set.concept("UCUM dialect (IkeFoundation)").at(inception)
                .synonym("UCUM dialect")
                .definition("The dialect in which a unit's UCUM name and print symbol are read, so that"
                        + " a unit is found by either, the way a definition is found by its name.")
                .isA(root);
        set.pattern(DIALECT_PATTERN_FQN).at(inception)
                .meaning(IkeTerm.DESCRIPTION_ACCEPTABILITY)
                .purpose(IkeTerm.DESCRIPTION_SEMANTIC)
                .field(set.conceptRef("UCUM dialect (IkeFoundation)"), IkeTerm.DESCRIPTION_ACCEPTABILITY,
                        IkeTerm.COMPONENT_FIELD)
                .definition("Records whether a description is preferred or acceptable in the UCUM"
                        + " dialect. One field: that description's acceptability for this dialect.");

        // ── Field meanings and purposes ──
        String[][] fields = {
            {"UCUM code", "The code UCUM gives a unit or a prefix, case-sensitive, as written: mg, min, mm[Hg]."},
            {"UCUM case-insensitive code", "The code UCUM gives for systems that cannot keep case, as written."},
            {"UCUM print symbol", "The symbol UCUM prints for a unit or a prefix, as written."},
            {"UCUM class", "The class UCUM files a unit under, as written: si, iso1000, clinical, and the rest."},
            {"UCUM metric", "Whether UCUM marks the unit metric, so that it may carry a prefix."},
            {"UCUM special", "Whether UCUM marks the unit special: defined by a function rather than a factor,"
                    + " like degrees Celsius, so that it does not convert by a ratio."},
            {"UCUM arbitrary", "Whether UCUM marks the unit arbitrary: a procedure-defined unit like an"
                    + " international unit, which never converts."},
            {"UCUM definition value", "The number in UCUM's definition of the unit, as written."},
            {"UCUM definition unit", "The unit UCUM defines the unit in terms of, as written."},
            {"UCUM prefix factor", "The multiplier a prefix stands for, as UCUM writes it."},
            {"Unit canonical code", "IKE's canonical spelling of a composed unit: its factors in one fixed"
                    + " order, the seed of its identity."},
            {"Unit dimension", "IKE's reduction of a unit to the base dimensions, so much length, mass, time,"
                    + " charge, temperature, luminous intensity, and angle, computed from UCUM's definitions;"
                    + " two units convert only when their dimensions agree."},
            {"Unit magnitude", "IKE's reduction of a unit to a magnitude in the base units, computed from"
                    + " UCUM's definitions; two commensurable units convert by the ratio of their magnitudes."},
            {"UCUM record", "Why a field is recorded: it is what UCUM says, kept verbatim."},
            {"Unit reduction", "Why a field is recorded: it is what IKE computes from UCUM's definitions, and"
                    + " is IKE's, not UCUM's."},
        };
        for (String[] field : fields) {
            set.concept(field[0] + " (IkeFoundation)").at(inception)
                    .synonym(field[0])
                    .definition(field[1])
                    .isA(root);
        }
        EntityProxy.Concept record = set.conceptRef("UCUM record (IkeFoundation)");
        EntityProxy.Concept reduction = set.conceptRef("Unit reduction (IkeFoundation)");

        // ── The unit pattern ──
        set.pattern(UNIT_PATTERN_FQN).at(inception)
                .meaning(root)
                .purpose(record)
                .field(set.conceptRef("UCUM code (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("UCUM case-insensitive code (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("UCUM print symbol (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("UCUM class (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("UCUM metric (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("UCUM special (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("UCUM arbitrary (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("UCUM definition value (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("UCUM definition unit (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("Unit dimension (IkeFoundation)"), reduction, IkeTerm.STRING)
                .field(set.conceptRef("Unit magnitude (IkeFoundation)"), reduction, IkeTerm.DECIMAL_FIELD)
                .definition("What UCUM says of one unit, kept verbatim, and what IKE computes from it: the"
                        + " code, the case-insensitive code, the print symbol, the class, whether metric,"
                        + " special, or arbitrary, the definition's value and unit as written, and IKE's"
                        + " dimension and magnitude. A base unit's definition is empty and its magnitude"
                        + " one.");

        // ── The prefix pattern ──
        set.pattern(PREFIX_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef(PREFIX_FQN))
                .purpose(record)
                .field(set.conceptRef("UCUM code (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("UCUM case-insensitive code (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("UCUM print symbol (IkeFoundation)"), record, IkeTerm.STRING)
                .field(set.conceptRef("UCUM prefix factor (IkeFoundation)"), record, IkeTerm.DECIMAL_FIELD)
                .definition("What UCUM says of one prefix, kept verbatim: the code, the case-insensitive"
                        + " code, the print symbol, and the factor.");

        // ── The composed unit pattern ──
        set.pattern(COMPOSED_UNIT_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef(COMPOSED_UNIT_FQN))
                .purpose(reduction)
                .field(set.conceptRef("Unit canonical code (IkeFoundation)"), reduction, IkeTerm.STRING)
                .field(set.conceptRef("Unit dimension (IkeFoundation)"), reduction, IkeTerm.STRING)
                .field(set.conceptRef("Unit magnitude (IkeFoundation)"), reduction, IkeTerm.DECIMAL_FIELD)
                .field(set.conceptRef("UCUM special (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .field(set.conceptRef("UCUM arbitrary (IkeFoundation)"), record, IkeTerm.BOOLEAN_FIELD)
                .definition("A unit composed by UCUM's grammar: its canonical code, IKE's dimension and"
                        + " magnitude for it, and whether any factor is special or arbitrary, in which case"
                        + " it does not convert.");
    }
}
