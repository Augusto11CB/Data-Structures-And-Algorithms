package com.buenosdev.general.trappingrainwater;

class ProblemSolutionReviewA {

    /*
     * https://leetcode.com/problems/trapping-rain-water/description/
     * */
    public int trap(int[] height) {
        int rightPointer = height.length - 1;
        int leftPointer = 0;

        var maxLeft = height[leftPointer];
        var maxRight = height[rightPointer];

        var resp = 0;

        while (leftPointer < rightPointer) {
            if (maxLeft <= maxRight) {
                leftPointer = leftPointer + 1;
                maxLeft = Math.max(maxLeft, height[leftPointer]);
                resp = resp + maxLeft - height[leftPointer];
            } else {
                rightPointer = rightPointer - 1;
                maxRight = Math.max(maxRight, height[rightPointer]);
                resp = resp + maxRight - height[rightPointer];
            }
        }
        return resp;
    }
}