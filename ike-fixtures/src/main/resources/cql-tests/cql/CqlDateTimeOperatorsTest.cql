library CqlDateTimeOperatorsTest version '1.0'

define "DateTimeAdd5Years": DateTime(2005, 10, 10) + 5 years
define "DateTimeAdd5Years_expected": @2010-10-10T
define "DateTimeAdd5Months": DateTime(2005, 5, 10) + 5 months
define "DateTimeAdd5Months_expected": @2005-10-10T
define "DateTimeAddMonthsOverflow": DateTime(2005, 5, 10) + 10 months
define "DateTimeAddMonthsOverflow_expected": @2006-03-10T
define "DateTimeAddThreeWeeks": DateTime(2018, 5, 2) + 3 weeks = DateTime(2018, 5, 23)
define "DateTimeAddThreeWeeks_expected": true
define "DateTimeAddYearInWeeks": DateTime(2018, 5, 23) + 52 weeks = DateTime(2019, 5, 22)
define "DateTimeAddYearInWeeks_expected": true
define "DateTimeLeapDayAddYearInWeeks": DateTime(2023, 3, 2) + 52 weeks = DateTime(2024, 2, 29)
define "DateTimeLeapDayAddYearInWeeks_expected": true
define "DateTimeLeapYearAddYearInWeeks": DateTime(2024, 2, 28) + 52 weeks = DateTime(2025, 2, 26)
define "DateTimeLeapYearAddYearInWeeks_expected": true
define "DateTimeAdd5Days": DateTime(2005, 5, 10) + 5 days
define "DateTimeAdd5Days_expected": @2005-05-15T
define "DateTimeAddDaysOverflow": DateTime(2016, 6, 10) + 21 days
define "DateTimeAddDaysOverflow_expected": @2016-07-01T
define "DateTimeAdd5Hours": DateTime(2005, 5, 10, 5) + 5 hours
define "DateTimeAdd5Hours_expected": @2005-05-10T10
define "DateTimeAdd5HoursWithLeftMinPrecisionSecond": DateTime(2005, 5, 10, 5, 20, 30) + 5 hours
define "DateTimeAdd5HoursWithLeftMinPrecisionSecond_expected": @2005-05-10T10:20:30
define "DateTimeAdd5HoursWithLeftMinPrecisionDay": DateTime(2005, 5, 10) + 5 hours = DateTime(2005, 5, 10)
define "DateTimeAdd5HoursWithLeftMinPrecisionDay_expected": true
define "DateTimeAdd5HoursWithLeftMinPrecisionDayOverflow": DateTime(2005, 5, 10) + 25 hours = DateTime(2005, 5, 11)
define "DateTimeAdd5HoursWithLeftMinPrecisionDayOverflow_expected": true
define "DateAdd2YearsAsMonths": Date(2014) + 24 months
define "DateAdd2YearsAsMonths_expected": @2016
define "DateAdd2YearsAsMonthsRem1": Date(2014) + 25 months
define "DateAdd2YearsAsMonthsRem1_expected": @2016
define "DateAdd33Days": Date(2014,6) + 33 days
define "DateAdd33Days_expected": @2014-07
define "DateAdd1Year": Date(2014,6) + 1 year
define "DateAdd1Year_expected": @2015-06
define "DateTimeAddHoursOverflow": DateTime(2016, 6, 10, 5) + 19 hours
define "DateTimeAddHoursOverflow_expected": @2016-06-11T00
define "DateTimeAdd5Minutes": DateTime(2005, 5, 10, 5, 5) + 5 minutes
define "DateTimeAdd5Minutes_expected": @2005-05-10T05:10
define "DateTimeAddMinutesOverflow": DateTime(2016, 6, 10, 5, 5) + 55 minutes
define "DateTimeAddMinutesOverflow_expected": @2016-06-10T06:00
define "DateTimeAdd5Seconds": DateTime(2005, 5, 10, 5, 5, 5) + 5 seconds
define "DateTimeAdd5Seconds_expected": @2005-05-10T05:05:10
define "DateTimeAddSecondsOverflow": DateTime(2016, 6, 10, 5, 5, 5) + 55 seconds
define "DateTimeAddSecondsOverflow_expected": @2016-06-10T05:06:00
define "DateTimeAdd5Milliseconds": DateTime(2005, 5, 10, 5, 5, 5, 5) + 5 milliseconds
define "DateTimeAdd5Milliseconds_expected": @2005-05-10T05:05:05.010
define "DateTimeAddMillisecondsOverflow": DateTime(2016, 6, 10, 5, 5, 5, 5) + 995 milliseconds
define "DateTimeAddMillisecondsOverflow_expected": @2016-06-10T05:05:06.000
define "DateTimeAddLeapYear": DateTime(2012, 2, 29) + 1 year
define "DateTimeAddLeapYear_expected": @2013-02-28T
define "DateTimeAdd2YearsByMonths": DateTime(2014) + 24 months
define "DateTimeAdd2YearsByMonths_expected": @2016T
define "DateTimeAdd2YearsByDays": DateTime(2014) + 730 days
define "DateTimeAdd2YearsByDays_expected": @2016T
define "DateTimeAdd2YearsByDaysRem5Days": DateTime(2014) + 735 days
define "DateTimeAdd2YearsByDaysRem5Days_expected": @2016T
define "TimeAdd5Hours": @T15:59:59.999 + 5 hours
define "TimeAdd5Hours_expected": @T20:59:59.999
define "TimeAdd1Minute": @T15:59:59.999 + 1 minute
define "TimeAdd1Minute_expected": @T16:00:59.999
define "TimeAdd1Second": @T15:59:59.999 + 1 seconds
define "TimeAdd1Second_expected": @T16:00:00.999
define "TimeAdd1Millisecond": @T15:59:59.999 + 1 milliseconds
define "TimeAdd1Millisecond_expected": @T16:00:00.000
define "TimeAdd5Hours1Minute": @T15:59:59.999 + 5 hours + 1 minutes
define "TimeAdd5Hours1Minute_expected": @T21:00:59.999
define "TimeAdd5hoursByMinute": @T15:59:59.999 + 300 minutes
define "TimeAdd5hoursByMinute_expected": @T20:59:59.999
define "DateTimeAfterYearTrue": DateTime(2005, 10, 10) after year of DateTime(2004, 10, 10)
define "DateTimeAfterYearTrue_expected": true
define "DateTimeAfterYearFalse": DateTime(2004, 11, 10) after year of DateTime(2004, 10, 10)
define "DateTimeAfterYearFalse_expected": false
define "DateTimeAfterMonthTrue": DateTime(2004, 12, 10) after month of DateTime(2004, 11, 10)
define "DateTimeAfterMonthTrue_expected": true
define "DateTimeAfterMonthFalse": DateTime(2004, 9, 10) after month of DateTime(2004, 10, 10)
define "DateTimeAfterMonthFalse_expected": false
define "DateTimeAfterDayTrue": DateTime(2004, 12, 11) after day of DateTime(2004, 10, 10)
define "DateTimeAfterDayTrue_expected": true
define "DateTimeAfterDayTrue2": DateTime(2004, 12, 09) after day of DateTime(2003, 10, 10)
define "DateTimeAfterDayTrue2_expected": true
define "DateTimeAfterDayFalse": DateTime(2004, 10, 9) after day of DateTime(2004, 10, 10)
define "DateTimeAfterDayFalse_expected": false
define "DateTimeAfterHourTrue": DateTime(2004, 10, 10, 10) after hour of DateTime(2004, 10, 10, 5)
define "DateTimeAfterHourTrue_expected": true
define "DateTimeAfterHourFalse": DateTime(2004, 10, 10, 20) after hour of DateTime(2004, 10, 10, 21)
define "DateTimeAfterHourFalse_expected": false
define "DateTimeAfterMinuteTrue": DateTime(2004, 10, 10, 20, 30) after minute of DateTime(2004, 10, 10, 20, 29)
define "DateTimeAfterMinuteTrue_expected": true
define "DateTimeAfterMinuteFalse": DateTime(2004, 10, 10, 20, 30) after minute of DateTime(2004, 10, 10, 20, 31)
define "DateTimeAfterMinuteFalse_expected": false
define "DateTimeAfterSecondTrue": DateTime(2004, 10, 10, 20, 30, 15) after second of DateTime(2004, 10, 10, 20, 30, 14)
define "DateTimeAfterSecondTrue_expected": true
define "DateTimeAfterSecondFalse": DateTime(2004, 10, 10, 20, 30, 15) after second of DateTime(2004, 10, 10, 20, 30, 16)
define "DateTimeAfterSecondFalse_expected": false
define "DateTimeAfterMillisecondTrue": DateTime(2004, 10, 10, 20, 30, 15, 512) after millisecond of DateTime(2004, 10, 10, 20, 30, 15, 510)
define "DateTimeAfterMillisecondTrue_expected": true
define "DateTimeAfterMillisecondFalse": DateTime(2004, 10, 10, 20, 30, 15, 512) after millisecond of DateTime(2004, 10, 10, 20, 30, 15, 513)
define "DateTimeAfterMillisecondFalse_expected": false
define "DateTimeAfterUncertain": DateTime(2005, 10, 10) after day of DateTime(2005, 9)
define "DateTimeAfterUncertain_expected": true
define "AfterTimezoneTrue": @2012-03-10T10:20:00.999+07:00 after hour of @2012-03-10T08:20:00.999+06:00
define "AfterTimezoneTrue_expected": true
define "AfterTimezoneFalse": @2012-03-10T10:20:00.999+07:00 after hour of @2012-03-10T10:20:00.999+06:00
define "AfterTimezoneFalse_expected": false
define "TimeAfterHourTrue": @T15:59:59.999 after hour of @T14:59:59.999
define "TimeAfterHourTrue_expected": true
define "TimeAfterHourFalse": @T15:59:59.999 after hour of @T16:59:59.999
define "TimeAfterHourFalse_expected": false
define "TimeAfterMinuteTrue": @T15:59:59.999 after minute of @T15:58:59.999
define "TimeAfterMinuteTrue_expected": true
define "TimeAfterMinuteFalse": @T15:58:59.999 after minute of @T15:59:59.999
define "TimeAfterMinuteFalse_expected": false
define "TimeAfterSecondTrue": @T15:59:59.999 after second of @T15:59:58.999
define "TimeAfterSecondTrue_expected": true
define "TimeAfterSecondFalse": @T15:59:58.999 after second of @T15:59:59.999
define "TimeAfterSecondFalse_expected": false
define "TimeAfterMillisecondTrue": @T15:59:59.999 after millisecond of @T15:59:59.998
define "TimeAfterMillisecondTrue_expected": true
define "TimeAfterMillisecondFalse": @T15:59:59.998 after millisecond of @T15:59:59.999
define "TimeAfterMillisecondFalse_expected": false
define "TimeAfterTimeCstor": Time(12, 30) after hour of Time(11, 55)
define "TimeAfterTimeCstor_expected": true
define "DateTimeBeforeYearTrue": DateTime(2003) before year of DateTime(2004, 10, 10)
define "DateTimeBeforeYearTrue_expected": true
define "DateTimeBeforeYearFalse": DateTime(2004, 11, 10) before year of DateTime(2003, 10, 10)
define "DateTimeBeforeYearFalse_expected": false
define "DateTimeBeforeMonthTrue": DateTime(2004, 10, 10) before month of DateTime(2004, 11, 10)
define "DateTimeBeforeMonthTrue_expected": true
define "DateTimeBeforeMonthFalse": DateTime(2004, 11, 10) before month of DateTime(2004, 10, 10)
define "DateTimeBeforeMonthFalse_expected": false
define "DateTimeBeforeDayTrue": DateTime(2004, 10, 1) before day of DateTime(2004, 10, 10)
define "DateTimeBeforeDayTrue_expected": true
define "DateTimeBeforeDayTrue2": DateTime(2003, 10, 11) before day of DateTime(2004, 10, 10)
define "DateTimeBeforeDayTrue2_expected": true
define "DateTimeBeforeDayFalse": DateTime(2004, 10, 11) before day of DateTime(2004, 10, 10)
define "DateTimeBeforeDayFalse_expected": false
define "DateTimeBeforeHourTrue": DateTime(2004, 10, 10, 1) before hour of DateTime(2004, 10, 10, 5)
define "DateTimeBeforeHourTrue_expected": true
define "DateTimeBeforeHourFalse": DateTime(2004, 10, 10, 23) before hour of DateTime(2004, 10, 10, 21)
define "DateTimeBeforeHourFalse_expected": false
define "DateTimeBeforeMinuteTrue": DateTime(2004, 10, 10, 20, 28) before minute of DateTime(2004, 10, 10, 20, 29)
define "DateTimeBeforeMinuteTrue_expected": true
define "DateTimeBeforeMinuteFalse": DateTime(2004, 10, 10, 20, 35) before minute of DateTime(2004, 10, 10, 20, 31)
define "DateTimeBeforeMinuteFalse_expected": false
define "DateTimeBeforeSecondTrue": DateTime(2004, 10, 10, 20, 30, 12) before second of DateTime(2004, 10, 10, 20, 30, 14)
define "DateTimeBeforeSecondTrue_expected": true
define "DateTimeBeforeSecondFalse": DateTime(2004, 10, 10, 20, 30, 55) before second of DateTime(2004, 10, 10, 20, 30, 16)
define "DateTimeBeforeSecondFalse_expected": false
define "DateTimeBeforeMillisecondTrue": DateTime(2004, 10, 10, 20, 30, 15, 508) before millisecond of DateTime(2004, 10, 10, 20, 30, 15, 510)
define "DateTimeBeforeMillisecondTrue_expected": true
define "DateTimeBeforeMillisecondFalse": DateTime(2004, 10, 10, 20, 30, 15, 599) before millisecond of DateTime(2004, 10, 10, 20, 30, 15, 513)
define "DateTimeBeforeMillisecondFalse_expected": false
define "BeforeTimezoneTrue": @2012-03-10T10:20:00.999+07:00 before hour of @2012-03-10T10:20:00.999+06:00
define "BeforeTimezoneTrue_expected": true
define "BeforeTimezoneFalse": @2012-03-10T10:20:00.999+07:00 before hour of @2012-03-10T09:20:00.999+06:00
define "BeforeTimezoneFalse_expected": false
define "TimeBeforeHourTrue": @T13:59:59.999 before hour of @T14:59:59.999
define "TimeBeforeHourTrue_expected": true
define "TimeBeforeHourFalse": @T16:59:59.999 before hour of @T15:59:59.999
define "TimeBeforeHourFalse_expected": false
define "TimeBeforeMinuteTrue": @T15:57:59.999 before minute of @T15:58:59.999
define "TimeBeforeMinuteTrue_expected": true
define "TimeBeforeMinuteFalse": @T15:59:59.999 before minute of @T15:59:59.999
define "TimeBeforeMinuteFalse_expected": false
define "TimeBeforeSecondTrue": @T15:59:57.999 before second of @T15:59:58.999
define "TimeBeforeSecondTrue_expected": true
define "TimeBeforeSecondFalse": @T15:59:56.999 before second of @T15:59:55.999
define "TimeBeforeSecondFalse_expected": false
define "TimeBeforeMillisecondTrue": @T15:59:59.997 before millisecond of @T15:59:59.998
define "TimeBeforeMillisecondTrue_expected": true
define "TimeBeforeMillisecondFalse": @T15:59:59.998 before millisecond of @T15:59:59.997
define "TimeBeforeMillisecondFalse_expected": false
define "DateTimeYear": DateTime(2003)
define "DateTimeYear_expected": @2003T
define "DateTimeMonth": DateTime(2003, 10)
define "DateTimeMonth_expected": @2003-10T
define "DateTimeDay": DateTime(2003, 10, 29)
define "DateTimeDay_expected": @2003-10-29T
define "DateTimeHour": DateTime(2003, 10, 29, 20)
define "DateTimeHour_expected": @2003-10-29T20
define "DateTimeMinute": DateTime(2003, 10, 29, 20, 50)
define "DateTimeMinute_expected": @2003-10-29T20:50
define "DateTimeSecond": DateTime(2003, 10, 29, 20, 50, 33)
define "DateTimeSecond_expected": @2003-10-29T20:50:33
define "DateTimeMillisecond": DateTime(2003, 10, 29, 20, 50, 33, 955)
define "DateTimeMillisecond_expected": @2003-10-29T20:50:33.955
define "DateTimeComponentFromYear": year from DateTime(2003, 10, 29, 20, 50, 33, 955)
define "DateTimeComponentFromYear_expected": 2003
define "DateTimeComponentFromMonth": month from DateTime(2003, 10, 29, 20, 50, 33, 955)
define "DateTimeComponentFromMonth_expected": 10
define "DateTimeComponentFromMonthMinBoundary": month from DateTime(2003, 01, 29, 20, 50, 33, 955)
define "DateTimeComponentFromMonthMinBoundary_expected": 1
define "DateTimeComponentFromDay": day from DateTime(2003, 10, 29, 20, 50, 33, 955)
define "DateTimeComponentFromDay_expected": 29
define "DateTimeComponentFromHour": hour from DateTime(2003, 10, 29, 20, 50, 33, 955)
define "DateTimeComponentFromHour_expected": 20
define "DateTimeComponentFromMinute": minute from DateTime(2003, 10, 29, 20, 50, 33, 955)
define "DateTimeComponentFromMinute_expected": 50
define "DateTimeComponentFromSecond": second from DateTime(2003, 10, 29, 20, 50, 33, 955)
define "DateTimeComponentFromSecond_expected": 33
define "DateTimeComponentFromMillisecond": millisecond from DateTime(2003, 10, 29, 20, 50, 33, 955)
define "DateTimeComponentFromMillisecond_expected": 955
define "DateTimeComponentFromTimezone": timezoneoffset from DateTime(2003, 10, 29, 20, 50, 33, 955, 1)
define "DateTimeComponentFromTimezone_expected": 1.00
define "DateTimeComponentFromDate": date from DateTime(2003, 10, 29, 20, 50, 33, 955, 1)
define "DateTimeComponentFromDate_expected": @2003-10-29
define "TimeComponentFromHour": hour from @T23:20:15.555
define "TimeComponentFromHour_expected": 23
define "TimeComponentFromMinute": minute from @T23:20:15.555
define "TimeComponentFromMinute_expected": 20
define "TimeComponentFromSecond": second from @T23:20:15.555
define "TimeComponentFromSecond_expected": 15
define "TimeComponentFromMilli": millisecond from @T23:20:15.555
define "TimeComponentFromMilli_expected": 555
define "DateTimeDifferenceYear": difference in years between DateTime(2000) and DateTime(2005, 12)
define "DateTimeDifferenceYear_expected": 5
define "DateTimeDifferenceMonth": difference in months between DateTime(2000, 2) and DateTime(2000, 10)
define "DateTimeDifferenceMonth_expected": 8
define "DateTimeDifferenceDay": difference in days between DateTime(2000, 10, 15, 10, 30) and DateTime(2000, 10, 25, 10, 0)
define "DateTimeDifferenceDay_expected": 10
define "DateTimeDifferenceHour": difference in hours between DateTime(2000, 4, 1, 12) and DateTime(2000, 4, 1, 20)
define "DateTimeDifferenceHour_expected": 8
define "DateTimeDifferenceMinute": difference in minutes between DateTime(2005, 12, 10, 5, 16) and DateTime(2005, 12, 10, 5, 25)
define "DateTimeDifferenceMinute_expected": 9
define "DateTimeDifferenceSecond": difference in seconds between DateTime(2000, 10, 10, 10, 5, 45) and DateTime(2000, 10, 10, 10, 5, 50)
define "DateTimeDifferenceSecond_expected": 5
define "DateTimeDifferenceMillisecond": difference in milliseconds between DateTime(2000, 10, 10, 10, 5, 45, 500, -6.0) and DateTime(2000, 10, 10, 10, 5, 45, 900, -7.0)
define "DateTimeDifferenceMillisecond_expected": 3600400
define "DateTimeDifferenceWeeks": difference in weeks between DateTime(2000, 10, 15) and DateTime(2000, 10, 28)
define "DateTimeDifferenceWeeks_expected": 1
define "DateTimeDifferenceWeeks2": difference in weeks between DateTime(2000, 10, 15) and DateTime(2000, 10, 29)
define "DateTimeDifferenceWeeks2_expected": 2
define "DateTimeDifferenceWeeks3": difference in weeks between @2012-03-10T22:05:09 and @2012-03-24T07:19:33
define "DateTimeDifferenceWeeks3_expected": 2
define "DateTimeDifferenceNegative": difference in years between DateTime(2016) and DateTime(1998)
define "DateTimeDifferenceNegative_expected": -18
define "DateTimeDifferenceUncertain": difference in months between DateTime(2005) and DateTime(2006, 7) > 5
define "DateTimeDifferenceUncertain_expected": true
define "TimeDifferenceHour": difference in hours between @T20 and @T23:25:15.555
define "TimeDifferenceHour_expected": 3
define "TimeDifferenceMinute": difference in minutes between @T20:20:15.555 and @T20:25:15.555
define "TimeDifferenceMinute_expected": 5
define "TimeDifferenceSecond": difference in seconds between @T20:20:15.555 and @T20:20:20.555
define "TimeDifferenceSecond_expected": 5
define "TimeDifferenceMillis": difference in milliseconds between @T20:20:15.555 and @T20:20:15.550
define "TimeDifferenceMillis_expected": -5
define "DateTimeA": @2017-03-12T01:00:00-07:00
define "DateTimeA_expected": @2017-03-12T01:00:00-07:00
define "DateTimeAA": DateTime(2017, 3, 12, 1, 0, 0, 0, -7.0)
define "DateTimeAA_expected": @2017-03-12T01:00:00.000-07:00
define "DateTimeB": @2017-03-12T03:00:00-06:00
define "DateTimeB_expected": @2017-03-12T03:00:00-06:00
define "DateTimeBB": DateTime(2017, 3, 12, 3, 0, 0, 0, -6.0)
define "DateTimeBB_expected": @2017-03-12T03:00:00.000-06:00
define "DateTimeC": @2017-11-05T01:30:00-06:00
define "DateTimeC_expected": @2017-11-05T01:30:00-06:00
define "DateTimeCC": DateTime(2017, 11, 5, 1, 30, 0, 0, -6.0)
define "DateTimeCC_expected": @2017-11-05T01:30:00.000-06:00
define "DateTimeD": @2017-11-05T01:15:00-07:00
define "DateTimeD_expected": @2017-11-05T01:15:00-07:00
define "DateTimeDD": DateTime(2017, 11, 5, 1, 15, 0, 0, -7.0)
define "DateTimeDD_expected": @2017-11-05T01:15:00.000-07:00
define "DateTimeE": @2017-03-12T00:00:00-07:00
define "DateTimeE_expected": @2017-03-12T00:00:00-07:00
define "DateTimeEE": DateTime(2017, 3, 12, 0, 0, 0, 0, -7.0)
define "DateTimeEE_expected": @2017-03-12T00:00:00.000-07:00
define "DateTimeF": @2017-03-13T00:00:00-06:00
define "DateTimeF_expected": @2017-03-13T00:00:00-06:00
define "DateTimeFF": DateTime(2017, 3, 13, 0, 0, 0, 0, -6.0)
define "DateTimeFF_expected": @2017-03-13T00:00:00.000-06:00
define "DifferenceInHoursA": difference in hours between @2017-03-12T01:00:00-07:00 and @2017-03-12T03:00:00-06:00
define "DifferenceInHoursA_expected": 1
define "DifferenceInMinutesA": difference in minutes between @2017-11-05T01:30:00-06:00 and @2017-11-05T01:15:00-07:00
define "DifferenceInMinutesA_expected": 45
define "DifferenceInDaysA": difference in days between @2017-03-12T00:00:00-07:00 and @2017-03-13T00:00:00-06:00
define "DifferenceInDaysA_expected": 1
define "DifferenceInHoursAA": difference in hours between DateTime(2017, 3, 12, 1, 0, 0, 0, -7.0) and DateTime(2017, 3, 12, 3, 0, 0, 0, -6.0)
define "DifferenceInHoursAA_expected": 1
define "DifferenceInMinutesAA": difference in minutes between DateTime(2017, 11, 5, 1, 30, 0, 0, -6.0) and DateTime(2017, 11, 5, 1, 15, 0, 0, -7.0)
define "DifferenceInMinutesAA_expected": 45
define "DifferenceInDaysAA": difference in days between DateTime(2017, 3, 12, 0, 0, 0, 0, -7.0) and DateTime(2017, 3, 13, 0, 0, 0, 0, -6.0)
define "DifferenceInDaysAA_expected": 1
define "DateTimeDurationBetweenYear": years between DateTime(2005) and DateTime(2010)
define "DateTimeDurationBetweenYear_expected": Interval[ 4, 5 ]
define "DateTimeDurationBetweenYearOffset": years between DateTime(2005, 5) and DateTime(2010, 4)
define "DateTimeDurationBetweenYearOffset_expected": 4
define "YearsBetweenLeapYearDatesEquals2": years between @2012-02-29 and @2014-02-28
define "YearsBetweenLeapYearDatesEquals2_expected": 2
define "YearsBetweenLeapYearDateTimesEquals2": years between @2012-02-29T12:34:56 and @2014-02-28T12:34:56
define "YearsBetweenLeapYearDateTimesEquals2_expected": 2
define "DateTimeDurationBetweenMonth": months between @2014-01-31 and @2014-02-01
define "DateTimeDurationBetweenMonth_expected": 0
define "DateTimeDurationBetweenDaysDiffYears": days between DateTime(2010, 10, 12, 12, 5) and DateTime(2008, 8, 15, 8, 8)
define "DateTimeDurationBetweenDaysDiffYears_expected": -788
define "DateTimeDurationBetweenUncertainInterval": days between DateTime(2014, 1, 15) and DateTime(2014, 2)
define "DateTimeDurationBetweenUncertainInterval_expected": Interval[ 17, 44 ]
define "DateTimeDurationBetweenUncertainInterval2": months between DateTime(2005) and DateTime(2006, 5)
define "DateTimeDurationBetweenUncertainInterval2_expected": Interval[ 4, 16 ]
define "DateTimeDurationBetweenUncertainAdd": (days between DateTime(2014, 1, 15) and DateTime(2014, 2))
				+ (days between DateTime(2014, 1, 15) and DateTime(2014, 2))
