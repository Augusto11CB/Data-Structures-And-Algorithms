package com.buenosdev.slidingwindow.findMaxConsecutiveOnes

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxLen = Int.MIN_VALUE
        var maxLenAux = 0
        var windowStart = 0

        for (windowEnd in 0 until nums.size) {
            if (nums[windowEnd] == 0) {
                windowStart = windowEnd + 1
                maxLen = Math.max(maxLen, maxLenAux)
                maxLenAux = 0
            } else {
                maxLenAux += 1
                maxLen = Math.max(maxLen, maxLenAux)
            }
        }
        return maxLen
    }

    fun findMaxConsecutiveOnesT(nums: IntArray): Int {
        var windowStart = 0
        var windowEnd = 0
        var max = Int.MIN_VALUE
        windowEnd = 0
        while (windowEnd < nums.size) {
            if (nums[windowEnd] == 0) {
                max = Math.max(max, windowEnd - windowStart)
                windowStart = windowEnd + 1
            }
            windowEnd++
        }
        max = Math.max(max, windowEnd - windowStart)
        return max
    }
}