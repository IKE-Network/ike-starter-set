library CqlIntervalOperatorsTest version '1.0'

define "TestAfterNull": (null as Integer) after Interval[1, 10]
define "TestAfterNull_expected": null
define "IntegerIntervalAfterTrue": Interval[11, 20] after Interval[1, 10]
define "IntegerIntervalAfterTrue_expected": true
define "IntegerIntervalAfterFalse": Interval[1, 10] after Interval[11, 20]
define "IntegerIntervalAfterFalse_expected": false
define "IntegerIntervalPointAfterTrue": 12 after Interval[1, 10]
define "IntegerIntervalPointAfterTrue_expected": true
define "IntegerIntervalPointAfterFalse": 9 after Interval[1, 10]
define "IntegerIntervalPointAfterFalse_expected": false
define "IntegerIntervalAfterPointTrue": Interval[11, 20] after 5
define "IntegerIntervalAfterPointTrue_expected": true
define "IntegerIntervalAfterPointFalse": Interval[11, 20] after 12
define "IntegerIntervalAfterPointFalse_expected": false
define "DecimalIntervalAfterTrue": Interval[11.0, 20.0] after Interval[1.0, 10.0]
define "DecimalIntervalAfterTrue_expected": true
define "DecimalIntervalAfterFalse": Interval[1.0, 10.0] after Interval[11.0, 20.0]
define "DecimalIntervalAfterFalse_expected": false
define "DecimalIntervalPointAfterTrue": 12.0 after Interval[1.0, 10.0]
define "DecimalIntervalPointAfterTrue_expected": true
define "DecimalIntervalPointAfterFalse": 9.0 after Interval[1.0, 10.0]
define "DecimalIntervalPointAfterFalse_expected": false
define "DecimalIntervalAfterPointTrue": Interval[11.0, 20.0] after 5.0
define "DecimalIntervalAfterPointTrue_expected": true
define "DecimalIntervalAfterPointFalse": Interval[11.0, 20.0] after 12.0
define "DecimalIntervalAfterPointFalse_expected": false
define "QuantityIntervalAfterTrue": Interval[11.0 'g', 20.0 'g'] after Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalAfterTrue_expected": true
define "QuantityIntervalAfterFalse": Interval[1.0 'g', 10.0 'g'] after Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalAfterFalse_expected": false
define "QuantityIntervalPointAfterTrue": 12.0'g' after Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalPointAfterTrue_expected": true
define "QuantityIntervalPointAfterFalse": 9.0'g' after Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalPointAfterFalse_expected": false
define "QuantityIntervalAfterPointTrue": Interval[11.0 'g', 20.0 'g'] after 5.0'g'
define "QuantityIntervalAfterPointTrue_expected": true
define "QuantityIntervalAfterPointFalse": Interval[11.0 'g', 20.0 'g'] after 12.0'g'
define "QuantityIntervalAfterPointFalse_expected": false
define "DateTimeAfterTrue": Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 15)] after DateTime(2011, 12, 31)
define "DateTimeAfterTrue_expected": true
define "DateTimeAfterFalse": Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 15)] after DateTime(2012, 12, 31)
define "DateTimeAfterFalse_expected": false
define "TimeAfterTrue": Interval[@T15:59:59.999, @T20:59:59.999] after @T12:59:59.999
define "TimeAfterTrue_expected": true
define "TimeAfterFalse": Interval[@T15:59:59.999, @T20:59:59.999] after @T17:59:59.999
define "TimeAfterFalse_expected": false
define "TestBeforeNull": (null as Integer) before Interval[1, 10]
define "TestBeforeNull_expected": null
define "IntegerIntervalBeforeFalse": Interval[11, 20] before Interval[1, 10]
define "IntegerIntervalBeforeFalse_expected": false
define "IntegerIntervalBeforeTrue": Interval[1, 10] before Interval[11, 20]
define "IntegerIntervalBeforeTrue_expected": true
define "IntegerIntervalPointBeforeTrue": 9 before Interval[11, 20]
define "IntegerIntervalPointBeforeTrue_expected": true
define "IntegerIntervalPointBeforeFalse": 9 before Interval[1, 10]
define "IntegerIntervalPointBeforeFalse_expected": false
define "IntegerIntervalBeforePointTrue": Interval[1, 10] before 11
define "IntegerIntervalBeforePointTrue_expected": true
define "IntegerIntervalBeforePointFalse": Interval[1, 10] before 8
define "IntegerIntervalBeforePointFalse_expected": false
define "DecimalIntervalBeforeFalse": Interval[11.0, 20.0] before Interval[1.0, 10.0]
define "DecimalIntervalBeforeFalse_expected": false
define "DecimalIntervalBeforeTrue": Interval[1.0, 10.0] before Interval[11.0, 20.0]
define "DecimalIntervalBeforeTrue_expected": true
define "DecimalIntervalPointBeforeTrue": 9.0 before Interval[11.0, 20.0]
define "DecimalIntervalPointBeforeTrue_expected": true
define "DecimalIntervalPointBeforeFalse": 9.0 before Interval[1.0, 10.0]
define "DecimalIntervalPointBeforeFalse_expected": false
define "DecimalIntervalBeforePointTrue": Interval[1.0, 10.0] before 11.0
define "DecimalIntervalBeforePointTrue_expected": true
define "DecimalIntervalBeforePointFalse": Interval[1.0, 10.0] before 8.0
define "DecimalIntervalBeforePointFalse_expected": false
define "QuantityIntervalBeforeTrue": Interval[1.0 'g', 10.0 'g'] before Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalBeforeTrue_expected": true
define "QuantityIntervalBeforeFalse": Interval[11.0 'g', 20.0 'g'] before Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalBeforeFalse_expected": false
define "QuantityIntervalPointBeforeTrue": Interval[1.0 'g', 10.0 'g'] before 12.0'g'
define "QuantityIntervalPointBeforeTrue_expected": true
define "QuantityIntervalPointBeforeFalse": Interval[1.0 'g', 10.0 'g'] before 9.0'g'
define "QuantityIntervalPointBeforeFalse_expected": false
define "QuantityIntervalBeforePointTrue": 5.0'g' before Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalBeforePointTrue_expected": true
define "QuantityIntervalBeforePointFalse": 12.0'g' before Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalBeforePointFalse_expected": false
define "DateTimeBeforeTrue": Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 15)] before DateTime(2012, 2, 27)
define "DateTimeBeforeTrue_expected": true
define "DateTimeBeforeFalse": Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 15)] before DateTime(2011, 12, 31)
define "DateTimeBeforeFalse_expected": false
define "TimeBeforeTrue": Interval[@T15:59:59.999, @T20:59:59.999] before @T22:59:59.999
define "TimeBeforeTrue_expected": true
define "TimeBeforeFalse": Interval[@T15:59:59.999, @T20:59:59.999] before @T10:59:59.999
define "TimeBeforeFalse_expected": false
define "TestCollapseNull": collapse {Interval(null, null)}
define "TestCollapseNull_expected": { }
define "IntegerIntervalCollapse": collapse { Interval[1,5], Interval[3,7], Interval[12,19], Interval[7,10] }
define "IntegerIntervalCollapse_expected": {Interval [ 1, 10 ], Interval [ 12, 19 ]}
define "IntegerIntervalCollapse2": collapse { Interval[1,2], Interval[3,7], Interval[10,19], Interval[7,10] }
define "IntegerIntervalCollapse2_expected": {Interval [ 1, 19 ]}
define "IntegerIntervalCollapse3": collapse { Interval[4,6], Interval[7,8] }
define "IntegerIntervalCollapse3_expected": {Interval [ 4, 8 ]}
define "DecimalIntervalCollapse": collapse { Interval[1.0,5.0], Interval[3.0,7.0], Interval[12.0,19.0], Interval[7.0,10.0] }
define "DecimalIntervalCollapse_expected": {Interval [ 1.0, 10.0 ], Interval [ 12.0, 19.0 ]}
define "DecimalIntervalCollapse2": collapse { Interval[4.0,6.0], Interval[6.00000001,8.0] }
define "DecimalIntervalCollapse2_expected": {Interval [ 4.0, 8.0 ]}
define "QuantityIntervalCollapse": collapse { Interval[1.0 'g',5.0 'g'], Interval[3.0 'g',7.0 'g'], Interval[12.0 'g',19.0 'g'], Interval[7.0 'g',10.0 'g'] }
define "QuantityIntervalCollapse_expected": {Interval [ 1.0 'g', 10.0 'g' ], Interval [ 12.0 'g', 19.0 'g' ]}
define "DateTimeCollapse": collapse { Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 15)], Interval[DateTime(2012, 1, 10), DateTime(2012, 1, 25)], Interval[DateTime(2012, 5, 10), DateTime(2012, 5, 25)], Interval[DateTime(2012, 5, 20), DateTime(2012, 5, 30)] }
define "DateTimeCollapse_expected": {Interval [ @2012-01-01T, @2012-01-25T ], Interval [ @2012-05-10T, @2012-05-30T ]}
define "DateTimeCollapse2": collapse { Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 15)], Interval[DateTime(2012, 1, 16), DateTime(2012, 5, 25)] }
define "DateTimeCollapse2_expected": {Interval [ @2012-01-01T, @2012-05-25T ]}
define "TimeCollapse": collapse { Interval[@T01:59:59.999, @T10:59:59.999], Interval[@T08:59:59.999, @T15:59:59.999], Interval[@T17:59:59.999, @T20:59:59.999], Interval[@T18:59:59.999, @T22:59:59.999] }
define "TimeCollapse_expected": {Interval [ @T01:59:59.999, @T15:59:59.999 ], Interval [ @T17:59:59.999, @T22:59:59.999 ]}
define "TimeCollapse2": collapse { Interval[@T01:59:59.999, @T10:59:59.999], Interval[@T11:00:00.000, @T15:59:59.999] }
define "TimeCollapse2_expected": {Interval [ @T01:59:59.999, @T15:59:59.999 ]}
define "ExpandNull": expand null
define "ExpandNull_expected": null
define "ExpandEmptyList": expand { }
define "ExpandEmptyList_expected": { }
define "ExpandListWithNull": expand { null }
define "ExpandListWithNull_expected": { }
define "ExpandPerDay": expand { Interval[@2018-01-01, @2018-01-04] } per day
define "ExpandPerDay_expected": { Interval[@2018-01-01, @2018-01-01], Interval[@2018-01-02, @2018-01-02], Interval[@2018-01-03, @2018-01-03], Interval[@2018-01-04, @2018-01-04] }
define "ExpandPerDayIntervalOverload": expand Interval[@2018-01-01, @2018-01-04] per day
define "ExpandPerDayIntervalOverload_expected": { @2018-01-01, @2018-01-02, @2018-01-03, @2018-01-04 }
define "ExpandPer2Days": expand { Interval[@2018-01-01, @2018-01-04] } per 2 days
define "ExpandPer2Days_expected": { Interval[@2018-01-01, @2018-01-02], Interval[@2018-01-03, @2018-01-04] }
define "ExpandPer2DaysIntervalOverload": expand Interval[@2018-01-01, @2018-01-04] per 2 days
define "ExpandPer2DaysIntervalOverload_expected": { @2018-01-01, @2018-01-03 }
define "ExpandPerHour": expand { Interval[@T10:00, @T12:30] } per hour
define "ExpandPerHour_expected": { Interval[@T10, @T10], Interval[@T11, @T11], Interval[@T12, @T12] }
define "ExpandPerHourIntervalOverload": expand Interval[@T10:00, @T12:30] per hour
define "ExpandPerHourIntervalOverload_expected": { @T10, @T11, @T12 }
define "ExpandPerHourOpen": expand { Interval[@T10:00, @T12:30) } per hour
define "ExpandPerHourOpen_expected": { Interval[@T10, @T10], Interval[@T11, @T11], Interval[@T12, @T12] }
define "ExpandPerHourOpenIntervalOverload": expand Interval[@T10:00, @T12:30) per hour
define "ExpandPerHourOpenIntervalOverload_expected": { @T10, @T11, @T12 }
define "ExpandPer1": expand { Interval[10.0, 12.5] } per 1
define "ExpandPer1_expected": { Interval[10, 10], Interval[11, 11], Interval[12, 12] }
define "ExpandPer1IntervalOverload": expand Interval[10.0, 12.5] per 1
define "ExpandPer1IntervalOverload_expected": { 10, 11, 12 }
define "ExpandPer1Open": expand { Interval[10.0, 12.5) } per 1
define "ExpandPer1Open_expected": { Interval[10, 10], Interval[11, 11], Interval[12, 12] }
define "ExpandPer1OpenIntervalOverload": expand Interval[10.0, 12.5) per 1
define "ExpandPer1OpenIntervalOverload_expected": { 10, 11, 12 }
define "ExpandPerMinute": expand { Interval[@T10, @T10] } per minute
define "ExpandPerMinute_expected": { }
define "ExpandPerMinuteIntervalOverload": expand Interval[@T10, @T10] per minute
define "ExpandPerMinuteIntervalOverload_expected": { }
define "ExpandPer0D1": expand { Interval[10, 10] } per 0.1
define "ExpandPer0D1_expected": { Interval[10.0, 10.0], Interval[10.1, 10.1], Interval[10.2, 10.2], Interval[10.3, 10.3], Interval[10.4, 10.4], Interval[10.5, 10.5], Interval[10.6, 10.6], Interval[10.7, 10.7], Interval[10.8, 10.8], Interval[10.9, 10.9] }
define "ExpandPer0D1IntervalOverload": expand Interval[10, 10] per 0.1
define "ExpandPer0D1IntervalOverload_expected": { 10.0, 10.1, 10.2, 10.3, 10.4, 10.5, 10.6, 10.7, 10.8, 10.9 }
define "ExpandInterval": expand { Interval[1, 10] }
define "ExpandInterval_expected": { Interval[1, 1], Interval[2, 2], Interval[3, 3], Interval[4, 4], Interval[5, 5], Interval[6, 6], Interval[7, 7], Interval[8, 8], Interval[9, 9], Interval[10, 10] }
define "ExpandIntegerIntervalOverload": expand Interval[1, 10]
define "ExpandIntegerIntervalOverload_expected": { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }
define "ExpandIntervalOpen": expand { Interval[1, 10) }
define "ExpandIntervalOpen_expected": { Interval[1, 1], Interval[2, 2], Interval[3, 3], Interval[4, 4], Interval[5, 5], Interval[6, 6], Interval[7, 7], Interval[8, 8], Interval[9, 9] }
define "ExpandIntegerOpenIntervalOverload": expand Interval[1, 10)
define "ExpandIntegerOpenIntervalOverload_expected": { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
define "ExpandIntervalPer2": expand { Interval[1, 10] } per 2
define "ExpandIntervalPer2_expected": { Interval[1, 2], Interval[3, 4], Interval[5, 6], Interval[7, 8], Interval[9, 10] }
define "ExpandIntervalPer2IntervalOverload": expand Interval[1, 10] per 2
define "ExpandIntervalPer2IntervalOverload_expected": { 1, 3, 5, 7, 9 }
define "ExpandIntervalOpenPer2": expand { Interval[1, 10) } per 2
define "ExpandIntervalOpenPer2_expected": { Interval[1, 2], Interval[3, 4], Interval[5, 6], Interval[7, 8] }
define "ExpandIntervalOpenPer2IntervalOverload": expand Interval[1, 10) per 2
define "ExpandIntervalOpenPer2IntervalOverload_expected": { 1, 3, 5, 7 }
define "TestContainsNull": Interval[1, 10] contains null
define "TestContainsNull_expected": null
define "TestNullElement1": null as Interval<Integer> contains 5
define "TestNullElement1_expected": false
define "TestNullElement2": Interval[null, 5] contains 10
define "TestNullElement2_expected": false
define "IntegerIntervalContainsTrue": Interval[1, 10] contains 5
define "IntegerIntervalContainsTrue_expected": true
define "IntegerIntervalContainsFalse": Interval[1, 10] contains 25
define "IntegerIntervalContainsFalse_expected": false
define "DecimalIntervalContainsTrue": Interval[1.0, 10.0] contains 8.0
define "DecimalIntervalContainsTrue_expected": true
define "DecimalIntervalContainsFalse": Interval[1.0, 10.0] contains 255.0
define "DecimalIntervalContainsFalse_expected": false
define "QuantityIntervalContainsTrue": Interval[1.0 'g', 10.0 'g'] contains 2.0 'g'
define "QuantityIntervalContainsTrue_expected": true
define "QuantityIntervalContainsFalse": Interval[1.0 'g', 10.0 'g'] contains 100.0 'g'
define "QuantityIntervalContainsFalse_expected": false
define "DateTimeContainsTrue": Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 15)] contains DateTime(2012, 1, 10)
define "DateTimeContainsTrue_expected": true
define "DateTimeContainsFalse": Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 15)] contains DateTime(2012, 1, 16)
define "DateTimeContainsFalse_expected": false
define "TimeContainsTrue": Interval[@T01:59:59.999, @T10:59:59.999] contains @T05:59:59.999
define "TimeContainsTrue_expected": true
define "TimeContainsFalse": Interval[@T01:59:59.999, @T10:59:59.999] contains @T15:59:59.999
define "TimeContainsFalse_expected": false
define "IntegerIntervalEnd": end of Interval[1, 10]
define "IntegerIntervalEnd_expected": 10
define "DecimalIntervalEnd": end of Interval[1.0, 10.0]
define "DecimalIntervalEnd_expected": 10.0
define "QuantityIntervalEnd": end of Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalEnd_expected": 10.0'g'
define "DateTimeIntervalEnd": end of Interval[@2016-05-01T00:00:00.000, @2016-05-02T00:00:00.000]
define "DateTimeIntervalEnd_expected": @2016-05-02T00:00:00.000
define "TimeIntervalEnd": end of Interval[@T00:00:00.000, @T23:59:59.599]
define "TimeIntervalEnd_expected": @T23:59:59.599
define "TestEndsNull": Interval[1, 10] ends Interval(null, null)
define "TestEndsNull_expected": null
define "IntegerIntervalEndsTrue": Interval[4, 10] ends Interval[1, 10]
define "IntegerIntervalEndsTrue_expected": true
define "IntegerIntervalEndsFalse": Interval[44, 50] ends Interval[1, 10]
define "IntegerIntervalEndsFalse_expected": false
define "DecimalIntervalEndsTrue": Interval[4.0, 10.0] ends Interval[1.0, 10.0]
define "DecimalIntervalEndsTrue_expected": true
define "DecimalIntervalEndsFalse": Interval[11.0, 20.0] ends Interval[1.0, 10.0]
define "DecimalIntervalEndsFalse_expected": false
define "QuantityIntervalEndsTrue": Interval[5.0 'g', 10.0 'g'] ends Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalEndsTrue_expected": true
define "QuantityIntervalEndsFalse": Interval[11.0 'g', 20.0 'g'] ends Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalEndsFalse_expected": false
define "DateTimeEndsTrue": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 15)] ends Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 15)]
define "DateTimeEndsTrue_expected": true
define "DateTimeEndsFalse": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 15)] ends Interval[DateTime(2012, 1, 1), DateTime(2012, 1, 16)]
define "DateTimeEndsFalse_expected": false
define "TimeEndsTrue": Interval[@T05:59:59.999, @T10:59:59.999] ends Interval[@T01:59:59.999, @T10:59:59.999]
define "TimeEndsTrue_expected": true
define "TimeEndsFalse": Interval[@T05:59:59.999, @T10:59:59.999] ends Interval[@T01:59:59.999, @T11:59:59.999]
define "TimeEndsFalse_expected": false
define "TestEqualNull": Interval[1, 10] = Interval(null, null)
define "TestEqualNull_expected": null
define "IntegerIntervalEqualTrue": Interval[1, 10] = Interval[1, 10]
define "IntegerIntervalEqualTrue_expected": true
define "IntegerIntervalEqualFalse": Interval[1, 10] = Interval[11, 20]
define "IntegerIntervalEqualFalse_expected": false
define "DecimalIntervalEqualTrue": Interval[1.0, 10.0] = Interval[1.0, 10.0]
define "DecimalIntervalEqualTrue_expected": true
define "DecimalIntervalEqualFalse": Interval[1.0, 10.0] = Interval[11.0, 20.0]
define "DecimalIntervalEqualFalse_expected": false
define "QuantityIntervalEqualTrue": Interval[1.0 'g', 10.0 'g'] = Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalEqualTrue_expected": true
define "QuantityIntervalEqualFalse": Interval[1.0 'g', 10.0 'g'] = Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalEqualFalse_expected": false
define "DateTimeEqualTrue": Interval[DateTime(2012, 1, 5, 0, 0, 0, 0), DateTime(2012, 1, 15, 0, 0, 0, 0)] = Interval[DateTime(2012, 1, 5, 0, 0, 0, 0), DateTime(2012, 1, 15, 0, 0, 0, 0)]
define "DateTimeEqualTrue_expected": true
define "DateTimeEqualFalse": Interval[DateTime(2012, 1, 5, 0, 0, 0, 0), DateTime(2012, 1, 15, 0, 0, 0, 0)] = Interval[DateTime(2012, 1, 5, 0, 0, 0, 0), DateTime(2012, 1, 16, 0, 0, 0, 0)]
define "DateTimeEqualFalse_expected": false
define "TimeEqualTrue": Interval[@T05:59:59.999, @T10:59:59.999] = Interval[@T05:59:59.999, @T10:59:59.999]
define "TimeEqualTrue_expected": true
define "TimeEqualFalse": Interval[@T05:59:59.999, @T10:59:59.999] = Interval[@T05:59:59.999, @T10:58:59.999]
define "TimeEqualFalse_expected": false
define "TestExceptNull": Interval[null, null] except Interval[null, null]
define "TestExceptNull_expected": null
define "IntegerIntervalExcept1to3": Interval[1, 10] except Interval[4, 10]
define "IntegerIntervalExcept1to3_expected": Interval [ 1, 3 ]
define "IntegerIntervalExceptNull": Interval[1, 10] except Interval[3, 7]
define "IntegerIntervalExceptNull_expected": null
define "DecimalIntervalExcept1to3": Interval[1.0, 10.0] except Interval[4.0, 10.0]
define "DecimalIntervalExcept1to3_expected": Interval [ 1.0, 3.99999999 ]
define "DecimalIntervalExceptNull": Interval[1.0, 10.0] except Interval[3.0, 7.0]
define "DecimalIntervalExceptNull_expected": null
define "QuantityIntervalExcept1to4": Interval[1.0 'g', 10.0 'g'] except Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalExcept1to4_expected": Interval [ 1.0 'g', 4.99999999 'g' ]
define "Except12": Interval[1, 4] except Interval[3, 6]
define "Except12_expected": Interval [ 1, 2 ]
define "ExceptDateTimeInterval": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 15)] except Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 15)]
define "ExceptDateTimeInterval_expected": Interval [ @2012-01-05T, @2012-01-06T ]
define "ExceptDateTime2": Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 16)] except Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 12)]
define "ExceptDateTime2_expected": Interval [ @2012-01-13T, @2012-01-16T ]
define "ExceptTimeInterval": Interval[@T05:59:59.999, @T10:59:59.999] except Interval[@T08:59:59.999, @T10:59:59.999]
define "ExceptTimeInterval_expected": Interval [ @T05:59:59.999, @T08:59:59.998 ]
define "ExceptTime2": Interval[@T08:59:59.999, @T11:59:59.999] except Interval[@T05:59:59.999, @T10:59:59.999]
define "ExceptTime2_expected": Interval [ @T11:00:00.000, @T11:59:59.999 ]
define "TestInNullBoundaries": 5 in Interval[null, null]
define "TestInNullBoundaries_expected": false
define "IntegerIntervalInTrue": 5 in Interval[1, 10]
define "IntegerIntervalInTrue_expected": true
define "IntegerIntervalInFalse": 500 in Interval[1, 10]
define "IntegerIntervalInFalse_expected": false
define "DecimalIntervalInTrue": 9.0 in Interval[1.0, 10.0]
define "DecimalIntervalInTrue_expected": true
define "DecimalIntervalInFalse": -2.0 in Interval[1.0, 10.0]
define "DecimalIntervalInFalse_expected": false
define "QuantityIntervalInTrue": 1.0 'g' in Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalInTrue_expected": true
define "QuantityIntervalInFalse": 55.0 'g' in Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalInFalse_expected": false
define "DateTimeInTrue": DateTime(2012, 1, 7) in Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 15)]
define "DateTimeInTrue_expected": true
define "DateTimeInFalse": DateTime(2012, 1, 17) in Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 15)]
define "DateTimeInFalse_expected": false
define "DateTimeInNullTrue": DateTime(2012, 1, 7) in Interval[DateTime(2012, 1, 5), null]
define "DateTimeInNullTrue_expected": true
define "TimeInTrue": @T07:59:59.999 in Interval[@T05:59:59.999, @T10:59:59.999]
define "TimeInTrue_expected": true
define "TimeInFalse": @T17:59:59.999 in Interval[@T05:59:59.999, @T10:59:59.999]
define "TimeInFalse_expected": false
define "TimeInNull": null in Interval[@T05:59:59.999, @T10:59:59.999]
define "TimeInNull_expected": null
define "TestPeriod1": Interval[@2017-12-20T11:00:00, @2017-12-21T21:00:00]
define "TestPeriod1_expected": Interval [ @2017-12-20T11:00:00, @2017-12-21T21:00:00 ]
define "TestPeriod2": Interval[@2017-12-20T10:30:00, @2017-12-20T12:00:00]
define "TestPeriod2_expected": Interval [ @2017-12-20T10:30:00, @2017-12-20T12:00:00 ]
define "Issue32Interval": Interval[@2017-12-20T10:30:00, @2017-12-20T12:00:00]
				starts 1 day or less on or after day of start of
				Interval[@2017-12-20T11:00:00, @2017-12-21T21:00:00]
