library CqlErrorsAndMessagingOperatorsTest version '1.0'

define "TestMessageInfo": Message(1, true, '100', 'Message', 'Test Message')
define "TestMessageInfo_expected": 1
define "TestMessageWarn": Message(2, true, '200', 'Warning', 'You have been warned!')
define "TestMessageWarn_expected": 2
define "TestMessageTrace": Message({3, 4, 5}, true, '300', 'Trace', 'This is a trace')
define "TestMessageTrace_expected": {3, 4, 5}
