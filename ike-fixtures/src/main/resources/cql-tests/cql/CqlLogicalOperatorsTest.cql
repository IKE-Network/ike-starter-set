library CqlLogicalOperatorsTest version '1.0'

define "TrueAndTrue": true and true
define "TrueAndTrue_expected": true
define "TrueAndFalse": true and false
define "TrueAndFalse_expected": false
define "TrueAndNull": true and null
define "TrueAndNull_expected": null
define "FalseAndTrue": false and true
define "FalseAndTrue_expected": false
define "FalseAndFalse": false and false
define "FalseAndFalse_expected": false
define "FalseAndNull": false and null
define "FalseAndNull_expected": false
define "NullAndTrue": null and true
define "NullAndTrue_expected": null
define "NullAndFalse": null and false
define "NullAndFalse_expected": false
define "NullAndNull": null and null
define "NullAndNull_expected": null
define "TrueImpliesTrue": true implies true
define "TrueImpliesTrue_expected": true
define "TrueImpliesFalse": true implies false
define "TrueImpliesFalse_expected": false
define "TrueImpliesNull": true implies null
define "TrueImpliesNull_expected": null
define "FalseImpliesTrue": false implies true
define "FalseImpliesTrue_expected": true
define "FalseImpliesFalse": false implies false
define "FalseImpliesFalse_expected": true
define "FalseImpliesNull": false implies null
define "FalseImpliesNull_expected": true
define "NullImpliesTrue": null implies true
define "NullImpliesTrue_expected": true
define "NullImpliesFalse": null implies false
define "NullImpliesFalse_expected": null
define "NullImpliesNull": null implies null
define "NullImpliesNull_expected": null
define "NotTrue": not true
define "NotTrue_expected": false
define "NotFalse": not false
define "NotFalse_expected": true
define "NotNull": not null
define "NotNull_expected": null
define "TrueOrTrue": true or true
define "TrueOrTrue_expected": true
define "TrueOrFalse": true or false
define "TrueOrFalse_expected": true
define "TrueOrNull": true or null
define "TrueOrNull_expected": true
define "FalseOrTrue": false or true
define "FalseOrTrue_expected": true
define "FalseOrFalse": false or false
define "FalseOrFalse_expected": false
define "FalseOrNull": false or null
define "FalseOrNull_expected": null
define "NullOrTrue": null or true
define "NullOrTrue_expected": true
define "NullOrFalse": null or false
define "NullOrFalse_expected": null
define "NullOrNull": null or null
define "NullOrNull_expected": null
define "TrueXorTrue": true xor true
define "TrueXorTrue_expected": false
define "TrueXorFalse": true xor false
define "TrueXorFalse_expected": true
define "TrueXorNull": true xor null
define "TrueXorNull_expected": null
define "FalseXorTrue": false xor true
define "FalseXorTrue_expected": true
define "FalseXorFalse": false xor false
define "FalseXorFalse_expected": false
define "FalseXorNull": false xor null
define "FalseXorNull_expected": null
define "NullXorTrue": null xor true
define "NullXorTrue_expected": null
define "NullXorFalse": null xor false
define "NullXorFalse_expected": null
define "NullXorNull": null xor null
define "NullXorNull_expected": null
