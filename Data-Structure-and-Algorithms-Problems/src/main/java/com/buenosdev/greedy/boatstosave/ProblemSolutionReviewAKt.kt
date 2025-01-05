package com.buenosdev.greedy.boatstosave

class ProblemSolutionReviewAKt {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        var i = 0
        var j = people.size - 1
        var result = 0

        people.sort()

        while (i < j) {
            if (people[i] + people[j] <= limit) i++
            j--
            result++
        }

        if (i == j) result++

        return result
    }
}