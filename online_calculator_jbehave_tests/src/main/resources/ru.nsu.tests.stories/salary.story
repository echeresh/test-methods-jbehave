Scenario: Salary Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression 10000 * 12 using keyboard
When User types expression = using user interface
Then Result is 120000
When User types expression * 0.87 using keyboard
When User types expression = using user interface
Then Result is 104400