package com.buenosdev.ciclycsort.findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

public class ProblemSolutionSecondAttempt {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 1;

        while (i < nums.length) {
            int j = nums[i] - 1; // Calculate the index where the current element should be placed.
            if (nums[i] != nums[j]) { // Check if the current element is not in its correct position.
                // Swap the current element with the one at its correct position.
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++; // If the current element is already in its correct position, move to the next element.
            }
        }

        List<Integer> resultArray = new ArrayList<>();

        for (i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) resultArray.add(i + 1);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        var sol = new ProblemSolutionSecondAttempt();
        List<Integer> missing = sol.findDisappearedNumbers(
                new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println("Missing numbers: " + missing);

        missing = sol.findDisappearedNumbers(new int[]{2, 4, 1, 2});
        System.out.println("Missing numbers: " + missing);

        missing = sol.findDisappearedNumbers(new int[]{2, 3, 2, 1});
        System.out.println("Missing numbers: " + missing);
    }

}
