package com.buenosdev.a.luckyNumbersInAMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProblemSolution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        var minElements = new ArrayList<List<Integer>>();

        for (int i = 0; i < matrix.length; i++) {
            var min = Integer.MAX_VALUE;
            var minJ = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    minJ = j;
                    min = matrix[i][j];
                }
            }
            minElements.add(new ArrayList<>(Arrays.asList(i, minJ)));

        }

        var result = new ArrayList<Integer>();
        for (List<Integer> l : minElements) {
            var i = l.get(0);
            var j = l.get(1);
            var maxC = matrix[i][j];

            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][j] > maxC) {
                    maxC = matrix[k][j];
                    break;
                }
            }

            if (maxC == matrix[i][j]) result.add(matrix[i][j]);
        }

        return result;
    }
}