library CqlAggregateTest version '1.0'

define "FactorialOfFive": ({ 1, 2, 3, 4, 5 }) Num aggregate Result starting 1: Result * Num
define "FactorialOfFive_expected": 120
define "RolledOutIntervals": ({
				  Interval[@2012-01-01, @2012-02-28],
				  Interval[@2012-02-01, @2012-03-31],
				  Interval[@2012-03-01, @2012-04-30]
				}) M
				  aggregate R starting (null as List<Interval<DateTime>>): R union ({
				    M X
				      let S: Max({ end of Last(R) + 1 day, start of X }),
				        E: S + Quantity{ value: duration in days of X, unit: 'days' }
				      return Interval[S, E]
				  })
define "RolledOutIntervals_expected": {
				  Interval[@2012-01-01, @2012-02-28],
				  Interval[@2012-02-29, @2012-04-28],
				  Interval[@2012-04-29, @2012-06-28]
				}
define "AggregateSumWithStart": ({ 1, 2, 3, 4, 5 }) Num
				  aggregate Result starting 1: Result + Num
define "AggregateSumWithStart_expected": 16
define "AggregateSumWithNull": ({ 1, 2, 3, 4, 5 }) Num
				  aggregate Result: Coalesce(Result, 0) + Num
define "AggregateSumWithNull_expected": 15
define "AggregateSumAll": ({ 1, 1, 2, 2, 2, 3, 4, 4, 5 }) Num
				  aggregate all Result: Coalesce(Result, 0) + Num
define "AggregateSumAll_expected": 24
define "AggregateSumDistinct": ({ 1, 1, 2, 2, 2, 3, 4, 4, 5 }) Num
				  aggregate distinct Result: Coalesce(Result, 0) + Num
define "AggregateSumDistinct_expected": 15
define "Multi": from ({1}) X, ({2}) Y, ({3}) Z
				  aggregate Agg: Coalesce(Agg, 0) + X + Y + Z
define "Multi_expected": 6
define "MegaMulti": from ({1, 2}) X, ({1, 2}) Y, ({1, 2}) Z
				  aggregate Agg starting 0: Agg + X + Y + Z
define "MegaMulti_expected": 36
define "MegaMultiDistinct": from ({1, 2, 2, 1}) X, ({1, 2, 1, 2}) Y, ({2, 1, 2, 1}) Z
				  aggregate distinct Agg starting 1: Agg + X + Y + Z
define "MegaMultiDistinct_expected": 37
