package com.buenosdev.a.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

class ProblemSolution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        var set = new HashSet<Character>();
        var sArray = s.toCharArray();

        var windowStart = 0;
        var maxLengthFound = Integer.MIN_VALUE;

        var auxLength = maxLengthFound;
        for (int windowEnd = 0; windowEnd < sArray.length; windowEnd++) {
            if (!set.contains(sArray[windowEnd])) {
                set.add(sArray[windowEnd]);
                auxLength = (windowEnd - windowStart) + 1;
            } else {
                maxLengthFound = Math.max(maxLengthFound, auxLength);

                while (windowStart < windowEnd && set.contains(sArray[windowEnd])) {
                    set.remove(sArray[windowStart]);
                    windowStart += 1;
                }
                set.add(sArray[windowEnd]);
                auxLength = windowEnd - windowStart + 1;
            }

        }

        maxLengthFound = Math.max(maxLengthFound, auxLength);

        return maxLengthFound;

    }

    public static void main(String[] args) {
        var ps = new ProblemSolution();
        ps.lengthOfLongestSubstring("bbbbb");
    }
}