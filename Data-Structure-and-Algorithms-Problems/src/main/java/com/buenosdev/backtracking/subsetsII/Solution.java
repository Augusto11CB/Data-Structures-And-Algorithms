package com.buenosdev.backtracking.subsetsII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {

    // Main function to generate subsets with duplicates handled
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Initialize the result list to store all subsets
        List<List<Integer>> result = new ArrayList<>();

        // Initialize a deque (double-ended queue) for current subset
        Deque<Integer> deq = new ArrayDeque<>();

        // Sort the input array to handle duplicates easily
        // The core idea to avoid duplicates in the subsets is to sort the array nums. Sorting brings identical elements next to each other, making it easier to avoid duplicates when constructing the subsets.
        // We are going to use order to skip the duplicate elements.
        // This way we garantee that we are not working with duplicates.
        Arrays.sort(nums);

        // Start depth-first search (DFS) from index 0
        dfs(nums, 0, deq, result);

        // Return the generated subsets
        return result;
    }

    // DFS function to recursively generate subsets
    public void dfs(int[] nums, int start, Deque<Integer> deq, List<List<Integer>> resp) {

        // Base case: when we have processed all elements in nums
        if (start == nums.length) {
            // Convert deque to a list and add it to the result list
            var l = deq.stream().toList();
            resp.add(l);
            return;
        }

        // Include the current element nums[start] in the current subset
        deq.add(nums[start]);
        // Recursively call dfs to generate subsets including nums[start]
        dfs(nums, start + 1, deq, resp);

        // Exclude the current element nums[start] and backtrack
        deq.removeLast();

        // Skip duplicates: if the next element is the same as nums[start], skip it
        while (start + 1 < nums.length && nums[start] == nums[start + 1])
            start++;

        // Recursively call dfs to generate subsets excluding duplicates
        dfs(nums, start + 1, deq, resp);

    }
}
