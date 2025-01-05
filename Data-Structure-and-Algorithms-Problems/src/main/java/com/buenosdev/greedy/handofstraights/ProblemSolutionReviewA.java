package com.buenosdev.greedy.handofstraights;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ProblemSolutionReviewA {

    // (Greedy Algorithm) Problem I: Hand of Straights

    /*
    https://leetcode.com/problems/hand-of-straights/
     **/

    /*
     * */
    public static void main(String[] args) {

        var problemSolution = new ProblemSolutionReviewA();

    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length < groupSize) return false;

        var mapOfNumOcurrences = new HashMap<Integer, Integer>();

        for (int i : hand) mapOfNumOcurrences.put(i, mapOfNumOcurrences.getOrDefault(i, 0) + 1);

        var priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.addAll(mapOfNumOcurrences.keySet());


        while (!priorityQueue.isEmpty()) {
            var elem = priorityQueue.peek();


            // MUST BE CONSECUTIVE CARDS
            for (int i = 1; i < groupSize; i++) {
                if (!mapOfNumOcurrences.containsKey(elem + i)) return false;


                if (priorityQueue.isEmpty() || priorityQueue.peek() != elem + i) return false;
                priorityQueue.poll();
            }

        }
        return true;
    }
}