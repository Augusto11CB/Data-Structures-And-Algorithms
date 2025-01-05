package com.buenosdev.backtracking.permutations;

import java.util.*;
class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, 0, result);

        return result;

    }

    private void dfs(int [] nums, int start, List<List<Integer>> resp){
        if(start == nums.length - 1){
            var ar = new ArrayList<Integer>();
            for(int num : nums){
                ar.add(num);
            }
            
            resp.add(ar);
            return;
        }

        for(int i = start; i < nums.length; i++){
            var swap = nums[i];

            nums[i] = nums[start];

            nums[start] = swap;

           dfs(nums, start + 1, resp);

            swap = nums[i];

            nums[i] = nums[start];

            nums[start] = swap;

        }
    }

    public List<List<Integer>> permuteII(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int num : nums) {
            queue.add(num);
        }

        if(queue.size() == 1){
            res.add(new ArrayList<>(queue));
        }

        for (int i = 0; i < nums.length; i++) {
            var n = queue.removeFirst();
            var remainingNums = queue.stream().mapToInt(Integer::intValue).toArray();
            var perms = permute(remainingNums);

            for (List<Integer> perm : perms) {
                perm.add(n);
                res.add(perm);
            }
            
            queue.addLast(n);

        }
        
        return res;
        
    }
}