package com.buenosdev.slidingwindow.minSubArrayLen

/*
* https://leetcode.com/problems/minimum-size-subarray-sum/
*
* */


class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {

        var minLen = Int.MAX_VALUE
        var currentSumWindow = 0
        var windowStart = 0
        for (windowEnd in 0 until nums.size) {
            currentSumWindow = currentSumWindow + nums[windowEnd]

            // shrink the window as small as possible until the 'currentSumWindow' is smaller than 'target'
            while (currentSumWindow >= target) {
                minLen = Math.min(minLen, windowEnd - windowStart + (1))
                currentSumWindow -= nums[windowStart]
                windowStart++
            }
        }

        if(minLen == Int.MAX_VALUE) return 0
        return minLen
    }

    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        val set = HashSet<Int>()
        var max: Long = 0
        var sum: Long = 0
        var windowStart = 0
        for (windowEnd in nums.indices) {
            val currentValue = nums[windowEnd]

            while (set.contains(currentValue) || set.size == k) {
                set.remove(nums[windowStart]) // removendo elemento no começo da 'janela'
                sum -= nums[windowStart].toLong()
                windowStart++
            }

            sum += currentValue.toLong()
            set.add(currentValue)

            if (set.size == k) {
                max = Math.max(max, sum)
            }
        }
        return max
    }


}
