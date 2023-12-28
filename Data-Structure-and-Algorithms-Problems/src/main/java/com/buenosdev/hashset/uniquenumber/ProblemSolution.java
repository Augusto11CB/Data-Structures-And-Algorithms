package com.buenosdev.hashset.uniquenumber;

import java.util.HashMap;
import java.util.HashSet;

public class ProblemSolution {

    // (HashSet) Problem 3: Unique Number of Occurrences

    /*
    https://leetcode.com/problems/unique-number-of-occurrences/
    **/

    /*
     * */

    public boolean uniqueOccurrences(int[] arr) {
        var occurrencesMapper = new HashMap<Integer, Integer>();

        for (int i : arr) {
            occurrencesMapper.put(i, occurrencesMapper.getOrDefault(i, 0) + 1);
        }

        var uniqueValues = new HashSet<Integer>();

        for (int value : occurrencesMapper.values()) {
            if (uniqueValues.contains(value)) {
                return false; // Duplicate value found
            }
            uniqueValues.add(value);
        }

        return true; // All values are unique

    }

       /*
        Time Complexity: O(n + m)
        - where n is the length of the arr and m is the length of the occurrencesMapper.

        Space Complexity: O(n)

        */


    public boolean uniqueOccurrencesV2(int[] arr) {
        var occurrencesMapper = new HashMap<Integer, Integer>();

        for (int i : arr) occurrencesMapper.merge(i, 1, Integer::sum);

        var uniqueValues = new HashSet<>(occurrencesMapper.values());

        return uniqueValues.size() == occurrencesMapper.size();
    }

    /*
     Time Complexity: O(n + m)
     - where n is the length of the arr and m is the length of the occurrencesMapper.

     Space Complexity: O(n)

     */

    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.uniqueOccurrences(new int[]{4, 5, 4, 6, 6, 6}));
        System.out.println(sol.uniqueOccurrences(new int[]{7, 8, 8, 9, 9, 9, 10, 10}));
        System.out.println(sol.uniqueOccurrences(new int[]{11, 12, 13, 14, 14, 15, 15, 15}));
    }
}