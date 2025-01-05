package com.buenosdev.twopointers.findMaxK

class ProbleSolutionKt {

    /*
    * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/
    * */

    fun findMaxK(nums: IntArray): Int {
        nums.sort()

        var right = nums.size - 1
        var left = 0

        var maxK = Int.MIN_VALUE

        while (left < right) {
            if (nums[left] + nums[right] == 0) {
                return nums[right]
            } else if (Math.abs(nums[left]) > nums[right]) {
                left = left + 1
            } else {
                right = right - 1
            }
        }

        return -1
    }
}