package com.buenosdev.leftrightsumdifferences;

import java.util.HashSet;

class ProblemSolution {

    // Problem 3: Left and Right Sum Differences


    /*
    Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:

    answer.length == nums.length.
    answer[i] = |leftSum[i] - rightSum[i]|.

    Where:
    - leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
    - rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.

    Return the array answer.
     */

    /*
    Example 1:
    Input: nums = [10,4,8,3]
    Output: [15,1,11,22]
    Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
    The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].

    Example 2:
    Input: nums = [1]
    Output: [0]
    Explanation: The array leftSum is [0] and the array rightSum is [0].
    The array answer is [|0 - 0|] = [0].
     */

    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();
        int[] example1 = {2, 5, 1, 6};
        int[] example2 = {3, 1, 4, 2, 2};
        int[] example3 = {1, 2, 3, 4, 5};

        // Output should be: [12, 5, 1, 8]
        printArray(solution.findDifferenceArray(example1));
        // Output should be: [9, 5, 0, 6, 10]
        printArray(solution.findDifferenceArray(example2));
        // Output should be: [14, 11, 6, 1, 10]
        printArray(solution.findDifferenceArray(example3));
    }

    // Helper method to print array elements
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int[] leftArray = new int[n];
        int[] rightArray = new int[n];

        leftArray[0] = 0;
        for (int i = 1; i < leftArray.length; i++) {
            leftArray[i] = leftArray[i - 1] + nums[i - 1];
        }

        rightArray[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightArray[i] = rightArray[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < leftArray.length; i++) {
            differenceArray[i] = Math.abs(leftArray[i] - rightArray[i]);
        }

        return differenceArray;
    }

    public int[] findDifferenceArrayV2(int[] nums) {
        int leftSum = 0, rightSum = 0, n = nums.length;
        for (int num : nums) rightSum += num;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            nums[i] = Math.abs((leftSum - nums[i]) - rightSum);
        }
        return nums;
    }
}

/*
Time Complexity:
 - O(3n): Because of the 3 for loops.

Space Complexity:
 - O(n): Because The algorithm utilizes two additional arrays: rightArray and leftArray, each of size n.
 This contributes (2n) to the space complexity, i.e., (O(2n)).
*/