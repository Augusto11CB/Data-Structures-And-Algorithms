# 1672. Richest Customer Wealth
## Intuition
My idea for solving this problem was to calculate the sum of the columns in each row of the matrix to find the richest customer. As I iterated through the matrix, I stored the highest amount found in a variable.

## Complexity
- Time complexity: O(n*m)
    - Given that `n` is the number of rows and `m` is the number of columns. The complexity is $$O(n*m)$$ because the code iterates through each element in the matrix once using **two nested for loops**.

- Space complexity: O(1)
    - The code only use a variable called biggestAmount