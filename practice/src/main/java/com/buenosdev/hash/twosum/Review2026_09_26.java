package com.buenosdev.hash.twosum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Review2026_09_26 {

    /*
     * Two Sum
     * https://leetcode.com/problems/two-sum/description/
     *
     * Review date: 2026-09-26
     */
    public int[] twoSum(int[] nums, int target) {
        var result = new int[2];

        // you may not use the same element twice => while (i != j)?

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return result;
    }

    public int[] twoSumV2(int[] nums, int target) {
        // This is the "jump of the cat" that allows us to use the standard two-pointer algorithm.
        // We need to keep track of each number's original index because sorting would otherwise lose it.
        // A HashMap<Integer, Integer> (key = nums[i], value = i) could overwrite the index
        // when duplicate numbers occur, so we use an array of pairs instead:
        // [number, original index].
        var matrixIds = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            matrixIds[i] = new int[]{nums[i], i};
        }

        Arrays.sort(matrixIds, (a, b) -> Integer.compare(a[0], b[0]));

        var i = 0;
        var j = nums.length - 1;

        while (i < j) {
            var result = matrixIds[i][0] + matrixIds[j][0];
            if (result == target) {
                return new int[]{matrixIds[i][1], matrixIds[j][1]};
            }

            if (result > target) j--;
            else i++;
        }

        return new int[2];
    }


    public int[] twoSumV3(int[] nums, int target) {
        var hashMap = new HashMap<Integer, Integer>();

        var result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            var reminder = target - nums[i];
            if (hashMap.containsKey(reminder))
                return new int[]{hashMap.get(reminder), i};
            else
                hashMap.put(nums[i], i);
        }

        return result;
    }
}
