package com.buenosdev.a.subarraySumEqualsK;

import java.util.HashMap;

class ProblemSolution {

    public int subarraySum(int[] nums, int k) {
        var mapOfPrefixSum = new HashMap<Integer, Integer>();
        mapOfPrefixSum.put(0, 1);

        int res = 0;
        int curSum = 0;
        for (int i : nums) {
            curSum += i;
            var diff = curSum - k;

            // This diff represents a hypothetical cumulative sum that, if it exists in the prefix sums map,
            // indicates there is a subarray that sums to k between the previous occurrence of this diff and the current position.
            res += mapOfPrefixSum.getOrDefault(diff, 0);
            mapOfPrefixSum.put(curSum, mapOfPrefixSum.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        var mapOfPrefixSum = new HashMap<Integer, Integer>();
        mapOfPrefixSum.put(0, 1);

        int res = 0;
        int curSum = 0;
        for (int i : nums) {
            curSum += i;
            var diff = curSum % k;

            // This diff represents a hypothetical cumulative sum that, if it exists in the prefix sums map,
            // indicates there is a subarray that sums to k between the previous occurrence of this diff and the current position.
            res += mapOfPrefixSum.getOrDefault(diff, 0);
            if (res > 0) return true;
            mapOfPrefixSum.put(curSum, mapOfPrefixSum.getOrDefault(curSum, 0) + 1);
        }
        return false;
    }

    public int subarraySumII(int[] nums, int k) {
        var prefix = createPrefixSumArray(nums);
        var result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (getSubArraySum(prefix, i, j) == k) result += 1;
            }
        }
        return result;
    }

    private static int[] createPrefixSumArray(int[] arr) {
        var prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }

        return prefix;
    }

    private static int getSubArraySum(int[] nums, int l, int r) {
        if (l == 0) return nums[r];
        else return nums[r] - nums[l - 1];
    }

    public static void main(String[] args) {
        var ps = new ProblemSolution();
        ps.subarraySum(new int[]{1, 2, 3}, 3);
    }
}