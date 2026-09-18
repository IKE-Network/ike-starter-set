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

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.entity.builder.ActiveStamp;
import dev.ikm.tinkar.entity.builder.KnowledgeSet;
import dev.ikm.tinkar.terms.EntityProxy;

/**
 * The ELM node catalog as a ledger section, imported from the ELM specification, cqframework/clinical_quality_language v5.3.0, by {@code ike:schema-import} (IKE-Network/ike-issues#1104).
 * GENERATED FROM THE SCHEMAS: regenerate, never edit.
 * <p>270 types, 143 position names over 346 type positions, 9 schema primitives, 1 types of other schemas referred to, 3 enumerations with 14 values.
 */
final class ElmNodeCatalogSet {

    /** The family root: the catalog itself. */
    static final String ROOT_FQN = "ELM node catalog (ELM)";

    /** The pattern that records, on each type, its positions. */
    static final String TYPE_POSITION_PATTERN_FQN = "ELM type position pattern (ELM)";

    private ElmNodeCatalogSet() {
    }

    /**
     * Composes this section's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    static void compose(KnowledgeSet set) {
        ActiveStamp inception = Ike.INCEPTION;

        // ── The family root and its parents ──
        set.concept("ELM node catalog (ELM)").at(inception)
                .synonym("ELM node catalog")
                .definition("The catalog of the node kinds of the ELM specification: each kind, what it holds, and"
                        + " what each thing it holds may be. Its 270 node kinds, each with its base and its"
                        + " positions, its 143 position names, its 9 schema primitives, its 1 type of other"
                        + " schemas it refers to, and its 3 enumerations, imported from"
                        + " cqframework/clinical_quality_language v5.3.0 and regenerated from the schemas, never"
                        + " edited. A node kind is a kind of node a tree in this language can have; a position is"
                        + " a named place in a node that holds a child or a value.")
                .isA(IkeTerm.MODEL_CONCEPT);
        EntityProxy.Concept root = set.conceptRef(ROOT_FQN);

        set.concept("ELM position (ELM)").at(inception)
                .synonym("ELM position")
                .definition("A position of the catalog: a named place in a node that holds a child or a value, such"
                        + " as operand or dataType, shared by every node type that has a position of that name."
                        + " Which types have it, with what value type and how many, is recorded on each type by"
                        + " the type position pattern.")
                .isA(root);
        EntityProxy.Concept positionParent = set.conceptRef("ELM position (ELM)");

        set.concept("ELM primitive (ELM)").at(inception)
                .synonym("ELM primitive")
                .definition("A value type the XML Schema language itself supplies, string or QName, rather than a"
                        + " node kind of the catalog: what a position holds when it holds a plain value and not a"
                        + " node.")
                .isA(root);
        EntityProxy.Concept primitiveParent = set.conceptRef("ELM primitive (ELM)");

        set.concept("ELM external type (ELM)").at(inception)
                .synonym("ELM external type")
                .definition("A type declared by a schema outside this catalog that a position or a base refers to;"
                        + " the catalog names it so that every reference resolves, and says no more about it than"
                        + " its name and its namespace.")
                .isA(root);
        EntityProxy.Concept externalParent = set.conceptRef("ELM external type (ELM)");

        // ── The type position pattern: which positions each type has ──
        set.concept("ELM type position (ELM)").at(inception)
                .synonym("ELM type position")
                .definition("What a type position semantic is: one position of one node kind, with the type of"
                        + " value it holds, the fewest and the most values the schema allows, the schema's own"
                        + " note on that position for that kind, and its form: whether our vertex holds it as a"
                        + " property or as an edge.")
                .isA(root);
        set.concept("ELM catalog structure (ELM)").at(inception)
                .synonym("ELM catalog structure")
                .definition("Why type positions are recorded: so that a tree can be checked against the catalog and"
                        + " a reader can know what each node may hold.")
                .isA(root);
        EntityProxy.Concept structure = set.conceptRef("ELM catalog structure (ELM)");
        set.concept("ELM property form (ELM)").at(inception)
                .synonym("ELM property form")
                .definition("The form of a position that holds a plain value, an attribute in the schema: our"
                        + " vertex holds it as a property keyed by the position.")
                .isA(root);
        set.concept("ELM edge form (ELM)").at(inception)
                .synonym("ELM edge form")
                .definition("The form of a position that holds a node, an element in the schema: our vertex holds"
                        + " it as an edge to the vertex below, named by the position.")
                .isA(root);
        set.concept("ELM position field (ELM)").at(inception)
                .synonym("ELM position field")
                .definition("The position a type position semantic is about.")
                .isA(root);
        set.concept("ELM value type field (ELM)").at(inception)
                .synonym("ELM value type field")
                .definition("The type of value that position holds on that type: a node kind of the catalog, a"
                        + " schema primitive, or a type of another schema.")
                .isA(root);
        set.concept("ELM minimum field (ELM)").at(inception)
                .synonym("ELM minimum field")
                .definition("The fewest values the schema allows in that position, zero when it is optional.")
                .isA(root);
        set.concept("ELM maximum field (ELM)").at(inception)
                .synonym("ELM maximum field")
                .definition("The most values the schema allows in that position, or minus one when the schema sets"
                        + " no limit.")
                .isA(root);
        set.concept("ELM position note field (ELM)").at(inception)
                .synonym("ELM position note field")
                .definition("The schema's own note on that position for that type, empty when the schema gives"
                        + " none.")
                .isA(root);
        set.concept("ELM form field (ELM)").at(inception)
                .synonym("ELM form field")
                .definition("How our vertex holds that position on that type: the property form when it holds a"
                        + " plain value, the edge form when it holds a node.")
                .isA(root);
        set.pattern(TYPE_POSITION_PATTERN_FQN).at(inception)
                .meaning(set.conceptRef("ELM type position (ELM)"))
                .purpose(structure)
                .field(set.conceptRef("ELM position field (ELM)"), structure, IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("ELM value type field (ELM)"), structure, IkeTerm.COMPONENT_FIELD)
                .field(set.conceptRef("ELM minimum field (ELM)"), structure, IkeTerm.INTEGER_FIELD)
                .field(set.conceptRef("ELM maximum field (ELM)"), structure, IkeTerm.INTEGER_FIELD)
                .field(set.conceptRef("ELM position note field (ELM)"), structure, IkeTerm.STRING)
                .field(set.conceptRef("ELM form field (ELM)"), structure, IkeTerm.COMPONENT_FIELD);
        EntityProxy.Concept propertyForm = set.conceptRef("ELM property form (ELM)");
        EntityProxy.Concept edgeForm = set.conceptRef("ELM edge form (ELM)");
        EntityProxy.Pattern typePositions = set.patternRef(TYPE_POSITION_PATTERN_FQN);

        // ── Positions: one concept per name, shared across types ──
        set.concept("ELM accessLevel position (ELM)").at(inception)
                .synonym("ELM accessLevel position")
                .definition("The argument position named accessLevel, an attribute, on 6 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM aggregate position (ELM)").at(inception)
                .synonym("ELM aggregate position")
                .definition("The argument position named aggregate, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM alias position (ELM)").at(inception)
                .synonym("ELM alias position")
                .definition("The argument position named alias, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM annotation position (ELM)").at(inception)
                .synonym("ELM annotation position")
                .definition("The argument position named annotation, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM asType position (ELM)").at(inception)
                .synonym("ELM asType position")
                .definition("The argument position named asType, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM asTypeSpecifier position (ELM)").at(inception)
                .synonym("ELM asTypeSpecifier position")
                .definition("The argument position named asTypeSpecifier, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM by position (ELM)").at(inception)
                .synonym("ELM by position")
                .definition("The argument position named by, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM caseItem position (ELM)").at(inception)
                .synonym("ELM caseItem position")
                .definition("The argument position named caseItem, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM choice position (ELM)").at(inception)
                .synonym("ELM choice position")
                .definition("The argument position named choice, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM classType position (ELM)").at(inception)
                .synonym("ELM classType position")
                .definition("The argument position named classType, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM code position (ELM)").at(inception)
                .synonym("ELM code position")
                .definition("The argument position named code, an element on some types and an attribute on others,"
                        + " on 7 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM codeComparator position (ELM)").at(inception)
                .synonym("ELM codeComparator position")
                .definition("The argument position named codeComparator, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM codeFilter position (ELM)").at(inception)
                .synonym("ELM codeFilter position")
                .definition("The argument position named codeFilter, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM codeProperty position (ELM)").at(inception)
                .synonym("ELM codeProperty position")
                .definition("The argument position named codeProperty, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM codeSearch position (ELM)").at(inception)
                .synonym("ELM codeSearch position")
                .definition("The argument position named codeSearch, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM codeSystem position, mixed case (ELM)").at(inception)
                .synonym("ELM codeSystem position, mixed case")
                .definition("The argument position named codeSystem, a child element, on 2 node kinds of the"
                        + " catalog. The schema spells it mixed case, and spells another position the same way"
                        + " but for case.")
                .isA(positionParent);
        set.concept("ELM codeSystems position (ELM)").at(inception)
                .synonym("ELM codeSystems position")
                .definition("The argument position named codeSystems, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM codes position (ELM)").at(inception)
                .synonym("ELM codes position")
                .definition("The argument position named codes, a child element, on 5 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM codesystem position, lower case (ELM)").at(inception)
                .synonym("ELM codesystem position, lower case")
                .definition("The argument position named codesystem, a child element, on 3 node kinds of the"
                        + " catalog. The schema spells it lower case, and spells another position the same way"
                        + " but for case.")
                .isA(positionParent);
        set.concept("ELM codesystemExpression position (ELM)").at(inception)
                .synonym("ELM codesystemExpression position")
                .definition("The argument position named codesystemExpression, a child element, on 2 node kinds of"
                        + " the catalog.")
                .isA(positionParent);
        set.concept("ELM comparand position (ELM)").at(inception)
                .synonym("ELM comparand position")
                .definition("The argument position named comparand, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM comparator position (ELM)").at(inception)
                .synonym("ELM comparator position")
                .definition("The argument position named comparator, an attribute, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM concepts position (ELM)").at(inception)
                .synonym("ELM concepts position")
                .definition("The argument position named concepts, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM condition position (ELM)").at(inception)
                .synonym("ELM condition position")
                .definition("The argument position named condition, a child element, on 3 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM context position (ELM)").at(inception)
                .synonym("ELM context position")
                .definition("The argument position named context, an element on some types and an attribute on"
                        + " others, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM contextProperty position (ELM)").at(inception)
                .synonym("ELM contextProperty position")
                .definition("The argument position named contextProperty, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM contextSearch position (ELM)").at(inception)
                .synonym("ELM contextSearch position")
                .definition("The argument position named contextSearch, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM contexts position (ELM)").at(inception)
                .synonym("ELM contexts position")
                .definition("The argument position named contexts, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM dataType position (ELM)").at(inception)
                .synonym("ELM dataType position")
                .definition("The argument position named dataType, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM dateFilter position (ELM)").at(inception)
                .synonym("ELM dateFilter position")
                .definition("The argument position named dateFilter, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM dateHighProperty position (ELM)").at(inception)
                .synonym("ELM dateHighProperty position")
                .definition("The argument position named dateHighProperty, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM dateLowProperty position (ELM)").at(inception)
                .synonym("ELM dateLowProperty position")
                .definition("The argument position named dateLowProperty, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM dateProperty position (ELM)").at(inception)
                .synonym("ELM dateProperty position")
                .definition("The argument position named dateProperty, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM dateRange position (ELM)").at(inception)
                .synonym("ELM dateRange position")
                .definition("The argument position named dateRange, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM dateSearch position (ELM)").at(inception)
                .synonym("ELM dateSearch position")
                .definition("The argument position named dateSearch, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM day position (ELM)").at(inception)
                .synonym("ELM day position")
                .definition("The argument position named day, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM default position (ELM)").at(inception)
                .synonym("ELM default position")
                .definition("The argument position named default, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM denominator position (ELM)").at(inception)
                .synonym("ELM denominator position")
                .definition("The argument position named denominator, a child element, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM direction position (ELM)").at(inception)
                .synonym("ELM direction position")
                .definition("The argument position named direction, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM display position (ELM)").at(inception)
                .synonym("ELM display position")
                .definition("The argument position named display, an element on some types and an attribute on"
                        + " others, on 6 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM distinct position (ELM)").at(inception)
                .synonym("ELM distinct position")
                .definition("The argument position named distinct, an attribute, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM element position (ELM)").at(inception)
                .synonym("ELM element position")
                .definition("The argument position named element, a child element, on 7 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM elementType position (ELM)").at(inception)
                .synonym("ELM elementType position")
                .definition("The argument position named elementType, a child element, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM else position (ELM)").at(inception)
                .synonym("ELM else position")
                .definition("The argument position named else, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM endIndex position (ELM)").at(inception)
                .synonym("ELM endIndex position")
                .definition("The argument position named endIndex, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM expression position (ELM)").at(inception)
                .synonym("ELM expression position")
                .definition("The argument position named expression, a child element, on 6 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM external position (ELM)").at(inception)
                .synonym("ELM external position")
                .definition("The argument position named external, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM fluent position (ELM)").at(inception)
                .synonym("ELM fluent position")
                .definition("The argument position named fluent, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM high position (ELM)").at(inception)
                .synonym("ELM high position")
                .definition("The argument position named high, a child element, on 7 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM highClosed position (ELM)").at(inception)
                .synonym("ELM highClosed position")
                .definition("The argument position named highClosed, an element on some types and an attribute on"
                        + " others, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM highClosedExpression position (ELM)").at(inception)
                .synonym("ELM highClosedExpression position")
                .definition("The argument position named highClosedExpression, a child element, on 1 node kind of"
                        + " the catalog.")
                .isA(positionParent);
        set.concept("ELM highProperty position (ELM)").at(inception)
                .synonym("ELM highProperty position")
                .definition("The argument position named highProperty, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM hour position (ELM)").at(inception)
                .synonym("ELM hour position")
                .definition("The argument position named hour, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM id position (ELM)").at(inception)
                .synonym("ELM id position")
                .definition("The argument position named id, an element on some types and an attribute on others,"
                        + " on 6 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM idProperty position (ELM)").at(inception)
                .synonym("ELM idProperty position")
                .definition("The argument position named idProperty, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM idSearch position (ELM)").at(inception)
                .synonym("ELM idSearch position")
                .definition("The argument position named idSearch, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM identifier position (ELM)").at(inception)
                .synonym("ELM identifier position")
                .definition("The argument position named identifier, an element on some types and an attribute on"
                        + " others, on 3 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM include position (ELM)").at(inception)
                .synonym("ELM include position")
                .definition("The argument position named include, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM includeFrom position (ELM)").at(inception)
                .synonym("ELM includeFrom position")
                .definition("The argument position named includeFrom, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM includedIn position (ELM)").at(inception)
                .synonym("ELM includedIn position")
                .definition("The argument position named includedIn, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM includes position (ELM)").at(inception)
                .synonym("ELM includes position")
                .definition("The argument position named includes, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM initialValue position (ELM)").at(inception)
                .synonym("ELM initialValue position")
                .definition("The argument position named initialValue, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM isReverse position (ELM)").at(inception)
                .synonym("ELM isReverse position")
                .definition("The argument position named isReverse, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM isType position (ELM)").at(inception)
                .synonym("ELM isType position")
                .definition("The argument position named isType, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM isTypeSpecifier position (ELM)").at(inception)
                .synonym("ELM isTypeSpecifier position")
                .definition("The argument position named isTypeSpecifier, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM iteration position (ELM)").at(inception)
                .synonym("ELM iteration position")
                .definition("The argument position named iteration, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM length position (ELM)").at(inception)
                .synonym("ELM length position")
                .definition("The argument position named length, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM let position (ELM)").at(inception)
                .synonym("ELM let position")
                .definition("The argument position named let, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM libraryName position (ELM)").at(inception)
                .synonym("ELM libraryName position")
                .definition("The argument position named libraryName, an attribute, on 7 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM localId position (ELM)").at(inception)
                .synonym("ELM localId position")
                .definition("The argument position named localId, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM localIdentifier position (ELM)").at(inception)
                .synonym("ELM localIdentifier position")
                .definition("The argument position named localIdentifier, an attribute, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM locator position (ELM)").at(inception)
                .synonym("ELM locator position")
                .definition("The argument position named locator, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM low position (ELM)").at(inception)
                .synonym("ELM low position")
                .definition("The argument position named low, a child element, on 7 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM lowClosed position (ELM)").at(inception)
                .synonym("ELM lowClosed position")
                .definition("The argument position named lowClosed, an element on some types and an attribute on"
                        + " others, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM lowClosedExpression position (ELM)").at(inception)
                .synonym("ELM lowClosedExpression position")
                .definition("The argument position named lowClosedExpression, a child element, on 1 node kind of"
                        + " the catalog.")
                .isA(positionParent);
        set.concept("ELM lowProperty position (ELM)").at(inception)
                .synonym("ELM lowProperty position")
                .definition("The argument position named lowProperty, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM mediaType position (ELM)").at(inception)
                .synonym("ELM mediaType position")
                .definition("The argument position named mediaType, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM message position (ELM)").at(inception)
                .synonym("ELM message position")
                .definition("The argument position named message, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM millisecond position (ELM)").at(inception)
                .synonym("ELM millisecond position")
                .definition("The argument position named millisecond, a child element, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM minute position (ELM)").at(inception)
                .synonym("ELM minute position")
                .definition("The argument position named minute, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM month position (ELM)").at(inception)
                .synonym("ELM month position")
                .definition("The argument position named month, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM name position (ELM)").at(inception)
                .synonym("ELM name position")
                .definition("The argument position named name, an element on some types and an attribute on others,"
                        + " on 23 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM numerator position (ELM)").at(inception)
                .synonym("ELM numerator position")
                .definition("The argument position named numerator, a child element, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM operand position (ELM)").at(inception)
                .synonym("ELM operand position")
                .definition("The argument position named operand, a child element, on 7 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM operandType position (ELM)").at(inception)
                .synonym("ELM operandType position")
                .definition("The argument position named operandType, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM operandTypeSpecifier position (ELM)").at(inception)
                .synonym("ELM operandTypeSpecifier position")
                .definition("The argument position named operandTypeSpecifier, a child element, on 1 node kind of"
                        + " the catalog.")
                .isA(positionParent);
        set.concept("ELM orderBy position (ELM)").at(inception)
                .synonym("ELM orderBy position")
                .definition("The argument position named orderBy, an attribute, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM otherFilter position (ELM)").at(inception)
                .synonym("ELM otherFilter position")
                .definition("The argument position named otherFilter, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM parameterName position (ELM)").at(inception)
                .synonym("ELM parameterName position")
                .definition("The argument position named parameterName, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM parameterType position (ELM)").at(inception)
                .synonym("ELM parameterType position")
                .definition("The argument position named parameterType, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM parameterTypeSpecifier position (ELM)").at(inception)
                .synonym("ELM parameterTypeSpecifier position")
                .definition("The argument position named parameterTypeSpecifier, a child element, on 1 node kind of"
                        + " the catalog.")
                .isA(positionParent);
        set.concept("ELM parameters position (ELM)").at(inception)
                .synonym("ELM parameters position")
                .definition("The argument position named parameters, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM path position (ELM)").at(inception)
                .synonym("ELM path position")
                .definition("The argument position named path, an attribute, on 4 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM pattern position (ELM)").at(inception)
                .synonym("ELM pattern position")
                .definition("The argument position named pattern, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM pointType position (ELM)").at(inception)
                .synonym("ELM pointType position")
                .definition("The argument position named pointType, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM precision position (ELM)").at(inception)
                .synonym("ELM precision position")
                .definition("The argument position named precision, an element on some types and an attribute on"
                        + " others, on 27 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM preserve position (ELM)").at(inception)
                .synonym("ELM preserve position")
                .definition("The argument position named preserve, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM property position (ELM)").at(inception)
                .synonym("ELM property position")
                .definition("The argument position named property, an attribute, on 3 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM relatedDataType position (ELM)").at(inception)
                .synonym("ELM relatedDataType position")
                .definition("The argument position named relatedDataType, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM relatedProperty position (ELM)").at(inception)
                .synonym("ELM relatedProperty position")
                .definition("The argument position named relatedProperty, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM relatedSearch position (ELM)").at(inception)
                .synonym("ELM relatedSearch position")
                .definition("The argument position named relatedSearch, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM relationship position (ELM)").at(inception)
                .synonym("ELM relationship position")
                .definition("The argument position named relationship, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM resultTypeName position (ELM)").at(inception)
                .synonym("ELM resultTypeName position")
                .definition("The argument position named resultTypeName, an attribute, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM resultTypeSpecifier position (ELM)").at(inception)
                .synonym("ELM resultTypeSpecifier position")
                .definition("The argument position named resultTypeSpecifier, a child element, on 1 node kind of"
                        + " the catalog.")
                .isA(positionParent);
        set.concept("ELM return position (ELM)").at(inception)
                .synonym("ELM return position")
                .definition("The argument position named return, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM schemaIdentifier position (ELM)").at(inception)
                .synonym("ELM schemaIdentifier position")
                .definition("The argument position named schemaIdentifier, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM scope position (ELM)").at(inception)
                .synonym("ELM scope position")
                .definition("The argument position named scope, an attribute, on 7 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM search position (ELM)").at(inception)
                .synonym("ELM search position")
                .definition("The argument position named search, an attribute, on 3 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM second position (ELM)").at(inception)
                .synonym("ELM second position")
                .definition("The argument position named second, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM separator position (ELM)").at(inception)
                .synonym("ELM separator position")
                .definition("The argument position named separator, a child element, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM separatorPattern position (ELM)").at(inception)
                .synonym("ELM separatorPattern position")
                .definition("The argument position named separatorPattern, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM severity position (ELM)").at(inception)
                .synonym("ELM severity position")
                .definition("The argument position named severity, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM signature position (ELM)").at(inception)
                .synonym("ELM signature position")
                .definition("The argument position named signature, a child element, on 3 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM sort position (ELM)").at(inception)
                .synonym("ELM sort position")
                .definition("The argument position named sort, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM source position (ELM)").at(inception)
                .synonym("ELM source position")
                .definition("The argument position named source, a child element, on 16 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM startIndex position (ELM)").at(inception)
                .synonym("ELM startIndex position")
                .definition("The argument position named startIndex, a child element, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM starting position (ELM)").at(inception)
                .synonym("ELM starting position")
                .definition("The argument position named starting, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM statements position (ELM)").at(inception)
                .synonym("ELM statements position")
                .definition("The argument position named statements, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM strict position (ELM)").at(inception)
                .synonym("ELM strict position")
                .definition("The argument position named strict, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM string position (ELM)").at(inception)
                .synonym("ELM string position")
                .definition("The argument position named string, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM stringToSplit position (ELM)").at(inception)
                .synonym("ELM stringToSplit position")
                .definition("The argument position named stringToSplit, a child element, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM stringToSub position (ELM)").at(inception)
                .synonym("ELM stringToSub position")
                .definition("The argument position named stringToSub, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM suchThat position (ELM)").at(inception)
                .synonym("ELM suchThat position")
                .definition("The argument position named suchThat, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM system position (ELM)").at(inception)
                .synonym("ELM system position")
                .definition("The argument position named system, an element on some types and an attribute on"
                        + " others, on 3 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM templateId position (ELM)").at(inception)
                .synonym("ELM templateId position")
                .definition("The argument position named templateId, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM then position (ELM)").at(inception)
                .synonym("ELM then position")
                .definition("The argument position named then, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM timezoneOffset position (ELM)").at(inception)
                .synonym("ELM timezoneOffset position")
                .definition("The argument position named timezoneOffset, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM toType position (ELM)").at(inception)
                .synonym("ELM toType position")
                .definition("The argument position named toType, an attribute, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM toTypeSpecifier position (ELM)").at(inception)
                .synonym("ELM toTypeSpecifier position")
                .definition("The argument position named toTypeSpecifier, a child element, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM typeSpecifier position (ELM)").at(inception)
                .synonym("ELM typeSpecifier position")
                .definition("The argument position named typeSpecifier, a child element, on 1 node kind of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM unit position (ELM)").at(inception)
                .synonym("ELM unit position")
                .definition("The argument position named unit, an element on some types and an attribute on others,"
                        + " on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM uri position (ELM)").at(inception)
                .synonym("ELM uri position")
                .definition("The argument position named uri, an attribute, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM usings position (ELM)").at(inception)
                .synonym("ELM usings position")
                .definition("The argument position named usings, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM value position (ELM)").at(inception)
                .synonym("ELM value position")
                .definition("The argument position named value, an element on some types and an attribute on"
                        + " others, on 16 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM valueSetProperty position (ELM)").at(inception)
                .synonym("ELM valueSetProperty position")
                .definition("The argument position named valueSetProperty, an attribute, on 2 node kinds of the"
                        + " catalog.")
                .isA(positionParent);
        set.concept("ELM valueSets position (ELM)").at(inception)
                .synonym("ELM valueSets position")
                .definition("The argument position named valueSets, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM valueType position (ELM)").at(inception)
                .synonym("ELM valueType position")
                .definition("The argument position named valueType, an attribute, on 4 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM valueset position (ELM)").at(inception)
                .synonym("ELM valueset position")
                .definition("The argument position named valueset, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM valuesetExpression position (ELM)").at(inception)
                .synonym("ELM valuesetExpression position")
                .definition("The argument position named valuesetExpression, a child element, on 2 node kinds of"
                        + " the catalog.")
                .isA(positionParent);
        set.concept("ELM version position (ELM)").at(inception)
                .synonym("ELM version position")
                .definition("The argument position named version, an element on some types and an attribute on"
                        + " others, on 7 node kinds of the catalog.")
                .isA(positionParent);
        set.concept("ELM when position (ELM)").at(inception)
                .synonym("ELM when position")
                .definition("The argument position named when, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM where position (ELM)").at(inception)
                .synonym("ELM where position")
                .definition("The argument position named where, a child element, on 1 node kind of the catalog.")
                .isA(positionParent);
        set.concept("ELM year position (ELM)").at(inception)
                .synonym("ELM year position")
                .definition("The argument position named year, a child element, on 2 node kinds of the catalog.")
                .isA(positionParent);

        // ── Schema primitives the positions use ──
        set.concept("ELM primitive QName (ELM)").at(inception)
                .synonym("ELM primitive QName")
                .definition("The XML Schema primitive QName, a plain value a position of the ELM specification"
                        + " holds.")
                .isA(primitiveParent);
        set.concept("ELM primitive anySimpleType (ELM)").at(inception)
                .synonym("ELM primitive anySimpleType")
                .definition("The XML Schema primitive anySimpleType, a plain value a position of the ELM"
                        + " specification holds.")
                .isA(primitiveParent);
        set.concept("ELM primitive anyType (ELM)").at(inception)
                .synonym("ELM primitive anyType")
                .definition("The XML Schema primitive anyType, a plain value a position of the ELM specification"
                        + " holds.")
                .isA(primitiveParent);
        set.concept("ELM primitive anyURI (ELM)").at(inception)
                .synonym("ELM primitive anyURI")
                .definition("The XML Schema primitive anyURI, a plain value a position of the ELM specification"
                        + " holds.")
                .isA(primitiveParent);
        set.concept("ELM primitive boolean (ELM)").at(inception)
                .synonym("ELM primitive boolean")
                .definition("The XML Schema primitive boolean, a plain value a position of the ELM specification"
                        + " holds.")
                .isA(primitiveParent);
        set.concept("ELM primitive decimal (ELM)").at(inception)
                .synonym("ELM primitive decimal")
                .definition("The XML Schema primitive decimal, a plain value a position of the ELM specification"
                        + " holds.")
                .isA(primitiveParent);
        set.concept("ELM primitive int (ELM)").at(inception)
                .synonym("ELM primitive int")
                .definition("The XML Schema primitive int, a plain value a position of the ELM specification holds.")
                .isA(primitiveParent);
        set.concept("ELM primitive long (ELM)").at(inception)
                .synonym("ELM primitive long")
                .definition("The XML Schema primitive long, a plain value a position of the ELM specification"
                        + " holds.")
                .isA(primitiveParent);
        set.concept("ELM primitive string (ELM)").at(inception)
                .synonym("ELM primitive string")
                .definition("The XML Schema primitive string, a plain value a position of the ELM specification"
                        + " holds.")
                .isA(primitiveParent);

        // ── Types of other schemas the catalog refers to ──
        set.concept("ELM external CqlToElmBase (ELM)").at(inception)
                .synonym("ELM external CqlToElmBase")
                .definition("The type CqlToElmBase of the namespace urn:hl7-org:cql-annotations:r1, which the ELM"
                        + " specification refers to but does not declare.")
                .isA(externalParent);

        // ── Types, each after its base ──
        set.concept("ELM System Any (ELM)").at(inception)
                .synonym("ELM System Any")
                .definition("A type of the ELM specification; the schema gives no description. The schema marks it"
                        + " abstract: a tree never holds it directly, only one of the types that extend it.")
                .isA(root);
        set.concept("ELM System Boolean (ELM)").at(inception)
                .synonym("ELM System Boolean")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Boolean value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM System Code (ELM)").at(inception)
                .synonym("ELM System Code")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Code code")),
                        set.conceptRef("ELM code position (ELM)"), set.conceptRef("ELM System String (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Code display")),
                        set.conceptRef("ELM display position (ELM)"), set.conceptRef("ELM System String (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Code system")),
                        set.conceptRef("ELM system position (ELM)"), set.conceptRef("ELM System String (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Code version")),
                        set.conceptRef("ELM version position (ELM)"), set.conceptRef("ELM System String (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System Concept (ELM)").at(inception)
                .synonym("ELM System Concept")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Concept codes")),
                        set.conceptRef("ELM codes position (ELM)"), set.conceptRef("ELM System Code (ELM)"), 1, -1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Concept display")),
                        set.conceptRef("ELM display position (ELM)"), set.conceptRef("ELM System String (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System Vocabulary (ELM)").at(inception)
                .synonym("ELM System Vocabulary")
                .definition("A type of the ELM specification; the schema gives no description. The schema marks it"
                        + " abstract: a tree never holds it directly, only one of the types that extend it.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Vocabulary id")),
                        set.conceptRef("ELM id position (ELM)"), set.conceptRef("ELM System String (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Vocabulary version")),
                        set.conceptRef("ELM version position (ELM)"), set.conceptRef("ELM System String (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Vocabulary name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM System String (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System ValueSet (ELM)").at(inception)
                .synonym("ELM System ValueSet")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Vocabulary (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System ValueSet codesystem")),
                        set.conceptRef("ELM codesystem position, lower case (ELM)"), set.conceptRef("ELM System CodeSystem (ELM)"), 0, -1,
                        "", edgeForm);
        set.concept("ELM System CodeSystem (ELM)").at(inception)
                .synonym("ELM System CodeSystem")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Vocabulary (ELM)"));
        set.concept("ELM System Date (ELM)").at(inception)
                .synonym("ELM System Date")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Date value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM System DateTime (ELM)").at(inception)
                .synonym("ELM System DateTime")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System DateTime value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM System Decimal (ELM)").at(inception)
                .synonym("ELM System Decimal")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Decimal value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive decimal (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM System Integer (ELM)").at(inception)
                .synonym("ELM System Integer")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Integer value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive int (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM System Long (ELM)").at(inception)
                .synonym("ELM System Long")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Long value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive long (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM System Quantity (ELM)").at(inception)
                .synonym("ELM System Quantity")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Quantity value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM System Decimal (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Quantity unit")),
                        set.conceptRef("ELM unit position (ELM)"), set.conceptRef("ELM System String (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System Ratio (ELM)").at(inception)
                .synonym("ELM System Ratio")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Ratio numerator")),
                        set.conceptRef("ELM numerator position (ELM)"), set.conceptRef("ELM System Quantity (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Ratio denominator")),
                        set.conceptRef("ELM denominator position (ELM)"), set.conceptRef("ELM System Quantity (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM System String (ELM)").at(inception)
                .synonym("ELM System String")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System String value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM System Time (ELM)").at(inception)
                .synonym("ELM System Time")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Time value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM System Interval (ELM)").at(inception)
                .synonym("ELM System Interval")
                .definition("A type of the ELM specification; the schema gives no description. The schema marks it"
                        + " abstract: a tree never holds it directly, only one of the types that extend it.")
                .isA(set.conceptRef("ELM System Any (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Interval lowClosed")),
                        set.conceptRef("ELM lowClosed position (ELM)"), set.conceptRef("ELM System Boolean (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System Interval highClosed")),
                        set.conceptRef("ELM highClosed position (ELM)"), set.conceptRef("ELM System Boolean (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System IntegerInterval (ELM)").at(inception)
                .synonym("ELM System IntegerInterval")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Interval (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System IntegerInterval low")),
                        set.conceptRef("ELM low position (ELM)"), set.conceptRef("ELM System Integer (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System IntegerInterval high")),
                        set.conceptRef("ELM high position (ELM)"), set.conceptRef("ELM System Integer (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System DecimalInterval (ELM)").at(inception)
                .synonym("ELM System DecimalInterval")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Interval (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System DecimalInterval low")),
                        set.conceptRef("ELM low position (ELM)"), set.conceptRef("ELM System Decimal (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System DecimalInterval high")),
                        set.conceptRef("ELM high position (ELM)"), set.conceptRef("ELM System Decimal (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System QuantityInterval (ELM)").at(inception)
                .synonym("ELM System QuantityInterval")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Interval (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System QuantityInterval low")),
                        set.conceptRef("ELM low position (ELM)"), set.conceptRef("ELM System Quantity (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System QuantityInterval high")),
                        set.conceptRef("ELM high position (ELM)"), set.conceptRef("ELM System Quantity (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System DateInterval (ELM)").at(inception)
                .synonym("ELM System DateInterval")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Interval (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System DateInterval low")),
                        set.conceptRef("ELM low position (ELM)"), set.conceptRef("ELM System Date (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System DateInterval high")),
                        set.conceptRef("ELM high position (ELM)"), set.conceptRef("ELM System Date (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System DateTimeInterval (ELM)").at(inception)
                .synonym("ELM System DateTimeInterval")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Interval (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System DateTimeInterval low")),
                        set.conceptRef("ELM low position (ELM)"), set.conceptRef("ELM System DateTime (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System DateTimeInterval high")),
                        set.conceptRef("ELM high position (ELM)"), set.conceptRef("ELM System DateTime (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM System TimeInterval (ELM)").at(inception)
                .synonym("ELM System TimeInterval")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM System Interval (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System TimeInterval low")),
                        set.conceptRef("ELM low position (ELM)"), set.conceptRef("ELM System Time (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM System TimeInterval high")),
                        set.conceptRef("ELM high position (ELM)"), set.conceptRef("ELM System Time (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM Element (ELM)").at(inception)
                .synonym("ELM Element")
                .definition("From the ELM specification: The Element type defines the abstract base type for all"
                        + " library elements in ELM. The schema marks it abstract: a tree never holds it"
                        + " directly, only one of the types that extend it.")
                .isA(root)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Element annotation")),
                        set.conceptRef("ELM annotation position (ELM)"), set.conceptRef("ELM external CqlToElmBase (ELM)"), 0, -1,
                        "The annotation element provides a mechanism for decorating expressions with application-specific information such as translation hints, visual designer information, or debug symbols.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Element resultTypeSpecifier")),
                        set.conceptRef("ELM resultTypeSpecifier position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, 1,
                        "The resultTypeSpecifier element describes the type information for this ELM node. ELM documents are not required to contain result type information, but if they do, the result type of each node is specified using the resultTypeName attribute for named types, and this resultTypeSpecifier element for non-named types.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Element localId")),
                        set.conceptRef("ELM localId position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Element locator")),
                        set.conceptRef("ELM locator position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The locator for an ELM node identifies the location in the source document that produced the ELM. The format is L:C[-L:C], where L is a line number and C is a column number. For locators that span a range, an optional range can be given to an ending line and column number. Line and column numbers are 1-based.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Element resultTypeName")),
                        set.conceptRef("ELM resultTypeName position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 0, 1,
                        "The resultTypeName attribute is part of type information for an ELM document. ELM documents are not required to specify result type information, but if they do, the result type of each node is specified using this attribute for named types, or the resultTypeSpecifier element for non-named types.", propertyForm);
        set.concept("ELM TypeSpecifier (ELM)").at(inception)
                .synonym("ELM TypeSpecifier")
                .definition("From the ELM specification: TypeSpecifier is the abstract base type for all type"
                        + " specifiers. The schema marks it abstract: a tree never holds it directly, only one of"
                        + " the types that extend it.")
                .isA(set.conceptRef("ELM Element (ELM)"));
        set.concept("ELM NamedTypeSpecifier (ELM)").at(inception)
                .synonym("ELM NamedTypeSpecifier")
                .definition("From the ELM specification: NamedTypeSpecifier defines a type identified by a name,"
                        + " such as Integer, String, Patient, or Encounter.")
                .isA(set.conceptRef("ELM TypeSpecifier (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM NamedTypeSpecifier name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM IntervalTypeSpecifier (ELM)").at(inception)
                .synonym("ELM IntervalTypeSpecifier")
                .definition("From the ELM specification: IntervalTypeSpecifier defines an interval type by"
                        + " specifying the point type. Any type can serve as the point type for an interval, so"
                        + " long as it supports comparison operators, minimum and maximum value determination, as"
                        + " well as predecessor and successor functions.")
                .isA(set.conceptRef("ELM TypeSpecifier (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IntervalTypeSpecifier pointType")),
                        set.conceptRef("ELM pointType position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM ListTypeSpecifier (ELM)").at(inception)
                .synonym("ELM ListTypeSpecifier")
                .definition("From the ELM specification: ListTypeSpecifier defines a list type by specifying the"
                        + " type of elements the list may contain.")
                .isA(set.conceptRef("ELM TypeSpecifier (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ListTypeSpecifier elementType")),
                        set.conceptRef("ELM elementType position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM TupleElementDefinition (ELM)").at(inception)
                .synonym("ELM TupleElementDefinition")
                .definition("From the ELM specification: TupleElementDefinition defines the name and type of a"
                        + " single element within a TupleTypeSpecifier.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM TupleElementDefinition elementType")),
                        set.conceptRef("ELM elementType position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM TupleElementDefinition name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM TupleTypeSpecifier (ELM)").at(inception)
                .synonym("ELM TupleTypeSpecifier")
                .definition("From the ELM specification: TupleTypeSpecifier defines the possible elements of a"
                        + " tuple.")
                .isA(set.conceptRef("ELM TypeSpecifier (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM TupleTypeSpecifier element")),
                        set.conceptRef("ELM element position (ELM)"), set.conceptRef("ELM TupleElementDefinition (ELM)"), 0, -1,
                        "", edgeForm);
        set.concept("ELM ChoiceTypeSpecifier (ELM)").at(inception)
                .synonym("ELM ChoiceTypeSpecifier")
                .definition("From the ELM specification: ChoiceTypeSpecifier defines the possible types of a choice"
                        + " type.")
                .isA(set.conceptRef("ELM TypeSpecifier (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ChoiceTypeSpecifier choice")),
                        set.conceptRef("ELM choice position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, -1,
                        "", edgeForm);
        set.concept("ELM ParameterTypeSpecifier (ELM)").at(inception)
                .synonym("ELM ParameterTypeSpecifier")
                .definition("From the ELM specification: A type which is generic class parameter such as T in"
                        + " MyGeneric<T extends SomeType>.")
                .isA(set.conceptRef("ELM TypeSpecifier (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ParameterTypeSpecifier parameterName")),
                        set.conceptRef("ELM parameterName position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM Expression (ELM)").at(inception)
                .synonym("ELM Expression")
                .definition("From the ELM specification: The Expression type defines the abstract base type for all"
                        + " expressions used in the ELM expression language. The schema marks it abstract: a tree"
                        + " never holds it directly, only one of the types that extend it.")
                .isA(set.conceptRef("ELM Element (ELM)"));
        set.concept("ELM OperatorExpression (ELM)").at(inception)
                .synonym("ELM OperatorExpression")
                .definition("From the ELM specification: The Operator type defines the abstract base type for all"
                        + " built-in operators used in the ELM expression language. This explicitly excludes"
                        + " FunctionRef, which is the concrete type for all function invocations. The schema"
                        + " marks it abstract: a tree never holds it directly, only one of the types that extend"
                        + " it.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OperatorExpression signature")),
                        set.conceptRef("ELM signature position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, -1,
                        "Specifies the declared signature of the operator or function being called. If no signature is specified, the run-time types of the operands should be used to resolve any overload.", edgeForm);
        set.concept("ELM UnaryExpression (ELM)").at(inception)
                .synonym("ELM UnaryExpression")
                .definition("From the ELM specification: The UnaryExpression type defines the abstract base type"
                        + " for expressions that take a single argument. The schema marks it abstract: a tree"
                        + " never holds it directly, only one of the types that extend it.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM UnaryExpression operand")),
                        set.conceptRef("ELM operand position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM BinaryExpression (ELM)").at(inception)
                .synonym("ELM BinaryExpression")
                .definition("From the ELM specification: The BinaryExpression type defines the abstract base type"
                        + " for expressions that take two arguments. The schema marks it abstract: a tree never"
                        + " holds it directly, only one of the types that extend it.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM BinaryExpression operand")),
                        set.conceptRef("ELM operand position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 2, 2,
                        "", edgeForm);
        set.concept("ELM TernaryExpression (ELM)").at(inception)
                .synonym("ELM TernaryExpression")
                .definition("From the ELM specification: The TernaryExpression type defines the abstract base type"
                        + " for expressions that take three arguments. The schema marks it abstract: a tree never"
                        + " holds it directly, only one of the types that extend it.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM TernaryExpression operand")),
                        set.conceptRef("ELM operand position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 3, 3,
                        "", edgeForm);
        set.concept("ELM NaryExpression (ELM)").at(inception)
                .synonym("ELM NaryExpression")
                .definition("From the ELM specification: The NaryExpression type defines an abstract base class for"
                        + " an expression that takes any number of arguments, including zero. The schema marks it"
                        + " abstract: a tree never holds it directly, only one of the types that extend it.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM NaryExpression operand")),
                        set.conceptRef("ELM operand position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, -1,
                        "", edgeForm);
        set.concept("ELM ExpressionDef (ELM)").at(inception)
                .synonym("ELM ExpressionDef")
                .definition("From the ELM specification: The ExpressionDef type defines an expression and an"
                        + " associated name that can be referenced by any expression in the artifact. The name"
                        + " must be unique within the artifact. The context attribute specifies the context of"
                        + " the execution and is used by the environment to determine whether or not to filter"
                        + " the data returned from retrieves based on the current context.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ExpressionDef expression")),
                        set.conceptRef("ELM expression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ExpressionDef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ExpressionDef context")),
                        set.conceptRef("ELM context position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ExpressionDef accessLevel")),
                        set.conceptRef("ELM accessLevel position (ELM)"), set.conceptRef("ELM AccessModifier (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM FunctionDef (ELM)").at(inception)
                .synonym("ELM FunctionDef")
                .definition("From the ELM specification: The FunctionDef type defines a named function that can be"
                        + " invoked by any expression in the artifact. Function names must be unique within the"
                        + " artifact. Functions may take any number of operands.")
                .isA(set.conceptRef("ELM ExpressionDef (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM FunctionDef operand")),
                        set.conceptRef("ELM operand position (ELM)"), set.conceptRef("ELM OperandDef (ELM)"), 0, -1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM FunctionDef external")),
                        set.conceptRef("ELM external position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM FunctionDef fluent")),
                        set.conceptRef("ELM fluent position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ExpressionRef (ELM)").at(inception)
                .synonym("ELM ExpressionRef")
                .definition("From the ELM specification: The ExpressionRef type defines an expression that"
                        + " references a previously defined NamedExpression. The result of evaluating an"
                        + " ExpressionReference is the result of evaluating the referenced NamedExpression.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ExpressionRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ExpressionRef libraryName")),
                        set.conceptRef("ELM libraryName position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM FunctionRef (ELM)").at(inception)
                .synonym("ELM FunctionRef")
                .definition("From the ELM specification: The FunctionRef type defines an expression that invokes a"
                        + " previously defined function. The result of evaluating each operand is passed to the"
                        + " function.")
                .isA(set.conceptRef("ELM ExpressionRef (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM FunctionRef signature")),
                        set.conceptRef("ELM signature position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, -1,
                        "Specifies the declared signature of the function being called. If no signature is specified, the run-time types of the operands should be used to resolve any overload.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM FunctionRef operand")),
                        set.conceptRef("ELM operand position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, -1,
                        "", edgeForm);
        set.concept("ELM ParameterDef (ELM)").at(inception)
                .synonym("ELM ParameterDef")
                .definition("From the ELM specification: The ParameterDef type defines a parameter that can be"
                        + " referenced by name anywhere within an expression. Parameters are defined at the"
                        + " artifact level, and may be provided as part of the payload for an evaluation request."
                        + " If no parameter value is provided, the default element is used to provide the value"
                        + " for the parameter. If no parameter or default is provided, the parameter is defined"
                        + " to be null. Note that the expression specified in the default element must be able to"
                        + " be evaluated at compile-time (i.e. without reference to any run-time capabilities"
                        + " such as data, terminology, and library references, both local and included).")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ParameterDef default")),
                        set.conceptRef("ELM default position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ParameterDef parameterTypeSpecifier")),
                        set.conceptRef("ELM parameterTypeSpecifier position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ParameterDef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ParameterDef parameterType")),
                        set.conceptRef("ELM parameterType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ParameterDef accessLevel")),
                        set.conceptRef("ELM accessLevel position (ELM)"), set.conceptRef("ELM AccessModifier (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ParameterRef (ELM)").at(inception)
                .synonym("ELM ParameterRef")
                .definition("From the ELM specification: The ParameterRef expression allows the value of a"
                        + " parameter to be referenced as part of an expression.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ParameterRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ParameterRef libraryName")),
                        set.conceptRef("ELM libraryName position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM OperandDef (ELM)").at(inception)
                .synonym("ELM OperandDef")
                .definition("From the ELM specification: The OperandDef type defines an operand to a function that"
                        + " can be referenced by name anywhere within the body of a function definition.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OperandDef operandTypeSpecifier")),
                        set.conceptRef("ELM operandTypeSpecifier position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OperandDef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OperandDef operandType")),
                        set.conceptRef("ELM operandType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM OperandRef (ELM)").at(inception)
                .synonym("ELM OperandRef")
                .definition("From the ELM specification: The OperandRef expression allows the value of an operand"
                        + " to be referenced as part of an expression within the body of a function definition.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OperandRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM IdentifierRef (ELM)").at(inception)
                .synonym("ELM IdentifierRef")
                .definition("From the ELM specification: The IdentifierRef type defines an expression that"
                        + " references an identifier that is either unresolved, or has been resolved to an"
                        + " attribute in an unambiguous iteration scope such as Sort. Implementations should"
                        + " attempt to resolve the identifier, only throwing an error at compile-time (or"
                        + " run-time for an interpretive system) if the identifier reference cannot be resolved.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IdentifierRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IdentifierRef libraryName")),
                        set.conceptRef("ELM libraryName position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Literal (ELM)").at(inception)
                .synonym("ELM Literal")
                .definition("From the ELM specification: The Literal type defines a single scalar value. For"
                        + " example, the literal 5, the boolean value true or the string \"antithrombotic\".")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Literal valueType")),
                        set.conceptRef("ELM valueType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 1, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Literal value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive anySimpleType (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM TupleElement (ELM)").at(inception)
                .synonym("ELM TupleElement")
                .definition("From the ELM specification: The TupleElement is used within a Tuple expression to"
                        + " provide the value of a specific element within a tuple literal expression.")
                .isA(root)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM TupleElement value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM TupleElement name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM Tuple (ELM)").at(inception)
                .synonym("ELM Tuple")
                .definition("From the ELM specification: The Tuple expression allows tuples of any type to be built"
                        + " up as an expression. The tupleType attribute specifies the type of the tuple being"
                        + " built, if any, and the list of tuple elements specify the values for the elements of"
                        + " the tuple. Note that the value of an element may be any expression, including another"
                        + " Tuple.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Tuple element")),
                        set.conceptRef("ELM element position (ELM)"), set.conceptRef("ELM TupleElement (ELM)"), 0, -1,
                        "", edgeForm);
        set.concept("ELM InstanceElement (ELM)").at(inception)
                .synonym("ELM InstanceElement")
                .definition("From the ELM specification: The InstanceElement is used within an Instance expression"
                        + " to provide the value of a specific element within an object literal expression.")
                .isA(root)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM InstanceElement value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM InstanceElement name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM Instance (ELM)").at(inception)
                .synonym("ELM Instance")
                .definition("From the ELM specification: The Instance expression allows class instances of any type"
                        + " to be built up as an expression. The classType attribute specifies the type of the"
                        + " class instance being built, and the list of instance elements specify the values for"
                        + " the elements of the class instance. Note that the value of an element may be any"
                        + " expression, including another Instance.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Instance element")),
                        set.conceptRef("ELM element position (ELM)"), set.conceptRef("ELM InstanceElement (ELM)"), 0, -1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Instance classType")),
                        set.conceptRef("ELM classType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM Interval (ELM)").at(inception)
                .synonym("ELM Interval")
                .definition("From the ELM specification: The Interval selector defines an interval value. An"
                        + " interval must be defined using a point type that supports comparison, as well as"
                        + " Successor and Predecessor operations, and Minimum and Maximum Value operations. The"
                        + " low and high bounds of the interval may each be defined as open or closed. Following"
                        + " standard terminology usage in interval mathematics, an open interval is defined to"
                        + " exclude the specified point, whereas a closed interval includes the point. The"
                        + " default is closed, indicating an inclusive interval. The low and high elements are"
                        + " both optional. If the low element is not specified, the low bound of the resulting"
                        + " interval is null. If the high element is not specified, the high bound of the"
                        + " resulting interval is null. The static type of the low bound determines the type of"
                        + " the interval, and the high bound must be of the same type. If the low bound of the"
                        + " interval is null and open, the low bound of the interval is interpreted as unknown"
                        + " and represented as an uncertainty from the minimum value of the point type of the"
                        + " interval to the high boundary (inclusive); computations involving the low boundary"
                        + " may result in null. If the low bound of the interval is null and closed, the interval"
                        + " is interpreted to start at the minimum value of the point type, and computations"
                        + " involving the low boundary will be performed with that value. If the high bound of"
                        + " the interval is null and open, the high bound of the interval is unknown and"
                        + " represented as an uncertainty from the low boundary (inclusive) to the maximum value"
                        + " of the point type of the interval; computations involving the high boundary may"
                        + " result in null. If the high bound of the interval is null and closed, the interval is"
                        + " interpreted to end at the maximum value of the point type, and computations involving"
                        + " the high boundary will be performed with that interpretation.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Interval low")),
                        set.conceptRef("ELM low position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Interval lowClosedExpression")),
                        set.conceptRef("ELM lowClosedExpression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Interval high")),
                        set.conceptRef("ELM high position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Interval highClosedExpression")),
                        set.conceptRef("ELM highClosedExpression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Interval lowClosed")),
                        set.conceptRef("ELM lowClosed position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Interval highClosed")),
                        set.conceptRef("ELM highClosed position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM List (ELM)").at(inception)
                .synonym("ELM List")
                .definition("From the ELM specification: The List selector returns a value of type List, whose"
                        + " elements are the result of evaluating the arguments to the List selector, in order."
                        + " If a typeSpecifier element is provided, the list is of that type. Otherwise, the"
                        + " static type of the first argument determines the type of the resulting list, and each"
                        + " subsequent argument must be of that same type. If any argument is null, the resulting"
                        + " list will have null for that element.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM List typeSpecifier")),
                        set.conceptRef("ELM typeSpecifier position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM List element")),
                        set.conceptRef("ELM element position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, -1,
                        "", edgeForm);
        set.concept("ELM And (ELM)").at(inception)
                .synonym("ELM And")
                .definition("From the ELM specification: The And operator returns the logical conjunction of its"
                        + " arguments. Note that this operator is defined using 3-valued logic semantics. This"
                        + " means that if either argument is false, the result is false; if both arguments are"
                        + " true, the result is true; otherwise, the result is null. Note also that ELM does not"
                        + " prescribe short-circuit evaluation.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Or (ELM)").at(inception)
                .synonym("ELM Or")
                .definition("From the ELM specification: The Or operator returns the logical disjunction of its"
                        + " arguments. Note that this operator is defined using 3-valued logic semantics. This"
                        + " means that if either argument is true, the result is true; if both arguments are"
                        + " false, the result is false; otherwise, the result is null. Note also that ELM does"
                        + " not prescribe short-circuit evaluation.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Xor (ELM)").at(inception)
                .synonym("ELM Xor")
                .definition("From the ELM specification: The Xor operator returns the exclusive or of its"
                        + " arguments. Note that this operator is defined using 3-valued logic semantics. This"
                        + " means that the result is true if and only if one argument is true and the other is"
                        + " false, and that the result is false if and only if both arguments are true or both"
                        + " arguments are false. If either or both arguments are null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Implies (ELM)").at(inception)
                .synonym("ELM Implies")
                .definition("From the ELM specification: The Implies operator returns the logical implication of"
                        + " its arguments. Note that this operator is defined using 3-valued logic semantics."
                        + " This means that if the left operand evaluates to true, this operator returns the"
                        + " boolean evaluation of the right operand. If the left operand evaluates to false, this"
                        + " operator returns true. Otherwise, this operator returns true if the right operand"
                        + " evaluates to true, and null otherwise. Note that implies may use short-circuit"
                        + " evaluation in the case that the first operand evaluates to false.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Not (ELM)").at(inception)
                .synonym("ELM Not")
                .definition("From the ELM specification: The Not operator returns the logical negation of its"
                        + " argument. If the argument is true, the result is false; if the argument is false, the"
                        + " result is true; otherwise, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM If (ELM)").at(inception)
                .synonym("ELM If")
                .definition("From the ELM specification: The If operator evaluates a condition, and returns the"
                        + " then argument if the condition evaluates to true; if the condition evaluates to false"
                        + " or null, the result of the else argument is returned. The static type of the then"
                        + " argument determines the result type of the conditional, and the else argument must be"
                        + " of that same type.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM If condition")),
                        set.conceptRef("ELM condition position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM If then")),
                        set.conceptRef("ELM then position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM If else")),
                        set.conceptRef("ELM else position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM CaseItem (ELM)").at(inception)
                .synonym("ELM CaseItem")
                .definition("A type of the ELM specification; the schema gives no description.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CaseItem when")),
                        set.conceptRef("ELM when position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CaseItem then")),
                        set.conceptRef("ELM then position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM Case (ELM)").at(inception)
                .synonym("ELM Case")
                .definition("From the ELM specification: The Case operator allows for multiple conditional"
                        + " expressions to be chained together in a single expression, rather than having to nest"
                        + " multiple If operators. In addition, the comparand operand provides a variant on the"
                        + " case that allows a single value to be compared in each conditional. If a comparand is"
                        + " not provided, the type of each when element of the caseItems within the Case is"
                        + " expected to be boolean. If a comparand is provided, the type of each when element of"
                        + " the caseItems within the Case is expected to be of the same type as the comparand. An"
                        + " else element must always be provided. The static type of the then argument within the"
                        + " first caseItem determines the type of the result, and the then argument of each"
                        + " subsequent caseItem and the else argument must be of that same type.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Case comparand")),
                        set.conceptRef("ELM comparand position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Case caseItem")),
                        set.conceptRef("ELM caseItem position (ELM)"), set.conceptRef("ELM CaseItem (ELM)"), 1, -1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Case else")),
                        set.conceptRef("ELM else position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM Null (ELM)").at(inception)
                .synonym("ELM Null")
                .definition("From the ELM specification: The Null operator returns a null, or missing information"
                        + " marker. To avoid the need to cast this result, the operator is allowed to return a"
                        + " typed null.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Null valueType")),
                        set.conceptRef("ELM valueType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM IsNull (ELM)").at(inception)
                .synonym("ELM IsNull")
                .definition("From the ELM specification: The IsNull operator determines whether or not its argument"
                        + " evaluates to null. If the argument evaluates to null, the result is true; otherwise,"
                        + " the result is false.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM IsTrue (ELM)").at(inception)
                .synonym("ELM IsTrue")
                .definition("From the ELM specification: The IsTrue operator determines whether or not its argument"
                        + " evaluates to true. If the argument evaluates to true, the result is true; if the"
                        + " argument evaluates to false or null, the result is false.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM IsFalse (ELM)").at(inception)
                .synonym("ELM IsFalse")
                .definition("From the ELM specification: The IsFalse operator determines whether or not its"
                        + " argument evaluates to false. If the argument evaluates to false, the result is true;"
                        + " if the argument evaluates to true or null, the result is false.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Coalesce (ELM)").at(inception)
                .synonym("ELM Coalesce")
                .definition("From the ELM specification: The Coalesce operator returns the first non-null result in"
                        + " a list of arguments. If all arguments evaluate to null, the result is null. The"
                        + " static type of the first argument determines the type of the result, and all"
                        + " subsequent arguments must be of that same type.")
                .isA(set.conceptRef("ELM NaryExpression (ELM)"));
        set.concept("ELM Is (ELM)").at(inception)
                .synonym("ELM Is")
                .definition("From the ELM specification: The Is operator allows the type of a result to be tested."
                        + " The language must support the ability to test against any type. If the run-time type"
                        + " of the argument is of the type being tested, the result of the operator is true;"
                        + " otherwise, the result is false.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Is isTypeSpecifier")),
                        set.conceptRef("ELM isTypeSpecifier position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Is isType")),
                        set.conceptRef("ELM isType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM As (ELM)").at(inception)
                .synonym("ELM As")
                .definition("From the ELM specification: The As operator allows the result of an expression to be"
                        + " cast as a given target type. This allows expressions to be written that are"
                        + " statically typed against the expected run-time type of the argument. If the argument"
                        + " is not of the specified type, and the strict attribute is false (the default), the"
                        + " result is null. If the argument is not of the specified type and the strict attribute"
                        + " is true, an exception is thrown.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM As asTypeSpecifier")),
                        set.conceptRef("ELM asTypeSpecifier position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM As asType")),
                        set.conceptRef("ELM asType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM As strict")),
                        set.conceptRef("ELM strict position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Convert (ELM)").at(inception)
                .synonym("ELM Convert")
                .definition("From the ELM specification: The Convert operator converts a value to a specific type."
                        + " The result of the operator is the value of the argument converted to the target type,"
                        + " if possible. If no valid conversion exists from the actual value to the target type,"
                        + " the result is null. This operator supports conversion: Between String and each of"
                        + " Boolean, Integer, Long, Decimal, Quantity, Ratio, Date, DateTime, and Time as well"
                        + " as: From Integer to Long, Decimal or Quantity From Decimal to Quantity Between Date"
                        + " and DateTime From Code to Concept Between Concept and List<Code> Conversion between"
                        + " String and Date/DateTime/Time is performed using the ISO-8601 standard format:"
                        + " YYYY-MM-DDThh:mm:ss(+|-)hh:mm.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Convert toTypeSpecifier")),
                        set.conceptRef("ELM toTypeSpecifier position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Convert toType")),
                        set.conceptRef("ELM toType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM CanConvert (ELM)").at(inception)
                .synonym("ELM CanConvert")
                .definition("From the ELM specification: The CanConvert operator returns true if the given value"
                        + " can be converted to a specific type, and false otherwise. This operator returns true"
                        + " for conversion: Between String and each of Boolean, Integer, Long, Decimal, Quantity,"
                        + " Ratio, Date, DateTime, and Time, as well as: From Integer to Long, Decimal, or"
                        + " Quantity From Decimal to Quantity Between Date and DateTime From Code to Concept"
                        + " Between Concept and List<Code> Conversion between String and Date/DateTime/Time is"
                        + " checked using the ISO-8601 standard format: YYYY-MM-DDThh:mm:ss(+|-)hh:mm.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CanConvert toTypeSpecifier")),
                        set.conceptRef("ELM toTypeSpecifier position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CanConvert toType")),
                        set.conceptRef("ELM toType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ToBoolean (ELM)").at(inception)
                .synonym("ELM ToBoolean")
                .definition("From the ELM specification: The ToBoolean operator converts the value of its argument"
                        + " to a Boolean value. The operator accepts 'true', 't', 'yes', 'y', and '1' as string"
                        + " representations of true, and 'false', 'f', 'no', 'n', and '0' as string"
                        + " representations of false, ignoring case. If the input is an Integer or Long, the"
                        + " result is true if the integer is 1, false if the integer is 0. If the input is a"
                        + " Decimal, the result is true if the decimal is 1.0, false if the decimal is 0.0. If"
                        + " the input cannot be interpreted as a valid Boolean value, the result is null. If the"
                        + " argument is null the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToBoolean (ELM)").at(inception)
                .synonym("ELM ConvertsToBoolean")
                .definition("From the ELM specification: The ConvertsToBoolean operator returns true if the value"
                        + " of its argument is or can be converted to a Boolean value. The operator accepts"
                        + " 'true', 't', 'yes', 'y', and '1' as string representations of true, and 'false', 'f',"
                        + " 'no', 'n', and '0' as string representations of false, ignoring case. If the input is"
                        + " an Integer or Long, the result is true if the integer is 1 or 0. If the input is a"
                        + " Decimal, the result is true if the decimal is 1.0 or 0.0. If the input cannot be"
                        + " interpreted as a valid Boolean value, the result is false. If the argument is null"
                        + " the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToConcept (ELM)").at(inception)
                .synonym("ELM ToConcept")
                .definition("From the ELM specification: The ToConcept operator converts a value of type Code to a"
                        + " Concept value with the given Code as its primary and only Code. If the Code has a"
                        + " display value, the resulting Concept will have the same display value. If the input"
                        + " is a list of Codes, the resulting Concept will have all the input Codes, and will not"
                        + " have a display value. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToDate (ELM)").at(inception)
                .synonym("ELM ConvertsToDate")
                .definition("From the ELM specification: The ConvertsToDate operator returns true if the value of"
                        + " its argument is or can be converted to a Date value. For String values, The operator"
                        + " expects the string to be formatted using the ISO-8601 date representation: YYYY-MM-DD"
                        + " In addition, the string must be interpretable as a valid date value. Note that the"
                        + " operator can take time formatted strings and will ignore the time portions. If the"
                        + " input string is not formatted correctly, or does not represent a valid date value,"
                        + " the result is false. As with date literals, date values may be specified to any"
                        + " precision. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToDate (ELM)").at(inception)
                .synonym("ELM ToDate")
                .definition("From the ELM specification: The ToDate operator converts the value of its argument to"
                        + " a Date value. For String values, The operator expects the string to be formatted"
                        + " using the ISO-8601 date representation: YYYY-MM-DD See the Formatting Strings topic"
                        + " in the CQL Reference (Appendix B) of the CQL Specification for a description of"
                        + " formatting strings. In addition, the string must be interpretable as a valid date"
                        + " value. Note that the operator can take datetime formatted strings and will ignore the"
                        + " time portions. If the input string is not formatted correctly, or does not represent"
                        + " a valid date value, the result is null. As with date literals, date values may be"
                        + " specified to any precision. For DateTime values, the result is equivalent to"
                        + " extracting the Date component of the DateTime value. If the argument is null, the"
                        + " result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToDateTime (ELM)").at(inception)
                .synonym("ELM ConvertsToDateTime")
                .definition("From the ELM specification: The ConvertsToDateTime operator returns true if the value"
                        + " of its argument is or can be converted to a DateTime value. For String values, the"
                        + " operator expects the string to be formatted using the ISO-8601 datetime"
                        + " representation: YYYY-MM-DDThh:mm:ss.fff(Z|((+|-)hh:mm)) See the Formatting Strings"
                        + " topic in the CQL Reference (Appendix B) of the CQL Specification for a description of"
                        + " formatting strings. In addition, the string must be interpretable as a valid DateTime"
                        + " value. If the input string is not formatted correctly, or does not represent a valid"
                        + " DateTime value, the result is false. As with Date and Time literals, DateTime values"
                        + " may be specified to any precision. If no timezone offset is supplied, the timezone"
                        + " offset of the evaluation request timestamp is assumed. If the argument is null, the"
                        + " result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToDateTime (ELM)").at(inception)
                .synonym("ELM ToDateTime")
                .definition("From the ELM specification: The ToDateTime operator converts the value of its argument"
                        + " to a DateTime value. For String values, the operator expects the string to be"
                        + " formatted using the ISO-8601 datetime representation:"
                        + " YYYY-MM-DDThh:mm:ss.fff(Z|((+|-)hh:mm)) See the Formatting Strings topic in the CQL"
                        + " Reference (Appendix B) of the CQL Specification for a description of formatting"
                        + " strings. In addition, the string must be interpretable as a valid DateTime value. If"
                        + " the input string is not formatted correctly, or does not represent a valid DateTime"
                        + " value, the result is null. As with Date and Time literals, DateTime values may be"
                        + " specified to any precision. If no timezone offset is supplied, the timezone offset of"
                        + " the evaluation request timestamp is assumed. For Date values, the result is a"
                        + " DateTime with the time components unspecified, except the timezone offset, which is"
                        + " set to the timezone offset of the evaluation request timestamp. If the argument is"
                        + " null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToDecimal (ELM)").at(inception)
                .synonym("ELM ConvertsToDecimal")
                .definition("From the ELM specification: The ConvertsToDecimal operator returns true if the value"
                        + " of its argument is or can be converted to a Decimal value. The operator accepts"
                        + " strings using the following format: (+|-)?#0(.0#)? Meaning an optional polarity"
                        + " indicator, followed by any number of digits (including none), followed by at least"
                        + " one digit, followed optionally by a decimal point, at least one digit, and any number"
                        + " of additional digits (including none). See the Formatting Strings topic in the CQL"
                        + " Reference (Appendix B) of the CQL Specification for a description of formatting"
                        + " strings. Note that for this operator to return true, the input value must be limited"
                        + " in precision and scale to the maximum precision and scale representable for Decimal"
                        + " values within CQL. If the input string is not formatted correctly, or cannot be"
                        + " interpreted as a valid Decimal value, the result is false. If the input is a Boolean,"
                        + " the result is true. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToDecimal (ELM)").at(inception)
                .synonym("ELM ToDecimal")
                .definition("From the ELM specification: The ToDecimal operator converts the value of its argument"
                        + " to a Decimal value. The operator accepts strings using the following format:"
                        + " (+|-)?#0(.0#)? Meaning an optional polarity indicator, followed by any number of"
                        + " digits (including none), followed by at least one digit, followed optionally by a"
                        + " decimal point, at least one digit, and any number of additional digits (including"
                        + " none). See the Formatting Strings topic in the CQL Reference (Appendix B) of the CQL"
                        + " Specification for a description of formatting strings. Note that the decimal value"
                        + " returned by this operator must be limited in precision and scale to the maximum"
                        + " precision and scale representable for Decimal values within CQL. If the input string"
                        + " is not formatted correctly, or cannot be interpreted as a valid Decimal value, the"
                        + " result is null. If the input is Boolean, true will result in 1.0, false will result"
                        + " in 0.0. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToInteger (ELM)").at(inception)
                .synonym("ELM ConvertsToInteger")
                .definition("From the ELM specification: The ConvertsToInteger operator returns true if the value"
                        + " of its argument is or can be converted to an Integer value. The operator accepts"
                        + " strings using the following format: (+|-)?#0 Meaning an optional polarity indicator,"
                        + " followed by any number of digits (including none), followed by at least one digit."
                        + " See the Formatting Strings topic in the CQL Reference (Appendix B) of the CQL"
                        + " Specification for a description of formatting strings. Note that for this operator to"
                        + " return true, the input must be a valid value in the range representable for Integer"
                        + " values in CQL. If the input string is not formatted correctly, or cannot be"
                        + " interpreted as a valid Integer value, the result is false. If the input is a Boolean,"
                        + " the result is true. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToInteger (ELM)").at(inception)
                .synonym("ELM ToInteger")
                .definition("From the ELM specification: The ToInteger operator converts the value of its argument"
                        + " to an Integer value. The operator accepts strings using the following format:"
                        + " (+|-)?#0 Meaning an optional polarity indicator, followed by any number of digits"
                        + " (including none), followed by at least one digit. See the Formatting Strings topic in"
                        + " the CQL Reference (Appendix B) of the CQL Specification for a description of"
                        + " formatting strings. Note that the integer value returned by this operator must be a"
                        + " valid value in the range representable for Integer values in CQL. If the input string"
                        + " is not formatted correctly, or cannot be interpreted as a valid Integer value, the"
                        + " result is null. If the input is Boolean, true will result in 1, false will result in"
                        + " 0. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToLong (ELM)").at(inception)
                .synonym("ELM ConvertsToLong")
                .definition("From the ELM specification: The ConvertsToLong operator returns true if the value of"
                        + " its argument is or can be converted to a Long value. The operator accepts strings"
                        + " using the following format: (+|-)?#0 Meaning an optional polarity indicator, followed"
                        + " by any number of digits (including none), followed by at least one digit. See the"
                        + " Formatting Strings topic in the CQL Reference (Appendix B) of the CQL Specification"
                        + " for a description of formatting strings. Note that for this operator to return true,"
                        + " the input must be a valid value in the range representable for Long values in CQL. If"
                        + " the input string is not formatted correctly, or cannot be interpreted as a valid Long"
                        + " value, the result is false. If the input is a Boolean, the result is true. If the"
                        + " argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToLong (ELM)").at(inception)
                .synonym("ELM ToLong")
                .definition("From the ELM specification: The ToLong operator converts the value of its argument to"
                        + " a Long value. The operator accepts strings using the following format: (+|-)?#0"
                        + " Meaning an optional polarity indicator, followed by any number of digits (including"
                        + " none), followed by at least one digit. See the Formatting Strings topic in the CQL"
                        + " Reference (Appendix B) of the CQL Specification for a description of formatting"
                        + " strings. Note that the long value returned by this operator must be a valid value in"
                        + " the range representable for Long values in CQL. If the input string is not formatted"
                        + " correctly, or cannot be interpreted as a valid Long value, the result is null. If the"
                        + " argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToQuantity (ELM)").at(inception)
                .synonym("ELM ConvertsToQuantity")
                .definition("From the ELM specification: The ConvertsToQuantity operator returns true if the value"
                        + " of its argument is or can be converted to a Quantity value. The operator may be used"
                        + " with Integer, Decimal, Ratio, or String values. For String values, the operator"
                        + " accepts strings using the following format: (+|-)?#0(.0#)?('<unit>')? Meaning an"
                        + " optional polarity indicator, followed by any number of digits (including none)"
                        + " followed by at least one digit, optionally followed by a decimal point, at least one"
                        + " digit, and any number of additional digits, all optionally followed by a unit"
                        + " designator as a string literal specifying a valid UCUM unit of measure or calendar"
                        + " duration keyword, singular or plural. Spaces are allowed between the quantity value"
                        + " and the unit designator. See the Formatting Strings topic in the CQL Reference"
                        + " (Appendix B) of the CQL Specification for a description of formatting strings. Note"
                        + " that the decimal value of the quantity returned by this operator must be a valid"
                        + " value in the range representable for Decimal values in CQL. If the input string is"
                        + " not formatted correctly, or cannot be interpreted as a valid Quantity value, the"
                        + " result is false. For Integer, Decimal, and Ratio values, the operator simply returns"
                        + " true. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToQuantity (ELM)").at(inception)
                .synonym("ELM ToQuantity")
                .definition("From the ELM specification: The ToQuantity operator converts the value of its argument"
                        + " to a Quantity value. The operator may be used with Integer, Decimal, Ratio, or String"
                        + " values. The operation does not perform any unit conversion, that capability is"
                        + " supported by the ConvertQuantity operator. For String values, the operator accepts"
                        + " strings using the following format: (+|-)?#0(.0#)?('<unit>')? Meaning an optional"
                        + " polarity indicator, followed by any number of digits (including none) followed by at"
                        + " least one digit, optionally followed by a decimal point, at least one digit, and any"
                        + " number of additional digits, all optionally followed by a unit designator as a string"
                        + " literal specifying a valid UCUM unit of measure or calendar duration keyword,"
                        + " singular or plural. Spaces are allowed between the quantity value and the unit"
                        + " designator. See the Formatting Strings topic in the CQL Reference (Appendix B) of the"
                        + " CQL Specification for a description of formatting strings. Note that the decimal"
                        + " value of the quantity returned by this operator must be a valid value in the range"
                        + " representable for Decimal values in CQL. If the input string is not formatted"
                        + " correctly, or cannot be interpreted as a valid Quantity value, the result is null."
                        + " For Integer and Decimal values, the result is a Quantity with the value of the"
                        + " integer or decimal input, and the default unit ('1'). For Ratio values, the operation"
                        + " is equivalent to the result of dividing the numerator of the ratio by the"
                        + " denominator. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToRatio (ELM)").at(inception)
                .synonym("ELM ConvertsToRatio")
                .definition("From the ELM specification: The ConvertsToRatio operator returns true if the value of"
                        + " its argument is or can be converted to a Ratio value. The operator accepts strings"
                        + " using the following format: <quantity>:<quantity> Meaning a quantity, followed by a"
                        + " colon (:), followed by another quantity. The operator accepts quantity strings using"
                        + " the same format as the ToQuantity operator. If the input string is not formatted"
                        + " correctly, or cannot be interpreted as a valid Ratio value, the result is false. If"
                        + " the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToRatio (ELM)").at(inception)
                .synonym("ELM ToRatio")
                .definition("From the ELM specification: The ToRatio operator converts the value of its argument to"
                        + " a Ratio value. The operator accepts strings using the following format:"
                        + " <quantity>:<quantity> Meaning a quantity, followed by a colon (:), followed by"
                        + " another quantity. The operator accepts quantity strings using the same format as the"
                        + " ToQuantity operator. If the input string is not formatted correctly, or cannot be"
                        + " interpreted as a valid Ratio value, the result is null. If the argument is null, the"
                        + " result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToList (ELM)").at(inception)
                .synonym("ELM ToList")
                .definition("From the ELM specification: The ToList operator returns its argument as a List value."
                        + " The operator accepts a singleton value of any type and returns a list with the value"
                        + " as the single element. If the argument is null, the operator returns an empty list."
                        + " The operator is effectively shorthand for \"if operand is null then { } else { operand"
                        + " }\". The operator is used to implement list promotion efficiently.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToChars (ELM)").at(inception)
                .synonym("ELM ToChars")
                .definition("From the ELM specification: The ToChars operator takes a string and returns a list"
                        + " with one string for each character in the input, in the order in which they appear in"
                        + " the string. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToString (ELM)").at(inception)
                .synonym("ELM ConvertsToString")
                .definition("From the ELM specification: The ConvertsToString operator returns true if the value of"
                        + " its argument is or can be converted to a String value. The operator returns true if"
                        + " the argument is any of the following types: Boolean Integer Long Decimal DateTime"
                        + " Date Time Quantity Ratio String If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToString (ELM)").at(inception)
                .synonym("ELM ToString")
                .definition("From the ELM specification: The ToString operator converts the value of its argument"
                        + " to a String value. The operator uses the following string representations for each"
                        + " type: Boolean true|false Integer (-)?#0 Long (-)?#0 Decimal (-)?#0.0# Quantity"
                        + " (-)?#0.0# '<unit>' Date YYYY-MM-DD DateTime YYYY-MM-DDThh:mm:ss.fff(+|-)hh:mm Time"
                        + " hh:mm:ss.fff Ratio <quantity>:<quantity> See the Formatting Strings topic in the CQL"
                        + " Reference (Appendix B) of the CQL Specification for a description of formatting"
                        + " strings. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ConvertsToTime (ELM)").at(inception)
                .synonym("ELM ConvertsToTime")
                .definition("From the ELM specification: The ConvertsToTime operator returns true if the value of"
                        + " its argument is or can be converted to a Time value. For String values, the operator"
                        + " expects the string to be formatted using ISO-8601 time representation: hh:mm:ss.fff"
                        + " See the Formatting Strings topic in the CQL Reference (Appendix B) of the CQL"
                        + " Specification for a description of formatting strings. In addition, the string must"
                        + " be interpretable as a valid time-of-day value. If the input string is not formatted"
                        + " correctly, or does not represent a valid time-of-day value, the result is false. As"
                        + " with time-of-day literals, time-of-day values may be specified to any precision. If"
                        + " the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM ToTime (ELM)").at(inception)
                .synonym("ELM ToTime")
                .definition("From the ELM specification: The ToTime operator converts the value of its argument to"
                        + " a Time value. For String values, the operator expects the string to be formatted"
                        + " using ISO-8601 time representation: hh:mm:ss.fff See the Formatting Strings topic in"
                        + " the CQL Reference (Appendix B) of the CQL Specification for a description of"
                        + " formatting strings. In addition, the string must be interpretable as a valid"
                        + " time-of-day value. If the input string is not formatted correctly, or does not"
                        + " represent a valid time-of-day value, the result is null. As with time-of-day"
                        + " literals, time-of-day values may be specified to any precision. For DateTime values,"
                        + " the result is the same as extracting the Time component from the DateTime value. If"
                        + " the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM CanConvertQuantity (ELM)").at(inception)
                .synonym("ELM CanConvertQuantity")
                .definition("From the ELM specification: The CanConvertQuantity operator returns true if the"
                        + " Quantity can be converted to an equivalent Quantity with the given Unit. Otherwise,"
                        + " the result is false. Note that implementations are not required to support quantity"
                        + " conversion, and so may return false, even if the conversion is valid. Implementations"
                        + " that do support unit conversion shall do so according to the conversion specified by"
                        + " UCUM. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM ConvertQuantity (ELM)").at(inception)
                .synonym("ELM ConvertQuantity")
                .definition("From the ELM specification: The ConvertQuantity operator converts a Quantity to an"
                        + " equivalent Quantity with the given unit. If the unit of the input quantity can be"
                        + " converted to the target unit, the result is an equivalent Quantity with the target"
                        + " unit. Otherwise, the result is null. Note that implementations are not required to"
                        + " support quantity conversion. Implementations that do support unit conversion shall do"
                        + " so according to the conversion specified by UCUM. Implementations that do not support"
                        + " unit conversion shall throw an error if an unsupported unit conversion is requested"
                        + " with this operation. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Equal (ELM)").at(inception)
                .synonym("ELM Equal")
                .definition("From the ELM specification: The Equal operator returns true if the arguments are"
                        + " equal; false if the arguments are known unequal, and null otherwise. Equality"
                        + " semantics are defined to be value-based. For simple types, this means that equality"
                        + " returns true if and only if the result of each argument evaluates to the same value."
                        + " For string values, equality is strictly lexical based on the Unicode values for the"
                        + " individual characters in the strings. For decimal values, trailing zeroes are"
                        + " ignored. For quantities, this means that the dimensions of each quantity must be the"
                        + " same, but not necessarily the unit. For example, units of 'cm' and 'm' are"
                        + " comparable, but units of 'cm2' and 'cm' are not. Attempting to operate on quantities"
                        + " with invalid units will result in null. When a quantity has no units specified, it is"
                        + " treated as a quantity with the default unit ('1'). For time-valued quantities, UCUM"
                        + " definite-time duration quantities above days (and weeks) are not comparable to"
                        + " calendar duration quantities above days (and weeks). Definite-time duration unit"
                        + " conversions shall be performed as specified in ISO-8601, while calendar-time duration"
                        + " unit conversions shall be performed according to calendar duration semantics. In"
                        + " particular, unit conversion between variable length calendar durations (i.e. years"
                        + " and months) and definite-time durations (i.e. days or below) results in null. For"
                        + " ratios, this means that the numerator and denominator must be the same, using"
                        + " quantity equality semantics. For tuple types, this means that equality returns true"
                        + " if and only if the tuples are of the same type, and the values for all elements that"
                        + " have values, by name, are equal. For list types, this means that equality returns"
                        + " true if and only if the lists contain elements of the same type, have the same number"
                        + " of elements, and for each element in the lists, in order, the elements are equal"
                        + " using equality semantics, with the exception that null elements are considered equal."
                        + " For interval types, equality returns true if and only if the intervals are over the"
                        + " same point type, and they have the same value for the starting and ending points of"
                        + " the interval as determined by the Start and End operators. For Date, Time, and"
                        + " DateTime values, the comparison is performed by considering each precision in order,"
                        + " beginning with years (or hours for time values). If the values are the same,"
                        + " comparison proceeds to the next precision; if the values are different, the"
                        + " comparison stops and the result is false. If one input has a value for the precision"
                        + " and the other does not, the comparison stops and the result is null; if neither input"
                        + " has a value for the precision or the last precision has been reached, the comparison"
                        + " stops and the result is true. For the purposes of comparison, seconds and"
                        + " milliseconds are combined as a single precision using a decimal, with decimal"
                        + " equality semantics. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Equivalent (ELM)").at(inception)
                .synonym("ELM Equivalent")
                .definition("From the ELM specification: The Equivalent operator returns true if the arguments are"
                        + " the same value, or if they are both null; and false otherwise. With the exception of"
                        + " null behavior and the semantics for specific types defined below, equivalence is the"
                        + " same as equality. For string values, equivalence returns true if the strings are the"
                        + " same value while ignoring case and locale, and normalizing whitespace. Normalizing"
                        + " whitespace means that all whitespace characters are treated as equivalent, with"
                        + " whitespace characters as defined in the whitespace lexical category. For decimals,"
                        + " equivalent means the values are the same with the comparison done on values rounded"
                        + " to the least precision of the least precise operand; trailing zeroes after the"
                        + " decimal are ignored in determining precision for equivalent comparison. For"
                        + " quantities, equivalent means the values are the same quantity when considering unit"
                        + " conversion (e.g. 100 'cm' ~ 1 'm') and using decimal equivalent semantics for the"
                        + " value. Note that implementations are not required to support unit conversion and so"
                        + " are allowed to return false for equivalence of quantities with different units. For"
                        + " time-valued quantities, UCUM definite-time duration quantities above days (and weeks)"
                        + " are considered equivalent to their calendar duration counterparts. Definite-time"
                        + " duration unit conversions shall be performed as specified in ISO-8601, while"
                        + " calendar-time duration unit conversions shall be performed according to the calendar"
                        + " duration semantics. In particular, unit conversion between variable length calendar"
                        + " durations (i.e. years and months) and definite-time durations (i.e. days or below)"
                        + " uses the approximations of 365 days in a year, and 30 days in a month. For ratios,"
                        + " equivalent means that the numerator and denominator represent the same ratio (e.g."
                        + " 1:100 ~ 10:1000). For tuple types, this means that two tuple values are equivalent if"
                        + " and only if the tuples are of the same type, and the values for all elements by name"
                        + " are equivalent. For list types, this means that two lists are equivalent if and only"
                        + " if the lists contain elements of the same type, have the same number of elements, and"
                        + " for each element in the lists, in order, the elements are equivalent. For interval"
                        + " types, this means that two intervals are equivalent if and only if the intervals are"
                        + " over the same point type, and the starting and ending points of the intervals as"
                        + " determined by the Start and End operators are equivalent. For Date, Time, and"
                        + " DateTime values, the comparison is performed in the same way as it is for equality,"
                        + " except that if one input has a value for a given precision and the other does not,"
                        + " the comparison stops and the result is false, rather than null. As with equality, the"
                        + " second and millisecond precisions are combined as a single precision using a decimal,"
                        + " with decimal equivalence semantics. For Code values, equivalence is defined based on"
                        + " the code and system elements only. The display and version elements are ignored for"
                        + " the purposes of determining Code equivalence. For Concept values, equivalence is"
                        + " defined as a non-empty intersection of the codes in each Concept. Note that this"
                        + " operator will always return true or false, even if either or both of its arguments"
                        + " are null or contain null components.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM NotEqual (ELM)").at(inception)
                .synonym("ELM NotEqual")
                .definition("From the ELM specification: The NotEqual operator returns true if its arguments are"
                        + " not the same value. The NotEqual operator is a shorthand for invocation of logical"
                        + " negation of the Equal operator.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Less (ELM)").at(inception)
                .synonym("ELM Less")
                .definition("From the ELM specification: The Less operator returns true if the first argument is"
                        + " less than the second argument. For comparisons involving quantities, the dimensions"
                        + " of each quantity must be the same, but not necessarily the unit. For example, units"
                        + " of 'cm' and 'm' are comparable, but units of 'cm2' and 'cm' are not. Attempting to"
                        + " operate on quantities with invalid units will result in a null. When a quantity has"
                        + " no units specified, it is treated as a quantity with the default unit ('1'). For"
                        + " time-valued quantities, the UCUM definite-quantity durations above days (and weeks)"
                        + " are not comparable to calendar durations. Definite-time duration unit conversions"
                        + " shall be performed as specified in ISO-8601, while calendar-time duration unit"
                        + " conversions shall be performed according to calendar duration semantics. In"
                        + " particular, unit conversion between variable length calendar durations (i.e. years"
                        + " and months) and definite-time durations (i.e. days or below) results in null. For"
                        + " Date, Time, and DateTime values, the comparison is performed by considering each"
                        + " precision in order, beginning with years (or hours for time values). If the values"
                        + " are the same, comparison proceeds to the next precision; if the first value is less"
                        + " than the second, the result is true; if the first value is greater than the second,"
                        + " the result is false; if one input has a value for the precision and the other does"
                        + " not, the comparison stops and the result is null; if neither input has a value for"
                        + " the precision or the last precision has been reached, the comparison stops and the"
                        + " result is false. For the purposes of comparison, seconds and milliseconds are"
                        + " combined as a single precision using a decimal, with decimal comparison semantics. If"
                        + " either argument is null, the result is null. The Less operator is defined for the"
                        + " Integer, Long, Decimal, String, Date, DateTime, Time, and Quantity types. Note that"
                        + " relative ratio comparisons are not directly supported due to the variance of uses"
                        + " within healthcare. See the discussion in Ratio Operators in the Author's Guide for"
                        + " more information.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Greater (ELM)").at(inception)
                .synonym("ELM Greater")
                .definition("From the ELM specification: The Greater operator returns true if the first argument is"
                        + " greater than the second argument. The Greater operator is defined for the Integer,"
                        + " Long, Decimal, String, Date, DateTime, Time, and Quantity types. For comparisons"
                        + " involving quantities, the dimensions of each quantity must be the same, but not"
                        + " necessarily the unit. For example, units of 'cm' and 'm' are comparable, but units of"
                        + " 'cm2' and 'cm' are not. Attempting to operate on quantities with invalid units will"
                        + " result in null. When a quantity has no units specified, it is treated as a quantity"
                        + " with the default unit ('1'). For time-valued quantities, the UCUM definite-quantity"
                        + " durations above days (and weeks) are not comparable to calendar durations."
                        + " Definite-time duration unit conversions shall be performed as specified in ISO-8601,"
                        + " while calendar-time duration unit conversions shall be performed according to"
                        + " calendar duration semantics. In particular, unit conversion between variable length"
                        + " calendar durations (i.e. years and months) and definite-time durations (i.e. days or"
                        + " below) results in null. For Date, Time, and DateTime values, the comparison is"
                        + " performed by considering each precision in order, beginning with years (or hours for"
                        + " time values). If the values are the same, comparison proceeds to the next precision;"
                        + " if the first value is greater than the second, the result is true; if the first value"
                        + " is less than the second, the result is false; if one input has a value for the"
                        + " precision and the other does not, the comparison stops and the result is null; if"
                        + " neither input has a value for the precision or the last precision has been reached,"
                        + " the comparison stops and the result is false. For the purposes of comparison, seconds"
                        + " and milliseconds are combined as a single precision using a decimal, with decimal"
                        + " comparison semantics. When comparing DateTime values with different timezone offsets,"
                        + " implementations should normalize to the timezone offset of the evaluation request"
                        + " timestamp, but only when the comparison precision is hours, minutes, seconds, or"
                        + " milliseconds. If either argument is null, the result is null. Note that relative"
                        + " ratio comparisons are not directly supported due to the variance of uses within"
                        + " healthcare. See the discussion in Ratio Operators in the Author's Guide for more"
                        + " information.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM LessOrEqual (ELM)").at(inception)
                .synonym("ELM LessOrEqual")
                .definition("From the ELM specification: The LessOrEqual operator returns true if the first"
                        + " argument is less than or equal to the second argument. The LessOrEqual operator is"
                        + " defined for the Integer, Long, Decimal, String, Date, DateTime, Time, and Quantity"
                        + " types. For comparisons involving quantities, the dimensions of each quantity must be"
                        + " the same, but not necessarily the unit. For example, units of 'cm' and 'm' are"
                        + " comparable, but units of 'cm2' and 'cm' are not. Attempting to operate on quantities"
                        + " with invalid units will result in a null. When a quantity has no units specified, it"
                        + " is treated as a quantity with the default unit ('1'). For time-valued quantities, the"
                        + " UCUM definite-quantity durations above days (and weeks) are not comparable to"
                        + " calendar durations. Definite-time duration unit conversions shall be performed as"
                        + " specified in ISO-8601, while calendar-time duration unit conversions shall be"
                        + " performed according to calendar duration semantics. In particular, unit conversion"
                        + " between variable length calendar durations (i.e. years and months) and definite-time"
                        + " durations (i.e. days or below) results in null. For Date, Time, and DateTime values,"
                        + " the comparison is performed by considering each precision in order, beginning with"
                        + " years (or hours for time values). If the values are the same, comparison proceeds to"
                        + " the next precision; if the first value is less than the second, the result is true;"
                        + " if the first value is greater than the second, the result is false; if one input has"
                        + " a value for the precision and the other does not, the comparison stops and the result"
                        + " is null; if neither input has a value for the precision or the last precision has"
                        + " been reached, the comparison stops and the result is true. For the purposes of"
                        + " comparison, seconds and milliseconds are combined as a single precision using a"
                        + " decimal, with decimal comparison semantics. When comparing DateTime values with"
                        + " different timezone offsets, implementations should normalize to the timezone offset"
                        + " of the evaluation request timestamp, but only when the comparison precision is hours,"
                        + " minutes, seconds, or milliseconds. If either argument is null, the result is null."
                        + " Note that relative ratio comparisons are not directly supported due to the variance"
                        + " of uses within healthcare. See the discussion in Ratio Operators in the Author's"
                        + " Guide for more information.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM GreaterOrEqual (ELM)").at(inception)
                .synonym("ELM GreaterOrEqual")
                .definition("From the ELM specification: The GreaterOrEqual operator returns true if the first"
                        + " argument is greater than or equal to the second argument. The GreaterOrEqual operator"
                        + " is defined for the Integer, Long, Decimal, String, Date, DateTime, Time, and Quantity"
                        + " types. For comparisons involving quantities, the dimensions of each quantity must be"
                        + " the same, but not necessarily the unit. For example, units of 'cm' and 'm' are"
                        + " comparable, but units of 'cm2' and 'cm' are not. Attempting to operate on quantities"
                        + " with invalid units will result in a null. When a quantity has no units specified, it"
                        + " is treated as a quantity with the default unit ('1'). For time-valued quantities, the"
                        + " UCUM definite-quantity durations above days (and weeks) are not comparable to"
                        + " calendar durations. Definite-time duration unit conversions shall be performed as"
                        + " specified in ISO-8601, while calendar-time duration unit conversions shall be"
                        + " performed according to calendar duration semantics. In particular, unit conversion"
                        + " between variable length calendar durations (i.e. years and months) and definite-time"
                        + " durations (i.e. days or below) results in null. For Date, Time, and DateTime values,"
                        + " the comparison is performed by considering each precision in order, beginning with"
                        + " years (or hours for time values). If the values are the same, comparison proceeds to"
                        + " the next precision; if the first value is greater than the second, the result is"
                        + " true; if the first value is less than the second, the result is false; if one input"
                        + " has a value for the precision and the other does not, the comparison stops and the"
                        + " result is null; if neither input has a value for the precision or the last precision"
                        + " has been reached, the comparison stops and the result is true. For the purposes of"
                        + " comparison, seconds and milliseconds are combined as a single precision using a"
                        + " decimal, with decimal comparison semantics. When comparing DateTime values with"
                        + " different timezone offsets, implementations should normalize to the timezone offset"
                        + " of the evaluation request timestamp, but only when the comparison precision is hours,"
                        + " minutes, seconds, or milliseconds. If either argument is null, the result is null."
                        + " Note that relative ratio comparisons are not directly supported due to the variance"
                        + " of uses within healthcare. See the discussion in Ratio Operators in the Author's"
                        + " Guide for more information.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Add (ELM)").at(inception)
                .synonym("ELM Add")
                .definition("From the ELM specification: The Add operator performs numeric addition of its"
                        + " arguments. When adding quantities, the dimensions of each quantity must be the same,"
                        + " but not necessarily the unit. For example, units of 'cm' and 'm' can be added, but"
                        + " units of 'cm2' and 'cm' cannot. The unit of the result will be the most granular unit"
                        + " of either input. Attempting to operate on quantities with invalid units will result"
                        + " in a run-time error. The Add operator is defined for the Integer, Long, Decimal, and"
                        + " Quantity types. In addition, a time-valued Quantity can be added to a Date, DateTime"
                        + " or Time using this operator. For Date, DateTime, and Time values, the operator"
                        + " returns the value of the first argument, incremented by the time-valued quantity,"
                        + " respecting variable length periods for calendar years and months. For Date values,"
                        + " the quantity unit must be one of years, months, weeks, or days. For DateTime values,"
                        + " the quantity unit must be one of years, months, weeks, days, hours, minutes, seconds,"
                        + " or milliseconds. For Time values, the quantity unit must be one of hours, minutes,"
                        + " seconds, or milliseconds. Note that as with any Date, Time, or DateTime operations,"
                        + " temporal units may be specified with either singular, plural, or UCUM units. However,"
                        + " to avoid the potential confusion of calendar-based date and time arithmetic with"
                        + " definite-duration date and time arithmetic, it is an error to attempt to add a"
                        + " definite-duration time-valued unit above days (and weeks), a calendar duration must"
                        + " be used. For precisions above seconds, any decimal portion of the time-valued"
                        + " quantity is ignored, since date/time arithmetic above seconds is performed with"
                        + " calendar duration semantics. For partial date/time values where the time-valued"
                        + " quantity is more precise than the partial date/time, the operation is performed by"
                        + " converting the time-based quantity to the highest specified granularity in the first"
                        + " argument (truncating any resulting decimal portion) and then adding it to the first"
                        + " argument. If either argument is null, the result is null. If the result of the"
                        + " addition cannot be represented (i.e. arithmetic overflow), the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Subtract (ELM)").at(inception)
                .synonym("ELM Subtract")
                .definition("From the ELM specification: The Subtract operator performs numeric subtraction of its"
                        + " arguments. When subtracting quantities, the dimensions of each quantity must be the"
                        + " same, but not necessarily the unit. For example, units of 'cm' and 'm' can be"
                        + " subtracted, but units of 'cm2' and 'cm' cannot. The unit of the result will be the"
                        + " most granular unit of either input. Attempting to operate on quantities with invalid"
                        + " units will result in a run-time error. The Subtract operator is defined for the"
                        + " Integer, Long, Decimal, and Quantity types. In addition, a time-valued Quantity can"
                        + " be subtracted from a Date, DateTime, or Time using this operator. For Date, DateTime,"
                        + " Time values, the operator returns the value of the first argument, decremented by the"
                        + " time-valued quantity, respecting variable length periods for calendar years and"
                        + " months. For Date values, the quantity unit must be one of years, months, weeks, or"
                        + " days. For DateTime values, the quantity unit must be one of years, months, weeks,"
                        + " days, hours, minutes, seconds, or milliseconds. For Time values, the quantity unit"
                        + " must be one of hours, minutes, seconds, or milliseconds. Note that as with any Date,"
                        + " Time, or DateTime operations, temporal units may be specified with either singular,"
                        + " plural, or UCUM units. However, to avoid the potential confusion of calendar-based"
                        + " date and time arithmetic with definite-duration date and time arithmetic, it is an"
                        + " error to attempt to subtract a definite-duration time-valued unit above days (and"
                        + " weeks), a calendar duration must be used. For precisions above seconds, any decimal"
                        + " portion of the time-valued quantity is ignored, since date/time arithmetic above"
                        + " seconds is performed with calendar duration semantics. For partial date/time values"
                        + " where the time-valued quantity is more precise than the partial date/time, the"
                        + " operation is performed by converting the time-based quantity to the highest specified"
                        + " granularity in the first argument (truncating any resulting decimal portion) and then"
                        + " subtracting it from the first argument. If either argument is null, the result is"
                        + " null. If the result of the operation cannot be represented, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Multiply (ELM)").at(inception)
                .synonym("ELM Multiply")
                .definition("From the ELM specification: The Multiply operator performs numeric multiplication of"
                        + " its arguments. For multiplication operations involving quantities, the resulting"
                        + " quantity will have the appropriate unit. If either argument is null, the result is"
                        + " null. If the result of the operation cannot be represented, the result is null. The"
                        + " Multiply operator is defined for the Integer, Long, Decimal and Quantity types.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Divide (ELM)").at(inception)
                .synonym("ELM Divide")
                .definition("From the ELM specification: The Divide operator performs numeric division of its"
                        + " arguments. Note that the result type of Divide is Decimal, even if its arguments are"
                        + " of type Integer. For integer division, use the truncated divide operator. For"
                        + " division operations involving quantities, the resulting quantity will have the"
                        + " appropriate unit. If either argument is null, the result is null. If the result of"
                        + " the division cannot be represented, or the right argument is 0, the result is null."
                        + " The Divide operator is defined for the Decimal and Quantity types.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM TruncatedDivide (ELM)").at(inception)
                .synonym("ELM TruncatedDivide")
                .definition("From the ELM specification: The TruncatedDivide operator performs integer division of"
                        + " its arguments. If either argument is null, the result is null. If the result of the"
                        + " operation cannot be represented, or the right argument is 0, the result is null. The"
                        + " TruncatedDivide operator is defined for the Integer, Long, Decimal, and Quantity"
                        + " types. For TruncatedDivide operations involving quantities, the resulting quantity"
                        + " will have the appropriate unit.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Modulo (ELM)").at(inception)
                .synonym("ELM Modulo")
                .definition("From the ELM specification: The Modulo operator computes the remainder of the division"
                        + " of its arguments. If either argument is null, the result is null. If the result of"
                        + " the modulo cannot be represented, or the right argument is 0, the result is null. The"
                        + " Modulo operator is defined for the Integer, Long, Decimal, and Quantity types. For"
                        + " Modulo operations involving quantities, the resulting quantity will have the"
                        + " appropriate unit.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Ceiling (ELM)").at(inception)
                .synonym("ELM Ceiling")
                .definition("From the ELM specification: The Ceiling operator returns the first integer greater"
                        + " than or equal to the argument. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Floor (ELM)").at(inception)
                .synonym("ELM Floor")
                .definition("From the ELM specification: The Floor operator returns the first integer less than or"
                        + " equal to the argument. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Truncate (ELM)").at(inception)
                .synonym("ELM Truncate")
                .definition("From the ELM specification: The Truncate operator returns the integer component of its"
                        + " argument. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Abs (ELM)").at(inception)
                .synonym("ELM Abs")
                .definition("From the ELM specification: The Abs operator returns the absolute value of its"
                        + " argument. When taking the absolute value of a quantity, the unit is unchanged. If the"
                        + " argument is null, the result is null. If the result of taking the absolute value of"
                        + " the argument cannot be represented (e.g. Abs(minimum Integer)), the result is null."
                        + " The Abs operator is defined for the Integer, Long, Decimal, and Quantity types.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Negate (ELM)").at(inception)
                .synonym("ELM Negate")
                .definition("From the ELM specification: The Negate operator returns the negative of its argument."
                        + " When negating quantities, the unit is unchanged. If the argument is null, the result"
                        + " is null. If the result of negating the argument cannot be represented (e.g. -(minimum"
                        + " Integer)), the result is null. The Negate operator is defined for the Integer, Long,"
                        + " Decimal, and Quantity types.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Round (ELM)").at(inception)
                .synonym("ELM Round")
                .definition("From the ELM specification: The Round operator returns the nearest integer to its"
                        + " argument. The semantics of round are defined as a traditional round, meaning that a"
                        + " decimal value of 0.5 or higher will round to 1. If the argument is null, the result"
                        + " is null. Precision determines the decimal place at which the rounding will occur. If"
                        + " precision is not specified or null, 0 is assumed.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Round operand")),
                        set.conceptRef("ELM operand position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Round precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM Ln (ELM)").at(inception)
                .synonym("ELM Ln")
                .definition("From the ELM specification: The Ln operator computes the natural logarithm of its"
                        + " argument. If the argument is null, the result is null. If the result of the operation"
                        + " cannot be represented, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Exp (ELM)").at(inception)
                .synonym("ELM Exp")
                .definition("From the ELM specification: The Exp operator returns e raised to the given power. If"
                        + " the argument is null, the result is null. If the result of the operation cannot be"
                        + " represented, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Log (ELM)").at(inception)
                .synonym("ELM Log")
                .definition("From the ELM specification: The Log operator computes the logarithm of its first"
                        + " argument, using the second argument as the base. If either argument is null, the"
                        + " result is null. If the result of the operation cannot be represented, the result is"
                        + " null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Power (ELM)").at(inception)
                .synonym("ELM Power")
                .definition("From the ELM specification: The Power operator raises the first argument to the power"
                        + " given by the second argument. If either argument is null, the result is null. If the"
                        + " result of the operation cannot be represented, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Successor (ELM)").at(inception)
                .synonym("ELM Successor")
                .definition("From the ELM specification: The Successor operator returns the successor of the"
                        + " argument. For example, the successor of 1 is 2. If the argument is already the"
                        + " maximum value for the type, a run-time error is thrown. The Successor operator is"
                        + " defined for the Integer, Long, Decimal, Quantity, Date, DateTime, and Time types. For"
                        + " Integer, Successor is equivalent to adding 1. For Long, Successor is equivalent to"
                        + " adding 1L. For Decimal, Successor is equivalent to adding the minimum precision value"
                        + " for the Decimal type, or 10^-08. For Date, DateTime, and Time values, Successor is"
                        + " equivalent to adding a time-unit quantity for the lowest specified precision of the"
                        + " value. For example, if the DateTime is fully specified, Successor is equivalent to"
                        + " adding 1 millisecond; if the DateTime is specified to the second, Successor is"
                        + " equivalent to adding one second, etc. For Quantity values, Successor is equivalent to"
                        + " adding 1 if the quantity is an integer, and the minimum precision value for the"
                        + " Decimal type if the quantity is a decimal. The units are unchanged. If the argument"
                        + " is null, the result is null. If the result of the operation cannot be represented,"
                        + " the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Predecessor (ELM)").at(inception)
                .synonym("ELM Predecessor")
                .definition("From the ELM specification: The Predecessor operator returns the predecessor of the"
                        + " argument. For example, the predecessor of 2 is 1. If the argument is already the"
                        + " minimum value for the type, a run-time error is thrown. The Predecessor operator is"
                        + " defined for the Integer, Long, Decimal, Quantity, Date, DateTime, and Time types. For"
                        + " Integer, Predecessor is equivalent to subtracting 1. For Long, Predecessor is"
                        + " equivalent to subtracting 1L. For Decimal, Predecessor is equivalent to subtracting"
                        + " the minimum precision value for the Decimal type, or 10^-08. For Date, DateTime, and"
                        + " Time values, Predecessor is equivalent to subtracting a time-unit quantity for the"
                        + " lowest specified precision of the value. For example, if the DateTime is fully"
                        + " specified, Predecessor is equivalent to subtracting 1 millisecond; if the DateTime is"
                        + " specified to the second, Predecessor is equivalent to subtracting one second, etc."
                        + " For Quantity values, the Predecessor is equivalent to subtracting 1 if the quantity"
                        + " is an integer, and the minimum precision value for Decimal if the quantity is a"
                        + " decimal. The units are unchanged. If the argument is null, the result is null. If the"
                        + " result of the operation cannot be represented, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM MinValue (ELM)").at(inception)
                .synonym("ELM MinValue")
                .definition("From the ELM specification: The MinValue operator returns the minimum representable"
                        + " value for the given type. The MinValue operator is defined for the Integer, Long,"
                        + " Decimal, Quantity, Date, DateTime, and Time types. For Integer, MinValue returns the"
                        + " minimum signed 32-bit integer, -(2^31). For Long, MinValue returns the minimum signed"
                        + " 64-bit integer, -(2^63). For Decimal, MinValue returns the minimum representable"
                        + " Decimal value, (-10^28 + 1) / 10^8 (-99999999999999999999.99999999). For Quantity,"
                        + " MinValue returns the minimum representable quantity, i.e. the minimum representable"
                        + " decimal value with a default unit (1). For Date, MinValue returns the minimum"
                        + " representable Date value, Date(1, 1, 1). For DateTime, MinValue returns the minimum"
                        + " representable DateTime value, DateTime(1, 1, 1, 0, 0, 0, 0). For Time, MinValue"
                        + " returns the minimum representable Time value, Time(0, 0, 0, 0). For any other type,"
                        + " attempting to invoke MinValue results in an error. Note that implementations may"
                        + " choose to represent the minimum DateTime value using a constant offset such as UTC.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM MinValue valueType")),
                        set.conceptRef("ELM valueType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM MaxValue (ELM)").at(inception)
                .synonym("ELM MaxValue")
                .definition("From the ELM specification: The MaxValue operator returns the maximum representable"
                        + " value for the given type. The MaxValue operator is defined for the Integer, Long,"
                        + " Decimal, Quantity, Date, DateTime, and Time types. For Integer, MaxValue returns the"
                        + " maximum signed 32-bit integer, 2^31 - 1. For Long, MaxValue returns the maximum"
                        + " signed 64-bit integer, 2^63 - 1. For Decimal, MaxValue returns the maximum"
                        + " representable Decimal value, (10^28 - 1) / 10^8 (99999999999999999999.99999999). For"
                        + " Quantity, MaxValue returns the maximum representable quantity, i.e. the maximum"
                        + " representable decimal value with a default unit (1). For Date, MaxValue returns the"
                        + " maximum representable Date value, Date(9999, 12, 31). For DateTime, MaxValue returns"
                        + " the maximum representable DateTime value, DateTime(9999, 12, 31, 23, 59, 59, 999)."
                        + " For Time, MaxValue returns the maximum representable Time value, Time(23, 59, 59,"
                        + " 999). For any other type, attempting to invoke MaxValue results in an error. Note"
                        + " that implementations may choose to represent the maximum DateTime value using a"
                        + " constant offset such as UTC.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM MaxValue valueType")),
                        set.conceptRef("ELM valueType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM Precision (ELM)").at(inception)
                .synonym("ELM Precision")
                .definition("From the ELM specification: The Precision operator returns the number of digits of"
                        + " precision in the input value. The operator can be used with Decimal, Date, DateTime,"
                        + " and Time values. For Decimal values, the operator returns the number of digits of"
                        + " precision after the decimal place in the input value. Precision(1.58700) // 5 For"
                        + " Date and DateTime values, the operator returns the number of digits of precision in"
                        + " the input value. Precision(@2014) // 4 Precision(@2014-01-05T10:30:00.000) // 17"
                        + " Precision(@T10:30) // 4 Precision(@T10:30:00.000) // 9 If the argument is null, the"
                        + " result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM LowBoundary (ELM)").at(inception)
                .synonym("ELM LowBoundary")
                .definition("From the ELM specification: The LowBoundary operator returns the least possible value"
                        + " of the input to the specified precision. If no precision is specified, the greatest"
                        + " precision of the type of the input value is used (i.e. at least 8 for Decimal, 4 for"
                        + " Date, at least 17 for DateTime, and at least 9 for Time). If the precision is greater"
                        + " than the maximum possible precision of the implementation, the result is null. The"
                        + " operator can be used with Decimal, Date, DateTime, and Time values."
                        + " LowBoundary(1.587, 8) // 1.58700000 LowBoundary(@2014, 6) // @2014-01"
                        + " LowBoundary(@2014-01-01T08, 17) // @2014-01-01T08:00:00.000 LowBoundary(@T10:30, 9)"
                        + " // @T10:30:00.000 If the input value is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM HighBoundary (ELM)").at(inception)
                .synonym("ELM HighBoundary")
                .definition("From the ELM specification: The HighBoundary operator returns the greatest possible"
                        + " value of the input to the specified precision. If no precision is specified, the"
                        + " greatest precision of the type of the input value is used (i.e. at least 8 for"
                        + " Decimal, 4 for Date, at least 17 for DateTime, and at least 9 for Time). If the"
                        + " precision is greater than the maximum possible precision of the implementation, the"
                        + " result is null. The operator can be used with Decimal, Date, DateTime, and Time"
                        + " values. HighBoundary(1.587, 8) // 1.58799999 HighBoundary(@2014, 6) // @2014-12"
                        + " HighBoundary(@2014-01-01T08, 17) // @2014-01-01T08:59:59.999 HighBoundary(@T10:30, 9)"
                        + " // @T10:30:59.999 If the input value is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Concatenate (ELM)").at(inception)
                .synonym("ELM Concatenate")
                .definition("From the ELM specification: The Concatenate operator performs string concatenation of"
                        + " its arguments. If any argument is null, the result is null.")
                .isA(set.conceptRef("ELM NaryExpression (ELM)"));
        set.concept("ELM Combine (ELM)").at(inception)
                .synonym("ELM Combine")
                .definition("From the ELM specification: The Combine operator combines a list of strings,"
                        + " optionally separating each string with the given separator. If either argument is"
                        + " null the result is null. If the source list is empty, the result is an empty string"
                        + " (''). For consistency with aggregate operator behavior, null elements in the input"
                        + " list are ignored.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Combine source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Combine separator")),
                        set.conceptRef("ELM separator position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM Split (ELM)").at(inception)
                .synonym("ELM Split")
                .definition("From the ELM specification: The Split operator splits a string into a list of strings"
                        + " using a separator. If the stringToSplit argument is null, the result is null. If the"
                        + " stringToSplit argument does not contain any appearances of the separator, the result"
                        + " is a list of strings containing one element that is the value of the stringToSplit"
                        + " argument.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Split stringToSplit")),
                        set.conceptRef("ELM stringToSplit position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Split separator")),
                        set.conceptRef("ELM separator position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM SplitOnMatches (ELM)").at(inception)
                .synonym("ELM SplitOnMatches")
                .definition("From the ELM specification: The SplitOnMatches operator splits a string into a list of"
                        + " strings using matches of a regex pattern. The separatorPattern argument is a regex"
                        + " pattern, following the same semantics as the Matches operator. If the stringToSplit"
                        + " argument is null, the result is null. If the stringToSplit argument does not contain"
                        + " any appearances of the separator pattern, the result is a list of strings containing"
                        + " one element that is the input value of the stringToSplit argument.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM SplitOnMatches stringToSplit")),
                        set.conceptRef("ELM stringToSplit position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM SplitOnMatches separatorPattern")),
                        set.conceptRef("ELM separatorPattern position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM Length (ELM)").at(inception)
                .synonym("ELM Length")
                .definition("From the ELM specification: The Length operator returns the length of its argument."
                        + " For strings, the length is the number of characters in the string. For lists, the"
                        + " length is the number of elements in the list. If the argument is null, the result is"
                        + " 0.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Upper (ELM)").at(inception)
                .synonym("ELM Upper")
                .definition("From the ELM specification: The Upper operator returns the given string with all"
                        + " characters converted to their upper case equivalents. Note that the definition of"
                        + " uppercase for a given character is a locale-dependent determination, and is not"
                        + " specified by CQL. Implementations are expected to provide appropriate and consistent"
                        + " handling of locale for their environment. If the argument is null, the result is"
                        + " null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Lower (ELM)").at(inception)
                .synonym("ELM Lower")
                .definition("From the ELM specification: The Lower operator returns the given string with all"
                        + " characters converted to their lowercase equivalents. Note that the definition of"
                        + " lowercase for a given character is a locale-dependent determination, and is not"
                        + " specified by CQL. Implementations are expected to provide appropriate and consistent"
                        + " handling of locale for their environment. If the argument is null, the result is"
                        + " null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Indexer (ELM)").at(inception)
                .synonym("ELM Indexer")
                .definition("From the ELM specification: The Indexer operator returns the indexth element in a"
                        + " string or list. Indexes in strings and lists are defined to be 0-based. If the index"
                        + " is less than 0 or greater than the length of the string or list being indexed, the"
                        + " result is null. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM PositionOf (ELM)").at(inception)
                .synonym("ELM PositionOf")
                .definition("From the ELM specification: The PositionOf operator returns the 0-based index of the"
                        + " beginning given pattern in the given string. If the pattern is not found, the result"
                        + " is -1. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM PositionOf pattern")),
                        set.conceptRef("ELM pattern position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM PositionOf string")),
                        set.conceptRef("ELM string position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM LastPositionOf (ELM)").at(inception)
                .synonym("ELM LastPositionOf")
                .definition("From the ELM specification: The LastPositionOf operator returns the 0-based index of"
                        + " the beginning of the last appearance of the given pattern in the given string. If the"
                        + " pattern is not found, the result is -1. If either argument is null, the result is"
                        + " null.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM LastPositionOf pattern")),
                        set.conceptRef("ELM pattern position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM LastPositionOf string")),
                        set.conceptRef("ELM string position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM Substring (ELM)").at(inception)
                .synonym("ELM Substring")
                .definition("From the ELM specification: The Substring operator returns the string within"
                        + " stringToSub, starting at the 0-based index startIndex, and consisting of length"
                        + " characters. If length is ommitted, the substring returned starts at startIndex and"
                        + " continues to the end of stringToSub. If stringToSub or startIndex is null, or"
                        + " startIndex is out of range, the result is null.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Substring stringToSub")),
                        set.conceptRef("ELM stringToSub position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Substring startIndex")),
                        set.conceptRef("ELM startIndex position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Substring length")),
                        set.conceptRef("ELM length position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM StartsWith (ELM)").at(inception)
                .synonym("ELM StartsWith")
                .definition("From the ELM specification: The StartsWith operator returns true if the given string"
                        + " starts with the given prefix. If the prefix is the empty string, the result is true."
                        + " If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM EndsWith (ELM)").at(inception)
                .synonym("ELM EndsWith")
                .definition("From the ELM specification: The EndsWith operator returns true if the given string"
                        + " ends with the given suffix. If the suffix is the empty string, the result is true. If"
                        + " either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Matches (ELM)").at(inception)
                .synonym("ELM Matches")
                .definition("From the ELM specification: The Matches operator returns true if the given string"
                        + " matches the given regular expression pattern. Regular expressions should function"
                        + " consistently, regardless of any culture- and locale-specific settings in the"
                        + " environment, should be case-sensitive, use single line mode, and allow Unicode"
                        + " characters. If either argument is null, the result is null. Platforms will typically"
                        + " use native regular expression implementations. These are typically fairly similar,"
                        + " but there will always be small differences. As such, CQL does not prescribe a"
                        + " particular dialect, but recommends the use of the [PCRE](http://www.pcre.org)"
                        + " dialect.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM ReplaceMatches (ELM)").at(inception)
                .synonym("ELM ReplaceMatches")
                .definition("From the ELM specification: The ReplaceMatches operator matches the given string using"
                        + " the regular expression pattern, replacing each match with the given substitution. The"
                        + " substitution string may refer to identified match groups in the regular expression."
                        + " Regular expressions should function consistently, regardless of any culture- and"
                        + " locale-specific settings in the environment, should be case-sensitive, use single"
                        + " line mode and allow Unicode characters. If any argument is null, the result is null."
                        + " Platforms will typically use native regular expression implementations. These are"
                        + " typically fairly similar, but there will always be small differences. As such, CQL"
                        + " does not prescribe a particular dialect, but recommends the use of the"
                        + " [PCRE](http://www.pcre.org) dialect.")
                .isA(set.conceptRef("ELM TernaryExpression (ELM)"));
        set.concept("ELM DurationBetween (ELM)").at(inception)
                .synonym("ELM DurationBetween")
                .definition("From the ELM specification: The DurationBetween operator returns the number of whole"
                        + " calendar periods for the specified precision between the first and second arguments."
                        + " If the first argument is after the second argument, the result is negative. The"
                        + " result of this operation is always an integer; any fractional periods are dropped."
                        + " For Date values, precision must be one of Year, Month, Week, or Day. For Time values,"
                        + " precision must be one of Hour, Minute, Second, or Millisecond. For calculations"
                        + " involving weeks, the duration of a week is equivalent to 7 days. When calculating"
                        + " duration between DateTime values with different timezone offsets, implementations"
                        + " should normalize to the timezone offset of the evaluation request timestamp, but only"
                        + " when the comparison precision is hours, minutes, seconds, or milliseconds. If either"
                        + " argument is null, the result is null. Note that this operator can be implemented"
                        + " using Uncertainty as described in the CQL specification, Chapter 5, Precision-Based"
                        + " Timing.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DurationBetween precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM DifferenceBetween (ELM)").at(inception)
                .synonym("ELM DifferenceBetween")
                .definition("From the ELM specification: The DifferenceBetween operator returns the number of"
                        + " boundaries crossed for the specified precision between the first and second"
                        + " arguments. If the first argument is after the second argument, the result is"
                        + " negative. Because this operation is only counting boundaries crossed, the result is"
                        + " always an integer. For Date values, precision must be one of Year, Month, Week, or"
                        + " Day. For Time values, precision must be one of Hour, Minute, Second, or Millisecond."
                        + " For calculations involving weeks, Sunday is considered to be the first day of the"
                        + " week for the purposes of determining boundaries. When calculating difference between"
                        + " DateTime values with different timezone offsets, implementations should normalize to"
                        + " the timezone offset of the evaluation request timestamp, but only when the comparison"
                        + " precision is hours, minutes, seconds, or milliseconds. If either argument is null,"
                        + " the result is null. Note that this operator can be implemented using Uncertainty as"
                        + " described in the CQL specification, Chapter 5, Precision-Based Timing.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DifferenceBetween precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM DateFrom (ELM)").at(inception)
                .synonym("ELM DateFrom")
                .definition("From the ELM specification: The DateFrom operator returns the date (with no time"
                        + " components specified) of the argument. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM TimeFrom (ELM)").at(inception)
                .synonym("ELM TimeFrom")
                .definition("From the ELM specification: The TimeFrom operator returns the Time of the argument."
                        + " When extracting the time from a DateTime value, implementations should normalize to"
                        + " the timezone offset of the evaluation request timestamp. If the argument is null, the"
                        + " result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM TimezoneFrom (ELM)").at(inception)
                .synonym("ELM TimezoneFrom")
                .definition("From the ELM specification: DEPRECATED (as of 1.4): The TimezoneFrom operator returns"
                        + " the timezone offset of the argument. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM TimezoneOffsetFrom (ELM)").at(inception)
                .synonym("ELM TimezoneOffsetFrom")
                .definition("From the ELM specification: The TimezoneOffsetFrom operator returns the timezone"
                        + " offset of the argument. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM DateTimeComponentFrom (ELM)").at(inception)
                .synonym("ELM DateTimeComponentFrom")
                .definition("From the ELM specification: The DateTimeComponentFrom operator returns the specified"
                        + " component of the argument. If the argument is null, the result is null. The precision"
                        + " must be one of Year, Month, Day, Hour, Minute, Second, or Millisecond. Note"
                        + " specifically that since there is variability how weeks are counted, Week precision is"
                        + " not supported, and will result in an error.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateTimeComponentFrom precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM TimeOfDay (ELM)").at(inception)
                .synonym("ELM TimeOfDay")
                .definition("From the ELM specification: The TimeOfDay operator returns the time-of-day of the"
                        + " start timestamp associated with the evaluation request. See the Now operator for more"
                        + " information on the rationale for defining the TimeOfDay operator in this way.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"));
        set.concept("ELM Today (ELM)").at(inception)
                .synonym("ELM Today")
                .definition("From the ELM specification: The Today operator returns the date (with no time"
                        + " component) of the start timestamp associated with the evaluation request. See the Now"
                        + " operator for more information on the rationale for defining the Today operator in"
                        + " this way.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"));
        set.concept("ELM Now (ELM)").at(inception)
                .synonym("ELM Now")
                .definition("From the ELM specification: The Now operator returns the date and time of the start"
                        + " timestamp associated with the evaluation request. Now is defined in this way for two"
                        + " reasons: 1) The operation will always return the same value within any given"
                        + " evaluation, ensuring that the result of an expression containing Now will always"
                        + " return the same result. 2) The operation will return the timestamp associated with"
                        + " the evaluation request, allowing the evaluation to be performed with the same"
                        + " timezone offset information as the data delivered with the evaluation request.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"));
        set.concept("ELM Date (ELM)").at(inception)
                .synonym("ELM Date")
                .definition("From the ELM specification: The Date operator constructs a date value from the given"
                        + " components. At least one component must be specified, and no component may be"
                        + " specified at a precision below an unspecified precision. For example, month may be"
                        + " null, but if it is, day must be null as well.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Date year")),
                        set.conceptRef("ELM year position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Date month")),
                        set.conceptRef("ELM month position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Date day")),
                        set.conceptRef("ELM day position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM DateTime (ELM)").at(inception)
                .synonym("ELM DateTime")
                .definition("From the ELM specification: The DateTime operator constructs a DateTime value from the"
                        + " given components. At least one component other than timezoneOffset must be specified,"
                        + " and no component may be specified at a precision below an unspecified precision. For"
                        + " example, hour may be null, but if it is, minute, second, and millisecond must all be"
                        + " null as well. If all the arguments are null, the result is null, as opposed to a"
                        + " DateTime with no components specified. Although the milliseconds are specified with a"
                        + " separate component, seconds and milliseconds are combined and represented as a"
                        + " Decimal for the purposes of comparison. If timezoneOffset is not specified, it is"
                        + " defaulted to the timezone offset of the evaluation request.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateTime year")),
                        set.conceptRef("ELM year position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateTime month")),
                        set.conceptRef("ELM month position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateTime day")),
                        set.conceptRef("ELM day position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateTime hour")),
                        set.conceptRef("ELM hour position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateTime minute")),
                        set.conceptRef("ELM minute position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateTime second")),
                        set.conceptRef("ELM second position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateTime millisecond")),
                        set.conceptRef("ELM millisecond position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateTime timezoneOffset")),
                        set.conceptRef("ELM timezoneOffset position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM Time (ELM)").at(inception)
                .synonym("ELM Time")
                .definition("From the ELM specification: The Time operator constructs a time value from the given"
                        + " components. At least one component must be specified, and no component may be"
                        + " specified at a precision below an unspecified precision. For example, minute may be"
                        + " null, but if it is, second, and millisecond must all be null as well. Although the"
                        + " milliseconds are specified with a separate component, seconds and milliseconds are"
                        + " combined and represented as a [.id]#Decimal# for the purposes of comparison.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Time hour")),
                        set.conceptRef("ELM hour position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Time minute")),
                        set.conceptRef("ELM minute position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Time second")),
                        set.conceptRef("ELM second position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Time millisecond")),
                        set.conceptRef("ELM millisecond position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM SameAs (ELM)").at(inception)
                .synonym("ELM SameAs")
                .definition("From the ELM specification: The SameAs operator is defined for Date, DateTime, and"
                        + " Time values, as well as intervals. For the Interval overloads, the SameAs operator"
                        + " returns true if the intervals start and end at the same value, using the semantics"
                        + " described in the Start and End operator to determine interval boundaries. The SameAs"
                        + " operator compares two Date, Time, or DateTime values to the specified precision for"
                        + " equality. Individual component values are compared starting from the year component"
                        + " down to the specified precision. If all values are specified and have the same value"
                        + " for each component, then the result is true. If a compared component is specified in"
                        + " both dates, but the values are not the same, then the result is false. Otherwise the"
                        + " result is null, as there is not enough information to make a determination. If no"
                        + " precision is specified, the comparison is performed beginning with years (or hours"
                        + " for time values) and proceeding to the finest precision specified in either input."
                        + " For Date values, precision must be one of year, month, or day. For DateTime values,"
                        + " precision must be one of year, month, day, hour, minute, second, or millisecond. For"
                        + " Time values, precision must be one of hour, minute, second, or millisecond. Note"
                        + " specifically that due to variability in the way week numbers are determined,"
                        + " comparisons involving weeks are not supported. When comparing DateTime values with"
                        + " different timezone offsets, implementations should normalize to the timezone offset"
                        + " of the evaluation request timestamp, but only when the comparison precision is hours,"
                        + " minutes, seconds, or milliseconds. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM SameAs precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM SameOrBefore (ELM)").at(inception)
                .synonym("ELM SameOrBefore")
                .definition("From the ELM specification: The SameOrBefore operator is defined for Date, DateTime,"
                        + " and Time values, as well as intervals. For the Interval overload, the SameOrBefore"
                        + " operator returns true if the first interval ends on or before the second one starts."
                        + " In other words, if the ending point of the first interval is less than or equal to"
                        + " the starting point of the second interval, using the semantics described in the Start"
                        + " and End operators to determine interval boundaries. The SameOrBefore operator"
                        + " compares two Date, DateTime, or Time values to the specified precision to determine"
                        + " whether the first argument is the same or before the second argument. The comparison"
                        + " is performed by considering each precision in order, beginning with years (or hours"
                        + " for time values). If the values are the same, comparison proceeds to the next"
                        + " precision; if the first value is less than the second, the result is true; if the"
                        + " first value is greater than the second, the result is false; if either input has no"
                        + " value for the precision, the comparison stops and the result is null; if the"
                        + " specified precision has been reached, the comparison stops and the result is true. If"
                        + " no precision is specified, the comparison is performed beginning with years (or hours"
                        + " for time values) and proceeding to the finest precision specified in either input."
                        + " For Date values, precision must be one of year, month, or day. For DateTime values,"
                        + " precision must be one of year, month, day, hour, minute, second, or millisecond. For"
                        + " Time values, precision must be one of hour, minute, second, or millisecond. Note"
                        + " specifically that due to variability in the way week numbers are determined,"
                        + " comparisons involving weeks are not supported. When comparing DateTime values with"
                        + " different timezone offsets, implementations should normalize to the timezone offset"
                        + " of the evaluation request timestamp, but only when the comparison precision is hours,"
                        + " minutes, seconds, or milliseconds. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM SameOrBefore precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM SameOrAfter (ELM)").at(inception)
                .synonym("ELM SameOrAfter")
                .definition("From the ELM specification: The SameOrAfter operator is defined for Date, DateTime,"
                        + " and Time values, as well as intervals. For the Interval overload, the SameOrAfter"
                        + " operator returns true if the first interval starts on or after the second one ends."
                        + " In other words, if the starting point of the first interval is greater than or equal"
                        + " to the ending point of the second interval, using the semantics described in the"
                        + " Start and End operators to determine interval boundaries. For the Date, DateTime, and"
                        + " Time overloads, this operator compares two Date, DateTime, or Time values to the"
                        + " specified precision to determine whether the first argument is the same or after the"
                        + " second argument. The comparison is performed by considering each precision in order,"
                        + " beginning with years (or hours for time values). If the values are the same,"
                        + " comparison proceeds to the next precision; if the first value is greater than the"
                        + " second, the result is true; if the first value is less than the second, the result is"
                        + " false; if either input has no value for the precision, the comparison stops and the"
                        + " result is null; if the specified precision has been reached, the comparison stops and"
                        + " the result is true. If no precision is specified, the comparison is performed"
                        + " beginning with years (or hours for time values) and proceeding to the finest"
                        + " precision specified in either input. For Date values, precision must be one of year,"
                        + " month, or day. For DateTime values, precision must be one of year, month, day, hour,"
                        + " minute, second, or millisecond. For Time values, precision must be one of hour,"
                        + " minute, second, or millisecond. Note specifically that due to variability in the way"
                        + " week numbers are determined, comparisons involving weeks are not supported. When"
                        + " comparing DateTime values with different timezone offsets, implementations should"
                        + " normalize to the timezone offset of the evaluation request timestamp, but only when"
                        + " the comparison precision is hours, minutes, seconds, or milliseconds. If either"
                        + " argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM SameOrAfter precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM PointFrom (ELM)").at(inception)
                .synonym("ELM PointFrom")
                .definition("From the ELM specification: The PointFrom expression extracts the single point from"
                        + " the source interval. The source interval must be a unit interval (meaning an interval"
                        + " with the same starting and ending boundary), otherwise, a run-time error is thrown."
                        + " If the source interval is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Width (ELM)").at(inception)
                .synonym("ELM Width")
                .definition("From the ELM specification: The Width operator returns the width of an interval. The"
                        + " result of this operator is equivalent to invoking: End(i) - Start(i) Note that this"
                        + " operator is not defined for intervals of type Date, DateTime, and Time. If the"
                        + " argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Size (ELM)").at(inception)
                .synonym("ELM Size")
                .definition("From the ELM specification: The Size operator returns the size of an interval. The"
                        + " result of this operator is equivalent to invoking: End(i) - Start(i) + point-size,"
                        + " where the point-size for the point type of the interval is determined by:"
                        + " Successor(Minimum_T) - Minimum_T. Note that this operator is not defined for"
                        + " intervals of type Date, DateTime, and Time. If the argument is null, the result is"
                        + " null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Start (ELM)").at(inception)
                .synonym("ELM Start")
                .definition("From the ELM specification: The Start operator returns the starting point of an"
                        + " interval. If the low boundary of the interval is open, this operator returns the"
                        + " Successor of the low value of the interval. Note that if the low value of the"
                        + " interval is null, the result is null. If the low boundary of the interval is closed"
                        + " and the low value of the interval is not null, this operator returns the low value of"
                        + " the interval. Otherwise, the result is the minimum value of the point type of the"
                        + " interval. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM End (ELM)").at(inception)
                .synonym("ELM End")
                .definition("From the ELM specification: The End operator returns the ending point of an interval."
                        + " If the high boundary of the interval is open, this operator returns the Predecessor"
                        + " of the high value of the interval. Note that if the high value of the interval is"
                        + " null, the result is null. If the high boundary of the interval is closed and the high"
                        + " value of the interval is not null, this operator returns the high value of the"
                        + " interval. Otherwise, the result is the maximum value of the point type of the"
                        + " interval. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Contains (ELM)").at(inception)
                .synonym("ELM Contains")
                .definition("From the ELM specification: The Contains operator returns true if the first operand"
                        + " contains the second. There are two overloads of this operator: List, T : The type of"
                        + " T must be the same as the element type of the list. Interval, T : The type of T must"
                        + " be the same as the point type of the interval. For the List, T overload, this"
                        + " operator returns true if the given element is in the list, using equality semantics,"
                        + " with the exception that null elements are considered equal. If the first argument is"
                        + " null, the result is false. If the second argument is null, the result is true if the"
                        + " list contains any null elements, and false otherwise. For the Interval, T overload,"
                        + " this operator returns true if the given point is equal to the starting or ending"
                        + " point of the interval, or greater than the starting point and less than the ending"
                        + " point. For open interval boundaries, exclusive comparison operators are used. For"
                        + " closed interval boundaries, if the interval boundary is null, the result of the"
                        + " boundary comparison is considered true. If precision is specified and the point type"
                        + " is a Date, DateTime, or Time type, comparisons used in the operation are performed at"
                        + " the specified precision. If the first argument is null, the result is false. If the"
                        + " second argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Contains precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ProperContains (ELM)").at(inception)
                .synonym("ELM ProperContains")
                .definition("From the ELM specification: The ProperContains operator returns true if the first"
                        + " operand properly contains the second. There are two overloads of this operator: List,"
                        + " T: The type of T must be the same as the element type of the list. Interval, T : The"
                        + " type of T must be the same as the point type of the interval. For the List, T"
                        + " overload, this operator returns true if the given element is in the list, and it is"
                        + " not the only element in the list, using equality semantics, with the exception that"
                        + " null elements are considered equal. If the first argument is null, the result is"
                        + " false. If the second argument is null, the result is true if the list contains any"
                        + " null elements and at least one other element, and false otherwise. For the Interval,"
                        + " T overload, this operator returns true if the given point is greater than the"
                        + " starting point of the interval, and less than the ending point of the interval, as"
                        + " determined by the Start and End operators. If precision is specified and the point"
                        + " type is a Date, DateTime, or Time type, comparisons used in the operation are"
                        + " performed at the specified precision. If the first argument is null, the result is"
                        + " false. If the second argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ProperContains precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM In (ELM)").at(inception)
                .synonym("ELM In")
                .definition("From the ELM specification: The In operator tests for membership in an interval or"
                        + " list. There are two overloads of this operator: T, List : The type of T must be the"
                        + " same as the element type of the list. T, Interval : The type of T must be the same as"
                        + " the point type of the interval. For the T, List overload, this operator returns true"
                        + " if the given element is in the given list, using equality semantics, with the"
                        + " exception that null elements are considered equal. If the first argument is null, the"
                        + " result is true if the list contains any null elements, and false otherwise. If the"
                        + " second argument is null the result is false. For the T, Interval overload, this"
                        + " operator returns true if the given point is equal to the starting or ending point of"
                        + " the interval, or greater than the starting point and less than the ending point. For"
                        + " open interval boundaries, exclusive comparison operators are used. For closed"
                        + " interval boundaries, if the interval boundary is null, the result of the boundary"
                        + " comparison is considered true. If precision is specified and the point type is a"
                        + " Date, DateTime, or Time type, comparisons used in the operation are performed at the"
                        + " specified precision. If the first argument is null, the result is null. If the second"
                        + " argument is null, the result is false.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM In precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ProperIn (ELM)").at(inception)
                .synonym("ELM ProperIn")
                .definition("From the ELM specification: The ProperIn operator tests for proper membership in an"
                        + " interval or list. There are two overloads of this operator: T, List : The type of T"
                        + " must be the same as the element type of the list. T, Interval : The type of T must be"
                        + " the same as the point type of the interval. For the T, List overload, this operator"
                        + " returns if the given element is in the given list, and it is not the only element in"
                        + " the list, using equality semantics, with the exception that null elements are"
                        + " considered equal. If the first argument is null, the result is true if the list"
                        + " contains any null elements, and at least one other element, and false otherwise. If"
                        + " the second argument is null, the result is false. For the T, Interval overload, this"
                        + " operator returns true if the given point is greater than the starting point, and less"
                        + " than the ending point of the interval, as determined by the Start and End operators."
                        + " If precision is specified and the point type is a Date, DateTime, or Time type,"
                        + " comparisons used in the operation are performed at the specified precision. If the"
                        + " first argument is null, the result is null. If the second argument is null the result"
                        + " is false.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ProperIn precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Includes (ELM)").at(inception)
                .synonym("ELM Includes")
                .definition("From the ELM specification: The Includes operator returns true if the first operand"
                        + " completely includes the second. There are two overloads of this operator: List, List"
                        + " : The element type of both lists must be the same. Interval, Interval : The point"
                        + " type of both intervals must be the same. For the List, List overload, this operator"
                        + " returns true if the first operand includes every element of the second operand, using"
                        + " equality semantics, with the exception that null elements are considered equal. For"
                        + " the Interval, Interval overload, this operator returns true if starting point of the"
                        + " first interval is less than or equal to the starting point of the second interval,"
                        + " and the ending point of the first interval is greater than or equal to the ending"
                        + " point of the second interval. If precision is specified and the point type is a Date,"
                        + " DateTime, or Time type, comparisons used in the operation are performed at the"
                        + " specified precision. This operator uses the semantics described in the Start and End"
                        + " operators to determine interval boundaries. If either argument is null, the result is"
                        + " null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Includes precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM IncludedIn (ELM)").at(inception)
                .synonym("ELM IncludedIn")
                .definition("From the ELM specification: The IncludedIn operator returns true if the first operand"
                        + " is completely included in the second. There are two overloads of this operator: List,"
                        + " List : The element type of both lists must be the same. Interval, Interval : The"
                        + " point type of both intervals must be the same. For the List, List overload, this"
                        + " operator returns true if every element in the first list is included in the second"
                        + " list, using equality semantics, with the exception that null elements are considered"
                        + " equal. For the Interval, Interval overload, this operator returns true if the"
                        + " starting point of the first interval is greater than or equal to the starting point"
                        + " of the second interval, and the ending point of the first interval is less than or"
                        + " equal to the ending point of the second interval. If precision is specified and the"
                        + " point type is a Date, DateTime, or Time type, comparisons used in the operation are"
                        + " performed at the specified precision. This operator uses the semantics described in"
                        + " the Start and End operators to determine interval boundaries. If either argument is"
                        + " null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludedIn precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ProperIncludes (ELM)").at(inception)
                .synonym("ELM ProperIncludes")
                .definition("From the ELM specification: The ProperIncludes operator returns true if the first"
                        + " operand includes the second, and is strictly larger. There are two overloads of this"
                        + " operator: List, List : The element type of both lists must be the same. Interval,"
                        + " Interval : The point type of both intervals must be the same. For the List, List"
                        + " overload, this operator returns true if the first list is strictly larger, and the"
                        + " first list includes every element of the second list, using equality semantics, with"
                        + " the exception that null elements are considered equal. For the Interval, Interval"
                        + " overload, this operator returns true if the first interval includes the second"
                        + " interval, and the intervals are not equal. If precision is specified and the point"
                        + " type is a Date, DateTime, or Time type, comparisons used in the operation are"
                        + " performed at the specified precision. This operator uses the semantics described in"
                        + " the Start and End operators to determine interval boundaries. If either argument is"
                        + " null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ProperIncludes precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ProperIncludedIn (ELM)").at(inception)
                .synonym("ELM ProperIncludedIn")
                .definition("From the ELM specification: The ProperIncludedIn operator returns true if the first"
                        + " operand is included in the second, and is strictly smaller. There are two overloads"
                        + " of this operator: List, List : The element type of both lists must be the same."
                        + " Interval, Interval : The point type of both intervals must be the same. For the List,"
                        + " List overload, this operator returns true if the first list is strictly smaller, and"
                        + " every element of the first list is included in the second list, using equality"
                        + " semantics, with the exception that null elements are considered equal. For the"
                        + " Interval, Interval overload, this operator returns true if the first interval is"
                        + " included in the second interval, and the intervals are not equal. If precision is"
                        + " specified and the point type is a Date, DateTime, or Time type, comparisons used in"
                        + " the operation are performed at the specified precision. This operator uses the"
                        + " semantics described in the Start and End operators to determine interval boundaries."
                        + " If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ProperIncludedIn precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Before (ELM)").at(inception)
                .synonym("ELM Before")
                .definition("From the ELM specification: The Before operator is defined for Intervals, as well as"
                        + " Date, DateTime, and Time values. For the Interval overload, the Before operator"
                        + " returns true if the first interval ends before the second one starts. In other words,"
                        + " if the ending point of the first interval is less than the starting point of the"
                        + " second interval, using the semantics described in the Start and End operators to"
                        + " determine interval boundaries. For the Date, DateTime, and Time overloads, the"
                        + " comparison is performed by considering each precision in order, beginning with years"
                        + " (or hours for time values). If the values are the same, comparison proceeds to the"
                        + " next precision; if the first value is less than the second, the result is true; if"
                        + " the first value is greater than the second, the result is false; if either input has"
                        + " no value for the precision, the comparison stops and the result is null; if the"
                        + " specified precision has been reached, the comparison stops and the result is false."
                        + " If no precision is specified, the comparison is performed beginning with years (or"
                        + " hours for time values) and proceeding to the finest precision specified in either"
                        + " input. For Date values, precision must be one of year, month, or day. For DateTime"
                        + " values, precision must be one of year, month, day, hour, minute, second, or"
                        + " millisecond. For Time values, precision must be one of hour, minute, second, or"
                        + " millisecond. Note specifically that due to variability in the way week numbers are"
                        + " determined, comparisons involving weeks are not supported. When comparing DateTime"
                        + " values with different timezone offsets, implementations should normalize to the"
                        + " timezone offset of the evaluation request timestamp, but only when the comparison"
                        + " precision is hours, minutes, seconds, or milliseconds. If either argument is null,"
                        + " the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Before precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM After (ELM)").at(inception)
                .synonym("ELM After")
                .definition("From the ELM specification: The After operator is defined for Intervals, as well as"
                        + " Date, DateTime, and Time values. For the Interval overload, the After operator"
                        + " returns true if the first interval starts after the second one ends. In other words,"
                        + " if the starting point of the first interval is greater than the ending point of the"
                        + " second interval using the semantics described in the Start and End operators to"
                        + " determine interval boundaries. For the Date, DateTime, and Time overloads, the After"
                        + " operator returns true if the first datetime is after the second datetime at the"
                        + " specified level of precision. The comparison is performed by considering each"
                        + " precision in order, beginning with years (or hours for time values). If the values"
                        + " are the same, comparison proceeds to the next precision; if the first value is"
                        + " greater than the second, the result is true; if the first value is less than the"
                        + " second, the result is false; if either input has no value for the precision, the"
                        + " comparison stops and the result is null; if the specified precision has been reached,"
                        + " the comparison stops and the result is false. If no precision is specified, the"
                        + " comparison is performed beginning with years (or hours for time values) and"
                        + " proceeding to the finest precision specified in either input. For Date values,"
                        + " precision must be one of year, month, or day. For DateTime values, precision must be"
                        + " one of year, month, day, hour, minute, second, or millisecond. For Time values,"
                        + " precision must be one of hour, minute, second, or millisecond. Note specifically that"
                        + " due to variability in the way week numbers are determined, comparisons involving"
                        + " weeks are not supported. When comparing DateTime values with different timezone"
                        + " offsets, implementations should normalize to the timezone offset of the evaluation"
                        + " request timestamp, but only when the comparison precision is hours, minutes, seconds,"
                        + " or milliseconds. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM After precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Meets (ELM)").at(inception)
                .synonym("ELM Meets")
                .definition("From the ELM specification: The Meets operator returns true if the first interval ends"
                        + " immediately before the second interval starts, or if the first interval starts"
                        + " immediately after the second interval ends. In other words, if the ending point of"
                        + " the first interval is equal to the predecessor of the starting point of the second,"
                        + " or if the starting point of the first interval is equal to the successor of the"
                        + " ending point of the second. This operator uses the semantics described in the Start"
                        + " and End operators to determine interval boundaries. If precision is specified and the"
                        + " point type is a Date, DateTime, or Time type, comparisons used in the operation are"
                        + " performed at the specified precision. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Meets precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM MeetsBefore (ELM)").at(inception)
                .synonym("ELM MeetsBefore")
                .definition("From the ELM specification: The MeetsBefore operator returns true if the first"
                        + " interval ends immediately before the second interval starts. In other words, if the"
                        + " ending point of the first interval is equal to the predecessor of the starting point"
                        + " of the second. This operator uses the semantics described in the Start and End"
                        + " operators to determine interval boundaries. If precision is specified and the point"
                        + " type is a Date, DateTime, or Time type, comparisons used in the operation are"
                        + " performed at the specified precision. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM MeetsBefore precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM MeetsAfter (ELM)").at(inception)
                .synonym("ELM MeetsAfter")
                .definition("From the ELM specification: The MeetsAfter operator returns true if the first interval"
                        + " starts immediately after the second interval ends. In other words, if the starting"
                        + " point of the first interval is equal to the successor of the ending point of the"
                        + " second. This operator uses the semantics described in the Start and End operators to"
                        + " determine interval boundaries. If precision is specified and the point type is a"
                        + " Date, DateTime, or Time type, comparisons used in the operation are performed at the"
                        + " specified precision. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM MeetsAfter precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Overlaps (ELM)").at(inception)
                .synonym("ELM Overlaps")
                .definition("From the ELM specification: The Overlaps operator returns true if the first interval"
                        + " overlaps the second. In other words, if the starting or ending point of either"
                        + " interval is in the other, or if the ending point of the first interval is greater"
                        + " than or equal to the starting point of the second interval, and the starting point of"
                        + " the first interval is less than or equal to the ending point of the second interval."
                        + " This operator uses the semantics described in the Start and End operators to"
                        + " determine interval boundaries. If precision is specified and the point type is a"
                        + " Date, DateTime, or Time type, comparisons used in the operation are performed at the"
                        + " specified precision. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Overlaps precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM OverlapsBefore (ELM)").at(inception)
                .synonym("ELM OverlapsBefore")
                .definition("From the ELM specification: The OverlapsBefore operator returns true if the first"
                        + " interval starts before and overlaps the second. In other words, if the first interval"
                        + " starts before and ends on or after the start of the second interval. This operator"
                        + " uses the semantics described in the Start and End operators to determine interval"
                        + " boundaries. If precision is specified and the point type is a Date, DateTime, or Time"
                        + " type, comparisons used in the operation are performed at the specified precision. If"
                        + " either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OverlapsBefore precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM OverlapsAfter (ELM)").at(inception)
                .synonym("ELM OverlapsAfter")
                .definition("From the ELM specification: The OverlapsAfter operator returns true if the first"
                        + " interval overlaps and ends after the second. In other words, if the first interval"
                        + " ends after and starts on or before the end of the second interval. This operator uses"
                        + " the semantics described in the Start and End operators to determine interval"
                        + " boundaries. If precision is specified and the point type is a Date, DateTime, or Time"
                        + " type, comparisons used in the operation are performed at the specified precision. If"
                        + " either argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OverlapsAfter precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Starts (ELM)").at(inception)
                .synonym("ELM Starts")
                .definition("From the ELM specification: The Starts operator returns true if the first interval"
                        + " starts the second. In other words, if the starting point of the first is equal to the"
                        + " starting point of the second interval and the ending point of the first interval is"
                        + " less than or equal to the ending point of the second interval. This operator uses the"
                        + " semantics described in the Start and End operators to determine interval boundaries."
                        + " If precision is specified and the point type is a Date, DateTime, or Time type,"
                        + " comparisons used in the operation are performed at the specified precision. If either"
                        + " argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Starts precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Ends (ELM)").at(inception)
                .synonym("ELM Ends")
                .definition("From the ELM specification: The Ends operator returns true if the first interval ends"
                        + " the second. In other words, if the starting point of the first interval is greater"
                        + " than or equal to the starting point of the second, and the ending point of the first"
                        + " interval is equal to the ending point of the second. This operator uses the semantics"
                        + " described in the Start and End operators to determine interval boundaries. If"
                        + " precision is specified and the point type is a Date, DateTime, or Time type,"
                        + " comparisons used in the operation are performed at the specified precision. If either"
                        + " argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Ends precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Collapse (ELM)").at(inception)
                .synonym("ELM Collapse")
                .definition("From the ELM specification: The Collapse operator returns the unique set of intervals"
                        + " that completely covers the ranges present in the given list of intervals. In other"
                        + " words, adjacent intervals within a sorted list are merged if they either overlap or"
                        + " meet. The operation is performed by combining successive intervals in the input that"
                        + " either overlap or meet, using the semantics defined for the Overlaps and Meets"
                        + " operators. Note that because those operators are themselves defined in terms of"
                        + " interval successor and predecessor operators, sets of Date-, DateTime-, or Time-based"
                        + " intervals that are only defined to a particular precision will calculate meets and"
                        + " overlaps at that precision. For example, a list of DateTime-based intervals where the"
                        + " boundaries are all specified to the hour will collapse at the hour precision, unless"
                        + " the collapse precision is overridden with the per argument. The per argument"
                        + " determines the precision at which the collapse is computed and must be a"
                        + " quantity-valued expression compatible with the interval point type. For numeric"
                        + " intervals, this means a quantity with the default unit '1' (not to be confused with"
                        + " the quantity value, which may be any valid positive decimal). For Date-, DateTime-,"
                        + " and Time-valued intervals, this means a quantity with a temporal unit (e.g., 'year',"
                        + " 'month', etc). Conceptually, the per argument to the collapse operator partitions the"
                        + " value-space for the operation into units of size 'per', and the intervals will be"
                        + " collapsed aligning with those partitions. Note that the 'per' partitions start from"
                        + " the starting boundary of the first input interval, ordered. If the per argument is"
                        + " null, a per value will be constructed based on the coarsest precision of the"
                        + " boundaries of the intervals in the input set. For example, a list of DateTime-based"
                        + " intervals where the boundaries are a mixture of hours and minutes will collapse at"
                        + " the hour precision. If the list of intervals is empty, the result is empty. If the"
                        + " list of intervals contains a single interval, the result is a list with that"
                        + " interval. If the list of intervals contains nulls, they will be excluded from the"
                        + " resulting list. If the source argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Expand (ELM)").at(inception)
                .synonym("ELM Expand")
                .definition("From the ELM specification: The Expand operator returns the set of intervals of size"
                        + " per for all the ranges present in the given list of intervals, or the list of points"
                        + " covering the range of the given interval, if invoked on a single interval. The per"
                        + " argument determines the size of the resulting intervals and must be a quantity-valued"
                        + " expression compatible with the interval point type. For numeric intervals, this means"
                        + " a quantity with the default unit '1' (not to be confused with the quantity value,"
                        + " which may be any valid positive decimal). For Date-, DateTime-, and Time-valued"
                        + " intervals, this means a quantity with a temporal unit (e.g., 'year', 'month', etc)."
                        + " Conceptually, the per argument to the expand operator partitions the value-space for"
                        + " the operation into units of size 'per', and the intervals will be expanded aligning"
                        + " with those partitions. Note that the 'per' partitions start from the starting"
                        + " boundary of the first input interval, ordered. If the per argument is null, a per"
                        + " value will be constructed based on the coarsest precision of the boundaries of the"
                        + " intervals in the input set. For example, a list of DateTime-based intervals where the"
                        + " boundaries are a mixture of hours and minutes will expand at the hour precision. Note"
                        + " that if the values in the intervals are more precise than the per quantity, the more"
                        + " precise values will be truncated to the precision specified by the per quantity. If"
                        + " the input argument is an interval, rather than a list of intervals, the result is a"
                        + " list of points, rather than a list of intervals. In this case, the calculation is"
                        + " performed the same way, but the starting point of each resulting interval is"
                        + " returned, rather than the interval. If the list of intervals is empty, the result is"
                        + " empty. If the list of intervals contains nulls, they will be excluded from the"
                        + " resulting list. If the source argument is null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Union (ELM)").at(inception)
                .synonym("ELM Union")
                .definition("From the ELM specification: The Union operator returns the union of its arguments."
                        + " This operator has two overloads: List Interval For the list overload, this operator"
                        + " returns a list with all unique elements from both arguments, using equality"
                        + " semantics, with the exception that null elements are considered equal. For the"
                        + " interval overload, this operator returns the interval that starts at the earliest"
                        + " starting point in either argument, and ends at the latest starting point in either"
                        + " argument. If the arguments do not overlap or meet, this operator returns null. If"
                        + " either argument is null, the operation is performed as though the argument was an"
                        + " empty list.")
                .isA(set.conceptRef("ELM NaryExpression (ELM)"));
        set.concept("ELM Intersect (ELM)").at(inception)
                .synonym("ELM Intersect")
                .definition("From the ELM specification: The Intersect operator returns the intersection of its"
                        + " arguments. This operator has two overloads: List Interval For the list overload, this"
                        + " operator returns a list with the elements that appear in both lists, using equality"
                        + " semantics with the exception that null elements are considered equal for the purposes"
                        + " of the intersection. The operator is defined with set semantics, meaning that each"
                        + " element will appear in the result at most once, and that there is no expectation that"
                        + " the order of the inputs will be preserved in the results. For the interval overload,"
                        + " this operator returns the interval that defines the overlapping portion of both"
                        + " arguments. If the arguments do not overlap, this operator returns null. If either"
                        + " argument is null, the result is null.")
                .isA(set.conceptRef("ELM NaryExpression (ELM)"));
        set.concept("ELM Except (ELM)").at(inception)
                .synonym("ELM Except")
                .definition("From the ELM specification: The Except operator returns the set difference of the two"
                        + " arguments. This operator has two overloads: List, List Interval, Interval For the"
                        + " list overload, this operator returns a list with the elements that appear in the"
                        + " first operand, that do not appear in the second operand, using equality semantics,"
                        + " with the exception that null elements are considered equal for the purposes of"
                        + " determining the result. The operator is defined with set semantics, meaning that each"
                        + " element will appear in the result at most once, and that there is no expectation that"
                        + " the order of the inputs will be preserved in the results. For the interval overload,"
                        + " this operator returns the portion of the first interval that does not overlap with"
                        + " the second. If the second argument is properly contained within the first and does"
                        + " not start or end it, this operator returns null. If the first argument is null, the"
                        + " result is null. If the second argument is null, the operation is performed as though"
                        + " the second argument was an empty list.")
                .isA(set.conceptRef("ELM NaryExpression (ELM)"));
        set.concept("ELM Exists (ELM)").at(inception)
                .synonym("ELM Exists")
                .definition("From the ELM specification: The Exists operator returns true if the list contains any"
                        + " elements. If the argument is null, the result is false.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Times (ELM)").at(inception)
                .synonym("ELM Times")
                .definition("From the ELM specification: The Times operator performs the cartesian product of two"
                        + " lists of tuples. The return type of a Times operator is a tuple with all the"
                        + " components from the tuple types of both arguments. The result will contain a tuple"
                        + " for each possible combination of tuples from both arguments with the values for each"
                        + " component derived from the pairing of the source tuples. If either argument is null,"
                        + " the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Filter (ELM)").at(inception)
                .synonym("ELM Filter")
                .definition("From the ELM specification: The Filter operator returns a list with only those"
                        + " elements in the source list for which the condition element evaluates to true. If the"
                        + " source argument is null, the result is null.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Filter source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Filter condition")),
                        set.conceptRef("ELM condition position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Filter scope")),
                        set.conceptRef("ELM scope position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM First (ELM)").at(inception)
                .synonym("ELM First")
                .definition("From the ELM specification: The First operator returns the first element in a list. If"
                        + " the order by attribute is specified, the list is sorted by that ordering prior to"
                        + " returning the first element. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM First source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM First orderBy")),
                        set.conceptRef("ELM orderBy position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Last (ELM)").at(inception)
                .synonym("ELM Last")
                .definition("From the ELM specification: The Last operator returns the last element in a list. If"
                        + " the order by attribute is specified, the list is sorted by that ordering prior to"
                        + " returning the last element. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Last source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Last orderBy")),
                        set.conceptRef("ELM orderBy position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Slice (ELM)").at(inception)
                .synonym("ELM Slice")
                .definition("From the ELM specification: The Slice operator returns a portion of the elements in a"
                        + " list, beginning at the start index and ending just before the ending index. If the"
                        + " source list is null, the result is null. If the startIndex is null, the slice begins"
                        + " at the first element of the list. If the endIndex is null, the slice continues to the"
                        + " last element of the list. If the startIndex or endIndex is less than 0, or if the"
                        + " endIndex is less than the startIndex, the result is an empty list.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Slice source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Slice startIndex")),
                        set.conceptRef("ELM startIndex position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Slice endIndex")),
                        set.conceptRef("ELM endIndex position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM IndexOf (ELM)").at(inception)
                .synonym("ELM IndexOf")
                .definition("From the ELM specification: The IndexOf operator returns the 0-based index of the"
                        + " given element in the given source list. The operator uses equality semantics as"
                        + " defined in the Equal operator to determine the index, with the exception that nulls"
                        + " are considered equal. The search is linear, and returns the index of the first"
                        + " element for which the equality comparison returns true. If the list is empty, or no"
                        + " element is found, the result is -1. If either argument is null, the result is null.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IndexOf source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IndexOf element")),
                        set.conceptRef("ELM element position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM Flatten (ELM)").at(inception)
                .synonym("ELM Flatten")
                .definition("From the ELM specification: The Flatten operator flattens a list of lists into a"
                        + " single list. If the argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Sort (ELM)").at(inception)
                .synonym("ELM Sort")
                .definition("From the ELM specification: The Sort operator returns a list with all the elements in"
                        + " source, sorted as described by the by element. When the sort elements do not provide"
                        + " a unique ordering (i.e. there is a possibility of duplicate sort values in the"
                        + " result), the order of duplicates is unspecified. If the argument is null, the result"
                        + " is null.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Sort source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Sort by")),
                        set.conceptRef("ELM by position (ELM)"), set.conceptRef("ELM SortByItem (ELM)"), 1, -1,
                        "", edgeForm);
        set.concept("ELM ForEach (ELM)").at(inception)
                .synonym("ELM ForEach")
                .definition("From the ELM specification: The ForEach expression iterates over the list of elements"
                        + " in the source element, and returns a list with the same number of elements, where"
                        + " each element in the new list is the result of evaluating the element expression for"
                        + " each element in the source list. If the source argument is null, the result is null."
                        + " If the element argument evaluates to null for some item in the source list, the"
                        + " resulting list will contain a null for that element.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ForEach source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ForEach element")),
                        set.conceptRef("ELM element position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ForEach scope")),
                        set.conceptRef("ELM scope position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Repeat (ELM)").at(inception)
                .synonym("ELM Repeat")
                .definition("From the ELM specification: The Repeat expression performs successive ForEach until no"
                        + " new elements are returned. The operator uses equality comparison semantics as defined"
                        + " in the Equal operator. If the source argument is null, the result is null. If the"
                        + " element argument evaluates to null for some item in the source list, the resulting"
                        + " list will contain a null for that element.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Repeat source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Repeat element")),
                        set.conceptRef("ELM element position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Repeat scope")),
                        set.conceptRef("ELM scope position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Distinct (ELM)").at(inception)
                .synonym("ELM Distinct")
                .definition("From the ELM specification: The Distinct operator takes a list of elements and returns"
                        + " a list containing only the unique elements within the input. For example, given the"
                        + " list of integers { 1, 1, 1, 2, 2, 3, 4, 4 }, the result of Distinct would be { 1, 2,"
                        + " 3, 4 }. The operator uses equality comparison semantics as defined in the Equal"
                        + " operator, with the exception that nulls are considered equal for the purposes of"
                        + " distinct determination. This means that multiple nulls in the input will result in a"
                        + " single null in the output. If the source argument is null, the result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Current (ELM)").at(inception)
                .synonym("ELM Current")
                .definition("From the ELM specification: The Current expression returns the value of the object"
                        + " currently in scope. For example, within a ForEach expression, this returns the"
                        + " current element being considered in the iteration. Scopes are introduced by the named"
                        + " scoping operators (Filter, ForEach, and Repeat), the implicit scoping operators (Sort"
                        + " and Aggregate) as well as introduced within Queries by the AliasedQuerySource,"
                        + " LetClause, AggregateClause, and SortClause elements. It is an error to invoke the"
                        + " Current operator outside of a scoped operation.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Current scope")),
                        set.conceptRef("ELM scope position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Iteration (ELM)").at(inception)
                .synonym("ELM Iteration")
                .definition("From the ELM specification: The Iteration expression returns the current iteration"
                        + " number of a scoped operation. For example, within a ForEach expression, this returns"
                        + " the 0-based index of the current iteration. Scopes are introduced by the named"
                        + " scoping operators (Filter, ForEach, and Repeat), the implicit scoping operators (Sort"
                        + " and Aggregate) as well as introduced within Queries by the AliasedQuerySource,"
                        + " LetClause, AggregateClause, and SortClause elements. It is an error to invoke the"
                        + " Iteration operator outside of a scoped operation.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Iteration scope")),
                        set.conceptRef("ELM scope position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Total (ELM)").at(inception)
                .synonym("ELM Total")
                .definition("From the ELM specification: The Total expression returns the current value of the"
                        + " total aggregation accumulator in an aggregate operation. It is an error to invoke the"
                        + " Total operator outside of an aggregate operation (Aggregate or within the"
                        + " AggregateClause of a query).")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Total scope")),
                        set.conceptRef("ELM scope position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM SingletonFrom (ELM)").at(inception)
                .synonym("ELM SingletonFrom")
                .definition("From the ELM specification: The SingletonFrom expression extracts a single element"
                        + " from the source list. If the source list is empty, the result is null. If the source"
                        + " list contains one element, that element is returned. If the list contains more than"
                        + " one element, a run-time error is thrown. If the source list is null, the result is"
                        + " null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM AggregateExpression (ELM)").at(inception)
                .synonym("ELM AggregateExpression")
                .definition("From the ELM specification: Aggregate expressions perform operations on lists of data,"
                        + " either directly on a list of scalars, or indirectly on a list of objects, with a"
                        + " reference to a property present on each object in the list. Aggregate expressions"
                        + " deal with missing information by excluding missing values from consideration before"
                        + " performing the aggregated operation. For example, in a Sum over Dose, any instance of"
                        + " Medication with no value for Dose would be ignored. An aggregate operation performed"
                        + " over an empty list is defined to return null, except as noted in the documentation"
                        + " for each operator (Count, AllTrue, and AnyTrue are the exceptions). The schema marks"
                        + " it abstract: a tree never holds it directly, only one of the types that extend it.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AggregateExpression signature")),
                        set.conceptRef("ELM signature position (ELM)"), set.conceptRef("ELM TypeSpecifier (ELM)"), 0, -1,
                        "Specifies the declared signature of the operator or function being called. If no signature is specified, the run-time types of the operands should be used to resolve any overload.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AggregateExpression source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AggregateExpression path")),
                        set.conceptRef("ELM path position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Aggregate (ELM)").at(inception)
                .synonym("ELM Aggregate")
                .definition("From the ELM specification: The Aggregate operator performs custom aggregation by"
                        + " evaluating an expression for each element of the source. If a path is specified, the"
                        + " aggregation is performed for value of the property specified by the path for each"
                        + " element of the source. The iteration expression has access to the $this, $index, and"
                        + " $total variables. At the end of each iteration, the value of the $total variable is"
                        + " updated to the result of the iteration expression. The value of the $total variable"
                        + " is initialized to the result of the initialValue expression, if present. If the list"
                        + " is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Aggregate iteration")),
                        set.conceptRef("ELM iteration position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Aggregate initialValue")),
                        set.conceptRef("ELM initialValue position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM Count (ELM)").at(inception)
                .synonym("ELM Count")
                .definition("From the ELM specification: The Count operator returns the number of non-null elements"
                        + " in the source. If a path is specified, the count returns the number of elements that"
                        + " have a value for the property specified by the path. If the list is empty, the result"
                        + " is 0. If the list is null, the result is 0.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM Sum (ELM)").at(inception)
                .synonym("ELM Sum")
                .definition("From the ELM specification: The Sum operator returns the sum of non-null elements in"
                        + " the source. If a path is specified, elements with no value for the property specified"
                        + " by the path are ignored. If the source contains no non-null elements, null is"
                        + " returned. If the list is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM Product (ELM)").at(inception)
                .synonym("ELM Product")
                .definition("From the ELM specification: The Product operator returns the geometric product of"
                        + " non-null elements in the source. If a path is specified, elements with no value for"
                        + " the property specified by the path are ignored. If the source contains no non-null"
                        + " elements, null is returned. If the list is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM Min (ELM)").at(inception)
                .synonym("ELM Min")
                .definition("From the ELM specification: The Min operator returns the minimum element in the"
                        + " source. Comparison semantics are defined by the comparison operators for the type of"
                        + " the values being aggregated. If a path is specified, elements with no value for the"
                        + " property specified by the path are ignored. If the source contains no non-null"
                        + " elements, null is returned. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM Max (ELM)").at(inception)
                .synonym("ELM Max")
                .definition("From the ELM specification: The Max operator returns the maximum element in the"
                        + " source. Comparison semantics are defined by the comparison operators for the type of"
                        + " the values being aggregated. If a path is specified, elements with no value for the"
                        + " property specified by the path are ignored. If the source contains no non-null"
                        + " elements, null is returned. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM Avg (ELM)").at(inception)
                .synonym("ELM Avg")
                .definition("From the ELM specification: The Avg operator returns the average of the non-null"
                        + " elements in source. If a path is specified, elements with no value for the property"
                        + " specified by the path are ignored. If the source contains no non-null elements, null"
                        + " is returned. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM GeometricMean (ELM)").at(inception)
                .synonym("ELM GeometricMean")
                .definition("From the ELM specification: The GeometricMean operator returns the geometric mean of"
                        + " the non-null elements in source. If a path is specified, elements with no value for"
                        + " the property specified by the path are ignored. If the source contains no non-null"
                        + " elements, null is returned. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM Median (ELM)").at(inception)
                .synonym("ELM Median")
                .definition("From the ELM specification: The Median operator returns the median of the elements in"
                        + " source. If a path is specified, elements with no value for the property specified by"
                        + " the path are ignored. If the source contains no non-null elements, null is returned."
                        + " If the source is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM Mode (ELM)").at(inception)
                .synonym("ELM Mode")
                .definition("From the ELM specification: The Mode operator returns the statistical mode of the"
                        + " elements in source. If a path is specified, elements with no value for the property"
                        + " specified by the path are ignored. If the source contains no non-null elements, null"
                        + " is returned. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM Variance (ELM)").at(inception)
                .synonym("ELM Variance")
                .definition("From the ELM specification: The Variance operator returns the statistical variance of"
                        + " the elements in source. If a path is specified, elements with no value for the"
                        + " property specified by the path are ignored. If the source contains no non-null"
                        + " elements, null is returned. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM PopulationVariance (ELM)").at(inception)
                .synonym("ELM PopulationVariance")
                .definition("From the ELM specification: The PopulationVariance operator returns the statistical"
                        + " population variance of the elements in source. If a path is specified, elements with"
                        + " no value for the property specified by the path are ignored. If the source contains"
                        + " no non-null elements, null is returned. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM StdDev (ELM)").at(inception)
                .synonym("ELM StdDev")
                .definition("From the ELM specification: The StdDev operator returns the statistical standard"
                        + " deviation of the elements in source. If a path is specified, elements with no value"
                        + " for the property specified by the path are ignored. If the source contains no"
                        + " non-null elements, null is returned. If the list is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM PopulationStdDev (ELM)").at(inception)
                .synonym("ELM PopulationStdDev")
                .definition("From the ELM specification: The PopulationStdDev operator returns the statistical"
                        + " standard deviation of the elements in source. If a path is specified, elements with"
                        + " no value for the property specified by the path are ignored. If the source contains"
                        + " no non-null elements, null is returned. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM AllTrue (ELM)").at(inception)
                .synonym("ELM AllTrue")
                .definition("From the ELM specification: The AllTrue operator returns true if all the non-null"
                        + " elements in source are true. If a path is specified, elements with no value for the"
                        + " property specified by the path are ignored. If the source contains no non-null"
                        + " elements, true is returned. If the source is null, the result is true.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM AnyTrue (ELM)").at(inception)
                .synonym("ELM AnyTrue")
                .definition("From the ELM specification: The AnyTrue operator returns true if any non-null element"
                        + " in source is true. If a path is specified, elements with no value for the property"
                        + " specified by the path are ignored. If the source contains no non-null elements, false"
                        + " is returned. If the source is null, the result is false.")
                .isA(set.conceptRef("ELM AggregateExpression (ELM)"));
        set.concept("ELM Property (ELM)").at(inception)
                .synonym("ELM Property")
                .definition("From the ELM specification: The Property operator returns the value of the property on"
                        + " the source (or named scope) specified by the path attribute. If the result of"
                        + " evaluating source (or the named scope) is null, the result is null. The path"
                        + " attribute may include qualifiers (.) and indexers ([x]). Indexers must be literal"
                        + " integer values. If the path attribute contains qualifiers or indexers, each qualifier"
                        + " or indexer is traversed to obtain the actual value. If the object of the property"
                        + " access at any point in traversing the path is null, the result is null. If a scope is"
                        + " specified, the name is used to resolve the scope in which the path will be resolved."
                        + " Scopes can be named by the scoping operators (Filter, ForEach, Repeat, and Sort) as"
                        + " well as introduced within a Query through the AliasedQuerySource, LetClause,"
                        + " AggregateClause, and SortClause. Property expressions can also be used to access the"
                        + " individual points and closed indicators for interval types using the property names"
                        + " low, high, lowClosed, and highClosed.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Property source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Property path")),
                        set.conceptRef("ELM path position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Property scope")),
                        set.conceptRef("ELM scope position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM AliasedQuerySource (ELM)").at(inception)
                .synonym("ELM AliasedQuerySource")
                .definition("From the ELM specification: The AliasedQuerySource element defines a single source for"
                        + " inclusion in a query scope. The type of the source is determined by the expression"
                        + " element, and the source can be accessed within the query scope by the given alias.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AliasedQuerySource expression")),
                        set.conceptRef("ELM expression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AliasedQuerySource alias")),
                        set.conceptRef("ELM alias position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM LetClause (ELM)").at(inception)
                .synonym("ELM LetClause")
                .definition("From the ELM specification: The LetClause element allows any number of expression"
                        + " definitions to be introduced within a query scope. Defined expressions can be"
                        + " referenced by name within the query scope.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM LetClause expression")),
                        set.conceptRef("ELM expression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM LetClause identifier")),
                        set.conceptRef("ELM identifier position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm);
        set.concept("ELM RelationshipClause (ELM)").at(inception)
                .synonym("ELM RelationshipClause")
                .definition("From the ELM specification: The RelationshipClause element allows related sources to"
                        + " be used to restrict the elements included from another source in a query scope. Note"
                        + " that the elements referenced by the relationship clause can only be accessed within"
                        + " the suchThat condition, and that elements of the related source are not included in"
                        + " the query scope. The schema marks it abstract: a tree never holds it directly, only"
                        + " one of the types that extend it.")
                .isA(set.conceptRef("ELM AliasedQuerySource (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM RelationshipClause suchThat")),
                        set.conceptRef("ELM suchThat position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM With (ELM)").at(inception)
                .synonym("ELM With")
                .definition("From the ELM specification: The With clause restricts the elements of a given source"
                        + " to only those elements that have elements in the related source that satisfy the"
                        + " suchThat condition. This operation is known as a semi-join in database languages.")
                .isA(set.conceptRef("ELM RelationshipClause (ELM)"));
        set.concept("ELM Without (ELM)").at(inception)
                .synonym("ELM Without")
                .definition("From the ELM specification: The Without clause restricts the elements of a given"
                        + " source to only those elements that do not have elements in the related source that"
                        + " satisfy the suchThat condition. This operation is known as a semi-difference in"
                        + " database languages.")
                .isA(set.conceptRef("ELM RelationshipClause (ELM)"));
        set.concept("ELM SortByItem (ELM)").at(inception)
                .synonym("ELM SortByItem")
                .definition("A type of the ELM specification; the schema gives no description. The schema marks it"
                        + " abstract: a tree never holds it directly, only one of the types that extend it.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM SortByItem direction")),
                        set.conceptRef("ELM direction position (ELM)"), set.conceptRef("ELM SortDirection (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ByDirection (ELM)").at(inception)
                .synonym("ELM ByDirection")
                .definition("From the ELM specification: The ByDirection element specifies that the sort should be"
                        + " performed using the given direction. This approach is used when the result of the"
                        + " query is a list of non-tuple elements and only the sort direction needs to be"
                        + " specified.")
                .isA(set.conceptRef("ELM SortByItem (ELM)"));
        set.concept("ELM ByColumn (ELM)").at(inception)
                .synonym("ELM ByColumn")
                .definition("From the ELM specification: The ByColumn element specifies that the sort should be"
                        + " performed using the given column and direction. This approach is used to specify the"
                        + " sort order for a query when the result is a list of tuples.")
                .isA(set.conceptRef("ELM SortByItem (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ByColumn path")),
                        set.conceptRef("ELM path position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ByExpression (ELM)").at(inception)
                .synonym("ELM ByExpression")
                .definition("From the ELM specification: The ByExpression element specifies that the sort should be"
                        + " performed using the given expression and direction. This approach is used to specify"
                        + " the sort order as a calculated expression. Within the expression, the iteration"
                        + " accessor $this can be used to access the current iteration value, and $index can be"
                        + " used to access the 0-based index of the current iteration.")
                .isA(set.conceptRef("ELM SortByItem (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ByExpression expression")),
                        set.conceptRef("ELM expression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM SortClause (ELM)").at(inception)
                .synonym("ELM SortClause")
                .definition("From the ELM specification: The SortClause element defines the sort order for the"
                        + " query.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM SortClause by")),
                        set.conceptRef("ELM by position (ELM)"), set.conceptRef("ELM SortByItem (ELM)"), 1, -1,
                        "", edgeForm);
        set.concept("ELM ReturnClause (ELM)").at(inception)
                .synonym("ELM ReturnClause")
                .definition("From the ELM specification: The ReturnClause element defines the shape of the result"
                        + " set of the query.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ReturnClause expression")),
                        set.conceptRef("ELM expression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ReturnClause distinct")),
                        set.conceptRef("ELM distinct position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM AggregateClause (ELM)").at(inception)
                .synonym("ELM AggregateClause")
                .definition("From the ELM specification: The AggregateClause element defines the result of the"
                        + " query in terms of an aggregation expression performed for each item in the query.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AggregateClause expression")),
                        set.conceptRef("ELM expression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AggregateClause starting")),
                        set.conceptRef("ELM starting position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AggregateClause identifier")),
                        set.conceptRef("ELM identifier position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AggregateClause distinct")),
                        set.conceptRef("ELM distinct position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Query (ELM)").at(inception)
                .synonym("ELM Query")
                .definition("From the ELM specification: The Query operator represents a clause-based query. The"
                        + " result of the query is determined by the type of sources included, as well as the"
                        + " clauses used in the query.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Query source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM AliasedQuerySource (ELM)"), 1, -1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Query let")),
                        set.conceptRef("ELM let position (ELM)"), set.conceptRef("ELM LetClause (ELM)"), 0, -1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Query relationship")),
                        set.conceptRef("ELM relationship position (ELM)"), set.conceptRef("ELM RelationshipClause (ELM)"), 0, -1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Query where")),
                        set.conceptRef("ELM where position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Query return")),
                        set.conceptRef("ELM return position (ELM)"), set.conceptRef("ELM ReturnClause (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Query aggregate")),
                        set.conceptRef("ELM aggregate position (ELM)"), set.conceptRef("ELM AggregateClause (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Query sort")),
                        set.conceptRef("ELM sort position (ELM)"), set.conceptRef("ELM SortClause (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM AliasRef (ELM)").at(inception)
                .synonym("ELM AliasRef")
                .definition("From the ELM specification: The AliasRef expression allows for the reference of a"
                        + " specific source within the scope of a query.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AliasRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM QueryLetRef (ELM)").at(inception)
                .synonym("ELM QueryLetRef")
                .definition("From the ELM specification: The QueryLetRef expression allows for the reference of a"
                        + " specific let definition within the scope of a query.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM QueryLetRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Children (ELM)").at(inception)
                .synonym("ELM Children")
                .definition("From the ELM specification: For structured types, the Children operator returns a list"
                        + " of all the values of the elements of the type. List-valued elements are expanded and"
                        + " added to the result individually, rather than as a single list. For list types, the"
                        + " result is the same as invoking Children on each element in the list and flattening"
                        + " the resulting lists into a single result. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Children source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM Descendants (ELM)").at(inception)
                .synonym("ELM Descendants")
                .definition("From the ELM specification: For structured types, the Descendants operator returns a"
                        + " list of all the values of the elements of the type, recursively. List-valued elements"
                        + " are expanded and added to the result individually, rather than as a single list. For"
                        + " list types, the result is the same as invoking Descendants on each element in the"
                        + " list and flattening the resulting lists into a single result. If the source is null,"
                        + " the result is null.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Descendants source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM Descendents (ELM)").at(inception)
                .synonym("ELM Descendents")
                .definition("From the ELM specification: DEPRECATED: Use Descendants. For structured types, the"
                        + " Descendents operator returns a list of all the values of the elements of the type,"
                        + " recursively. List-valued elements are expanded and added to the result individually,"
                        + " rather than as a single list. For list types, the result is the same as invoking"
                        + " Descendents on each element in the list and flattening the resulting lists into a"
                        + " single result. If the source is null, the result is null.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Descendents source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM Message (ELM)").at(inception)
                .synonym("ELM Message")
                .definition("From the ELM specification: The Message operator is used to support errors, warnings,"
                        + " messages, and tracing in an ELM evaluation environment. The operator is defined to"
                        + " return the input source. If the severity is Error, the operator is expected to raise"
                        + " a run-time error and return the message to the calling environment. This is the only"
                        + " severity that stops processing. All other severities continue evaluation of the"
                        + " expression. If the severity is Trace, the operator is expected to make the message"
                        + " available to a tracing mechanism such as a debug log in the calling environment. If"
                        + " the severity is Warning, the operator is expected to provide the message as a warning"
                        + " to the calling environment. If the severity is Message, the operator is expected to"
                        + " provide the message as information to the calling environment.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Message source")),
                        set.conceptRef("ELM source position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Message condition")),
                        set.conceptRef("ELM condition position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Message code")),
                        set.conceptRef("ELM code position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Message severity")),
                        set.conceptRef("ELM severity position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Message message")),
                        set.conceptRef("ELM message position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM CodeFilterElement (ELM)").at(inception)
                .synonym("ELM CodeFilterElement")
                .definition("From the ELM specification: The CodeFilterElement type specifies a terminology filter"
                        + " criteria for use within a retrieve, specified as either [property] [comparator]"
                        + " [value] or [search] [comparator] [value].")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeFilterElement value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "An expression that provides the comparison value for the filter. The expression is expected to result in a List<Code> to match against. Only the clinical statements that match at least one of the specified codes will be returned.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeFilterElement property")),
                        set.conceptRef("ELM property position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The property attribute specifies which property the filter applies to. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeFilterElement valueSetProperty")),
                        set.conceptRef("ELM valueSetProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The valueSetProperty attribute optionally specifies which property of the model contains a value set identifier that can be used as an alternative mechanism for matching the value set of the retrieve, in the case when no code is specified in the source data. This attribute is intended to address the case where systems representing negation rationale for an activity not performed do so by indicating a valueset identifier rather than a code. For example, when indicating that a medication was not administered, the value set identifier for the expected medication is used, rather than indicating a specific medication that was not administered. In this case, the valueSetProperty attribute allows the retrieve to specify where to look for the value set identifier without needing to change the conceptual data model or the CQL logic describing the negated activity. Note that implementers could also specify this information elsewhere as part of an implementation catalog, rather than on each Retrieve expression, but allowing it to be specified in the retrieve expression gives the most flexibility. From the perspective of ELM, the specification ensures that ELM can be processed without reference to the model information. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeFilterElement search")),
                        set.conceptRef("ELM search position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The search attribute specifies the name of a search path for the filter.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeFilterElement comparator")),
                        set.conceptRef("ELM comparator position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "The codeComparator attribute specifies how elements of the code property should be matched to the terminology. One of 'in', '=', or '~'. Note that 'in' will resolve to the appropriate terminology matching operator, resulting in equivalence semantics for value set and code system membership testing.", propertyForm);
        set.concept("ELM DateFilterElement (ELM)").at(inception)
                .synonym("ELM DateFilterElement")
                .definition("From the ELM specification: The DateFilterElement type specifies a date-valued filter"
                        + " criteria for use within a retrieve, specified as either a date-valued [property], a"
                        + " date-value [lowProperty] and [highProperty] or a [search], and an expression that"
                        + " evaluates to a date or time type, an interval of a date or time type, or a"
                        + " time-valued Quantity.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateFilterElement value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "An expression that provides the comparison value for the filter. The expression is expected to result in a date or time type, an interval of a date or time type, or a time-valued quantity. Only the clinical statements that match at least one of the specified codes will be returned.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateFilterElement property")),
                        set.conceptRef("ELM property position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The dateProperty attribute optionally specifies which property of the model contains the clinically relevant date for the clinical statement. This property is expected to reference a property that is either a Date or DateTime, or an interval of Date or DateTime. In either case, the result set will only include instances where the value of the dateProperty is during the date range. For Date or DateTime values, this means the date is both the same or after the beginning of the range, and the same or before the end of the range. For Date- or DateTime-based interval values, this means that the entire interval is included in the date range. Instances with no value for the dateProperty will not be included in the result set if a date range is specified. Note that if the property is specified, the lowProperty and highProperty attributes must not be present. And conversely, if the lowProperty and highProperty attributes are specified, the dateProperty must not be present. If specified, the lowProperty and highProperty values will be used to construct an interval with inclusive boundaries for the date range. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateFilterElement lowProperty")),
                        set.conceptRef("ELM lowProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The lowProperty attribute optionally specifies which property of the model contains the low component of the clinically relevant date for the clinical statement. Note that if the property is specified, the lowProperty and highProperty attributes must not be present. And conversely, if the lowProperty and highProperty attributes are specified, the property must not be present. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateFilterElement highProperty")),
                        set.conceptRef("ELM highProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The highProperty attribute optionally specifies which property of the model contains the high component of the clinically relevant date for the clinical statement. Note that if the property is specified, the lowProperty and highProperty attributes must not be present. And conversely, if the lowProperty and highProperty attributes are specified, the property must not be present. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM DateFilterElement search")),
                        set.conceptRef("ELM search position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The search attribute specifies the name of the search path to use for searching for values in the date range specified by the dateRange element.", propertyForm);
        set.concept("ELM OtherFilterElement (ELM)").at(inception)
                .synonym("ELM OtherFilterElement")
                .definition("From the ELM specification: The OtherFilterElement type specifies an arbitrarily-typed"
                        + " filter criteria for use within a retrieve, specified as either [property]"
                        + " [comparator] [value] or [search] [comparator] [value].")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OtherFilterElement value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "An expression that provides the comparison value for the filter.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OtherFilterElement property")),
                        set.conceptRef("ELM property position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The property attribute specifies which property the filter applies to. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OtherFilterElement search")),
                        set.conceptRef("ELM search position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The search attribute specifies the name of a search path for the filter.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM OtherFilterElement comparator")),
                        set.conceptRef("ELM comparator position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "The comparator attribute specifies the comparison operation for the filter.", propertyForm);
        set.concept("ELM IncludeElement (ELM)").at(inception)
                .synonym("ELM IncludeElement")
                .definition("From the ELM specification: The IncludeElement type specifies include information for"
                        + " an include within a retrieve.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludeElement includeFrom")),
                        set.conceptRef("ELM includeFrom position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The localId of another Retrieve that specifies the data to be included in this retrieve. The target Retrieve will have an includedIn attribute referencing this includeElement.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludeElement relatedDataType")),
                        set.conceptRef("ELM relatedDataType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 1, 1,
                        "The relatedDataType attribute specifies the type of the related data being requested.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludeElement relatedProperty")),
                        set.conceptRef("ELM relatedProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The relatedProperty attribute specifies which property of the relatedDataType contains the relatedId for the clinical statement. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludeElement relatedSearch")),
                        set.conceptRef("ELM relatedSearch position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The relatedSearch attribute specifies the name of the search path to use for searching for data of the relatedDataType.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludeElement isReverse")),
                        set.conceptRef("ELM isReverse position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 0, 1,
                        "The isReverse attribute indicates that the include is reverse, i.e. that the relatedDataType is referencing the data being retrieved, rather than the retrieved data referencing the relatedDataType.", propertyForm);
        set.concept("ELM Retrieve (ELM)").at(inception)
                .synonym("ELM Retrieve")
                .definition("From the ELM specification: The retrieve expression defines clinical data that will be"
                        + " used by the artifact. This expression allows clinically relevant filtering criteria"
                        + " to be provided in a well-defined and computable way. This operation defines the"
                        + " integration boundary for artifacts. The result of a retrieve is defined to return the"
                        + " same data for subsequent invocations within the same evaluation request. This means"
                        + " in particular that patient data updates made during the evaluation request are not"
                        + " visible to the artifact. In effect, the patient data is a snapshot of the data as of"
                        + " the start of the evaluation. This ensures strict deterministic and functional"
                        + " behavior of the artifact, and allows the implementation engine freedom to cache"
                        + " intermediate results in order to improve performance.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve id")),
                        set.conceptRef("ELM id position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "The id element optionally specifies an expression that results in a value that can be used to filter the retrieve to a specific id.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve codes")),
                        set.conceptRef("ELM codes position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "The codes element optionally specifies an expression that results in a List<Code> to match against. Only the clinical statements that match at least one of the specified codes will be returned.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve dateRange")),
                        set.conceptRef("ELM dateRange position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "The dateRange element optionally specifies an expression that results in an Interval<DateTime> to match against. Only those clinical statements whose date falls within the specified date range will be returned.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve context")),
                        set.conceptRef("ELM context position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "If specified, the context element references an expression that, when evaluated, provides the context for the retrieve. The expression evaluates to the instance id that will be used as the context for the retrieve.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve include")),
                        set.conceptRef("ELM include position (ELM)"), set.conceptRef("ELM IncludeElement (ELM)"), 0, -1,
                        "Specifies a related data type to be included in the result as part of the retrieve.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve codeFilter")),
                        set.conceptRef("ELM codeFilter position (ELM)"), set.conceptRef("ELM CodeFilterElement (ELM)"), 0, -1,
                        "Specifies a terminology filter to be applied as part of the retrieve. Each codeFilter is specified as [property] [comparator] [value] or [search] [comparator] [value]. When multiple codeFilters are present, they are all applied (i.e. ANDed). For simplicity, if this element is specified at all, it will include the code filter established by the attributes of the retrieve, as well as any additional filtering criteria as determined by optimization strategies.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve dateFilter")),
                        set.conceptRef("ELM dateFilter position (ELM)"), set.conceptRef("ELM DateFilterElement (ELM)"), 0, -1,
                        "Specifies a date filter to be applied as part of the retrieve. Each dateFilter is specifies as a [property], or a [lowProperty]-[highProperty], or a [search], and a [value] that is an expression that evaluates to an interval of a date or time value. When multiple dateFilters are present, they are all applied (i.e. ANDed). For simplicity, if this element is specified at all, it will include the date filter established by the attributes of the retrieve, as well as any additional filtering criteria as determined by optimization strategies.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve otherFilter")),
                        set.conceptRef("ELM otherFilter position (ELM)"), set.conceptRef("ELM OtherFilterElement (ELM)"), 0, -1,
                        "Specifies other, non-id, -context, -terminology, or -date valued filter criteria to be applied as part of the retrieve. Each other Filter is specified as [property] [comparator] [value] or [search] [comparator] [value]. When multiple otherFilters are present, they are all applied (i.e. ANDed). This element is included to allow for additional filtering criteria as determined by optimization strategies.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve dataType")),
                        set.conceptRef("ELM dataType position (ELM)"), set.conceptRef("ELM primitive QName (ELM)"), 1, 1,
                        "The dataType attribute specifies the type of data being requested.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve templateId")),
                        set.conceptRef("ELM templateId position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The templateId attribute specifies an optional template to be used. If specified, the retrieve is defined to return only objects that conform to the template.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve idProperty")),
                        set.conceptRef("ELM idProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The idProperty attribute specifies which property of the model contains the Id for the clinical statement. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve idSearch")),
                        set.conceptRef("ELM idSearch position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The idSearch attribute specifies the name of the search path to use for searching for the values in the id element.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve contextProperty")),
                        set.conceptRef("ELM contextProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The contextProperty attribute optionally specifies which property of the model contains the context value. Note that implementers could also specify this information elsewhere as part of an implementation catalog, rather than on each Retrieve expression, but allowing it to be specified in the retrieve expression gives the most flexibility. Note also that even in the case of an implementation catalog, implementations would still ned to respect contextProperty values in the ELM due to the possibility of the retrieve specifying alternate context paths. From the persepctive of ELM, the specification ensures that ELM can be processed without reference to the model information. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve contextSearch")),
                        set.conceptRef("ELM contextSearch position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The contextSearch attribute specifies the name of the search path to use for searching for the context values.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve codeProperty")),
                        set.conceptRef("ELM codeProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The codeProperty attribute optionally specifies which property of the model contains the Code or Codes for the clinical statement. Note that implementers could also specify this information elsewhere as part of an implementation catalog, rather than on each Retrieve expression, but allowing it to be specified in the retrieve expression gives the most flexibility. Note also that even in the case of an implementation catalog, implementations would still need to respect codeProperty values in the ELM due to the possibility of the retrieve specifying alternate code filters. From the perspective of ELM, the specification ensures that ELM can be processed without reference to the model information. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve codeSearch")),
                        set.conceptRef("ELM codeSearch position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The codeSearch attribute specifies the name of the search path to use for searching for the values in the code element.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve codeComparator")),
                        set.conceptRef("ELM codeComparator position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The codeComparator attribute specifies how elements of the code property should be matched to the terminology. One of 'in', '=', or '~'. Note that 'in' will resolve to the appropriate terminology matching operator, resulting in equivalence semantics for value set and code system membership testing.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve valueSetProperty")),
                        set.conceptRef("ELM valueSetProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The valueSetProperty attribute optionally specifies which property of the model contains a value set identifier that can be used as an alternative mechanism for matching the value set of the retrieve, in the case when no code is specified in the source data. This attribute is intended to address the case where systems representing negation rationale for an activity not performed do so by indicating a valueset identifier rather than a code. For example, when indicating that a medication was not administered, the value set identifier for the expected medication is used, rather than indicating a specific medication that was not administered. In this case, the valueSetProperty attribute allows the retrieve to specify where to look for the value set identifier without needing to change the conceptual data model or the CQL logic describing the negated activity. Note that implementers could also specify this information elsewhere as part of an implementation catalog, rather than on each Retrieve expression, but allowing it to be specified in the retrieve expression gives the most flexibility. From the perspective of ELM, the specification ensures that ELM can be processed without reference to the model information. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve dateProperty")),
                        set.conceptRef("ELM dateProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The dateProperty attribute optionally specifies which property of the model contains the clinically relevant date for the clinical statement. This property is expected to reference a property that is either a Date or DateTime, or an interval of Date or DateTime. In either case, the result set will only include instances where the value of the dateProperty is during the date range. For Date or DateTime values, this means the date is both the same or after the beginning of the range, and the same or before the end of the range. For Date- or DateTime-based interval values, this means that the entire interval is included in the date range. Instances with no value for the dateProperty will not be included in the result set if a date range is specified. Note that if the dateProperty is specified, the dateLowProperty and dateHighProperty attributes must not be present. And conversely, if the dateLowProperty and dateHighProperty attributes are specified, the dateProperty must not be present. If specified, the dateLowProperty and dateHighProperty values will be used to construct an interval with inclusive boundaries for the date range. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve dateLowProperty")),
                        set.conceptRef("ELM dateLowProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The dateLowProperty attribute optionally specifies which property of the model contains the low component of the clinically relevant date for the clinical statement. Note that if the dateProperty is specified, the dateLowProperty and dateHighProperty attributes must not be present. And conversely, if the dateLowProperty and dateHighProperty attributes are specified, the dateProperty must not be present. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve dateHighProperty")),
                        set.conceptRef("ELM dateHighProperty position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The dateHighProperty attribute optionally specifies which property of the model contains the high component of the clinically relevant date for the clinical statement. Note that if the dateProperty is specified, the dateLowProperty and dateHighProperty attributes must not be present. And conversely, if the dateLowProperty and dateHighProperty attributes are specified, the dateProperty must not be present. This property may be specified as a path, including qualifiers and constant indexers. The <simplePath> production rule in the CQL grammar provides the formal semantics for this path.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve dateSearch")),
                        set.conceptRef("ELM dateSearch position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The dateSearch attribute specifies the name of the search path to use for searching for values in the date range specified by the dateRange element.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Retrieve includedIn")),
                        set.conceptRef("ELM includedIn position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The localId of another Retrieve that includes the data for this retrieve. The target Retrieve will have an includeElement referencing this retrieve.", propertyForm);
        set.concept("ELM Search (ELM)").at(inception)
                .synonym("ELM Search")
                .definition("From the ELM specification: The Search operation provides an operator that returns the"
                        + " result of an indexing expression on an instance. It is effectively the same as a"
                        + " property access, but uses the name of a defined search on the type, rather than the"
                        + " name of a property on the class.")
                .isA(set.conceptRef("ELM Property (ELM)"));
        set.concept("ELM CodeSystemDef (ELM)").at(inception)
                .synonym("ELM CodeSystemDef")
                .definition("From the ELM specification: The CodeSystemDef type defines a code system identifier"
                        + " that can then be used to identify code systems involved in value set definitions.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeSystemDef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "The name of the code system used for reference.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeSystemDef id")),
                        set.conceptRef("ELM id position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "The unique identifier of the code system.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeSystemDef version")),
                        set.conceptRef("ELM version position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The version of the code system to be used. If no version is specified, the most current published version of the code system is assumed.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeSystemDef accessLevel")),
                        set.conceptRef("ELM accessLevel position (ELM)"), set.conceptRef("ELM AccessModifier (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ValueSetDef (ELM)").at(inception)
                .synonym("ELM ValueSetDef")
                .definition("From the ELM specification: The ValueSetDef type defines a value set identifier that"
                        + " can be referenced by name anywhere within an expression. The id specifies the"
                        + " globally unique identifier for the value set. This may be an HL7 OID, a FHIR URL, or"
                        + " a CTS2 value set URL. If version is specified, it will be used to resolve the version"
                        + " of the value set definition to be used. Otherwise, the most current published version"
                        + " of the value set is assumed. If codeSystems are specified, they will be used to"
                        + " resolve the code systems used within the value set definition to construct the"
                        + " expansion set. Note that the recommended approach to statically binding to an"
                        + " expansion set is to use a value set definition that specifies the version of each"
                        + " code system used. The codeSystemVersions attribute is provided only to ensure static"
                        + " binding can be achieved when the value set definition does not specify code system"
                        + " versions as part of the definition header.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ValueSetDef codeSystem")),
                        set.conceptRef("ELM codeSystem position, mixed case (ELM)"), set.conceptRef("ELM CodeSystemRef (ELM)"), 0, -1,
                        "The code system that should be used to construct the expansion set. Note that the recommended approach to statically binding to an expansion set is to use a value set definition that specifies the version of each code system used. The codeSystem elements are provided only to ensure static binding can be achieved when the value set definition does not specify code system versions as part of the definition header.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ValueSetDef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ValueSetDef id")),
                        set.conceptRef("ELM id position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "The unique identifier of the value set to be retrieved.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ValueSetDef version")),
                        set.conceptRef("ELM version position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "The version of the value set to be retrieved. If no version is provided, the most current published version of the value set is assumed.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ValueSetDef accessLevel")),
                        set.conceptRef("ELM accessLevel position (ELM)"), set.conceptRef("ELM AccessModifier (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM CodeDef (ELM)").at(inception)
                .synonym("ELM CodeDef")
                .definition("From the ELM specification: The CodeDef type defines a code identifier that can then"
                        + " be used to reference single codes anywhere within an expression.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeDef codeSystem")),
                        set.conceptRef("ELM codeSystem position, mixed case (ELM)"), set.conceptRef("ELM CodeSystemRef (ELM)"), 0, 1,
                        "The code system that contains the code being referenced.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeDef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "The name of the code used for reference.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeDef id")),
                        set.conceptRef("ELM id position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "The unique identifier of the code.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeDef display")),
                        set.conceptRef("ELM display position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "An optional display string used to describe the code.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeDef accessLevel")),
                        set.conceptRef("ELM accessLevel position (ELM)"), set.conceptRef("ELM AccessModifier (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ConceptDef (ELM)").at(inception)
                .synonym("ELM ConceptDef")
                .definition("From the ELM specification: The ConceptDef type defines a concept identifier that can"
                        + " then be used to reference single concepts anywhere within an expression.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ConceptDef code")),
                        set.conceptRef("ELM code position (ELM)"), set.conceptRef("ELM CodeRef (ELM)"), 1, -1,
                        "A code that makes up the concept. All codes within a given concept must be synonyms.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ConceptDef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "The name of the concept used for reference.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ConceptDef display")),
                        set.conceptRef("ELM display position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "An optional display string used to describe the concept.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ConceptDef accessLevel")),
                        set.conceptRef("ELM accessLevel position (ELM)"), set.conceptRef("ELM AccessModifier (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM CodeSystemRef (ELM)").at(inception)
                .synonym("ELM CodeSystemRef")
                .definition("From the ELM specification: The CodeSystemRef expression allows a previously defined"
                        + " named code system to be referenced within an expression. Conceptually, referencing a"
                        + " code system returns the set of codes in the code system. Note that this operation"
                        + " should almost never be performed in practice. Code system references are allowed in"
                        + " order to allow for testing of code membership in a particular code system.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeSystemRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeSystemRef libraryName")),
                        set.conceptRef("ELM libraryName position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ValueSetRef (ELM)").at(inception)
                .synonym("ELM ValueSetRef")
                .definition("From the ELM specification: The ValueSetRef expression allows a previously defined"
                        + " named value set to be referenced within an expression. Conceptually, referencing a"
                        + " value set returns the expansion set for the value set as a list of codes.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ValueSetRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ValueSetRef libraryName")),
                        set.conceptRef("ELM libraryName position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ValueSetRef preserve")),
                        set.conceptRef("ELM preserve position (ELM)"), set.conceptRef("ELM primitive boolean (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM CodeRef (ELM)").at(inception)
                .synonym("ELM CodeRef")
                .definition("From the ELM specification: The CodeRef expression allows a previously defined code to"
                        + " be referenced within an expression.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CodeRef libraryName")),
                        set.conceptRef("ELM libraryName position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM ConceptRef (ELM)").at(inception)
                .synonym("ELM ConceptRef")
                .definition("From the ELM specification: The ConceptRef expression allows a previously defined"
                        + " concept to be referenced within an expression.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ConceptRef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ConceptRef libraryName")),
                        set.conceptRef("ELM libraryName position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Code (ELM)").at(inception)
                .synonym("ELM Code")
                .definition("From the ELM specification: The Code type represents a literal code selector.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Code system")),
                        set.conceptRef("ELM system position (ELM)"), set.conceptRef("ELM CodeSystemRef (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Code code")),
                        set.conceptRef("ELM code position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Code display")),
                        set.conceptRef("ELM display position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Concept (ELM)").at(inception)
                .synonym("ELM Concept")
                .definition("From the ELM specification: The Concept type represents a literal concept selector.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Concept code")),
                        set.conceptRef("ELM code position (ELM)"), set.conceptRef("ELM Code (ELM)"), 1, -1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Concept display")),
                        set.conceptRef("ELM display position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM InCodeSystem (ELM)").at(inception)
                .synonym("ELM InCodeSystem")
                .definition("From the ELM specification: The InCodeSystem operator returns true if the given code"
                        + " is in the given code system. The first argument is expected to be a String, Code, or"
                        + " Concept. The second argument is expected to be of type CodeSystem. When this argument"
                        + " is statically a CodeSystemRef, this allows for both static analysis of the code"
                        + " system references within an artifact, as well as the implementation of code system"
                        + " membership by the target environment as a service call to a terminology server, if"
                        + " desired.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM InCodeSystem code")),
                        set.conceptRef("ELM code position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM InCodeSystem codesystem")),
                        set.conceptRef("ELM codesystem position, lower case (ELM)"), set.conceptRef("ELM CodeSystemRef (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM InCodeSystem codesystemExpression")),
                        set.conceptRef("ELM codesystemExpression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM AnyInCodeSystem (ELM)").at(inception)
                .synonym("ELM AnyInCodeSystem")
                .definition("From the ELM specification: The AnyInCodeSystem operator returns true if any of the"
                        + " given codes are in the given code system. The first argument is expected to be a list"
                        + " of String, Code, or Concept. The second argument is expected to be of type"
                        + " CodeSystem. When this argument is statically a CodeSystemRef, this allows for both"
                        + " static analysis of the code system references within an artifact, as well as the"
                        + " implementation of code system membership by the target environment as a service call"
                        + " to a terminology server, if desired.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AnyInCodeSystem codes")),
                        set.conceptRef("ELM codes position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AnyInCodeSystem codesystem")),
                        set.conceptRef("ELM codesystem position, lower case (ELM)"), set.conceptRef("ELM CodeSystemRef (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AnyInCodeSystem codesystemExpression")),
                        set.conceptRef("ELM codesystemExpression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM InValueSet (ELM)").at(inception)
                .synonym("ELM InValueSet")
                .definition("From the ELM specification: The InValueSet operator returns true if the given code is"
                        + " in the given value set. The first argument is expected to be a String, Code, or"
                        + " Concept. The second argument is expected to be of type ValueSet. When this argument"
                        + " is statically a ValueSetRef, this allows for both static analysis of the value set"
                        + " references within an artifact, as well as the implementation of valueset membership"
                        + " by the target environment as a service call to a terminology server, if desired.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM InValueSet code")),
                        set.conceptRef("ELM code position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM InValueSet valueset")),
                        set.conceptRef("ELM valueset position (ELM)"), set.conceptRef("ELM ValueSetRef (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM InValueSet valuesetExpression")),
                        set.conceptRef("ELM valuesetExpression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM AnyInValueSet (ELM)").at(inception)
                .synonym("ELM AnyInValueSet")
                .definition("From the ELM specification: The AnyInValueSet operator returns true if any of the"
                        + " given codes are in the given value set. The first argument is expected to be a list"
                        + " of String, Code, or Concept. The second argument is expected to be of type ValueSet."
                        + " When this argument is statically a ValueSetRef, this allows for both static analysis"
                        + " of the value set references within an artifact, as well as the implementation of"
                        + " valueset membership by the target environment as a service call to a terminology"
                        + " server, if desired.")
                .isA(set.conceptRef("ELM OperatorExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AnyInValueSet codes")),
                        set.conceptRef("ELM codes position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AnyInValueSet valueset")),
                        set.conceptRef("ELM valueset position (ELM)"), set.conceptRef("ELM ValueSetRef (ELM)"), 0, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM AnyInValueSet valuesetExpression")),
                        set.conceptRef("ELM valuesetExpression position (ELM)"), set.conceptRef("ELM Expression (ELM)"), 0, 1,
                        "", edgeForm);
        set.concept("ELM ExpandValueSet (ELM)").at(inception)
                .synonym("ELM ExpandValueSet")
                .definition("From the ELM specification: The ExpandValueSet operator returns the current expansion"
                        + " for the given value set. The operation exoects a single argument of type ValueSet."
                        + " This may be a static reference to a value set (i.e. a ValueSetRef), or a ValueSet"
                        + " value to support dynamic value set usage. The operation is used as the implicit"
                        + " conversion from a ValueSet reference to a list of codes. If the argument is null, the"
                        + " result is null.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"));
        set.concept("ELM Subsumes (ELM)").at(inception)
                .synonym("ELM Subsumes")
                .definition("From the ELM specification: The Subsumes operator returns true if the given codes are"
                        + " equivalent, or if the first code subsumes the second (i.e. the first code is an"
                        + " ancestor of the second in a subsumption hierarchy), and false otherwise. For the"
                        + " Concept overload, this operator returns true if any code in the first concept"
                        + " subsumes any code in the second. If either or both arguments are null, the result is"
                        + " null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM SubsumedBy (ELM)").at(inception)
                .synonym("ELM SubsumedBy")
                .definition("From the ELM specification: The SubsumedBy operator returns true if the given codes"
                        + " are equivalent, or if the first code is subsumed by the second code (i.e. the first"
                        + " code is a descendent of the second code in a subsumption hierarchy), and false"
                        + " otherwise. For the Concept overload, this operator returns true if any code in the"
                        + " first concept is subsumed by any code in the second. If either or both arguments are"
                        + " null, the result is null.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"));
        set.concept("ELM Quantity (ELM)").at(inception)
                .synonym("ELM Quantity")
                .definition("From the ELM specification: The Quantity type defines a clinical quantity. For"
                        + " example, the quantity 10 days or 30 mmHg. The value is a decimal, while the unit is"
                        + " expected to be a valid UCUM unit or calendar duration keyword, singular or plural.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Quantity value")),
                        set.conceptRef("ELM value position (ELM)"), set.conceptRef("ELM primitive decimal (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Quantity unit")),
                        set.conceptRef("ELM unit position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Ratio (ELM)").at(inception)
                .synonym("ELM Ratio")
                .definition("From the ELM specification: The Ratio type defines a ratio between two quantities. For"
                        + " example, the titre 1:128, or the concentration ratio 5 mg/10 mL. The numerator and"
                        + " denominator are both quantities.")
                .isA(set.conceptRef("ELM Expression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Ratio numerator")),
                        set.conceptRef("ELM numerator position (ELM)"), set.conceptRef("ELM Quantity (ELM)"), 1, 1,
                        "", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Ratio denominator")),
                        set.conceptRef("ELM denominator position (ELM)"), set.conceptRef("ELM Quantity (ELM)"), 1, 1,
                        "", edgeForm);
        set.concept("ELM CalculateAge (ELM)").at(inception)
                .synonym("ELM CalculateAge")
                .definition("From the ELM specification: Calculates the age in the specified precision of a person"
                        + " born on the given date. The CalculateAge operator is defined for Date and DateTime."
                        + " For the Date overload, the calculation is performed using Today(), the precision must"
                        + " be one of year, month, week, or day, and the result is the number of whole calendar"
                        + " periods that have elapsed between the given date and today. For the DateTime"
                        + " overload, the calculation is performed using Now(), and the result is the number of"
                        + " whole calendar periods that have elapsed between the given datetime and now.")
                .isA(set.conceptRef("ELM UnaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CalculateAge precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM CalculateAgeAt (ELM)").at(inception)
                .synonym("ELM CalculateAgeAt")
                .definition("From the ELM specification: Calculates the age in the specified precision of a person"
                        + " born on a given date, as of another given date. The CalculateAgeAt operator has two"
                        + " signatures: (Date, Date) (DateTime, DateTime) For the Date overload, precision must"
                        + " be one of year, month, week, or day, and the result is the number of whole calendar"
                        + " periods that have elapsed between the first date and the second date. For the"
                        + " DateTime overload, the result is the number of whole calendar periods that have"
                        + " elapsed between the first datetime and the second datetime.")
                .isA(set.conceptRef("ELM BinaryExpression (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM CalculateAgeAt precision")),
                        set.conceptRef("ELM precision position (ELM)"), set.conceptRef("ELM DateTimePrecision (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM VersionedIdentifier (ELM)").at(inception)
                .synonym("ELM VersionedIdentifier")
                .definition("From the ELM specification: VersionedIdentifier is composed of three parts: (1) an"
                        + " optional system, or namespace, which provides a globally unique, stable scope for the"
                        + " identifier, (2) an identifier which identifies the set of all versions of a given"
                        + " resource, and (3) the actual version of the instance of interest in this set. The"
                        + " VersionedIdentifier therefore points to an individual 'versioned' instance of a"
                        + " resource such as the third version of a library.")
                .isA(root)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM VersionedIdentifier id")),
                        set.conceptRef("ELM id position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM VersionedIdentifier system")),
                        set.conceptRef("ELM system position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM VersionedIdentifier version")),
                        set.conceptRef("ELM version position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM UsingDef (ELM)").at(inception)
                .synonym("ELM UsingDef")
                .definition("From the ELM specification: Defines a data model that is available within the"
                        + " artifact.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM UsingDef localIdentifier")),
                        set.conceptRef("ELM localIdentifier position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM UsingDef uri")),
                        set.conceptRef("ELM uri position (ELM)"), set.conceptRef("ELM primitive anyURI (ELM)"), 1, 1,
                        "The URI of the model that is being referenced. This URL must also be defined as a namespace in the root element of the document to allow for elements of the model to be referenced within the artifact.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM UsingDef version")),
                        set.conceptRef("ELM version position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM IncludeDef (ELM)").at(inception)
                .synonym("ELM IncludeDef")
                .definition("From the ELM specification: Includes a library for use within the artifact.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludeDef localIdentifier")),
                        set.conceptRef("ELM localIdentifier position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 1, 1,
                        "A unique name within this artifact for the library reference. This name is used within this artifact to reference components of this library.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludeDef mediaType")),
                        set.conceptRef("ELM mediaType position (ELM)"), set.conceptRef("ELM primitive anyURI (ELM)"), 0, 1,
                        "Defines the type of the library. If this attribute is omitted, the library is assumed to be an ELM library artifact.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludeDef path")),
                        set.conceptRef("ELM path position (ELM)"), set.conceptRef("ELM primitive anyURI (ELM)"), 1, 1,
                        "Defines the path to the library.", propertyForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM IncludeDef version")),
                        set.conceptRef("ELM version position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "Optionally defines the required version number of the referenced library.", propertyForm);
        set.concept("ELM ContextDef (ELM)").at(inception)
                .synonym("ELM ContextDef")
                .definition("From the ELM specification: The ContextDef type defines a context definition"
                        + " statement. Note that this is a placeholder for the context statement within the"
                        + " library. The effect of the context definition is applied by the translator to the"
                        + " definitions that follow.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM ContextDef name")),
                        set.conceptRef("ELM name position (ELM)"), set.conceptRef("ELM primitive string (ELM)"), 0, 1,
                        "", propertyForm);
        set.concept("ELM Library (ELM)").at(inception)
                .synonym("ELM Library")
                .definition("From the ELM specification: A Library is an instance of a CQL-ELM library.")
                .isA(set.conceptRef("ELM Element (ELM)"))
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library identifier")),
                        set.conceptRef("ELM identifier position (ELM)"), set.conceptRef("ELM VersionedIdentifier (ELM)"), 1, 1,
                        "The identifier element defines a unique identifier for this library, and optionally, a system (or namespace) and version.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library schemaIdentifier")),
                        set.conceptRef("ELM schemaIdentifier position (ELM)"), set.conceptRef("ELM VersionedIdentifier (ELM)"), 1, 1,
                        "This is the identifier of the XML schema (and its version) which governs the structure of this Library.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library usings")),
                        set.conceptRef("ELM usings position (ELM)"), set.conceptRef("ELM primitive anyType (ELM)"), 0, 1,
                        "Set of data models referenced in the Expression objects in this knowledge artifact.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library includes")),
                        set.conceptRef("ELM includes position (ELM)"), set.conceptRef("ELM primitive anyType (ELM)"), 0, 1,
                        "Set of libraries referenced by this artifact. Components of referenced libraries may be used within this artifact.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library parameters")),
                        set.conceptRef("ELM parameters position (ELM)"), set.conceptRef("ELM primitive anyType (ELM)"), 0, 1,
                        "The parameters defined within this library.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library codeSystems")),
                        set.conceptRef("ELM codeSystems position (ELM)"), set.conceptRef("ELM primitive anyType (ELM)"), 0, 1,
                        "The code systems defined within this library.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library valueSets")),
                        set.conceptRef("ELM valueSets position (ELM)"), set.conceptRef("ELM primitive anyType (ELM)"), 0, 1,
                        "The value sets defined within this library.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library codes")),
                        set.conceptRef("ELM codes position (ELM)"), set.conceptRef("ELM primitive anyType (ELM)"), 0, 1,
                        "The codes defined within this library.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library concepts")),
                        set.conceptRef("ELM concepts position (ELM)"), set.conceptRef("ELM primitive anyType (ELM)"), 0, 1,
                        "The concepts defined within this library.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library contexts")),
                        set.conceptRef("ELM contexts position (ELM)"), set.conceptRef("ELM primitive anyType (ELM)"), 0, 1,
                        "The contexts defined within this library.", edgeForm)
                .semantic(typePositions, PublicIds.of(set.uuidFor("Type position: ELM Library statements")),
                        set.conceptRef("ELM statements position (ELM)"), set.conceptRef("ELM primitive anyType (ELM)"), 0, 1,
                        "The statements section contains the expression and function definitions for the library.", edgeForm);

        // ── Enumerations and their values ──
        set.concept("ELM AccessModifier (ELM)").at(inception)
                .synonym("ELM AccessModifier")
                .definition("From the ELM specification: The AccessModifier type is used to specify the access"
                        + " level for the various definitions within a library such as parameters, expressions,"
                        + " and functions. If no access modifier is specified, public is assumed. Private"
                        + " definitions can only be accessed within the library in which they are defined.")
                .isA(root);
        set.concept("ELM AccessModifier Public (ELM)").at(inception)
                .synonym("ELM AccessModifier Public")
                .definition("The AccessModifier value Public of the ELM specification.")
                .isA(set.conceptRef("ELM AccessModifier (ELM)"));
        set.concept("ELM AccessModifier Private (ELM)").at(inception)
                .synonym("ELM AccessModifier Private")
                .definition("The AccessModifier value Private of the ELM specification.")
                .isA(set.conceptRef("ELM AccessModifier (ELM)"));
        set.concept("ELM DateTimePrecision (ELM)").at(inception)
                .synonym("ELM DateTimePrecision")
                .definition("From the ELM specification: The DateTimePrecision type specifies the units of"
                        + " precision available for temporal operations such as DurationBetween, SameAs,"
                        + " SameOrBefore, SameOrAfter, and DateTimeComponentFrom.")
                .isA(root);
        set.concept("ELM DateTimePrecision Year (ELM)").at(inception)
                .synonym("ELM DateTimePrecision Year")
                .definition("The DateTimePrecision value Year of the ELM specification.")
                .isA(set.conceptRef("ELM DateTimePrecision (ELM)"));
        set.concept("ELM DateTimePrecision Month (ELM)").at(inception)
                .synonym("ELM DateTimePrecision Month")
                .definition("The DateTimePrecision value Month of the ELM specification.")
                .isA(set.conceptRef("ELM DateTimePrecision (ELM)"));
        set.concept("ELM DateTimePrecision Week (ELM)").at(inception)
                .synonym("ELM DateTimePrecision Week")
                .definition("The DateTimePrecision value Week of the ELM specification.")
                .isA(set.conceptRef("ELM DateTimePrecision (ELM)"));
        set.concept("ELM DateTimePrecision Day (ELM)").at(inception)
                .synonym("ELM DateTimePrecision Day")
                .definition("The DateTimePrecision value Day of the ELM specification.")
                .isA(set.conceptRef("ELM DateTimePrecision (ELM)"));
        set.concept("ELM DateTimePrecision Hour (ELM)").at(inception)
                .synonym("ELM DateTimePrecision Hour")
                .definition("The DateTimePrecision value Hour of the ELM specification.")
                .isA(set.conceptRef("ELM DateTimePrecision (ELM)"));
        set.concept("ELM DateTimePrecision Minute (ELM)").at(inception)
                .synonym("ELM DateTimePrecision Minute")
                .definition("The DateTimePrecision value Minute of the ELM specification.")
                .isA(set.conceptRef("ELM DateTimePrecision (ELM)"));
        set.concept("ELM DateTimePrecision Second (ELM)").at(inception)
                .synonym("ELM DateTimePrecision Second")
                .definition("The DateTimePrecision value Second of the ELM specification.")
                .isA(set.conceptRef("ELM DateTimePrecision (ELM)"));
        set.concept("ELM DateTimePrecision Millisecond (ELM)").at(inception)
                .synonym("ELM DateTimePrecision Millisecond")
                .definition("The DateTimePrecision value Millisecond of the ELM specification.")
                .isA(set.conceptRef("ELM DateTimePrecision (ELM)"));
        set.concept("ELM SortDirection (ELM)").at(inception)
                .synonym("ELM SortDirection")
                .definition("An enumeration of the ELM specification with 4 values; the schema gives no"
                        + " description.")
                .isA(root);
        set.concept("ELM SortDirection asc (ELM)").at(inception)
                .synonym("ELM SortDirection asc")
                .definition("The SortDirection value asc of the ELM specification.")
                .isA(set.conceptRef("ELM SortDirection (ELM)"));
        set.concept("ELM SortDirection ascending (ELM)").at(inception)
                .synonym("ELM SortDirection ascending")
                .definition("The SortDirection value ascending of the ELM specification.")
                .isA(set.conceptRef("ELM SortDirection (ELM)"));
        set.concept("ELM SortDirection desc (ELM)").at(inception)
                .synonym("ELM SortDirection desc")
                .definition("The SortDirection value desc of the ELM specification.")
                .isA(set.conceptRef("ELM SortDirection (ELM)"));
        set.concept("ELM SortDirection descending (ELM)").at(inception)
                .synonym("ELM SortDirection descending")
                .definition("The SortDirection value descending of the ELM specification.")
                .isA(set.conceptRef("ELM SortDirection (ELM)"));
    }
}
