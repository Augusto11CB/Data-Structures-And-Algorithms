# 485 Max Consecutive Ones

## Intuition
Count the sequences of 'ones' until you find 'zero', store the count in a variable. Start counting again when you find the next 'one'. If another 'zero' is found, compare the current count with the one previously stored in the variable, and find the one that is greater.

## Complexity
- Time complexity: `O(n)`

- Space complexity: `O(1)`
