package com.buenosdev.dynamicProgramming.palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

class ProblemSolution {

    public List<List<String>> partition(String s) {

        var result = new ArrayList<List<String>>();
        if (s == null || s.isBlank()) {
            result.add(new ArrayList<>());
            return result;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i)) {
                var list = partition(s.substring(i + 1));
                for (List<String> l : list) {
                    l.add(0, s.substring(0, i + 1));
                    result.add(l);
                }
            }
        }
        return result;

    }

    public static boolean isPalindrome(String str, int end) {
        if (str == null) {
            return false;
        }
        int left = 0;
        int right = end;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}