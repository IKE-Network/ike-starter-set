package network.ike.foundation.ike.terms.cql;

import dev.ikm.tinkar.entity.builder.KnowledgeSet;

/**
 * Composes every CQL keyword section onto the caller's KnowledgeSet: 136 keywords, one
 * section each, as the CQL keyword dictionary chapter (ike-doc
 * {@code cql/keyword-dictionary.adoc}) defines them, filed under the CQL keyword hierarchy
 * ({@link CqlKeywordHierarchy}).
 *
 * <p>Each keyword becomes one concept, fully qualified as the keyword plus the
 * {@code (CQL)} tag, with the keyword itself as its regular name and its dictionary entry's
 * meaning and example as its definition. Every one is filed under one category of the
 * hierarchy, which hangs from the CQL keyword root under Legacy (IkeFoundation).
 *
 * <p>No identity mapping to Komet is asserted anywhere in this package.
 *
 * <p>These are fresh IKE mints, not ingests: with no upstream UUID to adopt, every identity
 * — concept, each description, the identifier, the stated axioms, each dialect
 * acceptability — derives from the set's own type-5 namespace through
 * {@code set.uuidFor(key)}, keyed on the concept's fully qualified name. Derivation stays
 * stable on re-authoring, where a literal would be an identity nothing else could reproduce.
 * The Tinkar base model membership semantic the ingested foundation sections carry is absent
 * for the same reason: it marks baseline provenance these concepts do not have.
 */
public final class CqlSet {

    private CqlSet() {
    }

    /**
     * Composes this set's declarations into the session.
     *
     * @param set the knowledge set (the session)
     */
    public static void compose(KnowledgeSet set) {
        CqlKeywordHierarchy.compose(set);
        After.compose(set); // after
        Aggregate.compose(set); // aggregate
        All.compose(set); // all
        And.compose(set); // and
        As.compose(set); // as
        Asc.compose(set); // asc
        Ascending.compose(set); // ascending
        Before.compose(set); // before
        Between.compose(set); // between
        Bind.compose(set); // bind
        By.compose(set); // by
        Called.compose(set); // called
        Case.compose(set); // case
        Cast.compose(set); // cast
        CodeDeclaration.compose(set); // code
        Codesystem.compose(set); // codesystem
        Codesystems.compose(set); // codesystems
        CodeTypeName.compose(set); // Code
        Collapse.compose(set); // collapse
        ConceptDeclaration.compose(set); // concept
        ConceptTypeName.compose(set); // Concept
        Contains.compose(set); // contains
        Context.compose(set); // context
        Conversion.compose(set); // conversion
        Convert.compose(set); // convert
        Date.compose(set); // date
        Day.compose(set); // day
        Days.compose(set); // days
        Default.compose(set); // default
        Define.compose(set); // define
        Desc.compose(set); // desc
        Descending.compose(set); // descending
        Difference.compose(set); // difference
        Display.compose(set); // display
        Distinct.compose(set); // distinct
        Div.compose(set); // div
        Duration.compose(set); // duration
        During.compose(set); // during
        Else.compose(set); // else
        End.compose(set); // end
        Ends.compose(set); // ends
        Except.compose(set); // except
        Exists.compose(set); // exists
        Expand.compose(set); // expand
        Explicit.compose(set); // explicit
        Extends.compose(set); // extends
        False.compose(set); // false
        Flatten.compose(set); // flatten
        Fluent.compose(set); // fluent
        From.compose(set); // from
        Function.compose(set); // function
        Hour.compose(set); // hour
        Hours.compose(set); // hours
        Identifier.compose(set); // identifier
        If.compose(set); // if
        Implicit.compose(set); // implicit
        Implies.compose(set); // implies
        In.compose(set); // in
        Include.compose(set); // include
        IncludedIn.compose(set); // included in
        Includes.compose(set); // includes
        Intersect.compose(set); // intersect
        Interval.compose(set); // Interval
        Is.compose(set); // is
        Key.compose(set); // key
        Label.compose(set); // label
        Let.compose(set); // let
        Library.compose(set); // library
        List.compose(set); // List
        Maximum.compose(set); // maximum
        Meets.compose(set); // meets
        Millisecond.compose(set); // millisecond
        Milliseconds.compose(set); // milliseconds
        Minimum.compose(set); // minimum
        Minute.compose(set); // minute
        Minutes.compose(set); // minutes
        Mod.compose(set); // mod
        Month.compose(set); // month
        Months.compose(set); // months
        Not.compose(set); // not
        Null.compose(set); // null
        Occurs.compose(set); // occurs
        Of.compose(set); // of
        On.compose(set); // on
        Or.compose(set); // or
        OrAfter.compose(set); // or after
        OrBefore.compose(set); // or before
        OrLess.compose(set); // or less
        OrMore.compose(set); // or more
        OrOn.compose(set); // or on
        Ordered.compose(set); // ordered
        Overlaps.compose(set); // overlaps
        Parameter.compose(set); // parameter
        Path.compose(set); // path
        Per.compose(set); // per
        Point.compose(set); // point
        Predecessor.compose(set); // predecessor
        Primary.compose(set); // primary
        Private.compose(set); // private
        Properly.compose(set); // properly
        Public.compose(set); // public
        Related.compose(set); // related
        Retrievable.compose(set); // retrievable
        Return.compose(set); // return
        Same.compose(set); // same
        Second.compose(set); // second
        Seconds.compose(set); // seconds
        Singleton.compose(set); // singleton
        Sort.compose(set); // sort
        Start.compose(set); // start
        Starting.compose(set); // starting
        Starts.compose(set); // starts
        Successor.compose(set); // successor
        SuchThat.compose(set); // such that
        Then.compose(set); // then
        Time.compose(set); // time
        Timezoneoffset.compose(set); // timezoneoffset
        To.compose(set); // to
        True.compose(set); // true
        Tuple.compose(set); // Tuple
        Type.compose(set); // type
        Union.compose(set); // union
        Using.compose(set); // using
        Valueset.compose(set); // valueset
        Version.compose(set); // version
        Week.compose(set); // week
        Weeks.compose(set); // weeks
        When.compose(set); // when
        Where.compose(set); // where
        Width.compose(set); // width
        With.compose(set); // with
        Within.compose(set); // within
        Without.compose(set); // without
        Xor.compose(set); // xor
        Year.compose(set); // year
        Years.compose(set); // years
    }
}
