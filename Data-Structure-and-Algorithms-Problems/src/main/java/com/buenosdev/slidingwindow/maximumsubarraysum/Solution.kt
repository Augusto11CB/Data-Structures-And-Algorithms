package com.buenosdev.slidingwindow.maximumsubarraysum


class Solution {

    /*
    * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
    * */

    //    Example 1:
//
//    Input: nums = [1,5,4,2,9,9,9], k = 3
//    Output: 15
//    Explanation: The subarrays of nums with length 3 are:
//    - [1,5,4] which meets the requirements and has a sum of 10.
//    - [5,4,2] which meets the requirements and has a sum of 11.
//    - [4,2,9] which meets the requirements and has a sum of 15.
//    - [2,9,9] which does not meet the requirements because the element 9 is repeated.
//    - [9,9,9] which does not meet the requirements because the element 9 is repeated.
//    We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
    fun maximumSubarraySumFAILED(nums: IntArray, k: Int): Long {
        var result = Long.MAX_VALUE
        var windowSum = 0L
        var windowStart = 0
        val windonHashSet = HashSet<Int>()
        for (windowEnd in nums.indices) {
            windowSum = (windowSum + nums[windowEnd]).toLong()
            // slide the window, we don't need to slide if we've not hit the required
            // window size of 'k'
            if (windowEnd >= k - 1) {
                if (!windonHashSet.contains(nums[windowEnd])) {
                    if (windowSum >= result) result = windowSum
                    windowStart++ // slide the window ahead
                } else if (nums[windowEnd - k] != nums[windowEnd]) {
                    windonHashSet.clear()
                    windonHashSet.add(nums[windowEnd])
                    windowSum = (nums[windowEnd]).toLong()
                    windowStart = windowEnd
                }
            }
        }
        return result
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