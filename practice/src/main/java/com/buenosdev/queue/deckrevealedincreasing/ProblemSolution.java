package com.buenosdev.queue.deckrevealedincreasing;

import java.util.*;

public class ProblemSolution {

    /*
     * https://leetcode.com/problems/reveal-cards-in-increasing-order/
     * */

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        var queueOfIndexes = new LinkedList<Integer>();

        for (int i = 0; i < deck.length; i++) {
            queueOfIndexes.add(i); // Initialize queue with indices 0, 1, 2, ..., n-1
        }

        var resultArray = new int[deck.length];

        for (int card : deck) {
            var rightIndexToInsertCard = queueOfIndexes.poll();  // Get the next available index
            resultArray[rightIndexToInsertCard] = card;  // Place the card in the result array
            if (!queueOfIndexes.isEmpty()) {
                queueOfIndexes.add(queueOfIndexes.poll()); // Move the used index to the end of deque
            }
        }

        return resultArray;
    }
}
