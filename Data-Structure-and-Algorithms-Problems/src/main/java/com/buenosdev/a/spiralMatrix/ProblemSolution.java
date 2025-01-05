package com.buenosdev.a.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

class ProblemSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        var result = new ArrayList<Integer>();

        // Define the boundaries of the matrix
        var top = 0;
        var bottom = matrix.length - 1;
        var left = 0;
        var right = matrix[0].length - 1;

        // Continue the process until all elements are traversed
        while (true) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary down
            if (checkIfBoundariesWereCrossed(top, bottom, left, right)) break;

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary left
            if (checkIfBoundariesWereCrossed(top, bottom, left, right)) break;

            // Traverse from right to left along the bottom boundary
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--; // Move the bottom boundary up
            if (checkIfBoundariesWereCrossed(top, bottom, left, right)) break;

            // Traverse from bottom to top along the left boundary
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++; // Move the left boundary right
            if (checkIfBoundariesWereCrossed(top, bottom, left, right)) break;
        }

        return result;
    }

    private static boolean checkIfBoundariesWereCrossed(int top, int bottom, int left, int right) {
        return top > bottom || left > right;
    }

}