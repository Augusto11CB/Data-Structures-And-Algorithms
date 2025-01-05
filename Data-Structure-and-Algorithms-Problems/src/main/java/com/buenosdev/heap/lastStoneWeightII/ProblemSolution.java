package com.buenosdev.heap.lastStoneWeightII;

import java.util.Arrays;

class ProblemSolution {

    // The problem of finding the last remaining stone weight after repeatedly smashing the two heaviest stones can be transformed into
    // a problem of partitioning the stones into two groups such that the difference in their total weights is minimized.

    // Ideally, we want to split the stones into two groups with nearly equal total weights. This would minimize the remaining stone weight (or the difference) after all possible smash operations.
    // The closest we can get to an equal partition is each group having a total weight close to half of the sum.

    // By targeting a weight close to half of the sum (`target = ceil(sum / 2)`), we aim to find a subset of stones whose total weight is as close as possible to this target. This subset, when subtracted from the total sum, gives us the closest possible weight to the other half.
    public int lastStoneWeightII(int[] stones) {
        var totalWeight = Arrays.stream(stones).sum();
        var target = (int) Math.ceil(totalWeight / 2);

        var dp = new int[stones.length][totalWeight + 1];
        Arrays.fill(dp, -1);


        return dfs(stones, 0, 0, target, totalWeight, dp);
    }

    private int dfs(int[] stones, int i, int weightSoFar, int target, int totalWeight, int[][] dp) {
        // Base case: if the current weight exceeds or equals the target, or if all stones have been considered
        if(weightSoFar >= target || i >= stones.length){
            // This is the smallest possible difference we aim for.
            var theOtherHalf = totalWeight - weightSoFar;

            // The absolute difference represents the last remaining stone weight or the smallest possible difference we can achieve.
            return Math.abs(weightSoFar - theOtherHalf);
        }

        if(dp[i][weightSoFar] != -1 ) return dp[i][weightSoFar];

        // Recursive case: compute the minimum difference by considering two scenarios
        // 1. Do not include the current stone and keep the current weight unchanged
        // 2. Include the current stone and add its weight to the current weight
        var valueOne = dfs(stones, i + 1, weightSoFar, target, totalWeight, dp);
        var valueTwo = dfs(stones, i + 1, weightSoFar + stones[i], target, totalWeight, dp);

        // since we want the smallest possible difference, we will choose the min value between valueOne and valueTwo;

        dp[i][weightSoFar] = Math.min(valueOne, valueTwo);

        return dp[i][weightSoFar];
    }
}
