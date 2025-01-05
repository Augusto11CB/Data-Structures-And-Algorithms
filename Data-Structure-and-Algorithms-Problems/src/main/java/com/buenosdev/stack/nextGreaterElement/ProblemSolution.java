package com.buenosdev.stack.nextGreaterElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ProblemSolution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        int[] result = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            hash.put(nums2[i], stack.empty() ? -1 : stack.peek());

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = hash.get(nums1[i]) != null ? hash.get(nums1[i]) : -1;
        }

        return result;

        // All integers in nums1 and nums2 are unique.
        // Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
    }

    public int[] nextGreaterElementTwo(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack=new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums2){
            while(!stack.isEmpty() && num > stack.peek())
                map.put(stack.pop(), num);
            stack.push(num);
        }

        int i=0;
        for(int num : nums1)
            result[i++] = map.getOrDefault(num, -1);
        return result;
    }

    public static void main(String[] args) {
        ProblemSolution problemSolution = new ProblemSolution();
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] result = problemSolution.nextGreaterElement(nums1, nums2);

        // Print the result
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
