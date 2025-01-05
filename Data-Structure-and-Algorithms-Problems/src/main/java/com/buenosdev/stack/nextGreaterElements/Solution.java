package com.buenosdev.stack.nextGreaterElements;

import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) stack.add(nums[i]);

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.empty() ? -1 : stack.peek();
            stack.add(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        int[] result = solution.nextGreaterElements(nums);

        // Print the result
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
