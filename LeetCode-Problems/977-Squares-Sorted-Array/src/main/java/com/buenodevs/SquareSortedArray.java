package com.buenodevs;

public class SquareSortedArray {
    public static void main(String[] args) {
        int[] nums = {-222,3,5,10};
        int[] result = sortedSquares(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int leftPointerIndex = 0;
        int rightPointerIndex = nums.length - 1;
        int index = nums.length - 1;
        while (leftPointerIndex <= rightPointerIndex) {
            if (Math.abs(nums[leftPointerIndex]) >= Math.abs(nums[rightPointerIndex])) {
                result[index] = nums[leftPointerIndex] * nums[leftPointerIndex];
                leftPointerIndex = leftPointerIndex + 1;
            } else {
                result[index] = nums[rightPointerIndex] * nums[rightPointerIndex];
                rightPointerIndex = rightPointerIndex - 1;
            }
            index = index - 1;
        }
        return result;
    }
}
