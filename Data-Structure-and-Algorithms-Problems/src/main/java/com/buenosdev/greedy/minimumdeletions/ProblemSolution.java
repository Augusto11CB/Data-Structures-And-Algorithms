package com.buenosdev.greedy.minimumdeletions;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ProblemSolution {

    // (Greedy Algorithm) Problem J: Removing Minimum and Maximum From Array

    /*
    https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/
     **/

    /*
     * */
    public static void main(String[] args) {

        var problemSolution = new ProblemSolution();
        problemSolution.minimumDeletions(new int[]{-14, 61, 29, -18, 59, 13, -67, -16, 55, -57, 7, 74});

    }

    public int minimumDeletions(int[] nums) {

        int min = Integer.MAX_VALUE;
        int minPosition = -1;

        int max = Integer.MIN_VALUE;
        int maxPosition = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxPosition = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minPosition = i;
            }
        }

        var minDistanceToEnd = nums.length - minPosition;
        var maxDistanceToEnd = nums.length - maxPosition;

        // Removing the minimum and maximum elements starting from the same end of the array.
        var departureFromStart = Math.max(maxPosition + 1, minPosition + 1); // Both from start
        var departureFromEnd = Math.max(minDistanceToEnd, maxDistanceToEnd); // Both from end

        // Removing one of them from the start and the other from the end.
        var departureFromEndAndStart = Math.min(minPosition + 1 + maxDistanceToEnd, minDistanceToEnd + maxPosition + 1); // One from each end

        // find the shortest path to remove both elements
        return Math.min(Math.min(departureFromStart, departureFromEnd), departureFromEndAndStart);
    }
}