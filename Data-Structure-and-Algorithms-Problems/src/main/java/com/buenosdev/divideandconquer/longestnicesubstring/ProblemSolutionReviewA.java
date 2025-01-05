package com.buenosdev.divideandconquer.longestnicesubstring;

import java.util.HashSet;
import java.util.Set;

public class ProblemSolutionReviewA {

    /*
     * https://leetcode.com/problems/longest-nice-substring/
     * */

    public String longestNiceSubstring(String s) {
        return getLongestNiceSubstring(s);
    }

    private static String getLongestNiceSubstring(String str) {
        if (str.length() <= 1) return "";

        var hashOfChars = new HashSet<Character>();
        for (Character c : str.toCharArray()) {
            hashOfChars.add(c);
        }

        for (int i = 0; i < str.length(); i++) {
            var upperC = Character.toUpperCase(str.charAt(i));
            var lowerC = Character.toLowerCase(str.charAt(i));

            if (!hashOfChars.contains(upperC) || !hashOfChars.contains(lowerC)) {
                var leftSub = getLongestNiceSubstring(str.substring(0, i));
                var rightSub = getLongestNiceSubstring(str.substring(1 + i, str.length()));
                return leftSub.length() >= rightSub.length() ? leftSub : rightSub;
            }

        }
        return str;
    }

    public static void main(String[] args) {
        var sol = new ProblemSolutionReviewA();
        // Testing the algorithm with example inputs
        //System.out.println(sol.longestNiceSubstring("BbCcXxY"));  // Expected: BbCcXx
        System.out.println(sol.longestNiceSubstring("abABB"));   // Expected: (empty string)
        System.out.println(sol.longestNiceSubstring("acAbB"));   // Expected: (empty string)
        System.out.println(sol.longestNiceSubstring("YazaAay"));   // Expected: (empty string)
        // System.out.println(sol.longestNiceSubstring("dDzeE")); // Expected: qQwWeErR
        // System.out.println(sol.longestNiceSubstring("deEDbcB")); // Expected: qQwWeErR
        // System.out.println(sol.longestNiceSubstring("xLeElzxgHzcWslEdgMGwEOZCXwwDMwcEhgJHLL")); // Expected: qQwWeErR
    }
}
