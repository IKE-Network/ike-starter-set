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
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.entity.builder.Stamp;
import network.ike.foundation.ike.bindings.IkeTerms;
import network.ike.foundation.ike.writer.StoreWriter;

import java.util.List;

/**
 * Reads the unmodified UCUM file into the store as knowledge (IKE-Network/ike-issues#1114):
 * a concept for each property, each base unit and defined unit under its property, and each
 * prefix, every code, name, symbol, class, and definition kept verbatim in the concept's
 * record, IKE's reduction to the base units beside them marked as IKE's, and the four
 * relations that say UCUM's second, minute, hour, and millisecond are IKE's own units of that
 * name. Every identity is derived from the code, so importing twice writes nothing new, and a
 * changed file appends versions where content changed.
 */
public final class UcumImporter {

    /**
     * What an import did.
     *
     * @param properties    how many properties became concepts
     * @param baseUnits     how many base units
     * @param units         how many defined units
     * @param prefixes      how many prefixes
     * @param composedUnits how many composed units the import itself made, the millisecond
     * @param relations     how many identity relations
     * @param counts        what the writer did: written, unchanged, versioned, retired
     */
    public record Report(int properties, int baseUnits, int units, int prefixes, int composedUnits, int relations,
                         StoreWriter.Counts counts) {
    }

    private final StampCalculator calculator;

    /**
     * Creates an importer over a view.
     *
     * @param calculator the view that decides which existing versions count
     */
    public UcumImporter(StampCalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Imports the file under a stamp.
     *
     * @param essence the file, read
     * @param stamp   the stamp every new version is written under
     * @return what was done
     */
    public Report importEssence(UcumEssence essence, Stamp stamp) {
        StoreWriter writer = new StoreWriter(calculator, stamp);
        for (String property : essence.properties()) {
            UcumConcepts.property(writer, property);
        }
        for (UcumEssence.BaseUnit base : essence.baseUnits()) {
            UcumConcepts.unit(writer, base.code(), base.caseInsensitiveCode(), List.of(base.name()), base.printSymbol(),
                    base.property(), "", true, false, false, "", "", essence.reduction(base.code()));
        }
        for (UcumEssence.Unit unit : essence.units()) {
            UcumConcepts.unit(writer, unit.code(), unit.caseInsensitiveCode(), unit.names(), unit.printSymbol(),
                    unit.property(), unit.unitClass(), unit.metric(), unit.special(), unit.arbitrary(),
                    unit.definitionNumber(), unit.definitionUnit(), essence.reduction(unit.code()));
        }
        for (UcumEssence.Prefix prefix : essence.prefixes()) {
            UcumConcepts.prefix(writer, prefix);
        }
        UcumConcepts.identity(writer, UcumIdentity.unit("s"), "s", IkeTerms.SECOND, "Second");
        UcumConcepts.identity(writer, UcumIdentity.unit("min"), "min", IkeTerms.MINUTE, "Minute");
        UcumConcepts.identity(writer, UcumIdentity.unit("h"), "h", IkeTerms.HOUR, "Hour");
        UcumTerm millisecond = UcumGrammar.parse("ms", essence);
        PublicId ms = UcumConcepts.composedUnit(writer, millisecond, millisecond.reduce(essence));
        UcumConcepts.identity(writer, ms, millisecond.canonicalCode(), IkeTerms.MILLISECOND, "Millisecond");
        return new Report(essence.properties().size(), essence.baseUnits().size(), essence.units().size(),
                essence.prefixes().size(), 1, 4, writer.counts());
    }
}
