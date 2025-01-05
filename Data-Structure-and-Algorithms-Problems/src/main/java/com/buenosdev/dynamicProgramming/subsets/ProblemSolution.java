package com.buenosdev.dynamicProgramming.subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            var semiResult = new ArrayList<List<Integer>>();
            for (List<Integer> l : result) {
                var newArray = new ArrayList<Integer>(l);
                newArray.add(nums[i]);
                semiResult.add(newArray);
            }

            result.addAll(semiResult);

        }

        return result;
    }

    private static void subsets(int[] nums, Set<List<Integer>> hashset) {
        for (int i = 0; i < nums.length; i++) {
            var auxHash = new TreeSet<List<Integer>>();
            var curNum = nums[i];
            for (List<Integer> l : hashset) {
                if (l.contains(curNum)) continue;
                var list = new ArrayList<Integer>(l);
                list.add(curNum);
                auxHash.add(list);
            }
            hashset.addAll(auxHash);

        }
    }
}