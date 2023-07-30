package com.buenosdev;

public class RemoveElementArray {

    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            if (nums[startIndex] == val) {
                nums[startIndex] = nums[endIndex];
                endIndex--;
            } else {
                startIndex++;
            }
        }
        return startIndex;
    }
}

