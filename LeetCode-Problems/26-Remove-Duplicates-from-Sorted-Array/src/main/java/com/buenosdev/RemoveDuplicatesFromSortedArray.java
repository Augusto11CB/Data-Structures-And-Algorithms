package com.buenosdev;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        var numbersInArrayNums = new HashSet<Integer>();
        var availableIndexQueue = new LinkedList<Integer>();
        var startIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (numbersInArrayNums.contains(nums[i])) {
                availableIndexQueue.add(i);
            } else {
                numbersInArrayNums.add(nums[i]);
                if (!availableIndexQueue.isEmpty()) {
                    nums[availableIndexQueue.poll()] = nums[i];
                    availableIndexQueue.add(i);
                }
                startIndex++;
            }
        }
        return startIndex;
    }

    public static int removeDuplicatesV2(int[] nums) {
        var index = 0;

        for (int n : nums) {
            if (index == 0 || n > nums[index - 1]) {
                nums[index++] = n;
            }
        }

        return index;

//        var startIndex = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != nums[startIndex]) {
//                startIndex++;
//                nums[startIndex] = nums[i];
//            }
//        }
//        return startIndex;
    }
}

