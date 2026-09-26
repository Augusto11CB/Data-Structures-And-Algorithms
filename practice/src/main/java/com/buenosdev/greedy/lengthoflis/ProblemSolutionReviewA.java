package com.buenosdev.greedy.lengthoflis;

import java.util.ArrayList;

public class ProblemSolutionReviewA {

    /*
    https://leetcode.com/problems/longest-increasing-subsequence/
    * */

    public static void main(String[] args) {
        var ps = new ProblemSolutionReviewA();
    }

    public int lengthOfLIS(int[] nums) {
        var auxArray = new ArrayList<Integer>();
        auxArray.add(nums[0]);

        for (int i = 0; i < nums.length; i++) {

            var lastAddedPosAuxArray = auxArray.size() - 1;
            if (nums[i] <= auxArray.get(lastAddedPosAuxArray)) {
                replaceIt(nums[i], auxArray);
            } else if (nums[i] > auxArray.get(lastAddedPosAuxArray)) {
                auxArray.add(nums[i]);

            }
        }

        return auxArray.size();

    }

    private void replaceIt(int num, ArrayList<Integer> auxArray) {
        int j = 0;
        // when element <= auxArray.get(j) ---> let's replace auxArray.get(j) by element
        while (num > auxArray.get(j)) {
            j = j + 1;
        }
        // replacing number in position j for 'element'.
        auxArray.set(j, num);
    }
}
