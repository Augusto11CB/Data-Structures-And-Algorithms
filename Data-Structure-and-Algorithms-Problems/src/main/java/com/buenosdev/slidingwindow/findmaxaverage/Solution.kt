package com.buenosdev.slidingwindow.findmaxaverage

class Solution {

    /*
    * https://leetcode.com/problems/maximum-average-subarray-i/description/
    * */

    /*
    *
    * Input: nums = [1,12,-5,-6,50,3], k = 4
    * Output: 12.75000
    * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    * */
    fun findMaxAverageFAILED(nums: IntArray, k: Int): Double {

        var maxAverage = Double.MIN_VALUE

        var sum = 0
        var groupCount = 0

        for (i in 0 until nums.size - 4) {

            if (groupCount < k) {
                sum = sum + nums[i]
                groupCount = 1 + groupCount
            }

            if (groupCount == k) {
                var averageLocal: Double = (sum / k).toDouble()
                if (maxAverage < averageLocal) maxAverage = averageLocal
                sum = sum - nums[i - k]
                groupCount = groupCount - 1
            }
        }

        return maxAverage
    }

    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var result = Double.NEGATIVE_INFINITY
        var windowSum = 0.0
        var windowStart = 0
        for (windowEnd in nums.indices) {
            windowSum = windowSum + nums[windowEnd].toDouble() // add the next element
            // slide the window, we don't need to slide if we've not hit the required
            // window size of 'k'
            if (windowEnd >= k - 1) {
                var aux = (windowSum / k).toDouble() // calculate the average
                if (aux >= result) result = aux
                windowSum = windowSum - nums[windowStart].toDouble() // subtract the element going out
                windowStart++ // slide the window ahead
            }
        }
        return result
    }

    fun findMaxAverageTwo(nums: IntArray, k: Int): Double {
        var sum: Long = 0
        for (i in 0 until k) sum += nums[i].toLong()
        var max = sum
        for (i in k until nums.size) {
            sum += (nums[i] - nums[i - k]).toLong()
            max = Math.max(max, sum)
        }
        return max / 1.0 / k
    }

}