package com.buenosdev.backtracking.combinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var res = new ArrayList<List<Integer>>();

        dfs(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> l, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(l));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target) {
                continue;
            }

            // Add the current candidate to the current combination
            l.add(candidates[i]);

            // Recursively call the function with the updated combination and remaining
            // target
            dfs(candidates, target - candidates[i], i, l, result);

            // !!! Backtrack by removing the last added candidate from the combination
            l.remove(l.size() - 1);

        }
    }
}