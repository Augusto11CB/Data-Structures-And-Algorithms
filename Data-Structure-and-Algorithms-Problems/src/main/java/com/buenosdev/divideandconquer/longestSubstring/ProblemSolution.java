package com.buenosdev.divideandconquer.longestSubstring;

class ProblemSolution {

    /*
     * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
     * */

    public int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, k, 0, s.length());
    }

    private int longestSubstringUtil(String s, int k, int start, int end) {
        if (end - start < k)
            return 0;

        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int left = longestSubstringUtil(s, k, start, i);
                int right = longestSubstringUtil(s, k, i + 1, end);
                return Math.max(left, right);
            }
        }

        return end - start;
    }
}