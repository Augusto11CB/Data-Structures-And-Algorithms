package com.buenosdev.greedy.longestchain;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemSolutionReviewB {

    /*
    https://leetcode.com/problems/maximum-length-of-pair-chain/description/
    **/

    /*
     * It is a kind of interval problem.
     * */

    public static void main(String[] args) {
        var ps = new ProblemSolutionReviewB();
        int[][] matrix = {{4, 8}, {3, 5}, {8, 9}, {8, 10}, {8, 9}, {-5, 9}, {8, 10}};
        int[][] matrix2 = {{1, 2}, {2, 3}, {3, 4}};
        int[][] matrix3 = {{1, 2}, {7, 8}, {4, 5}};

        System.out.println(ps.findLongestChain(matrix));
        System.out.println(ps.findLongestChain(matrix2));
        System.out.println(ps.findLongestChain(matrix3));
    }

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, Comparator.comparingInt(value -> value[1]));

        var lastedAddedToChain = Integer.MIN_VALUE;
        var lengthlongestchain = 0;
        for (int[] i : pairs) {
            if (lastedAddedToChain < i[0]) {
                lastedAddedToChain = i[1];
                lengthlongestchain = lengthlongestchain + 1;
            }
        }

        return lengthlongestchain;

    }

    // O(nlogn) due to sorting the pairs.
}
