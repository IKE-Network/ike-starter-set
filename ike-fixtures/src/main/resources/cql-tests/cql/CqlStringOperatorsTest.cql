library CqlStringOperatorsTest version '1.0'

define "CombineNull": Combine(null)
define "CombineNull_expected": null
define "CombineEmptyList": Combine({})
define "CombineEmptyList_expected": null
define "CombineABC": Combine({'a', 'b', 'c'})
define "CombineABC_expected": 'abc'
define "CombineABCSepDash": Combine({'a', 'b', 'c'}, '-')
define "CombineABCSepDash_expected": 'a-b-c'
define "ConcatenateNullNull": Concatenate(null, null)
define "ConcatenateNullNull_expected": null
define "ConcatenateANull": Concatenate('a', null)
define "ConcatenateANull_expected": null
define "ConcatenateNullB": Concatenate(null, 'b')
define "ConcatenateNullB_expected": null
define "ConcatenateAB": Concatenate('a', 'b')
define "ConcatenateAB_expected": 'ab'
define "ConcatenateABWithAdd": 'a' + 'b'
define "ConcatenateABWithAdd_expected": 'ab'
define "EndsWithNull": EndsWith(null, null)
define "EndsWithNull_expected": null
define "EndsWithTrue": EndsWith('Chris Schuler is the man!!', 'n!!')
define "EndsWithTrue_expected": true
define "EndsWithFalse": EndsWith('Chris Schuler is the man!!', 'n!')
define "EndsWithFalse_expected": false
define "IndexerNullNull": Indexer(null as String, null)
define "IndexerNullNull_expected": null
define "IndexerANull": Indexer('a', null)
define "IndexerANull_expected": null
define "IndexerNull1String": Indexer(null as String, 1)
define "IndexerNull1String_expected": null
define "IndexerAB0": Indexer('ab', 0)
define "IndexerAB0_expected": 'a'
define "IndexerAB1": Indexer('ab', 1)
define "IndexerAB1_expected": 'b'
define "IndexerAB2": Indexer('ab', 2)
define "IndexerAB2_expected": null
define "IndexerABNeg1": Indexer('ab', -1)
define "IndexerABNeg1_expected": null
define "LastPositionOfNull": LastPositionOf(null, null)
define "LastPositionOfNull_expected": null
define "LastPositionOfNull1": LastPositionOf(null, 'hi')
define "LastPositionOfNull1_expected": null
define "LastPositionOfNull2": LastPositionOf('hi', null)
define "LastPositionOfNull2_expected": null
define "LastPositionOf1": LastPositionOf('hi', 'Ohio is the place to be!')
define "LastPositionOf1_expected": 1
define "LastPositionOf2": LastPositionOf('hi', 'Say hi to Ohio!')
define "LastPositionOf2_expected": 11
define "LengthNullString": Length(null as String)
define "LengthNullString_expected": null
define "LengthEmptyString": Length('')
define "LengthEmptyString_expected": 0
define "LengthA": Length('a')
define "LengthA_expected": 1
define "LengthAB": Length('ab')
define "LengthAB_expected": 2
define "LowerNull": Lower(null)
define "LowerNull_expected": null
define "LowerEmpty": Lower('')
define "LowerEmpty_expected": ''
define "LowerA": Lower('A')
define "LowerA_expected": 'a'
define "LowerB": Lower('b')
define "LowerB_expected": 'b'
define "LowerAB": Lower('Ab')
define "LowerAB_expected": 'ab'
define "MatchesNull": Matches('Not all who wander are lost', null)
define "MatchesNull_expected": null
define "MatchesNumberFalse": Matches('Not all who wander are lost', '.*\\d+')
define "MatchesNumberFalse_expected": false
define "MatchesNumberTrue": Matches('Not all who wander are lost - circa 2017', '.*\\d+')
define "MatchesNumberTrue_expected": true
define "MatchesAllTrue": Matches('Not all who wander are lost', '.*')
define "MatchesAllTrue_expected": true
define "MatchesWordsAndSpacesTrue": Matches('Not all who wander are lost', '[\\w|\\s]+')
define "MatchesWordsAndSpacesTrue_expected": true
define "MatchesWordsAndSpacesFalse": Matches('Not all who wander are lost - circa 2017', '^[\\w\\s]+$')
define "MatchesWordsAndSpacesFalse_expected": false
define "MatchesNotWords": Matches('   ', '\\W+')
define "MatchesNotWords_expected": true
define "MatchesWhiteSpace": Matches(' \n\t', '\\s+')
define "MatchesWhiteSpace_expected": true
define "PositionOfNullNull": PositionOf(null, null)
define "PositionOfNullNull_expected": null
define "PositionOfANull": PositionOf('a', null)
define "PositionOfANull_expected": null
define "PositionOfNullA": PositionOf(null, 'a')
define "PositionOfNullA_expected": null
define "PositionOfAInAB": PositionOf('a', 'ab')
define "PositionOfAInAB_expected": 0
define "PositionOfBInAB": PositionOf('b', 'ab')
define "PositionOfBInAB_expected": 1
define "PositionOfCInAB": PositionOf('c', 'ab')
define "PositionOfCInAB_expected": -1
define "ReplaceMatchesNull": ReplaceMatches('Not all who wander are lost', null, 'But I am...')
define "ReplaceMatchesNull_expected": null
define "ReplaceMatchesAll": ReplaceMatches('Not all who wander are lost', 'Not all who wander are lost', 'But still waters run deep')
define "ReplaceMatchesAll_expected": 'But still waters run deep'
define "ReplaceMatchesMany": ReplaceMatches('Who put the bop in the bop she bop she bop?', 'bop', 'bang')
define "ReplaceMatchesMany_expected": 'Who put the bang in the bang she bang she bang?'
define "ReplaceMatchesSpaces": ReplaceMatches('All that glitters is not gold', '\\s', '\\$')
define "ReplaceMatchesSpaces_expected": 'All$that$glitters$is$not$gold'
define "SplitNullNull": Split(null, null)
define "SplitNullNull_expected": null
define "SplitNullComma": Split(null, ',')
define "SplitNullComma_expected": null
define "SplitABNull": Split('a,b', null)
define "SplitABNull_expected": {'a,b'}
define "SplitABDash": Split('a,b', '-')
define "SplitABDash_expected": {'a,b'}
define "SplitABComma": Split('a,b', ',')
define "SplitABComma_expected": {'a','b'}
define "StartsWithNull": StartsWith(null, null)
define "StartsWithNull_expected": null
define "StartsWithNull1": StartsWith('hi', null)
define "StartsWithNull1_expected": null
define "StartsWithNull2": StartsWith(null, 'hi')
define "StartsWithNull2_expected": null
define "StartsWithTrue1": StartsWith('Breathe deep the gathering gloom', 'Bre')
define "StartsWithTrue1_expected": true
define "StartsWithFalse1": StartsWith('Breathe deep the gathering gloom', 'bre')
define "StartsWithFalse1_expected": false
define "SubstringNullNull": Substring(null, null)
define "SubstringNullNull_expected": null
define "SubstringANull": Substring('a', null)
define "SubstringANull_expected": null
define "SubstringNull1": Substring(null, 1)
define "SubstringNull1_expected": null
define "SubstringAB0": Substring('ab', 0)
define "SubstringAB0_expected": 'ab'
define "SubstringAB1": Substring('ab', 1)
define "SubstringAB1_expected": 'b'
define "SubstringAB2": Substring('ab', 2)
define "SubstringAB2_expected": null
define "SubstringABNeg1": Substring('ab', -1)
define "SubstringABNeg1_expected": null
define "SubstringEmptyAnd0": Substring('', 0)
define "SubstringEmptyAnd0_expected": ''
define "SubstringAB0To1": Substring('ab', 0, 1)
define "SubstringAB0To1_expected": 'a'
define "SubstringABC1To1": Substring('abc', 1, 1)
define "SubstringABC1To1_expected": 'b'
define "SubstringAB0To3": Substring('ab', 0, 3)
define "SubstringAB0To3_expected": 'ab'
define "UpperNull": Upper(null)
define "UpperNull_expected": null
define "UpperEmpty": Upper('')
define "UpperEmpty_expected": ''
define "UpperA": Upper('a')
define "UpperA_expected": 'A'
define "UpperB": Upper('B')
define "UpperB_expected": 'B'
define "UpperAB": Upper('aB')
define "UpperAB_expected": 'AB'
define "QuantityToString": ToString(125 'cm')
define "QuantityToString_expected": '125 \'cm\''
define "DateTimeToString1": ToString(DateTime(2000, 1, 1))
define "DateTimeToString1_expected": '2000-01-01'
define "DateTimeToString2": ToString(DateTime(2000, 1, 1, 15, 25, 25, 300))
define "DateTimeToString2_expected": '2000-01-01T15:25:25.300'
define "DateTimeToString3": ToString(DateTime(2000, 1, 1, 8, 25, 25, 300, -7))
define "DateTimeToString3_expected": '2000-01-01T08:25:25.300-07:00'
define "TimeToString1": ToString(@T09:30:01.003)
define "TimeToString1_expected": '09:30:01.003'
