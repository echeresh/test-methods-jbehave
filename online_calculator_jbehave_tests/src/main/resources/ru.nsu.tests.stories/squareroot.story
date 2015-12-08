Scenario: Square root Scenario using keyboard

Given Start page of Online Calculator in browser
When User stores expression 3 in variable _s
When User stores expression 1 in variable _x

When User computes series _x equals 0.5 * (_x + _s / _x) with 10 iterations
When User types expression C using user interface
When User types expression _x * _x - _s using keyboard
When User types expression = using user interface
Then Approximate result is 0