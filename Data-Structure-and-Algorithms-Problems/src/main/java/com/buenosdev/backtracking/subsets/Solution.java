package com.buenosdev.backtracking.subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Deque<Integer> deq = new ArrayDeque<>();

        dfs(nums, 0, deq, result);

        return result;

    }

    public void dfs(int[] nums, int start, Deque<Integer> deq, List<List<Integer>> resp) {
        if (start == nums.length) {
            resp.add(deq.stream().toList());
            return;
        }

        deq.add(nums[start]);
        dfs(nums, start + 1, deq, resp);

        deq.removeLast();
        dfs(nums, start + 1, deq, resp);

    }
}