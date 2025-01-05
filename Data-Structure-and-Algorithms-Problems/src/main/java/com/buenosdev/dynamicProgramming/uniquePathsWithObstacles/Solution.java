package com.buenosdev.dynamicProgramming.uniquePathsWithObstacles;

class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        // Get the number of rows and columns, adjusting for 0-based indexing
        var m = o.length - 1;
        var n = o[m].length - 1;
        
        // Initialize a response array to hold the final count (not really needed in this approach)
        var resp = new int[1];
        
        // Initialize a memoization table to store results of subproblems
        var mem = new int[m + 1][n + 1];

        // Call the DFS function starting from the top-left corner (0,0)
        return dfs(o, mem, 0, 0, resp, m, n);
    }

    private int dfs(int[][] g, int[][] mem, int row, int col, int[] resp, int m, int n) {
        // If out of bounds or hitting an obstacle, return 0 (no path)
        if (row > m || row < 0 || col > n || col < 0 || g[row][col] == 1)
            return 0;

        // If we reach the bottom-right corner, return 1 (one valid path found)
        if (row == m && col == n) {
            mem[row][col] = 1;
            return 1;
        }

        // If we have already computed this cell, return its value
        if (mem[row][col] != 0)
            return mem[row][col];

        // Calculate paths by moving down and right
        var down = dfs(g, mem, row + 1, col, resp, m, n);
        var right = dfs(g, mem, row, col + 1, resp, m, n);

        // Store the result in the memoization table and return it
        mem[row][col] = down + right;

        return mem[row][col];
    }


    /*
    The time complexity is O(m * n) where m is the number of rows and n is the number of columns:
        - Each cell (i, j) is visited once and its result is computed and stored in mem[i][j].
        - The memoization ensures that each cell's value is calculated at most once.
    * */

    /*
    The space complexity is also O(m * n):
        - The memoization table mem of size (m+1) x (n+1) requires O(m * n) space.
    * */
}
