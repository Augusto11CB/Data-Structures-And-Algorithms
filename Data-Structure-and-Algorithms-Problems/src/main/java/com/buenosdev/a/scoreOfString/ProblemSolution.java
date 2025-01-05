package com.buenosdev.a.scoreOfString;

class ProblemSolution {
    public int scoreOfString(String s) {
        var sArray = s.toCharArray();

        var windowStart = 0;
        var diff = 0;
        for(int windowEnd = 1; windowEnd < sArray.length; windowEnd++){
            diff += Math.abs(sArray[windowEnd] - sArray[windowStart]);
            windowStart += 1;
        }
        return diff;
    }
}