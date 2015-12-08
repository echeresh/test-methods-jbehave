Scenario: Material mixture Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression 1.011 * 2 + 3.895 * 4 + 5.5001 * 6 + 0.0033 * 9 using keyboard
When User types expression = using user interface
Then Approximate result is 50.6323
When User types expression / 100 * 2 using keyboard
When User types expression = using user interface
Then Approximate result is 1.012646