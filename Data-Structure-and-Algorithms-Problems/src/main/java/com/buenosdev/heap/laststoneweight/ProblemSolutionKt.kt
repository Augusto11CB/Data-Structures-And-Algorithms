package com.buenosdev.heap.laststoneweight

import java.util.*

class ProblemSolutionKt {
    fun lastStoneWeight(stones: IntArray): Int {
        // Use a max heap (priority queue) to always get the two heaviest stones efficiently.
        // The lambda function { a, b -> b - a } is used to sort the heap in descending order.
        val maxHeapHeavy = PriorityQueue<Int> { a: Int, b: Int -> b - a }

        // Add all stone weights to the max heap.
        for (i in stones) {
            maxHeapHeavy.add(i)
        }

        // Continue the process until there is at most one stone left in the heap.
        while (maxHeapHeavy.size > 1) {
            // Extract the two heaviest stones.
            val firstStone = maxHeapHeavy.poll()
            val secondStone = maxHeapHeavy.poll()

            // If the stones are not of the same weight, add the difference back into the heap.
            // If they are the same, both stones are destroyed, so we don't add anything back.
            val resultOfSmashedStones = firstStone - secondStone
            if (resultOfSmashedStones > 0) maxHeapHeavy.add(resultOfSmashedStones)
        }

        // If there are no stones left, return 0. Otherwise, return the weight of the last remaining stone.
        return if (maxHeapHeavy.size == 0) 0 else maxHeapHeavy.poll()
    }
}