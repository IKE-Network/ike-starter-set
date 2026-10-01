library CqlComparisonOperatorsTest version '1.0'

define "BetweenIntTrue": 4 between 2 and 6
define "BetweenIntTrue_expected": true
define "SimpleEqTrueTrue": true = true
define "SimpleEqTrueTrue_expected": true
define "SimpleEqTrueFalse": true = false
define "SimpleEqTrueFalse_expected": false
define "SimpleEqFalseFalse": false = false
define "SimpleEqFalseFalse_expected": true
define "SimpleEqFalseTrue": false = true
define "SimpleEqFalseTrue_expected": false
define "SimpleEqNullNull": null as String = null
define "SimpleEqNullNull_expected": null
define "SimpleEqTrueNull": true = null
define "SimpleEqTrueNull_expected": null
define "SimpleEqNullTrue": null = true
define "SimpleEqNullTrue_expected": null
define "SimpleEqInt1Int1": 1 = 1
define "SimpleEqInt1Int1_expected": true
define "SimpleEqInt1Int2": 1 = 2
define "SimpleEqInt1Int2_expected": false
define "SimpleEqLong1Long2": 1L = 2L
define "SimpleEqLong1Long2_expected": false
define "SimpleEqStringAStringA": 'a' = 'a'
define "SimpleEqStringAStringA_expected": true
define "SimpleEqStringAStringB": 'a' = 'b'
define "SimpleEqStringAStringB_expected": false
define "SimpleEqFloat1Float1": 1.0 = 1.0
define "SimpleEqFloat1Float1_expected": true
define "SimpleEqFloat1Float2": 1.0 = 2.0
define "SimpleEqFloat1Float2_expected": false
define "SimpleEqFloat1Float1WithZ": 1.0 = 1.00
define "SimpleEqFloat1Float1WithZ_expected": true
define "SimpleEqFloat1Float1WithPrecisionAndZ": 1.50 = 1.55
define "SimpleEqFloat1Float1WithPrecisionAndZ_expected": false
define "SimpleEqFloat1Int1": 1.0 = 1
define "SimpleEqFloat1Int1_expected": true
define "SimpleEqFloat1Int2": 1.0 = 2
define "SimpleEqFloat1Int2_expected": false
define "QuantityEqCM1CM1": 1'cm' = 1'cm'
define "QuantityEqCM1CM1_expected": true
define "QuantityEqCM1M01": 1'cm' = 0.01'm'
define "QuantityEqCM1M01_expected": true
define "QuantityEqDiffPrecision": 2.0'cm' = 2.00'cm'
define "QuantityEqDiffPrecision_expected": true
define "RatioEqual": 1'cm':2'cm' = 1'cm':2'cm'
define "RatioEqual_expected": true
define "RatioNotEqualDiffNumerator": 1'cm':2'cm' = 1.1'cm':2'cm'
define "RatioNotEqualDiffNumerator_expected": false
define "RatioNotEqualDiffDenominator": 1'cm':2'cm' = 1'cm':2.1'cm'
define "RatioNotEqualDiffDenominator_expected": false
define "TupleEqJohnJohn": Tuple { Id : 1, Name : 'John' } = Tuple { Id : 1, Name : 'John' }
define "TupleEqJohnJohn_expected": true
define "TupleEqJohnJane": Tuple { Id : 1, Name : 'John' } = Tuple { Id : 2, Name : 'Jane' }
define "TupleEqJohnJane_expected": false
define "TupleEqJohn1John2": Tuple { Id : 1, Name : 'John' } = Tuple { Id : 2, Name : 'John' }
define "TupleEqJohn1John2_expected": false
define "TupleEqJohn1John2WithNullName": Tuple { Id : 1, Name : 'John' } = Tuple { Id : 2, Name : null }
define "TupleEqJohn1John2WithNullName_expected": false
define "TupleEqDifferentNamesWithOneNullId": Tuple { Id : null, Name : 'John' } = Tuple { Id : 1, Name : 'James' }
define "TupleEqDifferentNamesWithOneNullId_expected": null
define "TupleEqJohn1John1WithBothNamesNull": Tuple { Id : 1, Name : null } = Tuple { Id : 1, Name : null }
define "TupleEqJohn1John1WithBothNamesNull_expected": true
define "TupleEqJohnJohnWithBothIdsNull": Tuple { Id : null, Name : 'John' } = Tuple { Id : null, Name : 'John' }
define "TupleEqJohnJohnWithBothIdsNull_expected": true
define "TupleEqJohn1John1WithNullName": Tuple { Id : 1, Name : 'John' } = Tuple { Id : 1, Name : null }
define "TupleEqJohn1John1WithNullName_expected": null
define "TupleEqDateTimeTrue": Tuple { dateId: 1, Date: DateTime(2012, 10, 5, 0, 0, 0, 0) } = Tuple { dateId: 1, Date: DateTime(2012, 10, 5, 0, 0, 0, 0) }
define "TupleEqDateTimeTrue_expected": true
define "TupleEqDateTimeFalse": Tuple { dateId: 1, Date: DateTime(2012, 10, 5, 0, 0, 0, 0) } = Tuple { dateId: 1, Date: DateTime(2012, 10, 5, 5, 0, 0, 0) }
define "TupleEqDateTimeFalse_expected": false
define "TupleEqDateTimeTrue2": Tuple { dateId: 12, Date: DateTime(2012, 1, 1) } = Tuple { dateId: 12, Date: DateTime(2012, 1, 1) }
define "TupleEqDateTimeTrue2_expected": true
define "TupleEqTimeTrue": Tuple { timeId: 55, TheTime: @T05:15:15.541 } = Tuple { timeId: 55, TheTime: @T05:15:15.541 }
define "TupleEqTimeTrue_expected": true
define "TupleEqTimeFalse": Tuple { timeId: 55, TheTime: @T05:15:15.541 } = Tuple { timeId: 55, TheTime: @T05:15:15.540 }
define "TupleEqTimeFalse_expected": false
define "DateTimeEqTodayToday": Today() = Today()
define "DateTimeEqTodayToday_expected": true
define "DateTimeEqTodayYesterday": Today() = Today() - 1 days
define "DateTimeEqTodayYesterday_expected": false
define "DateTimeEqJanJan": DateTime(2014, 1, 5, 5, 0, 0, 0, 0) = DateTime(2014, 1, 5, 5, 0, 0, 0, 0)
define "DateTimeEqJanJan_expected": true
define "DateTimeEqJanJuly": DateTime(2014, 1, 5, 5, 0, 0, 0, 0) = DateTime(2014, 7, 5, 5, 0, 0, 0, 0)
define "DateTimeEqJanJuly_expected": false
define "DateTimeEqMissingArg": DateTime(2015, 1, 5, 5, 0, 0) = DateTime(2015, 1, 5, 5, 0, 0)
define "DateTimeEqMissingArg_expected": true
define "DateTimeEqNull": DateTime(null) = DateTime(null)
define "DateTimeEqNull_expected": null
define "DateTimeEqTrue": DateTime(2001, 1, 1, null) = DateTime(2001, 1, 1, null, null)
define "DateTimeEqTrue_expected": true
define "DateTimeUTC": @2014-01-25T14:30:14.559+01:00 = @2014-01-25T14:30:14.559+01:00
define "DateTimeUTC_expected": true
define "DateTimeDayCompare": @2022-02-22T00:00:00.000-05:00 same day as @2022-02-22T04:59:00.000Z
define "DateTimeDayCompare_expected": true
define "TimeEq10A10A": @T10:00:00.000 = @T10:00:00.000
define "TimeEq10A10A_expected": true
define "TimeEq10A10P": @T10:00:00.000 = @T22:00:00.000
define "TimeEq10A10P_expected": false
define "GreaterZZ": 0 > 0
define "GreaterZZ_expected": false
define "GreaterZ1": 0 > 1
define "GreaterZ1_expected": false
define "GreaterLong": 0L > 10L
define "GreaterLong_expected": false
define "GreaterZNeg1": 0 > -1
define "GreaterZNeg1_expected": true
define "GreaterDecZZ": 0.0 > 0.0
define "GreaterDecZZ_expected": false
define "GreaterDecZ1": 0.0 > 1.0
define "GreaterDecZ1_expected": false
define "GreaterDecZNeg1": 0.0 > -1.0
define "GreaterDecZNeg1_expected": true
define "GreaterDec1Int2": 1.0 > 2
define "GreaterDec1Int2_expected": false
define "GreaterCM0CM0": 0'cm' > 0'cm'
define "GreaterCM0CM0_expected": false
define "GreaterCM0CM1": 0'cm' > 1'cm'
define "GreaterCM0CM1_expected": false
define "GreaterCM0NegCM1": 0'cm' > -1'cm'
define "GreaterCM0NegCM1_expected": true
define "GreaterM1CM1": 1'm' > 1'cm'
define "GreaterM1CM1_expected": true
define "GreaterM1CM10": 1'm' > 10'cm'
define "GreaterM1CM10_expected": true
define "GreaterAA": 'a' > 'a'
define "GreaterAA_expected": false
define "GreaterAB": 'a' > 'b'
define "GreaterAB_expected": false
define "GreaterBA": 'b' > 'a'
define "GreaterBA_expected": true
define "GreaterAThanAA": 'a' > 'aa'
define "GreaterAThanAA_expected": false
define "GreaterAAThanA": 'aa' > 'a'
define "GreaterAAThanA_expected": true
define "GreaterJackJill": 'Jack' > 'Jill'
define "GreaterJackJill_expected": false
define "DateTimeGreaterTrue": DateTime(2012, 2, 12) > DateTime(2012, 2, 10)
define "DateTimeGreaterTrue_expected": true
define "DateTimeGreaterFalse": DateTime(2012, 2, 12) > DateTime(2012, 2, 13)
define "DateTimeGreaterFalse_expected": false
define "TimeGreaterTrue": @T10:00:00.001 > @T10:00:00.000
define "TimeGreaterTrue_expected": true
define "TimeGreaterFalse": @T10:00:00.000 > @T10:00:00.001
define "TimeGreaterFalse_expected": false
define "UncertaintyGreaterNull": DateTime(2014) > DateTime(2014, 2, 15)
define "UncertaintyGreaterNull_expected": null
define "UncertaintyGreaterTrue": DateTime(2015) > DateTime(2014, 2, 15)
define "UncertaintyGreaterTrue_expected": true
define "UncertaintyGreaterFalse": DateTime(2013) > DateTime(2014, 2, 15)
define "UncertaintyGreaterFalse_expected": false
define "GreaterOrEqualZZ": 0 >= 0
define "GreaterOrEqualZZ_expected": true
define "GreaterOrEqualZ1": 0 >= 1
define "GreaterOrEqualZ1_expected": false
define "GreaterOrEqualZ1Long": 0L >= 10L
define "GreaterOrEqualZ1Long_expected": false
define "GreaterOrEqualZNeg1": 0 >= -1
define "GreaterOrEqualZNeg1_expected": true
define "GreaterOrEqualDecZZ": 0.0 >= 0.0
define "GreaterOrEqualDecZZ_expected": true
define "GreaterOrEqualDecZ1": 0.0 >= 1.0
define "GreaterOrEqualDecZ1_expected": false
define "GreaterOrEqualDecZNeg1": 0.0 >= -1.0
define "GreaterOrEqualDecZNeg1_expected": true
define "GreaterOrEqualDec1Int2": 1.0 >= 2
define "GreaterOrEqualDec1Int2_expected": false
define "GreaterOrEqualCM0CM0": 0'cm' >= 0'cm'
define "GreaterOrEqualCM0CM0_expected": true
define "GreaterOrEqualCM0CM1": 0'cm' >= 1'cm'
define "GreaterOrEqualCM0CM1_expected": false
define "GreaterOrEqualCM0NegCM1": 0'cm' >= -1'cm'
define "GreaterOrEqualCM0NegCM1_expected": true
define "GreaterOrEqualM1CM1": 1'm' >= 1'cm'
define "GreaterOrEqualM1CM1_expected": true
define "GreaterOrEqualM1CM10": 1'm' >= 10'cm'
define "GreaterOrEqualM1CM10_expected": true
define "GreaterOrEqualAA": 'a' >= 'a'
define "GreaterOrEqualAA_expected": true
define "GreaterOrEqualAB": 'a' >= 'b'
define "GreaterOrEqualAB_expected": false
define "GreaterOrEqualBA": 'b' >= 'a'
define "GreaterOrEqualBA_expected": true
define "GreaterOrEqualAThanAA": 'a' >= 'aa'
define "GreaterOrEqualAThanAA_expected": false
define "GreaterOrEqualAAThanA": 'aa' >= 'a'
define "GreaterOrEqualAAThanA_expected": true
define "GreaterOrEqualJackJill": 'Jack' >= 'Jill'
define "GreaterOrEqualJackJill_expected": false
define "DateTimeGreaterEqTrue": DateTime(2012, 2, 12, 0, 0, 0, 0) >= DateTime(2012, 2, 10, 0, 0, 0, 0)
define "DateTimeGreaterEqTrue_expected": true
define "DateTimeGreaterEqTrue2": DateTime(2012, 2, 12, 0, 0, 0, 0) >= DateTime(2012, 2, 12, 0, 0, 0, 0)
define "DateTimeGreaterEqTrue2_expected": true
define "DateTimeGreaterEqFalse": DateTime(2012, 2, 12, 0, 0, 0, 0) >= DateTime(2012, 2, 13, 0, 0, 0, 0)
define "DateTimeGreaterEqFalse_expected": false
define "TimeGreaterEqTrue": @T10:00:00.001 >= @T10:00:00.000
define "TimeGreaterEqTrue_expected": true
define "TimeGreaterEqTrue2": @T10:00:00.000 >= @T10:00:00.000
define "TimeGreaterEqTrue2_expected": true
define "TimeGreaterEqFalse": @T10:00:00.000 >= @T10:00:00.001
define "TimeGreaterEqFalse_expected": false
define "UncertaintyGreaterEqualNull": DateTime(2014) >= DateTime(2014, 2, 15)
define "UncertaintyGreaterEqualNull_expected": null
define "UncertaintyGreaterEqualTrue": DateTime(2015) >= DateTime(2014, 2, 15)
define "UncertaintyGreaterEqualTrue_expected": true
define "UncertaintyGreaterEqualFalse": DateTime(2013) >= DateTime(2014, 2, 15)
define "UncertaintyGreaterEqualFalse_expected": false
define "LessZZ": 0 < 0
define "LessZZ_expected": false
define "LessZ1": 0 < 1
define "LessZ1_expected": true
define "LessLong": 0L < 10L
define "LessLong_expected": true
define "LessLongNeg": -30L < -20L
define "LessLongNeg_expected": true
define "LessZNeg1": 0 < -1
define "LessZNeg1_expected": false
define "LessDecZZ": 0.0 < 0.0
define "LessDecZZ_expected": false
define "LessDecZ1": 0.0 < 1.0
define "LessDecZ1_expected": true
define "LessDecZNeg1": 0.0 < -1.0
define "LessDecZNeg1_expected": false
define "LessDec1Int2": 1.0 < 2
define "LessDec1Int2_expected": true
define "LessCM0CM0": 0'cm' < 0'cm'
define "LessCM0CM0_expected": false
define "LessCM0CM1": 0'cm' < 1'cm'
define "LessCM0CM1_expected": true
define "LessCM0NegCM1": 0'cm' < -1'cm'
define "LessCM0NegCM1_expected": false
define "LessM1CM1": 1'm' < 1'cm'
define "LessM1CM1_expected": false
define "LessM1CM10": 1'm' < 10'cm'
define "LessM1CM10_expected": false
define "LessAA": 'a' < 'a'
define "LessAA_expected": false
define "LessAB": 'a' < 'b'
define "LessAB_expected": true
define "LessBA": 'b' < 'a'
define "LessBA_expected": false
define "LessAThanAA": 'a' < 'aa'
define "LessAThanAA_expected": true
define "LessAAThanA": 'aa' < 'a'
define "LessAAThanA_expected": false
define "LessJackJill": 'Jack' < 'Jill'
define "LessJackJill_expected": true
define "DateTimeLessTrue": DateTime(2012, 2, 9) < DateTime(2012, 2, 10)
define "DateTimeLessTrue_expected": true
define "DateTimeLessFalse": DateTime(2012, 2, 14) < DateTime(2012, 2, 13)
define "DateTimeLessFalse_expected": false
define "TimeLessTrue": @T10:00:00.001 < @T10:00:00.002
define "TimeLessTrue_expected": true
define "TimeLessFalse": @T10:10:00.000 < @T10:00:00.001
define "TimeLessFalse_expected": false
define "UncertaintyLessNull": DateTime(2014) < DateTime(2014, 2, 15)
define "UncertaintyLessNull_expected": null
define "UncertaintyLessTrue": DateTime(2013) < DateTime(2014, 2, 15)
define "UncertaintyLessTrue_expected": true
define "UncertaintyLessFalse": DateTime(2015) < DateTime(2014, 2, 15)
define "UncertaintyLessFalse_expected": false
define "LessOrEqualZZ": 0 <= 0
define "LessOrEqualZZ_expected": true
define "LessOrEqualZ1": 0 <= 1
define "LessOrEqualZ1_expected": true
define "LessOrEqualZ1Long": 0L <= 10L
define "LessOrEqualZ1Long_expected": true
define "LessOrEqualZNeg1": 0 <= -1
define "LessOrEqualZNeg1_expected": false
define "LessOrEqualDecZZ": 0.0 <= 0.0
define "LessOrEqualDecZZ_expected": true
define "LessOrEqualDecZ1": 0.0 <= 1.0
define "LessOrEqualDecZ1_expected": true
define "LessOrEqualDecZNeg1": 0.0 <= -1.0
define "LessOrEqualDecZNeg1_expected": false
define "LessOrEqualDec1Int2": 1.0 <= 2
define "LessOrEqualDec1Int2_expected": true
define "LessOrEqualCM0CM0": 0'cm' <= 0'cm'
define "LessOrEqualCM0CM0_expected": true
define "LessOrEqualCM0CM1": 0'cm' <= 1'cm'
define "LessOrEqualCM0CM1_expected": true
define "LessOrEqualCM0NegCM1": 0'cm' <= -1'cm'
define "LessOrEqualCM0NegCM1_expected": false
define "LessOrEqualM1CM1": 1'm' <= 1'cm'
define "LessOrEqualM1CM1_expected": false
define "LessOrEqualM1CM10": 1'm' <= 10'cm'
define "LessOrEqualM1CM10_expected": false
define "LessOrEqualAA": 'a' <= 'a'
define "LessOrEqualAA_expected": true
define "LessOrEqualAB": 'a' <= 'b'
define "LessOrEqualAB_expected": true
define "LessOrEqualBA": 'b' <= 'a'
define "LessOrEqualBA_expected": false
define "LessOrEqualAThanAA": 'a' <= 'aa'
define "LessOrEqualAThanAA_expected": true
define "LessOrEqualAAThanA": 'aa' <= 'a'
define "LessOrEqualAAThanA_expected": false
define "LessOrEqualJackJill": 'Jack' <= 'Jill'
define "LessOrEqualJackJill_expected": true
define "DateTimeLessEqTrue": DateTime(2012, 2, 9, 0, 0, 0, 0) <= DateTime(2012, 2, 10, 0, 0, 0, 0)
define "DateTimeLessEqTrue_expected": true
define "DateTimeLessEqTrue2": DateTime(2012, 2, 12, 0, 0, 0, 0) <= DateTime(2012, 2, 12, 0, 0, 0, 0)
define "DateTimeLessEqTrue2_expected": true
define "DateTimeLessEqFalse": DateTime(2012, 2, 12, 1, 0, 0, 0) <= DateTime(2012, 2, 12, 0, 0, 0, 0)
define "DateTimeLessEqFalse_expected": false
define "TimeLessEqTrue": @T10:00:00.001 <= @T10:00:00.002
define "TimeLessEqTrue_expected": true
define "TimeLessEqTrue2": @T10:00:00.000 <= @T10:00:00.000
define "TimeLessEqTrue2_expected": true
define "TimeLessEqFalse": @T10:00:00.002 <= @T10:00:00.001
define "TimeLessEqFalse_expected": false
define "UncertaintyLessEqualNull": DateTime(2014) <= DateTime(2014, 2, 15)
define "UncertaintyLessEqualNull_expected": null
define "UncertaintyLessEqualTrue": DateTime(2013) <= DateTime(2014, 2, 15)
define "UncertaintyLessEqualTrue_expected": true
define "UncertaintyLessEqualFalse": DateTime(2015) <= DateTime(2014, 2, 15)
define "UncertaintyLessEqualFalse_expected": false
define "EquivTrueTrue": true ~ true
define "EquivTrueTrue_expected": true
define "EquivTrueFalse": true ~ false
define "EquivTrueFalse_expected": false
define "EquivFalseFalse": false ~ false
define "EquivFalseFalse_expected": true
define "EquivFalseTrue": false ~ true
define "EquivFalseTrue_expected": false
define "EquivNullNull": null as String ~ null
define "EquivNullNull_expected": true
define "EquivTrueNull": true ~ null
define "EquivTrueNull_expected": false
define "EquivNullTrue": null ~ true
define "EquivNullTrue_expected": false
define "EquivInt1Int1": 1 ~ 1
define "EquivInt1Int1_expected": true
define "EquivInt1Int2": 1 ~ 2
define "EquivInt1Int2_expected": false
define "EquivStringAStringA": 'a' ~ 'a'
define "EquivStringAStringA_expected": true
define "EquivStringAStringB": 'a' ~ 'b'
define "EquivStringAStringB_expected": false
define "EquivStringIgnoreCase": 'Abel' ~ 'abel'
define "EquivStringIgnoreCase_expected": true
define "EquivFloat1Float1": 1.0 ~ 1.0
define "EquivFloat1Float1_expected": true
define "EquivFloat1Float2": 1.0 ~ 2.0
define "EquivFloat1Float2_expected": false
define "EquivFloat1Float1WithZ": 1.0 ~ 1.00
define "EquivFloat1Float1WithZ_expected": true
define "EquivFloat1Float1WithPrecision": 1.5 ~ 1.55
define "EquivFloat1Float1WithPrecision_expected": false
define "EquivFloat1Float1WithPrecisionAndZ": 1.50 ~ 1.55
define "EquivFloat1Float1WithPrecisionAndZ_expected": false
define "EquivFloatTrailingZero": 1.001 ~ 1.000
define "EquivFloatTrailingZero_expected": true
define "EquivFloat1Int1": 1.0 ~ 1
define "EquivFloat1Int1_expected": true
define "EquivFloat1Int2": 1.0 ~ 2
define "EquivFloat1Int2_expected": false
define "EquivEqCM1CM1": 1'cm' ~ 1'cm'
define "EquivEqCM1CM1_expected": true
define "EquivEqCM1M01": 1'cm' ~ 0.01'm'
define "EquivEqCM1M01_expected": true
define "RatioEquivalent": 1'cm':2'cm' ~ 1'cm':2'cm'
define "RatioEquivalent_expected": true
define "RatioNotEquivalentDiffNumerator": 1'cm':2'cm' ~ 3'cm':2'cm'
define "RatioNotEquivalentDiffNumerator_expected": false
define "RatioNotEquivalentDiffDenominator": 1'cm':2'cm' ~ 1'cm':3'cm'
define "RatioNotEquivalentDiffDenominator_expected": false
define "EquivTupleJohnJohn": Tuple { Id : 1, Name : 'John' } ~ Tuple { Id : 1, Name : 'John' }
define "EquivTupleJohnJohn_expected": true
define "EquivTupleJohnJohnWithNulls": Tuple { Id : 1, Name : 'John', Position: null } ~ Tuple { Id : 1, Name : 'John', Position: null }
define "EquivTupleJohnJohnWithNulls_expected": true
define "EquivTupleJohnJane": Tuple { Id : 1, Name : 'John' } ~ Tuple { Id : 2, Name : 'Jane' }
define "EquivTupleJohnJane_expected": false
define "EquivTupleJohn1John2": Tuple { Id : 1, Name : 'John' } ~ Tuple { Id : 2, Name : 'John' }
define "EquivTupleJohn1John2_expected": false
define "EquivDateTimeTodayToday": Today() ~ Today()
define "EquivDateTimeTodayToday_expected": true
define "EquivDateTimeTodayYesterday": Today() ~ Today() - 1 days
define "EquivDateTimeTodayYesterday_expected": false
define "EquivTime10A10A": @T10:00:00.000 ~ @T10:00:00.000
define "EquivTime10A10A_expected": true
define "EquivTime10A10P": @T10:00:00.000 ~ @T22:00:00.000
define "EquivTime10A10P_expected": false
define "SimpleNotEqTrueTrue": true != true
define "SimpleNotEqTrueTrue_expected": false
define "SimpleNotEqTrueFalse": true != false
define "SimpleNotEqTrueFalse_expected": true
define "SimpleNotEqFalseFalse": false != false
define "SimpleNotEqFalseFalse_expected": false
define "SimpleNotEqFalseTrue": false != true
define "SimpleNotEqFalseTrue_expected": true
define "SimpleNotEqNullNull": null as String != null
define "SimpleNotEqNullNull_expected": null
define "SimpleNotEqTrueNull": true != null
define "SimpleNotEqTrueNull_expected": null
define "SimpleNotEqNullTrue": null != true
define "SimpleNotEqNullTrue_expected": null
define "SimpleNotEqInt1Int1": 1 != 1
define "SimpleNotEqInt1Int1_expected": false
define "SimpleNotEqInt1Int2": 1 != 2
define "SimpleNotEqInt1Int2_expected": true
define "SimpleNotEqLong1Long2": 1L != 2L
define "SimpleNotEqLong1Long2_expected": true
define "SimpleNotEqStringAStringA": 'a' != 'a'
define "SimpleNotEqStringAStringA_expected": false
define "SimpleNotEqStringAStringB": 'a' != 'b'
define "SimpleNotEqStringAStringB_expected": true
define "SimpleNotEqFloat1Float1": 1.0 != 1.0
define "SimpleNotEqFloat1Float1_expected": false
define "SimpleNotEqFloat1Float2": 1.0 != 2.0
define "SimpleNotEqFloat1Float2_expected": true
define "SimpleNotEqFloat1Int1": 1.0 != 1
define "SimpleNotEqFloat1Int1_expected": false
define "SimpleNotEqFloat1Int2": 1.0 != 2
define "SimpleNotEqFloat1Int2_expected": true
define "QuantityNotEqCM1CM1": 1'cm' != 1'cm'
define "QuantityNotEqCM1CM1_expected": false
define "QuantityNotEqCM1M01": 1'cm' != 0.01'm'
define "QuantityNotEqCM1M01_expected": false
define "TupleNotEqJohnJohn": Tuple{ Id : 1, Name : 'John' } != Tuple{ Id : 1, Name : 'John' }
define "TupleNotEqJohnJohn_expected": false
define "TupleNotEqJohnJane": Tuple{ Id : 1, Name : 'John' } != Tuple{ Id : 2, Name : 'Jane' }
define "TupleNotEqJohnJane_expected": true
define "TupleNotEqJohn1John2": Tuple{ Id : 1, Name : 'John' } != Tuple{ Id : 2, Name : 'John' }
define "TupleNotEqJohn1John2_expected": true
define "TupleNotEqJohn1John2WithNullName": Tuple{ Id : 1, Name : 'John' } != Tuple{ Id : 2, Name : null }
define "TupleNotEqJohn1John2WithNullName_expected": true
define "TupleNotEqDifferingNamesWithOneNullId": Tuple{ Id : null, Name : 'John' } != Tuple{ Id : 1, Name : 'Joe' }
define "TupleNotEqDifferingNamesWithOneNullId_expected": null
define "TupleNotEqJohn1John1WithBothNamesNull": Tuple{ Id : 1, Name : null } != Tuple{ Id : 1, Name : null }
define "TupleNotEqJohn1John1WithBothNamesNull_expected": false
define "TupleNotEqMatchingNamesWithNullIDs": Tuple{ Id : null, Name : 'John' } != Tuple{ Id : null, Name : 'John' }
define "TupleNotEqMatchingNamesWithNullIDs_expected": false
define "TupleNotEqJohn1John1WithNullName": Tuple{ Id : 1, Name : 'John' } != Tuple{ Id : 1, Name : null }
define "TupleNotEqJohn1John1WithNullName_expected": null
define "DateTimeNotEqTodayToday": Today() != Today()
define "DateTimeNotEqTodayToday_expected": false
define "DateTimeNotEqTodayYesterday": Today() != Today() - 1 days
define "DateTimeNotEqTodayYesterday_expected": true
define "TimeNotEq10A10A": @T10:00:00.000 != @T10:00:00.000
define "TimeNotEq10A10A_expected": false
define "TimeNotEq10A10P": @T10:00:00.000 != @T22:00:00.000
define "TimeNotEq10A10P_expected": true
define "TestQuantityMillisecondEqualMs": 1 millisecond = 1 'ms'
define "TestQuantityMillisecondEqualMs_expected": true
define "TestQuantityMillisecondEqualMilliseconds": 1 millisecond = 1 milliseconds
define "TestQuantityMillisecondEqualMilliseconds_expected": true
define "TestQuantityMillisecondsEqualMs": 1 milliseconds = 1 'ms'
define "TestQuantityMillisecondsEqualMs_expected": true
define "TestQuantitySecondEqualS": 1 second = 1 's'
define "TestQuantitySecondEqualS_expected": true
define "TestQuantitySecondEqualSeconds": 1 second = 1 seconds
define "TestQuantitySecondEqualSeconds_expected": true
define "TestQuantitySecondsEqualS": 1 seconds = 1 's'
define "TestQuantitySecondsEqualS_expected": true
define "TestQuantityMinuteEqualMin": 1 minute = 1 'min'
define "TestQuantityMinuteEqualMin_expected": true
define "TestQuantityMinuteEqualMinutes": 1 minute = 1 minutes
define "TestQuantityMinuteEqualMinutes_expected": true
define "TestQuantityMinutesEqualMin": 1 minutes = 1 'min'
define "TestQuantityMinutesEqualMin_expected": true
define "TestQuantityHourEqualH": 1 hour = 1 'h'
define "TestQuantityHourEqualH_expected": true
define "TestQuantityHourEqualHours": 1 hour = 1 hours
define "TestQuantityHourEqualHours_expected": true
define "TestQuantityHoursEqualH": 1 hours = 1 'h'
define "TestQuantityHoursEqualH_expected": true
define "TestQuantityDayEqualD": 1 day = 1 'd'
define "TestQuantityDayEqualD_expected": true
define "TestQuantityDayEqualDays": 1 day = 1 days
define "TestQuantityDayEqualDays_expected": true
define "TestQuantityDaysEqualD": 1 days = 1 'd'
define "TestQuantityDaysEqualD_expected": true
define "TestQuantityWeekEqualWk": 1 week = 1 'wk'
define "TestQuantityWeekEqualWk_expected": true
define "TestQuantityWeekEqualWeeks": 1 week = 1 weeks
define "TestQuantityWeekEqualWeeks_expected": true
define "TestQuantityWeeksEqualWk": 1 weeks = 1 'wk'
define "TestQuantityWeeksEqualWk_expected": true
define "TestQuantityMonthEqualMo": 1 month = 1 'mo'
define "TestQuantityMonthEqualMo_expected": null
define "TestQuantityMonthNotEqualMo": 1 month != 1 'mo'
define "TestQuantityMonthNotEqualMo_expected": null
define "TestQuantityMonthEquivalentMo": 1 month ~ 1 'mo'
define "TestQuantityMonthEquivalentMo_expected": true
define "TestQuantityMonthEqualMonths": 1 month = 1 months
define "TestQuantityMonthEqualMonths_expected": true
define "TestQuantityMonthsNotEqualMo": 1 months != 1 'mo'
define "TestQuantityMonthsNotEqualMo_expected": null
define "TestQuantityMonthsEquivalentMo": 1 months ~ 1 'mo'
define "TestQuantityMonthsEquivalentMo_expected": true
define "TestQuantityYearEqualA": 1 year = 1 'a'
define "TestQuantityYearEqualA_expected": null
define "TestQuantityYearNotEqualA": 1 year != 1 'a'
define "TestQuantityYearNotEqualA_expected": null
define "TestQuantityYearEquivalentA": 1 year ~ 1 'a'
define "TestQuantityYearEquivalentA_expected": true
define "TestQuantityYearsEqualYear": 1 years = 1 year
define "TestQuantityYearsEqualYear_expected": true
define "TestQuantityYearsNotEqualA": 1 years != 1 'a'
define "TestQuantityYearsNotEqualA_expected": null
define "TestQuantityYearsEquivalentA": 1 years ~ 1 'a'
define "TestQuantityYearsEquivalentA_expected": true
define "TestYearEquivalentMonths": 1 year ~ 12 months
define "TestYearEquivalentMonths_expected": true
define "TestYearEquivalentDays": 1 year ~ 365 days
define "TestYearEquivalentDays_expected": true
define "TestMonthEquivalentDays": 1 month ~ 30 days
define "TestMonthEquivalentDays_expected": true
define "TestWeekEqualDays": 1 week = 7 days
define "TestWeekEqualDays_expected": true
define "TestDayEqualHours": 1 day = 24 hours
define "TestDayEqualHours_expected": true
define "TestHourEqualMinutes": 1 hour = 60 minutes
define "TestHourEqualMinutes_expected": true
define "TestMinuteEqualSeconds": 1 minute = 60 seconds
define "TestMinuteEqualSeconds_expected": true
define "TestSecondEqualMilliseconds": 1 second = 1000 milliseconds
define "TestSecondEqualMilliseconds_expected": true
