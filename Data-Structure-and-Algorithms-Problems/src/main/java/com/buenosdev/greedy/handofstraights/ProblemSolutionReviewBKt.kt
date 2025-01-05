package com.buenosdev.greedy.handofstraights

import java.util.*

class ProblemSolutionReviewBKt {

    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        // If the size of the hand is not a multiple of the group size, return false
        if (hand.size % groupSize != 0) return false

        // Create a HashMap to store the frequency of each number in the hand
        val numberFrequency = HashMap<Int, Int>()

        // Iterate over the hand and update the frequency of each number in the HashMap
        for (i in hand) {
            numberFrequency[i] = numberFrequency.getOrDefault(i, 0) + 1
        }

        // Create a PriorityQueue (minHeap) and add all the keys from the HashMap to it
        val minHeap = PriorityQueue<Int>()
        minHeap.addAll(numberFrequency.keys)

        // While the HashMap is not empty
        while (numberFrequency.isNotEmpty()) {
            // Peek the smallest key from the minHeap
            val key = minHeap.peek()
            // Iterate from 0 to groupSize
            for (i in 0 until groupSize) {
                // Calculate the new key by adding the current iteration number to the key
                val newKey = key + i
                // If the new key is not in the HashMap, return false
                if (newKey !in numberFrequency) return false
                // Decrease the value of the new key in the HashMap by 1
                val newValueForNewKey = numberFrequency[newKey]!!.minus(1)

                // If the new value for the new key is 0
                if (newValueForNewKey == 0) {
                    // Remove the new key from the HashMap
                    numberFrequency.remove(newKey)

                    // If the new key is not equal to the smallest key in the minHeap, return false
                    // This is because we are popping a value from the heap that is not equal to the value that reached frequency equals zero in the hashmap
                    // This means that we have to return false because the sequence of numbers in the hand cannot be divided into groups of consecutive numbers
                    if (newKey != minHeap.peek()) return false
                    else minHeap.poll()
                } else
                // If the new value for the new key is not 0, update the value of the new key in the HashMap
                    numberFrequency[newKey] = newValueForNewKey
            }
        }
        // If the HashMap is empty, return true
        return true
    }


    fun isNStraightHandFAILED(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false

        val mapOfFrequency = HashMap<Int, Int>()
        for (num in hand) {
            mapOfFrequency.put(num, mapOfFrequency.getOrDefault(num, 1))
        }


        var priority = PriorityQueue<Int>()
        priority.addAll(mapOfFrequency.keys)

        while (mapOfFrequency.isNotEmpty()) {
            val num = priority.peek()
            var auxGSize = 0

            while (auxGSize < groupSize) {
                val newNum = num + auxGSize
                if (!mapOfFrequency.contains(newNum)) return false
                if (mapOfFrequency[newNum]!! - 1 == 0) {
                    priority.poll()
                    mapOfFrequency.remove(newNum)
                } else mapOfFrequency.put(newNum, mapOfFrequency[newNum]!! - 1)
                auxGSize++;
            }
        }

        return true
    }
}