package com.buenosdev.greedy.onesandzeros;

import java.util.Arrays;
import java.util.Comparator;

class ProblemSolution {

    // (Greedy Algorithm) Problem B: Ones and Zeroes

    /*
    https://leetcode.com/problems/ones-and-zeroes/description/
     **/

    /*
     * */
    int result = 0;
    int onesSelected = 0;
    int zerosSelected = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        // m = number of O's
        // n = number of 1's

        Arrays.sort(strs, Comparator.comparingInt(String::length));

        for (int i = 0; i < strs.length; i++) {
            var element = strs[i];
            var localNumberOfOnes = (int) element.chars().filter(ch -> ch == '1').count();
            var localNumberOfZeros = (int) element.chars().filter(ch -> ch == '0').count();

            if ((onesSelected + localNumberOfOnes) <= m && (zerosSelected + localNumberOfZeros) <= n) {
                select(localNumberOfOnes, localNumberOfZeros);
            }
            if ((onesSelected + localNumberOfOnes) <= m && (zerosSelected + localNumberOfZeros) == 0) {
                select(localNumberOfOnes, 0);
            }
            if ((onesSelected + localNumberOfOnes) == 0 && (zerosSelected + localNumberOfZeros) <= n) {
                select(0, localNumberOfZeros);
            }
        }
        return result;
    }

    private void select(int localNumberOfOnes, int localNumberOfZeros) {
        onesSelected = onesSelected + localNumberOfOnes;
        zerosSelected = zerosSelected + localNumberOfZeros;
        result = result + 1;
    }

    public static void main(String[] args) {

    }
}