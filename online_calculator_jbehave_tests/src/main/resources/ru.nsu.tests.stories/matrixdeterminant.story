Scenario: Matrix determinant Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression 4 * 29 * (-5) + 3 * 5 * 41 + 0 * 6 * 12 using keyboard
When User types expression = using user interface
Then Result is 35
When User types expression - (0 * 29 * 41 + 4 * 5 * 12 + 3 * 6 * (-5)) using keyboard
When User types expression = using user interface
Then Result is -115