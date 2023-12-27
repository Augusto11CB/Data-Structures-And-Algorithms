package com.buenosdev.hash.maximumnumberofballons;

import java.util.HashMap;

public class ProblemSolution {

    // (Hash) Problem 3: Maximum Number of Balloons

    /*
    https://leetcode.com/problems/maximum-number-of-balloons/description/
    **/

    /*
     * */

    public int maxNumberOfBalloonsV1(String text) {
        if (text == null || text.isEmpty() || text.length() < 7)
            return 0;
        var freq = new HashMap<Character, Integer>();
        var textArray = text.toCharArray();

        for (Character c : textArray) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Balloons
        // b = 1
        var bFreq = freq.get('b');
        if (bFreq == null || bFreq < 1) return 0;
        var aFreq = freq.get('a');
        if (aFreq == null || aFreq < 1) return 0;
        var lFreq = freq.get('l'); //
        if (lFreq == null || Math.floorDiv(lFreq, 2) < 1) return 0;
        var oFreq = freq.get('o'); //
        if (oFreq == null || Math.floorDiv(oFreq, 2) < 1) return 0;
        var nFreq = freq.get('n');
        if (nFreq == null || nFreq < 1) return 0;


        int[] numbers = new int[]{
                bFreq,
                aFreq,
                Math.floorDiv(lFreq, 2),
                Math.floorDiv(oFreq, 2),
                nFreq
        };

        int minimum = Integer.MAX_VALUE; // Initialize minimum with a large value

        for (int num : numbers) {
            if (num < minimum) {
                minimum = num; // Update the minimum value
            }
        }

        if (minimum != Integer.MAX_VALUE) return minimum;

        return 0;

    }

    public int maxNumberOfBalloons(String text) {
        if (text == null || text.isEmpty() || text.length() < 7)
            return 0;
        var freq = new HashMap<Character, Integer>();
        var textArray = text.toCharArray();

        for (Character c : textArray) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int minCount = Integer.MAX_VALUE;
        // Calculate the maximum number of times "balloon" can be formed
        minCount = Math.min(minCount, freq.getOrDefault('b', 0));
        minCount = Math.min(minCount, freq.getOrDefault('a', 0));
        minCount = Math.min(minCount, freq.getOrDefault('l', 0) / 2);
        minCount = Math.min(minCount, freq.getOrDefault('o', 0) / 2);
        minCount = Math.min(minCount, freq.getOrDefault('n', 0));

        return minCount;

    }


       /*
        Time Complexity: O(2n)
        - Populating the hashmap with frequencies O(n).
        - Finding the first largest number O(n).

        Space Complexity: O(n)

        */



    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.maxNumberOfBalloons("nlaebolko"));  // Expected: 1
        System.out.println(sol.maxNumberOfBalloons("bbaall"));          // Expected: 0
        System.out.println(sol.maxNumberOfBalloons("balloonballoooon"));// Expected: 2

    }
}