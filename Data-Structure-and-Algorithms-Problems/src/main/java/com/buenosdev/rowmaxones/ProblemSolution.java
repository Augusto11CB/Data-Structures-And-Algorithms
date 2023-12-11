package com.buenosdev.rowmaxones;

class ProblemSolution {

    // (Matrix) Problem 3: Row With Maximum Ones

    /*
    We are given a binary matrix that has dimensions , consisting of ones and zeros. Our task is to determine the row that
    contains the highest number of ones and return two values: the zero-based index of this row and the actual count of ones
    it possesses. If there is a tie, i.e., multiple rows contain the same maximum number of ones, we must select the row with
    the lowest index.
     * */

    /*
    Example 1:
    Input: [[1, 0], [1, 1], [0, 1]]
    Expected Output: [1, 2]
    Justification: The second row [1, 1] contains the most ones, so the output is [1, 2].

    Example 2:
    Input: [[0, 1, 1], [0, 1, 1], [1, 1, 1]]
    Expected Output: [2, 3]
    Justification: The third row [1, 1, 1] has the most ones, leading to the output [2, 3].

    Example 3:
    Input: [[1, 0, 1], [0, 0, 1], [1, 1, 0]]
    Expected Output: [0, 2]
    Justification: Both the first and third rows contain two ones, but we choose the first due to its lower index, resulting in [0, 2].
     * */

    public int[] findMaxOnesRow(int[][] mat) {
        int maxOnesIdx = 0;
        int maxOnesCount = 0;

        for (int i = 0; i < mat.length; i++) {
            int onesWithinRowI = 0;
            for (int j = 0; j < mat[i].length; j++) {
                // if (mat[i][j] == 1) {
                //    onesWithinRowI++;
                // }
                onesWithinRowI += mat[i][j];
            }

            if (maxOnesCount < onesWithinRowI) {
                maxOnesCount = onesWithinRowI;
                maxOnesIdx = i;
            }
        }
        return new int[]{maxOnesIdx, maxOnesCount};
    }
}
/*
Time Complexity:
 - O(n*m)

Space Complexity:
 - O(1)
*/