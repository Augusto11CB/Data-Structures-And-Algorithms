package com.buenosdev.greedy.maxsubarray;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemSolution {

    // (Greedy Algorithm) Problem D: Maximum Subarray

    /*
    https://leetcode.com/problems/maximum-subarray/description/
     **/

    /*
     * */

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int onGoingSum = 0;

        for (int i = 0; i < nums.length; i++) {
            onGoingSum = onGoingSum + nums[i];

            if (onGoingSum > maxSum) maxSum = onGoingSum;

            // If the current sum currentSum becomes negative, it indicates that including the current element in the
            // subarray would reduce the overall sum. Then, we should remove this sub array and restart count.
            if (onGoingSum < 0) {
                onGoingSum = 0;
            }
        }

        return maxSum;

    }


    public static void main(String[] args) {

    }

}