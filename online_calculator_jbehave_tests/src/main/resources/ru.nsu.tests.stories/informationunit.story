Scenario: Information unit Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression 1.37 * 1024 * 1024 * 1024 * 8 using keyboard
When User types expression = using user interface
Then Result is 11768210391.04
When User types expression / (5 * 1024 * 1024) using keyboard
When User types expression = using user interface
Then Result is 2244.608
When User types expression  / 60 / 60 using keyboard
When User types expression = using user interface
Then Result is 0.6235022222222223