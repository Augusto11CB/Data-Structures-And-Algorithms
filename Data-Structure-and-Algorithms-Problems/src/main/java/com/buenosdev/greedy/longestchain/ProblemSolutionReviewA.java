package com.buenosdev.greedy.longestchain;

import com.buenosdev.greedy.maxsubarray.ProblemSolution;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemSolutionReviewA {

    /*
    https://leetcode.com/problems/maximum-length-of-pair-chain/description/
    **/

    /*
    * It is a kind of interval problem.
    * */

    public static void main(String[] args) {
        var ps = new ProblemSolutionReviewA();
        int[][] matrix = {{4, 8}, {3, 5}, {8, 9}, {8, 10}, {8, 9}, {-5, 9}, {8, 10}};
        System.out.println(ps.findLongestChain(matrix));
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[1]));

        // pair [i,j]
        var lastJInTheChain =  Integer.MIN_VALUE;
        var resultCount = 0;

        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > lastJInTheChain) {
                lastJInTheChain = pairs[i][1];
                resultCount++;
            }
        }
        return resultCount;
    }


}
