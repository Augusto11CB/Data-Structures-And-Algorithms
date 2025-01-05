package com.buenosdev.backtracking.permutationII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.*;

class Solution {

    public List<List<Integer>> permuteUniqueV2(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> permut = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        Deque<Integer> a = new ArrayDeque<>();


        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        dfsV2(nums, count, permut, res);

        return res;
    }

    private void dfsV2(int[] nums, Map<Integer, Integer> count, List<Integer> permut, List<List<Integer>> res) {
        if (permut.size() == nums.length) {
            res.add(new LinkedList<>(permut));
            return;
        }

        for (int n : count.keySet()) {
            if (count.get(n) > 0) {
                permut.add(n);
                count.put(n, count.get(n) - 1);

                dfsV2(nums, count, permut, res);

                count.put(n, count.get(n) + 1);
                permut.remove(permut.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> permut = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        // Count occurrences of each number in the input array
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        dfs(nums, result, permut, map);

        return result;

    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> permutation, Map<Integer, Integer> count) {

        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        // Explore each unique number in the map
        // The reason for iterating over the map (count) instead of directly iterating over nums is to ensure that each number is used uniquely and that duplicates are managed correctly during the permutation generation process.
        for (int num : count.keySet()) {
            // If there are remaining occurrences of this number to use in the permutation
            if (count.get(num) > 0) {
                permutation.add(num);
                count.put(num, count.get(num) - 1);


                dfs(nums, res, permutation, count);

                // // Backtrack: restore the count and remove the last added number from permutation
                count.put(num, count.get(num) + 1);
                permutation.remove(permutation.size() - 1);
            }
        }

    }

    // not optimized solution
    private void backtrack(int[] nums, int start, List<List<Integer>> res, Set<String> set) {
        if (start == nums.length - 1) {
            var ar = new ArrayList<Integer>();
            var sb = new StringBuilder();
            for (int num : nums) {
                sb.append(num);
                ar.add(num);
            }

            var str = sb.toString();
            if (!set.contains(str)) {
                set.add(str);
                res.add(ar);
            }

        }

        for (int i = start; i < nums.length; i++) {
            var swap = nums[i];

            nums[i] = nums[start];

            nums[start] = swap;

            backtrack(nums, start + 1, res, set);

            swap = nums[i];

            nums[i] = nums[start];

            nums[start] = swap;

        }
    }
}