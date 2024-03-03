package com.buenosdev.hash.twosum;

import java.util.HashMap;

class ProblemSolution {

    // (HashMap) Problem: Two Sum

    /*
    https://leetcode.com/problems/two-sum/description/
     * */

    /*
     * */

    public static void main(String[] args) {
    }

    public int[] twoSum(int[] nums, int target) {
        var hashComplement = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var complement = target - nums[i];

            if (hashComplement.containsKey(complement)) {
                return new int[]{hashComplement.get(complement), i};
            }
            hashComplement.put(nums[i], i);
        }
        return new int[]{};
    }
}
/*
Time Complexity:
 - O(n): The time complexity of this algorithm is O(n), where n is the length of the string. This is because we're
  processing each character in the string exactly once.

Space Complexity:
 - O(n): in the worst-case scenario when all the characters in the string are opening parentheses, so we push each character
  onto the Stack.
*/