define "Issue32Interval_expected": true
define "TestIncludesNull": Interval[1, 10] includes null
define "TestIncludesNull_expected": null
define "IntegerIntervalIncludesTrue": Interval[1, 10] includes Interval[4, 10]
define "IntegerIntervalIncludesTrue_expected": true
define "IntegerIntervalIncludesFalse": Interval[1, 10] includes Interval[44, 50]
define "IntegerIntervalIncludesFalse_expected": false
define "DecimalIntervalIncludesTrue": Interval[1.0, 10.0] includes Interval[4.0, 10.0]
define "DecimalIntervalIncludesTrue_expected": true
define "DecimalIntervalIncludesFalse": Interval[1.0, 10.0] includes Interval[11.0, 20.0]
define "DecimalIntervalIncludesFalse_expected": false
define "QuantityIntervalIncludesTrue": Interval[1.0 'g', 10.0 'g'] includes Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalIncludesTrue_expected": true
define "QuantityIntervalIncludesFalse": Interval[1.0 'g', 10.0 'g'] includes Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalIncludesFalse_expected": false
define "DateTimeIncludesTrue": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 15)] includes Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)]
define "DateTimeIncludesTrue_expected": true
define "DateTimeIncludesFalse": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 15)] includes Interval[DateTime(2012, 1, 4), DateTime(2012, 1, 14)]
define "DateTimeIncludesFalse_expected": false
define "TimeIncludesTrue": Interval[@T05:59:59.999, @T10:59:59.999] includes Interval[@T06:59:59.999, @T09:59:59.999]
define "TimeIncludesTrue_expected": true
define "TimeIncludesFalse": Interval[@T05:59:59.999, @T10:59:59.999] includes Interval[@T04:59:59.999, @T09:59:59.999]
define "TimeIncludesFalse_expected": false
define "TestIncludedInNull": null included in Interval[1, 10]
define "TestIncludedInNull_expected": null
define "IntegerIntervalIncludedInTrue": Interval[4, 10] included in Interval[1, 10]
define "IntegerIntervalIncludedInTrue_expected": true
define "IntegerIntervalIncludedInFalse": Interval[44, 50] included in Interval[1, 10]
define "IntegerIntervalIncludedInFalse_expected": false
define "DecimalIntervalIncludedInTrue": Interval[4.0, 10.0] included in Interval[1.0, 10.0]
define "DecimalIntervalIncludedInTrue_expected": true
define "DecimalIntervalIncludedInFalse": Interval[11.0, 20.0] included in Interval[1.0, 10.0]
define "DecimalIntervalIncludedInFalse_expected": false
define "QuantityIntervalIncludedInTrue": Interval[5.0 'g', 10.0 'g'] included in Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalIncludedInTrue_expected": true
define "QuantityIntervalIncludedInFalse": Interval[11.0 'g', 20.0 'g'] included in Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalIncludedInFalse_expected": false
define "DateTimeIncludedInTrue": Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)] included in Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 15)]
define "DateTimeIncludedInTrue_expected": true
define "DateTimeIncludedInFalse": Interval[DateTime(2012, 1, 4), DateTime(2012, 1, 14)] included in Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 15)]
define "DateTimeIncludedInFalse_expected": false
define "TimeIncludedInTrue": Interval[@T06:59:59.999, @T09:59:59.999] included in Interval[@T05:59:59.999, @T10:59:59.999]
define "TimeIncludedInTrue_expected": true
define "TimeIncludedInFalse": Interval[@T04:59:59.999, @T09:59:59.999] included in Interval[@T05:59:59.999, @T10:59:59.999]
define "TimeIncludedInFalse_expected": false
define "DateTimeIncludedInNull": Interval [@2017-09-01T00:00:00, @2017-09-01T00:00:00] included in Interval [@2017-09-01T00:00:00.000, @2017-12-30T23:59:59.999]
define "DateTimeIncludedInNull_expected": null
define "DateTimeIncludedInPrecisionTrue": Interval [@2017-09-01T00:00:00, @2017-09-01T00:00:00] included in day of Interval [@2017-09-01T00:00:00.000, @2017-12-30T23:59:59.999]
define "DateTimeIncludedInPrecisionTrue_expected": true
define "DateTimeIncludedInPrecisionNull": Interval [@2017-09-01T00:00:00, @2017-09-01T00:00:00] included in millisecond of Interval [@2017-09-01T00:00:00.000, @2017-12-30T23:59:59.999]
define "DateTimeIncludedInPrecisionNull_expected": null
define "TestIntersectNull": Interval[1, 10] intersect Interval[5, null)
define "TestIntersectNull_expected": Interval[5, null)
define "TestIntersectNull1": start of (Interval[1, 10] intersect Interval[5, null)) <= 10
define "TestIntersectNull1_expected": true
define "TestIntersectNull2": start of (Interval[1, 10] intersect Interval[5, null)) >= 5
define "TestIntersectNull2_expected": true
define "TestIntersectNull3": start of (Interval[1, 10] intersect Interval[5, null)) > 10
define "TestIntersectNull3_expected": false
define "TestIntersectNull4": start of (Interval[1, 10] intersect Interval[5, null)) < 5
define "TestIntersectNull4_expected": false
define "IntegerIntervalIntersectTest4to10": Interval[1, 10] intersect Interval[4, 10]
define "IntegerIntervalIntersectTest4to10_expected": Interval [ 4, 10 ]
define "IntegerIntervalIntersectTestNull": Interval[1, 10] intersect Interval[11, 20]
define "IntegerIntervalIntersectTestNull_expected": null
define "DecimalIntervalIntersectTest4to10": Interval[1.0, 10.0] intersect Interval[4.0, 10.0]
define "DecimalIntervalIntersectTest4to10_expected": Interval [ 4.0, 10.0 ]
define "DecimalIntervalIntersectTestNull": Interval[1.0, 10.0] intersect Interval[11.0, 20.0]
define "DecimalIntervalIntersectTestNull_expected": null
define "QuantityIntervalIntersectTest5to10": Interval[1.0 'g', 10.0 'g'] intersect Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalIntersectTest5to10_expected": Interval [ 5.0 'g', 10.0 'g' ]
define "QuantityIntervalIntersectTestNull": Interval[1.0 'g', 10.0 'g'] intersect Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalIntersectTestNull_expected": null
define "DateTimeIntersect": Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)] intersect Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 10)]
define "DateTimeIntersect_expected": Interval [ @2012-01-07T, @2012-01-10T ]
define "TimeIntersect": Interval[@T04:59:59.999, @T09:59:59.999] intersect Interval[@T04:59:59.999, @T06:59:59.999]
define "TimeIntersect_expected": Interval [ @T04:59:59.999, @T06:59:59.999 ]
define "IntegerIntervalEquivalentTrue": Interval[1, 10] ~ Interval[1, 10]
define "IntegerIntervalEquivalentTrue_expected": true
define "IntegerIntervalEquivalentFalse": Interval[44, 50] ~ Interval[1, 10]
define "IntegerIntervalEquivalentFalse_expected": false
define "DecimalIntervalEquivalentTrue": Interval[1.0, 10.0] ~ Interval[1.0, 10.0]
define "DecimalIntervalEquivalentTrue_expected": true
define "DecimalIntervalEquivalentFalse": Interval[11.0, 20.0] ~ Interval[1.0, 10.0]
define "DecimalIntervalEquivalentFalse_expected": false
define "QuantityIntervalEquivalentTrue": Interval[1.0 'g', 10.0 'g'] ~ Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalEquivalentTrue_expected": true
define "QuantityIntervalEquivalentFalse": Interval[11.0 'g', 20.0 'g'] ~ Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalEquivalentFalse_expected": false
define "DateTimeEquivalentTrue": Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)] ~ Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)]
define "DateTimeEquivalentTrue_expected": true
define "DateTimeEquivalentFalse": Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)] ~ Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 15)]
define "DateTimeEquivalentFalse_expected": false
define "TimeEquivalentTrue": Interval[@T04:59:59.999, @T09:59:59.999] ~ Interval[@T04:59:59.999, @T09:59:59.999]
define "TimeEquivalentTrue_expected": true
define "TimeEquivalentFalse": Interval[@T04:59:59.999, @T09:59:59.999] ~ Interval[@T04:58:59.999, @T09:59:59.999]
define "TimeEquivalentFalse_expected": false
define "TestMeetsNull": Interval(null, 5] meets Interval(null, 15)
define "TestMeetsNull_expected": null
define "IntegerIntervalMeetsTrue": Interval[1, 10] meets Interval[11, 20]
define "IntegerIntervalMeetsTrue_expected": true
define "IntegerIntervalMeetsFalse": Interval[1, 10] meets Interval[44, 50]
define "IntegerIntervalMeetsFalse_expected": false
define "DecimalIntervalMeetsTrue": Interval[3.01, 5.00000001] meets Interval[5.00000002, 8.50]
define "DecimalIntervalMeetsTrue_expected": true
define "DecimalIntervalMeetsFalse": Interval[3.01, 5.00000001] meets Interval[5.5, 8.50]
define "DecimalIntervalMeetsFalse_expected": false
define "QuantityIntervalMeetsTrue": Interval[3.01 'g', 5.00000001 'g'] meets Interval[5.00000002 'g', 8.50 'g']
define "QuantityIntervalMeetsTrue_expected": true
define "QuantityIntervalMeetsFalse": Interval[3.01 'g', 5.00000001 'g'] meets Interval[5.5 'g', 8.50 'g']
define "QuantityIntervalMeetsFalse_expected": false
define "DateTimeMeetsTrue": Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)] meets Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 25)]
define "DateTimeMeetsTrue_expected": true
define "DateTimeMeetsFalse": Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)] meets Interval[DateTime(2012, 1, 20), DateTime(2012, 1, 25)]
define "DateTimeMeetsFalse_expected": false
define "TimeMeetsTrue": Interval[@T04:59:59.999, @T09:59:59.999] meets Interval[@T10:00:00.000, @T19:59:59.999]
define "TimeMeetsTrue_expected": true
define "TimeMeetsFalse": Interval[@T04:59:59.999, @T09:59:59.999] meets Interval[@T10:12:00.000, @T19:59:59.999]
define "TimeMeetsFalse_expected": false
define "TestMeetsBeforeNull": Interval(null, 5] meets before Interval(null, 25]
define "TestMeetsBeforeNull_expected": null
define "IntegerIntervalMeetsBeforeTrue": Interval[1, 10] meets before Interval[11, 20]
define "IntegerIntervalMeetsBeforeTrue_expected": true
define "IntegerIntervalMeetsBeforeFalse": Interval[1, 10] meets before Interval[44, 50]
define "IntegerIntervalMeetsBeforeFalse_expected": false
define "DecimalIntervalMeetsBeforeTrue": Interval[3.50000001, 5.00000011] meets before Interval[5.00000012, 8.50]
define "DecimalIntervalMeetsBeforeTrue_expected": true
define "DecimalIntervalMeetsBeforeFalse": Interval[8.01, 15.00000001] meets before Interval[15.00000000, 18.50]
define "DecimalIntervalMeetsBeforeFalse_expected": false
define "QuantityIntervalMeetsBeforeTrue": Interval[3.50000001 'g', 5.00000011 'g'] meets before Interval[5.00000012 'g', 8.50 'g']
define "QuantityIntervalMeetsBeforeTrue_expected": true
define "QuantityIntervalMeetsBeforeFalse": Interval[8.01 'g', 15.00000001 'g'] meets before Interval[15.00000000 'g', 18.50 'g']
define "QuantityIntervalMeetsBeforeFalse_expected": false
define "DateTimeMeetsBeforeTrue": Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)] meets Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 25)]
define "DateTimeMeetsBeforeTrue_expected": true
define "DateTimeMeetsBeforeFalse": Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)] meets Interval[DateTime(2012, 1, 20), DateTime(2012, 1, 25)]
define "DateTimeMeetsBeforeFalse_expected": false
define "TimeMeetsBeforeTrue": Interval[@T04:59:59.999, @T09:59:59.999] meets Interval[@T10:00:00.000, @T19:59:59.999]
define "TimeMeetsBeforeTrue_expected": true
define "TimeMeetsBeforeFalse": Interval[@T04:59:59.999, @T09:59:59.999] meets Interval[@T10:12:00.000, @T19:59:59.999]
define "TimeMeetsBeforeFalse_expected": false
define "TestMeetsAfterNull": Interval(null, 5] meets after Interval[11, null)
define "TestMeetsAfterNull_expected": false
define "IntegerIntervalMeetsAfterTrue": Interval[11, 20] meets after Interval[1, 10]
define "IntegerIntervalMeetsAfterTrue_expected": true
define "IntegerIntervalMeetsAfterFalse": Interval[44, 50] meets after Interval[1, 10]
define "IntegerIntervalMeetsAfterFalse_expected": false
define "DecimalIntervalMeetsAfterTrue": Interval[55.00000123, 128.032156] meets after Interval[12.00258, 55.00000122]
define "DecimalIntervalMeetsAfterTrue_expected": true
define "DecimalIntervalMeetsAfterFalse": Interval[55.00000124, 150.222222] meets after Interval[12.00258, 55.00000122]
define "DecimalIntervalMeetsAfterFalse_expected": false
define "QuantityIntervalMeetsAfterTrue": Interval[55.00000123 'g', 128.032156 'g'] meets after Interval[12.00258 'g', 55.00000122 'g']
define "QuantityIntervalMeetsAfterTrue_expected": true
define "QuantityIntervalMeetsAfterFalse": Interval[55.00000124 'g', 150.222222 'g'] meets after Interval[12.00258 'g', 55.00000122 'g']
define "QuantityIntervalMeetsAfterFalse_expected": false
define "DateTimeMeetsAfterTrue": Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 25)] meets Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)]
define "DateTimeMeetsAfterTrue_expected": true
define "DateTimeMeetsAfterFalse": Interval[DateTime(2012, 1, 20), DateTime(2012, 1, 25)] meets Interval[DateTime(2012, 1, 7), DateTime(2012, 1, 14)]
define "DateTimeMeetsAfterFalse_expected": false
define "TimeMeetsAfterTrue": Interval[@T10:00:00.000, @T19:59:59.999] meets Interval[@T04:59:59.999, @T09:59:59.999]
define "TimeMeetsAfterTrue_expected": true
define "TimeMeetsAfterFalse": Interval[@T10:12:00.000, @T19:59:59.999] meets Interval[@T04:59:59.999, @T09:59:59.999]
define "TimeMeetsAfterFalse_expected": false
define "IntegerIntervalNotEqualTrue": Interval[1, 10] != Interval[11, 20]
define "IntegerIntervalNotEqualTrue_expected": true
define "IntegerIntervalNotEqualFalse": Interval[1, 10] != Interval[1, 10]
define "IntegerIntervalNotEqualFalse_expected": false
define "DecimalIntervalNotEqualTrue": Interval[1.0, 10.0] != Interval[11.0, 20.0]
define "DecimalIntervalNotEqualTrue_expected": true
define "DecimalIntervalNotEqualFalse": Interval[1.0, 10.0] != Interval[1.0, 10.0]
define "DecimalIntervalNotEqualFalse_expected": false
define "QuantityIntervalNotEqualTrue": Interval[1.0 'g', 10.0 'g'] != Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalNotEqualTrue_expected": true
define "QuantityIntervalNotEqualFalse": Interval[1.0 'g', 10.0 'g'] != Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalNotEqualFalse_expected": false
define "DateTimeNotEqualTrue": Interval[DateTime(2012, 1, 15, 0, 0, 0, 0), DateTime(2012, 1, 25, 0, 0, 0, 0)] != Interval[DateTime(2012, 1, 15, 0, 0, 0, 0), DateTime(2012, 1, 25, 0, 0, 0, 22)]
define "DateTimeNotEqualTrue_expected": true
define "DateTimeNotEqualFalse": Interval[DateTime(2012, 1, 15, 0, 0, 0, 0), DateTime(2012, 1, 25, 0, 0, 0, 0)] != Interval[DateTime(2012, 1, 15, 0, 0, 0, 0), DateTime(2012, 1, 25, 0, 0, 0, 0)]
define "DateTimeNotEqualFalse_expected": false
define "TimeNotEqualTrue": Interval[@T10:00:00.000, @T19:59:59.999] != Interval[@T10:10:00.000, @T19:59:59.999]
define "TimeNotEqualTrue_expected": true
define "TimeNotEqualFalse": Interval[@T10:00:00.000, @T19:59:59.999] != Interval[@T10:00:00.000, @T19:59:59.999]
define "TimeNotEqualFalse_expected": false
define "TestOnOrAfterNull": Interval[@2012-12-01, @2013-12-01] on or after (null as Interval<Date>)
define "TestOnOrAfterNull_expected": null
define "TestOnOrAfterDateTrue": Interval[@2012-12-01, @2013-12-01] on or after month of @2012-11-15
define "TestOnOrAfterDateTrue_expected": true
define "TestOnOrAfterDateFalse": @2012-11-15 on or after month of Interval[@2012-12-01, @2013-12-01]
define "TestOnOrAfterDateFalse_expected": false
define "TestOnOrAfterTimeTrue": Interval[@T10:00:00.000, @T19:59:59.999] on or after hour of Interval[@T08:00:00.000, @T09:59:59.999]
define "TestOnOrAfterTimeTrue_expected": true
define "TestOnOrAfterTimeFalse": Interval[@T10:00:00.000, @T19:59:59.999] on or after hour of Interval[@T08:00:00.000, @T11:59:59.999]
define "TestOnOrAfterTimeFalse_expected": false
define "TestOnOrAfterIntegerTrue": Interval[6, 10] on or after 6
define "TestOnOrAfterIntegerTrue_expected": true
define "TestOnOrAfterDecimalFalse": 2.5 on or after Interval[1.666, 2.50000001]
define "TestOnOrAfterDecimalFalse_expected": false
define "TestOnOrAfterQuantityTrue": 2.5 'mg' on or after Interval[1.666 'mg', 2.50000000 'mg']
define "TestOnOrAfterQuantityTrue_expected": true
define "TestOnOrBeforeNull": Interval[@2012-12-01, @2013-12-01] on or before (null as Interval<Date>)
define "TestOnOrBeforeNull_expected": null
define "TestOnOrBeforeDateTrue": Interval[@2012-10-01, @2012-11-01] on or before month of @2012-11-15
define "TestOnOrBeforeDateTrue_expected": true
define "TestOnOrBeforeDateFalse": @2012-11-15 on or before month of Interval[@2012-10-01, @2013-12-01]
define "TestOnOrBeforeDateFalse_expected": false
define "TestOnOrBeforeTimeTrue": Interval[@T05:00:00.000, @T07:59:59.999] on or before hour of Interval[@T08:00:00.000, @T09:59:59.999]
define "TestOnOrBeforeTimeTrue_expected": true
define "TestOnOrBeforeTimeFalse": Interval[@T10:00:00.000, @T19:59:59.999] on or before hour of Interval[@T08:00:00.000, @T11:59:59.999]
define "TestOnOrBeforeTimeFalse_expected": false
define "TestOnOrBeforeIntegerTrue": Interval[4, 6] on or before 6
define "TestOnOrBeforeIntegerTrue_expected": true
define "TestOnOrBeforeDecimalFalse": 1.6667 on or before Interval[1.666, 2.50000001]
define "TestOnOrBeforeDecimalFalse_expected": false
define "TestOnOrBeforeQuantityTrue": 1.666 'mg' on or before Interval[1.666 'mg', 2.50000000 'mg']
define "TestOnOrBeforeQuantityTrue_expected": true
define "TestOverlapsNull": Interval[null, null] overlaps Interval[1, 10]
define "TestOverlapsNull_expected": null
define "IntegerIntervalOverlapsTrue": Interval[1, 10] overlaps Interval[4, 10]
define "IntegerIntervalOverlapsTrue_expected": true
define "IntegerIntervalOverlapsTrue2": Interval[4, 10] overlaps Interval[4, 10]
define "IntegerIntervalOverlapsTrue2_expected": true
define "IntegerIntervalOverlapsTrue3": Interval[10, 15] overlaps Interval[4, 10]
define "IntegerIntervalOverlapsTrue3_expected": true
define "IntegerIntervalOverlapsFalse": Interval[1, 10] overlaps Interval[11, 20]
define "IntegerIntervalOverlapsFalse_expected": false
define "IntegerIntervalExclusiveOverlapsTrue": Interval[4, 10) overlaps Interval[4, 10)
define "IntegerIntervalExclusiveOverlapsTrue_expected": true
define "IntegerIntervalExclusiveOverlapsTrue2": Interval[4, 11) overlaps Interval[10, 20]
define "IntegerIntervalExclusiveOverlapsTrue2_expected": true
define "IntegerIntervalExclusiveOverlapsTrue3": Interval[4, 10] overlaps Interval(9, 20]
define "IntegerIntervalExclusiveOverlapsTrue3_expected": true
define "IntegerIntervalExclusiveOverlapsTrue4": Interval[4, 11) overlaps Interval(9, 20]
define "IntegerIntervalExclusiveOverlapsTrue4_expected": true
define "IntegerIntervalExclusiveOverlapsFalse": Interval[4, 10] overlaps Interval(10, 20]
define "IntegerIntervalExclusiveOverlapsFalse_expected": false
define "IntegerIntervalExclusiveOverlapsFalse2": Interval[4, 10) overlaps Interval[10, 20]
define "IntegerIntervalExclusiveOverlapsFalse2_expected": false
define "IntegerIntervalExclusiveOverlapsFalse3": Interval[4, 10) overlaps Interval(10, 20]
define "IntegerIntervalExclusiveOverlapsFalse3_expected": false
define "IntegerIntervalExclusiveOverlapsFalse4": Interval[4, 10) overlaps Interval(9, 20]
define "IntegerIntervalExclusiveOverlapsFalse4_expected": false
define "DecimalIntervalOverlapsTrue": Interval[1.0, 10.0] overlaps Interval[4.0, 10.0]
define "DecimalIntervalOverlapsTrue_expected": true
define "DecimalIntervalOverlapsFalse": Interval[1.0, 10.0] overlaps Interval[11.0, 20.0]
define "DecimalIntervalOverlapsFalse_expected": false
define "QuantityIntervalOverlapsTrue": Interval[1.0 'g', 10.0 'g'] overlaps Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalOverlapsTrue_expected": true
define "QuantityIntervalOverlapsFalse": Interval[1.0 'g', 10.0 'g'] overlaps Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalOverlapsFalse_expected": false
define "DateTimeOverlapsTrue": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)] overlaps Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 28)]
define "DateTimeOverlapsTrue_expected": true
define "DateTimeOverlapsFalse": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)] overlaps Interval[DateTime(2012, 1, 26), DateTime(2012, 1, 28)]
define "DateTimeOverlapsFalse_expected": false
define "DateTimeOverlapsPrecisionLeftPossiblyStartsDuringRight": Interval[DateTime(2012, 2, 25), DateTime(2012, 3, 26)] overlaps Interval[DateTime(2012, 1, 10), DateTime(2012, 2)]
define "DateTimeOverlapsPrecisionLeftPossiblyStartsDuringRight_expected": null
define "DateTimeOverlapsPrecisioLeftPossiblyEndsDuringRight": Interval[DateTime(2012, 1, 25), DateTime(2012, 2, 26)] overlaps Interval[DateTime(2012, 2), DateTime(2012, 3, 28)]
define "DateTimeOverlapsPrecisioLeftPossiblyEndsDuringRight_expected": null
define "DateTimeOverlapsPrecisionLeftPossiblyStartsAndEndsDuringRight": Interval[DateTime(2012, 2), DateTime(2012, 3)] overlaps Interval[DateTime(2011, 1, 10), DateTime(2012)]
define "DateTimeOverlapsPrecisionLeftPossiblyStartsAndEndsDuringRight_expected": null
define "DateTimeOverlapsPrecisionRightPossiblyStartsDuringLeftButEndsDuringLeft": Interval[DateTime(2012), DateTime(2013, 3)] overlaps Interval[DateTime(2012, 2), DateTime(2013, 2)]
define "DateTimeOverlapsPrecisionRightPossiblyStartsDuringLeftButEndsDuringLeft_expected": true
define "DateTimeOverlapsPrecisionRightStartsDuringLeftAndPossiblyEndsDuringLeft": Interval[DateTime(2012, 2), DateTime(2013)] overlaps Interval[DateTime(2012, 3), DateTime(2013, 2)]
define "DateTimeOverlapsPrecisionRightStartsDuringLeftAndPossiblyEndsDuringLeft_expected": true
define "TimeOverlapsTrue": Interval[@T10:00:00.000, @T19:59:59.999] overlaps Interval[@T12:00:00.000, @T21:59:59.999]
define "TimeOverlapsTrue_expected": true
define "TimeOverlapsFalse": Interval[@T10:00:00.000, @T19:59:59.999] overlaps Interval[@T20:00:00.000, @T21:59:59.999]
define "TimeOverlapsFalse_expected": false
define "TestOverlapsBeforeNull": Interval[null, null] overlaps before Interval[1, 10]
define "TestOverlapsBeforeNull_expected": null
define "IntegerIntervalOverlapsBeforeTrue": Interval[1, 10] overlaps before Interval[4, 10]
define "IntegerIntervalOverlapsBeforeTrue_expected": true
define "IntegerIntervalOverlapsBeforeFalse": Interval[4, 10] overlaps before Interval[1, 10]
define "IntegerIntervalOverlapsBeforeFalse_expected": false
define "IntegerIntervalOverlapsBeforeFalse2": Interval[4, 10] overlaps before Interval[4, 10]
define "IntegerIntervalOverlapsBeforeFalse2_expected": false
define "IntegerIntervalExclusiveOverlapsBeforeTrue": Interval[4, 10] overlaps before Interval(4, 10]
define "IntegerIntervalExclusiveOverlapsBeforeTrue_expected": true
define "IntegerIntervalExclusiveOverlapsBeforeTrue2": Interval(3, 10] overlaps before Interval(4, 10]
define "IntegerIntervalExclusiveOverlapsBeforeTrue2_expected": true
define "IntegerIntervalExclusiveOverlapsBeforeTrue3": Interval(3, 10] overlaps before Interval[5, 10]
define "IntegerIntervalExclusiveOverlapsBeforeTrue3_expected": true
define "IntegerIntervalExclusiveOverlapsBeforeFalse": Interval(3, 10] overlaps before Interval(3, 10]
define "IntegerIntervalExclusiveOverlapsBeforeFalse_expected": false
define "IntegerIntervalExclusiveOverlapsBeforeFalse2": Interval(3, 10] overlaps before Interval[4, 10]
define "IntegerIntervalExclusiveOverlapsBeforeFalse2_expected": false
define "IntegerIntervalExclusiveOverlapsBeforeFalse3": Interval[4, 10] overlaps before Interval(3, 10]
define "IntegerIntervalExclusiveOverlapsBeforeFalse3_expected": false
define "DecimalIntervalOverlapsBeforeTrue": Interval[1.0, 10.0] overlaps before Interval[4.0, 10.0]
define "DecimalIntervalOverlapsBeforeTrue_expected": true
define "DecimalIntervalOverlapsBeforeFalse": Interval[4.0, 10.0] overlaps before Interval[1.0, 10.0]
define "DecimalIntervalOverlapsBeforeFalse_expected": false
define "QuantityIntervalOverlapsBeforeTrue": Interval[1.0 'g', 10.0 'g'] overlaps before Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalOverlapsBeforeTrue_expected": true
define "QuantityIntervalOverlapsBeforeFalse": Interval[5.0 'g', 10.0 'g'] overlaps before Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalOverlapsBeforeFalse_expected": false
define "DateTimeOverlapsBeforeTrue": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)] overlaps Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 28)]
define "DateTimeOverlapsBeforeTrue_expected": true
define "DateTimeOverlapsBeforeFalse": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)] overlaps Interval[DateTime(2012, 1, 26), DateTime(2012, 1, 28)]
define "DateTimeOverlapsBeforeFalse_expected": false
define "TimeOverlapsBeforeTrue": Interval[@T10:00:00.000, @T19:59:59.999] overlaps Interval[@T12:00:00.000, @T21:59:59.999]
define "TimeOverlapsBeforeTrue_expected": true
define "TimeOverlapsBeforeFalse": Interval[@T10:00:00.000, @T19:59:59.999] overlaps Interval[@T20:00:00.000, @T21:59:59.999]
define "TimeOverlapsBeforeFalse_expected": false
define "TestOverlapsAfterNull": Interval[null, null] overlaps after Interval[1, 10]
define "TestOverlapsAfterNull_expected": null
define "IntegerIntervalOverlapsAfterTrue": Interval[4, 15] overlaps after Interval[1, 10]
define "IntegerIntervalOverlapsAfterTrue_expected": true
define "IntegerIntervalOverlapsAfterFalse": Interval[4, 10] overlaps after Interval[1, 10]
define "IntegerIntervalOverlapsAfterFalse_expected": false
define "IntegerIntervalOverlapsAfterFalse2": Interval[4, 10] overlaps after Interval[4, 10]
define "IntegerIntervalOverlapsAfterFalse2_expected": false
define "IntegerIntervalExclusiveOverlapsAfterTrue": Interval[4, 11) overlaps after Interval[4, 9]
define "IntegerIntervalExclusiveOverlapsAfterTrue_expected": true
define "IntegerIntervalExclusiveOverlapsAfterTrue2": Interval[4, 11) overlaps after Interval[4, 10)
define "IntegerIntervalExclusiveOverlapsAfterTrue2_expected": true
define "IntegerIntervalExclusiveOverlapsAfterTrue3": Interval[4, 10] overlaps after Interval[4, 10)
define "IntegerIntervalExclusiveOverlapsAfterTrue3_expected": true
define "IntegerIntervalExclusiveOverlapsAfterFalse": Interval[4, 11) overlaps after Interval[4, 11)
define "IntegerIntervalExclusiveOverlapsAfterFalse_expected": false
define "IntegerIntervalExclusiveOverlapsAfterFalse2": Interval[4, 11) overlaps after Interval[4, 10]
define "IntegerIntervalExclusiveOverlapsAfterFalse2_expected": false
define "IntegerIntervalExclusiveOverlapsAfterFalse3": Interval[4, 10] overlaps after Interval[4, 11)
define "IntegerIntervalExclusiveOverlapsAfterFalse3_expected": false
define "DecimalIntervalOverlapsAfterTrue": Interval[4.0, 15.0] overlaps after Interval[1.0, 10.0]
define "DecimalIntervalOverlapsAfterTrue_expected": true
define "DecimalIntervalOverlapsAfterFalse": Interval[4.0, 10.0] overlaps after Interval[1.0, 10.0]
define "DecimalIntervalOverlapsAfterFalse_expected": false
define "QuantityIntervalOverlapsAfterTrue": Interval[5.0 'g', 15.0 'g'] overlaps after Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalOverlapsAfterTrue_expected": true
define "QuantityIntervalOverlapsAfterFalse": Interval[5.0 'g', 10.0 'g'] overlaps after Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalOverlapsAfterFalse_expected": false
define "DateTimeOverlapsAfterTrue": Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 28)] overlaps Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)]
define "DateTimeOverlapsAfterTrue_expected": true
define "DateTimeOverlapsAfterFalse": Interval[DateTime(2012, 1, 26), DateTime(2012, 1, 28)] overlaps Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)]
define "DateTimeOverlapsAfterFalse_expected": false
define "TimeOverlapsAfterTrue": Interval[@T12:00:00.000, @T21:59:59.999] overlaps Interval[@T10:00:00.000, @T19:59:59.999]
define "TimeOverlapsAfterTrue_expected": true
define "TimeOverlapsAfterFalse": Interval[@T20:00:00.000, @T21:59:59.999] overlaps Interval[@T10:00:00.000, @T19:59:59.999]
define "TimeOverlapsAfterFalse_expected": false
define "TestPointFromNull": point from Interval[null, null]
define "TestPointFromNull_expected": null
define "TestPointFromInteger": point from Interval[1, 1]
define "TestPointFromInteger_expected": 1
define "TestPointFromDecimal": point from Interval[1.0, 1.0]
define "TestPointFromDecimal_expected": 1.0
define "TestPointFromQuantity": point from Interval[1.0 'cm', 1.0 'cm']
define "TestPointFromQuantity_expected": 1.0'cm'
define "TimeProperContainsTrue": Interval[@T12:00:00.000, @T21:59:59.999] properly includes @T12:00:00.001
define "TimeProperContainsTrue_expected": true
define "TimeProperContainsFalse": Interval[@T12:00:00.000, @T21:59:59.999] properly includes @T12:00:00.000
define "TimeProperContainsFalse_expected": false
define "TimeProperContainsNull": Interval[@T12:00:00.001, @T21:59:59.999] properly includes @T12:00:00
define "TimeProperContainsNull_expected": null
define "TimeProperContainsPrecisionTrue": Interval[@T12:00:00.000, @T21:59:59.999] properly includes second of @T12:00:01
define "TimeProperContainsPrecisionTrue_expected": true
define "TimeProperContainsPrecisionFalse": Interval[@T12:00:00.001, @T21:59:59.999] properly includes second of @T12:00:00
define "TimeProperContainsPrecisionFalse_expected": false
define "TimeProperContainsPrecisionNull": Interval[@T12:00:00.001, @T21:59:59.999] properly includes millisecond of @T12:00:00
define "TimeProperContainsPrecisionNull_expected": null
define "TimeProperInTrue": @T12:00:00.001 properly included in Interval[@T12:00:00.000, @T21:59:59.999]
define "TimeProperInTrue_expected": true
define "TimeProperInFalse": @T12:00:00.000 properly included in  Interval[@T12:00:00.000, @T21:59:59.999]
define "TimeProperInFalse_expected": false
define "TimeProperInNull": @T12:00:00 properly included in Interval[@T12:00:00.001, @T21:59:59.999]
define "TimeProperInNull_expected": null
define "TimeProperInPrecisionTrue": @T12:00:01 properly included in second of Interval[@T12:00:00.000, @T21:59:59.999]
define "TimeProperInPrecisionTrue_expected": true
define "TimeProperInPrecisionFalse": @T12:00:00 properly included in second of Interval[@T12:00:00.001, @T21:59:59.999]
define "TimeProperInPrecisionFalse_expected": false
define "TimeProperInPrecisionNull": @T12:00:00 properly included in millisecond of Interval[@T12:00:00.001, @T21:59:59.999]
define "TimeProperInPrecisionNull_expected": null
define "NullBoundariesProperlyIncludesIntegerInterval": Interval[null as Integer, null as Integer] properly includes Interval[1, 10]
define "NullBoundariesProperlyIncludesIntegerInterval_expected": true
define "IntegerIntervalProperlyIncludesTrue": Interval[1, 10] properly includes Interval[4, 10]
define "IntegerIntervalProperlyIncludesTrue_expected": true
define "IntegerIntervalProperlyIncludesFalse": Interval[1, 10] properly includes Interval[4, 15]
define "IntegerIntervalProperlyIncludesFalse_expected": false
define "DecimalIntervalProperlyIncludesTrue": Interval[1.0, 10.0] properly includes Interval[4.0, 10.0]
define "DecimalIntervalProperlyIncludesTrue_expected": true
define "DecimalIntervalProperlyIncludesFalse": Interval[1.0, 10.0] properly includes Interval[4.0, 15.0]
define "DecimalIntervalProperlyIncludesFalse_expected": false
define "QuantityIntervalProperlyIncludesTrue": Interval[1.0 'g', 10.0 'g'] properly includes Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalProperlyIncludesTrue_expected": true
define "QuantityIntervalProperlyIncludesFalse": Interval[1.0 'g', 10.0 'g'] properly includes Interval[5.0 'g', 15.0 'g']
define "QuantityIntervalProperlyIncludesFalse_expected": false
define "DateTimeProperlyIncludesTrue": Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 28)] properly includes Interval[DateTime(2012, 1, 16), DateTime(2012, 1, 27)]
define "DateTimeProperlyIncludesTrue_expected": true
define "DateTimeProperlyIncludesFalse": Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 28)] properly includes Interval[DateTime(2012, 1, 16), DateTime(2012, 1, 29)]
define "DateTimeProperlyIncludesFalse_expected": false
define "TimeProperlyIncludesTrue": Interval[@T12:00:00.000, @T21:59:59.999] properly includes Interval[@T12:01:01.000, @T21:59:59.998]
define "TimeProperlyIncludesTrue_expected": true
define "TimeProperlyIncludesFalse": Interval[@T12:00:00.000, @T21:59:59.999] properly includes Interval[@T12:01:01.000, @T22:00:00.000]
define "TimeProperlyIncludesFalse_expected": false
define "IntegerIntervalProperlyIncludedInNullBoundaries": Interval[1, 10] properly included in Interval[null, null]
define "IntegerIntervalProperlyIncludedInNullBoundaries_expected": true
define "IntegerIntervalProperlyIncludedInTrue": Interval[4, 10] properly included in Interval[1, 10]
define "IntegerIntervalProperlyIncludedInTrue_expected": true
define "IntegerIntervalProperlyIncludedInFalse": Interval[4, 15] properly included in Interval[1, 10]
define "IntegerIntervalProperlyIncludedInFalse_expected": false
define "DecimalIntervalProperlyIncludedInTrue": Interval[4.0, 10.0] properly included in Interval[1.0, 10.0]
define "DecimalIntervalProperlyIncludedInTrue_expected": true
define "DecimalIntervalProperlyIncludedInFalse": Interval[4.0, 15.0] properly included in Interval[1.0, 10.0]
define "DecimalIntervalProperlyIncludedInFalse_expected": false
define "QuantityIntervalProperlyIncludedInTrue": Interval[5.0 'g', 10.0 'g'] properly included in Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalProperlyIncludedInTrue_expected": true
define "QuantityIntervalProperlyIncludedInFalse": Interval[1.0 'g', 10.0 'g'] properly included in Interval[5.0 'g', 15.0 'g']
define "QuantityIntervalProperlyIncludedInFalse_expected": false
define "DateTimeProperlyIncludedInTrue": Interval[DateTime(2012, 1, 16), DateTime(2012, 1, 27)] properly included in Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 28)]
define "DateTimeProperlyIncludedInTrue_expected": true
define "DateTimeProperlyIncludedInFalse": Interval[DateTime(2012, 1, 16), DateTime(2012, 1, 29)] properly included in Interval[DateTime(2012, 1, 15), DateTime(2012, 1, 28)]
define "DateTimeProperlyIncludedInFalse_expected": false
define "TimeProperlyIncludedInTrue": Interval[@T12:01:01.000, @T21:59:59.998] properly included in Interval[@T12:00:00.000, @T21:59:59.999]
define "TimeProperlyIncludedInTrue_expected": true
define "TimeProperlyIncludedInFalse": Interval[@T12:01:01.000, @T22:00:00.000] properly included in Interval[@T12:00:00.000, @T21:59:59.999]
define "TimeProperlyIncludedInFalse_expected": false
define "IntegerIntervalStart": start of Interval[1, 10]
define "IntegerIntervalStart_expected": 1
define "DecimalIntervalStart": start of Interval[1.0, 10.0]
define "DecimalIntervalStart_expected": 1.0
define "QuantityIntervalStart": start of Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalStart_expected": 1.0'g'
define "DateTimeIntervalStart": start of Interval[@2016-05-01T00:00:00.000, @2016-05-02T00:00:00.000]
define "DateTimeIntervalStart_expected": @2016-05-01T00:00:00.000
define "TimeIntervalStart": start of Interval[@T00:00:00.000, @T23:59:59.599]
define "TimeIntervalStart_expected": @T00:00:00.000
define "TestStartsNull": Interval[null, null] starts Interval[1, 10]
define "TestStartsNull_expected": null
define "IntegerIntervalStartsTrue": Interval[4, 10] starts Interval[4, 15]
define "IntegerIntervalStartsTrue_expected": true
define "IntegerIntervalStartsFalse": Interval[1, 10] starts Interval[4, 10]
define "IntegerIntervalStartsFalse_expected": false
define "DecimalIntervalStartsTrue": Interval[4.0, 10.0] starts Interval[4.0, 15.0]
define "DecimalIntervalStartsTrue_expected": true
define "DecimalIntervalStartsFalse": Interval[1.0, 10.0] starts Interval[4.0, 10.0]
define "DecimalIntervalStartsFalse_expected": false
define "QuantityIntervalStartsTrue": Interval[5.0 'g', 10.0 'g'] starts Interval[5.0 'g', 15.0 'g']
define "QuantityIntervalStartsTrue_expected": true
define "QuantityIntervalStartsFalse": Interval[1.0 'g', 10.0 'g'] starts Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalStartsFalse_expected": false
define "DateTimeStartsTrue": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)] starts Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 27)]
define "DateTimeStartsTrue_expected": true
define "DateTimeStartsFalse": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)] starts Interval[DateTime(2012, 1, 6), DateTime(2012, 1, 27)]
define "DateTimeStartsFalse_expected": false
define "TimeStartsTrue": Interval[@T05:59:59.999, @T15:59:59.999] starts Interval[@T05:59:59.999, @T17:59:59.999]
define "TimeStartsTrue_expected": true
define "TimeStartsFalse": Interval[@T05:59:59.999, @T15:59:59.999] starts Interval[@T04:59:59.999, @T17:59:59.999]
define "TimeStartsFalse_expected": false
define "TestUnionNull": Interval[null, null] union Interval[1, 10]
define "TestUnionNull_expected": null
define "IntegerIntervalUnion1To15": Interval[1, 10] union Interval[4, 15]
define "IntegerIntervalUnion1To15_expected": Interval [ 1, 15 ]
define "IntegerIntervalUnionNull": Interval[1, 10] union Interval[44, 50]
define "IntegerIntervalUnionNull_expected": null
define "DecimalIntervalUnion1To15": Interval[1.0, 10.0] union Interval[4.0, 15.0]
define "DecimalIntervalUnion1To15_expected": Interval [ 1.0, 15.0 ]
define "DecimalIntervalUnionNull": Interval[1.0, 10.0] union Interval[14.0, 15.0]
define "DecimalIntervalUnionNull_expected": null
define "QuantityIntervalUnion1To15": Interval[1.0 'g', 10.0 'g'] union Interval[5.0 'g', 15.0 'g']
define "QuantityIntervalUnion1To15_expected": Interval [ 1.0 'g', 15.0 'g' ]
define "QuantityIntervalUnionNull": Interval[1.0 'g', 10.0 'g'] union Interval[14.0 'g', 15.0 'g']
define "QuantityIntervalUnionNull_expected": null
define "DateTimeUnion": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)] union Interval[DateTime(2012, 1, 25), DateTime(2012, 1, 28)]
define "DateTimeUnion_expected": Interval [ @2012-01-05T, @2012-01-28T ]
define "DateTimeUnionNull": Interval[DateTime(2012, 1, 5), DateTime(2012, 1, 25)] union Interval[DateTime(2012, 1, 27), DateTime(2012, 1, 28)]
define "DateTimeUnionNull_expected": null
define "TimeUnion": Interval[@T05:59:59.999, @T15:59:59.999] union Interval[@T10:59:59.999, @T20:59:59.999]
define "TimeUnion_expected": Interval [ @T05:59:59.999, @T20:59:59.999 ]
define "TimeUnionNull": Interval[@T05:59:59.999, @T15:59:59.999] union Interval[@T16:59:59.999, @T20:59:59.999]
define "TimeUnionNull_expected": null
define "IntegerIntervalTestWidth9": width of Interval[1, 10]
define "IntegerIntervalTestWidth9_expected": 9
define "IntervalTestWidthNull": width of (null as Interval<Any>)
define "IntervalTestWidthNull_expected": null
define "DecimalIntervalTestWidth11": width of Interval[4.0, 15.0]
define "DecimalIntervalTestWidth11_expected": 11.0
define "QuantityIntervalTestWidth5": width of Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalTestWidth5_expected": 5.0'g'
define "IntegerIntervalTest": Interval[1, 10]
define "IntegerIntervalTest_expected": Interval[1, 10]
define "IntegerIntervalTest2": Interval[11, 20]
define "IntegerIntervalTest2_expected": Interval[11, 20]
define "IntegerIntervalTest3": Interval[44, 50]
define "IntegerIntervalTest3_expected": Interval[44, 50]
define "IntegerIntervalTest4": Interval[4, 10]
define "IntegerIntervalTest4_expected": Interval[4, 10]
define "IntegerIntervalTest5": Interval[4, 15]
define "IntegerIntervalTest5_expected": Interval[4, 15]
define "DecimalIntervalTest": Interval[1.0, 10.0]
define "DecimalIntervalTest_expected": Interval[1.0, 10.0]
define "DecimalIntervalTest2": Interval[11.0, 20.0]
define "DecimalIntervalTest2_expected": Interval[11.0, 20.0]
define "DecimalIntervalTest3": Interval[4.0, 10.0]
define "DecimalIntervalTest3_expected": Interval[4.0, 10.0]
define "DecimalIntervalTest4": Interval[4.0, 15.0]
define "DecimalIntervalTest4_expected": Interval[4.0, 15.0]
define "DecimalIntervalTest5": Interval[14.0, 15.0]
define "DecimalIntervalTest5_expected": Interval[14.0, 15.0]
define "QuantityIntervalTest": Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalTest_expected": Interval[1.0 'g', 10.0 'g']
define "QuantityIntervalTest2": Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalTest2_expected": Interval[11.0 'g', 20.0 'g']
define "QuantityIntervalTest3": Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalTest3_expected": Interval[5.0 'g', 10.0 'g']
define "QuantityIntervalTest4": Interval[5.0 'g', 15.0 'g']
define "QuantityIntervalTest4_expected": Interval[5.0 'g', 15.0 'g']
define "QuantityIntervalTest5": Interval[14.0 'g', 15.0 'g']
define "QuantityIntervalTest5_expected": Interval[14.0 'g', 15.0 'g']
define "DateTimeIntervalTest": Interval[@2016-05-01T00:00:00.000, @2016-05-02T00:00:00.000]
define "DateTimeIntervalTest_expected": Interval[@2016-05-01T00:00:00.000, @2016-05-02T00:00:00.000]
define "TimeIntervalTest": Interval[@T00:00:00.000, @T23:59:59.599]
define "TimeIntervalTest_expected": Interval[@T00:00:00.000, @T23:59:59.599]
define "CollapseIntervalTestInteger": {Interval[1, 10], Interval[11, 20], Interval[44, 50]}
define "CollapseIntervalTestInteger_expected": {Interval[1, 10], Interval[11, 20], Interval[44, 50]}
