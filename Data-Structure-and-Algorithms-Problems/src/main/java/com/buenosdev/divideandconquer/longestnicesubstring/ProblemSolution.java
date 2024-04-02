package com.buenosdev.divideandconquer.longestnicesubstring;

import java.util.HashSet;
import java.util.Set;

public class ProblemSolution {

    /*
     * https://leetcode.com/problems/longest-nice-substring/
     * */

    public String longestNiceSubstring(String s) {
        return getLongestNiceSubstring(s);
    }

    private static String getLongestNiceSubstring(String str) {
        if (str.length() <= 1) {
            return "";
        }

        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            charSet.add(c);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char upper = Character.toUpperCase(ch);
            char lower = Character.toLowerCase(ch);

            if (!charSet.contains(upper) || !charSet.contains(lower)) {
                // Ignore character in the i position since it does not have any upper || lower case
                //      when doing str.substring(0, i) --> i is not included
                //      when doing str.substring(i + 1) --> i is not included
                String left = getLongestNiceSubstring(str.substring(0, i));
                String right = getLongestNiceSubstring(str.substring(i + 1));

                if (left.length() == right.length()) {
                    return left;
                } else {
                    return left.length() > right.length() ? left : right;
                }
            }
        }

        return str;
    }

    public static void main(String[] args) {
        var sol = new ProblemSolution();
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
