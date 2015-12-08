Scenario: Associative Scenario using keyboard

Given Start page of Online Calculator in browser
When User stores expression 100000 in variable _matrixRows
When User stores expression 100 in variable _matrixCols
When User types expression (_matrixRows * _matrixCols *  _matrixCols - 1 / 3 * _matrixCols * _matrixCols * _matrixCols - 1 / 2 * _matrixCols *  _matrixCols) using keyboard
When User types expression = using user interface
Then Result is 999661666.6666666
When User types expression / 1e9 using keyboard
When User types expression = using user interface
Then Result is 0.9996616666666667
When User types expression / 0.007 / 36 / 2.3 / 16 using keyboard
When User types expression = using user interface
Then Result is 0.10779650477340695