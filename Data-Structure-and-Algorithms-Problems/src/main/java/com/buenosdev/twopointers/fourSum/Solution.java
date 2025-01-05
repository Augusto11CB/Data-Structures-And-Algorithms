package com.buenosdev.twopointers.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        kSum(nums, 4, 0, target, new ArrayList<>(), res);

        return res;
    }

    private void kSum(int[] nums, int k, int start, long target, List<Integer> temp, List<List<Integer>> resp) {
        if (k != 2) {
            for (int i = start; i <= nums.length - k; i++) {
                // we’re iterating through the array to select elements for our solution, we don’t pick the same number multiple times at the same level of recursion
                // would return [[2, 2, 2, 2], [2, 2, 2, 2], [2, 2, 2, 2]] instead of [[2, 2, 2, 2]]
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                temp.add(nums[i]);
                kSum(nums, k - 1, i + 1, target - nums[i], temp, resp);
                temp.remove(temp.size() - 1);
            }
            return;
        }

        int l = start;
        int r = nums.length - 1;

        while (l < r) {
            long sum = nums[l] + nums[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                var current = new ArrayList<>(temp);
                current.add(nums[l]);
                current.add(nums[r]);
                resp.add(current);


                // ################################
                l++;
                r--;
                // If the pointers left or right move over elements that are the same as the previous ones, the algorithm would produce the same quadruplet multiple times.
                // would return [[-2, -1, 1, 2], [-2, -1, 1, 2], [-1, -1, 1, 1]]
                // instead of [[-2, -1, 1, 2], [-1, -1, 1, 1]]

                while (l < r && nums[l] == nums[l - 1]) l++;
                while (l < r && nums[r] == nums[r + 1]) r--;
            }
        }
    }

    public static void main(String[] args) {
        var obj = new Solution();
        int[] test1 = {-2, -1, -1, 1, 1, 2, 2};
        List<List<Integer>> result1 = obj.fourSum(test1, 0);
        System.out.println("Test 1 Result: " + result1); // Expected: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        int[] test2 = {2,2,2,2,2};
        List<List<Integer>> result2 = obj.fourSum(test2, 8);
        System.out.println("Test 2 Result: " + result2); // Expected: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }
}