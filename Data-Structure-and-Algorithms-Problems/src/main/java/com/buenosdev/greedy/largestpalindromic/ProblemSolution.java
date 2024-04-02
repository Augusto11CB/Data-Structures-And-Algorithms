package com.buenosdev.greedy.largestpalindromic;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ProblemSolution {

    // (Greedy Algorithm) Problem 5: Largest Palindromic Number

    /*
    https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
     **/

    /*
     * */
    public String largestPalindromic(String num) {
        var numberFrequency = new TreeMap<Character, Integer>(Collections.reverseOrder());
        var numsArray = num.toCharArray();

        for (Character c : numsArray) {
            numberFrequency.put(c, numberFrequency.getOrDefault(c, 0) + 1);
        }

        for (Character key : numberFrequency.keySet()) {
            System.out.println("Key: " + key + ", Value: " + numberFrequency.get(key));
        }

        var sbLest = new StringBuilder();
        var sbRight = new StringBuilder();
        Character middleCharacterSelected = null;

        for (Map.Entry<Character, Integer> entry : numberFrequency.entrySet()) {
            if (entry.getValue() > 1) {
                var auxValue = entry.getValue();
                while (auxValue > 1) {
                    sbLest.append(entry.getKey());
                    sbRight.append(entry.getKey());
                    auxValue = auxValue - 2;
                }

                if (auxValue > 0 && middleCharacterSelected == null) {
                    middleCharacterSelected = entry.getKey();
                }
            } else if (middleCharacterSelected == null) {
                middleCharacterSelected = entry.getKey();
            }
        }

        // Handle special cases
        if (sbLest.toString().equals("") || sbLest.charAt(0) == '0') {
            return middleCharacterSelected != null ? "0" : String.valueOf(middleCharacterSelected);  // Return the middle digit or "0"
        } else if (sbLest.toString().matches("^0+$")) {
            return "0";  // Case for multiple zeros
        }


        return sbLest.toString() + (middleCharacterSelected != null ? middleCharacterSelected : "") + sbRight.reverse();
    }

    public static void main(String[] args) {
        var sol = new ProblemSolution();

        var result = sol.largestPalindromic("6006");

        System.out.println("LargestPalindromic: " + result);
    }
}
