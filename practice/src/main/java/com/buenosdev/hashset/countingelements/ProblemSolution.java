package com.buenosdev.hashset.countingelements;

import java.util.Arrays;
import java.util.HashSet;

public class ProblemSolution {

    // (HashSet) Problem 1:  Counting Elements

    /*
    https://leetcode.com/problems/first-unique-character-in-a-string/
    **/

    /*
     * */
    public int countElements(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;

        var count = 0;
        var hashset = new HashSet<Integer>();
        var arrLength = arr.length;

        Arrays.sort(arr);

        hashset.add(arr[arrLength - 1]);

        for (int i = arrLength - 2; i >= 0; i--) {

            if (hashset.contains(arr[i] + 1)) {
                count++;
            }
            hashset.add(arr[i]);
        }

        return count;
    }

       /*
        Time Complexity: O(n) + O(n logn)

        Space Complexity: O(n)

        */

    public int countElementsV2(int[] arr) {
        // Create a set to store unique numbers from the array
        HashSet<Integer> set = new HashSet<>();

        // Populate the set with numbers from the array
        for (int num : arr) {
            set.add(num);
        }

        int count = 0;
        // For each number in the array, check if its next consecutive number exists in the set
        for (int num : arr) {
            if (set.contains(num + 1)) {
                count++;
            }
        }

        return count;
    }

       /*
        Time Complexity: O(2n)
        - one 'n' once to populate the hashset and another 'n' to count the valid numbers.

        Space Complexity: O(n)
        - The space complexity is determined by the hashset, which in the worst case will have an entry for each unique number in the array.

        */

    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();

    }
}