Scenario: Binary numbers Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression 0b10 + 0b101 using keyboard
When User types expression = using user interface
When User stores result in variable _result
Then Result is 7
When User types expression C using user interface
When User loads from variable _result
When User types expression - 0b111 using keyboard
When User types expression = using user interface
Then Result is -7