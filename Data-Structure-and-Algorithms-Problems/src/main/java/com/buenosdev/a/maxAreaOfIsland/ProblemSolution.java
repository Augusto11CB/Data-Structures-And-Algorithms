package com.buenosdev.a.maxAreaOfIsland;

public class ProblemSolution {
    public int maxAreaOfIsland(int[][] grid) {
        // Initialize maxLength to track the maximum area found. Integer.MIN_VALUE
        // ensures any positive area will replace it.
        var maxLength = 0;

        // Iterate over each cell in the grid.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Start a DFS if the cell is part of an island (i.e., grid[i][j] == 1).
                if (grid[i][j] == 1) {
                    var newLength = dfs(grid, i, j, grid.length - 1, grid[i].length - 1);
                    // Update maxLength with the larger of the current maxLength and the area
                    // returned by DFS.
                    maxLength = Math.max(maxLength, newLength);
                }
            }
        }
        // Return the largest area found.
        return maxLength;
    }

    private int dfs(int[][] grid, int row, int col, int rowSize, int colSize) {
        // Base case: return 0 if out of bounds or if the cell is not part of an island.
        if (row < 0 || row > rowSize || col < 0 || col > colSize || grid[row][col] != 1)
            return 0;

        // Mark the cell as visited by setting it to -1. This avoids counting it in
        // future DFS calls.
        grid[row][col] = -1;

        // Recursively visit all four neighboring cells.
        var up = dfs(grid, row + 1, col, rowSize, colSize);
        var down = dfs(grid, row - 1, col, rowSize, colSize);
        var left = dfs(grid, row, col - 1, rowSize, colSize);
        var right = dfs(grid, row, col + 1, rowSize, colSize);

        // Return the total area for this island segment: 1 for the current cell + areas
        // of all neighboring cells.
        return 1 + up + down + left + right;
    }
}
