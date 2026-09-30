package com.buenosdev.arraymatrix.findfirstpalindromicstringinthearray;

// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
// Find First Palindromic String in the Array — review date: 2026-09-30
public class Review2026_09_30 {
    public String firstPalindrome(String[] words) {

        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) return words[i];
        }
        return "";
    }

    public boolean isPalindrome(String s) {
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
