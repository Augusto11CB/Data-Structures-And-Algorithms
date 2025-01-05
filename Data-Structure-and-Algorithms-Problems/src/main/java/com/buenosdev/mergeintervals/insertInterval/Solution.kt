package com.buenosdev.mergeintervals.insertInterval

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.size < 1) return arrayOf(newInterval)

        var newArray = ArrayList<IntArray>()

        var i = 0

        // skip (and add to output) all intervals that come before the 'newInterval'
        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            newArray.add(intervals[i])
            i++
        }

        // merge all intervals that overlap with 'newInterval'
        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++
        }

        newArray.add(newInterval)

        // add all the remaining intervals to the output
        while (i < intervals.size) {
            newArray.add(intervals[i])
            i++
        }

        return newArray.toTypedArray()
    }

}