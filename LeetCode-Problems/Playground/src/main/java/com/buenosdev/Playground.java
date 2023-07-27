package com.buenosdev;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Playground {

    public static void main(String[] args) {
        var input = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicatesV2(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    // 27. Remove Element
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

    // 26. Remove Duplicates from Sorted Array
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

    // 26. Remove Duplicates from Sorted Array
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

    // 1346. Check If N and Its Double Exist - TODO
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> setOfNumbersInArr = new HashSet<>();
        for (int i : arr) {

            if (setOfNumbersInArr.contains(i * 2) || (i % 2 == 0 && setOfNumbersInArr.contains(i / 2))) {
                return true;
            }
            setOfNumbersInArr.add(i);
        }
        return false;
    }
}

