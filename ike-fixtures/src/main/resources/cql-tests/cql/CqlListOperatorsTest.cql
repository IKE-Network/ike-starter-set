library CqlListOperatorsTest version '1.0'

define "simpleSortAsc": ({4, 5, 1, 6, 2, 1}) sL sort asc
define "simpleSortAsc_expected": {1, 1, 2, 4, 5, 6}
define "simpleSortDesc": ({4, 5, 1, 6, 2, 1}) sL sort desc
define "simpleSortDesc_expected": {6, 5, 4, 2, 1, 1}
define "simpleSortStringAsc": ({'back', 'aardvark', 'alligator', 'zebra', 'iguana', 'Wolf', 'Armadillo'}) sls sort asc
define "simpleSortStringAsc_expected": {'Armadillo', 'Wolf', 'aardvark', 'alligator', 'back', 'iguana', 'zebra'}
define "simpleSortStringDesc": ({'back', 'aardvark', 'alligator', 'zebra', 'iguana', 'Wolf', 'Armadillo'}) sls sort desc
define "simpleSortStringDesc_expected": {'zebra', 'iguana', 'back', 'alligator', 'aardvark', 'Wolf', 'Armadillo'}
define "SortDatesAsc": ({ DateTime(2012, 10, 5, 10), DateTime(2012, 1, 1), DateTime(2012, 1, 1, 12), DateTime(2012, 10, 5) }) S sort asc
define "SortDatesAsc_expected": { @2012-01-01T, @2012-01-01T12, @2012-10-05T, @2012-10-05T10 }
define "SortDatesDesc": ({ DateTime(2012, 10, 5, 10), DateTime(2012, 1, 1), DateTime(2012, 1, 1, 12), DateTime(2012, 10, 5) }) S sort desc
define "SortDatesDesc_expected": { @2012-10-05T10, @2012-10-05T, @2012-01-01T12, @2012-01-01T }
define "intList": { 3, 2, 1 }
define "intList_expected": {3, 2, 1}
define "decimalList": { 3.8, 2.4, 1.9 }
define "decimalList_expected": {3.8, 2.4, 1.9}
define "quantityList": { 19.99 '[lb_av]', 17.33 '[lb_av]', 10.66 '[lb_av]' }
define "quantityList_expected": {19.99 '[lb_av]', 17.33 '[lb_av]', 10.66 '[lb_av]'}
define "dateTimeList": { DateTime(2016), DateTime(2015), DateTime(2010) }
define "dateTimeList_expected": {@2016T, @2015T, @2010T}
define "timeList": { @T15:59:59.999, @T15:12:59.999, @T15:12:13.999 }
define "timeList_expected": {@T15:59:59.999, @T15:12:59.999, @T15:12:13.999}
define "ContainsABNullHasNull": { 'a', 'b', null } contains null
define "ContainsABNullHasNull_expected": true
define "ContainsNullFirst": { null, 'b', 'c' } contains 'a'
define "ContainsNullFirst_expected": false
define "ContainsABCHasA": { 'a', 'b', 'c' } contains 'a'
define "ContainsABCHasA_expected": true
define "ContainsJan2012True": { DateTime(2012, 10, 5), DateTime(2012, 9, 5), DateTime(2012, 1, 1) } contains DateTime(2012, 1, 1)
define "ContainsJan2012True_expected": true
define "ContainsJan2012False": { DateTime(2012, 10, 5), DateTime(2012, 9, 5), DateTime(2012, 10, 1) } contains DateTime(2012, 1, 1)
define "ContainsJan2012False_expected": false
define "ContainsTimeTrue": { @T15:59:59.999, @T05:59:59.999, @T20:59:59.999 } contains @T05:59:59.999
define "ContainsTimeTrue_expected": true
define "ContainsTimeFalse": { @T15:59:59.999, @T05:59:59.999, @T20:59:59.999 } contains @T08:59:59.999
define "ContainsTimeFalse_expected": false
define "ContainsNullLeft": null as List<String> contains 'a'
define "ContainsNullLeft_expected": false
define "DescendentsEmptyList": (null).descendents()
define "DescendentsEmptyList_expected": null
define "DistinctEmptyList": distinct {}
define "DistinctEmptyList_expected": {}
define "DistinctNullNullNull": distinct { null, null, null}
define "DistinctNullNullNull_expected": { null }
define "DistinctANullANull": distinct { 'a', null, 'a', null}
define "DistinctANullANull_expected": {'a', null}
define "Distinct112233": distinct { 1, 1, 2, 2, 3, 3}
define "Distinct112233_expected": {1,2,3}
define "Distinct123123": distinct { 1, 2, 3, 1, 2, 3}
define "Distinct123123_expected": {1,2,3}
define "DistinctAABBCC": distinct { 'a', 'a', 'b', 'b', 'c', 'c'}
define "DistinctAABBCC_expected": {'a','b','c'}
define "DistinctABCABC": distinct { 'a', 'b', 'c', 'a', 'b', 'c'}
define "DistinctABCABC_expected": {'a','b','c'}
define "DistinctDateTime": distinct { DateTime(2012, 10, 5), DateTime(2012, 1, 1), DateTime(2012, 1, 1)}
define "DistinctDateTime_expected": { @2012-10-05T, @2012-01-01T }
define "DistinctTime": distinct { @T15:59:59.999, @T20:59:59.999 }
define "DistinctTime_expected": { @T15:59:59.999, @T20:59:59.999 }
define "EqualNullNull": {null} = {null}
define "EqualNullNull_expected": true
define "EqualEmptyListNull": {} as List<String> = null
define "EqualEmptyListNull_expected": null
define "EqualNullEmptyList": null = {} as List<String>
define "EqualNullEmptyList_expected": null
define "EqualEmptyListAndEmptyList": {} = {}
define "EqualEmptyListAndEmptyList_expected": true
define "EqualABCAndABC": { 'a', 'b', 'c' } = { 'a', 'b', 'c' }
define "EqualABCAndABC_expected": true
define "EqualABCAndAB": { 'a', 'b', 'c' } = { 'a', 'b' }
define "EqualABCAndAB_expected": false
define "EqualABCAnd123": { 'a', 'b', 'c' } as List<Any> ~ { 1, 2, 3 } as List<Any>
define "EqualABCAnd123_expected": false
define "Equal123AndABC": { 1, 2, 3 } as List<Any> = { 'a', 'b', 'c' } as List<Any>
define "Equal123AndABC_expected": false
define "Equal123AndString123": { 1, 2, 3 } as List<Any> = { '1', '2', '3' } as List<Any>
define "Equal123AndString123_expected": false
define "Equal12And123": { 1, 2 } = { 1, 2, 3 }
define "Equal12And123_expected": false
define "Equal123And12": { 1, 2, 3 } = { 1, 2 }
define "Equal123And12_expected": false
define "Equal123And123": { 1, 2, 3 } = { 1, 2, 3 }
define "Equal123And123_expected": true
define "EqualDateTimeTrue": {DateTime(2012, 5, 10, 0, 0, 0, 0), DateTime(2014, 12, 10, 0, 0, 0, 0)} = {DateTime(2012, 5, 10, 0, 0, 0, 0), DateTime(2014, 12, 10, 0, 0, 0, 0)}
define "EqualDateTimeTrue_expected": true
define "EqualDateTimeFalse": {DateTime(2012, 5, 10, 0, 0, 0, 0), DateTime(2014, 12, 10, 0, 0, 0, 0)} = {DateTime(2012, 1, 10, 0, 0, 0, 0), DateTime(2014, 12, 10, 0, 0, 0, 0)}
define "EqualDateTimeFalse_expected": false
define "EqualTimeTrue": { @T15:59:59.999, @T20:59:59.999, @T20:59:59.999 } = { @T15:59:59.999, @T20:59:59.999, @T20:59:59.999 }
define "EqualTimeTrue_expected": true
define "EqualTimeFalse": { @T15:59:59.999, @T20:59:59.999, @T20:59:59.999 } = { @T10:59:59.999, @T20:59:59.999, @T20:59:59.999 }
define "EqualTimeFalse_expected": false
define "ExceptEmptyListAndEmptyList": {} except {}
define "ExceptEmptyListAndEmptyList_expected": {}
define "Except1234And23": { 1, 2, 3, 4 } except { 2, 3 }
define "Except1234And23_expected": { 1, 4 }
define "Except23And1234": { 2, 3 } except { 1, 2, 3, 4 }
define "Except23And1234_expected": {}
define "ExceptDateTimeList": { DateTime(2012, 5, 10), DateTime(2014, 12, 10), DateTime(2010, 1, 1)} except {DateTime(2014, 12, 10), DateTime(2010, 1, 1) }
define "ExceptDateTimeList_expected": {@2012-05-10T}
define "ExceptTimeList": { @T15:59:59.999, @T20:59:59.999, @T12:59:59.999 } except { @T20:59:59.999, @T12:59:59.999 }
define "ExceptTimeList_expected": {@T15:59:59.999}
define "ExceptNullRight": { 1, 4 } except null
define "ExceptNullRight_expected": {1, 4}
define "ExistsEmpty": Exists({})
define "ExistsEmpty_expected": false
define "ExistsListNull": Exists({ null })
define "ExistsListNull_expected": false
define "Exists1": Exists({ 1 })
define "Exists1_expected": true
define "Exists12": Exists({ 1, 2 })
define "Exists12_expected": true
define "ExistsDateTime": Exists({ DateTime(2012, 5, 10), DateTime(2014, 12, 10) })
define "ExistsDateTime_expected": true
define "ExistsTime": Exists({ @T15:59:59.999, @T20:59:59.999 })
define "ExistsTime_expected": true
define "ExistsNull": Exists(null)
define "ExistsNull_expected": false
define "FlattenEmpty": Flatten({{},{}})
define "FlattenEmpty_expected": {}
define "FlattenListNullAndNull": Flatten({{null}, {null}})
define "FlattenListNullAndNull_expected": {null, null}
define "FlattenList12And34": Flatten({{1,2}, {3,4}})
define "FlattenList12And34_expected": {1,2,3,4}
define "FlattenDateTime": Flatten({ {DateTime(2012, 5, 10)}, {DateTime(2014, 12, 10)} })
define "FlattenDateTime_expected": { @2012-05-10T, @2014-12-10T }
define "FlattenTime": Flatten({ {@T15:59:59.999}, {@T20:59:59.999} })
define "FlattenTime_expected": { @T15:59:59.999, @T20:59:59.999 }
define "FirstEmpty": First({})
define "FirstEmpty_expected": null
define "FirstNull1": First({ null, 1 })
define "FirstNull1_expected": null
define "First1Null": First({ 1, null })
define "First1Null_expected": 1
define "First12": First({ 1, 2 })
define "First12_expected": 1
define "FirstDateTime": First({ DateTime(2012, 5, 10), DateTime(2014, 12, 10) })
define "FirstDateTime_expected": @2012-05-10T
define "FirstTime": First({ @T15:59:59.999, @T20:59:59.999 })
define "FirstTime_expected": @T15:59:59.999
define "InNullEmpty": null in {}
define "InNullEmpty_expected": false
define "InNullAnd1Null": null in { 1, null }
define "InNullAnd1Null_expected": true
define "In1Null": 1 in null as List<Integer>
define "In1Null_expected": false
define "In1And12": 1 in { 1, 2 }
define "In1And12_expected": true
define "In3And12": 3 in { 1, 2 }
define "In3And12_expected": false
define "InDateTimeTrue": DateTime(2012, 5, 10) in { DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10) }
define "InDateTimeTrue_expected": true
define "InDateTimeFalse": DateTime(2012, 6, 10) in { DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10) }
define "InDateTimeFalse_expected": false
define "InTimeTrue": @T15:59:59.999 in { @T02:29:15.156, @T15:59:59.999, @T20:59:59.999 }
define "InTimeTrue_expected": true
define "InTimeFalse": @T16:59:59.999 in { @T02:29:15.156, @T15:59:59.999, @T20:59:59.999 }
define "InTimeFalse_expected": false
define "IncludesEmptyAndEmpty": {} includes {}
define "IncludesEmptyAndEmpty_expected": true
define "IncludesListNullAndListNull": {null} includes {null}
define "IncludesListNullAndListNull_expected": true
define "Includes123AndEmpty": {1, 2, 3} includes {}
define "Includes123AndEmpty_expected": true
define "Includes123And2": {1, 2, 3} includes {2}
define "Includes123And2_expected": true
define "Includes123And4": {1, 2, 3} includes {4}
define "Includes123And4_expected": false
define "IncludesDateTimeTrue": {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)} includes {DateTime(2012, 5, 10)}
define "IncludesDateTimeTrue_expected": true
define "IncludesDateTimeFalse": {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)} includes {DateTime(2012, 5, 11)}
define "IncludesDateTimeFalse_expected": false
define "IncludesTimeTrue": { @T02:29:15.156, @T15:59:59.999, @T20:59:59.999 } includes @T15:59:59.999
define "IncludesTimeTrue_expected": true
define "IncludesTimeFalse": { @T02:29:15.156, @T15:59:59.999, @T20:59:59.999 } includes @T16:59:59.999
define "IncludesTimeFalse_expected": false
define "IncludesNullLeft": null as List<Integer> includes {2}
define "IncludesNullLeft_expected": null
define "IncludesNullRight": {'s', 'a', 'm'} includes null as List<String>
define "IncludesNullRight_expected": null
define "IncludedInEmptyAndEmpty": {} included in {}
define "IncludedInEmptyAndEmpty_expected": true
define "IncludedInListNullAndListNull": { null } included in { null }
define "IncludedInListNullAndListNull_expected": true
define "IncludedInEmptyAnd123": {} included in { 1, 2, 3 }
define "IncludedInEmptyAnd123_expected": true
define "IncludedIn2And123": { 2 } included in { 1, 2, 3 }
define "IncludedIn2And123_expected": true
define "IncludedIn4And123": { 4 } included in { 1, 2, 3 }
define "IncludedIn4And123_expected": false
define "IncludedInDateTimeTrue": { DateTime(2012, 5, 10)} included in {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)}
define "IncludedInDateTimeTrue_expected": true
define "IncludedInDateTimeFalse": {DateTime(2012, 5, 11)} included in {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)}
define "IncludedInDateTimeFalse_expected": false
define "IncludedInTimeTrue": @T15:59:59.999 included in { @T02:29:15.156, @T15:59:59.999, @T20:59:59.999 }
define "IncludedInTimeTrue_expected": true
define "IncludedInTimeFalse": @T16:59:59.999 included in { @T02:29:15.156, @T15:59:59.999, @T20:59:59.999 }
define "IncludedInTimeFalse_expected": false
define "IncludedInNullLeft": null as List<Integer> included in {2}
define "IncludedInNullLeft_expected": null
define "IncludedInNullRight": {'s', 'a', 'm'} included in null as List<String>
define "IncludedInNullRight_expected": null
define "IndexerNull1List": (null as List<System.Any>)[1]
define "IndexerNull1List_expected": null
define "Indexer0Of12": { 1, 2 }[0]
define "Indexer0Of12_expected": 1
define "Indexer1Of12": { 1, 2 }[1]
define "Indexer1Of12_expected": 2
define "Indexer2Of12": { 1, 2 }[2]
define "Indexer2Of12_expected": null
define "IndexerNeg1Of12": { 1, 2 }[-1]
define "IndexerNeg1Of12_expected": null
define "IndexerDateTime": { DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10) }[1]
define "IndexerDateTime_expected": @2012-05-10T
define "IndexerTime": { @T02:29:15.156, @T15:59:59.999, @T20:59:59.999 }[1]
define "IndexerTime_expected": @T15:59:59.999
define "IndexOfEmptyNull": IndexOf({}, null)
define "IndexOfEmptyNull_expected": null
define "IndexOfNullEmpty": IndexOf(null, {})
define "IndexOfNullEmpty_expected": null
define "IndexOfNullIn1Null": IndexOf({ 1, null }, null)
define "IndexOfNullIn1Null_expected": null
define "IndexOf1In12": IndexOf({ 1, 2 }, 1)
define "IndexOf1In12_expected": 0
define "IndexOf2In12": IndexOf({ 1, 2 }, 2)
define "IndexOf2In12_expected": 1
define "IndexOf3In12": IndexOf({ 1, 2 }, 3)
define "IndexOf3In12_expected": -1
define "IndexOfDateTime": IndexOf({ DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10) }, DateTime(2014, 12, 10))
define "IndexOfDateTime_expected": 2
define "IndexOfTime": IndexOf({ @T02:29:15.156, @T15:59:59.999, @T20:59:59.999 }, @T15:59:59.999)
define "IndexOfTime_expected": 1
define "IntersectEmptyListAndEmptyList": {} intersect {}
define "IntersectEmptyListAndEmptyList_expected": {}
define "Intersect1234And23": { 1, 2, 3, 4 } intersect { 2, 3 }
define "Intersect1234And23_expected": { 2, 3 }
define "Intersect23And1234": {2, 3} intersect { 1, 2, 3, 4 }
define "Intersect23And1234_expected": { 2, 3 }
define "IntersectDateTime": { DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10) } intersect { DateTime(2012, 5, 10), DateTime(2014, 12, 10), DateTime(2000, 5, 5) }
define "IntersectDateTime_expected": {@2012-05-10T, @2014-12-10T}
define "IntersectTime": { @T02:29:15.156, @T15:59:59.999, @T20:59:59.999 } intersect { @T01:29:15.156, @T15:59:59.999, @T20:59:59.999 }
define "IntersectTime_expected": {@T15:59:59.999, @T20:59:59.999}
define "LastEmpty": Last({})
define "LastEmpty_expected": null
define "LastNull1": Last({null, 1})
define "LastNull1_expected": 1
define "Last1Null": Last({1, null})
define "Last1Null_expected": null
define "Last12": Last({1, 2})
define "Last12_expected": 2
define "LastDateTime": Last({DateTime(2012, 5, 10), DateTime(2014, 12, 10)})
define "LastDateTime_expected": @2014-12-10T
define "LastTime": Last({ @T15:59:59.999, @T20:59:59.999 })
define "LastTime_expected": @T20:59:59.999
define "LengthEmptyList": Length({})
define "LengthEmptyList_expected": 0
define "LengthNull1": Length({null, 1})
define "LengthNull1_expected": 2
define "Length1Null": Length({1, null})
define "Length1Null_expected": 2
define "Length12": Length({1, 2})
define "Length12_expected": 2
define "LengthDateTime": Length({DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)})
define "LengthDateTime_expected": 3
define "LengthTime": Length({ @T15:59:59.999, @T20:59:59.999, @T15:59:59.999, @T20:59:59.999, @T15:59:59.999, @T20:59:59.999 })
define "LengthTime_expected": 6
define "LengthNullList": Length(null as List<Any>)
define "LengthNullList_expected": 0
define "EquivalentEmptyAndEmpty": {} ~ {}
define "EquivalentEmptyAndEmpty_expected": true
define "EquivalentABCAndABC": { 'a', 'b', 'c' } ~ { 'a', 'b', 'c' }
define "EquivalentABCAndABC_expected": true
define "EquivalentABCAndAB": { 'a', 'b', 'c' } ~ { 'a', 'b' }
define "EquivalentABCAndAB_expected": false
define "EquivalentABCAnd123": { 'a', 'b', 'c' } as List<Any> ~ { 1, 2, 3 } as List<Any>
define "EquivalentABCAnd123_expected": false
define "Equivalent123AndABC": { 1, 2, 3 } as List<Any> ~ { 'a', 'b', 'c' } as List<Any>
define "Equivalent123AndABC_expected": false
define "Equivalent123AndString123": { 1, 2, 3 } as List<Any> ~ { '1', '2', '3' } as List<Any>
define "Equivalent123AndString123_expected": false
define "EquivalentDateTimeTrue": {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10), null} ~ {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10), null}
define "EquivalentDateTimeTrue_expected": true
define "EquivalentDateTimeNull": {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)} ~ {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10), null}
define "EquivalentDateTimeNull_expected": false
define "EquivalentDateTimeFalse": {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)} ~ {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 1)}
define "EquivalentDateTimeFalse_expected": false
define "EquivalentTimeTrue": { @T15:59:59.999, @T20:59:59.999 } ~ { @T15:59:59.999, @T20:59:59.999 }
define "EquivalentTimeTrue_expected": true
define "EquivalentTimeNull": { @T15:59:59.999, @T20:59:59.999 } ~ { @T15:59:59.999, @T20:59:59.999, null }
define "EquivalentTimeNull_expected": false
define "EquivalentTimeFalse": { @T15:59:59.999, @T20:59:59.999 } ~ { @T15:59:59.999, @T20:59:59.995 }
define "EquivalentTimeFalse_expected": false
define "NotEqualEmptyAndEmpty": {} != {}
define "NotEqualEmptyAndEmpty_expected": false
define "NotEqualABCAndABC": { 'a', 'b', 'c' } != { 'a', 'b', 'c' }
define "NotEqualABCAndABC_expected": false
define "NotEqualABCAndAB": { 'a', 'b', 'c' } != { 'a', 'b' }
define "NotEqualABCAndAB_expected": true
define "NotEqualABCAnd123": { 'a', 'b', 'c' } as List<Any> != { 1, 2, 3 } as List<Any>
define "NotEqualABCAnd123_expected": true
define "NotEqual123AndABC": { 1, 2, 3 } as List<Any> != { 'a', 'b', 'c' } as List<Any>
define "NotEqual123AndABC_expected": true
define "NotEqual123AndString123": { 1, 2, 3 } as List<Any> != { '1', '2', '3' } as List<Any>
define "NotEqual123AndString123_expected": true
define "NotEqualDateTimeTrue": {DateTime(2001, 9, 11, 0, 0, 0, 0), DateTime(2012, 5, 10, 0, 0, 0, 0), DateTime(2014, 12, 10, 0, 0, 0, 0)} != {DateTime(2001, 9, 11, 0, 0, 0, 0), DateTime(2012, 5, 10, 0, 0, 0, 0), DateTime(2014, 12, 1, 0, 0, 0, 0)}
define "NotEqualDateTimeTrue_expected": true
define "NotEqualDateTimeFalse": {DateTime(2001, 9, 11, 0, 0, 0, 0), DateTime(2012, 5, 10, 0, 0, 0, 0), DateTime(2014, 12, 10, 0, 0, 0, 0)} != {DateTime(2001, 9, 11, 0, 0, 0, 0), DateTime(2012, 5, 10, 0, 0, 0, 0), DateTime(2014, 12, 10, 0, 0, 0, 0)}
define "NotEqualDateTimeFalse_expected": false
define "NotEqualTimeTrue": { @T15:59:59.999, @T20:59:59.999 } = { @T15:59:59.999, @T20:59:59.999 }
define "NotEqualTimeTrue_expected": true
define "NotEqualTimeFalse": { @T15:59:59.999, @T20:59:59.999 } = { @T15:59:59.999, @T20:59:49.999 }
define "NotEqualTimeFalse_expected": false
define "ProperContains1": null as List<String> properly includes 'a'
define "ProperContains1_expected": false
define "ProperContains2": {} properly includes 'a'
define "ProperContains2_expected": false
define "ProperContains3": { 'a' } properly includes 'a'
define "ProperContains3_expected": false
define "ProperContains4": { null } properly includes null as String
define "ProperContains4_expected": false
define "ProperContainsNullRightFalse": {'s', 'u', 'n'} properly includes null as String
define "ProperContainsNullRightFalse_expected": false
define "ProperContains5": { null, null } properly includes null as String
define "ProperContains5_expected": true
define "ProperContainsNullRightTrue": {'s', 'u', 'n', null} properly includes null as String
define "ProperContainsNullRightTrue_expected": true
define "ProperContains6": { 'a', 'b' } properly includes 'a'
define "ProperContains6_expected": true
define "ProperContains7": { 'a', 'a' } properly includes 'a'
define "ProperContains7_expected": true
define "ProperContains8": { 'a', 'b' } properly includes 'c'
define "ProperContains8_expected": false
define "ProperContains9": { 'a', null } properly includes 'a'
define "ProperContains9_expected": true
define "ProperContains10": { 'a', 'b', null } properly includes 'a'
define "ProperContains10_expected": true
define "ProperContainsTimeTrue": { @T15:59:59, @T20:59:59.999, @T20:59:49.999 } properly includes @T15:59:59
define "ProperContainsTimeTrue_expected": true
define "ProperContainsTimeNull": { @T15:59:59.999, @T20:59:59.999, @T20:59:49.999 } properly includes @T15:59:59
define "ProperContainsTimeNull_expected": false
define "ProperIn1": 'a' properly included in null as List<String>
define "ProperIn1_expected": false
define "ProperIn2": 'a' properly included in {}
define "ProperIn2_expected": false
define "ProperIn3": 'a' properly included in { 'a' }
define "ProperIn3_expected": false
define "ProperIn4": null as String properly included in { null }
define "ProperIn4_expected": false
define "ProperInNullRightFalse": null as String properly included in {'s', 'u', 'n'}
define "ProperInNullRightFalse_expected": false
define "ProperIn5": null as String properly included in { null, null }
define "ProperIn5_expected": true
define "ProperInNullRightTrue": null properly included in {'s', 'u', 'n', null}
define "ProperInNullRightTrue_expected": true
define "ProperIn6": 'a' properly included in { 'a', 'b' }
define "ProperIn6_expected": true
define "ProperIn7": 'a' properly included in { 'a', 'a' }
define "ProperIn7_expected": true
define "ProperIn8": 'c' properly included in { 'a', 'b' }
define "ProperIn8_expected": false
define "ProperIn9": 'a' properly included in { 'a', null }
define "ProperIn9_expected": true
define "ProperIn10": 'a' properly included in { 'a', 'b', null }
define "ProperIn10_expected": true
define "ProperInTimeTrue": @T15:59:59 properly included in { @T15:59:59, @T20:59:59.999, @T20:59:49.999 }
define "ProperInTimeTrue_expected": true
define "ProperInTimeNull": @T15:59:59 properly included in { @T15:59:59.999, @T20:59:59.999, @T20:59:49.999 }
define "ProperInTimeNull_expected": false
define "ProperIncludesEmptyAndEmpty": {} properly includes {}
define "ProperIncludesEmptyAndEmpty_expected": false
define "ProperIncludesListNullAndListNull": {null} properly includes {null}
define "ProperIncludesListNullAndListNull_expected": false
define "ProperIncludes123AndEmpty": {1, 2, 3} properly includes {}
define "ProperIncludes123AndEmpty_expected": true
define "ProperIncludes123And2": {1, 2, 3} properly includes {2}
define "ProperIncludes123And2_expected": true
define "ProperIncludes123And4": {1, 2, 3} properly includes {4}
define "ProperIncludes123And4_expected": false
define "ProperIncludesDateTimeTrue": {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)} properly includes {DateTime(2012, 5, 10), DateTime(2014, 12, 10)}
define "ProperIncludesDateTimeTrue_expected": true
define "ProperIncludesDateTimeFalse": {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)} properly includes {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)}
define "ProperIncludesDateTimeFalse_expected": false
define "ProperIncludesTimeTrue": { @T15:59:59.999, @T20:59:59.999, @T20:59:49.999 } properly includes { @T15:59:59.999, @T20:59:59.999 }
define "ProperIncludesTimeTrue_expected": true
define "ProperIncludesTimeFalse": { @T15:59:59.999, @T20:59:59.999, @T20:59:49.999 } properly includes { @T15:59:59.999, @T20:59:59.999, @T14:59:22.999 }
define "ProperIncludesTimeFalse_expected": false
define "ProperlyIncludesNullLeft": null as List<Integer> properly includes {2}
define "ProperlyIncludesNullLeft_expected": null
define "ProperIncludedInEmptyAndEmpty": {} properly included in {}
define "ProperIncludedInEmptyAndEmpty_expected": false
define "ProperIncludedInListNullAndListNull": {null} properly included in {null}
define "ProperIncludedInListNullAndListNull_expected": false
define "ProperIncludedInEmptyAnd123": {} properly included in {1, 2, 3}
define "ProperIncludedInEmptyAnd123_expected": true
define "ProperIncludedIn2And123": {2} properly included in {1, 2, 3}
define "ProperIncludedIn2And123_expected": true
define "ProperIncludedIn4And123": {4} properly included in {1, 2, 3}
define "ProperIncludedIn4And123_expected": false
define "ProperIncludedInDateTimeTrue": {DateTime(2012, 5, 10), DateTime(2014, 12, 10)} properly included in {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)}
define "ProperIncludedInDateTimeTrue_expected": true
define "ProperIncludedInDateTimeFalse": {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)} properly included in {DateTime(2001, 9, 11), DateTime(2012, 5, 10), DateTime(2014, 12, 10)}
define "ProperIncludedInDateTimeFalse_expected": false
define "ProperIncludedInTimeTrue": { @T15:59:59.999, @T20:59:59.999 } properly included in { @T15:59:59.999, @T20:59:59.999, @T20:59:49.999 }
define "ProperIncludedInTimeTrue_expected": true
define "ProperIncludedInTimeFalse": { @T15:59:59.999, @T20:59:59.999, @T14:59:22.999 } properly included in { @T15:59:59.999, @T20:59:59.999, @T20:59:49.999 }
define "ProperIncludedInTimeFalse_expected": false
define "ProperlyIncludedInNulRight": {'s', 'u', 'n'} properly included in null as List<String>
define "ProperlyIncludedInNulRight_expected": null
define "SingletonFromEmpty": singleton from {}
define "SingletonFromEmpty_expected": null
define "SingletonFromListNull": singleton from {null}
define "SingletonFromListNull_expected": null
define "SingletonFrom1": singleton from { 1 }
define "SingletonFrom1_expected": 1
define "SingletonFromDateTime": singleton from { DateTime(2012, 5, 10) }
define "SingletonFromDateTime_expected": @2012-05-10T
define "SingletonFromTime": singleton from { @T15:59:59.999 }
define "SingletonFromTime_expected": @T15:59:59.999
define "SkipNull": Skip(null, 3)
define "SkipNull_expected": null
define "SkipEven": Skip({1,2,3,4,5}, 2)
define "SkipEven_expected": {3, 4, 5}
define "SkipOdd": Skip({1,2,3,4,5}, 3)
define "SkipOdd_expected": {4, 5}
define "SkipNone": Skip({1,2,3,4,5}, 0)
define "SkipNone_expected": {1,2,3,4,5}
define "SkipAll": Skip({1,2,3,4,5}, 5)
define "SkipAll_expected": {}
define "TailNull": Tail(null)
define "TailNull_expected": null
define "TailEven": Tail({1,2,3,4})
define "TailEven_expected": {2,3,4}
define "TailOdd": Tail({1,2,3,4,5})
define "TailOdd_expected": {2,3,4,5}
define "TailEmpty": Tail({})
define "TailEmpty_expected": {}
define "TailOneElement": Tail({1})
define "TailOneElement_expected": {}
define "TakeNull": Take(null, 3)
define "TakeNull_expected": null
define "TakeNullEmpty": Take({1,2,3}, null as Integer)
define "TakeNullEmpty_expected": {}
define "TakeEmpty": Take({1,2,3}, 0)
define "TakeEmpty_expected": {}
define "TakeEven": Take({1,2,3,4}, 2)
define "TakeEven_expected": {1, 2}
define "TakeOdd": Take({1,2,3,4}, 3)
define "TakeOdd_expected": {1, 2, 3}
define "TakeAll": Take({1,2,3,4}, 4)
define "TakeAll_expected": {1, 2, 3, 4}
define "UnionEmptyAndEmpty": {} union {}
define "UnionEmptyAndEmpty_expected": {}
define "UnionListNullAndListNull": { null } union { null }
define "UnionListNullAndListNull_expected": {null}
define "Union123AndEmpty": { 1, 2, 3 } union {}
define "Union123AndEmpty_expected": {1, 2, 3}
define "Union123And2": { 1, 2, 3 } union { 2 }
define "Union123And2_expected": {1, 2, 3}
define "Union123And4": { 1, 2, 3 } union { 4 }
define "Union123And4_expected": {1, 2, 3, 4}
define "UnionDateTime": { DateTime(2001, 9, 11)} union {DateTime(2012, 5, 10), DateTime(2014, 12, 10) }
define "UnionDateTime_expected": {@2001-09-11T, @2012-05-10T, @2014-12-10T}
define "UnionTime": { @T15:59:59.999, @T20:59:59.999, @T12:59:59.999 } union { @T10:59:59.999 }
define "UnionTime_expected": {@T15:59:59.999, @T20:59:59.999, @T12:59:59.999, @T10:59:59.999}
