package com.buenosdev.dynamicProgramming.houseRobber;

class ProblemSolution {

    /*
    * https://leetcode.com/problems/house-robber/description/
    * */

    //  Iterative + memo (bottom-up)
    // obbery of current house + loot from houses before the previous
    //loot from the previous house robbery and any loot captured before that

    public int rob(int[] nums) {
        var robbedHouses = new int[nums.length + 1];
        robbedHouses[0] = 0;
        robbedHouses[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            var currentL = nums[i];
            robbedHouses[i + 1] = Math.max(currentL + robbedHouses[i - 1], robbedHouses[i]);
        }

        return robbedHouses[nums.length];

    }


}