package com.buenosdev.dynamicProgramming.houseRobberTwo;

import java.util.Arrays;

class ProblemSolution {

    /*
     * https://leetcode.com/problems/house-robber-ii/description/
     * */

    //  Iterative + memo (bottom-up)
    // Robbery of current house + loot from houses before the previous
    // loot from the previous house robbery and any loot captured before that

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        var sol1 = robHouses(Arrays.copyOfRange(nums, 0, nums.length - 1));
        var sol2 = robHouses(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(sol1, sol2);

    }

    public int robHouses(int[] nums) {
        var robbedHouses = new int[nums.length + 1];
        robbedHouses[0] = 0;
        robbedHouses[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            var currentL = nums[i];
            robbedHouses[i + 1] = Math.max(currentL + robbedHouses[i - 1], robbedHouses[i]);
        }

        return robbedHouses[nums.length];

    }

    private int robFAILED(int[] nums, int start, int end) {
        var robbedHouses = new int[nums.length + 1];
        robbedHouses[0] = 0;
        robbedHouses[1] = nums[start];

        for (int i = start + 1; i < end; i++) {
            var currentL = nums[i];
            robbedHouses[i + 1] = Math.max(currentL + robbedHouses[i - 1], robbedHouses[i]);
        }

        return robbedHouses[end];
    }

    public static void main(String[] args) {
        var solution = new ProblemSolution();

        // Test case 1
        int[] nums1 = {2, 3, 2};
        System.out.println("Expected output for test case 1 is 3. The output of the rob method is: " + solution.rob(nums1));

        // Test case 2
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Expected output for test case 2 is 12. The output of the rob method is: " + solution.rob(nums2));

        // Add more test cases as needed
    }


}