package com.buenosdev.hash.largestuniquenumber;

import java.util.HashMap;

public class ProblemSolution {

    // (Hash) Problem 2: Largest Unique Number

    /*
    Given an array of integers, identify the highest value that appears only once in the array. If no such number exists, return -1.
    **/

    /*
    Example 1:

    Input: [5, 7, 3, 7, 5, 8]
    Expected Output: 8
    Justification: The number 8 is the highest value that appears only once in the array.
    * */

    public int largestUniqueNumber(int[] A) {
        if (A == null || A.length == 0)
            return -1;
        if (A.length == 1)
            return A[0];

        var freq = new HashMap<Integer, Integer>();
        for (int c : A) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int maxUnique = -1;

        for (int i = 0; i < A.length; i++) {
            if (freq.get(A[i]) == 1 && A[i] > maxUnique) {
                maxUnique = A[i];
            }
        }
        return maxUnique;
    }


       /*
        Time Complexity: O(2n)
        - Populating the hashmap with frequencies O(n).
        - Finding the first largest number O(n).

        Space Complexity: O(n)

        */


    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.largestUniqueNumber(new int[]{5, 7, 3, 7, 5, 8}));  // Expected: 8
        System.out.println(sol.largestUniqueNumber(new int[]{1, 2, 3, 2, 1, 4, 4}));  // Expected: 3
        System.out.println(sol.largestUniqueNumber(new int[]{9, 9, 8, 8, 7, 7}));   // Expected: -1
    }
}