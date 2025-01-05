package com.buenosdev.dynamicProgramming.triangle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<String, Integer> map;

    public int minimumTotal(List<List<Integer>> triangle) {
        map = new HashMap<>();
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int row, int col) {
        if (row >= triangle.size()) {
            return 0;
        }

        String key = row + "," + col;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int curValue = triangle.get(row).get(col);
        int leftPath = dfs(triangle, row + 1, col);
        int rightPath = dfs(triangle, row + 1, col + 1);
        int minPath = Math.min(leftPath, rightPath) + curValue;

        map.put(key, minPath);
        return minPath;
    }


    public int minimumTotalII(List<List<Integer>> triangle) {
        // Create a dp array to store the minimum path sums for each level of the triangle
        // The size of the dp array is 201 as a safe upper limit, assuming the maximum number
        // of rows in the triangle does not exceed 200. [from problem desc]
        var dp = new int[201];

        // Start from the bottom row of the triangle and move upwards
        for (int row = triangle.size() - 1; row >= 0; row--) {
            // Iterate through each element in the current row
            for (int j = 0; j < triangle.get(row).size(); j++) {
                // For each element, update the dp array with the minimum path sum
                // by considering the current element and the minimum of the two possible paths
                // from the row below (dp[j] and dp[j + 1])
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(row).get(j);
            }
        }

        // The answer will be the minimum path sum starting from the top of the triangle,
        // which is now stored in dp[0]
        return dp[0];
    }
}