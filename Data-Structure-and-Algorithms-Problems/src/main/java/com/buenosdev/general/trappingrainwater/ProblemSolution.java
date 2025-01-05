package com.buenosdev.general.trappingrainwater;

class ProblemSolution {

    /*
     * https://leetcode.com/problems/trapping-rain-water/description/
     * */

    // Do as directed in question. For each element in the array, we find the maximum level of water it can trap after
    // the rain, which is equal to the minimum of maximum height of bars on both the sides minus its own height.
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int storedWaterResult = 0;
        // Fill maxLeft array
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        // Fill maxRight array
        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        // Calculate trapped water
        // Math.min(maxLeft[i], maxRight[i]) - height[i]
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(maxLeft[i], maxRight[i]);
            storedWaterResult += minHeight - height[i];
        }

        return storedWaterResult;
    }
}