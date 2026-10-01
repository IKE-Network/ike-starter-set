library CqlQueryTests version '1.0'

define "NonListSource": (4) l
define "NonListSource_expected": 4
define "NonListSourceWithReturn": (4) l return 'Hello World'
define "NonListSourceWithReturn_expected": 'Hello World'
define "MultiSource": from ({2, 3}) A, ({5, 6}) B
define "MultiSource_expected": {{ A: 2, B: 5 }, { A: 2, B: 6 }, { A: 3, B: 5 }, { A: 3, B: 6 }}
define "IntegerDescending": ({1, 2, 3}) l sort desc
define "IntegerDescending_expected": {3, 2, 1}
define "IntegerAscending": ({1, 3, 2}) l sort ascending
define "IntegerAscending_expected": {1, 2, 3}
define "DateTimeDescending": ({@2013-01-02T00:00:00.000Z, @2014-01-02T00:00:00.000Z, @2015-01-02T00:00:00.000Z}) l sort desc
define "DateTimeDescending_expected": {@2015-01-02T00:00:00.000Z, @2014-01-02T00:00:00.000Z, @2013-01-02T00:00:00.000Z}
define "DateTimeAscending": ({@2013-01-02T00:00:00.000Z, @2015-01-02T00:00:00.000Z, @2014-01-02T00:00:00.000Z}) l sort ascending
define "DateTimeAscending_expected": {@2013-01-02T00:00:00.000Z, @2014-01-02T00:00:00.000Z, @2015-01-02T00:00:00.000Z}
define "MultiplyIntegers": ({1, 2, 3, 3, 4}) L aggregate A starting 1: A * L
define "MultiplyIntegers_expected": 72
define "MultiplyIntegersAll": ({1, 2, 3, 3, 4}) L aggregate all A starting 1: A * L
define "MultiplyIntegersAll_expected": 72
define "MultiplyIntegersDistinct": ({1, 2, 3, 3, 4}) L aggregate distinct A starting 1: A * L
define "MultiplyIntegersDistinct_expected": 24
define "MultiplyIntegersNoStartingExpression": ({1, 2, 3}) L aggregate A : A * L
define "MultiplyIntegersNoStartingExpression_expected": null
define "Multi-Source": from ({1, 2, 3}) B, (4) C aggregate A : A + B + C
define "Multi-Source_expected": null
