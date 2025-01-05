package com.buenosdev.dynamicProgramming.climbStairs;

class ProblemSolutionReviewB {
    // Tabulation
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
}