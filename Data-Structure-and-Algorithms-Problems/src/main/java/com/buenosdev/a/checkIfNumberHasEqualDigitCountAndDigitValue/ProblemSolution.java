package com.buenosdev.a.checkIfNumberHasEqualDigitCountAndDigitValue;

import java.util.HashMap;

class ProblemSolution {
    public boolean digitCount(String num) {
        var map = new HashMap<Integer, Integer>();

        var numArray = num.toCharArray();

        for (int i = 0; i < numArray.length; i++) {
            var numA = numArray[i] - '0';
            map.put(numA, map.getOrDefault(numA, 0) + 1);
        }

        for (int i = 0; i < numArray.length; i++) {
            if (map.getOrDefault(i, 0) != numArray[i] - '0')
                return false;
        }

        return true;

    }
}