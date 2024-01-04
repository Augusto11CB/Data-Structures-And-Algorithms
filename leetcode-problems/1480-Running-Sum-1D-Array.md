# 1480 Running Sum of 1D Array
# Intuition
I thought that by using the already calculated running sums from the previous array slots (i-1) to calculate the sum of the current element (i), I could avoid having to iterate through the input array multiple times to recalculate values that had already been calculated.

# Complexity
- Time complexity: O(n)
  - It is  O(n), because the code iterates through the entire input array once using a for loop, performing a constant amount of work at each iteration.

- Space complexity: O(n)
  - I declare a new integer array called `result` as the same lenght as the input array. Thus, the space required to store is proportioanal to the lenght of the input. 