library CqlArithmeticFunctionsTest version '1.0'

define "AbsNull": Abs(null as Integer)
define "AbsNull_expected": null
define "Abs0": Abs(0)
define "Abs0_expected": 0
define "AbsNeg1": Abs(-1)
define "AbsNeg1_expected": 1
define "AbsNeg1Dec": Abs(-1.0)
define "AbsNeg1Dec_expected": 1.0
define "Abs0Dec": Abs(0.0)
define "Abs0Dec_expected": 0.0
define "Abs1cm": Abs(-1.0'cm')
define "Abs1cm_expected": 1.0'cm'
define "AbsLong": Abs(-1L)
define "AbsLong_expected": 1L
define "AddNull": 1 + null
define "AddNull_expected": null
define "Add11": 1 + 1
define "Add11_expected": 2
define "Add1L2L": 1L + 2L
define "Add1L2L_expected": 3L
define "Add1D1D": 1.0 + 1.0
define "Add1D1D_expected": 2.0
define "Add1Q1Q": 1'g/cm3' + 1'g/cm3'
define "Add1Q1Q_expected": 2.0'g/cm3'
define "AddIAndD": 1 + 2.0
define "AddIAndD_expected": 3.0
define "Add1L1L": 1L + 1L
define "Add1L1L_expected": 2L
define "CeilingNull": Ceiling(null as Decimal)
define "CeilingNull_expected": null
define "Ceiling1D": Ceiling(1.0)
define "Ceiling1D_expected": 1
define "Ceiling1D1": Ceiling(1.1)
define "Ceiling1D1_expected": 2
define "CeilingNegD1": Ceiling(-0.1)
define "CeilingNegD1_expected": 0
define "CeilingNeg1": Ceiling(-1.0)
define "CeilingNeg1_expected": -1
define "CeilingNeg1D1": Ceiling(-1.1)
define "CeilingNeg1D1_expected": -1
define "Ceiling1I": Ceiling(1)
define "Ceiling1I_expected": 1
define "CeilingMaxInteger": Ceiling(2147483647)
define "CeilingMaxInteger_expected": 2147483647
define "CeilingMaxIntegerAsDecimal": Ceiling(2147483647.0)
define "CeilingMaxIntegerAsDecimal_expected": 2147483647
define "CeilingMaxIntegerAsDecimalWhereDecimalIsNonZero": Ceiling(2147483647.2)
define "CeilingMaxIntegerAsDecimalWhereDecimalIsNonZero_expected": null
define "CeilingDecimalGreaterThanMaxInteger": Ceiling(2147483648.2)
define "CeilingDecimalGreaterThanMaxInteger_expected": null
define "CeilingMinInteger": Ceiling(-2147483648)
define "CeilingMinInteger_expected": -2147483648
define "CeilingMinIntegerAsDecimal": Ceiling(-2147483648.0)
define "CeilingMinIntegerAsDecimal_expected": -2147483648
define "CeilingMinIntegerAsDecimalWhereDecimalIsNonZero": Ceiling(-2147483648.2)
define "CeilingMinIntegerAsDecimalWhereDecimalIsNonZero_expected": -2147483648
define "CeilingDecimalLessThanMinInteger": Ceiling(-2147483649.2)
define "CeilingDecimalLessThanMinInteger_expected": null
define "DivideNull": 1 / null
define "DivideNull_expected": null
define "Divide10": 1 / 0
define "Divide10_expected": null
define "Divide01": 0 / 1
define "Divide01_expected": 0.0
define "Divide11": 1 / 1
define "Divide11_expected": 1.0
define "Divide1L1L": 1L / 1L
define "Divide1L1L_expected": 1.0
define "Divide1d1d": 1.0 / 1.0
define "Divide1d1d_expected": 1.0
define "Divide103": Round(10 / 3, 8)
define "Divide103_expected": 3.33333333
define "Divide1Q1": 1'g/cm3' / 1.0
define "Divide1Q1_expected": 1.0'g/cm3'
define "Divide1Q1Q": 1'g/cm3' / 1'g/cm3'
define "Divide1Q1Q_expected": 1.0'1'
define "Divide10I5D": 10 / 5.0
define "Divide10I5D_expected": 2.0
define "Divide10I5I": 10 / 5
define "Divide10I5I_expected": 2.0
define "Divide10Q5I": 10.0 'g' / 5
define "Divide10Q5I_expected": 2.0'g'
define "FloorNull": Floor(null as Decimal)
define "FloorNull_expected": null
define "Floor1": Floor(1)
define "Floor1_expected": 1
define "Floor1D": Floor(1.0)
define "Floor1D_expected": 1
define "Floor1D1": Floor(1.1)
define "Floor1D1_expected": 1
define "FloorNegD1": Floor(-0.1)
define "FloorNegD1_expected": -1
define "FloorNeg1": Floor(-1.0)
define "FloorNeg1_expected": -1
define "FloorNeg1D1": Floor(-1.1)
define "FloorNeg1D1_expected": -2
define "Floor2I": Floor(2)
define "Floor2I_expected": 2
define "FloorMaxInteger": Floor(2147483647)
define "FloorMaxInteger_expected": 2147483647
define "FloorMaxIntegerAsDecimal": Floor(2147483647.0)
define "FloorMaxIntegerAsDecimal_expected": 2147483647
define "FloorMaxIntegerAsDecimalWhereDecimalIsNonZero": Floor(2147483647.2)
define "FloorMaxIntegerAsDecimalWhereDecimalIsNonZero_expected": 2147483647
define "FloorIntegerGreaterThanMaxInteger": Floor(2147483648)
define "FloorIntegerGreaterThanMaxInteger_expected": null
define "FloorDecimalGreaterThanMaxInteger": Floor(2147483648.2)
define "FloorDecimalGreaterThanMaxInteger_expected": null
define "FloorMinInteger": Floor(-2147483648)
define "FloorMinInteger_expected": -2147483648
define "FloorMinIntegerAsDecimal": Floor(-2147483648.0)
define "FloorMinIntegerAsDecimal_expected": -2147483648
define "FloorMinIntegerAsDecimalWhereDecimalIsNonZero": Floor(-2147483648.2)
define "FloorMinIntegerAsDecimalWhereDecimalIsNonZero_expected": null
define "FloorIntegerLessThanMinInteger": Floor(-2147483649)
define "FloorIntegerLessThanMinInteger_expected": null
define "FloorDecimalLessThanMinInteger": Floor(-2147483649.2)
define "FloorDecimalLessThanMinInteger_expected": null
define "ExpNull": Exp(null as Decimal)
define "ExpNull_expected": null
define "Exp0": Exp(0)
define "Exp0_expected": 1.0
define "ExpNeg0": Exp(-0)
define "ExpNeg0_expected": 1.0
define "Exp1": Round(Exp(1), 8)
define "Exp1_expected": 2.71828183
define "Exp1L": Round(Exp(1L), 8)
define "Exp1L_expected": 2.71828183
define "ExpNeg1": Round(Exp(-1), 8)
define "ExpNeg1_expected": 0.36787944
define "HighBoundaryDecimal": HighBoundary(1.587, 8)
define "HighBoundaryDecimal_expected": 1.58799999
define "HighBoundaryDateMonth": HighBoundary(@2014, 6)
define "HighBoundaryDateMonth_expected": @2014-12
define "HighBoundaryDateTimeMillisecond": HighBoundary(@2014-01-01T08, 17)
define "HighBoundaryDateTimeMillisecond_expected": @2014-01-01T08:59:59.999
define "HighBoundaryTimeMillisecond": HighBoundary(@T10:30, 9)
define "HighBoundaryTimeMillisecond_expected": @T10:30:59.999
define "HighBoundaryNull": HighBoundary(null as Decimal, 8)
define "HighBoundaryNull_expected": null
define "HighBoundaryNullPrecision": HighBoundary(1.58888, null)
define "HighBoundaryNullPrecision_expected": 1.58888999
define "LogNullNull": Log(null, null)
define "LogNullNull_expected": null
define "Log1BaseNull": Log(1, null)
define "Log1BaseNull_expected": null
define "Log1Base1": Log(1, 1)
define "Log1Base1_expected": null
define "Log2Base1": Log(2, 1)
define "Log2Base1_expected": null
define "Log1Base2": Log(1, 2)
define "Log1Base2_expected": 0.0
define "Log1Base100": Log(1, 100)
define "Log1Base100_expected": 0.0
define "Log1Base100L": Log(1L, 100L)
define "Log1Base100L_expected": 0.0
define "Log16Base2": Log(16, 2)
define "Log16Base2_expected": 4.0
define "LogD125Base2": Log(0.125, 2)
define "LogD125Base2_expected": -3.0
define "LowBoundaryDecimal": LowBoundary(1.587, 8)
define "LowBoundaryDecimal_expected": 1.58700000
define "LowBoundaryDateMonth": LowBoundary(@2014, 6)
define "LowBoundaryDateMonth_expected": @2014-01
define "LowBoundaryDateTimeMillisecond": LowBoundary(@2014-01-01T08, 17)
define "LowBoundaryDateTimeMillisecond_expected": @2014-01-01T08:00:00.000
define "LowBoundaryTimeMillisecond": LowBoundary(@T10:30, 9)
define "LowBoundaryTimeMillisecond_expected": @T10:30:00.000
define "LowBoundaryNull": LowBoundary(null as Decimal, 8)
define "LowBoundaryNull_expected": null
define "LowBoundaryNullPrecision": LowBoundary(1.58888, null)
define "LowBoundaryNullPrecision_expected": 1.58888000
define "LnNull": Ln(null)
define "LnNull_expected": null
define "Ln1": Ln(1)
define "Ln1_expected": 0.0
define "Ln1L": Ln(1L)
define "Ln1L_expected": 0.0
define "LnNeg1": Ln(-1)
define "LnNeg1_expected": null
define "Ln1000": Round(Ln(1000), 8)
define "Ln1000_expected": 6.90775528
define "Ln1000D": Round(Ln(1000.0), 8)
define "Ln1000D_expected": 6.90775528
define "IntegerMinValue": minimum Integer
define "IntegerMinValue_expected": -2147483648
define "LongMinValue": minimum Long
define "LongMinValue_expected": -9223372036854775808L
define "DecimalMinValue": minimum Decimal
define "DecimalMinValue_expected": -99999999999999999999.99999999
define "DateTimeMinValue": minimum DateTime
define "DateTimeMinValue_expected": @0001-01-01T00:00:00.000Z
define "DateMinValue": minimum Date
define "DateMinValue_expected": @0001-01-01
define "TimeMinValue": minimum Time
define "TimeMinValue_expected": @T00:00:00.000
define "IntegerMaxValue": maximum Integer
define "IntegerMaxValue_expected": 2147483647
define "LongMaxValue": maximum Long
define "LongMaxValue_expected": 9223372036854775807L
define "DecimalMaxValue": maximum Decimal
define "DecimalMaxValue_expected": 99999999999999999999.99999999
define "DateTimeMaxValue": maximum DateTime
define "DateTimeMaxValue_expected": @9999-12-31T23:59:59.999Z
define "DateMaxValue": maximum Date
define "DateMaxValue_expected": @9999-12-31
define "TimeMaxValue": maximum Time
define "TimeMaxValue_expected": @T23:59:59.999
define "ModuloNull": 1 mod null
define "ModuloNull_expected": null
define "Modulo0By0": 0 mod 0
define "Modulo0By0_expected": null
define "Modulo4By2": 4 mod 2
define "Modulo4By2_expected": 0
define "Modulo4LBy2L": 4L mod 2L
define "Modulo4LBy2L_expected": 0L
define "Modulo4DBy2D": 4.0 mod 2.0
define "Modulo4DBy2D_expected": 0.0
define "Modulo10By3": 10 mod 3
define "Modulo10By3_expected": 1
define "Modulo10DBy3D": 10.0 mod 3.0
define "Modulo10DBy3D_expected": 1.0
define "Modulo10IBy3D": 10 mod 3.0
define "Modulo10IBy3D_expected": 1.0
define "ModuloDResult": 3.5 mod 3
define "ModuloDResult_expected": 0.5
define "ModuloQuantity": 3.5 'cm' mod 3 'cm'
define "ModuloQuantity_expected": 0.5 'cm'
define "Modulo10By3Quantity": 10.0 'g' mod 3.0 'g'
define "Modulo10By3Quantity_expected": 1.0 'g'
define "Modulo10By0Quantity": 10.0 'g' mod 0.0 'g'
define "Modulo10By0Quantity_expected": null
define "MultiplyNull": 1 * null
define "MultiplyNull_expected": null
define "Multiply1By1": 1 * 1
define "Multiply1By1_expected": 1
define "Multiply2LBy3L": 2L * 3L
define "Multiply2LBy3L_expected": 6L
define "Multiply1DBy2D": 1.0 * 2.0
define "Multiply1DBy2D_expected": 2.0
define "Multiply1By1L": 1 * 1L
define "Multiply1By1L_expected": 1L
define "Multiply1IBy2D": 1 * 2.0
define "Multiply1IBy2D_expected": 2.0
define "Multiply1CMBy2CM": 1.0 'cm' * 2.0 'cm'
define "Multiply1CMBy2CM_expected": 2.0'cm2'
define "NegateNull": -(null as Integer)
define "NegateNull_expected": null
define "Negate0": -0
define "Negate0_expected": 0
define "NegateNeg0": -(-0)
define "NegateNeg0_expected": 0
define "Negate1": -1
define "Negate1_expected": -1
define "Negate1L": -1L
define "Negate1L_expected": -1L
define "NegateMaxLong": -9223372036854775807L
define "NegateMaxLong_expected": -9223372036854775807L
define "NegateNeg1": -(-1)
define "NegateNeg1_expected": 1
define "NegateNeg1L": -(-1L)
define "NegateNeg1L_expected": 1L
define "Negate0D": -(0.0)
define "Negate0D_expected": 0.0
define "NegateNeg0D": -(-0.0)
define "NegateNeg0D_expected": 0.0
define "Negate1D": -(1.0)
define "Negate1D_expected": -1.0
define "NegateNeg1D": -(-1.0)
define "NegateNeg1D_expected": 1.0
define "Negate1CM": -(1'cm')
define "Negate1CM_expected": -1.0'cm'
define "PrecisionDecimal": Precision(1.58700)
define "PrecisionDecimal_expected": 5
define "PrecisionYear": Precision(@2014)
define "PrecisionYear_expected": 4
define "PrecisionDateTimeMilliseconds": Precision(@2014-01-05T10:30:00.000)
define "PrecisionDateTimeMilliseconds_expected": 17
define "PrecisionTimeMinutes": Precision(@T10:30)
define "PrecisionTimeMinutes_expected": 4
define "PrecisionTimeMilliseconds": Precision(@T10:30:00.000)
define "PrecisionTimeMilliseconds_expected": 9
define "PredecessorNull": predecessor of (null as Integer)
define "PredecessorNull_expected": null
define "PredecessorOf0": predecessor of 0
define "PredecessorOf0_expected": -1
define "PredecessorOf1": predecessor of 1
define "PredecessorOf1_expected": 0
define "PredecessorOf1L": predecessor of 1L
define "PredecessorOf1L_expected": 0L
define "PredecessorOf1D": predecessor of 1.0
define "PredecessorOf1D_expected": 0.99999999
define "PredecessorOf101D": predecessor of 1.01
define "PredecessorOf101D_expected": 1.00999999
define "PredecessorOf1DPrecision": predecessor of 1.0
define "PredecessorOf1DPrecision_expected": 0.9
define "PredecessorOf101DPrecision": predecessor of 1.01
define "PredecessorOf101DPrecision_expected": 1.00
define "PredecessorOf1QCM": predecessor of 1.0 'cm'
define "PredecessorOf1QCM_expected": 0.99999999'cm'
define "PredecessorOf1QCMPrecision": predecessor of 1.0 'cm'
define "PredecessorOf1QCMPrecision_expected": 0.9'cm'
define "PredecessorOfJan12000": predecessor of DateTime(2000,1,1)
define "PredecessorOfJan12000_expected": @1999-12-31T
define "PredecessorOfNoon": predecessor of @T12:00:00.000
define "PredecessorOfNoon_expected": @T11:59:59.999
define "PowerNullToNull": Power(null as Integer, null as Integer)
define "PowerNullToNull_expected": null
define "Power0To0": Power(0, 0)
define "Power0To0_expected": 1
define "Power2To2": Power(2, 2)
define "Power2To2_expected": 4
define "PowerNeg2To2": Power(-2, 2)
define "PowerNeg2To2_expected": 4
define "Power2ToNeg2": Power(2, -2)
define "Power2ToNeg2_expected": 0.25
define "Power2LTo2L": Power(2L, 2L)
define "Power2LTo2L_expected": 4L
define "Power2DTo2D": Power(2.0, 2.0)
define "Power2DTo2D_expected": 4.0
define "PowerNeg2DTo2D": Power(-2.0, 2.0)
define "PowerNeg2DTo2D_expected": 4.0
define "Power2DToNeg2D": Power(2.0, -2.0)
define "Power2DToNeg2D_expected": 0.25
define "Power2DTo2": Power(2.0, 2)
define "Power2DTo2_expected": 4.0
define "Power2To2D": Power(2, 2.0)
define "Power2To2D_expected": 4.0
define "Power2To4": 2^4
define "Power2To4_expected": 16
define "Power2LTo3L": 2L^3L
define "Power2LTo3L_expected": 8L
define "Power2DTo4D": 2.0^4.0
define "Power2DTo4D_expected": 16.0
define "Power2DToNeg2DEquivalence": Power(2, -2) ~ 0.25
define "Power2DToNeg2DEquivalence_expected": true
define "RoundNull": Round(null as Decimal)
define "RoundNull_expected": null
define "Round1": Round(1)
define "Round1_expected": 1.0
define "Round0D5": Round(0.5)
define "Round0D5_expected": 1.0
define "Round0D4": Round(0.4)
define "Round0D4_expected": 0.0
define "Round3D14159": Round(3.14159, 2)
define "Round3D14159_expected": 3.14
define "RoundNeg0D5": Round(-0.5)
define "RoundNeg0D5_expected": -1.0
define "RoundNeg0D4": Round(-0.4)
define "RoundNeg0D4_expected": 0.0
define "RoundNeg0D6": Round(-0.6)
define "RoundNeg0D6_expected": -1.0
define "RoundNeg1D1": Round(-1.1)
define "RoundNeg1D1_expected": -1.0
define "RoundNeg1D5": Round(-1.5)
define "RoundNeg1D5_expected": -2.0
define "RoundNeg1D6": Round(-1.6)
define "RoundNeg1D6_expected": -2.0
define "SubtractNull": 1 - null
define "SubtractNull_expected": null
define "Subtract1And1": 1 - 1
define "Subtract1And1_expected": 0
define "Subtract1LAnd1L": 1L - 1L
define "Subtract1LAnd1L_expected": 0L
define "Subtract1DAnd2D": 1.0 - 2.0
define "Subtract1DAnd2D_expected": -1.0
define "Subtract1CMAnd2CM": 1.0 'cm' - 2.0 'cm'
define "Subtract1CMAnd2CM_expected": -1.0'cm'
define "Subtract2And11D": 2 - 1.1
define "Subtract2And11D_expected": 0.9
define "SuccessorNull": successor of (null as Integer)
define "SuccessorNull_expected": null
define "SuccessorOf0": successor of 0
define "SuccessorOf0_expected": 1
define "SuccessorOf1": successor of 1
define "SuccessorOf1_expected": 2
define "SuccessorOf1L": successor of 1L
define "SuccessorOf1L_expected": 2L
define "SuccessorOf1D": successor of 1.0
define "SuccessorOf1D_expected": 1.00000001
define "SuccessorOf101D": successor of 1.01
define "SuccessorOf101D_expected": 1.01000001
define "SuccessorOf1DPrecision": successor of 1.0
define "SuccessorOf1DPrecision_expected": 1.1
define "SuccessorOf101DPrecision": successor of 1.01
define "SuccessorOf101DPrecision_expected": 1.02
define "SuccessorOfJan12000": successor of DateTime(2000,1,1)
define "SuccessorOfJan12000_expected": @2000-01-02T
define "SuccessorOfNoon": successor of @T12:00:00.000
define "SuccessorOfNoon_expected": @T12:00:00.001
define "TruncateNull": Truncate(null as Decimal)
define "TruncateNull_expected": null
define "Truncate0": Truncate(0)
define "Truncate0_expected": 0
define "Truncate0D0": Truncate(0.0)
define "Truncate0D0_expected": 0
define "Truncate0D1": Truncate(0.1)
define "Truncate0D1_expected": 0
define "Truncate1": Truncate(1)
define "Truncate1_expected": 1
define "Truncate1D0": Truncate(1.0)
define "Truncate1D0_expected": 1
define "Truncate1D1": Truncate(1.1)
define "Truncate1D1_expected": 1
define "Truncate1D9": Truncate(1.9)
define "Truncate1D9_expected": 1
define "TruncateNeg1": Truncate(-1)
define "TruncateNeg1_expected": -1
define "TruncateNeg1D0": Truncate(-1.0)
define "TruncateNeg1D0_expected": -1
define "TruncateNeg1D1": Truncate(-1.1)
define "TruncateNeg1D1_expected": -1
define "TruncateNeg1D9": Truncate(-1.9)
define "TruncateNeg1D9_expected": -1
define "TruncatedDivideNull": (null as Integer) div (null as Integer)
define "TruncatedDivideNull_expected": null
define "TruncatedDivide2By1": 2 div 1
define "TruncatedDivide2By1_expected": 2
define "TruncatedDivide2By0": 2 div 0
define "TruncatedDivide2By0_expected": null
define "TruncatedDivide10By3": 10 div 3
define "TruncatedDivide10By3_expected": 3
define "TruncatedDivide10LBy3L": 10L div 3L
define "TruncatedDivide10LBy3L_expected": 3L
define "TruncatedDivide10LBy0L": 10L div 0L
define "TruncatedDivide10LBy0L_expected": null
define "TruncatedDivide10d1By3D1": 10.1 div 3.1
define "TruncatedDivide10d1By3D1_expected": 3.0
define "TruncatedDivide10D1By0D": 10.1 div 0.0
define "TruncatedDivide10D1By0D_expected": null
define "TruncatedDivideNeg2ByNeg1": -2 div -1
define "TruncatedDivideNeg2ByNeg1_expected": 2
define "TruncatedDivideNeg10ByNeg3": -10 div -3
define "TruncatedDivideNeg10ByNeg3_expected": 3
define "TruncatedDivideNeg10d1ByNeg3D1": -10.1 div -3.1
define "TruncatedDivideNeg10d1ByNeg3D1_expected": 3.0
define "TruncatedDivideNeg2By1": -2 div 1
define "TruncatedDivideNeg2By1_expected": -2
define "TruncatedDivideNeg10By3": -10 div 3
define "TruncatedDivideNeg10By3_expected": -3
define "TruncatedDivideNeg10d1By3D1": -10.1 div 3.1
define "TruncatedDivideNeg10d1By3D1_expected": -3.0
define "TruncatedDivide2ByNeg1": 2 div -1
define "TruncatedDivide2ByNeg1_expected": -2
define "TruncatedDivide10ByNeg3": 10 div -3
define "TruncatedDivide10ByNeg3_expected": -3
define "TruncatedDivide10d1ByNeg3D1": 10.1 div -3.1
define "TruncatedDivide10d1ByNeg3D1_expected": -3.0
define "TruncatedDivide10By5D": 10 div 5.0
define "TruncatedDivide10By5D_expected": 2.0
define "TruncatedDivide10d1ByNeg3D1Quantity": 10.1 'cm' div -3.1 'cm'
define "TruncatedDivide10d1ByNeg3D1Quantity_expected": -3.0 '1'
define "TruncatedDivide10By5DQuantity": 10.0 'g' div 5.0 'g'
define "TruncatedDivide10By5DQuantity_expected": 2.0 '1'
define "TruncatedDivide414By206DQuantity": 4.14 'm' div 2.06 'm'
define "TruncatedDivide414By206DQuantity_expected": 2.0 '1'
define "TruncatedDivide10By0DQuantity": 10.0 'g' div 0.0 'g'
define "TruncatedDivide10By0DQuantity_expected": null
