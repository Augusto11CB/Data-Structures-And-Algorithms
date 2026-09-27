package com.buenosdev.hash.validanagram;

import java.util.HashMap;

/**
 * Valid Anagram — review dated 2026-09-27.
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class Review2026_09_27 {

    // Implement the solution during this review.
    public boolean isAnagram(String s, String t) {
        // sort and compare
        if (s.length() != t.length())
            return false;

        var map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            var curChar = (Character.valueOf(s.charAt(i)));

            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            var curChar = Character.valueOf(t.charAt(i));

            if (!map.containsKey(curChar)) return false;
            var newVal = map.get(curChar) - 1;

            if (newVal <= 0) map.remove(curChar);
            else map.put(curChar, newVal);
        }

        return map.isEmpty();
    }
}
