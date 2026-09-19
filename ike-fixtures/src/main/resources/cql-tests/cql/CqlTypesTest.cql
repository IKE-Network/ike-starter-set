library CqlTypesTest version '1.0'

define "AnyQuantity": 5.0 'g'
define "AnyQuantity_expected": 5.0'g'
define "AnyDateTime": DateTime(2012, 4, 4)
define "AnyDateTime_expected": @2012-04-04T
define "AnyTime": @T09:00:00.000
define "AnyTime_expected": @T09:00:00.000
define "AnyInterval": Interval[2, 7]
define "AnyInterval_expected": Interval[2, 7]
define "AnyList": {1, 2, 3}
define "AnyList_expected": {1, 2, 3}
define "AnyTuple": Tuple { id: 5, name: 'Chris'}
define "AnyTuple_expected": Tuple { id: 5, name: 'Chris'}
define "AnyString": Tuple { id: 5, name: 'Chris'}.name
define "AnyString_expected": 'Chris'
define "DateTimeNull": DateTime(null)
define "DateTimeNull_expected": null
define "DateTimeProper": DateTime(2016, 7, 7, 6, 25, 33, 910)
define "DateTimeProper_expected": @2016-07-07T06:25:33.910
define "DateTimeIncomplete": DateTime(2015, 2, 10)
define "DateTimeIncomplete_expected": @2015-02-10T
define "DateTimeUncertain": days between DateTime(2015, 2, 10) and DateTime(2015, 3)
define "DateTimeUncertain_expected": Interval [ 18, 49 ]
define "DateTimeMin": DateTime(0001, 1, 1, 0, 0, 0, 0)
define "DateTimeMin_expected": @0001-01-01T00:00:00.000
define "DateTimeMax": DateTime(9999, 12, 31, 23, 59, 59, 999)
define "DateTimeMax_expected": @9999-12-31T23:59:59.999
define "DateTimeTimeUnspecified": hour from @2015-02-10T is null
define "DateTimeTimeUnspecified_expected": true
define "QuantityTest": 150.2 '[lb_av]'
define "QuantityTest_expected": 150.2 '[lb_av]'
define "QuantityTest2": 2.5589 '{eskimo_kisses}'
define "QuantityTest2_expected": 2.5589 '{eskimo_kisses}'
define "QuantityFractionalTooBig": 5.999999999 'g'
define "QuantityFractionalTooBig_expected": 5.999999999 'g'
define "StringTestEscapeQuotes": '\'I start with a single quote and end with a double quote\"'
define "StringTestEscapeQuotes_expected": '\u0027I start with a single quote and end with a double quote\u0022'
define "StringUnicodeTest": '\u0048\u0069'
define "StringUnicodeTest_expected": 'Hi'
define "TimeMillisParsing": @T23:59:59.10000
define "TimeMillisParsing_expected": @T23:59:59.100
define "TimeProper": @T10:25:12.863
define "TimeProper_expected": @T10:25:12.863
define "TimeAllMax": @T23:59:59.999
define "TimeAllMax_expected": @T23:59:59.999
define "TimeAllMin": @T00:00:00.000
define "TimeAllMin_expected": @T00:00:00.000
