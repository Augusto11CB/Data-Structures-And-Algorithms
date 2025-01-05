package com.buenosdev.ciclycsort.missingNumber

class Solution {
    /*
    * https://leetcode.com/problems/missing-number/description/
    * */

    fun missingNumber(nums: IntArray): Int {
        val auxArray = IntArray(nums.size + 1)

        for (num in nums) {
            auxArray[num] = num
        }

        var result = 0

        for (i in 0 until auxArray.size) {
            val nextValue = auxArray[i] + 1
            if (nextValue < auxArray.size && auxArray[nextValue] != nextValue) result = nextValue
        }

        return result
    }

    fun findMissingNumber(nums: IntArray): Int {
        var i = 0

        while (i < nums.size) {
            var index = nums[i]
            if (nums[i] < nums.size && nums[i] != nums[index]) {
                swap(nums, i, index)
            } else {
                i++
            }
        }

        // find the first number missing from its index, that will be our required number
        i = 0
        while (i < nums.size) {
            if (nums[i] != i) return i
            i++
        }
        return nums.size
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}