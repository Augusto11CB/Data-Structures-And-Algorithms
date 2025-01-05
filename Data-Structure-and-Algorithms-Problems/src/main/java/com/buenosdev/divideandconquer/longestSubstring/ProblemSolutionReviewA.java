package com.buenosdev.divideandconquer.longestSubstring;

import java.util.HashMap;

public class ProblemSolutionReviewA {
    public int longestSubstring(String s, int k) {
        var hashMap = new HashMap<Character, Integer>();
        var charArray = s.toCharArray();
        for (char c : charArray) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            var myChar = s.charAt(i);
            if (hashMap.get(myChar) >= k) continue;
            if (!hashMap.containsKey(myChar) || hashMap.get(myChar) < k) {
                var left = longestSubstring(s.substring(0, i), k);
                var right = longestSubstring(s.substring(i + 1), k);
                return Math.max(left, right);
            }
        }

        return s.length();
    }
}

