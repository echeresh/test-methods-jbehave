Scenario: Quadratic equation Scenario using keyboard

Given Start page of Online Calculator in browser
When User stores expression 1 in variable _a
When User stores expression -3 in variable _b
When User stores expression 2 in variable _c
When User types expression _b * _b - 4 * _a * _c using keyboard
When User types expression = using user interface
Then Result is 1
When User stores result in variable _d
When User types expression C using user interface
When User types expression (- _b + _d) / 2 / _a using keyboard
When User types expression = using user interface
Then Result is 2
When User stores result in variable _x0
When User types expression C using user interface
When User types expression (- _b - _d) / 2 / _a using keyboard
When User types expression = using user interface
Then Result is 1
When User stores result in variable _x1
When User types expression C using user interface
When User types expression (_x0 + _x1) using keyboard
When User types expression + _b using keyboard
When User types expression = using user interface
Then Result is 0
When User types expression C using user interface
When User types expression (_x0 * _x1) using keyboard
When User types expression - _c using keyboard
When User types expression = using user interface
Then Result is 0