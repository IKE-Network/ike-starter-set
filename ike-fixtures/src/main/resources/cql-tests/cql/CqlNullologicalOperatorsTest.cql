library CqlNullologicalOperatorsTest version '1.0'

define "CoalesceANull": Coalesce('a', null)
define "CoalesceANull_expected": 'a'
define "CoalesceNullA": Coalesce(null, 'a')
define "CoalesceNullA_expected": 'a'
define "CoalesceEmptyList": Coalesce({})
define "CoalesceEmptyList_expected": null
define "CoalesceListFirstA": Coalesce({'a', null, null})
define "CoalesceListFirstA_expected": 'a'
define "CoalesceListLastA": Coalesce({null, null, 'a'})
define "CoalesceListLastA_expected": 'a'
define "CoalesceFirstList": Coalesce({'a'},null, null)
define "CoalesceFirstList_expected": {'a'}
define "CoalesceLastList": Coalesce(null, null, {'a'})
define "CoalesceLastList_expected": {'a'}
define "DateTimeCoalesce": Coalesce(null, null, DateTime(2012, 5, 18))
define "DateTimeCoalesce_expected": @2012-05-18T
define "DateTimeListCoalesce": Coalesce({ null, null, DateTime(2012, 5, 18) })
define "DateTimeListCoalesce_expected": @2012-05-18T
define "TimeCoalesce": Coalesce(null, null, @T05:15:33.556)
define "TimeCoalesce_expected": @T05:15:33.556
define "TimeListCoalesce": Coalesce({ null, null, @T05:15:33.556 })
define "TimeListCoalesce_expected": @T05:15:33.556
define "IsNullTrue": IsNull(null)
define "IsNullTrue_expected": true
define "IsNullFalseEmptyString": IsNull('')
define "IsNullFalseEmptyString_expected": false
define "IsNullAlsoFalseAbcString": IsNull('abc')
define "IsNullAlsoFalseAbcString_expected": false
define "IsNullAlsoFalseNumber1": IsNull(1)
define "IsNullAlsoFalseNumber1_expected": false
define "IsNullAlsoFalseNumberZero": IsNull(0)
define "IsNullAlsoFalseNumberZero_expected": false
define "IsFalseFalse": IsFalse(false)
define "IsFalseFalse_expected": true
define "IsFalseTrue": IsFalse(true)
define "IsFalseTrue_expected": false
define "IsFalseNull": IsFalse(null)
define "IsFalseNull_expected": false
define "IsTrueTrue": IsTrue(true)
define "IsTrueTrue_expected": true
define "IsTrueFalse": IsTrue(false)
define "IsTrueFalse_expected": false
define "IsTrueNull": IsTrue(null)
define "IsTrueNull_expected": false
