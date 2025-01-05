package com.buenosdev.greedy.minmeetingrooms

class ProblemSolutionKt {

    class Interval(var start: Int, var end: Int)

    fun minMeetingRooms(intervals: List<Interval>): Int {
        var max = 0
        var rooms = 0

        val endPeriods = IntArray(intervals.size)
        val startPeriods = IntArray(intervals.size)

        for (i in 0 until intervals.size) {
            startPeriods[i] = intervals[i].start
            endPeriods[i] = intervals[i].end
        }
        endPeriods.sort()
        startPeriods.sort()

        var i = 0
        var j = 0
        while (i < startPeriods.size && j < endPeriods.size) {
            if (startPeriods[i] < endPeriods[j]) {
                rooms++
                i++
            } else {
                rooms--
                j++
            }

            max = Math.max(max, rooms)
        }

        return max
    }
}