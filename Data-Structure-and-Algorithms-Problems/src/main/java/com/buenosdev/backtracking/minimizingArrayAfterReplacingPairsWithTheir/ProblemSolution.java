package com.buenosdev.backtracking.minimizingArrayAfterReplacingPairsWithTheir;

import java.util.ArrayList;
import java.util.List;

public class ProblemSolution {

/*
    Problem Statement
    You are given an array containing integers nums and an integer value k. You can perform the below operation on the array elements for multiple times:

    Pick two adjacent elements, x and y, from nums and replace them with a single element equal to their product, x*y, but only if x*y is less than or equal to k.
    Return the minimum possible length of nums after performing multiple operations.

            Examples
    Example 1:

    Input: nums = [2, 3, 4, 5], k = 10
    Expected Output: 3
    Justification: We can replace 2 and 3 with their product 6 ([6, 4, 5]). No further operations can be performed since all adjacent products will exceed k. Hence, the minimum length is 3.
    Example 2:

    Input: nums = [1, 2, 2, 3], k = 5
    Expected Output: 2
    Justification: First, replace 2 and 2 with 4 ([1, 4, 3]), then replace 1 and 4 with 4 ([4, 3]). No more operations can be performed, resulting in a minimum length of 2.
    Example 3:

    Input: nums = [10, 5, 2, 3, 4, 2, 20, 1], k = 50
    Expected Output: 3
    Justification: First, replace 10 and 5 with 50 ([50, 2, 3, 4, 2, 20, 1]), then replace 2, 3, 4 and 2 with 48 ([50, 48, 20, 1]), and then replace 20 and 1 with 20 ([50, 48, 20]). No more operations can be performed, resulting in a minimum length of 3.
*/

    public int minArrayLengthOfficialSolution(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(); // Initialize a list to store the minimized array
        for (int num : nums) { // Iterate through the input array
            if (num == 0) { // If the current number is 0, the minimum array length is 1
                return 1;
            }
            if (!res.isEmpty() && res.get(res.size() - 1) * num <= k) { // If the product of last number and current number is less than or equal to k
                res.set(res.size() - 1, res.get(res.size() - 1) * num); // Update the last number in res to the product
            } else {
                res.add(num); // Otherwise, add the current number to res
            }
        }
        return res.size(); // Return the length of the minimized array
    }

    public int minArrayLength(int[] nums, int k) {
        List<Integer> arrayList = new ArrayList<>();
        for (int num : nums) {
            arrayList.add(num);
        }

        return dfs(arrayList, k).size();
    }

    private List<Integer> dfs(List<Integer> nums, int k) {
        if (nums.size() <= 2) {
            // Handle the base case where the size is 2 or less
            if (nums.size() == 2) {
                int product = nums.get(0) * nums.get(1);
                if (product <= k) {
                    List<Integer> merged = new ArrayList<>();
                    merged.add(product);
                    return merged;
                }
            }
            return new ArrayList<>(nums); // Return the original list if it cannot be merged
        }

        List<Integer> result = new ArrayList<>(nums);
        int minLength = nums.size();

        // Iterate through adjacent pairs
        for (int i = 0; i < nums.size() - 1; i++) {
            int product = nums.get(i) * nums.get(i + 1);

            if (product <= k) {
                // Create a new list after merging the current pair
                List<Integer> newList = new ArrayList<>();
                newList.addAll(nums.subList(0, i)); // Add elements before the pair
                newList.add(product); // Add the merged product
                newList.addAll(nums.subList(i + 2, nums.size())); // Add elements after the pair

                // Recursively find the minimum length for this new list
                List<Integer> candidate = dfs(newList, k);
                if (candidate.size() < minLength) {
                    result = candidate;
                    minLength = candidate.size();
                }
            }
        }

        return result;
    }

    private List<Integer> dfsFAILED(List<Integer> nums, int k) {
        // Errei aqui, precisava ser menor ou igual a dois
        if (nums.size() == 2) { // !!!

            var product = nums.get(0) * nums.get(1);
            var newList = new ArrayList<Integer>();
            if (product <= k) {
                newList.add(product);

            } else {
                newList.add(nums.get(0));
                newList.add(nums.get(1));
            }

            return newList;
        }


        List<Integer> list = new ArrayList<>(nums);
        var minLen = nums.size();

        for (int i = 0; i + 1 < nums.size(); i++) { // !!!
            var product = nums.get(i) * nums.get(i + 1);

            if (product <= k) {
                var subList = new ArrayList<Integer>();
                // Errei aqui, precisava adicionar os elementos antes e depois do par
                subList.add(product);
                subList.addAll(nums.subList(i + 2, nums.size()));
                var resp = dfs(subList, k);
                if (resp.size() < minLen) {
                    list = resp;
                    minLen = resp.size();
                }
            }
        }

        return list;
    }


    public static void main(String[] args) {
        var solution = new ProblemSolution();

        // Example 1
        int[] nums1 = {2, 3, 4, 5};
        int k1 = 10;
        System.out.println(solution.minArrayLength(nums1, k1));
        System.out.println("Official Solution: " + solution.minArrayLengthOfficialSolution(nums1, k1));

        // Example 2
        int[] nums2 = {1, 2, 2, 3};
        int k2 = 5;
        System.out.println(solution.minArrayLength(nums2, k2));
        System.out.println("Official Solution: " + solution.minArrayLengthOfficialSolution(nums2, k2));

        // Example 3
        int[] nums3 = {10, 5, 2, 3, 4, 2, 20, 1};
        int k3 = 50;
        System.out.println(solution.minArrayLength(nums3, k3));
        System.out.println("Official Solution: " + solution.minArrayLengthOfficialSolution(nums3, k3));
    }
}
