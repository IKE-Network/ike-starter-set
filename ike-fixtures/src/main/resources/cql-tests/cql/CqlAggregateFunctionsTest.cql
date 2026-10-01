library CqlAggregateFunctionsTest version '1.0'

define "AllTrueAllTrue": AllTrue({true,true})
define "AllTrueAllTrue_expected": true
define "AllTrueTrueFirst": AllTrue({true,false})
define "AllTrueTrueFirst_expected": false
define "AllTrueFalseFirst": AllTrue({false,true})
define "AllTrueFalseFirst_expected": false
define "AllTrueAllTrueFalseTrue": AllTrue({true,false,true})
define "AllTrueAllTrueFalseTrue_expected": false
define "AllTrueAllFalseTrueFalse": AllTrue({false,true,false})
define "AllTrueAllFalseTrueFalse_expected": false
define "AllTrueNullFirst": AllTrue({null,true,true})
define "AllTrueNullFirst_expected": true
define "AllTrueEmptyList": AllTrue({})
define "AllTrueEmptyList_expected": true
define "AllTrueIsTrueWhenNull": AllTrue(null)
define "AllTrueIsTrueWhenNull_expected": true
define "AnyTrueAllTrue": AnyTrue({true,true})
define "AnyTrueAllTrue_expected": true
define "AnyTrueAllFalse": AnyTrue({false,false})
define "AnyTrueAllFalse_expected": false
define "AnyTrueAllTrueFalseTrue": AnyTrue({true,false,true})
define "AnyTrueAllTrueFalseTrue_expected": true
define "AnyTrueAllFalseTrueFalse": AnyTrue({false,true,false})
define "AnyTrueAllFalseTrueFalse_expected": true
define "AnyTrueTrueFirst": AnyTrue({true,false})
define "AnyTrueTrueFirst_expected": true
define "AnyTrueFalseFirst": AnyTrue({false,true})
define "AnyTrueFalseFirst_expected": true
define "AnyTrueNullFirstThenTrue": AnyTrue({null,true})
define "AnyTrueNullFirstThenTrue_expected": true
define "AnyTrueNullFirstThenFalse": AnyTrue({null,false})
define "AnyTrueNullFirstThenFalse_expected": false
define "AnyTrueEmptyList": AnyTrue({})
define "AnyTrueEmptyList_expected": false
define "AnyTrueIsFalseWhenNull": AnyTrue(null)
define "AnyTrueIsFalseWhenNull_expected": false
define "AvgTest1": Avg({ 1.0, 2.0, 3.0, 6.0 })
define "AvgTest1_expected": 3.0
define "ProductLong": Product({5L, 4L, 5L})
define "ProductLong_expected": 100L
define "CountTest1": Count({ 15, 5, 99, null, 1 })
define "CountTest1_expected": 4
define "CountTestDateTime": Count({ DateTime(2014), DateTime(2001), DateTime(2010) })
define "CountTestDateTime_expected": 3
define "CountTestTime": Count({ @T15:59:59.999, @T05:59:59.999, @T20:59:59.999 })
define "CountTestTime_expected": 3
define "CountTestNull": Count({})
define "CountTestNull_expected": 0
define "MaxTestInteger": Max({ 5, 12, 1, 15, 0, 4, 90, 44 })
define "MaxTestInteger_expected": 90
define "MaxTestLong": Max({ 5L, 12L, 1L, 15L, 0L, 4L, 90L, 44L })
define "MaxTestLong_expected": 90L
define "MaxTestString": Max({ 'hi', 'bye', 'zebra' })
define "MaxTestString_expected": 'zebra'
define "MaxTestDateTime": Max({ DateTime(2012, 10, 5), DateTime(2012, 9, 5), DateTime(2012, 10, 6) })
define "MaxTestDateTime_expected": @2012-10-06T
define "MaxTestTime": Max({ @T15:59:59.999, @T05:59:59.999, @T20:59:59.999 })
define "MaxTestTime_expected": @T20:59:59.999
define "MedianTestDecimal": Median({6.0, 5.0, 4.0, 3.0, 2.0, 1.0})
define "MedianTestDecimal_expected": 3.5
define "MinTestInteger": Min({5, 12, 1, 15, 0, 4, 90, 44})
define "MinTestInteger_expected": 0
define "MinTestLong": Min({5L, 12L, 1L, 15L, 0L, 4L, 90L, 44L})
define "MinTestLong_expected": 0L
define "MinTestString": Min({'hi', 'bye', 'zebra'})
define "MinTestString_expected": 'bye'
define "MinTestDateTime": Min({ DateTime(2012, 10, 5), DateTime(2012, 9, 5), DateTime(2012, 10, 6) })
define "MinTestDateTime_expected": @2012-09-05T
define "MinTestTime": Min({ @T15:59:59.999, @T05:59:59.999, @T20:59:59.999 })
define "MinTestTime_expected": @T05:59:59.999
define "ModeTestInteger": Mode({ 2, 1, 8, 2, 9, 1, 9, 9 })
define "ModeTestInteger_expected": 9
define "ModeTestDateTime": Mode({ DateTime(2012, 10, 5), DateTime(2012, 9, 5), DateTime(2012, 10, 6), DateTime(2012, 9, 5) })
define "ModeTestDateTime_expected": @2012-09-05T
define "ModeTestDateTime2": Mode({ DateTime(2012, 10, 5), DateTime(2012, 10, 5), DateTime(2012, 10, 6), DateTime(2012, 9, 5) })
define "ModeTestDateTime2_expected": @2012-10-05T
define "ModeTestTime": Mode({ @T15:59:59.999, @T05:59:59.999, @T20:59:59.999, @T05:59:59.999 })
define "ModeTestTime_expected": @T05:59:59.999
define "PopStdDevTest1": PopulationStdDev({ 1.0, 2.0, 3.0, 4.0, 5.0 })
define "PopStdDevTest1_expected": 1.41421356
define "PopulationStdDevIsNull": PopulationStdDev({ null as Quantity, null as Quantity, null as Quantity })
define "PopulationStdDevIsNull_expected": null
define "PopVarianceTest1": PopulationVariance({ 1.0, 2.0, 3.0, 4.0, 5.0 })
define "PopVarianceTest1_expected": 2.0
define "PopVarianceIsNull": PopulationVariance({ null as Quantity, null as Quantity, null as Quantity })
define "PopVarianceIsNull_expected": null
define "StdDevTest1": StdDev({ 1.0, 2.0, 3.0, 4.0, 5.0 })
define "StdDevTest1_expected": 1.58113883
define "StdDevIsNull": StdDev({ null as Quantity, null as Quantity, null as Quantity })
define "StdDevIsNull_expected": null
define "SumTest1": Sum({ 6.0, 2.0, 3.0, 4.0, 5.0 })
define "SumTest1_expected": 20.0
define "SumTestLong": Sum({ 6L, 2L, 3L, 4L, 5L })
define "SumTestLong_expected": 20L
define "SumTestQuantity": Sum({1 'ml',2 'ml',3 'ml',4 'ml',5 'ml'})
define "SumTestQuantity_expected": 15 'ml'
define "SumTestNull": Sum({ null, 1, null })
define "SumTestNull_expected": 1
define "VarianceTest1": Variance({ 1.0, 2.0, 3.0, 4.0, 5.0 })
define "VarianceTest1_expected": 2.5
