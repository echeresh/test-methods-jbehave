Scenario: Food price Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression 11.50 + 20.45 + 3.30 + 4.50 + 5.25 + 64.90 + 7.40 + 8.13 + 9.56 using keyboard
When User types expression = using user interface
Then Result is 134.99
When User types expression - 35.53 using keyboard
When User types expression = using user interface
Then Approximate result is 99.46