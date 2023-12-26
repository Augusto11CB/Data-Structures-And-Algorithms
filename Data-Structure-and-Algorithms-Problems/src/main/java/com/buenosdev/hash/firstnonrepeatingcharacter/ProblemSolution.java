package com.buenosdev.hash.firstnonrepeatingcharacter;

import java.util.HashMap;

public class ProblemSolution {

    // (Hash) Problem 1: First Non-repeating Character

    /*
    https://leetcode.com/problems/first-unique-character-in-a-string/
    **/

    /*
     * */

    public int firstUniqChar(String s) {
        var myHash = new HashMap<Character, Integer>();
        var arrayFromStringS = s.toCharArray();

//        for (Character c : arrayFromStringS) {
//            Integer value = myHash.get(c);
//            if (value != null) {
//                value = value + 1;
//            } else {
//                value = 1;
//            }
//            myHash.put(c, value);
//        }


        // Traverse the string to populate the hashmap with character frequencies
        for (char c : arrayFromStringS) {
            myHash.put(c, myHash.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < arrayFromStringS.length; i++) {
            if (myHash.get(arrayFromStringS[i]) == 1) return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.firstUniqChar("apple"));  // Expected: 0
        System.out.println(sol.firstUniqChar("abcab"));  // Expected: 2
        System.out.println(sol.firstUniqChar("abab"));   // Expected: -1
        System.out.println(sol.firstUniqChar("loveleetcode"));   // Expected: -1
    }
}