package com.buenosdev.greedy.ispossibledivide;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ProblemSolution {

    // (Greedy Algorithm) Problem I: Divide Array in Sets of K Consecutive Numbers

    /*
    https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
     **/

    public static void main(String[] args) {

        var problemSolution = new ProblemSolution();

    }

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        var numOfFreq = new TreeMap<Integer, Integer>();

        for (int i : nums) {
            numOfFreq.put(i, numOfFreq.getOrDefault(i, 0) + 1);
        }

        while (!numOfFreq.isEmpty()) {
            var entrySmallestNum = numOfFreq.firstEntry();
            var entrySmallest = entrySmallestNum.getKey();

            for (int i = 0; i < k; i++) {
                if (!numOfFreq.containsKey(entrySmallest + i)) return false;
                numOfFreq.put(entrySmallest + i, numOfFreq.get(entrySmallest + i) - 1);
                if (numOfFreq.get(entrySmallest + i) == 0) numOfFreq.remove(entrySmallest + i);
            }
        }
        return true;
    }
}