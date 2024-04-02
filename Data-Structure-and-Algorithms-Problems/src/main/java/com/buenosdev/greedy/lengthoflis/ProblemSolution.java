package com.buenosdev.greedy.lengthoflis;

import java.util.ArrayList;
import java.util.Arrays;

public class ProblemSolution {
    /*
    https://leetcode.com/problems/longest-increasing-subsequence/
    * */

    public static void main(String[] args) {
        var psA = new ProblemSolution();
    }

    public int lengthOfLIS(int[] nums) {
        // ArrayList to store potential candidates for the longest increasing subsequence.
        var auxArray = new ArrayList<Integer>();
        auxArray.add(nums[0]);

        for (int element : nums) {

            var lastElementAddedSlot = auxArray.size() - 1;

            // check if it is greater than the last number in the helper array
            if (element > auxArray.get(lastElementAddedSlot)) {
                // append it to the end of the helper array
                auxArray.add(element);
            } else {
                // replace the smallest number in the helper array that is greater than or equal to the current number
                int j = 0;
                // when element <= auxArray.get(j) ---> let's replace auxArray.get(j) by element
                while (element > auxArray.get(j)) {
                    j = j + 1;
                }
                // replacing number in position j for 'element'.
                auxArray.set(j, element);
            }
        }

        return auxArray.size();
    }
}

// eraseoverlapintervals