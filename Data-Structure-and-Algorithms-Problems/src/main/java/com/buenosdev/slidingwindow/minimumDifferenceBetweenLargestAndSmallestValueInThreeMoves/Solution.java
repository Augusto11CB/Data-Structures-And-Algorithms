package com.buenosdev.slidingwindow.minimumDifferenceBetweenLargestAndSmallestValueInThreeMoves;

import java.util.Arrays;

class Solution {
    public int minDifferenceII(int[] nums) {
        if (nums.length < 4)
            return 0;
        Arrays.sort(nums);

        var min = Integer.MAX_VALUE;
        for (int l = 0; l < 4; l++) {
            int r = nums.length - 4 + l;
            min = Math.min(min, nums[r] - nums[l]);

        }
        return min;

    }

    public int minDifferenceIII(int[] nums) {
        if (nums.length < 4)
            return 0;
        Arrays.sort(nums);

        var smallAr = new int[4];

        for (int i = 0; i < 4; i++) {
            smallAr[i] = nums[i];
        }

        var largeAr = new int[4];
        var idx = 0;
        for (int i = nums.length - 1; i >= nums.length - 4; i--) {
            largeAr[idx] = nums[i];
            idx++;
        }

        Arrays.sort(largeAr);

        var min = Integer.MAX_VALUE;
        for (int l = 0; l < 4; l++) {
            min = Math.min(min, largeAr[l] - smallAr[l]);
        }
        return min;

    }

    public int minDifference(int[] nums) {
        // If there are fewer than 4 elements, the minimum difference is always 0
        if (nums.length <= 4) {
            return 0;
        }

        // Sort the array
        Arrays.sort(nums);

        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        // Compare the differences after removing up to 3 elements from either end
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(minDiff, nums[n - 4 + i] - nums[i]);
        }

        return minDiff;
    }
}