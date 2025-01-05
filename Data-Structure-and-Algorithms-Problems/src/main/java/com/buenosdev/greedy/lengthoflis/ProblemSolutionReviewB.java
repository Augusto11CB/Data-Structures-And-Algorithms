package com.buenosdev.greedy.lengthoflis;

import java.util.ArrayList;

public class ProblemSolutionReviewB {

    /*
    https://leetcode.com/problems/longest-increasing-subsequence/
    * */

    public static void main(String[] args) {
        var ps = new ProblemSolutionReviewB();
        ps.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    public int lengthOfLIS(int[] nums) {
        var arrayLIS = new ArrayList<Integer>();
        arrayLIS.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= arrayLIS.get(arrayLIS.size() - 1)) {
                replaceIt(nums[i], arrayLIS);
            } else {
                arrayLIS.add(nums[i]);
            }
        }
        return arrayLIS.size();
    }

    private void replaceIt(int num, ArrayList<Integer> auxArray) {

        for (int i = 0; i < auxArray.size(); i++) {
            if (auxArray.get(i) >= num) {
                auxArray.set(i, num);
                break;
            }
        }
    }
}
