package com.buenosdev.hash.ransomnote;

import java.util.HashMap;
import java.util.Map;

public class ProblemSolution {

    // (Hash) Problem 5: Ransom Note

    /*
    https://leetcode.com/problems/ransom-note/description/
    **/

    /*
     * */


    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        var freq = new HashMap<Character, Integer>();

        for (Character c : magazine.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (Character c : ransomNote.toCharArray()) {
            var value = freq.get(c);
            if (value == null || value <= 0) {
                return false;
            } else {
                value = value - 1;
                freq.put(c, value);
            }
        }
        return true;
    }

       /*
        Time Complexity: O(n + m)
        - where n is the length of the ransom note and m is the length of the magazine.

        Space Complexity: O(1)
        - However, since the alphabet has a fixed number of characters, the space complexity is O(1)

        */

    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.canConstruct("hello", "hellworld"));  // Expected: true
        System.out.println(sol.canConstruct("notes", "stoned"));     // Expected: true
        System.out.println(sol.canConstruct("apple", "pale"));       // Expected: false
    }
}