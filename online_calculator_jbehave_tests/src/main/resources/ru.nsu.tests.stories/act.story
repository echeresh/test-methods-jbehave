Scenario: Acceptance Scenario using UI keys

Given Start page of Online Calculator in browser
When User types expression 1+2*3 using user interface
When User types expression = using user interface
Then Result is 7

Scenario: Acceptance Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression 1+2*3 using keyboard
When User types expression = using user interface
Then Result is 7
