Scenario: Pythagorean theorem Scenario using keyboard

Given Start page of Online Calculator in browser
When User stores expression 0.8 in variable _a
When User stores expression 0.6 in variable _b
When User types expression _a * _a + _b * _b using keyboard
When User types expression = using user interface
Then Result is 1
When User stores result in variable _c
When User types expression C using user interface
When User types expression 0.5 * _a * _b using keyboard
When User types expression = using user interface
When User stores result in variable _area
When User types expression C using user interface
When User types expression 0.5 * (_a + _b + _c) using keyboard
When User types expression = using user interface
When User stores result in variable _half_perimeter
When User types expression C using user interface
When User types expression _half_perimeter * (_half_perimeter - _a) * (_half_perimeter - _b) * (_half_perimeter - _c) using keyboard
When User types expression - (_area * _area) using keyboard
When User types expression = using user interface
Then Approximate result is 0