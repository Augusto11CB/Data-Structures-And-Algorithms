package com.buenosdev.a.setMatrixZeroes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ProblemSolution {

    public void setZeroes(int[][] matrix) {
        var setX = new HashSet<Integer>();
        var setY = new HashSet<Integer>();

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if (matrix[x][y] == 0) {
                    setX.add(x);
                    setY.add(y);
                }
            }
        }

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                if (setX.contains(x) || setY.contains(y)) {
                    matrix[x][y] = 0;
                }
            }
        }
    }


    public void setZeroesFAILED(int[][] matrix) {
        var set = new HashSet<int[]>();

        for (int x = 0; x < matrix.length; x++) {

            for (int y = 0; y < matrix[x].length; y++) {

                if (matrix[x][y] == 0 && !set.contains(new int[]{x, y})) {
                    adjacentWithZerosFAILED(matrix, x, y, set);
                }
            }
        }
    }

    public void adjacentWithZerosFAILED(int[][] matrix, int x, int y, HashSet<int[]> zeroes) {
        var upX = x - 1;
        while (upX >= 0) {
            var pair = new int[]{upX, y};
            if (matrix[upX][y] != 0 && !zeroes.contains(pair)) {
                matrix[upX][y] = 0;
                zeroes.add(pair);
            }
            upX = upX - 1;
        }

        var bottomX = x + 1;
        while (bottomX <= matrix.length - 1) {
            var pair = new int[]{bottomX, y};
            if (matrix[bottomX][y] != 0 && !zeroes.contains(pair)) {
                matrix[bottomX][y] = 0;
                zeroes.add(pair);
            }
            bottomX = bottomX + 1;
        }

        var rightY = y + 1;
        while (rightY <= matrix[0].length - 1) {
            var pair = new int[]{x, rightY};
            if (matrix[x][rightY] != 0 && !zeroes.contains(pair)) {
                matrix[x][rightY] = 0;
                zeroes.add(pair);
            }
            rightY = rightY + 1;
        }

        var leftY = y - 1;
        while (leftY >= 0) {
            var pair = new int[]{x, leftY};
            if (matrix[x][leftY] != 0 && !zeroes.contains(pair)) {
                matrix[x][leftY] = 0;
                zeroes.add(pair);
            }
            leftY = leftY - 1;
        }
    }

    public void setZeroesSet(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroCol = new HashSet<>();

        // get all zero from matrix, set the index into a hashset to void duplicate
        for (int m = 0; m < rowNum; m++) {
            for (int n = 0; n < colNum; n++) {
                if (matrix[m][n] == 0) {
                    zeroRow.add(m);
                    zeroCol.add(n);
                }
            }
        }

        // as the index of zero to set the entire row and column of matrix to 0
        for (Integer i : zeroRow) {
            for (int n = 0; n < colNum; n++) {
                matrix[i][n] = 0;
            }
        }
        for (int m = 0; m < rowNum; m++) {
            for (Integer i : zeroCol) {
                matrix[m][i] = 0;
            }
        }
    }

    public void setZeroesArray(int[][] matrix) {
        // Initialize row and col arrays with the same length as the number of rows and columns in the matrix, respectively.
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        // Fill the row and col arrays with 1s. This means initially we assume no row or column needs to be zeroed.
        Arrays.fill(row, 1);
        Arrays.fill(col, 1);

        // First pass: Identify the rows and columns that need to be zeroed
        // Iterate through each element in the matrix
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                // If an element is zero, mark the corresponding row and column in the row and col arrays
                if (matrix[i][j] == 0) {
                    row[i] = 0; // Mark the entire row to be zeroed
                    col[j] = 0; // Mark the entire column to be zeroed
                }
            }
        }

        // Second pass: Set the elements to zero as required
        // Iterate through each element in the matrix again
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                // Set the matrix element to zero if its row or column is marked zero
                // This uses the row and col arrays to determine if the current element should be zero
                matrix[i][j] = matrix[i][j] * row[i] * col[j];
            }
        }
    }
}