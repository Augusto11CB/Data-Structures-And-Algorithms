package com.buenosdev.arraymatrix.validpalindrome;

/*
* https://leetcode.com/problems/valid-palindrome/description/
* */

// Valid Palindrome — review date: 2026-09-29
public class Review2026_09_29 {

    // "race a car"
    public boolean isPalindrome(String s) {

        var input = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        var right = input.length() - 1;
        var left = 0;

        while (left < input.length()) {

            if (input.charAt(left) != input.charAt(right)) return false;

            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeV2(String s) {
        var right = s.length() - 1;
        var left = 0;

        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) left++;
            while (!Character.isLetterOrDigit(s.charAt(right)) && right > left) right--;


            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;
        }
        return true;
    }
}
