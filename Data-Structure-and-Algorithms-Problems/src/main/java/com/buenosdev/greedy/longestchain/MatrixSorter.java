package com.buenosdev.greedy.longestchain;

import java.util.Arrays;
import java.util.Comparator;

public class MatrixSorter {

    // (Greedy Algorithm) Problem 2: Maximum Length of Pair Chain

    /*
    https://leetcode.com/problems/maximum-length-of-pair-chain/description/
     **/

    /*
     * */

    public int findLongestChain(int[][] pairs) {
        // Print the sorted matrix
        int[][] sortedMatrix = sortMatrix(pairs);
        int previus = -1;
        int result = 0;


        for (int i = 1; i < sortedMatrix.length; i++) {
            if (sortedMatrix[i][0] > previus) {
                previus = sortedMatrix[i][1];
                result = result + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{4,8},{3,5},{8,9},{8,10},{8,9},{-5,9},{8,10}};
        int[][] sortedMatrix = sortMatrix(matrix);

        // Print the sorted matrix
        for (int[] row : sortedMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] sortMatrix(int[][] matrix) {
        Arrays.sort(matrix, Comparator.comparingInt(a -> a[1]));
        return matrix;
    }
}