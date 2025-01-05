package com.buenosdev.slidingwindow.lengthOfLongestSubstringKDistinct;

/*
 * https://aaronice.gitbook.io/lintcode/two_pointers/longest_substring_with_at_most_k_distinct_characters
 *
 * */

import java.util.HashMap;
import java.util.Map;

public class ProblemSolution {
    /**
     * @param s : A string
     * @return : The length of the longest substring
     * that contains at most k distinct characters.
     */
//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    public int findLength(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        var map = new HashMap<Character, Integer>();

        var sArray = s.toCharArray();

        var result = Integer.MIN_VALUE;

        var windowStart = 0;

        for (int windowEnd = 0; windowEnd < sArray.length; windowEnd++) {
            map.put(sArray[windowEnd], map.getOrDefault(sArray[windowEnd], 0) + 1);

            while (map.size() > k) {
                char charToRemove = sArray[windowStart];
                map.put(charToRemove, map.get(charToRemove) - 1);

                if (map.get(charToRemove) == 0) {
                    map.remove(charToRemove);
                }
                windowStart++; // shrink the window

            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }

        return result;
    }

    public int findLengthTwo(String str, int k) {

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in
            // the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            // remember the maximum length so far
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}