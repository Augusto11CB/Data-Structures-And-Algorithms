package com.buenosdev.mergeintervals.merge

import java.util.*

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size < 2)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt { interval: IntArray -> interval[0] })

        val array = mutableListOf<IntArray>()
        var lastSelectedIntervalEnd = Int.MIN_VALUE;


        for (interval in intervals) {
            if (interval[0] > lastSelectedIntervalEnd) {
                lastSelectedIntervalEnd = interval[1]
                array.add(interval)
            } else {
                var lastAddedInterval = array.last()
                lastAddedInterval[1] = Math.max(interval[1], lastAddedInterval[1])
                array[array.size - 1] = lastAddedInterval
                lastSelectedIntervalEnd = lastAddedInterval[1]
            }
        }
        return array.toTypedArray()
    }
}