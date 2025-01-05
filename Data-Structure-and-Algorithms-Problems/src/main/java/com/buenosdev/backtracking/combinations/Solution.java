package com.buenosdev.backtracking.combinations;

import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        var nums = new ArrayList<Integer>();
        var resp = new ArrayList<List<Integer>>();
          
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }

        dfs(nums, new ArrayList<Integer>(), 0, k, resp);

        return resp;
        
    }

    private void dfs(List<Integer> nums, List<Integer> pr, int start, int k, List<List<Integer>> res){

        if(pr.size() == k){
            res.add(new ArrayList<>(pr));
            return;
        }


        for(int i = start; i < nums.size(); i++){
            pr.add(nums.get(i));
            dfs(nums, pr, i+1, k, res);
            pr.remove(pr.size() -1);
        }
    }
}


