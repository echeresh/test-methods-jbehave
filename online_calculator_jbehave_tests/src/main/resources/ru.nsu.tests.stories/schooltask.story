Scenario: School task Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression 123 + 212 + -345.3 + 449 + -552 + 666 + 716 + 824 + -9.14 using keyboard
When User types expression = using user interface
Then Result is 2083.56
When User types expression + -2357.1 using keyboard
When User types expression = using user interface
Then Approximate result is -273.54