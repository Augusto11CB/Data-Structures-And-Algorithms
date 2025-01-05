package com.buenosdev.arraymatrix.numidenticalpairs


class ProblemSolution {

    /*
    * https://leetcode.com/problems/number-of-good-pairs/
    * */
    fun numIdenticalPairs(nums: IntArray): Int {

        var result = 0;

        for (j in nums.size - 1 downTo 0) {
            val current = nums[j]

            for (i in j - 1 downTo 0) {
                if (nums[i] == current) result = result + 1
            }
        }

        return result;
    }

    fun numGoodPairs(nums: IntArray): Int {
        var pairCount = 0
        val map: MutableMap<Int, Int> = HashMap()
        for (n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1 // increment the count of 'n' in the map

            // every new occurrence of a number can be paired with every previous occurrence
            // so if a number has already appeared 'p' times, we will have 'p-1' new pairs
            pairCount += map[n]!! - 1
        }
        return pairCount
    }

    fun main() {
        val sol = ProblemSolution()
        val nums1 = intArrayOf(1, 2, 3, 1, 1, 3)
        val result1 = sol.numGoodPairs(nums1)
        println("Result 1: $result1 (Expected: 4)")
        val nums2 = intArrayOf(1, 1, 1, 1)
        val result2 = sol.numGoodPairs(nums2)
        println("Result 2: $result2 (Expected: 6)")
        val nums3 = intArrayOf(1, 2, 3)
        val result3 = sol.numGoodPairs(nums3)
        println("Result 3: $result3 (Expected: 0)")
    }
}