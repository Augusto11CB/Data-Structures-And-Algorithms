package com.buenosdev.general.dominantIndex

class ProblemSolutionKt {

    /*
    * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
    * */

    fun dominantIndex(nums: IntArray): Int {
        var largestNum = Int.MIN_VALUE
        var secondLargestNum = Int.MIN_VALUE
        var intex = -1

        for (i in 0 until nums.size) {
            if (nums[i] > largestNum) {
                secondLargestNum = largestNum
                largestNum = nums[i]
                intex = i
            } else if (nums[i] > secondLargestNum) {
                secondLargestNum = nums[i]
            }
        }
        return if (secondLargestNum * 2 > largestNum) -1 else intex
    }
}