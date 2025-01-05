package com.buenosdev.a.specialArrayWithXElementsGreaterThanOrEqualX;

import java.util.Arrays;

class ProblemSolution {

    // the minimum possible value for x is 1. This is because if x equals 0, the array nums must be empty, but the constraints guarantee that nums has at least 1 element.
    public int specialArrayIII(int[] nums) {

        var numsLen = nums.length;

        Arrays.sort(nums);
        var result = -1;
        for (int i = 1; i <= numsLen; i++) {
            var curLen = 0;
            Integer lastJValue = null;

            for (int j = 0; j < numsLen; j++) {
                lastJValue = nums[j];
                if (nums[j] < i || curLen > i) {
                    continue;
                } else {
                    curLen = curLen + 1;
                }

            }

            if (curLen == i && lastJValue >= i) result = i;

        }
        return result;
    }

    public int specialArrayII(int[] nums) {
        var result = -1;
        var numsLen = nums.length;

        Arrays.sort(nums);

        for (int i = 1; i < numsLen; i++) {
            var index = binarySearch(nums, i);
            if (numsLen - index == i) {
                return i;
            }
        }

        return result;
    }

    public int binarySearch(int[] nums, int val) {
        var start = 0;
        var end = nums.length - 1;

        var idx = nums.length;

        while (start <= end) {
            var mid = (start + end) / 2;
            if (nums[mid] > val) {
                end = mid;
                idx = mid - 1;
            } else {
                start = mid;
            }
        }

        return idx;
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        var count = new int[nums.length + 1];

        for (int num : nums) {
            var index = Math.min(num, nums.length);
            count[index] = count[index] + 1;
        }

        var totalR = 0;
        for (int i = nums.length; i >= 0; i--) {
            totalR += count[i];
            if (totalR == i)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        var ps = new ProblemSolution();
//        System.out.println(ps.specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(ps.specialArray(new int[]{3, 5}));
    }
}