package com.buenosdev.greedy.palindrometwo;

public class ProblemSolution {
    // (Greedy Algorithm) Problem 1: Valid Palindrome II

    /*
    https://leetcode.com/problems/valid-palindrome-ii/description/
     **/

    /*
     * */
    public static boolean isPalindromePossible(String str) {
        var auxStr = str;
        var reverseAux = new StringBuilder(auxStr).reverse().toString();
        if (auxStr.equals(reverseAux)) return true;


        for (int i = 0; i < str.length(); i++) {
            auxStr = str.replace(String.valueOf(str.charAt(i)), "");

            reverseAux = new StringBuilder(auxStr).reverse().toString();
            if (auxStr.equals(reverseAux))
                return true;
        }

        return false;
    }
}