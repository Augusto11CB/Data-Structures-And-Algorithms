package com.buenosdev.hash.majorityelement

class ProblemSolutionKt {

    fun majorityElement(nums: IntArray): Int {
        return findElement(nums, 0, nums.size - 1)
    }

    private fun findElement(nums: IntArray, i: Int, j: Int): Int {
        if (i == j) return nums[j]

        var middleElement = i + (j - i) / 2

        var left = findElement(nums, i, middleElement)
        var right = findElement(nums, middleElement + 1, j)
        if (left == right) return left

        var countL = 0
        var countR = 0
        for (aux in i..j) {
            if (nums[aux] == left) {
                countL += 1
            } else if (nums[aux] == right) {
                countR += 1
            }
        }

        return if (countL > countR) return left else right
    }

}