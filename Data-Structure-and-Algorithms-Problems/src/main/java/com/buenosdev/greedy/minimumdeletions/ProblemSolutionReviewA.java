package com.buenosdev.greedy.minimumdeletions;

public class ProblemSolutionReviewA {

    // (Greedy Algorithm) Problem J: Removing Minimum and Maximum From Array

    /*
    https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/
     **/

    /*
     * */
    public static void main(String[] args) {

        var problemSolution = new ProblemSolutionReviewA();
        problemSolution.minimumDeletions(new int[]{-14, 61, 29, -18, 59, 13, -67, -16, 55, -57, 7, 74});

    }

    public int minimumDeletions(int[] nums) {

        var intMax = Integer.MIN_VALUE;
        var intMaxPosition = -1;
        var intMin = Integer.MAX_VALUE;
        var intMinPosition = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > intMax) {
                intMax = nums[i];
                intMaxPosition = i;
            }
            if (nums[i] < intMin) {
                intMin = nums[i];
                intMinPosition = i;
            }
        }

        var minDistanceToEnd = nums.length - intMinPosition;
        var maxDistanceToEnd = nums.length - intMaxPosition;

        var removeFromBegin = Math.max(intMaxPosition + 1, intMinPosition + 1);
        var removeFromEnd = Math.max(minDistanceToEnd, maxDistanceToEnd);

        var removeMinFromStartAndMaxFromEnd = intMinPosition + 1 + maxDistanceToEnd;
        var removeMaxFromStartAndMinFromEnd = minDistanceToEnd + intMaxPosition + 1;
        var removeFromEndAndStart = Math.min(removeMinFromStartAndMaxFromEnd, removeMaxFromStartAndMinFromEnd);

        return Math.min(Math.min(removeFromEnd, removeFromBegin), removeFromEndAndStart);

    }
}