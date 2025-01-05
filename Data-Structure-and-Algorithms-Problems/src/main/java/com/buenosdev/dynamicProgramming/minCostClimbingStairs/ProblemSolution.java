package com.buenosdev.dynamicProgramming.minCostClimbingStairs;

class ProblemSolution {

    /*
    * https://leetcode.com/problems/min-cost-climbing-stairs/description/
    * */

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[dp.length - 1] = dp[dp.length - 2] = 1;

        for (int i = dp.length - 3; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }

    public int minCostClimbingStairs(int[] cost) {
        // [10,15,20]
        // In reality we need to consider the array as [10,15,20, _0_]
        // because the "top of the floor" is not 20, but the index beyond the last slot of the array.

        for (int i = cost.length - 3; i >= 0; i--) {
            var oneJumpCost = cost[i] + cost[i + 1];
            var twoJumpCost = cost[i] + cost[i + 2];
            cost[i] = Math.min(oneJumpCost, twoJumpCost);
        }

        return Math.min(cost[0], cost[1]);
    }
}