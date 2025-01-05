package com.buenosdev.hash.majorityelement;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class ProblemSolutionReviewA {

    /*
     * https://leetcode.com/problems/majority-element/
     * */

    public static void main(String[] args) {
        var ps = new ProblemSolutionReviewA();
        ps.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    public int majorityElement(int[] nums) {
        return findMajorityElement(nums, 0, nums.length - 1);

    }

    private int findMajorityElement(int[] nums, int i, int j) {
        if (j == i) return nums[i];

        int middleIndex = i + (j - i) / 2;
        // int middleIndexT = (i + j) / 2;

        var leftResult = findMajorityElement(nums, i, middleIndex);
        var rightResult = findMajorityElement(nums, middleIndex + 1, j);

        if (leftResult == rightResult)
            return leftResult;

        var countLeft = 0;
        var countRight = 0;

        for (int auxI = i; auxI <= j; auxI++) {
            if (nums[auxI] == leftResult)
                countLeft = 1 + countLeft;
            if (nums[auxI] == rightResult)
                countRight = 1 + countRight;
        }

        return countLeft > countRight ? leftResult : rightResult;
    }
}
