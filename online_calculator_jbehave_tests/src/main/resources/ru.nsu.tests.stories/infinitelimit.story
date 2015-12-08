Scenario: Infinite limit Scenario using keyboard

Given Start page of Online Calculator in browser
When User types expression Infinity * Infinity / (Infinity + 1) * 0 using keyboard
When User types expression = using user interface
Then Result is NaN
When User types expression C using user interface
When User types expression Infinity / (1 + 1 / Infinity) using keyboard
When User types expression = using user interface
Then Result is Infinity