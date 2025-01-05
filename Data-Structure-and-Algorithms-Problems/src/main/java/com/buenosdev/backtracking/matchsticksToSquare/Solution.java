package com.buenosdev.backtracking.matchsticksToSquare;

import java.util.*;
class Solution {
    public boolean makesquare(int[] matchsticks) {
        // Check if the input is valid
        if (matchsticks == null || matchsticks.length == 0) {
            return false;
        }

        int perimeter = 0;

        // Calculate the total perimeter by summing all matchsticks
        for (int i = 0; i < matchsticks.length; i++) {
            perimeter += matchsticks[i];
        }

        // If the perimeter is not divisible by 4, we can't form a square
        if (perimeter % 4 != 0)
            return false;

        // Each side of the square should be perimeter / 4
        int side = perimeter / 4;

        // Array to store the length of the four sides of the square
        int[] sides = new int[4];

        // Convert int[] to Integer[] to use Collections.reverseOrder for sorting
        Integer[] arInteger = Arrays.stream(matchsticks).boxed().toArray(Integer[]::new);

        // Sort the matchsticks in descending order to optimize the DFS (placing larger sticks first)
        Arrays.sort(arInteger, Collections.reverseOrder());

        // Start the depth-first search (DFS) to try to form the square
        return dfs(arInteger, sides, 0, side);
    }

    // Helper method to perform DFS
    private boolean dfs(Integer[] m, int[] sides, int cur, int side) {
        // If all matchsticks are used, check if all sides are equal
        if (cur >= m.length) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        // Try to place the current matchstick in each of the four sides
        for (int i = 0; i < sides.length; i++) {
            // Check if placing the matchstick in the current side does not exceed the target side length
            if (sides[i] + m[cur] <= side) {
                // Place the matchstick in the current side
                sides[i] += m[cur];
                // Continue with the next matchstick
                if (dfs(m, sides, cur + 1, side))
                    return true;
                // Backtrack: remove the matchstick from the current side
                sides[i] -= m[cur];
            }
        }

        // If placing the current matchstick in any side does not work, return false
        return false;
    }

    // For each matchstick, we have up to 4 choices (one for each side of the square).

    // O(4^n)
}
