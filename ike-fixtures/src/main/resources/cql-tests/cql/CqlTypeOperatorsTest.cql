library CqlTypeOperatorsTest version '1.0'

define "AsQuantity": 45.5 'g' as Quantity
define "AsQuantity_expected": 45.5 'g'
define "CastAsQuantity": cast 45.5 'g' as Quantity
define "CastAsQuantity_expected": 45.5 'g'
define "AsDateTime": DateTime(2014, 01, 01) as DateTime
define "AsDateTime_expected": @2014-01-01T
define "IntegerToDecimal": convert 5 to Decimal
define "IntegerToDecimal_expected": 5.0
define "IntegerToString": convert 5 to String
define "IntegerToString_expected": '5'
define "StringToIntegerError": convert 'foo' to Integer
define "StringToIntegerError_expected": null
define "StringToDateTime": convert '2014-01-01' to DateTime
define "StringToDateTime_expected": @2014-01-01T
define "StringToTime": convert 'T14:30:00.0' to Time
define "StringToTime_expected": @T14:30:00.000
define "StringToDateTimeMalformed": convert '2014/01/01' to DateTime
define "StringToDateTimeMalformed_expected": null
define "IntegerIsInteger": 5 is Integer
define "IntegerIsInteger_expected": true
define "StringIsInteger": '5' is Integer
define "StringIsInteger_expected": false
define "ValueSetIsVocabulary": System.ValueSet{id: '123'} is Vocabulary
define "ValueSetIsVocabulary_expected": true
define "StringNoToBoolean": ToBoolean('NO')
define "StringNoToBoolean_expected": false
define "CodeToConcept1": ToConcept(Code { code: '8480-6' })
define "CodeToConcept1_expected": Concept {
					codes: Code { code: '8480-6' }
				}
define "ToDateTime1": ToDateTime('2014-01-01')
define "ToDateTime1_expected": @2014-01-01T
define "ToDateTime2": ToDateTime('2014-01-01T12:05')
define "ToDateTime2_expected": @2014-01-01T12:05
define "ToDateTime3": ToDateTime('2014-01-01T12:05:05.955')
define "ToDateTime3_expected": @2014-01-01T12:05:05.955
define "ToDateTime4": ToDateTime('2014-01-01T12:05:05.955+01:30')
define "ToDateTime4_expected": @2014-01-01T12:05:05.955+01:30
define "ToDateTime5": ToDateTime('2014-01-01T12:05:05.955-01:15')
define "ToDateTime5_expected": @2014-01-01T12:05:05.955-01:15
define "ToDateTime6": ToDateTime('2014-01-01T12:05:05.955Z')
define "ToDateTime6_expected": @2014-01-01T12:05:05.955+00:00
define "ToDateTimeMalformed": ToDateTime('2014/01/01T12:05:05.955Z')
define "ToDateTimeMalformed_expected": null
define "ToDateTimeDate": ToDateTime(@2014-01-01)
define "ToDateTimeDate_expected": @2014-01-01T
define "ToDateTimeTimeUnspecified": hour from ToDateTime(@2014-01-01) is null
define "ToDateTimeTimeUnspecified_expected": true
define "String25D5ToDecimal": ToDecimal('+25.5')
define "String25D5ToDecimal_expected": 25.5
define "StringNeg25ToInteger": ToInteger('-25')
define "StringNeg25ToInteger_expected": -25
define "String5D5CMToQuantity": ToQuantity('5.5 \'cm\'')
define "String5D5CMToQuantity_expected": 5.5'cm'
define "IntegerNeg5ToString": ToString(-5)
define "IntegerNeg5ToString_expected": '-5'
define "Decimal18D55ToString": ToString(18.55)
define "Decimal18D55ToString_expected": '18.55'
define "Quantity5D5CMToString": ToString(5.5 'cm')
define "Quantity5D5CMToString_expected": '5.5 \'cm\''
define "BooleanTrueToString": ToString(true)
define "BooleanTrueToString_expected": 'true'
define "ToTime1": ToTime('T14:30:00.0')
define "ToTime1_expected": @T14:30:00.000
define "ToTime2": ToTime('T14:30:00.0+05:30')
define "ToTime2_expected": @T14:30:00.000
define "ToTime3": ToTime('T14:30:00.0-05:45')
define "ToTime3_expected": @T14:30:00.000
define "ToTime4": ToTime('T14:30:00.0Z')
define "ToTime4_expected": @T14:30:00.000
define "ToTimeMalformed": ToTime('T14-30-00.0')
define "ToTimeMalformed_expected": null
