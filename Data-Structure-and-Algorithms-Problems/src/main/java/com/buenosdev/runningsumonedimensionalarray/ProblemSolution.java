package com.buenosdev.runningsumonedimensionalarray;

public class ProblemSolution {

    // Problem 1: Running Sum of 1d Array (easy)

    /*
    Given a one-dimensional array of integers, create a new array that represents the running sum of the original array.

    The running sum at position i in the new array is calculated as the sum of all the numbers in the original array
    from the 0th index up to the i-th index (inclusive).
    Formally, the resulting array should be computed as follows: result[i] = sum(nums[0] + nums[1] + ... + nums[i])
    for each i from 0 to the length of the array minus one.

    * */

    /*
    Example 1
    Input: [2, 3, 5, 1, 6]
    Expected Output: [2, 5, 10, 11, 17]
    Justification:
    For i=0: 2
    For i=1: 2 + 3 = 5
    For i=2: 2 + 3 + 5 = 10
    For i=3: 2 + 3 + 5 + 1 = 11
    For i=4: 2 + 3 + 5 + 1 + 6 = 17

    Example 2
    Input: [1, 1, 1, 1, 1]
    Expected Output: [1, 2, 3, 4, 5]
    Justification: Each element is simply the sum of all preceding elements plus the current element.

    Example 3
    Input: [-1, 2, -3, 4, -5]
    Expected Output: [-1, 1, -2, 2, -3]
    Justification: Negative numbers are also summed up in the same manner as positive ones.

    * */

    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();

        // Test cases
        int[][] testInputs = {
                {1, 2, 3, 4},
                {3, 1, 4, 2, 2},
                {-1, -2, -3, -4, -5}
        };

        for (int[] input : testInputs) {
            int[] output = solution.runningSum(input);

            // Print the output array
            for (int val : output) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public int[] runningSum(int[] nums) {

        // Check if the array is null or has no elements and return an empty array if true
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // Initialize an array to store the running sum
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }

        return result;
    }
}

/*
Time Complexity:
 - O(n): We iterate through all (n) elements of the input array exactly once. Inside the loop, we perform a constant amount
of work (a sum and an assignment). Hence, the time complexity is linear.

Space Complexity:
 - O(1): The algorithm uses a constant amount of extra space. The result array does not count towards the space complexity
since it's the expected output. However, no additional data structures grow with the input size, meaning that the algorithm
uses a constant amount of additional memory.
*/