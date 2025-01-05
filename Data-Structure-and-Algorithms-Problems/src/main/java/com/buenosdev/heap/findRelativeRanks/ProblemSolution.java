package com.buenosdev.heap.findRelativeRanks;

import java.util.HashMap;
import java.util.PriorityQueue;

class ProblemSolution {
    public String[] findRelativeRanks(int[] score) {

        var hash = new HashMap<Integer, Integer>();
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int i = 0; i < score.length; i++) {
            hash.put(score[i], i);
            pq.add(score[i]);
        }

        var result = new String[score.length];
        int i = 1;
        while (!pq.isEmpty()) {
            var scoreFromHeap = pq.poll();
            var originalSlot = hash.get(scoreFromHeap);
            result[originalSlot] = getPrize(i);
            i += 1;
        }

        return result;

    }

    private String getPrize(int i) {
        if (i == 1) return "Gold Medal";
        else if (i == 2) return "Silver Medal";
        else if (i == 3) return "Bronze Medal";
        else return String.valueOf(i);
    }


    /*
    *
    * Time complexity: O(nlogn)
      We traverse the score array once and populate the heap with each score. Adding an element to the heap takes logn time, resulting in a time complexity of O(nlogn) for this step.

      When assigning ranks to athletes, we pop each pair from the heap. Removing an element from the heap also takes logn time, so removing nnn elements will take O(nlogn) time.

      The overall time complexity is O(2nlogn), which we can simplify to O(nlogn).
    * */
}