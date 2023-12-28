package com.buenosdev.hash.longestpalindrome;

import java.util.HashMap;
import java.util.Map;

public class ProblemSolution {

    // (Hash) Problem 4: Longest Palindrome

    /*
    https://leetcode.com/problems/longest-palindrome/description/
    **/

    /*
     * */


    // (1) Each letter must occur an even number of times, like "abba" or "baab".
    // (2) If a letter occurs an odd number of times, like "cccdd", we form "cddc" or "dccd" - only one letter 'c' is not taken into account.
    // (3) If there is only one letter that occurs an odd number of times, "aaa".
    // (4) and this cenerio, where a letter that occurs an odd number of times can be the middle of the palindrome "zabab" -> "abzba" or "bazab".
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return 0;

        var freq = new HashMap<Character, Integer>();
        var textArray = s.toCharArray();

        for (Character c : textArray) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        var numberOfCharacters = 0;
        var oddFound = false;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            // This 'if' guarantees that we cover the case (2).
            if (entry.getValue() % 2 != 0) {
                numberOfCharacters = entry.getValue() - 1 + numberOfCharacters;
                oddFound = true;
                continue;
            }
            numberOfCharacters = entry.getValue() + numberOfCharacters;
        }

        // (oddFound == true)  numberOfCharacters + 1 will guarantees that we cover the cases (3) and (4)
        return (oddFound) ? numberOfCharacters + 1 : numberOfCharacters;
    }

       /*
        Time Complexity: O(2n)
        - Populating the hashmap with frequencies O(n).
        - Finding the first largest number O(n).

        Space Complexity: O(n)

        */

    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.longestPalindrome("bananas"));  // Expected output: 5
        System.out.println(sol.longestPalindrome("applepie")); // Expected output: 5
        System.out.println(sol.longestPalindrome("racecar"));  // Expected output: 7
    }
}