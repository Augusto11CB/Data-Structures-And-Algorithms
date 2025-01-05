package com.buenosdev.a.getEqualSubstringsWithinBudget;

public class ProblemSolution {

    // Input: s = "abcd", t = "bcdf", maxCost = 3
    // Output: 3
    // Explanation: "abc" of s can change to "bcd".
    // That costs 3, so the maximum length is 3.

    public int equalSubstring(String s, String t, int maxCost) {
        var curCost = maxCost;

        var maxLength = 0;
        var startWin = 0;
        var length = s.length();

        for (int endWin = 0; endWin < length; endWin++) {
            curCost -= Math.abs(t.charAt(endWin) - s.charAt(endWin));

            // If our curCost is less than zero, it means that there are more chars to change than we are allowed to change. 
            // Now we will "advance" our window (by increasing the size of startWin) so that by discarding the change we made in s.charAt(startWin),
            // we can check whether we can get an even greater length size by considering the current position onwards.
            while (curCost < 0) {
                curCost += Math.abs(t.charAt(startWin) - s.charAt(startWin));
                startWin++;
            }

            maxLength = Math.max(maxLength, (endWin - startWin) + 1);

        }

        return maxLength;
    }

    public int equalSubstringFAILEDII(String s, String t, int maxCost) {
        var startWin = 0;
        var maxLength = Integer.MIN_VALUE;

        var sCharArray = s.toCharArray();
        var tCharArray = t.toCharArray();

        var curCost = maxCost;
        var localMax = Integer.MIN_VALUE;
        for (int endWin = 0; endWin < sCharArray.length; endWin++) {
            var sCharIntValue = (int) sCharArray[endWin];
            var tCharIntValue = (int) tCharArray[endWin];
            var auxCurCost = curCost - Math.abs(sCharIntValue - tCharIntValue);
            if (auxCurCost < 0) {
                var a = auxCurCost + (int) sCharArray[startWin];

                if (a >= 0 && localMax + 1 > maxLength) {
                    startWin += 1;
                    maxLength = localMax + 1;
                    localMax += 1;
                    auxCurCost = a;
                }

            } else {

            }

        }
        return 0;
    }

    public int equalSubstringFAILED(String s, String t, int maxCost) {
        var length = s.length();

        var sCharArray = s.toCharArray();
        var tCharArray = t.toCharArray();

        var curCost = maxCost;
        var charChanged = 0;
        for (int i = 0; i < length; i++) {

            var sChar = (int) sCharArray[i];
            var tChar = (int) tCharArray[i];

            if (sChar != tChar) {

                var auxCurCost = curCost - Math.abs(sChar - tChar);
                if (auxCurCost >= 0) {
                    charChanged += 1;
                    curCost = auxCurCost;
                }

            } else {
                charChanged += 1;
            }

        }
        return charChanged;

    }

}
