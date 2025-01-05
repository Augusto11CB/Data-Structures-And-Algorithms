package com.buenosdev.ciclycsort.findDisappearedNumbers

class Solution {

    /*
    * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    * */

    fun findDisappearedNumbers(nums: IntArray): List<Int> {

        var i = 1

        while (i < nums.size) {
            val j = nums[i] - 1 // Calculate the index where the current element should be placed.
            if (nums[i] != nums[j]) // Check if the current element is not in its correct position.
                swap(nums, i, j) // Swap the current element with the one at its correct position.
            else i++ // If the current element is already in its correct position, move to the next element.
        }

        val resultArray = mutableListOf<Int>()

        for (i in 1 until nums.size) {
            if (nums[i] != i) resultArray.add(i)
        }

        return resultArray
    }


    fun findDisappearedNumbersFAILED(nums: IntArray): List<Int> {
        var i = 1

        while (i < nums.size) {
            var index = nums[i - 1]
            if (nums[i - 1] < nums.size && nums[i - 1] != nums[index]) {
                swap(nums, i - 1, index)
            } else {
                i++
            }
        }

        val resultArray = mutableListOf<Int>()

        for (i in 0 until nums.size) {
            if (nums[i] != i + 1) resultArray.add(i)
        }

        return resultArray
    }

    private fun swap(nums: IntArray, i: Int, index: Int) {

        val temp = nums[i]
        nums[i] = nums[index]
        nums[index] = temp
    }
}