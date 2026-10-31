package network.ike.foundation.ike.terms.ecl;

import dev.ikm.tinkar.entity.builder.KnowledgeSet;

/**
 * Composes every ECL keyword section onto the caller's KnowledgeSet: 48 keywords, one
 * section each, as the SNOMED CT Expression Constraint Language 2.3 brief and long syntax
 * define them, filed under the ECL keyword hierarchy ({@link EclKeywordHierarchy}).
 *
 * <p>Each keyword becomes one concept, fully qualified as the keyword plus "ECL keyword" and
 * the {@code (ECL)} tag, with the keyword itself (its long syntax spelling) as its regular name
 * and its meaning and example as its definition. Every one is filed under one category of the
 * hierarchy, which hangs from the ECL keyword root under Legacy (IkeFoundation).
 *
 * <p>No identity mapping to Komet is asserted anywhere in this package.
 *
 * <p>These are fresh IKE mints, not ingests: every identity derives from the set's own type-5
 * namespace through {@code set.uuidFor(key)}, keyed on the concept's fully qualified name, as
 * the CQL keyword set's do.
 */
public final class EclSet {

    private EclSet() {
    }

    /**
     * Composes this set's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    public static void compose(KnowledgeSet set) {
        EclKeywordHierarchy.compose(set);
        Accept.compose(set); // accept
        Active.compose(set); // active
        AncestorOf.compose(set); // ancestorOf
        AncestorOrSelfOf.compose(set); // ancestorOrSelfOf
        And.compose(set); // and
        Bottom.compose(set); // bottom
        ConceptFilterType.compose(set); // C
        ChildOf.compose(set); // childOf
        ChildOrSelfOf.compose(set); // childOrSelfOf
        DescriptionFilterType.compose(set); // D
        Def.compose(set); // def
        Defined.compose(set); // defined
        DefinitionStatus.compose(set); // definitionStatus
        DefinitionStatusId.compose(set); // definitionStatusId
        DescendantOf.compose(set); // descendantOf
        DescendantOrSelfOf.compose(set); // descendantOrSelfOf
        Dialect.compose(set); // dialect
        DialectId.compose(set); // dialectId
        EffectiveTime.compose(set); // effectiveTime
        False.compose(set); // false
        Fsn.compose(set); // fsn
        History.compose(set); // history
        HistoryMax.compose(set); // history-max
        HistoryMin.compose(set); // history-min
        HistoryMod.compose(set); // history-mod
        Id.compose(set); // id
        Language.compose(set); // language
        MemberFilterType.compose(set); // M
        Many.compose(set); // many
        Match.compose(set); // match
        MemberOf.compose(set); // memberOf
        Minus.compose(set); // minus
        ModuleId.compose(set); // moduleId
        Or.compose(set); // or
        ParentOf.compose(set); // parentOf
        ParentOrSelfOf.compose(set); // parentOrSelfOf
        Prefer.compose(set); // prefer
        Primitive.compose(set); // primitive
        RefsetContainingAny.compose(set); // refsetContainingAny
        ReverseOf.compose(set); // reverseOf
        Syn.compose(set); // syn
        Term.compose(set); // term
        To.compose(set); // to
        Top.compose(set); // top
        True.compose(set); // true
        Type.compose(set); // type
        TypeId.compose(set); // typeId
        Wild.compose(set); // wild
    }
}
