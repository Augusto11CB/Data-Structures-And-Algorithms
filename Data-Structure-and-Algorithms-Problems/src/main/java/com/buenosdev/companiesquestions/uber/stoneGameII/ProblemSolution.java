package com.buenosdev.companiesquestions.uber.stoneGameII;

class ProblemSolution {
    // Main method to solve the Stone Game II problem
    public int stoneGameII(int[] piles) {
        int n = piles.length; // Get the number of piles
        int[][][] dp = new int[2][n][n + 1]; // Initialize the 3D DP array to store intermediate results

        // Start the recursive BFS with initial parameters: player 0, starting index 0, and initial M value 1
        return bfs(0, 0, 1, piles, dp);
    }

    // Recursive method to simulate the game and compute the optimal result
    private int bfs(int a, int i, int m, int[] piles, int[][][] dp) {
        if (i == piles.length) { // Base case: if we've reached the end of the piles, no more stones to take
            return 0;
        }
        if (dp[a][i][m] != 0) { // Check if we already have a computed result for this state
            return dp[a][i][m];
        }

        // Initialize the result variable
        // If it's player 0 (first player), we want to maximize the result (start with 0)
        // If it's player 1 (second player), we want to minimize the result (start with MAX_VALUE)
        int res = (a == 0) ? 0 : Integer.MAX_VALUE;
        int total = 0; // Variable to keep track of the total stones taken in the current move
        for (int x = 1; x <= 2 * m; x++) { // Loop to try taking 1 to 2*M piles of stones
            if (i + x > piles.length) { // Break if we go beyond the number of piles
                break;
            }
            total += piles[i + x - 1]; // Add the stones from the current pile to the total
            if (a == 0) {
                // For player 0, we want to maximize the result by taking the current total and the result of the next move
                res = Math.max(res, total + bfs(1, i + x, Math.max(m, x), piles, dp));
            } else {
                // For player 1, we want to minimize the result by taking the result of the next move
                res = Math.min(res, bfs(0, i + x, Math.max(m, x), piles, dp));
            }
        }

        dp[a][i][m] = res; // Store the computed result in the DP array
        return dp[a][i][m]; // Return the computed result for this state
    }

    // Example usage of the solution
    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution(); // Create an instance of the Solution class
        int[] piles = {2, 7, 9, 4, 4}; // Example input
        System.out.println(sol.stoneGameII(piles)); // Print the result of the stoneGameII method
    }
}