define "DateTimeDurationBetweenUncertainAdd_expected": Interval[ 32, 88 ]
define "DateTimeDurationBetweenUncertainSubtract": (days between DateTime(2014, 1, 15) and DateTime(2014, 2))
				- (months between DateTime(2005) and DateTime(2006, 5))
define "DateTimeDurationBetweenUncertainSubtract_expected": Interval[ 0, 40 ]
define "DateTimeDurationBetweenUncertainMultiply": (days between DateTime(2014, 1, 15) and DateTime(2014, 2))
				* (days between DateTime(2014, 1, 15) and DateTime(2014, 2))
define "DateTimeDurationBetweenUncertainMultiply_expected": Interval[ 256, 1936 ]
define "DateTimeDurationBetweenMonthUncertain": months between DateTime(2005) and DateTime(2006, 7) > 5
define "DateTimeDurationBetweenMonthUncertain_expected": true
define "DateTimeDurationBetweenMonthUncertain2": months between DateTime(2005) and DateTime(2006, 2) > 5
define "DateTimeDurationBetweenMonthUncertain2_expected": null
define "DateTimeDurationBetweenMonthUncertain3": months between DateTime(2005) and DateTime(2006, 7) > 25
define "DateTimeDurationBetweenMonthUncertain3_expected": false
define "DateTimeDurationBetweenMonthUncertain4": months between DateTime(2005) and DateTime(2006, 7) < 24
define "DateTimeDurationBetweenMonthUncertain4_expected": true
define "DateTimeDurationBetweenMonthUncertain5": months between DateTime(2005) and DateTime(2006, 7) = 24
define "DateTimeDurationBetweenMonthUncertain5_expected": false
define "DateTimeDurationBetweenMonthUncertain6": months between DateTime(2005) and DateTime(2006, 7) >= 5
define "DateTimeDurationBetweenMonthUncertain6_expected": true
define "DateTimeDurationBetweenMonthUncertain7": months between DateTime(2005) and DateTime(2006, 7) <= 24
define "DateTimeDurationBetweenMonthUncertain7_expected": true
define "DateTime1": @2012-03-10T10:20:00
define "DateTime1_expected": @2012-03-10T10:20:00
define "DateTime2": @2013-03-10T09:20:00
define "DateTime2_expected": @2013-03-10T09:20:00
define "DurationInYears": years between (date from @2012-03-10T10:20:00) and (date from @2013-03-10T09:20:00)
define "DurationInYears_expected": 1
define "DurationInWeeks": weeks between @2012-03-10T22:05:09 and @2012-03-20T07:19:33
define "DurationInWeeks_expected": 1
define "DurationInWeeks2": weeks between @2012-03-10T22:05:09 and @2012-03-24T07:19:33
define "DurationInWeeks2_expected": 1
define "DurationInWeeks3": weeks between @2012-03-10T06:05:09 and @2012-03-24T07:19:33
define "DurationInWeeks3_expected": 2
define "TimeDurationBetweenHour": hours between @T20:26:15.555 and @T23:25:15.555
define "TimeDurationBetweenHour_expected": 2
define "TimeDurationBetweenHourDiffPrecision2": hours between @T06 and @T07:00:00
define "TimeDurationBetweenHourDiffPrecision2_expected": 1
define "TimeDurationBetweenMinute": minutes between @T23:20:16.555 and @T23:25:15.555
define "TimeDurationBetweenMinute_expected": 4
define "TimeDurationBetweenSecond": seconds between @T23:25:10.556 and @T23:25:15.555
define "TimeDurationBetweenSecond_expected": 4
define "TimeDurationBetweenMillis": milliseconds between @T23:25:25.555 and @T23:25:25.560
define "TimeDurationBetweenMillis_expected": 5
define "DurationInHoursA": hours between @2017-03-12T01:00:00-07:00 and @2017-03-12T03:00:00-06:00
define "DurationInHoursA_expected": 1
define "DurationInMinutesA": minutes between @2017-11-05T01:30:00-06:00 and @2017-11-05T01:15:00-07:00
define "DurationInMinutesA_expected": 45
define "DurationInDaysA": days between @2017-03-12T00:00:00-07:00 and @2017-03-13T00:00:00-06:00
define "DurationInDaysA_expected": 0
define "DurationInHoursAA": hours between DateTime(2017, 3, 12, 1, 0, 0, 0, -7.0) and DateTime(2017, 3, 12, 3, 0, 0, 0, -6.0)
define "DurationInHoursAA_expected": 1
define "DurationInMinutesAA": minutes between DateTime(2017, 11, 5, 1, 30, 0, 0, -6.0) and DateTime(2017, 11, 5, 1, 15, 0, 0, -7.0)
define "DurationInMinutesAA_expected": 45
define "DurationInDaysAA": days between DateTime(2017, 3, 12, 0, 0, 0, 0, -7.0) and DateTime(2017, 3, 13, 0, 0, 0, 0, -6.0)
define "DurationInDaysAA_expected": 0
define "DateTimeNow": Now() = Now()
define "DateTimeNow_expected": true
define "DateTimeSameAsYearTrue": DateTime(2014) same year as DateTime(2014)
define "DateTimeSameAsYearTrue_expected": true
define "DateTimeSameAsYearFalse": DateTime(2013) same year as DateTime(2014)
define "DateTimeSameAsYearFalse_expected": false
define "DateTimeSameAsMonthTrue": DateTime(2014, 12) same month as DateTime(2014, 12)
define "DateTimeSameAsMonthTrue_expected": true
define "DateTimeSameAsMonthFalse": DateTime(2014, 12) same month as DateTime(2014, 10)
define "DateTimeSameAsMonthFalse_expected": false
define "DateTimeSameAsDayTrue": DateTime(2014, 12, 10) same day as DateTime(2014, 12, 10)
define "DateTimeSameAsDayTrue_expected": true
define "DateTimeSameAsDayFalse": DateTime(2014, 10, 10) same day as DateTime(2014, 10, 11)
define "DateTimeSameAsDayFalse_expected": false
define "DateTimeSameAsHourTrue": DateTime(2014, 12, 10, 20) same hour as DateTime(2014, 12, 10, 20)
define "DateTimeSameAsHourTrue_expected": true
define "DateTimeSameAsHourFalse": DateTime(2014, 10, 10, 20) same hour as DateTime(2014, 10, 10, 21)
define "DateTimeSameAsHourFalse_expected": false
define "DateTimeSameAsMinuteTrue": DateTime(2014, 12, 10, 20, 55) same minute as DateTime(2014, 12, 10, 20, 55)
define "DateTimeSameAsMinuteTrue_expected": true
define "DateTimeSameAsMinuteFalse": DateTime(2014, 10, 10, 20, 55) same minute as DateTime(2014, 10, 10, 21, 56)
define "DateTimeSameAsMinuteFalse_expected": false
define "DateTimeSameAsSecondTrue": DateTime(2014, 12, 10, 20, 55, 45) same second as DateTime(2014, 12, 10, 20, 55, 45)
define "DateTimeSameAsSecondTrue_expected": true
define "DateTimeSameAsSecondFalse": DateTime(2014, 10, 10, 20, 55, 45) same second as DateTime(2014, 10, 10, 21, 55, 44)
define "DateTimeSameAsSecondFalse_expected": false
define "DateTimeSameAsMillisecondTrue": DateTime(2014, 12, 10, 20, 55, 45, 500) same millisecond as DateTime(2014, 12, 10, 20, 55, 45, 500)
define "DateTimeSameAsMillisecondTrue_expected": true
define "DateTimeSameAsMillisecondFalse": DateTime(2014, 10, 10, 20, 55, 45, 500) same millisecond as DateTime(2014, 10, 10, 21, 55, 45, 501)
define "DateTimeSameAsMillisecondFalse_expected": false
define "DateTimeSameAsNull": DateTime(2014, 10) same day as DateTime(2014, 10, 12)
define "DateTimeSameAsNull_expected": null
define "SameAsTimezoneTrue": @2012-03-10T10:20:00.999+07:00 same hour as @2012-03-10T09:20:00.999+06:00
define "SameAsTimezoneTrue_expected": true
define "SameAsTimezoneFalse": @2012-03-10T10:20:00.999+07:00 same hour as @2012-03-10T10:20:00.999+06:00
define "SameAsTimezoneFalse_expected": false
define "TimeSameAsHourTrue": @T23:25:25.555 same hour as @T23:55:25.900
define "TimeSameAsHourTrue_expected": true
define "TimeSameAsHourFalse": @T22:25:25.555 same hour as @T23:25:25.555
define "TimeSameAsHourFalse_expected": false
define "TimeSameAsMinuteTrue": @T23:55:22.555 same minute as @T23:55:25.900
define "TimeSameAsMinuteTrue_expected": true
define "TimeSameAsMinuteFalse": @T23:26:25.555 same minute as @T23:25:25.555
define "TimeSameAsMinuteFalse_expected": false
define "TimeSameAsSecondTrue": @T23:55:25.555 same second as @T23:55:25.900
define "TimeSameAsSecondTrue_expected": true
define "TimeSameAsSecondFalse": @T23:25:35.555 same second as @T23:25:25.555
define "TimeSameAsSecondFalse_expected": false
define "TimeSameAsMillisTrue": @T23:55:25.555 same millisecond as @T23:55:25.555
define "TimeSameAsMillisTrue_expected": true
define "TimeSameAsMillisFalse": @T23:25:25.555 same millisecond as @T23:25:25.554
define "TimeSameAsMillisFalse_expected": false
define "DateTimeSameOrAfterYearTrue1": DateTime(2014) same year or after DateTime(2014)
define "DateTimeSameOrAfterYearTrue1_expected": true
define "DateTimeSameOrAfterYearTrue2": DateTime(2016) same year or after DateTime(2014)
define "DateTimeSameOrAfterYearTrue2_expected": true
define "DateTimeSameOrAfterYearFalse": DateTime(2013) same year or after DateTime(2014)
define "DateTimeSameOrAfterYearFalse_expected": false
define "DateTimeSameOrAfterMonthTrue1": DateTime(2014, 12) same month or after DateTime(2014, 12)
define "DateTimeSameOrAfterMonthTrue1_expected": true
define "DateTimeSameOrAfterMonthTrue2": DateTime(2014, 10) same month or after DateTime(2014, 9)
define "DateTimeSameOrAfterMonthTrue2_expected": true
define "DateTimeSameOrAfterMonthFalse": DateTime(2014, 10) same month or after DateTime(2014, 11)
define "DateTimeSameOrAfterMonthFalse_expected": false
define "DateTimeSameOrAfterDayTrue1": DateTime(2014, 12, 20) same day or after DateTime(2014, 12, 20)
define "DateTimeSameOrAfterDayTrue1_expected": true
define "DateTimeSameOrAfterDayTrue2": DateTime(2014, 10, 25) same day or after DateTime(2014, 10, 20)
define "DateTimeSameOrAfterDayTrue2_expected": true
define "DateTimeSameOrAfterDayFalse": DateTime(2014, 10, 20) same day or after DateTime(2014, 10, 25)
define "DateTimeSameOrAfterDayFalse_expected": false
define "DateTimeSameOrAfterHourTrue1": DateTime(2014, 12, 20, 12) same hour or after DateTime(2014, 12, 20, 12)
define "DateTimeSameOrAfterHourTrue1_expected": true
define "DateTimeSameOrAfterHourTrue2": DateTime(2014, 10, 25, 12) same hour or after DateTime(2014, 10, 25, 10)
define "DateTimeSameOrAfterHourTrue2_expected": true
define "DateTimeSameOrAfterHourFalse": DateTime(2014, 10, 25, 12) same hour or after DateTime(2014, 10, 25, 15)
define "DateTimeSameOrAfterHourFalse_expected": false
define "DateTimeSameOrAfterMinuteTrue1": DateTime(2014, 12, 20, 12, 30) same minute or after DateTime(2014, 12, 20, 12, 30)
define "DateTimeSameOrAfterMinuteTrue1_expected": true
define "DateTimeSameOrAfterMinuteTrue2": DateTime(2014, 10, 25, 10, 30) same minute or after DateTime(2014, 10, 25, 10, 25)
define "DateTimeSameOrAfterMinuteTrue2_expected": true
define "DateTimeSameOrAfterMinuteFalse": DateTime(2014, 10, 25, 15, 30) same minute or after DateTime(2014, 10, 25, 15, 45)
define "DateTimeSameOrAfterMinuteFalse_expected": false
define "DateTimeSameOrAfterSecondTrue1": DateTime(2014, 12, 20, 12, 30, 15) same second or after DateTime(2014, 12, 20, 12, 30, 15)
define "DateTimeSameOrAfterSecondTrue1_expected": true
define "DateTimeSameOrAfterSecondTrue2": DateTime(2014, 10, 25, 10, 25, 25) same second or after DateTime(2014, 10, 25, 10, 25, 20)
define "DateTimeSameOrAfterSecondTrue2_expected": true
define "DateTimeSameOrAfterSecondFalse": DateTime(2014, 10, 25, 15, 45, 20) same second or after DateTime(2014, 10, 25, 15, 45, 21)
define "DateTimeSameOrAfterSecondFalse_expected": false
define "DateTimeSameOrAfterMillisecondTrue1": DateTime(2014, 12, 20, 12, 30, 15, 250) same millisecond or after DateTime(2014, 12, 20, 12, 30, 15, 250)
define "DateTimeSameOrAfterMillisecondTrue1_expected": true
define "DateTimeSameOrAfterMillisecondTrue2": DateTime(2014, 10, 25, 10, 25, 20, 500) same millisecond or after DateTime(2014, 10, 25, 10, 25, 20, 499)
define "DateTimeSameOrAfterMillisecondTrue2_expected": true
define "DateTimeSameOrAfterMillisecondFalse": DateTime(2014, 10, 25, 15, 45, 20, 500) same millisecond or after DateTime(2014, 10, 25, 15, 45, 20, 501)
define "DateTimeSameOrAfterMillisecondFalse_expected": false
define "DateTimeSameOrAfterNull1": DateTime(2014, 12, 20) same day or after DateTime(2014, 12)
define "DateTimeSameOrAfterNull1_expected": null
define "SameOrAfterTimezoneTrue": @2012-03-10T10:20:00.999+07:00 same hour or after @2012-03-10T09:20:00.999+06:00
define "SameOrAfterTimezoneTrue_expected": true
define "SameOrAfterTimezoneFalse": @2012-03-10T10:20:00.999+07:00 same hour or after @2012-03-10T10:20:00.999+06:00
define "SameOrAfterTimezoneFalse_expected": false
define "TimeSameOrAfterHourTrue1": @T23:25:25.555 same hour or after @T23:55:25.900
define "TimeSameOrAfterHourTrue1_expected": true
define "TimeSameOrAfterHourTrue2": @T23:25:25.555 same hour or after @T22:55:25.900
define "TimeSameOrAfterHourTrue2_expected": true
define "TimeSameOrAfterHourFalse": @T22:25:25.555 same hour or after @T23:55:25.900
define "TimeSameOrAfterHourFalse_expected": false
define "TimeSameOrAfterMinuteTrue1": @T23:25:25.555 same minute or after @T23:25:25.900
define "TimeSameOrAfterMinuteTrue1_expected": true
define "TimeSameOrAfterMinuteTrue2": @T23:25:25.555 same minute or after @T22:15:25.900
define "TimeSameOrAfterMinuteTrue2_expected": true
define "TimeSameOrAfterMinuteFalse": @T23:25:25.555 same minute or after @T23:55:25.900
define "TimeSameOrAfterMinuteFalse_expected": false
define "TimeSameOrAfterSecondTrue1": @T23:25:25.555 same second or after @T23:25:25.900
define "TimeSameOrAfterSecondTrue1_expected": true
define "TimeSameOrAfterSecondTrue2": @T23:25:35.555 same second or after @T22:25:25.900
define "TimeSameOrAfterSecondTrue2_expected": true
define "TimeSameOrAfterSecondFalse": @T23:55:25.555 same second or after @T23:55:35.900
define "TimeSameOrAfterSecondFalse_expected": false
define "TimeSameOrAfterMillisTrue1": @T23:25:25.555 same millisecond or after @T23:25:25.555
define "TimeSameOrAfterMillisTrue1_expected": true
define "TimeSameOrAfterMillisTrue2": @T23:25:25.555 same millisecond or after @T22:25:25.550
define "TimeSameOrAfterMillisTrue2_expected": true
define "TimeSameOrAfterMillisFalse": @T23:55:25.555 same millisecond or after @T23:55:25.900
define "TimeSameOrAfterMillisFalse_expected": false
define "OnOrAfterTrue": @2017-12-20T11:00:00.000 on or after @2017-12-20T11:00:00.000
define "OnOrAfterTrue_expected": true
define "Issue32DateTime": @2017-12-21T02:00:00.0 same or after @2017-12-20T11:00:00.0
define "Issue32DateTime_expected": true
define "DateTimeSameOrBeforeYearTrue1": DateTime(2014) same year or before DateTime(2014)
define "DateTimeSameOrBeforeYearTrue1_expected": true
define "DateTimeSameOrBeforeYearTrue2": DateTime(2013) same year or before DateTime(2014)
define "DateTimeSameOrBeforeYearTrue2_expected": true
define "DateTimeSameOrBeforeYearFalse": DateTime(2015) same year or before DateTime(2014)
define "DateTimeSameOrBeforeYearFalse_expected": false
define "DateTimeSameOrBeforeMonthTrue1": DateTime(2014, 12) same month or before DateTime(2014, 12)
define "DateTimeSameOrBeforeMonthTrue1_expected": true
define "DateTimeSameOrBeforeMonthTrue2": DateTime(2014, 8) same month or before DateTime(2014, 9)
define "DateTimeSameOrBeforeMonthTrue2_expected": true
define "DateTimeSameOrBeforeMonthFalse": DateTime(2014, 12) same month or before DateTime(2014, 11)
define "DateTimeSameOrBeforeMonthFalse_expected": false
define "DateTimeSameOrBeforeDayTrue1": DateTime(2014, 12, 20) same day or before DateTime(2014, 12, 20)
define "DateTimeSameOrBeforeDayTrue1_expected": true
define "DateTimeSameOrBeforeDayTrue2": DateTime(2014, 10, 15) same day or before DateTime(2014, 10, 20)
define "DateTimeSameOrBeforeDayTrue2_expected": true
define "DateTimeSameOrBeforeDayFalse": DateTime(2014, 10, 30) same day or before DateTime(2014, 10, 25)
define "DateTimeSameOrBeforeDayFalse_expected": false
define "DateTimeSameOrBeforeHourTrue1": DateTime(2014, 12, 20, 12) same hour or before DateTime(2014, 12, 20, 12)
define "DateTimeSameOrBeforeHourTrue1_expected": true
define "DateTimeSameOrBeforeHourTrue2": DateTime(2014, 10, 25, 5) same hour or before DateTime(2014, 10, 25, 10)
define "DateTimeSameOrBeforeHourTrue2_expected": true
define "DateTimeSameOrBeforeHourFalse": DateTime(2014, 10, 25, 20) same hour or before DateTime(2014, 10, 25, 15)
define "DateTimeSameOrBeforeHourFalse_expected": false
define "DateTimeSameOrBeforeMinuteTrue1": DateTime(2014, 12, 20, 12, 30) same minute or before DateTime(2014, 12, 20, 12, 30)
define "DateTimeSameOrBeforeMinuteTrue1_expected": true
define "DateTimeSameOrBeforeMinuteTrue2": DateTime(2014, 10, 25, 10, 20) same minute or before DateTime(2014, 10, 25, 10, 25)
define "DateTimeSameOrBeforeMinuteTrue2_expected": true
define "DateTimeSameOrBeforeMinuteFalse": DateTime(2014, 10, 25, 15, 55) same minute or before DateTime(2014, 10, 25, 15, 45)
define "DateTimeSameOrBeforeMinuteFalse_expected": false
define "DateTimeSameOrBeforeSecondTrue1": DateTime(2014, 12, 20, 12, 30, 15) same second or before DateTime(2014, 12, 20, 12, 30, 15)
define "DateTimeSameOrBeforeSecondTrue1_expected": true
define "DateTimeSameOrBeforeSecondTrue2": DateTime(2014, 10, 25, 10, 25, 15) same second or before DateTime(2014, 10, 25, 10, 25, 20)
define "DateTimeSameOrBeforeSecondTrue2_expected": true
define "DateTimeSameOrBeforeSecondFalse": DateTime(2014, 10, 25, 15, 45, 25) same second or before DateTime(2014, 10, 25, 15, 45, 21)
define "DateTimeSameOrBeforeSecondFalse_expected": false
define "DateTimeSameOrBeforeMillisecondTrue1": DateTime(2014, 12, 20, 12, 30, 15, 250) same millisecond or before DateTime(2014, 12, 20, 12, 30, 15, 250)
define "DateTimeSameOrBeforeMillisecondTrue1_expected": true
define "DateTimeSameOrBeforeMillisecondTrue2": DateTime(2014, 10, 25, 10, 25, 20, 450) same millisecond or before DateTime(2014, 10, 25, 10, 25, 20, 499)
define "DateTimeSameOrBeforeMillisecondTrue2_expected": true
define "DateTimeSameOrBeforeMillisecondFalse": DateTime(2014, 10, 25, 15, 45, 20, 505) same millisecond or before DateTime(2014, 10, 25, 15, 45, 20, 501)
define "DateTimeSameOrBeforeMillisecondFalse_expected": false
define "DateTimeSameOrBeforeNull1": DateTime(2014, 12, 20) same minute or before DateTime(2014, 12, 20, 15)
define "DateTimeSameOrBeforeNull1_expected": null
define "SameOrBeforeTimezoneTrue": @2012-03-10T09:20:00.999+07:00 same hour or before @2012-03-10T10:20:00.999+06:00
define "SameOrBeforeTimezoneTrue_expected": true
define "SameOrBeforeTimezoneFalse": @2012-03-10T10:20:00.999+06:00 same hour or before @2012-03-10T10:20:00.999+07:00
define "SameOrBeforeTimezoneFalse_expected": false
define "TimeSameOrBeforeHourTrue1": @T23:25:25.555 same hour or before @T23:55:25.900
define "TimeSameOrBeforeHourTrue1_expected": true
define "TimeSameOrBeforeHourTrue2": @T21:25:25.555 same hour or before @T22:55:25.900
define "TimeSameOrBeforeHourTrue2_expected": true
define "TimeSameOrBeforeHourFalse": @T22:25:25.555 same hour or before @T21:55:25.900
define "TimeSameOrBeforeHourFalse_expected": false
define "TimeSameOrBeforeMinuteTrue1": @T23:25:25.555 same minute or before @T23:25:25.900
define "TimeSameOrBeforeMinuteTrue1_expected": true
define "TimeSameOrBeforeMinuteFalse0": @T23:10:25.555 same minute or before @T22:15:25.900
define "TimeSameOrBeforeMinuteFalse0_expected": false
define "TimeSameOrBeforeMinuteFalse": @T23:56:25.555 same minute or before @T23:55:25.900
define "TimeSameOrBeforeMinuteFalse_expected": false
define "TimeSameOrBeforeSecondTrue1": @T23:25:25.555 same second or before @T23:25:25.900
define "TimeSameOrBeforeSecondTrue1_expected": true
define "TimeSameOrBeforeSecondFalse0": @T23:25:35.555 same second or before @T22:25:45.900
define "TimeSameOrBeforeSecondFalse0_expected": false
define "TimeSameOrBeforeSecondFalse": @T23:55:45.555 same second or before @T23:55:35.900
define "TimeSameOrBeforeSecondFalse_expected": false
define "TimeSameOrBeforeMillisTrue1": @T23:25:25.555 same millisecond or before @T23:25:25.555
define "TimeSameOrBeforeMillisTrue1_expected": true
define "TimeSameOrBeforeMillisFalse0": @T23:25:25.200 same millisecond or before @T22:25:25.550
define "TimeSameOrBeforeMillisFalse0_expected": false
define "TimeSameOrBeforeMillisFalse": @T23:55:25.966 same millisecond or before @T23:55:25.900
define "TimeSameOrBeforeMillisFalse_expected": false
define "DateTimeSubtract5Years": DateTime(2005, 10, 10) - 5 years
define "DateTimeSubtract5Years_expected": @2000-10-10T
define "DateTimeSubtract5Months": DateTime(2005, 6, 10) - 5 months
define "DateTimeSubtract5Months_expected": @2005-01-10T
define "DateTimeSubtractMonthsUnderflow": DateTime(2005, 5, 10) - 6 months
define "DateTimeSubtractMonthsUnderflow_expected": @2004-11-10T
define "DateTimeSubtractThreeWeeks": DateTime(2018, 5, 23) - 3 weeks = DateTime(2018, 5, 2)
define "DateTimeSubtractThreeWeeks_expected": true
define "DateTimeSubtractYearInWeeks": DateTime(2018, 5, 23) - 52 weeks = DateTime(2017, 5, 24)
define "DateTimeSubtractYearInWeeks_expected": true
define "DateTimeLeapDaySubtractYearInWeeks": DateTime(2024, 2, 29) - 52 weeks = DateTime(2023, 3, 2)
define "DateTimeLeapDaySubtractYearInWeeks_expected": true
define "DateTimeLeapYearSubtractYearInWeeks": DateTime(2024, 3, 1) - 52 weeks = DateTime(2023, 3, 3)
define "DateTimeLeapYearSubtractYearInWeeks_expected": true
define "DateTimeSubtract5Days": DateTime(2005, 5, 10) - 5 days
define "DateTimeSubtract5Days_expected": @2005-05-05T
define "DateTimeSubtractDaysUnderflow": DateTime(2016, 6, 10) - 11 days
define "DateTimeSubtractDaysUnderflow_expected": @2016-05-30T
define "DateTimeSubtract5Hours": DateTime(2005, 5, 10, 10) - 5 hours
define "DateTimeSubtract5Hours_expected": @2005-05-10T05
define "DateTimeSubtractHoursUnderflow": DateTime(2016, 6, 10, 5) - 6 hours
define "DateTimeSubtractHoursUnderflow_expected": @2016-06-09T23
define "DateTimeSubtract5Minutes": DateTime(2005, 5, 10, 5, 10) - 5 minutes
define "DateTimeSubtract5Minutes_expected": @2005-05-10T05:05
define "DateTimeSubtractMinutesUnderflow": DateTime(2016, 6, 10, 5, 5) - 6 minutes
define "DateTimeSubtractMinutesUnderflow_expected": @2016-06-10T04:59
define "DateTimeSubtract5Seconds": DateTime(2005, 5, 10, 5, 5, 10) - 5 seconds
define "DateTimeSubtract5Seconds_expected": @2005-05-10T05:05:05
define "DateTimeSubtract1YearInSeconds": DateTime(2016,5) - 31535999 seconds = DateTime(2015, 5)
define "DateTimeSubtract1YearInSeconds_expected": true
define "DateTimeSubtract15HourPrecisionSecond": DateTime(2016, 10, 1, 10, 20, 30) - 15 hours
define "DateTimeSubtract15HourPrecisionSecond_expected": @2016-09-30T19:20:30
define "DateTimeSubtractSecondsUnderflow": DateTime(2016, 6, 10, 5, 5, 5) - 6 seconds
define "DateTimeSubtractSecondsUnderflow_expected": @2016-06-10T05:04:59
define "DateTimeSubtract5Milliseconds": DateTime(2005, 5, 10, 5, 5, 5, 10) - 5 milliseconds
define "DateTimeSubtract5Milliseconds_expected": @2005-05-10T05:05:05.005
define "DateTimeSubtractMillisecondsUnderflow": DateTime(2016, 6, 10, 5, 5, 5, 5) - 6 milliseconds
define "DateTimeSubtractMillisecondsUnderflow_expected": @2016-06-10T05:05:04.999
define "DateTimeSubtract2YearsAsMonths": DateTime(2014) - 24 months
define "DateTimeSubtract2YearsAsMonths_expected": @2012T
define "DateTimeSubtract2YearsAsMonthsRem1": DateTime(2014) - 25 months
define "DateTimeSubtract2YearsAsMonthsRem1_expected": @2012T
define "DateSubtract2YearsAsMonths": Date(2014) - 24 months
define "DateSubtract2YearsAsMonths_expected": @2012
define "DateSubtract2YearsAsMonthsRem1": Date(2014) - 25 months
define "DateSubtract2YearsAsMonthsRem1_expected": @2012
define "DateSubtract33Days": Date(2014,6) - 33 days
define "DateSubtract33Days_expected": @2014-05
define "DateSubtract1Year": Date(2014,6) - 1 year
define "DateSubtract1Year_expected": @2013-06
define "TimeSubtract5Hours": @T15:59:59.999 - 5 hours
define "TimeSubtract5Hours_expected": @T10:59:59.999
define "TimeSubtract1Minute": @T15:59:59.999 - 1 minutes
define "TimeSubtract1Minute_expected": @T15:58:59.999
define "TimeSubtract1Second": @T15:59:59.999 - 1 seconds
define "TimeSubtract1Second_expected": @T15:59:58.999
define "TimeSubtract1Millisecond": @T15:59:59.0 - 1 milliseconds
define "TimeSubtract1Millisecond_expected": @T15:59:58.999
define "TimeSubtract5Hours1Minute": @T15:59:59.999 - 5 hours - 1 minutes
define "TimeSubtract5Hours1Minute_expected": @T10:58:59.999
define "TimeSubtract5hoursByMinute": @T15:59:59.999 - 300 minutes
define "TimeSubtract5hoursByMinute_expected": @T10:59:59.999
define "TimeTest2": @T23:59:59.999
define "TimeTest2_expected": @T23:59:59.999
define "TimeOfDayTest": TimeOfDay() = TimeOfDay()
define "TimeOfDayTest_expected": true
define "DateTimeSameOrBeforeTodayTrue1": Today() same day or before Today()
define "DateTimeSameOrBeforeTodayTrue1_expected": true
define "DateTimeSameOrBeforeTodayTrue2": Today() same day or before Today() + 1 days
define "DateTimeSameOrBeforeTodayTrue2_expected": true
define "DateTimeSameOrBeforeTodayFalse": Today() + 1 years same day or before Today()
define "DateTimeSameOrBeforeTodayFalse_expected": false
define "DateTimeAddTodayTrue": Today() + 1 days > Today()
define "DateTimeAddTodayTrue_expected": true
define "Issue34B": Today() = Today()
define "Issue34B_expected": true
