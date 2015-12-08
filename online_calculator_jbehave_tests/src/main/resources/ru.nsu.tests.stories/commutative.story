Scenario: Commutative Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression 123 + 456 using keyboard
When User types expression = using user interface
Then Result is 579
When User types expression C using user interface
When User types expression 456 + 123 using keyboard
When User types expression = using user interface
Then Result is 579