package com.buenosdev.a.determineWhetherMatrixCanBeObtainedByRotation;

class ProblemSolution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // Try to match the target by rotating the matrix up to 4 times (360 degrees in total)
        for (int i = 1; i <= 4; i++) {
            // Check if the current matrix is equal to the target matrix
            if (isEqual(mat, target))
                return true;
            // Rotate the matrix 90 degrees clockwise
            rotate(mat);
        }
        // If no rotation results in the target matrix, return false
        return false;
    }

    /*
     * Rotate the matrix 90 degrees clockwise:
     * 1. Reverse the rows (up to down)
     * 2. Swap the symmetry (transpose the matrix)
     * Example:
     *  1  2  3  4       13 14 15 16       13  9  5  1
     *  5  6  7  8   =>  9 10 11 12   =>  14 10  6  2
     *  9 10 11 12       5  6  7  8       15 11  7  3
     * 13 14 15 16       1  2  3  4       16 12  8  4
     */
    private void rotate(int[][] matrix) {
        // Step 1: Reverse the rows
        int s = 0;
        int e = matrix.length - 1;
        while (s < e) {
            int[] tmp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = tmp;
            s++;
            e--;
        }

        // Step 2: Transpose the matrix (swap symmetry)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    // Helper method to check if two matrices are equal
    private boolean isEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
}
