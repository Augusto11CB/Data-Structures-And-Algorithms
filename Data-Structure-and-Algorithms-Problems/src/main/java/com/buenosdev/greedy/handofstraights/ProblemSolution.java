package com.buenosdev.greedy.handofstraights;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ProblemSolution {

    // (Greedy Algorithm) Problem I: Hand of Straights

    /*
    https://leetcode.com/problems/hand-of-straights/
     **/

    /*
     * */
    public static void main(String[] args) {

        var problemSolution = new ProblemSolution();

    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        var numberFrequency = new TreeMap<Integer, Integer>();

        for (Integer i : hand) {
            numberFrequency.put(i, numberFrequency.getOrDefault(i, 0) + 1);
        }


        while (!numberFrequency.isEmpty()) {
            var integerIntegerEntry = numberFrequency.firstEntry();
            var key = integerIntegerEntry.getKey();

            for (int i = 0; i < groupSize; i++) {
                if (!numberFrequency.containsKey(key + i)) return false;
                if (numberFrequency.get(key + i) - 1 == 0) numberFrequency.remove(key + i);
                else numberFrequency.put(key + i, numberFrequency.get(key + i) - 1);
            }
        }

        return true;
    }

    public boolean isNStraightHandMinHeap(int[] hand, int groupSize) {

        var numberFrequency = new HashMap<Integer, Integer>();

        for (Integer i : hand) {
            numberFrequency.put(i, numberFrequency.getOrDefault(i, 0) + 1);
        }

        var minHeap = new PriorityQueue<Integer>();

        minHeap.addAll(numberFrequency.keySet());

        while (!minHeap.isEmpty()) {
            var key = minHeap.peek();

            for (int i = 0; i < groupSize; i++) {
                if (!numberFrequency.containsKey(key + i)) return false;
                if (numberFrequency.get(key + i) - 1 == 0) {
                    minHeap.poll();
                    numberFrequency.remove(key + i);
                } else numberFrequency.put(key + i, numberFrequency.get(key + i) - 1);
            }
        }

        return true;
    }
}